package com.meituan.servlet.busiServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.impl.BusiDAOImpl;

public class Busilogout extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private BusiDAO bd = new BusiDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		session.removeAttribute("busiId");
		session.removeAttribute("busiPhone");
		response.sendRedirect("/xMeituan/html/busiPage/busiLogin.html");
	}
}
