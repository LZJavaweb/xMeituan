package com.meituan.servlet.adminServlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.domain.Busi;
import com.meituan.domain.CheckBusi;
import com.meituan.service.adminService.BusiManageService;

public class BusiManage extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String methodName = request.getParameter("method");
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

	private BusiManageService busiManageService = new BusiManageService();

	protected void getBusi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String pageNoStr = request.getParameter("pageNo");
		String busiName = request.getParameter("busiName");
		String busiPhone = request.getParameter("busiPhone");
		String busiPass = request.getParameter("busiPass");
		String busiAddr = request.getParameter("busiAddr");
		String busiShopName = request.getParameter("busiShopName");
		String busiFlagStr = request.getParameter("busiFlag");
		String busiBanStr = request.getParameter("busiBan");
		int busiFlag = 1;
		int busiBan = 1;
		int pageNo = 1;
		try
		{
			if (pageNoStr != null)
				pageNo = Integer.parseInt(pageNoStr);
			if (busiFlagStr != null)
				busiFlag = Integer.parseInt(busiFlagStr);
			if (busiBanStr != null)
				busiBan = Integer.parseInt(busiBanStr);
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		CheckBusi cb = new CheckBusi(busiName, busiPhone, busiPass, busiAddr, busiShopName, busiFlag, busiBan);
		int pageSize = 10;
		long totalItem = busiManageService.getCountForAllBusi(cb);
		long totalPage;
		if (totalItem % pageSize == 0)
		{
			totalPage = totalItem / pageSize;
		} else
		{
			totalPage = totalItem / pageSize + 1;
		}
		List<Busi> busiList = busiManageService.getAllBusi(pageNo, pageSize, cb);
		request.setAttribute("busiList", busiList);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("pageNo", pageNo);
		request.getRequestDispatcher("/html/adminPage/busiManage.jsp").forward(request, response);
	}

	protected void updateBusi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		String busiIdStr = request.getParameter("busiId");
		String busiBanStr = request.getParameter("busiBan");
		int busiId = 0;
		int busiBan = 1;
		try
		{
			if (busiIdStr != null)
				busiId = Integer.parseInt(busiIdStr);
			if (busiBanStr != null)
				busiBan = Integer.parseInt(busiBanStr);
		} catch (NumberFormatException e)
		{
			System.out.println("busiManage:updateBusi:转换失败");
			e.printStackTrace();
		}
		busiManageService.updateBusi(busiId, busiBan);
		response.sendRedirect("/xMeituan/busiManaga?method=getBusi");
	}

}
