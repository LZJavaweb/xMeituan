<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.meituan.domain.Food" %>
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
			<img border="0" width="13" height="13" src="/xMeituan/html/busiPage/detail/style/images/title_arrow.gif"/> 菜品列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="" method="post" target="right">
			<input type="hidden" name="method" value="search">
			<input type="text" name="keyword" title="请输入菜品名称">
			<input type="submit" value="搜索">
		</form>
	</div>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>菜品编号</td>
				<td>菜品名</td>
				<td>菜品简介</td>
                <td>价格</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
		
<%
	List<Food> foodList=(List<Food>)request.getAttribute("foodList");
	for(Food e : foodList) {
		Integer foodIndex=foodList.indexOf(e);
		Integer foodId=e.getFoodId();
		String foodName=e.getFoodName();
		String foodDesc=e.getFoodDesc();
		Double foodPrice=e.getFoodPrice();	
%>
		
			<tr class="TableDetail1">
				<td><%=foodIndex %>&nbsp;</td>
				<td><%=foodName %>&nbsp;</td>
				<td><%=foodDesc %>&nbsp;</td>
                <td><%=foodPrice %>&nbsp;</td>
				<td>
					<a href=""  class="FunctionButton">更新</a>				
					<a href="" onClick="return delConfirm();"class="FunctionButton">删除</a>				
				</td>
			</tr>

<%
	}
%>
        
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"><a href="/xMeituan/html/busiPage/detail/busiUpload.jsp">添加</a></div>
    </div> 
</div>
</body>
</html>
