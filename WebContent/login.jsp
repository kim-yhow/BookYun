<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/logreg.css" type="text/css"/>
<%String bid=request.getParameter("bid"); %> 
<script type="text/javascript" src=js/sendform.js></script>
<head>
  <title>登录页面</title>
</head>
<body>
<div class="wrapper">
	<div class="logo">
	<img src="images/logow.png">
	</div>
	  <form  class="logreg" name="loginForm" method="post" action="Checklogin?bid=<%=bid %>" onSubmit="return CheckPost()">
   		<p class="title">登陆</p>
            <input id="name" type="text" name="userName" style="width: 290px" placeholder="用户名">
         	<input id="pwd" type="password" name="passWord" style="width: 290px" placeholder="密码">
        <input  type="hidden" name="authority" value="1">
                <input id="submit" type="submit" value="登录" >
             <p>还没有账号？点击<a href="register.jsp">注册</a>  <a href="../Bookcloud/adminlogin.jsp">管理员登录</a>
             <%if(String.valueOf(request.getParameter("wrong")).equals("1")){
            	%> <span class="sss">用户名或密码错误 </span><% }%></p>        
            
         </form>       

 </div>
</body>
</html>