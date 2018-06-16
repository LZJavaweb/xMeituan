package com.meituan.servlet.busiServlet;

import java.io.IOException;
import java.io.PrintWriter;
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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BusiShow extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	private BusiDAO bd = new BusiDAOImpl();
	private FoodDAO fd = new FoodDAOImpl();
	private int busiId;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String busiPhone = (String) session.getAttribute("busiPhone");
		busiId=bd.getId(busiPhone);
		List<Food> list = fd.getAll(busiId);
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj = null;
		for(Food food : list)
		{
			System.out.println(food);
			jsonObj = new JSONObject();
			jsonObj.put("foodId", food.getFoodId());
			jsonObj.put("foodDesc", food.getFoodDesc());
			jsonObj.put("foodName", food.getFoodName());
			jsonObj.put("foodPic", food.getFoodPic());
			jsonObj.put("foodPrice", food.getFoodPrice());
			jsonObj.put("foodStock", food.getFoodStock());
			jsonArray.add(jsonObj);
		}
		System.out.println(jsonArray); 
		out.println(jsonArray);
	}

}
