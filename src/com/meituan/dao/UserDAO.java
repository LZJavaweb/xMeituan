package com.meituan.dao;

import com.meituan.domain.User;

//�˿���Ϣ��ѯDAO
public interface UserDAO
{
	//��ѯ�˺�����
	public long getCountForUser(String userPhone,String userPass);
	//��ѯ�绰����
	public long getCountForPhone(String userPhone);
	//����ע����Ϣ
	public void sava(User user);
}
