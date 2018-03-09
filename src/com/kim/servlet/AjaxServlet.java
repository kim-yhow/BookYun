package com.kim.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kim.bean.BookComment;
import com.kim.bean.BookInfo;
import com.kim.bean.Bookdb;
import com.kim.bean.Comments;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		BookInfo book=(BookInfo) session.getAttribute("infos");
		
		
		if(String.valueOf(request.getParameter("ch")).equals("in"))
		{
			String str=String.valueOf(request.getParameter("outline"));
			response.getWriter().write("<p class=\"outline\">&nbsp;&nbsp;"+str+"</p>");	
		}
		else 
		{
			boolean temp = false;
			Bookdb dbHelper=new Bookdb();	
			//评论数据加入数据库，提交评论
			if(Integer.valueOf(request.getParameter("ch"))==3){			
				System.out.println("55 AjaxServlet ");
			BookComment bkcomment=new BookComment();
			bkcomment.setAuthor(String.valueOf(session.getAttribute("userName")));
			bkcomment.setContent(String.valueOf(request.getParameter("content")));
			bkcomment.setRebookid(Integer.valueOf(String.valueOf(session.getAttribute("bid"))));		
			temp=dbHelper.addcomment(bkcomment);
			if(temp)
				{
					book.AddCommentnum();
					session.setAttribute("AllPages", book.getCommentnum()/4+1);
					
				}
		}	
		//如果是查看评论
		if(Integer.valueOf(request.getParameter("ch"))==2 || temp)			
		{				
			ArrayList<Comments> cmts=new ArrayList<Comments>();			
			 try{
				String bookid=String.valueOf(session.getAttribute("bid"));
				ResultSet rs=dbHelper.findCommentsBybook(bookid);	
				while(rs.next())
				{				
					Comments comment=new Comments();	
					comment.setAuthor(rs.getString("Re_writer"));
					comment.setContent(rs.getString("Re_content"));
					comment.setRebookid(Integer.valueOf(bookid));					
					comment.setCtm(rs.getString("Re_time"));
					cmts.add(comment);				
				}				
				if(cmts.size()==0)
				{		
						response.setCharacterEncoding("utf-8");
						response.getWriter().write("<div class=\"nocomment\">还没有评论喔~ 快去留言板占沙发</div>");
				}
				else
				{
					int idx=0;
					int count=0;
					int page=1;
					if(request.getAttribute("page")!=null)
					{
						 page=Integer.valueOf(String.valueOf(request.getAttribute("page")));
					}
				
					idx=(page-1)*4;
					while(idx<cmts.size()&& count<4)
					{	
						
						response.setCharacterEncoding("utf-8");						
						response.getWriter().write("<div class=\"commentcontent\">"+cmts.get(idx).getContent()
								+ "<p class=\"but-comment\">"+	cmts.get(idx).getCtm().subSequence(0, 19)+"&nbsp;&nbsp;"
								+ " 评论人："+cmts.get(idx).getAuthor()+"</p>"+ "</div><hr class=\"info-hr1\"/>");
						idx++;count++;
					}																					
			
				}	
				//int allpages=Integer.valueOf(String.valueOf(session.getAttribute("AllPages")));
			//	response.getWriter().write("<p ><a href=\"#\" id=\"1\" onclick=\"FirstPage()\">首页</a> <a href=\"#\"  onclick=\"LastPage()\">前一页</a><a href=\"#\" onclick=\"NextPage()\">后一页</a> <a href=\"#\"  onclick=\"FinalPage()\">末页</a></p>");	
				response.getWriter().write("<div class=\"lvm\">回复</div><hr class=\"info-hr0\"/>");		
				if(session.getAttribute("userName")==null)
				{
					response.getWriter().write("<div class=\"commentcontent\">你尚未登录请先<a href=\"login.jsp?bid="+String.valueOf(request.getParameter("bid"))+"\">登录 </a></div>");
				}
				else
				{	
				 session.setAttribute("bid", bookid);
				 response.getWriter().write("<div class=\"cform\"><textarea name=\"content\" id=\"cont\"> </textarea>"
						+ " <input type=\"button\"  onclick=\"send()\" value=\"提交\" > </div>");
				}		
				
			 }catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
