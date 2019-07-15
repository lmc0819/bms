package com.book.dao;

import java.util.List;

import com.book.entity.Book;

public interface BookDao {
	/**
	 * 查询所有图书信息
	 * 
	 */
	public List<Book> SelectAllBook();
	/**
	 * 插入图书信息
	 */
	public void InsertBook(Book book);
	/**
	 * 删除图书信息
	 */
	public void DeleteBook(int id);
	/**
	 * 修改图书信息
	 */
	public void UpdateBook(Book book);
	
	
	/**
	 * 按照id查询图书信息
	 */
	public Book SelectById(int id);
	
	
	
	/**
	 * 按照Name实现模糊查询图书信息
	 */
	public List<Book> SelectByName(String name);
	
	/**
	 * 按照种类查询图书信息
	 */
	public List<Book> SelectByCate(String category);
	
	/**
	 * 按照分页查询图书信息
	 */
	public List<Book> SelectByCp(int cp);
	
	public int SelectNumber();
	
	//----读者部分开始↓-------读者部分开始↓-------读者部分开始↓-------读者部分开始↓-------读者部分开始↓-------读者部分开始↓-------读者部分开始↓-------读者部分开始↓-------读者部分开始↓---
		/*
		 * 根据bookid查询一条记录
		 */
		public Book getBookByBookid(int bookid);
		/*
		 * 获取书的总条数(有条件)
		 */	
		public long getTotalpageOfBook(String bookname);
		
		/*
		 * 获取书的总条数(无条件)
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
		
//		--读者部分结束↑---读者部分↑-读者部分↑-读者部分↑-读者部分↑-读者部分↑-读者部分↑-读者部分↑-读者部分↑-读者部分↑-读者部分↑-读者部分↑-读者部分↑-读者部分↑-读者部分↑-读者部分↑---------------------------------
}
