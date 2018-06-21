package com.meituan.servlet.userServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.service.userService.UserConfirmService;

public class UserConfirm extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	private UserConfirmService userConfirmService = new UserConfirmService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String orderIdStr = request.getParameter("orderId");
		int orderId = Integer.parseInt(orderIdStr);
		userConfirmService.saveFinish(orderId);
		response.sendRedirect("/xMeituan/userOrder");
	}
}
