<%--
  Created by IntelliJ IDEA.
  User: lixueqin
  Date: 2017/9/17
  Time: 下午7:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户列表</title>
    <style>
        table, table tr th, table tr td {
            border: 1px solid #0094ff;
        }

        table tr th {
            font-size: 22px;
            font-weight: 300;
            border: 1px solid black;
        }

        table {
            width: 400px;
            min-height: 30px;
            line-height: 30px;
            text-align: center;
            border-collapse: collapse;
            padding: 2px;
        }
    </style>
</head>
<body>

<h1 style="color: red"> 用户列表</h1>

<table style="border: 1px solid black;width: 500px;" cellspacing="1" cellpadding="0">
    <tr>
        <th>id</th>
        <th>firstname</th>
        <th>lastname</th>
        <th>age</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${userlist}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstname}</td>
            <td>${user.lastname}</td>
            <td>${user.age}</td>
            <td><a href="user_delete?user.id=${user.id}" onclick="return del()">删除</a> | <a
                    href="user_detail?user.id=${user.id}">修改</a></td>
        </tr>
    </c:forEach>
</table>
<div style="margin-top: 30px">
    <s:a href="index.jsp"> home </s:a>

    <s:a href="generatexls"> generate xls </s:a>

</div>
</body>
</html>
<script type="text/javascript">

    function del() {
        if (confirm("确定删除？")) {
            return true;
        }

        return false;

    }

</script>