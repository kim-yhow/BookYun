package com.kim.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Booktype {
private int type_id;
private String type_name;
private int type_booknum;
public Booktype(){
	
}

public Booktype(ResultSet rs) throws SQLException {
	this.type_id=rs.getInt("type_id");
	this.type_name=rs.getString("type_name");
	this.type_booknum=rs.getInt("type_booknum");
}
public int getType_id() {
	return type_id;
}
public void setType_id(int type_id) {
	this.type_id = type_id;
}
public String getType_name() {
	return type_name;
}
public void setType_name(String type_name) {
	this.type_name = type_name;
}
public int getType_booknum() {
	return type_booknum;
}
public void setType_booknum(int type_booknum) {
	this.type_booknum = type_booknum;
}

}
