package com.meituan.servlet.userServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.domain.Evaluation;
import com.meituan.service.userService.UserEvaluationService;

public class UserEvaluation extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}
	private UserEvaluationService userEvaluationService = new UserEvaluationService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String evaluation = request.getParameter("evaluation");
		String orderIdStr = request.getParameter("orderId");
		String gradeStr = request.getParameter("grade");
		int orderId = Integer.parseInt(orderIdStr);
		int grade = Integer.parseInt(gradeStr);
		Evaluation eval = new Evaluation(orderId, evaluation, grade);
		System.out.println("userEval:eval:"+eval);
		userEvaluationService.save(eval);
		response.sendRedirect("/xMeituan/userOrder");
	}
}
