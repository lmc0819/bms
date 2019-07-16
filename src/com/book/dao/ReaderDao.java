package com.book.dao;

import java.util.List;


import com.book.entity.Reader;

public interface ReaderDao {
	
	public List<Reader> SelectAllReader();

	public List<Reader> SelectByCp(int cp);
	
	public void DeleteReader(int id);

	public void UpdateReader(Reader reader);

	public List<Reader> SelectByIdList(int id);
	
	public List<Reader> SelectByName(String name);
	
	public int SelectReaderNum();
	//---读者部分开始↓--读者部分开始↓--读者部分开始↓--读者部分开始↓--读者部分开始↓--读者部分开始↓--读者部分开始↓--读者部分开始↓--读者部分开始↓--读者部分开始↓--
		//插入读者信息（注册）
		public void InsertReader(Reader reader);
		//根据读者id修改密码
		public void updatePasswordByReaderId(int readerid ,String newpassword);	
		//更新用户个人信息
		public void updateReader(int readerid,long mobile,String sex, String department, String remarks);
		//按用户的名字查找用户
		public Reader findReaderByReadername(String readername);
		//按读者id查找用户
		public Reader SelectById(int id);
		//根据手机号修改用户密码
		public void updatePasswordByMobile(long mobile,String newPwd);
		//根据手机号查找用户
		public Reader SelectReaderByMobile(long mobile);
		//增加用户的借阅次数
		public void addReaderBorrowNum(int readerid);
	//----读者部分结束-↑↑------读者部分--↑↑---↑↑---↑↑-读者部分-----↑↑-----读者部分----读者部分-----↑↑---↑↑--↑↑---↑↑---↑↑---------↑↑---------↑↑---↑↑----↑↑---↑↑---------↑↑-----------------------------------------------------
		
}	
