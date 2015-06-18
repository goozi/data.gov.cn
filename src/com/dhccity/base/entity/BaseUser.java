package com.dhccity.base.entity;

import java.util.*;

import org.light.*;

/**
 * <p>Title: BASE_USER ����Ӧ��</p>
 * <p>Description:BASE_USER</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-07-26 14:28</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseUser extends Ado
{
	private long id; //ID��
	private String name; //����
	private String loginName; //��¼��
	private String password; //����
	private long departmentId; //����ID
	private String sex; //�Ա�
	private String ename; //Ӣ����
	private String nationality; //����
	private String code; //��Ա���
	private String identityCard; //����֤����
	private Date birthday; //����
	private String nativePlace; //����
	private long party; //����
	private String tel; //�칫�ҵ绰
	private String fax; //�칫�Ҵ���
	private String mobileTel; //�ֻ�����
	private String email; //�����ʼ�
	private Date joinDate; //������λ����
	private long joinType; //������λ��ʽ
	private long boss; //�ϼ�
	private long assistant; //����
	private String ip; //IP
	private int sequ; //��ʾ˳���
	private String type; //����
	private int state; //״̬[-1��ʾ����ɾ����0��ʾɾ����1��ʾ����]
	private int isProgrammer; //�Ƿ����Ա
	private int isAdmin; //�Ƿ����Ա

	{defaultOrder = "o.sequ desc";
	} //Ĭ�ϵ�����ʽ

	public BaseUser()
	{
	}

	public BaseUser(long id)
	{
		this.id = id;
	}

	/**
	 * ��Ӧ�ֶΣ�[ID��]  ���ͣ�NUMBER(22)
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * ��Ӧ�ֶΣ�[ID��]  ���ͣ�NUMBER(22)
	 */
	public long getId()
	{
		return this.id;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(20)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(20)
	 */
	public String getName()
	{
		return this.name == null ? "" : this.name;
	}

	/**
	 * ��Ӧ�ֶΣ�[��¼��]  ���ͣ�VARCHAR2(20)
	 */
	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	/**
	 * ��Ӧ�ֶΣ�[��¼��]  ���ͣ�VARCHAR2(20)
	 */
	public String getLoginName()
	{
		return this.loginName == null ? "" : this.loginName;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(100)
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(100)
	 */
	public String getPassword()
	{
		return this.password == null ? "" : this.password;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ID]  ���ͣ�NUMBER(12)
	 */
	public void setDepartmentId(long departmentId)
	{
		this.departmentId = departmentId;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ID]  ���ͣ�NUMBER(12)
	 */
	public long getDepartmentId()
	{
		return this.departmentId;
	}

	/**
	 * ��Ӧ�ֶΣ�[�Ա�]  ���ͣ�VARCHAR2(2)
	 */
	public void setSex(String sex)
	{
		this.sex = sex;
	}

	/**
	 * ��Ӧ�ֶΣ�[�Ա�]  ���ͣ�VARCHAR2(2)
	 */
	public String getSex()
	{
		return this.sex == null ? "" : this.sex;
	}

	/**
	 * ��Ӧ�ֶΣ�[Ӣ����]  ���ͣ�VARCHAR2(50)
	 */
	public void setEname(String ename)
	{
		this.ename = ename;
	}

	/**
	 * ��Ӧ�ֶΣ�[Ӣ����]  ���ͣ�VARCHAR2(50)
	 */
	public String getEname()
	{
		return this.ename == null ? "" : this.ename;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(50)
	 */
	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(50)
	 */
	public String getNationality()
	{
		return this.nationality == null ? "" : this.nationality;
	}

	/**
	 * ��Ӧ�ֶΣ�[��Ա���]  ���ͣ�VARCHAR2(50)
	 */
	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * ��Ӧ�ֶΣ�[��Ա���]  ���ͣ�VARCHAR2(50)
	 */
	public String getCode()
	{
		return this.code == null ? "" : this.code;
	}

	/**
	 * ��Ӧ�ֶΣ�[����֤����]  ���ͣ�VARCHAR2(50)
	 */
	public void setIdentityCard(String identityCard)
	{
		this.identityCard = identityCard;
	}

	/**
	 * ��Ӧ�ֶΣ�[����֤����]  ���ͣ�VARCHAR2(50)
	 */
	public String getIdentityCard()
	{
		return this.identityCard == null ? "" : this.identityCard;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�DATE(7)
	 */
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�DATE(7)
	 */
	public Date getBirthday()
	{
		return this.birthday;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(50)
	 */
	public void setNativePlace(String nativePlace)
	{
		this.nativePlace = nativePlace;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(50)
	 */
	public String getNativePlace()
	{
		return this.nativePlace == null ? "" : this.nativePlace;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�NUMBER(12)
	 */
	public void setParty(long party)
	{
		this.party = party;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�NUMBER(12)
	 */
	public long getParty()
	{
		return this.party;
	}

	/**
	 * ��Ӧ�ֶΣ�[�칫�ҵ绰]  ���ͣ�VARCHAR2(50)
	 */
	public void setTel(String tel)
	{
		this.tel = tel;
	}

	/**
	 * ��Ӧ�ֶΣ�[�칫�ҵ绰]  ���ͣ�VARCHAR2(50)
	 */
	public String getTel()
	{
		return this.tel == null ? "" : this.tel;
	}

	/**
	 * ��Ӧ�ֶΣ�[�칫�Ҵ���]  ���ͣ�VARCHAR2(50)
	 */
	public void setFax(String fax)
	{
		this.fax = fax;
	}

	/**
	 * ��Ӧ�ֶΣ�[�칫�Ҵ���]  ���ͣ�VARCHAR2(50)
	 */
	public String getFax()
	{
		return this.fax == null ? "" : this.fax;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ֻ�����]  ���ͣ�VARCHAR2(50)
	 */
	public void setMobileTel(String mobileTel)
	{
		this.mobileTel = mobileTel;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ֻ�����]  ���ͣ�VARCHAR2(50)
	 */
	public String getMobileTel()
	{
		return this.mobileTel == null ? "" : this.mobileTel;
	}

	/**
	 * ��Ӧ�ֶΣ�[�����ʼ�]  ���ͣ�VARCHAR2(50)
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * ��Ӧ�ֶΣ�[�����ʼ�]  ���ͣ�VARCHAR2(50)
	 */
	public String getEmail()
	{
		return this.email == null ? "" : this.email;
	}

	/**
	 * ��Ӧ�ֶΣ�[������λ����]  ���ͣ�DATE(7)
	 */
	public void setJoinDate(Date joinDate)
	{
		this.joinDate = joinDate;
	}

	/**
	 * ��Ӧ�ֶΣ�[������λ����]  ���ͣ�DATE(7)
	 */
	public Date getJoinDate()
	{
		return this.joinDate;
	}

	/**
	 * ��Ӧ�ֶΣ�[������λ��ʽ]  ���ͣ�NUMBER(12)
	 */
	public void setJoinType(long joinType)
	{
		this.joinType = joinType;
	}

	/**
	 * ��Ӧ�ֶΣ�[������λ��ʽ]  ���ͣ�NUMBER(12)
	 */
	public long getJoinType()
	{
		return this.joinType;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ϼ�]  ���ͣ�NUMBER(12)
	 */
	public void setBoss(long boss)
	{
		this.boss = boss;
	}

	/**
	 * ��Ӧ�ֶΣ�[�ϼ�]  ���ͣ�NUMBER(12)
	 */
	public long getBoss()
	{
		return this.boss;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�NUMBER(12)
	 */
	public void setAssistant(long assistant)
	{
		this.assistant = assistant;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�NUMBER(12)
	 */
	public long getAssistant()
	{
		return this.assistant;
	}

	/**
	 * ��Ӧ�ֶΣ�[IP]  ���ͣ�VARCHAR2(100)
	 */
	public void setIp(String ip)
	{
		this.ip = ip;
	}

	/**
	 * ��Ӧ�ֶΣ�[IP]  ���ͣ�VARCHAR2(100)
	 */
	public String getIp()
	{
		return this.ip == null ? "" : this.ip;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ʾ˳���]  ���ͣ�NUMBER(8)
	 */
	public void setSequ(int sequ)
	{
		this.sequ = sequ;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ʾ˳���]  ���ͣ�NUMBER(8)
	 */
	public int getSequ()
	{
		return this.sequ;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(20)
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(20)
	 */
	public String getType()
	{
		return this.type == null ? "" : this.type;
	}

	/**
	 * ��Ӧ�ֶΣ�[״̬[-1��ʾ����ɾ����0��ʾɾ����1��ʾ����]]  ���ͣ�NUMBER(2)
	 */
	public void setState(int state)
	{
		this.state = state;
	}

	/**
	 * ��Ӧ�ֶΣ�[״̬[-1��ʾ����ɾ����0��ʾɾ����1��ʾ����]]  ���ͣ�NUMBER(2)
	 */
	public int getState()
	{
		return this.state;
	}

	/**
	 * ��Ӧ�ֶΣ�[�Ƿ����Ա]  ���ͣ�NUMBER(1)
	 */
	public void setIsProgrammer(int isProgrammer)
	{
		this.isProgrammer = isProgrammer;
	}

	/**
	 * ��Ӧ�ֶΣ�[�Ƿ����Ա]  ���ͣ�NUMBER(1)
	 */
	public int getIsProgrammer()
	{
		return this.isProgrammer;
	}

	/**
	 * ��Ӧ�ֶΣ�[�Ƿ����Ա]  ���ͣ�NUMBER(1)
	 */
	public void setIsAdmin(int isAdmin)
	{
		this.isAdmin = isAdmin;
	}

	/**
	 * ��Ӧ�ֶΣ�[�Ƿ����Ա]  ���ͣ�NUMBER(1)
	 */
	public int getIsAdmin()
	{
		return this.isAdmin;
	}

	//===============================����Ϊ�Ա༭����===================================


	/**
	 * ��ò�������
	 * @return String
	 */
	public String getDepartmentName()
	{
		BaseDepartment baseDepartment = (BaseDepartment)new BaseDepartment().findById(this.departmentId);
		return baseDepartment == null ? "" : baseDepartment.getName();
	}

	/**
	 * ����ϼ�����
	 * @return String
	 */
	public String getBossName()
	{
		BaseUser baseUser = (BaseUser)new BaseUser().findById(this.boss);
		return baseUser == null ? "" : baseUser.getName();
	}

	/**
	 * ����ϼ�����
	 * @return String
	 */
	public String getAssistantName()
	{
		BaseUser baseUser = (BaseUser)new BaseUser().findById(this.assistant);
		return baseUser == null ? "" : baseUser.getName();
	}

	/**
	 * ͨ���ʺ��������ȡ�û�����
	 * @param loginName String		�ʺ�
	 * @param password String		����
	 * @return BaseUser
	 */
	public static BaseUser findByLoginName(String loginName, String password)
	{
		String hql = "from BaseUser o where o.state=1 and  o.loginName='" + filterSQL(loginName) + "' and o.password='" + filterSQL(password) + "'";
		return (BaseUser)new BaseUser().findObject(hql);
	}

	/**
	 * ͨ�����ͽ��з�ҳ����
	 * @param types String		����,�ɽ���������á�;��������""Ϊ�����û�
	 * @param currPage int		��ǰҳ
	 * @param pageSize int			ÿҳ������
	 * @return List				�������п��õ��û�
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
	 * ��������
	 * @param types String				����,�ɽ���������á�;��������""Ϊ�����û�
	 * @param searchField String		�����ֶ�
	 * @param searchValue String		����ֵ
	 * @param departmentId long			����ID
	 * @param dutyId long				ְ��ID
	 * @param roleId long				��ɫID
	 * @param state int					״̬
	 * @param currPage int				��ǰҳ
	 * @param pageSize int				ÿҳ������
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
	 * ͨ������ID�Ҳ��û�
	 * @param departmentId long			����ID
	 * @return List
	 */
	public List findByDepartmentId(long departmentId)
	{
		//String hql = "from BaseUser o where o.departmentId=" + departmentId + " and o.state=1 and o.isProgrammer=0 order by o.sequ desc";
		String hql = "from BaseUser o where o.departmentId=" + departmentId + " and o.state=1 order by o.sequ desc";
		return this.findAll(hql);
	}

	/**
	 * ����������Ч�û�
	 * @return List
	 */
	public List findAllUser()
	{
		//String hql = "from BaseUser o where  o.state=1 and o.isProgrammer=0 order by o.sequ desc";
		String hql = "from BaseUser o where  o.state=1 order by o.sequ desc";
		return this.findAll(hql);
	}

}