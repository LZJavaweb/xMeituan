package com.meituan.domain;

public class Food
{
	private int foodId;
	private int busiId;
	private String foodName;
	private String foodDesc;
	private double foodPrice;
	private int foodStock;
	private String foodPic;
	private String foodType;
	private int foodSale;

	public Food()
	{
		super();
	}

	public Food(int busiId, String foodName, String foodDesc, double foodPrice, int foodStock, String foodPic)
	{
		super();
		this.busiId = busiId;
		this.foodName = foodName;
		this.foodDesc = foodDesc;
		this.foodPrice = foodPrice;
		this.foodStock = foodStock;
		this.foodPic = foodPic;
	}

	@Override
	public String toString()
	{
		return "Food [foodId=" + foodId + ", busiId=" + busiId + ", foodName=" + foodName + ", foodDesc=" + foodDesc
				+ ", foodPrice=" + foodPrice + ", foodStock=" + foodStock + ", foodPic=" + foodPic + ", foodType="
				+ foodType + ", foodSale=" + foodSale + "]";
	}

	public int getFoodId()
	{
		return foodId;
	}

	public void setFoodId(int foodId)
	{
		this.foodId = foodId;
	}

	public int getBusiId()
	{
		return busiId;
	}

	public void setBusiId(int busiId)
	{
		this.busiId = busiId;
	}

	public String getFoodName()
	{
		return foodName;
	}

	public void setFoodName(String foodName)
	{
		this.foodName = foodName;
	}

	public String getFoodDesc()
	{
		return foodDesc;
	}

	public void setFoodDesc(String foodDesc)
	{
		this.foodDesc = foodDesc;
	}

	public double getFoodPrice()
	{
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice)
	{
		this.foodPrice = foodPrice;
	}

	public int getFoodStock()
	{
		return foodStock;
	}

	public void setFoodStock(int foodStock)
	{
		this.foodStock = foodStock;
	}

	public String getFoodPic()
	{
		return foodPic;
	}

	public void setFoodPic(String foodPic)
	{
		this.foodPic = foodPic;
	}

	public String getFoodType()
	{
		return foodType;
	}

	public void setFoodType(String foodType)
	{
		this.foodType = foodType;
	}

	public int getFoodSale()
	{
		return foodSale;
	}

	public void setFoodSale(int foodSale)
	{
		this.foodSale = foodSale;
	}

}
