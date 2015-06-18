package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.business.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_TYPE ������Servlet��</p>
 * <p>Description:BASE_TYPE</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2005-07-18 10:20</p>
 * @author liuxd_
 * @version 1.0
 * <servlet><servlet-name>TypeAction</servlet-name><servlet-class>com.dhccity.xmsl.setup.servlet.TypeAction</servlet-class></servlet>
   <servlet-mapping><servlet-name>TypeAction</servlet-name><url-pattern>/baseTypeAction</url-pattern></servlet-mapping>
 */

public class TypeAction extends ServletAction
{
	private final String SYSTEM_NAME = "ϵͳά����ϵͳ";
	private final String MODULE_NAME = "�ֵ����";
	private final int WINDOW_TYPE = 1; //0��ʾ��Ч��1��ʾ��ת��2��ʾ�ر�

	/**
	 * �����ֵ�
	 */
	public void addType(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String name = request.getString("name");
		String code = request.getString("code");
		String userNames = request.getString("userNames");
		String userIds = request.getString("userIds");
		String type = request.getString("type");
		long parentId = request.getLong("parentId");
		int sequ = request.getInt("sequ");
		String explain = request.getString("explain");
		int securityLevel = request.getInt("securityLevel");

		//�½�һ������
		BaseType baseType = new BaseType();
		baseType.setName(name);
		baseType.setCode(code);
		baseType.setParentId(parentId);
		baseType.setUserNames(userNames);
		baseType.setUserIds(userIds);
		baseType.setType(type);
		baseType.setDescription(explain);
		baseType.setSequ(sequ);
		baseType.setState(1);
		baseType.setIsParent(1);
		baseType.setSecurityLevel(securityLevel);
		baseType.add(); //���Ӽ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "���Ӽ�¼[" + name + "]");
		doReturn(response, WINDOW_TYPE, "type_list.jsp?searchField=id&searchValue=" + baseType.getId() + "&search=����");

	}

	/**
	 * ����ѡ��
	 */
	public void addChildType(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String name = request.getString("name");
		int state = request.getInt("state");
		int isDefault = request.getInt("isDefault");
		int sequ = request.getInt("sequ");
		String code = request.getString("code");
		String type = request.getString("type");
		long parentId = request.getLong("parentId");
		String value = request.getString("value");

		//�½�һ������
		BaseType baseType = new BaseType();
		baseType.setName(name);
		baseType.setCode(code);
		baseType.setState(state);
		baseType.setIsDefault(isDefault);
		baseType.setSequ(sequ);
		baseType.setType(type);
		baseType.setParentId(parentId);
		baseType.setValue(value);
		baseType.add(); //���Ӽ�¼

		user.addLog(SYSTEM_NAME, "�ֵ�-ѡ�����", "���Ӽ�¼[" + name + "]");
		doReturn(response, 2);
	}

	/**
	 * �޸��ֵ�
	 */
	public void updateType(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long id = request.getLong("id");
		String name = request.getString("name");
		String code = request.getString("code");
		String userNames = request.getString("userNames");
		String userIds = request.getString("userIds");
		String type = request.getString("type");
		long parentId = request.getLong("parentId");
		int sequ = request.getInt("sequ");
		String explain = request.getString("explain");
		int securityLevel = request.getInt("securityLevel");
		//�½�һ������
		BaseType baseType = (BaseType)new BaseType().findById(id);
		baseType.setName(name);
		baseType.setCode(code);
		baseType.setUserNames(userNames);
		baseType.setUserIds(userIds);
		baseType.setParentId(parentId);
		baseType.setType(type);
		baseType.setSequ(sequ);
		baseType.setDescription(explain);
		baseType.setSecurityLevel(securityLevel);
		baseType.update(); //�޸ļ�¼
		user.addLog(SYSTEM_NAME, MODULE_NAME, "�޸ļ�¼[" + name + "]");
		doReturn(response, WINDOW_TYPE, "type_list.jsp?searchField=id&searchValue=" + id + "&search=����");
	}

	/**
	 * �޸�ѡ��
	 */
	public void updateChildType(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long id = request.getLong("id");
		String name = request.getString("name");
		int state = request.getInt("state");
		int isDefault = request.getInt("isDefault");
		int sequ = request.getInt("sequ");
		long parentId = request.getLong("parentId");
		String value = request.getString("value");

		//�½�һ������
		BaseType baseType = (BaseType)new BaseType().findById(id);
		baseType.setName(name);
		baseType.setState(state);
		baseType.setIsDefault(isDefault);
		baseType.setSequ(sequ);
		baseType.setParentId(parentId);
		baseType.setValue(value);
		baseType.update(); //�޸ļ�¼

		user.addLog(SYSTEM_NAME, "�ֵ�-ѡ�����", "�޸ļ�¼[" + name + "]");
		doReturn(response, 2);

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
				BaseType baseType = (BaseType)new BaseType().findById(idArray[i]);
				baseType.setState(state);
				baseType.update();
				log += baseType.getName() + ";";
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
	 * �������ͽṹXml�ַ�
	 */
	public void createTreeXml(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String sValue = TypeApp.createTreeXml(request.getString("code"));
		out.println(sValue);
	}

	/**
	 * �������ͽṹXml�ַ�--�ֵ�
	 */
	public void createParentTypeXml(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String sValue = TypeApp.createParentTypeXml(user);
		out.println(sValue);
	}

	/**
	 * �������Ƿ����
	 */
	public void checkCode(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String code = request.getString("code");
		long id = request.getLong("id");
		PrintWriter out = response.getWriter();
		if (BaseType.isHadCode(id, code))
		{
			out.print("false");
		}
		else
		{
			out.print("true");
		}
	}

}