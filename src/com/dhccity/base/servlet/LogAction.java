package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_LOG �����Servlet��</p>
 * <p>Description:BASE_LOG</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2007-01-15 16:55</p>
 * @author Zerrion
 * @version 1.0
 * <servlet><servlet-name>LogAction</servlet-name><servlet-class>com.dhccity.base.servlet.LogAction</servlet-class></servlet>
   <servlet-mapping><servlet-name>LogAction</servlet-name><url-pattern>/baseLogAction</url-pattern></servlet-mapping>
 */

public class LogAction extends ServletAction
{
	private final String SYSTEM_NAME = "ϵͳά����ϵͳ";
	private final String MODULE_NAME = "��־����";

	/**
	 * ɾ����ݼ�
	 */
	public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long[] idArray = request.getLongArray("idArray");
		String log = "";

		//�½�һ������
		BaseLog baseLog = new BaseLog();
		if (idArray != null)
		{
			for (int i = 0; i < idArray.length; i++)
			{
				baseLog.delete(idArray[i]); //ɾ���¼
				log += idArray[i] + ";";
			}
		}
		user.addLog(SYSTEM_NAME, MODULE_NAME, "ɾ���¼[" + log + "]");
	}
}
