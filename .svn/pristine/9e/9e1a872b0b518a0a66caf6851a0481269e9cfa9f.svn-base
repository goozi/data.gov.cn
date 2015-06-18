<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseUser" %>
<%@ page import="com.dhccity.base.entity.BaseUserGroup" %>
<%	
	int type=req.getInt("type");
	String name=type==1?"职务":"角色";
	String typeCode=type==1?"DUTY":"ROLE";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<link rel="stylesheet" href="../htc/default.jss" type="text/css">
<title><%=Config.SystemName%></title>
</head>
<body>
<table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
  <tbody>
    <tr class="title"> 
      <td colspan=2 height=8><b><%=name%>选择</b></td>
    </tr>
    <tr > 
      <td width="27%"  align=right>部门：</td>
      <td><select style="width:225px;" name="departmentId"><option value="0"></option>
          <%=TreeApp.createOption("Department",TreeApp.ID)%></select> </td>
    </tr>
    <tr > 
      <td align="right"><%=name%>：</td>
      <td width="73%"> <select style="width:225px;" name="groupId">
          <%=TypeApp.createOption(typeCode,TypeApp.ID)%></select></td>
    </tr>
    <tr > 
      <td align="right">显示顺序号：</td>
      <td><input name="sequ" type="text" size="30"  validType="maxLength[6]" class="easyui-textbox easyui-validatebox" DataType="+int" HelpTitle="值越大，排列越靠前"></td>
    </tr>
  </tbody>
</table>
<div align="center"><br>
  <input type=button class="btn"   border="0" name="ok" value="确定" onclick="doSelect()" >
  <input type=button class="btn"    border="0" name="cancel" value="取消" onclick="self.close();">
</div>
</body>
</html>
<script language="javascript">
//删除选中记录
function doSelect()
{
	var departmentId=document.all("departmentId");
	var optionDep=departmentId.options[departmentId.selectedIndex];
	var groupId=document.all("groupId");
	var optionGroup=groupId.options[groupId.selectedIndex];
	var sequ=document.all("sequ").value;
	var depName=optionDep.text.replace(/├ /g,"").replace(/│/g,"");
	var groupName=optionGroup.text.replace(/├ /g,"").replace(/│/g,"");
	opener.addRow<%=type%>(depName,optionDep.value,groupName,optionGroup.value,sequ);
	self.close();
}


//响应搜索按钮
function doSearch()
{
	var unit=document.all("unit").value;
	unit=str2Url(unit);//对特殊字符进行转换
	var materialObjectId=document.all("materialObjectId").value;
	var startTime="",overTime="";
	if (document.all("startTime").checked) startTime=document.all("startTime").value;
	if (document.all("overTime").checked)  overTime=document.all("overTime").value;
	if (overTime<startTime&&startTime!=""&&overTime!="")
	{
		alert("结束时间必须大于开始时间！");
		return;
	}
	document.location.href="check_list.jsp?unit=" + unit + "&materialObjectId=" + materialObjectId + "&startTime=" + startTime +"&overTime=" + overTime;
}
</script>