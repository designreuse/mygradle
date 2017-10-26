<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>




<jsp:include page="/head.jsp"></jsp:include>

<jsp:include page="/left.jsp"></jsp:include>


<div id="dcMain">
    <!-- 当前位置 -->
    <div id="urHere">DouPHP 管理中心<b>></b><strong>添加分类</strong></div>
    <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3>添加分类</h3>
        <form action="${pageContext.request.contextPath}/oa/Topic/addTopic" method="post" id="forms">
            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">



                <tr>
                    <td align="right" >主题</td>
                    <td>
                        <input type="text" name="title" size="100" class="inpMain">
                    </td>
                </tr>

                <tr>
                    <td align="right">帖子内容</td>
                    <td>
                        <!-- /KindEditor -->
                        <textarea id="content" name="content" style="width:780px;height:400px;" class="textArea"></textarea>


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

<!-- KindEditor -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor/kindeditor.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor/lang/zh_CN.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/js/kindeditor/plugins/code/prettify.js"></script>
<script>
    KindEditor.ready(function(K) {
        var editor1 = K.create('textarea[name="content"]', {
            cssPath : '${pageContext.request.contextPath}/js/plugins/code/prettify.css',
            uploadJson : '${pageContext.request.contextPath}/js/php/upload_json.php',
            fileManagerJson : '${pageContext.request.contextPath}/js/php/file_manager_json.php',
            allowFileManager : true,
            afterCreate : function() {
                var self = this;
                K.ctrl(document, 13, function() {
                    self.sync();
                    K('form[name=example]')[0].submit();
                });
                K.ctrl(self.edit.doc, 13, function() {
                    self.sync();
                    K('form[name=example]')[0].submit();
                });
            }
        });
        prettyPrint();
    });
</script>