<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.meituan.domain.Evaluation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>查看评价</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../../../css/bootstrap-4.1.1.min.css">
        <script src="../../../js/jquery-2.2.4.js"></script>
        <script src="../../../js/jquery.form.js"></script>
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
					src="style/images/title_arrow.gif" /> 顾客评价
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
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>John</td>
							<td>Doe</td>
						</tr>
						</tbody>
					</table>
				</div>
			</div>

			<div class="container d-flex justify-content-center">
				<div class="col-6 col align-self-center">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#">Previous</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">Next</a></li>
					</ul>
				</div>
			</div>
		</div>
        
        <script src="../../../js/popper-1.14.3.min.js"></script>
        <script src="../../../js/bootstrap-4.1.1.min.js"></script>
    </body>
</html>
