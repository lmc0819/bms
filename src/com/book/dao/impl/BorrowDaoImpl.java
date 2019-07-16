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
import com.book.entity.BorrowCount;
import com.book.entity.Reader;
import com.book.util.JDBCutil;

public class BorrowDaoImpl implements BorrowDao {
	JDBCutil util=new JDBCutil();
	@Override
	public List<Borrow> SelectAllBorrow() {
		
		JDBCutil util=new JDBCutil();
		Connection con=util.getConn();
		String sql="select * from Borrow";
		return util.queryPreparedStatement(sql,null,Borrow.class);
		

	}

	@Override
	public List<Borrow> SelectByCp(int cp) {
String sql="select * from(select t1.* ,rownum num from (select * from borrow b order by borrowid desc) t1 where rownum<="+cp*10+") where num>"+(cp-1)*10;
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
	//-----读者部分开始↓--读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓-读者部分开始↓------------------------------------------------------------------------------
		@Override
		public long getTotalpageOfBorrowByReaderId(int readerid) {
			String sql = "select count(*) count from borrow where readerid ="+readerid;	
			BorrowCount borrowCount = (BorrowCount) util.queryPreparedStatement(sql, null, BorrowCount.class).get(0);	
			return borrowCount.getCount();	
		}

		@Override
		public List<Borrow> selectPerPageBorrowByReaderId(int currentPage, int pageSize,int readerid) {
			String sql="select * from (select t1.*,rownum num  "
					+ "from (select * from borrow e where readerid = "+readerid+" order by borrowid asc) t1"
					+ " where rownum<="+currentPage*pageSize+") "
							+ "where num>"+(currentPage-1)*pageSize;
			List<Borrow> borrows = util.queryPreparedStatement(sql, null, Borrow.class);
			return borrows;
		}

		@Override
		public void subBookNum(int bookid,int count) {
			String sql = "update book set booknum=booknum-"+ count+" where bookid = "+bookid;
			util.updatePreparedStatement(sql, null);		
		}

		@Override
		public void addBookNum(int bookid, int count) {
			String sql = "update book set booknum=booknum+"+ count+" where bookid = "+bookid;
			util.updatePreparedStatement(sql, null);				
		}

		@Override
		public List<Borrow> selectUnreturnBorrow(int readerid) {
			String sql = "select * from borrow where isreturn = '否' and readerid = "+readerid;
			List<Borrow> unreturns = util.queryPreparedStatement(sql, null, Borrow.class);
			return unreturns;
		}

		@Override
		public long getTotalpageOfUnReturnByReaderId(int readerid) {
			String sql = "select count(*) count from borrow where isreturn='否' and readerid ="+readerid;
			BorrowCount borrowCount = (BorrowCount) util.queryPreparedStatement(sql, null, BorrowCount.class).get(0);	
			return borrowCount.getCount();	
		}

		@Override
		public List<Borrow> selectPerPageUnReturnByReaderId(int currentPage, int pageSize, int readerid) {
			String sql="select * from (select t1.*,rownum num  "
					+ "from (select * from borrow e where isreturn='否' and readerid = "+readerid+" order by borrowid asc) t1"
					+ " where rownum<="+currentPage*pageSize+") "
							+ "where num>"+(currentPage-1)*pageSize;
			List<Borrow> unreturn = util.queryPreparedStatement(sql, null, Borrow.class);
			return unreturn;
		}

		@Override
		public void returnBook(int borrowid) {
			String sql = "update borrow set isreturn ='是' where borrowid ="+borrowid;
			util.updatePreparedStatement(sql, null);	
		} 
		
	//--读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑----读者部分结束↑---

	@Override
	public void InsertBorrow(Borrow borrow) {
		String sql= "insert into borrow values(null,?,?,sysdate,sysdate+30,'否',?, ? )";
		JDBCutil util=new JDBCutil();
		Connection con=util.getConn();
		List<Object> psmts=new ArrayList();
		psmts.add(borrow.getBookid());
		psmts.add(borrow.getReaderid());
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


}
