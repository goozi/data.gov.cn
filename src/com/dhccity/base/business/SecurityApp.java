package com.dhccity.base.business;

import java.util.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * 权限检测业务类
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
	 * 通过模块名称和功能名称进行权限检测
	 * @param user User				用户对象
	 * @param moduleCode String		模块代码
	 * @param functionCode String	功能代码,可分别用"||"或"&&"对多个功能代码进行隔开，如"Admin||Read"或"Admin&&Read"
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
	 * 通过模块名称和功能名称进行权限检测--用于菜单权限检测
	 * @param user User				用户对象
	 * @param securityId long		模块或功能ID号
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
	 * 通过网址和请求字符串进行权限检测
	 * @param user User		用户对象
	 * @param url String	网址
	 * @param query String	请求字符
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
	 * 检测用户权限
	 * @param user User		用户对象
	 * @param list List		BaseUserSecurity列表
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
				return true; //无限制
			}
			if (baseUserSecurity.getType() == 1) //用户
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
			else if (baseUserSecurity.getType() == 2) //职务
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
			else if ( (baseUserSecurity.getType() == 3)) //角色
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
	 * 通过类型代码创建树型结构类型的Xml字符串--用于radio
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
