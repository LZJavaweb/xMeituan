package com.meituan.servlet.busiServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.FoodDAO;
import com.meituan.dao.impl.BusiDAOImpl;
import com.meituan.dao.impl.FoodDAOImpl;
import com.meituan.domain.Food;
import com.meituan.utils.FileUploadAppProperties;
import com.meituan.utils.FileUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class busiPageForUpload extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static final String FILE_PATH = "D:\\xMeituan\\WebContent\\resources\\BusiPic";
	private static final String TEMP_DIR = "d:\\tempDirectory";
	private int busiId ;
	private String busiPhone = null;
	private FoodDAO fd = new FoodDAOImpl();
	private BusiDAO bd = new BusiDAOImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 获取 ServletFileUpload 对象.
		System.out.println("hellow");
		ServletFileUpload upload = getServletFileUpload();
		//获取商家busiId
		busiPhone = (String) request.getSession().getAttribute("busiPhone");
		busiId = bd.getId(busiPhone);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		PrintWriter out = response.getWriter();
		try
		{
			// 把需要上传的 FileItem 都放入到该 Map 中
			// 键: 文件的待存放的路径, 值: 对应的 FileItem 对象
			Map<String, FileItem> uploadFiles = new HashMap<String, FileItem>();

			// 解析请求, 得到 FileItem 的集合.
			List<FileItem> items = upload.parseRequest(request);

			// 1. 构建 FileUploadBean 的集合, 同时填充 uploadFiles
			List<Food> beans = buildFileUploadBeans(items, uploadFiles);

			// 2. 校验扩展名:
			vaidateExtName(beans);

			// 3. 校验文件的大小: 在解析时, 已经校验了, 我们只需要通过异常得到结果.

			// 4. 进行文件的上传操作.
			upload(uploadFiles);

			// 5. 把上传的信息保存到数据库中
			saveBeans(beans);

			// 6. 删除临时文件夹的临时文件
			FileUtils.delAllFile(TEMP_DIR);
			
			jsonObj.put("checked", "true");
			
		} catch (Exception e)
		{
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
			jsonObj.put("checked", "false");
		} finally
		{
			jsonArray.add(jsonObj);
			out.println(jsonArray);
		}
	}
	/**
	 * 构建 ServletFileUpload 对象 从配置文件中读取了部分属性, 用户设置约束. 该方法代码来源于文档.
	 * 
	 * @return
	 */
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
	
	/**
	 * 利用传入的 FileItem 的集合, 构建 FileUploadBean 的集合, 同时填充 uploadFiles
	 * 
	 * FileUploadBean 对象封装了: id, fileName, filePath, fileDesc uploadFiles:
	 * Map<String, FileItem> 类型, 存放文件域类型的 FileItem. 键: 待保存的文件的名字 ,值: FileItem 对象
	 * 
	 * 构建过程: 1. 对传入 FileItem 的集合进行遍历. 得到 desc 的那个 Map. 键: desc 的 fieldName(desc1,
	 * desc2 ...). 值: desc 的那个输入的文本值
	 * 
	 * 2. 对传入 FileItem 的集合进行遍历. 得到文件域的那些 FileItem 对象, 构建对应的 key (desc1 ....) 来获取其
	 * desc. 构建的 FileUploadBean 对象, 并填充 beans 和 uploadFiles
	 * 
	 * @param items
	 * @param uploadFiles
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	private List<Food> buildFileUploadBeans(List<FileItem> items, Map<String, FileItem> uploadFiles)
			throws UnsupportedEncodingException
	{
		List<Food> beans = new ArrayList<>();

		Map<String, String> descs = new HashMap<>();

		for (int i = 0; i < items.size(); i++)
		{
			FileItem item = items.get(i);

			if (item.isFormField())
			{
				//fieldName对应name属性，desc对应的是文本域的内容
				String fieldName = item.getFieldName();
				String desc = item.getString("UTF-8");
				descs.put(fieldName, desc);
			}
		}

		for (int i = 0; i < items.size(); i++)
		{
			FileItem item = items.get(i);
			Food food = null;
			if (!item.isFormField())
			{
				//获取文件域的name属性,在这里fieldName应该是"foodPic*",*是1-9中的数字
				String fieldName = item.getFieldName();
				//获取当前文件域是第几个文件,注：一次上传不能超过9个文件
				String num = fieldName.substring(fieldName.length()-1);
				//组装foodName*,foodPrice*等
				String name = "foodName" + num;
				String desc = "foodDesc" + num;
				String price = "foodPrice" + num;
				String stock = "foodStock" + num;
				//获取foodName*,foodPrice*等对应的值
				String foodName = descs.get(name);
				String foodDesc = descs.get(desc);
				String foodPrice = descs.get(price);
				String foodStock = descs.get(stock);
				System.out.println(busiId);
				System.out.println(foodName);
				System.out.println(foodDesc);
				System.out.println(foodPrice);
				System.out.println(foodStock);
				// 对应文件名
				String fileName = item.getName();
				//得到生成的存放在磁盘中的路径
				String foodPic = getFilePath(fileName);
				//建立对象
				food = new Food(busiId, foodName, foodDesc, Double.parseDouble(foodPrice), Integer.parseInt(foodStock), foodPic);
				//加入到List中
				beans.add(food);
				//具体写入，需要用到uploadFiles,所以把路径给他，然后判断是否符合条件，符合再写入。
				uploadFiles.put(food.getFoodPic(), item);
			}
		}

		return beans;
	}
	
	/**
	 * 根据跟定的文件名构建一个随机的文件名 1. 构建的文件的文件名的扩展名和给定的文件的扩展名一致 2. 利用 ServletContext 的
	 * getRealPath 方法获取的绝对路径 3. 利用了 Random 和 当前的系统时间构建随机的文件的名字
	 * 
	 * @param fileName
	 * @return
	 */
	private String getFilePath(String fileName)
	{
		String extName = fileName.substring(fileName.lastIndexOf("."));
		Random random = new Random();
		String filePath = FILE_PATH +"\\"+ System.currentTimeMillis()+ random.nextInt(100000) + extName;
		return filePath;
	}
	
	/**
	 * 校验扩展名是否合法
	 * 
	 * @param beans:
	 */
	private void vaidateExtName(List<Food> beans)
	{
		String exts = FileUploadAppProperties.getInstance().getProperty("exts");
		List<String> extList = Arrays.asList(exts.split(","));
		System.out.println(extList);

		for (Food food : beans)
		{
			String foodPic = food.getFoodPic();
			System.out.println(foodPic.indexOf("."));

			String extName = foodPic.substring(foodPic.lastIndexOf(".") + 1);
			System.out.println(extName);

			if (!extList.contains(extName))
			{
				throw new com.meituan.exception.InvalidExtNameException(foodPic + "文件的扩展名不合法");
			}
		}
	}
	/**
	 * 文件上传前的准备工作. 得到 filePath 和 InputStream
	 * 
	 * @param uploadFiles
	 * @throws IOException
	 */
	private void upload(Map<String, FileItem> uploadFiles) throws IOException
	{
		for (Map.Entry<String, FileItem> uploadFile : uploadFiles.entrySet())
		{
			String filePath = uploadFile.getKey();
			FileItem item = uploadFile.getValue();

			upload(filePath, item.getInputStream());
		}
	}
	/**
	 * 文件上传的 IO 方法.
	 * 
	 * @param filePath
	 * @param inputStream
	 * @throws IOException
	 */
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
	private void saveBeans(List<Food> beans)
	{
		for(Food food : beans)
		{
			fd.save(food);
		}
	}
}
