package com.meituan.service.busiService;

import java.util.List;

import com.meituan.dao.FoodDAO;
import com.meituan.dao.impl.FoodDAOImpl;
import com.meituan.domain.Food;

public class BusiShowService
{
	private FoodDAO fd = new FoodDAOImpl();
	public List<Food> getAll(int busiId)
	{
		return fd.getAll(busiId);
	}
}
