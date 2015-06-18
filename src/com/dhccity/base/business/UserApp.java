package com.dhccity.base.business;

import java.util.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * �û�ҵ����--ʵ��User�ӿ�
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * @author Zerrion
 * @version 1.0
 */

public class UserApp implements User
{
	private BaseUser baseUser = null;
    private UserParameterApp userParameter=null;
	private String ip = "";
	private Date loginTime;

	public UserApp(BaseUser baseUser)
	{
		this.baseUser = baseUser;
        userParameter=new UserParameterApp(baseUser.getId());
	}

	/**
	 * ����û�ID��
	 * @return long
	 */
	public long getId()
	{
		return baseUser.getId();
	}

	/**
	 * ����û�����
	 * @return String
	 */
	public String getName()
	{
		return baseUser.getName();
	}

	/**
	 * ��õ�¼��
	 * @return String
	 */
	public String getLoginName()
	{
		return baseUser.getLoginName();
	}

	/**
	 * ��ò���ID��
	 * @return long
	 */
	public long getDepartmentId()
	{
		return baseUser.getDepartmentId();
	}

	/**
	 * ����û�����--��������û����Զ�ȡ
	 * @return Object
	 */
	public BaseUser getObject()
	{
		return baseUser;
	}


    /**
    * ��ȡ�û���������
    * @return int
    */
   public Object getParameterObject()
   {
       return userParameter;
   }


	/**
	 * ��ȡ�û�IP��ַ
	 * @return String
	 */
	public String getIp()
	{
		return ip;
	}

	/**
	 * �����û�IP��ַ
	 * @param ip String
	 */
	public void setIp(String ip)
	{
		this.ip = ip;
	}

	/**
	 * ��ȡ�û���¼ʱ��
	 * @return String
	 */
	public Date getLoginTime()
	{
		return this.loginTime;
	}

	/**
	 * �����û���¼ʱ��
	 * @param loginTime Date
	 */
	public void setLoginTime(Date loginTime)
	{
		this.loginTime=loginTime;
	}


	/**
	 * �Ƿ��Ǹ߼�����Ա
	 * @return boolean
	 */
	public boolean isAdmin()
	{
		return baseUser.getIsAdmin() == 1;
	}

	/**
	 * �Ƿ��ǳ���Ա
	 * @return boolean
	 */
	public boolean isProgrammer()
	{
		return baseUser.getIsProgrammer() == 1;
	}

	/**
	 * ͨ��ģ�����ƺ͹������ƽ���Ȩ�޼��
	 * @param moduleCode String		ģ�����
	 * @param functionCode String	���ܴ���,�ɷֱ���"||"��"&&"�Զ�����ܴ�����и�������"Admin||Read"��"Admin&&Read"
	 * @return boolean
	 */
	public boolean checkFunction(String moduleCode, String functionCode)
	{
		return SecurityApp.checkFunction(this, moduleCode, functionCode);
	}

	/**
	 * ͨ����ַ�������ַ�������Ȩ�޼��
	 * @param url String	��ַ
	 * @param query String	�����ַ�
	 * @return boolean
	 */
	public boolean checkUrl(String url, String query)
	{
		return SecurityApp.checkUrl(this, url, query);
	}

	/**
	 * ���Ӳ�����־
	 * @param systemName String		ϵͳ����ϵͳ����
	 * @param moduleName String		ģ������
	 * @param content String		��������
	 */
	public void addLog(String systemName, String moduleName, String content)
	{
		BaseLog baseLog = new BaseLog();
		baseLog.setIp(ip);
		baseLog.setUserName(getName());
		baseLog.setUserId(getId());
		baseLog.setNodeTime(new Date());
		baseLog.setSystemName(systemName);
		baseLog.setModuleName(moduleName);
		baseLog.setContent(content);
		baseLog.add();
	}

	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}