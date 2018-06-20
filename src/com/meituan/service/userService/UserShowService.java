package com.meituan.service.userService;

import java.util.List;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.impl.BusiDAOImpl;
import com.meituan.domain.Busi;

public class UserShowService
{
	BusiDAO bd = new BusiDAOImpl();
	public List<Busi> getBusi(int pageNo)
	{
		return bd.getAll(pageNo);
	}
	public long getTotalItem()
	{
		return bd.getTotalBusi();
	}
}
