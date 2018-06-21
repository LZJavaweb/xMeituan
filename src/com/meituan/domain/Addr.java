package com.meituan.domain;

public class Addr
{
	private int addrId;
	private int userId;
	private String addrName;
	private String addrPhone;
	private String addrProv;
	private String addrCity;
	private String addrReal;
	private int addrFlag;
	@Override
	public String toString()
	{
		return "Addr [addrId=" + addrId + ", userId=" + userId + ", addrName=" + addrName + ", addrPhone=" + addrPhone
				+ ", addrProv=" + addrProv + ", addrCity=" + addrCity + ", addrReal=" + addrReal + ", addrFlag="
				+ addrFlag + "]";
	}
	public Addr()
	{
		super();
	}
	public Addr(int userId, String addrName, String addrPhone, String addrProv, String addrCity, String addrReal,
			int addrFlag)
	{
		super();
		this.userId = userId;
		this.addrName = addrName;
		this.addrPhone = addrPhone;
		this.addrProv = addrProv;
		this.addrCity = addrCity;
		this.addrReal = addrReal;
		this.addrFlag = addrFlag;
	}
	public int getAddrId()
	{
		return addrId;
	}
	public void setAddrId(int addrId)
	{
		this.addrId = addrId;
	}
	public int getUserId()
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getAddrName()
	{
		return addrName;
	}
	public void setAddrName(String addrName)
	{
		this.addrName = addrName;
	}
	public String getAddrPhone()
	{
		return addrPhone;
	}
	public void setAddrPhone(String addrPhone)
	{
		this.addrPhone = addrPhone;
	}
	public String getAddrProv()
	{
		return addrProv;
	}
	public void setAddrProv(String addrProv)
	{
		this.addrProv = addrProv;
	}
	public String getAddrCity()
	{
		return addrCity;
	}
	public void setAddrCity(String addrCity)
	{
		this.addrCity = addrCity;
	}
	public String getAddrReal()
	{
		return addrReal;
	}
	public void setAddrReal(String addrReal)
	{
		this.addrReal = addrReal;
	}
	public int getAddrFlag()
	{
		return addrFlag;
	}
	public void setAddrFlag(int addrFlag)
	{
		this.addrFlag = addrFlag;
	}
	
	
}
