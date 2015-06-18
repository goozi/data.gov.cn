<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="../include.jsp" %>
<%
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <LINK href="../style/default.css" rel=stylesheet>
    <script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="../js/body.js"></script>
    <%@ include file="../easyui_include.jsp" %>
    <%@ include file="../kindeditor_include.jsp" %>
    <title><%=Config.SystemName%>
    </title>
</head>
<body>
<form id="dataForm" name="dataForm" method="post" action="appAction.do?action=addData"  ENCTYPE="multipart/form-data">
    <table class="edit" cellspacing=1 cellpadding=3 width="95%" align=center border=0>
        <tr class="title">
            <td colspan="4"><b>应用新增</b></td>
        </tr>
        <tr>
            <td width="15%" align="right">英文名</td>
            <td><input name="name" type="text" size="30" validType="maxLength[160]"
                       class="easyui-textbox easyui-validatebox" required="required"></td>
            <td width="15%" align="right">中文名</td>
            <td><input name="cnName" type="text" size="30" validType="maxLength[160]"
                       class="easyui-textbox easyui-validatebox" required="required"></td>
        </tr>
        <tr>
            <td width="15%" align="right">描述</td>
            <td colspan="3"><textarea id="editor_id" name="description"
                          style="width: 800px; height: 400px;"></textarea></td>
        </tr>
        <tr>
            <td width="15%" align="right">应用操作系统</td>
            <td ><%=TypeApp.createCheckbox("appOs","APP_OS",TypeApp.VALUE)%></td>
            <td width="15%" align="right">URL</td>
            <td><input name="url" type="text" size="80" validType="maxLength[160]"
                                   class="easyui-textbox easyui-validatebox" required="required"></td>
        </tr>
        <tr>
            <td width="15%" align="right">开发人</td>
            <td><input name="developer" type="text" size="30" validType="maxLength[160]"
                       class="easyui-textbox easyui-validatebox" required="required"></td>
            <td width="15%" align="right">关联数据集</td>
            <td><input id="relDatasetId" name="relDatasetId" type="text" size="30"></td>
        </tr>
        <tr>
            <td width="15%" align="right">应用图标</td>
            <td colspan="3">
                <jsp:include page="/base/file_add.jsp" flush="true">
                    <jsp:param name="sourceCode" value="appThumbnail"/>
                    <jsp:param name="isSingle" value="true"/>
                </jsp:include>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">应用截图</td>
            <td colspan="3">
                <jsp:include page="/base/file_add.jsp" flush="true">
                    <jsp:param name="sourceCode" value="appPic"/>
                    <jsp:param name="isSingle" value="false"/>
                </jsp:include>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">应用收费类型</td>
            <td><%=TypeApp.createRadio("appCharge", "APP_CHARGE", TypeApp.VALUE)%>
            </td>
            <td width="15%" align="right">类别</td>
            <td><%=TypeApp.createRadio("category", "APP_CATEGORY", TypeApp.VALUE)%></td>
        </tr>
    </table>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="29" align="center">
                <input type="button" class="btn" border="0" onclick="doSubmit()" name="sure" value="确定">
                <input type="button" class="btn" border="0" name="return" value="返回" onclick="history.back(-1);">
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    KindEditor.ready(function(K) {
        window.editor = K.create('#editor_id', {
            cssPath : '/kindeditor/plugins/code/prettify.css',
            uploadJson : '/kindeditor/jsp/upload_json.jsp',
            fileManagerJson : '/kindeditor/jsp/file_manager_json.jsp',
            allowFileManager : true
        });
    });
    $('#relDatasetId').combobox({
        url:'/data/datasetAction.do?action=loadJsonData',
        valueField:'id',
        textField:'text'
    });
    //验证并提交表单
    function doSubmit() {
        if ($('#dataForm').form('validate')) {
            editor.sync();
            if(editor.html().length>2000){
                $.messager.alert('警告', '描述长度超过2000个字符！', 'warning');
                return;
            }
            $('#dataForm').submit();
        }
    }
</script>
</html>
