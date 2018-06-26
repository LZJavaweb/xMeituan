package com.meituan.service.adminService;

import com.meituan.dao.AdminDAO;
import com.meituan.dao.impl.AdminDAOImpl;
import com.meituan.domain.Admin;

public class AdminLoginService
{
	private AdminDAO ad = new AdminDAOImpl();
	public long getCountForAdmin(Admin admin)
	{
		return ad.getCount(admin);
	}
}
