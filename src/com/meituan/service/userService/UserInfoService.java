package com.meituan.service.userService;

import java.util.List;

import com.meituan.dao.UserDAO;
import com.meituan.dao.impl.UserDAOImpl;
import com.meituan.domain.User;

public class UserInfoService
{
	private UserDAO ud = new UserDAOImpl();
	public List<User> getUser(int userId)
	{
		List<User> userList =  ud.getUser(userId);
		for(User user:userList)
		{
			user.setUserPass("");
		}
		return userList;
	}
	public void updateUser(int userId ,String userName)
	{
		ud.updateUser(userId, userName);
	}
	public void updatePass(int userId,String userPass)
	{
		ud.updatePass(userId, userPass);
	}
	public long getCountForUser(int userId,String userPass)
	{
		return ud.getCount(userId, userPass);
	}
}
