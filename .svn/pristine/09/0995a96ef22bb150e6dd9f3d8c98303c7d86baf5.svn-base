<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.base.util.StringUtil" %>
<%@ page import="com.dhccity.data.entity.DataResource" %>
<%
    long id = req.getLong("id");
    DataResource dataResource = (DataResource) new DataResource().findById(id);
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <LINK href="../style/default.css" rel=stylesheet>
    <script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>
    <script type="text/javascript" src="../js/body.js"></script>
    <%@ include file="../easyui_include.jsp" %>
    <%@ include file="../kindeditor_include.jsp" %>
    <title><%=Config.SystemName%>
    </title>
</head>
<body>
<form id="dataForm" name="dataForm" method="post" ENCTYPE="multipart/form-data"
      action="/data/dataResourceAction.do?action=updateData"
      Check="true" Change="true">
    <table class="edit" cellspacing=1 cellpadding=3 width="95%" align=center border=0>
        <tr class="title">
            <td colspan="4"><b>API资源编辑</b></td>
        </tr>
        <tr>
            <td width="15%" align="right">API名</td>
            <td colspan="3"><input name="title" type="text" size="60" value="<%=dataResource.getTitle()%>"
                       validType="maxLength[160]" class="easyui-textbox easyui-validatebox" required></td>
        </tr>
        <tr>
            <td width="15%" align="right">API描述</td>
            <td colspan="3">
			<textarea id="editor_id" name="description"
                      style="width: 800px; height: 400px;"><%=StringUtil.htmlspecialchars(dataResource.getDescription())%></textarea>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">API地址</td>
            <td colspan="3"><input name="sourceUrl" type="text" size="60" value="<%=dataResource.getSourceUrl()%>"
                       validType="maxLength[160]"
                       class="easyui-textbox easyui-validatebox" required="true">
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">版本</td>
            <td>
                <input type="text" class="easyui-numberbox" name="version" size="30"
                       data-options="min:0,max:9.9,precision:1" value="<%=dataResource.getVersion()%>"></td>
            </td>
            <td></td>
            <td></td>
        </tr>
    </table>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="29" align="center">
                <input name="id" type="hidden" value="<%=dataResource.getId()%>">
                <input type="hidden" id="resType" name="resType" value="<%=dataResource.getResType()%>">
                <input type="hidden" id="flow" name="flow" value="single_api">
                <input type="button" class="btn" border="0" name="sure" value="确定">
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
    //验证并提交表单
    $('#dataForm').on('click', function () {
        if ($('#dataForm').form('validate')) {
            editor.sync();
            if (editor.html().length > 2000) {
                $.messager.alert('警告', '备注长度超过2000个字符！', 'warning');
                return;
            }
            $("#dataForm").ajaxSubmit({
                type: 'post',
                url: "/data/dataResourceAction.do?action=updateData",
                success: function (regBack) {
                    if (regBack == 'success') {
                        $.messager.alert('成功', '编辑成功！', 'info');
                    }
                }
            });
        }
    });
</script>
</html>
