<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="../include.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <LINK href="../style/default.css" rel=stylesheet>
    <title><%=Config.SystemName%>
    </title>
</head>
<body leftmargin="0" topmargin="0">
<br>
<table width="97%" height="95%" border="0" align="right" cellpadding="0" cellspacing="0">
    <tr>
        <td width="26%" valign="top">
            <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#666666">
                <tr>
                    <td bgcolor="#FFFFFF">
                        <iframe name="parentFrame" src="security_treeList.jsp" border="1" frameborder="0"
                                framespacing="0" width="100%" height="100%"></iframe>
                    </td>
                </tr>
            </table>
        </td>
        <td width="2%">&nbsp;</td>
        <td width="72%" valign="top">
            <iframe id="childFrame" name="childFrame" src="user_security_list.jsp" border="0" frameborder="0" noresize width="100%"
                    height="100%"></iframe>
        </td>
    </tr>
</table>
</body>
</html>