
var Check,Change;
var oFirstNull;														//第一个为空对象
var elements = $('form input,form select');

$('input').on('keydown',doKeydown);
$('form').on('submit',goSubmit);

/**
* 处理按键事件（以重载方式，屏蔽回车键）
*/
function doKeydown()
{	
	if (event.keyCode==13)
	{
		if (event.srcElement.type=="text"||event.srcElement.type=="password")
		{
			event.returnValue =false;
		}		
	}
}


/**
* 表单提交方法
*/
function doSubmit()
{
	if (doCheck_()=="ERROR")
	{
		return;
	}
	else if (doCheck_()=="NULL")
	{
		showNull(oFirstNull);
		oFirstNull.focus();
		return;		
	}

	if (Change=="true")
	{
		changeChar();		//替换特殊字符
	}	
	this.submit();
}

/**
* 处理提交事件
*/
function goSubmit()
{
	if (doCheck_()=="ERROR")
	{
		event.returnValue = false;
		return;
	}
	else if (doCheck_()=="NULL")
	{
		showNull(oFirstNull);
		oFirstNull.focus();
		event.returnValue = false;
		return;		
	}

	if (Change=="true")
	{
		changeChar();		//替换特殊字符
	}	
	event.returnValue = true;
	
}

/**
* 对表单里的控件符合性进行检查
*/
function doCheck()
{
	if (doCheck_()=="ERROR")
	{
		return false;
	}
	else if (doCheck_()=="NULL")
	{
		showNull(oFirstNull);
		oFirstNull.focus();
		return false;		
	}

	return true;
}


/**
* 对表单对象进行数据检测
* return   ERROR:输入框类型错误 ; NULL:输入框为空错误; TRUE:正确
*/
function doCheck_()
{
	var isError=false;
	var isNull=false;
	if (Check=="true")
	{
		var j=0
		elements.each(function(i,obj){
			if (obj.IsError=="true")
			{
				isError=true;
			}
			if (obj.getAttribute("NullAble")=="false")						//验证是否为空
			{
				if (isNull(obj.value))
				{
					if (j==0) oFirstNull=obj;
					isNull=true;
					j++;
				}
			}
		});
	}
	if (isError)
	{
		return "ERROR";
	}

	if (isNull)
	{
		return "NULL";
	}
	return "TRUE";
}

/**
* 对表单对象进行特殊字符串替换
*/
function changeChar()
{
	elements.each(function(i,obj){
		if (obj.type=="text") obj.value=html2Input(obj.value);
		else if (obj.type=="textarea") obj.value=html2Textarea(obj.value);
	});
}

/*
 *特殊字符转换
 */
function html2Input(html)
{    
    var sValue=html.replace(/"/g,"″");
	return sValue;
}

/*
 *特殊字符转换
 */
function html2Textarea(html)
{
    var sValue=html.replace(/</g,"〈");
    sValue=sValue.replace(/>/g,"〉");
    sValue=sValue.replace(/"/g,"″");
	return sValue;
}



function doSend()
{
	if (doCheck_()=="ERROR")
	{
		return;
	}
	else if (doCheck_()=="NULL")
	{
		showNull(oFirstNull);
		oFirstNull.focus();
		return;		
	}

	if (Change=="true")
	{
		changeChar();		//替换特殊字符
	}	
	
	var query_string='';
    var and='';
	elements.each(function(i,obj){
		var e=obj;
		if (e.name)
		{
			if (e.type=='select-one')
			{
				var element_value=e.options[e.selectedIndex].value;
			}
			else if (e.type=='select-multiple')
			{
				for (var n=0;n<e.length;n++)
				{
					var op=e.options[n];
					if (op.selected)
					{
						query_string+=and+e.name+'='+ str2Url(op.value);
						and="&"
					}
				}
				return true;
			}
			else if (e.type=='checkbox' || e.type=='radio')
			{
				if (e.checked==false)
				{
					return true;
				}
				element_value=e.value;
			}
			else if (typeof e.value != 'undefined')
			{
				element_value=e.value;
			}
			else
			{
				return true;
			}
			query_string += and + e.name + '=' + str2Url(element_value);
			and="&"
		}
	});
	if (this.action.indexOf("?")!=-1)
	{
		document.location.href=this.action + "&" + query_string;
	}
	else
	{
		document.location.href=this.action + "?" + query_string;
	}    
}

