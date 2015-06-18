package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_USER_SECURITY �����Servlet��</p>
 * <p>Description:BASE_USER_SECURITY</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-02-14 14:33</p>
 * @author Zerrion
 * @version 1.0
 * <servlet><servlet-name>UserSecurityAction</servlet-name><servlet-class>com.dhccity.base.servlet.UserSecurityAction</servlet-class></servlet>
   <servlet-mapping><servlet-name>UserSecurityAction</servlet-name><url-pattern>/baseUserSecurityAction</url-pattern></servlet-mapping>
 */

public class UserSecurityAction extends ServletAction
{
	private final String SYSTEM_NAME = "ϵͳά����ϵͳ";
	private final String MODULE_NAME = "Ȩ������";
	private final int WINDOW_TYPE = 2; //0��ʾ��Ч��1��ʾ��ת��2��ʾ�ر�

	/**
	 * �������
	 */
	public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long securityId = request.getLong("securityId");
		String[] securityArray = request.getStringArray("securityArray");

		String security = "";

		for (int i = 0; i < securityArray.length; i++)
		{
			security += "{" + securityArray[i] + "}";
		}

		int type = request.getInt("type");
		long departmentId, ownerId;
		if (type == 1)
		{
			departmentId = request.getLong("departmentId1");
			ownerId = request.getLong("ownerId1");
		}
		else if (type == 2)
		{
			departmentId = request.getLong("departmentId2");
			ownerId = request.getLong("ownerId2");
		}
		else
		{
			departmentId = request.getLong("departmentId3");
			ownerId = request.getLong("ownerId3");
		}
		int sequ = request.getInt("sequ");

		//�½�һ������
		BaseUserSecurity baseUserSecurity = new BaseUserSecurity();
		baseUserSecurity.setSecurityId(securityId);
		baseUserSecurity.setSecurityArray(security);
		baseUserSecurity.setType(type);
		baseUserSecurity.setDepartmentId(departmentId);
		baseUserSecurity.setOwnerId(ownerId);
		baseUserSecurity.setSequ(sequ);
		baseUserSecurity.add(); //���Ӽ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "���Ӽ�¼[" + baseUserSecurity.getId() + "]");
		doReturn(response, WINDOW_TYPE);
	}

	/**
	 * ɾ����ݼ�
	 */
	public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long[] idArray = request.getLongArray("idArray");
		String log = "";

		//�½�һ������
		BaseUserSecurity baseUserSecurity = new BaseUserSecurity();
		if (idArray != null)
		{
			for (int i = 0; i < idArray.length; i++)
			{
				baseUserSecurity.delete(idArray[i]); //ɾ���¼
				log += idArray[i] + ";";
			}
		}
		user.addLog(SYSTEM_NAME, MODULE_NAME, "ɾ���¼[" + log + "]");
	}

}
