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
	
			<nav class="navbar navbar-default navbar-fixed-top  navbar-inverse" role="navigation">
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
			
		
		<!--表单开始-->
			<form onsubmit="return checkAll()" class="form-horizontal" role="form" action="${pageContext.request.contextPath }/readerServlet?act=updateInfo" method="post" id="readerInfoFrom"> 
							
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">用户名<i style="color:red">*</i></label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="readername"  value="${readerInfo.readername }"
							   readonly="readonly">
					</div>
					<span style="color:red"></span>
				</div>
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">手机号码<i style="color:red">*</i></label>
					<div class="col-sm-4">
						<input type="text" class="form-control" id="mobile" name="mobile" value="${readerInfo.mobile }" onblur="checkMobile()">
					</div>
					<span id="mobileMsg" style="color:red"></span>
				</div>
		
				<div class="form-group">
					<div class="col-sm-offset-1 col-sm-10">					
						<div class="radio">	
							<label><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别<i style="color:red">*</i>:</b></label>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label>
								<input type="radio" name="sex" value="男" 
								 <c:if test="${readerInfo.sex == '男'}">
								 checked="checked"
                                  </c:if>
								 >男							
							</label>
							<label>
								<input type="radio" name="sex" value="女"
								 <c:if test="${readerInfo.sex == '女'}">
								 checked="checked"
                                  </c:if>
								>女								
							</label>
							
						</div>
					</div>
				</div>
				
				
				
				<div class="form-group">
				    <label for="email" class="col-sm-2 control-label">院系：<i style="color:red">*</i></label>					       
				    <div class="col-sm-3">					  
						<select class="form-control" name="department">
							<option value="经济学院"
							 <c:if test="${readerInfo.department == '经济学院'}">
								 selected="selected"
                             </c:if>
							>经济学院</option>
							
	                        <option value="航空工程学院" 
	                        <c:if test="${readerInfo.department =='经济航空工程学院'}">
								 selected="selected"
                             </c:if>
	                        >航空工程学院</option>
	                        <option value="商学院"
	                         <c:if test="${readerInfo.department =='商学院'}">
								 selected="selected"
                             </c:if>
	                        >商学院</option>
	                        <option value="智能工程学院"
	                          <c:if test="${readerInfo.department == '智能工程学院'}">
								 selected="selected"
                             </c:if>
	                        >智能工程学院</option>
	                        <option value="土木建筑学院"
	                         <c:if test="${readerInfo.department == '土木建筑学院'}">
								 selected="selected"
                             </c:if>
	                        >土木建筑学院</option>
	                        <option value="文法学院"
	                          <c:if test="${readerInfo.department == '文法学院'}">
								 selected="selected"
                             </c:if>
	                        >文法学院</option>
	                        <option value="数学学院"
	                         <c:if test="${readerInfo.department == '数学学院'}">
								 selected="selected"
                             </c:if>
	                        >数学学院</option>
	                        <option value="体育与公共艺术部"
	                        <c:if test="${readerInfo.department == '体育与公共艺术部'}">
								 selected="selected"
                             </c:if>
	                        >体育与公共艺术部</option>
	                        <option value="国际教育学院"
	                        <c:if test="${readerInfo.department == '国际教育学院'}">
								 selected="selected"
                             </c:if>
	                        >国际教育学院</option>
	                        <option value="管理工程学院"
	                        <c:if test="${readerInfo.department == '管理工程学院'}">
								 selected="selected"
                             </c:if>
	                        >管理工程学院</option>
	                        <option value="信息管理学院"
	                        <c:if test="${readerInfo.department == '信息管理学院'}">
								 selected="selected"
                             </c:if>
	                        >信息管理学院</option>
	                        <option value="民航学院"
	                         <c:if test="${readerInfo.department == '民航学院'}">
								 selected="selected"
                             </c:if>
	                        >民航学院</option>
	                        <option value="材料学院"
	                        <c:if test="${readerInfo.department == '材料学院'}">
								 selected="selected"
                             </c:if>
	                        >材料学院</option>
	                        <option value="艺术设计学院"
	                         <c:if test="${readerInfo.department == '艺术设计学院'}">
								 selected="selected"
                             </c:if>
	                        >艺术设计学院</option>
	                        <option value="外国语学院"
	                         <c:if test="${readerInfo.department == '外国语学院'}">
								 selected="selected"
                             </c:if>
	                        >外国语学院</option>
	                        <option value="马克思主义学院"
	                        <c:if test="${readerInfo.department == '马克思主义学院'}">
								 selected="selected"
                             </c:if>
	                        >马克思主义学院</option>
	                        <option value="继续教育学院"
	                         <c:if test="${readerInfo.department == '继续教育学院'}">
								 selected="selected"
                             </c:if>
	                        >继续教育学院</option>
	                        <option value="蓝天书院"
	                        <c:if test="${readerInfo.department == '蓝天书院'}">
								 selected="selected"
                             </c:if>
	                        >蓝天书院</option>
						</select>											
				    </div>
				</div>				 
				<!-- <div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">上传文件</label>
					<div class="col-sm-4">
						<input type="file" name="file" />
					</div>					
				</div>	 -->			   
				<div class="form-group">
					<label for="lastname" class="col-sm-2 control-label">备注信息</label>
					<div class="col-sm-4">
						<textarea name="remarks" rows="3" cols="50" placeholder="备注信息">${readerInfo.remarks }
						</textarea>
					</div>
					<span style="color:blue">表单验证信息</span>
				</div>
   				    
				<div class="form-group col-sm-3" >
					<button type="submit" class="btn btn-primary" onclick="updateInfo()">修改</button>  
					<button type="reset" class="btn btn-default">重置</button> 				 				    
				</div>   
								
		    </form>
			
			
		
	</body>
	<script type="text/javascript">
    function updateInfo(){
    	var flag = window.confirm("确认修改信息吗？");
    	//alert(flag)
        if(flag==true){
        	//提交表单
        	$("#readerInfoFrom").submit();
        } 
    }
     
    function checkMobile(){
    	var mobile = $("#mobile").val().trim();
    	if(mobile.length==0){   		 	
    		$("#mobileMsg").html("手机号码不能为空")   		
    		return false;
    	}
    	var reg = /^[1][3,4,5,7,8][0-9]{9}$/; 	
    	if(!reg.test(mobile)){    		
    	     $("#mobileMsg").html("手机号码不合法");
    	     return false;
    	}
    	$("#mobileMsg").html("")
    	return true;
    	
    }
    
    function checkAll(){
    	if(checkMobile()){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    
    </script>
</html>
