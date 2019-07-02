package com.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.DriverManager;
import java.util.List;

import com.book.dao.BorrowDao;
import com.book.entity.Borrow;
import com.book.entity.Reader;
import com.book.util.JDBCutil;

public class BorrowDaoImpl implements BorrowDao {

	@Override
	public List<Borrow> SelectAllBorrow() {
		
		JDBCutil util=new JDBCutil();
		Connection con=util.getConn();
		String sql="select * from Borrow";
		return util.queryPreparedStatement(sql,null,Borrow.class);
		

		
	}

	@Override
	public List<Borrow> SelectByCp(int cp) {
String sql="select * from(select t1.* ,rownum num from (select * from borrow b order by borrowid desc) t1 where rownum<="+cp*10+") where rownum>"+(cp-1)*10;
          JDBCutil util=new JDBCutil();
          Connection con=util.getConn();
          return util.queryPreparedStatement(sql,null,Borrow.class);
	}

	@Override
	public List<Borrow> SelectById(int id) {
		
		String sql="select * from borrow where borrowId=?";
		 JDBCutil util=new JDBCutil();
         List<Object> psmts=new ArrayList();
         psmts.add(id);
      
       return   util.queryPreparedStatement(sql,psmts,Borrow.class);
		 
	}

	@Override
	public void InsertBorrow(Borrow borrow) {
		String sql="insert into borrow values(null, ?, ?, ?, ?, ?, ?, ?)";
		JDBCutil util=new JDBCutil();
		Connection con=util.getConn();
		List<Object> psmts=new ArrayList();
		psmts.add(borrow.getBookid());
		psmts.add(borrow.getReaderid());
		psmts.add(borrow.getBorrowdate());
		psmts.add(borrow.getReturndate());
		psmts.add(borrow.getIsreturn());
		psmts.add(borrow.getBookname());
		psmts.add(borrow.getReadername());
		util.updatePreparedStatement(sql,psmts);
	
		
	}

	@Override
	public void UpdateBorrow(Borrow borrow) {
		String sql="update borrow set bookid=?,readerid=?,borrowdate=?,returndate=?,isreturn=?,bookname=?,readername=? where borrowid=? ";
		
		JDBCutil util=new JDBCutil();
		
		List<Object> psmts=new ArrayList();
		psmts.add(borrow.getBookid());
		psmts.add(borrow.getReaderid());
		psmts.add(borrow.getBorrowdate());
		psmts.add(borrow.getReturndate());
		psmts.add(borrow.getIsreturn());
		psmts.add(borrow.getBookname());
		psmts.add(borrow.getReadername());
		psmts.add(borrow.getBorrowid());
		util.updatePreparedStatement(sql,psmts);
		
	}

	@Override
	public void DeleteBorrow(String name, int id) {
		JDBCutil util=new JDBCutil();
		
		String sql="delete from borrow where "+name+"="+id;
	
		
		util.updatePreparedStatement(sql,null);
	}

	@Override
	public List<Borrow> SelectBorrow(String name, int id) {
		JDBCutil util=new JDBCutil();
		
		String sql="select * from borrow where "+name+"="+id;
		
	    return	util.queryPreparedStatement(sql,null,Borrow.class);
		
	}

	@Override
	public List<Borrow> SelectBorrows(String name, String value) {
JDBCutil util=new JDBCutil();
		
		String sql="select * from borrow where "+name+" like '%"+value+"%'";
		
	    return	util.queryPreparedStatement(sql,null,Borrow.class);
	}

	@Override
	public int SelectBorrowNum() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			String sql="select count(*) from borrow";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			int count=0;
			if(rs.next()){
				count=rs.getInt(1);
			}
			return count;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return -1;
	}
	
	

}
