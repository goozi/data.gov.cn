<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="/js/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="/style/carousel.css">
	<title>无标题文档</title>
	<STYLE>

		td {
			font-size: 12px;
		}

		.Menu {
			color: #02346E;
			cursor: hand;
			TEXT-ALIGN: center;
			VALIGN: bottom;
		}

		.currMenu {
			color: #02346E;
			cursor: hand;
			TEXT-ALIGN: center;
			VALIGN: bottom;
			background-image: url(images/simple/navka.jpg);
			background-repeat: no-repeat;
			background-position: bottom;
			font-weight: bold
		}

		.currItem {
			color: #FF8400;
		}

		.Item {
			color: #02346E;
		}
	</STYLE>
	<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="../js/topMenu.js"></script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	   align="center">
	<tr>
		<td width="1000"><img src="images/simple/header.png"
							 width="1000" height="73" border="0"></td>
		<td style="background-color: #2ca9ec">
			<div class="assist">
				<div class="btn-group assist-btn" role="group" aria-label="...">
					<button type="button" class="btn btn-default" onclick="parent.location.href='/index.jsps'">首页</button>
					<button id="logout" type="button" class="btn btn-default">退出</button>
				</div>
			</div>
		</td>
	<tr>
</table>
<table width="100%" height="56" border="0" cellpadding="0"
	   cellspacing="0">
	<tr>

		<td valign="bottom" background="images/simple/bannerbg.jpg"
			style="background-position: bottom; background-repeat: repeat-x">
			<table width="100%" height="100%" border="0" cellpadding="0"
				   cellspacing="0">
				<tr>
					<td height="29" background="images/simple/navkabg.jpg"><div
							id="Outlook" NodeXmlSrc="base/menuAction.do?action=createMenu"></div></td>
				</tr>
				<tr>
					<td height="31" background="images/simple/bannerbg2.jpg"
						id="subMenu"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>

<script language="JavaScript">

	$(document).ready(function(){
		$.get('base/menuAction.do?action=createMenu',function(xml){
			doInit(xml);
		});
	});

	$('#logout').on('click',function(){
		parent.location.href='loginAction.do?action=logout';
	});

	//显示项目管理模块
	function showProjectPage() {
		document.all.showProject.click();
	}

	function changeColor(n) {
		//alert(n);
		var objects = $("#stool")[0];
		for ( var i = 0; i < objects.length; i++) {
			objects[i].className = "orangeStyle";
		}
		objects[n].className = "orangeStyleFocus";

	}
	//换页操作
	function changePage(n) {
		var ary = new Array(new Array(), new Array(), new Array(), new Array());

		ary[0][0] = "";
		ary[1][0] = "0,*";

		ary[0][1] = "<table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td id='stool' onClick='changeColor(0)' class='orangeStyle' style='cursor:hand'>系统状态管理 </td><td id='stool' onClick='changeColor(1)' style='cursor:hand'>系统参数管理  </td><td id='stool' onClick='changeColor(2)' style='cursor:hand'>在线用户管理  </td><td id='stool' onClick='changeColor(3)' style='cursor:hand'>行政区划管理  </td><td id='stool' onClick='changeColor(4)' style='cursor:hand'>系统专业管理 </td><td id='stool' onClick='changeColor(5)' style='cursor:hand'>系统日志管理  </td><td id='stool' onClick='changeColor(6)' style='cursor:hand'>系统环境设置</td></tr></table>"; //二级菜单
		ary[1][1] = "0,*"

		ary[0][2] = "about:blank";
		ary[1][2] = "215,*"

		ary[0][3] = "about:blank";
		ary[1][3] = "0,*"

		ary[0][4] = "about:blank";
		ary[1][4] = "215,*"

		ary[0][5] = "about:blank";
		ary[1][5] = "0,*"

		ary[0][6] = "about:blank";
		ary[1][6] = "215,*"

		ary[0][7] = "about:blank";
		ary[1][7] = "0,*"

		var objects = $("#tool")[0];
		var fontObject = $("#checkFont")[0];//改变字体颜色
		for ( var i = 0; i < objects.length; i++) {
			objects[i].className = "tmpStyle";
			objects[i].style.backgroundImage = 'url(none)';
			objects[i].vAlign = "bottom";
			//fontObject[i].color="#000000";
		}
		objects[n].className = "tmpStyleFocus";
		objects[n].style.backgroundImage = 'url(images/navka.jpg)';
		objects[n].vAlign = "bottom";
		//fontObject[n].color="#red";
		$("#tooltext").html(ary[0][n]);
		//parent.mainFrameSet.cols   =  ary[1][n];
		//if (objects[n].leftSrc!=null) parent.frames["left"].location=objects[n].leftSrc;
		//if (objects[n].rightSrc!=null) parent.frames["main"].location=objects[n].rightSrc;
	}
</script>