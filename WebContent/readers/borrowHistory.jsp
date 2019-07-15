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
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a style="font-size:20px"   class="navbar-brand" href="#">欢迎使用图书管理系统</a>
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
					借阅历史：<em style="font-size:15px;color:blue">温馨提示：同时借阅多本书则显示多条记录！</em>
					<!-- <h5 style="color:blue">温馨提示：</h5> -->
				</h1>	
				<br>			
				<h4>共有${intTotal }条记录</h4>
				
			</div>
						
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>
							图书名称
						</th>
						<th>
							借阅时间
						</th>
						<th>
							归还时间
						</th>
						<th>
							是否归还
						</th>
						<!-- <th>
							查看详情
						</th> -->
						<!-- <th>
							归还图书
						</th> -->
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${borrows }" var="item">
				     <tr 
				     <c:if test="${item.isreturn=='是'}" >class="success"</c:if>
				     <c:if test="${item.isreturn=='否'}" >class="warning"</c:if>
				     >
						<td>
							${item.bookname }
						</td>
						<td>
							${item.borrowdate }
						</td>
						<td>
							${item.returndate }
						</td>
						<td>
							${item.isreturn }
						</td>				
						<%-- <td>
							<button type="button" class="btn btn-primary" onclick="details(${item.borrowid })">查看详情</button>	
						</td> --%>
						<%-- <td>
						     <c:if test="${item.isreturn=='是'}" ><button type="button" class="btn btn-primary" onclick="borrow(${item.bookid},${readerInfo.readerid })">我要续借</button></c:if>
							 <c:if test="${item.isreturn=='否'}" ><button type="button" class="btn btn-primary" onclick="borrow(${item.bookid},${readerInfo.readerid })">我要还书</button></c:if>	
						</td> --%>
					</tr>
				</c:forEach>	
				</tbody>
			</table>
				<ul class="pagination">
					<li 
					<c:if test="${currentPage==1}" >class="disabled"</c:if>
					 >
						 <a href="borrowServlet?act=list&currentPage=${currentPage==1?currentPage:currentPage-1}">上一页</a>
					</li>
					
				<c:forEach begin="1" end="${totalPage }" step="1" var="item">
					<li
					 <c:if test="${currentPage==item }"> class="active" </c:if>
					>
					<a href="borrowServlet?act=list&currentPage=${item }">${item }</a>
					</li>
				</c:forEach> 
				
					<li
					<c:if test="${currentPage==totalPage}" >class="disabled"</c:if>
					>
						 <a href="borrowServlet?act=list&currentPage=${currentPage==totalPage?totalPage:currentPage+1}">下一页</a>
					</li>
				</ul>
				
		</div>
	</div>
</div>
	
	
	
		
</body>
	
	

</html>
