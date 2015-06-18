<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.app.entity.AppDatasetRelation" %>
<%
	long id=req.getLong("id");
	AppDatasetRelation appDatasetRelation = (AppDatasetRelation) new AppDatasetRelation().findById(id);
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<LINK  href="../style/default.css" rel=stylesheet>
	<link rel="stylesheet" href="../htc/default.jss" type="text/css">
	<title><%=Config.SystemName%></title>
</head>
<body>
	<form id="dataForm" name="dataForm" method="post" action="appRelAction.do?action=addData" Check="true" Change="true">
	<table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
		<tr class="title">
			<td colspan="4"><b>应用关系查看</b></td>
		</tr>
		<tr>
			<td width="15%"  align="right">应用ID</td>
			<td><%=appDatasetRelation.getAppId()%></td>
			<td width="15%"  align="right">数据集ID</td>
			<td><%=appDatasetRelation.getDatasetId()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">创建时间</td>
			<td><%=appDatasetRelation.getCreateTime()%></td>
		<td></td><td></td></tr>
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
