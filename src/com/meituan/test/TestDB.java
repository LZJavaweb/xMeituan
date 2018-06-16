package com.meituan.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.meituan.db.JdbcUtils;

public class TestDB
{
	@Test
	public void test1()
	{
		try
		{
			Connection ju =  JdbcUtils.getConnection();
			System.out.println(ju);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
}
