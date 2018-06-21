package com.meituan.service.userService;

import com.meituan.dao.EvaluationDAO;
import com.meituan.dao.OrderDAO;
import com.meituan.dao.impl.EvaluationDAOImpl;
import com.meituan.dao.impl.OrderDAOImpl;
import com.meituan.domain.Evaluation;

public class UserEvaluationService
{
	private EvaluationDAO ed = new EvaluationDAOImpl();
	private OrderDAO od = new OrderDAOImpl();
	public void save(Evaluation eval)
	{
		ed.save(eval);
		od.setState(eval.getOrderId(), "已评价");
	}
}
