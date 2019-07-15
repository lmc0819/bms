package com.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BorrowDao;
import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Reader;
import com.book.service.BorrowService;
import com.book.service.impl.BorrowServiceImpl;

/**
 * Servlet implementation class BorrowServlet
 */
@WebServlet("/borrowServlet")
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BorrowService borrowService = new BorrowServiceImpl();   
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String action = request.getParameter("act");
		System.out.println(action);
		switch(action){
		case "list":
			doList(request,response);
			break;
		case "unReturnList":
			doUnReturnList(request,response);
			break;
		}
	}
	
	
	//查询未归还的图书（带分页）
	public void doUnReturnList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 int currentPage = 1;
		 int pageSize = 3;
		if(request.getParameter("currentPage")!=null){
			  String cp = request.getParameter("currentPage");	 
			  currentPage = Integer.parseInt(cp);			 
		  }
		  if(request.getParameter("pageSize")!=null){
			  String pz = request.getParameter("pageSize");
			  pageSize = Integer.parseInt(pz);	
		  }		  
		  Reader readerInfo =  (Reader)request.getSession().getAttribute("readerInfo");
		  //查询总记录数和每一页的内容
		  List<Borrow>  unreturns = borrowService.selectPerPageUnReturnByReaderId(currentPage, pageSize, readerInfo.getReaderid());
		  long  total = borrowService.getTotalpageOfUnReturnByReaderId(readerInfo.getReaderid());
		  int intTotal = Integer.parseInt(String.valueOf(total));
		  //计算出总页数
		  int totalPage = intTotal%pageSize==0 ? intTotal/pageSize:intTotal/pageSize+1;
		  request.setAttribute("totalPage", totalPage);
		  request.setAttribute("currentPage", currentPage);
		  request.setAttribute("pageSize", pageSize);
		  request.setAttribute("intTotal", intTotal);
		  request.setAttribute("unreturns", unreturns);  
		  request.getRequestDispatcher("readers/returnBook.jsp").forward(request, response);			
	}
	
	
	
	//借阅信息列表
	public void doList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{		
		 int currentPage = 1;
		 int pageSize = 3;
	  if(request.getParameter("currentPage")!=null){
		  String cp = request.getParameter("currentPage");	 
		  currentPage = Integer.parseInt(cp);			 
	  }
	  if(request.getParameter("pageSize")!=null){
		  String pz = request.getParameter("pageSize");
		  pageSize = Integer.parseInt(pz);	
	  }		  
	  Reader readerInfo =  (Reader)request.getSession().getAttribute("readerInfo");
	  //调用底层方法
	  List<Borrow>  borrows = borrowService.selectPerPageBorrowByReaderId(currentPage, pageSize,readerInfo.getReaderid());
	  long  total = borrowService.getTotalpageOfBorrowByReaderId(readerInfo.getReaderid());
	  int intTotal = Integer.parseInt(String.valueOf(total));
	  //计算出总页数
	  int totalPage = intTotal%pageSize==0 ? intTotal/pageSize:intTotal/pageSize+1;
	  request.setAttribute("totalPage", totalPage);
	  request.setAttribute("currentPage", currentPage);
	  request.setAttribute("pageSize", pageSize);
	  request.setAttribute("intTotal", intTotal);
	  request.setAttribute("borrows", borrows);  
	  request.getRequestDispatcher("readers/borrowHistory.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
