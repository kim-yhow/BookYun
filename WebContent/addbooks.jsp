<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="com.kim.bean.BookInfo" %>
<%@page import="com.kim.bean.Bookdb" %>
<link rel="stylesheet" type="text/css" href="css/search.css"/>
<link rel="stylesheet" type="text/css" href="css/indexstyle.css"/>
<link rel="stylesheet" href="css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="css/shopcarstyle.css"/>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/index-jquery.js"></script>


<style type="text/css">


input{
 display: block;
  width:300px;
  padding: 15px 10px;
  margin-bottom: 10px;
  border: 1px solid #98FB98;
  color: #121212;
  margin-left:380px;

	
}

textarea{
 display: block;
 width:300px;
 height:300px;
  padding: 15px 10px;
  margin-bottom: 10px;
  border: 1px solid #98FB98;
  color: #121212;
  margin-left:380px;
}

</style>
<title>添加图书</title>
</head>
<body>

	<div class="index-veiling">
		<div class="t">
			<div class="index-leftnav"  style="float:left;">
				<a href="../Bookcloud/index.jsp"><img src="images/logow.png" alt="logo"></a>
			</div>
			<div class="search">
				<form class="se" action="SearchServlet">
				<input type="text" name="seritem" placeholder="搜索从这里开始...">
				<button type="submit"></button>
				</form>
			</div>		
			<div class="index-rightnav">
		<%if(session.getAttribute("userName")==null)
		{%>
			<div class="log">
 			  <a href="login.jsp">登陆</a>
 			  </div >
			<div class="reg">
  			 <a  href="register.jsp">注册</a>
  			 </div>
  			<%
			}
		else{
			out.print("<div class=\"wel\"><p>欢迎,"+session.getAttribute("userName")+"</p>");
			out.print("<a  href=\"../Bookcloud/manage.jsp\"><img src=\"images/wicon5.png\" alt=\"logo\"></img><p>全部图书</a></p>"+"</div>");
		}	
		%>
</div>
</div>
<div class="shoplist">
<div display:"block"; >
<h3 class="my">添加图书</h3>
<form action="Admin" method="post">
<input  name="book_name" type="text" placeholder="书名">
<input  name="book_author" type="text" placeholder="作者">
<input  name="book_transor" type="text" placeholder="译者（无）" value="无">
<input  name="book_type" type="text" placeholder="类型">
<input  name="book_price" type="text" placeholder="原价">
<input  name="book_vprice" type="text" placeholder="优惠价">
<input  name="book_isbn" type="text" placeholder="isbn">
<input  name="book_dealnum" type="text" placeholder="成交量">
<input  name="book_num" type="text" placeholder="图书库存">
<input  name="book_storetime" type="text" placeholder="入库时间 例如2017-08-01">
<input  name="book_pubtime" type="text" placeholder="发行时间 例如2017-08-01">
<input  name="book_version" type="text" placeholder="版次">
<input  name="book_press" type="text" placeholder="出版社">
<input  name="book_photo" type="text" placeholder="图片地址"> 
<input  name="book_cost" type="text" placeholder="成本">
<textarea  name="book_outline" type="text" placeholder="简介"></textarea>
<input  type="submit" value="提交">
</form>
</div>
</div>


</div>


</body>
</html>