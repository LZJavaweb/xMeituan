package com.meituan.dao;

import com.meituan.domain.User;

//�˿���Ϣ��ѯDAO
public interface UserDAO
{
	//��ѯ�˺�����
	public int getCountForUser(String userTel,String userPass);
	//��ѯ�绰����
	public int getCountForPhone(String usrTel);
	//����ע����Ϣ
	public void sava(User user);
}
