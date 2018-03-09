package com.kim.bean;

import java.io.UnsupportedEncodingException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;


public class Bookdb {
	private String Str_Driver="com.mysql.jdbc.Driver";
	//private String Str_ConnUrl="jdbc:mysql://localhost:3306/bookcdb?useUnicode=true&characterEncoding=UTF-8&";
	private String Str_ConnUrl="jdbc:mysql://localhost:3306/bookcdb?useUnicode=true&characterEncoding=UTF-8&";
	private	String Sql_user="root";
	private String Sql_password="52jyh4869ms";	
	private Connection conn=null;
	//加载驱动
	public Bookdb()
	{
		try
		{	
			Class.forName(Str_Driver); 
			conn=DriverManager.getConnection(Str_ConnUrl, Sql_user, Sql_password);
		}
		catch(ClassNotFoundException e) { 
			System.err.println("create():"+e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
    protected void finalize() throws java.lang.Throwable {
    	  if (conn != null) {
		    	conn.close();
		      }	
        // 递归调用超类中的finalize方法

        super.finalize(); 

     }
	
	//加载最新图书信息
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList LoadNewBook(){
		String sql;
		try{
			@SuppressWarnings("rawtypes")
			ArrayList NewBook=new ArrayList();
			sql="SELECT * from tb_bookinfo ORDER BY `book_storetime` desc ";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				BookInfo book=new BookInfo(rs);
				NewBook.add(book);
			}			
			return NewBook;
		}catch(SQLException e){
			System.err.println("SQL()"+e.getMessage());
			return null;
		}
	}
	
	//加载热销图书信息
	public ArrayList LoadGoodBook(){
		String sql;
		try{
			@SuppressWarnings("rawtypes")
			ArrayList NewBook=new ArrayList();
			sql="SELECT * from tb_bookinfo ORDER BY `book_dealnum` desc";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			int i=0;
			while(rs.next() && i<15)
			{
				BookInfo book=new BookInfo(rs);
				NewBook.add(book);
			}			
			return NewBook;
		}catch(SQLException e){
			System.err.println("SQL()"+e.getMessage());
			return null;
		}

	}
	
	//获取所有图书
	public ArrayList LoadAllBook(){
		String sql;
		try{
			@SuppressWarnings("rawtypes")
			ArrayList NewBook=new ArrayList();
			sql="SELECT * from tb_bookinfo ORDER BY `book_dealnum` desc";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			int i=0;
			while(rs.next() && i<15)
			{
				BookInfo book=new BookInfo(rs);
				NewBook.add(book);
			}			
			return NewBook;
		}catch(SQLException e){
			System.err.println("SQL()"+e.getMessage());
			return null;
		}

	}

	//删除某本书的所有信息
	public boolean DeleteBook(String bokid){
			try {
				PreparedStatement sql=conn.prepareStatement("DELETE from `bookcdb`.`tb_bookinfo` where book_id =?;");
				sql.setString(1,bokid);
				if(sql.executeUpdate()!=0)
				{
					return true;
				}
				
			}catch (SQLException e) {		
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
	
	
//新增图书
public boolean setNewBook(BookInfo book)
{
	try {
		PreparedStatement sql=conn.prepareStatement(
		"INSERT INTO `bookcdb`.`tb_bookinfo` (`book_name`, `book_author`, `book_transor`, `book_type`, `book_price`,"
		+ " `book_cost`, `book_outline`, `book_isbn`, `book_dealnum`, `book_num`, `book_storetime`, "
		+ "`book_pubtime`, `book_version`, `book_press`, `book_photo`, `book_vprice`,`book_comment`)"
		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");
		sql.setString(1, book.getName());
		sql.setString(2, book.getAuthor());
		sql.setString(3, book.getTransor());
		sql.setString(4, book.getType());
		sql.setDouble(5, book.getPrice());
		sql.setDouble(6, book.getCost());
		sql.setString(7, book.getOutline());
		sql.setString(8, book.getIsbn());
		sql.setInt(9, book.getDealnum());
		sql.setInt(10,book.getNum());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  		
		sql.setString(11,sdf.format(book.getStoretime()));
		sql.setString(12,sdf.format(book.getPubtime()));
		
		sql.setInt(13, book.getVersion());
		sql.setString(14, book.getPress());
		sql.setString(15, book.getPhoto());
		sql.setDouble(16, book.getVprice());
		sql.setInt(17, 0);
		if(sql.executeUpdate()==1)
		{			
			return true;
		}
		else
		{			
			return false;
		}		
	} catch (SQLException e) {		
		e.printStackTrace();
		return false;
	}
		
}

//判断是否为会员或者管理员
 public ResultSet CheckUser(LoginInf loginInfo){
	String sql;
		if(loginInfo.getAuthority().equals("1"))	
		{sql="select Usr_name from (select * from tb_customer where Usr_name='"+
				loginInfo.getName()+"' or  Usr_email='"+
				loginInfo.getName()+"')as candidate where Usr_pwd='"+loginInfo.getPass()+"'";
		try{
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs!=null && rs.next())
			{	
				PreparedStatement preSql=conn.prepareStatement
						("update tb_customer set Usr_lastlogintm= ? where Usr_name=? or Usr_email= ?");
				preSql.setString(2,loginInfo.getName());
				preSql.setString(3,loginInfo.getName());
				//更新上次登录时间
				Date date=new Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				preSql.setString(1,sdf.format(date));
				if(preSql.executeUpdate()==0)
		         {
					//需要更改
		        	 System.out.print("Updata fail!");
		         }
				return rs;
			}
							
		}
		catch (SQLException ex) {
			System.err.println("SQL():"+ex.getMessage());
		} 
		}
	else{
		 sql="select Ad_name from (select * from tb_admin where Ad_name='"+
				loginInfo.getName()+"' or  Ad_email='"+
				loginInfo.getName()+"')as candidate where Ad_pwd='"+loginInfo.getPass()+"'";
		 try{
				 
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				
				if(rs!=null && rs.next())
				{	
					PreparedStatement preSql=conn.prepareStatement
							("update tb_admin set Ad_lastlogintm= ? where Ad_name=? or Ad_email= ?");
					preSql.setString(2,loginInfo.getName());
					preSql.setString(3,loginInfo.getName());
					//更新上次登录时间
					Date date=new Date();
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					preSql.setString(1,sdf.format(date));
					if(preSql.executeUpdate()==0)
			         {
						//需要更改
			        	 System.out.print("Updata fail!");
			         }
					return rs;
				}
								
			}
			catch (SQLException ex) {
				System.err.println("SQL():"+ex.getMessage());
			} 
	}
		
		return null;
	}
	
	//注册会员
public boolean setNewUser(RegisterInfo registerInfo) throws UnsupportedEncodingException
	{	
		try{
			PreparedStatement sql =conn.prepareStatement
				("insert into tb_customer (Usr_name,Usr_pwd,Usr_email,Usr_registertime,Usr_lastlogintm,Usr_priority) values(?,?,?,?,?)"); 
			sql.setString(1,registerInfo.getUserName());
			sql.setString(2,registerInfo.getUserPass());
			sql.setString(3,registerInfo.getUserEmail());
			//设置日期格式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String sdate=sdf.format(date);
			sql.setString(4,sdate);
			sql.setString(5,sdate);
			int i=sql.executeUpdate();
			if(i==0)
			{
				return false;
			}	
			}	catch (SQLException ex) {
				System.err.println("SQL():"+ex.getMessage());
				return false;
			} 
			
		return true;
	}
	
public ResultSet findBookById(String bookid) {	
		try {
			PreparedStatement sql=conn.prepareStatement("select * from tb_bookinfo where book_id= ?");
			sql.setString(1, bookid);
			ResultSet rs=sql.executeQuery();
			return rs;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
public ResultSet findCommentsBybook(String bookid) {		
		try {		
			PreparedStatement sql=conn.prepareStatement("select * from tb_bookcomment where Re_book_id= ?");
			sql.setString(1, bookid);
			ResultSet rs=sql.executeQuery();
			return rs;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

public boolean addcomment(BookComment comment) {
		try {
			PreparedStatement sql =conn.prepareStatement("INSERT INTO `bookcdb`.`tb_bookcomment` "
					+ "(`Re_writer`, `Re_book_id`, `Re_content`, `Re_time`)VALUES (?, ?, ?, ?)");
			sql.setString(1,comment.getAuthor());
			sql.setInt(2, comment.getRebookid());
			sql.setString(3, comment.getContent());			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
			Date currentTime = new Date();//得到当前系统时间   
			sql.setString(4,formatter.format(currentTime));
			if(sql.executeUpdate()==0)
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
				
		return true;
	}
		

	
	
public ResultSet LoadShopList(String userName) {	
		try {		
			PreparedStatement sql=conn.prepareStatement("select * from tb_shoppingcar where car_usr=? and car_ispaid=0");
			sql.setString(1,userName );			
			ResultSet rs=sql.executeQuery();
			if (rs!=null)
			  {
				rs.next();
				int carid=rs.getInt("car_id");
				PreparedStatement Sql=conn.prepareStatement("select * from tb_shoppingcar_detail where car_id=?");
				Sql.setInt(1,carid );			
				ResultSet rst=Sql.executeQuery();
				return rst;
			  }
				return rs;
				
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}

public boolean deleteshopcarbyID(String carid) {
		
		try {
			 			
			PreparedStatement sql=conn.prepareStatement("delete from tb_shoppingcar where car_id=?");
			sql.setString(1,carid );			
			if(sql.executeUpdate()!=0)
			{
				
				return true;
			}
			
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
		
		return false;
	}
	

public boolean setorderbyCarId(String carid) {		
	// TODO Auto-generated method stub
	String sql="call Proc_commitorder(?);";
	try {
		CallableStatement  cstm = conn.prepareCall(sql);
		cstm.setString(1, carid);
		return cstm.execute();		
	  	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} //实例化对象cstm 
	return false;		

}






	public ResultSet findToken(String item) {
		try {
			 			
			PreparedStatement sql=conn.prepareStatement("SELECT * FROM tb_bookinfo where book_name like ?");
			sql.setString(1,'%'+item+'%' );			
			ResultSet rs=sql.executeQuery();
	
			return rs;
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	}
	
	
	
	public ArrayList<Booktype> LoadType() {
		String sql;
		try{
			conn=DriverManager.getConnection(Str_ConnUrl, Sql_user, Sql_password);
			@SuppressWarnings("rawtypes")
			ArrayList<Booktype> NewBook=new ArrayList<Booktype>();
			sql="SELECT * from tb_booktype ORDER BY `type_booknum` desc";
	
			Statement stmt=conn.createStatement();
		
			ResultSet rs=stmt.executeQuery(sql);
			int i=0;
			while(rs.next() && i<10)
			{
				Booktype book=new Booktype(rs);
				NewBook.add(book);
			}			

			
			return NewBook;
		}catch(SQLException e){
			System.err.println("SQL()"+e.getMessage());
			return null;
		}
	}
	
	
	
	public ResultSet findBookByTypeId(String type) {
		try {
			 			
			PreparedStatement sql=conn.prepareStatement("SELECT * FROM tb_bookinfo where book_type=?");
			sql.setString(1,type);			
			ResultSet rs=sql.executeQuery();

			return rs;
			
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
		}
	}


	public Boolean Isshopcar(String usrname)  {
		// TODO Auto-generated method stub
		PreparedStatement sql;
		try {
			sql = conn.prepareStatement("SELECT * from tb_shoppingcar where car_ispaid=0 and car_usr=?");
			sql.setString(1,usrname);
			ResultSet rs=sql.executeQuery();
			if(rs!=null){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		
		
	}


	public boolean AddBooksIntoShopCar(String usrname, int book_id) {
		// TODO Auto-generated method stub
		String sql="CALL Proc_Shopcar(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setString(1, usrname);
			cstm.setInt(2, book_id);
			return cstm.execute();		
		  	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		return false;
	}

	public int LoadCarid(String usrName) {
		
		try {
			PreparedStatement sql=conn.prepareStatement("select * from tb_shoppingcar where car_usr=? and car_ispaid=0");
			sql.setString(1, usrName);
			ResultSet rs=sql.executeQuery();
			while(rs.next()){
				return rs.getInt("car_id");
			}						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return -1;
	}

	public boolean removeBooksOutShopCar(int car_id, int book_id) {
		
		// TODO Auto-generated method stub
				String sql="call Proc_removeBookshopcar(?,?);";
				try {
					CallableStatement  cstm = conn.prepareCall(sql);
					cstm.setInt(1, car_id);
					cstm.setInt(2, book_id);
					return cstm.execute();							
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //实例化对象cstm 
				return false;
	}
	public boolean deleteBooksOutShopCar(int car_id, int book_id) {
		
		// TODO Auto-generated method stub
				String sql="call Proc_deletshopcar(?,?);";
				try {
					CallableStatement  cstm = conn.prepareCall(sql);
					cstm.setInt(1, car_id);
					cstm.setInt(2, book_id);
					return cstm.execute();		
				  	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //实例化对象cstm 
				return false;
	}

	public boolean updatebooks(BookInfo obok, BookInfo book) {
		if(book.equals(obok))
				return true;
		if(!book.getName().equals(obok.getName()))
			this.updatebookName(book.getName(),obok.getBook_id());
		if(book.getAuthor().equals(obok.getAuthor()))
			this.updatebookAuthor(book.getAuthor(),obok.getBook_id());
		if(!book.getTransor().equals(obok.getTransor()))	
			this.updatebookTransor(book.getTransor(),obok.getBook_id());
		if(!book.getType().equals(obok.getType()))
			this.updatebookType(book.getType(),obok.getBook_id());
		if(book.getPrice()!=obok.getPrice())
			this.updatebookPrice(book.getPrice(),obok.getBook_id());
		if(book.getCost()!=obok.getCost())
			this.updatebookCost(book.getCost(),obok.getBook_id());
		if(!book.getOutline().equals(obok.getOutline()))
			this.updatebookOutline(book.getOutline(),obok.getBook_id());
		if(!book.getIsbn().equals(obok.getIsbn()))
			this.updatebookIsbn(book.getIsbn(),obok.getBook_id());
		if(book.getNum()!=obok.getNum())	
			this.updatebookNum(book.getNum(),obok.getBook_id());
		if(!book.getStoretime().equals(obok.getStoretime()))
			this.updatebookStroetime(book.getStoretime(),obok.getBook_id());
		if(!book.getPubtime().equals(obok.getPubtime()))
			this.updatebookPubtime(book.getPubtime(),obok.getBook_id());	
		if(book.getVersion()!=obok.getVersion())
			this.updatebookVersion(book.getVersion(),obok.getBook_id());
		if(book.getPress().equals(obok.getPress()))
			this.updatebookPress(book.getPress(),obok.getBook_id());
		if(!book.getPhoto().equals(obok.getPhoto()))	
			this.updatebookPhoto(book.getPhoto(),obok.getBook_id());
	    if(book.getVprice()!=obok.getVprice())
	    	this.updatebookvprice(book.getVprice(),obok.getBook_id());		
		return true;
	}

	private void updatebookvprice(double vprice, int id) {
		String sql="CALL Proc_updatebookvprice(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setDouble(1, vprice);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
	}

	private void updatebookPhoto(String photo, int id) {
		String sql="CALL Proc_updatebookPhoto(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setString(1, photo);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
	}

	private void updatebookPress(String press, int id) {
		String sql="CALL Proc_updatebookPress(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setString(1, press);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
	}

	private void updatebookVersion(int version, int id) {
		String sql="CALL Proc_updatebookVersion(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setInt(1, version);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
		
	}

	private void updatebookPubtime(Date pubtime, int id) {
		String sql="CALL Proc_updatebookPubtime(?,?);";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  		
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setString(12,sdf.format(pubtime));
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
	}

	private void updatebookStroetime(Date storedtime, int id) {
		String sql="CALL Proc_updatebookStroetime(?,?);";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  	
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setString(1, sdf.format(storedtime));
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
		
	}

	private void updatebookNum(int num, int id) {
		String sql="CALL Proc_updatebookNum(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setInt(1, num);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
		
	}

	private void updatebookIsbn(String isbn, int id) {
		String sql="CALL Proc_updatebookIsbn(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setString(1, isbn);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
	}

	private void updatebookOutline(String outline, int id) {
		String sql="CALL Proc_updatebookOutline(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setString(1, outline);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
		
	}

	private void updatebookCost(double cost, int id) {
		String sql="CALL Proc_updatebookCost(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setDouble(1, cost);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
	}

	private void updatebookPrice(double price, int id) {
		String sql="CALL Proc_updatebookPrice(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setDouble(1, price);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
		
	}

	private void updatebookType(String type, int id) {
		String sql="CALL Proc_updatebookType(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setString(1, type);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
		
	}

	private void updatebookTransor(String transor, int id) {
		String sql="CALL Proc_updatebookTransor(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setString(1, transor);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
		
	}

	private void updatebookAuthor(String author, int id) {
		String sql="CALL Proc_updatebookAuthor(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setString(1, author);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
		
	}

	private void updatebookName(String name, int id) {
		String sql="CALL Proc_updatebookName(?,?);";
		try {
			CallableStatement  cstm = conn.prepareCall(sql);
			cstm.setString(1, name);
			cstm.setInt(2, id);	  	
			cstm.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //实例化对象cstm 
	}

}