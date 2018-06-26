package com.meituan.domain;

public class CheckBusi
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
	@Override
	public String toString()
	{
		return "CheckBusi [busiId=" + busiId + ", busiName=" + busiName + ", busiPhone=" + busiPhone + ", busiPass="
				+ busiPass + ", busiAddr=" + busiAddr + ", busiShopName=" + busiShopName + ", busiLogo=" + busiLogo
				+ ", busiNotice=" + busiNotice + ", busiFlag=" + busiFlag + ", busiBan=" + busiBan + "]";
	}
	public CheckBusi()
	{
		super();
	}
	public CheckBusi(String busiName, String busiPhone, String busiPass, String busiAddr, String busiShopName,
			int busiFlag, int busiBan)
	{
		super();
		this.busiName = busiName;
		this.busiPhone = busiPhone;
		this.busiPass = busiPass;
		this.busiAddr = busiAddr;
		this.busiShopName = busiShopName;
		this.busiFlag = busiFlag;
		this.busiBan = busiBan;
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
		if(busiName==null)
			busiName = "%%";
		else
			busiName = "%"+busiName+"%";
		return busiName;
	}
	public void setBusiName(String busiName)
	{
		this.busiName = busiName;
	}
	public String getBusiPhone()
	{
		if(busiPhone==null)
			busiPhone = "%%";
		else
			busiPhone = "%"+busiPhone+"%";
		return busiPhone;
	}
	public void setBusiPhone(String busiPhone)
	{
		this.busiPhone = busiPhone;
	}
	public String getBusiPass()
	{
		if(busiPass==null)
			busiPass = "%%";
		else
			busiPass = "%"+busiPass+"%";
		return busiPass;
	}
	public void setBusiPass(String busiPass)
	{
		this.busiPass = busiPass;
	}
	public String getBusiAddr()
	{
		if(busiAddr==null)
			busiAddr = "%%";
		else
			busiAddr = "%"+busiAddr+"%";
		return busiAddr;
	}
	public void setBusiAddr(String busiAddr)
	{
		this.busiAddr = busiAddr;
	}
	public String getBusiShopName()
	{
		if(busiShopName==null)
			busiShopName = "%%";
		else
			busiShopName = "%"+busiShopName+"%";
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
