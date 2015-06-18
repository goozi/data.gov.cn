<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseType" %>
<%@ page import="com.dhccity.base.business.TypeApp" %>
<%
    long parentId = req.getLong("parentId");
    BaseType baseType = (BaseType) new BaseType().findById(parentId);
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <LINK href="../style/default.css" rel=stylesheet>
    <script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
    <%@ include file="../easyui_include.jsp" %>
    <title><%=Config.SystemName%>
    </title>
</head>

<body>
<form id="frm" name="frm" method="POST" action="typeAction.do?action=addChildType" Check="true" Change="true">

    <table class="edit" cellspacing=1 cellpadding=3
           width="95%" align=center border=0>
        <tbody>
        <tr class="title">
            <td colspan=4 height=8><b>类型选项信息</b></td>
        </tr>
        <tr>
            <td width="19%" align=right>名称：</td>
            <td colspan="3"><input id="name" name="name" type="text" size="50" required="true" validType="maxLength[80]"
                                   class="easyui-textbox easyui-validatebox">
                <input type="hidden" name="code" value="<%=baseType.getCode()%>"/>
                <input type="hidden" name="type" value="<%=baseType.getType()%>"/></td>
        </tr>
        <%if (baseType.getType().equals("TREE")) {%>
        <tr>
            <td align=right>上级选项：</td>
            <td colspan="3"><%=TypeApp.createSelfSelect("parentId", baseType.getCode(), false)%>
            </td>
        </tr>
        <%
            } else {
                out.print("<input name='parentId' type='hidden' value='" + parentId + "'>");
            }
        %>
        <tr>
            <td align=right>值：</td>
            <td width="37%"><input id="value1" name="value" type="text" size="40" validType="maxLength[80]"
                                   class="easyui-textbox easyui-validatebox">
            </td>
            <td width="16%" align="right">顺序种子：</td>
            <td width="28%"><input name="sequ" type="text" size="10"
                                   class="easyui-numberbox" data-options="min:0,max:999"></td>
        </tr>
        <tr>
            <td height="20" align=right>有效：</td>
            <td><input name="state" type="checkbox" checked value="1">
            </td>
            <td align="right">是否默认：</td>
            <td><input type="checkbox" name="isDefault" value="1">
            </td>
        </tr>
        </tbody>
    </table>
    <br>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="29" align="center">
                <input type="submit" class="btn" border="0" name="save" value="确定">
                <input type=button class="btn" border="0" name="cancel" value="取消" onclick="self.close();">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
<script language="JavaScript">
    $('#name').textbox({onChange:function(newValue,oldValue){
        $('#value1').val(newValue);
    }});
    $('#frm').submit(function () {
        return $('#frm').form('validate');
    });
</script>
