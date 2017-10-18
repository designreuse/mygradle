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
    <div id="urHere">DouPHP 管理中心<b>></b><strong>编辑分类</strong></div>
    <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="product_category.php" class="actionBtn">文档分类</a>编辑分类</h3>
        <form action="document_edit" method="post" id="forms">
            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">



                    <td align="right">名称</td>
                    <td>
                        <input type="text" name="title" size="50" value="${document.name}" class="inpMain">
                    </td>






                <tr  v-if="${!document.flag}">
                    <td align="right">描述</td>
                    <td>
                        <textarea name="description" cols="60" rows="4"   class="textArea">
                            ${document.content}
                        </textarea>
                    </td>
                </tr>

                <tr  v-if="${!document.flag}">
                    <td align="right">地址</td>
                    <td>
                        <input type="text" name="address"  value="${document.address}" size="100" class="inpMain">
                    </td>
                </tr>



                <tr>
                    <td align="right">排序</td>
                    <td>
                        <input type="text" name="order" value="${document.order}" size="5" class="inpMain"/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>

                        <input name="submit" class="btn" type="submit" value="提交"/>
                    </td>
                </tr>

                <input type="hidden" name="parentId" value="${parentId}">
                <input type="hidden" name="type" value="${document.type}">
                <input type="hidden" name="id" value="${document.id}">

            </table>
        </form>
    </div>
</div>




<jsp:include page="/footer.jsp"></jsp:include>
<script type="text/javascript">
    var form = new Vue({
        el:"#forms",
        data : {
            type:'directory'
        }
    })
</script>

