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

<jsp:include page="/left.jsp"></jsp:include>
<div id="dcMain">
    <!-- 当前位置 -->
    <div id="urHere">DouPHP 管理中心<b>></b><strong>商品列表</strong></div>

    <div id="mobileBox">
        <div id="mMenu">
            <h3>手机版</h3>
            <ul>
                <li><a href="${pageContext.request.contextPath}/catelog_list.action?type=1&parentId=-1" class="cur">公司文档</a></li>
                <li><a href="${pageContext.request.contextPath}/catelog_list.action?type=2&parentId=-1">部门文档</a></li>
                <li><a href="${pageContext.request.contextPath}/catelog_list.action?type=3&parentId=-1">协作文档</a></li>
                <li><a href="${pageContext.request.contextPath}/catelog_list.action?type=4&parentId=-1">共享文档</a></li>
                <li><a href="${pageContext.request.contextPath}/catelog_list.action?type=5&parentId=-1">培训文档</a></li>
            </ul>
        </div>

        <div id="mMain">
            <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
            <h3><a href="${pageContext.request.contextPath}/catelog_show_add?type=${type}&parentId=${parentId}" class="actionBtn add">添加分类</a>分类列表</h3>
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
                <form name="action" method="post" action="product.php?rec=action">
                    <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">
                        <tr>
                            <th width="22" align="center"><input name='chkall' type='checkbox' id='chkall'
                                                                 onclick='selectcheckbox(this.form)' value='check'></th>
                            <th width="40" align="center">编号</th>
                            <th width="120" align="center">名称</th>
                            <th width="80" align="center">创建日期</th>
                            <th width="80" align="center">创建者</th>
                            <th width="80" align="center">类型</th>
                            <th width="80" align="center">上移</th>
                            <th width="80" align="center">下移</th>
                            <th width="80" align="center">子目录/链接</th>
                            <th width="80" align="center">文件</th>
                            <th width="80" align="center">操作</th>
                        </tr>

                        <c:forEach items="${list}" var="document" varStatus="vs">
                            <tr>
                                <td align="center"><input type="checkbox" name="checkbox[]" value="${document.id}"/>
                                </td>
                                <td align="center">${vs.index}</td>
                                <td align="center">${document.name}</td>
                                <td align="center">${document.date.toString().substring(0,10)}</td>
                                <td align="center">${document.authorName}</td>
                                <td align="center">
                                    <c:if test="${document.flag}">
                                        目录
                                    </c:if>
                                    <c:if test="${!document.flag}">
                                        链接
                                    </c:if>
                                </td>

                                <td align="center">
                                    <c:if test="${!vs.first}">
                                        <a href="${pageContext.request.contextPath}/order_up?id=${document.id}&type=${type}&parentId=${parentId}"><img src="${pageContext.request.contextPath}/images/arrowup.gif"></a>
                                    </c:if>


                                </td>
                                <td align="center">
                                    <c:if test="${!vs.last}">
                                        <a href="${pageContext.request.contextPath}/order_down?id=${document.id}&type=${type}&parentId=${parentId}"><img src="${pageContext.request.contextPath}/images/arrowdown.gif"></a>
                                    </c:if>

                                </td>
                                <td align="center">
                                    <c:if test="${document.flag}">
                                        <a href="${pageContext.request.contextPath}/catelog_list?type=${document.type}&parentId=${document.id}">进入</a>
                                    </c:if>
                                    <c:if test="${!document.flag}">
                                        <a href="${document.address}" target="_blank">${document.content}</a>
                                    </c:if>
                                </td>
                                <td align="center">
                                    <c:if test="${document.flag}">
                                        <a href="${pageContext.request.contextPath}/DocumentItem/listDocumentItem?documentCatalogId=${document.id}">查看</a>
                                    </c:if>

                                </td>
                                <td align="center">
                                    <a href="${pageContext.request.contextPath}/document_update?id=${document.id}&type=${type}&parentId=${parentId}">编辑</a> | <a
                                        href="${pageContext.request.contextPath}/document_del?id=${document.id}&type=${type}&parentId=${parentId}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                    <div class="action">
                        <select name="action" onchange="douAction()">
                            <option value="0">请选择...</option>
                            <option value="1">删除</option>
                            <option value="category_move">移动分类至</option>
                        </select>
                        <select name="new_cat_id" style="display:none">
                            <option value="0">未分类</option>
                            <option value="1"> 电子数码</option>
                            <option value="4">- 智能手机</option>
                            <option value="5">- 平板电脑</option>
                            <option value="2"> 家居百货</option>
                            <option value="3"> 母婴用品</option>
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