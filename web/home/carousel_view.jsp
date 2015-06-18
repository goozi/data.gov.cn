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
	<form id="dataForm" name="dataForm" method="post" action="carouselAction.do?action=addData" Check="true" Change="true">
	<table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
		<tr class="title">
			<td colspan="4"><b>首页幻灯片查看</b></td>
		</tr>
		<tr>
			<td width="15%"  align="right">标题</td>
			<td><%=article.getTitle()%></td>
			<td width="15%"  align="right">内容</td>
			<td><%=article.getContent()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">文章类型</td>
			<td><%=article.getType()%></td>
			<td width="15%"  align="right">发表用户</td>
			<td><%=article.getCreator()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">状态</td>
			<td><%=article.getState()%></td>
			<td width="15%"  align="right">是否发布</td>
			<td><%=article.getIsPublic()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">是否可评论</td>
			<td><%=article.getIsCommentable()%></td>
			<td width="15%"  align="right">是否置顶</td>
			<td><%=article.getIsTop()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">创建时间</td>
			<td><%=article.getCreateTime()%></td>
			<td width="15%"  align="right">修改用户</td>
			<td><%=article.getModifyUser()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">修改时间</td>
			<td><%=article.getModifyTime()%></td>
			<td width="15%"  align="right">查看数</td>
			<td><%=article.getReadNum()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">来源IP</td>
			<td><%=article.getIp()%></td>
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
