package com.meituan.domain;

import java.sql.Timestamp;

public class Order
{
	private int orderId;
	private int userId;
	private int busiId;
	private int addrId;
	private double orderMoney;
	private String orderState;
	private Timestamp orderBegin;
	private Timestamp orderReceive;
	private Timestamp orderFinish;
	private Timestamp orderCancel;
	private String orderRemark;
	@Override
	public String toString()
	{
		return "Order [orderId=" + orderId + ", userId=" + userId + ", busiId=" + busiId + ", addrId=" + addrId
				+ ", orderMoney=" + orderMoney + ", orderState=" + orderState + ", orderBegin=" + orderBegin
				+ ", orderReceive=" + orderReceive + ", orderFinish=" + orderFinish + ", orderCancel=" + orderCancel
				+ ", orderRemark=" + orderRemark + "]";
	}
	public Order()
	{
		super();
	}
	public Order(int userId, int busiId, int addrId, double orderMoney, String orderState, Timestamp orderBegin)
	{
		super();
		this.userId = userId;
		this.busiId = busiId;
		this.addrId = addrId;
		this.orderMoney = orderMoney;
		this.orderState = orderState;
		this.orderBegin = orderBegin;
	}
	public int getOrderId()
	{
		return orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public int getBusiId()
	{
		return busiId;
	}
	public void setBusiId(int busiId)
	{
		this.busiId = busiId;
	}
	public int getAddrId()
	{
		return addrId;
	}
	public void setAddrId(int addrId)
	{
		this.addrId = addrId;
	}
	public double getOrderMoney()
	{
		return orderMoney;
	}
	public void setOrderMoney(double orderMoney)
	{
		this.orderMoney = orderMoney;
	}
	public String getOrderState()
	{
		return orderState;
	}
	public void setOrderState(String orderState)
	{
		this.orderState = orderState;
	}
	public Timestamp getOrderBegin()
	{
		return orderBegin;
	}
	public void setOrderBegin(Timestamp orderBegin)
	{
		this.orderBegin = orderBegin;
	}
	public Timestamp getOrderReceive()
	{
		return orderReceive;
	}
	public void setOrderReceive(Timestamp orderReceive)
	{
		this.orderReceive = orderReceive;
	}
	public Timestamp getOrderFinish()
	{
		return orderFinish;
	}
	public void setOrderFinish(Timestamp orderFinish)
	{
		this.orderFinish = orderFinish;
	}
	public Timestamp getOrderCancel()
	{
		return orderCancel;
	}
	public void setOrderCancel(Timestamp orderCancel)
	{
		this.orderCancel = orderCancel;
	}
	public String getOrderRemark()
	{
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark)
	{
		this.orderRemark = orderRemark;
	}
	
}
