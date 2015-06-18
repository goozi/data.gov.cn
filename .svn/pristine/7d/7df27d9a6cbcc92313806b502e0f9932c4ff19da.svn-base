package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_DOCUMENT ���Ӧ��</p>
 * <p>Description:BASE_DOCUMENT</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2005-05-23 11:35</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseDocument extends Ado
{
	private long id;	//ID
	private String name;	//��ʾ���
	private String fileName;	//ԭ���ļ����
	private String postfix;		//��׺
	private Date createTime;	//����ʱ��
	private String sourceCode;	//��Դ���
	private long sourceId;		//��ԴID
	private double sequ;		//˳��(��ʱû��)
	private long fileSize;		//�ļ���С
	private long userId;		//�û�ID

	public BaseDocument()
	{
	}

	public BaseDocument(long id)
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
	 * ��Ӧ�ֶΣ�[��ʾ���]  ���ͣ�VARCHAR2(200)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ʾ���]  ���ͣ�VARCHAR2(200)
	 */
	public String getName()
	{
		return this.name == null ? "" : this.name;
	}

	/**
	 * ��Ӧ�ֶΣ�[ԭ���ļ����]  ���ͣ�VARCHAR2(200)
	 */
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	/**
	 * ��Ӧ�ֶΣ�[ԭ���ļ����]  ���ͣ�VARCHAR2(200)
	 */
	public String getFileName()
	{
		return this.fileName == null ? "" : this.fileName;
	}

	/**
	 * ��Ӧ�ֶΣ�[��׺]  ���ͣ�VARCHAR2(100)
	 */
	public void setPostfix(String postfix)
	{
		this.postfix = postfix;
	}

	/**
	 * ��Ӧ�ֶΣ�[��׺]  ���ͣ�VARCHAR2(100)
	 */
	public String getPostfix()
	{
		return this.postfix == null ? "" : this.postfix;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ʱ��]  ���ͣ�DATE(7)
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ʱ��]  ���ͣ�DATE(7)
	 */
	public Date getCreateTime()
	{
		return this.createTime;
	}

	/**
	 * ��Ӧ�ֶΣ�[��Դ���]  ���ͣ�VARCHAR2(50)
	 */
	public void setSourceCode(String sourceCode)
	{
		this.sourceCode = sourceCode;
	}

	/**
	 * ��Ӧ�ֶΣ�[��Դ���]  ���ͣ�VARCHAR2(50)
	 */
	public String getSourceCode()
	{
		return this.sourceCode == null ? "" : this.sourceCode;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ԴID]  ���ͣ�NUMBER(12)
	 */
	public void setSourceId(long sourceId)
	{
		this.sourceId = sourceId;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ԴID]  ���ͣ�NUMBER(12)
	 */
	public long getSourceId()
	{
		return this.sourceId;
	}

	/**
	 * ��Ӧ�ֶΣ�[˳��(��ʱû��)]  ���ͣ�NUMBER(22)
	 */
	public void setSequ(double sequ)
	{
		this.sequ = sequ;
	}

	/**
	 * ��Ӧ�ֶΣ�[˳��(��ʱû��)]  ���ͣ�NUMBER(22)
	 */
	public double getSequ()
	{
		return this.sequ;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ļ���С]  ���ͣ�NUMBER(12)
	 */
	public void setFileSize(long fileSize)
	{
		this.fileSize = fileSize;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ļ���С]  ���ͣ�NUMBER(12)
	 */
	public long getFileSize()
	{
		return this.fileSize;
	}

	/**
	 * ��Ӧ�ֶΣ�[�û�ID]  ���ͣ�NUMBER(8)
	 */
	public void setUserId(long userId)
	{
		this.userId = userId;
	}

	/**
	 * ��Ӧ�ֶΣ�[�û�ID]  ���ͣ�NUMBER(8)
	 */
	public long getUserId()
	{
		return this.userId;
	}

	//===============================����Ϊ�Ա༭����===================================

	/**
	 * ͨ����Դ������ID�Ų������м�¼
	 * @param sourceCode String   ��Դ����
	 * @param sourceId long       ��ԴID
	 * @return List
	 */
	public List findBySource(String sourceCode, long sourceId)
	{
		String hql = "from BaseDocument o where o.sourceCode='" + sourceCode + "' and o.sourceId=" + sourceId + " order by o.id";
		return this.findAll(hql);
	}

	/**
	 * ͨ����Դ������ID�Ų������м�¼
	 * @param sourceCode String   ��Դ����
	 * @param sourceId long       ��ԴID
	 * @return List
	 */
	public List findBySource(String sourceCode, int userId, String name)
	{
		String hql = "from BaseDocument o where o.name like '%" + name + "%' and  o.sourceCode='" + sourceCode + "' and o.userId=" + userId + " order by o.id";
		return this.findAll(hql);
	}

}
