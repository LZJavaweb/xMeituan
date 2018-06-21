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
		int pageSize = 10;
		int start = (page-1)*pageSize;
		String sql = "SELECT * FROM dingdan WHERE busiId = ? ORDER BY orderId DESC LIMIT ?,?";
		return getForList(sql, busiId,start,pageSize);
	}

//	@Override
//	public long getTotalPageByBusi(int busiId)
//	{
//		String sql = "SELECT COUNT(orderId) FROM dingdan WHERE busiId = ?";
//		return getForValue(sql, busiId);
//	}

	@Override
	public List<Order> getListByUser(int userId, int page)
	{
		int pageSize = 10;
		int start = (page-1)*pageSize;
		String sql = "SELECT * FROM dingdan WHERE userId = ? ORDER BY orderId DESC LIMIT ?,?";
		return getForList(sql, userId,start,pageSize);
	}

	@Override
	public long getTotalPageByUser(int userId)
	{
		String sql = "SELECT COUNT(orderId) FROM dingdan WHERE userId = ?";
		return getForValue(sql, userId);
	}

	@Override
	public void save(Order order)
	{
		String sql = "INSERT INTO dingdan(userId,busiId,addrId,orderMoney,"
				+ "orderState,orderBegin,orderRemark) VALUES(?,?,?,?,?,?,?)";
		update(sql, order.getUserId(),order.getBusiId(),order.getAddrId(),
				order.getOrderMoney(),order.getOrderState(),order.getOrderBegin(),
				order.getOrderRemark());
	}

	@Override
	public void saveReceiveTime(int orderId, Timestamp receiveTime)
	{
		String sql = "UPDATE dingdan SET orderReceive=?,orderState=? WHERE orderId = ?";
		update(sql,receiveTime,"已接单",orderId);
	}


	@Override
	public void saveCancelTime(int orderId, Timestamp cancelTime)
	{
		String sql = "UPDATE dingdan SET orderCancel=?,orderState= ? WHERE orderId = ?";
		update(sql,cancelTime,"已取消",orderId);
	}

	@Override
	public void saveFinishTime(int orderId, Timestamp finishTime)
	{
		String sql = "UPDATE dingdan SET orderFinish= ?,orderState = ? WHERE orderId = ?";
		update(sql, finishTime,"已完成",orderId);
	}

	@Override
	public int saveReturn(Order order)
	{
		String sql = "INSERT INTO dingdan(userId,busiId,addrId,orderMoney,"
				+ "orderState,orderBegin,orderRemark) VALUES(?,?,?,?,?,?,?)";
		long id = insert(sql,order.getUserId(),order.getBusiId(),order.getAddrId(),
				order.getOrderMoney(),order.getOrderState(),order.getOrderBegin(),
				order.getOrderRemark());
		int orderId = new Long(id).intValue();
		return orderId;
	}

	@Override
	public List<Order> getOrder(int busiId)
	{
		String sql = "SELECT * FROM dingdan WHERE busiId = ? AND (OrderState = ? OR OrderState = ?) ORDER BY orderId DESC ";
		return getForList(sql, busiId,"已接单","未接单");
	}

	@Override
	public List<Order> getOldOrder(int busiId, int pageSize, int pageNo)
	{
		int start = (pageNo-1)*pageSize;
		String sql = "SELECT * FROM dingdan WHERE busiId = ? AND (OrderState = ? OR OrderState = ?) ORDER BY orderId DESC LIMIT ?,?";
		return getForList(sql, busiId,"已完成","已评价",start,pageSize);
	}

	@Override
	public void setState(int orderId, String State)
	{
		String sql= "UPDATE dingdan	SET orderState = ? WHERE orderId= ?";
		update(sql, State,orderId);
	}

	@Override
	public long getTotalItemByState(int busiId, String state1, String state2)
	{
		String sql = "SELECT COUNT(orderId) FROM dingdan WHERE busiId = ? AND (orderState = ? OR orderState = ?)";
		return getForValue(sql, busiId,state1,state2);
	}

}
