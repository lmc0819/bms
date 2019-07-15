<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap-3.3.7/css/bootstrap.min.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.2.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap-3.3.7/js/bootstrap.min.js"></script>				
		<title></title>
	</head>
	<body style="font-size: 20px;color: black;">
		
		<div class="container"style="width: 600px;">
			<h1 style="text-align: center;padding-top: 100px;">读者注册</h1>
	   <div class="row clearfix">

		<br>

		<div class="col-md-12 column">
			<form  onsubmit="return checkAll()" class="form-horizontal" role="form" autocomplete="off" action="readerServlet?act=register" method="POST">
				
				<div class="form-group">
					 <label for="inputName" class="col-sm-3 control-label">用户名<em style="color: red">*</em></label>
					<div class="col-sm-9">
						<input name="username" type="text" class="form-control" id="username" required="required"  placeholder="请输入用户名"/ onblur="checkUsername()">
						<span id="usernameMsg" style="color:red;font-size: 15px"></span>
					</div>
				</div>
				<div class="form-group">
					<label for="inputName" class="col-sm-3 control-label">密码<em style="color: red">*</em></label>
				   <div class="col-sm-9">
					   <input type="password" class="form-control" id="password" required="required" placeholder="请输入密码" onblur="checkPassword()" />
					   <span id="passwordMsg" style="color:blue;font-size: 15px">提示：密码长度6~18位，必须包含字母,数字或下划线</span>
				   </div>
			   </div>
			   <div class="form-group">
				<label for="inputName" class="col-sm-3 control-label">确认密码<em style="color: red">*</em></label>
					<div class="col-sm-9">
						<input name="password" type="password" class="form-control" id="repassword" required="required" placeholder="请再次输入密码" onblur="checkRepassword()"/>
						<span id="repasswordMsg" style="color: red;font-size: 15px"></span>
					</div>
			   </div>
			   
				<div class="form-group">
					 <label for="inputSex" class="col-sm-3 control-label">性别<em style="color: red">*</em></label>
					<div class="col-sm-9"style="padding-top: 7px;">
						&nbsp;&nbsp;
						<input type="radio" name="sex" value="男">男
						&nbsp;&nbsp;
						<input type="radio" name="sex" value="女">女
					</div>
				</div>

				<div class="form-group">
						<label for="inputName" class="col-sm-3 control-label">手机号码<em style="color: red">*</em></label>
						<div class="col-sm-9">
							<input name="mobile" type="tel" id="phone" class="form-control" id="inputName" required="required" placeholder="请如实填写手机号码，可以通过手机号找回密码" onblur="checkPhone()"/>
							<span id="phoneMsg" style="color: red;font-size: 15px"></span>
						</div>
				</div>



			
				<div class="form-group">
					 <label for="inputDepartment" class="col-sm-3 control-label">院系<em style="color: red">*</em></label>
					<div class="col-sm-9">
						<select name="department" style="height: 34px;border-radius: 3px;">
							<option value="经济学院">经济学院</option>
							<option value="航空工程学院">航空工程学院</option>
							<option value="商学院">商学院</option>
							<option value="智能工程学院">智能工程学院</option>
							<option value="土木建筑学院">土木建筑学院</option>
							<option value="6">文法学院</option>
							<option value="文法学院">数学学院</option>
							<option value="体育与公共艺术部">体育与公共艺术部</option>
							<option value="国际教育学院">国际教育学院</option>
							<option value="管理工程学院">管理工程学院</option>
							<option value="信息管理学院">信息管理学院</option>
							<option value="民航学院">民航学院</option>
							<option value="材料学院">材料学院</option>
							<option value="艺术设计学院">艺术设计学院</option>
							<option value="外国语学院">外国语学院</option>
							<option value="马克思主义学院">马克思主义学院</option>
							<option value="继续教育学院">继续教育学院</option>
							<option value="蓝天书院">蓝天书院</option>
                        </select>
					</div>
				</div>

				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-3 control-label">备注</label>
					<div class="col-sm-9">
						<textarea cols="50" rows="3" name="remarks" placeholder="备注信息，选填" style="font-size: 10px"></textarea>
						
					</div>
				</div>

				<div class="form-group"style="text-align: center;">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-primary">注册</button>
						 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						 <button type="button" class="btn btn-default" onclick="window.location.href='login.jsp' ">返回登录页面</button>
					</div>
				</div>

			</form>
		</div>
	</div>
</div>
		
</body>

<script>

	function checkUsername(){	 
		var username = $("#username").val().trim();
		//写ajax判断用户名
		if(username.length==0){
			$("#usernameMsg").html("用户名不能为空！");
			return false;
		}
		
		$.ajax({
			url:"${pageContext.request.contextPath }/readerServlet?act=validateUsername",
		    data:{"username":username},
		    type:"post",
		    dataType:"text",
		    success:function(result){	
		    	 //alert(result);
		    	 console.log(result)
		    	 if(result!=null){
		    		 $("#usernameMsg").html(result);	
		    		 return false;
		    	 }
		    		    	
		    },
		    error:function(){
		    	$("#usernameMsg").html("请求失败！");
		    	return false;
		    }
		})
		
		return true;
	}

	 function checkPassword(){
		var password = $("#password").val().trim();
    	 if(password.length>18 || password.length<6 ){   		
    		 $("#passwordMsg").html("<font style='color:red'>密码长度不合法,请换个密码！</font>");
    		 return false;
    	 }
    	  var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$/;
    	  if(!reg.test(password)){   		 
    		  $("#passwordMsg").html("<font style='color:red'>必须包含字母,数字或下划线</font>");
    		  return false;
    	  }else{
    		  $("#passwordMsg").html("<font style='color:green'>√</font>");
    		  return true;
    	  }
    	  return true;  
	 }
   


   function checkRepassword(){
	   if(checkPassword()){   		 
    		 var repassword = $("#repassword").val().trim();
    		  if(repassword.length!=0){
    			    var password = $("#password").val().trim();			    	
			    	 if(password != repassword){
			    		 $("#repasswordMsg").html("两次密码输入不一致,请检查！")
			    		 return false;
			    	 }else{
			    		 $("#repasswordMsg").html("<font style='color:green'>√</font>");
			   		  return true;
			    	 }
			    	  return true; 
    		  }else{
    			  $("#repasswordMsg").html("请再次输入密码！")
    			  return false;
    		  }
			    	 
    	 }else{
    		 return false;
    	 } 	 
   }

   function checkPhone(){
	   var phone =$("#phone").val().trim();
	   if(phone.length==0){
		   $("#phoneMsg").html("请输入手机号码！")
		   return false;
	   }
	   var reg=/^1(3|4|5|6|7|8|9)\d{9}$/;
	   if(!reg.test(phone)){
			$("#phoneMsg").html("手机号码有误，请检查！") 
			return false;
	   }else{
		    $("#phoneMsg").html("<font style='color:green'>√</font>");
			return true
	   }
   }

   function checkAll(){
	   if(checkUsername()&&checkRepassword()&&checkPhone()){
		   return true;
	   }else{
		   return false;
	   }
   }

</script>
</html>
