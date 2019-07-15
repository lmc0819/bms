package com.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Reader;
import com.book.service.ReaderService;
import com.book.service.impl.ReaderServiceImpl;

/**
 * Servlet implementation class ReaderServlet
 */
@WebServlet("/readerServlet")
public class ReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReaderService readerService = new ReaderServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String action = request.getParameter("act");
		switch(action){
		case "updateInfo":
			doUpdateInfo(request,response);
			break;
		case "updatePassword":
			doUpdatePassword(request,response);
			break;
		case "validateUsername":
			doValidateUsername(request,response);
			break;
		case "register":
			doRegister(request,response);
			break;
			
		}
	}
	//读者注册
	public void doRegister(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String readername = request.getParameter("username");
		String rpassword = request.getParameter("password");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("mobile");
		long mobile = Long.valueOf(phone);
		String department = request.getParameter("department");
		int borrownumber = 0;//借阅次数默认为0
		String remarks = request.getParameter("remarks");
		Reader reader = new Reader();
		reader.setReadername(readername);
		reader.setRpassword(rpassword);
		reader.setSex(sex);
		reader.setMobile(mobile);
		reader.setDepartment(department);
		reader.setBorrownumber(borrownumber);
		reader.setRemarks(remarks);		
		//插入读者信息
		readerService.InsertReader(reader);
		response.getWriter().println("<script>alert('恭喜！注册成功，请登录');window.location.href='login.jsp'</script>");
		
	}
	
	
	//验证用户名是否存在
	public void doValidateUsername(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String username = request.getParameter("username");
		//根据用户名查找用户
		Reader reader = readerService.findReaderByReadername(username);
		if(reader!=null){
			response.getWriter().print("用户名已存在，换个用户名吧！");
		}else{
			response.getWriter().println("");
		}
	}
	
	
	//用户修改密码
	public void doUpdatePassword(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String password = request.getParameter("password");
		String newpassword = request.getParameter("newpassword");
		Reader reader = (Reader)request.getSession().getAttribute("readerInfo");
		int readerid = reader.getReaderid();
		//判断用户输入的原密码是否正确
		Reader reader1 = readerService.SelectById(readerid);
		if(password.equals(reader1.getRpassword())){
			//密码正确，修改密码
			readerService.updatePasswordByReaderId(readerid, newpassword);
			response.getWriter().println("<script>alert('密码修改成功！');window.location.href='booksServlet?act=search'</script>");
		}else{
			//密码不正确，重新输入
			request.setAttribute("updatePasswordMsg", "原密码输入不正确！请检查");
			request.getRequestDispatcher("${pageContext.request.contextPath }/readers/updateReaderPassword.jsp").forward(request, response);			
		}
	}
	
	
	//用户修改个人信息
	public void doUpdateInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//获取值
		long mobile = Long.parseLong(request.getParameter("mobile"));
		Reader reader = (Reader)request.getSession().getAttribute("readerInfo");
		int readerid = reader.getReaderid();
		String sex = request.getParameter("sex");
		String department = request.getParameter("department");
		String remarks = request.getParameter("remarks");
		//System.out.println(mobile+" "+readerid+" "+sex+" "+department+" "+remarks);
		//更新用户信息
		readerService.updateReader(readerid, mobile, sex, department, remarks);
		//更新用户信息
		Reader readerInfo = readerService.SelectById(readerid);
		request.getSession().setAttribute("readerInfo", readerInfo);
		//转发
		response.getWriter().println("<script>alert('个人信息修改成功！');window.location.href='booksServlet?act=search'</script>");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
