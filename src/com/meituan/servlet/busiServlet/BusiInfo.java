package com.meituan.servlet.busiServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.meituan.domain.Busi;
import com.meituan.service.busiService.BusiInfoService;
import com.meituan.utils.FileUploadAppProperties;
import com.meituan.utils.FileUtils;

public class BusiInfo extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final String FILE_PATH = "D:\\xMeituan\\WebContent\\resources\\BusiPic";
	private static final String TEMP_DIR = "d:\\tempDirectory";
	private int busiId;
	private BusiInfoService busiInfoService = new BusiInfoService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String methodName = request.getParameter("method");
		System.out.println("busiInfo:doPost:methodName"+methodName);
		try
		{
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	protected void getBusi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		busiId = (int) request.getSession().getAttribute("busiId");
		System.out.println("busiInfo:getBusi:busiId" + busiId);
		List<Busi> busiList = busiInfoService.getBusi(busiId);
		System.out.println("busiInfo:getBusi:busiId" + busiList);
		request.setAttribute("busiList", busiList);
		request.getRequestDispatcher("/html/busiPage/detail/busiInfo.jsp").forward(request, response);
	}

	// 更新密码
	protected void updatePass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int busiId = (int) session.getAttribute("busiId");
		String busiPhone = (String) session.getAttribute("busiPhone");
		String oldBusiPass = request.getParameter("oldPass");
		String newBusiPass = request.getParameter("newPass");
		String sureBusiPass = request.getParameter("surePass");
		System.out.println("busiInfo:updatePass:"+oldBusiPass+" "+newBusiPass+" "+sureBusiPass);
		try
		{
			if(newBusiPass.equals(sureBusiPass))
			{
				long count = busiInfoService.getCountForBusiPass(busiPhone, oldBusiPass);
				if(count==1)
				{
					busiInfoService.updatePass(busiId, newBusiPass);
					session.removeAttribute("busiId");
					session.removeAttribute("busiPhone");
					response.sendRedirect("/xMeituan/html/busiPage/busiLogin.html");
				}
				else
				{
					System.out.println("密码不正确,无法修改");
				}
			}
			else
			{
				System.out.println("新密码和确认密码不一致！");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("/xMeituan/html/error/error.jsp");
		}
	}

	// 更新商家信息
	protected void updateBusi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int busiId = (int) session.getAttribute("busiId");
		String busiName = request.getParameter("busiName");
		String busiPhone = request.getParameter("busiPhone");
		String busiAddr = request.getParameter("busiAddr");
		String busiShopName = request.getParameter("busiShopName");
		String busiNotice = request.getParameter("busiNotice");
		System.out.println("busiInfo:updateBusi:"+busiName+busiPhone+busiAddr+busiShopName+busiNotice);
		long count = busiInfoService.getCountForBusiPhone(busiPhone);
		long count1 = busiInfoService.getCountForBusiShopName(busiShopName);
		if(count<=1)
		{
			if(count1<=1)
			{
				//更新并修改session中的busiPhone
				Busi busi = new Busi(busiId, busiName, busiPhone, busiAddr, busiShopName, busiNotice);
				busiInfoService.updateBusi(busi);
				session.setAttribute("busiPhone", busiPhone);
			}
			else
			{
				System.out.println("商店名已被占用");
			}
		}
		else
		{
			System.out.println("手机号码已被占用");
		}
		response.sendRedirect("/xMeituan/busiInfo?method=getBusi");
	}

	// 更新营业信息
	protected void updateFlag(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{
			int busiId = (int) request.getSession().getAttribute("busiId");
			String busiFlagStr = request.getParameter("busiFlag");
			int busiFlag = Integer.parseInt(busiFlagStr);
			busiInfoService.updateFlag(busiId, busiFlag);
		} catch (Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("/xMeituan/html/error/error.jsp");
		}
		response.sendRedirect("/xMeituan/busiInfo?method=getBusi");
	}

	// 修改Logo的方法
	protected void updateLogo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String oldBusiLogo = request.getParameter("oldBusiLogo");
		ServletFileUpload upload = getServletFileUpload();
		busiId = (int) request.getSession().getAttribute("busiId");
		try
		{
			// 解析请求, 得到 FileItem 的集合.
			List<FileItem> items = upload.parseRequest(request);
			// 创建uploadFiles,key是路径名,value是fileItem
			Map<String, FileItem> uploadFiles = new HashMap<String, FileItem>();
			// 1. 构建busiLogo路径, 同时填充 uploadFiles
			String busiLogo = getLogoPath(items, uploadFiles);
			// 2. 校验扩展名:
			vaidateExtName(busiLogo);
			// 3. 校验文件的大小: 在解析时, 已经校验了, 我们只需要通过异常得到结果.

			// 4. 进行文件的上传操作.
			upload(uploadFiles);
			// 5. 把上传的信息保存到数据库中
			updatePath(busiId, busiLogo);
			// 6. 删除临时文件夹的临时文件
			FileUtils.delAllFile(TEMP_DIR);
			// 7. 删除原来的图片
			if(oldBusiLogo!=null)
			{
				deleteFile(oldBusiLogo);
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("/xMeituan/html/error/error.jsp");
		}
		response.sendRedirect("/xMeituan/busiInfo?method=getBusi");
	}

	private boolean deleteFile(String fileName)
	{
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile())
		{
			if (file.delete())
			{
				System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else
			{
				System.out.println("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else
		{
			System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}

	private void upload(String filePath, InputStream inputStream) throws IOException
	{
		OutputStream out = new FileOutputStream(filePath);

		byte[] buffer = new byte[1024];
		int len = 0;

		while ((len = inputStream.read(buffer)) != -1)
		{
			out.write(buffer, 0, len);
		}
		inputStream.close();
		out.close();

		System.out.println(filePath);
	}

	private void upload(Map<String, FileItem> uploadFiles) throws IOException
	{
		for (Map.Entry<String, FileItem> uploadFile : uploadFiles.entrySet())
		{
			String filePath = uploadFile.getKey();
			FileItem item = uploadFile.getValue();

			upload(filePath, item.getInputStream());
		}
	}

	private void vaidateExtName(String busiLogo)
	{
		String exts = FileUploadAppProperties.getInstance().getProperty("exts");
		List<String> extList = Arrays.asList(exts.split(","));
		System.out.println(extList);
		String extName = busiLogo.substring(busiLogo.lastIndexOf(".") + 1);
		System.out.println("busiLogo:ext:" + extName);
		if (!extList.contains(extName))
		{
			throw new com.meituan.exception.InvalidExtNameException(busiLogo + "文件的扩展名不合法");
		}
	}

	private void updatePath(int busiId, String busiLogo)
	{
		busiInfoService.updatebusiLogo(busiId, busiLogo);
	}

	private String getLogoPath(List<FileItem> items, Map<String, FileItem> uploadFiles)
	{
		String busiLogo = null;
		for (int i = 0; i < items.size(); i++)
		{
			FileItem item = items.get(i);

			if (!item.isFormField())
			{
				// 获取过来的文件名
				String fileName = item.getName();
				busiLogo = getFilePath(fileName);
				uploadFiles.put(busiLogo, item);
			}
		}
		return busiLogo;
	}

	private ServletFileUpload getServletFileUpload()
	{
		String fileMaxSize = FileUploadAppProperties.getInstance().getProperty("file.max.size");
		String totalFileMaxSize = FileUploadAppProperties.getInstance().getProperty("total.file.max.size");
		System.out.println(fileMaxSize);
		System.out.println(totalFileMaxSize);
		DiskFileItemFactory factory = new DiskFileItemFactory();

		factory.setSizeThreshold(1024 * 500);
		File tempDirectory = new File(TEMP_DIR);
		factory.setRepository(tempDirectory);

		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setSizeMax(Integer.parseInt(totalFileMaxSize));
		upload.setFileSizeMax(Integer.parseInt(fileMaxSize));

		return upload;
	}

	private String getFilePath(String fileName)
	{
		String extName = fileName.substring(fileName.lastIndexOf("."));
		Random random = new Random();
		String filePath = FILE_PATH + "\\" + System.currentTimeMillis() + random.nextInt(100000) + extName;
		return filePath;
	}
}
