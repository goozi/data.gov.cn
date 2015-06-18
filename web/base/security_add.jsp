<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<link rel="stylesheet" href="../htc/default.jss" type="text/css">
<title><%=Config.SystemName%></title>
</head>
<body >
<form id="dataForm" name="dataForm" method="POST" action="securityAction.do?action=addData" Check="true" Change="true">
  <table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
    <tbody>
      <tr class="title"> 
        <td colspan=4 height=8><b>权限管理</b></td>
      </tr>
      <tr > 
        <td height="24"  align=right>权限名称：</td>
        <td width="36%" ><input name="name" type="text" size="35" required="true" validType="maxLength[50]" class="easyui-textbox easyui-validatebox" >
        </td>
        <td width="13%" align="right" >权限代码：</td>
        <td width="40%" ><input name="value" type="text" size="35" required="true" validType="maxLength[50]" class="easyui-textbox easyui-validatebox"></td>
      </tr>
      <tr > 
        <td width="11%"  align=right>权限类型：</td>
        <td ><input type="radio" name="type" value="1">
          模块 &nbsp;&nbsp; <input name="type" type="radio" value="2" checked>
          权限</td>
        <td align="right" >上级模块：</td>
        <td ><%=TreeApp.createSelfSelect("parentId","Security")%></td>
      </tr>
      <tr > 
        <td  align=right>排序号：</td>
        <td><input name="sequ" type="text" size="35" validType="maxLength[6]" class="easyui-textbox easyui-validatebox" DataType="+int"></td>
        <td align="right">管理级别：</td>
        <td><input name="securityLevel" type="radio" value="0" checked>
          普通&nbsp;&nbsp; <input type="radio" name="securityLevel" value="1">
          程序员</td>
      </tr>
      <tr > 
        <td  align=right>说明：</td>
        <td colspan="3"><input name="explain" type="text" value="" size="35" validType="maxLength[500]" class="easyui-textbox easyui-validatebox"></td>
      </tr>
    </tbody>
  </table>
  <br>
  <table id="TableUrl" class="subList" cellspacing=1 cellpadding=0 width="95%" align=center  border=0 >
    <tbody>
      <tr class="title" > 
        <td  width="6%" height="19" align="center"> <div align="center">操作</div></td>
        <td width="46%" ><div align="center">相关网址</div></td>
        <td width="48%"><div align="center">请求参数</div></td>
      </tr>
      <tr class="odd"> 
        <td width="6%"  align="center"><img src="../images/edit.gif" style='cursor:hand' onclick="addRow(this)"> 
        </td>
        <td ><input name="urls" type="text" size="35" validType="maxLength[50]" class="easyui-textbox easyui-validatebox"> </td>
        <td ><input name="querys" type="text" size="35"  validType="maxLength[50]" class="easyui-textbox easyui-validatebox"> </td>
      </tr>
    </tbody>
  </table>
  <br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
      <td height="29" align="center"> <input type=button class="btn"   border="0" name="sure" value="确定" onclick="doSure()"> 
        <input type=button class="btn"    border="0" name="return" value="返回" onclick="history.back(-1);"> 
      </td>
  </tr>
</table>
</form>
</body>
</html>
<script language="JavaScript">
function addRow(obj)
{
    obj.parentNode.innerHTML="<img src='../images/delete.gif' style='cursor:hand' onclick='deleteRow(this)'>";
	
	var table=document.all("TableUrl");
	var i=table.rows.length;
	var tr=table.insertRow(i);
	tr.className="odd";
	var td=tr.insertCell(0);	
	td.align="center";
	td.innerHTML="<img src=\"../images/edit.gif\" style='cursor:hand' onclick=\"addRow(this)\">";
	td=tr.insertCell(1);
	td.innerHTML="<input type=\"text\" name=\"urls\" size=\"35\" maxByte=\"50\">";
	td=tr.insertCell(2);	
	td.innerHTML="<input type=\"text\" name=\"querys\" size=\"35\" maxByte=\"50\">";		
}

function deleteRow(obj)
{
	var table=document.all("TableUrl");	
	table.deleteRow(obj.parentNode.parentNode.rowIndex);	
}

function doSure()
{
	var objValue=document.all("value");
	var type=document.all("type")[0].checked?"1":"2";
	var parentId=document.all("parentId").value;	
	if (objValue.value!="")
	{
		var actionReturn=sendGetHttp("securityAction.do?action=checkCode&id=0&code=" + objValue.value + "&type=" + type  + "&parentId=" + parentId);
		if (actionReturn=="false")
		{
			showMessage("已存在该权限代码",objValue);
			objValue.IsError="none";
			objValue.focus();
			return;
		}
	}
	document.all("dataForm").doSubmit();
}
</script>
