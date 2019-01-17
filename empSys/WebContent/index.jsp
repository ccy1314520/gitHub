<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>员工管理主页</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<style type="text/css">
			* {
				margin: 0px;
			}
			
			body,html{
				font-size: 14px;
				width:100%;
				height:100%;
				    -webkit-tap-highlight-color: rgba(0,0,0,0);
			}
			 #bg{
		        position: fixed;
				width: 100%;
				height: 100%;
				background-repeat: no-repeat;
				 background-image: url(img/backbg.jpg); 
				background-size: 100% 100%;
				opacity: 0.9;
	        }
			#header {
				position: fixed;
				width: 100%;
				height: 100px;
				border: 1px solid;
				/*background-color: #337AB7;*/
			}
			
			#header-logo {
				/* background-color: #337AB7; */
				opacity: 1;
			}
			.logout {
				position: absolute;
				top: 30px;
				right: 50px;
				font-size: 30px;
				cursor: pointer;
			}
			
			#header .userInfo {
				position: absolute;
				bottom: 5px;
				right: 30px;
			}
			
			#siderBar {
				position: fixed;
				width: 200px;
				top: 100px;
				bottom: 10px;
				border: 1px  solid;
				
			}
			
			#content {
				position: fixed;
				width: 100%;
				left: 200px;
				top: 100px;
				bottom: 10px;
				border: 1px  solid;
			}
			
			#foot {
				position: fixed;
				bottom: 100px;
				width: 100%;
				height: 10px;
				background: #436EEE;
				bottom: 0px;
				border: 1px  solid;
			}
			#siderBar ul li{
			font-color:red;
			}
			.ac{
			background-color: white;
			}
		</style>
		<script type="text/javascript" src="js/jquery-3.1.1.min.js" ></script>
		<script>
			function openOrCloseMenu(currNodeId) {
				//获得所有子节点
				var subNodes = $("#siderBar ul li[parentId=" + currNodeId + "]");
				//显示或隐藏子节点
				if(subNodes.css("display") == "none") { //关闭状态
					//展开菜单（显示子节点）
					subNodes.css("display", "block");
				} else { //展开状态
					//关闭菜单（隐藏子节点）
					subNodes.css("display", "none");
				}
			}
			
			/* 用户退出系统*/
			function logOut() {
				var isSure =confirm("确定要退出嘛？");
				if(isSure){
					return true;
				}else{
					return false;
				}
			}
		</script>
</head>
<body>
   <div id="bg"></div>
	<div id="header">
			<a href="${pageContext.request.contextPath }/emp?reqCommand=logOut" onclick="return logOut()"><span class="logout glyphicon glyphicon-log-out" ></span></a>
			<span class="userInfo" >欢迎你:${sessionScope.emp.name } </span>
			<img id="header-logo" src="img/logo.jpg" width="200px" height="100px">
			
		</div>
		<div id="siderBar">
			<ul class="nav nav-pills nav-stacked ">
				<li id="1" role="presentation" class="active" ><a href="javascript:openOrCloseMenu(1)">
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span>系统设置</a>
				</li>
				<li parentId="1" role="presentation" style="display: none;"><a href="#">亮度设置</a></li>
				<li parentId="1" role="presentation" style="display: none;"><a href="#">字体设置</a></li>	
				<li parentId="1" role="presentation" style="display: none;"><a href="#">背景设置</a></li>
				<li id="2" role="presentation" class="active"><a href="javascript:openOrCloseMenu(2)" >
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span>权限管理</a>
				</li>
				<li parentId="2" role="presentation" style="display: none;"><a href="#">权限设置</a></li>
				<li parentId="2" role="presentation" style="display: none;"><a href="#">权限分配</a></li>	
				<li id="3" role="presentation" class="active"><a href="javascript:openOrCloseMenu(3)">
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span>员工管理</a>
				</li>		
			    <li parentId="3" role="presentation" style="display: none;"><a href="${pageContext.request.contextPath }/emp?reqCommand=query" target="main">员工列表</a></li>
				<li parentId="3" role="presentation" style="display: none;"><a href="#">员工考勤</a></li>
				<li parentId="3" role="presentation" style="display: none;"><a href="${pageContext.request.contextPath }/register.jsp" target="main">注册管理</a></li>
				<li id="3" role="presentation" class="active"><a href="javascript:openOrCloseMenu(4)">
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span>日志管理</a>
				</li>		
			    <li parentId="4" role="presentation" style="display: none;"><a href="#">登录日志</a></li>
				<li parentId="4" role="presentation" style="display: none;"><a href="#">更新日志</a></li>
				<li parentId="4" role="presentation" style="display: none;"><a href="#">删除日志</a></li>	
				<li id="3" role="presentation" class="active"><a href="javascript:openOrCloseMenu(5)">
					<span class="glyphicon glyphicon-star" aria-hidden="true"></span>系统维护</a>
				</li>		
			    <li parentId="5" role="presentation" style="display: none;"><a href="#">恢复数据</a></li>
				<li parentId="5" role="presentation" style="display: none;"><a href="#">系统升级</a></li>
			</ul>
		</div>
		<div id="content">
			<iframe id="main" name="main"  width="100%" height="100%" frameborder="0"></iframe>
		</div>
		<div id="foot"></div>
	<!--<h1>hello xiongdi${sessionScope.emp.name }</h1>-->
	<c:if test="${sessionScope.emp==null }">
		<a href="${pageContext.request.contextPath }/register.jsp">注册</a>
		<a href="${pageContext.request.contextPath }/login.jsp">登录</a>
	</c:if>
	<c:if test="${sessionScope.emp!=null }">
		<a href="${pageContext.request.contextPath }/EmpListServlet">员工列表</a>
		<a href="${pageContext.request.contextPath }/LogoutServlet">安全退出</a>
		<!--<div>上次登录时间：${requestScope.lastTime }</div>-->
	</c:if>
	
</body>
</html>