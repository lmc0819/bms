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
}
