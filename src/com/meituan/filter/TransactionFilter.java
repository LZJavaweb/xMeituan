package com.meituan.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.db.JdbcUtils;
import com.meituan.web.ConnectionContext;

public class TransactionFilter implements Filter
{
	public void destroy()
	{
		System.out.println("transactionfilter destroy ...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		Connection connection = null;

		try
		{
			connection = JdbcUtils.getConnection();

			connection.setAutoCommit(false);

			ConnectionContext.getInstance().bind(connection);

			chain.doFilter(request, response);

			connection.commit();
		} catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				connection.rollback();
			} catch (SQLException e1)
			{
				e1.printStackTrace();
			}

			HttpServletResponse resp = (HttpServletResponse) response;
			HttpServletRequest req = (HttpServletRequest) request;
			resp.sendRedirect(req.getContextPath() + "/html/error/error.jsp");

		} finally
		{
			ConnectionContext.getInstance().remove();

			JdbcUtils.releaseConnection(connection);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException
	{
		System.out.println("transactionfilter init ...");
	}

}
