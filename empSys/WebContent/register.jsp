<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册员工</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<style>
	        #header {
				position: relative;
				margin-top: 2px;
			}
			
			#header ul li {
				margin-left: 20px;
			}
			
			#header ul li a {
				cursor: pointer;
			}
</style>
</head>
<body>
<div id="header">
			<ul class="nav nav-tabs">
				<li class="active"><a>员工注册</a></li>
			</ul>
		</div>
	<h1>员工注册页面</h1>
	<form action="${pageContext.request.contextPath }/emp?reqCommand=register" method="post">
	姓名：<input type="text" name="name" >
	<br>
	密码：<input type="password" name="password">
	<br>
	性别：<input type="radio" name="gender" value="男">男
	<input type="radio" name="gender" value="女">女
	<br>
	年龄：<input type="text" name="age">
	<br>
	电话：<input type="text" name="phone">
	<br>
	邮箱：<input type="text" name="email">
	<br>
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<input type="reset" value="重置">
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<input type="submit" value="注册">
	</form>
	
</body>
</html>