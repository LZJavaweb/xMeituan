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
		@SuppressWarnings("unchecked")
		List<Cart> cartList = (List<Cart>) request.getAttribute("cartList");
		String busiIdStr =  (String) request.getAttribute("busiId");
		String userIdStr =  (String) session.getAttribute("userId");
		String addrIdStr =  request.getParameter("addrId");
		String orderRemark = request.getParameter("orderRemark");
		int busiId = Integer.parseInt(busiIdStr);
		int userId = Integer.parseInt(userIdStr);
		int addrId = Integer.parseInt(addrIdStr);
		userCheckOutService.save(cartList, userId, addrId, busiId, orderRemark);
		request.getRequestDispatcher("/html/userPage/userSuccess.jsp");
	}
}
