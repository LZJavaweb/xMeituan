package com.meituan.servlet.userServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meituan.domain.Order;
import com.meituan.service.userService.UserOrderService;

public class UserOrder extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	public UserOrderService userOrderService = new UserOrderService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
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
		List<Order> orderList = userOrderService.getOrder(userId, pageNo);
		long totalOrder = userOrderService.getTotalOrder(userId);
		long totalPage;
		int pageSize = 10;
		if(totalOrder%pageSize==0)
		{
			totalPage = totalOrder/pageSize;
		}
		else 
		{
			totalPage = totalOrder/pageSize+1;
		}
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("orderList", orderList);
		request.getRequestDispatcher("/html/userPage/userOrder.jsp").forward(request, response);
	}
}
