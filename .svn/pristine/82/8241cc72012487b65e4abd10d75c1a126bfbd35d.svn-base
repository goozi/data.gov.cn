package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_TYPE 表对应类</p>
 * <p>Description:BASE_TYPE</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2007-01-15 12:44</p>
 * @author liuxd
 * @version 1.0
 */

public class BaseType extends Ado
{
	private long id; //ID
	private String name; //名称
	private String code; //代码
	private int state; //状态：0表示无效、1表示有效
	private int isDefault; //是否默认：0表示不是、1表示默认
	private int sequ; //顺序种子
	private long parentId; //父ID号
	private String userNames; //允许访问的用户名集合
	private String userIds; //允许访问的用户ID集合
	private String value; //值
	private String type; //NORMAL普通、TREE树
	private String description; //说明
	private String meno; //备注
	private int securityLevel; //安全级别、0为普通级别,1为开发者可管理,2为在类型管理中不能管理
	private int isParent; //是否为根字典，1表示是,0表示不是

	protected int level = 0; //级数
	protected String levelString = ""; //级数文本表示字符串
	protected String levelHtml = ""; //级数网页表示字符串
	protected Vector<BaseType> treeVector = new Vector<BaseType>(); //树型节点列表
	protected int currIndex = -1; //当前节点索引
	protected boolean isLeaf = true; //是否为叶子节点

	//{defaultOrder = "o.id";} //默认的排序方式

	public BaseType()
	{
	}

