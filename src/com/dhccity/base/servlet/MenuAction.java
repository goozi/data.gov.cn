package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.business.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_MENU ������Servlet��</p>
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
	private final String SYSTEM_NAME = "ϵͳά����ϵͳ";
	private final String MODULE_NAME = "�˵�����";
	private final int WINDOW_TYPE = 1; //0��ʾ��Ч��1��ʾ��ת��2��ʾ�ر�

	/**
	 * ��������
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

		//�½�һ������
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
		baseMenu.add(); //���Ӽ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "���Ӽ�¼[" + name + "]");
		doReturn(response, WINDOW_TYPE, "menu_list.jsp?searchField=id&searchValue=" + baseMenu.getId() + "&search=����");

	}

	/**
	 * �޸�����
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

		//�½�һ������
		BaseMenu baseMenu = (BaseMenu)new BaseMenu().findById(id);
		baseMenu.setName(name);
		baseMenu.setSequ(sequ);
		baseMenu.setParentId(parentId);
		baseMenu.setValue(value);
		baseMenu.setTarget(target);
		baseMenu.setSecurityId(securityId);
		baseMenu.setExplain(explain);
		baseMenu.setMeno(meno);
		baseMenu.update(); //�޸ļ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "�޸ļ�¼[" + name + "]");
		doReturn(response, WINDOW_TYPE, "menu_list.jsp?searchField=id&searchValue=" + baseMenu.getId() + "&search=����");
	}

	/**
	 * �ı�״̬
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
			user.addLog(SYSTEM_NAME, MODULE_NAME, "ɾ����¼[" + log + "]");
		}
		else
		{
			user.addLog(SYSTEM_NAME, MODULE_NAME, "�ָ���¼[" + log + "]");
		}
	}

	/**
	 * �����û������˵�XML
	 */
	public void createMenu(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.print(MenuApp.createXml(user));
	}

}