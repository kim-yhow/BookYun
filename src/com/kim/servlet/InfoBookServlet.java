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

import com.kim.bean.BookInfo;
import com.kim.bean.Bookdb;

/**
 * Servlet implementation class InfoBookServlet
 */
@WebServlet("/InfoBook")
public class InfoBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookid=request.getParameter("id");
		String bokid=request.getParameter("bokid");
		Bookdb dbHelper=new Bookdb();
		BookInfo bookInf=new BookInfo();
	
		if(bookid!=null && !bookid.equals("null"))
		{
		ResultSet rs=dbHelper.findBookById(bookid);
		try {
			while(rs.next())
			{
				bookInf.setByrs(rs);
			}
			HttpSession session=request.getSession();
			session.setAttribute("infos", bookInf);		
			request.removeAttribute("id");
			response.sendRedirect("infobook.jsp");
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else if(bokid!=null && !bokid.equals("null")){
			ResultSet rs=dbHelper.findBookById(bokid);
			try {
				while(rs.next())
				{
					bookInf.setByrs(rs);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			HttpSession session=request.getSession();
			session.setAttribute("modInfo", bookInf);		
			request.removeAttribute("bokid");
			response.sendRedirect("modifybooks.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
