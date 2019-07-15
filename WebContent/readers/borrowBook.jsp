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
	<style type="text/css">
		img:hover{
		     transform: scale(4,4);
		}
		td{
		text-align:center;
		valign:center;
		}
		</style>	
		</head>
	<body>
<div class="container">
		
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="alert alert-dismissable alert-info">
				 <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h4>
					通知公告：
				</h4>
				<strong>Warning!</strong> Best check yo self, you're not looking too good. <a href="#" class="alert-link">alert link</a>
				<strong>Warning!</strong> Best check yo self, you're not looking too good. <a href="#" class="alert-link">alert link</a>
			</div>
		</div>
	</div>
			<nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a style="font-size:20px" class="navbar-brand" href="#">欢迎使用图书管理系统</a>
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
									 <a style="font-size:20px" href="readers/updateReaderInfo.jsp">个人信息修改</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a style="font-size:20px" href="readers/updateReaderPassword.jsp">密码修改</a>
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
			<div class="page-header">
				<h1>
					可借图书列表：
				</h1>
			</div>
			
			<div class="row">
			<form class="navbar-form navbar-left" role="search" action="booksServlet?act=search" method="post">
				<div class="form-group">
					<input type="text" name="bookname" value="${bookname }" class="form-control" placeholder="请输入书名"/>							
				</div> 
				<button type="submit" class="btn btn-primary">搜索</button>						
			</form>
			</div>	
			
			<h3>共有${intTotal }条记录</h3>
			<!--主题内容开始-->
			<div class="row">
			  <c:forEach items="${books }" var="item">
			    <div class="col-sm-6 col-md-3">
			        <div class="thumbnail">
			            <img class="img-thumbnail"as width="80px" alt="" src="/img/${item.photo}">
			                
			            <div class="caption">
			                <h3 style="color:black">${item.bookname }</h3>
			                <p ><em style="color:blue">图书简介：</em>${item.intro }</p>			              
			                <p style="color:blue">馆藏数量：${item.booknum }本</p>
			                <p>
			                   <button type="button" class="btn btn-primary" onclick="details(${item.bookid })">查看详情</button>				                     
			                   <button type="button" class="btn btn-primary" onclick="borrow(${item.bookid},${readerInfo.readerid })">我要借阅</button>	
			                </p>
			            </div>
			        </div>
			    </div>	
			   </c:forEach>	
			    
			    			     
			</div>
			
			
			
			
			
			
			
			
			
			
						
			<%-- <table class="table table-bordered">
				<thead>
					<tr>
						<th>
							书名
						</th>
						<th>
							作者
						</th>
						<th>
						   出版社
						</th>
						<th>
							出版日期
						</th>
						<th>
							图书详细信息
						</th>
						<th>
							图书位置
						</th>
						<th>
							图书分类
						</th>
						<th>
							馆藏数量
						</th>
						<th>
							查看详情
						</th>
						<th>
							借阅
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${books }" var="item">
				<tr class="success">
						<td>
							${item.bookname }
						</td>
						<td>
							${item.author }
						</td>
						<td>
							${item.phouse }
						</td>
						<td>
						   ${item.pdate }
						</td>
						<td>
							${item.intro }
						</td>
						<td>
							${item.action }
						</td>
						<td>
							${item.category }
						</td>					
						<td>
							${item.booknum }
						</td>
						<td>
							<button type="button" class="btn btn-primary" onclick="details(${item.bookid })">查看详情</button>	
						</td>
						<td>
							<button type="button" class="btn btn-primary" onclick="borrow(${item.bookid},${readerInfo.readerid })">我要借阅</button>	
						</td>
					</tr>
				</c:forEach>	
				</tbody>
			</table> --%>
			<ul class="pagination">
				<li 
				<c:if test="${currentPage==1}" >class="disabled"</c:if>
				 >
					 <a href="booksServlet?act=search&bookname=${bookname }&currentPage=${currentPage==1?currentPage:currentPage-1}">上一页</a>
				</li>
				
			<c:forEach begin="1" end="${totalPage }" step="1" var="item">
				<li
				 <c:if test="${currentPage==item }"> class="active" </c:if>
				>
				<a href="booksServlet?act=search&bookname=${bookname }&currentPage=${item }">${item }</a>
				</li>
			</c:forEach> 
			
				<li
				<c:if test="${currentPage==totalPage}" >class="disabled"</c:if>
				>
					 <a href="booksServlet?act=search&bookname=${bookname }&currentPage=${currentPage==totalPage?totalPage:currentPage+1}">下一页</a>
				</li>
			</ul>
			
		</div>
	</div>
