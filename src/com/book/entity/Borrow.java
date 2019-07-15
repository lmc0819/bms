package com.book.entity;

import java.sql.Date;
import java.sql.Timestamp;

public class Borrow {

	private int borrowid;
	private int bookid;
	private String bookname;
	private int readerid;
	private String readername;
	private Date borrowdate;
	private Date returndate;
	private String isreturn;
	public Borrow() {
		super();
	}
	public Borrow(int borrowId, int bookId, String bookName, int readerId, String readerName, Date borrowDate,
			Date returnDate, String isReturn) {
		super();
		this.borrowid = borrowId;
		this.bookid = bookId;
		this.bookname = bookName;
		this.readerid = readerId;
		this.readername = readerName;
		this.borrowdate = borrowDate;
		this.returndate = returnDate;
		this.isreturn = isReturn;
	}
	public int getBorrowid() {
		return borrowid;
	}
	public void setBorrowid(int borrowId) {
		this.borrowid = borrowId;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookId) {
		this.bookid = bookId;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookName) {
		this.bookname = bookName;
	}
	public int getReaderid() {
		return readerid;
	}
	public void setReaderid(int readerId) {
		this.readerid = readerId;
	}
	public String getReadername() {
		return readername;
	}
	public void setReadername(String readerName) {
		this.readername = readerName;
	}
	public Date getBorrowdate() {
		return borrowdate;
	}
	public void setBorrowdate(Date timestamp) {
		this.borrowdate = timestamp;
	}
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returnDate) {
		this.returndate = returnDate;
	}
	public String getIsreturn() {
		return isreturn;
	}
	public void setIsreturn(String isReturn) {
		this.isreturn = isReturn;
	}
	
}
