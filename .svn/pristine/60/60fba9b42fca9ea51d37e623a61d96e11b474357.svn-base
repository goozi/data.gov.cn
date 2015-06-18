<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseType" %>
<%
	long id=req.getLong("id");	
    BaseType baseType = (BaseType) new BaseType().findById(id);    
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<link rel="stylesheet" href="/htc/default.css" type="text/css">
<title><%=Config.SystemName%></title>
</head>

<body>
<form id="dataForm" name="dataForm" method="POST" action="typeAction.do?action=updateChildType" Check="true" Change="true">

  <table class="edit"  cellspacing=1 cellpadding=3
            width="95%" align=center border=0>
    <tbody>
      <tr class="title"> 
        <td colspan=4 height=8><b>类型选项信息
          <input type="hidden" name="code" value="<%=baseType.getCode()%>">
		  <input type="hidden" name="value" value="<%=baseType.getValue()%>">
          </b></td>
      </tr>
      <tr > 
        <td width="19%"  align=right>名称：</td>
        <td colspan="3" ><input name="name" type="text" value="<%=baseType.getName()%>" size="50" required="true" validType="maxLength[80]" class="easyui-textbox easyui-validatebox" >
          <input type="hidden" name="id" value="<%=baseType.getId()%>" /> </td>
      </tr>
      <%if (baseType.getType().equals("TREE")) {%>
      <tr > 
        <td  align=right>上级选项：</td>
        <td colspan="3"><%=TypeApp.createSelfSelect("parentId",baseType.getCode(),false,baseType.getId(),baseType.getParentId())%></td>
      </tr>
      <%} else {
	  	 out.print("<input name='parentId' type='hidden' value='" + baseType.getParentId() + "'>");
	    }%>
      <tr > 
        <td  align=right>有效：</td>
        <td width="37%"><input name="state" type="checkbox" value="1"  <%=baseType.getState()==1?"checked":""%>> 
        </td>
        <td width="16%" align="right" validType="maxLength[3]" class="easyui-textbox easyui-validatebox">顺序种子：</td>
        <td width="28%"><input name="sequ" type="text" value="<%=baseType.getSequ()%>" size="15" validType="maxLength[3]" class="easyui-textbox easyui-validatebox" DataType="+int"></td>
      </tr>
    </tbody>
  </table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="29" align="center">
      <input type="submit" class="btn"   border="0" name="save" value="确定" >
      <input type=button class="btn"  border="0" name="cancel" value="取消" onclick="self.close();">
    </td>
  </tr>
</table>
</form>
</body>
</html>