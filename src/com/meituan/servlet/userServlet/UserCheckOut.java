package com.meituan.servlet.userServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meituan.domain.Cart;
import com.meituan.service.userService.UserCheckOutService;

public class UserCheckOut extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	private UserCheckOutService userCheckOutService = new UserCheckOutService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		List<Cart> cartList = (List<Cart>) session.getAttribute("cartList");
		int userId =  (int) session.getAttribute("userId");
		//System.out.println("userCheckOut:userId:"+userId);
		int busiId = (int) session.getAttribute("busiId");
		//System.out.println("userCheckOut:busiIdStr:"+busiIdStr);
		//System.out.println("userCheckOut:busiId:"+busiId);
		String addrIdStr =  request.getParameter("addrId");
		int addrId = Integer.parseInt(addrIdStr);
		//System.out.println("userCheckOut:addrId:"+addrId);
		String orderRemark = request.getParameter("orderRemark");
		try
		{
			userCheckOutService.save(cartList, userId, addrId, busiId, orderRemark);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		response.sendRedirect("/xMeituan/userOrder");
	}
}
