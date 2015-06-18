package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.business.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_SECURITY 表管理Servlet类</p>
 * <p>Description:BASE_SECURITY</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-02-14 13:51</p>
 * @author liuxd
 * @version 1.0
 * <servlet><servlet-name>SecurityAction</servlet-name><servlet-class>com.dhccity.base.servlet.SecurityAction</servlet-class></servlet>
   <servlet-mapping><servlet-name>SecurityAction</servlet-name><url-pattern>/baseSecurityAction</url-pattern></servlet-mapping>
 */

public class SecurityAction extends ServletAction
{
	private final String SYSTEM_NAME = "系统维护子系统";
	private final String MODULE_NAME = "权限管理";
	private final int WINDOW_TYPE = 1; //0表示无效、1表示调转、2表示关闭

	/**
	 * 增加数据
	 */
	public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String name = request.getString("name");
		int sequ = request.getInt("sequ");
		long parentId = request.getLong("parentId");
		String value = request.getString("value");
		int type = request.getInt("type");
		String explain = request.getString("explain");
		String meno = request.getString("meno");
		int securityLevel = request.getInt("securityLevel");

		//新建一个对象
		BaseSecurity baseSecurity = new BaseSecurity();
		baseSecurity.setName(name);
		baseSecurity.setState(1);
		baseSecurity.setSequ(sequ);
		baseSecurity.setParentId(parentId);
		baseSecurity.setValue(value);
		baseSecurity.setType(type);
		baseSecurity.setDescription(explain);
		baseSecurity.setMeno(meno);
		baseSecurity.setSecurityLevel(securityLevel);
		baseSecurity.add(); //增加记录

		//增加相关网址参数
		String[] urls = request.getStringArray("urls");
		String[] query = request.getStringArray("querys");
		for (int i = 0; i < urls.length; i++)
		{
			if (!urls[i].equals(""))
			{

				BaseSecurityUrl baseSecurityUrl = new BaseSecurityUrl();
				baseSecurityUrl.setSecurityId(baseSecurity.getId());
				baseSecurityUrl.setUrl(urls[i]);
				baseSecurityUrl.setQuery(query[i]);
				baseSecurityUrl.add(); //增加记录
			}
		}

		user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录[" + name + "]");
		doReturn(response, WINDOW_TYPE, "security_list.jsp?searchField=id&searchValue=" + baseSecurity.getId() + "&search=搜索");
	}

	/**
	 * 修改数据
	 */
	public void updateData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long id = request.getLong("id");
		String name = request.getString("name");
		int sequ = request.getInt("sequ");
		long parentId = request.getLong("parentId");
		String value = request.getString("value");
		int type = request.getInt("type");
		String explain = request.getString("explain");
		String meno = request.getString("meno");
		int securityLevel = request.getInt("securityLevel");

		//新建一个对象
		BaseSecurity baseSecurity = (BaseSecurity)new BaseSecurity().findById(id);
		baseSecurity.setName(name);
		baseSecurity.setSequ(sequ);
		baseSecurity.setParentId(parentId);
		baseSecurity.setValue(value);
		baseSecurity.setType(type);
		baseSecurity.setDescription(explain);
		baseSecurity.setMeno(meno);
		baseSecurity.setSecurityLevel(securityLevel);
		baseSecurity.update(); //修改记录

		//修改相关网址参数
		String[] urls = request.getStringArray("urls");
		String[] query = request.getStringArray("querys");
		long[] ids = request.getLongArray("ids");
		BaseSecurityUrl.deleteBySecurityId(baseSecurity.getId(), ids);
		for (int i = 0; i < urls.length; i++)
		{
			if (!urls[i].equals("") && ids[i] > 0)
			{
				BaseSecurityUrl baseSecurityUrl = (BaseSecurityUrl)new BaseSecurityUrl().findById(ids[i]);
				baseSecurityUrl.setSecurityId(baseSecurity.getId());
				baseSecurityUrl.setUrl(urls[i]);
				baseSecurityUrl.setQuery(query[i]);
				baseSecurityUrl.update(); //修改记录
			}
			if (!urls[i].equals("") && ids[i] == 0)
			{
				BaseSecurityUrl baseSecurityUrl = new BaseSecurityUrl();
				baseSecurityUrl.setSecurityId(baseSecurity.getId());
				baseSecurityUrl.setUrl(urls[i]);
				baseSecurityUrl.setQuery(query[i]);
				baseSecurityUrl.add(); //增加记录
			}
		}

		user.addLog(SYSTEM_NAME, MODULE_NAME, "修改记录[" + name + "]");
		doReturn(response, WINDOW_TYPE, "security_list.jsp?searchField=id&searchValue=" + baseSecurity.getId() + "&search=搜索");
	}

	/**
	 * 改变状态
	 */
	public void updateState(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long[] idArray = request.getLongArray("idArray");
		int state = request.getInt("state");
		String log = "";
		if (idArray != null)
		{
			for (int i = 0; i < idArray.length; i++)
			{
				BaseSecurity baseSecurity = (BaseSecurity)new BaseSecurity().findById(idArray[i]);
				baseSecurity.setState(state);
				baseSecurity.update();
				log += baseSecurity.getName() + ";";
			}
		}
		if (state == 0)
		{
			user.addLog(SYSTEM_NAME, MODULE_NAME, "删除记录[" + log + "]");
		}
		else
		{
			user.addLog(SYSTEM_NAME, MODULE_NAME, "恢复记录[" + log + "]");
		}
	}

	/**
	 * 创建单选树XML
	 */
	public void createRadioTreeXml(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.print(SecurityApp.createRadioTreeXml());
	}

	/**
	 * 创建树形XML
	 */
	public void createTreeXml(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.print(TreeApp.createTreeXml("Security"));
	}

	/**
	 * 检测代码是否存在
	 */
	public void checkCode(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String code = request.getString("code");
		long id = request.getLong("id");
		long parentId = request.getLong("parentId");
		int type = request.getInt("type");
		PrintWriter out = response.getWriter();
		if (BaseSecurity.isHadCode(id, code, parentId, type))
		{
			out.print("false");
		}
		else
		{
			out.print("true");
		}
	}

}
