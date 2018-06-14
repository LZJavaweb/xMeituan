package com.meituan.servlet.userServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.meituan.dao.UserDAO;
import com.meituan.dao.impl.UserDAOImpl;
import com.meituan.domain.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * ud : UserDAO
 * doPost() : post����
 * check() : ��Ӧcheck.ul ,ul��userLogin
 * reg() : ��Ӧreg.ul ,ul��userLogin
 * phone() : ��Ӧphone.ul ,ul��userLogin
 * @author zhou
 *
 */
public class userLogin extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private UserDAO ud = new UserDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 1. ��ȡ ServletPath: /check.ul�� reg.ul �ȡ� ul��userLogin������ĸ��д
		String servletPath = request.getServletPath();
		System.out.println(servletPath);
		// 2. ȥ�� / �� .ul, �õ������� check �� reg �������ַ���
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

	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String userPhone = request.getParameter("userPhone");
		String userPass = request.getParameter("userPass");
		System.out.println(request.getServletPath() + ":" + userPhone);
		System.out.println(request.getServletPath() + ":" + userPass);
		long count = ud.getCountForUser(userPhone, userPass);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		if (count == 1)
		{
			jsonObj.put("checked", "true");
		} else
		{
			jsonObj.put("checked", "false");
		}
		jsonList.add(jsonObj);
		out.println(jsonList);
	}

	private void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		// ��ȡ���ݹ����Ĳ���
		String userPhone = request.getParameter("userPhone");
		String userPass = request.getParameter("userPass");
		String userName = request.getParameter("userName");
		System.out.println(request.getServletPath() + ":" + userPhone);
		System.out.println(request.getServletPath() + ":" + userPass);
		System.out.println(request.getServletPath() + ":" + userName);
		// ��ѯ���ݿ��Ƿ�����ֻ���
		long count = ud.getCountForPhone(userPhone);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		if (count == 0)
		{
			// δע������û�
			User user = new User(userPhone, userPass, userName);
			ud.sava(user);
			jsonObj.put("checked", "true");
		} else
		{
			// ע������û�
			jsonObj.put("checked", "false");
		}
		jsonList.add(jsonObj);
		out.println(jsonList);
	}

	private void phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		// ��ȡ���ݹ����Ĳ���
		String userPhone = request.getParameter("userPhone");
		System.out.println(request.getServletPath() + ":" + userPhone);
		// ��ѯ���ݿ��Ƿ�����ֻ���
		long count = ud.getCountForPhone(userPhone);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		if (count == 0)
		{
			// δע������ֻ���
			jsonObj.put("checked", "true");
		} else
		{
			// ע������ֻ���
			jsonObj.put("checked", "false");
		}
		jsonList.add(jsonObj);
		out.println(jsonList);
	}
}
