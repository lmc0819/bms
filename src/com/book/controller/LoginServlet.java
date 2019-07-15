package com.book.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.book.entity.Admin;
import com.book.entity.Reader;
import com.book.service.AdminService;
import com.book.service.ReaderService;
import com.book.service.impl.AdminServiceImpl;
import com.book.service.impl.ReaderServiceImpl;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReaderService readerService = new ReaderServiceImpl();  
    private AdminService adminService  = new AdminServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		
		String username = request.getParameter("username");
		//int userid = Integer.parseInt(request.getParameter("userId")) ;
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		String type = request.getParameter("type");
		String code = request.getParameter("checkCode");
		System.out.println(username+" "+password+" "+remember+" "+type+" "+code);
		Reader readerInfo = null ;
		Admin adminInfo = null;
		//判断用户或者管理员
		if("用户".equals(type)){	
		//用户登录开始
		readerInfo =readerService.findReaderByReadername(username);	
			//判断
			if(readerInfo != null){
				if(readerInfo.getRpassword().equals(password)){
					if (!code.equalsIgnoreCase((String) request.getSession().getAttribute("randCheckCode"))) {
						request.setAttribute("errorMsg", "验证码不正确");
						request.getRequestDispatcher("login.jsp").forward(request, response);
						//response.getWriter().println("<script> type='text/javascript'>window.alert('验证码错误！');window.location.href='login.jsp'</script>");
					}else{
						//密码正确，添加cookie
						if("true".equals(remember)){
						   String uname = URLEncoder.encode(username,"utf-8");
						   Cookie cookie1 = new Cookie("username",uname);
						   Cookie cookie2 = new Cookie("password",password);
						   Cookie cookie3 = new Cookie("remember","true");
						   cookie1.setMaxAge(60*60);
						   cookie2.setMaxAge(60*60);
						   cookie3.setMaxAge(60*60);
						   response.addCookie(cookie1);
						   response.addCookie(cookie2);		
						   response.addCookie(cookie3);	
						}else{
							//说明用户没有勾选记住密码，清除cookie
							Cookie c1 = new Cookie("username",null);
							Cookie c2 = new Cookie("password",null);
							Cookie c3 = new Cookie("remember","false");
							c1.setMaxAge(0);
							c2.setMaxAge(0);
							c3.setMaxAge(0);
							response.addCookie(c1);
							response.addCookie(c2);	
							response.addCookie(c3);								
						}
						//转发
						request.getSession().setAttribute("readerInfo", readerInfo);
						request.getRequestDispatcher("booksServlet?act=search").forward(request, response);					
					}					
				}else{
					request.setAttribute("errorMsg", "用户名或者密码错误，请检查!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
			}else{
				request.setAttribute("errorMsg", "用户不存在!请注册");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}	
			//用户登录结束
	}else{			
			//管理员登录开始
			adminInfo = adminService.SelectByName(username);			
			//判断
			if(adminInfo != null){
				if(adminInfo. getApassword().equals(password)){
					if (!code.equalsIgnoreCase((String) request.getSession().getAttribute("randCheckCode"))) {
						request.setAttribute("errorMsg", "验证码不正确");
						request.getRequestDispatcher("login.jsp").forward(request, response);
						//response.getWriter().println("<script> type='text/javascript'>window.alert('验证码错误！');window.location.href='login.jsp'</script>");
					}else{
						//密码正确，添加cookie
						
						if("true".equals(remember)){
						   Cookie cookie1 = new Cookie("username",request.getParameter("userId"));
						   Cookie cookie2 = new Cookie("password",password);
						   Cookie cookie3 = new Cookie("remember","true");
						   cookie1.setMaxAge(60*60);
						   cookie2.setMaxAge(60*60);
						   cookie3.setMaxAge(60*60);
						   response.addCookie(cookie1);
						   response.addCookie(cookie2);		
						   response.addCookie(cookie3);	
						}else{
							//说明用户没有勾选记住密码，清除cookie
							Cookie c1 = new Cookie("username",null);
							Cookie c2 = new Cookie("password",null);
							Cookie c3 = new Cookie("remember","false");
							c1.setMaxAge(0);
							c2.setMaxAge(0);
							c3.setMaxAge(0);
							response.addCookie(c1);
							response.addCookie(c2);	
							response.addCookie(c3);	
							
						}
						//转发
						session.setAttribute("admin", adminInfo);
						request.getRequestDispatcher("admin?act=SelectAllReader").forward(request, response);					
					}
					
					
				}else{
					request.setAttribute("errorMsg", "用户名或者密码错误，请检查!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				
			}else{
				request.setAttribute("errorMsg", "该管理员不存在!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}	
			//管理员登录结束

		}	
		
		System.out.println(readerInfo);	
		

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
