<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-3.3.7/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-3.3.7/js/bootstrap.min.js"></script>		
	</head>
	<body>
<div class="container">
	
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />	
			<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a style="font-size: 20px;" class="navbar-brand" href="#">欢迎使用图书管理系统</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li >
							 <a style="font-size:20px" href="${pageContext.request.contextPath }/booksServlet?act=search">馆藏查询</a>
						</li>
						
						<li class="dropdown">
							 <a style="font-size:20px" href="#" class="dropdown-toggle" data-toggle="dropdown">借阅中心<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
							
								<li class="divider">
								</li>
								<li>
									 <a style="font-size:20px" href="${pageContext.request.contextPath }/booksServlet?act=search">我要借阅</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a style="font-size:20px" href="${pageContext.request.contextPath }/borrowServlet?act=unReturnList">我要归还</a>
								</li>
								<li class="divider">
								</li>
							</ul>
						</li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li>
							
							 <a style="font-size:20px" href="#">欢迎：${readerInfo.readername } 用户</a>
						</li>
						<li>
							
							 <a style="font-size:20px" href="${pageContext.request.contextPath }/borrowServlet?act=list">我的借阅记录</a>
						</li>
						<li class="dropdown">
							 <a style="font-size:20px" href="#" class="dropdown-toggle" data-toggle="dropdown">个人中心<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								
								<li>
									 <a style="font-size:20px" href="updateReaderInfo.jsp">个人信息修改</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a style="font-size:20px" href="updateReaderPassword.jsp">密码修改</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a style="font-size:20px" href="${pageContext.request.contextPath }/logoutServlet">退出</a>
								</li>
								<li class="divider">
								</li>
							</ul>
						</li>
					</ul>
				</div>
				
			</nav>
			<p style="color:red">${updatePasswordMsg }</p>
		<!--表单开始-->
			<form onsubmit="return checkAll()" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/readerServlet?act=updatePassword" method="post" id="updatePasswordForm">
			    <h2 style="color:red">${updatePasswordMsg }</h2>
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">请输入原密码：</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="password" name="password" onblur="checkPassword()"
							   placeholder="请输入原密码">
					</div>
					<span id="passwordMsg" style="color:red"></span> 
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">请输入新密码：</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="newPassword"  onblur="checkNewPassword()"
							   placeholder="请输入新密码" />
					</div>
					<span id="newPasswordMsg" style="color:blue"><font>提示：密码长度6~18位，必须包含字母,数字或下划线</font></span>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">请再次输入新密码：</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="reNewPassword" name="newpassword" onblur="checkReNewPassword()"
							   placeholder="请再次输入新密码">
					</div>
					<span id="reNewPasswordMsg" style="color:red"></span>
				</div>
							    
				<div class="form-group col-sm-3" >
					<button type="submit" class="btn btn-primary" onclick="updatePassword()">修改</button>  
					<button type="reset" class="btn btn-default">重置</button> 				 				    
				</div>   
							
		    </form>		
	</body>
	
	<script type="text/javascript">
     function checkPassword(){
    	 var password = $("#password").val();
    	// alert(password)
    	 if(password.trim().length==0){
    		 $("#passwordMsg").html("请输入密码！");
    		 return false;
    	 }   
    	return true;
     }
     
     function checkNewPassword(){  	 
    	 var newpassword = $("#newPassword").val().trim();
    	 if(newpassword.length>18 || newpassword.length<6 ){   		
    		 $("#newPasswordMsg").html("<font style='color:red'>密码长度不合法,请换个密码！</font>");
    		 return false;
    	 }
    	  var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$/;
    	  if(!reg.test(newpassword)){   		 
    		  $("#newPasswordMsg").html("<font style='color:red'>必须包含字母,数字或下划线</font>");
    		  return false;
    	  }else{
    		  $("#newPasswordMsg").html("<font style='color:green'>√</font>");
    		  return true;
    	  }
    	  return true;     	
     }
     function checkReNewPassword(){
    	 if(checkNewPassword()){   		 
    		 var renewpassword = $("#reNewPassword").val().trim();
    		  if(renewpassword.length!=0){
    			    var newpassword = $("#newPassword").val().trim();			    	
			    	 if(newpassword != renewpassword){
			    		 $("#reNewPasswordMsg").html("两次密码输入不一致,请检查！")
			    		 return false;
			    	 }else{
			    		 $("#reNewPasswordMsg").html("<font style='color:green'>√</font>");
			   		  return true;
			    	 }
			    	  return true; 
    		  }else{
    			  $("#reNewPasswordMsg").html("请再次输入密码！")
    			  return false;
    		  }
			    	 
    	 }else{
    		 return false;
    	 } 	 
     }
     
     function checkAll(){
    	 if(checkPassword()&&checkNewPassword()&&checkReNewPassword()){
    		 return true;
    	 }else{
    		 return false;
    	 }
     }
     
      function updatePassword(){
    	var flag =  window.confirm("确认要修改密码吗？")
    	if(flag==true){
    		$("#updatePasswordForm").submit();
    	}
     } 
     
    </script>
</html>

