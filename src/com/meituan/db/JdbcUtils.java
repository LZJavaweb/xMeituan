package com.meituan.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.meituan.exception.DBException;

public class JdbcUtils
{

	/**
	 * 释放connection
	 * 
	 * @param connection
	 */
	public static void releaseConnection(Connection connection)
	{
		try
		{
			if (connection != null)
			{
				connection.close();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void release(ResultSet rs, Statement statement)
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new DBException("resultSet 关闭错误！");
		}
		try
		{
			if (statement != null)
			{
				statement.close();
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
			throw new DBException("Statement 关闭错误！");
		}
	}
	
	private static DataSource dataSource = null;

	static
	{
		// 静态代码块，保证唯一
		dataSource = new ComboPooledDataSource("mituan");
	}

	/**
	 * 获取connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException
	{
		return dataSource.getConnection();
	}

}
