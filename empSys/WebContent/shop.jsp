<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

</script>
</head>
<body>
    <div id="header"> </div>
    
	<form action="${pageContext.request.contextPath }/shop" method="post" >
	
		<!-- 隐士的传入操作命令 -->
		<input type="hidden" name="cmd" value="add"/>
	
		<!-- <select name="productId" onchange="">
			<option value="1">手机</option>
			<option value="2">平板</option>
			<option value="3">电脑</option>
		</select> -->
		<input type="text" name="pid"  placeholder="1,手机  2,电脑  3,照相机 ">
		<input type="text" name="number" placeholder="请输入购买数量"/>
		<input type="submit" value="购买"   />
	
	</form>
	
	<div  style="position: absolute;top:0px;right:100px"><a href="${pageContext.request.contextPath }/shop?cmd=go">我的购物车</a></div>
	
</body>
</html>