<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.data.entity.DataResource" %>
<%
    String datasetId = req.getString("datasetId");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <LINK href="../style/default.css" rel=stylesheet>
    <script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="../js/body.js"></script>
    <%@ include file="../easyui_include.jsp" %>
    <%@ include file="../kindeditor_include.jsp" %>
    <title><%=Config.SystemName%>
    </title>
</head>
<body>
<form id="dataForm" name="dataForm" method="post" ENCTYPE="multipart/form-data"
      action="dataResourceAction.do?action=addData"
      Check="true" Change="true">
    <table class="edit" cellspacing=1 cellpadding=3 width="95%" align=center border=0>
        <tr class="title">
            <td colspan="4">
                <b>数据资源新增</b>
                <input type="hidden" name="datasetId" value="<%=datasetId %>">
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">名称</td>
            <td><input name="name" type="text" size="30" validType="maxLength[160]"
                       class="easyui-textbox easyui-validatebox" required="true"></td>
            <td width="15%" align="right">标题</td>
            <td><input name="title" type="text" size="30" validType="maxLength[160]"
                       class="easyui-textbox easyui-validatebox"
                       required="true"></td>
        </tr>
        <tr>
            <td width="15%" align="right">描述</td>
            <td colspan="3"><textarea id="editor_id" name="description"
                                      style="width: 800px; height: 400px;"></textarea></td>
        </tr>
        <tr>
            <td width="15%" align="right">资源类型</td>
            <td colspan="3">
                <input type="radio" name="resType" value="url"> URL
                <input type="radio" name="resType" value="file" checked> 文件上传
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">来源URL</td>
            <td><input id="sourceUrl" name="sourceUrl" type="text" size="30" validType="maxLength[160]"
                       class="easyui-textbox easyui-validatebox" disabled="disabled"></td>
            <td width="15%" align="right">文件</td>
            <td>
                <input type="hidden" name="sourceCode" value="dataResource">
                <input id="fileId" name="fileId" class="easyui-filebox" size="40" required="true"
                       data-options="onChange:fileChange,prompt:'允许的文件类型txt,csv,html,xml,xls',buttonText:'选择文件'"></td>
        </tr>
        <tr>
            <td width="15%" align="right">版本</td>
            <td colspan="3">
                <input type="text" class="easyui-numberbox" name="version" size="30"
                       data-options="min:0,max:9.9,precision:1"></td>
        </tr>
    </table>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="29" align="center">
                <input type="hidden" id="flow" name="flow" value="single">
                <input type="button" class="btn"
                       border="0" name="sure" value="确定" onclick="doSubmit(1)">
                <input
                        type="button" class="btn" border="0" name="continueAddResource"
                        value="确定并继续添加数据资源" onclick="doSubmit(2)">
                <input type="button" class="btn" border="0" name="return" value="返回" onclick="history.back(-1);">
            </td>
        </tr>
    </table>
</form>
</body>
<script type="application/javascript">
    KindEditor.ready(function (K) {
        window.editor = K.create('#editor_id', {
            cssPath: '/kindeditor/plugins/code/prettify.css',
            uploadJson: '/kindeditor/jsp/upload_json.jsp',
            fileManagerJson: '/kindeditor/jsp/file_manager_json.jsp',
            allowFileManager: true
        });
    });
    $('input[name="resType"]').on('click', function () {
        switch ($(this).val()) {
            case 'url':
                $('#sourceUrl').textbox('enable');
                $('#sourceUrl').textbox({required: true});
                $('#fileId').filebox('disable');
                //因为把filebox 设为 disable 只是禁用了输入框，还须禁用带的按钮
                $('#fileId').filebox('button').linkbutton("disable");
                $('#fileId').filebox({required: false});
                break;
            case 'file':
                $('#sourceUrl').textbox('disable');
                $('#sourceUrl').textbox({required: false});
                $('#fileId').filebox('enable');
                $('#fileId').filebox('button').linkbutton("enable");
                $('#fileId').filebox({required: true});
                break;
        }
    });
    //验证并提交表单
    function doSubmit(type) {
        var flow = $('#flow');
        switch (type) {
            case 1:
                flow.val('single');
                break;
            case 2:
                flow.val('multi');
                break;
        }
        if ($('#dataForm').form('validate')) {
            editor.sync();
            if (editor.html().length > 2000) {
                $.messager.alert('警告', '备注长度超过2000个字符！', 'warning');
                return;
            }
            $('#dataForm').submit();
        }
    }

    function fileChange(newValue, oldValue) {
        var acceptFileType = ['txt', 'csv', 'html', 'xml', 'xls'];
        var postfix = newValue.substr(newValue.lastIndexOf('.') + 1);
        if ($.inArray(postfix, acceptFileType) == -1) {
            $.messager.alert('警告', '不允许上传的文件类型', 'warning');
            $('#fileId').filebox('clear');
        }
    }
</script>
</html>
