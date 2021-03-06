<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.home.entity.Article" %>
<%
	long id=req.getLong("id");
	Article article = (Article) new Article().findById(id);
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<LINK  href="../style/default.css" rel=stylesheet>
	<link rel="stylesheet" href="../htc/default.jss" type="text/css">
	<title><%=Config.SystemName%></title>
</head>
<body>
	<form id="dataForm" name="dataForm" method="post" action="carouselAction.do?action=updateData" Check="true" Change="true">
	<table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
		<tr class="title">
			<td colspan="4"><b>首页幻灯片编辑</b></td>
		</tr>
		<tr>
			<td width="15%"  align="right">标题</td>
			<td><input name="title" type="text" size="30" value="<%=article.getTitle()%>" validType="maxLength[160]" class="easyui-textbox easyui-validatebox"></td>
			<td width="15%"  align="right">内容</td>
			<td><input name="content" type="text" size="30" value="<%=article.getContent()%>" maxByte="3200"></td>
		</tr>
		<tr>
			<td width="15%"  align="right">文章类型</td>
			<td><input name="type" type="text" size="30" DataType="int" value="<%=article.getType()%>" validType="maxLength[18]" class="easyui-textbox easyui-validatebox"></td>
			<td width="15%"  align="right">发表用户</td>
			<td><input name="creator" type="text" size="30" DataType="int" value="<%=article.getCreator()%>" validType="maxLength[18]" class="easyui-textbox easyui-validatebox"></td>
		</tr>
		<tr>
			<td width="15%"  align="right">状态</td>
			<td><input name="state" type="text" size="30" DataType="int" value="<%=article.getState()%>" validType="maxLength[1]" class="easyui-textbox easyui-validatebox"></td>
			<td width="15%"  align="right">是否发布</td>
			<td><input name="isPublic" type="text" size="30" DataType="int" value="<%=article.getIsPublic()%>" validType="maxLength[1]" class="easyui-textbox easyui-validatebox"></td>
		</tr>
		<tr>
			<td width="15%"  align="right">创建时间</td>
			<td><input name="createTime" type="text" size="30" DataType="date" value="<%=article.getCreateTime()%>" validType="maxLength[6]" class="easyui-textbox easyui-validatebox"></td>
			<td width="15%"  align="right">修改用户</td>
			<td><input name="modifyUser" type="text" size="30" DataType="int" value="<%=article.getModifyUser()%>" validType="maxLength[18]" class="easyui-textbox easyui-validatebox"></td>
		</tr>
		<tr>
			<td width="15%"  align="right">修改时间</td>
			<td><input name="modifyTime" type="text" size="30" DataType="date" value="<%=article.getModifyTime()%>" validType="maxLength[6]" class="easyui-textbox easyui-validatebox"></td>
			<td width="15%"  align="right">查看数</td>
			<td><input name="readNum" type="text" size="30" DataType="int" value="<%=article.getReadNum()%>" validType="maxLength[8]" class="easyui-textbox easyui-validatebox"></td>
		</tr>
		<tr>
			<td width="15%"  align="right">来源IP</td>
			<td><input name="ip" type="text" size="30" value="<%=article.getIp()%>" validType="maxLength[15]" class="easyui-textbox easyui-validatebox"></td>
		<td></td><td></td></tr>
	</table>
	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="29" align="center">
				<input name="id" type="hidden" value="<%=article.getId()%>">
				<input type="submit" class="btn" border="0" name="sure" value="确定" >
				<input type="button" class="btn" border="0" name="return" value="返回" onclick="history.back(-1);">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
