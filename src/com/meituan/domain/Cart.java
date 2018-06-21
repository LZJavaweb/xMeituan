package com.meituan.domain;

public class Cart
{
	private int foodId;
	private int foodNum;
	private double foodPrice;
	@Override
	public String toString()
	{
		return "Cart [foodId=" + foodId + ", foodNum=" + foodNum + ", foodPrice=" + foodPrice + "]";
	}
	public Cart(int foodId, int foodNum, double foodPrice)
	{
		super();
		this.foodId = foodId;
		this.foodNum = foodNum;
		this.foodPrice = foodPrice;
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
	public double getFoodPrice()
	{
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice)
	{
		this.foodPrice = foodPrice;
	}
	

}
