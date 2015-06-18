$(document).ready(function () {
    var temp_iframe = "<iframe id='htc_body_frame_load' src='about:blank' name='htc_body_frame_load' frameborder='0'  scrolling=no style='top:0px;left:0px;HEIGHT: 100px; WIDTH: 250px;display:none;z-index:1000; position:absolute;'></iframe> <iframe id='htc_body_frame_null' src='about:blank' name='htc_body_frame_null' frameborder='0'  scrolling=no style='top:0px;left:0px;HEIGHT: 34px; WIDTH: 149px;display:none;z-index:1000; position:absolute;'></iframe> <iframe id='htc_body_frame_message' src='about:blank' name='htc_body_frame_message' frameborder='0'  scrolling=no style='top:0px;left:0px;display:none;z-index:1000; position:absolute;'></iframe>";
    $(temp_iframe).prependTo('body');
    doInit_body();
});
var kingtopMessage = null;
var kingtopLoad = null;
var kingtopNull = null;
var kingtopMessageWin = null;
var kingtopNullWin = null;
var kingtopLoadWin = null;

var kingtopDate = null;
var kingtopDateWin = null;

var isWinComplete = false;

var isCreateDateFrame = false;

var m_xmlhttp = null;
var oXmlHttp = null;
var oXmlDom = null;

var sErrorByLine = "你现在处于脱机状态,请联机后再试!";
var sErrorByServer = "服务器没有响应，请重新连接!";

var FilesDir = "";


/**
 * 初始创建信息提示层
 */
function doInit_body() {


    $(document).on('click', doClick);										//失去焦点事件

    createMessage();													//创建信息提示对象
    createNull();														//创建为空提示对象
    createLoad();														//创建等待提示对象

    //element.document.body.oncontextmenu=new Function("return false");

    _createXmlDom();													//创建XmlDom对象
    _createXmlHttp();													//创建XmlHttp对象
}

function doClick() {
    if (event.srcElement.type == "select-one" || event.srcElement.type == "checkbox" || event.srcElement.type == "radio")
        closeMessage();									//关闭提示
}


/**
 * 创建信息提示对象--(要求IE5.0以上,可遮挡住SELECT组件)
 * @return
 */
function createMessage() {
    try {
        if (kingtopMessage == null) {
            kingtopMessage = $("#htc_body_frame_message")[0];
            //element.document.body.insertAdjacentElement("afterBegin",kingtopMessage);

            if (kingtopMessage.contentWindow)	//ie5.5
            {
                kingtopMessageWin = kingtopMessage.contentWindow;
                isWinComplete = true;
            }
            else {
                kingtopMessageWin = window.open('about:blank', kingtopMessage.name);
                isWinComplete = true;
            }
        }
    }
    catch (exception) {
    }

}


/**
 * 创建为空提示对象--(要求IE5.0以上,可遮挡住SELECT组件)
 * @return
 */
function createNull() {

    if (kingtopNull == null) {
        kingtopNull = $("#htc_body_frame_null");
        //insertAdjacentElement("afterBegin",kingtopNull);

        if (kingtopNull.contentWindow)	//ie5.5
        {
            kingtopNullWin = kingtopNull.contentWindow;
        }
        else {
            kingtopNullWin = window.open('about:blank', kingtopNull.name);
        }
    }

}


/**
 * 显示为空提示
 * @param obj 激活窗口的输入框对象
 * @return
 */
