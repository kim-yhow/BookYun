package com.kim.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import com.kim.bean.Bookdb;
import com.kim.bean.RegisterInfo;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegisterInfo registerInfo=new RegisterInfo();
		registerInfo.setUserName(request.getParameter("username"));
		registerInfo.setUserEmail(request.getParameter("email"));
		registerInfo.setUserPass(request.getParameter("password"));
		Bookdb db=new Bookdb();
		
		if(db.setNewUser(registerInfo))
		{
			System.out.print("success");
			
		}
		else{
			System.out.print("fail!");
			response.sendRedirect("login.jsp");
		}

	}
		


	/**
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
