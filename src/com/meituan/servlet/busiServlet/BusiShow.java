package com.meituan.servlet.busiServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.FoodDAO;
import com.meituan.dao.impl.BusiDAOImpl;
import com.meituan.dao.impl.FoodDAOImpl;
import com.meituan.domain.Food;
import com.meituan.service.busiService.BusiShowService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BusiShow extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	private BusiShowService busiShowService = new BusiShowService();
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
	//获取食品信息
	public void getFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int busiId = (int) session.getAttribute("busiId");
		List<Food> foodList = busiShowService.getAll(busiId);
		request.setAttribute("foodList", foodList);
		request.getRequestDispatcher("/html/busiPage/detail/busiShow.jsp").forward(request, response);
	}
	//编辑食品信息
	public void editFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
	//删除食品信息
	public void deleteFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
	}
}
