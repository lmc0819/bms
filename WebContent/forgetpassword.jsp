<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="author" content="穷在闹市" />
		<!-- 作者 -->
		<meta name="revised" content="穷在闹市.v3, 2019/05/01" />
		<!-- 定义页面的最新版本 -->
		<meta name="description" content="网站简介" />
		<!-- 网站简介 -->
		<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
		<title>忘记密码</title>

		<!-- 公共样式 开始 -->
		<link rel="shortcut icon" href="images/favicon.ico"/>
		<link rel="bookmark" href="images/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/iconfont.css">
		<script type="text/javascript" src="framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
		<script type="text/javascript" src="layui/layui.js"></script>
		<!-- 公共样式 结束 -->
		
		<link rel="stylesheet" type="text/css" href="css/forgetpassword.css">
		<script type="text/javascript" src="js/login1.js"></script>
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	</head>

	<body>
		
		<div class="login_main">
			<div class="box">
				<div class="left">
				<p>重置密码:</p>
				<br/>
					<span style="color:red">${errorMsg }</span>
				<br/>
                <br/>
				<a style="color:blue" href="login.jsp">返回登录页面</a>
				</div>
				<div class="right">

					<form class="layui-form layui-form-pane" action="fortgetPwdServlet" method="post">
					    <div class="layui-form-item">
							<label class="layui-form-label login_title"><i class="iconfont icon-mima1"></i></label>
							<div class="layui-input-block login_input">						
								<input id="phone" name="phonenumber" type="text"  required lay-verify="required" autocomplete="off" placeholder="请输入手机号码" class="layui-input" onblur="checkPhone()">										
							</div>
							
							  <br/>
							  <input  id="getCode" name="getCode" class="layui-btn layui-btn-disabled"  type="button" value="发送验证码"/>
										   
							<!--  <img src="pictureCheckCode" id="CreateCheckCode" >
							 <a href="javascript:void(0)" onclick="myReload()" style="font-size:12px;color:blue">看不清,换一个</a> -->									
						</div>
						
						
						<div class="layui-form-item">
							<label class="layui-form-label login_title"><i class="iconfont icon-mima1"></i></label>
							<div class="layui-input-block login_input">
								<input id="checkCode" name="checkCode" type="text"  required lay-verify="required" autocomplete="off" placeholder="请输入验证码" class="layui-input" onblur="checkPhoneCode()" >
							</div>
														
						</div>
						
						 <div class="layui-form-item">
							<label class="layui-form-label login_title"><i class="iconfont icon-mima1"></i></label>
							<div class="layui-input-block login_input">
								<input name="newPwd" type="password"  required lay-verify="required" autocomplete="off" placeholder="请输入新密码" class="layui-input" onblur="checkNewPwd()">
								
							</div>
								
																		
						</div>
						
						<div class="layui-form-item">
							<label class="layui-form-label login_title"><i class="iconfont icon-mima1"></i></label>
							<div class="layui-input-block login_input">
								<input name="rePwd" type="password"  required lay-verify="required" autocomplete="off" placeholder="请再次输入新密码" class="layui-input" onblur="checkRePwd()" >
							</div>
							
						</div>
																						
						<div class="layui-form-item">
							<button id="submit" type="submit" class="layui-btn layui-btn-fluid layui-btn-disabled login_but" lay-submit >重置密码</button>
						</div>
						
					</form>
				</div>
			</div>
		</div>
		<script type="text/javascript">			
			
		     function checkPhone(){
		    	 var phonenumber = $("#phone").val().trim();
					if(phonenumber.length==0){
						$("#getCode").attr("class","layui-btn layui-btn-disabled")
						alert("手机号码不能为空")
						return false;
					}
					
					var reg= /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/;
					if(!reg.test(phonenumber)){
						 $("#getCode").attr("class","layui-btn layui-btn-disabled");												 
						 alert("手机号码不合法，请重新输入！");
						 return false;
					}else{
						 $("#getCode").attr("class","layui-btn layui-btn-normal");						
						 return true;
					} 
					return true;
		     }		
		
		     
		     
		     function checkPhoneCode(){
		    	 var code = $("#checkCode").val().trim();
		    	 if(code.length==0){						
					alert("验证码不能为空！")
					return false;
				 }
		    	 var reg = /^\d{6}$/;
		    	 if(!reg.test(code)){
		    		 alert("验证码必须是六位数字");
		    		 return false;
		    	 }
		    	 return true;
		     }
			  
			function checkNewPwd(){
				var newPwd = $("input[name='newPwd']").val().trim();
				if(newPwd.length==0){
					alert("请输入密码！");
					return false;
				}
				var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,18}$/;
				if(!reg.test(newPwd)){
					alert("密码不合法(6-18位数字字母组合)");
					return false;
				}
				return true;
			}
		     
		     
			function checkRePwd(){
				if(checkPhone()&&checkPhoneCode()&&checkNewPwd()){
					var rePwd = $("input[name='rePwd']").val().trim();
					var newPwd = $("input[name='newPwd']").val().trim();
					if(rePwd.length==0){
						alert("请输入密码！");
						$("#submit").attr("class","layui-btn layui-btn-fluid layui-btn-disabled login_but");
						return false;
					}				
					if(rePwd!=newPwd){
						alert("两次密码输入不一致，请检查！");
						$("#submit").attr("class","layui-btn layui-btn-fluid layui-btn-disabled login_but");
						return false;
					}	
					
					$("#submit").attr("class","layui-btn layui-btn-fluid  login_but");
				}else{
					$("#submit").attr("class","layui-btn layui-btn-fluid layui-btn-disabled login_but");
				}
			    
				
			}
			
		 
			
			
			
			
		 $(function(){
								 
		    $("#getCode").removeAttr("disabled");//记得括号里，对应的是id		    
		    //发送验证码
		    $("#getCode").click(function(){		    
		        $.ajax({
		        url:"phoneVerifyServlet",//ajax提交表单
		        data:{"phone":$("#phone").val()},
		        type:"post",
		        async:true,
		        dataType:"text",
		        success:function(data){
		           if(data!=null){
		             alert("验证码已发送");
		             time(this);
		           }else
		              alert("发送失败");
		        },
		        error:function(){
		            alert("error");
		       }
		   });
		   });
		    
		 });
			  
		  //倒计时
		  var wait=60;
		  function time(obj){
		    if(wait==0){
		      $("#getCode").attr("class","layui-btn layui-btn-normal");
		      $("#getCode").val("重新获取");
		      wait=60;
		    }else{
		        $("#getCode").attr("class","layui-btn layui-btn-disabled");
		        $("#getCode").val(wait+"s后重新获取");
		        wait--;
		        setTimeout(function(){//倒计时的方法
		            time(obj);
		        },1000);        //1s
		     }
		  }
		   
	
  
					
			
			
		</script>
	</body>

</html>