    function CheckPost () 
    {
         if (loginForm.userName.value == "") 
         {
               alert("请填写用户名！！");
               return false;
         }
         if (loginForm.passWord.value == "") 
         {
               alert("密码不能为空！！");
               return false;
         }
       
         return true;
    }