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

<s:form action="user_save" namespace="/">
    <s:textfield name="user.firstname" label="%{getText('firstname')}"></s:textfield>
    <s:textfield name="user.lastname" label="%{getText('lastname')}"></s:textfield>
    <s:textfield name="user.age"  label="%{getText('age')}" ></s:textfield>
    <s:submit value="提交"></s:submit>

</s:form>
<%--<form action="user_save" method="post" onsubmit="">--%>
    <%--<p >--%>
        <%--<label for="username"><s:property value="%{getText('firstname')}" /></label>--%>
        <%--<input type="text" name="user.firstname" id="username">--%>
    <%--</p>--%>
    <%--<p >--%>
        <%--<label for="lastname"><s:property value="%{getText('lastname')}" /></label>--%>
        <%--<input type="text" name="user.lastname" id="lastname">--%>
    <%--</p>--%>
    <%--<p >--%>
        <%--<label for="age"><s:property value="%{getText('age')}"/> </label>--%>
        <%--<input type="text" name="user.age" id="age">--%>
    <%--</p>--%>
    <%--<p>--%>
        <%--<input type="submit" value="提交">--%>
    <%--</p>--%>

<%--</form>--%>

<div>
    <s:fielderror fieldName="first"></s:fielderror>
    <s:fielderror fieldName="last"></s:fielderror>
    <s:fielderror fieldName="age" ></s:fielderror>

    <s:debug></s:debug>
</div>

</body>
</html>
