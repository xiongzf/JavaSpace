<%@page import="com.xzf.models.User" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EL 表达式</title>
</head>
<body>
${ pageScope.name }
${ requestScope.name }
${ sessionScope.name }
${ applicationScope.name }

<%
    String[] a = {"aa", "bb", "cc", "dd"};
    pageContext.setAttribute("array", a);
%>

</br>使用 EL 表达式来获取数组中的值</br>
${ array[0] }, ${ array[1] }, ${ array[2] }, ${ array[3] }

<br><br>----------集合数据----------

<%
    List list = new ArrayList();
    list.add("111");
    list.add("222");
    list.add("333");
    list.add("444");
    pageContext.setAttribute("li", list);
%>

</br>使用 EL 表达式来获集合中的值</br>
${ li[0] }, ${ li[1] }, ${ li[2] }, ${ li[3] }

<br><br>----------Map数据----------

<%
    Map map = new HashMap();
    map.put("name", "zhangsan");
    map.put("age", 18);
    map.put("address", "北京");
    map.put("name.ag", "哈哈");
    pageContext.setAttribute("map", map);
%>

</br>使用 EL 表达式来获map中的值</br>
${ map.name }, ${ map.age }, ${ map.address }, ${ map["name.ag"] }


<br><br>----------对象数据----------
<%
    User user = new User("zhangsan", 18);
    session.setAttribute("user", user);
%>

</br>使用 EL 表达式来获对象中的值</br>
${ user.name }, ${ user.age }

</body>
</html>