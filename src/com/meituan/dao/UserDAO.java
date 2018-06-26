package com.meituan.dao;

import java.util.List;

import com.meituan.domain.User;

//顾客信息查询DAO
public interface UserDAO
{
	//查询账号密码
	public long getCountForUser(String userPhone,String userPass);
	//查询电话号码
	public long getCountForPhone(String userPhone);
	//保存注册信息
	public void sava(User user);
	//查询userId
	public int getUserId(String userPhone);
	//查询userName
	public String getUserName(String userName);
	//查询用户
	public List<User> getUser(int userId);
	//更新用户名
	public void updateUser(int userId ,String userName);
	//更新用户密码
	public void updatePass(int userId ,String userPass);
	//查询用户数
	public long getCount(int userId,String userPass);
}
