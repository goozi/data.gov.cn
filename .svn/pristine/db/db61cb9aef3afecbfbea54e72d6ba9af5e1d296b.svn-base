<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.app.entity.App" %>
<%
	long id=req.getLong("id");
	App app = (App) new App().findById(id);
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<LINK  href="../style/default.css" rel=stylesheet>
	<link rel="stylesheet" href="../htc/default.jss" type="text/css">
	<title><%=Config.SystemName%></title>
</head>
<body>
	<form id="dataForm" name="dataForm" method="post" action="appAction.do?action=addData" Check="true" Change="true">
	<table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
		<tr class="title">
			<td colspan="4"><b>应用查看</b></td>
		</tr>
		<tr>
			<td width="15%"  align="right">英文名</td>
			<td><%=app.getName()%></td>
			<td width="15%"  align="right">中文名</td>
			<td><%=app.getCnName()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">描述</td>
			<td><%=app.getDescription()%></td>
			<td width="15%"  align="right">URL</td>
			<td><%=app.getUrl()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">开发人</td>
			<td><%=app.getDeveloper()%></td>
			<td width="15%"  align="right">提交人ID</td>
			<td><%=app.getSubmitterId()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">应用图标</td>
			<td><%=app.getAppThumbnail()%></td>
			<td width="15%"  align="right">应用截图</td>
			<td><%=app.getAppPic()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">应用收费类型</td>
			<td><%=app.getAppCharge()%></td>
			<td width="15%"  align="right">类别</td>
			<td><%=app.getCategory()%></td>
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
