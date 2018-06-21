package com.meituan.dao;

import java.sql.Timestamp;
import java.util.List;

import com.meituan.domain.Order;

public interface OrderDAO
{
	//查询订单
	public List<Order> getListByBusi(int busiId,int page);
	//查询商家评价的总页数
//	public long getTotalPageByBusi(int busiId);
	//user查询订单
	public List<Order> getListByUser(int userId,int page);
	//查询用户评价的总页数
	public long getTotalPageByUser(int userId);
	//保存订单
	public void save(Order order);
	//保存接单时间
	public void saveReceiveTime(int orderId,Timestamp receiveTime);
	//保存完成订单时间
	public void saveFinishTime(int orderId,Timestamp finishTime);
	//保存自动取消时间
	public void saveCancelTime(int orderId,Timestamp cancelTime);
	//保存并返回orderId
	public int saveReturn(Order order);
	//获取未完成，未接单的订单
	public List<Order> getOrder(int busiId);
	//获取已完成的订单
	public List<Order> getOldOrder(int busiId ,int pageSize,int pageNo);
	//设置订单状态
	public void setState(int orderId,String State);
	//用订单状态获取订单数
	public long getTotalItemByState(int busiId,String state1,String state2);
}
