
function changeCss(obj){ 	

var b = document.getElementById("in");
b.style.color = "#00f"; //给所有a标签赋原色
b.style.background="#fff";

var c = document.getElementById("2");
c.style.color = "#00f"; //给所有a标签赋原色
c.style.background="#fff";


obj.style.color = "#fff"; //令当前标签高亮
obj.style.background="rgba(192,192,192,1)";
chatw(obj.id+'&'+obj.name);
}
function chatw(str){
var xmlhttp;
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
  document.getElementById("ajaxt").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","AjaxServlet?ch="+str,true);
xmlhttp.send();
}


function send(){
	var str=document.getElementById("cont").value
	console.log(str);
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	  document.getElementById("ajaxt").innerHTML=xmlhttp.responseText;
	    }
	  }
	xmlhttp.open("GET","AjaxServlet?ch=3&content="+str,true);
	xmlhttp.send();
}


function FirstPage(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
		  	document.getElementById("ajaxt").innerHTML=xmlhttp.responseText;
	    }
	  }
	xmlhttp.open("GET","AjaxServlet?ch=2&page=1",true);
	xmlhttp.send();
}


function LastPage(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	  document.getElementById("ajaxt").innerHTML=xmlhttp.responseText;
	    }
	  }
	xmlhttp.open("GET","AjaxServlet?ch=3&content="+str,true);
	xmlhttp.send();
}
function NextPage(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	  document.getElementById("ajaxt").innerHTML=xmlhttp.responseText;
	    }
	  }
	xmlhttp.open("GET","AjaxServlet?ch=3&content="+str,true);
	xmlhttp.send();
}

function FinalPage(){
	var xmlhttp;
	if (window.XMLHttpRequest)
	  {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	  }
	else
	  {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	  }
	xmlhttp.onreadystatechange=function()
	  {
	  if (xmlhttp.readyState==4 && xmlhttp.status==200)
	    {
	  document.getElementById("ajaxt").innerHTML=xmlhttp.responseText;
	    }
	  }
	xmlhttp.open("GET","AjaxServlet?ch=2&page=1"+str,true);
	xmlhttp.send();
}






