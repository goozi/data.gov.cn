package com.dhccity.base.entity;

import java.util.*;

import org.light.*;
import com.dhccity.base.business.*;

/**
 * <p>Title: BASE_USER_GROUP ����Ӧ��</p>
 * <p>Description:BASE_USER_GROUP</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-02-14 14:40</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseUserGroup extends Ado
{
	private long id; //ID
	private long userId; //�û�ID
	private long departmentId; //����ID
	private long groupId; //ְ����ɫID
	private int type; //���ͣ�1��ʾְ��2��ʾ��ɫ
	private int sequ; //��ʾ˳���

	public BaseUserGroup()
	{
	}

	public BaseUserGroup(long id)
	{
		this.id = id;
	}

	/**
	 * ��Ӧ�ֶΣ�[ID]  ���ͣ�NUMBER(22)
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * ��Ӧ�ֶΣ�[ID]  ���ͣ�NUMBER(22)
	 */
	public long getId()
	{
		return this.id;
	}

	/**
	 * ��Ӧ�ֶΣ�[�û�ID]  ���ͣ�NUMBER(12)
	 */
	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	/**
	 * ��Ӧ�ֶΣ�[�û�ID]  ���ͣ�NUMBER(12)
	 */
	public long getUserId()
	{
		return this.userId;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ID]  ���ͣ�NUMBER(12)
	 */
	public void setDepartmentId(long departmentId)
	{
		this.departmentId = departmentId;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ID]  ���ͣ�NUMBER(12)
	 */
	public long getDepartmentId()
	{
		return this.departmentId;
	}

	/**
	 * ��Ӧ�ֶΣ�[ְ����ɫID]  ���ͣ�NUMBER(12)
	 */
	public void setGroupId(long groupId)
	{
		this.groupId = groupId;
	}

	/**
	 * ��Ӧ�ֶΣ�[ְ����ɫID]  ���ͣ�NUMBER(12)
	 */
	public long getGroupId()
	{
		return this.groupId;
	}

	/**
	 * ��Ӧ�ֶΣ�[���ͣ�1��ʾְ��2��ʾ��ɫ]  ���ͣ�NUMBER(2)
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	/**
	 * ��Ӧ�ֶΣ�[���ͣ�1��ʾְ��2��ʾ��ɫ]  ���ͣ�NUMBER(2)
	 */
	public int getType()
	{
		return this.type;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ʾ˳���]  ���ͣ�NUMBER(8)
	 */
	public void setSequ(int sequ)
	{
		this.sequ = sequ;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ʾ˳���]  ���ͣ�NUMBER(8)
	 */
	public int getSequ()
	{
		return this.sequ;
	}

	//===============================����Ϊ�Ա༭����===================================

	/**
	 * ͨ���û�ID��ȡ�׸�ְ������
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
	 * �û��Ƿ����ڸ��飨ְ�����ɫ��
	 * @param userId long		�û�ID
	 * @param groupId long		��ID
	 * @param type int			����1��ʾְ��2��ʾ��ɫ
	 * @return boolean
	 */
	public static boolean isBelongToGroup(long userId, long groupId, int type)
	{
		String hql = "from BaseUserGroup o where o.userId=" + userId + " and o.groupId=" + groupId + " and o.type=" + type;
		return new BaseUserGroup().findObject(hql) != null;
	}

	/**
	 * �û��Ƿ����ڸò����µĸ��飨ְ�����ɫ��
	 * @param userId long			�û�ID
	 * @param departmentId long		����ID
	 * @param groupId long			��ID
	 * @param type int				����1��ʾְ��2��ʾ��ɫ
	 * @return boolean
	 */
	public static boolean isBelongToGroup(long userId, long departmentId, long groupId, int type)
	{
		String hql = "from BaseUserGroup o where o.userId=" + userId + " and o.departmentId=" + departmentId + " and o.groupId=" + groupId + " and o.type=" + type;
		return new BaseUserGroup().findObject(hql) != null;
	}

	/**
	 * �û��Ƿ����ڸò���
	 * @param userId long			�û�ID
	 * @param departmentId long		����ID
	 * @param type int				����1��ʾְ��2��ʾ��ɫ
	 * @return boolean
	 */
	public static boolean isBelongToDepartment(long userId, long departmentId, int type)
	{
		String hql = "from BaseUserGroup o where o.userId=" + userId + " and o.departmentId=" + departmentId + " and o.type=" + type;
		return new BaseUserGroup().findObject(hql) != null;
	}

	/**
	 * ͨ���û�ID�����鼯��
	 * @param userId long    �û�ID
	 * @param type int       ����
	 * @return List
	 */
	public List findByUserId(long userId, int type)
	{
		String hql = "from BaseUserGroup o where o.userId=" + userId + " and o.type=" + type + " order by sequ desc";
		return this.findAll(hql);
	}

	/**
	 * ��ò�������
	 * @return String
	 */
	public String getDepartmentName()
	{
		BaseDepartment baseDepartment = (BaseDepartment)new BaseDepartment().findById(this.departmentId);
		return baseDepartment == null ? "" : baseDepartment.getName();
	}

	/**
	 * ��ò�������
	 * @return String
	 */
	public String getGroupName()
	{
		return TypeApp.getName(this.groupId);
	}

	/**
	 * ͨ���û�IDɾ������
	 * @param userId long	�û�ID
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