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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Seatype 表示搜索的来源  如果是0 则是用户搜索 如果是1 则是管理员搜索
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item=String.valueOf(request.getParameter("seritem"));			
		ArrayList<BookInfo> resultBooks=new ArrayList<BookInfo>();
		Bookdb dbHelper=new Bookdb();			
		ResultSet rs=dbHelper.findToken(new String(item.getBytes("ISO-8859-1"),"utf-8"));
		try {
			while(rs.next())
			{
				BookInfo book=new BookInfo(rs);
				resultBooks.add(book);			
			}
			HttpSession session=request.getSession();
			session.setAttribute("resultBooks", resultBooks);
			
			if(request.getParameter("Seatype").equals("0"))
			{
				response.sendRedirect("Results.jsp");
			}
			else{
				session.setAttribute("maSearch", "1");
				response.sendRedirect("manage.jsp");
			}
			
			
			
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
