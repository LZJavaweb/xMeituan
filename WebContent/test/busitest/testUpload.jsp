<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/xMeituan/busiPageForUpload" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<%String busiPhone = (String)session.getAttribute("busiPhone"); %>
				<%=busiPhone %>
			</tr>
			
			<tr class="foodName">
				<td>FoodName:</td>
				<td><input type="text" name="foodName1" /></td>
			</tr>
			<tr class="foodDesc">
				<td>FoodDesc:</td>
				<td><input type="text" name="foodDesc1" /></td>
			</tr>
			<tr class="foodPrice">
				<td>FoodPrice:</td>
				<td><input type="text" name="foodPrice1" /></td>
			</tr>
			<tr class="foodStock">
				<td>FoodStock:</td>
				<td><input type="text" name="foodStock1" /></td>
			</tr>
			<tr class="foodPic">
				<td>FoodPic:</td>
				<td><input type="file" name="foodPic1" /></td>
			</tr>

			<tr>
				<td><input type="submit" id="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
	<a href="/xMeituan/test/busitest/testBusiPageShow.jsp">to show</a>
</body>
</html>