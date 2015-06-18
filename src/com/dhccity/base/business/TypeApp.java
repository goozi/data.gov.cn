package com.dhccity.base.business;

import java.util.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * �ֵ�ҵ����
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: DHCcity</p>
 *
 * @author Zerrion
 * @version 1.0
 */

public class TypeApp {
    public final static boolean ID = true; //ֵΪid
    public final static boolean VALUE = false; //ֵΪvalue

    /**
     * ͨ��ID���ѡ������
     *
     * @param id long    ID
     * @return String
     */
    public static String getName(long id) {
        BaseType baseType = (BaseType) new BaseType().findById(id);
        return baseType == null ? "" : baseType.getName();
    }

    /**
     * ͨ��ֵ�����������
     *
     * @param code  String    ����
     * @param value String   ֵ
     * @return String
     */
    public static String getName(String code, String value) {
        BaseType baseType = (BaseType) new BaseType().findByCode(code, value);
        return baseType == null ? "" : baseType.getName();
    }

    /**
     * ����Select����
     *
     * @param webObjectName String    	web��������
     * @param code          String           	���ʹ���
     * @param valueType     boolean     	ֵ������[TypeApp.ID��ʾIDֵ��TypeApp.VALUE��ʾvalueֵ]
     * @return String
     */
    public static String createSelect(String webObjectName, String code, boolean valueType) {
        String html = "<select name=\"" + webObjectName + "\">";
        html = html + createOption(code, valueType) + "</select>";
        return html;
    }

    /**
     * ����Select����(ֵΪID)
     *
     * @param webObjectName String    web��������
     * @param code          String             ���ʹ���
     * @param childTypeId   long        ��ѡ��ID(Select��ʼѡ��ֵ)
     * @return String
     */
    public static String createSelect(String webObjectName, String code, long childTypeId) {
        String html = "<select name=\"" + webObjectName + "\">";
        html = html + createOption(code, childTypeId) + "</select>";
        return html;
    }

    /**
     * ����Select����(ֵΪVALUE)
     *
     * @param webObjectName  String      web��������
     * @param code           String               ���ʹ���
     * @param childTypeValue String     ��ѡ��ֵ(Select��ʼѡ��ֵ)
     * @return String
     */
    public static String createSelect(String webObjectName, String code, String childTypeValue) {
        String html = "<select name=\"" + webObjectName + "\">";
        html = html + createOption(code, childTypeValue) + "</select>";
        return html;
    }

