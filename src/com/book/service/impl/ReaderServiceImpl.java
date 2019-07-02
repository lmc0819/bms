package com.book.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.book.dao.impl.BookDaoImpl;
import com.book.dao.impl.BorrowDaoImpl;
import com.book.dao.impl.ReaderDaoImpl;
import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Reader;
import com.book.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {

	@Override
	public boolean ReaderLogin(String name, String password) {
		ReaderDaoImpl dao=new ReaderDaoImpl();
		List<Reader> list=new ArrayList();
		list=dao.SelectByName(name);
		Reader r=list.get(0);
		if(r.getReadername().equals(name)&&r.getRpassword().equals(password)){
			return true;
		}
		return false;
	}

	@Override
	public void Regist(Reader reader) {
		ReaderDaoImpl dao=new ReaderDaoImpl();
		dao.InsertReader(reader);

	}

	@Override
	public void BorrowBook(Borrow borrow) {
       BorrowDaoImpl dao=new BorrowDaoImpl();
         dao.InsertBorrow(borrow); 

	}

	@Override
	public void BackBook(Borrow borrow) {
		BorrowDaoImpl dao=new BorrowDaoImpl();
        dao.UpdateBorrow(borrow);

	}

	@Override
	public void Renew(Borrow borrow) {
		BorrowDaoImpl dao=new BorrowDaoImpl();
        dao.UpdateBorrow(borrow);
	}

	@Override
	public void UpdateReader(Reader reader) {
		ReaderDaoImpl dao=new ReaderDaoImpl();
		dao.UpdateReader(reader);

	}

	@Override
	public List<Book> SelectCpBook(int cp) {
		BookDaoImpl dao=new BookDaoImpl();
		return dao.SelectByCp(cp);
	}

	@Override
	public List<Book> FuzzyQuery(String name) {
		BookDaoImpl dao=new BookDaoImpl();
		return dao.SelectByName(name);
	}

	@Override
	public List<Book> CategoryQuery(String category) {
		BookDaoImpl dao=new BookDaoImpl();
		return dao.SelectByCate(category);
	}

	@Override
	public List<Borrow> QueryPrivate(int readerid) {
		BorrowDaoImpl dao=new BorrowDaoImpl();
       return dao.SelectById(readerid);
	}

}