function showNull(obj) {
    if (obj.ShowNullStar == "false") {
        if (clientWidth < obj.getBoundingClientRect().right + scrollLeft + 10 + 149) {
            sHTML = "<IMG style='position:absolute;left:0;top:0;'  border=0 src='" + FilesDir + "/htc/images/null_noStar_right.gif' >";
            kingtopNull.style.left = obj.getBoundingClientRect().right + scrollLeft - 149;
        }
        else {
            sHTML = "<IMG style='position:absolute;left:0;top:0;'  border=0 src='" + FilesDir + "/htc/images/null_noStar.gif' >";
            kingtopNull.style.left = obj.getBoundingClientRect().right + scrollLeft + 10;
        }
    }
    else {
        if (clientWidth < obj.getBoundingClientRect().right + scrollLeft + 10 + 149) {
            sHTML = "<IMG style='position:absolute;left:0;top:0;'  border=0 src='" + FilesDir + "/htc/images/null_right.gif' >";
            kingtopNull.style.left = obj.getBoundingClientRect().right + scrollLeft - 149;
        }
        else {
            sHTML = "<IMG style='position:absolute;left:0;top:0;'  border=0 src='" + FilesDir + "/htc/images/null.gif' >";
            kingtopNull.style.left = obj.getBoundingClientRect().right + scrollLeft + 10;
        }
    }

    kingtopNullWin.document.write(sHTML);

    kingtopNull.style.top = obj.getBoundingClientRect().bottom + scrollTop - 44;

    kingtopNull.style.display = "";
    window.setTimeout("document.body.closeNull();", 2000, "JScript");			//2秒后关闭
}


/**
 * 关闭为空提示
 * @return
 */
function closeNull() {
    kingtopNull.style.display = "none";
}


/**
 * 显示帮助提示
 * @param MessageTitle  提示文字
 * @param MessageWidth    提示宽度象素    [可选]
 * @param obj            激活窗口的输入框对象
 * @return
 */

function showMessage() {
    var argv = showMessage.arguments;

    if (argv.length == 3) {
        showMessage_Width(argv[0], argv[1], argv[2]);						//显示帮助提示--(设定宽度)
    }
    else if (argv.length == 2) {
        showMessage_NoWidth(argv[0], argv[1]);										//显示帮助提示
    }
}

/**
 * 显示帮助提示--(设定宽度)
 * @param MessageTitle  提示文字
 * @param MessageWidth    提示宽度象素
 * @param obj            激活窗口的输入框对象
 * @return
 */
function showMessage_Width(MessageTitle, MessageWidth, obj) {
    if (!isWinComplete) {
        return;
    }
    var hang;
    if (MessageWidth == 0) {
        hang = 1;
        MessageWidth = getLength(MessageTitle) * 6 + 10;
    }
    else {
        hang = eval(6 * getLength(MessageTitle) / MessageWidth);		//计算根据设定宽值计算需要多少行
        hang = Math.ceil(hang);
    }


    var gao = hang * 16;

    var sHTML = "<div style='position:absolute;left:0;top:0;FONT-SIZE:11px;LINE-HEIGHT:150%;background-color:#F4F5F2;color:black;border:1 solid black;width:" + MessageWidth + ";height:" + gao + ";'>" + MessageTitle + "</div>";

    kingtopMessageWin.document.write(sHTML);

    if (clientWidth < obj.getBoundingClientRect().left + scrollLeft + MessageWidth) {
        kingtopMessage.style.left = obj.getBoundingClientRect().right + scrollLeft - MessageWidth - 2;
    }
    else {
        kingtopMessage.style.left = obj.getBoundingClientRect().left + scrollLeft;
    }

    if (clientHeight < obj.getBoundingClientRect().bottom + scrollTop + gao) {
        kingtopMessage.style.top = obj.getBoundingClientRect().top + scrollTop - (gao + 4);
    }
    else {
        kingtopMessage.style.top = obj.getBoundingClientRect().bottom + scrollTop - 2;
    }

    kingtopMessage.style.width = MessageWidth;
    kingtopMessage.style.height = gao + 2;

    kingtopMessage.style.display = "";

}

/**
 * 显示帮助提示
 * @param MessageTitle  提示文字
 * @param obj 激活窗口的输入框对象
 * @return
 */
