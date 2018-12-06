<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	这是 el03 页面
	<jsp:forward page="el04.jsp">
		<jsp:param value="beijing" name="address"/>
	</jsp:forward>
	
	
</body>
</html>