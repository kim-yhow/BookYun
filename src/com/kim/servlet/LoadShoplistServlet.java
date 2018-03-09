package com.kim.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.bean.BookInfo;
import com.kim.bean.Bookdb;
import com.kim.bean.Books;

/**
 * Servlet implementation class LoadShoplistServlet
 */
@WebServlet("/LoadShoplistServlet")
public class LoadShoplistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadShoplistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Bookdb dbHelper=new Bookdb();
		ArrayList<Books> Myshop=new ArrayList<Books>();
		String usrName=String.valueOf(session.getAttribute("userName"));
		ResultSet rs=dbHelper.LoadShopList(usrName);
		
		if(rs!=null)
		{
			session.setAttribute("carid", dbHelper.LoadCarid(usrName));
			try {
			while(rs.next())
			{
				ResultSet rf=dbHelper.findBookById(rs.getString("book_id"));
				while(rf.next())
				{
					Books book=new Books(rf,rs);	
					Myshop.add(book);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		session.setAttribute("MyList", Myshop);
		response.sendRedirect("shopcarlist.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

}
