package com.meituan.dao;

import java.util.List;

import com.meituan.domain.Busi;

//商家信息查询DAO
public interface BusiDAO
{
	//查询账号密码
	public long getCountForBusi(String busiPhone,String busiPass);
	//查询电话号码
	public long getCountForPhone(String busiPhone);
	//保存注册信息
	public void sava(Busi busi);
	//查询店铺名
	public long getCountForShopName(String busiShopName);
	//查ID
	public int getId(String busiPhone);
	//查询所有店家
	public List<Busi> getAll(int pageNo);
	//查询总页数
	public long getTotalBusi();
}
