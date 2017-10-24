<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>




<jsp:include page="/head.jsp"></jsp:include>

<jsp:include page="/left.jsp"></jsp:include>


<div id="dcMain">
    <!-- 当前位置 -->
    <div id="urHere">DouPHP 管理中心<b>></b><strong>添加分类</strong></div>
    <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="product_category.php" class="actionBtn">文档分类</a>添加分类</h3>
        <form action="${pageContext.request.contextPath}/oa/Post/updatePost" method="post" id="forms">
            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">



                <tr>
                    <td align="right">authorId</td>
                    <td>
                        <input type="text" name="authorId" size="50" value="<s:property value='post.authorId' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">authorName</td>
                    <td>
                        <input type="text" name="authorName" size="50" value="<s:property value='post.authorName' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">date</td>
                    <td>
                        <input type="text" name="date" size="50" value="<s:property value='post.date' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">content</td>
                    <td>
                        <input type="text" name="content" size="50" value="<s:property value='post.content' />"
                               class="inpMain">
                    </td>
                <tr/>

                <tr>
                    <td align="right">parent</td>
                    <td>
                        <input type="text" name="parent" size="50" value="<s:property value='post.parent' />"
                               class="inpMain">
                    </td>
                <tr/>



                <input type="hidden" name="id" value="<s:property value='post.id'/>">

                <tr>
                    <td></td>
                    <td>
                        <input name="submit" class="btn" type="submit" value="提交"/>
                    </td>
                </tr>

            </table>
        </form>
    </div>
</div>







<jsp:include page="/footer.jsp"></jsp:include>