<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<link rel="stylesheet" href="../htc/default.jss" type="text/css">
<title><%=Config.SystemName%></title>
</head>
<body >
<form id="dataForm" name="dataForm" action="menuAction.do?action=addData" method="POST" Check="true" Change="true">
  <table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
    <tbody>
      <tr class="title"> 
        <td colspan=4 height=8><b>菜单信息</b></td>
      </tr>
      <tr > 
        <td width="13%"  align=right>名称：</td>
        <td width="40%" ><input name="name" type="text" size="35" required="true" validType="maxLength[50]" class="easyui-textbox easyui-validatebox">
        </td>
        <td width="9%" align="right" >所属上级：</td>
        <td width="38%" ><%=TreeApp.createSelfSelect("parentId","Menu")%></td>
      </tr>
      <tr > 
        <td  align=right>网址：</td>
        <td> <input name="value" type="text" size="35" validType="maxLength[90]" class="easyui-textbox easyui-validatebox"></td>
        <td align="right">目标：</td>
        <td><input name="target" type="text" size="35"  validType="maxLength[20]" class="easyui-textbox easyui-validatebox"></td>
      </tr>
      <tr > 
        <td  align=right>图标：</td>
        <td><input name="meno" type="text" size="35" validType="maxLength[40]" class="easyui-textbox easyui-validatebox"></td>
        <td align="right">顺序种子：</td>
        <td><input name="sequ" type="text"  size="35" validType="maxLength[6]" class="easyui-textbox easyui-validatebox" datatype="+int"></td>
      </tr>
      <tr > 
        <td  align=right>权限对象：</td>
        <td><input id="securityName" name="securityName" type="text" size="35" readonly="readonly"> 
          <input type="hidden" id="securityId" name="securityId" > <img src="../images/find.gif" style="cursor:hand" width="18" height="19" onClick="selectSecurity()"></td>
        <td align="right">说明：</td>
        <td><input name="explain" type="text" value="" size="35" validType="maxLength[500]" class="easyui-textbox easyui-validatebox"></td>
      </tr>
    </tbody>
  </table>
<br>
  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr> 
      <td height="29" align="center"> <input type=submit class="btn"   border="0" name="sure" value="确定" > 
        <input type=button class="btn"    border="0" name="return" value="返回" onclick="history.back(-1);"> 
      </td>
    </tr>
  </table>
</form>
</body>
</html>
<script>
function selectSecurity()
{
	openCenter("security_select.jsp","",480,500);
}
function writeValue(id,name)
{
	$("#securityName").val(name);
	$("#securityId").val(id);
}
</script>
