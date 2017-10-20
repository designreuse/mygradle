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
                <li>
                    <a href="${pageContext.request.contextPath}/documentcatelog/listtree.jsp?type=1&parentId=-1">公司文档图</a>
                </li>
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
        var   parentId = ${param.parentId}
        var src = "${pageContext.request.contextPath}/oa/treedocument?type=${param.type}";

       var tree = $('#jstree').jstree({
            'core': {
                'data': {
                    "url": src,
                    "dataType": "json",// needed only if you do not supply JSON
                    'data': function (node) {
                        src = "${pageContext.request.contextPath}/oa/treedocument?type=${param.type}"
                        if('#'!=node.id) {
                            parentId = node.original.parentId;
                        }

                        return {'parentId':parentId,'id': node.id};
                    },
                    'check_callback' : function(o, n, p, i, m) {
                        if(m && m.dnd && m.pos !== 'i') { return false; }
                        if(o === "move_node" || o === "copy_node") {
                            if(this.get_node(n).parent === this.get_node(p).id) { return false; }
                        }
                        return true;
                    },
                    'themes' : {
                        'responsive' : false,
                        'variant' : 'small',
                        'stripes' : true
                    }

                }

            },
            'sort' : function(a, b) {
                return this.get_type(a) === this.get_type(b) ? (this.get_text(a) > this.get_text(b) ? 1 : -1) : (this.get_type(a) >= this.get_type(b) ? 1 : -1);
            },
            'contextmenu' : {
                'items' : function(node) {
                    var tmp = $.jstree.defaults.contextmenu.items();
                    delete tmp.create.action;
                    tmp.create.label = "New";
                    tmp.create.submenu = {
                        "create_folder" : {
                            "separator_after"	: true,
                            "label"				: "Folder",
                            "action"			: function (data) {
                                var inst = $.jstree.reference(data.reference),
                                    obj = inst.get_node(data.reference);
                                inst.edit(obj)

                                inst.create_node(obj, { type : "default" }, "last", function (new_node) {
//                                    setTimeout(function () { inst.edit(new_node); },0);
                                    alert(new_node.id)
                                },true);
                            }
                        },
                        "create_file" : {
                            "label"				: "File",
                            "action"			: function (data) {
                                var inst = $.jstree.reference(data.reference),
                                    obj = inst.get_node(data.reference);
                                inst.create_node(obj, { type : "file" }, "last", function (new_node) {
                                    setTimeout(function () { inst.edit(new_node); },0);
                                });
                            }
                        }
                    };
                    if(this.get_type(node) === "file") {
                        delete tmp.create;
                    }
                    return tmp;
                }
            },
            'types' : {
                'default' : { 'icon' : 'folder' },
                'file' : { 'valid_children' : [], 'icon' : 'file' }
            },
            'unique' : {
                'duplicate' : function (name, counter) {
                    return name + ' ' + counter;
                }
            },
            'plugins' : ['state','dnd','sort','types','contextmenu','unique']

        }).on('changed.jstree', function (e, data) {
            <%--console.log("data:  " + data)--%>

            <%--var parentId = data.node.original.parentId;--%>
            <%--var parentName = data.node.original.id;--%>
            <%--if (!parentName) {--%>
                <%--parentName = data.node.original.text;--%>
            <%--}--%>
            <%--src = "${pageContext.request.contextPath}/oa/treedocument?type=${param.type}&parentId=" + parentId + "&parentName=" + parentName;--%>

        }).on('before_open.jstree', function (e, data) {
            <%--var parentId = data.node.original.parentId;--%>
            <%--var parentName = data.node.original.id;--%>
            <%--if (!parentName) {--%>
                <%--parentName = data.node.original.text;--%>
            <%--}--%>
            <%--src = "${pageContext.request.contextPath}/oa/treedocument?type=${param.type}&parentId=" + parentId + "&parentName=" + parentName;--%>

            <%--alert(src);--%>
            <%--data.instance.refresh();--%>
            alert("before_open "+data.node.id );

        })
        .on('move_node.jstree', function (e, data) {
//                $.get('?operation=move_node', { 'id' : data.node.id, 'parent' : data.parent })
//                    .done(function (d) {
//                        //data.instance.load_node(data.parent);
//                        data.instance.refresh();
//                    })
//                    .fail(function () {
//                        data.instance.refresh();
//                    });
            alert("move_node "+data.node.id );
            })
            .on('create_node.jstree', function (e, data) {
//                $.get('?operation=create_node', { 'type' : data.node.type, 'id' : data.node.parent, 'text' : data.node.text })
//                    .done(function (d) {
//                        data.instance.set_id(data.node, d.id);
//                    })
//                    .fail(function () {
//                        data.instance.refresh();
//                    });
                alert("create_node "+data.node.id );
            })
            .on('rename_node.jstree', function (e, data) {
//                $.get('?operation=rename_node', { 'id' : data.node.id, 'text' : data.text })
//                    .done(function (d) {
//                        data.instance.set_id(data.node, d.id);
//                    })
//                    .fail(function () {
//                        data.instance.refresh();
//                    });
                alert('rename_node  '+data.node.id)
            })
            .on('move_node.jstree', function (e, data) {
//                $.get('?operation=move_node', { 'id' : data.node.id, 'parent' : data.parent })
//                    .done(function (d) {
//                        //data.instance.load_node(data.parent);
//                        data.instance.refresh();
//                    })
//                    .fail(function () {
//                        data.instance.refresh();
//                    });
                alert('move_node  '+data.node.id)
            })
            .on('copy_node.jstree', function (e, data) {
//                $.get('?operation=copy_node', { 'id' : data.original.id, 'parent' : data.parent })
//                    .done(function (d) {
//                        //data.instance.load_node(data.parent);
//                        data.instance.refresh();
//                    })
//                    .fail(function () {
//                        data.instance.refresh();
//                    });

                alert('copy_node  '+data.node.id)
            })














    })




</script>