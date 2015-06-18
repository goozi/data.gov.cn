<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.dhccity.xmsl.common.entity.BaseDocument" %>
<%@ page import="com.dhccity.xmsl.common.business.DocumentServer" %>
<%@ include file="/include.jsp" %>
<%
	String sourceCode=req.getString("sourceCode");
	long sourceId=req.getLong("sourceId");
	Iterator itFile=DocumentServer.findDocument(sourceCode,sourceId).iterator();

%>
<table class="list" style="behavior:url(../htc/table.htc)"  cellspacing=1 cellpadding=0 width="100%" align=center  border=0 >
  <tbody>

    <tr align="center" class="title"   >
      <td  width="56%">文件名称</td>

      <td  width="14%">大小</td>

      <td width="30%">创建时间</td>
          </tr>
  <%
	int fileCount=0;
	while (itFile!=null&&itFile.hasNext()){
		fileCount++;
        BaseDocument baseDocument = (BaseDocument) itFile.next();
%>
  <tr class="odd">
      <td align="left"  ><img src="<%=DocumentServer.getDocumentIcon(baseDocument.getPostfix())%>" ><a href="/common/documentAction?action=OPEN&id=<%=baseDocument.getId()%>">&nbsp;<%=baseDocument.getName()%></a></td>
    <TD width="14%"><%=baseDocument.getSize()%></TD>
    <TD width="30%"><%=KHttp.getTimeString(baseDocument.getCreateTime())%></TD>
  </TR>
  <%
	}
%>
</table>


