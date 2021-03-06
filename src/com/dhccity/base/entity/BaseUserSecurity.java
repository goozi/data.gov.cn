package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_USER_SECURITY 表对应类</p>
 * <p>Description:BASE_USER_SECURITY</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-02-14 14:33</p>
 * @author liuxd
 * @version 1.0
 */

public class BaseUserSecurity extends Ado
{
	private long id; //ID
	private long securityId; //模块权限ID
	private String securityArray; //权限ID集
	private int type; //类型;1、用户，2、职务，3、角色
	private long departmentId; //部门ID，0表示所有部门
	private long ownerId; //所有者ID，0表示所有
	private int sequ; //排列


	public BaseUserSecurity()
	{
	}

	public BaseUserSecurity(long id)
	{
		this.id = id;
	}

	/**
	 * 对应字段：[ID]  类型：NUMBER(22)
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * 对应字段：[ID]  类型：NUMBER(22)
	 */
	public long getId()
	{
		return this.id;
	}

	/**
	 * 对应字段：[模块权限ID]  类型：NUMBER(12)
	 */
	public void setSecurityId(long securityId)
	{
		this.securityId = securityId;
	}

	/**
	 * 对应字段：[模块权限ID]  类型：NUMBER(12)
	 */
	public long getSecurityId()
	{
		return this.securityId;
	}

	/**
	 * 对应字段：[权限ID集]  类型：VARCHAR2(4000)
	 */
	public void setSecurityArray(String securityArray)
	{
		this.securityArray = securityArray;
	}

	/**
	 * 对应字段：[权限ID集]  类型：VARCHAR2(4000)
	 */
	public String getSecurityArray()
	{
		return this.securityArray == null ? "" : this.securityArray;
	}

	/**
	 * 对应字段：[类型;1、用户，2、职务，3、角色]  类型：NUMBER(2)
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	/**
	 * 对应字段：[类型;1、用户，2、职务，3、角色]  类型：NUMBER(2)
	 */
	public int getType()
	{
		return this.type;
	}

	/**
	 * 对应字段：[部门ID，0表示所有部门]  类型：NUMBER(12)
	 */
	public void setDepartmentId(long departmentId)
	{
		this.departmentId = departmentId;
	}

	/**
	 * 对应字段：[部门ID，0表示所有部门]  类型：NUMBER(12)
	 */
	public long getDepartmentId()
	{
		return this.departmentId;
	}

	/**
	 * 对应字段：[所有者ID，0表示所有]  类型：NUMBER(12)
	 */
	public void setOwnerId(long ownerId)
	{
		this.ownerId = ownerId;
	}

	/**
	 * 对应字段：[所有者ID，0表示所有]  类型：NUMBER(12)
	 */
	public long getOwnerId()
	{
		return this.ownerId;
	}

	/**
	 * 对应字段：[排列]  类型：NUMBER(8)
	 */
	public void setSequ(int sequ)
	{
		this.sequ = sequ;
	}

	/**
	 * 对应字段：[排列]  类型：NUMBER(8)
	 */
	public int getSequ()
	{
		return this.sequ;
	}

	//===============================以下为自编辑代码===================================

	/**
	 * 获取类型名称
	 * @return String
	 */
	public String getTypeName()
	{
		String value = "";
		if (type == 1)
		{
			value = "用户";
		}
		else if (type == 2)
		{
			value = "职务";
		}
		else if (type == 3)
		{
			value = "角色";
		}
		return value;
	}

	/**
	 * 获取部门名称
	 * @return String
	 */
	public String getDepartmentName()
	{
		String value = "";
		if (departmentId == 0)
		{
			value = "所有";
		}
		else
		{
			BaseDepartment baseDepartment = (BaseDepartment)new BaseDepartment().findById(departmentId);
			value = baseDepartment == null ? "" : baseDepartment.getName();
		}
		return value;
	}

	/**
	 * 获取拥有对象名称
	 * @return String
	 */
	public String getOwnerName()
	{
		String value = "";
		if (ownerId == 0)
		{
			value = "所有";
		}
		else
		{
			if (type == 1)
			{
				BaseUser baseUser = (BaseUser)new BaseUser().findById(ownerId);
				value = baseUser == null ? "" : baseUser.getName();
			}
			else if (type == 2 || type == 3)
			{
				BaseType baseType = (BaseType)new BaseType().findById(ownerId);
				value = baseType == null ? "" : baseType.getName();
			}
		}
		return value;
	}

	/**
	 * 获取功能数组名称
	 */
	public String getSecurityArrayName()
	{
		String value = "";
		String functionIds = securityArray.substring(1, securityArray.length() - 1);
		String[] idArray = functionIds.split("\\}\\{");
		Iterator it = new BaseSecurity().findNodeByIdArray(idArray).iterator();
		int i = 1;
		while (it.hasNext())
		{
			BaseSecurity baseSecurity = (BaseSecurity) it.next();
			if (i == 1)
			{
				value += baseSecurity.getName();
			}
			else
			{
				value += "；" + baseSecurity.getName();
			}
			i++;
		}
		return value;
	}

	/**
	 * 通过模块ID号和功能ID数组查找所有的权限定义节点
	 * @param securityId long		模块ID号
	 * @param idArray String[]		功能ID数组
	 * @return List
	 */
	public List findAllNode(long securityId, String[] idArray)
	{
		if (idArray.length == 0)
		{
			return new Vector();
		}
		String hql = "from BaseUserSecurity o where o.securityId=" + securityId;
		String hqlArray = "1<>1";
		for (int i = 0; i < idArray.length; i++)
		{
			hqlArray += " or o.securityArray like '%{" + idArray[i] + "}%'";
		}
		hql = hql + " and (" + hqlArray + ")";
		return this.findAll(hql);
	}

	/**
	 * 通过模块ID号或功能ID查找所有的权限定义节点
	 * @param idArray String[]		功能ID或模块ID数组
	 * @return List
	 */
	public List findAllNode(String[] idArray)
	{
		if (idArray.length == 0)
		{
			return new Vector();
		}
		String hql = "from BaseUserSecurity o where ";
		String hqlId = "1<>1";
		String hqlArray = "1<>1";
		for (int i = 0; i < idArray.length; i++)
		{
			hqlId += " or o.securityId=" + idArray[i];
			hqlArray += " or o.securityArray like '%{" + idArray[i] + "}%'";
		}
		hql = hql + "(" + hqlId + ") or (" + hqlArray + ")";
		return this.findAll(hql);
	}

	/**
	 * 通过模块ID号或功能ID查找所有的权限定义节点
	 * @param securityId long		模块ID号或功能ID
	 * @return List
	 */
	public List findAllNode(long securityId)
	{
		String hql = "from BaseUserSecurity o where o.securityId=" + securityId + " or o.securityArray like '%{" + securityId + "}%'";
		return this.findAll(hql);
	}

	/**
	 * 通过模块ID号查找所有的权限定义
	 * @param securityId long
	 * @return List
	 */
	public List findAllBySecurityId(long securityId)
	{
		String hql = "from BaseUserSecurity o where o.securityId=" + securityId;
		return this.findAll(hql);
	}

}
