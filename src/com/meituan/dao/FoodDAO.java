package com.meituan.dao;

import java.util.List;

import com.meituan.domain.Food;

public interface FoodDAO
{
	//保存商品信息
	public void save(Food food);
	//获取对应店家的所有商品信息
	public List<Food> getAll(int busiId);
	//更新food
	public void updateFood(Food food);
	//删除food
	public void deleteFood(int foodId);
	//用foodId获取foodList
	public List<Food> getFood(int foodId);
}
