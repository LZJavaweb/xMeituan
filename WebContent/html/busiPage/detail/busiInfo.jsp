<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.meituan.domain.Busi" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="/xMeituan/html/busiPage/detail/style/js/page_common.js"></script>
<link href="/xMeituan/html/busiPage/detail/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/xMeituan/html/busiPage/detail/style/css/index_1.css" />
<link rel="stylesheet" href="/xMeituan/css/bootstrap-4.1.1.min.css">
<script src="/xMeituan/js/jquery-2.2.4.js"></script>
<script src="/xMeituan/js/jquery.form.js"></script>
</head>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="/xMeituan/html/busiPage/detail/style/images/title_arrow.gif"/> 店铺信息
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

	<div class="container d-flex justify-content-center" id="info">
		<div class="col-4 col align-self-center">
			<form role="form" id="infoForm" action="/xMeituan/busiInfo?method=updateBusi" method="post" target="right">
<%
	List<Busi> busi=(List<Busi>)request.getAttribute("busi");
	String oldBusiLogo=null;
	Integer busiFlag=null;
	if(busi!=null){
		for(Busi e : busi){
			oldBusiLogo=e.getBusiLogo();
			busiFlag=e.getBusiFlag();
			String busiName=e.getBusiName();
			String busiPhone=e.getBusiPhone();
			String busiAddr=e.getBusiAddr();
			String busiShopName=e.getBusiShopName();
			String busiNotice=e.getBusiNotice();
%>
				<div class="form-group">
					<label>姓名：</label>
					<input name="busiName" id="busiName" type="text" class="form-control" value="<%=busiName %>" disabled>
				</div>
				<div class="form-group">
					<label>电话：</label>
					<input name="busiPhone" id="busiPhone" type="text" class="form-control" value="<%=busiPhone %>" disabled>
				</div>
				<div class="form-group">
					<label>地址：</label>
					<input name="busiAddr" id="busiAddr" type="text" class="form-control" value="<%=busiAddr %>" disabled>
				</div>
				<div class="form-group">
					<label>店铺名：</label>
					<input name="busiShopName" id="busiShopName" type="text" class="form-control" value="<%=busiShopName %>" disabled>
				</div>
				<div class="form-group">
					<label>商家公告：</label>
					<textarea name="busiNotice" id="busiNotice" class="form-control" value="<%=busiNotice %>" disabled></textarea>
				</div>
				<div class="form-group">
					<input onclick="enableUpdate()" id="enableUp" type="button" class="form-control btn btn-primary" value="修改">
				</div>
<%
		}
	}
%>
			</form>
		</div>
		<div class="col-4 col align-self-center">
			<form role="form" id="pswForm" action="/xMeituan/busiInfo?method=updatePass" method="post" target="right">
				<div class="form-group">
					<label>修改密码</label>
				</div>
				<div class="form-group">
					<input name="oldPass" id="oriPsw" type="password" class="form-control" maxLength="16" placeholder="输入原密码">
				</div>
				<div class="form-group">
					<input name="newPass" id="newPsw" type="password" class="form-control" maxlength="16" placeholder="输入新密码">
				</div>
				<div class="form-group">
					<input name="surePass" id="xNewPsw" type="password" class="form-control" maxlength="16" placeholder="再次输入新密码">
				</div>
				<div class="form-group">
					<input id="updateP" type="submit" class="btn btn-primary" value="确认修改">
				</div>
			</form>
			<form role="form" id="picForm" action="/xMeituan/busiInfo?method=updateLogo" method="post" target="right" enctype="multipart/form-data">
				<div class="form-group ">
					<input name="oldBusiLogo" type="hidden" value="<%=oldBusiLogo%>">
					<input onclick="upPicBtn()" type="button" id="uploadPic" class="btn btn-defalut" value="上传照片" disabled>
					<input name="busiLogo" id="busiLogo" class="form-control" type="file" accept="image/jpeg,image/png" style="opacity: 0" disabled>
				</div>
			</form>
			<form role="form-group" id="service" action="/xMeituan/busiInfo?method=">
<%
	if(busiFlag==1){
%>
				<div class="form-group">
					<input id="xSwitch" type="submit" class="btn btn-danger" value="暂停营业">
				</div>
<%
	}else if(busiFlag==0){
%>
				<div class="form-group">
					<input id="xSwitch" type="submit" class="btn btn-warning" value="继续营业">
				</div>
<%
	}else{}
%>
			</form>
		</div>
	</div>
	<script src="/xMeituan/js/popper-1.14.3.min.js"></script>
	<script src="/xMeituan/js/bootstrap-4.1.1.min.js"></script>
	<script src="/xMeituan/js/busiInfo.js"></script>
</body>
</html>