    /**
     * ����Option����(ֵΪID)
     *
     * @param code      String          		���ʹ���
     * @param valueType boolean     	ֵ������[TypeApp.ID��ʾIDֵ��TypeApp.VALUE��ʾvalueֵ]
     * @return String
     */
    public static String createOption(String code, boolean valueType) {
        List list = new BaseType().findAllChildType(code, 1);
        Iterator it = list.iterator();
        String html = "";
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            String strTemp = baseType.getIsDefault() == 1 ? "selected" : "";
            String value = valueType ? Convert.toString(baseType.getId()) : baseType.getValue();
            html += "<option " + strTemp + " value=\"" + value + "\">" + baseType.getLevelString() + baseType.getName() + "</option>";
        }
        return html;
    }

    /**
     * ����Option����(ֵΪID)
     *
     * @param code        String          ���ʹ���
     * @param childTypeId long     ��ѡ��ID(Option��ʼѡ��ֵ)
     * @return String
     */
    public static String createOption(String code, long childTypeId) {
        List list = new BaseType().findAllChildType(code, 1);
        Iterator it = list.iterator();
        String html = "";
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            String strTemp = baseType.getId() == childTypeId ? "selected" : "";
            html += "<option " + strTemp + " value=\"" + baseType.getId() + "\">" + baseType.getLevelString() + baseType.getName() + "</option>";
        }
        return html;
    }

    /**
     * ����Option����(ֵΪVALUE)
     *
     * @param code           String          		���ʹ���
     * @param childTypeValue String     ��ѡ��ֵ(Select��ʼѡ��ֵ)
     * @return String
     */
    public static String createOption(String code, String childTypeValue) {
        List list = new BaseType().findAllChildType(code, 1);
        Iterator it = list.iterator();
        String html = "";
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            String strTemp = baseType.getValue().equals(childTypeValue) ? "selected" : "";
            html += "<option " + strTemp + " value=\"" + baseType.getValue() + "\">" + baseType.getLevelString() + baseType.getName() + "</option>";
        }
        return html;
    }

    /**
     * ����Radio����(ֵΪID)
     *
     * @param webObjectName String    	web��������
     * @param code          String             	���ʹ���
     * @param valueType     boolean     	ֵ������[TypeApp.ID��ʾIDֵ��TypeApp.VALUE��ʾvalueֵ]
     * @return String
     */
    public static String createRadio(String webObjectName, String code, boolean valueType) {
        List list = new BaseType().findAllChildType(code, 1);
        Iterator it = list.iterator();
        String html = "";
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            String strTemp = baseType.getIsDefault() == 1 ? "checked" : "";
            String value = valueType ? Convert.toString(baseType.getId()) : baseType.getValue();
            html += "<label><input type=\"radio\" " + strTemp + " name=\"" + webObjectName + "\"  value=\"" + value + "\">" + baseType.getName()+"</label>";
        }
        return html;
    }

    /**
     * ����Radio����(ֵΪID)
     *
     * @param webObjectName String    web��������
     * @param code          String             ���ʹ���
     * @param childTypeId   long        ��ѡ��ID(Radio��ʼѡ��ֵ)
     * @return String
     */
    public static String createRadio(String webObjectName, String code, int childTypeId) {
        List list = new BaseType().findAllChildType(code, 1);
        Iterator it = list.iterator();
        String html = "";
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            String strTemp = baseType.getId() == childTypeId ? "checked" : "";
            html += "<input type=\"radio\" " + strTemp + " name=\"" + webObjectName + "\"  value=\"" + baseType.getValue() + "\">" + baseType.getName();
        }
        return html;
    }

    /**
     * ����Radio����(ֵΪVALUE)
     *
     * @param webObjectName  String      web��������
     * @param code           String               ���ʹ���
     * @param childTypeValue String     ��ѡ��ֵ(Radio��ʼѡ��ֵ)
     * @return String
     */
    public static String createRadio(String webObjectName, String code, String childTypeValue) {
        List list = new BaseType().findAllChildType(code, 1);
        Iterator it = list.iterator();
        String html = "";
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            String strTemp = baseType.getValue().equals(childTypeValue) ? "checked" : "";
            html += "<input type=\"radio\" " + strTemp + " name=\"" + webObjectName + "\"  value=\"" + baseType.getValue() + "\">" + baseType.getName();
        }
        return html;
    }

    /**
     * ����Checkbox����(ֵΪID)
     *
     * @param webObjectName String    	web��������
     * @param code          String             	���ʹ���
     * @param valueType     boolean     	ֵ������[TypeApp.ID��ʾIDֵ��TypeApp.VALUE��ʾvalueֵ]
     * @return String
     */
    public static String createCheckbox(String webObjectName, String code, boolean valueType) {
        List list = new BaseType().findAllChildType(code, 1);
        Iterator it = list.iterator();
        String html = "";
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            String strTemp = baseType.getIsDefault() == 1 ? "checked" : "";
            String value = valueType ? Convert.toString(baseType.getId()) : baseType.getValue();
            html += "<input type=\"checkbox\" " + strTemp + " name=\"" + webObjectName + "\"  value=\"" + value + "\">" + baseType.getName();
        }
        return html;
    }

    /**
     * ����Checkbox����(ֵΪID)
     *
     * @param webObjectName String    web��������
     * @param code          String             ���ʹ���
     * @param childTypeId   long        ��ѡ��ID(Checkbox��ʼѡ��ֵ)
     * @return String
     */
    public static String createCheckbox(String webObjectName, String code, int childTypeId) {
        List list = new BaseType().findAllChildType(code, 1);
        Iterator it = list.iterator();
        String html = "";
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            String strTemp = baseType.getId() == childTypeId ? "checked" : "";
            html += "<input type=\"checkbox\" " + strTemp + " name=\"" + webObjectName + "\"  value=\"" + baseType.getValue() + "\">" + baseType.getName();
        }
        return html;
    }

    /**
     * ����Checkbox����(ֵΪVALUE)
     *
     * @param webObjectName  String      web��������
     * @param code           String               ���ʹ���
     * @param childTypeValue String     ��ѡ��ֵ(Checkbox��ʼѡ��ֵ)
     * @return String
     */
    public static String createCheckbox(String webObjectName, String code, String childTypeValue) {
        List list = new BaseType().findAllChildType(code, 1);
        Iterator it = list.iterator();
        String html = "";
        childTypeValue += ";";
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            String strTemp = childTypeValue.indexOf(baseType.getValue() + ";") != -1 ? "checked" : "";
            html += "<input type=\"checkbox\" " + strTemp + " name=\"" + webObjectName + "\"  value=\"" + baseType.getValue() + "\">" + baseType.getName();
        }
        return html;
    }

    /**
     * ͨ�����ʹ��봴�����ͽṹ���͵�Xml�ַ���
     *
     * @param code String
     * @return String
     */
    public static String createTreeXml(String code) {
        List list = new BaseType().findAllChildType(code, 1);
        Iterator it = list.iterator();
        String strXml = "<?xml version=\"1.0\" encoding=\"gb2312\" ?><tree>";
        long lastLevel = 0;
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            if (lastLevel > baseType.getLevel()) {
                for (int i = 0; i < lastLevel - baseType.getLevel(); i++) {
                    strXml += "</item>";
                }
            }

            if (baseType.isLeaf()) {
                strXml += "<item value='" + baseType.getId() + "' text='" + baseType.getName() + "'   NodeId=\"" +
                        baseType.getId() + "\" Title=\"" + baseType.getName() +
                        "\" Href=\"javascript:doClick(" + baseType.getId() + ",'" + baseType.getValue() +
                        "');\" Target=\"self\" />";
            } else {
                strXml += "<item value='" + baseType.getId() + "' text='" + baseType.getName() + "'   NodeId='" +
                        baseType.getId() + "' Title='" + baseType.getName() + "'>";
            }

            lastLevel = baseType.getLevel();
        }
        for (int i = 0; i < lastLevel; i++) {
            strXml += "</item>";
        }
        strXml += "</tree>";
        return strXml;
    }

    /**
     * ͨ���û������ȡ���û��ܹ���ȡ�������ֵ���
     *
     * @param user User
     * @return String
     */
    public static String createParentTypeXml(User user) {
        List list = new BaseType().findAllParentType(user);
        Iterator it = list.iterator();
        String strXml = "<?xml version='1.0' encoding='gb2312' ?><tree>";
        long lastLevel = 0;
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            if (lastLevel > baseType.getLevel()) {
                for (int i = 0; i < lastLevel - baseType.getLevel(); i++) {
                    strXml += "</item>";
                }
            }
            if (baseType.isLeaf()) {
                strXml += "<item value='" + baseType.getId() + "' text='" + baseType.getName() + "'   NodeId='" +
                        baseType.getId() + "' Title='" + baseType.getName() +
                        "' Href='javascript:doClick(" + baseType.getId() + ");' Target='_self' />";
            } else {
                strXml += "<item value='" + baseType.getId() + "' text='" + baseType.getName() + "'   NodeId='" +
                        baseType.getId() + "' Title='" + baseType.getName() + "'>";
            }
            lastLevel = baseType.getLevel();
        }
        for (int i = 0; i < lastLevel; i++) {
            strXml += "</item>";
        }
        strXml += "</tree>";
        return strXml;
    }

    /**
     * ����Select����--�����������
     *
     * @param webObjectName String    	web��������
     * @param code          String             	���ʹ���
     * @param isParent      boolean          �Ƿ�ΪҪĿ¼
     * @return String
     */
    public static String createSelfSelect(String webObjectName, String code, boolean isParent) {
        String html = "<select name=\"" + webObjectName + "\">";
        BaseType baseType = new BaseType().findByCode(code);
        html = html + "<option value=\"" + baseType.getId() + "\">��" + baseType.getName() + "</option>";
        html = html + createSelfOption(code, isParent, ID) + "</select>";
        return html;
    }

    /**
     * ����Select����--�����������
     *
     * @param webObjectName String    	web��������
     * @param code          String				���ʹ���
     * @param isParent      boolean          �Ƿ�ΪҪĿ¼
     * @param id            long					ID��
     * @param parentId      long				��ID��
     * @return String
     */
    public static String createSelfSelect(String webObjectName, String code, boolean isParent, long id, long parentId) {
        String html = "<select name=\"" + webObjectName + "\">";
        BaseType baseType = new BaseType().findByCode(code);
        String strTemp = baseType.getId() == parentId ? "selected" : "";
        html = html + "<option value=\"" + baseType.getId() + "\"" + strTemp + ">��" + baseType.getName() + "</option>";
        html = html + createSelfOption(code, isParent, id, parentId) + "</select>";
        return html;
    }

    /**
     * ����Option����(ֵΪID)
     *
     * @param code      String          		���ʹ���
     * @param isParent  boolean          �Ƿ�Ϊ��Ŀ¼
     * @param valueType boolean     	ֵ������[TypeApp.ID��ʾIDֵ��TypeApp.VALUE��ʾvalueֵ]
     * @return String
     */
    public static String createSelfOption(String code, boolean isParent, boolean valueType) {
        List list = null;
        if (isParent) {
            list = new BaseType().findAllParentType(1);
        } else {
            list = new BaseType().findAllChildType(code, 1);
        }
        Iterator it = list.iterator();
        String html = "";
        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            String strTemp = baseType.getIsDefault() == 1 ? "selected" : "";
            String value = valueType ? Convert.toString(baseType.getId()) : baseType.getValue();
            html += "<option " + strTemp + " value=\"" + value + "\">" + baseType.getLevelString() + baseType.getName() + "</option>";
        }
        return html;
    }

    /**
     * ����Select����--�����������
     *
     * @param code     String				���ʹ���
     * @param isParent boolean          �Ƿ�Ϊ��Ŀ¼
     * @param id       long					ID��
     * @param parentId long				��ID��
     * @return String
     */
    public static String createSelfOption(String code, boolean isParent, long id, long parentId) {
        List list = null;
        if (isParent) {
            list = new BaseType().findAllParentType(1);
        } else {
            list = new BaseType().findAllChildType(code, 1);

        }
        Iterator it = list.iterator();
        String html = "";
        boolean stopWrite = false;
        long level = 10000;

        while (it.hasNext()) {
            BaseType baseType = (BaseType) it.next();
            String strTemp = baseType.getId() == parentId ? "selected" : "";

            if (level >= baseType.getLevel() && stopWrite) {
                stopWrite = false;
            }

            if (baseType.getId() == id) {
                stopWrite = true;
                level = baseType.getLevel();
            }

            if (!stopWrite) {
                html += "<option " + strTemp + " value=\"" + baseType.getId() + "\">" + baseType.getLevelString() +
                        baseType.getName() + "</option>";
            }
        }
        return html;
    }

}
