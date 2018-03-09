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
import com.kim.bean.ShopInf;

/**
 * Servlet implementation class ShopcarServlet
 */
@WebServlet("/AddShopcarServlet")
public class AddShopcarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShopcarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		BookInfo bookInf= (BookInfo)session.getAttribute("infos");
		String usrname=(String) session.getAttribute("userName");
		if(session.getAttribute("bid")!=null)
		{			
			Bookdb dbHelper=new Bookdb();	
			dbHelper.AddBooksIntoShopCar(usrname,bookInf.getBook_id());
			session.setAttribute("AddShopcarsuccess", "success");
			response.sendRedirect("infobook.jsp");
		}			
		else
		{
			response.sendError(500, "ShopcarServlet ±®¥Ì¡À");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request,response);	
	
	}

}
