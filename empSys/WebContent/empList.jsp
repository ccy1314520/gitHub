<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工列表</title>
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
				<li class="active"><a>用户管理</a></li>
			</ul>
		</div>
	<table class="table table-bordered table-hover" style="width: 80%">
		<thead class="btn-primary">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>密码</th>
				<th>性别</th>
				<th>年龄</th>
				<th>入职日期</th>
				<th>薪资</th>
				<th>电话</th>
				<th>邮箱</th>
				<th colspan="2">操作</th>
			</tr>
		</thead>
		<c:forEach items="${requestScope.list }" var="e">
			<tr>
				<td>${e.id }</td>
				<td>${e.name }</td>
				<td>${e.password }</td>
				<td>${e.gender }</td>
				<td>${e.age }</td>
				<td>${e.hiredate }</td>
				<td>${e.salary }</td>
				<td>${e.phone }</td>
				<td>${e.email }</td>
				<td><a href="${pageContext.request.contextPath }/emp?id=${e.id}&reqCommand=displayEditInfo" target="main">修改</a></td>
				<td><a href="${pageContext.request.contextPath }/emp?id=${e.id}&reqCommand=delete" target="main">删除</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>