<%@ page language="java" pageEncoding="utf-8"%>

<%@ include file="../include.jsp"%>
<%
	String type=req.getString("type");
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="../js/body.js"></script>
<%@ include file="../easyui_include.jsp"%>
<title><%=Config.SystemName%></title>
</head>
<body>
<form id="dataForm" name="dataForm" method="post" action="userAction.do?action=addData" Check="true" Change="true" ENCTYPE="multipart/form-data">
  <table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
    <tbody>
      <tr class="title"> 
        <td colspan=4 height=8><b>用户信息
          <input type="hidden" name="type" value="<%=type%>">
          </b></td>
      </tr>
      <tr >
        <td width="16%"  align=right>头像：</td>
        <td colspan="3">
          <input type="hidden" name="sourceCode" value="avatar">
          <input name="avatar" type="text"  class="easyui-filebox" required="required" data-options="buttonText:'上传头像'">
        </td>
      </tr>
      <tr > 
        <td width="16%"  align=right>姓名：</td>
        <td><input name="name" type="text" size="30" required="true" validType="maxLength[20]" class="easyui-textbox easyui-validatebox">
        </td>
        <td align="right">性别：</td>
        <td><%=TypeApp.createSelect("sex","SEX",TypeApp.VALUE)%></td>
      </tr>
      <tr > 
        <td align="right">登陆帐号：</td>
        <td width="34%"> <input name="loginName" type="text" id="loginName" size="30" required="true" validType="maxLength[20]" class="easyui-textbox easyui-validatebox"></td>
        <td width="15%" align="right">密码：</td>
        <td width="35%"> <input name="password" type="text" id="password" size="30" required="true" validType="maxLength[30]" class="easyui-textbox easyui-validatebox"></td>
      </tr>
      <tr > 
        <td align="right">英文名： </td>
        <td><input name="ename" type="text" size="30"  validType="maxLength[30]" class="easyui-textbox easyui-validatebox"></td>
        <td align="right">国籍：</td>
        <td><input name="nationality" type="text" size="30"  validType="maxLength[30]" class="easyui-textbox easyui-validatebox"></td>
      </tr>
      <tr > 
        <td align="right">人员编号：</td>
        <td><input name="code" type="text" size="30" validType="maxLength[30]" class="easyui-textbox easyui-validatebox"></td>
        <td align="right">所属部门：</td>
        <td><%=TreeApp.createSelect("departmentId","Department",TreeApp.ID)%></td>
      </tr>
      <tr > 
        <td align="right">身份证号码：</td>
        <td><input name="identityCard" type="text" size="30" data-options="validType:['idcard']" class="easyui-textbox easyui-validatebox"></td>
        <td align="right">生日：</td>
        <td><input name="birthday" type="text" size="30"  validType="date" class="easyui-textbox easyui-validatebox"></td>
      </tr>
      <tr > 
        <td height="27"  align=right>籍贯：</td>
        <td><input name="nativePlace" type="text" size="30"  validType="maxLength[30]" class="easyui-textbox easyui-validatebox"></td>
        <td align="right">党派：</td>
        <td><%=TypeApp.createSelect("party","PARTY",TypeApp.ID)%></td>
      </tr>
      <tr > 
        <td align="right">办公室电话：</td>
        <td><input name="tel" type="text" size="30"  validType="tel" class="easyui-textbox easyui-validatebox"></td>
        <td align="right">办公室传真：</td>
        <td><input name="fax" type="text" size="30"  validType="tel" class="easyui-textbox easyui-validatebox">
        </td>
      </tr>
      <tr > 
        <td align="right">手机号码：</td>
        <td><input name="mobileTel" type="text" size="30" validType="mobile" class="easyui-textbox easyui-validatebox">
        </td>
        <td align="right">电子邮件：</td>
        <td><input name="email" type="text" size="30" validType="email" class="easyui-textbox easyui-validatebox"></td>
      </tr>
      <tr > 
        <td align="right">来本单位日期：</td>
        <td><input name="joinDate" type="text" size="30" class="easyui-datebox" editable="false"></td>
        <td align="right">来本单位方式：</td>
        <td><%=TypeApp.createSelect("joinType","JOIN_TYPE",TypeApp.ID)%></td>
      </tr>
      <tr > 
        <td align="right">上级：</td>
        <td><input id="bossName" name="bossName" type="text" size="30" readonly="readonly"> <input id="boss" type="hidden" name="boss" ><img src="../images/find.gif" width="18" height="19" style="cursor:hand" onClick="oselectUser('bossName','boss')"></td>
        <td align="right">助理：</td>
        <td><input name="assistantName" type="text" size="30" readonly="readonly"> 
          <input type="hidden" name="assistant" >
          <img src="../images/find.gif" width="18" height="19" style="cursor:hand" onClick="oselectUser('assistantName','assistant')"></td>
      </tr>
      <tr > 
        <td align="right">IP：</td>
        <td><input name="ip" type="text" size="30"  validType="ip" class="easyui-textbox easyui-validatebox" ></td>
        <td align="right">显示顺序号：</td>
        <td><input name="sequ" type="text" size="30"  data-options="validType:['integer','maxLength[6]']" class="easyui-textbox easyui-validatebox" title="值越大，排列越靠前"></td>
      </tr>
    </tbody>
  </table>
  <br>
  <table  cellspacing=1 cellpadding=3 
            width="95%" align=center border=0>
    <tbody>
      <tr > 
        <td width="50%"><b><font color=#ff0000>*</font>担任职务</b></td>
        <td height=8 colspan=2><font color=#ff0000>*</font><strong>担任角色</strong></td>
      </tr>
      <tr > 
        <td height="24" valign="top"> 
          <jsp:include page="userGroup_add.jsp" flush="true"> 
          <jsp:param  name="type" value="1" />
		</jsp:include>
		</td>
        <td width="50%" valign="top"><jsp:include page="userGroup_add.jsp" flush="true"> 
          <jsp:param  name="type" value="2" />
		</jsp:include></td>
      </tr>
    </tbody>
  </table>
  <br>
  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr> 
      <td height="29" align="center"> <input type=submit class="btn"   border="0" name="sure" value="确定" > 
        <input type=button class="btn"    border="0" name="return" value="返回" onclick="history.back(-1);"> 
      </td>
    </tr>
  </table>
</form>
</body>
</html>
<script language="JavaScript">
function oselectUser(userNameObj,userIdObj)
{
	selectUser("user_select.jsp",305,490,userNameObj,userIdObj);
}
</script>