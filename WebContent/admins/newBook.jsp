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
							 <a href="#">欢迎：${sessionScope.admin.adminname }</a>											 
						</li>
						<li class="dropdown">
									 <a href="#" class="dropdown-toggle" data-toggle="dropdown">个人中心<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
																			
										<li>
											 <a href="personInfo.jsp">个人信息修改</a>
										</li>
										<li class="divider">
										</li>
										<li>
											 <a href="updatePassword.jsp">修改密码</a>
										</li>
											<li class="divider">
										</li>
										<li>
											 <a href="/BookManager/admin?act=quit">退出</a>
										</li>
										
									</ul>
					</li>
						
					</ul>
				</div>
				
			</nav>
			
			<p class="lead">
				<strong>新书入库系统：</strong> 
			</p>
			<!--表单开始-->
			<form class="form-horizontal" role="form" action="/BookManager/Imgservlet" method="post" enctype="multipart/form-data">
			          <input type="hidden" class="form-control" id="firstname" name="act" value="InsertBook">
				<div class="form-group">
					<label for="firstname" class="col-sm-2 control-label">书名</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="firstname" name="bookname">
					</div>
				
				</div>
				<hr />
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">作者</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="lastname" name="author">
					</div>
				</div>
				<hr />
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">出版社</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="lastname" name="phouse">
					</div>
				
				</div>
				<hr />
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">出版日期</label>
					<div class="col-sm-4">
						<input type="date" class="form-control" id="lastname" name="pdate">
							 
					</div>
					
				</div>
				<hr />
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">简介</label>
					<div class="col-sm-4">
						<!-- <input type="textarea" class="form-control" id="lastname" name="intro"> -->
						<textarea class="form-control" id="lastname" name="intro" rows="" cols="" ></textarea>
					</div>
				</div>
				<hr />
					<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">数量</label>
					<div class="col-sm-4">
						<input type="number" class="form-control" id="lastname" name="booknum">
					</div>
				</div>
				<hr />
					<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">位置</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="lastname" name="action">
					</div>
				</div>
				<hr />
					<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">分类</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="lastname" name="category">
					</div>
				</div>
				<hr />

				 
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">上传图片</label>
					<div class="col-sm-4">
						<input type="file" name="file" />
					</div>
					
				</div>
				<hr />

				<div class="form-group col-sm-3" >
					<button type="submit" class="btn btn-primary">添加</button>  
					<button type="reset" class="btn btn-default">重置</button> 
				 				    
				</div>   
				
				
				
     
						   
				
				
		    </form>
			
			
			
			
			
			
			
			
			
		</div>
	</div>
</div>



			<!--弹出层-->
            <div class="modal fade" id="modal-container-751906" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
									<h4 class="modal-title" id="myModalLabel">
										修改个人信息
									</h4>
								</div>
								<form></form>
								<div class="modal-body">
									<form action="" method="post">
					                    <div class="form-group">
					                        <label for="recipient-name" class="control-label">字段1:</label>
					                        <input type="text" class="form-control" id="recipient-name">
					                    </div>
					                    <div class="form-group">
					                        <label for="message-text" class="control-label">字段2:</label>
					                        <input type="text" class="form-control" id="recipient-name">
					                    </div>
					                    <div class="form-group">
					                        <label for="message-text" class="control-label">字段3:</label>
					                        <input type="text" class="form-control" id="recipient-name">
					                    </div>
					                    <div class="form-group">
					                        <label for="message-text" class="control-label">字段4:</label>
					                        <input type="text" class="form-control" id="recipient-name">
					                    </div>
					                </form>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">取消</button> 
									<button type="submit" class="btn btn-primary">修改</button>
								</div>
								</form>
							</div>
		
						</div>
		
		    </div>
 			<!--弹出层结束-->


	</body>
</html>
