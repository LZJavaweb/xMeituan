﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<img border="0" width="13" height="13" src="/xMeituan/html/busiPage/detail/style/images/title_arrow.gif"/> 更新新菜品
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="/xMeituan/busiUpdateFood?method=updateFood" method="post">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="/xMeituan/html/busiPage/detail/style/images/item_point.gif"> 菜品信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">

					<table cellpadding="0" cellspacing="0" class="mainForm">
<%
					List<Food> foodList=(List<Food>)request.getAttribute("food");
					//Food e=(Food)request.getAttribute("food");
					String oldFoodPic=null;
					for(Food e : foodList){
						String foodName=e.getFoodName();
						Double foodPrice=e.getFoodPrice();
						String foodDesc=e.getFoodDesc();
						oldFoodPic=e.getFoodPic();
						Integer foodId=e.getFoodId();
%>
						<tr>
							<td width="80px">菜名</td>
							<td><input type="text" name="foodName" class="InputStyle" value="<%=foodName %>"/> *</td>
						</tr>
						<tr>
							<td>价格</td>
							<td><input type="text" name="foodPrice" class="InputStyle" value="<%=foodPrice %>"/> *</td>
						</tr>
						
						<tr>
							<td>简介</td>
							<td><textarea name="foodDesc" class="TextareaStyle"><%=foodDesc %></textarea></td>
						</tr>
<%
					}
%>
					</table>
				</div>
            </div>
        </div>
		
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
			<input type="submit" value="修改" class="FunctionButtonInput">
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
	<br>
	<form action="/xMeituan/busiUpdateFood?method=updatePic" method="post" enctype="multipart/form-data">
		<input name="oldFoodPic" type="hidden" value="<%=oldFoodPic%>">
		<input name="foodPic" type="file">
		<input type="submit" value="上传图片" class="FunctionButtonInput">
	</form>
</div>
</body>
</html>
