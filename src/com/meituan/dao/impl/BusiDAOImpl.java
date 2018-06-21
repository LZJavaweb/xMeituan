package com.meituan.dao.impl;

import java.util.List;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.DAO;
import com.meituan.domain.Busi;

public class BusiDAOImpl extends DAO<Busi> implements BusiDAO
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

	@Override
	public long getCountForShopName(String busiShopName)
	{
		String sql = "SELECT COUNT(busiId) FROM business WHERE busiShopName = ?";
		return getForValue(sql, busiShopName);
	}

	@Override
	public int getId(String busiPhone)
	{
		String sql = "SELECT busiId FROM business WHERE busiPhone= ?";
		return getForValue(sql, busiPhone);
	}

	@Override
	public List<Busi> getAll(int pageNo)
	{
		int pageSize = 10;
		int pageStart = (pageNo-1)*pageSize;
		String sql = "select * from business limit ?,?";
		return getForList(sql, pageStart,pageSize);
	}

	@Override
	public long getTotalBusi()
	{
		String sql = "select count(*) from business";
		return getForValue(sql);
	}

	@Override
	public int getBusiId(String busiPhone)
	{
		String sql="SELECT busiId FROM business WHERE busiPhone = ?";
		return getForValue(sql, busiPhone);
	}
}
