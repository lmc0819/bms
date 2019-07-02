package com.book.dao.impl;

import java.util.ArrayList;

import java.util.List;

import com.book.dao.ReaderDao;
import com.book.entity.Borrow;
import com.book.entity.Reader;
import com.book.util.JDBCutil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReaderDaoImpl implements ReaderDao {

	@Override
	public List<Reader> SelectAllReader() {
		JDBCutil util=new JDBCutil();
		
		String sql="select * from reader";
		return util.queryPreparedStatement(sql,null,Reader.class);
	}



	@Override
	public List<Reader> SelectByCp(int cp) {
String sql="select * from(select t1.* ,rownum num from (select * from reader r order by readerid desc) t1 where rownum<="+cp*10+") where rownum>"+(cp-1)*10;
	
		JDBCutil util=new JDBCutil();
     
        return util.queryPreparedStatement(sql,null,Reader.class);
	}

	@Override
	public void DeleteReader(int id) {
		String sql="delete from reader where readerid=?";
		JDBCutil util=new JDBCutil();
        Connection con=util.getConn();
        List<Object> psmts=new ArrayList();
        psmts.add(id);
        util.updatePreparedStatement(sql,psmts);
	}	

	@Override
	public void UpdateReader(Reader reader) {
		String sql="update reader set rpassword = ?,readername = ?,sex = ?,mobile = ?,department = ?,borrownumber = ?,remarks = ? where readerid = ?";
		JDBCutil util=new JDBCutil();
		Connection con=util.getConn();
		List<Object> psmts=new ArrayList();
		psmts.add(reader.getRpassword());
		psmts.add(reader.getReadername());
		psmts.add(reader.getSex());
		psmts.add(reader.getMobile());
		psmts.add(reader.getDepartment());
		psmts.add(reader.getBorrownumber());
		psmts.add(reader.getRemarks());
		psmts.add(reader.getReaderid());
		util.updatePreparedStatement(sql,psmts);
		
	}

	@Override
	public void InsertReader(Reader reader) {
		String sql="insert into Reader values(null, ?, ?, ?, ?, ?, ?, ?,?)";
		JDBCutil util=new JDBCutil();
		Connection con=util.getConn();
		List<Object> psmts=new ArrayList();
		psmts.add(reader.getRpassword());
		psmts.add(reader.getReadername());
		psmts.add(reader.getSex());
		psmts.add(reader.getMobile());
		psmts.add(reader.getDepartment());
		psmts.add(reader.getSxtime());
		psmts.add(reader.getBorrownumber());
		psmts.add(reader.getRemarks());
		util.updatePreparedStatement(sql,psmts);
	}

	@Override
	public List<Reader> SelectById(int id) {

		String sql="select * from reader where readerid=?";
		 JDBCutil util=new JDBCutil();
        Connection con=util.getConn();
        List<Object> psmts=new ArrayList();
        psmts.add(id);
        return  util.queryPreparedStatement(sql,psmts,Reader.class);
		
		 
		
	}





	@Override
	public List<Reader> SelectByName(String name) {
		
		String sql="select * from reader where readername like '%"+name+"%'";
		 JDBCutil util=new JDBCutil();
    
       List<Reader> list=new ArrayList();
        return  util.queryPreparedStatement(sql,null,Reader.class);
		
		
	}



	@Override
	public int SelectReaderNum() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			String sql="select count(*) from reader";
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
