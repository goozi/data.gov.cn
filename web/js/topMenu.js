var xmlObj; // XML对象
var currMenu = -1;
var currItem = -1;

/**
 * 初始化菜单框
 */
function doInit(NodeXmlSrc) {
	var html = "";
	xmlObj = $($.parseXML(NodeXmlSrc)).children('tree:eq(0)');
	html = "<table height='25' cellSpacing=1 cellPadding=0  border=0><tr align='center'><td width='10'></td>";
	xmlObj
			.children('item')
			.each(
					function(i, item) {
						if (i == 0) {
							html += "<td width='100' valign='bottom' class='currMenu' id='txtMenu"
									+ i
									+ "' style='CURSOR: pointer' onClick='ClickMenu("
									+ i
									+ ")'>"
									+ $(item).attr("Title")
									+ "</td>";
						} else {
							html += "<td width='100' valign='bottom' class='Menu' id='txtMenu"
									+ i
									+ "' style='CURSOR: pointer' onClick='ClickMenu("
									+ i
									+ ")'>"
									+ $(item).attr("Title")
									+ "</td>";
						}
					});
	html += "</tr>";
	html += "</table>";

	$('#Outlook').html(html);

	ClickMenu(0);

}

/*
 * 标签按钮点击响应事件
 * 
 */
function ClickMenu(n) {
	if (currMenu == n)
		return;
	if (currMenu != -1) {
		$("#txtMenu" + currMenu).attr('class', 'Menu');
	}
	$("#txtMenu" + n).attr('class', 'currMenu');
	currMenu = n;
	createLeftMenu(n);
	return;
}

/*
 * 创建左边菜单
 * 
 */
function createLeftMenu(i) {
	var html = "<table  border='0' cellspacing='0' cellpadding='0'><tr>";

	var rightMenu = $("#subMenu");
	var url = "";
	var frameName = "";

	var subObj = xmlObj.children('item:eq(' + i + ')');

	subObj
			.children('item')
			.each(
					function(j, item) {
						if (j == 0) {
							url = $(item).attr("Href");
							frameName = $(item).attr("Target");
							html += "<td width='75' class='currItem' id='tdItem"
									+ j
									+ "' style='cursor:pointer;padding-left:20px;' onClick=\"ClickItem("
									+ j + ",'" + $(item).attr("Href") + "','"
									+ $(item).attr("Target") + "')\" >"
									+ $(item).attr("Title") + "</td>";
						} else {
							html += "<td width='75' class='Item' id='tdItem"
									+ j
									+ "' style='cursor:pointer;padding-left:20px;' onClick=\"ClickItem("
									+ j + ",'" + $(item).attr("Href") + "','"
									+ $(item).attr("Target") + "')\" >"
									+ $(item).attr("Title") + "</td>";
						}
					})

	html += "</tr></table>";

	rightMenu.html(html);
	currItem = -1;
	ClickItem(0, url, frameName);
}

/*
 * 二级菜单点击事件
 * 
 */
function ClickItem(n, url, frameName) {
	if (currItem == n)
		return;

	try {
		$("#tdItem" + currItem).attr('class', 'Item');
	} catch (exception) {
	}

	$("#tdItem" + n).attr('class', 'currItem');
	parent.frames[frameName].location = url;

	currItem = n;

}
