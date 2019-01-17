<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>购买单价</th>
				<th>购买数量</th>
				<th>共计价格</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<%-- ${sessionScope.CART_IN_SESSION.items } --%>
		<%-- ${requestScope.items } --%>
		
			<c:forEach items="${sessionScope.products}" var="i">
				<tr>
					<td>${i.pid }</td>
					<td>${i.pname }</td>
					<td>${i.price }</td>
					<td>${i.number }</td>
					<td>${(i.price)*(i.number) }</td>
					<td><a href="${pageContext.request.contextPath }/shop?cmd=clearOne&pid=${i.pid}">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="6">总价:XXXXXXX</td>
			</tr>
		</tbody>
	</table>

	<a href="${pageContext.request.contextPath }/shop?cmd=clearAll">清空购物车</a>
	<a href="${pageContext.request.contextPath }/shop.jsp">继续购物</a>

</body>
</html>