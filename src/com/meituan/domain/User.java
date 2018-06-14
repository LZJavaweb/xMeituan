package com.meituan.domain;

public class User
{
	private int userId;
	private String userTel;
	private String userPass;
	private String userName;
	@Override
	public String toString()
	{
		return "User [userId=" + userId + ", userTel=" + userTel + ", userPass=" + userPass + ", userName=" + userName
				+ "]";
	}
	public User(String userTel, String userPass, String userName)
	{
		super();
		this.userTel = userTel;
		this.userPass = userPass;
		this.userName = userName;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getUserTel()
	{
		return userTel;
	}
	public void setUserTel(String userTel)
	{
		this.userTel = userTel;
	}
	public String getUserPass()
	{
		return userPass;
	}
	public void setUserPass(String userPass)
	{
		this.userPass = userPass;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}
