package com.book.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.book.entity.Book;
import com.book.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class Img
 */
@WebServlet("/Imgservlet")
public class Img extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminServiceImpl admin=new AdminServiceImpl();   
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("UTF-8");
		List<FileItem> list = upload.parseRequest(request);
		
		Book b=new Book();
		for(FileItem item:list){
			if(item.isFormField()){
				String name = item.getFieldName();// name="username"
				String value = item.getString();
				
				if(name.equals("bookname")){
					 value=new String(value.getBytes("iso8859-1"),"utf-8");
					b.setBookname(value);
				}else if(name.equals("author")){
					 value=new String(value.getBytes("iso8859-1"),"utf-8");
				    b.setAuthor(value);
				}else if(name.equals("phouse")){
					 value=new String(value.getBytes("iso8859-1"),"utf-8");
				    b.setPhouse(value);
				}else if(name.equals("pdate")){
					java.util.Date  date  =  new SimpleDateFormat("yyyy-MM-dd").parse(value);     
					java.sql.Date  sqlDate  =  new java.sql.Date(date.getTime()); 
				    b.setPdate(sqlDate);
				}else if(name.equals("intro")){
					 value=new String(value.getBytes("iso8859-1"),"utf-8");
				    b.setIntro(value);
				}else if(name.equals("booknum")){
					int num=Integer.parseInt(value);
				    b.setBooknum(num);
				}else if(name.equals("action")){
					 value=new String(value.getBytes("iso8859-1"),"utf-8");
				    b.setAction(value);
				}
				else if(name.equals("category")){
					 value=new String(value.getBytes("iso8859-1"),"utf-8");
				    b.setCategory(value);
				}
			}else{
				
				InputStream is = item.getInputStream();
				String filename = item.getName();
				String subfix = filename.substring(filename.indexOf("."));
				String nfilename = new Date().getTime()+subfix;
				
				File file = new File("E:\\蓝桥学习\\upload\\"+nfilename);
				if(!file.exists()){
					file.createNewFile();
				}
				
				FileOutputStream fos = new FileOutputStream(file);
			
				byte[] bs = new byte[512];
				int len=-1;
				while((len=is.read(bs))!=-1){
					fos.write(bs,0,len);
				}
				is.close();
				fos.close();
				b.setPhoto("/image/"+nfilename);
				admin.InsertBook(b);
			}
			}
		      request.getRequestDispatcher("admin?act=SelectAllBook").forward(request, response);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
