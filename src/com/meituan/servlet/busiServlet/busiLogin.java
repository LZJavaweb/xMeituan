package com.meituan.servlet.busiServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.impl.BusiDAOImpl;
import com.meituan.domain.Busi;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class busiLogin extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private BusiDAO bd = new BusiDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 1. 获取 ServletPath: /check.ul或 reg.ul 等。 ul是busiLogin的首字母缩写
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
		PrintWriter out = response.getWriter();
		String busiPhone = request.getParameter("busiPhone");
		String busiPass = request.getParameter("busiPass");
		System.out.println(request.getServletPath() + ":" + busiPhone);
		System.out.println(request.getServletPath() + ":" + busiPass);
		long count = bd.getCountForBusi(busiPhone, busiPass);
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
		String path = request.getServletPath();
		// 获取传递过来的参数
		String busiPhone = request.getParameter("busiPhone");
		String busiPass = request.getParameter("busiPass");
		String busiName = request.getParameter("busiName");
		String busiShopName = request.getParameter("busiShopName");
		String busiAddr = request.getParameter("busiAddr");
		System.out.println(path + ":" + busiPhone);
		System.out.println(path + ":" + busiPass);
		System.out.println(path + ":" + busiName);
		System.out.println(path + ":" + busiShopName);
		System.out.println(path + ":" + busiAddr);
		// 查询数据库是否存在手机号
		long count = bd.getCountForPhone(busiPhone);
		long count1 = bd.getCountForShopName(busiShopName);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		if (count == 0 && count1 == 0)
		{
			// 未注册过的店铺
			Busi busi = new Busi(busiName, busiPhone, busiPass, busiAddr, busiShopName);
			bd.sava(busi);
			jsonObj.put("checked", "true");
		} else
		{
			// 注册过的店铺
			jsonObj.put("checked", "false");
		}
		jsonList.add(jsonObj);
		out.println(jsonList);
	}

	private void phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		// 获取传递过来的参数
		String busiPhone = request.getParameter("busiPhone");
		System.out.println(request.getServletPath() + ":" + busiPhone);
		// 查询数据库是否存在手机号
		long count = bd.getCountForPhone(busiPhone);
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

	private void shopName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		// 获取传递过来的参数
		String busiShopName = request.getParameter("busiShopName");
		System.out.println(request.getServletPath() + ":" + busiShopName);
		// 查询数据库是否存在手机号
		long count = bd.getCountForShopName(busiShopName);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		System.out.println("店铺数量"+count);
		if (count == 0)
		{
			// 未注册过的店铺名
			jsonObj.put("checked", "true");
		} else
		{
			// 注册过的店铺名
			jsonObj.put("checked", "false");
		}
		jsonList.add(jsonObj);
		out.println(jsonList);
	}
}
