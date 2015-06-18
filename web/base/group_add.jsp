<%@ page language="java" pageEncoding="utf-8" %>
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
    <script type="text/javascript" src="../js/body.js"></script>
    <%@ include file="../easyui_include.jsp" %>
    <title><%=Config.SystemName%>
    </title>
</head>
<body>
<form id="dataForm" name="dataForm" method="POST" action="typeAction.do?action=addChildType" Check="true" Change="true">
    <table class="edit" cellspacing=1 cellpadding=3 width="95%" align=center border=0>
        <tbody>
        <tr class="title">
            <td colspan=4 height=8><b>类型选项信息
            </b></td>
        </tr>
        <tr>
            <td width="19%" align=right>名称：</td>
            <td colspan="3"><input name="name" type="text" size="50" required="true" validType="maxLength[80]"
                                   class="easyui-textbox easyui-validatebox">
                <input type="hidden" name="code" value="<%=baseType.getCode()%>"/>
                <input type="hidden" name="type" value="<%=baseType.getType()%>"/>
            </td>
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
            <td align=right>有效：</td>
            <td width="37%"><input name="state" type="checkbox" checked value="1"></td>
            <td width="16%" align="right">顺序种子：</td>
            <td width="28%"><input name="sequ" type="text" size="10"  data-options="min:0,max:999" class="easyui-numberbox"></td>
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
