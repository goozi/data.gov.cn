<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/include.jsp" %>
<%
    String userNames = req.getString("userNames");
    String userIds = req.getString("userIds");
    if (!userIds.equals("")) userIds = userIds.substring(1, userIds.length() - 1);
    String[] userName = userNames.split(";");
    String[] userId = userIds.split("\\]\\[");
    String option = "";
    if (!userNames.equals("")) {
        for (int i = 0; i < userName.length; i++) {
            if (i < userId.length) option += "<option value=\"" + userId[i] + "\">" + userName[i] + "</option>";
            else option += "<option value=\"\">" + userName[i] + "</option>";
        }
    }
%>
<HTML>
<HEAD>
    <TITLE>人员选择窗体</TITLE>
    <META content="text/html; charset=gb2312" http-equiv=Content-Type>
    <META content="MSHTML 5.00.2920.0" name=GENERATOR>
    <script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="../js/select.js"></script>
    <STYLE>
        body {
            font-size: 12px;
            color: #000000;
            BACKGROUND-COLOR: #ded5cf;
        }

        .btn {
            CURSOR: hand;
            MARGIN-LEFT: 6px;
            MARGIN-RIGHT: 6px;
            PADDING-TOP: 1px;
            HEIGHT: 20px;
            FONT-FAMILY: 宋体;
            COLOR: #000000;
            border-left: #999999 1px solid;
            border-top: #999999 1px solid;
            border-bottom: #666666 1px solid;
            border-right: #666666 1px solid;
            BACKGROUND-COLOR: #F8F8F8;
            font-size: 12px;
        }

        td {
            font-size: 12px
        }
    </STYLE>
</HEAD>
<BODY leftmargin="5" topmargin="7">
<fieldset style="HEIGHT: 250px; LEFT: 20px; WIDTH: 480px" align="center">
    <legend style="FONT-SIZE: 12px; HEIGHT: 14px; WIDTH: 66px">[人员选择］</legend>
    <table width="447" height="201" border="0" align="center" cellPadding=0 cellSpacing=0>
        <tr>
            <td width="44" height="21" align="left" valign="middle"> &nbsp;部门： <br></td>
            <td width="177" align="left" valign="top">
                <select name="select" style="width:170px;" first="true"
                        NodeXmlSrc="xmlAction.dox?action=createDepartmentAndUser" subName="leftPeople">
                </select></td>
            <td width="56" rowspan="2" align="center"><input title="增加" type="button" name="Submit" value=" -&gt; "
                                                             onclick="addOne()" class="btn">
                <br>
                <br> <input title="删除" type="button" name="Submit" value=" &lt;- " onclick="delOne()" class="btn">
                <br>
                <br> <input title="增加全部" type="button" name="Submit" value=" =&gt;&gt;" onclick="addAll()" class="btn">
                <br>
                <br> <input title="清空" type="button" name="Submit" value="&lt;&lt;= " onclick="delAll()" class="btn">
            </td>
            <td rowspan="2" align="center" valign="bottom"><SELECT id="rightPeople" NAME="rightPeople" ondblclick="delOne()"
                                                                   leftName="leftPeople"
                                                                   style="width:170px;height:196px" multiple>
                <%=option%>
            </SELECT></td>
        </tr>
        <tr>
            <td height="180" align="left" valign="middle">&nbsp;待选：</td>
            <td width="177" align="left" valign="bottom"><select id="leftPeople" name="leftPeople" ondblclick="addOne()"
                                                                 rightname="rightPeople"
                                                                 style="width:170px;height:180px" multiple>
            </select></td>
        </tr>
    </table>
</fieldset>
<table width="221" height="28" border=0 align="center" cellpadding=0 cellspacing=0>
    <tr valign="bottom">
        <td width="50%" height="26" align="center">
            <input type="button" name="Submit3" value="  确定  " class="btn" onclick="doOk()">
        </td>
        <td width="50%" align="center">
            <input type="button" name="Submit4" value="  取消  " class="btn" onClick="self.close()">
        </td>
    </tr>
</table>
</BODY>
</HTML>
<script language="JavaScript">


    //响应确定按钮
    function doOk() {
        var sUserName = "", sUserId = "";

        var obj = $("#rightPeople")[0];
        for (var i = 0; i < obj.options.length; i++) {
            sUserName += obj.options[i].text + ";";
            sUserId += "{" + obj.options[i].value + "}";
        }

        window.returnValue = "<xml><node>" + sUserName + "</node><node>" + sUserId + "</node></xml>";
        self.close();
    }

    function addOne() {
        var obj = $("#leftPeople")[0];
        addSelectedOption("right",obj);
    }

    function addAll() {
        var obj = $("#leftPeople")[0];
        addAllOption("right",obj);
    }

    function delOne() {
        var obj = $("#rightPeople")[0];
        delSelectedOption(obj);
    }

    function delAll() {
        var obj = $("#rightPeople")[0];
        delAllOption(obj);
    }

</script>
