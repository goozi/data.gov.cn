package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_TYPE ���Ӧ��</p>
 * <p>Description:BASE_TYPE</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2007-01-15 12:44</p>
 * @author liuxd
 * @version 1.0
 */

public class BaseType extends Ado
{
	private long id; //ID
	private String name; //����
	private String code; //����
	private int state; //״̬��0��ʾ��Ч��1��ʾ��Ч
	private int isDefault; //�Ƿ�Ĭ�ϣ�0��ʾ���ǡ�1��ʾĬ��
	private int sequ; //˳������
	private long parentId; //��ID��
	private String userNames; //������ʵ��û�������
	private String userIds; //������ʵ��û�ID����
	private String value; //ֵ
	private String type; //NORMAL��ͨ��TREE��
	private String description; //˵��
	private String meno; //��ע
	private int securityLevel; //��ȫ����0Ϊ��ͨ����,1Ϊ�����߿ɹ���,2Ϊ�����͹����в��ܹ���
	private int isParent; //�Ƿ�Ϊ���ֵ䣬1��ʾ��,0��ʾ����

	protected int level = 0; //����
	protected String levelString = ""; //�����ı���ʾ�ַ���
	protected String levelHtml = ""; //������ҳ��ʾ�ַ���
	protected Vector<BaseType> treeVector = new Vector<BaseType>(); //���ͽڵ��б�
	protected int currIndex = -1; //��ǰ�ڵ�����
	protected boolean isLeaf = true; //�Ƿ�ΪҶ�ӽڵ�

	//{defaultOrder = "o.id";} //Ĭ�ϵ�����ʽ

	public BaseType()
	{
	}

	public BaseType(long id)
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
	 * ��Ӧ�ֶΣ�[�Ƿ�Ĭ�ϣ�0��ʾ���ǡ�1��ʾĬ��]  ���ͣ�NUMBER(1)
	 */
	public void setIsDefault(int isDefault)
	{
		this.isDefault = isDefault;
	}

