package com.book.entity;

public class Admin {

	private int admid;
	private String apassword;
	private String adminname;
	private String sex;
	private long mobile;
	private String address;
	private String remarks;

	public int getAdmid() {
		return admid;
	}
	public void setAdmid(int admid) {
		this.admid = admid;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Admin() {
		super();
	}
	@Override
	public String toString() {
		return "Admin [admid=" + admid + ", apassword=" + apassword + ", adminname=" + adminname + ", sex=" + sex
				+ ", mobile=" + mobile + ", address=" + address + ", remarks=" + remarks + "]";
	}
	public Admin(int admid, String apassword, String adminname, String sex, long mobile, String address,
			String remarks) {
		super();
		this.admid = admid;
		this.apassword = apassword;
		this.adminname = adminname;
		this.sex = sex;
		this.mobile = mobile;
		this.address = address;
		this.remarks = remarks;
	}
	
	
	
}
