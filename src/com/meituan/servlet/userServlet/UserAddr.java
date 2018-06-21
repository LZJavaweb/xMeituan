package com.meituan.servlet.userServlet;

import java.io.IOException;
import java.lang.reflect.Method;
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
	public void seleteAddr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
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
	public void getAddr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int userId= (int) session.getAttribute("userId");
		List<Addr> addrList = userAddrService.getAddr(userId);
		request.setAttribute("addrList", addrList);
		request.getRequestDispatcher("/html/userPage/userAddr.jsp").forward(request, response);
	}
	public void editAddr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int userId = (int) request.getSession().getAttribute("userId");
		String addrIdStr = request.getParameter("addrId");
		int addrId = Integer.parseInt(addrIdStr);
		String addrName = request.getParameter("addrName");
		String addrPhone = request.getParameter("addrPhone");
		String addrProv = request.getParameter("addrProv");
		String addrCity = request.getParameter("addrCity");
		String addrReal = request.getParameter("addrReal");
		int addrFlag = 0;
		Addr addr = new Addr(userId, addrName, addrPhone, addrProv, addrCity, addrReal, addrFlag);
		addr.setAddrId(addrId);
		userAddrService.editAddr(addr);
		System.out.println(addr);
		response.sendRedirect("/xMeituan/userAddr?method=getAddr");
	}
	public void deleteAddr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String addrIdStr = request.getParameter("addrId");
		int addrId = Integer.parseInt(addrIdStr);
		userAddrService.deleteAddr(addrId);
		response.sendRedirect("/xMeituan/userAddr?method=getAddr");
	}
	public void addAddr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int userId = (int) request.getSession().getAttribute("userId");
		String addrName = request.getParameter("addrName");
		String addrPhone = request.getParameter("addrPhone");
		String addrProv = request.getParameter("addrProv");
		String addrCity = request.getParameter("addrCity");
		String addrReal = request.getParameter("addrReal");
		int addrFlag = 0;
		Addr addr = new Addr(userId, addrName, addrPhone, addrProv, addrCity, addrReal, addrFlag);
		userAddrService.addAddr(addr);
		System.out.println(addr);
		response.sendRedirect("/xMeituan/userAddr?method=getAddr");
	}
}
