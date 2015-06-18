<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseUserGroup" %>
<%
	int type=req.getInt("type");
	long userId=req.getLong("userId");
	String name=type==1?"职务":"角色";
	Iterator it=new BaseUserGroup().findByUserId(userId,type).iterator();
%>
<table id="Table<%=type%>" class="subList" cellspacing=1 cellpadding=0 width="100%" align=center  border=0 >
  <tbody>  
  <tr class="title" > 
    <td  width="9%" height="19" align="center"> <div align="center">序号</div></td>
    <td width="50%" ><div align="center">部门</div></td>
    <td width="28%"><div align="center"><%=name%></div></td>
    <td width="13%" align="center">排序</td>
  </tr>
   <%
	while (it.hasNext())
	{
		int i=1;
		BaseUserGroup baseUserGroup = (BaseUserGroup) it.next();
%>
  <tr class="odd"> 
      <td width="9%"  align="center"><%=i%> </td>
      <td ><%=baseUserGroup.getDepartmentName()%></td>
      <td ><%=baseUserGroup.getGroupName()%></td>
      <td ><%=baseUserGroup.getSequ()%></td>
  </tr>
    <%
	i++;
	}
%>  
  </tbody>
</table>
