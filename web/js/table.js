var ktable;
var OddClass;
var EvenClass;
var StartRow;
var FixRow;
var FixCol;
var rowNum=0;
var colNum=0;
var currObj;

$(document).ready(function(){
	ktable= $('table.list')[0];
	OddClass = ktable.getAttribute('OddClass');
	EvenClass = ktable.getAttribute('EvenClass');
	StartRow = ktable.getAttribute('StartRow');
	FixRow = ktable.getAttribute('FixRow');
	FixCol = ktable.getAttribute('FixCol');
	doInit_table();
});
/**
* 初始化
*/
function doInit_table()
{
	ktable.style.wordBreak="keep-all";
	ktable.style.tableLayout="fixed";
	rowNum=ktable.rows.length;
	var maxNum=rowNum;
	if (OddClass==null) OddClass="odd";
	if (EvenClass==null) EvenClass="even";
	if (StartRow==null) StartRow=1;
	if (FixRow!=null) maxNum=parseInt(FixRow)+1;

	colNum=FixCol==null?ktable.rows[0].cells.length:FixCol;
	
	for(var i=StartRow;i<maxNum;i++)
	{
		if (i>=rowNum)
		{
			var oTr=ktable.insertRow(i);
			for (j=0;j<colNum;j++)
			{
				oTr.insertCell(j);				
			}			
		}
		if ((i-StartRow)%2==0)
		{
			ktable.rows[i].setAttribute('class',OddClass);
		}
		else
		{
			ktable.rows[i].setAttribute('class',EvenClass);			
		}
	}	

	if (FixCol==null)
	{
		$('table.list tr.title td').on('click',clickTbl);
		//attachEvent("onclick", clickTbl);
	}
}

/* 
*点击时进行排序
*
*/
function clickTbl()
{
	
	currObj=event.srcElement;
	if (currObj.tagName!='TD'||currObj.parentNode.rowIndex>=StartRow) return;
	
	var cellIndex=currObj.cellIndex;
	
	var aRows = [];
	var oRows = ktable.rows;

	for (var i=StartRow; i<rowNum; i++) 
	{  
		var obj=oRows[i];
		aRows[i-StartRow] = [oRows[i].cells[cellIndex].innerText,obj];
    }   

	for (var j=0;j<ktable.rows[0].cells.length;j++)
	{
		var re =/↓/i,re2=/↑/i;
		ktable.rows[0].cells[j].innerHTML=ktable.rows[0].cells[j].innerHTML.replace(re, "").replace(re2, "");
	}		

    var bDesc = ("true" == currObj.getAttribute("sort")) ? true : false;
    if (bDesc)
	{
		currObj.innerHTML=currObj.innerHTML + "↑";
		
	}
    else
	{
		currObj.innerHTML=currObj.innerHTML + "↓";		
	}

	aRows.sort(sortRows); //降序排列，按字符串内码

	currObj.setAttribute("sort", "" + !bDesc);


	
	var tempTable="table";
	tempTable=document.createElement(tempTable);

	for (var i=StartRow; i<rowNum; i++) 
	{
		var oTr=tempTable.insertRow(i-StartRow);
		for (j=0;j<ktable.rows[0].cells.length;j++)
		{
			oTr.insertCell(j);
			oTr.cells[j].innerHTML=aRows[i-StartRow][1].cells[j].innerHTML;
		}				
    }

    for (var i=StartRow; i<rowNum; i++) 
	{
		for (j=0;j<ktable.rows[0].cells.length;j++)
		{
			oRows[i].cells[j].innerHTML=tempTable.rows[i-StartRow].cells[j].innerHTML;
		}		
    }

}


/** 
 * 数据排序用的，判断大小
 * 
*/
function sortRows(x,y)
{
	var a = x[0];
	var b = y[0];		
	

	if(currObj.getAttribute("DataType")== "NUMBER")			//数据类型是数字
	{ 
		a=replace(a,",","");
		b=replace(b,",","");
		a = parseFloat(a);
		b = parseFloat(b);
	}
	else if  (currObj.getAttribute("DataType")=="DATE")		//数据类型是日期
	{ 
		a=replace(a,"-","/");
		b=replace(b,"-","/");		
		a = parseInt(new Date(a==""?"1700/01/01":a).getTime()/1000);
		b = parseInt(new Date(b==""?"1700/01/01":b).getTime()/1000);
		
	}
	if(a>b)
	{
		if("true" == currObj.getAttribute("sort")) return 1;
		else	return -1;
	}
	else if (a<b)
	{
		if("true" == currObj.getAttribute("sort"))	return -1;
		else	return 1;
	}
	else	return 0;
}

/* 
*替换字符
*
*/
function replace(str,from,to)
{
	return str.split(from).join(to);
}

