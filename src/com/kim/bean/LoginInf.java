package com.kim.bean;

import java.io.UnsupportedEncodingException;

public class LoginInf {
	 private String Name;
	 private String Pass;
	 
	 private String Authority;


	public String getName() {
		return Name;
	}

	public void setName(String name) throws UnsupportedEncodingException {
		Name =  new String(name.getBytes("ISO-8859-1"),"utf-8");
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) throws UnsupportedEncodingException {
		Pass = new String(pass.getBytes("ISO-8859-1"),"utf-8");
	}

	public String getAuthority() {
		return Authority;
	}

	public void setAuthority(String authority) throws UnsupportedEncodingException {
		Authority = new String(authority.getBytes("ISO-8859-1"),"utf-8");
	}
	 
	 
	 
}
