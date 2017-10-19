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
<jsp:include page="/head.jsp"></jsp:include>

<link href="${pageContext.request.contextPath}/css/jstree/default/style.min.css" rel="stylesheet"
      type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jstree.js"></script>

<jsp:include page="/left.jsp"></jsp:include>
<div id="dcMain">
    <!-- 当前位置 -->
    <div id="urHere">DouPHP 管理中心<b>></b><strong>商品列表</strong></div>

    <div id="mobileBox">
        <div id="mMenu">
            <h3>手机版</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/oa/catelog_list.action?type=1&parentId=-1" class="cur">公司文档</a>
                </li>
                <li><a href="${pageContext.request.contextPath}/oa/catelog_list.action?type=2&parentId=-1">部门文档</a></li>
                <li><a href="${pageContext.request.contextPath}/oa/catelog_list.action?type=3&parentId=-1">协作文档</a></li>
                <li><a href="${pageContext.request.contextPath}/oa/catelog_list.action?type=4&parentId=-1">共享文档</a></li>
                <li><a href="${pageContext.request.contextPath}/oa/catelog_list.action?type=5&parentId=-1">培训文档</a></li>
                <li><a href="${pageContext.request.contextPath}/documentcatelog/listtree.jsp?type=1&parentId=-1">公司文档图</a></li>
            </ul>
        </div>

        <div id="mMain">
            <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
                <h3><a href="${pageContext.request.contextPath}/oa/catelog_show_add?type=${type}&parentId=${parentId}"
                       class="actionBtn add">添加分类</a>分类列表</h3>
                <div class="filter">

                </div>
                <div id="list">
                    <div id="jstree"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>

    </div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>
<script type="text/javascript">

    $(function () {
        var src = "${pageContext.request.contextPath}/oa/treedocument?type=${param.type}&parentId=${param.parentId}";

        $('#jstree').jstree({
            'core': {
                'data':  {
                        "url" : src,
                        "dataType" : "json" ,// needed only if you do not supply JSON

                    }

            }
        }).on('changed.jstree', function (e, data) {
          console.log("data:  "+data)

            var parentId = data.node.original.parentId;
            var parentName = data.node.original.id;
            if(!parentName) {
                parentName = data.node.original.text;
            }
            src = "${pageContext.request.contextPath}/oa/treedocument?type=${param.type}&parentId="+parentId+"&parentName="+parentName;

        }).on('before_open.jstree', function (e, data) {
             var parentId = data.node.original.parentId;
            var parentName = data.node.original.id;
            if(!parentName) {
                parentName = data.node.original.text;
            }
            src = "${pageContext.request.contextPath}/oa/treedocument?type=${param.type}&parentId="+parentId+"&parentName="+parentName;

            alert(src);
            data.instance.refresh();

        })
        ;

    })

</script>