<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.meituan.domain.Busi" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>米团外卖</title>
<meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发" />
<meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!" />
<meta name="author" content="DeathGhost"/>
<link href="/xMeituan/css/template/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/xMeituan/js/template/public.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/jquery.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/jqpublic.js"></script>
<!--
Author: DeathGhost
Author URI: http://www.deathghost.cn
-->
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
<!--Start content-->
<section class="Psection">
 <section class="fslist_navtree">
  <ul class="select">
		<li class="select-list">
			<dl id="select1">
				<dt>分类：</dt>
				<dd class="select-all selected"><a href="javascript:">全部</a></dd>
				<dd><a href="javascript:">快餐</a></dd>
                <dd><a href="javascript:">正餐</a></dd>
                <dd><a href="javascript:">小吃零食</a></dd>
                <dd><a href="javascript:">甜品饮品</a></dd>
                <dd><a href="javascript:">果蔬生鲜</a></dd>
                <dd><a href="javascript:">鲜花蛋糕</a></dd>
                <dd><a href="javascript:">超市便利店</a></dd>
			</dl>
		</li>
		<li class="select-list">
			<dl id="select2">
				<dt>位置：</dt>
				<dd class="select-all selected"><a href="javascript:">全部</a></dd>
				<dd><a href="javascript:">越秀区</a></dd>
                <dd><a href="javascript:">海珠区</a></dd>
                <dd><a href="javascript:">天河区</a></dd>
                <dd><a href="javascript:">白云区</a></dd>
                <dd><a href="javascript:">番禺区</a></dd>
                <dd><a href="javascript:">从化区</a></dd>
                <dd><a href="javascript:">花都区</a></dd>
                <dd><a href="javascript:">南沙区</a></dd>
                <dd><a href="javascript:">黄浦区</a></dd>
                <dd><a href="javascript:">荔湾区</a></dd>
                <dd><a href="javascript:">增城区</a></dd>
			</dl>
		</li>
        <li class="select-list">
			<dl id="select4">
				<dt>价位区间：</dt>
				<dd class="select-all selected"><a href="javascript:">全部</a></dd>
				<dd><a href="javascript:">20元以下</a></dd>
                <dd><a href="javascript:">20-40元</a></dd>
                <dd><a href="javascript:">40-60元</a></dd>
                <dd><a href="javascript:">60-80元</a></dd>
                <dd><a href="javascript:">80-100元</a></dd>
			</dl>
		</li>
		<li class="select-result">
			<dl>
			 <dd class="select-no">已选择：</dd>
			</dl>
		</li>
	</ul>
 </section>
<section class="Fslmenu">
 <a href="#" title="默认排序">
  <span>
  <span>默认排序</span>
  <span></span>
  </span>
 </a>
 <a href="#" title="评价">
  <span>
  <span>评价</span>
  <span class="s-up"></span>
  </span>
 </a>
 <a href="#" title="销量">
  <span>
  <span>销量</span>
  <span class="s-up"></span>
  </span>
 </a>
 <a href="#" title="价格排序">
  <span>
  <span>价格</span>
  <span class="s-down"></span>
  </span>
 </a>
 <a href="#" title="发布时间排序">
  <span>
  <span>发布时间</span>
  <span class="s-up"></span>
  </span>
 </a>
</section>
<section class="Fsl">
 <ul>
 
<%
	List<Busi> busi=(List<Busi>)request.getAttribute("busiList");
	if (null!=busi) {
		Integer curPage=(Integer)request.getAttribute("pageNo");
		Long totalPages=(Long)request.getAttribute("totalPage");
        Long lastPage=Long.parseLong("1");
        if(totalPages%busi.size()==0){
            lastPage=totalPages/busi.size();
        }else{
            lastPage=(Long)((totalPages/busi.size())+1);
        }
%>
 <%
 	for(Busi e : busi) {
 		String addr=e.getBusiAddr();
 		String shopName=e.getBusiShopName();
 		String phone=e.getBusiPhone();
 		String logo=e.getBusiLogo();
        Integer busiId=e.getBusiId();
 %>
 
  <li>
   <a href="/xMeituan/userMenu?busiId=<%=busiId%>" target="_blank" title="<%=shopName %>"><img src="<%=logo %>"></a>
   <hgroup>
   <h3><%=shopName %></h3>
   <h4></h4>
   </hgroup>
   <p><%=addr %></p>
   <p>电话：<%=phone %></p>
   <p>
    <span class="Score-l">
    <img src="images/star-on.png">
    <img src="images/star-on.png">
    <img src="images/star-on.png">
    <img src="images/star-on.png">
    <img src="images/star-off.png">
    <span class="Score-v">4.8</span>
    </span>
    <span class="DSBUTTON"><a href="shop.html" target="_blank" class="Fontfff">点外卖</a></span>
   </p>
  </li>
  
 <%
 		}
 %>
  
 </ul>
 <div class="TurnPage">
  <a href="/xMeituan/userShow">
  <span class="Prev"><i></i>首页</span>
  </a>
  <%
  for (int i=1;i!=busi.size()+1;++i){
  %>
  <a href="/xMeituan/userShow?pageNo=<%=i%>"><span class="PNumber"><%=i%></span></a>
  <%
    }
  %>
  <a href="/xMeituan/userShow?pageNo=<%=lastPage%>">
  <%
  }
  %>
  <span class="Next">最后一页<i></i></span>
  </a>
 </div>
</section>
</section>
<!--End content-->
<footer>
<div class="copyright">© 2018 Metaloe</div>
</footer>
</body>
</html>
