<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="/include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseDepartment" %>
<%
    int state = req.getInt("state") == -1 ? -1 : 1;
    String searchField = req.getString("searchField");
    String searchValue = req.getString("searchValue");
    String search = req.getString("search");
    Iterator it = new BaseDepartment().findAllNode(state).iterator();
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
<% if (user.checkFunction("DEPARTMENT", "ADMIN")) {%>
<table border="0" cellpadding="0" cellspacing="0" width="95%" align="center">
    <tr>
        <td width="100%">
            <table width="100%" cellspacing="0" cellpadding="0">
                <tr>
                    <td colspan="2" height="10"></td>
                </tr>
                <tr>
                    <td width="68%"><input type=button class="btn" onClick="location.href='department_add.jsp';"
                                           border="0" name="add" value="新建">
                        <input type=button class="btn"
                               onClick="editData(document.getElementsByName('idArray'),'department_edit.jsp?id=')"
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
<%}%>
<table class="query_table" cellspacing=0 cellpadding=0 width="95%" align=center border=0>
    <form id="searchForm" name="searchForm" method="post" action="department_list.jsp">
        <tr>
            <td height="34"> &nbsp;
                <select name="searchField" SelectValue="<%=searchField%>">
                    <option value="name" selected>名称</option>
                    <option value="fullName">部门全称</option>
                    <option value="code">机构代码</option>
                </select>
                ：
                <input size="40" name="searchValue" value="<%=searchField.equals("id")?"":searchValue%>">
                <input type="checkbox" value="-1" name="state" <%=state==-1?"checked":""%>>
                显示已删除部门
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
        <td width="4%" height="24">选择</td>
        <td width="22%">部门名称</td>
        <td width="27%">部门全称</td>
        <td width="12%">部门负责人</td>
        <td width="11%">机构代码</td>
        <td width="13%" align="center">部门级别</td>
        <td width="11%" align="center">机构属性</td>
    </tr>
    <%
        while (it.hasNext()) {
            BaseDepartment baseDepartment = (BaseDepartment) it.next();
            String isShow = "";
            if (!search.equals("") && !searchValue.equals("")) {
                if (searchField.equals("id") && baseDepartment.getId() == Convert.toLong(searchValue)) isShow = "true";
                else if (searchField.equals("name") && baseDepartment.getName().indexOf(searchValue) != -1)
                    isShow = "true";
                else if (searchField.equals("fullName") && baseDepartment.getFullName().indexOf(searchValue) != -1)
                    isShow = "true";
                else if (searchField.equals("code") && baseDepartment.getCode().indexOf(searchValue) != -1)
                    isShow = "true";
            }
    %>
    <tr level="<%=baseDepartment.getLevel()%>" isLeaf="<%=baseDepartment.isLeaf()%>"
        html="<%=baseDepartment.getLevelHtml()%>" isShow="<%=isShow%>">
        <td align="center"><input name="idArray" type="checkbox" value="<%=baseDepartment.getId()%>"></td>
        <td align="left">&nbsp;<a
                href="department_view.jsp?id=<%=baseDepartment.getId()%>"><%=baseDepartment.getName()%>
        </a></td>
        <td align="left"><%=baseDepartment.getFullName()%>
        </td>
        <td><%=baseDepartment.getLeaderName()%>
        </td>
        <td align="center"><%=baseDepartment.getCode()%>
        </td>
        <td align="center"><%=TypeApp.getName(baseDepartment.getMainLevel())%>
        </td>
        <td align="center"><%=TypeApp.getName(baseDepartment.getProperty())%>
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
        if (setupData(document.getElementsByName('idArray'), 'departmentAction.do?action=updateState&state=' + state))
            document.location.reload();
    }


    //响应搜索按钮
    function doSearch() {
        $("#searchForm").submit();
    }
</script>