<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工登录</title>
 <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
           <style>
	        body {
				font-size: 14px;
			}
			*{
			  	 margin:0;
			  	 padding:0;
			  }
	        #content{
		        position: fixed;
				width: 100%;
				height: 100%;
				background-repeat: no-repeat;
				background-image: url(img/bg.jpg);
				background-size: 100% 100%;
	        }
	        #login {
				position: absolute;
				width: 350px;
				height: 50%;
				top:20%;
				left: 36%;
				background-color: white;
				border-radius: 5px;
				opacity: 1;
				margin: 0 auto;
			}
			#title {
				margin-left: 20px;
				margin-top: 20px;
				font-size: x-large;
			}
			#login ul {
				list-style: none;
				padding-top: 10px;
				padding-inline-start: 0px;
			}
			
			#login ul li {
				padding-top: 10px;
				display: block;
				height: 50px;
			}
			.loginbt {
				display: block;
				margin-left: 20px;
			}
			
			.inputs {
				width: 90%;
				margin-left: 5%;
			}
			.sel {
				width: 30%;
				height: 35px;
				border-radius: 5px;
			}
			
			.inputsize {
				width: 200px;
				margin-left: 5px;
			}	
        </style>
        <script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
        <script>
      //设置全局参数默认为0，不成功的状态
    	var isSuccess=0;
    	function checkNameAndPassword(){
    		var name=$("#name").val();
    		var pwd=$("#password").val();
    		if(name.length==0||pwd.length==0){
    			alert("账号或密码不能为空");
    			isSuccess=0;
    			return isSuccess;
    		}
    		else if(name.length>11){
    			alert("请输入11位一以下的账号");
    			isSuccess=0;
    			return isSuccess;
    		}else{
    			isSuccess=1;
    			return isSuccess;
    		}
    	}
    	function allowSubmit(){
    		if(isSuccess==0){
    			return false;
    		}else{
    			return true;
    		}
    	}
    	
    	function changeImg(){
			// 获取到img的空间对象
			var val = document.getElementById("validate");
			// 每次重新访问地址
			val.src="${pageContext.request.contextPath }/ValidateServlet?date=" + new Date();
		}
        </script>
</head>
<body>
	<div id="content">
		<div id="login">
			<div id="title">账号登录</div>
	  <form action="${pageContext.request.contextPath }/emp?reqCommand=login" method="post" onsubmit="return allowSubmit()" >
	  	<ul>
	  		<li>
	    <input type="text" name="name" id="name" placeholder="请输入你的账号" class="form-control inputs" autofocus><span id="nameSpan"></span>
	    </li>
		<li>
		<input type="password" name="password" id="password" class="form-control inputs" placeholder="请输入你的密码">
		</li>
		<!-- <li>
		<input type="checkbox" checked="checked" style="margin-left: 5%;">记住用户名
		</li> -->
		
		<!--${requestScope.error_msg }错误提示信息-->
		<lable style="position:absolute;bottom:0px;right:0px;">${val_msg }</lable>
		<li>
		<img alt="验证码" id="validate" src="${pageContext.request.contextPath }/ValidateServlet"
				style="cursor: pointer;" onclick="changeImg()" style="display:inline-block;" class="inputs form-input-size sel"/>
		<input style="display:inline-block;" type="text" name="validate" class="form-control form-input-size inputsize " placeholder="请输入验证码">
		</li>
		
		<li style="width: 90%;">
		<input type="submit" value="登录"  class="btn btn-success btn-default btn-block loginbt" onclick="checkNameAndPassword()">
		</li>
		</ul>
	  </form>
	  </div>
	</div>
	
</body>
</html>