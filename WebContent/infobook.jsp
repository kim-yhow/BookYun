<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.kim.bean.BookInfo" %>
<jsp:useBean id="bookInf" scope="page" class="com.kim.bean.BookInfo"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
 bookInf= (BookInfo)session.getAttribute("infos");
if(bookInf==null){
	response.sendRedirect("../Bookcloud/index.jsp");
}else{
 session.setAttribute("bid", bookInf.getBook_id());
 session.setAttribute("Allpages", bookInf.getCommentnum()/4+1);
 System.out.println("10 infobook "+session.getAttribute("Allpages"));
 
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/infobookstyle.css"/>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/ajax-infobook.js"></script>
<script type="text/javascript">

function checkusr() {
    var user ='<%=session.getAttribute("userName")%>';
    if(user=="null")
    	{
    	 alert("请先登录！！");
    	}    
}
var s='<%=session.getAttribute("AddShopcarsuccess")%>';
console.log(s);
if(s!="null") {
alert("添加成功！可以在我的购物车里查看 ");
}
</script>

<title>图书详细信息</title>
<%
session.removeAttribute("AddShopcarsuccess");
%>
</head>
<body>
	<div class="info-veiling">
	<div class="nav">
		<div class="index-leftnav">
				<a href="http://localhost:8080/Bookcloud/index.jsp"><img src="images/logow.png" alt="logo"></a>
		</div>
		<div class="info-rightnav">		
	<%if(session.getAttribute("userName")!=null)
	{
			out.print("<div class=\"wel\"><p>欢迎,"+session.getAttribute("userName")+"</p>");
			out.print("<img src=\"images/shopping.png\" alt=\"logo\"><a  href=\"LoadShoplistServlet\">我的购物车 </a>"+"</div>");
	}
	else
	{%>
	<div class="log">
	  <a href="login.jsp">登陆</a>
	  </div >
	<div class="reg">
	 <a  href="register.jsp">注册</a>
	 </div>
	<%
	}
	%>
		</div>
	</div>
		<div class="infoarea">
			<div class="imgarea">
		    	<img src="images/books/<%=bookInf.getPhoto() %>" alt="logo">
		    </div>
		    <div class="detail">
				<p class="title"><%=bookInf.getName() %>  </p>
				<div class="baseinfo"><p>作者: <%=bookInf.getAuthor() %> </p>
				<%
				if (!bookInf.getTransor().equals("无"))
				{
					%><p><%=bookInf.getTransor() %> 译</p><%	
				}
				%>
		        <p> 出版社：<%=bookInf.getPress() %></p>  <p>第<%=bookInf.getVersion() %>版</p> <p>出版时间：<%=bookInf.getPubtime() %></p>  </div>
					<div class="comment-num">														
					  <p>入库时间：<%=bookInf.getStoretime() %></p>						
						  <p>库存:<%=bookInf.getNum() %></p> 
						<p>已卖出 :<%=bookInf.getDealnum()%> </p>
					 <p>isbn:<%=bookInf.getIsbn() %></p></div> 
				<div class="pr">  	
					<p class="info">抢购价</p>	
					<p class="vprice">
					￥<%=bookInf.getVprice()%>
					</p> 
					<p class="price">定价 ￥<%=bookInf.getPrice() %>			
					</p>
					<% if(session.getAttribute("userName")==null){
						out.print("<a href=\"#\" onclick=\"checkusr()\">加入购物车</a>");
					}
					else
					   {out.print("<a href=\"AddShopcarServlet\" >加入购物车</a>");}
					   %>
				</div>		
				<div class="icl">
				<a href="#" name="af&outline=<%=bookInf.getOutline() %>" id="in" onclick="changeCss(this)">简介</a>
				<a href="#" name="af&bid=<%=bookInf.getBook_id() %>" id="2" onclick="changeCss(this)">评论</a>			
				</div>
				<hr class="info-hr0"/>
				<div id="ajaxt">
				<p class="outline">&nbsp;&nbsp;<%=bookInf.getOutline()%> </p>								
				<hr class="info-hr0"/>	
				</div>			
			</div>
		</div>             
	</div>
</body>
</html>
<%}%>