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
        <form action="${pageContext.request.contextPath}/oa/Board/addBoard" method="post" id="forms">
            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">



                <tr>
                    <td align="right">name</td>
                    <td>
                        <input type="text" name="name" size="50" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">topicCount</td>
                    <td>
                        <input type="text" name="topicCount" size="50" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">postCount</td>
                    <td>
                        <input type="text" name="postCount" size="50" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">children</td>
                    <td>
                        <input type="text" name="children" size="50" class="inpMain">
                    </td>
                </tr>




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