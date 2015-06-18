
var Check,Change;
var oFirstNull;														//��һ��Ϊ�ն���
var elements = $('form input,form select');

$('input').on('keydown',doKeydown);
$('form').on('submit',goSubmit);

/**
* �������¼��������ط�ʽ�����λس�����
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
* ���ύ����
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
		changeChar();		//�滻�����ַ�
	}	
	this.submit();
}

/**
* �����ύ�¼�
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
		changeChar();		//�滻�����ַ�
	}	
	event.returnValue = true;
	
}

/**
* �Ա���Ŀؼ������Խ��м��
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
* �Ա�����������ݼ��
* return   ERROR:��������ʹ��� ; NULL:�����Ϊ�մ���; TRUE:��ȷ
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
			if (obj.getAttribute("NullAble")=="false")						//��֤�Ƿ�Ϊ��
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
* �Ա�������������ַ����滻
*/
function changeChar()
{
	elements.each(function(i,obj){
		if (obj.type=="text") obj.value=html2Input(obj.value);
		else if (obj.type=="textarea") obj.value=html2Textarea(obj.value);
	});
}

/*
 *�����ַ�ת��
 */
function html2Input(html)
{    
    var sValue=html.replace(/"/g,"��");
	return sValue;
}

/*
 *�����ַ�ת��
 */
function html2Textarea(html)
{
    var sValue=html.replace(/</g,"��");
    sValue=sValue.replace(/>/g,"��");
    sValue=sValue.replace(/"/g,"��");
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
		changeChar();		//�滻�����ַ�
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

