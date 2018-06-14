package com.meituan.dao;

import com.meituan.domain.User;

//顾客信息查询DAO
public interface UserDAO
{
	//查询账号密码
	public int getCountForUser(String userTel,String userPass);
	//查询电话号码
	public int getCountForPhone(String usrTel);
	//保存注册信息
	public void sava(User user);
}
