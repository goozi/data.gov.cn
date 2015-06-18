package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_SECURITY ����Ӧ��</p>
 * <p>Description:BASE_SECURITY</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-02-14 13:51</p>
 * @author liuxd
 * @version 1.0
 */

public class BaseSecurity extends TreeAdo implements Tree
{
	private long id; //ID
	private String name; //����
	private int state; //״̬��0��ʾ��Ч��1��ʾ��Ч
	private int sequ; //˳������
	private long parentId; //��ID��
	private String value; //ֵ[Ȩ�޴���]
	private int type; //���ͣ�1.ģ�飬2.Ȩ��
	private String description; //˵��
	private String meno; //��ע
	private int securityLevel; //��ȫ����0Ϊ��ͨ����,1Ϊ�����߿ɹ���

	//{defaultOrder = "o.id";} //Ĭ�ϵ�����ʽ

	public BaseSecurity()
	{

	}

	public BaseSecurity(long id)
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
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(200)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(200)
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
	 * ��Ӧ�ֶΣ�[ֵ[Ȩ�޴���]]  ���ͣ�VARCHAR2(100)
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

	/**
	 * ��Ӧ�ֶΣ�[ֵ[Ȩ�޴���]]  ���ͣ�VARCHAR2(100)
	 */
	public String getValue()
	{
		return this.value == null ? "" : this.value;
	}

	/**
	 * ��Ӧ�ֶΣ�[���ͣ�1.ģ�飬2.Ȩ��]  ���ͣ�NUMBER(2)
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	/**
	 * ��Ӧ�ֶΣ�[���ͣ�1.ģ�飬2.Ȩ��]  ���ͣ�NUMBER(2)
	 */
	public int getType()
	{
		return this.type;
	}

