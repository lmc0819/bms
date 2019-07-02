package com.book.dao;

import java.util.List;


import com.book.entity.Borrow;
import com.book.entity.Reader;

public interface BorrowDao {
	
	public List<Borrow> SelectAllBorrow();
	
	public List<Borrow> SelectByCp(int cp);
	
	public List<Borrow> SelectById(int id);
	
	public void InsertBorrow(Borrow borrow);
	
	
	public void UpdateBorrow(Borrow borrow);
	public void DeleteBorrow(String name, int id);
	public List<Borrow> SelectBorrow(String name, int id);
	public List<Borrow> SelectBorrows(String name, String value);
	public int SelectBorrowNum();
}
