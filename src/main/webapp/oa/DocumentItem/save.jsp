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
<script type='text/javascript' src='/mygit/dwr/engine.js'></script>
<script type='text/javascript' src='/mygit/dwr/interface/DocumentItemWatcher.js'></script>
<script type='text/javascript' src='/mygit/dwr/util.js'></script>

<jsp:include page="/left.jsp"></jsp:include>
<div id="dcMain">
    <!-- 当前位置 -->
    <div id="urHere">DouPHP 管理中心<b>></b><strong>添加分类</strong></div>
    <div class="mainBox" style="height:auto!important;height:550px;min-height:550px;">
        <h3><a href="" class="actionBtn">文档分类</a>添加分类</h3>

        <span style="color: red">${actionErrors[0]}</span>
        <span style="color: red" id="prefresh"></span>
        <form action="${pageContext.request.contextPath}/oa/DocumentItem/upload" onsubmit="return validate()"
              method="post" id="forms" enctype="multipart/form-data">
            <table width="100%" border="0" cellpadding="8" cellspacing="0" class="tableBasic">

                <tr id="progressBar">
                    <td id="test"></td>
                    <td id="list">




                    </td>
                </tr>

                <tr>
                    <td align="right">上传文件</td>
                    <td>
                        <input type="file" name="file" size="38" class="inpFlie">
                        <img src="${pageContext.request.contextPath}/images/action_btn.gif" style="cursor: pointer"
                             @click="add">
                    </td>
                </tr>
                <tr class="close"></tr>


                <tr>
                    <td></td>
                    <td>
                        <input type="hidden" name="documentCatalogId" value="<s:property value="documentCatalogId"/>">
                        <input name="submit" class="btn" type="submit" value="提交"/>
                    </td>
                </tr>


            </table>
        </form>
    </div>
</div>


<jsp:include page="/footer.jsp"></jsp:include>
<script type="text/javascript">

    $(function () {
        $("#progressBar").css("display", "none")
    })

    function validate() {

        createView();
        startUpload()

        return true;
    }

    function createView() {

        $("#list").html("")
        for (var i = 0; i < $(":file").length; i++) {

            var $file = $($(":file")[i]);
            var name = $file.val()
            if(name.length>0) {

                var lastIndex = name.lastIndexOf("\\");
                if(-1 == lastIndex) {
                    lastIndex = name.lastIndexOf("/");
                }
               name = (i+1)+", "+name.substring(lastIndex+1,name.length);
                if(name.length>20) {
                    name = name.substring(0,20)+"..."
                }
                var addProsessBar = '   <div style="clear: both;margin-bottom: 20px;">' +
                    '                            <div style="float: left;margin-right: 20px;width: 150px">'+name+'</div>' +
                    '                            <div class="barbox"' +
                    '                                 style="width: 300px;height: 15px;border: 1px solid #000;float: left;margin-right: 20px">' +
                    '' +
                    '                                <div class="progressRate" style="width: 0px;height: 100% ;background-color: green"></div>' +
                    '                            </div>' +
                    '                            <div class="barPrecentage"></div>' +
                    '                        </div>';

                $("#list").append(addProsessBar);
            }


        }

    }

    function startUpload() {

        $("#progressBar").css("display", "")
        setTimeout("refreshProgress()", 500)
    }

    function refreshProgress() {

        DocumentItemWatcher.getUploadInfo(uploadprogress)
    }

    function uploadprogress(uploadinfo) {


        for(var i =0;i< uploadinfo.hasRead.length;i++) {
            var percentage = Math.round((uploadinfo.hasRead[i] / uploadinfo.totalSize[i]) * 100);
            if (isNaN(percentage)) { //
                percentage = 0;
            }

            $($(".progressRate")[i]).width(percentage * 3 + "px")

            $($(".barPrecentage")[i]).html(percentage + "%")

        }





        setTimeout("refreshProgress()", 1000)
    }


    var dome = ' <tr class="add">\
        <td align="right"></td>\
        <td>\
        <input type="file" name="file" size="38" class="inpFlie">\
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
                if (addLength == 0) {
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
    $("#forms").on("click", ".x", function (event) {
        $(event.target).parents("tr").remove()
        form.count--;
    })
</script>

