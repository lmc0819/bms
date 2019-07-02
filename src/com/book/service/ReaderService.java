package com.book.service;

import java.util.List;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Reader;

public interface ReaderService {
	/**
	 * 璇昏�呯櫥褰曢獙璇佸姛鑳�
	 */
	public boolean ReaderLogin(String name,String password);
	
	/**
	 * 娉ㄥ唽
	 */
	public void Regist(Reader reader);
	
	/**
	 * 鍊熶功
	 */
	public void BorrowBook(Borrow borrow);
	
	/**
	 * 杩樹功
	 */
	public void BackBook(Borrow borrow);
	
	/**
	 * 缁��
	 */
	public void Renew(Borrow borrow);
	/**
	 * 淇敼涓汉淇℃伅
	 */
	public void UpdateReader(Reader reader);
	
	/**
	 * 椤电爜鏌ヨ鍥句功淇℃伅
	 */
	public List<Book> SelectCpBook(int cp);
	/**
	 * 妯＄硦鏌ヨ鍥句功淇℃伅
	 */
	public List<Book> FuzzyQuery(String name);
	/**
	 * 绉嶇被鏌ヨ鍥句功淇℃伅
	 */
	public List<Book> CategoryQuery(String category);
	
	/**
	 * 鏌ヨ鑷繁鍊熼槄鐨勫浘涔︿俊鎭�
	 */
	public List<Borrow> QueryPrivate(int readerid);
}
