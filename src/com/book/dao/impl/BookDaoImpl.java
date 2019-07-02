package com.book.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



import com.book.dao.BookDao;
import com.book.entity.Admin;
import com.book.entity.Book;
import com.book.util.JDBCutil;

public class BookDaoImpl implements BookDao {
	JDBCutil util=new JDBCutil();
	
	@Override
	public List<Book> SelectAllBook() {
		
		List books = util.queryPreparedStatement("select * from book", null, Book.class);	
		util.close();
		return books;
		
		
		/*
		List<Book> books=new ArrayList<Book>();
		Statement st=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,username,password);
			
			st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from book");
			
			while(rs.next()){
				int bookId = rs.getInt(1);
				String bookName = rs.getString(2);
				String author = rs.getString(3);
				String phouse = rs.getString(4);
				Date pdate = rs.getDate(5);
				String intro = rs.getString(6);
				int bookNum = rs.getInt(7);
				String action = rs.getString(8);
				String category = rs.getString(9);
				
				Book book=new Book(bookId, bookName, author, phouse, pdate, intro, bookNum, action, category);
				books.add(book);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		*/
		
		
	}
	
	@Override
	public void InsertBook(Book book) {
		String sql="insert into book(bookid,bookName, author, phouse, pdate, intro, "
				+ "bookNum, action, category,photo)values(null,?, ?, ?, ?, ?, ?, ?, ?,?)";
		List params=new ArrayList();
		params.add(0,book.getBookname());
		params.add(1, book.getAuthor());
		params.add(2,book.getPhouse());
		params.add(3, book.getPdate());
		params.add(4, book.getIntro());
		params.add(5, book.getBooknum());
		params.add(6, book.getAction());
		params.add(7, book.getCategory());	
		params.add(8,book.getPhoto());
		util.updatePreparedStatement(sql, params);
		/*Connection con=null;
		PreparedStatement psmt=null;
		String sql="insert into book(bookid,bookName, author, phouse, pdate, intro, "
				+ "bookNum, action, category)values(null,?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			con = JDBCutil.getCon();
			psmt = con.prepareStatement(sql);
			psmt.setObject(1, book.getBookName());
			psmt.setObject(2, book.getAuthor());
			psmt.setObject(3, book.getPhouse());
			psmt.setObject(4, book.getPdate());
			psmt.setObject(5, book.getIntro());
			psmt.setObject(6, book.getBookNum());
			psmt.setObject(7, book.getAction());
			psmt.setObject(8, book.getCategory());
			
			psmt.execute();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(psmt!=null){
					psmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
*/
	}

