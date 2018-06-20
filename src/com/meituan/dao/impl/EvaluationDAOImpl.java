package com.meituan.dao.impl;

import java.util.List;

import com.meituan.dao.DAO;
import com.meituan.dao.EvaluationDAO;
import com.meituan.domain.Evaluation;

public class EvaluationDAOImpl extends DAO<Evaluation> implements EvaluationDAO
{

	@Override
	public List<Evaluation> getListByBusi(int busiId, int page)
	{
		int pageSize = 10;
		int start = (page-1)*pageSize;
		String sql = "SELECT  evaluation.* FROM evaluation,dingdan WHERE evaluation.`orderId` = dingdan.`orderId` AND dingdan.`busiId` = ? LIMIT ?,?";
		return getForList(sql, busiId,start,pageSize);
	}

	@Override
	public long getTotalPage(int busiId)
	{
		String sql = "SELECT  COUNT(evaluation.`evalId`) FROM evaluation,dingdan WHERE evaluation.`orderId` = dingdan.`orderId` AND dingdan.`busiId` = ?";
		return getForValue(sql, busiId);
	}

	@Override
	public void save(Evaluation eval)
	{
		String sql = "INSERT INTO evaluation(orderId,evalContent,evalStar) VALUES(?,?,?)";
		update(sql,eval.getOrderId(),eval.getEvalContent(),eval.getEvalStar());
	}

}
