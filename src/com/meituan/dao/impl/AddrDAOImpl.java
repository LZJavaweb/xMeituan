package com.meituan.dao.impl;

import java.util.List;

import com.meituan.dao.AddrDAO;
import com.meituan.dao.DAO;
import com.meituan.domain.Addr;

public class AddrDAOImpl extends DAO<Addr> implements AddrDAO
{

	@Override
	public void save(Addr addr)
	{
		String sql="INSERT INTO address(userId,addrName,addrPhone,addrProv,addrCity,addrReal,addrFlag) VALUES(?,?,?,?,?,?,?)";
		update(sql, addr.getUserId(),addr.getAddrName(),addr.getAddrPhone(),addr.getAddrProv(),addr.getAddrCity(),addr.getAddrReal(),addr.getAddrFlag());
	}

	@Override
	public List<Addr> getAll(int userId)
	{
		String sql = "SELECT * FROM address WHERE userId = ?";
		return getForList(sql, userId);
	}

	@Override
	public void changeAddr(Addr addr)
	{
		String sql = "UPDATE address SET addrName = ?,addrPhone = ?,addrProv= ?,addrCity= ?,addrReal= ?,addrFlag= ? WHERE addrId = ?";
		update(sql, addr.getAddrName(),addr.getAddrPhone(),addr.getAddrProv(),addr.getAddrCity(),addr.getAddrReal(),addr.getAddrFlag(),addr.getAddrId());
	}

	@Override
	public void deleteAddr(int addrId)
	{
		String sql = "DELETE FROM address WHERE addrId = ?";
		update(sql, addrId);
	}

}
