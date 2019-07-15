<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="穷在闹市" />
		<!-- 作者 -->
		<meta name="revised" content="穷在闹市.v3, 2019/05/01" />
		<!-- 定义页面的最新版本 -->
		<meta name="description" content="网站简介" />
		<!-- 网站简介 -->
		<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
		<title>图书管理系统</title>

		<!-- 公共样式 开始 -->
		<link rel="shortcut icon" href="images/favicon.ico"/>
		<link rel="bookmark" href="images/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/iconfont.css">
		<script type="text/javascript" src="framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
		<script type="text/javascript" src="layui/layui.js"></script>
		<!-- 公共样式 结束 -->
		
		<link rel="stylesheet" type="text/css" href="css/login1.css">
		<script type="text/javascript" src="js/login1.js"></script>
		<script type="text/javascript" src="js/jquery.cookie.js""></script>
				
		<%
			String mess = (String) session.getAttribute("msg");
			if (mess == null|| mess.equals("")){		
			}		
			else {
		%>
		<script type="text/javascript">
		        alert("<%=mess%>");
		</script>		
		<%
		  session.setAttribute("msg", "");
		%>
		<%
			}
		%>
		
		
	</head>

	<body>
		<!-- <div class="loginBg"></div> -->
		
		
		<br>
		<br>
		<br>
		<br>
		
		<br>
	  
	  
	    
		<div class="login_main">
		   <p style="font-size: 30px; text-align:center;"><b>欢迎使用图书管理系统</b></p>
			<div class="box">
				 <div class="left">
					<!-- <img src="images/logo.png" />-->
					<p>请登录:</p>
					<br/>
					<span style="color:red">${errorMsg }</span>
				</div> 
				<div class="right">
					<form class="layui-form layui-form-pane" action="loginServlet" method="post">
						<div class="layui-form-item">
							<label class="layui-form-label login_title"><i class="iconfont icon-gerenzhongxin-denglu"></i></label>
							<div class="layui-input-block login_input">
								<input id="username" type="text" name="username" required lay-verify="required" autocomplete="off" placeholder="请输入您的用户名" class="layui-input">
							</div>
						</div>
					
						
						<div class="layui-form-item">
							<label class="layui-form-label login_title"><i class="iconfont icon-mima1"></i></label>
							<div class="layui-input-block login_input">
								<input id="password" type="password" name="password" required lay-verify="required" autocomplete="off" placeholder="请输入密码" class="layui-input">
							         忘记密码？<a href="forgetpassword.jsp"  style="font-size:12px;color:blue" >点我</a>
							</div>
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label login_title"><i class="iconfont icon-mima1"></i></label>
							<div class="layui-input-block login_input">
								<input id="remember" type="text" name="checkCode" required lay-verify="required" autocomplete="off" placeholder="请输入验证码" class="layui-input">
							</div>
							<br/>
							 <img src="${pageContext.request.contextPath }/pictureCheckCode" id="CreateCheckCode" >
							 <a href="javascript:void(0)" onclick="myReload()" style="font-size:12px;color:blue">看不清,换一个</a>
						</div>
						
						<div class="layui-form-item">
							<input type="radio" name="type" value="用户" title="用户"  checked lay-filter="userType">
							<input type="radio" name="type" value="管理员" title="管理员" lay-filter="userType">
							
						</div>
						<div class="layui-form-item">
							<input id="remember" name="remember" value="true" type="checkbox" checked="checked"  />记住密码							
						</div>
												
						<div class="layui-form-item">
							<p>没有账号？<a style="color:blue" href="register.jsp">去注册</a></p>
						</div>
						<br/>
						<div class="layui-form-item">
							<button type="submit" class="layui-btn layui-btn-fluid login_but" lay-submit lay-filter="loginBut">登 录</button>
						</div>
						
					</form>
				</div>
			</div>
		</div>
		<script>
			layui.use('form', function() {
				var form = layui.form;
				
				//监听用户类型，改变风格
				form.on('radio(userType)', function(data){
					if(data.value == "用户"){
						$(".loginBg").css("background","url('images/login_admin_bg.jpg')");
						$(".login_but").css("cssText", "background-color:#57c201 !important");
					}
					if(data.value == "管理员"){
						$(".loginBg").css("background","url('images/login_sh_bg.jpg')");
						$(".login_but").css("cssText", "background-color:#16c6f9 !important");
					}
					
				});
			});
			
			
			
			$("input[name='userId']").bind("blur",function(){
				var readername = $(this).val().trim();
				if(readername.length==0){
					alert("用户名不能为空")
				}
			})
			
			 function myReload() {
			    document.getElementById("CreateCheckCode").src = 
			    	document.getElementById("CreateCheckCode").src+ "?nocache=" + new Date().getTime();
			  }
			
			

			 if($.cookie("remember")=="true"){
				 var password = $.cookie("password");		 
				 var username = $.cookie("username");
				 		 //填充用户名和密码
				 $("#username").val(username);
				 $("#password").val(password);
				 $("#remember").prop("checked",true); 
			 }
             
			 
			 
			 
			 
			 
					
		</script>
	</body>

</html>