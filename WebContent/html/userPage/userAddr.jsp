<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.meituan.domain.Addr" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>浏览店铺商品</title>
<meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发" />
<meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!" />
<meta name="author" content="DeathGhost"/>
<link href="/xMeituan/css/template/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="/xMeituan/css/bootstrap-4.1.1.min.css">
<script type="text/javascript" src="/xMeituan/js/template/public.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/jquery.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/jqpublic.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/cart.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/jquery.easyui.min.js"></script>
</head>
<body>
    <header>
        <section class="Topmenubg">
            <div class="Topnav">
            <div class="LeftNav">
            <a href="userLogin.html">注册/登录</a><a href="../busiPage/busiLogin.html">商家版</a>
            </div>
            <div class="RightNav">
            <a href="userOrder.html">用户中心</a> <a href="userOrder.html" target="_blank" title="我的订单">我的订单</a> <a href="userCart.html">购物车（0）</a>
            </div>
            </div>
        </section>
        <div class="Logo_search">
            <div class="Logo">
            <img src="/xMeituan/resources/pagePics/logoxx.png" title="DeathGhost" alt="模板">
            <i></i>
            <span>广州市 [ <a href="#">海珠区</a> ]</span>
            </div>
            <div class="Search"> 
            <form method="get" id="main_a_serach" onsubmit="return check_search(this)">
            <div class="Search_nav" id="selectsearch">
            <a href="javascript:;" onClick="selectsearch(this,'restaurant_name')" class="choose">餐厅</a>
            </div>
            <div class="Search_area"> 
            <input type="search" id="fkeyword" name="keyword" placeholder="请输入您所需查找的餐厅名称" class="searchbox" />
            <input type="submit" class="searchbutton" value="搜 索" />
            </div>
            </form>
            </div>
        </div>
        <nav class="menu_bg">
            <ul class="menu">
            <li><a href="list.html">订餐</a></li>
            </ul>
        </nav>
    </header>

    <div class="container d-flex justify-content-center" id="info">
		<div class="col-10 col align-self-center">
			<form action="\xMeituan\userAddr" method="post" role="form" id="infoForm">
                <div class="form-group">
                    <label for="sel1">地址:</label>
                    <select name="addrId" class="form-control" id="sel1">
<%
    List<Addr> addrList=(List<Addr>)request.getAttribute("addrList");
    for(Addr e : addrList){
        Integer addrId=e.getAddrId();
        String addrReal=e.getAddrReal();
%>
                        <option><p hidden><%=addrId%></p><%=addrReal%></option>
<%
    }
%>
                    </select>
                </div>
				<div class="form-group">
					<label>备注：</label>
					<input name="orderRemark" type="text" class="form-control">
                </div>
                <input type="submit" id="addRemark" class="btn btn-defalut" value="确定">
			</form>
		</div>
    </div>

    <footer>
        <div class="copyright">© 2018 Metaloe</div>
    </footer>
    <script src="../../js/popper-1.14.3.min.js"></script>
    <script src="../../js/bootstrap-4.1.1.min.js"></script>
</body>
</html>
