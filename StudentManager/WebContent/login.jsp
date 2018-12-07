<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h3>欢迎使用学生管理系统</h3>
<form action="LoginServlet" method="post">
    账号: <input type="text" name="username"/> <br/>
    密码: <input type="password" name="pwd"/> <br/>
    <input type="submit" value="登录">
</form>
</body>
</html>