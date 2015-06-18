<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseUser" %>
<%@ page import="com.dhccity.base.entity.BaseUserGroup" %>
<%
	Iterator it=OnlineUser.list().iterator();	 
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script> 	<script type="text/javascript" src="../js/body.js"></script> 	<script type="text/javascript" src="../js/table.js"></script>
<title><%=Config.SystemName%></title>
</head>
<body>
<br>
<table class="list"  style="behavior:url(../htc/table.htc)" cellspacing=1 cellpadding=0 width="95%" align=center  border=0 >
  <tbody>
    <tr class="title"   > 
      <td  width="8%" height="24">序号</td>
      <td  width="29%" >姓名</td>
      <td  width="36%">登录时间</td>
      <td  width="27%">访问地址</td>
    </tr>
    <%
	int i=1;
	while (it.hasNext())
	{
		User baseUser = (User) it.next();
%>
    <tr class="odd"> 
      <td ><%=i%></td>
      <td  align="left">&nbsp;&nbsp;<%=baseUser.getName()%></td>
      <td align="center"><%=Convert.toTimeString(baseUser.getLoginTime())%></td>
      <td align="center"><%=baseUser.getIp()%></td>
    </tr>
    <%
	i++;
	}
%>
  </tbody>
</table>
</body>
</html>
