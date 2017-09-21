<%--
  Created by IntelliJ IDEA.
  User: lihao
  Date: 17/9/21
  Time: 下午2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<style type="text/css">
    .error {
        color: red;
    }

</style>
<jsp:include page="/head.jsp"></jsp:include>

<jsp:include page="/left.jsp"></jsp:include>
<div id="dcMain">
    <!-- 当前位置 -->
    <div id="urHere">DouPHP 管理中心<b>></b><strong>商品列表</strong></div>
    <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3>
            <c:if test="${user != null && user.id != null}">
                修改用户
            </c:if>

            <c:if test="${user == null || user.id == null}">
                添加用户
            </c:if>

        </h3>

        <div>

            <form action="<c:if test="${user == null || user.id == null}">user_save</c:if><c:if test="${user != null && user.id != null}">user_update</c:if>" method="post">
                <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
                    <tbody>
                    <tr>
                        <td width="80" align="right"><s:property value="%{getText('firstname')}"/> </td>
                        <td>
                            <input type="text" name="user.firstname" value="${user.firstname}" size="40" class="inpMain">
                            <span class="error">${fieldErrors.first[0]}</span>
                        </td>
                    </tr>
                    <tr>
                        <td align="right"><s:property value="%{getText('lastname')}"/></td>
                        <td>
                            <input type="text" name="user.lastname" value="${user.lastname}" size="40" class="inpMain">

                            <span class="error">${fieldErrors.last[0]}</span>
                        </td>
                    </tr>

                    <tr>
                        <td align="right"><s:property value="%{getText('age')}"/> </td>
                        <td>
                            <input type="text" name="user.age" value="${user.age}" size="40" class="inpMain">
                            <span class="error">${fieldErrors.age[0]}</span>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td>
                            <input type="hidden" name="token" value="b9439ae8">
                            <input type="hidden" name="cat_id" value="">
                            <input name="submit" class="btn" type="submit" value="提交">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>


        </div>


    </div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>