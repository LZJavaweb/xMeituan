package com.meituan.servlet.userServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.domain.Food;
import com.meituan.service.userService.UserMenuService;

public class UserMenu extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private UserMenuService userMenuService = new UserMenuService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String busiIdStr = request.getParameter("busiId");
		int busiId = Integer.parseInt(busiIdStr);
		System.out.println("busiId:"+busiId);
		List<Food> foodList = userMenuService.getAll(busiId);
		System.out.println("foodList:"+foodList);
		request.setAttribute("busiId", busiId);
		request.setAttribute("foodList", foodList);
		request.getRequestDispatcher("/html/userPage/userMenu.jsp").forward(request, response);
	}
}
