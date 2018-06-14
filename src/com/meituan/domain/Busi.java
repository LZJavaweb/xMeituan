package com.meituan.domain;

public class Busi
{
	private int busiId;
	private String busiName;
	private String busiPhone;
	private String busiPass;
	private String busiAddr;
	private String busiShopName;
	private String busiLogo;
	private String busiNotice;
	private int busiFlag;
	private int busiBan;
	public Busi(int busiId, String busiName, String busiPhone, String busiPass, String busiAddr, String busiShopName)
	{
		super();
		this.busiName = busiName;
		this.busiPhone = busiPhone;
		this.busiPass = busiPass;
		this.busiAddr = busiAddr;
		this.busiShopName = busiShopName;
	}
	@Override
	public String toString()
	{
		return "Busi [busiId=" + busiId + ", busiName=" + busiName + ", busiPhone=" + busiPhone + ", busiPass="
				+ busiPass + ", busiAddr=" + busiAddr + ", busiShopName=" + busiShopName + ", busiLogo=" + busiLogo
				+ ", busiNotice=" + busiNotice + ", busiFlag=" + busiFlag + ", busiBan=" + busiBan + "]";
	}
	public int getBusiId()
	{
		return busiId;
	}
	public void setBusiId(int busiId)
	{
		this.busiId = busiId;
	}
	public String getBusiName()
	{
		return busiName;
	}
	public void setBusiName(String busiName)
	{
		this.busiName = busiName;
	}
	public String getBusiPhone()
	{
		return busiPhone;
	}
	public void setBusiPhone(String busiPhone)
	{
		this.busiPhone = busiPhone;
	}
	public String getBusiPass()
	{
		return busiPass;
	}
	public void setBusiPass(String busiPass)
	{
		this.busiPass = busiPass;
	}
	public String getBusiAddr()
	{
		return busiAddr;
	}
	public void setBusiAddr(String busiAddr)
	{
		this.busiAddr = busiAddr;
	}
	public String getBusiShopName()
	{
		return busiShopName;
	}
	public void setBusiShopName(String busiShopName)
	{
		this.busiShopName = busiShopName;
	}
	public String getBusiLogo()
	{
		return busiLogo;
	}
	public void setBusiLogo(String busiLogo)
	{
		this.busiLogo = busiLogo;
	}
	public String getBusiNotice()
	{
		return busiNotice;
	}
	public void setBusiNotice(String busiNotice)
	{
		this.busiNotice = busiNotice;
	}
	public int getBusiFlag()
	{
		return busiFlag;
	}
	public void setBusiFlag(int busiFlag)
	{
		this.busiFlag = busiFlag;
	}
	public int getBusiBan()
	{
		return busiBan;
	}
	public void setBusiBan(int busiBan)
	{
		this.busiBan = busiBan;
	}
	
}
