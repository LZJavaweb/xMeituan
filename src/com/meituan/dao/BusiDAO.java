package com.meituan.dao;

import com.meituan.domain.Busi;

//�̼���Ϣ��ѯDAO
public interface BusiDAO
{
	//��ѯ�˺�����
	public long getCountForBusi(String busiPhone,String busiPass);
	//��ѯ�绰����
	public long getCountForPhone(String busiPhone);
	//����ע����Ϣ
	public void sava(Busi busi);
	//��ѯ������
	public long getCountForShopName(String busiShopName);
}
