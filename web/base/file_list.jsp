<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.dhccity.base.entity.BaseDocument" %>
<%@ page import="com.dhccity.base.business.DocumentApp" %>
<%@ include file="/include.jsp" %>
<%
	String sourceCode=req.getString("sourceCode");
	long sourceId=req.getLong("sourceId");
	Iterator itFile=DocumentApp.findDocument(sourceCode,sourceId).iterator();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="/style/default.css" rel=stylesheet>
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script> 	<script type="text/javascript" src="../js/body.js"></script> 	<script type="text/javascript" src="../js/table.js"></script>
<title><%=Config.SystemName%></title>
</head>
<body>
<table class="list" style="behavior:url(../htc/table.htc)"  cellspacing=1 cellpadding=0 width="100%" align=center  border=0 >
  <tbody>

    <tr align="center" class="title" >
      <td  width="56%">文件名称</td>
      <td  width="14%">大小</td>
      <td width="30%">创建时间</td>
    </tr>
<%
	while (itFile!=null&&itFile.hasNext()){
        BaseDocument baseDocument = (BaseDocument) itFile.next();
%>
  <tr class="odd">
      <td align="left"  ><img src="<%=DocumentApp.getDocumentIcon(baseDocument.getPostfix())%>" ><a href="/base/documentAction.do?action=downloadFile&id=<%=baseDocument.getId()%>">&nbsp;<%=baseDocument.getName()%></a></td>
    <TD width="14%"><%=baseDocument.getFileSize()%></TD>
    <TD width="30%"><%=baseDocument.getCreateTime()%></TD>
  </TR>
<%
	}
%>
</table>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="29" align="center">
       <input type=button class="btn" border="0" name="cancel" value="关闭" onclick="self.close();">
    </td>
  </tr>
</table>

</body>
</html>


