package com.dhccity.base.entity;

import org.light.*;

/**
 * <p>Title: BASE_MESSAGE ���Ӧ��</p>
 * <p>Description:BASE_MESSAGE</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2005-05-30 16:40</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseMessage extends Ado
{
	private long id;	//ID
	private String code;	//����
	private String content;	//����
	private String explain;	//˵��

	public BaseMessage()
	{
	}

	public BaseMessage(long id)
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
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(20)
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(20)
	 */
	public String getCode()
	{
		return this.code == null ? "" : this.code;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(1000)
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(1000)
	 */
	public String getContent()
	{
		return this.content == null ? "" : this.content;
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
	 * ͨ��Code������Ϣ����
	 * @param code String
	 * @return BaseMessage
	 */
	public BaseMessage findByCode(String code)
	{
		String hql = "from BaseMessage o where o.code='" + code + "'";
		return (BaseMessage)this.findObject(hql);
	}

}
