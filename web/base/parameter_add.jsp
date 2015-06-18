<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<link rel="stylesheet" href="../htc/default.jss" type="text/css">
<STYLE>
	 kingtop\:date {behavior: url(../htc/date.htc);}
</STYLE>

<title><%=Config.SystemName%></title>
</head>
<body>
    <form method="POST" action="parameterAction.do?action=addData"  name="dataFrom" Check="true" Change="true">

<table class="edit"  cellspacing=1 cellpadding=3
            width="95%" align=center border=0>
  <tbody>
    <tr class="title">
        <td colspan=4 height=8><b>属性信息</b></td>
    </tr>
    <tr >
      <td width="16%"  align=right>名称：</td>
      <td colspan="3" ><input id="name" name="name" type="text" size="43" validType="maxLength[40]" class="easyui-textbox easyui-validatebox" required="true" >
      </td>
    </tr>
    <tr >
      <td  align=right>代码：</td>
      <td colspan="3"> <input name="code" type="text" size="43" required="true" validType="maxLength[20]" class="easyui-textbox easyui-validatebox">
      </td>
    </tr>
    <tr >
      <td height="20"  align=right>类型：</td>
      <td width="26%"><%=TypeApp.createSelect("type","PARAMETER_TYPE",TypeApp.VALUE)%></td>
      <td width="11%" align="right">单位：</td>
      <td width="47%"><input name="unit" type="text" size="20" validType="maxLength[30]" class="easyui-textbox easyui-validatebox"></td>
    </tr>
    <tr >
      <td height="20"  align=right>权限设置：</td>
      <td colspan="3"><input name="userNames" type="text" size="43" readonly="readonly"> <input type="hidden" name="userIds" />
        <img src="../images/find.gif" width="18" style="cursor:hand" height="19" onClick="selectUser('userNames','userIds')">
      </td>
    </tr>
    <tr >
      <td height="20"  align=right>说明：</td>
      <td colspan="3"><input name="explain" type="text" value="" size="43" validType="maxLength[500]" class="easyui-textbox easyui-validatebox"></td>
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
