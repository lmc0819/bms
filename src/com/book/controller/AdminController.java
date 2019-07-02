package com.book.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.book.entity.Admin;
import com.book.entity.Book;
import com.book.entity.Borrow;
import com.book.entity.Reader;
import com.book.service.impl.AdminServiceImpl;
import com.book.util.JDBCutil;



@WebServlet("/admin")
public class AdminController extends BaseServlet {
	AdminServiceImpl admin=new AdminServiceImpl();

	public void SelectAllBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cp =request.getParameter("cp");
		int num=1;
		if(cp!=null){
			num=Integer.parseInt(cp);
		}
		int borrownum=admin.SelectBorrowNum();
		List<Borrow> list=new ArrayList();
		list=admin.SelectCpBorrow(num);
		request.setAttribute("bos", list);
		request.setAttribute("cp", num);
		request.setAttribute("count", borrownum);
		request.getRequestDispatcher("admins/borrowRecord.jsp").forward(request, response);

	}
	
	public void SelectAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String cp =request.getParameter("cp");
		int num=1;
		if(cp!=null){
			num=Integer.parseInt(cp);
		}
		int BookNum = admin.SelectBookNum();
		List<Book> list=new ArrayList();
		list=admin.SelectCpBook(num);
		request.setAttribute("bs", list);
		request.setAttribute("cp", num);
		request.setAttribute("count", BookNum);
		request.getRequestDispatcher("admins/bookInfo.jsp").forward(request, response);

	}
	public void SelectAllReader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cp =request.getParameter("cp");
		int num=1;
		if(cp!=null){
			num=Integer.parseInt(cp);
		}
		int ReaderNum = admin.SelectReaderNum();
		List<Reader> list=new ArrayList();
		list=admin.SelectCpReader(num);
		request.setAttribute("rs", list);
		request.setAttribute("cp", num);
		request.setAttribute("count", ReaderNum);
		request.getRequestDispatcher("admins/reader.jsp").forward(request, response);

	}
	public void DeleteReader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
	    String name=request.getParameter("name");
	    if(admin.SelectBorrow(name,id)){
	        admin.DeleteBorrow(name, id);
		    }
       
        admin.DeleteReader(id);
        response.sendRedirect("admin?act=SelectAllReader");

	}
	public void SelectReader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select=request.getParameter("select");
		String name=request.getParameter("name");
		List<Reader> list=new ArrayList();
		 list=admin.SelectReader(select, name);
		 request.setAttribute("rs", list);
		request.getRequestDispatcher("admins/reader.jsp").forward(request, response);

	}public void SelectBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value=request.getParameter("value");
		String name=request.getParameter("name");
		List<Borrow> list=new ArrayList();
		 list=admin.SelectBorrows(name, value);
		 request.setAttribute("bos", list);
		request.getRequestDispatcher("admins/borrowRecord.jsp").forward(request, response);

	}

	public void DeleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
	    String name=request.getParameter("name");
	    if(admin.SelectBorrow(name,id)){
        admin.DeleteBorrow(name, id);
	    }
	    admin.DeleteBook(id);
        response.sendRedirect("admin?act=SelectAllBook");

	}
	public void SelectBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		System.out.print(name+"  "+value);
		List<Book> list=new ArrayList();
		list= admin.SelectBook(name, value);
		 request.setAttribute("bs", list);
		request.getRequestDispatcher("admins/bookInfo.jsp").forward(request, response);

	}
	public void Update(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("bookid"));
		Book book = admin.SelectBookById(id);
		book.setBookname(new String(request.getParameter("bookname").getBytes("ISO8859-1"),"UTF-8"));
		book.setAuthor(new String(request.getParameter("author").getBytes("ISO8859-1"),"UTF-8"));
		book.setPhouse(new String(request.getParameter("phouse").getBytes("ISO8859-1"),"UTF-8"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = sdf.parse(new String(request.getParameter("pdate").getBytes("ISO8859-1"),"UTF-8"));
		java.sql.Date date = new java.sql.Date(dd.getTime());
		
		book.setPdate(date);
		book.setCategory(new String(request.getParameter("category").getBytes("ISO8859-1"),"UTF-8"));
		book.setBooknum(Integer.parseInt(request.getParameter("booknum")));
		book.setAction(new String(request.getParameter("action").getBytes("ISO8859-1"),"UTF-8"));
		book.setIntro(new String(request.getParameter("intro").getBytes("ISO8859-1"),"UTF-8"));
		
		
		admin.UpdateBook(book);
		
		response.sendRedirect("/BookManager/admin?act=SelectAllBook");
	}
	public void UpdateReader(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("readerid"));
		Reader r = admin.SelectReaderById(id);
		r.setReadername(new String(request.getParameter("readername").getBytes("ISO8859-1"),"UTF-8"));
		r.setRpassword(new String(request.getParameter("rpassword").getBytes("ISO8859-1"),"UTF-8"));
		r.setSex(new String(request.getParameter("sex").getBytes("ISO8859-1"),"UTF-8"));
		r.setSex(new String(request.getParameter("sex").getBytes("ISO8859-1"),"UTF-8"));
		r.setMobile(Long.parseLong(request.getParameter("mobile")));
		r.setDepartment(new String(request.getParameter("department").getBytes("ISO8859-1"),"UTF-8"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = sdf.parse(new String(request.getParameter("sxtime").getBytes("ISO8859-1"),"UTF-8"));
		java.sql.Date date = new java.sql.Date(dd.getTime());
		r.setSxtime(date);
		r.setBorrownumber(Integer.parseInt(request.getParameter("borrownumber")));
		admin.UpdateReader(r);;
		
		response.sendRedirect("/BookManager/admin?act=SelectAllReader");
	}
    public void UpdateAdmin(HttpServletRequest request, HttpServletResponse response)throws Exception{
    	request.setCharacterEncoding("UTF-8");
       int id=Integer.parseInt(request.getParameter("admid"));
       Admin a=admin.SelectAdmin(id);
       a.setAdminname(request.getParameter("adminname"));
       a.setSex(request.getParameter("sex"));
       a.setMobile(Long.parseLong(request.getParameter("mobile")));
       a.setAddress(request.getParameter("address"));
       a.setRemarks(request.getParameter("remarks"));
       admin.UpdateAdmin(a);
       HttpSession session=request.getSession();
       session.setAttribute("a", a);
       response.sendRedirect("admins/personInfo.jsp");
    }

}






