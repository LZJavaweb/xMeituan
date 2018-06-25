package com.meituan.dao.impl;

import com.meituan.dao.AdminDAO;
import com.meituan.dao.DAO;
import com.meituan.domain.Admin;

public class AdminDAOImpl extends DAO<Admin> implements AdminDAO
{

	@Override
	public long getCount(Admin admin)
	{
		String sql="SELECT COUNT(adminId) FROM admin WHERE adminName = ? AND adminPass = ?";
		return getForValue(sql, admin.getAdminName(),admin.getAdminPass());
	}
}
