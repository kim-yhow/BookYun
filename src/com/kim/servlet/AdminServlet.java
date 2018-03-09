package com.kim.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.bean.BookInfo;
import com.kim.bean.Bookdb;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/Admin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		Bookdb dbHelper =new Bookdb();
		BookInfo book=new BookInfo(); 
		BookInfo OriginalBok=(BookInfo)session.getAttribute("modInfo");
		book.setName((String)request.getParameter("book_name"));
		book.setAuthor((String)request.getParameter("book_author"));
		book.setTransor((String)request.getParameter("book_transor"));
		book.setType((String)request.getParameter("book_type"));
		book.setPrice(Double.valueOf((String)request.getParameter("book_price")));
		book.setCost(Double.valueOf((String)request.getParameter("book_cost")));
		book.setOutline((String)request.getParameter("book_outline"));
		book.setIsbn((String)request.getParameter("book_isbn"));
		book.setDealnum(Integer.valueOf((String)request.getParameter("book_dealnum")));
		book.setNum(Integer.valueOf((String)request.getParameter("book_num")));		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		try {
			book.setStoretime(sdf.parse((String)request.getParameter("book_storetime")));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		try {
			book.setPubtime(sdf.parse((String)request.getParameter("book_pubtime")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book.setVersion(Integer.valueOf((String)request.getParameter("book_version")));
		book.setPress((String)request.getParameter("book_press"));
		book.setPhoto((String)request.getParameter("book_photo"));
		book.setVprice(Double.parseDouble((String)request.getParameter("book_vprice")));
		String book_from=request.getParameter("book_from");
		if(book_from==null || book_from.equals("null")){
			if(dbHelper.setNewBook(book))
			{
				session.setAttribute("finishAd", "0");
				response.sendRedirect("../Bookcloud/manage.jsp");			
			}
			else 
			{
				response.sendError(500,"数据库插入数据失败");
			}	
		}
		else{
			request.removeAttribute("book_from");
			if(dbHelper.updatebooks(OriginalBok,book))
			{
				session.setAttribute("finishAd", "0");
				response.sendRedirect("../Bookcloud/manage.jsp");			
			}
			else 
			{
				response.sendError(500,"数据库插入数据失败");
			}
			
		}
		
	}
	
	

}
