package com.meituan.servlet.busiServlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meituan.domain.Food;
import com.meituan.service.busiService.BusiShowService;

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
	protected void getFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int busiId = (int) session.getAttribute("busiId");
		List<Food> foodList = busiShowService.getAll(busiId);
		request.setAttribute("foodList", foodList);
		request.getRequestDispatcher("/html/busiPage/detail/busiShow.jsp").forward(request, response);
	}
	//编辑食品信息
	protected void editFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int foodId=0;
		double foodPrice=0;
		int foodStock=0;
		String foodIdStr = request.getParameter("foodId");
		String foodName = request.getParameter("foodName");
		String foodPriceStr = request.getParameter("foodPrice");
		String foodDesc = request.getParameter("foodDesc");
		String foodStockStr = request.getParameter("foodStock");
		try
		{
			if(foodIdStr!=null)
				foodId = Integer.parseInt(foodIdStr);
			if(foodPriceStr!=null)
				foodPrice = Double.parseDouble(foodStockStr);
			if(foodStockStr!=null)
				foodStock= Integer.parseInt(foodStockStr);
		} catch (NumberFormatException e)
		{
			System.out.println("busiShow:editfood:转换出错");
			e.printStackTrace();
		}
		Food food = new Food();
		food.setFoodId(foodId);
		food.setFoodName(foodName);
		food.setFoodPrice(foodPrice);
		food.setFoodDesc(foodDesc);
		food.setFoodStock(foodStock);
		busiShowService.updateFood(food);
		response.sendRedirect("/xMeituan/busiShow?method=getFood");
	}
	//删除食品信息
	protected void deleteFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int foodId=0;
		String foodIdStr = request.getParameter("foodId");
		try
		{
			if(foodIdStr!=null)
				foodId = Integer.parseInt(foodIdStr);
		} catch (NumberFormatException e)
		{
			System.out.println("busiShow:deletefood:转换出错");
			e.printStackTrace();
		}
		List<Food> foodList = busiShowService.getFood(foodId);
		busiShowService.deleteFood(foodId);
		Food food = foodList.get(0);
		System.out.println(food);
		String foodPic = food.getFoodPic();
		deleteFile(foodPic);
		response.sendRedirect("/xMeituan/busiShow?method=getFood");
		
	}
	private boolean deleteFile(String fileName)
	{
		File file = new File(fileName);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile())
		{
			if (file.delete())
			{
				System.out.println("删除单个文件" + fileName + "成功！");
				return true;
			} else
			{
				System.out.println("删除单个文件" + fileName + "失败！");
				return false;
			}
		} else
		{
			System.out.println("删除单个文件失败：" + fileName + "不存在！");
			return false;
		}
	}
}
