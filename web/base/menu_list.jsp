<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseMenu" %>
<%
    int state = req.getInt("state") == -1 ? -1 : 1;
    String searchField = req.getString("searchField");
    String searchValue = req.getString("searchValue");
    String search = req.getString("search");
    Iterator it = new BaseMenu().findAllNode(state).iterator();
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
<body>
<table border="0" cellpadding="0" cellspacing="0" width="95%" align="center">
    <tr>
        <td width="100%">
            <table width="100%" cellspacing="0" cellpadding="0">
                <tr>
                    <td colspan="2" height="10"></td>
                </tr>
                <tr>
                    <td width="68%"><input type=button class="btn" onClick="location.href='menu_add.jsp';" border="0"
                                           name="add" value="新建"/>
                        <input type=button class="btn"
                               onClick="editData(getElementsByName('idArray'),'menu_edit.jsp?id=')" border="0"
                               name="edit" value="编辑"/>
                        <input type=button class="btn" onClick="doDelete(0);" border="0" name="delete" value="删除"/>
                        <input type=button class="btn" onClick="doDelete(1);" border="0" name="resume" value="恢复"/>
                        <input type=button class="btn" border="0" name="selectAll" value="全选"
                               onClick="selectAll(getElementsByName('idArray'))"/>
                        <input type=button class="btn" border="0" name="inverse" value="反选"
                               onClick="inverse(getElementsByName('idArray'))"/>
                    </td>
                    <td width="31%" height="30" align="right">&nbsp; </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<form id="searchForm" name="searchForm" method="post" action="menu_list.jsp">
    <table class="query_table" cellspacing=0 cellpadding=0 width="95%" align=center border=0>
        <tr>
            <td height="34"> &nbsp;
                <select name="searchField" SelectValue="<%=searchField%>">
                    <option value="name" selected>菜单名称</option>
                    <option value="value">网址</option>
                </select>
                ：
                <input size="40" name="searchValue" value="<%=searchField.equals("id")?"":searchValue%>">
                <input type="checkbox" value="-1" name="state" <%=state==-1?"checked":""%>>
                显示已删除菜单
            </td>
            <td width="6%"><input type=button class="btn" onClick="doSearch()" border="0" name="search" value="搜索"></td>
        </tr>
    </table>
</form>
<br>
<table width="95%" border="0" align=center cellpadding=0 cellspacing=1 class="listTree" FilesDir="../js" startcol="1"
       expancelevel="1">
    <tbody>
    <tr class="title">
        <td width="5%" height="24">选择</td>
        <td width="22%">菜单名称</td>
        <td width="54%">网址</td>
        <td width="10%">目标</td>
        <td width="9%">有效</td>
    </tr>
    <%
        while (it.hasNext()) {
            BaseMenu baseMenu = (BaseMenu) it.next();
            String isShow = "";
            if (!search.equals("") && !searchValue.equals("")) {
                if (searchField.equals("id") && baseMenu.getId() == Convert.toLong(searchValue)) isShow = "true";
                else if (searchField.equals("name") && baseMenu.getName().indexOf(searchValue) != -1) isShow = "true";
                else if (searchField.equals("value") && baseMenu.getValue().indexOf(searchValue) != -1) isShow = "true";
            }
    %>
    <tr level="<%=baseMenu.getLevel()%>" isLeaf="<%=baseMenu.isLeaf()%>" html="<%=baseMenu.getLevelHtml()%>"
        isShow="<%=isShow%>">
        <td align="center"><input name="idArray" type="checkbox" value="<%=baseMenu.getId()%>"></td>
        <td align="left">&nbsp;<%=baseMenu.getName()%>
        </td>
        <td align="left">&nbsp;<%=baseMenu.getValue()%>
        </td>
        <td align="left">&nbsp;<%=baseMenu.getTarget()%>
        </td>
        <td><%=baseMenu.getState() == 1 ? "√" : "×"%>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
</body>
</html>
<script language="javascript">
    //删除选中记录
    function doDelete(state) {
        if (setupData(document.getElementsByName('idArray'), 'menuAction.do?action=updateState&state=' + state))
            document.location.reload();
    }


    //响应搜索按钮
    function doSearch() {
        //doSend();
        $('#searchForm').submit();
    }
</script>