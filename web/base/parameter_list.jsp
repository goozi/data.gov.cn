<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseParameter" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script> 	<script type="text/javascript" src="../js/body.js"></script> 	<script type="text/javascript" src="../js/table.js"></script>
<title><%=Config.SystemName%></title>
<%
	int currPage=req.getInt("currPage")==0?1:req.getInt("currPage");
	int pageSize=15;    
    String searchField=req.getString("searchField");
	String searchValue=req.getString("searchValue");
    String pageUrl=req.getPageUrl();
	BaseParameter oBaseParameter=new BaseParameter();
    Iterator it=null;
    if (req.getString("search").equals(""))
	{
        it=oBaseParameter.findPageByUser(user,currPage,pageSize).iterator();       
	}
	else
	{
	    it=oBaseParameter.search(searchField,searchValue,user,currPage,pageSize).iterator();       
    }
    Page oPage=oBaseParameter.getPage();
%>
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" width="95%" align="center">
  <tr>
    <td width="100%">
      <table width="100%" cellspacing="0" cellpadding="0">
        <tr>
          <td colspan="2" height="10"> </td>
        </tr>
        <tr>
          <td width="68%">
<% if (user.checkFunction("PARAMETER","ADMIN")) {%>
              <input type=button class="btn"  onClick="openCenter('parameter_add.jsp','',250,500);"  border="0" name="add" value="新建" >
            <input type=button class="btn"  onClick="editData(document.getElementsByName('idArray'),'parameter_edit.jsp?id=',250,500);"  border="0" name="edit" value="编辑" >
<% }%>
		    <input type=button class="btn"  onClick="editData(document.getElementsByName('idArray'),'parameter_setup.jsp?id=',250,500);"  border="0" name="setup" value="设置参数值" >
          </td>
          <td width="31%" height="30" align="right" >&nbsp; </td>
        </tr>
      </table>
   </td>
  </tr>
</table>
<table class="query_table" border="0" cellpadding="0" cellspacing="0" align="center" width="95%">
<form id="searchForm" name="searchForm" method="post" action="parameter_list.jsp">
  <tr>
    <td width="11%" height="34" > &nbsp;&nbsp; <select name="searchField" SelectValue="<%=searchField%>">
        <option value="name">参数名称</option>
        <option value="code">参数代码</option>
      </select></td>
    <td width="39%" ><input name="searchValue" type="text" class="TextInput" value="<%=searchValue%>" size="40" ></td>
    <td width="43%" >&nbsp;</td>
    <td width="7%" ><input type="button" class="btn"  onClick="doSearch()"  border="0" name="search" value="搜索" ></td>
  </tr>
 </form>
</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td align="right"></td>
  </tr>
</table>
<table class="list" style="behavior:url(../htc/table.htc)" FixRow="15" cellspacing=1 cellpadding=0 width="95%" align=center  border=0 >
  <tbody>
    <tr class="title"   >
      <td  width="4%">选择</td>
      <td  width="47%" >名称</td>
      <td  width="20%">代码</td>
      <td  height=24>值</td>
      <td>单位</td>
    </tr>
    <%
        while(it.hasNext()){
            BaseParameter baseParameter=(BaseParameter)it.next();
        %>
    <tr class="odd">
      <td width="4%" > <input name="idArray" type="checkbox" value="<%=baseParameter.getId()%>"></td>
      <td width="47%" align="left"><%=baseParameter.getName()%></td>
      <td width="20%" align="left"><%=baseParameter.getCode()%></td>
      <td width="20%" align="left"><%=baseParameter.getValue()%></td>
      <td width="9%" align="left" nowrap="nowrap"><%=baseParameter.getUnit()%></td>
      <input type="hidden" name="type" value="<%=baseParameter.getType()%>" />
    </tr>
    <%}%>
  </tbody>
</table>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td width="50%" height="33" align="left"><%=oPage.getInfo()%></td>
    <td width="50%" align="right"><%=oPage.getButton(pageUrl)%></td>
  </tr>
</table>
</body>
</html>
<script language="javascript">
//响应搜索按钮
function doSearch()
{
	$("#searchForm").submit();
}
</script>