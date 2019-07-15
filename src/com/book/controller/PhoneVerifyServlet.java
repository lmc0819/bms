package com.book.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.util.SendSmsUtil;

/**
 * Servlet implementation class PhoneVerifyServlet
 */
@WebServlet("/phoneVerifyServlet")
public class PhoneVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhoneVerifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		//随机生成4位验证码
		StringBuilder codebuilder =new StringBuilder();//定义变长字符串
    	Random random=new Random();
    	for(int i=0;i<6;i++){
    		codebuilder.append(random.nextInt(10));
    	}
    	String code = codebuilder.toString();
		SendSmsUtil.send(phone, code);
		request.getSession().setAttribute("phoneCode", code);
		response.getWriter().println("true");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
