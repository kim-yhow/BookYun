package com.kim.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.bean.Bookdb;

/**
 * Servlet implementation class DeleteServ
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String cbokid=String.valueOf(request.getParameter("cbokid"));
		String bokid=String.valueOf(request.getParameter("bokid"));
		String carid = String.valueOf(session.getAttribute("carid"));
		String doflag=String.valueOf(request.getParameter("doflag"));
		String usrName=String.valueOf(session.getAttribute("userName"));
		if(cbokid!=null && !cbokid.equals("null"))	
		{	boolean f;
			Bookdb dbHelper=new Bookdb();						
			switch(doflag){
			case "1": 
				dbHelper.AddBooksIntoShopCar(usrName, Integer.valueOf(cbokid));
				break;
			case "-1": 
				dbHelper.removeBooksOutShopCar(Integer.valueOf(carid), Integer.valueOf(cbokid));
				break;
			default:dbHelper.deleteBooksOutShopCar(Integer.valueOf(carid), Integer.valueOf(cbokid)); break;
			}
	
				request.removeAttribute("cbokid");
				request.getRequestDispatcher("/LoadShoplistServlet").forward(request, response);										
		}	
		
		else if(bokid!=null && !bokid.equals("null")){
			Bookdb dbHelper=new Bookdb();		
			if(dbHelper.DeleteBook(bokid))
			{
				request.removeAttribute("bookid");
				session.setAttribute("finishAd", -1);
				response.sendRedirect("../Bookcloud/manage.jsp");
			}else{
				response.sendError(500,"É¾³ýÊé±¾Ê§°Ü£¡");
			}
		}	
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
