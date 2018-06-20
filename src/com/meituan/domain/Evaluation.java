package com.meituan.domain;

public class Evaluation
{
	private int evalId;
	private int orderId;
	private String evalContent;
	private int evalStar;
	@Override
	public String toString()
	{
		return "Evaluation [evalId=" + evalId + ", orderId=" + orderId + ", evalContent=" + evalContent + ", evalStar="
				+ evalStar + "]\n";
	}
	public Evaluation()
	{
		super();
	}
	public Evaluation(int orderId, String evalContent, int evalStar)
	{
		super();
		this.orderId = orderId;
		this.evalContent = evalContent;
		this.evalStar = evalStar;
	}
	public int getEvalId()
	{
		return evalId;
	}
	public void setEvalId(int evalId)
	{
		this.evalId = evalId;
	}
	public int getOrderId()
	{
		return orderId;
	}
	public void setOrderId(int orderId)
	{
		this.orderId = orderId;
	}
	public String getEvalContent()
	{
		return evalContent;
	}
	public void setEvalContent(String evalContent)
	{
		this.evalContent = evalContent;
	}
	public int getEvalStar()
	{
		return evalStar;
	}
	public void setEvalStar(int evalStar)
	{
		this.evalStar = evalStar;
	}
	
}
