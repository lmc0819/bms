package com.book.dao;

import java.util.List;

import com.book.entity.Admin;




public interface AdminDao {
	
	/**
	 * 查询管理员信息
	 */
	public Admin SelectByName(String name);
	public Admin SelectById(int id);
	
	
	/**
	 * 修改管理员信息
	 */
	public void UpdateAdmin(Admin admin);
	
	
	
}
