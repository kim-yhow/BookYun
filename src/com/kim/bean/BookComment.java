package com.kim.bean;

import java.io.UnsupportedEncodingException;
import java.util.Date;



public class BookComment {
	private String author;
	private String content;
	private Date commenttime;
	private int rebookid;
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) throws UnsupportedEncodingException {
		this.author = new String(author.getBytes("ISO-8859-1"),"utf-8");
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) throws UnsupportedEncodingException {
		this.content = new String(content.getBytes("ISO-8859-1"),"utf-8");
	}
	public Date getCommenttime() {
		return commenttime;
	}
	public void setCommenttime(Date commenttime) {
		this.commenttime = commenttime;
	}
	public int getRebookid() {
		return rebookid;
	}
	public void setRebookid(int rebookid) {
		this.rebookid = rebookid;
	}
	
	
}
