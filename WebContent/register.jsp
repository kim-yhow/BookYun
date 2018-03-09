<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link rel="stylesheet" href="css/logreg.css" type="text/css"/> 
<script type="text/javascript" src=js/checkformat.js></script> 
</head>
<body>
<div class="wrapper">
	<div class="logo">
	<img src="images/logow.png">
	</div>
	<form class="logreg" name="registerForm" method="post" action="Register"  onSubmit="return Checkpost()">
   		<p class="title">注册</p>    
        <input id="name" type="text" name="username" style="width:290px" placeholder="用户名">      
        <input id="name" type="text" name="email" style="width:290px" placeholder="邮箱">                                   
     	<input id="pwd" type="password" name="password" style="width:290px" placeholder="密码">
        <input id="pwd" type="password" name="repassword" style="width:290px" placeholder="确认密码">	
        <input id="submit" type="submit" value="创建新用户" >      
       </form>
</div>
</body>
</html>