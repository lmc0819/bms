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
		<%
		String mess = (String) session.getAttribute("mess");
		if (mess == null|| mess.equals("")){		
			}		
			else {
		%>
		<script type="text/javascript">
		        alert("<%=mess%>");
		</script>		
		<%
		  session.setAttribute("mess", "");
		%>
		<%
			}
		%>
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
				<strong>读者信息管理：</strong> 
			</p>
			
			
			
			<form class="navbar-form navbar-left" role="search" action="/BookManager/admin">
						<div class="form-group">
							<input type="text" class="form-control"  name="select" />
							<input type="hidden" name="act" value="SelectReader">
						</div> 
						<div class="form-group">
							<select name="name">
							<option value="姓名">姓名</option>
							<option value="id">id</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">搜索</button>
					</form>
			<table class="table table-bordered">
				<thead>
					<tr >
						<th>
							学生ID
						</th>
						<th>
							姓名
						</th>
						<th>
							密码
						</th>
						<th>
							性别
						</th>
						<th>
							电话
						</th>
						<th>
							院系
						</th>
						<th>
							注册时间
						</th>
						<th>
							已借数量
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				<c:set var="index" value="0" /> 
				<c:forEach items="${requestScope.rs }" var="r">
					<tr class="success">
						<td name="readerid">${r.readerid }</td>
						<td name="readername">${r.readername}</td>
						<td name="rpassword">${r.rpassword}</td>
						<td name="sex">${r.sex}</td>
						<td name="mobile">${r.mobile}</td>
						<td name="department">${r.department }</td>
						<td name="sxtime">${r.sxtime }</td>
						<td name="borrownumber">${r.borrownumber }</td>
						<td>
						<c:set var="index" value="${index+1}" /> 
							<button type="button" class="btn btn-primary" id="modal-751906" href="#modal-container-751906"  data-toggle="modal" onclick="update(${index-1})">修改</button>
							<button type="button" class="btn btn-danger" onclick="del(${r.readerid})">删除</button>
						</td>
						
					</tr>
						</c:forEach>
					
				</tbody>
			</table>
			
											
			<div style="text-align: center;">
		    	<ul class="pagination" >
					<li class=${requestScope.cp==1?"disabled":""}><a href="/BookManager/admin?act=SelectAllReader&cp=${requestScope.cp-1<=0?1:requestScope.cp-1}">&laquo;</a></li>
					<c:forEach var="i" begin="1" end="${requestScope.count }" step="1"> 
						<li class=${requestScope.cp==i ?"active":""}><a href="/BookManager/admin?act=SelectAllReader&cp=${i}"><c:out value="${i}" /></a></li>
					</c:forEach>	
					<li class=${requestScope.cp==requestScope.count?"disabled":""}><a href="/BookManager/admin?act=SelectAllReader&cp=${requestScope.cp+1>requestScope.count?count:requestScope.cp+1 }">&raquo;</a></li>
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
									 <input type="hidden" class="form-control" id="recipient-name" name="readerid">
									 <input type="hidden" class="form-control"  name="act" value="UpdateReader">
					                    <div class="form-group">
					                        <label for="recipient-name" class="control-label">学生名:</label>
					                        <input type="text" class="form-control" id="recipient-name1" name="readername">
					                    </div>
					                    <div class="form-group">
					                        <label for="message-text" class="control-label">密码:</label>
					                        <input type="text" class="form-control" id="recipient-name2" name="rpassword">
					                    </div>
					                    <div class="form-group">
					                        <label for="message-text" class="control-label">性别:</label>
					                        <input type="text" class="form-control" id="recipient-name3" name="sex">
					                    </div>
					                    <div class="form-group">
					                        <label for="message-text" class="control-label">电话:</label>
					                        <input type="number" class="form-control" id="recipient-name4" name="mobile">
					                    </div>
					                    <div class="form-group">
					                        <label for="message-text" class="control-label">院系:</label>
					                        <input type="text" class="form-control" id="recipient-name5" name="department">
					                    </div>
					                    <div class="form-group">
					                        <label for="message-text" class="control-label">生效时间:</label>
					                        <input type="date" class="form-control" id="recipient-name6" name="sxtime">
					                    </div>
					                     <div class="form-group">
					                        <label for="message-text" class="control-label">已借数量:</label>
					                        <input type="number" class="form-control" id="recipient-name7" name="borrownumber">
					                    </div>
					             
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

        <script type="text/javascript">
        	function del(id){
        		var result=window.confirm("删除此用户的同时将删除所有借阅信息，你确认删除吗？");
        		if(result){
        			location.href="/BookManager/admin?act=DeleteReader&name=readerid&id="+id;
        		}
        	}
        	function update(i){
        		var readerid=document.getElementsByName("readerid")[i].innerHTML
        		var readername=document.getElementsByName("readername")[i].innerHTML;
        		var rpassword=document.getElementsByName("rpassword")[i].innerHTML;
        		var sex=document.getElementsByName("sex")[i].innerHTML;
        		var mobile=document.getElementsByName("mobile")[i].innerHTML;
        		var department=document.getElementsByName("department")[i].innerHTML;
        		var sxtime=document.getElementsByName("sxtime")[i].innerHTML;
        		var borrownumber=document.getElementsByName("borrownumber")[i].innerHTML;
        		
        		document.getElementById("recipient-name").value=readerid;
        		document.getElementById("recipient-name1").value=readername;
        		document.getElementById("recipient-name2").value=rpassword;
        		document.getElementById("recipient-name3").value=sex;
        		document.getElementById("recipient-name4").value=mobile;
        		document.getElementById("recipient-name5").value=department;
        		document.getElementById("recipient-name6").value=sxtime;
        		document.getElementById("recipient-name7").value=borrownumber;
        	}
        </script>
	</body>
</html>
