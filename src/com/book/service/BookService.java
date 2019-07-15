package com.book.service;

import java.util.List;

import com.book.entity.Book;

public interface BookService {
	
//-----读者部分开始↓--读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓------------------------------------------------------------------------------
	/*
	 * 根据bookid查询一条记录
	 */
	public Book getBookByBookid(int bookid);
	/*
	 * 获取书的总条数(有条件)
	 */	
	public long getTotalpageOfBook(String bookname);
	/*
	 * 获取书的总条数
	 */	
	public long getTotalpageOfBook();
	
	/*
	 * @查询每页的书籍（zhy）
	 */	
	public List<Book> selectPerPageBooks(int currentPage,int pageSize );
	/*
	 * 按书名查询每一页
	 */	
	public List<Book> selectPerPageBooksByBookname(int currentPage,int pageSize,String bookname);
//--读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑---
}
