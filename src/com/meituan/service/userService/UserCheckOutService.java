package com.meituan.service.userService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.meituan.dao.ItemDAO;
import com.meituan.dao.OrderDAO;
import com.meituan.dao.impl.ItemDAOImpl;
import com.meituan.dao.impl.OrderDAOImpl;
import com.meituan.domain.Cart;
import com.meituan.domain.Item;
import com.meituan.domain.Order;

public class UserCheckOutService
{
	OrderDAO od = new OrderDAOImpl();
	ItemDAO id = new ItemDAOImpl();
	public void saveItem(List<Item> itemList)
	{
		for(Item item:itemList)
		{
			id.save(item);
		}
	}
	public int saveOrder(Order order)
	{
		return od.saveReturn(order);
	}
	@SuppressWarnings("null")
	public void save(List<Cart> cartList,int userId,int addrId, int busiId,String orderRemark)
	{
		int totalPrice = 0;
		int foodId;
		int foodNum;
		int foodPrice;
		List<Item> itemList = new ArrayList<Item>();
		Item item = null;
		Order order = null;
		if(cartList!=null)
		{
			for(Cart cart:cartList)
			{
				
				foodId = cart.getFoodId();
				foodNum = cart.getFoodNum();
				item= new Item(foodId, foodNum);
				itemList.add(item);
				foodPrice = cart.getFoodPrice();
				totalPrice +=foodPrice;
				foodId = 0;
				foodNum = 0;
				foodPrice = 0;
			}
		}
		Date date = new Date();
		Timestamp orderBegin = new Timestamp(date.getTime());
		order = new Order(userId, busiId, addrId, totalPrice, "未接单", orderBegin, orderRemark);
		int orderId = saveOrder(order);
		for(Item it:itemList)
		{
			it.setOrderId(orderId);
		}
		saveItem(itemList);
	}
}