	/**
	 * ��Ӧ�ֶΣ�[˵��]  ���ͣ�VARCHAR2(1000)
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * ��Ӧ�ֶΣ�[˵��]  ���ͣ�VARCHAR2(1000)
	 */
	public String getDescription()
	{
		return this.description == null ? "" : this.description;
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
	 * ��Ӧ�ֶΣ�[��ȫ����0Ϊ��ͨ����,1Ϊ�����߿ɹ���]  ���ͣ�NUMBER(2)
	 */
	public void setSecurityLevel(int securityLevel)
	{
		this.securityLevel = securityLevel;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ȫ����0Ϊ��ͨ����,1Ϊ�����߿ɹ���]  ���ͣ�NUMBER(2)
	 */
	public int getSecurityLevel()
	{
		return this.securityLevel;
	}

	//===============================����Ϊ�Ա༭����===================================

	/**
	 * ͨ���ݹ鷽ʽ--�����ӽڵ㣬ʵ��TreeAdo�麯��--������Ȩ��
	 * @param parentId long		��ID
	 * @param state int			-1Ϊ���С�0Ϊ��Ч�ġ�1Ϊ��Ч��
	 * @param level int			����
	 */
	protected void loadChildNode(long parentId, int state, int level)
	{
		String hql = "from BaseSecurity o where o.type=1 and o.securityLevel=0 and o.parentId=" + parentId;
		if (state == 0 || state == 1)
		{
			hql += " and o.state=" + state;
		}
		hql += " order by o.sequ desc";
		List list = this.findAll(hql);
		Iterator it = list.iterator();
		if (list.size() > 0 && currIndex != -1)
		{
			( (BaseSecurity) treeVector.get(currIndex)).isLeaf = false;
		}
		while (it.hasNext())
		{
			BaseSecurity baseSecurity = (BaseSecurity) it.next();
			baseSecurity.setLevel(level);
			baseSecurity.isLeaf = true;
			treeVector.add(baseSecurity);
			currIndex++;
			loadChildNode(baseSecurity.getId(), state, level + 1); //�ݹ�
		}
	}

	/**
	 * ͨ��ģ��/���ܴ�����ҹ��ܽڵ�
	 * @param moduleCode String		ģ�����
	 * @param functionCode String	���ܴ���,����"||"��"&&"�Զ�����ܴ�����и���
	 * @return BaseSecurity
	 */
	public List findNodeByCode(String moduleCode, String functionCode)
	{
		String functionSql = "";
		if (functionCode.indexOf("||") != -1)
		{
			String[] temp = functionCode.split("||");
			for (int i = 0; i < temp.length; i++)
			{
				if (i == 0)
				{
					functionSql += " o.value='" + temp[i] + "'";
				}
				else
				{
					functionSql += " or o.value='" + temp[i] + "'";
				}
			}
		}
		else if (functionCode.indexOf("&&") != -1)
		{
			String[] temp = functionCode.split("&&");
			for (int i = 0; i < temp.length; i++)
			{
				if (i == 0)
				{
					functionSql += " o.value='" + temp[i] + "'";
				}
				else
				{
					functionSql += " and o.value='" + temp[i] + "'";
				}
			}
		}
		else
		{
			functionSql = " o.value='" + functionCode + "'";
		}
		String hql = "from BaseSecurity o where o.type=2 and o.state=1 and (" + functionSql + ") and o.parentId in (select e.id from BaseSecurity e where e.type=1 and e.value='" + moduleCode + "')";
		return this.findAll(hql);
	}

	/**
	 * ͨ����ַ���ҹ��ܽڵ�
	 * @param url String		��ַ
	 * @param query String		�������
	 * @return List
	 */
	public List findNodeByUrl(String url, String query)
	{
		String hql = "from BaseSecurity o where o.state=1 and";
		String strAnd=getSqlString("+");
		hql += " o.id in (select e.securityId from BaseSecurityUrl e where '" + url + "' like '%' " + strAnd + " e.url  " + strAnd + "  '%'";
		hql += " and '" + query + "' like '%'  " + strAnd + "  e.query  " + strAnd + "  '%')";
		return this.findAll(hql);
	}

	/**
	 * ͨ��ID������ҹ��ܽڵ�
	 * @param idArray String[]
	 * @return List
	 */
	public List findNodeByIdArray(String[] idArray)
	{
		String hql = "from BaseSecurity o where o.state=1 and (1<>1";
		for (int i = 0; i < idArray.length; i++)
		{
			hql += " or o.id=" + idArray[i];
		}
		hql += ")";
		return this.findAll(hql);
	}

	/**
	 * �������нڵ�--��������˳��--����Ȩ��
	 * @param state int	-1Ϊ���С�0Ϊ��Ч�ġ�1Ϊ��Ч��
	 * @return List
	 */
	public List findAllItem(int state)
	{
		treeVector = new Vector<Object>();
		currIndex = -1;
		loadChilItem(0, state, 0);
		return treeVector;
	}

	/**
	 * ͨ���ݹ鷽ʽ--�����ӽڵ㣬����Ȩ��
	 * @param parentId long		��ID
	 * @param state int			-1Ϊ���С�0Ϊ��Ч�ġ�1Ϊ��Ч��
	 * @param level int			����
	 */
	protected void loadChilItem(long parentId, int state, int level)
	{
		String hql = "from BaseSecurity o where o.parentId=" + parentId;
		if (state == 0 || state == 1)
		{
			hql += " and o.state=" + state;
		}
		hql += " order by o.sequ desc";
		List list = this.findAll(hql);
		Iterator it = list.iterator();
		if (list.size() > 0 && currIndex != -1)
		{
			( (BaseSecurity) treeVector.get(currIndex)).isLeaf = false;
		}
		while (it.hasNext())
		{
			BaseSecurity baseSecurity = (BaseSecurity) it.next();
			baseSecurity.setLevel(level);
			baseSecurity.isLeaf = true;
			treeVector.add(baseSecurity);
			currIndex++;
			loadChilItem(baseSecurity.getId(), state, level + 1); //�ݹ�
		}
	}

	/**
	 * �Ƿ�ӵ����Ȩ��
	 * @return boolean
	 */
	public static boolean isChildSecurity(long id)
	{
		String hql = "from BaseSecurity o where o.type=2 and o.state=1 and o.parentId=" + id;
		return new BaseSecurity().findObject(hql) == null ? false : true;

	}

	/**
	 * ͨ��parentId������Ȩ��
	 * @param id long
	 * @return boolean
	 */
	public List findChildByParentId(long id)
	{
		String hql = "from BaseSecurity o where o.type=2 and o.state=1 and o.parentId=" + id;
		return this.findAll(hql);

	}

	/**
	 * �������Ƿ��Ѵ���--���ڷ���true
	 * @param code String		����
	 * @param id long			ID��
	 * @return boolean
	 */
	public static boolean isHadCode(long id, String code, long parentId, int type)
	{
		String hql = "from BaseSecurity o where o.value='" + code + "' and o.id!=" + id;

		if (type == 1)
		{
			hql += " and o.type=1";
		}
		else
		{
			hql += " and o.type=2 and o.parentId=" + parentId;
		}
		Object object = new BaseSecurity().findObject(hql);
		return object != null;
	}

}