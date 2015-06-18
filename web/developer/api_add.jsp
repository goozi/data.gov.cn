<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../include.jsp"%>
<%

%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<LINK href="../style/default.css" rel=stylesheet>
	<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="../js/body.js"></script>
	<%@ include file="../easyui_include.jsp"%>
	<%@ include file="../kindeditor_include.jsp"%>
	<title><%=Config.SystemName%></title>
</head>
<body>
<form id="dataForm" name="dataForm" method="post">
	<table class="edit" cellspacing=1 cellpadding=3 width="95%"
		   align=center border=0>
		<tr class="title">
			<td colspan="4"><b>API集新增</b></td>
		</tr>
		<tr>
			<td width="15%" align="right">API集名</td>
			<td colspan="3"><input name="title" type="text"
					   validType="length[1,160]" required="true" class="easyui-textbox easyui-validatebox"
					   size="60"></td>
		</tr>
		<tr>
			<td width="15%" align="right">API集说明</td>
			<td colspan="3"><textarea id="editor_id" name="description"
									  style="width: 800px; height: 400px;"></textarea></td>
		</tr>
		<tr>
			<td width="15%" align="right">是否公开</td>
			<td colspan="3"><%=TypeApp.createRadio("isPublic", "IS_PUBLIC",
					TypeApp.VALUE)%></td>
		</tr>
		<tr>
			<td width="15%" align="right">所属机构</td>
			<td><input id="orgId" name="orgId" type="text" size="30"></td>
			<td width="15%" align="right">所属专题</td>
			<td><input id="groupId" name="groupId" type="text" size="30"></td>
		</tr>
	</table>
	<table width="95%" border="0" align="center" cellpadding="0"
		   cellspacing="0">
		<tr>
			<td height="29" align="center">
				<input type="button" class="btn"
					   border="0" name="sure" value="确定" onclick="doSubmit(1)">
				<input
						type="button" class="btn" border="0" name="continueAddResource"
						value="确定并继续添加API" onclick="doSubmit(2)">
				<input type="button" class="btn"
					   border="0" name="return" value="返回" onclick="history.back(-1);"></td>
		</tr>
	</table>
</form>
</body>
<script type="text/javascript">
	KindEditor.ready(function(K) {
		window.editor = K.create('#editor_id', {
			cssPath : '/kindeditor/plugins/code/prettify.css',
			uploadJson : '/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '/kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true
		});
	});
	//验证并提交表单
	function doSubmit(type) {
		var action;
		switch (type) {
			case 1:
				action = '/data/datasetAction.do?action=addData&flow=single_api';
				break;
			case 2:
				action = '/data/datasetAction.do?action=addData&flow=multi_api';
				break;
		}
		if ($('#dataForm').form('validate')) {
			editor.sync();
			if(editor.html().length>2000){
				$.messager.alert('警告', '描述长度超过2000个字符！', 'warning');
				return;
			}
			var dataForm = document.getElementById("dataForm");
			dataForm.action = action;
			dataForm.submit();
		}
	}
	$('#orgId').combobox({
		url:'/data/orgAction.do?action=loadJsonData',
		valueField:'id',
		textField:'text'
	});
	$('#groupId').combobox({
		url:'/data/dataGroupAction.do?action=loadJsonData',
		valueField:'id',
		textField:'text'
	});
</script>
</html>
