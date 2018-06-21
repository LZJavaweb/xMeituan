<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.meituan.domain.Order" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/xMeituan/html/busiPage/detail/style/js/jquery.js"></script>
<script type="text/javascript" src="/xMeituan/html/busiPage/detail/style/js/page_common.js"></script>
<link href="/xMeituan/html/busiPage/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/xMeituan/html/busiPage/detail/style/css/index_1.css" />
	<script type="text/javascript">
		setInterval(function(){
			window.location.href = "/xMeituan/busiOrder?method=getOrder";
		},1000 * 10);
	</script>
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
					<td>下单时间</td>
					<td>订单总金额</td>
					<td>订单备注</td>
					<td>订单状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->

			<tbody id="TableData">
<%
	List<Order> orderList=(List<Order>)request.getAttribute("orderList");
	for(Order e : orderList){
		Integer orderId=e.getOrderId();
		Double orderMoney=e.getOrderMoney();
		String orderRemark=e.getOrderRemark();
		String orderState=e.getOrderState();
		Timestamp orderStateTime=e.getOrderBegin();
		String timeStr=null;
		if(orderStateTime!=null){
			Long tmpFinTime=orderStateTime.getTime();
			Date date=new Date(tmpFinTime);
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			timeStr=sdf.format(date);
		}
		String operation=null;
		String xOperation=null;
		if(orderState.equals("已接单")){
			xOperation="";
			operation="等待确认";
		}else if(orderState.equals("未接单")){
			xOperation="/xMeituan/busiOrder?method=receiveOrder&orderId="+orderId;
			operation="接单";
		}else{}
%>
				<tr height="60">
					<td><%=orderId%></td>
					<td><%=timeStr%></td>
					<td><%=orderMoney%></td>
					<td><%=orderRemark%></td>
					<td><%=orderState%></td>
					<td>			 
						<a href="<%=xOperation%>" class="FunctionButton"><%=operation%></a>	
					</td>
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
