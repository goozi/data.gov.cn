package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**wbtional
 * <p>Title: BASE_PARAMETER ���Ӧ��</p>
 * <p>Description:BASE_PARAMETER</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2005-06-16 08:42</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseParameter extends Ado
{
	private long id;	//ID
	private String name;	//���
	private String code;	//����
	private String value;	//ֵ
	private String unit;	//��λ
	private String type;	//����
	private String userNames;	//��Ȩ���û����
	private String userIds;		//��Ȩ���û�ID����
	private String explain;		//˵��

	public BaseParameter()
	{
	}

	public BaseParameter(long id)
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
	 * ��Ӧ�ֶΣ�[���]  ���ͣ�VARCHAR2(200)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * ��Ӧ�ֶΣ�[���]  ���ͣ�VARCHAR2(200)
	 */
	public String getName()
	{
		return this.name == null ? "" : this.name;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(100)
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(100)
	 */
	public String getCode()
	{
		return this.code == null ? "" : this.code;
	}

	/**
	 * ��Ӧ�ֶΣ�[ֵ]  ���ͣ�VARCHAR2(1000)
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

	/**
	 * ��Ӧ�ֶΣ�[ֵ]  ���ͣ�VARCHAR2(1000)
	 */
	public String getValue()
	{
		return this.value == null ? "" : this.value;
	}

	/**
	 * ��Ӧ�ֶΣ�[��λ]  ���ͣ�VARCHAR2(50)
	 */
	public void setUnit(String unit)
	{
		this.unit = unit;
	}

	/**
	 * ��Ӧ�ֶΣ�[��λ]  ���ͣ�VARCHAR2(50)
	 */
	public String getUnit()
	{
		return this.unit == null ? "" : this.unit;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(100)
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(100)
	 */
	public String getType()
	{
		return this.type == null ? "" : this.type;
	}

	/**
	 * ��Ӧ�ֶΣ�[��Ȩ���û����]  ���ͣ�VARCHAR2(4000)
	 */
	public void setUserNames(String userNames)
	{
		this.userNames = userNames;
	}

	/**
	 * ��Ӧ�ֶΣ�[��Ȩ���û����]  ���ͣ�VARCHAR2(4000)
	 */
	public String getUserNames()
	{
		return this.userNames == null ? "" : this.userNames;
	}

	/**
	 * ��Ӧ�ֶΣ�[��Ȩ���û�ID����]  ���ͣ�VARCHAR2(4000)
	 */
	public void setUserIds(String userIds)
	{
		this.userIds = userIds;
	}

	/**
	 * ��Ӧ�ֶΣ�[��Ȩ���û�ID����]  ���ͣ�VARCHAR2(4000)
	 */
	public String getUserIds()
	{
		return this.userIds == null ? "" : this.userIds;
	}

	/**
	 * ��Ӧ�ֶΣ�[˵��]  ���ͣ�VARCHAR2(1000)
	 */
	public void setExplain(String explain)
	{
		this.explain = explain;
	}

	/**
	 * ��Ӧ�ֶΣ�[˵��]  ���ͣ�VARCHAR2(1000)
	 */
	public String getExplain()
	{
		return this.explain == null ? "" : this.explain;
	}

	//===============================����Ϊ�Ա༭����===================================





	/**
	 * ����û�IDӵ�в���Ȩ�޵Ĳ�������б�
	 * @param  user User		�û�
	 * @param currPage int   	��ǰҳ��
	 * @param pageSize int      ÿҳ����
	 * @return List
	 */
	public List findPageByUser(User user, int currPage, int pageSize)
	{
		String hql = "from BaseParameter o where 1=1 ";
		if (!user.isProgrammer() && !user.isAdmin())
		{
			hql += " and o.userIds like '%{" + user.getId() + "}%'";
		}
		hql += "order by o.id desc";
		return this.findPage(hql, currPage, pageSize);
	}

	/**
	 * ͨ��Code��ò������
	 * @param code String		����
	 * @return BaseParameter
	 */
	public BaseParameter findByCode(String code)
	{

		String hql = "from BaseParameter o where o.code='" + code + "'";
		return (BaseParameter)this.findObject(hql);
	}

	/**
	 * ���ҷ�������ļ�¼��
	 * @param searchField String   		�����ֶ�
	 * @param searchValue String    	����ֵ
	 * @param  user User				�û�
	 * @param currPage int   			��ǰҳ��
	 * @param pageSize int        		ÿҳ����
	 * @return List
	 */
	public List search(String searchField, String searchValue, User user, int currPage, int pageSize)
	{
		String hql = "from BaseParameter o where " + searchField + " like '%" + searchValue + "%'";
		if (!user.isProgrammer() && !user.isAdmin())
		{
			hql += " and o.userIds like '%{" + user.getId() + "}%'";
		}
		hql += "order by o.id desc";
		return this.findPage(hql, currPage, pageSize);
	}

}
