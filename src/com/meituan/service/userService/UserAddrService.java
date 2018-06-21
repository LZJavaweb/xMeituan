package com.meituan.service.userService;

import java.util.List;

import com.meituan.dao.AddrDAO;
import com.meituan.dao.impl.AddrDAOImpl;
import com.meituan.domain.Addr;

public class UserAddrService
{
	private AddrDAO ad = new AddrDAOImpl();
	public List<Addr> getAddr(int userId)
	{
		return ad.getAll(userId);
	}
}
