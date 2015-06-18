<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="../include.jsp" %>
<%@ page import="com.dhccity.data.entity.DataGroup" %>
<%@ page import="com.dhccity.base.entity.BaseUser" %>
<%@ page import="com.dhccity.base.util.BaseConstant" %>
<%@ page import="com.dhccity.base.entity.BaseType" %>
<%
	long id=req.getLong("id");
	DataGroup dataGroup = (DataGroup) new DataGroup().findById(id);
	BaseUser creator = (BaseUser)(new BaseUser().findById(dataGroup.getCreator()));
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<LINK  href="../style/default.css" rel=stylesheet>
	<link rel="stylesheet" href="/js/font-awesome/css/font-awesome.css">
	<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
	<%@ include file="../easyui_include.jsp" %>
	<title><%=Config.SystemName%></title>
</head>
<body>
	<form id="dataForm" name="dataForm" method="post" action="dataGroupAction.do?action=addData" Check="true" Change="true">
	<table class="edit"  cellspacing=1 cellpadding=3 width="95%" align=center border=0>
		<tr class="title">
			<td colspan="4"><b>专题查看</b></td>
		</tr>
		<tr>
			<td width="15%"  align="right">名称</td>
			<td><%=dataGroup.getName()%></td>
			<td width="15%"  align="right">标题</td>
			<td><%=dataGroup.getTitle()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right" height="250">描述</td>
			<td colspan="3"><%=dataGroup.getDescription()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">LOGO</td>
			<td colspan="3"><i class="fa fa-3x <%=dataGroup.getLogo()%>"></i></td>
		</tr>
		<tr>
			<td width="15%"  align="right">创建人</td>
			<td><%=creator.getName()%></td>
			<td width="15%"  align="right">创建时间</td>
			<td><%=dataGroup.getCreateTime()%></td>
		</tr>
		<tr>
			<td width="15%"  align="right">状态</td>
			<td><%=TypeApp.getName("STATE", dataGroup.getState())%></td>
			<td width="15%"  align="right">审核状态</td>
			<td id="approvalStatus"><%=TypeApp.getName("APPROVAL_STATUS", dataGroup.getApprovalStatus())%></td>
		</tr>
	</table>
	<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td height="29" align="center">
				<%
					//该机构待审及登录用户有机构审核员的角色权限
					if(dataGroup.getApprovalStatus().equals(BaseConstant.APPROVAL_STATUS_NORMAL) && new BaseType().getDutyOrRoleList(user.getId(),2).contains("专题审核员")){
					//if(dataGroup.getApprovalStatus().equals(BaseConstant.APPROVAL_STATUS_NORMAL) && new BaseType().getDutyOrRoleList(2,2).contains("专题审核员")){
				%>
				<input type="button" class="btn" border="0" id="pass" value="审核通过">
				<input type="button" class="btn" border="0" id="refuse" value="审核不通过">
				<%
					}
				%>
				<input type="button" class="btn" border="0" name="return" value="返回" onclick="location.href='dataGroup_list.jsp';">
			</td>
		</tr>
	</table>
	</form>
</body>
<script>
	$('#refuse').on('click',function(){
		$.get('dataGroupAction.do?action=approvalData&id=<%=dataGroup.getId()%>&type=refuse',function(data){
			if(data=='success'){
				$('#approvalStatus').text('审核不通过');
				$('#refuse').hide('slow');
				$('#pass').hide('slow');
				$.messager.alert('成功','已审核不通过','info');
			}
		});
	});
	$('#pass').on('click',function(){
		$.get('dataGroupAction.do?action=approvalData&id=<%=dataGroup.getId()%>&type=pass',function(data){
			if(data=='success'){
				$('#approvalStatus').text('审核通过');
				$('#refuse').hide('slow');
				$('#pass').hide('slow');
				$.messager.alert('成功','已审核通过','info');
			}
		});
	});
</script>
</html>
