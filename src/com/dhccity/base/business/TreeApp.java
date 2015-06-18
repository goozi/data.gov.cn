package com.dhccity.base.business;

import java.util.*;

import org.light.*;
import org.light.system.*;

/**
 * 树型对象业务类
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: DHCcity</p>
 * @author Zerrion
 * @version 1.0
 */

public class TreeApp
{
	public final static boolean ID = true; //值为id
	public final static boolean VALUE = false; //值为value

	/**
	 * 通过代码code获得子选项列表
	 * @param code String     类型代码
	 * @return List
	 */
	private static List findAllNode(String code)
	{
		Tree baseTree = (Tree) Spring.getContext().getBean(code);
		return baseTree.findAllNode(1);
	}

	/**
	 * 创建Select对象
	 * @param webObjectName String    	web对象名称
	 * @param code String           	类型代码
	 * @param valueType boolean     	值的类型[TypeApp.ID表示ID值，TypeApp.VALUE表示value值]
	 * @return String
	 */
	public static String createSelect(String webObjectName, String code, boolean valueType)
	{
		String html = "<select name=\"" + webObjectName + "\">";
		html = html + createOption(code, valueType) + "</select>";
		return html;
	}

	/**
	 * 创建Select对象(值为ID)
	 * @param webObjectName String    web对象名称
	 * @param code String             类型代码
	 * @param childTypeId long        子选项ID(Select初始选定值)
	 * @return String
	 */
	public static String createSelect(String webObjectName, String code, long childTypeId)
	{
		String html = "<select name=\"" + webObjectName + "\">";
		html = html + createOption(code, childTypeId) + "</select>";
		return html;
	}

	/**
	 * 创建Select对象(值为VALUE)
	 * @param webObjectName String      web对象名称
	 * @param code String               类型代码
	 * @param childTypeValue String     子选项值(Select初始选定值)
	 * @return String
	 */
	public static String createSelect(String webObjectName, String code, String childTypeValue)
	{
		String html = "<select name=\"" + webObjectName + "\">";
		html = html + createOption(code, childTypeValue) + "</select>";
		return html;
	}

