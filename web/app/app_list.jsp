<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.app.entity.App" %>
<%@ page import="com.dhccity.base.entity.BaseUser" %>
<%
    int currPage = req.getInt("currPage") == 0 ? 1 : req.getInt("currPage");
    int pageSize = parameter.pageSize;
    String pageUrl = req.getPageUrl();
    String searchField = req.getString("searchField");
    String searchValue = req.getString("searchValue");
    App oApp = new App();
    Iterator it = null;
    if (req.getString("search").equals(""))
        it = oApp.findPage(currPage, pageSize).iterator();
    else
        ;//it=oApp.search(searchField,searchValue,currPage,pageSize).iterator();
    Page oPage = oApp.getPage();

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
            <input type="button" name="add" value="新建" class="btn" onClick="location.href='app_add.jsp';">
            <input type="button" name="edit" value="编辑" class="btn"
                   onClick="editData(document.getElementsByName('idArray'),'app_edit.jsp?id=')">
            <input type="button" name="delete" value="删除" class="btn" onClick="doDelete();">
            <input type="button" name="selectAll" value="全选" class="btn"
                   onClick="selectAll(document.getElementsByName('idArray'))">
            <input type="button" name="inverse" value="反选" class="btn"
                   onClick="inverse(document.getElementsByName('idArray'))">
        </td>
    </tr>
</table>
<table class="query_table" cellspacing="0" cellpadding="0" width="95%" align="center" border="0">
    <form id="searchForm" name="searchForm" method="post" action="user_list.jsp">
        <tr>
            <td height="34">
                <select name="searchField" SelectValue="<%=searchField%>">
                    <option value="name">英文名</option>
                    <option value="cnName">中文名</option>
                    <option value="developer">开发人</option>
                </select>：
                <input size="20" name="searchValue" value="<%=searchValue%>">
            </td>
            <td width="6%">
                <input type=button class="btn" onClick="doSearch()" border="0" name="search" value="搜索">
            </td>
        </tr>
    </form>
</table>
<br>
<table class="list" FixRow="<%=pageSize%>" cellspacing=1 cellpadding=0
       width="95%" align=center border=0>
    <tr class="title">
        <td>选择</td>
        <td DataType="NUMBER">ID</td>
        <td>应用名</td>
        <td>开发人</td>
        <td DataType="NUMBER">提交人</td>
        <td DataType="NUMBER">应用收费类型</td>
        <td DataType="NUMBER">类别</td>
    </tr>
    <%
        while (it.hasNext()) {
            App app = (App) it.next();
            BaseUser submitter = (BaseUser)new BaseUser().findById(app.getSubmitterId());
    %>
    <tr>
        <td><input name="idArray" type="checkbox" value="<%=app.getId()%>"></td>
        <td><a href="app_view.jsp?id=<%=app.getId()%>"><%=app.getId()%>
        </a></td>
        <td><%=app.getCnName()%>
        </td>
        <td><%=app.getDeveloper()%>
        </td>
        <td><%=submitter.getName()%>
        </td>
        <td><%=TypeApp.getName("APP_CHARGE", app.getAppCharge())%>
        </td>
        <td><%=TypeApp.getName("APP_CATEGORY", app.getCategory())%>
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
        if (setupData(document.getElementsByName('idArray'), 'appAction.do?action=deleteData'))
            document.location.reload();
    }
    //响应搜索按钮
    function doSearch() {
        $("#searchForm").submit();
    }
</script>
