package com.meituan.dao;

import com.meituan.domain.Busi;

//�̼���Ϣ��ѯDAO
public interface BusiDAO
{
	//��ѯ�˺�����
	public int getCountForBusi(String busiPhone,String busiPass);
	//��ѯ�绰����
	public int getCountForPhone(String busiPhone);
	//����ע����Ϣ
	public void sava(Busi busi);
}
