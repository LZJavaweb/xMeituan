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
		// 1. ��ȡ ServletPath: /check.ul�� reg.ul �ȡ� ul��busiLogin������ĸ��д
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
		// ��ȡ���ݹ����Ĳ���
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
		// ��ѯ���ݿ��Ƿ�����ֻ���
		long count = bd.getCountForPhone(busiPhone);
		long count1 = bd.getCountForShopName(busiShopName);
		JSONArray jsonList = new JSONArray();
		JSONObject jsonObj = new JSONObject();
		if (count == 0 && count1 ==0)
		{
			// δע����ĵ���
			Busi busi = new Busi(busiName, busiPhone, busiPass, busiAddr, busiShopName);
			bd.sava(busi);
			jsonObj.put("checked", "true");
		} else
		{
			// ע����ĵ���
			jsonObj.put("checked", "false");
		}
		jsonList.add(jsonObj);
		out.println(jsonList);
	}

	private void phone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		// ��ȡ���ݹ����Ĳ���
		String busiPhone = request.getParameter("busiPhone");
		System.out.println(request.getServletPath() + ":" + busiPhone);
		// ��ѯ���ݿ��Ƿ�����ֻ���
		long count = bd.getCountForPhone(busiPhone);
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
	private void shopName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		// ��ȡ���ݹ����Ĳ���
		String busiShopName = request.getParameter("busiShopName");
		System.out.println(request.getServletPath() + ":" + busiShopName);
		// ��ѯ���ݿ��Ƿ�����ֻ���
		long count = bd.getCountForPhone(busiShopName);
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
