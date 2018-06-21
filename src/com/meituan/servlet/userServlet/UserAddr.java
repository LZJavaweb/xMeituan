package com.meituan.servlet.userServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meituan.domain.Addr;
import com.meituan.domain.Cart;
import com.meituan.service.userService.UserAddrService;

public class UserAddr extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	private UserAddrService userAddrService = new UserAddrService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int userId= (int) session.getAttribute("userId");
		String busiIdStr = request.getParameter("busiId");
		System.out.println("userAddr:busiIdStr:"+busiIdStr);
		int busiId = Integer.parseInt(busiIdStr);
		String rowStr = request.getParameter("row");
		int row = Integer.parseInt(rowStr);
		System.out.println("userAddr:userId:"+userId+",busiId:"+busiId+",row:"+row);
		List<Cart> cartList = new ArrayList<Cart>();
		String foodIdStr;
		String foodNumStr;
		String foodPriceStr;
		Cart cart = null;
		for(int i=1;i<=row;i++)
		{
			foodIdStr = request.getParameter("foodId"+i);
			foodNumStr = request.getParameter("num"+i);
			foodPriceStr = request.getParameter("price"+i);
			System.out.println("userAddr:foodId:"+foodIdStr+",foodNum:"+foodNumStr+",foodPrice:"+foodPriceStr);
			cart = new Cart(Integer.parseInt(foodIdStr), Integer.parseInt(foodNumStr), Double.parseDouble(foodPriceStr));
			cartList.add(cart);
		}
		List<Addr> addrList = userAddrService.getAddr(userId);
		request.setAttribute("addrList", addrList);
		session.setAttribute("busiId", busiId);
		session.setAttribute("cartList", cartList);
		request.getRequestDispatcher("/html/userPage/userCheckOut.jsp").forward(request, response);
	}
}
