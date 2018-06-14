package com.meituan.dao;

import com.meituan.domain.Busi;

//商家信息查询DAO
public interface BusiDAO
{
	//查询账号密码
	public int getCountForBusi(String busiPhone,String busiPass);
	//查询电话号码
	public int getCountForPhone(String busiPhone);
	//保存注册信息
	public void sava(Busi busi);
}
