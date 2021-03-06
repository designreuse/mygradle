<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<jsp:include page="/head.jsp"></jsp:include>

<jsp:include page="/left.jsp"></jsp:include>


<div id="dcMain">
    <!-- 当前位置 -->
    <div id="urHere">DouPHP 管理中心<b>></b><strong>添加分类</strong></div>
    <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="${pageContext.request.contextPath}/oa/Board/addBoard.jsp" class="actionBtn">添加板块</a>板块</h3>
        <div class="filter">
            <form action="product.php" method="post">
                <select name="cat_id">
                    <option value="0">未分类</option>

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
                        <th width="80" align="center">论坛板块</th>

                        <th width="80" align="center">论坛说明</th>

                        <th width="80" align="center">主题数</th>

                        <th width="80" align="center">总帖数</th>

                        <th width="80" align="center">帖子</th>



                        <th width="80" align="center">操作</th>
                    </tr>

                    <s:iterator value="list" var="bean" status="vs">
                        <tr>
                            <td align="center"><input type="checkbox" name="checkbox[]" value="<s:property value="id" />"/></td>
                            <td align="center">${vs.count}</td>
                             <td align="center"><s:property value="name" /></td>

                            <td align="center"><s:property value="description" escapeHtml="false"/></td>

                            <td align="center"><s:property value="topicCount" /></td>

                            <td align="center"><s:property value="postCount" /></td>
                            <td align="center">
                                <a href="${pageContext.request.contextPath}/oa/Topic/listTopic?parentId=<s:property value="id" />">进入</a>
                            </td>



                            <td align="center">
                                <a href="${pageContext.request.contextPath}/oa/Board/updatepBoard?id=${bean.id}&start=<s:property value='start'/>&range=<s:property value='range'/>">编辑</a> |
                                <a href="${pageContext.request.contextPath}/oa/Board/deleteBoard?id=${bean.id}&start=<s:property value='start'/>&range=<s:property value='range'/>">删除</a>
                            </td>

                        </tr>


                    </s:iterator>

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
        <div class="pager">
            <s:property value="pageInfo"  escapeHtml="false" />

        </div>

    </div>



</div>
<jsp:include page="/footer.jsp"></jsp:include>