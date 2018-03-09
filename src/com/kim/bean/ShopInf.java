package com.kim.bean;

import java.util.ArrayList;
import java.util.Date;

public class ShopInf {
	private int car_id;
	private String car_usr;
	private ArrayList<Books> books;
    private int	car_ispaid;
    private Date  shoptime;
	public int getCar_id() {
		return car_id;
	}
	public void setCar_id(int car_id) {
		this.car_id = car_id;
	}
	public String getCar_usr() {
		return car_usr;
	}
	public void setCar_usr(String car_usr) {
		this.car_usr = car_usr;
	}
	public ArrayList<Books> getBooks() {
		return books;
	}
	public void setBooks(ArrayList<Books> books) {
		this.books = books;
	}
	public int getCar_ispaid() {
		return car_ispaid;
	}
	public void setCar_ispaid(int car_ispaid) {
		this.car_ispaid = car_ispaid;
	}
	public Date getShoptime() {
		return shoptime;
	}
	public void setShoptime(Date shoptime) {
		this.shoptime = shoptime;
	}
	
    

	
}
