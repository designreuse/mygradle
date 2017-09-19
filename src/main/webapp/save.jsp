<%--
  Created by IntelliJ IDEA.
  User: lixueqin
  Date: 2017/9/19
  Time: 上午7:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>save User</title>
</head>
<body>
<h1 style="color: red"> Save User</h1>

<s:form action="saveUser">
    <s:textfield name="user.firstname" label="%{getText('firstname')}"></s:textfield>
    <s:textfield name="user.lastname" label="%{getText('lastname')}"></s:textfield>
    <s:textfield name="user.age"  label="%{getText('age')}" ></s:textfield>
    <s:submit value="提交"></s:submit>

</s:form>
</body>
</html>
