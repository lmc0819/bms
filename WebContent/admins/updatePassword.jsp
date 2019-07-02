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
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default navbar-inverse" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">图书管理系统</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li>
						<a href="/BookManager/admin?act=SelectAllReader">读者信息管理</a>
						</li>
					<li class="dropdown">
									 <a href="#" class="dropdown-toggle" data-toggle="dropdown">图书管理<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										
										
										<li>
											 <a href="/BookManager/admin?act=SelectAllBook">图书信息管理</a>
										</li>
										<li class="divider">
										</li>
										<li>
											 <a href="admins/newBook.jsp">新书入库管理</a>
										</li>
										
										
									</ul>
					</li>
					
					<li>
						<a href="/BookManager/admin?act=SelectAllBorrow">借阅信息管理</a>
					</li>
					
					
					
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li class="active">
							 <a href="#">欢迎：张三</a>											 
						</li>
						<li class="dropdown">
									 <a href="#" class="dropdown-toggle" data-toggle="dropdown">个人中心<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
																			
										<li>
											 <a href="admins/personInfo.jsp">个人信息修改</a>
										</li>
										<li class="divider">
										</li>
										<li>
											 <a href="admins/updatePassword.jsp">修改密码</a>
										</li>
										
										
									</ul>
					</li>
						
					</ul>
				</div>
				
			</nav>
			
			<p class="lead">
				<strong>密码修改：</strong> 
			</p>
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
						
		</div>
	</div>
</div>



		

	</body>
</html>
