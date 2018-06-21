<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.meituan.domain.Addr" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>用户中心</title>
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
       <a href="userLogin.html">注册/登录</a><a href="/xMeituan/html/busiPage/busiLogin.html">商家版</a>
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
   <li><i></i><a href="/xMeituan/userShow">用户中心首页</a></li>
   <li><i></i><a href="/xMeituan/userOrder?method=getOrder">我的订单</a></li>
   <li><i></i><a href="/xMeituan/userAddr?method=getAddr">收货地址</a></li>
   <li><i></i><a href="/xMeituan/">账户管理</a></li>
   <li><i></i><a href="/xMeituan/">安全退出</a></li>
  </ul>
 </nav>
 <article class="U-article Overflow">
  <!--user Address-->
  <section class="Myaddress Overflow">
   <span class="MDtitle Font14 FontW Block Lineheight35">收货人信息</span>
   <form action="/xMeituan/userAddr?method=editAddr" method="post">
   <table>

<%
  List<Addr> addrList=(List<Addr>)request.getAttribute("addrList");
  for(Addr e : addrList){
%>
	<input type="hidden" name="addrId" value="<%=e.getAddrId()%>">
   <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">收件人姓名：</td>
     <td><input type="text" name="addrName" required value="<%=e.getAddrName()%>" class="input_name"></td>
    </tr>
    <tr>
      <td width="30%" class="Font14 FontW Lineheight35" align="right">省：</td>
      <td><input type="text" name="addrProv" required size="10" value="<%=e.getAddrProv() %>" class="input_name"></td>
    </tr>
    <tr>
      <td width="30%" class="Font14 FontW Lineheight35" align="right">市：</td>
      <td><input type="text" name="addrCity" required size="10" value="<%=e.getAddrCity() %>" class="input_name"></td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">详细地址：</td>
     <td><input type="text" name="addrReal" required size="50" value="<%=e.getAddrReal() %>" class="input_addr"></td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">手机号码：</td>
     <td><input type="text" name="addrPhone" required pattern="[0-9]{11}" value="<%=e.getAddrPhone() %>" class="input_tel"></td>
    </tr>
    <tr>
     <td align="right"  width="30%" class="Font14 FontW Lineheight35"></td>
     <td class="Lineheight35"><input name="" type="submit" value="确认修改" class="Submit"><a href="/xMeituan/userAddr?method=deleteAddr&addrId=<%=e.getAddrId() %>" class="Submit">删除</a></td>
    </tr>

<%
  }
%>

   </table>
   </form>
   <!--add new address-->
   <form action="/xMeituan/userAddr?method=addAddr" method="post">
    <table style="margin-top:10px;">
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">收件人姓名：</td>
     <td><input type="text" name="addrName" required  class="input_name"></td>
    </tr>
    <tr>
        <td width="30%" class="Font14 FontW Lineheight35" align="right">省：</td>
        <td><input type="text" name="addrProv" required size="10" value="" class="input_name"></td>
      </tr>
      <tr>
        <td width="30%" class="Font14 FontW Lineheight35" align="right">市：</td>
        <td><input type="text" name="addrCity" required size="10" value="" class="input_name"></td>
      </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">详细地址：</td>
     <td><input type="text" name="addrReal" required  class="input_addr"></td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right">手机号码：</td>
     <td><input type="text" name="addrPhone" required pattern="[0-9]{11}" class="input_tel"></td>
    </tr>
    <tr>
     <td width="30%" class="Font14 FontW Lineheight35" align="right"></td>
     <td class="Font14 Font Lineheight35"><input name="" type="submit" value="新增收货地址"  class="Submit"></td>
    </tr>
   </table>
   </form>
  </section>
 </article>
</section>
<!--End content-->
<footer>
  <div class="copyright">© 2018 Metaloe</div>
</footer>
</body>
</html>
