package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.book.dao.AdminDao;
import com.book.entity.Admin;
import com.book.util.JDBCutil;

public class AdminDaoImpl implements AdminDao{
	JDBCutil util=new JDBCutil();
	@Override
	public  Admin SelectByName(String name) {
		
		Admin admin=new Admin();
		List params=new ArrayList();
		params.add(name);
		List list = util.queryPreparedStatement("select * from ADMIN where adminname=?", params, Admin.class);
		util.close();	
		 if(list.isEmpty()){
	         return null;
	       }else{       	
	   		
	   		 return admin = (Admin)list.get(0);
	       }
		
	
	}

	@Override
	public void UpdateAdmin(Admin admin) {
	
		List params=new ArrayList();
		params.add(0,admin.getAdminname());
		params.add(1, admin.getSex());
		params.add(2, admin.getMobile());
		params.add(3, admin.getAddress());
		params.add(4, admin.getRemarks());
		params.add(5, admin.getAdmid());
		util.updatePreparedStatement("update admin set adminname=?,sex=?,mobile=?,address=?,remarks=? where admid=?", params);
		util.close();
	}
	


	@Override
	public Admin SelectById(int id) {
		Admin admin=new Admin();
		List params=new ArrayList();
		params.add(id);
		List list = util.queryPreparedStatement("select * from ADMIN where admid=?", params, Admin.class);
		admin = (Admin)list.get(0);
		util.close();	
		return admin;

	}
	@Override
	public Admin selectAdminByMobile(long mobile) {
		 String sql="select * from admin where mobile =?";
		   JDBCutil util=new JDBCutil();
	       Connection con=util.getConn();
	       List<Object> psmts=new ArrayList();
	       psmts.add(mobile);
	       List<Admin> list=new ArrayList();
	       list= util.queryPreparedStatement(sql,psmts,Admin.class);
	       Admin admin = new Admin();
	       if(list.isEmpty()){
	       	return null;
	       }else{       	
	    	   admin=list.get(0);
	       }		
			 return admin;
	}

	@Override
	public void updatePasswordByMobile(long mobile, String newPwd) {
		String sql="update admin set apassword = ? where mobile = ?";
		JDBCutil util=new JDBCutil();
		Connection con=util.getConn();
		List<Object> psmts=new ArrayList();
		psmts.add(newPwd);
		psmts.add(mobile);
		util.updatePreparedStatement(sql,psmts);		
	}

}
