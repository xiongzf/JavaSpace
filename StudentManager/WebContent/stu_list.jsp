<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息管理系统</title>
</head>
<body>
	<br>学生列表<br>
	
	<table border="1" width="700">
		<tr align = "center">
			<td>编号</td>
			<td>姓名</td>
			<td>年龄</td>
			<td>性别</td>
			<td>住址</td>
			<td>联系方式</td>
			<td>操作</td>
		</tr>
		
		<c:forEach items="${list }" var="stu">
			<tr align = "center">
				<td>${stu.sid }</td>
				<td>${stu.sname }</td>
				<td>${stu.age }</td>
				<td>${stu.gender }</td>
				<td>${stu.address }</td>
				<td>${stu.phoneNum }</td>
				<td><a href="#">更新</a>  <a href="#">删除</a></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>