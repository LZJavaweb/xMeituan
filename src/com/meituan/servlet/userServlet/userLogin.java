package com.meituan.servlet.userServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

import com.meituan.dao.UserDAO;
import com.meituan.dao.impl.UserDAOImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;

/**
 * Servlet implementation class LoginCheck
 */
public class userLogin extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 1. ��ȡ ServletPath: /edit.do �� /addCustomer.do
		String servletPath = request.getServletPath();

		// 2. ȥ�� / �� .do, �õ������� edit �� addCustomer �������ַ���
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);

		try
		{
			// 3. ���÷����ȡ methodName ��Ӧ�ķ���
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// 4. ���÷�����ö�Ӧ�ķ���
			method.invoke(this, request, response);
		} catch (Exception e)
		{
			e.printStackTrace();
			// ������һЩ��Ӧ.
			response.sendRedirect("error.jsp");
		}
	}
	private UserDAO ud = new UserDAOImpl();
	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException
	{
		PrintWriter out = response.getWriter();
		String userPhone = request.getParameter("userPhone");
		String userPass = request.getParameter("userPass");
//		System.out.println(userPhone);
//		System.out.println(userPass);
		long count = ud.getCountForUser(userPhone, userPass);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonUser = new JSONObject();
		if(count==1)
		{
			jsonUser.put("checked", "true");
		}
		else 
		{
			jsonUser.put("checked", "false");
		}
		jsonList.add(jsonUser);
		out.println(jsonList);
	}
}
