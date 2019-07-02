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
						<li >
							
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
			<div class="page-header">
				<h1>
					我的借阅历史：
				</h1>
			</div>
			
			<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" />
							<input type="text" class="form-control" />
							<input type="text" class="form-control" />
						</div> <button type="submit" class="btn btn-primary">搜索</button>
						
			</form>
			
			
			
			
			
			
			
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							产品
						</th>
						<th>
							交付时间
						</th>
						<th>
							状态
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Default
						</td>
					</tr>
					<tr class="success">
						<td>
							1
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							01/04/2012
						</td>
						<td>
							Approved
						</td>
					</tr>
					<tr class="error">
						<td>
							2
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							02/04/2012
						</td>
						<td>
							Declined
						</td>
					</tr>
					<tr class="warning">
						<td>
							3
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							03/04/2012
						</td>
						<td>
							Pending
						</td>
					</tr>
					<tr class="info">
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
					</tr>
				</tbody>
			</table>
			<ul class="pagination">
				<li>
					 <a href="#">Prev</a>
				</li>
				<li>
					 <a href="#">1</a>
				</li>
				<li>
					 <a href="#">2</a>
				</li>
				<li>
					 <a href="#">3</a>
				</li>
				<li>
					 <a href="#">4</a>
				</li>
				<li>
					 <a href="#">5</a>
				</li>
				<li>
					 <a href="#">Next</a>
				</li>
			</ul>
		</div>
	</div>
</div>
		
		
		
		
		
		
	</body>
</html>
