package com.meituan.servlet.userServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.domain.Busi;
import com.meituan.service.userService.UserShowService;

public class UserShow extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	private UserShowService userShowService = new UserShowService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String  pageNoStr = request.getParameter("pageNo");
		int pageNo = 1;
		try
		{
			if(pageNoStr != null)
				pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		List<Busi> busiList = userShowService.getBusi(pageNo);
		long totalBusi = userShowService.getTotalItem();
		long totalPage;
		int pageSize = 10;
		if(totalBusi%pageSize==0)
		{
			totalPage = totalBusi/pageSize;
		}
		else 
		{
			totalPage = totalBusi/pageSize+1;
		}
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("busiList", busiList);
		request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("/html/userPage/userShow.jsp").forward(request, response);;
	}
}
