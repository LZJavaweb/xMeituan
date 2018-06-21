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

	@Override
	public long getTotalPageByBusi(int busiId)
	{
		String sql = "SELECT COUNT(orderId) FROM dingdan WHERE busiId = ?";
		return getForValue(sql, busiId);
	}

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
		String sql = "UPDATE dingdan SET orderReceive=? WHERE orderId = ?";
		update(sql,receiveTime,orderId);
	}


	@Override
	public void saveCancelTime(int orderId, Timestamp cancelTime)
	{
		String sql = "UPDATE dingdan SET orderCancel=? WHERE orderId = ?";
		update(sql,cancelTime,orderId);
	}

	@Override
	public void saveFinishTime(int orderId, Timestamp finishTime)
	{
		String sql = "UPDATE dingdan SET orderFinish = ? WHERE orderId = ?";
		update(sql, finishTime,orderId);
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

}
