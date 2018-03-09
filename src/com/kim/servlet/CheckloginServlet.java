package com.kim.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.bean.Bookdb;
import com.kim.bean.LoginInf;
import com.kim.bean.User;

/**
 * Servlet implementation class CheckloginServlet
 */
@WebServlet("/Checklogin")
public class CheckloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckloginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		Bookdb dbHelper=new Bookdb();
		//loginInf 对象保存登陆信息
		LoginInf loginInfo=new LoginInf();
		loginInfo.setAuthority(request.getParameter("authority"));
		loginInfo.setName( request.getParameter("userName").trim());
	    loginInfo.setPass(request.getParameter("passWord"));
	    session.setAttribute("authority", loginInfo.getAuthority());
	    ResultSet rs=dbHelper.CheckUser(loginInfo);
	    if(rs!=null ) 		    
	    {	   
	    	if( loginInfo.getAuthority().equals("1"))
	    	{
	    		try {
	    		session.setAttribute("userName", rs.getString("Usr_name"));
	    		}
		    	 catch (SQLException e) {
		    			// TODO Auto-generated catch block
		    			e.printStackTrace();
		    		}	    	
	    			if(session.getAttribute("bid")==null)	    		
	    	    	{
	    	    		response.sendRedirect("index.jsp");
	    	    	}
	    	    	else{	    	    		
	    	    		response.sendRedirect("infobook.jsp");
	    	    	}
	    		
	    	}
	    	else{
	    		try {
		    	session.setAttribute("userName", rs.getString("Ad_name"));
	    		}catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}	    	
	    		response.sendRedirect("manage.jsp");
	    	}
	    }
	
	  else 	//rs==null
	    {		
	    	if( loginInfo.getAuthority().equals("1"))
	    	{	    	
	    		response.sendRedirect("login.jsp?wrong=1");
	    	}
	    	else{
	    		response.sendRedirect("adminlogin.jsp?wrong=1");
	    	}
	
	    }
	 }
	   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
