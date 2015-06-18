<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.data.entity.Dataset" %>
<%@ page import="com.dhccity.base.entity.BaseUser" %>
<%
	int currPage=req.getInt("currPage")==0?1:req.getInt("currPage");
	int pageSize=parameter.pageSize;
	String pageUrl=req.getPageUrl();
	Dataset oDataset=new Dataset();
	Iterator it=oDataset.search(0,0,"api",0,"","",currPage,pageSize).iterator();
	Page oPage=oDataset.getPage();
	BaseUser oBaseUser = new BaseUser() ;

%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<LINK  href="../style/default.css" rel=stylesheet>
	<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="../js/body.js"></script>
	<script type="text/javascript" src="../js/table.js"></script>
	<%@ include file="../easyui_include.jsp"%>
	<title><%=Config.SystemName%></title>
</head>
<body>
	<table width="95%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="10"></td>
		</tr>
		<tr>
			<td height="30">
				<input type="button" name="add" value="新建" class="btn"  onClick="location.href='api_add.jsp';" >
				<input type="button" name="edit" value="编辑" class="btn"  onClick="editData(document.getElementsByName('idArray'),'api_edit.jsp?id=')"  >
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
			<td DataType="NUMBER">是否公开</td>
			<td DataType="NUMBER">创建人</td>
			<td DataType="DATE">创建时间</td>
			<td DataType="NUMBER">下载数</td>
			<td DataType="NUMBER">查看数</td>
		</tr>
<%
	while (it.hasNext())
	{
		Dataset dataset = (Dataset) it.next();
		BaseUser baseUser = (BaseUser)oBaseUser.findById(dataset.getCreator());
%>
		<tr>
			<td ><input name="idArray" type="checkbox" value="<%=dataset.getId()%>"></td>
			<td><a href="api_view.jsp?id=<%=dataset.getId()%>"><%=dataset.getId()%></a></td>
			<td><%=dataset.getTitle()%></td>
			<td><%=TypeApp.getName("IS_PUBLIC",dataset.getIsPublic())%></td>
			<td><%=baseUser.getName()%></td>
			<td><%=dataset.getCreateTime()%></td>
			<td><%=dataset.getDownloadNum()%></td>
			<td><%=dataset.getReadNum()%></td>
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
	if (setupData(document.getElementsByName('idArray'),'datasetAction.do?action=deleteData'))
	document.location.reload();
}
</script>
