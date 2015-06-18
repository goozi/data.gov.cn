package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_DEPARTMENT ���Ӧ��</p>
 * <p>Description:BASE_DEPARTMENT</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-04-11 12:38</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseDepartment extends TreeAdo implements Tree
{
	private long id; //ID
	private String name; //���
	private int state; //״̬��0��ʾ��Ч��1��ʾ��Ч
	private int sequ; //˳������
	private long parentId; //��ID��
	private long leaderId; //���Ÿ�����
	private String code; //�����
	private String fullName; //����ȫ��
	private long mainLevel; //���ż���1
	private long subLevel; //���ż���2
	private long property; //��������
	private String address; //��ַ
	private String postCode; //�ʱ�
	private String canton; //��������
	private String tel; //�绰
	private String fax; //����
	private String explain; //˵��
	private String meno; //��ע

	//{defaultOrder = "o.id";} //Ĭ�ϵ�����ʽ

	public BaseDepartment()
	{
	}

	public BaseDepartment(long id)
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
	 * ��Ӧ�ֶΣ�[״̬��0��ʾ��Ч��1��ʾ��Ч]  ���ͣ�NUMBER(1)
	 */
	public void setState(int state)
	{
		this.state = state;
	}

	/**
	 * ��Ӧ�ֶΣ�[״̬��0��ʾ��Ч��1��ʾ��Ч]  ���ͣ�NUMBER(1)
	 */
	public int getState()
	{
		return this.state;
	}

	/**
	 * ��Ӧ�ֶΣ�[˳������]  ���ͣ�NUMBER(4)
	 */
	public void setSequ(int sequ)
	{
		this.sequ = sequ;
	}

	/**
	 * ��Ӧ�ֶΣ�[˳������]  ���ͣ�NUMBER(4)
	 */
	public int getSequ()
	{
		return this.sequ;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ID��]  ���ͣ�NUMBER(12)
	 */
	public void setParentId(long parentId)
	{
		this.parentId = parentId;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ID��]  ���ͣ�NUMBER(12)
	 */
	public long getParentId()
	{
		return this.parentId;
	}

	/**
	 * ��Ӧ�ֶΣ�[���Ÿ�����]  ���ͣ�NUMBER(12)
	 */
	public void setLeaderId(long leaderId)
	{
		this.leaderId = leaderId;
	}

	/**
	 * ��Ӧ�ֶΣ�[���Ÿ�����]  ���ͣ�NUMBER(12)
	 */
	public long getLeaderId()
	{
		return this.leaderId;
	}

	/**
	 * ��Ӧ�ֶΣ�[�����]  ���ͣ�VARCHAR2(50)
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * ��Ӧ�ֶΣ�[�����]  ���ͣ�VARCHAR2(50)
	 */
	public String getCode()
	{
		return this.code == null ? "" : this.code;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ȫ��]  ���ͣ�VARCHAR2(300)
	 */
	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ȫ��]  ���ͣ�VARCHAR2(300)
	 */
	public String getFullName()
	{
		return this.fullName == null ? "" : this.fullName;
	}

	/**
	 * ��Ӧ�ֶΣ�[���ż���1]  ���ͣ�NUMBER(12)
	 */
	public void setMainLevel(long mainLevel)
	{
		this.mainLevel = mainLevel;
	}

	/**
	 * ��Ӧ�ֶΣ�[���ż���1]  ���ͣ�NUMBER(12)
	 */
	public long getMainLevel()
	{
		return this.mainLevel;
	}

	/**
	 * ��Ӧ�ֶΣ�[���ż���2]  ���ͣ�NUMBER(12)
	 */
	public void setSubLevel(long subLevel)
	{
		this.subLevel = subLevel;
	}

	/**
	 * ��Ӧ�ֶΣ�[���ż���2]  ���ͣ�NUMBER(12)
	 */
	public long getSubLevel()
	{
		return this.subLevel;
	}

	/**
	 * ��Ӧ�ֶΣ�[��������]  ���ͣ�NUMBER(12)
	 */
	public void setProperty(long property)
	{
		this.property = property;
	}

	/**
	 * ��Ӧ�ֶΣ�[��������]  ���ͣ�NUMBER(12)
	 */
	public long getProperty()
	{
		return this.property;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ַ]  ���ͣ�VARCHAR2(250)
	 */
	public void setAddress(String address)
	{
		this.address = address;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ַ]  ���ͣ�VARCHAR2(250)
	 */
	public String getAddress()
	{
		return this.address == null ? "" : this.address;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ʱ�]  ���ͣ�VARCHAR2(6)
	 */
	public void setPostCode(String postCode)
	{
		this.postCode = postCode;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ʱ�]  ���ͣ�VARCHAR2(6)
	 */
	public String getPostCode()
	{
		return this.postCode == null ? "" : this.postCode;
	}

	/**
	 * ��Ӧ�ֶΣ�[��������]  ���ͣ�VARCHAR2(50)
	 */
	public void setCanton(String canton)
	{
		this.canton = canton;
	}

	/**
	 * ��Ӧ�ֶΣ�[��������]  ���ͣ�VARCHAR2(50)
	 */
	public String getCanton()
	{
		return this.canton == null ? "" : this.canton;
	}

	/**
	 * ��Ӧ�ֶΣ�[�绰]  ���ͣ�VARCHAR2(50)
	 */
	public void setTel(String tel)
	{
		this.tel = tel;
	}

	/**
	 * ��Ӧ�ֶΣ�[�绰]  ���ͣ�VARCHAR2(50)
	 */
	public String getTel()
	{
		return this.tel == null ? "" : this.tel;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(50)
	 */
	public void setFax(String fax)
	{
		this.fax = fax;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(50)
	 */
	public String getFax()
	{
		return this.fax == null ? "" : this.fax;
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

	/**
	 * ��Ӧ�ֶΣ�[��ע,��ʾͼ���ļ����]  ���ͣ�VARCHAR2(1000)
	 */
	public void setMeno(String meno)
	{
		this.meno = meno;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ע,��ʾͼ���ļ����]  ���ͣ�VARCHAR2(1000)
	 */
	public String getMeno()
	{
		return this.meno == null ? "" : this.meno;
	}

	//===============================����Ϊ�Ա༭����===================================

	/**
	 * ��ȡ�ڵ�ֵ
	 * @return String
	 */
	public String getValue()
	{
		return this.name;
	}

	/**
	 * ����쵼���
	 * @return String
	 */
	public String getLeaderName()
	{
		BaseUser baseUser = (BaseUser)new BaseUser().findById(this.leaderId);
		return baseUser == null ? "" : baseUser.getName();
	}

	/**
	 * ����ϼ��������
	 * @return String
	 */
	public String getParentName()
	{
		BaseDepartment baseDepartment = (BaseDepartment)new BaseDepartment().findById(this.parentId);
		return baseDepartment == null ? "" : baseDepartment.getName();
	}

	/**
	 * ͨ��ݹ鷽ʽ--�����ӽڵ㣬ʵ��TreeAdo�麯��
	 * @param parentId long		��ID
	 * @param state int			-1Ϊ���С�0Ϊ��Ч�ġ�1Ϊ��Ч��
	 * @param level int			����
	 */
	protected void loadChildNode(long parentId, int state, int level)
	{
		String hql = "from BaseDepartment o where o.parentId=" + parentId;
		if (state == 0 || state == 1)
		{
			hql += " and o.state=" + state;
		}
		hql += " order by o.sequ desc";
		List list = this.findAll(hql);
		Iterator it = list.iterator();
		if (list.size() > 0 && currIndex != -1)
		{
			( (BaseDepartment) treeVector.get(currIndex)).isLeaf = false;
		}
		while (it.hasNext())
		{
			BaseDepartment baseDepartment = (BaseDepartment) it.next();
			baseDepartment.setLevel(level);
			baseDepartment.isLeaf = true;
			treeVector.add(baseDepartment);
			currIndex++;
			loadChildNode(baseDepartment.getId(), state, level + 1); //�ݹ�
		}
	}

}
