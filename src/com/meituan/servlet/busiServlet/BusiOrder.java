package com.meituan.servlet.busiServlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meituan.domain.Order;
import com.meituan.service.busiService.BusiOrderService;

public class BusiOrder extends HttpServlet
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
	private BusiOrderService busiOrderService = new BusiOrderService();
	//获取订单
	public void getOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int busiId = (int) session.getAttribute("busiId");
		List<Order> orderList = busiOrderService.getOrder(busiId);
		request.setAttribute("orderList", orderList);
		System.out.println("busiOrder:orderList:"+orderList);
		request.getRequestDispatcher("/html/busiPage/detail/busiOrder.jsp").forward(request, response);
	}
	//获取历史订单
	public void getOldOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int busiId = (int) session.getAttribute("busiId");
		String pageNoStr = request.getParameter("pageNo");
		int pageNo = 1;
		try
		{
			if(pageNoStr != null)
				pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		int pageSize = 10;
		long totalItem = busiOrderService.getTotalItem(busiId, "已评价", "已完成");
		long totalPage;
		if(totalItem%pageSize==0)
		{
			totalPage = totalItem/pageSize;
		}
		else 
		{
			totalPage = totalItem/pageSize+1;
		}
		System.out.println("busiOrder:totalpage:"+totalPage+"totalItem:"+totalItem);
		List<Order> orderList = busiOrderService.getOldOrder(busiId, pageSize, pageNo);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("/html/busiPage/detail/busiOrderHistory.jsp").forward(request, response);
	}
	//接单处理
	public void receiveOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String orderIdStr = request.getParameter("orderId");
		int orderId = Integer.parseInt(orderIdStr);
		busiOrderService.saveReceive(orderId);
		response.sendRedirect("/xMeituan/busiOrder?method=getOrder");
	}
}
