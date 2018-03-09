<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.kim.bean.BookInfo" %>
  <%@page import="com.kim.bean.Books" %>
 <%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopcarstyle.css"/>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/ajax-shopcar.js"></script>
<script type="text/javascript">
function show()
{
	var sum='<%=session.getAttribute("sum") %>';
	alter("确定要支付"+sum+"元么");
}

</script>



<%
	ArrayList<Books> MyList=(ArrayList<Books>)session.getAttribute("MyList");
	
%>
<title>我的购物车</title>
</head>
<body>
<div class="shoplist-veiling">
		<div class="nav">
			<div class="index-leftnav">
				<a href="../Bookcloud/index.jsp"><img src="images/logow.png" alt="logo"></a>
			</div>
		</div>
	<div  class="shoplist">
		<div class="title">购物车清单</div>   
			<hr class="info-hr0"/>					
<%
		int idx=0;double sum=0;
if(MyList.size()==0)
{%>
	
	<div class="noorder">购物车空空如也~<a href="infobook.jsp">返回</a></div>
	
<%}	
		while(idx<MyList.size())
		{%>
			<div class="item">
				<div class="imgarea">
			    	<img src="images/books/<%=MyList.get(idx).getPhoto() %>" alt="logo">
			    </div>
				 <div class="baseinfo">
				 <div>
				 <p>书名:<%=MyList.get(idx).getName() %></p>
				<p>作者:<%=MyList.get(idx).getAuthor() %></p>
				<p>出版社:<%=MyList.get(idx).getPress()%></p>

				</div>
					
				<div class="ddre"> 	
				  <p>单价：￥<%=MyList.get(idx).getVprice()%></p>
				  <p>数量：<%=MyList.get(idx).num%> </p>
		  		  <p>总价：￥<%=MyList.get(idx).subprice%></p>
		  		 </div>	 		
		  		 		 
			    </div>	
			    <div class="link">	    
			        <a href="DeleteServlet?cbokid=<%=MyList.get(idx).getBook_id()%>&doflag=1">+</a>
		  		 	<a href="DeleteServlet?cbokid=<%=MyList.get(idx).getBook_id()%>&doflag=-1">-</a> 
			    	<a href="DeleteServlet?cbokid=<%=MyList.get(idx).getBook_id()%>">删除订单</a>
			    	</div>    
			</div>
			<hr class="info-hr1"/>		
		<%  sum=sum+MyList.get(idx).subprice;idx++;	 
		}	
		session.setAttribute("sum", sum);
		%>			
<div class="sum">
	<a href="DoOrder" onlick="show()">结算</a><p id="ss">总价：<%=sum %></p>
	</div>				
   </div>		
</div>
</body>
</html>