<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/include.jsp" %>
<%

%>
<HTML><HEAD><TITLE>人员选择窗体</TITLE>
<META content="text/html; charset=gb2312" http-equiv=Content-Type>
<META content="MSHTML 5.00.2920.0" name=GENERATOR>
<STYLE>
	select {behavior: url(../htc/select.htc)}
	body{ font-size:12px;color:#000000; BACKGROUND-COLOR:#ded5cf;}
	.btn{CURSOR: hand;MARGIN-LEFT: 6px;	MARGIN-RIGHT: 6px;PADDING-TOP: 1px;HEIGHT: 20px;FONT-FAMILY: 宋体;COLOR: #000000;border-left:#999999 1px solid;border-top: #999999 1px solid;border-bottom: #666666 1px solid;border-right: #666666 1px solid;BACKGROUND-COLOR: #F8F8F8;font-size:12px;}
	td{ font-size:12px }
</STYLE>
</HEAD>
<BODY leftmargin="5" topmargin="7" >
<fieldset style="HEIGHT: 101px; LEFT: 20px; WIDTH: 464" align="center" >
<legend style="FONT-SIZE: 12px; HEIGHT: 14px; WIDTH: 57px">[人员选择］</legend>
<table width="447" height="201"  border="0" align="center" cellPadding=0 cellSpacing=0 >
  <tr >
    <td width="44" height="21" align="left" valign="middle"> &nbsp;部门：</td>
    <td align="left" valign="top"><select name="select" style="width:400px;" first="true" NodeXmlSrc="xmlAction.dox?action=createDepartmentAndUser" subName="leftPeople">
      </select></td>
  </tr>
  <tr >
    <td height="180" align="left" valign="middle">&nbsp;待选：</td>
    <td align="left" valign="bottom"> <select  name="leftPeople" size="15" style="width:400px;height:180px" >
      </select></td>
  </tr>
</table>
</fieldset>
<table width="221" height="28" border=0 align="center" cellpadding =0 cellspacing=0    >
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
function doOk()
{
	var sUserName="",sUserId="";
	var j=0;

	var obj=document.all("leftPeople");
	for (i=0;i<obj.options.length;i++)
	{
		if (obj.options[i].selected)
		{
			sUserName += obj.options[i].text;
			sUserId += obj.options[i].value;
			j++;
		}
	}
	if (j>1)
	{
		alert("您只能选择一个用户");
		return;
	}

	window.returnValue="<xml><node>" + sUserName + "</node><node>" + sUserId + "</node></xml>";
	self.close();


}

</script>
