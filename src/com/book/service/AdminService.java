package com.book.service;

import java.util.List;

import com.book.entity.Admin;
import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Reader;

public interface AdminService {
	
	public int SelectBookNum();
	
	public int SelectReaderNum();
	
	public int SelectBorrowNum();
	
	public List<Borrow> SelectCpBorrow(int cp);
	
	public List<Book> SelectCpBook(int cp);
	
	public List<Reader> SelectCpReader(int cp);
	/*管理员登录*/
	public  Admin SelectByName(String adminname);
	
	public void DeleteBorrow(String name,int id);
	
	public boolean SelectBorrow(String name,int id);
	
	public void DeleteReader(int id);
	
	public List<Reader> SelectReader(String select,String name);
	
	public void DeleteBook(int id);
	
	public List<Borrow> SelectBorrows(String name,String value);
	
	public List<Book> SelectBook(String name,String value);
	
	public Book SelectBookById(int id);
	
	public void UpdateBook(Book book);
	
	public Reader SelectReaderById(int id);
	
	public void UpdateReader(Reader reader);
		
	public Admin SelectAdmin(int id);
	
	public void UpdateAdmin(Admin admin);
	
	public void InsertBook(Book book);
	
	public void InsertReader(Reader reader);
	
    public Admin selectAdminByMobile(long mobile);
	
	public void updatePasswordByMobile(long mobile,String newPwd);
	
/*	public boolean AdminLogin(String name,String password);
	public Admin SelectInformation(String name);	
	public List<Book> FuzzyQuery(String name);
	public List<Book> CategoryQuery(String category);
	public void UpdateBorrow(Borrow borrow);
	*/
	
	
	
	
}
