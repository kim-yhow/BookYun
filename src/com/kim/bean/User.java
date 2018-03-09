package com.kim.bean;

import java.util.Date;

public class User {
private int Usr_id;
private String Usr_name;
private Date Usr_registertime;
private Date Usr_lastlogintm;
private String Usr_priority;
public int getUsr_id() {
	return Usr_id;
}
public void setUsr_id(int usr_id) {
	Usr_id = usr_id;
}
public String getUsr_name() {
	return Usr_name;
}
public void setUsr_name(String usr_name) {
	Usr_name = usr_name;
}
public Date getUsr_registertime() {
	return Usr_registertime;
}
public void setUsr_registertime(Date usr_registertime) {
	Usr_registertime = usr_registertime;
}
public Date getUsr_lastlogintm() {
	return Usr_lastlogintm;
}
public void setUsr_lastlogintm(Date usr_lastlogintm) {
	Usr_lastlogintm = usr_lastlogintm;
}
public String getUsr_priority() {
	return Usr_priority;
}
public void setUsr_priority(String usr_priority) {
	Usr_priority = usr_priority;
}     



}
