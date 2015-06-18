/**
 * <p>Title: Select封闭类 </p>
 */


var SubName;													//子Select 名称
var NodeXmlSrc;												//Xml文件地址
var First;													//是否是首个Select 与 NodeXmlSrc一起使用

var XmlObj;													//Xml对象
var XmlObj_array=[];

var SelectValue;												//默认选中值
var SelectText;												//默认选中文本

var LeftName;													//左边列表框名称
var RightName;													//右边列表框名称

var isAll;												//是否包括全部
var iIndex = null;
var isDoSelect;


$(document).ready(function () {
    $('select').each(function (i, obj) {
       // debugger;
        doInit(obj,i);
        $(obj).on('change',{obj:obj,i:i}, doChange);
    })

});


/**
 * 初始化
 */
function doInit(obj,k) {
    NodeXmlSrc = obj.getAttribute('NodeXmlSrc');
    console.log(NodeXmlSrc);
    First = obj.getAttribute('First');
    var xmlDoc;
    if (NodeXmlSrc != null && First == "true")											//第一个列表框
    {
        if (window.DOMParser) {
            var parser = new DOMParser();
            $.ajax({
                url: NodeXmlSrc, async: false, success: function (xml) {
                    xmlDoc = parser.parseFromString(xml, "text/xml");
                }
            });
        }
        else // Internet Explorer
        {
            xmlDoc = new ActiveXObject("Microsoft.XMLDOM");
            xmlDoc.async = false;
            xmlDoc.loadXML(NodeXmlSrc);
        }

        XmlObj = xmlDoc.documentElement;
        XmlObj_array[k]=XmlObj;
        obj.setAttribute('XmlObj',XmlObj);

        for (var i = obj.options.length - 1; i >= 0; i--)										//删除数据
        {
            obj.options[i] = null;
        }

        for (var i = 0; i < XmlObj.childNodes.length; i++)									//填充数据
        {
            if(XmlObj.childNodes[i].tagName=='item') {
                var labels = XmlObj.childNodes[i].getAttribute("text");
                var values = XmlObj.childNodes[i].getAttribute("value");
                obj.add(document.createElement("OPTION"));
                obj.options[i].text = labels;
                obj.options[i].value = values;
            }
        }
        setSelect(obj);
        doChange(obj,k);
    }
    else {
        setSelect(obj);
        doChange(obj,k);
    }
    return XmlObj;
}


/**
 * 设置默认选项
 * @return
 */
function setSelect(obj) {
    SelectText = obj.getAttribute('SelectText');
    SelectValue = obj.getAttribute('SelectValue');
    if (SelectText != null)															//默认选中文本
    {
        for (var i = 0; i < obj.options.length; i++) {
            if (obj.options[i].text == SelectText) {
                obj.options[i].selected = true;
            }
        }
    }

    if (SelectValue != null)															//默认选中值
    {
        for (var i = 0; i < obj.options.length; i++) {
            if (obj.options[i].value == SelectValue) {
                obj.options[i].selected = true;
            }
        }
    }


}

/**
 * 处理选项变化事件
 * @return
 */
function doChange(obj,k) {
    if(obj.target){
        obj = obj.target;
    }
    SubName = obj.getAttribute('SubName');
    try {
        if (SubName == null)															//没有下级Select
        {
            event.returnValue = false;
            return;
        }

        var subObj = $('#' + SubName)[0];									//下级Select


        if (subObj == null)															//下级Select对象不存在
        {
            event.returnValue = false;
            return;
        }

        var subXmlObj = XmlObj_array[k].childNodes[obj.selectedIndex];								//读取被选中的XML数据


        for (var i = subObj.options.length - 1; i >= 0; i--)								//删除子列表数据
        {
            subObj.options[i] = null;
        }

        $(subObj).unbind('change');												//去除响应改变事件
        for (var j = 0; j < subXmlObj.childNodes.length; j++)									//增加子列表数据
        {
            var labels = subXmlObj.childNodes[j].getAttribute("text");
            var values = subXmlObj.childNodes[j].getAttribute("value");
            subObj.add(document.createElement("OPTION"));
            subObj.options[j].text = labels;
            subObj.options[j].value = values;
        }
        $(subObj).on("change", doChange);												//增加响应改变事件
        subObj.setAttribute('XmlObj', subXmlObj);
        //subObj.XmlObj = subXmlObj;

        /*

         if (subXmlObj.childNodes.length==0)											//当子选项为0时，隐掉子列表
         {
         subObj.style.display ="none";
         }
         else
         {
         subObj.style.display ="";
         }
         */
        $(subObj).change();
        //subObj.fireEvent("onchange");												//触发响应改变事件

    }
    catch (e) {
        ;
    }

}