</div>
		


		<!--图书详情弹出层开始-->
       <div>
		<div class="modal fade" id="queryInfo" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">该图书详细信息</h4>
					</div>
					<form method="post">
						<div class="modal-body">
							<div class="input-group">
								<span class="input-group-addon">书&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名</span>
								<input type="text" class="form-control" 
									id="bookname" readonly="readonly">
							</div>
							<br />
							<div class="input-group">
								<span class="input-group-addon">作&nbsp;&nbsp;&nbsp;&nbsp;者</span> <input
									type="text" class="form-control" id="author" readonly="readonly">
							</div>
							<br />
							<div class="input-group">
								<span class="input-group-addon">出&nbsp;版&nbsp;社</span>
								<input type="text" class="form-control"	 id="phouse" readonly="readonly">
							</div>
							<br />
							<div class="input-group">
								<span class="input-group-addon">出&nbsp;版&nbsp;日&nbsp;期</span>
								<input type="text" class="form-control"	 id="pdate" readonly="readonly">
							</div>	
							<br />
							<div class="input-group">
								<span class="input-group-addon">图&nbsp;书&nbsp;简&nbsp;介</span>
								<textarea rows="6" cols="65" id="intro" readonly="readonly"></textarea>
								<!-- <input type="text" class="form-control"	 id="intro" readonly="readonly"> -->
							</div>	
							<br />
							<div class="input-group">
								<span class="input-group-addon">图&nbsp;书&nbsp;位&nbsp;置</span>
								<input type="text" class="form-control"	 id="action" readonly="readonly">
							</div>	
							<br />
							<div class="input-group">
								<span class="input-group-addon">图&nbsp;书&nbsp;分&nbsp;类</span>
								<input type="text" class="form-control"	 id="category" readonly="readonly">
							</div>	
							<br />
							<div class="input-group">
								<span class="input-group-addon">馆&nbsp;藏&nbsp;数&nbsp;量</span>
								<input type="text" class="form-control"	 id="booknum" readonly="readonly">
							</div>					
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<!-- <button type="submit" class="btn btn-primary">提交</button> -->
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
 			<!--图书详情弹出层结束-->
 			
 		 <!-- 借阅弹出层开始 -->
        <div>
		    <div class="modal fade" id="borrowBook" tabindex="-1" role="dialog"
			  aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">请选择借阅的本数</h4>
					</div>
					<form action="${pageContext.request.contextPath }/booksServlet?act=borrow" method="post" id="borrowFrom">
						<div class="modal-body">
							<div class="input-group">
								<span class="input-group-addon">数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量</span>
								<input type="hidden" value="" id="bookid" name="bookid">
								<input type="hidden" value="" id="readerid" name="readerid">
								<input type="number" name="borrowcount" class="form-control" min="1" max="5" id="borrowcount"  placeholder="请在右侧选择你要借阅的本数→→">
							</div>										
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" onclick="onclickBorrow()" >借阅</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>							
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
        <!-- 借阅弹出层结束 -->
 			
 								
</body>

<script>
		function details(bookid){
			//alert(bookid);
			//发送ajax请求
			$.ajax({
				url:"booksServlet",
				data:{"act":"queryOneBook","bookid":bookid},
				dataType:"JSON",
				method:"post",
				success:showQuery,
				error: function() {
					alert("请求失败");
				}

			});
			
		}
			
		function showQuery(data) {
		    $("#bookname").val(data.bookname);
		    $("#author").val(data.author);
		    $("#phouse").val(data.phouse);
		    $("#pdate").val(data.pdate);
		    $("#intro").val(data.intro);
		    $("#action").val(data.action);
		    $("#category").val(data.category);
		    $("#booknum").val(data.booknum);
		    // 显示模态框
		    $('#queryInfo').modal('show');
		}
		
		
		//借阅数量弹出层
		function borrow(bookid,readerid){
			//alert(bookid+" "+readerid);
			$("#bookid").val(bookid);
			$("#readerid").val(readerid);
			$("#borrowBook").modal('show');
		}
		
		//借阅数量表单提交按钮
		function onclickBorrow(){
			var borrowcount = $("#borrowcount").val();
			//console.log(borrowcount);
			if(borrowcount==""){
				$("#borrowBook").modal('hide');
			}else{
				$("#borrowFrom").submit();
			} 
		}
		
		
		
		
		
		
</script>
</html>
