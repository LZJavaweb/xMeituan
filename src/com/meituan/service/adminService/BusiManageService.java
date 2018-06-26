package com.meituan.service.adminService;

import java.util.List;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.impl.BusiDAOImpl;
import com.meituan.domain.Busi;
import com.meituan.domain.CheckBusi;

public class BusiManageService
{
	private BusiDAO bd = new BusiDAOImpl();
	public long getCountForAllBusi(CheckBusi cb)
	{
		return bd.getCountForAllBusi(cb);
	}
	public List<Busi> getAllBusi(int pageNo,int pageSize,CheckBusi cb)
	{
		return bd.getAllBusi(pageNo, pageSize, cb);
	}
	public void updateBusi(int busiId ,int busiBan)
	{
		
	}
}
