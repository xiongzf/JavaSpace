<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>这是一个 jsp_action 文件</h1>

<%-- <jsp:include page="other02.jsp"></jsp:include> --%>
<jsp:forward page="other02.jsp">
    <jsp:param value="beijing" name="address"/>
</jsp:forward>

</body>
</html>