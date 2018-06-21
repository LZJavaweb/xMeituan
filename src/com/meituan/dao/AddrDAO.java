package com.meituan.dao;

import java.util.List;

import com.meituan.domain.Addr;

public interface AddrDAO
{
	//保存地址
	public void save(Addr addr);
	//查询地址
	public List<Addr> getAll(int userId);
	//更改地址信息
	public void changeAddr(Addr addr);
	//删除地址
	public void deleteAddr(int addrId);
}
