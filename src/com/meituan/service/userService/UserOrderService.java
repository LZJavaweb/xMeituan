package com.meituan.service.userService;

import java.util.List;

import com.meituan.dao.OrderDAO;
import com.meituan.dao.impl.OrderDAOImpl;
import com.meituan.domain.Order;

public class UserOrderService
{
	private OrderDAO od = new OrderDAOImpl();
	public List<Order> getOrder(int userId,int pageNo)
	{
		return od.getListByUser(userId, pageNo);
	}
	public long getTotalOrder(int userId)
	{
		return od.getTotalPageByUser(userId);
	}
}
