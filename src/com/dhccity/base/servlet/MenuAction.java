package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.business.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_MENU 表管理Servlet类</p>
 * <p>Description:BASE_MENU</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-02-21 16:42</p>
 * @author Zerrion
 * @version 1.0
 * <servlet><servlet-name>MenuAction</servlet-name><servlet-class>com.dhccity.base.servlet.MenuAction</servlet-class></servlet>
   <servlet-mapping><servlet-name>MenuAction</servlet-name><url-pattern>/baseMenuAction</url-pattern></servlet-mapping>
 */

public class MenuAction extends ServletAction
{
	private final String SYSTEM_NAME = "系统维护子系统";
	private final String MODULE_NAME = "菜单管理";
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
		String target = request.getString("target");
		long securityId = request.getLong("securityId");
		String explain = request.getString("explain");
		String meno = request.getString("meno");

		//新建一个对象
		BaseMenu baseMenu = new BaseMenu();
		baseMenu.setName(name);
		baseMenu.setState(1);
		baseMenu.setSequ(sequ);
		baseMenu.setParentId(parentId);
		baseMenu.setValue(value);
		baseMenu.setTarget(target);
		baseMenu.setSecurityId(securityId);
		baseMenu.setExplain(explain);
		baseMenu.setMeno(meno);
		baseMenu.add(); //增加记录

		user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录[" + name + "]");
		doReturn(response, WINDOW_TYPE, "menu_list.jsp?searchField=id&searchValue=" + baseMenu.getId() + "&search=搜索");

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
		String target = request.getString("target");
		long securityId = request.getLong("securityId");
		String explain = request.getString("explain");
		String meno = request.getString("meno");

		//新建一个对象
		BaseMenu baseMenu = (BaseMenu)new BaseMenu().findById(id);
		baseMenu.setName(name);
		baseMenu.setSequ(sequ);
		baseMenu.setParentId(parentId);
		baseMenu.setValue(value);
		baseMenu.setTarget(target);
		baseMenu.setSecurityId(securityId);
		baseMenu.setExplain(explain);
		baseMenu.setMeno(meno);
		baseMenu.update(); //修改记录

		user.addLog(SYSTEM_NAME, MODULE_NAME, "修改记录[" + name + "]");
		doReturn(response, WINDOW_TYPE, "menu_list.jsp?searchField=id&searchValue=" + baseMenu.getId() + "&search=搜索");
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
				BaseMenu baseMenu = (BaseMenu)new BaseMenu().findById(idArray[i]);
				baseMenu.setState(state);
				baseMenu.update();
				log += baseMenu.getName() + ";";
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
	 * 根据用户创建菜单XML
	 */
	public void createMenu(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.print(MenuApp.createXml(user));
	}

}
