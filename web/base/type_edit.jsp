<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseType" %>
<%
	long id = req.getLong("id");
    BaseType baseType = (BaseType)new BaseType().findById(id); //根据ID查询数据
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<link rel="stylesheet" href="../htc/default.jss" type="text/css">
<title><%=Config.SystemName%></title>
</head>
<body>
<form id="dataForm" name="dataForm" method="POST" action="typeAction.do?action=updateType" Check="true" Change="true">
  <table class="edit"  cellspacing=1 cellpadding=3
            width="95%" align=center border=0>
    <tbody>
      <tr class="title"> 
        <td colspan=4 height=8><b>系统类型信息</b></td>
      </tr>
      <tr > 
        <td width="12%"  align=right>名称：</td>
        <td width="37%" ><input name="name" type="text" value="<%=baseType.getName()%>" size="35" required="true" validType="maxLength[50]" class="easyui-textbox easyui-validatebox">
          <input type="hidden" name="id" value="<%=baseType.getId()%>" /> </td>
        <td width="12%" align="right" >代码：</td>
        <td width="39%" ><input name="code" type="text" value="<%=baseType.getCode()%>" size="35" required="true"  readonly="readonly" style='BACKGROUND-COLOR: #cccccc;'></td>
      </tr>
      <tr > 
        <td  align=right>类型：</td>
        <td><input name="type" type="radio" value="NORMAL" <%=baseType.getType().equals("TREE")?"":"checked"%> >
          普通 
          <input type="radio" name="type" value="TREE"  <%=baseType.getType().equals("TREE")?"checked":""%>>
          树型结构 </td>
        <td align="right">所属上级：</td>
        <td><%=TypeApp.createSelfSelect("parentId","PARENT_TYPE",true,baseType.getId(),baseType.getParentId())%></td>
      </tr>
      <tr > 
        <td  align=right>用户权限：</td>
        <td><input name="userNames" type="text" size="35" readonly="readonly" value="<%=baseType.getUserNames()%>"> 
          <input type="hidden" name="userIds" value="<%=baseType.getUserIds()%>"> 
          <img src="../images/find.gif" style="cursor:hand" width="18" height="19" onClick="selectUser('userNames','userIds')"></td>
        <td align="right">顺序种子：</td>
        <td><input name="sequ" type="text" value="<%=baseType.getSequ()%>" size="35" validType="maxLength[6]" class="easyui-textbox easyui-validatebox" datatype="+int"></td>
      </tr>
      <tr >
        <td align="right">管理级别：</td>
        <td><input name="securityLevel" type="radio" value="0" <%=baseType.getSecurityLevel()==0?"checked":""%>>
          普通&nbsp;&nbsp;  <%if (user.isProgrammer()) {%><input type="radio" name="securityLevel" value="1" <%=baseType.getSecurityLevel()==1?"checked":""%>>
          程序员 
          <input type="radio" name="securityLevel" value="2" <%=baseType.getSecurityLevel()==2?"checked":""%>>
          隐藏管理 <%}%></td>
        <td align="right">说明：</td>
        <td><input name="explain" type="text" value="<%=baseType.getExplain()%>" size="35"></td>
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
<script language="JavaScript">

function selectUser(userNameObj,userIdObj)
{
	selectUser("manyUser_select.jsp",295,480,userNameObj,userIdObj);
}


</script>