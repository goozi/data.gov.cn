package com.dhccity.base.business;

import java.util.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * 用户业务类--实现User接口
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
	 * 获得用户ID号
	 * @return long
	 */
	public long getId()
	{
		return baseUser.getId();
	}

	/**
	 * 获得用户名称
	 * @return String
	 */
	public String getName()
	{
		return baseUser.getName();
	}

	/**
	 * 获得登录名
	 * @return String
	 */
	public String getLoginName()
	{
		return baseUser.getLoginName();
	}

	/**
	 * 获得部门ID号
	 * @return long
	 */
	public long getDepartmentId()
	{
		return baseUser.getDepartmentId();
	}

	/**
	 * 获得用户对象--方便更多用户属性读取
	 * @return Object
	 */
	public BaseUser getObject()
	{
		return baseUser;
	}


    /**
    * 获取用户参数对象
    * @return int
    */
   public Object getParameterObject()
   {
       return userParameter;
   }


	/**
	 * 获取用户IP地址
	 * @return String
	 */
	public String getIp()
	{
		return ip;
	}

	/**
	 * 设置用户IP地址
	 * @param ip String
	 */
	public void setIp(String ip)
	{
		this.ip = ip;
	}

	/**
	 * 获取用户登录时间
	 * @return String
	 */
	public Date getLoginTime()
	{
		return this.loginTime;
	}

	/**
	 * 设置用户登录时间
	 * @param loginTime Date
	 */
	public void setLoginTime(Date loginTime)
	{
		this.loginTime=loginTime;
	}


	/**
	 * 是否是高级管理员
	 * @return boolean
	 */
	public boolean isAdmin()
	{
		return baseUser.getIsAdmin() == 1;
	}

	/**
	 * 是否是程序员
	 * @return boolean
	 */
	public boolean isProgrammer()
	{
		return baseUser.getIsProgrammer() == 1;
	}

	/**
	 * 通过模块名称和功能名称进行权限检测
	 * @param moduleCode String		模块代码
	 * @param functionCode String	功能代码,可分别用"||"或"&&"对多个功能代码进行隔开，如"Admin||Read"或"Admin&&Read"
	 * @return boolean
	 */
	public boolean checkFunction(String moduleCode, String functionCode)
	{
		return SecurityApp.checkFunction(this, moduleCode, functionCode);
	}

	/**
	 * 通过网址和请求字符串进行权限检测
	 * @param url String	网址
	 * @param query String	请求字符
	 * @return boolean
	 */
	public boolean checkUrl(String url, String query)
	{
		return SecurityApp.checkUrl(this, url, query);
	}

	/**
	 * 增加操作日志
	 * @param systemName String		系统或子系统名称
	 * @param moduleName String		模块名称
	 * @param content String		操作内容
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
