package com.meituan.test;

import org.junit.Test;

import com.meituan.dao.UserDAO;
import com.meituan.dao.impl.UserDAOImpl;
import com.meituan.domain.Busi;
import com.meituan.domain.User;

public class TestDAOImpl
{
	@Test
	public void testuser()
	{
		User user = new User("14718158227", "zhoujunliang", "�ܾ���");
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
		Busi busi = new Busi("�����", "1234567898", "wudalang", "�����", "������ձ�(�������)")
	}
}
