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
<script type="text/javascript" src="/xMeituan/html/busiPage/detail/style/js/jquery.js"></script>
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
					src="/xMeituan/html/busiPage/detail/style/images/title_arrow.gif" /> 餐厅订单列表
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
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
			
<%
	List<Order> orderList=(List<Order>)request.getAttribute("orderList");
	Integer curPage=(Integer)request.getAttribute("pageNo");
	Long totalPages=(Long)request.getAttribute("totalPage");
	Long lastPage=Long.parseLong("1");
	for(Order e : orderList){
		Integer orderId=e.getOrderId();
		Double orderMoney=e.getOrderMoney();
		String orderRemark=e.getOrderRemark();
		String orderState=e.getOrderState();
		Timestamp orderStateTime=null;
		if(e.getOrderCancel()!=null){
			orderStateTime=e.getOrderCancel();
		}else if(e.getOrderFinish()!=null){
			orderStateTime=e.getOrderFinish();
		}else{}
		String timeStr=null;
		if(orderStateTime!=null){
			Long tmpFinTime=orderStateTime.getTime();
			Date date=new Date(tmpFinTime);
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			timeStr=sdf.format(date);
		}
%>
			
			 		<tr height="60">
				 		<td><%=orderId %></td>
				 		<td><%=timeStr %></td>
				 		<td><%=orderMoney %></td>
				 		<td><%=orderRemark %></td>
						<td><%=orderState %></td>						 		
			 		</tr>
			 	
<%
	}
%>
			 	
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
<div class="TurnPage">
  <a href="/xMeituan/busiOrder?method=getOldOrder&pageNo=1">
  <span class="Prev"><i></i>首页</span>
  </a>
  <%
  for (int i=1;i!=totalPages+1;++i){
  %>
  <a href="/xMeituan/busiOrder?method=getOldOrder&pageNo=<%=i%>"><span class="PNumber"><%=i%></span></a>
  <%
    }
  %>
  <a href="/xMeituan/busiOrder?method=getOldOrder&pageNo=<%=totalPages%>">
  <span class="Next">最后一页<i></i></span>
  </a>
 </div>
 </div>
		</div>
</body>
</html>
