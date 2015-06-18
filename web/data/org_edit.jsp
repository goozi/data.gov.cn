<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.data.entity.Org" %>
<%@ page import="com.dhccity.base.util.StringUtil" %>
<%
    long id = req.getLong("id");
    Org org = (Org) new Org().findById(id);
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <LINK href="../style/default.css" rel=stylesheet>
    <link rel="stylesheet" href="/js/font-awesome/css/font-awesome.css">
    <script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="../js/body.js"></script>
    <%@ include file="../easyui_include.jsp" %>
    <%@ include file="../kindeditor_include.jsp" %>
    <title><%=Config.SystemName%>
    </title>
</head>
<body>
<form id="dataForm" name="dataForm" method="post" action="orgAction.do?action=updateData" Check="true" Change="true">
    <table class="edit" cellspacing=1 cellpadding=3 width="95%" align=center border=0>
        <tr class="title">
            <td colspan="4"><b>机构编辑</b></td>
        </tr>
        <tr>
            <td width="15%" align="right">名称</td>
            <td><input name="name" type="text" size="30" value="<%=org.getName()%>" validType="maxLength[160]"
                       class="easyui-textbox easyui-validatebox" required="true"></td>
            <td width="15%" align="right">标题</td>
            <td><input name="title" type="text" size="30" value="<%=org.getTitle()%>" validType="maxLength[160]"
                       class="easyui-textbox easyui-validatebox" required="true"></td>
        </tr>
        <tr>
            <td width="15%" align="right">描述</td>
            <td colspan="3">
            <textarea id="editor_id" name="description"
                      style="width: 800px; height: 400px;"><%=StringUtil.htmlspecialchars(org.getDescription())%></textarea>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">LOGO</td>
            <td colspan="3"><i class="fa fa-3x <%=org.getLogo()%>"></i>
                <input name="logo" type="text" size="30"
                       value="<%=org.getLogo()%>"
                       validType="maxLength[160]"
                       class="easyui-textbox easyui-validatebox"
                       required="true"></td>
        </tr>
    </table>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="29" align="center">
                <input name="id" type="hidden" value="<%=org.getId()%>">
                <input type="submit" class="btn" border="0" name="sure" value="确定">
                <input type="button" class="btn" border="0" name="return" value="返回" onclick="history.back(-1);">
            </td>
        </tr>
    </table>
</form>
</body>
<script>
    KindEditor.ready(function (K) {
        window.editor = K.create('#editor_id', {
            cssPath: '/kindeditor/plugins/code/prettify.css',
            uploadJson: '/kindeditor/jsp/upload_json.jsp',
            fileManagerJson: '/kindeditor/jsp/file_manager_json.jsp',
            allowFileManager: true
        });
    });
    $('#dataForm').submit(function () {
        if ($('#dataForm').form('validate')) {
            editor.sync();
            if (editor.html().length > 2000) {
                $.messager.alert('警告', '描述长度超过2000个字符！', 'warning');
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    });
</script>
</html>
