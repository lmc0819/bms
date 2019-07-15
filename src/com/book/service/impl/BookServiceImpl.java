package com.book.service.impl;

import java.util.List;

import com.book.dao.BookDao;
import com.book.dao.impl.BookDaoImpl;
import com.book.entity.Book;
import com.book.service.BookService;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
	@Override
	public List<Book> selectPerPageBooks(int currentPage, int pageSize) {
		
		return bookDao.selectPerPageBooks(currentPage, pageSize);
	  
	}

	@Override
	public List<Book> selectPerPageBooksByBookname(int currentPage, int pageSize, String bookname) {
		return bookDao.selectPerPageBooksByBookname(currentPage, pageSize, bookname);
	}

	@Override
	public long getTotalpageOfBook() {		
		return bookDao.getTotalpageOfBook();
	}

	@Override
	public long getTotalpageOfBook(String bookname) {		
		return bookDao.getTotalpageOfBook(bookname);
	}

	@Override
	public Book getBookByBookid(int bookid) {
		return bookDao.getBookByBookid(bookid);
	}
	

}
