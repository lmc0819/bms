<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>	
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
											 <a href="admins/personInfo.jsp">个人信息修改</a>
										</li>
										<li class="divider">
										</li>
										<li>
											 <a href="admins/updatePassword.jsp">修改密码</a>
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
				<strong>借阅信息管理：</strong> 
			</p>
			
			<form class="navbar-form navbar-left" role="search" action="/BookManager/admin">
			          <input type="hidden" class="form-control" name="act"  value="SelectBorrow"/>
						<div class="form-group">
							<input type="text" class="form-control" name="value" />
						</div> 
						<div class="form-group">
							<select name="name">
							<option value="bookname">书名</option>
							<option value="readername">读者</option>
							<option value="id">id</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">搜索</button>
					</form>
			<table class="table table-bordered">
				<thead>
					<tr >
						<th>
							编号
						</th>
						<th>
							书名
						</th>
						<th>
							读者
						</th>
						<th>
							借阅日期
						</th>
						<th>
							归还日期
						</th>
						<th>
							是否归还
						</th>
					
						
					</tr>
				</thead>
				<tbody>
				<c:set var="index" value="0"/> 
				<c:forEach items="${requestScope.bos }" var="b">
					<tr class="success">
						<td name="borrowid">${b.borrowid }</td>
						<td name="bookname">
							${b.bookname }
						</td>
						<td>
							${b.readername}
						</td>
						<td>
							${b.borrowdate }
						</td>
						<td>
							${b.returndate }
						</td>
						<td>
							${b.isreturn }
						</td>
						
						
						
					</tr>
					</c:forEach>
					
				</tbody>
			</table>
											
			<div style="text-align: center;">
		    	<ul class="pagination" >
					<li class=${requestScope.cp==1?"disabled":""}><a href="/BookManager/admin?act=SelectAllBorrow&cp=${requestScope.cp-1<=0?1:requestScope.cp-1}">&laquo;</a></li>
					<c:forEach var="i" begin="1" end="${requestScope.count }" step="1"> 
						<li class=${requestScope.cp==i ?"active":""}><a href="/BookManager/admin?act=SelectAllBorrow&cp=${i}"><c:out value="${i}" /></a></li>
					</c:forEach>	
					<li class=${requestScope.cp==requestScope.count?"disabled":""}><a href="/BookManager/admin?act=SelectAllBorrow&cp=${requestScope.cp+1>requestScope.count?count:requestScope.cp+1 }">&raquo;</a></li>
				</ul>
		    </div>		
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
										修改信息
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
