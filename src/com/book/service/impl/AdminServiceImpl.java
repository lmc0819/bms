package com.book.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.book.dao.AdminDao;
import com.book.dao.BookDao;
import com.book.dao.BorrowDao;
import com.book.dao.ReaderDao;
import com.book.dao.impl.AdminDaoImpl;
import com.book.dao.impl.BookDaoImpl;
import com.book.dao.impl.BorrowDaoImpl;
import com.book.dao.impl.ReaderDaoImpl;
import com.book.entity.Admin;
import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Reader;
import com.book.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao admindao=new AdminDaoImpl();
	BookDao bookdao=new BookDaoImpl();
	BorrowDao borrowdao=new BorrowDaoImpl();
	ReaderDao readerdao=new ReaderDaoImpl();
	@Override
	public boolean AdminLogin(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Admin SelectInformation(String name) {
		
		Admin admin = admindao.SelectByName(name);
		return admin;
	}

	@Override
	public void UpdateAdmin(Admin admin) {
		admindao.UpdateAdmin(admin);

	}

	@Override
	public List<Book> SelectCpBook(int cp) {
		List<Book> books = bookdao.SelectByCp(cp);
		return books;
	}

	@Override
	public List<Book> FuzzyQuery(String name) {
		List<Book> books = bookdao.SelectByName(name);
		return books;
	}

	@Override
	public List<Book> CategoryQuery(String category) {
		List<Book> books = bookdao.SelectByCate(category);
		return books;
	}

	@Override
	public List<Borrow> SelectCpBorrow(int cp) {
		List<Borrow> list = borrowdao.SelectByCp(cp);
		return list;
	}

	@Override
	public List<Reader> SelectCpReader(int cp) {
		List<Reader> list = readerdao.SelectByCp(cp);
		return list;
	}

	@Override
	public void UpdateReader(Reader reader) {
		readerdao.UpdateReader(reader);

	}

	@Override
	public void UpdateBorrow(Borrow borrow) {
		borrowdao.UpdateBorrow(borrow);

	}

	@Override
	public void UpdateBook(Book book) {
		bookdao.UpdateBook(book);

	}

	@Override
	public void InsertBook(Book book) {
		bookdao.InsertBook(book);

	}

	@Override
	public void InsertReader(Reader reader) {
		readerdao.InsertReader(reader);
	}

	@Override
	public void DeleteReader(int id) {
		readerdao.DeleteReader(id);

	}

	@Override
	public void DeleteBook(int id) {
		bookdao.DeleteBook(id);

	}

	@Override
	public void DeleteBorrow(String name, int id) {
		borrowdao.DeleteBorrow(name, id);
		
	}

	@Override
	public List<Reader> SelectReader(String select, String name) {
		if(name.equals("姓名")){
			return readerdao.SelectByName(select);
		}else{
			int id=Integer.parseInt(select);
			return readerdao.SelectById(id);
		}
		
	}

	@Override
	public boolean SelectBorrow(String name, int id) {
		List<Borrow> list=new ArrayList();
		list= borrowdao.SelectBorrow(name, id);
		if(list.isEmpty()){
			return false;
		}
		return true;
		
	}

	@Override
	public List<Book> SelectBook(String name, String value) {
		if(name.equals("name")){
			return bookdao.SelectByName(value);
		}else if(name.equals("id")){
			int id=Integer.parseInt(value);
			Book b=new Book();
			b= bookdao.SelectById(id);
			List<Book> list=new ArrayList();
			list.add(b);
			return list;
	    }else if(name.equals("category")){
	    	return bookdao.SelectByCate(value);
		}
		return null;
	}

	@Override
	public List<Borrow> SelectBorrows(String name, String value) {
		if(name.equals("id")){
			int id=Integer.parseInt(value);
			return borrowdao.SelectById(id);
		}
		return borrowdao.SelectBorrows(name, value);
	}
	@Override
	public int SelectBookNum() {
		int number = bookdao.SelectNumber();
		
		return number%10==0?number/10:number/10+1;
	}

	@Override
	public Book SelectBookById(int id) {
		return bookdao.SelectById(id);
	}

	@Override
	public int SelectReaderNum() {
		
		int number= readerdao.SelectReaderNum();
		return number%10==0?number/10:number/10+1;
	}

	@Override
	public Reader SelectReaderById(int id) {
		List<Reader> l=new ArrayList();
		l=readerdao.SelectById(id);
		return l.get(0);
	}

	@Override
	public int SelectBorrowNum() {
		int number= borrowdao.SelectBorrowNum();
		return number%10==0?number/10:number/10+1;
	}

	@Override
	public Admin SelectAdmin(int id) {
		return admindao.SelectById(id);
		
	}

}
