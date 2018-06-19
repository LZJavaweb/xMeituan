package com.meituan.dao;

import java.util.List;

import com.meituan.domain.Evaluation;

public interface EvaluationDAO
{
	//保存评价
	public void save(Evaluation eval);
	//查询评价
	public List<Evaluation> getListByBusi(int busiId,int page);
	//查询评价条数
	public long getTotalPage(int busiId);
}
