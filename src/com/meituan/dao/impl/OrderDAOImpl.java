package com.meituan.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import com.meituan.dao.DAO;
import com.meituan.dao.OrderDAO;
import com.meituan.domain.Order;

public class OrderDAOImpl extends DAO<Order> implements OrderDAO
{

	@Override
	public List<Order> getListByBusi(int busiId, int page)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotalPageByBusi(int busiId)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> getListByUser(int userId, int page)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getTotalPageByUser(int userId)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(Order order)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveReceiveTime(Timestamp receiveTime)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveEndTime(Timestamp endTime)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void saveCancelTime(Timestamp cancelTime)
	{
		// TODO Auto-generated method stub
		
	}


}
