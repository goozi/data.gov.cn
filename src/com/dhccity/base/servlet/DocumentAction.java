package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.jspsmart.upload.*;
import com.dhccity.base.business.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_DOCUMENT 表管理Servlet类</p>
 * <p>Description:BASE_DOCUMENT</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2005-05-23 11:35</p>
 *
 * @author Zerrion
 * @version 1.0
 *          <servlet><servlet-name>DocumentAction</servlet-name><servlet-class>com.dhccity.xmsl.common.servlet.DocumentAction</servlet-class></servlet>
 *          <servlet-mapping><servlet-name>DocumentAction</servlet-name><url-pattern>/baseDocumentAction</url-pattern></servlet-mapping>
 */

public class DocumentAction extends ServletAction {
    private ServletConfig config;

    //Initialize global variables
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    /**
     * 下载文件
     */
    public void downloadFile(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {

        long id = request.getLong("id");
        BaseDocument baseDocument = (BaseDocument) new BaseDocument().findById(id);
        String fileName = DocumentApp.getDocumentPath(baseDocument.getSourceCode()) + baseDocument.getId();
        String name = baseDocument.getFileName();

        SmartUpload mySmartUpload = new SmartUpload();
        try {
            mySmartUpload.initialize(config, request, response);
            mySmartUpload.downloadFile(fileName, "application/download", name);
        } catch (Exception e) {
        }

    }

    /**
     * 直接打开文件
     */
    public void openFile(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException {

        long id = request.getLong("id");
        BaseDocument baseDocument = (BaseDocument) new BaseDocument().findById(id);
        String fileName = DocumentApp.getDocumentPath(baseDocument.getSourceCode()) + baseDocument.getId();
        String mime = DocumentApp.getDocumentMime(baseDocument.getPostfix());

        SmartUpload mySmartUpload = new SmartUpload();
        try {
            mySmartUpload.initialize(config, request, response);
            mySmartUpload.downloadFile(fileName, mime, "");
        } catch (Exception e) {
        }

    }

}
