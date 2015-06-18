<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseParameter" %>
<%
	long id = req.getLong("id");
	BaseParameter baseParameter = (BaseParameter)new BaseParameter().findById(id);	
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<link rel="stylesheet" href="../htc/default.jss" type="text/css">
<title><%=Config.SystemName%></title>
</head>
<body>
     <form method="POST" action="parameterAction.do?action=updateData"  name="dataFrom" Check="true" Change="true">
  <table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
    <tbody>
      <tr class="title"> 
        <td colspan=4 height=8><b>属性信息</b></td>
      </tr>
      <tr > 
        <td width="16%"  align=right>名称：</td>
        <td colspan="3" ><input name="name" type="text" value="<%=baseParameter.getName()%>" size="43" required="true" validType="maxLength[40]" class="easyui-textbox easyui-validatebox">
          <input type="hidden" name="id" value="<%=baseParameter.getId()%>" /> 
        </td>
      </tr>
      <tr > 
        <td  align=right>代码：</td>
        <td colspan="3"> <input name="code" type="text" value="<%=baseParameter.getCode()%>"  readonly="readonly" size="43" required="true" validType="maxLength[20]" class="easyui-textbox easyui-validatebox">
        </td>
      </tr>
      <tr > 
        <td height="20"  align=right>类型：</td>
        <td width="27%"> <%=TypeApp.createSelect("type","PARAMETER_TYPE",baseParameter.getType())%> 
        </td>
        <td width="13%" align="right">单位：</td>
        <td width="44%"> <input name="unit" type="text" size="18" value="<%=baseParameter.getUnit()%>" validType="maxLength[30]" class="easyui-textbox easyui-validatebox"></td>
      </tr>
      <tr > 
        <td height="20"  align=right>权限设置：</td>
        <td colspan="3"><input name="userNames" type="text" size="43" value="<%=baseParameter.getUserNames()%>" readonly="readonly"> 
          <input type="hidden" name="userIds" value="<%=baseParameter.getUserIds()%>" /> 
          <img src="../images/find.gif" width="18" height="19" style="cursor:hand" onClick="selectUser('userNames','userIds')"> 
        </td>
      </tr>
      <tr > 
        <td height="20"  align=right>说明：</td>
        <td colspan="3"><input name="explain" type="text" value="<%=baseParameter.getExplain()%>" size="43" validType="maxLength[500]" class="easyui-textbox easyui-validatebox"></td>
      </tr>
    </tbody>
  </table>
  <br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="29" align="center">
      <input type="submit" class="btn"  border="0" name="sure" value="确定" >
        <input type=button class="btn"    border="0" name="cancel" value="取消" onclick="self.close();"> 
      </td>
  </tr>
</table>
 </form>
</body>
</html>
<script language="JavaScript">
function selectUser(userNameObj,userIdObj)
{
   selectUser("manyUser_select.jsp",295,480,userNameObj,userIdObj);
}
</script>
