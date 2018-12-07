<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>内置对象</title>
</head>
<body>
使用作用域来存储数据</br>

<!--
    1.pageContext,作用域仅限于当前界面
    2.request, 作用域仅限于一次请求,只要服务器对该请求做出了响应,这个域中存的值就没有了.
    3.session,作用域仅限于一次会话(多次请求与响应)当中.
    4.application, 整个工程都可以访问,服务器关闭后就不能访问了.
 -->
<%
    pageContext.setAttribute("name", "page");
    request.setAttribute("name", "request");
    session.setAttribute("name", "session");
    application.setAttribute("name", "application");
%>

取出四个作用域的值</br>
    <%= pageContext.getAttribute("name") %></br>
    <%= request.getAttribute("name") %></br>
    <%= session.getAttribute("name") %></br>
    <%= application.getAttribute("name") %></br>

<jsp:forward page="other05.jsp"></jsp:forward>

</body>
</html>