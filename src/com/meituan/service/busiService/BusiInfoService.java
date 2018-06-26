package com.meituan.service.busiService;

import java.util.List;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.impl.BusiDAOImpl;
import com.meituan.domain.Busi;

public class BusiInfoService
{
	BusiDAO bd = new BusiDAOImpl();
	public void updatebusiLogo(int busiId ,String busiLogo)
	{
		bd.updateBusiLogo(busiId, busiLogo);
	}
	public List<Busi> getBusi(int busiId)
	{
		List<Busi> busiList = bd.getBusi(busiId);
		for(Busi busi:busiList)
		{
			busi.setBusiPass("");
		}
		return busiList;
	}
	public long getCountForBusiPass(String busiPhone,String busiPass)
	{
		return bd.getCountForBusi(busiPhone, busiPass);
	}
	public void updatePass(int busiId,String busiPass)
	{
		bd.updatePass(busiId, busiPass);
	}
	public void updateFlag(int busiId,int busiFlag)
	{
		bd.updateFlag(busiId, busiFlag);
	}
	public long getCountForBusiPhone(String busiPhone)
	{
		return bd.getCountForPhone(busiPhone);
	}
	public long getCountForBusiShopName(String busiShopName)
	{
		return bd.getCountForShopName(busiShopName);
	}
	public void updateBusi(Busi busi)
	{
		bd.updateBusi(busi);
	}
}
