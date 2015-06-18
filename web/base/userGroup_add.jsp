<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%
	int type=req.getInt("type");
	String name=type==1?"职务":"角色";
%>
<table id="Table<%=type%>" class="subList" cellspacing=1 cellpadding=0 width="100%" align=center  border=0 >
  <tbody>  
  <tr class="title" > 
    <td  width="9%" height="19" align="center"> <div align="center">操作</div></td>
    <td width="50%" ><div align="center">部门</div></td>
    <td width="28%"><div align="center"><%=name%></div></td>
    <td width="13%" align="center">排序</td>
  </tr>
  <tr class="odd"> 
      <td width="9%"  align="center"><img src="../images/edit.gif" style="cursor:hand" onclick="doSelect<%=type%>()"> 
        <input type="hidden" name="departmentIds" value="">
        <input type="hidden" name="groupIds" value="">
		<input type="hidden" name="sequs" value="">
        <input type="hidden" name="types" value="0"></td>
      <td >&nbsp; </td>
      <td >&nbsp; </td>
      <td >&nbsp; </td>
  </tr></tbody>
</table>

<script language="javascript">
function doSelect<%=type%>()
{
	openCenter('userGroup_select.jsp?type=<%=type%>','',210,700);
}

//增加文件
function addRow<%=type%>(depName,depId,groupName,groupId,sequ)
{
	var sHTML="<img src='../images/delete.gif' style='cursor:hand' onclick='delete<%=type%>(this)'>";
	sHTML+="<input type='hidden' name='departmentIds' value='" + depId + "'>";
	sHTML+="<input type='hidden' name='groupIds' value='" + groupId + "'>";
	sHTML+="<input type='hidden' name='sequs' value='" + sequ + "'>";
	sHTML+="<input type='hidden' name='types' value='<%=type%>'>";
	var table=document.all("Table<%=type%>");
	var i=table.rows.length;
	var tr=table.insertRow(i-1);
	tr.className="odd";
	var td=tr.insertCell(0);	
	td.align="center";
	td.innerHTML=sHTML;
	td=tr.insertCell(1);
	td.innerHTML=depName;
	td=tr.insertCell(2);	
	td.innerHTML=groupName;
	td=tr.insertCell(3);	
	td.innerHTML=sequ;	
}


//删除文件
function delete<%=type%>(obj)
{
	var table=document.all("Table<%=type%>");	
	table.deleteRow(obj.parentNode.parentNode.rowIndex);	
}

</script>