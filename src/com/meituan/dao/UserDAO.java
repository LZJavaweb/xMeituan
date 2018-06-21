package com.meituan.dao;

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
}
