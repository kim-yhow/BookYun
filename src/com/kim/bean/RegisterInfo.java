package com.kim.bean;

import java.io.UnsupportedEncodingException;

public class RegisterInfo {		
		 private String userName;
		 private String userEmail;
		 private String userPass;
		 
		public String getUserName() throws UnsupportedEncodingException {
			return new String(userName.getBytes("ISO-8859-1"),"utf-8");
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getUserEmail() throws UnsupportedEncodingException {
			userEmail=new String(userEmail.getBytes("ISO-8859-1"),"UTF-8");
			return userEmail;
		}
		public void setUserEmail(String userEmail) {
			this.userEmail = userEmail;
		}
		public String getUserPass() throws UnsupportedEncodingException {
			userPass=new String(userPass.getBytes("ISO-8859-1"),"UTF-8");
			return userPass;
		}
		public void setUserPass(String userPass) {
			this.userPass = userPass;
		}

		 
		 
		 
		
}
