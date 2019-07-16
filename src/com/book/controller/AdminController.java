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
    /*查询所有借阅信息*/
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
	  /*查询所有书籍信息*/
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
	  /*查询所有读书信息*/
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
	/*删除用户和用户借阅信息*/
	public void DeleteReader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
	    String name=request.getParameter("name");
	    if(admin.SelectBorrow(name,id)){
	        admin.DeleteBorrow(name, id);
		    }
       
        admin.DeleteReader(id);
        request.getSession().setAttribute("mess","删除成功");
        response.sendRedirect("admin?act=SelectAllReader");

	}
	/*删除图书和图书借阅信息*/
	public void DeleteBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
	    String name=request.getParameter("name");
	    if(admin.SelectBorrow(name,id)){
        admin.DeleteBorrow(name, id);
	    }
	    admin.DeleteBook(id);
	    request.getSession().setAttribute("mess","删除成功");
        response.sendRedirect("admin?act=SelectAllBook");

	}
	/*用户查询*/
	public void SelectReader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select=request.getParameter("select");
		String name=request.getParameter("name");
		List<Reader> list=new ArrayList();
		 list=admin.SelectReader(select, name);
		 request.setAttribute("rs", list);
		request.getRequestDispatcher("admins/reader.jsp").forward(request, response);
		/*借阅信息查询*/
	}public void SelectBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String value=request.getParameter("value");
		String name=request.getParameter("name");
		List<Borrow> list=new ArrayList();
		 list=admin.SelectBorrows(name, value);
		 request.setAttribute("bos", list);
		request.getRequestDispatcher("admins/borrowRecord.jsp").forward(request, response);

	}

	/*书籍信息查询*/
	public void SelectBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		List<Book> list=new ArrayList();
		list= admin.SelectBook(name, value);
		 request.setAttribute("bs", list);
		request.getRequestDispatcher("admins/bookInfo.jsp").forward(request, response);

	}
	/*修改图书信息*/
	public void Update(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		int id = Integer.parseInt(request.getParameter("bookid"));
		Book book = admin.SelectBookById(id);
		book.setBookname(request.getParameter("bookname"));
		book.setAuthor(request.getParameter("author"));
		book.setPhouse(request.getParameter("phouse"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = sdf.parse(request.getParameter("pdate"));
		java.sql.Date date = new java.sql.Date(dd.getTime());
		
		book.setPdate(date);
		book.setCategory(request.getParameter("category"));
		book.setBooknum(Integer.parseInt(request.getParameter("booknum")));
		book.setAction(request.getParameter("action"));
		book.setIntro(request.getParameter("intro"));
		
		
		admin.UpdateBook(book);
		request.getSession().setAttribute("mess","修改成功");
		response.sendRedirect("/BookManager/admin?act=SelectAllBook");
	}
	public void UpdateReader(HttpServletRequest request, HttpServletResponse response) throws Exception{
		

		int id = Integer.parseInt(request.getParameter("readerid"));
		Reader r = admin.SelectReaderById(id);
		r.setReadername(request.getParameter("readername"));
		r.setRpassword(request.getParameter("rpassword"));
		r.setSex(request.getParameter("sex"));	
		r.setMobile(Long.parseLong(request.getParameter("mobile")));
		r.setDepartment(request.getParameter("department"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = sdf.parse(request.getParameter("sxtime"));
		java.sql.Date date = new java.sql.Date(dd.getTime());
		r.setSxtime(date);
		r.setBorrownumber(Integer.parseInt(request.getParameter("borrownumber")));
		admin.UpdateReader(r);
	    request.getSession().setAttribute("mess","修改成功");
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
       session.setAttribute("admin", a);
       request.getSession().setAttribute("mess","修改成功");
       response.sendRedirect("admins/personInfo.jsp");
    } public void UpdateAdminPwd(HttpServletRequest request, HttpServletResponse response)throws Exception{
    	request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("admid"));
        Admin a=admin.SelectAdmin(id);
        String pwd=request.getParameter("pwd");
        a.setAdmid(id);
        a.setApassword(pwd);
        admin.UpdateAdmin(a);
        HttpSession session=request.getSession();
        session.setAttribute("admin", a);
        request.getSession().setAttribute("mess","修改成功");
        response.sendRedirect("admins/personInfo.jsp");
     }
    public void validate(HttpServletRequest request, HttpServletResponse response)throws Exception{
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
    	String pwd=request.getParameter("pwd");
    	HttpSession session =request.getSession();
    	Admin a=(Admin) session.getAttribute("admin");
    	
    	if(pwd.equals(a.getApassword())){
    		response.getWriter().print("密码正确");
    	}else{
    		response.getWriter().print("密码错误");
    	}
    }
    public void quit(HttpServletRequest request, HttpServletResponse response)throws Exception{
    	request.getSession().removeAttribute("admin");
		response.sendRedirect("login.jsp");
    }

}