	/**
	 * 创建Option对象(值为ID)
	 * @param code String          		类型代码
	 * @param valueType boolean     	值的类型[TypeApp.ID表示ID值，TypeApp.VALUE表示value值]
	 * @return String
	 */
	public static String createOption(String code, boolean valueType)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String html = "";
		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			String value = valueType ? Convert.toString(tree.getId()) : tree.getValue();
			html += "<option value=\"" + value + "\">" + tree.getLevelString() + tree.getName() + "</option>";
		}
		return html;
	}

	/**
	 * 创建Option对象(值为ID)
	 * @param code String          类型代码
	 * @param childTypeId long     子选项ID(Option初始选定值)
	 * @return String
	 */
	public static String createOption(String code, long childTypeId)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String html = "";
		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			String strTemp = tree.getId() == childTypeId ? "selected" : "";
			html += "<option " + strTemp + " value=\"" + tree.getId() + "\">" + tree.getLevelString() + tree.getName() + "</option>";
		}
		return html;
	}

	/**
	 * 创建Option对象(值为VALUE)
	 * @param code String          		类型代码
	 * @param childTypeValue String     子选项值(Select初始选定值)
	 * @return String
	 */
	public static String createOption(String code, String childTypeValue)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String html = "";
		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			String strTemp = tree.getValue().equals(childTypeValue) ? "selected" : "";
			html += "<option " + strTemp + " value=\"" + tree.getValue() + "\">" + tree.getLevelString() + tree.getName() + "</option>";
		}
		return html;
	}

	/**
	 * 创建Radio对象(值为ID)
	 * @param webObjectName String    	web对象名称
	 * @param code String             	类型代码
	 * @param valueType boolean     	值的类型[TypeApp.ID表示ID值，TypeApp.VALUE表示value值]
	 * @return String
	 */
	public static String createRadio(String webObjectName, String code, boolean valueType)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String html = "";
		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			String value = valueType ? Convert.toString(tree.getId()) : tree.getValue();
			html += "<input type=\"radio\" name=\"" + webObjectName + "\"  value=\"" + value + "\">" + tree.getName();
		}
		return html;
	}

	/**
	 * 创建Radio对象(值为ID)
	 * @param webObjectName String    web对象名称
	 * @param code String             类型代码
	 * @param childTypeId long        子选项ID(Radio初始选定值)
	 * @return String
	 */
	public static String createRadio(String webObjectName, String code, int childTypeId)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String html = "";
		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			String strTemp = tree.getId() == childTypeId ? "checked" : "";
			html += "<input type=\"radio\" " + strTemp + " name=\"" + webObjectName + "\"  value=\"" + tree.getValue() + "\">" + tree.getName();
		}
		return html;
	}

	/**
	 * 创建Radio对象(值为VALUE)
	 * @param webObjectName String      web对象名称
	 * @param code String               类型代码
	 * @param childTypeValue String     子选项值(Radio初始选定值)
	 * @return String
	 */
	public static String createRadio(String webObjectName, String code, String childTypeValue)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String html = "";
		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			String strTemp = tree.getValue().equals(childTypeValue) ? "checked" : "";
			html += "<input type=\"radio\" " + strTemp + " name=\"" + webObjectName + "\"  value=\"" + tree.getValue() + "\">" + tree.getName();
		}
		return html;
	}

	/**
	 * 创建Checkbox对象(值为ID)
	 * @param webObjectName String    	web对象名称
	 * @param code String             	类型代码
	 * @param valueType boolean     	值的类型[TypeApp.ID表示ID值，TypeApp.VALUE表示value值]
	 * @return String
	 */
	public static String createCheckbox(String webObjectName, String code, boolean valueType)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String html = "";
		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			String value = valueType ? Convert.toString(tree.getId()) : tree.getValue();
			html += "<input type=\"checkbox\" name=\"" + webObjectName + "\"  value=\"" + value + "\">" + tree.getName();
		}
		return html;
	}

	/**
	 * 创建Checkbox对象(值为ID)
	 * @param webObjectName String    web对象名称
	 * @param code String             类型代码
	 * @param childTypeId long        子选项ID(Checkbox初始选定值)
	 * @return String
	 */
	public static String createCheckbox(String webObjectName, String code, int childTypeId)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String html = "";
		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			String strTemp = tree.getId() == childTypeId ? "checked" : "";
			html += "<input type=\"checkbox\" " + strTemp + " name=\"" + webObjectName + "\"  value=\"" + tree.getValue() + "\">" + tree.getName();
		}
		return html;
	}

	/**
	 * 创建Checkbox对象(值为VALUE)
	 * @param webObjectName String      web对象名称
	 * @param code String               类型代码
	 * @param childTypeValue String     子选项值(Checkbox初始选定值)
	 * @return String
	 */
	public static String createCheckbox(String webObjectName, String code, String childTypeValue)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String html = "";
		childTypeValue += ";";
		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			String strTemp = childTypeValue.indexOf(tree.getValue() + ";") != -1 ? "checked" : "";
			html += "<input type=\"checkbox\" " + strTemp + " name=\"" + webObjectName + "\"  value=\"" + tree.getValue() + "\">" + tree.getName();
		}
		return html;
	}

	/**
	 * 通过类型代码创建树型结构类型的Xml字符串--用于radio
	 * @param code String
	 * @return String
	 */
	public static String createRadioTreeXml(String code)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String strXml = "<?xml version=\"1.0\" encoding=\"gb2312\" ?><tree>";
		long lastLevel = 0;
		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			if (lastLevel > tree.getLevel())
			{
				for (int i = 0; i < lastLevel - tree.getLevel(); i++)
				{
					strXml += "</item>";
				}
			}
			if (tree.isLeaf())
			{
				strXml += "<item value='" + tree.getId() + ";" + tree.getName() + "' text='" + tree.getName() + "' Radio=\"false\"  NodeId=\"" +
					tree.getId() + "\" Title=\"" + tree.getName() +
					"\" Href=\"javascript:doClick(" + tree.getId() + ",'" + tree.getValue() +
					"');\" Target=\"self\" />";
			}
			else
			{
				strXml += "<item value='" + tree.getId() + ";" + tree.getName() + "' text='" + tree.getName() + "'  Radio=\"false\" NodeId='" +
					tree.getId() + "' Title='" + tree.getName() + "'>";
			}

			lastLevel = tree.getLevel();
		}
		for (int i = 0; i < lastLevel; i++)
		{strXml += "</item>";
		}
		strXml += "</tree>";
		return strXml;
	}

	/**
	 * 通过类型代码创建树型结构类型的Xml字符串
	 * @param code String
	 * @return String
	 */
	public static String createTreeXml(String code)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String strXml = "<?xml version=\"1.0\" encoding=\"gb2312\" ?><tree>";
		long lastLevel = 0;
		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			if (lastLevel > tree.getLevel())
			{
				for (int i = 0; i < lastLevel - tree.getLevel(); i++)
				{
					strXml += "</item>";
				}
			}
			if (tree.isLeaf())
			{
				strXml += "<item value='" + tree.getId() + "' text='" + tree.getName() + "'  NodeId=\"" +
					tree.getId() + "\" Title=\"" + tree.getName() +
					"\" Href=\"javascript:doClick(" + tree.getId() + ",'" + tree.getValue() +
					"');\" Target=\"_self\" />";
			}
			else
			{
				strXml += "<item value='" + tree.getId() + "' text='" + tree.getName() + "'  NodeId=\"" +
					tree.getId() + "\" Title=\"" + tree.getName() +
					"\" Href=\"javascript:doClick(" + tree.getId() + ",'" + tree.getValue() +
					"');\" Target=\"_self\" >";
			}

			lastLevel = tree.getLevel();
		}
		for (int i = 0; i < lastLevel; i++)
		{strXml += "</item>";
		}
		strXml += "</tree>";
		return strXml;
	}

	/**
	 * 创建Select对象--用于自身管理
	 * @param webObjectName String    	web对象名称
	 * @param code String             	类型代码
	 * @return String
	 */
	public static String createSelfSelect(String webObjectName, String code)
	{
		String html = "<select name=\"" + webObjectName + "\">";
		html = html + "<option value=\"0\">┌根目录</option>";
		html = html + createOption(code, ID) + "</select>";
		return html;
	}

	/**
	 * 创建Select对象--用于自身管理
	 * @param webObjectName String    	web对象名称
	 * @param code String				类型代码
	 * @param id long					ID号
	 * @param parentId long				父ID号
	 * @return String
	 */
	public static String createSelfSelect(String webObjectName, String code, long id, long parentId)
	{
		String html = "<select name=\"" + webObjectName + "\">";
		html = html + "<option value=\"0\">┌根目录</option>";
		html = html + createSelfOption(code, id, parentId) + "</select>";
		return html;
	}

	/**
	 * 创建Select对象--用于自身管理
	 * @param code String				类型代码
	 * @param id long					ID号
	 * @param parentId long				父ID号
	 * @return String
	 */
	public static String createSelfOption(String code, long id, long parentId)
	{
		List list = findAllNode(code);
		Iterator it = list.iterator();
		String html = "";
		boolean stopWrite = false;
		long level = 10000;

		while (it.hasNext())
		{
			Tree tree = (Tree) it.next();
			String strTemp = tree.getId() == parentId ? "selected" : "";

			if (level >= tree.getLevel() && stopWrite)
			{
				stopWrite = false;
			}

			if (tree.getId() == id)
			{
				stopWrite = true;
				level = tree.getLevel();
			}

			if (!stopWrite)
			{
				html += "<option " + strTemp + " value=\"" + tree.getId() + "\">" + tree.getLevelString() +
					tree.getName() + "</option>";
			}
		}
		return html;
	}

}
