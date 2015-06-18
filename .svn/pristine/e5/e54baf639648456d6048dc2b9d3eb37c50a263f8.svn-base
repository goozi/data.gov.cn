package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_SECURITY_URL ���Ӧ��</p>
 * <p>Description:BASE_SECURITY_URL</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2007-01-10 09:18</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseSecurityUrl extends Ado
{
	private long id; //ID
	private long securityId; //ģ��Ȩ��ID
	private String url; //��ַ
	private String query; //�������

	//{defaultOrder = "o.id";} //Ĭ�ϵ�����ʽ

	public BaseSecurityUrl()
	{
	}

	public BaseSecurityUrl(long id)
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
	 * ��Ӧ�ֶΣ�[��ַ]  ���ͣ�VARCHAR2(200)
	 */
	public void setUrl(String url)
	{
		this.url = url;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ַ]  ���ͣ�VARCHAR2(200)
	 */
	public String getUrl()
	{
		return this.url == null ? "" : this.url;
	}

	/**
	 * ��Ӧ�ֶΣ�[�������]  ���ͣ�VARCHAR2(200)
	 */
	public void setQuery(String query)
	{
		this.query = query;
	}

	/**
	 * ��Ӧ�ֶΣ�[�������]  ���ͣ�VARCHAR2(200)
	 */
	public String getQuery()
	{
		return this.query == null ? "" : this.query;
	}

	//===============================����Ϊ�Ա༭����===================================




	/**
	 * ͨ��Ȩ��ID�Ų��������ַ
	 * @param  securityId long		Ȩ��ID��
	 * @return List
	 */
	public List findBySecurityId(long securityId)
	{
		String hql = "from BaseSecurityUrl o where o.securityId=" + securityId + " order by o.id";
		return this.findAll(hql);
	}

	/**
	 * ͨ��Ȩ��ID��ɾ�����
	 * @param securityId long	Ȩ��ID
	 * @param ids		 long[]	ID����
	 * @return int
	 */
	public static int deleteBySecurityId(long securityId, long[] ids)
	{
		String sql = "delete from Base_Security_Url  where security_Id=" + securityId;
		for (int i = 0; i < ids.length; i++)
		{
			if (ids[i] > 0)
			{
				sql += " and id<>" + ids[i];
			}
		}
		return new BaseSecurityUrl().executeSql(sql);
	}

}
