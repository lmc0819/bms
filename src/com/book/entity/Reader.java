package com.book.entity;

import java.sql.Date;

public class Reader {
     
	private int readerid;
	private String rpassword;
	private String readername;
	private String sex;
	private long mobile;
	private String department;
	private Date sxtime;
	private int borrownumber;
	private String remarks;
	public Reader() {
		super();
	}
	public Reader(int readerid, String rpassword, String readername, String sex, long mobile, String department,
			Date sxtime, int borrownumber, String remarks) {
		super();
		this.readerid = readerid;
		this.rpassword = rpassword;
		this.readername = readername;
		this.sex = sex;
		this.mobile = mobile;
		this.department = department;
		this.sxtime = sxtime;
		this.borrownumber = borrownumber;
		this.remarks = remarks;
	}
	public int getReaderid() {
		return readerid;
	}
	public void setReaderid(int readerid) {
		this.readerid = readerid;
	}
	public String getRpassword() {
		return rpassword;
	}
	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}
	public String getReadername() {
		return readername;
	}
	public void setReadername(String readername) {
		this.readername = readername;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getSxtime() {
		return sxtime;
	}
	public void setSxtime(Date sxtime) {
		this.sxtime = sxtime;
	}
	public int getBorrownumber() {
		return borrownumber;
	}
	public void setBorrownumber(int borrownumber) {
		this.borrownumber = borrownumber;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	
}
