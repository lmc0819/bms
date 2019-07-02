<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="bootstrap-3.3.7/css/bootstrap.min.css" />
		<script type="text/javascript" src="js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="bootstrap-3.3.7/js/bootstrap.min.js"></script>	
		
		<style type="text/css">
		img:hover{
		     transform: scale(10,10);
		}
		td{
		text-align:center;
		valign:center;
		}
		</style>
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
				<strong>图书信息管理：</strong> 
			</p>
			
			
			
			<form class="navbar-form navbar-left" role="search" action="/BookManager/admin">
			            <input type="hidden" class="form-control" name="act"  value="SelectBook"/>
						<div class="form-group">
							<input type="text" class="form-control" name="value" />
						</div> 
						<div class="form-group">
							<select name="name">
							<option value="name">书名</option>
							<option value="id">id</option>
							<option value="category">分类</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">搜索</button>
					</form>
			<table class="table table-bordered">
				<thead>
					<tr >
						<th>
							图书编号
						</th>
						<th>
							书名
						</th>
						<th>
							图片
						</th>
						<th>
							作者
						</th>
						<th>
							出版社
						</th>
						<th>
							出版时间
						</th>
						<th>
							书籍种类
						</th>
						<th>
							书籍数量
						</th>
						<th>
							书籍位置
						</th>
						<th>
							简介
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="index" value="0"/> 
				<c:forEach items="${requestScope.bs}" var="b">
								<tr>
									
									<td name="bookid">${b.bookid }</td>
									<td name="bookname">${b.bookname }</td>
									<td name="photo"> <img class="img-thumbnail"as width="80px" alt="" src="/img/${b.photo}"> </td>
									<td name="author">${b.author }</td>
									<td name="phouse">${b.phouse }</td>
									<td name="pdate"><fmt:formatDate  value="${b.pdate }" pattern="yyyy-MM-dd"/></td>
									<td name="category">${b.category }</td>
									<td name="booknum">${b.booknum }</td>
									<td name="action">${b.action }</td>
									<td name="intro">${b.intro }</td>
									<td>
										<c:set var="index" value="${index+1}" /> 		
										<button type="button" class="btn btn-primary" id="modal-751906" href="#modal-container-751906"  data-toggle="modal" onclick="update(${index-1})">修改</button>
										<button type="button" class="btn btn-danger" onclick="del(${b.bookid })">删除</button>
									</td>
								</tr>
								
							</c:forEach>	
				</tbody>
			</table>
			
		    <div style="text-align: center;">
		    	<ul class="pagination" >
					<li class=${requestScope.cp==1?"disabled":""}><a href="/BookManager/admin?act=SelectAllBook&cp=${requestScope.cp-1<=0?1:requestScope.cp-1}">&laquo;</a></li>
					<c:forEach var="i" begin="1" end="${requestScope.count }" step="1"> 
						<li class=${requestScope.cp==i ?"active":""}><a href="/BookManager/admin?act=SelectAllBook&cp=${i}"><c:out value="${i}" /></a></li>
					</c:forEach>	
					<li class=${requestScope.cp==requestScope.count?"disabled":""}><a href="/BookManager/admin?act=SelectAllBook&cp=${requestScope.cp+1>requestScope.count?count:requestScope.cp+1 }">&raquo;</a></li>
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
					
					<div class="modal-body">
						<form action="/BookManager/admin" method="post">
		                    <div class="form-group">
		                    	<input type="hidden" name="act" value="Update"/>
		                    	<input type="hidden" name="bookid"  id="recipient-name8" />
		                        <label for="recipient-name" class="control-label">书名:</label>
		                        <input type="text" class="form-control" id="recipient-name" name="bookname">
		                    </div>
		                    <div class="form-group">
		                        <label for="message-text" class="control-label">作者:</label>
		                        <input type="text" class="form-control" id="recipient-name1" name="author">
		                    </div>
		                    <div class="form-group">
		                        <label for="message-text" class="control-label">出版社:</label>
		                        <input type="text" class="form-control" id="recipient-name2" name="phouse">
		                    </div>
		                    <div class="form-group">
		                        <label for="message-text" class="control-label">出版时间:</label>
		                        <input type="date" class="form-control" id="recipient-name3" name="pdate">
		                    </div>
		                    <div class="form-group">
		                        <label for="recipient-name" class="control-label">书籍种类:</label>
		                        <input type="text" class="form-control" id="recipient-name4" name="category">
		                    </div>
		                    <div class="form-group">
		                        <label for="message-text" class="control-label">书籍数量:</label>
		                        <input type="number" class="form-control" id="recipient-name5" name="booknum">
		                    </div>
		                    <div class="form-group">
		                        <label for="message-text" class="control-label">书籍位置:</label>
		                        <input type="text" class="form-control" id="recipient-name6" name="action">
		                    </div>
		                    <div class="form-group">
		                        <label for="message-text" class="control-label">简介:</label>
		                        <input type="text" class="form-control" id="recipient-name7" name="intro">
		                    </div>
		                    <div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">取消</button> 
								<button type="submit" class="btn btn-primary">修改</button>
							</div>
						</form>
					</div>
					
				</div>
	
			</div>
	
	    </div>
		<!--弹出层结束-->



        <script type="text/javascript"  charset="UTF-8">
        	function del(id){
        		if(window.confirm("删除此书籍的同时将删除所有借阅信息，你确认删除吗?")==true){
					location.href="/BookManager/admin?act=DeleteBook&name=bookid&id="+id;
        		}
        	}
        	function update(i){
        		var bookid=document.getElementsByName("bookid")[i].innerHTML
        		var bookname=document.getElementsByName("bookname")[	i].innerHTML;
        		var author=document.getElementsByName("author")[i].innerHTML;
        		var phouse=document.getElementsByName("phouse")[i].innerHTML;
        		var pdate=document.getElementsByName("pdate")[i].innerHTML;
        		var category=document.getElementsByName("category")[i].innerHTML;
        		var booknum=document.getElementsByName("booknum")[i].innerHTML;
        		var action=document.getElementsByName("action")[i].innerHTML;
        		var intro=document.getElementsByName("intro")[i].innerHTML;
        		document.getElementById("recipient-name").value=bookname;
        		document.getElementById("recipient-name1").value=author;
        		document.getElementById("recipient-name2").value=phouse;
        		document.getElementById("recipient-name3").value=pdate;
        		document.getElementById("recipient-name4").value=category;
        		document.getElementById("recipient-name5").value=booknum;
        		document.getElementById("recipient-name6").value=action;
        		document.getElementById("recipient-name7").value=intro;
        		document.getElementById("recipient-name8").value=bookid;
    
        	}
        </script>
        
      
        
        

	</body>
</html>
