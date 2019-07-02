package com.book.dao;

import java.util.List;


import com.book.entity.Reader;

public interface ReaderDao {
	/** 
	 * 鏌ヨ鎵�鏈夎鑰呬俊鎭�
	*/	
	public List<Reader> SelectAllReader();
	/**
	 * 鎸夌収鍒嗛〉鏌ヨ璇昏�呬俊鎭�
	 */
	public List<Reader> SelectByCp(int cp);
	
	/**
	 * 鍒犻櫎璇昏�呬俊鎭�
	 */
	public void DeleteReader(int id);
	
	/**
	 * 淇敼璇昏�呬俊鎭�
	 */
	public void UpdateReader(Reader reader);
	/**
	 * 鎻掑叆璇昏�呬俊鎭�
	 */
	public void InsertReader(Reader reader);
	
	public List<Reader> SelectById(int id);
	
	public List<Reader> SelectByName(String name);
	public int SelectReaderNum();
	
}	