	@Override
	public void DeleteBook(int id) {
		String sql="delete from book where bookid=?";
		List params=new ArrayList();
		params.add(id);
		util.updatePreparedStatement(sql, params);
		
		/*Connection con=null;
		PreparedStatement psmt=null;
		try {
			con = JDBCutil.getCon();
			String sql="delete from book where bookid=?";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, id);
			boolean b = psmt.execute();
			if(b==false){
				return 1;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(psmt!=null){
					psmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
	}

	@Override
	public void UpdateBook(Book book) {
		String sql="update book set bookName=?,author=?,phouse=?,pdate=?,intro=? ,bookNum=?,action=?,category=?,photo=?where bookId=?";
		List params=new ArrayList();
		params.add(0,book.getBookname());
		params.add(1, book.getAuthor());
		params.add(2,book.getPhouse());
		params.add(3, book.getPdate());
		params.add(4, book.getIntro());
		params.add(5, book.getBooknum());
		params.add(6, book.getAction());
		params.add(7, book.getCategory());	
		params.add(8, book.getPhoto());
		params.add(9, book.getBookid());	
		util.updatePreparedStatement(sql, params);
		/*String sql="update book set bookName=?,author=?,phouse=?,pdate=?,intro=? ,bookNum=?,action=?,category=?where bookId=?";
		try {
			Connection con = JDBCutil.getCon();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, book.getBookName());
			ps.setObject(2, book.getAuthor());
			ps.setObject(3,book.getPhouse());
			ps.setObject(4,book.getPdate());
			ps.setObject(5,book.getIntro());
			ps.setObject(6,book.getBookNum());
			ps.setObject(7,book.getAction());
			ps.setObject(8,book.getCategory());
			ps.setObject(9,book.getBookId());
			
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	@Override
	public Book SelectById(int id) {
		Book book=new Book();
		List params=new ArrayList();
		params.add(id);
		List list = util.queryPreparedStatement("select * from book where bookid=?", params, Book.class);
		book=(Book)list.get(0);
		return book;
		/*try {
			
			Connection con = JDBCutil.getCon();
			PreparedStatement prst = con.prepareStatement("select * from book where bookid=?");
			prst.setObject(1, id);
			ResultSet rs = prst.executeQuery();
			
			while(rs.next()){
				int bookId = rs.getInt(1);
				String bookName = rs.getString(2);
				String author = rs.getString(3);
				String phouse = rs.getString(4);
				Date pdate = rs.getDate(5);
				String intro = rs.getString(6);
				int bookNum = rs.getInt(7);
				String action = rs.getString(8);
				String category = rs.getString(9);
				
				book=new Book(bookId, bookName, author, phouse, pdate, intro, bookNum, action, category);
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
		
	}

	@Override
	public List<Book> SelectByName(String name) {
		
		List params=new ArrayList();
		params.add(name);
		List books = util.queryPreparedStatement("select * from book where bookName=?", params, Book.class);
		return books;
		/*try {
			
			Connection con = JDBCutil.getCon();
			PreparedStatement prst = con.prepareStatement("select * from book where bookName=?");
			prst.setObject(1, name);
			ResultSet rs = prst.executeQuery();
			
			while(rs.next()){
				int bookId = rs.getInt(1);
				String bookName = rs.getString(2);
				String author = rs.getString(3);
				String phouse = rs.getString(4);
				Date pdate = rs.getDate(5);
				String intro = rs.getString(6);
				int bookNum = rs.getInt(7);
				String action = rs.getString(8);
				String category = rs.getString(9);
				
				Book book=new Book(bookId, bookName, author, phouse, pdate, intro, bookNum, action, category);
				books.add(book);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
		
	}

	@Override
	public List<Book> SelectByCate(String category) {
		List params=new ArrayList();
		params.add(category);
		List books = util.queryPreparedStatement("select * from book where category=?", params, Book.class);
		return books;
		/*try {
			
			Connection con = JDBCutil.getCon();
			PreparedStatement prst = con.prepareStatement("select * from book where category=?");
			prst.setObject(1, category);
			ResultSet rs = prst.executeQuery();
			
			while(rs.next()){
				int bookId = rs.getInt(1);
				String bookName = rs.getString(2);
				String author = rs.getString(3);
				String phouse = rs.getString(4);
				Date pdate = rs.getDate(5);
				String intro = rs.getString(6);
				int bookNum = rs.getInt(7);
				String action = rs.getString(8);
				String category1 = rs.getString(9);
				
				Book book=new Book(bookId, bookName, author, phouse, pdate, intro, bookNum, action, category1);
				books.add(book);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
		
	}

	@Override
	public List<Book> SelectByCp(int cp) {
		
		String sql="select * from (select t1.*,rownum num  from (select * from book e order by bookid asc) t1 where rownum<="+cp*10+") where num>"+(cp-1)*10;
		List books = util.queryPreparedStatement(sql, null, Book.class);
		return books;
		/*String sql="select * from ("
				+ "select t1.*,rownum num  from ("
				+ "select * from book e order by bookid asc) t1 "
				+ "where rownum<="+cp*10+") "
				+ "where num>"+(cp-1)*10;
		
		try {
			Connection con = JDBCutil.getCon();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){
				int bookId = rs.getInt(1);
				String bookName = rs.getString(2);
				String author = rs.getString(3);
				String phouse = rs.getString(4);
				Date pdate = rs.getDate(5);
				String intro = rs.getString(6);
				int bookNum = rs.getInt(7);
				String action = rs.getString(8);
				String category = rs.getString(9);
				
				Book book=new Book(bookId, bookName, author, phouse, pdate, intro, bookNum, action, category);
				books.add(book);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	public static void main(String[] args) {
		BookDao dao=new BookDaoImpl();
		/*List<Book> list = dao.SelectAllBook();
		for(Book b:list){
			System.out.println(b);
		}
		java.util.Date date = new java.util.Date();
		long time = date.getTime();
		Book book=new Book("鑻辫", "鑼冪敇杩硶", "鍖楀ぇ鍑虹増绀�",new Date(time), "aa", 100, "涓夋ゼ鍖椾晶", "璇█");
		dao.InsertBook(book);*/
		/*java.util.Date date = new java.util.Date();
		long time = date.getTime();
		List<Book> list = dao.SelectAllBook();
		for(Book b:list){
			b.setBooknum(55);
			b.setPdate(new Date(time));
			dao.UpdateBook(b);
			System.out.println(b);
		}*/
	//	Book book = dao.SelectById(10012);
	//	System.out.println(book);
		/*List<Book> list = dao.SelectByCp(1);
		for(Book b:list){
			System.out.println(b);
		}*/
		List<Book> list2 = dao.SelectByCate("鏁版嵁搴�");
		for(Book b:list2){
			System.out.println(b);
		}
		List<Book> list = dao.SelectAllBook();
		for(Book b:list){
			System.out.println(b);
		}
		
	}
	@Override
	public int SelectNumber() {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl","scott","admin");
			String sql="select count(*) from book";
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
