package com.meituan.dao.impl;

import java.util.List;

import com.meituan.dao.DAO;
import com.meituan.dao.ItemDAO;
import com.meituan.domain.Item;

public class ItemDAOImpl extends DAO<Item> implements ItemDAO
{

	@Override
	public List<Item> getAll(int orderId)
	{
		String sql = "SELECT * FROM item WHERE orderId = ?";
		return getForList(sql, orderId);
	}

	@Override
	public void save(Item item)
	{
		String sql = "INSERT INTO item(orderId,foodId,foodNum) VALUES(?,?,?)";
		update(sql, item.getOrderId(),item.getFoodId(),item.getFoodNum());
	}

}
