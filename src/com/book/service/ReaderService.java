package com.book.service;

import java.util.List;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Reader;

public interface ReaderService {
	
	
//-----读者部分开始↓--读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓---------------------	
	//插入读者信息（注册）
	public void InsertReader(Reader reader);
	
	public void updatePasswordByReaderId(int readerid ,String newpassword);
	
	public void updateReader(int readerid,long mobile,String sex, String department, String remarks);
	
	public Reader findReaderByReadername(String readername);

	public void updatePasswordByMobile(long mobile,String newPwd);
	
	public Reader SelectReaderByMobile(long mobile);
		
	public Reader SelectById(int id);	
	
	public void addReaderBorrowNum(int readerid);
//--读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑--	
	
	
	
	
	/**
	 * 读者登录验证功能
	 */
	public boolean ReaderLogin(String name,String password);
	
	/**
	 * 注册
	 */
	public void Regist(Reader reader);
	
	/**
	 * 借书
	 */
	public void BorrowBook(Borrow borrow,int id);
	
	/**
	 * 还书
	 */
	public void BackBook(Borrow borrow);
	
	/**
	 * 续借
	 */
	public void Renew(int id);
	/**
	 * 修改个人信息
	 */
	public void UpdateReader(int  id);
	
	/**
	 * 页码查询图书信息
	 */
	public List<Book> SelectCpBook(int cp);
	/**
	 * 模糊查询图书信息
	 */
	public List<Book> FuzzyQuery(String name);
	/**
	 * 种类查询图书信息
	 */
	public List<Book> CategoryQuery(String category);
	
	/**
	 * 查询自己借阅的图书信息
	 */
	public List<Borrow> QueryPrivate(int readerid);
}
