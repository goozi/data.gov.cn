<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp"%>
<%@ page import="com.dhccity.base.entity.BaseType"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" href="../style/tree.css" />
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../js/tree.js"></script>
<title><%=Config.SystemName%></title>
</head>
<body leftmargin="0" topmargin="0">
<script type="text/javascript">
	var tree = new KLoadTree("数据字典", "typeAction.do?action=createParentTypeXml");
	document.write(tree);
	tree.expandToLevel(3);
</script>
</body>
</html>
<script language="JavaScript">
	function doClick(id) {
		$("#childFrame", window.parent.document).attr('src',
				'childType_list.jsp?id=' + id);
	}
</script>

