package com.book.dao;

import java.util.List;


import com.book.entity.Borrow;
import com.book.entity.Reader;

public interface BorrowDao {
	public List<Borrow> SelectAllBorrow();
	
	public void DeleteBorrow(String name, int id);
	
	public List<Borrow> SelectByCp(int cp);
	
	public List<Borrow> SelectBorrow(String name, int id);
	
	public List<Borrow> SelectById(int id);
	
	public List<Borrow> SelectBorrows(String name, String value);
	
	public int SelectBorrowNum();
	
	
	//读者部分开始--↓--	读者部分开始--↓--	读者部分开始--↓--	读者部分开始--↓--	读者部分开始--↓--	读者部分开始--↓--	读者部分开始--↓--	读者部分开始--↓--	读者部分开始--↓--	
		/*
		 * 还书
		 */
		public void returnBook(int borrowid);
		/*
		 * 获取归还图书的总条数(无条件)
		 */	
		public long getTotalpageOfUnReturnByReaderId(int readerid);
		
		/*
		 * 查询每页的待归还的记录
		 */	
		public List<Borrow> selectPerPageUnReturnByReaderId(int currentPage,int pageSize,int readerid );
		
		
		
		/*
		 * 查询未归还的图书
		 * 
		 */
		
		public List<Borrow> selectUnreturnBorrow(int readerid);
		/*
		 * 还书时 书的数量增加
		 */  
		
		public void addBookNum(int bookid,int count);
		/*
		 * 借书时 书的数量减少
		 */  
		public void subBookNum(int bookid ,int count);
			
		/*
		 * 获取借阅记录的总条数(无条件)
		 */	
		public long getTotalpageOfBorrowByReaderId(int readerid);
		
		/*
		 * @查询每页的借阅记录（zhy）
		 */	
		public List<Borrow> selectPerPageBorrowByReaderId(int currentPage,int pageSize,int readerid );
	
		//---读者部分结束↑------读者部分结束↑---读者部分结束↑---读者部分结束↑---读者部分结束↑---读者部分结束↑---读者部分结束↑---读者部分↑---读者部分↑---读者部分↑---读者部分↑---读者部分↑---读者部分↑---读者部分↑---------------------------------------------------------------
	
	
	
	public void InsertBorrow(Borrow borrow);
	public void UpdateBorrow(Borrow borrow);
	
	
	
	
}