function showMessage_NoWidth(MessageTitle, obj) {

    var MessageWidth = getLength(MessageTitle) * 6 + 10;
    var hang = 1;
    var gao = hang * 16;

    var sHTML = "<div style='position:absolute;left:0;top:0;FONT-SIZE: 11px;LINE-HEIGHT: 150%;background-color:#F4F5F2;color:red;border:1 solid black;width:" + MessageWidth + ";height:" + gao + ";'>" + MessageTitle + "</div>";

    kingtopMessageWin.document.write(sHTML);

    if (clientWidth < obj.getBoundingClientRect().left + scrollLeft + MessageWidth) {
        kingtopMessage.style.left = obj.getBoundingClientRect().right + scrollLeft - MessageWidth - 2;
    }
    else {
        kingtopMessage.style.left = obj.getBoundingClientRect().left + scrollLeft;
    }

    if (clientHeight < obj.getBoundingClientRect().bottom + scrollTop + gao) {
        kingtopMessage.style.top = obj.getBoundingClientRect().top + scrollTop - (gao + 4);
    }
    else {
        kingtopMessage.style.top = obj.getBoundingClientRect().bottom + scrollTop - 2;
    }

    kingtopMessage.style.width = MessageWidth;
    kingtopMessage.style.height = gao + 2;


    kingtopMessage.style.display = "";
}


/**
 * 关闭帮助提示
 * @return
 */
function closeMessage() {
    kingtopMessage.style.display = "none";
}


/**
 * 创建等待对象--(要求IE5.0以上,可遮挡住SELECT组件)
 * @param img Loading图形位置
 * @param title 等待标题
 * @return
 */
function createLoad() {
    if (kingtopLoad == null) {
        kingtopLoad = $('#htc_body_frame_load')[0];
        //element.document.body.insertAdjacentElement("afterBegin",kingtopLoad);

        if (kingtopLoad.contentWindow)	//ie5.5
        {
            kingtopLoadWin = kingtopLoad.contentWindow;
        }
        else {
            kingtopLoadWin = window.open('about:blank', kingtopLoad.name);

        }
    }
}


/**
 * 居中显示等待图层
 * @return
 */
function showLoad() {
    var sHTML = "<DIV style='BORDER-BOTTOM: #999999 1px solid; BORDER-LEFT: #999999 1px solid; BORDER-RIGHT: #999999 1px solid; BORDER-TOP: #999999 1px solid; HEIGHT: 100px; LEFT: 0px; POSITION: absolute; TOP: 0px; WIDTH: 250px;'>";
    sHTML = sHTML + "<TABLE border=0 cellPadding=0 cellSpacing=0 height='100%' width='100%'>";
    sHTML = sHTML + "<TBODY><TR><TD align=middle style='BACKGROUND-COLOR: #ffffff; FONT-SIZE: 12px; LINE-HEIGHT: 200%'>";
    sHTML = sHTML + "<IMG border=0 src='" + FilesDir + "/htc/images/loading.gif' ><BR>";
    sHTML = sHTML + "<SPAN id=rem><font color='#000000'>正在进行操作，请等候</font>.</SPAN></TD>";
    sHTML = sHTML + "</TR></TBODY></TABLE></DIV>";
    var width = 250
    var height = 100
    var aw = clientWidth;
    var ah = clientHeight;
    var xc = (aw - width) / 2 + scrollLeft;
    var yc = (ah - height) / 2 + scrollTop - 10;
    kingtopLoadWin.document.write(sHTML);
    kingtopLoad.style.left = xc;
    kingtopLoad.style.top = yc;
    kingtopLoad.style.display = "";

}


/**
 * 关闭等待图层
 * @return
 */
function closeLoad() {
    kingtopLoad.style.display = "none";
}


//============================================以下为公共方法==========================================

/**
 * 获得文本字节数
 * sText 欲统计的字符串
 * @return 字节数
 */
function getLength(sText) {
    var intByteLen = 0;
    var chrAti;
    for (var i = 0; i < sText.length; i++) {
        chrAti = sText.charAt(i);
        if (escape(chrAti).length == (chrAti.length) * 6)
            intByteLen += 2;
        else
            intByteLen += 1;
    }
    return intByteLen;
}

