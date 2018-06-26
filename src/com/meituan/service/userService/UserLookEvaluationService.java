package com.meituan.service.userService;

import java.util.List;

import com.meituan.dao.EvaluationDAO;
import com.meituan.dao.impl.EvaluationDAOImpl;
import com.meituan.domain.Evaluation;

public class UserLookEvaluationService
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
