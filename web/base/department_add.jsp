<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<link rel="stylesheet" href="../htc/default.jss" type="text/css">
<title><%=Config.SystemName%></title>
</head>
<body>
<form action="departmentAction.do?action=addData" method="post" name="dataForm" Check="true" Change="true">
  <table class="edit"  cellspacing=1 cellpadding=3 
            width="95%" align=center border=0>
    <tbody>
      <tr class="title"> 
        <td colspan=4 height=8><b>部门信息</b></td>
      </tr>
      <tr > 
        <td width="16%"  align=right>部门名称：</td>
        <td ><input name="name" type="text" size="30" required="true" validType="maxLength[80]" class="easyui-textbox easyui-validatebox">
        </td>
        <td align="right" >部门全称:</td>
        <td ><input name="fullName" type="text" size="30"  validType="maxLength[120]" class="easyui-textbox easyui-validatebox"></td>
      </tr>
      <tr > 
        <td  align=right>上级部门：</td>
        <td width="34%"> <%=TreeApp.createSelfSelect("parentId","Department")%></td>
        <td width="15%" align="right">部门负责人：</td>
        <td width="35%"><input name="leaderName" type="text" size="30" readonly="readonly"> 
          <input type="hidden" name="leaderId" > <img src="../images/find.gif" width="18" height="19" style="cursor:hand" onClick="selectUser('leaderName','leaderId')"></td>
      </tr>
      <tr > 
        <td  align=right>机构代码：</td>
        <td><input name="code" type="text" size="30"  validType="maxLength[30]" class="easyui-textbox easyui-validatebox"> </td>
        <td align="right">部门级别：</td>
        <td><%=TypeApp.createSelect("mainLevel","DEPARTMENT_MAINLEVEL",TypeApp.ID)%>--<%=TypeApp.createSelect("subLevel","DEPARTMENT_SUBLEVEL",TypeApp.ID)%></td>
      </tr>
      <tr > 
        <td  align=right>部门属性：</td>
        <td><%=TypeApp.createSelect("property","DEPARTMENT_PROPERTY",TypeApp.ID)%></td>
        <td align="right">所属行政区划：</td>
        <td><%=TypeApp.createSelect("canton","CANTON",TypeApp.VALUE)%></td>
      </tr>
      <tr > 
        <td  align=right>地址：</td>
        <td><input name="address" type="text" size="30"  validType="maxLength[100]" class="easyui-textbox easyui-validatebox"></td>
        <td align="right">邮编：</td>
        <td><input name="postCode" type="text" size="30"  validType="maxLength[6]" class="easyui-textbox easyui-validatebox" DataType="postCode"></td>
      </tr>
      <tr > 
        <td align=right>电话：</td>
        <td><input name="tel" type="text" size="30"  validType="maxLength[30]" class="easyui-textbox easyui-validatebox" DataType="tel"></td>
        <td align="right">传真：</td>
        <td><input name="fax" type="text" size="30"  validType="maxLength[30]" class="easyui-textbox easyui-validatebox" DataType="tel"></td>
      </tr>
      <tr >
        <td align="right">显示顺序号：</td>
        <td><input name="sequ" type="text" size="30"  validType="maxLength[6]" class="easyui-textbox easyui-validatebox" DataType="+int" HelpTitle="值越大，排列越靠前"></td>
        <td  align=right>其它说明：</td>
        <td><input name="explain" type="text" size="30"  validType="maxLength[60]" class="easyui-textbox easyui-validatebox"></td>
      </tr>
    </tbody>
  </table>
  <br>
  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr> 
      <td height="29" align="center"> <input type=submit class="btn"   border="0" name="ok" value="确定" >
        <input type=button class="btn"    border="0" name="return" value="返回" onclick="history.back(-1);"> 
      </td>
    </tr>
  </table>
</form>
</body>
</html>
<script language="JavaScript">
function selectUser(userNameObj,userIdObj)
{
	selectUser("user_select.jsp",295,480,userNameObj,userIdObj);
}
</script>