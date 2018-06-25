<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>用户中心</title>
<meta name="keywords" content="DeathGhost,DeathGhost.cn,web前端设,移动WebApp开发" />
<meta name="description" content="DeathGhost.cn::H5 WEB前端设计开发!" />
<meta name="author" content="DeathGhost"/>
<link rel="stylesheet" href="/xMeituan/css/bootstrap-4.1.1.min.css">
<link href="/xMeituan/css/template/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/xMeituan/js/template/public.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/jquery.js"></script>
<script type="text/javascript" src="/xMeituan/js/template/jqpublic.js"></script>
<script>
     function GetQueryString(name){
         var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
         var r = window.location.search.substr(1).match(reg);
         if(r!=null)return  unescape(r[2]); return null;
     }
     $(document).ready(function(){
         var orderId=GetQueryString("orderId");
         $("#odId").attr("value",orderId);
     });
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
<%
  String tmp=(String)session.getAttribute("userPhone");
  String state=null;
  String operation=null;
  if(tmp!=null&&tmp!=""){
    operation="/xMeituan/userOrder?method=getOrder";
    state=tmp;
  }else{
    operation="/xMeituan/html/userPage/userLogin.html";
    state="注册/登录";
  }
%>
       <a href="<%=operation %>"><%=state %></a><a href="/xMeituan/html/busiPage/busiLogin.html">商家版</a>
      </div>
      <div class="RightNav">
       <a href="/xMeituan/userOrder?method=getOrder">用户中心</a> <a href="/xMeituan/userOrder?method=getOrder" target="_blank" title="我的订单">我的订单</a>
      </div>
     </div>
    </section>
    <div class="Logo_search">
     <div class="Logo">
      <img src="/xMeituan/resources/pagePics/logoxx.png" title="Metaloe" alt="米团">
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
      <li><a href="/xMeituan/userShow">订餐</a></li>
     </ul>
    </nav>
   </header>
    <!--Start content-->
    <section class="Psection MT20">
    <nav class="U-nav Font14 FontW">
    <ul>
    <li><i></i><a href="/xMeituan/userShow">首页</a></li>
   <li><i></i><a href="/xMeituan/userOrder?method=getOrder">我的订单</a></li>
   <li><i></i><a href="/xMeituan/userAddr?method=getAddr">收货地址</a></li>
   <li><i></i><a href="">账户管理</a></li>
   <li><i></i><a href="">安全退出</a></li>
    </ul>
    </nav>
    <article class="U-article Overflow">
    <!--user order list-->
    <section class="Mymessage Overflow">
        <div class="container d-flex justify-content-center" id="info">
            <div class="col-10 col align-self-center">
                <form action="/xMeituan/userEvaluation" method="post">
                    <input name="orderId" id="odId" type="hidden">
                    <div class="form-group">
                        评价：<!--<input name="evaluation" class="form-control" type="text">-->
                        <textarea name="evaluation" maxLength="100" class="form-control"></textarea>
                    </div>
                    <div class="form-group">
                        评分：<input name="grade" type="number" value="5" min="0" max="5" step="1">
                    </div>
                    <div class="form-group">
                        <input type="submit" class="form-control btn btn-primary" value="提交">
                    </div>
                </form>
            </div>
        </div>
    </section>
    </article>
    </section>
    <!--End content-->
    <footer>
    <div class="copyright">© 2018 Metaloe</div>
    </footer>
    <script src="/xMeituan/js/popper-1.14.3.min.js"></script>
    <script src="/xMeituan/js/bootstrap-4.1.1.min.js"></script>
    </body>
    </html>
