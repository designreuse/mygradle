<%--
  Created by IntelliJ IDEA.
  User: lihao
  Date: 17/9/21
  Time: 下午4:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="dcLeft">
    <div id="menu">

        <ul>
            <li><a href="${pageContext.request.contextPath}/oa/catelog_list.action?type=1&parentId=-1"><i class="articleCat"></i><em>文档管理</em></a></li>
            <li class="cur"><a href="${pageContext.request.contextPath}/oa/user_list"><i class="user"></i><em>用户列表</em></a></li>
            <li ><a href="${pageContext.request.contextPath}/oa/Board/listBoard"><i class="manager"></i><em>项目论坛</em></a></li>
        </ul>

    </div>
</div>