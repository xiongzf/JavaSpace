<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生列表页面</title>
</head>
<body>
<form action="SearchStuServlet" method="post">
    <table border="1" width="800">

        <tr>
            <td colspan="8">
                按姓名查询:<input type="text" name="sname"> &nbsp;&nbsp;&nbsp;&nbsp;
                按性别查询:<select name="gender">
                <option value="">--请选择--
                <option value="男">男
                <option value="女">女
            </select>&nbsp;&nbsp;&nbsp;
                <input type="submit" value="查询">&nbsp;&nbsp;
                <a href="add.jsp">添加</a>
            </td>
        </tr>

        <tr align="center">
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>电话</td>
            <td>生日</td>
            <td>爱好</td>
            <td>简介</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${pageBean.list }" var="stu">
            <tr align="center">
                <td>${stu.sid }</td>
                <td>${stu.sname }</td>
                <td>${stu.gender }</td>
                <td>${stu.phone }</td>
                <td>${stu.birthday }</td>
                <td>${stu.hobby }</td>
                <td>${stu.info }</td>
                <td><a href="UpdateServlet?sid=${stu.sid}">更新</a> <a href="#" onclick="doDelete(${stu.sid})">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="8">
                第${pageBean.currentPage} / ${pageBean.totalPage}页 &nbsp;&nbsp;&nbsp;
                每页显示${pageBean.pageSize}条 &nbsp;&nbsp;&nbsp;
                总记录数${pageBean.totalSize} &nbsp;&nbsp;&nbsp;
                <c:if test="${pageBean.currentPage != 1}">
                    <a href="StudentPageListServlet?currentPage=1">首页</a> |
                    <a href="StudentPageListServlet?currentPage=${pageBean.currentPage - 1}">上一页</a>
                </c:if>

                <c:forEach begin="1" end="${pageBean.totalPage}" var="i">
                    <c:if test="${pageBean.currentPage == i }">
                        ${i }
                    </c:if>

                    <c:if test="${pageBean.currentPage != i }">
                        <a href="StudentPageListServlet?currentPage=${i}">${i }</a>
                    </c:if>
                </c:forEach>

                <c:if test="${pageBean.currentPage != pageBean.totalPage}">
                    <a href="StudentPageListServlet?currentPage=${pageBean.currentPage + 1}">下一页</a> |
                    <a href="StudentPageListServlet?currentPage=${pageBean.totalPage}">尾页</a>
                </c:if>
            </td>
        </tr>
    </table>
</form>
</body>

<script type="text/javascript">
    function doDelete(sid) {
        var flag = confirm("是否删除学生?");
        if (flag) {
            //window.location.href="DeleteServlet?sid=" + sid;
            location.href = "DeleteServlet?sid=" + sid;
        }

    }
</script>

</html>

