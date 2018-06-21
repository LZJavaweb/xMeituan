package com.meituan.servlet.userServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.domain.Cart;
import com.meituan.service.userService.UserOrderService;

public class UserOrder extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	public UserOrderService userOrderService = new UserOrderService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		@SuppressWarnings("unchecked")
		List<Cart> cartList = (List<Cart>) request.getAttribute("cartList");
		String busiIdStr =  (String) request.getAttribute("busiId");
		String userIdStr =  (String) request.getAttribute("userId");
		String addrIdStr =  (String) request.getAttribute("addrId");
		String orderRemark = (String) request.getAttribute("orderRemark");
		int busiId = Integer.parseInt(busiIdStr);
		int userId = Integer.parseInt(userIdStr);
		int addrId = Integer.parseInt(addrIdStr);
		userOrderService.save(cartList, userId, addrId, busiId, orderRemark);
		request.getRequestDispatcher("/html/userPage/userSuccess.jsp");
	}
}
