<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.home.entity.Comment" %>
<%
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<LINK  href="../style/default.css" rel=stylesheet>
	<link rel="stylesheet" href="../htc/default.jss" type="text/css">
	<title><%=Config.SystemName%></title>
</head>
<body>
	<form id="dataForm" name="dataForm" method="post" action="commentAction.do?action=addData" Check="true" Change="true">
	<table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
		<tr class="title">
			<td colspan="4"><b>评论新增</b></td>
		</tr>
		<tr>
			<td width="15%"  align="right">文章ID</td>
			<td><input name="articleId" type="text" size="30" DataType="int" validType="maxLength[18]" class="easyui-textbox easyui-validatebox"></td>
			<td width="15%"  align="right">内容</td>
			<td><input name="content" type="text" size="30" maxByte="3200"></td>
		</tr>
		<tr>
			<td width="15%"  align="right">状态</td>
			<td><input name="state" type="text" size="30" DataType="int" validType="maxLength[1]" class="easyui-textbox easyui-validatebox"></td>
			<td width="15%"  align="right">来源IP</td>
			<td><input name="ip" type="text" size="30" validType="maxLength[12]" class="easyui-textbox easyui-validatebox"></td>
		</tr>
		<tr>
			<td width="15%"  align="right">创建人</td>
			<td><input name="creator" type="text" size="30" DataType="int" validType="maxLength[18]" class="easyui-textbox easyui-validatebox"></td>
			<td width="15%"  align="right">创建时间</td>
			<td><input name="createTime" type="text" size="30" DataType="date" validType="maxLength[6]" class="easyui-textbox easyui-validatebox"></td>
		</tr>
		<tr>
			<td width="15%"  align="right">修改人</td>
			<td><input name="modifyUser" type="text" size="30" DataType="int" validType="maxLength[18]" class="easyui-textbox easyui-validatebox"></td>
			<td width="15%"  align="right">修改时间</td>
			<td><input name="modifyTime" type="text" size="30" DataType="date" validType="maxLength[6]" class="easyui-textbox easyui-validatebox"></td>
		</tr>
	</table>
	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="29" align="center">
				
				<input type="submit" class="btn" border="0" name="sure" value="确定" >
				<input type="button" class="btn" border="0" name="return" value="返回" onclick="history.back(-1);">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
