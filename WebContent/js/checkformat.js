function Checkpost()  
{    
if (registerForm.username.value=="")    
 {    
 alert("用户名不能为空");    
 return false;    
 }    

if (registerForm.password.value!=registerForm.repassword.value)    
{    
alert("两次输入的密码不同！");    
return false;    
}    
if (registerForm.password.value=="")    
{    
alert("用户密码不能为空！");    
return false;    
}    
var checkemail  = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
var email=registerForm.email.value;
if (!checkemail.test(email))
{
	alert("邮箱格式不对！");
	return false;
}
else return true;    
}    