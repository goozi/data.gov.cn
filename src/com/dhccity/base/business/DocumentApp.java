package com.dhccity.base.business;

import java.util.*;

import org.light.*;
import com.jspsmart.upload.*;
import com.dhccity.base.entity.*;

/**
 * 附件业务类
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * @author Zerrion
 * @version 1.0
 */

public class DocumentApp {

    /**
     * 增加文件集
     *
     * @param request  HttpRequest 		请求对象
     * @param sourceId long           	上传来源ID号
     * @param user     User              	上传用户对象
     * @return boolean
     */
    public static long addDocuments(HttpRequest request, long sourceId, User user) {
        long size = 0;
        try {
            long userId = user == null ? 0 : user.getId();
            SmartUpload smartUpload = request.getUpload();
            String[] sourceCodeArray = request.getStringArray("uploadSourceCode");

            int i = 0;
            for (int n = 0; n < sourceCodeArray.length; n++) //循环各个来源代码
            {
                String[] nameArray = request.getStringArray("uploadFileName" + sourceCodeArray[n]);
                long fileCount = request.getLong("uploadFileCount" + sourceCodeArray[n]);

                for (int j = 0; j < fileCount + 1; j++) //循环保存各个文件记录
                {
                    if (!smartUpload.getFiles().getFile(i).isMissing()) {
                        String name = nameArray[j];
                        String fileName = smartUpload.getFiles().getFile(i).getFileName();
                        long fileSize = smartUpload.getFiles().getFile(i).getSize();
                        String postfix = smartUpload.getFiles().getFile(i).getFileExt();
                        Date createTime = new Date();

                        //新建一个对象
                        BaseDocument baseDocument = new BaseDocument();
                        baseDocument.setName(name);
                        baseDocument.setFileName(fileName);
                        baseDocument.setPostfix(postfix);
                        baseDocument.setSourceCode(sourceCodeArray[n]);
                        baseDocument.setSourceId(sourceId);
                        baseDocument.setFileSize(fileSize);
                        baseDocument.setUserId(userId);
                        baseDocument.setCreateTime(createTime);
                        baseDocument.add(); //增加记录

                        smartUpload.getFiles().getFile(i).saveAs(getDocumentPath(sourceCodeArray[n]) + baseDocument.getId(),
                                smartUpload.SAVE_VIRTUAL);
                        size += fileSize;
                    }
                    i++;
                }
            }

        } catch (Exception ex) {
            return size;
        }
        return size;
    }

    /**
     * 增加文件
     *
     * @param request    HttpRequest 		请求对象
     * @param sourceId   long           	上传来源ID号
     * @param sourceCode String         来源代码
     * @param user       User             上传用户对象
     * @return String
     */
    public static String addDocument(HttpRequest request, long sourceId, String sourceCode, User user) {
        String postfix = "";
        try {
            long userId = user == null ? 0 : user.getId();
            SmartUpload smartUpload = request.getUpload();

            String fileName = smartUpload.getFiles().getFile(0).getFileName();
            long size = smartUpload.getFiles().getFile(0).getSize();
            postfix = smartUpload.getFiles().getFile(0).getFileExt();
            Date createTime = new Date();

            //新建一个对象
            BaseDocument baseDocument = new BaseDocument();
            baseDocument.setName(fileName);
            baseDocument.setFileName(fileName);
            baseDocument.setPostfix(postfix);
            baseDocument.setSourceCode(sourceCode);
            baseDocument.setSourceId(sourceId);
            baseDocument.setFileSize(size);
            baseDocument.setUserId(userId);
            baseDocument.setCreateTime(createTime);
            baseDocument.add(); //增加记录

            smartUpload.getFiles().getFile(0).saveAs(getDocumentPath(sourceCode) + baseDocument.getId(),
                    smartUpload.SAVE_VIRTUAL);
        } catch (Exception ex) {
            ex.printStackTrace();
            return postfix;
        }
        return postfix;
    }

