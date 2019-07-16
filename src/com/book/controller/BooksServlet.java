package com.book.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Reader;
import com.book.service.BookService;
import com.book.service.BorrowService;
import com.book.service.ReaderService;
import com.book.service.impl.BookServiceImpl;
import com.book.service.impl.BorrowServiceImpl;
import com.book.service.impl.ReaderServiceImpl;
import com.book.util.JsonUtils;

/**
 * Servlet implementation class BooksServlet
 */
@WebServlet("/booksServlet")
public class BooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BookService bookService = new BookServiceImpl();
    ReaderService readerService = new ReaderServiceImpl();
    BorrowService borrowService = new BorrowServiceImpl();		
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String action = request.getParameter("act");
		System.out.println(action);
		
		switch(action){
			case "search":
				doSearch(request,response);
			    break;
			case "queryOneBook":
				doQueryOneBook(request,response);
				break;
			case "borrow":
				doBorrow(request,response);
				break;
			
	     }	
		
		}
	   //借书
	   public void doBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  
		   int bookid = Integer.parseInt(request.getParameter("bookid"));
		   int readerid = Integer.parseInt(request.getParameter("readerid"));
		   int borrowcount = Integer.parseInt(request.getParameter("borrowcount")) ;//借阅的本数
		   System.out.println("bookid"+bookid+"  "+"readerid"+readerid+" "+"borrowcount"+borrowcount);
		   Book book = bookService.getBookByBookid(bookid);
		   Reader reader = readerService.SelectById(readerid);
		   //组合borrow对象			
			Borrow borrow = new Borrow();			
			borrow.setBookid(book.getBookid());
			borrow.setBookname(book.getBookname());
			borrow.setReaderid(reader.getReaderid());
			borrow.setReadername(reader.getReadername());
			//根据借书的本数，插入多条数据
			for(int i=0;i<borrowcount;i++){
				//插入借阅表
		        borrowService.InsertBorrow(borrow);
		        //增加读者借阅的次数
		        readerService.addReaderBorrowNum(readerid);
			}	     
	        //库存图书的数量减少
	        borrowService.subBookNum(book.getBookid(), borrowcount);
	        request.getSession().setAttribute("msg", "借书成功！");
	        request.getRequestDispatcher("borrowServlet?act=list").forward(request, response);
	        
	        
		   
	   }
	
	     //根据bookid查询一条记录
		public void doQueryOneBook(HttpServletRequest request, HttpServletResponse response) throws IOException{
			String id = request.getParameter("bookid");
			int bookid = Integer.parseInt(id);
			System.out.println(bookid);
			Book book = bookService.getBookByBookid(bookid);
			//将对象转换成json
			String json = JsonUtils.objectToJson(book);
			response.getWriter().println(json);			
		}
	
	
	
	   //分页查询（带参数和无参数）
		public void doSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String bookname = request.getParameter("bookname");
          System.out.println(bookname);
          int currentPage = 1;
      	int pageSize = 4;
		  if(request.getParameter("currentPage")!=null){
			  String cp = request.getParameter("currentPage");	 
			  currentPage = Integer.parseInt(cp);			 
		  }
		  if(request.getParameter("pageSize")!=null){
			  String pz = request.getParameter("pageSize");
			  pageSize = Integer.parseInt(pz);	
		  }
		   
				 	  
		  List<Book> books= null;
		  long total ;
		  if(bookname!=null && !"".equals(bookname)){	
			  System.out.println("------------");
			  books =  bookService.selectPerPageBooksByBookname(currentPage, pageSize, bookname);
			  request.setAttribute("bookname", bookname);
			  total = bookService.getTotalpageOfBook(bookname);
			  int intTotal = Integer.parseInt(String.valueOf(total));
			  //计算出总页数
			  int totalPage = intTotal%pageSize==0 ? intTotal/pageSize:intTotal/pageSize+1;
			  request.setAttribute("totalPage", totalPage);
			  request.setAttribute("currentPage", currentPage);
			  request.setAttribute("pageSize", pageSize);
			  request.setAttribute("intTotal", intTotal);
			  request.setAttribute("books", books);			 
			  request.getRequestDispatcher("readers/borrowBook.jsp").forward(request, response);
		  }else{
			  books = bookService.selectPerPageBooks(currentPage, pageSize);
			  total = bookService.getTotalpageOfBook();
			  int intTotal = Integer.parseInt(String.valueOf(total));
			  //计算出总页数
			  int totalPage = intTotal%pageSize==0 ? intTotal/pageSize:intTotal/pageSize+1;
			  request.setAttribute("totalPage", totalPage);
			  request.setAttribute("currentPage", currentPage);
			  request.setAttribute("pageSize", pageSize);
			  request.setAttribute("intTotal", intTotal);
			  request.setAttribute("books", books);
			  request.getRequestDispatcher("readers/borrowBook.jsp").forward(request, response);
		  }
		  
		 
		}
		
		
		
		
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
