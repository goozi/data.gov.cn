<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.data.entity.Dataset" %>
<%@ page import="com.dhccity.data.entity.Org" %>
<%@ page import="com.dhccity.data.entity.DataGroup" %>
<%
	long id=req.getLong("id");
	Dataset dataset = (Dataset) new Dataset().findById(id);
	Org org = (Org) new Org().findById(dataset.getOrgId());
	DataGroup dataGroup = (DataGroup) new DataGroup().findById(dataset.getGroupId());
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<LINK  href="../style/default.css" rel=stylesheet>
	<link rel="stylesheet" href="../htc/default.jss" type="text/css">
	<title><%=Config.SystemName%></title>
</head>
<body>
	<form id="dataForm" name="dataForm" method="post" action="datasetAction.do?action=addData" Check="true" Change="true">
	<table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
		<tr class="title">
			<td colspan="4"><b>数据集查看</b></td>
		</tr>
		<tr>
			<td width="15%"  align="right">名称</td>
			<td><%=dataset.getName()%></td>
			<td width="15%"  align="right">标题</td>
			<td><%=dataset.getTitle()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">描述</td>
			<td colspan="3" height="250"><%=dataset.getDescription()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">状态</td>
			<td><%=TypeApp.getName("STATE", dataset.getState())%></td>
			<td width="15%"  align="right">是否公开</td>
			<td><%=TypeApp.getName("IS_PUBLIC", dataset.getIsPublic())%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">创建人</td>
			<td><%=dataset.getCreator()%></td>
			<td width="15%"  align="right">创建时间</td>
			<td><%=dataset.getCreateTime()%></td>
		</tr>
		<tr>

			<td width="15%"  align="right">修改人</td>
			<td><%=dataset.getModifyUser()%></td>
			<td width="15%"  align="right">修改时间</td>
			<td><%=dataset.getModifyTime()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">更新频率</td>
			<td colspan="3"><%=TypeApp.getName("UPDATE_RATE", dataset.getUpdateRate())%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">下载数</td>
			<td><%=dataset.getDownloadNum()%></td>
			<td width="15%"  align="right">查看数</td>
			<td><%=dataset.getReadNum()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">所属机构</td>
			<td><%=org==null?"":org.getTitle()%></td>
			<td width="15%"  align="right">所属专题</td>
			<td><%=dataGroup==null?"":dataGroup.getTitle()%></td>
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
