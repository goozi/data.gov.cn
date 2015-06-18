<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="../include.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="../style/tree.css"/>
    <script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="../js/tree.js"></script>
    <title><%=Config.SystemName%>
    </title>
</head>
<body leftmargin="0" topmargin="0">
<script type="text/javascript">
    var tree = new KLoadTree("系统功能权限", "securityAction.do?action=createTreeXml");
    document.write(tree);
    tree.expandToLevel(3);
</script>
</body>
</html>
<script language="JavaScript">
    function doClick(id) {
        parent.document.getElementById("childFrame").src = "user_security_list.jsp?id=" + id;
    }
</script>

