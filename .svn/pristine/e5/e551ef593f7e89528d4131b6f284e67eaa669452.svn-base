package com.dhccity.base.business;

import java.util.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * 字典业务类
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: DHCcity</p>
 *
 * @author Zerrion
 * @version 1.0
 */

public class TypeApp {
    public final static boolean ID = true; //值为id
    public final static boolean VALUE = false; //值为value

    /**
     * 通过ID获得选项名称
     *
     * @param id long    ID
     * @return String
     */
    public static String getName(long id) {
        BaseType baseType = (BaseType) new BaseType().findById(id);
        return baseType == null ? "" : baseType.getName();
    }

    /**
     * 通过值与代码获得名称
     *
     * @param code  String    代码
     * @param value String   值
     * @return String
     */
    public static String getName(String code, String value) {
        BaseType baseType = (BaseType) new BaseType().findByCode(code, value);
        return baseType == null ? "" : baseType.getName();
    }

    /**
     * 创建Select对象
     *
     * @param webObjectName String    	web对象名称
     * @param code          String           	类型代码
     * @param valueType     boolean     	值的类型[TypeApp.ID表示ID值，TypeApp.VALUE表示value值]
     * @return String
     */
    public static String createSelect(String webObjectName, String code, boolean valueType) {
        String html = "<select name=\"" + webObjectName + "\">";
        html = html + createOption(code, valueType) + "</select>";
        return html;
    }

    /**
     * 创建Select对象(值为ID)
     *
     * @param webObjectName String    web对象名称
     * @param code          String             类型代码
     * @param childTypeId   long        子选项ID(Select初始选定值)
     * @return String
     */
    public static String createSelect(String webObjectName, String code, long childTypeId) {
        String html = "<select name=\"" + webObjectName + "\">";
        html = html + createOption(code, childTypeId) + "</select>";
        return html;
    }

    /**
     * 创建Select对象(值为VALUE)
     *
     * @param webObjectName  String      web对象名称
     * @param code           String               类型代码
     * @param childTypeValue String     子选项值(Select初始选定值)
     * @return String
     */
    public static String createSelect(String webObjectName, String code, String childTypeValue) {
        String html = "<select name=\"" + webObjectName + "\">";
        html = html + createOption(code, childTypeValue) + "</select>";
        return html;
    }

    /**
     * 创建Option对象(值为ID)
     *
     * @param code      String          		类型代码
     * @param valueType boolean     	值的类型[TypeApp.ID表示ID值，TypeApp.VALUE表示value值]
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
     * 创建Option对象(值为ID)
     *
     * @param code        String          类型代码
     * @param childTypeId long     子选项ID(Option初始选定值)
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
     * 创建Option对象(值为VALUE)
     *
     * @param code           String          		类型代码
     * @param childTypeValue String     子选项值(Select初始选定值)
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
     * 创建Radio对象(值为ID)
     *
     * @param webObjectName String    	web对象名称
     * @param code          String             	类型代码
     * @param valueType     boolean     	值的类型[TypeApp.ID表示ID值，TypeApp.VALUE表示value值]
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
     * 创建Radio对象(值为ID)
     *
     * @param webObjectName String    web对象名称
     * @param code          String             类型代码
     * @param childTypeId   long        子选项ID(Radio初始选定值)
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
     * 创建Radio对象(值为VALUE)
     *
     * @param webObjectName  String      web对象名称
     * @param code           String               类型代码
     * @param childTypeValue String     子选项值(Radio初始选定值)
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
     * 创建Checkbox对象(值为ID)
     *
     * @param webObjectName String    	web对象名称
     * @param code          String             	类型代码
     * @param valueType     boolean     	值的类型[TypeApp.ID表示ID值，TypeApp.VALUE表示value值]
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
     * 创建Checkbox对象(值为ID)
     *
     * @param webObjectName String    web对象名称
     * @param code          String             类型代码
     * @param childTypeId   long        子选项ID(Checkbox初始选定值)
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
     * 创建Checkbox对象(值为VALUE)
     *
     * @param webObjectName  String      web对象名称
     * @param code           String               类型代码
     * @param childTypeValue String     子选项值(Checkbox初始选定值)
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
     * 通过类型代码创建树型结构类型的Xml字符串
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
     * 通过用户对象获取该用户能够获取的数据字典项
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
     * 创建Select对象--用于自身管理
     *
     * @param webObjectName String    	web对象名称
     * @param code          String             	类型代码
     * @param isParent      boolean          是否为要目录
     * @return String
     */
    public static String createSelfSelect(String webObjectName, String code, boolean isParent) {
        String html = "<select name=\"" + webObjectName + "\">";
        BaseType baseType = new BaseType().findByCode(code);
        html = html + "<option value=\"" + baseType.getId() + "\">┌" + baseType.getName() + "</option>";
        html = html + createSelfOption(code, isParent, ID) + "</select>";
        return html;
    }

    /**
     * 创建Select对象--用于自身管理
     *
     * @param webObjectName String    	web对象名称
     * @param code          String				类型代码
     * @param isParent      boolean          是否为要目录
     * @param id            long					ID号
     * @param parentId      long				父ID号
     * @return String
     */
    public static String createSelfSelect(String webObjectName, String code, boolean isParent, long id, long parentId) {
        String html = "<select name=\"" + webObjectName + "\">";
        BaseType baseType = new BaseType().findByCode(code);
        String strTemp = baseType.getId() == parentId ? "selected" : "";
        html = html + "<option value=\"" + baseType.getId() + "\"" + strTemp + ">┌" + baseType.getName() + "</option>";
        html = html + createSelfOption(code, isParent, id, parentId) + "</select>";
        return html;
    }

    /**
     * 创建Option对象(值为ID)
     *
     * @param code      String          		类型代码
     * @param isParent  boolean          是否为根目录
     * @param valueType boolean     	值的类型[TypeApp.ID表示ID值，TypeApp.VALUE表示value值]
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
     * 创建Select对象--用于自身管理
     *
     * @param code     String				类型代码
     * @param isParent boolean          是否为根目录
     * @param id       long					ID号
     * @param parentId long				父ID号
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
