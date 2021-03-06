package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_SECURITY 表对应类</p>
 * <p>Description:BASE_SECURITY</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-02-14 13:51</p>
 * @author liuxd
 * @version 1.0
 */

public class BaseSecurity extends TreeAdo implements Tree
{
	private long id; //ID
	private String name; //名称
	private int state; //状态：0表示无效、1表示有效
	private int sequ; //顺序种子
	private long parentId; //父ID号
	private String value; //值[权限代码]
	private int type; //类型，1.模块，2.权限
	private String description; //说明
	private String meno; //备注
	private int securityLevel; //安全级别、0为普通级别,1为开发者可管理

	//{defaultOrder = "o.id";} //默认的排序方式

	public BaseSecurity()
	{

	}

	public BaseSecurity(long id)
	{
		this.id = id;
	}

	/**
	 * 对应字段：[ID]  类型：NUMBER(22)
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * 对应字段：[ID]  类型：NUMBER(22)
	 */
	public long getId()
	{
		return this.id;
	}

	/**
	 * 对应字段：[名称]  类型：VARCHAR2(200)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * 对应字段：[名称]  类型：VARCHAR2(200)
	 */
	public String getName()
	{
		return this.name == null ? "" : this.name;
	}

	/**
	 * 对应字段：[状态：0表示无效、1表示有效]  类型：NUMBER(1)
	 */
	public void setState(int state)
	{
		this.state = state;
	}

	/**
	 * 对应字段：[状态：0表示无效、1表示有效]  类型：NUMBER(1)
	 */
	public int getState()
	{
		return this.state;
	}

	/**
	 * 对应字段：[顺序种子]  类型：NUMBER(4)
	 */
	public void setSequ(int sequ)
	{
		this.sequ = sequ;
	}

	/**
	 * 对应字段：[顺序种子]  类型：NUMBER(4)
	 */
	public int getSequ()
	{
		return this.sequ;
	}

	/**
	 * 对应字段：[父ID号]  类型：NUMBER(12)
	 */
	public void setParentId(long parentId)
	{
		this.parentId = parentId;
	}

	/**
	 * 对应字段：[父ID号]  类型：NUMBER(12)
	 */
	public long getParentId()
	{
		return this.parentId;
	}

	/**
	 * 对应字段：[值[权限代码]]  类型：VARCHAR2(100)
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

	/**
	 * 对应字段：[值[权限代码]]  类型：VARCHAR2(100)
	 */
	public String getValue()
	{
		return this.value == null ? "" : this.value;
	}

	/**
	 * 对应字段：[类型，1.模块，2.权限]  类型：NUMBER(2)
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	/**
	 * 对应字段：[类型，1.模块，2.权限]  类型：NUMBER(2)
	 */
	public int getType()
	{
		return this.type;
	}

	/**
	 * 对应字段：[说明]  类型：VARCHAR2(1000)
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * 对应字段：[说明]  类型：VARCHAR2(1000)
	 */
	public String getDescription()
	{
		return this.description == null ? "" : this.description;
	}

	/**
	 * 对应字段：[备注]  类型：VARCHAR2(1000)
	 */
	public void setMeno(String meno)
	{
		this.meno = meno;
	}

	/**
	 * 对应字段：[备注]  类型：VARCHAR2(1000)
	 */
	public String getMeno()
	{
		return this.meno == null ? "" : this.meno;
	}

	/**
	 * 对应字段：[安全级别、0为普通级别,1为开发者可管理]  类型：NUMBER(2)
	 */
	public void setSecurityLevel(int securityLevel)
	{
		this.securityLevel = securityLevel;
	}

	/**
	 * 对应字段：[安全级别、0为普通级别,1为开发者可管理]  类型：NUMBER(2)
	 */
	public int getSecurityLevel()
	{
		return this.securityLevel;
	}

	//===============================以下为自编辑代码===================================

	/**
	 * 通过递归方式--加载子节点，实现TreeAdo虚函数--不包括权限
	 * @param parentId long		父ID
	 * @param state int			-1为所有、0为无效的、1为有效的
	 * @param level int			级数
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
			loadChildNode(baseSecurity.getId(), state, level + 1); //递归
		}
	}

	/**
	 * 通过模块/功能代码查找功能节点
	 * @param moduleCode String		模块代码
	 * @param functionCode String	功能代码,可用"||"或"&&"对多个功能代码进行隔开
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
	 * 通过网址查找功能节点
	 * @param url String		网址
	 * @param query String		请求参数
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
	 * 通过ID数组查找功能节点
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
	 * 查找所有节点--按照树形顺序--包括权限
	 * @param state int	-1为所有、0为无效的、1为有效的
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
	 * 通过递归方式--加载子节点，包括权限
	 * @param parentId long		父ID
	 * @param state int			-1为所有、0为无效的、1为有效的
	 * @param level int			级数
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
			loadChilItem(baseSecurity.getId(), state, level + 1); //递归
		}
	}

	/**
	 * 是否拥有子权限
	 * @return boolean
	 */
	public static boolean isChildSecurity(long id)
	{
		String hql = "from BaseSecurity o where o.type=2 and o.state=1 and o.parentId=" + id;
		return new BaseSecurity().findObject(hql) == null ? false : true;

	}

	/**
	 * 通过parentId查找子权限
	 * @param id long
	 * @return boolean
	 */
	public List findChildByParentId(long id)
	{
		String hql = "from BaseSecurity o where o.type=2 and o.state=1 and o.parentId=" + id;
		return this.findAll(hql);

	}

	/**
	 * 检测代码是否已存在--存在返回true
	 * @param code String		代码
	 * @param id long			ID号
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
