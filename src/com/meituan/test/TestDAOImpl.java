package com.meituan.test;

import org.junit.Test;

import com.meituan.dao.BusiDAO;
import com.meituan.dao.UserDAO;
import com.meituan.dao.impl.BusiDAOImpl;
import com.meituan.dao.impl.UserDAOImpl;
import com.meituan.domain.Busi;
import com.meituan.domain.User;

public class TestDAOImpl
{
	@Test
	public void testuser()
	{
		User user = new User("14718158227", "zhoujunliang", "周军良");
		System.out.println(user);
		UserDAO ud = new UserDAOImpl();
//		ud.sava(user);
		long count = ud.getCountForUser(user.getUserPhone(), user.getUserPass());
		System.out.println(count);
		long count1 = ud.getCountForPhone(user.getUserPhone());
		System.out.println(count1);
	}
	@Test
	public void testbusi()
	{
		Busi busi = new Busi("武大郎", "1234567898", "wudalang", "镇关西", "武大郎烧饼(镇关西店)");
		System.out.println(busi);
		BusiDAO bd = new BusiDAOImpl();
		bd.sava(busi);
		long count = bd.getCountForBusi(busi.getBusiPhone(), busi.getBusiPass());
		long count1 = bd.getCountForPhone(busi.getBusiPhone());
		System.out.println(count);
		System.out.println(count1);
		
	}
}
