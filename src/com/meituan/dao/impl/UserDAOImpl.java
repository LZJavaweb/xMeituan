package com.meituan.dao.impl;

import java.util.List;

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

	@Override
	public int getUserId(String userPhone)
	{
		String sql = "select userId from user where userPhone = ?";
		return getForValue(sql, userPhone);
	}

	@Override
	public String getUserName(String userName)
	{
		String sql = "select username from user where userPhone = ?";
		return getForValue(sql, userName);
	}

	@Override
	public List<User> getUser(int userId)
	{
		String sql = "SELECT * FROM USER WHERE userId = ?";
		return getForList(sql, userId);
	}

	@Override
	public void updateUser(int userId, String userName)
	{
		String sql = "UPDATE USER SET userName = ? WHERE userId = ?";
		update(sql, userName,userId);
	}

	@Override
	public void updatePass(int userId, String userPass)
	{
		String sql = "UPDATE USER SET userPass = ? WHERE userId = ?";
		update(sql, userPass,userId);
	}

	@Override
	public long getCount(int userId, String userPass)
	{
		String sql = "SELECT COUNT(userId) FROM USER WHERE userId = ? AND userPass = ?";
		return getForValue(sql, userId,userPass);
	}
	

}
