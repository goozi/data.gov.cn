<%@ page language="java" pageEncoding="utf-8" %>
<%@ include file="/include.jsp" %>
<%
    String sourceCode = req.getString("sourceCode");
    String isSingle = req.getString("isSingle");
%>
<table id="uploadFileTable<%=sourceCode%>" class="subList" cellspacing=1 cellpadding=0 width="100%" align=center
       border=0>
    <tbody><input id="uploadFileCount<%=sourceCode%>" name="uploadFileCount<%=sourceCode%>" type="hidden" value="0">
    <input name="uploadSourceCode" type="hidden" value="<%=sourceCode%>">
    <tr class="title">
        <td width="18%" height="19" align="center">
            <div align="center">操作</div>
        </td>
        <td width="47%">
            <div align="center">显示名称[可编辑]</div>
        </td>
        <td width="35%">
            <div align="center">文件路径</div>
        </td>
    </tr>
    <tr class="odd">
        <td width="6%" align="center"><input name="uploadFile<%=sourceCode%>" class="easyui-filebox"
                                             data-options="onChange:addFile<%=sourceCode%>,buttonText:'增加'">
        </td>
        <td><input type="text" name="uploadFileName<%=sourceCode%>" class='fileUpload_input'></td>
        <td><input type="text" name="uploadFilePath<%=sourceCode%>" class='fileUpload_input' readOnly="true"></td>
    </tr>
    </tbody>
</table>


<script language="javascript">

    var currRow<%=sourceCode%> = 2;

    //增加文件
    function addFile<%=sourceCode%>(newValue, oldValue) {
        debugger;
        var obj = this;
        var isSingle = <%=isSingle%>;
        var currFilePath, currFileName;
        var currRow = currRow<%=sourceCode%>;

        if (newValue == "" || $(obj).filebox('options').readonly == "true") return;

        var table = document.getElementById("uploadFileTable<%=sourceCode%>");
        var filePath = document.getElementsByName("uploadFilePath<%=sourceCode%>");
        var fileName = document.getElementsByName("uploadFileName<%=sourceCode%>");


        if (currRow == 2) {
            currFilePath = filePath[0];
            currFileName = fileName[0];
        }
        else {
            currFilePath = filePath[currRow - 2];
            currFileName = fileName[currRow - 2];
        }

        if (isSingle) {
            currFilePath.value = newValue;
            currFileName.value = getFileName<%=sourceCode%>(newValue);
            return;
        }

        var tr = table.insertRow(currRow);
        tr.className = "odd";
        var td = tr.insertCell(0);
        td.align = "center";
        <%--td.innerHTML = " <input name='uploadFile<%=sourceCode%>' type='text'>";--%>
        //var fileHtml = "<input name='uploadFile<%=sourceCode%>' type='text'>";
        var fileObj = document.createElement('input');
        fileObj.name='uploadFile<%=sourceCode%>';
        td.appendChild(fileObj);
        var changeHandle = addFile<%=sourceCode%>;
        $(fileObj).filebox({
            buttonText: '增加',
            onChange: changeHandle
        });

        td = tr.insertCell(1);
        td.innerHTML = "<input type='text' name='uploadFileName<%=sourceCode%>' class='fileUpload_input'>";
        td = tr.insertCell(2);
        td.innerHTML = "<input type='text' name='uploadFilePath<%=sourceCode%>' class='fileUpload_input' readOnly='true'>";

        currFilePath.value = newValue;
        currFileName.value = getFileName<%=sourceCode%>(newValue);

        <%--var sHTML = "<img src='/images/delete.gif' style='cursor:hand' onclick='deleteFile<%=sourceCode%>(this)'>"--%>
        var oDeleteButton = document.createElement('img');
        oDeleteButton.style.cursor = "pointer";
        oDeleteButton.onclick = deleteFile<%=sourceCode%>;
        //obj.insertAdjacentElement("afterEnd", oDeleteButton);
        obj.parentNode.appendChild(oDeleteButton);

//        obj.style.display = "none";
        $(obj).filebox('readonly', true);
        currRow++;
        document.getElementById("uploadFileCount<%=sourceCode%>").value = currRow - 2;
        currRow<%=sourceCode%> = currRow;
        return;
    }


    //删除文件
    function deleteFile<%=sourceCode%>() {
        var currRow = currRow<%=sourceCode%>;
        var table = document.getElementById("uploadFileTable<%=sourceCode%>");
        table.deleteRow(this.parentNode.parentNode.rowIndex);
        currRow--;
        document.getElementById("uploadFileCount<%=sourceCode%>").value = currRow - 2;
        currRow<%=sourceCode%> = currRow;
    }


    //获得文件名
    function getFileName<%=sourceCode%>(str) {
        var i = str.lastIndexOf("\\");
        var value = str.substr(i + 1);
        return value;
    }
</script>