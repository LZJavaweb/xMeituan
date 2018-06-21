package com.meituan.service.busiService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.meituan.dao.OrderDAO;
import com.meituan.dao.impl.OrderDAOImpl;
import com.meituan.domain.Order;

public class BusiOrderService
{
	private OrderDAO od = new OrderDAOImpl();
	public List<Order> getOrder(int busiId)
	{
		return od.getOrder(busiId);
	}
	public List<Order> getOldOrder(int busiId,int pageSize ,int pageNo)
	{
		return od.getOldOrder(busiId, pageSize, pageNo);
	}
	public long getTotalItem(int busiId,String state1,String state2)
	{
		return od.getTotalItemByState(busiId, state1, state2);
	}
	public void saveReceive(int orderId)
	{
		Date date = new Date();
		Timestamp receiveTime = new Timestamp(date.getTime());
		od.saveReceiveTime(orderId, receiveTime);
	}
}
