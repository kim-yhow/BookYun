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
<title>修改图书信息</title>
</head>
<body>
<%
BookInfo bok=(BookInfo)session.getAttribute("modInfo");
if(bok==null || bok.equals("null"))
{
	response.sendError(500,"modifybooks.jsp 接收参数错误");
		
}
else{
	%>


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
<h3 class="my">修改图书信息</h3>
<form action="Admin" method="post">
<input  title="书名" name="book_name" type="text" value=<%=bok.getName() %> >
<input  title="作者" name="book_author" type="text" value=<%=bok.getAuthor()%> >
<input  title="译者" name="book_transor" type="text" value=<%=bok.getTransor() %> >
<input  title="书本类别" name="book_type" type="text" value=<%=bok.getType() %> >
<input  title="书本价格" name="book_price" type="text" value=<%=bok.getPrice() %> >
<input  title="书本会员价" name="book_vprice" type="text" value=<%=bok.getVprice() %> >
<input  title="ISBN" name="book_isbn" type="text" value=<%=bok.getIsbn() %> >
<input  title="交易数量 （不可更改）" name="book_dealnum" type="text" value=<%=bok.getDealnum() %> >
<input  title="书本库存" name="book_num" type="text" value=<%=bok.getNum() %> >
<input  title="书本库存时间" name="book_storetime" type="text" value=<%=bok.getStoretime() %> >
<input  title="书本发行时间" name="book_pubtime" type="text" value=<%=bok.getPubtime()%> >
<input  title="印刷班次" name="book_version" type="text" value=<%=bok.getVersion()%> >
<input  title="出版社" name="book_press" type="text" value=<%=bok.getPress()%> >
<input  title="书本图片" name="book_photo" type="text" value=<%=bok.getPhoto() %> > 
<input  title="成本" name="book_cost" type="text" value=<%=bok.getCost()%> >
<textarea title="概要"  name="book_outline"  ><%=bok.getOutline()%></textarea>
<input name="book_from" type="hidden" value="1" >  
<input  type="submit" value="提交">
</form>
</div>
</div>


</div>

<%} %>
</body>
</html>