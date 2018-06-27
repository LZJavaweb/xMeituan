package com.meituan.servlet.busiServlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meituan.domain.Evaluation;
import com.meituan.service.busiService.BusiLookEvaluationService;

public class BusiLookEvaluation extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String methodName = request.getParameter("method");
		try
		{
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	private BusiLookEvaluationService busiLookEvaluationService = new BusiLookEvaluationService();
	protected void getEvaluation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int busiId = (int) request.getSession().getAttribute("busiId");
		String pageNoStr = request.getParameter("pageNo");
		int pageNo = 1;
		try
		{
			if(pageNoStr!=null)
				pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e)
		{
			System.out.println("userLookEvaluation:转换出错");
			e.printStackTrace();
		}
		List<Evaluation> evaluationList = busiLookEvaluationService.getEvaluation(busiId, pageNo);
		long totalItem = busiLookEvaluationService.getTotalItem(busiId);
		long totalPage=1;
		int pageSize = 10;
		if(totalItem%pageSize==0)
		{
			totalPage = totalItem/pageSize;
		}
		else 
		{
			totalPage = totalItem/pageSize+1;
		}
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("evaluationList", evaluationList);
		request.getRequestDispatcher("/html/busiPage/detail/busiLookEvaluation.jsp").forward(request, response);
	}
}
