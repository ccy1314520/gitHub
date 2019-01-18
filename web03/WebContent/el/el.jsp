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
		/*在请求域中写数据*/
		request.setAttribute("name", "siri");
	%>
	<%
		String name=(String) request.getAttribute("name");
	%>
	<%=name %>
	<br>
	
	${name }
	
</body>
</html>