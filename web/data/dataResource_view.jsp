<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.data.entity.DataResource" %>
<%
    long id = req.getLong("id");
    DataResource dataResource = (DataResource) new DataResource().findById(id);
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <LINK href="../style/default.css" rel=stylesheet>
    <link rel="stylesheet" href="../htc/default.jss" type="text/css">
    <title><%=Config.SystemName%>
    </title>
</head>
<body>
<form id="dataForm" name="dataForm" method="post" action="dataResourceAction.do?action=addData" Check="true"
      Change="true">
    <table class="edit" cellspacing=1 cellpadding=3 width="95%" align=center border=0>
        <tr class="title">
            <td colspan="4"><b>数据资源查看</b></td>
        </tr>
        <tr>
            <td width="15%" align="right">名称</td>
            <td><%=dataResource.getName()%>
            </td>
            <td width="15%" align="right">标题</td>
            <td><%=dataResource.getTitle()%>
            </td>
        </tr>
        <tr>
            <td width="15%" height="250" align="right">描述</td>
            <td colspan="3"><%=dataResource.getDescription()%>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">资源类型</td>
            <td colspan="3"><%=dataResource.getResType()%>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">来源URL</td>
            <td><%=dataResource.getSourceUrl()%>
            </td>
            <td width="15%" align="right">版本</td>
            <td><%=dataResource.getVersion()%>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">创建人</td>
            <td><%=dataResource.getCreator()%>
            </td>
            <td width="15%" align="right">创建时间</td>
            <td><%=dataResource.getCreateDate()%>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">修改人</td>
            <td><%=dataResource.getModifyUser()%>
            </td>
            <td width="15%" align="right">修改时间</td>
            <td><%=dataResource.getModifyDate()%>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">下载数</td>
            <td><%=dataResource.getDownloadNum()%>
            </td>
            <td width="15%" align="right">文件ID</td>
            <td><%=dataResource.getFileId()%>
            </td>
        </tr>
        <tr>
            <td width="15%" align="right">数据集ID</td>
            <td><%=dataResource.getDatasetId()%>
            </td>
            <td></td>
            <td></td>
        </tr>
    </table>
    <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
            <td height="29" align="center">
                <input type="button" class="btn" border="0" name="return" value="返回" onclick="history.back(-1);">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
