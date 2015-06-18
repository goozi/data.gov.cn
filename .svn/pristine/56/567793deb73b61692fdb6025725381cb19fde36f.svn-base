<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.home.entity.Article" %>
<%
	int currPage=req.getInt("currPage")==0?1:req.getInt("currPage");
	int pageSize=parameter.pageSize;
	String pageUrl=req.getPageUrl();
	Article oArticle=new Article();
	Iterator it=oArticle.findPage(currPage,pageSize).iterator();
	Page oPage=oArticle.getPage();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<LINK  href="../style/default.css" rel=stylesheet>
	<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../js/body.js"></script>
<script type="text/javascript" src="../js/table.js"></script>
	<title><%=Config.SystemName%></title>
</head>
<body>
	<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td height="30">
				<input type="button" name="add" value="新建" class="btn"  onClick="location.href='carousel_add.jsp';" >
				<input type="button" name="edit" value="编辑" class="btn"  onClick="editData(document.getElementsByName('idArray'),'carousel_edit.jsp?id=')"  >
				<input type="button" name="delete" value="删除" class="btn"  onClick="doDelete();">
				<input type="button" name="selectAll" value="全选" class="btn" onClick="selectAll(document.getElementsByName('idArray'))">
				<input type="button" name="inverse" value="反选" class="btn" onClick="inverse(document.getElementsByName('idArray'))" > 
			</td>
		</tr>
	</table>
	<br>
	<table class="list" FixRow="<%=pageSize%>" cellspacing=1 cellpadding=0 width="95%" align=center  border=0 >
		<tr class="title">
			<td>选择</td>
			<td DataType="NUMBER">ID</td>
			<td >标题</td>
			<td DataType="NUMBER">发表用户</td>
			<td DataType="NUMBER">状态</td>
			<td DataType="NUMBER">是否发布</td>
			<td DataType="DATE">创建时间</td>
		</tr>
<%
	while (it.hasNext())
	{
		Article article = (Article) it.next();
%>
		<tr>
			<td ><input name="idArray" type="checkbox" value="<%=article.getId()%>"></td>
			<td><a href="carousel_view.jsp?id=<%=article.getId()%>"><%=article.getId()%></a></td>
			<td><%=article.getTitle()%></td>
			<td><%=article.getCreator()%></td>
			<td><%=article.getState()%></td>
			<td><%=article.getIsPublic()%></td>
			<td><%=article.getCreateTime()%></td>
		</tr>
<%
	}
%>
	</table>
	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" >
		<tr>
			<td width="50%" height="33" align="left"><%=oPage.getInfo()%></td>
			<td width="50%" align="right"><%=oPage.getButton(pageUrl)%></td>
		</tr>
	</table>
</body>
</html>
<script language="javascript">
//删除--恢复选中记录
function doDelete()
{
	if (setupData(document.getElementsByName('idArray'),'carouselAction.do?action=deleteData'))
	document.location.reload();
}
</script>
