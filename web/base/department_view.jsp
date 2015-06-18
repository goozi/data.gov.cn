<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.dhccity.base.entity.BaseDepartment" %>
<%@ include file="../include.jsp"%>
<%
	long id=req.getLong("id");
	BaseDepartment baseDepartment = (BaseDepartment) new BaseDepartment().findById(id);  
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<link rel="stylesheet" href="../htc/default.jss" type="text/css">
<title><%=Config.SystemName%></title>
</head>
<body>
  <table class="edit"  cellspacing=1 cellpadding=3 
            width="95%" align=center border=0>
    <tbody>
      <tr class="title"> 
        <td colspan=4 height=8><b>部门信息</b></td>
      </tr>
      <tr > 
        <td width="16%"  align=right>部门名称：</td>
        <td ><%=baseDepartment.getName()%> 
        </td>
        <td align="right" >部门全称:</td>
        <td ><%=baseDepartment.getFullName()%></td>
      </tr>
      <tr > 
        <td  align=right>上级部门：</td>
        <td width="34%"> <%=baseDepartment.getParentName()%></td>
        <td width="15%" align="right">部门负责人：</td>
        <td width="35%"><%=baseDepartment.getLeaderName()%></td>
      </tr>
      <tr > 
        <td  align=right>机构代码：</td>
        <td><%=baseDepartment.getCode()%></td>
        <td align="right">部门级别：</td>
        <td><%=TypeApp.getName(baseDepartment.getMainLevel())%>--<%=TypeApp.getName(baseDepartment.getSubLevel())%></td>
      </tr>
      <tr > 
        <td  align=right>部门属性：</td>
        <td><%=TypeApp.getName(baseDepartment.getProperty())%></td>
        <td align="right">所属行政区划：</td>
        <td><%=baseDepartment.getCanton()%></td>
      </tr>
      <tr > 
        <td  align=right>地址：</td>
        <td><%=baseDepartment.getAddress()%></td>
        <td align="right">邮编：</td>
        <td><%=baseDepartment.getPostCode()%></td>
      </tr>
      <tr > 
        <td align=right>电话：</td>
        <td><%=baseDepartment.getTel()%></td>
        <td align="right">传真：</td>
        <td><%=baseDepartment.getFax()%></td>
      </tr>
      <tr >
        <td align="right">显示顺序号：</td>
        <td><%=baseDepartment.getSequ()%></td>
        <td  align=right>其它说明：</td>
        <td><%=baseDepartment.getExplain()%></td>
      </tr>
    </tbody>
  </table>
  
<br>
  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr> 
      <td height="29" align="center"> 
        <input type=button class="btn"    border="0" name="return" value="返回" onclick="history.back(-1);"> 
      </td>
    </tr>
  </table>
</body>
</html>
