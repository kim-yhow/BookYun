<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.kim.bean.BookInfo" %>
 <%@page import="java.util.ArrayList" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索结果</title>
<link rel="stylesheet" type="text/css" href="css/search.css"/>
<link rel="stylesheet" href="css/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="css/searchstyle.css"/>
</head>
<body>
	<div class="veiling">
		<div class="t">
			<div class="index-leftnav"  style="float:left;">
				<a href="http://localhost:8080/Bookcloud/index.jsp"><img src="images/logow.png" alt="logo"></a>
			</div>
			<div class="search">
				<form class="se" action="SearchServlet">
				<input type="text" name="seritem" placeholder="搜索从这里开始...">
				<button type="submit"></button>
				</form>
			</div>	
		</div>
		<div  class="searchlist">  

			
<%
ArrayList<BookInfo> resultbooks=(ArrayList<BookInfo>) session.getAttribute("resultBooks");
int idx=0;
System.out.print(resultbooks);
if(resultbooks==null ||  idx==resultbooks.size()) 
{%>
	
	<div class="noorder">没有任何合适的结果！<a href="index.jsp">返回</a></div>
	
<%}	
		while(idx<resultbooks.size())
		{%>
			<div class="item">
				<div class="imgarea">
			<a href="InfoBook?id=<%=resultbooks.get(idx).getBook_id()%>"><img src="images/books/<%=resultbooks.get(idx).getPhoto() %>" alt="logo"></a>
			    </div>
				 <div class="baseinfo">				 
				 <div>		
				 <p>书名：<%=resultbooks.get(idx).getName() %></p>		 
				<p>作者:<%=resultbooks.get(idx).getAuthor() %></p>
			<%if (!resultbooks.get(idx).getTransor().equals("无"))
			{%>
					<p><%=resultbooks.get(idx).getTransor() %> 译</p><%
					} %>
				</div>		  	
				<div>
		  		 <p>出版社:<%=resultbooks.get(idx).getPress()%></p> <p>单价：<%=resultbooks.get(idx).getVprice()%></p>
		  		 </div>		  	
			    </div>		    
			    
			</div>
			<hr class="info-hr1"/>		
		<% idx++;	 
		}	
		%>			
   
	
	
	
	
	</div>
			
		
		
		
		
		
		
	</div>	


</body>
</html>