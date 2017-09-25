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
    <div id="urHere">DouPHP 管理中心<b>></b><strong>添加分类</strong></div>
    <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="product_category.php" class="actionBtn">文档分类</a>添加分类</h3>
        <form action="catelog_add" method="post" id="forms">
            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">


                <tr>
                    <td align="right">上传文件</td>
                    <td>
                        <input type="file" name="files[]" size="38" class="inpFlie">
                        <img src="${pageContext.request.contextPath}/images/action_btn.gif" style="cursor: pointer"
                             @click="add">
                    </td>
                </tr>
                <tr class="close" ></tr>




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
<script type="text/javascript">
    var dome = ' <tr class="add">\
        <td align="right"></td>\
        <td>\
        <input type="file" name="files[]" size="38" class="inpFlie">\
        <img src="${pageContext.request.contextPath}/images/icon_no.png" style="cursor: pointer" class="x">\
        </td>\
        </tr>';


    var form = new Vue({
        el: "#forms",
        data: {
            count: 1
        },
        methods: {
            add: function (event) {
                form.count++;
                if (form.count > 5) {
                    alert("最多添加5个文件")
                    return;
                }
                var addLength = $(".add").length;
                if(addLength == 0) {
                    $(event.target).parents("tr").siblings(".close").after(dome)

                } else {
                    $(event.target).parents("tr").siblings(".close").siblings(".add").last().after(dome)
                }


            },
            del: function () {
                alert("del")
                $(event.target).parents("tr").remove();
                form.count--;
            }
        }
    });
    $("#forms").on("click",".x",function (event) {
        $(event.target).parents("tr").remove()
        form.count --;
    })
</script>

