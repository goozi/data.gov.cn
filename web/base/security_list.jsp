<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="/include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseSecurity" %>
<%
    int state = req.getInt("state") == -1 ? -1 : 1;
    String searchField = req.getString("searchField");
    String searchValue = req.getString("searchValue");
    String search = req.getString("search");
    Iterator it = new BaseSecurity().findAllItem(state).iterator();
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
                    <td width="68%"><input type=button class="btn" onClick="location.href='security_add.jsp';"
                                           border="0" name="add" value="新建">
                        <input type=button class="btn"
                               onClick="editData(document.getElementsByName('idArray'),'security_edit.jsp?id=')"
                               border="0" name="edit" value="编辑">
                        <input type=button class="btn" onClick="doDelete(0);" border="0" name="delete" value="删除">
                        <input type=button class="btn" onClick="doDelete(1);" border="0" name="resume" value="恢复">
                        <input type=button class="btn" border="0" name="selectAll" value="全选"
                               onClick="selectAll(document.getElementsByName('idArray'))">
                        <input type=button class="btn" border="0" name="inverse" value="反选"
                               onClick="inverse(document.getElementsByName('idArray'))">
                    </td>
                    <td width="31%" height="30" align="right">&nbsp; </td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<table class="query_table" cellspacing=0 cellpadding=0 width="95%" align=center border=0>
    <form id="searchForm" name="searchForm" method="post" action="security_list.jsp">
        <tr>
            <td height="34"> &nbsp;
                <select name="searchField" SelectValue="<%=searchField%>">
                    <option value="name" selected>名称</option>
                    <option value="value">代码</option>
                </select>
                ：
                <input size="40" name="searchValue" value="<%=searchField.equals("id")?"":searchValue%>">
                <input type="checkbox" value="-1" name="state" <%=state==-1?"checked":""%>>
                显示已删除权限
            </td>
            <td width="6%"><input type=button class="btn" onClick="doSearch()" border="0" name="search" value="搜索"></td>
        </tr>
    </form>
</table>
<br>
<table width="95%" border="0" align=center cellpadding=0 cellspacing=1 class="listTree"
       FilesDir="../htc" startcol="1" expancelevel="1">
    <tbody>
    <tr class="title">
        <td width="5%" height="24">选择</td>
        <td width="34%">权限名称</td>
        <td width="24%">权限代码</td>
        <td width="14%">类型</td>
        <td width="14%">顺序种子</td>
        <td width="9%">有效</td>
    </tr>
    <%
        while (it.hasNext()) {
            BaseSecurity baseSecurity = (BaseSecurity) it.next();
            String isShow = "false";
            if (!search.equals("") && !searchValue.equals("")) {
                if (searchField.equals("id") && baseSecurity.getId() == Convert.toLong(searchValue)) isShow = "true";
                else if (searchField.equals("name") && baseSecurity.getName().indexOf(searchValue) != -1)
                    isShow = "true";
                else if (searchField.equals("value") && baseSecurity.getValue().indexOf(searchValue) != -1)
                    isShow = "true";
            }
    %>
    <tr level="<%=baseSecurity.getLevel()%>" isLeaf="<%=baseSecurity.isLeaf()%>" html="<%=baseSecurity.getLevelHtml()%>"
        isShow="<%=isShow%>">
        <td align="center"><input name="idArray" type="checkbox" value="<%=baseSecurity.getId()%>"></td>
        <td align="left">&nbsp;<%=baseSecurity.getName()%>
        </td>
        <td align="left">&nbsp;<%=baseSecurity.getValue()%>
        </td>
        <td><%=baseSecurity.getType() == 1 ? "模块" : "权限"%>
        </td>
        <td align="left">&nbsp;<%=baseSecurity.getSequ()%>
        </td>
        <td><%=baseSecurity.getState() == 1 ? "√" : "×"%>
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
    //删除--恢复选中记录
    function doDelete(state) {
        if (deleteData(document.getElementsByName('idArray'), 'securityAction.do?action=updateState&state=' + state))
            document.location.reload();
    }


    //响应搜索按钮
    function doSearch() {
        $("#searchForm").submit();
    }
</script>