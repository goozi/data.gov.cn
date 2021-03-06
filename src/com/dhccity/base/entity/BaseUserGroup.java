package com.dhccity.base.entity;

import java.util.*;

import org.light.*;
import com.dhccity.base.business.*;

/**
 * <p>Title: BASE_USER_GROUP 表对应类</p>
 * <p>Description:BASE_USER_GROUP</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-02-14 14:40</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseUserGroup extends Ado
{
	private long id; //ID
	private long userId; //用户ID
	private long departmentId; //部门ID
	private long groupId; //职务或角色ID
	private int type; //类型，1表示职务，2表示角色
	private int sequ; //显示顺序号

	public BaseUserGroup()
	{
	}

	public BaseUserGroup(long id)
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
	 * 对应字段：[用户ID]  类型：NUMBER(12)
	 */
	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	/**
	 * 对应字段：[用户ID]  类型：NUMBER(12)
	 */
	public long getUserId()
	{
		return this.userId;
	}

	/**
	 * 对应字段：[部门ID]  类型：NUMBER(12)
	 */
	public void setDepartmentId(long departmentId)
	{
		this.departmentId = departmentId;
	}

	/**
	 * 对应字段：[部门ID]  类型：NUMBER(12)
	 */
	public long getDepartmentId()
	{
		return this.departmentId;
	}

	/**
	 * 对应字段：[职务或角色ID]  类型：NUMBER(12)
	 */
	public void setGroupId(long groupId)
	{
		this.groupId = groupId;
	}

	/**
	 * 对应字段：[职务或角色ID]  类型：NUMBER(12)
	 */
	public long getGroupId()
	{
		return this.groupId;
	}

	/**
	 * 对应字段：[类型，1表示职务，2表示角色]  类型：NUMBER(2)
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	/**
	 * 对应字段：[类型，1表示职务，2表示角色]  类型：NUMBER(2)
	 */
	public int getType()
	{
		return this.type;
	}

	/**
	 * 对应字段：[显示顺序号]  类型：NUMBER(8)
	 */
	public void setSequ(int sequ)
	{
		this.sequ = sequ;
	}

	/**
	 * 对应字段：[显示顺序号]  类型：NUMBER(8)
	 */
	public int getSequ()
	{
		return this.sequ;
	}

	//===============================以下为自编辑代码===================================

	/**
	 * 通过用户ID获取首个职务名称
	 * @param userId long
	 * @return String
	 */
	public static String getDutyName(long userId)
	{
		String value = "";
		String hql = "from BaseUserGroup o where o.userId=" + userId + " and o.type=1 order by o.sequ desc";
		BaseUserGroup baseUserGroup = (BaseUserGroup)new BaseUserGroup().findObject(hql);
		if (baseUserGroup != null)
		{
			value = TypeApp.getName(baseUserGroup.getGroupId());
		}
		return value;
	}

	/**
	 * 用户是否属于该组（职务与角色）
	 * @param userId long		用户ID
	 * @param groupId long		组ID
	 * @param type int			类型1表示职务，2表示角色
	 * @return boolean
	 */
	public static boolean isBelongToGroup(long userId, long groupId, int type)
	{
		String hql = "from BaseUserGroup o where o.userId=" + userId + " and o.groupId=" + groupId + " and o.type=" + type;
		return new BaseUserGroup().findObject(hql) != null;
	}

	/**
	 * 用户是否属于该部门下的该组（职务与角色）
	 * @param userId long			用户ID
	 * @param departmentId long		部门ID
	 * @param groupId long			组ID
	 * @param type int				类型1表示职务，2表示角色
	 * @return boolean
	 */
	public static boolean isBelongToGroup(long userId, long departmentId, long groupId, int type)
	{
		String hql = "from BaseUserGroup o where o.userId=" + userId + " and o.departmentId=" + departmentId + " and o.groupId=" + groupId + " and o.type=" + type;
		return new BaseUserGroup().findObject(hql) != null;
	}

	/**
	 * 用户是否属于该部门
	 * @param userId long			用户ID
	 * @param departmentId long		部门ID
	 * @param type int				类型1表示职务，2表示角色
	 * @return boolean
	 */
	public static boolean isBelongToDepartment(long userId, long departmentId, int type)
	{
		String hql = "from BaseUserGroup o where o.userId=" + userId + " and o.departmentId=" + departmentId + " and o.type=" + type;
		return new BaseUserGroup().findObject(hql) != null;
	}

	/**
	 * 通过用户ID查找组集合
	 * @param userId long    用户ID
	 * @param type int       类型
	 * @return List
	 */
	public List findByUserId(long userId, int type)
	{
		String hql = "from BaseUserGroup o where o.userId=" + userId + " and o.type=" + type + " order by sequ desc";
		return this.findAll(hql);
	}

	/**
	 * 获得部门名称
	 * @return String
	 */
	public String getDepartmentName()
	{
		BaseDepartment baseDepartment = (BaseDepartment)new BaseDepartment().findById(this.departmentId);
		return baseDepartment == null ? "" : baseDepartment.getName();
	}

	/**
	 * 获得部门名称
	 * @return String
	 */
	public String getGroupName()
	{
		return TypeApp.getName(this.groupId);
	}

	/**
	 * 通过用户ID删除数据
	 * @param userId long	用户ID
	 * @return int
	 */
	public static int deleteByUserId(long userId, long[] ids)
	{
		String hql = "delete from base_user_group where user_id=" + userId;
		for (int i = 0; i < ids.length; i++)
		{
			if (ids[i] > 0)
			{
				hql += " and id<>" + ids[i];
			}
		}
		return new BaseUserGroup().executeSql(hql);
	}

}
