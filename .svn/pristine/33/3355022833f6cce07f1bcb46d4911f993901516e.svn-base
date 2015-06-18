<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.app.entity.AppDatasetRelation" %>
<%
    int currPage = req.getInt("currPage") == 0 ? 1 : req.getInt("currPage");
    int pageSize = parameter.pageSize;
    String pageUrl = req.getPageUrl();
    AppDatasetRelation oAppDatasetRelation = new AppDatasetRelation();
    Iterator it = oAppDatasetRelation.findPage(currPage, pageSize).iterator();
    Page oPage = oAppDatasetRelation.getPage();
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <LINK href="../style/default.css" rel=stylesheet>
    <script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="../js/body.js"></script>
    <script type="text/javascript" src="../js/table.js"></script>
    <title><%=Config.SystemName%>
    </title>
</head>
<body>
<table width="95%" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="10"></td>
    </tr>
    <tr>
        <td height="30">
            <input type="button" name="add" value="新建" class="btn" onClick="location.href='appRel_add.jsp';">
            <input type="button" name="edit" value="编辑" class="btn"
                   onClick="editData(document.getElementsByName('idArray'),'appRel_edit.jsp?id=')">
            <input type="button" name="delete" value="删除" class="btn" onClick="doDelete();">
            <input type="button" name="selectAll" value="全选" class="btn"
                   onClick="selectAll(document.getElementsByName('idArray'))">
            <input type="button" name="inverse" value="反选" class="btn"
                   onClick="inverse(document.getElementsByName('idArray'))">
        </td>
    </tr>
</table>
<br>
<table class="list" FixRow="<%=pageSize%>" cellspacing=1 cellpadding=0 width="95%" align=center border=0>
    <tr class="title">
        <td>选择</td>
        <td DataType="NUMBER">ID</td>
        <td DataType="NUMBER">应用ID</td>
        <td DataType="NUMBER">数据集ID</td>
        <td DataType="DATE">创建时间</td>
    </tr>
    <%
        while (it.hasNext()) {
            AppDatasetRelation appDatasetRelation = (AppDatasetRelation) it.next();
    %>
    <tr>
        <td><input name="idArray" type="checkbox" value="<%=appDatasetRelation.getId()%>"></td>
        <td><a href="appRel_view.jsp?id=<%=appDatasetRelation.getId()%>"><%=appDatasetRelation.getId()%>
        </a></td>
        <td><%=appDatasetRelation.getAppId()%>
        </td>
        <td><%=appDatasetRelation.getDatasetId()%>
        </td>
        <td><%=appDatasetRelation.getCreateTime()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="50%" height="33" align="left"><%=oPage.getInfo()%>
        </td>
        <td width="50%" align="right"><%=oPage.getButton(pageUrl)%>
        </td>
    </tr>
</table>
</body>
</html>
<script language="javascript">
    //删除--恢复选中记录
    function doDelete() {
        if (setupData(document.getElementsByName('idArray'), 'appRelAction.do?action=deleteData'))
            document.location.reload();
    }
</script>