	public BaseType(long id)
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
	 * 对应字段：[代码]  类型：VARCHAR2(100)
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * 对应字段：[代码]  类型：VARCHAR2(100)
	 */
	public String getCode()
	{
		return this.code == null ? "" : this.code;
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
	 * 对应字段：[是否默认：0表示不是、1表示默认]  类型：NUMBER(1)
	 */
	public void setIsDefault(int isDefault)
	{
		this.isDefault = isDefault;
	}

	/**
	 * 对应字段：[是否默认：0表示不是、1表示默认]  类型：NUMBER(1)
	 */
	public int getIsDefault()
	{
		return this.isDefault;
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
	 * 对应字段：[允许访问的用户名集合]  类型：VARCHAR2(4000)
	 */
	public void setUserNames(String userNames)
	{
		this.userNames = userNames;
	}

	/**
	 * 对应字段：[允许访问的用户名集合]  类型：VARCHAR2(4000)
	 */
	public String getUserNames()
	{
		return this.userNames == null ? "" : this.userNames;
	}

	/**
	 * 对应字段：[允许访问的用户ID集合]  类型：VARCHAR2(4000)
	 */
	public void setUserIds(String userIds)
	{
		this.userIds = userIds;
	}

	/**
	 * 对应字段：[允许访问的用户ID集合]  类型：VARCHAR2(4000)
	 */
	public String getUserIds()
	{
		return this.userIds == null ? "" : this.userIds;
	}

	/**
	 * 对应字段：[值]  类型：VARCHAR2(100)
	 */
	public void setValue(String value)
	{
		this.value = value;
	}

	/**
	 * 对应字段：[值]  类型：VARCHAR2(100)
	 */
	public String getValue()
	{
		return this.value == null ? "" : this.value;
	}

	/**
	 * 对应字段：[NORMAL普通、TREE树]  类型：VARCHAR2(20)
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * 对应字段：[NORMAL普通、TREE树]  类型：VARCHAR2(20)
	 */
	public String getType()
	{
		return this.type == null ? "" : this.type;
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
	 * 对应字段：[安全级别、0为普通级别,1为开发者可管理,2为在类型管理中不能管理]  类型：NUMBER(2)
	 */
	public void setSecurityLevel(int securityLevel)
	{
		this.securityLevel = securityLevel;
	}

	/**
	 * 对应字段：[安全级别、0为普通级别,1为开发者可管理,2为在类型管理中不能管理]  类型：NUMBER(2)
	 */
	public int getSecurityLevel()
	{
		return this.securityLevel;
	}

	/**
	 * 是否为根字典，1表示是,0表示不是
	 */
	public void setIsParent(int isParent)
	{
		this.isParent = isParent;
	}

	/**
	 * 是否为根字典，1表示是,0表示不是
	 */
	public int getIsParent()
	{
		return this.isParent;
	}

	//===============================以下为自编辑代码===================================

	/**
	 * 获取级数
	 * @return long		0为第一级
	 */
	public long getLevel()
	{
		return this.level;
	}

	/**
	 * 获取级数文本
	 * @return String
	 */
	public String getLevelString()
	{
		return this.levelString;
	}

	/**
	 * 获取级数网页字符串
	 * @return String
	 */
	public String getLevelHtml()
	{
		return this.levelHtml;
	}

	/**
	 * 判断对象是否为页子节点
	 * @return boolean   true为叶子节点，false不非叶子节点
	 */
	public boolean isLeaf()
	{
		return this.isLeaf;
	}

	/**
	 * 设置级数与级数文本
	 * @param level int  文本
	 */
	private void setLevel(int level)
	{
		this.level = level;
		String strLine = "├ ";
		for (int i = 0; i < level; i++)
		{
			strLine = "│" + strLine;
			levelHtml += "&nbsp;&nbsp;";
		}
		this.levelString = strLine;
	}

	/**
	 * 通过用户获取数据字典项列表
	 * @param user User		用户对象
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
	 * 加载数据字典项列表（树型）
	 * @param user User			用户对象
	 * @param parentId long		字典项ID
	 * @param level int			级别
	 */
	private void loadParentType(User user, long parentId, int level)
	{
		String hql = "from BaseType o where o.parentId=" + parentId;

		//是否程序员检测
		if (user.isProgrammer())
		{
			hql += " and o.securityLevel<2";
		}
		else
		{
			hql += " and o.securityLevel<1";
		}

		//不是管理员
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
			loadParentType(user, baseType.getId(), level + 1); //递归
		}
	}

	/**
	 * 通过用户和状态获取数据字典项列表
	 * @param user  User		用户对象
	 * @param state int			状态
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
	 * 加载数据字典项列表（树型）
	 * @param user User			用户对象
	 * @param state int			状态
	 * @param parentId long		字典项ID
	 * @param level int			级别
	 */
	private void loadParentType(User user, int state, long parentId, int level)
	{
		String hql = "from BaseType o where o.parentId=" + parentId;

		//是否程序员检测
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
			loadParentType(user, state, baseType.getId(), level + 1); //递归
		}
	}

	/**
	 * 通过用户获取数据字典项列表
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
	 * 加载数据字典项列表（树型）
	 * @param state
	 * @param parentId long		字典项ID
	 * @param level int			级别
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
			loadParentType(state, baseType.getId(), level + 1); //递归
		}
	}

	/**
	 * 通过字典项ID号获取选项列表
	 * @param parentId long		字典项ID
	 * @param state int			-1为所有、0为无效的、1为有效的
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
	 * 通过字典项代码获取选项列表
	 * @param code String		字典项代码
	 * @param state int			-1为所有、0为无效的、1为有效的
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
	 * 加载选项列表（树型）
	 * @param parentId long			字典项ID
	 * @param state int				-1为所有、0为无效的、1为有效的
	 * @param level int				级别
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
			loadChildType(baseType.getId(), state, level + 1); //递归
		}
	}

	/**
	 * 通过Code获得字典对象
	 * @param code String	代码
	 * @return BaseType
	 */
	public BaseType findByCode(String code)
	{
		String hql = "from BaseType o where o.isParent=1 and o.code='" + code + "'";
		return (BaseType)this.findObject(hql);
	}

	/**
	 * 通过Code和值获得选项对象
	 * @param code String			选项代码
	 * @param value String			选项值
	 * @return BaseType
	 */
	public BaseType findByCode(String code, String value)
	{
		String hql = "from BaseType o where o.code='" + code + "' and o.value='" + value + "'  order by o.sequ";
		return (BaseType)this.findObject(hql);
	}

	/**
	 * 检测代码是否已存在--存在返回true
	 * @param code String		代码
	 * @param id long			ID号
	 * @return boolean
	 */
	public static boolean isHadCode(long id, String code)
	{
		String hql = "from BaseType o where o.code='" + code + "'  and o.id!=" + id;
		Object object = new BaseType().findObject(hql);
		return object != null;
	}

}
