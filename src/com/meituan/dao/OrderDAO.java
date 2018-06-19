package com.meituan.dao;

import java.sql.Timestamp;
import java.util.List;

import com.meituan.domain.Order;

public interface OrderDAO
{
	//查询订单
	public List<Order> getListByBusi(int busiId,int page);
	//查询商家评价的总页数
	public long getTotalPageByBusi(int busiId);
	//user查询订单
	public List<Order> getListByUser(int userId,int page);
	//查询用户评价的总页数
	public long getTotalPageByUser(int userId);
	//保存订单
	public void save(Order order);
	//保存接单时间
	public void saveReceiveTime(Timestamp receiveTime);
	//保存完成订单时间
	public void saveEndTime(Timestamp endTime);
	//保存自动取消时间
	public void saveCancelTime(Timestamp cancelTime);
}
