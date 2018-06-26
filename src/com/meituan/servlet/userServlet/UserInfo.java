package com.meituan.servlet.userServlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meituan.domain.User;
import com.meituan.service.userService.UserInfoService;

public class UserInfo extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

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

	private UserInfoService userInfoService = new UserInfoService();

	/**
	 * 获取用户信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		int userId = (int) request.getSession().getAttribute("userId");
		List<User> userList = userInfoService.getUser(userId);
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("/html/userPage/userInfo.jsp").forward(request, response);
	}

	/**
	 * 更新用户信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		int userId = (int) request.getSession().getAttribute("userId");
		String userName = request.getParameter("userName");
		if (userName != null && !userName.equals(""))
		{
			if (userName.length() <= 20)
			{
				userInfoService.updateUser(userId, userName);
			} else
			{
				System.out.println("userInfo:updateUser:用户名超过20");
			}
		} else
		{
			System.out.println("userInfo:updateUser:用户名为空");
		}
		response.sendRedirect("/xMeituan/userInfo?method=getUser");
	}

	/**
	 * 更新密码
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updatePass(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("userId");
		String oldPass = request.getParameter("oldPass");
		String newPass = request.getParameter("newPass");
		String surePass = request.getParameter("surePass");
		try
		{
			if (newPass.length() >= 8 && newPass.length() <= 20)
			{
				if (newPass.equals(surePass))
				{
					long count = userInfoService.getCountForUser(userId, oldPass);
					if (count == 1)
					{
						userInfoService.updatePass(userId, newPass);
						session.removeAttribute("userId");
						session.removeAttribute("userPhone");
						response.sendRedirect("/xMeituan/html/userPage/userLogin.html");
					}
				} else
				{
					System.out.println("userInfo:updatePass:密码不匹配");
				}
			} else
			{
				System.out.println("userInfo:updatePass:新密码长度不对");
			}
		} catch (Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("/xMeituan/html/error/error.jsp");
		}
	}

}
