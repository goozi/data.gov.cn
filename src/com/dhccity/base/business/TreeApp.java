package com.dhccity.base.business;

import java.util.*;

import org.light.*;
import org.light.system.*;

/**
 * ���Ͷ���ҵ����
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * <p>Company: DHCcity</p>
 * @author Zerrion
 * @version 1.0
 */

public class TreeApp
{
	public final static boolean ID = true; //ֵΪid
	public final static boolean VALUE = false; //ֵΪvalue

	/**
	 * ͨ������code�����ѡ���б�
	 * @param code String     ���ʹ���
	 * @return List
	 */
	private static List findAllNode(String code)
	{
		Tree baseTree = (Tree) Spring.getContext().getBean(code);
		return baseTree.findAllNode(1);
	}

	/**
	 * ����Select����
	 * @param webObjectName String    	web��������
	 * @param code String           	���ʹ���
	 * @param valueType boolean     	ֵ������[TypeApp.ID��ʾIDֵ��TypeApp.VALUE��ʾvalueֵ]
	 * @return String
	 */
	public static String createSelect(String webObjectName, String code, boolean valueType)
	{
		String html = "<select name=\"" + webObjectName + "\">";
		html = html + createOption(code, valueType) + "</select>";
		return html;
	}

	/**
	 * ����Select����(ֵΪID)
	 * @param webObjectName String    web��������
	 * @param code String             ���ʹ���
	 * @param childTypeId long        ��ѡ��ID(Select��ʼѡ��ֵ)
	 * @return String
	 */
	public static String createSelect(String webObjectName, String code, long childTypeId)
	{
		String html = "<select name=\"" + webObjectName + "\">";
		html = html + createOption(code, childTypeId) + "</select>";
		return html;
	}

	/**
	 * ����Select����(ֵΪVALUE)
	 * @param webObjectName String      web��������
	 * @param code String               ���ʹ���
	 * @param childTypeValue String     ��ѡ��ֵ(Select��ʼѡ��ֵ)
	 * @return String
	 */
	public static String createSelect(String webObjectName, String code, String childTypeValue)
	{
		String html = "<select name=\"" + webObjectName + "\">";
		html = html + createOption(code, childTypeValue) + "</select>";
		return html;
	}

	/**
	 * ����Option����(ֵΪID)
	 * @param code String          		���ʹ���
	 * @param valueType boolean     	ֵ������[TypeApp.ID��ʾIDֵ��TypeApp.VALUE��ʾvalueֵ]
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
	 * ����Option����(ֵΪID)
	 * @param code String          ���ʹ���
	 * @param childTypeId long     ��ѡ��ID(Option��ʼѡ��ֵ)
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
	 * ����Option����(ֵΪVALUE)
	 * @param code String          		���ʹ���
	 * @param childTypeValue String     ��ѡ��ֵ(Select��ʼѡ��ֵ)
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
	 * ����Radio����(ֵΪID)
	 * @param webObjectName String    	web��������
	 * @param code String             	���ʹ���
	 * @param valueType boolean     	ֵ������[TypeApp.ID��ʾIDֵ��TypeApp.VALUE��ʾvalueֵ]
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
	 * ����Radio����(ֵΪID)
	 * @param webObjectName String    web��������
	 * @param code String             ���ʹ���
	 * @param childTypeId long        ��ѡ��ID(Radio��ʼѡ��ֵ)
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
	 * ����Radio����(ֵΪVALUE)
	 * @param webObjectName String      web��������
	 * @param code String               ���ʹ���
	 * @param childTypeValue String     ��ѡ��ֵ(Radio��ʼѡ��ֵ)
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
	 * ����Checkbox����(ֵΪID)
	 * @param webObjectName String    	web��������
	 * @param code String             	���ʹ���
	 * @param valueType boolean     	ֵ������[TypeApp.ID��ʾIDֵ��TypeApp.VALUE��ʾvalueֵ]
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
	 * ����Checkbox����(ֵΪID)
	 * @param webObjectName String    web��������
	 * @param code String             ���ʹ���
	 * @param childTypeId long        ��ѡ��ID(Checkbox��ʼѡ��ֵ)
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
	 * ����Checkbox����(ֵΪVALUE)
	 * @param webObjectName String      web��������
	 * @param code String               ���ʹ���
	 * @param childTypeValue String     ��ѡ��ֵ(Checkbox��ʼѡ��ֵ)
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
	 * ͨ�����ʹ��봴�����ͽṹ���͵�Xml�ַ���--����radio
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
	 * ͨ�����ʹ��봴�����ͽṹ���͵�Xml�ַ���
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
	 * ����Select����--�����������
	 * @param webObjectName String    	web��������
	 * @param code String             	���ʹ���
	 * @return String
	 */
	public static String createSelfSelect(String webObjectName, String code)
	{
		String html = "<select name=\"" + webObjectName + "\">";
		html = html + "<option value=\"0\">����Ŀ¼</option>";
		html = html + createOption(code, ID) + "</select>";
		return html;
	}

	/**
	 * ����Select����--�����������
	 * @param webObjectName String    	web��������
	 * @param code String				���ʹ���
	 * @param id long					ID��
	 * @param parentId long				��ID��
	 * @return String
	 */
	public static String createSelfSelect(String webObjectName, String code, long id, long parentId)
	{
		String html = "<select name=\"" + webObjectName + "\">";
		html = html + "<option value=\"0\">����Ŀ¼</option>";
		html = html + createSelfOption(code, id, parentId) + "</select>";
		return html;
	}

	/**
	 * ����Select����--�����������
	 * @param code String				���ʹ���
	 * @param id long					ID��
	 * @param parentId long				��ID��
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
