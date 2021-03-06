package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_USER 表对应类</p>
 * <p>Description:BASE_USER</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-07-26 14:28</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseUser extends Ado
{
	private long id; //ID号
	private String name; //姓名
	private String loginName; //登录名
	private String password; //密码
	private long departmentId; //部门ID
	private String sex; //性别
	private String ename; //英文名
	private String nationality; //国籍
	private String code; //人员编号
	private String identityCard; //身份证号码
	private Date birthday; //生日
	private String nativePlace; //籍贯
	private long party; //党派
	private String tel; //办公室电话
	private String fax; //办公室传真
	private String mobileTel; //手机号码
	private String email; //电子邮件
	private Date joinDate; //来本单位日期
	private long joinType; //来本单位方式
	private long boss; //上级
	private long assistant; //助理
	private String ip; //IP
	private int sequ; //显示顺序号
	private String type; //类型
	private int state; //状态[-1表示撤底删除、0表示删除、1表示可用]
	private int isProgrammer; //是否程序员
	private int isAdmin; //是否管理员

	{defaultOrder = "o.sequ desc";
	} //默认的排序方式

	public BaseUser()
	{
	}

	public BaseUser(long id)
	{
		this.id = id;
	}

	/**
	 * 对应字段：[ID号]  类型：NUMBER(22)
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * 对应字段：[ID号]  类型：NUMBER(22)
	 */
	public long getId()
	{
		return this.id;
	}

	/**
	 * 对应字段：[姓名]  类型：VARCHAR2(20)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * 对应字段：[姓名]  类型：VARCHAR2(20)
	 */
	public String getName()
	{
		return this.name == null ? "" : this.name;
	}

	/**
	 * 对应字段：[登录名]  类型：VARCHAR2(20)
	 */
	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	/**
	 * 对应字段：[登录名]  类型：VARCHAR2(20)
	 */
	public String getLoginName()
	{
		return this.loginName == null ? "" : this.loginName;
	}

	/**
	 * 对应字段：[密码]  类型：VARCHAR2(100)
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * 对应字段：[密码]  类型：VARCHAR2(100)
	 */
	public String getPassword()
	{
		return this.password == null ? "" : this.password;
	}

	/**
	 * 对应字段：[部门ID]  类型：NUMBER(12)
	 */
	public void setDepartmentId(long departmentId)
	{
		this.departmentId = departmentId;
	}

	/**
	 * 对应字段：[部门ID]  类型：NUMBER(12)
	 */
	public long getDepartmentId()
	{
		return this.departmentId;
	}

	/**
	 * 对应字段：[性别]  类型：VARCHAR2(2)
	 */
	public void setSex(String sex)
	{
		this.sex = sex;
	}

	/**
	 * 对应字段：[性别]  类型：VARCHAR2(2)
	 */
	public String getSex()
	{
		return this.sex == null ? "" : this.sex;
	}

	/**
	 * 对应字段：[英文名]  类型：VARCHAR2(50)
	 */
	public void setEname(String ename)
	{
		this.ename = ename;
	}

	/**
	 * 对应字段：[英文名]  类型：VARCHAR2(50)
	 */
	public String getEname()
	{
		return this.ename == null ? "" : this.ename;
	}

	/**
	 * 对应字段：[国籍]  类型：VARCHAR2(50)
	 */
	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}

	/**
	 * 对应字段：[国籍]  类型：VARCHAR2(50)
	 */
	public String getNationality()
	{
		return this.nationality == null ? "" : this.nationality;
	}

	/**
	 * 对应字段：[人员编号]  类型：VARCHAR2(50)
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * 对应字段：[人员编号]  类型：VARCHAR2(50)
	 */
	public String getCode()
	{
		return this.code == null ? "" : this.code;
	}

	/**
	 * 对应字段：[身份证号码]  类型：VARCHAR2(50)
	 */
	public void setIdentityCard(String identityCard)
	{
		this.identityCard = identityCard;
	}

	/**
	 * 对应字段：[身份证号码]  类型：VARCHAR2(50)
	 */
	public String getIdentityCard()
	{
		return this.identityCard == null ? "" : this.identityCard;
	}

	/**
	 * 对应字段：[生日]  类型：DATE(7)
	 */
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	/**
	 * 对应字段：[生日]  类型：DATE(7)
	 */
	public Date getBirthday()
	{
		return this.birthday;
	}

	/**
	 * 对应字段：[籍贯]  类型：VARCHAR2(50)
	 */
	public void setNativePlace(String nativePlace)
	{
		this.nativePlace = nativePlace;
	}

	/**
	 * 对应字段：[籍贯]  类型：VARCHAR2(50)
	 */
	public String getNativePlace()
	{
		return this.nativePlace == null ? "" : this.nativePlace;
	}

	/**
	 * 对应字段：[党派]  类型：NUMBER(12)
	 */
	public void setParty(long party)
	{
		this.party = party;
	}

	/**
	 * 对应字段：[党派]  类型：NUMBER(12)
	 */
	public long getParty()
	{
		return this.party;
	}

	/**
	 * 对应字段：[办公室电话]  类型：VARCHAR2(50)
	 */
	public void setTel(String tel)
	{
		this.tel = tel;
	}

	/**
	 * 对应字段：[办公室电话]  类型：VARCHAR2(50)
	 */
	public String getTel()
	{
		return this.tel == null ? "" : this.tel;
	}

	/**
	 * 对应字段：[办公室传真]  类型：VARCHAR2(50)
	 */
	public void setFax(String fax)
	{
		this.fax = fax;
	}

	/**
	 * 对应字段：[办公室传真]  类型：VARCHAR2(50)
	 */
	public String getFax()
	{
		return this.fax == null ? "" : this.fax;
	}

	/**
	 * 对应字段：[手机号码]  类型：VARCHAR2(50)
	 */
	public void setMobileTel(String mobileTel)
	{
		this.mobileTel = mobileTel;
	}

	/**
	 * 对应字段：[手机号码]  类型：VARCHAR2(50)
	 */
	public String getMobileTel()
	{
		return this.mobileTel == null ? "" : this.mobileTel;
	}

	/**
	 * 对应字段：[电子邮件]  类型：VARCHAR2(50)
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * 对应字段：[电子邮件]  类型：VARCHAR2(50)
	 */
	public String getEmail()
	{
		return this.email == null ? "" : this.email;
	}

	/**
	 * 对应字段：[来本单位日期]  类型：DATE(7)
	 */
	public void setJoinDate(Date joinDate)
	{
		this.joinDate = joinDate;
	}

	/**
	 * 对应字段：[来本单位日期]  类型：DATE(7)
	 */
	public Date getJoinDate()
	{
		return this.joinDate;
	}

	/**
	 * 对应字段：[来本单位方式]  类型：NUMBER(12)
	 */
	public void setJoinType(long joinType)
	{
		this.joinType = joinType;
	}

	/**
	 * 对应字段：[来本单位方式]  类型：NUMBER(12)
	 */
	public long getJoinType()
	{
		return this.joinType;
	}

	/**
	 * 对应字段：[上级]  类型：NUMBER(12)
	 */
	public void setBoss(long boss)
	{
		this.boss = boss;
	}

	/**
	 * 对应字段：[上级]  类型：NUMBER(12)
	 */
	public long getBoss()
	{
		return this.boss;
	}

	/**
	 * 对应字段：[助理]  类型：NUMBER(12)
	 */
	public void setAssistant(long assistant)
	{
		this.assistant = assistant;
	}

	/**
	 * 对应字段：[助理]  类型：NUMBER(12)
	 */
	public long getAssistant()
	{
		return this.assistant;
	}

	/**
	 * 对应字段：[IP]  类型：VARCHAR2(100)
	 */
	public void setIp(String ip)
	{
		this.ip = ip;
	}

	/**
	 * 对应字段：[IP]  类型：VARCHAR2(100)
	 */
	public String getIp()
	{
		return this.ip == null ? "" : this.ip;
	}

	/**
	 * 对应字段：[显示顺序号]  类型：NUMBER(8)
	 */
	public void setSequ(int sequ)
	{
		this.sequ = sequ;
	}

	/**
	 * 对应字段：[显示顺序号]  类型：NUMBER(8)
	 */
	public int getSequ()
	{
		return this.sequ;
	}

	/**
	 * 对应字段：[类型]  类型：VARCHAR2(20)
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * 对应字段：[类型]  类型：VARCHAR2(20)
	 */
	public String getType()
	{
		return this.type == null ? "" : this.type;
	}

	/**
	 * 对应字段：[状态[-1表示撤底删除、0表示删除、1表示可用]]  类型：NUMBER(2)
	 */
	public void setState(int state)
	{
		this.state = state;
	}

	/**
	 * 对应字段：[状态[-1表示撤底删除、0表示删除、1表示可用]]  类型：NUMBER(2)
	 */
	public int getState()
	{
		return this.state;
	}

	/**
	 * 对应字段：[是否程序员]  类型：NUMBER(1)
	 */
	public void setIsProgrammer(int isProgrammer)
	{
		this.isProgrammer = isProgrammer;
	}

	/**
	 * 对应字段：[是否程序员]  类型：NUMBER(1)
	 */
	public int getIsProgrammer()
	{
		return this.isProgrammer;
	}

	/**
	 * 对应字段：[是否管理员]  类型：NUMBER(1)
	 */
	public void setIsAdmin(int isAdmin)
	{
		this.isAdmin = isAdmin;
	}

	/**
	 * 对应字段：[是否管理员]  类型：NUMBER(1)
	 */
	public int getIsAdmin()
	{
		return this.isAdmin;
	}

	//===============================以下为自编辑代码===================================


	/**
	 * 获得部门名称
	 * @return String
	 */
	public String getDepartmentName()
	{
		BaseDepartment baseDepartment = (BaseDepartment)new BaseDepartment().findById(this.departmentId);
		return baseDepartment == null ? "" : baseDepartment.getName();
	}

	/**
	 * 获得上级名称
	 * @return String
	 */
	public String getBossName()
	{
		BaseUser baseUser = (BaseUser)new BaseUser().findById(this.boss);
		return baseUser == null ? "" : baseUser.getName();
	}

	/**
	 * 获得上级名称
	 * @return String
	 */
	public String getAssistantName()
	{
		BaseUser baseUser = (BaseUser)new BaseUser().findById(this.assistant);
		return baseUser == null ? "" : baseUser.getName();
	}

	/**
	 * 通过帐号与密码获取用户对象
	 * @param loginName String		帐号
	 * @param password String		密码
	 * @return BaseUser
	 */
	public static BaseUser findByLoginName(String loginName, String password)
	{
		String hql = "from BaseUser o where o.state=1 and  o.loginName='" + filterSQL(loginName) + "' and o.password='" + filterSQL(password) + "'";
		return (BaseUser)new BaseUser().findObject(hql);
	}

	/**
	 * 通过类型进行分页查找
	 * @param types String		类型,可将多个类型用“;”隔开，""为所有用户
	 * @param currPage int		当前页
	 * @param pageSize int			每页多少行
	 * @return List				返回所有可用的用户
	 */
	public List findPageByType(String types, int currPage, int pageSize)
	{
		String hqlWhere = "";
		if (!types.equals(""))
		{
			hqlWhere = "1<>1";
			String[] type = types.split(";");
			for (int i = 0; i < type.length; i++)
			{
				hqlWhere += " or o.type='" + type[i] + "'";
			}
		}
		else
		{
			hqlWhere = "1=1";
		}
		//String hql = "from BaseUser o where (" + hqlWhere + ") and o.state=1 and o.isProgrammer=0 order by o.sequ desc";
		String hql = "from BaseUser o where (" + hqlWhere + ") and o.state=1 order by o.sequ desc";
		return this.findPage(hql, currPage, pageSize);
	}

	/**
	 * 复杂搜索
	 * @param types String				类型,可将多个类型用“;”隔开，""为所有用户
	 * @param searchField String		搜索字段
	 * @param searchValue String		搜索值
	 * @param departmentId long			部门ID
	 * @param dutyId long				职务ID
	 * @param roleId long				角色ID
	 * @param state int					状态
	 * @param currPage int				当前页
	 * @param pageSize int				每页多少行
	 * @return List
	 */
	public List search(String types, String searchField, String searchValue, long departmentId, long dutyId, long roleId, int state, int currPage, int pageSize)
	{
		String hqlWhere = "";
		if (!types.equals(""))
		{
			hqlWhere = "1<>1";
			String[] type = types.split(";");
			for (int i = 0; i < type.length; i++)
			{
				hqlWhere += " or o.type='" + type[i] + "'";
			}
		}
		else
		{
			hqlWhere = "1=1";
		}
		//String hql = "from BaseUser o where (" + hqlWhere + ") and o.isProgrammer=0";
		String hql = "from BaseUser o where (" + hqlWhere + ") ";
		hql += " and o." + searchField + " like '%" + filterSQL(searchValue) + "%'";
		if (departmentId != 0)
		{
			hql += " and o.departmentId=" + departmentId;
		}
		if (dutyId != 0)
		{
			hql += " and o.id in (select e.userId from BaseUserGroup e where e.type=1 and e.groupId=" + dutyId + ")";
		}
		if (roleId != 0)
		{
			hql += " and o.id in (select a.userId from BaseUserGroup a where a.type=2 and a.groupId=" + roleId + ")";
		}
		if (state != -1)
		{
			hql += " and o.state=1";
		}
		hql += " order by o.sequ desc";
		return this.findPage(hql, currPage, pageSize);
	}

	/**
	 * 通过部门ID找查用户
	 * @param departmentId long			部门ID
	 * @return List
	 */
	public List findByDepartmentId(long departmentId)
	{
		//String hql = "from BaseUser o where o.departmentId=" + departmentId + " and o.state=1 and o.isProgrammer=0 order by o.sequ desc";
		String hql = "from BaseUser o where o.departmentId=" + departmentId + " and o.state=1 order by o.sequ desc";
		return this.findAll(hql);
	}

	/**
	 * 查找所的有效用户
	 * @return List
	 */
	public List findAllUser()
	{
		//String hql = "from BaseUser o where  o.state=1 and o.isProgrammer=0 order by o.sequ desc";
		String hql = "from BaseUser o where  o.state=1 order by o.sequ desc";
		return this.findAll(hql);
	}

}
