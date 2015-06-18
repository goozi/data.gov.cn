package com.dhccity.base.entity;

import org.light.*;

/**
 * <p>Title: BASE_DOCUMENT_TYPE ���Ӧ��</p>
 * <p>Description:BASE_DOCUMENT_TYPE</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2005-05-20 17:26</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseDocumentType extends Ado
{
	private long id;	//ID
	private String postfix;		//��׺
	private String icon;		//ͼ���ļ����
	private String type;		//�ļ�����
	private String mime;		//�ļ������

	public BaseDocumentType()
	{
	}

	public BaseDocumentType(long id)
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
	 * ��Ӧ�ֶΣ�[��׺]  ���ͣ�VARCHAR2(200)
	 */
	public void setPostfix(String postfix)
	{
		this.postfix = postfix;
	}

	/**
	 * ��Ӧ�ֶΣ�[��׺]  ���ͣ�VARCHAR2(200)
	 */
	public String getPostfix()
	{
		return this.postfix == null ? "" : this.postfix;
	}

	/**
	 * ��Ӧ�ֶΣ�[��׺]  ���ͣ�VARCHAR2(200)
	 */
	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	/**
	 * ��Ӧ�ֶΣ�[��׺]  ���ͣ�VARCHAR2(200)
	 */
	public String getIcon()
	{
		return this.icon == null ? "" : this.icon;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ļ�����]  ���ͣ�VARCHAR2(200)
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ļ�����]  ���ͣ�VARCHAR2(200)
	 */
	public String getType()
	{
		return this.type == null ? "" : this.type;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ļ������]  ���ͣ�VARCHAR2(200)
	 */
	public void setMime(String mime)
	{
		this.mime = mime;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ļ������]  ���ͣ�VARCHAR2(200)
	 */
	public String getMime()
	{
		return this.mime == null ? "" : this.mime;
	}

	//===============================����Ϊ�Ա༭����===================================

	/**
	 * ͨ���׺���ͻ������ͼ���ļ����
	 * @param postfix String
	 * @return BaseDocumentType
	 */
	public BaseDocumentType findByPostfix(String postfix)
	{
		String hql = "from BaseDocumentType o where o.postfix='" + postfix.toUpperCase() + "'";
		return (BaseDocumentType)this.findObject(hql);
	}

}
