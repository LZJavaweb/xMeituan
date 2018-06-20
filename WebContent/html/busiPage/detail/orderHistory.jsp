<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.meituan.domain.Order" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->	
<title>无线点餐平台</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="style/js/jquery.js"></script>
<script type="text/javascript" src="style/js/page_common.js"></script>
<link href="style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="style/css/index_1.css" />
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="style/images/title_arrow.gif" /> 餐厅订单列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
	</div>

	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>订单编号</td>
					<td>顾客名</td>
					<td>下单日期</td>
					<td>总金额</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
			
<%
	List<Order> orderList=(List<Order>)request.getAttribute("?");
	for (Order e : orderList){
		Integer orderId=e.getOrderId();
		Integer userId=e.getUserId();
		Timestamp orderFinish=e.getOrderFinish();
		Double orderMoney=e.getOrderMoney();
		Long tmpFinTime=orderFinish.getTime();
		Date date=new Date(tmpFinTime);
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		String timeStr=sdf.format(date);
%>
			
			 		<tr height="60">
				 		<td><%=orderId %></td>
				 		<td><%=userId %></td>
				 		<td><%=timeStr %></td>
				 		<td><%=orderMoney %></td>	 						 		
			 		</tr>
			 	
<%
	}
%>
			 	
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
		</div>
	</div>
</body>
</html>
