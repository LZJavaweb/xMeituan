package com.meituan.dao.impl;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.DAO;
import com.meituan.domain.Busi;

public class BuaiDAOImpl extends DAO<Busi> implements BusiDAO
{

	@Override
	public long getCountForBusi(String busiPhone, String busiPass)
	{
		String sql = "SELECT COUNT(busiId) FROM business WHERE busiPhone = ? AND busiPass = ?";
		return getForValue(sql, busiPhone,busiPass);
	}

	@Override
	public long getCountForPhone(String busiPhone)
	{
		String sql = "SELECT COUNT(busiId) FROM business WHERE busiPhone = ?";
		return getForValue(sql, busiPhone);
	}

	@Override
	public void sava(Busi busi)
	{
		String sql = "INSERT INTO business(busiName,busiPass,busiAddr,busiPhone,busiShopName) VALUES (?,?,?,?,?)";
		update(sql, busi.getBusiName(),busi.getBusiPass(),busi.getBusiAddr(),busi.getBusiPhone(),busi.getBusiShopName());
	}
}