/**
 * 增加选项
 * sTyle right 向右边[rightNmae]Select增加选项 ,left 向左边[leftNmae]Select增加选项
 * @return
 */
function moveSelectedOption(sTyle, obj) {
    RightName = obj.getAttribute('RightName');
    LeftName = obj.getAttribute('LeftName');
    if (sTyle == "right") {
        var oSelect = $('#' + RightName)[0];
    }
    else {
        var oSelect = $('#' + LeftName)[0];
    }
    for (var i = 0; i < obj.options.length; i++) {
        if (obj.options[i].selected) {
            var sValue = obj.options[i].value;
            var sText = obj.options[i].text;
            var j = oSelect.options.length;
            oSelect.add(document.createElement("OPTION"));
            oSelect.options[j].text = sText;
            oSelect.options[j].value = sValue;
        }
    }
    for (var j = obj.options.length - 1; j >= 0; j--) {
        if (obj.options[j].selected) {
            obj.options[j] = null;
        }
    }
}

/**
 * 增加所有选项
 * sTyle right 向右边[rightNmae]Select增加选项 ,left 向左边[leftNmae]Select增加选项
 * @return
 */
function moveAllOption(sTyle, obj) {
    RightName = obj.getAttribute('RightName');
    LeftName = obj.getAttribute('LeftName');
    if (sTyle == "right") {
        var oSelect = $('#' + RightName)[0];
    }
    else {
        var oSelect = $('#' + LeftName)[0];
    }
    for (var i = 0; i < obj.options.length; i++) {
        var sValue = obj.options[i].value;
        var sText = obj.options[i].text;
        var j = oSelect.options.length;
        oSelect.add(document.createElement("OPTION"));
        oSelect.options[j].text = sText;
        oSelect.options[j].value = sValue;
    }
    for (var j = obj.options.length - 1; j >= 0; j--) {
        obj.options[j] = null;
    }
}

/**
 * 增加选项
 * sTyle right 向右边[rightNmae]Select增加选项 ,left 向左边[leftNmae]Select增加选项
 * @return
 */
function addSelectedOption(sTyle, obj) {
    RightName = obj.getAttribute('RightName');
    LeftName = obj.getAttribute('LeftName');
    var isHad = false;
    if (sTyle == "right") {
        var oSelect = $('#' + RightName)[0];
    }
    else {
        var oSelect = $('#' + LeftName)[0];
    }
    for (var i = 0; i < obj.options.length; i++) {
        if (obj.options[i].selected) {
            var sValue = obj.options[i].value;
            var sText = obj.options[i].text;
            isHad = false;
            for (var n = 0; n < oSelect.options.length; n++) {
                if (oSelect.options[n].value == sValue && oSelect.options[n].text == sText) {
                    isHad = true;
                    break;
                }
            }
            if (isHad) {
                break;
            }
            var j = oSelect.options.length;
            oSelect.add(document.createElement("OPTION"));
            oSelect.options[j].text = sText;
            oSelect.options[j].value = sValue;
        }
    }
}

/**
 * 增加所有选项
 * sTyle right 向右边[rightNmae]Select增加选项 ,left 向左边[leftNmae]Select增加选项
 * @return
 */
function addAllOption(sTyle, obj) {
    RightName = obj.getAttribute('RightName');
    LeftName = obj.getAttribute('LeftName');
    var isHad = false;
    if (sTyle == "right") {
        var oSelect = $('#' + RightName)[0];
    }
    else {
        var oSelect = $('#' + LeftName)[0];
    }
    for (var i = 0; i < obj.options.length; i++) {
        var sValue = obj.options[i].value;
        var sText = obj.options[i].text;
        for (var n = 0; n < oSelect.options.length; n++) {
            if (oSelect.options[n].value == sValue && oSelect.options[n].text == sText) {
                isHad = true;
                break;
            }
        }
        if (isHad) {
            break;
        }
        var j = oSelect.options.length;

        oSelect.add(document.createElement("OPTION"));
        oSelect.options[j].text = sText;
        oSelect.options[j].value = sValue;
    }
}

/**
 * 删除选项
 * @return
 */
function delSelectedOption(obj) {
    for (var j = obj.options.length - 1; j >= 0; j--) {
        if (obj.options[j].selected) {
            obj.options[j] = null;
        }
    }
}

/**
 * 删除所有选项
 * @return
 */
function delAllOption(obj) {

    for (var j = obj.options.length - 1; j >= 0; j--) {
        obj.options[j] = null;
    }
}

