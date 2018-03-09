<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.kim.bean.BookInfo" %>
 <%@page import="com.kim.bean.Booktype" %>
 <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书云</title>
<link rel="stylesheet" type="text/css" href="css/search.css"/>
<link rel="stylesheet" type="text/css" href="css/indexstyle.css"/>
<link rel="stylesheet" href="css/font-awesome.min.css"/>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/index-jquery.js"></script>

<%
session.removeAttribute("bid");
if(session.getAttribute("isLoad")==null){
	%><jsp:forward page="/IndexServlet"></jsp:forward>
	<%}
	%>
</head>
<body>
<div class="index-welcome">
	<div class="index-veiling">
		<div class="t">
			<div class="index-leftnav"  style="float:left;">
				<a href="../Bookcloud/index.jsp"><img src="images/logow.png" alt="logo"></a>
			</div>
			<div class="search">
				<form class="se" action="SearchServlet">
				<input type="text" name="seritem" placeholder="搜索从这里开始...">
				<input  type="hidden" name="Seatype" value="0">
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
		else  if(session.getAttribute("authority")==null || session.getAttribute("authority").equals("1")){
			out.print("<div class=\"wel\"><p>欢迎,"+session.getAttribute("userName")+"</p>");
			out.print("<img src=\"images/shopping.png\" alt=\"logo\"><a  href=\"LoadShoplistServlet\">我的购物车</a>"+"</div>");
			}else{
				out.print("<div class=\"wel\"><p>欢迎,"+session.getAttribute("userName")+"</p>");
				out.print("<div><img src=\"images/shopping.png\" alt=\"logo\"><a  href=\"LoadShoplistServlet\">我的购物车</a>"+"</div>");
				out.print("<div><img src=\"images/wicon5.png\" alt=\"logo\"><a  href=\"../Bookcloud/manage.jsp\">管理中心</a>"+"</div></div>");
			}
		%>
</div>
		</div>
		<div class="t">
			<div class="indexs" id="d1">
				<a href="#">首页</a>
			</div>	
			<div class="indexs" id="d2">
				<a href="#firstsheet">新书上架</a>
			</div>		
			<div class="indexs" id="d3">
				<a href="#secondsheet">热销图书</a>
			</div>
			<div class="indexs" id="d4">
				<a href="#thirdsheet">所有分类</a>
			</div>
		</div>
	</div>
</div>
<%if("true".compareTo(String.valueOf(session.getAttribute("isLoad")))==0) {%>		

<div class="index-booksheet" id="firstsheet">
新书上架
</div>
<hr class="index-hr0"/>

<%
int idx=0;
ArrayList<BookInfo> newBookList=(ArrayList<BookInfo>)session.getAttribute("newBook");
while(idx<newBookList.size() && idx<10)
{
	BookInfo book=new BookInfo();
	book=newBookList.get(idx);
%>
<%
if(idx==0){%><div class="sheet" id="s1"><%}
else if(idx%5==0){%><div class="sheet" ><%}
%>
	
<div class="book"><a href="InfoBook?id=<%=book.getBook_id()%>">
<img src="images/books/<%=book.getPhoto()%>" alt="logo">
<p class="title">
<%=book.getName() %></a>
</p>
<p class="author">
<%=book.getAuthor()%></p>
<p class="vprice">￥
<%=book.getVprice()%></p>
<p class="price">￥
<%=book.getPrice()%>
</p>
</div>
<%
idx++;
if(idx%5==0){%></div><%}
}
if(idx%5!=0){%></div><%}
%>
<div class="index-booksheet" id="secondsheet" >
热销图书
</div>
<hr class="index-hr0"/>

<%
 idx=0;
ArrayList<BookInfo> goodBookList=(ArrayList<BookInfo>)session.getAttribute("goodBook");
while(idx<newBookList.size() && idx<10)
{
	BookInfo book=new BookInfo();
	book=goodBookList.get(idx);
%>
<%
if(idx==0){%><div class="sheet" id="s1"><%}
else if(idx%5==0){%><div class="sheet" ><%}
%>
	
<div class="book"><a href="InfoBook?id=<%=book.getBook_id()%>">
<img src="images/books/<%=book.getPhoto()%>" alt="logo">
<p class="title">
<%=book.getName() %></a>
</p>
<p class="author">
<%=book.getAuthor()%></p>
<p class="vprice">￥
<%=book.getVprice()%></p>
<p class="price">￥
<%=book.getPrice()%>
</p>
</div>
<%
idx++;
if(idx%5==0){%></div><%}
}
if(idx%5!=0){%></div><%}
%>
<div class="index-booksheet" id="thirdsheet">
所有分类
</div>
<hr class="index-hr0"/>

<%
idx=0;
ArrayList<Booktype> Botypes=(ArrayList<Booktype>)session.getAttribute("Booktypes");
while(idx<Botypes.size() && idx<10)
{  
	
	Booktype type=new Booktype();
	type=Botypes.get(idx);
	
if(idx==0){%><div class="sheet" id="s1"><%}
else if(idx%5==0){%><div class="sheet" ><%}
%>
	
<div class="type"><a href="TypesBook?id=<%=type.getType_name()%>">
<p class="title">
<%=type.getType_name() %></p></a>
</div>
<%
idx++;
if(idx%5==0){%></div><%}
}
if(idx%5!=0){%></div><%}
}else{
%>
<div class="noBooks">
	<p class="no">还没有图书</p>
</div>
<%} %>




</body>
</html>