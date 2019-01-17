<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<li class="active"><a>修改信息</a></li>
			</ul>
		</div>
	<h1>修改页面</h1>
	<form action="${pageContext.request.contextPath }/emp?id=${requestScope.findEmp.id }&reqCommand=editEmp" method="post">
	姓名：<input type="text" name="name" value="${requestScope.findEmp.name }">
	<br>
	密码：<input type="password" name="password" value="${requestScope.findEmp.password }">
	<br>
	性别：<input type="text" name="gender" value="${requestScope.findEmp.gender  }">
	<br>
	年龄：<input type="text" name="age" value="${requestScope.findEmp.age }">
	<br>
	日期：<input type="date" name="date" value="${requestScope.findEmp.hiredate }"  >
	<br>
	薪资：<input type="text" name="salary" value="${requestScope.findEmp.salary }"> 
	<br>
	电话：<input type="text" name="phone" value="${requestScope.findEmp.phone }">
	<br>
	邮箱：<input type="text" name="email" value="${requestScope.findEmp.email }">
	<br>
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<input type="reset" value="重置">
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&'nbsp
	<input type="submit" value="修改">
	</form>
</body>
</html>