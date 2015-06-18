<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="com.dhccity.base.entity.BaseUser" %>
<%@ include file="../include.jsp"%>
<%
	long id=req.getLong("id");
	BaseUser baseUser = (BaseUser) new BaseUser().findById(id);  
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<LINK  href="../style/default.css" rel=stylesheet>
<link rel="stylesheet" href="../htc/default.jss" type="text/css">
<title><%=Config.SystemName%></title>
</head>
<body>
  <table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
    <tbody>
      <tr class="title"> 
        <td colspan=4 height=8><b>用户信息</td>
      </tr>
      <tr > 
        <td width="16%"  align=right>姓名：</td>
        <td><%=baseUser.getName()%> 
        </td>
        <td align="right">性别：</td>
        <td><%=baseUser.getSex()%></td>
      </tr>
      <tr > 
        <td align="right">登陆帐号：</td>
        <td width="34%"><%=baseUser.getLoginName()%></td>
        <td width="15%" align="right">密码：</td>
        
      <td width="35%">******</td>
      </tr>
      <tr > 
        <td align="right">英文名： </td>
        <td><%=baseUser.getEname()%></td>
        <td align="right">国籍：</td>
        <td><%=baseUser.getNationality()%></td>
      </tr>
      <tr > 
        <td align="right">人员编号：</td>
        <td><%=baseUser.getCode()%></td>
        <td align="right">所属部门：</td>
        <td><%=baseUser.getDepartmentName()%></td>
      </tr>
      <tr > 
        <td align="right">身份证号码：</td>
        <td><%=baseUser.getIdentityCard()%></td>
        <td align="right">生日：</td>
        <td><%=baseUser.getBirthday()%></td>
      </tr>
      <tr > 
        <td height="27"  align=right>籍贯：</td>
        <td><%=baseUser.getNativePlace()%></td>
        <td align="right">党派：</td>
        <td><%=TypeApp.getName(baseUser.getParty())%></td>
      </tr>
      <tr > 
        <td align="right">办公室电话：</td>
        <td><%=baseUser.getTel()%></td>
        <td align="right">办公室传真：</td>
        <td><%=baseUser.getFax()%> 
        </td>
      </tr>
      <tr > 
        <td align="right">手机号码：</td>
        <td><%=baseUser.getMobileTel()%> 
        </td>
        <td align="right">电子邮件：</td>
        <td><%=baseUser.getEmail()%></td>
      </tr>
      <tr > 
        <td align="right">来本单位日期：</td>
        <td><%=baseUser.getJoinDate()%></td>
        <td align="right">来本单位方式：</td>
        <td><%=TypeApp.getName(baseUser.getJoinType())%></td>
      </tr>
      <tr > 
        <td align="right">上级：</td>
        
      <td><%=baseUser.getBossName()%></td>
        <td align="right">助理：</td>
        <td><%=baseUser.getAssistantName()%></td>
      </tr>
      <tr > 
        <td align="right">IP：</td>
        <td><%=baseUser.getIp()%></td>
        <td align="right">显示顺序号：</td>
        <td><%=baseUser.getSequ()%></td>
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
          <jsp:include page="userGroup_view.jsp" flush="true"> 
          <jsp:param  name="type" value="1" />
		  <jsp:param  name="userId" value="<%=baseUser.getId()%>" />
		</jsp:include>
		</td>
        <td width="50%" valign="top"><jsp:include page="userGroup_view.jsp" flush="true"> 
          <jsp:param  name="type" value="2" />
		  <jsp:param  name="userId" value="<%=baseUser.getId()%>" />
		</jsp:include></td>
      </tr>
    </tbody>
  </table>
  <br>
  <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr> 
      
    <td height="29" align="center"> <input type=button class="btn"    border="0" name="return" value="返回" onclick="history.back(-1);"> 
    </td>
    </tr>
  </table>
</body>
</html>