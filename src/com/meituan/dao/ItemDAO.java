package com.meituan.dao;

import java.util.List;

import com.meituan.domain.Item;

public interface ItemDAO
{
	//查询订单项
	public List<Item> getAll(int orderId);
	//保存订单项
	public void save(Item item);
}
