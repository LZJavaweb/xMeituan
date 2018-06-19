package com.meituan.domain;

public class Item
{
	private int itemId;
	private int orderId;
	private int foodId;
	private int foodNum;
	public Item()
	{
		super();
	}
	public Item(int orderId, int foodId, int foodNum)
	{
		super();
		this.orderId = orderId;
		this.foodId = foodId;
		this.foodNum = foodNum;
	}
	@Override
	public String toString()
	{
		return "Item [itemId=" + itemId + ", orderId=" + orderId + ", foodId=" + foodId + ", foodNum=" + foodNum + "]";
	}
	public int getItemId()
	{
		return itemId;
	}
	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	public int getOrderId()
	{
		return orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}
	public int getFoodId()
	{
		return foodId;
	}
	public void setFoodId(int foodId)
	{
		this.foodId = foodId;
	}
	public int getFoodNum()
	{
		return foodNum;
	}
	public void setFoodNum(int foodNum)
	{
		this.foodNum = foodNum;
	}
	
}
