package com.meituan.test;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.FoodDAO;
import com.meituan.dao.ItemDAO;
import com.meituan.dao.OrderDAO;
import com.meituan.dao.UserDAO;
import com.meituan.dao.impl.BusiDAOImpl;
import com.meituan.dao.impl.FoodDAOImpl;
import com.meituan.dao.impl.ItemDAOImpl;
import com.meituan.dao.impl.OrderDAOImpl;
import com.meituan.dao.impl.UserDAOImpl;
import com.meituan.domain.Busi;
import com.meituan.domain.Food;
import com.meituan.domain.Order;
import com.meituan.domain.User;

public class TestDAOImpl
{
	@Test
	public void testuser()
	{
		User user = new User("14718158227", "zhoujunliang", "良军周");
		System.out.println(user);
		UserDAO ud = new UserDAOImpl();
		ud.sava(user);
		long count = ud.getCountForUser(user.getUserPhone(), user.getUserPass());
		System.out.println(count);
		long count1 = ud.getCountForPhone(user.getUserPhone());
		System.out.println(count1);
	}

	@Test
	public void testbusi()
	{
		Busi busi = new Busi("乌兰", "1234567898", "wudalang", "武大", "烧饼店(仲恺店)");
		System.out.println(busi);
		BusiDAO bd = new BusiDAOImpl();
		//bd.sava(busi);
		long count = bd.getCountForBusi(busi.getBusiPhone(), busi.getBusiPass());
		long count1 = bd.getCountForPhone(busi.getBusiPhone());
		long count2 = bd.getCountForShopName(busi.getBusiShopName()+" ");
		System.out.println(count);
		System.out.println(count1);
		System.out.println(count2);
		System.out.println("id:"+bd.getId(busi.getBusiPhone()));
	}
	@Test
	public void testfood()
	{
		Food food = new Food(2, "烧饼", "haocidishaobing", 23.4, 97, "/WEB-INF/file/shobing2.png");
		System.out.println(food);
		FoodDAO fd = new FoodDAOImpl();
		fd.save(food);
		List<Food> list = fd.getAll(food.getBusiId());
		System.out.println(list);
	}
	@Test
	public void testItem()
	{
		ItemDAO id = new ItemDAOImpl();
		
	}
	@Test
	public void testOrder()
	{
		int userId = 1;
		int busiId = 1;
		int addrId = 1;
		double orderMoney= 2.35;
		String orderState = "未接单";
		Date date = new Date();
		Timestamp orderBegin = new Timestamp(date.getTime());
		String orderRemark = null;
		Order order = new Order(userId, busiId, addrId, orderMoney, orderState, orderBegin, orderRemark);
		OrderDAO od = new OrderDAOImpl();
		od.save(order);
		System.out.println(order);
		List<Order> busiOrderList = od.getListByBusi(busiId, 1);
		List<Order> userOrderList = od.getListByUser(userId, 1);
		long count = od.getTotalPageByBusi(busiId);
		long count1 = od.getTotalPageByUser(userId);
		System.out.println("busiOrderList:"+busiOrderList);
		System.out.println("userOrderList:"+userOrderList);
		System.out.println("count:"+count);
		System.out.println("count1:"+count1);
		od.saveReceiveTime(4, new Timestamp(date.getTime()));
		od.saveFinishTime(4, new Timestamp(date.getTime()));
		od.saveCancelTime(4, new Timestamp(date.getTime()));
	}
	@Test
	public void testEvaluation()
	{
		
	}
}
