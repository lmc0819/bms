<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../bootstrap-3.3.7/css/bootstrap.min.css" />
		<script type="text/javascript" src="../js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="../bootstrap-3.3.7/js/bootstrap.min.js"></script>	
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
							 <a style="font-size: 20px;" href="books.html">馆藏查询</a>
						</li>
						 <li class="dropdown">
							 <a style="font-size: 20px;" href="#" class="dropdown-toggle" data-toggle="dropdown">借阅中心<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
							
								<li class="divider">
								</li>
								<li>
									 <a style="font-size: 20px;" href="borrow.html">我要借阅</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a style="font-size: 20px;" href="returnBook.html">我要归还</a>
								</li>
								<li class="divider">
								</li>
							</ul>
						</li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li>
							
							 <a style="font-size: 20px;" href="#">欢迎：XXXX</a>
						</li>
						<li>
							
							 <a style="font-size: 20px;" href="borrowHistory.html">我的借阅记录</a>
						</li>
						<li class="dropdown">
							 <a style="font-size: 20px;" href="#" class="dropdown-toggle" data-toggle="dropdown"><button class="btn btn-primary">个人中心</button><strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								
								<li>
									 <a style="font-size: 20px;" href="readerInfo.html">个人信息修改</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a style="font-size: 20px;" href="readerPassword.html">密码修改</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
				
			</nav>
			
		<!--表单开始-->
			<form class="form-horizontal" role="form" action="" method="post">
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">请输入原密码：</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="firstname" 
							   placeholder="请输入原密码">
					</div>
					<span>表单验证信息</span>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">请输入新密码：</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="lastname" 
							   placeholder="请输入新密码">
					</div>
					<span>表单验证信息</span>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">请再次输入新密码：</label>
					<div class="col-sm-4">
						<input type="password" class="form-control" id="lastname" 
							   placeholder="请再次输入新密码">
					</div>
					<span>表单验证信息</span>
				</div>
							    
				<div class="form-group col-sm-3" >
					<button type="submit" class="btn btn-primary">更改</button>  
					<button type="reset" class="btn btn-default">重置</button> 				 				    
				</div>   
							
		    </form>
		
		
		
	</body>
</html>
