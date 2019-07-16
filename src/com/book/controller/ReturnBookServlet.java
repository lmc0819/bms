package com.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.dao.BorrowDao;
import com.book.dao.impl.BorrowDaoImpl;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/returnBookServlet")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BorrowDao borrowDao =  new BorrowDaoImpl();
			
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("act");
		System.out.println(action);
		switch(action){
		case "returnbook":
			doReturnbook(request,response);
			break;
		}
	}
	
	
	
	
	//归还图书
	public void doReturnbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int borrowid = Integer.parseInt(request.getParameter("borrowid"));
		int bookid = Integer.parseInt(request.getParameter("bookid"));
		//归还图书
		borrowDao.returnBook(borrowid);		
		//将库存的数的数量加一
		borrowDao.addBookNum(bookid, 1);
		request.getSession().setAttribute("returnMsg", "还书成功！");
		//转发至还书页面
		request.getRequestDispatcher("borrowServlet?act=unReturnList").forward(request, response);		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
