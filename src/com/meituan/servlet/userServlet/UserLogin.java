package com.meituan.servlet.userServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meituan.dao.UserDAO;
import com.meituan.dao.impl.UserDAOImpl;
import com.meituan.domain.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * ud : UserDAO
 * doPost() : post请求
 * check() : 响应check.ul ,ul即userLogin
 * reg() : 响应reg.ul ,ul即userLogin
 * phone() : 响应phone.ul ,ul即userLogin
 * @author zhou
 *
 */
public class UserLogin extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private UserDAO ud = new UserDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 1. 获取 ServletPath: /check.ul或 reg.ul 等。 ul是userLogin的首字母缩写
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		// 2. 去除 / 和 .ul, 得到类似于 check 或 reg 这样的字符串
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);

		try
		{
			// 3. 利用反射获取 methodName 对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			// 4. 利用反射调用对应的方法
			method.invoke(this, request, response);
		} catch (Exception e)
		{
			e.printStackTrace();
			// 可以有一些响应.
			response.sendRedirect("error.jsp");
		}
	}

	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String userPhone = request.getParameter("userPhone");
		String userPass = request.getParameter("userPass");
		System.out.println(request.getServletPath() + ":" + userPhone);
		System.out.println(request.getServletPath() + ":" + userPass);
		long count = ud.getCountForUser(userPhone, userPass);
		if (count == 1)
		{
			HttpSession session = request.getSession();
			session.setAttribute("userPhone", userPhone);
			response.sendRedirect("/xMeituan/userShow");
		} else
		{
			response.sendRedirect("html/userPage/userLogin.html");
		}
	}

	private void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		// 获取传递过来的参数
		String userPhone = request.getParameter("userPhone");
		String userPass = request.getParameter("userPass");
		String userName = request.getParameter("userName");
		System.out.println(request.getServletPath() + ":" + userPhone);
		System.out.println(request.getServletPath() + ":" + userPass);
		System.out.println(request.getServletPath() + ":" + userName);
		// 查询数据库是否存在手机号
		long count = ud.getCountForPhone(userPhone);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		if (count == 0)
		{
			// 未注册过的用户
			User user = new User(userPhone, userPass, userName);
			ud.sava(user);
			jsonObj.put("checked", "true");
		} else
		{
			// 注册过的用户
			jsonObj.put("checked", "false");
		}
		jsonList.add(jsonObj);
		out.println(jsonList);
	}

	private void phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		// 获取传递过来的参数
		String userPhone = request.getParameter("userPhone");
		System.out.println(request.getServletPath() + ":" + userPhone);
		// 查询数据库是否存在手机号
		long count = ud.getCountForPhone(userPhone);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		if (count == 0)
		{
			// 未注册过的手机号
			jsonObj.put("checked", "true");
		} else
		{
			// 注册过的手机号
			jsonObj.put("checked", "false");
		}
		jsonList.add(jsonObj);
		out.println(jsonList);
	}
}
