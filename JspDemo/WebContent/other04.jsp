<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>这是04界面</h1>
	<%= pageContext.getAttribute("name") %></br>
	<%= request.getAttribute("name") %></br>
	<%= session.getAttribute("name") %></br>
	<%= application.getAttribute("name") %></br>
</body>
</html>