package com.meituan.dao.impl;

import java.util.List;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.DAO;
import com.meituan.domain.Busi;
import com.meituan.domain.CheckBusi;

public class BusiDAOImpl extends DAO<Busi> implements BusiDAO
{

	@Override
	public long getCountForBusi(String busiPhone, String busiPass)
	{
		String sql = "SELECT COUNT(busiId) FROM business WHERE busiPhone = ? AND busiPass = ?";
		return getForValue(sql, busiPhone, busiPass);
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
		update(sql, busi.getBusiName(), busi.getBusiPass(), busi.getBusiAddr(), busi.getBusiPhone(),
				busi.getBusiShopName());
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
		int pageStart = (pageNo - 1) * pageSize;
		String sql = "select * from business limit ?,?";
		return getForList(sql, pageStart, pageSize);
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
		String sql = "SELECT busiId FROM business WHERE busiPhone = ?";
		return getForValue(sql, busiPhone);
	}

	@Override
	public void updateBusiLogo(int busiId, String busiLogo)
	{
		String sql = "UPDATE business SET busiLogo = ? WHERE busiId =?";
		update(sql, busiLogo, busiId);
	}

	@Override
	public List<Busi> getBusi(int busiId)
	{
		String sql = "SELECT * FROM business WHERE busiId =?";
		return getForList(sql, busiId);
	}

	@Override
	public void updatePass(int busiId, String busiPass)
	{
		String sql = "UPDATE business SET busiPass = ? WHERE busiId = ?";
		update(sql, busiPass, busiId);
	}

	@Override
	public void updateFlag(int busiId, int busiFlag)
	{
		String sql = "UPDATE business SET busiFlag = ? WHERE busiId = ?";
		update(sql, busiFlag, busiId);
	}

	@Override
	public void updateBusi(Busi busi)
	{
		String sql = "UPDATE business SET busiName = ? ,busiPhone = ? ,busiAddr = ? ,busiShopName = ? , "
				+ "busiNotice = ? WHERE busiId = ?";
		update(sql, busi.getBusiName(), busi.getBusiPhone(), busi.getBusiAddr(), busi.getBusiShopName(),
				busi.getBusiNotice(), busi.getBusiId());
	}

	@Override
	public long getCountForAllBusi(CheckBusi cb)
	{
		String sql = "SELECT COUNT(busiId) FROM business WHERE busiName LIKE ? AND busiPhone LIKE ? AND busiPass LIKE ?\r\n"
				+ "AND busiAddr LIKE ? AND busiShopName LIKE ? AND busiFlag = ? AND busiBan = ?";
		return getForValue(sql, cb.getBusiName(), cb.getBusiPhone(), cb.getBusiPass(), cb.getBusiAddr(),
				cb.getBusiShopName(), cb.getBusiFlag(), cb.getBusiBan());
	}

	@Override
	public List<Busi> getAllBusi(int pageNo, int pageSize, CheckBusi cb)
	{
		int pageStart = (pageNo - 1) * pageSize;
		String sql = "SELECT * FROM business WHERE busiName LIKE ? AND busiPhone LIKE ? AND busiPass LIKE ?\r\n"
				+ "AND busiAddr LIKE ? AND busiShopName LIKE ? AND busiFlag = ? AND busiBan = ? LIMIT ?,?";
		return getForList(sql, cb.getBusiName(), cb.getBusiPhone(), cb.getBusiPass(), cb.getBusiAddr(),
				cb.getBusiShopName(), cb.getBusiFlag(), cb.getBusiBan(), pageStart, pageSize);
	}

	@Override
	public void updateBusi(int busiId, int busiBan)
	{
		String sql = "UPDATE business SET busiBan = ? WHERE busiId = ?";
		update(sql, busiBan, busiId);
	}
}
