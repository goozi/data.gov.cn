<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.home.entity.Comment" %>
<%
	int currPage=req.getInt("currPage")==0?1:req.getInt("currPage");
	int pageSize=parameter.pageSize;
	String pageUrl=req.getPageUrl();
	String searchField=req.getString("searchField");
	String searchValue=req.getString("searchValue");
	Comment oComment=new Comment();
	Iterator it=null;
	if (req.getString("search").equals(""))
		it=oComment.findPage(currPage,pageSize).iterator();
	else
		;//it=oComment.search(searchField,searchValue,currPage,pageSize).iterator();
	Page oPage=oComment.getPage();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<LINK  href="../style/default.css" rel=stylesheet>
	<script type="text/javascript" src="../js/jquery-1.11.3.js"></script> 	<script type="text/javascript" src="../js/body.js"></script> 	<script type="text/javascript" src="../js/table.js"></script>
	<title><%=Config.SystemName%></title>
</head>
<body>
	<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td height="30">
				<input type="button" name="add" value="新建" class="btn"  onClick="location.href='comment_add.jsp';" >
				<input type="button" name="edit" value="编辑" class="btn"  onClick="editData(document.getElementsByName('idArray'),'comment_edit.jsp?id=')"  >
				<input type="button" name="delete" value="删除" class="btn"  onClick="doDelete();">
				<input type="button" name="selectAll" value="全选" class="btn" onClick="selectAll(document.getElementsByName('idArray'))">
				<input type="button" name="inverse" value="反选" class="btn" onClick="inverse(document.getElementsByName('idArray'))" >
			</td>
		</tr>
	</table>
	<table class="query_table" cellspacing="0" cellpadding="0" width="95%" align="center"  border="0">
	<form id="searchForm" name="searchForm" method="post" action="user_list.jsp">
		<tr>
			<td height="34">
				<select name="searchField" SelectValue="<%=searchField%>">
					<option value="state">状态</option>
					<option value="creator">创建人</option>
					<option value="createTime">创建时间</option>
				</select>：
				<input size="20" name="searchValue" value="<%=searchValue%>">
			</td>
			<td width="6%" >
				<input type=button class="btn"  onClick="doSearch()"  border="0" name="search" value="搜索" >
			</td>
		</tr>
	</form>
	</table>
	<br>
	<table class="list"  style="behavior:url(../htc/table.htc)" FixRow="<%=pageSize%>" cellspacing=1 cellpadding=0 width="95%" align=center  border=0 >
		<tr class="title">
			<td>选择</td>
			<td DataType="NUMBER">ID</td>
			<td DataType="NUMBER">文章ID</td>
			<td >内容</td>
			<td DataType="NUMBER">状态</td>
			<td >来源IP</td>
			<td DataType="NUMBER">创建人</td>
			<td DataType="DATE">创建时间</td>
			<td DataType="NUMBER">修改人</td>
			<td DataType="DATE">修改时间</td>
		</tr>
<%
	while (it.hasNext())
	{
		Comment comment = (Comment) it.next();
%>
		<tr>
			<td ><input name="idArray" type="checkbox" value="<%=comment.getId()%>"></td>
			<td><a href="comment_view.jsp?id=<%=comment.getId()%>"><%=comment.getId()%></a></td>
			<td><%=comment.getArticleId()%></td>
			<td><%=comment.getContent()%></td>
			<td><%=comment.getState()%></td>
			<td><%=comment.getIp()%></td>
			<td><%=comment.getCreator()%></td>
			<td><%=comment.getCreateTime()%></td>
			<td><%=comment.getModifyUser()%></td>
			<td><%=comment.getModifyTime()%></td>
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
	if (setupData(document.getElementsByName('idArray'),'commentAction.do?action=deleteData'))
	document.location.reload();
}
//响应搜索按钮
function doSearch()
{
	$("#searchForm").submit();
}
</script>
