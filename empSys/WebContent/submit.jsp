<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		// 获取一个随机令牌对象
		String token = UUID.randomUUID().toString();
		// 把这个令牌对象保存到session中
		session.setAttribute("TOKEN_IN_SESSION", token);
	%>

	<form action="${pageContext.request.contextPath }/SubmitServlet" method="post">
		<input type="hidden" name="token" value="<%=token%>">
		<input type="text" name="text">
		<input type="submit">
	</form>

</body>
</html>