/**
 * 创建居中窗口
 * @param url 打开网页地址
 * @param name 网页标题
 * @param height 网页高度
 * @param width 网页宽度
 * @return
 */
function openCenter(url, name, height, width) {
    var str = "height=" + height + ",innerHeight=" + height;
    str = str + ",width=" + width + ",innerWidth=" + width;
    if (window.screen) {
        var ah = screen.availHeight - 30;
        var aw = screen.availWidth - 10;
        var xc = (aw - width) / 2;
        var yc = (ah - height) / 2;
        str = str + ",left=" + xc + ",screenX=" + xc;
        str = str + ",top=" + yc + ",screenY=" + yc;
    }
    str = str + ",status=no,resizable=1,toolbar=no,menubar=no,scrollbars=yes,location=no";
    return window.open(url, name, str);
}


/**
 * 弹出模式对话框
 * @param url 打开网页地址
 * @param height 网页高度
 * @param width 网页宽度
 * @return
 */
function openDialog(url, height, width) {
    var xml = window.showModalDialog(url, "", "dialogHeight:" + height + "px;dialogWidth:" + width + "px;center:yes;status:no");
    //var xml = window.open(url, "", "height:" + height + "px,width:" + width + "px,center:yes,status:no")
    return xml;
}

/* 
 *把文本转化成Url可接收的字节
 *str 待转化的字符
 */
