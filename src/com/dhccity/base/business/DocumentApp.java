package com.dhccity.base.business;

import java.util.*;

import org.light.*;
import com.jspsmart.upload.*;
import com.dhccity.base.entity.*;

/**
 * ����ҵ����
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * @author Zerrion
 * @version 1.0
 */

public class DocumentApp {

    /**
     * �����ļ���
     *
     * @param request  HttpRequest 		�������
     * @param sourceId long           	�ϴ���ԴID��
     * @param user     User              	�ϴ��û�����
     * @return boolean
     */
    public static long addDocuments(HttpRequest request, long sourceId, User user) {
        long size = 0;
        try {
            long userId = user == null ? 0 : user.getId();
            SmartUpload smartUpload = request.getUpload();
            String[] sourceCodeArray = request.getStringArray("uploadSourceCode");

            int i = 0;
            for (int n = 0; n < sourceCodeArray.length; n++) //ѭ��������Դ����
            {
                String[] nameArray = request.getStringArray("uploadFileName" + sourceCodeArray[n]);
                long fileCount = request.getLong("uploadFileCount" + sourceCodeArray[n]);

                for (int j = 0; j < fileCount + 1; j++) //ѭ����������ļ���¼
                {
                    if (!smartUpload.getFiles().getFile(i).isMissing()) {
                        String name = nameArray[j];
                        String fileName = smartUpload.getFiles().getFile(i).getFileName();
                        long fileSize = smartUpload.getFiles().getFile(i).getSize();
                        String postfix = smartUpload.getFiles().getFile(i).getFileExt();
                        Date createTime = new Date();

                        //�½�һ������
                        BaseDocument baseDocument = new BaseDocument();
                        baseDocument.setName(name);
                        baseDocument.setFileName(fileName);
                        baseDocument.setPostfix(postfix);
                        baseDocument.setSourceCode(sourceCodeArray[n]);
                        baseDocument.setSourceId(sourceId);
                        baseDocument.setFileSize(fileSize);
                        baseDocument.setUserId(userId);
                        baseDocument.setCreateTime(createTime);
                        baseDocument.add(); //���Ӽ�¼

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
     * �����ļ�
     *
     * @param request    HttpRequest 		�������
     * @param sourceId   long           	�ϴ���ԴID��
     * @param sourceCode String         ��Դ����
     * @param user       User             �ϴ��û�����
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

            //�½�һ������
            BaseDocument baseDocument = new BaseDocument();
            baseDocument.setName(fileName);
            baseDocument.setFileName(fileName);
            baseDocument.setPostfix(postfix);
            baseDocument.setSourceCode(sourceCode);
            baseDocument.setSourceId(sourceId);
            baseDocument.setFileSize(size);
            baseDocument.setUserId(userId);
            baseDocument.setCreateTime(createTime);
            baseDocument.add(); //���Ӽ�¼

            smartUpload.getFiles().getFile(0).saveAs(getDocumentPath(sourceCode) + baseDocument.getId(),
                    smartUpload.SAVE_VIRTUAL);
        } catch (Exception ex) {
            ex.printStackTrace();
            return postfix;
        }
        return postfix;
    }

    /**
     * �޸��ļ���
     *
     * @param request  HttpRequest 		�������
     * @param sourceId long           	�ϴ���ԴID��
     * @param user     User              	�ϴ��û�����
     * @return boolean
     */
    public static long updateDocuments(HttpRequest request, long sourceId, User user) {
        long size = 0;
        try {
            long userId = user == null ? 0 : user.getId();
            SmartUpload smartUpload = request.getUpload();
            String[] sourceCodeArray = request.getStringArray("uploadSourceCode");
            int i = 0;
            for (int n = 0; n < sourceCodeArray.length; n++) //ѭ��������Դ����
            {
                String[] nameArray = request.getStringArray("uploadFileName" + sourceCodeArray[n]);
                long fileCount = request.getLong("uploadFileCount" + sourceCodeArray[n]);
                String uploadFileDelete = request.getString("uploadFileDelete" + sourceCodeArray[n]);
                if (!uploadFileDelete.equals("")) //����ɾ���ļ�����
                {
                    String[] deleteIdArray = uploadFileDelete.split(";");
                    for (int j = 0; j < deleteIdArray.length; j++) //ѭ��ɾ���ļ�
                    {
                        deleteDocument(Long.parseLong(deleteIdArray[j]));
                    }
                }

                for (int j = 0; j < fileCount + 1; j++) {
                    if (!smartUpload.getFiles().getFile(i).isMissing()) //ѭ����������ļ���¼
                    {
                        String name = nameArray[j];
                        String fileName = smartUpload.getFiles().getFile(i).getFileName();
                        long fileSize = smartUpload.getFiles().getFile(i).getSize();
                        String postfix = smartUpload.getFiles().getFile(i).getFileExt();
                        Date createTime = new Date();

                        //�½�һ������
                        BaseDocument baseDocument = new BaseDocument();
                        baseDocument.setName(name);
                        baseDocument.setFileName(fileName);
                        baseDocument.setPostfix(postfix);
                        baseDocument.setSourceCode(sourceCodeArray[n]);
                        baseDocument.setSourceId(sourceId);
                        baseDocument.setFileSize(fileSize);
                        baseDocument.setUserId(userId);
                        baseDocument.setCreateTime(createTime);
                        baseDocument.add(); //���Ӽ�¼

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
     * �޸��ļ�
     *
     * @param request    HttpRequest 		�������
     * @param sourceId   long           	�ϴ���ԴID��
     * @param sourceCode String         ��Դ����
     * @param user       User              	�ϴ��û�����
     * @return String
     */
    public static String updateDocument(HttpRequest request, long sourceId, String sourceCode, User user) {
        String postfix = "";
        try {
            long userId = user == null ? 0 : user.getId();
            SmartUpload smartUpload = request.getUpload();

            String uploadFileDelete = request.getString("uploadFileDelete");
            if (!uploadFileDelete.equals("") && !uploadFileDelete.equals("0")) //����ɾ���ļ�����
            {
                deleteDocument(Long.parseLong(uploadFileDelete));
            }
            if (!smartUpload.getFiles().getFile(0).isMissing()) //ѭ����������ļ���¼
            {
                String fileName = smartUpload.getFiles().getFile(0).getFileName();
                long size = smartUpload.getFiles().getFile(0).getSize();
                postfix = smartUpload.getFiles().getFile(0).getFileExt();
                Date createTime = new Date();

                //�½�һ������
                BaseDocument baseDocument = new BaseDocument();
                baseDocument.setName(fileName);
                baseDocument.setFileName(fileName);
                baseDocument.setPostfix(postfix);
                baseDocument.setSourceCode(sourceCode);
                baseDocument.setSourceId(sourceId);
                baseDocument.setFileSize(size);
                baseDocument.setUserId(userId);
                baseDocument.setCreateTime(createTime);
                baseDocument.add(); //���Ӽ�¼

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
     * ͨ����Դ������ID�Ų������м�¼
     *
     * @param sourceCode String   ��Դ����
     * @param sourceId   long       ��ԴID
     * @return List
     */
    public static List findDocument(String sourceCode, long sourceId) {
        BaseDocument baseDocument = new BaseDocument();
        return baseDocument.findBySource(sourceCode, sourceId);
    }

    /**
     * ͨ����Դ�������û�ID�Ų������м�¼
     *
     * @param sourceCode String   ��Դ����
     * @param userId     int          �û�ID
     * @param name       String 		  �����ļ���
     * @return List
     */
    public static List findDocument(String sourceCode, int userId, String name) {
        BaseDocument baseDocument = new BaseDocument();
        return baseDocument.findBySource(sourceCode, userId, name);
    }

    /**
     * ͨ����Դ�������ĵ�·��
     *
     * @param sourceCode String  ��Դ����
     * @return String
     */
    public static String getDocumentPath(String sourceCode) {
        BaseDocumentPath baseDocumentPath = new BaseDocumentPath();
        return "/uploadFile/" + baseDocumentPath.getDocumentPath(sourceCode) + "/";
    }

    /**
     * ͨ����׺���ͼ���ļ���λ��
     *
     * @param postfix String	��׺����
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
     * ͨ����׺��ô�MIME�����ַ���
     *
     * @param postfix String	��׺����
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
     * ɾ���ļ������ݿ��¼
     *
     * @param id long  �ļ�ID��
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
     * ͨ����Դ������ID�Ż�ü�¼����
     *
     * @param sourceCode String   ��Դ����
     * @param sourceId   long       ��ԴID
     * @return int
     */
    public static int getRecordCount(String sourceCode, long sourceId) {
        BaseDocument baseDocument = new BaseDocument();
        return baseDocument.findBySource(sourceCode, sourceId).size();
    }

}