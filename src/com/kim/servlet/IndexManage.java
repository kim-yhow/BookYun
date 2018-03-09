package com.kim.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.bean.Bookdb;
import com.kim.bean.Booktype;

/**
 * Servlet implementation class IndexManage
 */
@WebServlet("/IndexManage")
public class IndexManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Bookdb dbHelper=new Bookdb();		
		ArrayList allBooks=new ArrayList();	
		ArrayList<Booktype> botypes=new ArrayList<Booktype>();
		allBooks=dbHelper.LoadAllBook();		
		botypes=dbHelper.LoadType();
		HttpSession session = request.getSession();
		if(allBooks!=null && botypes!=null)
		{
		session.setAttribute("allBooks", allBooks);
		session.setAttribute("Booktypes", botypes);
		session.setAttribute("finishAd", "1");
		response.sendRedirect("manage.jsp");
		}else{
			response.sendError(500,"书本管理初始化失败！");
		}
		
		
	}

}
