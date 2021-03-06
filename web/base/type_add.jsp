<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../js/body.js"></script>
  <%--<script type="text/javascript" src="../js/select.js"></script>--%>
<title><%=Config.SystemName%></title>
</head>
<body>
<form id="dataForm" name="dataForm" action="typeAction.do?action=addType" method="POST" Check="true" Change="true">
  <table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
    <tbody>
      <tr class="title"> 
        <td colspan=4 height=8><b>系统类型信息</b></td>
      </tr>
      <tr > 
        <td width="13%"  align=right>名称：</td>
        <td width="34%" ><input name="name" type="text" size="35" required="true" validType="maxLength[50]" class="easyui-textbox easyui-validatebox">
        </td>
        <td width="13%" align="right" >代码：</td>
        <td width="40%" ><input id="code" name="code" type="text" size="35" required="true" validType="maxLength[50]" class="easyui-textbox easyui-validatebox"></td>
      </tr>
      <tr > 
        <td  align=right>类型： </td>
        <td><input name="type" type="radio" value="NORMAL" checked>
          普通 
          <input type="radio" name="type" value="TREE">
          树型结构 </td>
        <td align="right">所属上级：</td>
        <td><%=TypeApp.createSelfSelect("parentId","PARENT_TYPE",true)%></td>
      </tr>
      <tr > 
        <td  align=right>用户权限：</td>
        <td><input id="userNames" name="userNames" type="text" size="35" readonly="readonly">
          <input type="hidden" name="userIds" id="userIds"> <img src="../images/find.gif" width="18" height="19" style="cursor:hand" onClick="oselectUser('userNames','userIds')"></td>
        <td align="right">顺序种子：</td>
        <td><input name="sequ" type="text"  size="35" validType="maxLength[6]" class="easyui-textbox easyui-validatebox" datatype="+int"></td>
      </tr>
      <tr >
        <td align="right">管理级别：</td>
        <td><input name="securityLevel" type="radio" value="0" checked>
          普通&nbsp;
		  <%if (user.isProgrammer()) {%>
		  <input type="radio" name="securityLevel" value="1">
          程序员 &nbsp; 
          <input type="radio" name="securityLevel" value="2">
          隐藏管理<%}%> </td>
        <td align="right">说明：</td>
        <td><input name="explain" type="text" value="" size="35" validType="maxLength[500]" class="easyui-textbox easyui-validatebox"></td>
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
/*
function doSure()
{
	if (!document.all("code").doCheck()) return;
	
	var actionReturn=sendGetHttp("typeAction?action=checkCode&a&code=" + document.all("code").value);
	if (actionReturn=="false")	
	{
		showMessage("代码名称已存在，不允许重复",document.all("name"));
		document.all("code").focus();
		return;
	}	

	var dataForm=document.all("dataForm");	
	document.all("dataForm").doSubmit();
}
*/

function oselectUser(userNameObj,userIdObj)
{
	selectUser("manyUser_select.jsp",350,560,userNameObj,userIdObj);
}

function doSure()
{
	var code=document.getElementById("code");	
	if (code.value!="")
	{
		$.get("typeAction.do?action=checkCode&id=0&code=" + code.value,function(actionReturn){
			if (actionReturn=="false")
			{
				showMessage("代码已存在请重新输入",code);
				code.IsError="none";
				code.focus();
				return;
			}
			});
		
	}
	document.getElementById("dataForm").submit();
}
</script>
