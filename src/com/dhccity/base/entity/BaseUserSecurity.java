package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_USER_SECURITY ����Ӧ��</p>
 * <p>Description:BASE_USER_SECURITY</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-02-14 14:33</p>
 * @author liuxd
 * @version 1.0
 */

public class BaseUserSecurity extends Ado
{
	private long id; //ID
	private long securityId; //ģ��Ȩ��ID
	private String securityArray; //Ȩ��ID��
	private int type; //����;1���û���2��ְ��3����ɫ
	private long departmentId; //����ID��0��ʾ���в���
	private long ownerId; //������ID��0��ʾ����
	private int sequ; //����


	public BaseUserSecurity()
	{
	}

	public BaseUserSecurity(long id)
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
	 * ��Ӧ�ֶΣ�[ģ��Ȩ��ID]  ���ͣ�NUMBER(12)
	 */
	public void setSecurityId(long securityId)
	{
		this.securityId = securityId;
	}

	/**
	 * ��Ӧ�ֶΣ�[ģ��Ȩ��ID]  ���ͣ�NUMBER(12)
	 */
	public long getSecurityId()
	{
		return this.securityId;
	}

	/**
	 * ��Ӧ�ֶΣ�[Ȩ��ID��]  ���ͣ�VARCHAR2(4000)
	 */
	public void setSecurityArray(String securityArray)
	{
		this.securityArray = securityArray;
	}

	/**
	 * ��Ӧ�ֶΣ�[Ȩ��ID��]  ���ͣ�VARCHAR2(4000)
	 */
	public String getSecurityArray()
	{
		return this.securityArray == null ? "" : this.securityArray;
	}

	/**
	 * ��Ӧ�ֶΣ�[����;1���û���2��ְ��3����ɫ]  ���ͣ�NUMBER(2)
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	/**
	 * ��Ӧ�ֶΣ�[����;1���û���2��ְ��3����ɫ]  ���ͣ�NUMBER(2)
	 */
	public int getType()
	{
		return this.type;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ID��0��ʾ���в���]  ���ͣ�NUMBER(12)
	 */
	public void setDepartmentId(long departmentId)
	{
		this.departmentId = departmentId;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ID��0��ʾ���в���]  ���ͣ�NUMBER(12)
	 */
	public long getDepartmentId()
	{
		return this.departmentId;
	}

	/**
	 * ��Ӧ�ֶΣ�[������ID��0��ʾ����]  ���ͣ�NUMBER(12)
	 */
	public void setOwnerId(long ownerId)
	{
		this.ownerId = ownerId;
	}

	/**
	 * ��Ӧ�ֶΣ�[������ID��0��ʾ����]  ���ͣ�NUMBER(12)
	 */
	public long getOwnerId()
	{
		return this.ownerId;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�NUMBER(8)
	 */
	public void setSequ(int sequ)
	{
		this.sequ = sequ;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�NUMBER(8)
	 */
	public int getSequ()
	{
		return this.sequ;
	}

	//===============================����Ϊ�Ա༭����===================================

	/**
	 * ��ȡ��������
	 * @return String
	 */
	public String getTypeName()
	{
		String value = "";
		if (type == 1)
		{
			value = "�û�";
		}
		else if (type == 2)
		{
			value = "ְ��";
		}
		else if (type == 3)
		{
			value = "��ɫ";
		}
		return value;
	}

	/**
	 * ��ȡ��������
	 * @return String
	 */
	public String getDepartmentName()
	{
		String value = "";
		if (departmentId == 0)
		{
			value = "����";
		}
		else
		{
			BaseDepartment baseDepartment = (BaseDepartment)new BaseDepartment().findById(departmentId);
			value = baseDepartment == null ? "" : baseDepartment.getName();
		}
		return value;
	}

	/**
	 * ��ȡӵ�ж�������
	 * @return String
	 */
	public String getOwnerName()
	{
		String value = "";
		if (ownerId == 0)
		{
			value = "����";
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
	 * ��ȡ������������
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
				value += "��" + baseSecurity.getName();
			}
			i++;
		}
		return value;
	}

	/**
	 * ͨ��ģ��ID�ź͹���ID����������е�Ȩ�޶���ڵ�
	 * @param securityId long		ģ��ID��
	 * @param idArray String[]		����ID����
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
	 * ͨ��ģ��ID�Ż���ID�������е�Ȩ�޶���ڵ�
	 * @param idArray String[]		����ID��ģ��ID����
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
	 * ͨ��ģ��ID�Ż���ID�������е�Ȩ�޶���ڵ�
	 * @param securityId long		ģ��ID�Ż���ID
	 * @return List
	 */
	public List findAllNode(long securityId)
	{
		String hql = "from BaseUserSecurity o where o.securityId=" + securityId + " or o.securityArray like '%{" + securityId + "}%'";
		return this.findAll(hql);
	}

	/**
	 * ͨ��ģ��ID�Ų������е�Ȩ�޶���
	 * @param securityId long
	 * @return List
	 */
	public List findAllBySecurityId(long securityId)
	{
		String hql = "from BaseUserSecurity o where o.securityId=" + securityId;
		return this.findAll(hql);
	}

}