package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_MENU ���Ӧ��</p>
 * <p>Description:BASE_MENU</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-02-21 16:42</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseMenu extends TreeAdo implements Tree
{
	private long id; //ID
	private String name; //���
	private int state; //״̬��0��ʾ��Ч��1��ʾ��Ч
	private int sequ; //˳������
	private long parentId; //��ID��
	private String value; //ֵ[���ӵ�ַ]
	private String target; //Ŀ��
	private long securityId; //��ȫID
	private String explain; //˵��
	private String meno; //��ע

	public BaseMenu()
	{
	}

	public BaseMenu(long id)
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
	 * ��Ӧ�ֶΣ�[ֵ[���ӵ�ַ]]  ���ͣ�VARCHAR2(100)
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

	/**
	 * ��Ӧ�ֶΣ�[ֵ[���ӵ�ַ]]  ���ͣ�VARCHAR2(100)
	 */
	public String getValue()
	{
		return this.value == null ? "" : this.value;
	}

	/**
	 * ��Ӧ�ֶΣ�[Ŀ��]  ���ͣ�VARCHAR2(100)
	 */
	public void setTarget(String target)
	{
		this.target = target;
	}

	/**
	 * ��Ӧ�ֶΣ�[Ŀ��]  ���ͣ�VARCHAR2(100)
	 */
	public String getTarget()
	{
		return this.target == null ? "" : this.target;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ȫID]  ���ͣ�NUMBER(12)
	 */
	public void setSecurityId(long securityId)
	{
		this.securityId = securityId;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ȫID]  ���ͣ�NUMBER(12)
	 */
	public long getSecurityId()
	{
		return this.securityId;
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

	//===============================����Ϊ�Ա༭����===================================

	/**
	 * ͨ��ݹ鷽ʽ--�����ӽڵ㣬ʵ��TreeAdo�麯��
	 * @param parentId long		��ID
	 * @param state int			-1Ϊ���С�0Ϊ��Ч�ġ�1Ϊ��Ч��
	 * @param level int			����
	 */
	protected void loadChildNode(long parentId, int state, int level)
	{
		String hql = "from BaseMenu o where o.parentId=" + parentId;
		if (state == 0 || state == 1)
		{
			hql += " and o.state=" + state;
		}
		hql += " order by o.sequ desc";
		List list = this.findAll(hql);
		Iterator it = list.iterator();
		if (list.size() > 0 && currIndex != -1)
		{
			( (BaseMenu) treeVector.get(currIndex)).isLeaf = false;
		}
		while (it.hasNext())
		{
			BaseMenu baseMenu = (BaseMenu) it.next();
			baseMenu.setLevel(level);
			baseMenu.isLeaf = true;
			treeVector.add(baseMenu);
			currIndex++;
			loadChildNode(baseMenu.getId(), state, level + 1); //�ݹ�
		}
	}

	/**
	 * ��ȡȨ�޶���
	 * @return String
	 */
	public String getSecurityName()
	{
		BaseSecurity baseSecurity = (BaseSecurity)new BaseSecurity().findById(this.securityId);
		return baseSecurity == null ? "" : baseSecurity.getName();
	}

}
