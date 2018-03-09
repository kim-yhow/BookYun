package com.kim.bean;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookInfo {
	private int book_id;
	private String name;
	private String author;
	private String transor;
	private String type;
	private double price;
	private double cost;
	private String 	outline;
	private String 	isbn;
	private int dealnum;
	private int num;
	private Date storetime;
	private Date pubtime;
	private int version;
	private String press;
	private String photo;
	private double vprice;
	private int commentnum;
	private String returntext;
	public BookInfo(){
		this.transor="нч";
	}
	
		
	public BookInfo(ResultSet rs) {		
		try{
		this.book_id=rs.getInt("book_id");
		this.name=rs.getString("book_name");
		this.author=rs.getString("book_author");
		this.transor=rs.getString("book_transor");
		this.type= rs.getString("book_type");
		this.price=rs.getDouble("book_price");
		this.cost=rs.getDouble("book_cost");
		this.outline =rs.getString("book_outline");
		this.isbn =rs.getString("book_isbn");
		this.dealnum =rs.getInt("book_dealnum");
		this.num=rs.getInt("book_num");		
		this.storetime=rs.getDate("book_storetime");
		this.pubtime=rs.getDate("book_pubtime");
		this.version=rs.getInt("book_version");
		this.press=rs.getString("book_press");
		this.photo=rs.getString("book_photo");
		this.vprice=rs.getDouble("book_vprice");
		this.commentnum=rs.getInt("book_comment");
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	
	}



	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) throws UnsupportedEncodingException {
		this.name = new String(name.getBytes("ISO-8859-1"),"utf-8");
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) throws UnsupportedEncodingException {
		this.author = new String(author.getBytes("ISO-8859-1"),"utf-8");
	}
	public String getTransor() {
		return transor;
	}
	public void setTransor(String transor) throws UnsupportedEncodingException {
		this.transor = new String(transor.getBytes("ISO-8859-1"),"utf-8");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) throws UnsupportedEncodingException {
		this.type =new String(type.getBytes("ISO-8859-1"),"utf-8");
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getOutline() {
		return outline;
	}
	public void setOutline(String outline) throws UnsupportedEncodingException {
		this.outline = new String(outline.getBytes("ISO-8859-1"),"utf-8");
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) throws UnsupportedEncodingException {
		this.isbn =new String(isbn.getBytes("ISO-8859-1"),"utf-8");
	}
	public int getDealnum() {
		return dealnum;
	}
	public void setDealnum(int dealnum) {
		this.dealnum = dealnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Date getStoretime() {
		return storetime;
	}
	public void setStoretime(Date storetime) {
		this.storetime = storetime;
	}
	public Date getPubtime() {
		return pubtime;
	}
	public void setPubtime(Date pubtime) {
		this.pubtime = pubtime;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) throws UnsupportedEncodingException {
		this.press =new String(press.getBytes("ISO-8859-1"),"utf-8");
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) throws UnsupportedEncodingException {
		this.photo =new String(photo.getBytes("ISO-8859-1"),"utf-8");
	}
	public double getVprice() {
		return vprice;
	}
	public void setVprice(double vprice) {
		this.vprice = vprice;
	}

	public int getCommentnum() {
		return commentnum;
	}

	public void setCommentnum(int commentnum) {
		this.commentnum = commentnum;
	}

	

	public void setByrs(ResultSet rs) {
		try{
			this.book_id=rs.getInt("book_id");
			this.name=rs.getString("book_name");
			this.author=rs.getString("book_author");
			this.transor=rs.getString("book_transor");
			this.type= rs.getString("book_type");
			this.price=rs.getDouble("book_price");
			this.cost=rs.getDouble("book_cost");
			this.outline =rs.getString("book_outline");
			this.isbn =rs.getString("book_isbn");
			this.dealnum =rs.getInt("book_dealnum");
			this.num=rs.getInt("book_num");
			
			this.storetime=rs.getDate("book_storetime");
			this.pubtime=rs.getDate("book_pubtime");
			this.version=rs.getInt("book_version");
			this.press=rs.getString("book_press");
			this.photo=rs.getString("book_photo");
			this.vprice=rs.getDouble("book_vprice");
			this.commentnum=rs.getInt("book_comment");
			}
			catch(SQLException ex){
				ex.printStackTrace();
			}
		
	}



	public void AddCommentnum() {
		this.commentnum++;
		
	}
}
	
	