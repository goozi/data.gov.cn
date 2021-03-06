<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.base.entity.BaseType" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="../style/tree.css"/>
    <script type="text/javascript" src="../js/tree.js"></script>
    <style>
        .btn {
            Height: 25px;
            BORDER-RIGHT: #31557f 1px solid;
            PADDING-RIGHT: 4px;
            BORDER-TOP: #cce3ff 1px solid;
            PADDING-LEFT: 4px;
            FONT-WEIGHT: normal;
            FONT-SIZE: 12px;
            BACKGROUND: #7688b1;
            PADDING-BOTTOM: 2px;
            MARGIN: 2px;
            /*BEHAVIOR: url("../css/changeButton.htc");*/
            WORD-SPACING: 0px;
            VERTICAL-ALIGN: middle;
            BORDER-LEFT: #cce3ff 1px solid;
            CURSOR: hand;
            COLOR: #ffffff;
            PADDING-TOP: 2px;
            BORDER-BOTTOM: #31557f 1px solid;
            LETTER-SPACING: 0px;
            HEIGHT: 20px
        }

    </style>
    <title><%=Config.SystemName%>
    </title>
</head>
<body leftmargin="0" topmargin="0">
<br>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#000000">
    <tr>
        <td bgcolor="#FFFFFF">
            <script type="text/javascript">
                var tree = new KLoadTree("系统功能权限", "securityAction.do?action=createRadioTreeXml");
                document.write(tree);
                tree.expandToLevel(2);
            </script>
        </td>
    </tr>
</table>
<br>
<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td height="29" align="center">
            <input type="button" class="btn" border="0" name="sure" value="确定" onClick="doSure()">
            <input type=button class="btn" border="0" name="save" value="取消" onclick="self.close();">
        </td>
    </tr>
</table>
</body>
</html>
<script language="JavaScript">
    function doSure() {
        var isSelect = false;
        var itemObj = document.all("item");
        var value;
        for (var i = 0; i < itemObj.length; i++) {
            if (itemObj[i].checked) {
                value = itemObj[i].value.split(";");
                isSelect = true;
                break;
            }
        }
        if (!isSelect) {
            alert("请选择相应的权限对象");
            return;
        }

        var id = value[0];
        var name = value[1];
        opener.writeValue(id, name);
        self.close();
    }
</script>

