package com.meituan.domain;

public class User
{
	private int userId;
	private String userPhone;
	private String userPass;
	private String userName;
	public User(String userPhone, String userPass, String userName)
	{
		super();
		this.userPhone = userPhone;
		this.userPass = userPass;
		this.userName = userName;
	}
	@Override
	public String toString()
	{
		return "User [userId=" + userId + ", userPhone=" + userPhone + ", userPass=" + userPass + ", userName="
				+ userName + "]";
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getUserPhone()
	{
		return userPhone;
	}
	public void setUserPhone(String userPhone)
	{
		this.userPhone = userPhone;
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
