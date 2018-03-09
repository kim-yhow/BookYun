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

/**
 * Servlet implementation class TypesBookServlet
 */
@WebServlet("/TypesBook")
public class TypesBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypesBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type=String.valueOf(request.getParameter("id"));
		System.out.println(type+"Type  38");
		ArrayList<BookInfo> resultBooks=new ArrayList<BookInfo>();
		Bookdb dbHelper=new Bookdb();	
		ResultSet rs=dbHelper.findBookByTypeId(new String(type.getBytes("ISO-8859-1"),"UTF-8"));
		try {
			while(rs.next())
			{
				BookInfo book=new BookInfo(rs);
				resultBooks.add(book);			
			}
			HttpSession session=request.getSession();
			session.setAttribute("resultBooks", resultBooks);
			response.sendRedirect("Results.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
