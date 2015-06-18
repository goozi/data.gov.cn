<%@ page contentType="text/html; charset=utf-8" %>
<%@ include file="include.jsp" %>
<html>
<head>
<META NAME="Robots" CONTENT="noindex">
  <meta content="text/html;charset=utf-8" http-equiv="Content-Type">
  <title>Deeptree</title>
<STYLE>
	 kingtop\:outlook {behavior: url(htc/outlook.htc);}
</STYLE>
</head>
<body  >
<kingtop:outlook  id="Outlook" top="0" left="0" height="element.clientHeight" width="118" NodeXmlSrc="base/menuAction.do?action=createMenu" FilesDir="htc/" TreeLevel=<%=Config.getAttributeValue("menu","treelevel")%>></kingtop:outlook>
</body>
</html>
