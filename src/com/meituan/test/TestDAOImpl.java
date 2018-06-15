package com.meituan.test;

import java.util.List;

import org.junit.Test;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.FoodDAO;
import com.meituan.dao.UserDAO;
import com.meituan.dao.impl.BusiDAOImpl;
import com.meituan.dao.impl.FoodDAOImpl;
import com.meituan.dao.impl.UserDAOImpl;
import com.meituan.domain.Busi;
import com.meituan.domain.Food;
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
	}
	@Test
	public void testfood()
	{
		Food food = new Food(2, "烧饼", "haocidishaobing", 23.4, 97, "/WEB-INF/file/shobing2.png");
		System.out.println(food);
		FoodDAO fd = new FoodDAOImpl();
		fd.save(food);
		List list = fd.getAll(food.getBusiId());
		System.out.println(list);
	}
}
