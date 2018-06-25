package com.meituan.domain;

public class Admin
{
	private int adminId;
	private String adminName;
	private String adminPass;
	@Override
	public String toString()
	{
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPass=" + adminPass + "]";
	}
	public Admin()
	{
		super();
	}
	public Admin(String adminName, String adminPass)
	{
		super();
		this.adminName = adminName;
		this.adminPass = adminPass;
	}
	public int getAdminId()
	{
		return adminId;
	}
	public void setAdminId(int adminId)
	{
		this.adminId = adminId;
	}
	public String getAdminName()
	{
		return adminName;
	}
	public void setAdminName(String adminName)
	{
		this.adminName = adminName;
	}
	public String getAdminPass()
	{
		return adminPass;
	}
	public void setAdminPass(String adminPass)
	{
		this.adminPass = adminPass;
	}
}
