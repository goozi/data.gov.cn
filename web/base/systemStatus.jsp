<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%   
    long maxMemory = Runtime.getRuntime().totalMemory();
    long freeMemory = Runtime.getRuntime().freeMemory();
    int rate = (int)(((float)maxMemory - (float)freeMemory) / (float)maxMemory * 100);
    int onlineUser = OnlineUser.size();
    Date startupTime =  Server.StartupTime;    
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
      			<td colspan=2 height=8><b>系统状态</td>
     		</tr>
      		<tr>
				<td width="40%" height="36"><p align="right">java虚拟机最大内存:</p></td>
				<td width="60%"><p align="left"><%=maxMemory%> bytes</p></td>
      		</tr>    		
      		<tr>
				<td height="36"><p align="right">java虚拟机空闲内存:</p></td>
				<td><p align="left"><%=freeMemory%> bytes</p></td>
      		</tr>      		
      		<tr>
				<td height="36"><p align="right">java虚拟机内存使用率:</p></td>
				<td><p align="left"><%=rate%> %</p></td>
      		</tr>    
      		<tr>
				<td height="36"><p align="right">系统在线人数:</p></td>
				<td><p align="left"><a href="onlineUser_list.jsp"><%=onlineUser%> 
          人</a></p></td>
      		</tr> 
      		<tr>
				<td height="36"><p align="right">服务器启动时间:</p></td>
				<td><p align="left"><%=Convert.toTimeString(startupTime)%></p></td>
      		</tr>  
      		  		     		 		
		</tbody>
	</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td height="29" align="center"> <input type="button" onclick="doRestart()" class="btn" border="0" name="sure" value="重新启动运用服务" >
      &nbsp;&nbsp;&nbsp; 
      <input type="button" class="btn"  border="0" name="return" value="返回" onclick="history.back(-1);"> 
    </td>
  </tr>
</table>
</body>
</html>
<script language="JavaScript">
function doRestart()
{
	if (confirm('您确定要进行重启WEB服务吗？')==true)
	{
		sendGetHttp("/systemAction.do?action=restart");
		location.href="/index.htm";
	}
}

</script>
