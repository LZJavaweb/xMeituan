<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.meituan.domain.Busi" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>用户中心</title>
<meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发" />
<meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!" />
<meta name="author" content="DeathGhost"/>
<link href="../../css/template/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../js/template/public.js"></script>
<script type="text/javascript" src="../../js/template/jquery.js"></script>
<script type="text/javascript" src="../../js/template/jqpublic.js"></script>
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
      <img src="../../resources/pagePics/logoxx.png" title="DeathGhost" alt="模板">
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
<section class="Psection MT20">
<nav class="U-nav Font14 FontW">
  <ul>
   <li><i></i><a href="user_center.html">用户中心首页</a></li>
   <li><i></i><a href="user_orderlist.html">我的订单</a></li>
   <li><i></i><a href="user_address.html">收货地址</a></li>
   <li><i></i><a href="user_message.html">我的留言</a></li>
   <li><i></i><a href="user_coupon.html">我的优惠券</a></li>
   <li><i></i><a href="user_favorites.html">我的收藏</a></li>
   <li><i></i><a href="user_account.html">账户管理</a></li>
   <li><i></i><a href="#">安全退出</a></li>
  </ul>
 </nav>
 <article class="U-article Overflow">
  <!--user order list-->
  <section>
    <table class="Myorder">
     <th class="Font14 FontW">订单编号</th>
     <th class="Font14 FontW">下单时间</th>
     <th class="Font14 FontW">收件人</th>
     <th class="Font14 FontW">订单总金额</th>
     <th class="Font14 FontW">订单状态</th>
     <th class="Font14 FontW">操作</th>
     <tr>
      <td class="FontW"><a href="user_order.html">201409225367</a></td>
      <td>2014-09-22 19:21:38</td>
      <td>DeathGhost</td>
      <td>￥328.00</td>
      <td>未付款,未发货</td>
      <td><a href="#">取消订单</a> | <a href="#">付款</a></td>
     </tr>
    </table>
    <div class="TurnPage">
         <a href="#">
          <span class="Prev"><i></i>首页</span>
         </a>
         <a href="#"><span class="PNumber">1</span></a>
         <a href="#"><span class="PNumber">2</span></a>
         <a href="#">
         <span class="Next">最后一页<i></i></span>
        </a>
       </div>
  </section>
 </article>
</section>
<!--End content-->
 <footer>
  <div class="copyright">© 2018 Metaloe</div>
  </footer>
</body>
</html>