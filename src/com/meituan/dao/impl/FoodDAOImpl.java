package com.meituan.dao.impl;

import java.util.List;

import com.meituan.dao.DAO;
import com.meituan.dao.FoodDAO;
import com.meituan.domain.Food;

public class FoodDAOImpl extends DAO<Food> implements FoodDAO
{

	@Override
	public void save(Food food)
	{
		String sql="INSERT INTO food(busiId,foodName,foodDesc,foodPrice,foodStock,foodPic) VALUES(?,?,?,?,?,?)";
		update(sql, food.getBusiId(),food.getFoodName(),food.getFoodDesc(),
				food.getFoodPrice(),food.getFoodStock(),food.getFoodPic());
		
	}

	@Override
	public List<Food> getAll(int busiId)
	{
		String sql="SELECT foodId,busiId,foodName,foodDesc,foodPrice,foodStock,foodPic FROM food WHERE busiId = ?";
		return getForList(sql, busiId);
	}

}
