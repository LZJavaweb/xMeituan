package com.meituan.dao.impl;

import com.meituan.dao.DAO;
import com.meituan.dao.UserDAO;
import com.meituan.domain.User;

public class UserDAOImpl extends DAO<User> implements UserDAO
{

	@Override
	public long getCountForUser(String userPhone, String userPass)
	{
		String sql = "SELECT COUNT(userId) FROM USER WHERE userPhone = ? AND userPass = ?";
		return getForValue(sql, userPhone, userPass);
	}

	@Override
	public long getCountForPhone(String userPhone)
	{
		String sql = "SELECT COUNT(userId) FROM USER WHERE userPhone = ?";
		return getForValue(sql, userPhone);
	}

	@Override
	public void sava(User user)
	{
		String sql = "INSERT INTO USER(userPhone,userPass,userName) VALUES(?,?,?)";
		update(sql,user.getUserPhone(),user.getUserPass(),user.getUserName());
	}



}
