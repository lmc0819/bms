package com.book.service;

import java.util.List;

import com.book.entity.Admin;
import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Reader;

public interface AdminService {

	public boolean AdminLogin(String name,String password);

	public Admin SelectInformation(String name);
	public Admin SelectAdmin(int id);

	public void UpdateAdmin(Admin admin);

	public List<Book> SelectCpBook(int cp);

	public List<Book> FuzzyQuery(String name);

	public List<Book> CategoryQuery(String category);
	public List<Book> SelectBook(String name,String value);

	public List<Borrow> SelectCpBorrow(int cp);

	public List<Reader> SelectCpReader(int cp);
	
	public List<Reader> SelectReader(String select,String name);

	public void UpdateReader(Reader reader);
	
	
	public void UpdateBorrow(Borrow borrow);
	
	public void UpdateBook(Book book);
	
	public void InsertBook(Book book);

	public void InsertReader(Reader reader);
	
	public void DeleteReader(int id);
	
	public void DeleteBook(int id);

	public void DeleteBorrow(String name,int id);
	public boolean SelectBorrow(String name,int id);
	public List<Borrow> SelectBorrows(String name,String value);
	
	public int SelectBookNum();
	public int SelectReaderNum();
	public int SelectBorrowNum();
	public Book SelectBookById(int id);
	public Reader SelectReaderById(int id);
}
