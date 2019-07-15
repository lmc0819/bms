package com.book.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.entity.Admin;
import com.book.entity.Reader;
import com.book.service.AdminService;
import com.book.service.ReaderService;
import com.book.service.impl.AdminServiceImpl;
import com.book.service.impl.ReaderServiceImpl;

/**
 * Servlet implementation class FortgetPwdServlet
 */
@WebServlet("/fortgetPwdServlet")
public class FortgetPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ReaderService readerService = new ReaderServiceImpl();
    AdminService adminService = new AdminServiceImpl();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FortgetPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String phonenumber = request.getParameter("phonenumber");
		long mobile = Long.parseLong(phonenumber);
		String code = request.getParameter("checkCode");
		String newPwd = request.getParameter("newPwd");
		System.out.println("新密码是"+newPwd);
			
		//先判断手机验证码是否正确
		if(!code.equals((String) request.getSession().getAttribute("phoneCode"))){
			request.setAttribute("errorMsg", "验证码不正确!请检查");
			request.getRequestDispatcher("forgetpassword.jsp").forward(request, response);
		}else{
			//判断手机号是否存在
			Reader reader= readerService.SelectReaderByMobile(mobile);
			System.out.println(reader);
			if(reader!=null){
				//修改读者 的密码
				readerService.updatePasswordByMobile(mobile, newPwd);
			}else{
				request.setAttribute("errorMsg", "手机号码不存在，请注册");
				request.getRequestDispatcher("forgetpassword.jsp").forward(request, response);
			}
			Admin admin = adminService.selectAdminByMobile(mobile);
			System.out.println(admin);
			if(admin!=null){
				//修改管理员的密码
				adminService.updatePasswordByMobile(mobile, newPwd);				
			}else{
				request.setAttribute("errorMsg", "手机号码不存在，请注册");
				request.getRequestDispatcher("forgetpassword.jsp").forward(request, response);
			}	
			
			//转发
			request.getSession().setAttribute("msg", "修改成功！请重新登录");
			response.sendRedirect("login.jsp");
			
			
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
