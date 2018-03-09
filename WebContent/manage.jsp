<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<link rel="stylesheet" type="text/css" href="css/shopcarstyle.css"/>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/index-jquery.js"></script>

<%if(!String.valueOf(session.getAttribute("finishAd")).equals("1")){
	%><jsp:forward page="/IndexManage"></jsp:forward>
	<%}
	%>


	
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
				<input  type="hidden" name="Seatype" value="1">
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
			out.print("<a  href=\"addbooks.jsp\"><img src=\"images/wicon5.png\" alt=\"logo\"></img><p>添加图书</a></p>"+"</div>");
		}	
		%>
</div>
</div>

<div class="shoplist-veiling">
		
<div class="shoplist">				
<%
ArrayList<BookInfo> BookList=new ArrayList<BookInfo>();
if(session.getAttribute("maSearch")==null || !session.getAttribute("maSearch").equals("1"))
{
 BookList=(ArrayList<BookInfo>)session.getAttribute("allBooks");
}
else{
BookList=(ArrayList<BookInfo>)session.getAttribute("resultBooks");
session.setAttribute("finishAd", "0");
session.setAttribute("maSearch", "0");
}

int idx=0;double sum=0;
if(BookList.size()==0)
{%>
	
	<div class="noorder">还没有书，可以添加书本~<a href=addbooks.jsp">添加新书</a></div>
	
<%}	
		while(idx<BookList.size())
		{%>
			<div class="item">
				<div class="imgarea">
			    	<a href="../Bookcloud/InfoBook?bokid=<%=BookList.get(idx).getBook_id() %>"><img src="images/books/<%=BookList.get(idx).getPhoto() %>" alt="logo"></a>
			    </div>
				 <div class="baseinfo">
				 <div>
				 <p>书名:<%=BookList.get(idx).getName() %></p>
				<p>作者:<%=BookList.get(idx).getAuthor() %></p>
			<%if (!BookList.get(idx).getTransor().equals("无")){%>
					<p><%=BookList.get(idx).getTransor() %> 译</p><%} %>
				</div>	
				<div> 	
		  		 <p>出版社:<%=BookList.get(idx).getPress()%></p> <p>单价：<%=BookList.get(idx).getVprice()%></p>
		  		 </div>	 		  	
			    </div>	
			    		    
			    	<a class="manageA" href="DeleteServlet?bokid=<%=BookList.get(idx).getBook_id()%> ">删除书本</a>    
			</div>
			<hr class="info-hr1"/>		
		<% 		
		idx++;}	
		%>						
   </div>		
</div>


</div>




</html>