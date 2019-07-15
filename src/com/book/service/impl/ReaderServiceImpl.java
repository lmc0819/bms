package com.book.service.impl;

import java.util.List;

import com.book.dao.ReaderDao;
import com.book.dao.impl.ReaderDaoImpl;
import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Reader;
import com.book.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    ReaderDao readerDao = new ReaderDaoImpl();
	
    
   
      
	@Override
	public boolean ReaderLogin(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Regist(Reader reader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BorrowBook(Borrow borrow, int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BackBook(Borrow borrow) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Renew(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateReader(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> SelectCpBook(int cp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> FuzzyQuery(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> CategoryQuery(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Borrow> QueryPrivate(int readerid) {
		// TODO Auto-generated method stub
		return null;
	}
	
//----------↓----↓----↓----↓----↓---------↓----↓-------↓----↓----↓	----↓----↓----↓----↓----↓----↓----↓----↓----↓----↓----↓

	@Override
	public void updatePasswordByMobile(long mobile, String newPwd) {
		// TODO Auto-generated method stub
		readerDao.updatePasswordByMobile(mobile, newPwd);
	}
	 @Override
	public Reader SelectById(int userid) {		
		return readerDao.SelectById(userid);
	}
	@Override
	public Reader SelectReaderByMobile(long mobile) {
		// TODO Auto-generated method stub
		return readerDao.SelectReaderByMobile(mobile);
	}

	@Override
	public Reader findReaderByReadername(String readername) {		
		return readerDao.findReaderByReadername(readername);
	}

	@Override
	public void updateReader(int readerid, long mobile, String sex, String department, String remarks) {				
		 readerDao.updateReader(readerid, mobile, sex, department, remarks);		
	}

	@Override
	public void updatePasswordByReaderId(int readerid, String newpassword) {
		readerDao.updatePasswordByReaderId(readerid, newpassword);
		
	}

	@Override
	public void InsertReader(Reader reader) {
	    readerDao.InsertReader(reader);
	}

	

}
