package com.meituan.dao;

import com.meituan.domain.Busi;

//�̼���Ϣ��ѯDAO
public interface BusiDAO
{
	//��ѯ�˺�����
	public int getCountForBusi(String busiTel,String busiPass);
	//��ѯ�绰����
	public int getCountForPhone(String busiTel);
	//����ע����Ϣ
	public void sava(Busi busi);
}
