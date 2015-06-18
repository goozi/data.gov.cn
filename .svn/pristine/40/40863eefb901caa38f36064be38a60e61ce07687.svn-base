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
<title><%=Config.SystemName%></title></head>
<body>
<form method="POST" action="parameterAction.do?action=setupValue"  name="dataForm" Check="true" Change="true">
  <br>
  <br>
  <table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
    <tbody>
      <tr class="title"> 
        <td colspan=4 height=8><b><%=baseParameter.getName()%>信息 
          <input type="hidden" name="id" value="<%=id%>">
          </b></td>
      </tr>
      <tr > 
        <td width="16%"  align=right>值：</td>
        <td width="84%" colspan="3" > <input name="value" type="text" value="<%=baseParameter.getValue()%>" size="30" required="true" <%=baseParameter.getType().equals("")?"":"DataType='" + baseParameter.getType() +"'"%>>
          [<%=baseParameter.getUnit()%>]&nbsp;类型：[<%=TypeApp.getName("PARAMETER_TYPE",baseParameter.getType())%>]</td>
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
