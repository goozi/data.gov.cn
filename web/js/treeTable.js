var ktabletree, startrow, expancelevel, startcol, FilesDir;
$(document).ready(function() {
	ktabletree = $('table.listTree')[0];
	startrow = ktabletree.getAttribute('startrow');
	expancelevel = ktabletree.getAttribute('expancelevel');
	startcol = ktabletree.getAttribute('startcol');
	FilesDir = ktabletree.getAttribute('FilesDir');
	doInit();
});
/**
 * 初始化
 */
function doInit() {
	if (startrow == null)
		startrow = 1;
	if (expancelevel == null)
		expancelevel = 0;
	if (startcol == null)
		startcol = 0;

	ktabletree.style.display = "none";
	var rowNum = ktabletree.rows.length; // 表行数
	for (var i = startrow; i < rowNum; i++) {
		ktabletree.rows[i].className= "Row"+ktabletree.rows[i].getAttribute('level');
		if (parseInt(ktabletree.rows[i].getAttribute('level')) > expancelevel) {
			ktabletree.rows[i].style.display = "none";
		}

		if (ktabletree.rows[i].getAttribute('isLeaf') == "false") {
			if (parseInt(ktabletree.rows[i].getAttribute('level')) < expancelevel) {
				ktabletree.rows[i].cells[startcol].innerHTML = "<img src='"
						+ FilesDir
						+ "/images/open.jpg' border='0' style='cursor:hand'>"
						+ ktabletree.rows[i].cells[startcol].innerHTML;
				ktabletree.rows[i].setAttribute('isExpand','true');
			} else {
				ktabletree.rows[i].setAttribute('isExpand','false');
				ktabletree.rows[i].cells[startcol].innerHTML = "<img src='"
						+ FilesDir
						+ "/images/close.jpg' border='0'  style='cursor:hand'>"
						+ ktabletree.rows[i].cells[startcol].innerHTML;
			}
		} else {
			ktabletree.rows[i].cells[startcol].innerHTML = "<span style='width:14px;height:14px;font-size:12px;padding-left:3px;padding-top:1px;'>&nbsp;</span>"
					+ ktabletree.rows[i].cells[startcol].innerHTML;
		}

		ktabletree.rows[i].cells[startcol].innerHTML = ktabletree.rows[i].getAttribute('html')
				+ ktabletree.rows[i].cells[startcol].innerHTML;

	}

	doShow();

	//绑定将来动态创建的元素
	$('table.listTree').on('click','img', clickTbl);
	// attachEvent("onclick", clickTbl);
	ktabletree.style.display = "";
}

/**
 * 初始化
 */
function doShow() {
	var rowNum = ktabletree.rows.length; // 表行数
	var lastLevel = 0; // 最后级数

	for (var i = rowNum - 1; i >= startrow; i--) {
		if (parseInt(ktabletree.rows[i].getAttribute('level')) == lastLevel - 1) {
			expandChild(ktabletree.rows[i]);
			lastLevel = parseInt(ktabletree.rows[i].getAttribute('level'));
		}
		if (ktabletree.rows[i].getAttribute('isShow') == "true") {
			lastLevel = parseInt(ktabletree.rows[i].getAttribute('level'));
			ktabletree.rows[i].className='isSelected';
		}
	}
}

/*
 * Zerrion 2005-05-18 点击时进行排序
 * 
 */
function clickTbl() {
	var currObj = event.srcElement;
	if (currObj.tagName != 'IMG')
		return;

	if (currObj.src.indexOf("/images/close.jpg") == -1
			&& currObj.src.indexOf("/images/open.jpg") == -1)
		return;
	var currTr = currObj.parentNode.parentNode;
	expand(currTr);
}

function expandChild(currTr) {
	var rowNum = ktabletree.rows.length;
	if (currTr.getAttribute('isLeaf') != "false") {
		return;
	}
	var cellIndex = currTr.rowIndex;
	for (var i = cellIndex + 1; i < rowNum; i++) {
		if (parseInt(ktabletree.rows[i].getAttribute('level')) == parseInt(currTr.getAttribute('level')) + 1) {
			ktabletree.rows[i].style.display = "";
		} else if (parseInt(ktabletree.rows[i].getAttribute('level')) > parseInt(currTr.getAttribute('level')) + 1) {
			;
		} else {
			break;
		}
	}
	currTr.cells[startcol].innerHTML = currTr.cells[startcol].innerHTML
			.replace("/images/close.jpg", "/images/open.jpg");
	currTr.setAttribute('isExpand','true');
}

function expand(currTr) {
	var rowNum = ktabletree.rows.length;
	if (currTr.getAttribute('isLeaf') != "false") {
		return;
	}

	var cellIndex = currTr.rowIndex;

	if (currTr.getAttribute('isExpand') == 'false') {
		for (var i = cellIndex + 1; i < rowNum; i++) {
			if (parseInt(ktabletree.rows[i].getAttribute('level')) == parseInt(currTr.getAttribute('level')) + 1) {
				ktabletree.rows[i].style.display = "";
			} else if (parseInt(ktabletree.rows[i].getAttribute('level')) > parseInt(currTr.getAttribute('level')) + 1) {
				;
			} else {
				break;
			}
		}
		currTr.cells[startcol].innerHTML = currTr.cells[startcol].innerHTML
				.replace("/images/close.jpg", "/images/open.jpg");
	} else {
		for (var i = cellIndex + 1; i < rowNum; i++) {
			if (parseInt(ktabletree.rows[i].getAttribute('level')) > parseInt(currTr.getAttribute('level'))) {
				ktabletree.rows[i].style.display = "none";
				if (ktabletree.rows[i].getAttribute('isLeaf') == "false") {
					ktabletree.rows[i].setAttribute('isExpand','false');
					ktabletree.rows[i].cells[startcol].innerHTML = ktabletree.rows[i].cells[startcol].innerHTML
							.replace("/images/open.jpg", "/images/close.jpg");
				}
			} else {
				break;
			}
		}
		currTr.cells[startcol].innerHTML = currTr.cells[startcol].innerHTML
				.replace("/images/open.jpg", "/images/close.jpg");
	}

	currTr.setAttribute('isExpand',currTr.getAttribute('isExpand')=='true'?'false':'true');
}