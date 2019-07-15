package com.book.service.impl;

import java.util.List;

import com.book.dao.BorrowDao;
import com.book.dao.impl.BorrowDaoImpl;
import com.book.entity.Borrow;
import com.book.service.BorrowService;

public class BorrowServiceImpl implements BorrowService {
    BorrowDao borrowDao = new BorrowDaoImpl();
	@Override
	public void InsertBorrow(Borrow borrow) {
		borrowDao.InsertBorrow(borrow);
		
	}
	@Override
	public long getTotalpageOfBorrowByReaderId(int readerid) {		
		return borrowDao.getTotalpageOfBorrowByReaderId(readerid);
	}
	@Override
	public List<Borrow> selectPerPageBorrowByReaderId(int currentPage, int pageSize,int readerid) {
		return borrowDao.selectPerPageBorrowByReaderId(currentPage, pageSize,readerid);
	}
	@Override
	public void addBookNum(int bookid, int count) {
		 borrowDao.addBookNum(bookid, count);				
	}
	@Override
	public void subBookNum(int bookid, int count) {
		borrowDao.subBookNum(bookid, count);		
	}
	@Override
	public List<Borrow> selectUnreturnBorrow(int readerid) {
		// TODO Auto-generated method stub
		return borrowDao.selectUnreturnBorrow(readerid);
	}
	@Override
	public long getTotalpageOfUnReturnByReaderId(int readerid) {
		return borrowDao.getTotalpageOfUnReturnByReaderId(readerid);
	}
	@Override
	public List<Borrow> selectPerPageUnReturnByReaderId(int currentPage, int pageSize, int readerid) {
		return borrowDao.selectPerPageUnReturnByReaderId(currentPage, pageSize, readerid);
	}
	@Override
	public void returnBook(int borrowid) {
		 borrowDao.returnBook(borrowid);	
	}
  
}
