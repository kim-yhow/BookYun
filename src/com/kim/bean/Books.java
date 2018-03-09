package com.kim.bean;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/*
 * 购买书本时使用，简单的数据结构，
 * id 书本的id
 * num 书本数量
 */
public class Books extends BookInfo{
	public int num; 
	public double subprice;
	public Date shoptime;
	public Books(Books k){
		super();
		this.subprice=k.subprice;
		this.num=k.num;
		this.shoptime=k.shoptime;
	
	}
	public Books(ResultSet bookinfoRs,ResultSet booksRs){
		super(bookinfoRs);
		try {
			this.subprice=booksRs.getDouble("de_subprice");			
			this.num=booksRs.getInt("de_num");
			this.shoptime=booksRs.getDate("de_time");			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
