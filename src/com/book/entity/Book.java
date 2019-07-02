package com.book.entity;

import java.sql.Date;

public class Book {

	private int bookid;
	private String bookname;
	private String author;
	private String phouse;
	private Date pdate;
	private String intro;
	private int booknum;
	private String action;
	private String category;
	private String photo;
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPhouse() {
		return phouse;
	}
	public void setPhouse(String phouse) {
		this.phouse = phouse;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookname=" + bookname + ", author=" + author + ", phouse=" + phouse
				+ ", pdate=" + pdate + ", intro=" + intro + ", booknum=" + booknum + ", action=" + action
				+ ", category=" + category + ", photo=" + photo + "]";
	}
	public Book(int bookid, String bookname, String author, String phouse, Date pdate, String intro, int booknum,
			String action, String category, String photo) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.author = author;
		this.phouse = phouse;
		this.pdate = pdate;
		this.intro = intro;
		this.booknum = booknum;
		this.action = action;
		this.category = category;
		this.photo = photo;
	}
	public Book(String bookname, String author, String phouse, Date pdate, String intro, int booknum, String action,
			String category, String photo) {
		super();
		this.bookname = bookname;
		this.author = author;
		this.phouse = phouse;
		this.pdate = pdate;
		this.intro = intro;
		this.booknum = booknum;
		this.action = action;
		this.category = category;
		this.photo = photo;
	}
	public Book() {
		super();
	}
	
	
	
}
