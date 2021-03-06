<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.meituan.domain.Order" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
        <li><i></i><a href="/xMeituan/userLogout">安全退出</a></li>
    </ul>
 </nav>
 <article class="U-article Overflow">
  <!--user order list-->
  <section>
    <table class="Myorder">
     <th class="Font14 FontW">订单编号</th>
     <th class="Font14 FontW">下单时间</th>
     <th class="Font14 FontW">订单总金额</th>
     <th class="Font14 FontW">订单备注</th>
     <th class="Font14 FontW">订单状态</th>
     <th class="Font14 FontW">操作</th>
<%
	List<Order> orderList=(List<Order>)request.getAttribute("orderList");
	Integer curPage=(Integer)request.getAttribute("pageNo");
	Long totalPages=(Long)request.getAttribute("totalPage");
%>
<%
	for(Order e : orderList) {
		Integer orderId=e.getOrderId();
		Double orderMoney=e.getOrderMoney();
		String orderRemark=e.getOrderRemark();
		String orderState=e.getOrderState();
		Timestamp orderStateTime=e.getOrderBegin();
		String timeStr=null;
		if(orderStateTime!=null){
			Long tmpFinTime=orderStateTime.getTime();
			Date date=new Date(tmpFinTime);
			SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
			timeStr=sdf.format(date);
		}
    	String xOperation=null;
    	String yOperation=null;
		if(orderState.equals("已接单")){
			xOperation="/xMeituan/userConfirm?orderId="+orderId;
			yOperation="确认送达";
		}else if(orderState.equals("已评价")||orderState.equals("未接单")){
			xOperation="";
			yOperation="";
		}else{
      		xOperation="/xMeituan/html/userPage/userEvaluation.jsp?orderId="+orderId;
      		yOperation="评价";
    	}
%>
     <tr>
      <td class="FontW"><%=orderId %></td>
      <td><%=timeStr %></td>
      <td><%=orderMoney %></td>
      <td><%=orderRemark %></td>
      <td><%=orderState %></td>
      <td><a href="<%=xOperation%>"><%=yOperation%></a></td>
     </tr>
<%
	}
%>
    </table>
  <div class="TurnPage">
  <a href="/xMeituan/userOrder">
  <span class="Prev"><i></i>首页</span>
  </a>
  <%
  for (int i=1;i!=totalPages+1;++i){
  %>
  <a href="/xMeituan/userOrder?pageNo=<%=i%>"><span class="PNumber"><%=i%></span></a>
  <%
    }
  %>
  <a href="/xMeituan/userOrder?pageNo=<%=totalPages%>">
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
