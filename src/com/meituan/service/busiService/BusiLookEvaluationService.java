package com.meituan.service.busiService;

import java.util.List;

import com.meituan.dao.EvaluationDAO;
import com.meituan.dao.impl.EvaluationDAOImpl;
import com.meituan.domain.Evaluation;

public class BusiLookEvaluationService
{
	private EvaluationDAO ed = new EvaluationDAOImpl();
	public List<Evaluation> getEvaluation(int busiId,int pageNo)
	{
		return ed.getListByBusi(busiId, pageNo);
	}
	public long getTotalItem(int busiId)
	{
		return ed.getTotalPage(busiId);
	}
}
