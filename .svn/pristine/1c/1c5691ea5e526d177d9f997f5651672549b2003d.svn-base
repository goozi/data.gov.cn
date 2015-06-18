package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_LOG ���Ӧ��</p>
 * <p>Description:BASE_LOG</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2007-01-15 16:55</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseLog extends Ado
{
	private long id; //ID
	private long userId; //�û�ID
	private String content; //��������
	private String ip; //IP��ַ
	private Date nodeTime; //��¼ʱ��
	private String pcName; //�������
	private String meno; //��ע
	private String systemName; //ϵͳ���
	private String moduleName; //ģ�����
	private String userName; //�û����

	//{defaultOrder = "o.id";} //Ĭ�ϵ�����ʽ

	public BaseLog()
	{
	}

	public BaseLog(long id)
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
	 * ��Ӧ�ֶΣ�[��������]  ���ͣ�VARCHAR2(200)
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	/**
	 * ��Ӧ�ֶΣ�[��������]  ���ͣ�VARCHAR2(200)
	 */
	public String getContent()
	{
		return this.content == null ? "" : this.content;
	}

	/**
	 * ��Ӧ�ֶΣ�[IP��ַ]  ���ͣ�VARCHAR2(20)
	 */
	public void setIp(String ip)
	{
		this.ip = ip;
	}

	/**
	 * ��Ӧ�ֶΣ�[IP��ַ]  ���ͣ�VARCHAR2(20)
	 */
	public String getIp()
	{
		return this.ip == null ? "" : this.ip;
	}

	/**
	 * ��Ӧ�ֶΣ�[��¼ʱ��]  ���ͣ�DATE(7)
	 */
	public void setNodeTime(Date nodeTime)
	{
		this.nodeTime = nodeTime;
	}

	/**
	 * ��Ӧ�ֶΣ�[��¼ʱ��]  ���ͣ�DATE(7)
	 */
	public Date getNodeTime()
	{
		return this.nodeTime;
	}

	/**
	 * ��Ӧ�ֶΣ�[�������]  ���ͣ�VARCHAR2(50)
	 */
	public void setPcName(String pcName)
	{
		this.pcName = pcName;
	}

	/**
	 * ��Ӧ�ֶΣ�[�������]  ���ͣ�VARCHAR2(50)
	 */
	public String getPcName()
	{
		return this.pcName == null ? "" : this.pcName;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ע]  ���ͣ�VARCHAR2(1000)
	 */
	public void setMeno(String meno)
	{
		this.meno = meno;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ע]  ���ͣ�VARCHAR2(1000)
	 */
	public String getMeno()
	{
		return this.meno == null ? "" : this.meno;
	}

	/**
	 * ��Ӧ�ֶΣ�[ϵͳ���]  ���ͣ�VARCHAR2(200)
	 */
	public void setSystemName(String systemName)
	{
		this.systemName = systemName;
	}

	/**
	 * ��Ӧ�ֶΣ�[ϵͳ���]  ���ͣ�VARCHAR2(200)
	 */
	public String getSystemName()
	{
		return this.systemName == null ? "" : this.systemName;
	}

	/**
	 * ��Ӧ�ֶΣ�[ģ�����]  ���ͣ�VARCHAR2(200)
	 */
	public void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}

	/**
	 * ��Ӧ�ֶΣ�[ģ�����]  ���ͣ�VARCHAR2(200)
	 */
	public String getModuleName()
	{
		return this.moduleName == null ? "" : this.moduleName;
	}

	/**
	 * ��Ӧ�ֶΣ�[�û����]  ���ͣ�VARCHAR2(1000)
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	/**
	 * ��Ӧ�ֶΣ�[�û����]  ���ͣ�VARCHAR2(1000)
	 */
	public String getUserName()
	{
		return this.userName == null ? "" : this.userName;
	}

	//===============================����Ϊ�Ա༭����===================================

	/**
	 * ���ҷ�������ļ�¼��
	 * @param searchField String �����ֶ�
	 * @param searchValue String ����ֵ
	 * @param startTime Date    ��ʼʱ��
	 * @param endTime Date      ����ʱ��
	 * @param currPage int      ��ǰҳ��
	 * @param pageSize int      ÿҳ����
	 * @return List
	 */
	public List search(String searchField, String searchValue, Date startTime, Date endTime, int currPage, int pageSize)
	{
		String sql = "from BaseLog o where o." + searchField + " like '%" + searchValue + "%'";
		if (startTime != null)
		{
			sql += " and o.nodeTime>=" + filterTime(startTime);
		}
		if (endTime != null)
		{
			sql += " and o.nodeTime<=" + filterTime(endTime);
		}
		sql += " order by o.id desc";
		return this.findPage(sql, currPage, pageSize);
	}

}
