package com.kim.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.bean.BookInfo;
import com.kim.bean.Bookdb;
import com.kim.bean.Booktype;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Bookdb dbHelper=new Bookdb();
		
		ArrayList newBook=new ArrayList();
		ArrayList goodBook=new ArrayList();
		ArrayList<Booktype> botypes=new ArrayList<Booktype>();
		newBook=dbHelper.LoadNewBook();		
		goodBook=dbHelper.LoadGoodBook();	
		botypes=dbHelper.LoadType();
		HttpSession session = request.getSession();
		if(newBook!=null && goodBook!=null)
		{
		session.setAttribute("newBook", newBook);
		session.setAttribute("goodBook", goodBook);
		session.setAttribute("Booktypes", botypes);
		session.setAttribute("isLoad", "true");
		response.sendRedirect("index.jsp");
		}else{
			session.setAttribute("isLoad", "false");
			response.sendRedirect("index.jsp");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
