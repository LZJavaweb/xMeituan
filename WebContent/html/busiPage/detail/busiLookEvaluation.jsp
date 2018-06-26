<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.meituan.domain.Evaluation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>查看评价</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="/xMeituan/css/bootstrap-4.1.1.min.css">
        <script src="/xMeituan/js/jquery-2.2.4.js"></script>
        <script src="/xMeituan/js/jquery.form.js"></script>
        <script type="text/javascript" src="/xMeituan/html/busiPage/detail/style/js/page_common.js"></script>
        <link href="/xMeituan/html/busiPage/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="/xMeituan/html/busiPage/detail/style/css/index_1.css" />
    </head>
    <body>
		<!-- 页面标题 -->
		<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="/xMeituan/html/busiPage/detail/style/images/title_arrow.gif" /> 顾客评价
			</div>
		</div>
		<div id="TitleArea_End"></div>
		</div>
		
		<div class="container justify-content-center">
			<div class="container d-flex justify-content-center">
				<div class="col-6 col align-self-center">
					<table class="table">
						<thead>
						<tr>
							<th>订单编号</th>
							<th>评价内容</th>
							<th>评价分数</th>
						</tr>
						</thead>
						<tbody>
<%
	List<Evaluation> evalsList=(List<Evaluation>)request.getAttribute("evaluationList");
	if(evalsList!=null){
		for(Evaluation e : evalsList){
			Integer orderId=e.getOrderId();
			String evalContent=e.getEvalContent();
			Integer evalStar=e.getEvalStar();
%>
						<tr>
							<td><%=orderId%></td>
							<td><%=evalContent%></td>
							<td><%=evalStar%></td>
						</tr>
<%
		}
	}
%>
						</tbody>
					</table>
				</div>
			</div>

			<div class="container d-flex justify-content-center">
				<div class="col-6 col align-self-center">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="/xMeituan/busiLookEvaluation?page=1">首页</a></li>
<%
	Integer curPage=(Integer)request.getAttribute("pageNo");
	Long totalPages=(Long)request.getAttribute("totalPage");
	for(int i=1;i!=totalPages+1;++i){
		if(i==curPage){
%>
						<li class="page-item active"><a class="page-link" href="/xMeituan/busiLookEvaluation?page=<%=i%>"><%=i%></a></li>
<%
		}else{
%>
						<li class="page-item"><a class="page-link" href="/xMeituan/busiLookEvaluation?page=<%=i%>"><%=i%></a></li>
<%						
		}
	}
%>
						<li class="page-item"><a class="page-link" href="/xMeituan/busiLookEvaluation?page=<%=totalPages%>">最后一页</a></li>
					</ul>
				</div>
			</div>
		</div>
        
        <script src="/xMeituan/js/popper-1.14.3.min.js"></script>
        <script src="/xMeituan/js/bootstrap-4.1.1.min.js"></script>
    </body>
</html>
