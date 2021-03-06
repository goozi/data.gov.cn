<%@ page language="java" pageEncoding="utf-8" %>
<%@ page import="com.dhccity.base.entity.BaseDocument" %>
<%@ page import="com.dhccity.base.business.DocumentApp" %>
<%@ include file="/include.jsp" %>
<%
    String sourceCode = req.getString("sourceCode");
    long sourceId = req.getLong("sourceId");
    String isSingle = req.getString("isSingle");
    Iterator itFile = DocumentApp.findDocument(sourceCode, sourceId).iterator();

%>
<table id="uploadFileTable<%=sourceCode%>" class="subList" cellspacing=1 cellpadding=0 width="100%" align=center
       border=0>
    <tbody>
    <input id="uploadFileCount<%=sourceCode%>" name="uploadFileCount<%=sourceCode%>" name="uploadFileCount<%=sourceCode%>" type="hidden" value="0">
    <input id="uploadFileDelete<%=sourceCode%>" name="uploadFileDelete<%=sourceCode%>" type="hidden" value="">
    <input name="uploadSourceCode" type="hidden" value="<%=sourceCode%>">
    <tr class="title">
        <td width="8%" height="19" align="center">
            <div align="center">操作</div>
        </td>
        <td width="51%">
            <div align="center">文件</div>
        </td>
        <td width="17%">
            <div align="center">文件大小</div>
        </td>
        <td width="24%" align="center">创建时间</td>
    </tr>
    <%
        int fileCount = 0;
        while (itFile != null && itFile.hasNext()) {
            fileCount++;
            BaseDocument baseDocument = (BaseDocument) itFile.next();
    %>
    <tr class="odd">
        <td width="8%" align="center"><img src='/images/delete.gif' value="<%=baseDocument.getId()%>"
                                           onclick='deleteServerFile<%=sourceCode%>(this)'>
        </td>
        <td><img src="<%=DocumentApp.getDocumentIcon(baseDocument.getPostfix())%>"><a
                href="/common/documentAction?action=DOWNLOAD&id=<%=baseDocument.getId()%>">
            &nbsp;<%=baseDocument.getName()%>
        </a></td>
        <TD width="17%"><%=baseDocument.getFileSize()%>
        </TD>
        <TD width="24%"><%=baseDocument.getCreateTime()%>
        </TD>
    </TR>
    <%
        }
    %>
    <tr class="odd">
        <td width="8%" align="center"><input name="uploadFile<%=sourceCode%>" type="file" class="file" title="增加"
                                             size="1">
        </td>
        <td><input type="text" name="uploadFileName<%=sourceCode%>" class="fileUpload_input"></td>
        <td colspan="2"><input name="uploadFilePath<%=sourceCode%>" type="text" class="fileUpload_input"
                               readOnly="true"></td>
    </tr>
    </tbody>
</table>


<script language="javascript">
    $(document).ready(function(){
        $("input[name='uploadFile<%=sourceCode%>']").bind('input propertychange', function() {
            addFile<%=sourceCode%>(this,<%=isSingle %>);
        });
    });
    var fileCount<%=sourceCode%> =<%=fileCount%>
    var currRow<%=sourceCode%> = fileCount<%=sourceCode%> + 2;
    var uploadFileDelete<%=sourceCode%> = "";

    //增加文件
    function addFile<%=sourceCode%>(obj, isSingle) {
        var currFilePath, currFileName;
        var currRow = currRow<%=sourceCode%>;

        if (obj.value == "" || obj.style.display == "none") return;

        var table = document.getElementById("uploadFileTable<%=sourceCode%>");
        var filePath = document.getElementsByName("uploadFilePath<%=sourceCode%>");
        var fileName = document.getElementsByName("uploadFileName<%=sourceCode%>");


        if (currRow == fileCount<%=sourceCode%> + 2) {
            currFilePath = filePath;
            currFileName = fileName;

        }
        else {
            currFilePath = filePath[currRow - fileCount<%=sourceCode%> - 2];
            currFileName = fileName[currRow - fileCount<%=sourceCode%> - 2];
        }
        if (isSingle) {
            currFilePath.value = obj.value;
            currFileName.value = getFileName<%=sourceCode%>(obj.value);
            return;
        }


        var tr = table.insertRow(currRow);
        tr.className = "odd";
        var td = tr.insertCell(0);
        td.align = "center";
        td.innerHTML = " <input name='uploadFile<%=sourceCode%>' type='file' class='file' title='增加' size='1' onpropertychange='addFile<%=sourceCode%>(this)'>";
        td = tr.insertCell(1);
        td.innerHTML = " <input type='text' name='uploadFileName<%=sourceCode%>' class='fileUpload_input'>";
        td = tr.insertCell(2);
        td.colSpan = 2;
        td.innerHTML = " <input type='text' name='uploadFilePath<%=sourceCode%>' class='fileUpload_input' readOnly='true'>";

        currFilePath.value = obj.value;
        currFileName.value = getFileName<%=sourceCode%>(obj.value);

        var sHTML = "<img src='/images/delete.gif' onclick='deleteFile<%=sourceCode%>(this)'>"
        oDeleteButton = obj.document.createElement(sHTML);
//	obj.insertAdjacentElement("afterEnd",oDeleteButton);
        if (obj.nextSibling) obj.parentNode.insertBefore(oDeleteButton, obj.nextSibling);
        else obj.parentNode.appendChild(oDeleteButton);
        obj.style.display = "none";

        currRow++;
        document.getElementById("uploadFileCount<%=sourceCode%>").value = currRow - fileCount<%=sourceCode%> - 2;
        currRow<%=sourceCode%> = currRow;
        return;
    }


    //删除文件
    function deleteFile<%=sourceCode%>(obj) {
        var currRow = currRow<%=sourceCode%>;
        var table = document.getElementById("uploadFileTable<%=sourceCode%>");
        table.deleteRow(obj.parentNode.parentNode.rowIndex);
        currRow--;
        document.getElementById("uploadFileCount<%=sourceCode%>").value = currRow - fileCount<%=sourceCode%> - 2;
        currRow<%=sourceCode%> = currRow;
    }

    //删除服务器文件
    function deleteServerFile<%=sourceCode%>(obj) {
        var table = document.getElementById("uploadFileTable<%=sourceCode%>");
        uploadFileDelete<%=sourceCode%> = uploadFileDelete<%=sourceCode%> + obj.value + ";";
        document.getElementById("uploadFileDelete<%=sourceCode%>").value = uploadFileDelete<%=sourceCode%>;
        table.deleteRow(obj.parentNode.parentNode.rowIndex);
        fileCount<%=sourceCode%>--;
        currRow<%=sourceCode%>--;
    }


    //获得文件名
    function getFileName<%=sourceCode%>(str) {
        var i = str.lastIndexOf("\\");
        var value = str.substr(i + 1);
        return value;
    }
</script>
