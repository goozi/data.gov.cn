<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseType" %>
<%
    String code = req.getString("code");
    int state = req.getInt("state") == -1 ? -1 : 1;
    String name = code.equals("DUTY") ? "职务" : "角色";
    BaseType oBaseType = (BaseType) new BaseType().findByCode(code);
    Iterator it = new BaseType().findAllChildType(code, state).iterator();

%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <LINK href="../style/default.css" rel=stylesheet>
    <script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="../js/body.js"></script>
    <script type="text/javascript" src="../js/treeTable.js"></script>
    <title><%=Config.SystemName%>
    </title>
</head>
<body leftmargin="0" topmargin="0">
<br>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="72%" height="29" valign="middle">
            <input type=button class="btn"
                   onClick="openCenter('group_add.jsp?parentId=<%=oBaseType.getId()%>','',210,700);"
                   border="0" name="add" value="新建">
            <input type=button class="btn"
                   onClick="editData(document.getElementsByName('idArray'),'group_edit.jsp?id=',210,700)" border="0"
                   name="edit" value="编辑">
        </td>
        <td width="72%" align="right" valign="middle"><input type="checkbox" value="-1" id="state" name="state"
                                                             onClick="doChange()" <%=state==-1?"checked":""%>>
            显示已删除<%=name%>
        </td>
    </tr>
</table>
<table width="95%" border="0" align=center cellpadding=0 cellspacing=1 class="listTree" FilesDir="../js" startcol="1"
       expancelevel="2">
    <tbody>
    <tr class="title">
        <td width="5%">选择</td>
        <td width="51%"><%=name%>名称</td>
        <td>顺序种子</td>
        <td height=24>有效</td>
    </tr>
    <%
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();%>
    <tr level="<%=baseType.getLevel()%>" isLeaf="<%=baseType.isLeaf()%>" html="<%=baseType.getLevelHtml()%>">
        <td align="center"><input name="idArray" type="checkbox" value="<%=baseType.getId()%>"></td>
        <td width="51%" align="left"><%=baseType.getName()%>
        </td>
        <td width="29%"><%=baseType.getSequ()%>
        </td>
        <td width="15%"><%=baseType.getState() == 1 ? "√" : "×"%>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
<script>
    function doChange() {
        if ($("#state").attr('checked')) {
            location.href = "group_list.jsp?code=<%=code%>&state=-1";
        }
        else {
            location.href = "group_list.jsp?code=<%=code%>&state=1";
        }
    }
</script>