function str2Url(str) {
    var sValue = str.replace(/%/g, "%25");
    sValue = sValue.replace(/#/g, "%23");
    sValue = sValue.replace(/\?/g, "%3F");
    sValue = sValue.replace(/=/g, "%3D");
    sValue = sValue.replace(/&/g, "%26");
    sValue = sValue.replace(/"/g, "″");
    return sValue;
}


/**
 * 验证是否为空
 * 空返回true,否则false
 */
function isNull(str) {
    if ((BASEtrim(str) == ""))
        return true;
    else
        return false;
}


//============================================以下为XmlHttp和XmlDoc相关方法==========================================


/**
 * 发送数据到服务器--Post方式
 * @param sUrl 打开网页地址
 * @param sPara 传送参数
 * @return    返回服务器反映的数据
 */

function sendPostHttp(sUrl, sPara) {
    var returnValue = "";
    if (navigator.onLine == false) {
        alert(sErrorByLine);
        return "";
    }
    oXmlHttp.Open("POST", sUrl, false);
    try {
        oXmlHttp.Send(sPara);
    }
    catch (exception) {
        alert(sErrorByServer);
        return "";
    }
    try {
        returnValue = oXmlHttp.responseText
    }
    catch (exception) {
        if (exception.description == '系统错误: -1072896748。') {
            returnValue = ""
        }
    }
    return returnValue
}

/**
 * 发送数据到服务器--Get方式
 * @param sUrl 打开网页地址
 * @param sPara 传送参数
 * @return    返回服务器反映的数据
 */

function sendGetHttp(sUrl) {
    var returnValue = "";
    if (navigator.onLine == false) {
        alert(sErrorByLine);
        return "";
    }
    oXmlHttp.Open("GET", sUrl, false);
    try {
        oXmlHttp.Send();
    }
    catch (exception) {
        alert(sErrorByServer);
        return "";
    }
    try {
        returnValue = oXmlHttp.responseText
    }
    catch (exception) {
        if (exception.description == '系统错误: -1072896748。') {
            returnValue = "";
        }
    }
    return returnValue
}

/**
 * 发送数据到服务器--Get方式,浏览器处于闲状态、服务器响应完成后调用
 * @param sUrl 打开网页地址
 * @return    返回服务器反映的数据
 */
function sendGetHttp_Load(sUrl) {
    showLoad();
    if (navigator.onLine == false) {
        return "你现在处于脱机状态,请联机后再试!"
    }
    m_xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    m_xmlhttp.Open("GET", sUrl, true);
    m_xmlhttp.onreadystatechange = sendGetHttp_finish;
    try {
        m_xmlhttp.Send();
    }
    catch (exception) {
        alert("服务器忙!")
    }
}

function sendGetHttp_finish() {
    if (m_xmlhttp.readyState == 4) {
        closeLoad();
        try {
            SendGet_finish();
        }
        catch (exception) {
            ;
        }
    }
}

function getXmlDom() {
    return oXmlDom;
}

function getXmlHttp() {
    return oXmlHttp;
}


//==================================================以下为私有方法============================================

function _createXmlHttp() {
    var sXmlName = new Array("Microsoft.XMLHTTP", "Msxml2.XMLHTTP.4.0", "Msxml2.XMLHTTP");
    var j = -1;
    for (var i = 0; i < sXmlName.length; i++) {
        try {
            new ActiveXObject(sXmlName[i]);
            j = i;
            break;
        }
        catch (e) {
            ;
        }
    }
    if (j != -1) {
        oXmlHttp = new ActiveXObject(sXmlName[j]);
    }
    else {
        if (window.XMLHttpRequest) {
            oXmlHttp = new XMLHttpRequest();
        }
        //oXmlHttp=null;
    }
}


function _createXmlDom() {
    var sXmlName = new Array("Microsoft.XMLDOM", "Msxml2.DOMDocument.4.0", "Msxml2.DOMDocument");
    var j = -1;
    for (var i = 0; i < sXmlName.length; i++) {
        try {
            new ActiveXObject(sXmlName[i]);
            j = i;
            break;
        }
        catch (e) {
            ;
        }
    }
    if (j != -1) {
        oXmlDom = new ActiveXObject(sXmlName[j]);
    }
    else {
        oXmlDom = null;
        //兼容 FF
        //if (document.implementation && document.implementation.createDocument) {
        //    oXmlDom = document.implementation.createDocument("", "", null);
        //}
    }
}


/**
 * 字符清除空格
 * 返回清除后的字符串
 */
function BASEtrim(str) {
    if (str != "") {
        lIdx = 0;
        rIdx = str.length;
        if (BASEtrim.arguments.length == 2)
            act = BASEtrim.arguments[1].toLowerCase();
        else
            act = "all"
        for (var i = 0; i < str.length; i++) {
            thelStr = str.substring(lIdx, lIdx + 1);
            therStr = str.substring(rIdx, rIdx - 1);
            if ((act == "all" || act == "left") && thelStr == " ") {
                lIdx++;
            }
            if ((act == "all" || act == "right") && therStr == " ") {
                rIdx--;
            }
        }
        if (document.all == null) {
            str = str.substring(lIdx, rIdx);
        }
        else {
            str = str.slice(lIdx, rIdx);
        }
    }
    return str;
}

//============================================以下为水利系统特有方法==========================================


/**
 * 选择所有的复选框
 * object 复选框对象
 */
function selectAll(object) {

    if (!object) return;
    if (isNaN(object.length)) object.checked = true;
    else {
        for (var i = 0; i < object.length; i++) {
            object[i].checked = true;
        }
    }
}

/**
 * 反选复选框
 * object 复选框对象
 */
function inverse(object) {

    if (!object) return;
    if (isNaN(object.length)) object.checked = !object.checked;
    else {
        for (var i = 0; i < object.length; i++) {
            object[i].checked = !object[i].checked;
        }
    }
}


/**
 * 编辑选中记录
 * object 复选框对象
 */
function editData() {
    var argv = editData.arguments;

    if (argv.length == 2) {
        editData_(argv[0], argv[1]);
    }
    else if (argv.length == 4) {
        editData_open(argv[0], argv[1], argv[2], argv[3]);
    }
}


/**
 * 编辑选中记录
 * object 复选框对象
 */
function editData_(object, url) {

    if (!object) return;

    var j = 0, value;

    if (object.checked)//单个复选框时
    {
        j++;
        value = object.value;
    }
    else {
        for (var i = 0; i < object.length; i++) {

            if (object[i].checked) {
                j++;
                value = object[i].value;
                if (j > 1) {
                    alert("一次只能操作一条记录，您选择了多条记录，请重新选择！");
                    return;
                }
            }
        }
    }
    if (j == 0) {
        alert("请选择一条记录进行操作！");
        return;
    }
    else {
        location.href = url + value;
    }
}

/**
 * 编辑选中记录
 * object 复选框对象
 */
function editData_open(object, url, height, width) {

    if (!object) return;

    var j = 0, value;

    if (object.checked)//单个复选框时
    {
        j++;
        value = object.value;
    }
    else {
        for (var i = 0; i < object.length; i++) {

            if (object[i].checked) {
                j++;
                value = object[i].value;
                if (j > 1) {
                    alert("一次只能操作一条记录，您选择了多条记录，请重新选择！");
                    return;
                }
            }
        }
    }
    if (j == 0) {
        alert("请选择一条记录进行操作！");
        return;
    }
    else {
        openCenter(url + value, '', height, width)
    }
}

/**
 * 删除选中目标
 * object 复选框对象
 */
function deleteData(object, url) {

    if (!object) return false;

    var j = 0, value = "";

    if (object.checked) {
        j++;
        value += "&idArray=" + object.value;
    }
    else {
        for (var i = 0; i < object.length; i++) {

            if (object[i].checked) {
                j++;
                value += "&idArray=" + object[i].value;

            }
        }
    }

    if (j == 0) {
        alert("请选择记录进行删除！");
        return false;
    }
    else {
        if (confirm('您确定删除选中的记录，记录一经删除将不可恢复？') == true) {
            sendGetHttp(url + value);
            return true;
        }
        else return false;
    }
}

/**
 * 设置选中目标属性
 * object 复选框对象
 */
function setupData(object, url) {

    if (!object) return false;

    var j = 0, value = "";

    if (object.checked) {
        j++;
        value += "&idArray=" + object.value;
    }
    else {
        for (var i = 0; i < object.length; i++) {

            if (object[i].checked) {
                j++;
                value += "&idArray=" + object[i].value;

            }
        }
    }

    if (j == 0) {
        alert("请选择记录进行操作！");
        return false;
    }
    else {
        //sendGetHttp(url + value);
        $.get(url + value);
        return true;
    }
}

/**
 * 选择用户
 * @param url 打开网页地址
 * @param height 网页高度
 * @param width 网页宽度
 * @return
 */
function selectUser(url, height, width, userNameObj, userIdObj) {
    var userNames = document.getElementById(userNameObj).value;
    var userIds = document.getElementById(userIdObj).value;
    url += "?userNames=" + userNames + "&userIds=" + userIds;
    var sXml = openDialog(url, height, width);
    if (sXml) {
        //oXmlDom.loadXML(sXml);

        document.getElementById(userNameObj).value = $($.parseXML(sXml)).find('node:eq(0)').text();
        document.getElementById(userIdObj).value = $($.parseXML(sXml)).find('node:eq(1)').text();
    }
}

/*
 * 选择用户--保健对象
 * @param url 打开网页地址
 * @param height 网页高度
 * @param width 网页宽度
 * @param type 类别，
 * @return
 */
function selectAllUser(url, height, width, userNameObj, userIdObj, type) {

    var userNames = document.getElementById(userNameObj).value;
    var userIds = document.getElementById(userIdObj).value;
    var types = document.getElementById(type).value;

    url += "?userNames=" + userNames + "&userIds=" + userIds + "&types=" + types;

    var sXml = openDialog(url, height, width);
    if (sXml) {
        if (oXmlDom == null) {
            var parser = new DOMParser();
            oXmlDom = parser.parseFromString(sXml, "text/xml");
        } else {
            oXmlDom.loadXML(sXml);
        }

        document.getElementById(userNameObj).value = oXmlDom.documentElement.childNodes(0).text;
        document.getElementById(userIdObj).value = oXmlDom.documentElement.childNodes(1).text;
        document.getElementById(type).value = oXmlDom.documentElement.childNodes(2).text;
    }
}

