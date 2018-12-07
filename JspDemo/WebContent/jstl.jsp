<%@page import="com.xzf.models.User" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<c:set var="name" value="zhangsan"></c:set>

${name}

<br>----------------------------------------<br>

<c:set var="age" value="26"></c:set>
<c:if test="${age > 30 }" var="flag" scope="session">
    年龄大于30岁...
</c:if>

<c:if test="${age <= 30 }">
    年龄小于等于30岁...
</c:if>

${ flag }

<br>----------------------------------------<br>

<c:forEach begin="1" end="10" var="i" step="2">
    ${i }
</c:forEach>

<br>----------------------------------------<br>

<%
    List list = new ArrayList();

    list.add(new User("zhangsan", 18));
    list.add(new User("lisi", 20));
    list.add(new User("wangwu", 21));
    list.add(new User("ermazi", 31));

    pageContext.setAttribute("list", list);
%>

<c:forEach var="user" items="${list}">
    ${user.name }-------------${user.age }
</c:forEach>

</body>
</html>