	/**
	 * ��Ӧ�ֶΣ�[�Ƿ�Ĭ�ϣ�0��ʾ���ǡ�1��ʾĬ��]  ���ͣ�NUMBER(1)
	 */
	public int getIsDefault()
	{
		return this.isDefault;
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
	 * ��Ӧ�ֶΣ�[������ʵ��û�������]  ���ͣ�VARCHAR2(4000)
	 */
	public void setUserNames(String userNames)
	{
		this.userNames = userNames;
	}

	/**
	 * ��Ӧ�ֶΣ�[������ʵ��û�������]  ���ͣ�VARCHAR2(4000)
	 */
	public String getUserNames()
	{
		return this.userNames == null ? "" : this.userNames;
	}

	/**
	 * ��Ӧ�ֶΣ�[������ʵ��û�ID����]  ���ͣ�VARCHAR2(4000)
	 */
	public void setUserIds(String userIds)
	{
		this.userIds = userIds;
	}

	/**
	 * ��Ӧ�ֶΣ�[������ʵ��û�ID����]  ���ͣ�VARCHAR2(4000)
	 */
	public String getUserIds()
	{
		return this.userIds == null ? "" : this.userIds;
	}

	/**
	 * ��Ӧ�ֶΣ�[ֵ]  ���ͣ�VARCHAR2(100)
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

	/**
	 * ��Ӧ�ֶΣ�[ֵ]  ���ͣ�VARCHAR2(100)
	 */
	public String getValue()
	{
		return this.value == null ? "" : this.value;
	}

	/**
	 * ��Ӧ�ֶΣ�[NORMAL��ͨ��TREE��]  ���ͣ�VARCHAR2(20)
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * ��Ӧ�ֶΣ�[NORMAL��ͨ��TREE��]  ���ͣ�VARCHAR2(20)
	 */
	public String getType()
	{
		return this.type == null ? "" : this.type;
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
	 * ��Ӧ�ֶΣ�[��ȫ����0Ϊ��ͨ����,1Ϊ�����߿ɹ���,2Ϊ�����͹����в��ܹ���]  ���ͣ�NUMBER(2)
	 */
	public void setSecurityLevel(int securityLevel)
	{
		this.securityLevel = securityLevel;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ȫ����0Ϊ��ͨ����,1Ϊ�����߿ɹ���,2Ϊ�����͹����в��ܹ���]  ���ͣ�NUMBER(2)
	 */
	public int getSecurityLevel()
	{
		return this.securityLevel;
	}

	/**
	 * �Ƿ�Ϊ���ֵ䣬1��ʾ��,0��ʾ����
	 */
	public void setIsParent(int isParent)
	{
		this.isParent = isParent;
	}

	/**
	 * �Ƿ�Ϊ���ֵ䣬1��ʾ��,0��ʾ����
	 */
	public int getIsParent()
	{
		return this.isParent;
	}

	//===============================����Ϊ�Ա༭����===================================

	/**
	 * ��ȡ����
	 * @return long		0Ϊ��һ��
	 */
	public long getLevel()
	{
		return this.level;
	}

	/**
	 * ��ȡ�����ı�
	 * @return String
	 */
	public String getLevelString()
	{
		return this.levelString;
	}

	/**
	 * ��ȡ������ҳ�ַ���
	 * @return String
	 */
	public String getLevelHtml()
	{
		return this.levelHtml;
	}

	/**
	 * �ж϶����Ƿ�Ϊҳ�ӽڵ�
	 * @return boolean   trueΪҶ�ӽڵ㣬false����Ҷ�ӽڵ�
	 */
	public boolean isLeaf()
	{
		return this.isLeaf;
	}

	/**
	 * ���ü����뼶���ı�
	 * @param level int  �ı�
	 */
	private void setLevel(int level)
	{
		this.level = level;
		String strLine = "�� ";
		for (int i = 0; i < level; i++)
		{
			strLine = "��" + strLine;
			levelHtml += "&nbsp;&nbsp;";
		}
		this.levelString = strLine;
	}

	/**
	 * ͨ���û���ȡ�����ֵ����б�
	 * @param user User		�û�����
	 * @return List
	 */
	public List findAllParentType(User user)
	{
		String hql = "from BaseType o where o.code='PARENT_TYPE' and o.isParent=1 and o.parentId=-1";
		BaseType baseType = (BaseType)this.findObject(hql);
		treeVector = new Vector<BaseType>();
		currIndex = -1;
		loadParentType(user, baseType.getId(), 0);
		return treeVector;
	}

	/**
	 * ���������ֵ����б����ͣ�
	 * @param user User			�û�����
	 * @param parentId long		�ֵ���ID
	 * @param level int			����
	 */
	private void loadParentType(User user, long parentId, int level)
	{
		String hql = "from BaseType o where o.parentId=" + parentId;

		//�Ƿ����Ա���
		if (user.isProgrammer())
		{
			hql += " and o.securityLevel<2";
		}
		else
		{
			hql += " and o.securityLevel<1";
		}

		//���ǹ���Ա
		if (!user.isAdmin())
		{
			hql += " and o.userIds like '%{" + user.getId() + "}%'";
		}
		hql += " and o.state=1 and o.isParent=1 order by o.sequ desc";
		List list = this.findAll(hql);
		Iterator it = list.iterator();
		if (list.size() > 0 && currIndex != -1)
		{
			( (BaseType) treeVector.get(currIndex)).isLeaf = false;
		}
		while (it.hasNext())
		{
			BaseType baseType = (BaseType) it.next();
			baseType.setLevel(level);
			baseType.isLeaf = true;
			treeVector.add(baseType);
			currIndex++;
			loadParentType(user, baseType.getId(), level + 1); //�ݹ�
		}
	}

	/**
	 * ͨ���û���״̬��ȡ�����ֵ����б�
	 * @param user  User		�û�����
	 * @param state int			״̬
	 * @return List
	 */
	public List findAllParentType(User user, int state)
	{
		String hql = "from BaseType o where o.code='PARENT_TYPE' and o.isParent=1 and o.parentId=-1";
		BaseType baseType = (BaseType)this.findObject(hql);
		treeVector = new Vector<BaseType>();
		currIndex = -1;
		loadParentType(user, state, baseType.getId(), 0);
		return treeVector;
	}

	/**
	 * ���������ֵ����б����ͣ�
	 * @param user User			�û�����
	 * @param state int			״̬
	 * @param parentId long		�ֵ���ID
	 * @param level int			����
	 */
	private void loadParentType(User user, int state, long parentId, int level)
	{
		String hql = "from BaseType o where o.parentId=" + parentId;

		//�Ƿ����Ա���
		if (user.isProgrammer())
		{
			hql += " and o.securityLevel<2";
		}
		else
		{
			hql += " and o.securityLevel<1";
		}
		if (state == 0 || state == 1)
		{
			hql += " and o.state=" + state;
		}
		hql += " and o.isParent=1 order by o.sequ desc";
		List list = this.findAll(hql);
		Iterator it = list.iterator();
		if (list.size() > 0 && currIndex != -1)
		{
			( (BaseType) treeVector.get(currIndex)).isLeaf = false;
		}
		while (it.hasNext())
		{
			BaseType baseType = (BaseType) it.next();
			baseType.setLevel(level);
			baseType.isLeaf = true;
			treeVector.add(baseType);
			currIndex++;
			loadParentType(user, state, baseType.getId(), level + 1); //�ݹ�
		}
	}

	/**
	 * ͨ���û���ȡ�����ֵ����б�
	 * @param state
	 * @return List
	 */
	public List findAllParentType(int state)
	{
		String hql = "from BaseType o where o.code='PARENT_TYPE' and o.isParent=1 and o.parentId=-1";
		BaseType baseType = (BaseType)this.findObject(hql);
		treeVector = new Vector<BaseType>();
		currIndex = -1;
		loadParentType(state, baseType.getId(), 0);
		return treeVector;
	}

	/**
	 * ���������ֵ����б����ͣ�
	 * @param state
	 * @param parentId long		�ֵ���ID
	 * @param level int			����
	 */
	private void loadParentType(int state, long parentId, int level)
	{
		String hql = "from BaseType o where o.parentId=" + parentId;
		hql += " and o.securityLevel<1";
		if (state == 0 || state == 1)
		{
			hql += " and o.state=" + state;
		}

		hql += "  and o.isParent=1 order by o.sequ desc";
		List list = this.findAll(hql);
		Iterator it = list.iterator();
		if (list.size() > 0 && currIndex != -1)
		{
			( (BaseType) treeVector.get(currIndex)).isLeaf = false;
		}
		while (it.hasNext())
		{
			BaseType baseType = (BaseType) it.next();
			baseType.setLevel(level);
			baseType.isLeaf = true;
			treeVector.add(baseType);
			currIndex++;
			loadParentType(state, baseType.getId(), level + 1); //�ݹ�
		}
	}

	/**
	 * ͨ���ֵ���ID�Ż�ȡѡ���б�
	 * @param parentId long		�ֵ���ID
	 * @param state int			-1Ϊ���С�0Ϊ��Ч�ġ�1Ϊ��Ч��
	 * @return List
	 */
	public List findAllChildType(long parentId, int state)
	{
		BaseType baseType = (BaseType)new BaseType().findById(parentId);
		if (baseType == null)
		{
			return new Vector();
		}
		if (baseType.getType().equals("TREE"))
		{
			treeVector = new Vector<BaseType>();
			currIndex = -1;
			loadChildType(parentId, state, 0);
			return treeVector;
		}
		else
		{
			String hql = "from BaseType o where o.parentId=" + parentId;
			if (state == 0 || state == 1)
			{
				hql += " and o.state=" + state;
			}
			hql += " order by o.sequ desc";
			return this.findAll(hql);
		}
	}

	/**
	 * ͨ���ֵ�������ȡѡ���б�
	 * @param code String		�ֵ������
	 * @param state int			-1Ϊ���С�0Ϊ��Ч�ġ�1Ϊ��Ч��
	 * @return List
	 */
	public List findAllChildType(String code, int state)
	{
		BaseType baseType = (BaseType)new BaseType().findByCode(code);
		if (baseType == null)
		{
			return new Vector();
		}
		if (baseType.getType().equals("TREE"))
		{
			treeVector = new Vector<BaseType>();
			currIndex = -1;
			loadChildType(baseType.getId(), state, 0);
			return treeVector;
		}
		else
		{
			String hql = "from BaseType o where o.parentId=" + baseType.getId();
			if (state == 0 || state == 1)
			{
				hql += " and o.state=" + state;
			}
			hql += " order by o.sequ desc";
			return this.findAll(hql);
		}
	}

	/**
	 * ����ѡ���б����ͣ�
	 * @param parentId long			�ֵ���ID
	 * @param state int				-1Ϊ���С�0Ϊ��Ч�ġ�1Ϊ��Ч��
	 * @param level int				����
	 */
	private void loadChildType(long parentId, int state, int level)
	{
		String hql = "from BaseType o where o.parentId=" + parentId;
		if (state == 0 || state == 1)
		{
			hql += " and o.state=" + state;
		}
		hql += " order by o.sequ desc";
		List list = this.findAll(hql);

		Iterator it = list.iterator();
		if (list.size() > 0 && currIndex != -1)
		{
			( (BaseType) treeVector.get(currIndex)).isLeaf = false;
		}

		while (it.hasNext())
		{
			BaseType baseType = (BaseType) it.next();
			baseType.setLevel(level);
			baseType.isLeaf = true;
			treeVector.add(baseType);
			currIndex++;
			loadChildType(baseType.getId(), state, level + 1); //�ݹ�
		}
	}

	/**
	 * ͨ��Code����ֵ����
	 * @param code String	����
	 * @return BaseType
	 */
	public BaseType findByCode(String code)
	{
		String hql = "from BaseType o where o.isParent=1 and o.code='" + code + "'";
		return (BaseType)this.findObject(hql);
	}

	/**
	 * ͨ��Code��ֵ���ѡ�����
	 * @param code String			ѡ�����
	 * @param value String			ѡ��ֵ
	 * @return BaseType
	 */
	public BaseType findByCode(String code, String value)
	{
		String hql = "from BaseType o where o.code='" + code + "' and o.value='" + value + "'  order by o.sequ";
		return (BaseType)this.findObject(hql);
	}

	/**
	 * �������Ƿ��Ѵ���--���ڷ���true
	 * @param code String		����
	 * @param id long			ID��
	 * @return boolean
	 */
	public static boolean isHadCode(long id, String code)
	{
		String hql = "from BaseType o where o.code='" + code + "'  and o.id!=" + id;
		Object object = new BaseType().findObject(hql);
		return object != null;
	}

}
