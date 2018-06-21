<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.meituan.domain.Food" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>浏览店铺商品</title>
<meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发" />
<meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!" />
<meta name="author" content="DeathGhost"/>
<link href="/xMeituan/css/template/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/xMeituan/js/template/public.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/jquery.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/jqpublic.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/cart.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/jquery.easyui.min.js"></script>
<script>
$(function(){		
	$('.title-list li').click(function(){
		var liindex = $('.title-list li').index(this);
		$(this).addClass('on').siblings().removeClass('on');
		$('.menutab-wrap div.menutab').eq(liindex).fadeIn(150).siblings('div.menutab').hide();
		var liWidth = $('.title-list li').width();
		$('.shopcontent .title-list p').stop(false,true).animate({'left' : liindex * liWidth + 'px'},300);
	});
	
	$('.menutab-wrap .menutab li').hover(function(){
		$(this).css("border-color","#ff6600");
		$(this).find('p > a').css('color','#ff6600');
	},function(){
		$(this).css("border-color","#fafafa");
		$(this).find('p > a').css('color','#666666');
	});
	});
	var mt = 0;
window.onload = function () {
 var Topcart = document.getElementById("Topcart");
   var mt = Topcart.offsetTop;
    window.onscroll = function () {
     var t = document.documentElement.scrollTop || document.body.scrollTop;
      if (t > mt) {
      Topcart.style.position = "fixed";
        Topcart.style.margin = "";
         Topcart.style.top = "200px";
		 Topcart.style.right = "191px";
		 Topcart.style.boxShadow ="0px 0px 20px 5px #cccccc";
		 Topcart.style.top="0";
		 Topcart.style.border="1px #636363 solid";
         }
         else { 
         Topcart.style.position = "static";
		 Topcart.style.boxShadow ="none";
		 Topcart.style.border="";
          }
          }
        }
</script>
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
<section class="Shop-index">
 <article>
  <div class="menutab-wrap">
   <a name="ydwm">
    <!--case1-->
    <div class="menutab show">
    <ul class="products">

<%
  List<Food> foodList=(List<Food>)request.getAttribute("foodList");
    for(Food e : foodList) {
      Integer foodId=e.getFoodId();
      String foodName=e.getFoodName();
      String foodDesc=e.getFoodDesc();
      Double foodPrice=e.getFoodPrice();
      String foodPic=e.getFoodPic();
      String temp = foodPic.substring(23);
      foodPic = "/xMeituan/"+temp;
%>
		<li>
    <img src="<%=foodPic%>" class="foodsimgsize">
     <a href="" class="item">
		 <div>
		  <p><%=foodName%></p>
      <p><%=foodDesc%></p>
		  <p class="AButton">拖至购物车:￥<%=foodPrice%></p>
      <p hidden><%=foodId%></p>
		 </div>
		 </a>
		</li>
<%
  }
%>

	 </ul>
    </div>
    </a>
    </div>
  </div>
</div>
 </article>
 <aside>
  <div class="cart" id="Topcart">
	<span class="Ctitle Block FontW Font14"><a href="cart.html" target="_blank">我的购物车</a></span>
  <form action="cart.html" method="post">
	<table id="cartcontent" fitColumns="true">
	<thead>
	<tr>
  <th hidden field="xID">商品ID</th>
	<th width="33%" align="center" field="name">商品</th>
	<th width="33%" align="center" field="quantity">数量</th>
	<th width="33%" align="center" field="price">价格</th>
	</tr>
	</thead>
	</table>
  <input name="busiId" value="<%busiId%>">
  <input name="row" id="xRow" type="hidden">
	<p class="Ptc"><span class="Cbutton"><a><input type="submit" value="下单"></a></span><span class="total">共计金额: ￥0</span></p>
  </form>
  </div>
 </aside>
 
</section>
<!--End content-->
<footer>
    <div class="copyright">© 2018 Metaloe</div>
</footer>

</body>
</html>
