package com.meituan.servlet.adminServlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.domain.Admin;
import com.meituan.service.adminService.AdminLoginService;

public class AdminLogin extends HttpServlet
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
	private AdminLoginService adminLoginService = new AdminLoginService();
	protected void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String adminName = request.getParameter("adminName");
		String adminPass = request.getParameter("adminPass");
		Admin admin = new Admin(adminName, adminPass);
		long count = adminLoginService.getCountForAdmin(admin);
		if(count==1)
		{
			response.sendRedirect("/xMeituan/html/adminPage/adminPage.html");
		}
		else
		{
			response.sendRedirect("/xMeituan/html/adminPage/adminLogin.html");
		}
	}

}
