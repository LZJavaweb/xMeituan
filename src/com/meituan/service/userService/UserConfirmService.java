package com.meituan.service.userService;

import java.sql.Timestamp;
import java.util.Date;

import com.meituan.dao.OrderDAO;
import com.meituan.dao.impl.OrderDAOImpl;

public class UserConfirmService
{
	private OrderDAO od  = new OrderDAOImpl();
	public void saveFinish(int orderId)
	{
		Date date = new Date();
		Timestamp finishTime = new Timestamp(date.getTime());
		od.saveFinishTime(orderId, finishTime);
	}
}
