package com.dhccity.base.business;

import java.util.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * Ȩ�޼��ҵ����
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: DHCcity</p>
 * @author Zerrion
 * @version 1.0
 */

public class SecurityApp
{

	/**
	 * ͨ��ģ�����ƺ͹������ƽ���Ȩ�޼��
	 * @param user User				�û�����
	 * @param moduleCode String		ģ�����
	 * @param functionCode String	���ܴ���,�ɷֱ���"||"��"&&"�Զ�����ܴ�����и�������"Admin||Read"��"Admin&&Read"
	 * @return boolean
	 */
	public static boolean checkFunction(User user, String moduleCode, String functionCode)
	{
		List list = new BaseSecurity().findNodeByCode(moduleCode, functionCode);
		String[] idArray = new String[list.size()];
		Iterator it = list.iterator();
		int i = 0;
		long parnetId = 0;
		while (it.hasNext())
		{
			BaseSecurity baseSecurity = (BaseSecurity) it.next();
			parnetId = baseSecurity.getParentId();
			idArray[i] = Convert.toString(baseSecurity.getId());
			i++;
		}
		list = new BaseUserSecurity().findAllNode(parnetId, idArray);
		return check(user, list);
	}

	/**
	 * ͨ��ģ�����ƺ͹������ƽ���Ȩ�޼��--���ڲ˵�Ȩ�޼��
	 * @param user User				�û�����
	 * @param securityId long		ģ�����ID��
	 * @return boolean
	 */
	public static boolean checkFunction(User user, long securityId)
	{
		if (securityId == 0)
		{
			return true;
		}
		List list = new BaseUserSecurity().findAllNode(securityId);
		return check(user, list);
	}

	/**
	 * ͨ����ַ�������ַ�������Ȩ�޼��
	 * @param user User		�û�����
	 * @param url String	��ַ
	 * @param query String	�����ַ�
	 * @return boolean
	 */
	public static boolean checkUrl(User user, String url, String query)
	{
		List list = new BaseSecurity().findNodeByUrl(url, query);
		String[] ids = new String[list.size()];
		Iterator it = list.iterator();
		int i = 0;
		while (it.hasNext())
		{
			BaseSecurity baseSecurity = (BaseSecurity) it.next();
			ids[i] = Convert.toString(baseSecurity.getId());
			i++;
		}
		list = new BaseUserSecurity().findAllNode(ids);
		return check(user, list);
	}

	/**
	 * ����û�Ȩ��
	 * @param user User		�û�����
	 * @param list List		BaseUserSecurity�б�
	 * @return boolean
	 */
	private static boolean check(User user, List list)
	{
		if (user == null)
		{
			return false;
		}
		if (user.isProgrammer())
		{
			return true;
		}
		Iterator it = list.iterator();
		while (it.hasNext())
		{
			BaseUserSecurity baseUserSecurity = (BaseUserSecurity) it.next();
			if (baseUserSecurity.getOwnerId() == 0 && baseUserSecurity.getDepartmentId() == 0)
			{
				return true; //������
			}
			if (baseUserSecurity.getType() == 1) //�û�
			{
				if (baseUserSecurity.getOwnerId() == 0)
				{
					if (baseUserSecurity.getDepartmentId() == user.getDepartmentId())
					{
						return true;
					}
				}
				else if (baseUserSecurity.getOwnerId() == user.getId())
				{
					return true;
				}
			}
			else if (baseUserSecurity.getType() == 2) //ְ��
			{
				if (baseUserSecurity.getOwnerId() == 0)
				{
					if (BaseUserGroup.isBelongToDepartment(user.getId(), baseUserSecurity.getDepartmentId(), 1))
					{
						return true;
					}
				}
				else
				{
					if (baseUserSecurity.getDepartmentId() == 0)
					{
						if (BaseUserGroup.isBelongToGroup(user.getId(), baseUserSecurity.getOwnerId(), 1))
						{
							return true;
						}
					}
					else
					{
						if (BaseUserGroup.isBelongToGroup(user.getId(), baseUserSecurity.getDepartmentId(), baseUserSecurity.getOwnerId(), 1))
						{
							return true;
						}
					}
				}

			}
			else if ( (baseUserSecurity.getType() == 3)) //��ɫ
			{
				if (baseUserSecurity.getOwnerId() == 0)
				{
					if (BaseUserGroup.isBelongToDepartment(user.getId(), baseUserSecurity.getDepartmentId(), 2))
					{
						return true;
					}
				}
				else
				{
					if (baseUserSecurity.getDepartmentId() == 0)
					{
						if (BaseUserGroup.isBelongToGroup(user.getId(), baseUserSecurity.getOwnerId(), 2))
						{
							return true;
						}
					}
					else
					{
						if (BaseUserGroup.isBelongToGroup(user.getId(), baseUserSecurity.getDepartmentId(), baseUserSecurity.getOwnerId(), 2))
						{
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * ͨ�����ʹ��봴�����ͽṹ���͵�Xml�ַ���--����radio
	 * @return String
	 */
	public static String createRadioTreeXml()
	{
		List list = new BaseSecurity().findAllItem(1);
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

}