    /**
     * 修改文件集
     *
     * @param request  HttpRequest 		请求对象
     * @param sourceId long           	上传来源ID号
     * @param user     User              	上传用户对象
     * @return boolean
     */
    public static long updateDocuments(HttpRequest request, long sourceId, User user) {
        long size = 0;
        try {
            long userId = user == null ? 0 : user.getId();
            SmartUpload smartUpload = request.getUpload();
            String[] sourceCodeArray = request.getStringArray("uploadSourceCode");
            int i = 0;
            for (int n = 0; n < sourceCodeArray.length; n++) //循环各个来源代码
            {
                String[] nameArray = request.getStringArray("uploadFileName" + sourceCodeArray[n]);
                long fileCount = request.getLong("uploadFileCount" + sourceCodeArray[n]);
                String uploadFileDelete = request.getString("uploadFileDelete" + sourceCodeArray[n]);
                if (!uploadFileDelete.equals("")) //存在删除文件现象
                {
                    String[] deleteIdArray = uploadFileDelete.split(";");
                    for (int j = 0; j < deleteIdArray.length; j++) //循环删除文件
                    {
                        deleteDocument(Long.parseLong(deleteIdArray[j]));
                    }
                }

                for (int j = 0; j < fileCount + 1; j++) {
                    if (!smartUpload.getFiles().getFile(i).isMissing()) //循环保存各个文件记录
                    {
                        String name = nameArray[j];
                        String fileName = smartUpload.getFiles().getFile(i).getFileName();
                        long fileSize = smartUpload.getFiles().getFile(i).getSize();
                        String postfix = smartUpload.getFiles().getFile(i).getFileExt();
                        Date createTime = new Date();

                        //新建一个对象
                        BaseDocument baseDocument = new BaseDocument();
                        baseDocument.setName(name);
                        baseDocument.setFileName(fileName);
                        baseDocument.setPostfix(postfix);
                        baseDocument.setSourceCode(sourceCodeArray[n]);
                        baseDocument.setSourceId(sourceId);
                        baseDocument.setFileSize(fileSize);
                        baseDocument.setUserId(userId);
                        baseDocument.setCreateTime(createTime);
                        baseDocument.add(); //增加记录

                        smartUpload.getFiles().getFile(i).saveAs(getDocumentPath(sourceCodeArray[n]) + baseDocument.getId(),
                                smartUpload.SAVE_VIRTUAL);
                        size += fileSize;
                    }
                    i++;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return size;
        }
        return size;
    }

    /**
     * 修改文件
     *
     * @param request    HttpRequest 		请求对象
     * @param sourceId   long           	上传来源ID号
     * @param sourceCode String         来源代码
     * @param user       User              	上传用户对象
     * @return String
     */
    public static String updateDocument(HttpRequest request, long sourceId, String sourceCode, User user) {
        String postfix = "";
        try {
            long userId = user == null ? 0 : user.getId();
            SmartUpload smartUpload = request.getUpload();

            String uploadFileDelete = request.getString("uploadFileDelete");
            if (!uploadFileDelete.equals("") && !uploadFileDelete.equals("0")) //存在删除文件现象
            {
                deleteDocument(Long.parseLong(uploadFileDelete));
            }
            if (!smartUpload.getFiles().getFile(0).isMissing()) //循环保存各个文件记录
            {
                String fileName = smartUpload.getFiles().getFile(0).getFileName();
                long size = smartUpload.getFiles().getFile(0).getSize();
                postfix = smartUpload.getFiles().getFile(0).getFileExt();
                Date createTime = new Date();

                //新建一个对象
                BaseDocument baseDocument = new BaseDocument();
                baseDocument.setName(fileName);
                baseDocument.setFileName(fileName);
                baseDocument.setPostfix(postfix);
                baseDocument.setSourceCode(sourceCode);
                baseDocument.setSourceId(sourceId);
                baseDocument.setFileSize(size);
                baseDocument.setUserId(userId);
                baseDocument.setCreateTime(createTime);
                baseDocument.add(); //增加记录

                smartUpload.getFiles().getFile(0).saveAs(getDocumentPath(sourceCode) + baseDocument.getId(),
                        smartUpload.SAVE_VIRTUAL);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return postfix;
        }
        return postfix;
    }

    /**
     * 通过来源代码与ID号查找所有记录
     *
     * @param sourceCode String   来源代码
     * @param sourceId   long       来源ID
     * @return List
     */
    public static List findDocument(String sourceCode, long sourceId) {
        BaseDocument baseDocument = new BaseDocument();
        return baseDocument.findBySource(sourceCode, sourceId);
    }

    /**
     * 通过来源代码与用户ID号查找所有记录
     *
     * @param sourceCode String   来源代码
     * @param userId     int          用户ID
     * @param name       String 		  搜索文件名
     * @return List
     */
    public static List findDocument(String sourceCode, int userId, String name) {
        BaseDocument baseDocument = new BaseDocument();
        return baseDocument.findBySource(sourceCode, userId, name);
    }

    /**
     * 通过来源代码获得文档路径
     *
     * @param sourceCode String  来源代码
     * @return String
     */
    public static String getDocumentPath(String sourceCode) {
        BaseDocumentPath baseDocumentPath = new BaseDocumentPath();
        return "/uploadFile/" + baseDocumentPath.getDocumentPath(sourceCode) + "/";
    }

    /**
     * 通过后缀获得图标文件与位置
     *
     * @param postfix String	后缀名称
     * @return String
     */
    public static String getDocumentIcon(String postfix) {
        BaseDocumentType baseDocumentType = (BaseDocumentType) new BaseDocumentType().findByPostfix(postfix);
        if (baseDocumentType == null) {
            return "/images/file_icon/default.gif";
        } else {
            return "/images/file_icon/" + baseDocumentType.getIcon();
        }
    }

    /**
     * 通过后缀获得打开MIME类型字符串
     *
     * @param postfix String	后缀名称
     * @return String
     */
    public static String getDocumentMime(String postfix) {
        BaseDocumentType baseDocumentType = (BaseDocumentType) new BaseDocumentType().findByPostfix(postfix);
        if (baseDocumentType == null) {
            return "application/download";
        } else {
            return baseDocumentType.getMime();
        }
    }

    /**
     * 删除文件和数据库记录
     *
     * @param id long  文件ID号
     */
    public static long deleteDocument(long id) {
        long size = 0;
        BaseDocument baseDocument = (BaseDocument) new BaseDocument().findById(id);
        if (baseDocument != null) {
            size = baseDocument.getFileSize();
            baseDocument.delete();
        }
        return size;
    }

    /**
     * 通过来源代码与ID号获得记录个数
     *
     * @param sourceCode String   来源代码
     * @param sourceId   long       来源ID
     * @return int
     */
    public static int getRecordCount(String sourceCode, long sourceId) {
        BaseDocument baseDocument = new BaseDocument();
        return baseDocument.findBySource(sourceCode, sourceId).size();
    }

}
