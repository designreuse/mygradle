<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>



<jsp:include page="/head.jsp"></jsp:include>

<jsp:include page="/left.jsp"></jsp:include>
<div id="dcMain">
    <!-- 当前位置 -->
    <div id="urHere">DouPHP 管理中心<b>></b><strong>商品列表</strong></div>

    <div id="mobileBox">
        <div id="mMenu">
            <h3>手机版</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/oa/catelog_list.action?type=1&parentId=-1" class="cur">公司文档</a></li>
                <li><a href="${pageContext.request.contextPath}/oa/catelog_list.action?type=2&parentId=-1">部门文档</a></li>
                <li><a href="${pageContext.request.contextPath}/oa/catelog_list.action?type=3&parentId=-1">协作文档</a></li>
                <li><a href="${pageContext.request.contextPath}/oa/catelog_list.action?type=4&parentId=-1">共享文档</a></li>
                <li><a href="${pageContext.request.contextPath}/oa/catelog_list.action?type=5&parentId=-1">培训文档</a></li>
            </ul>
        </div>

        <div id="mMain">
            <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
            <h3><a href="${pageContext.request.contextPath}/oa/DocumentItem/addDocumentItem?documentCatalogId=<s:property value="documentCatalogId"/>" class="actionBtn add">添加文档</a>文档列表</h3>
            <div class="filter">
                <form action="product.php" method="post">
                    <select name="cat_id">
                        <option value="0">未分类</option>
                     >
                    </select>
                    <input name="keyword" type="text" class="inpMain" value="" size="20"/>
                    <input name="submit" class="btnGray" type="submit" value="筛选"/>
                </form>

            </div>
            <div id="list">
                <form name="action" method="post" action="${pageContext.request.contextPath}/oa/DocumentItem/delete">
                    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
                        <tr>
                            <th width="22" align="center"><input name='chkall' type='checkbox' id='chkall'
                                                                 onclick='selectcheckbox(this.form)' value='check'></th>
                            <th width="40" align="center">编号</th>
                            <th width="120" align="center">名称

                                <a href="${pageContext.request.contextPath}/oa/DocumentItem/listDocumentItem?documentCatalogId=<s:property value="documentCatalogId"/>&field=name&away=asc">
                                    <img src="${pageContext.request.contextPath}/images/arrowup.gif" style="width: 15px;height: 15px">
                                </a>
                                <a href="${pageContext.request.contextPath}/oa/DocumentItem/listDocumentItem?documentCatalogId=<s:property value="documentCatalogId"/>&field=name&away=desc">
                                    <img src="${pageContext.request.contextPath}/images/arrowdown.gif" style="width: 15px;height: 15px">
                                </a>

                            </th>
                            <th width="80" align="center">创建日期</th>
                            <th width="80" align="center">创建者</th>
                            <th width="80" align="center">文件类型</th>
          2                  <th width="100" align="center">文件大小
                                <a href="${pageContext.request.contextPath}/oa/DocumentItem/listDocumentItem?documentCatalogId=<s:property value="documentCatalogId"/>&field=realSize&away=asc">
                                    <img src="${pageContext.request.contextPath}/images/arrowup.gif" style="width: 15px;height: 15px">
                                </a>
                                <a href="${pageContext.request.contextPath}/oa/DocumentItem/listDocumentItem?documentCatalogId=<s:property value="documentCatalogId"/>&field=realSize&away=desc">
                                    <img src="${pageContext.request.contextPath}/images/arrowdown.gif" style="width: 15px;height: 15px">
                                </a>


                            </th>
                            <th width="80" align="center">操作</th>
                        </tr>

                            <s:iterator value="list" status="st" var="documentItem">
                            <tr>
                                <td align="center">
                                    <input type="checkbox" name="ids" value="<s:property value="id"></s:property>"/>
                                </td>
                                <td align="center">${st.count}</td>
                                <td align="center"><s:property value="name"></s:property></td>
                                <td align="center"><s:property value="date.toString().substring(0,10)"></s:property></td>
                                <td align="center"><s:property value="authorName"/></td>
                                <td align="center">
                                <img src="${pageContext.request.contextPath}/images/icon/<s:property value="iconType"/>" width="15px" height="15px"/> &nbsp;|&nbsp;
                                    <s:property value="type"/>
                                </td>

                                <td align="center">

                                    <s:property value="size"/>

                                </td>


                                <td align="center">
                                    <a href="${pageContext.request.contextPath}/oa/DocumentItem/showupdate?itemId=<s:property value="id" />&documentCatalogId=${param['documentCatalogId']}">更新</a> | <a
                                        href="${pageContext.request.contextPath}/oa/DocumentItem/download?documentItemId=<s:property value="id" />">下载</a>
                                </td>
                            </tr>
                            </s:iterator>

                    </table>
                    <input type="hidden" name="documentCatalogId" value="<s:property value="documentCatalogId"/>"/>
                    <div class="action">
                        <select name="action" onchange="douAction()">
                            <option value="0">请选择...</option>
                            <option value="1">删除</option>
                            <option value="category_move">移动分类至</option>
                        </select>
                        <select name="new_cat_id" style="display:none">
                            <option value="0">未分类</option>

                        </select>
                        <input name="submit" class="btn" type="submit" value="执行"/>
                    </div>
                </form>
            </div>
            <div class="clear"></div>
            <div class="pager">总计 15 个记录，共 1 页，当前第 1 页 | <a href="product.php?page=1">第一页</a> 上一页 下一页 <a
                    href="product.php?page=1">最末页</a></div>
        </div>
        </div>

    </div>
</div>

<jsp:include page="/footer.jsp"></jsp:include>