package com.dhccity.base.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.light.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_USER_PARAMETER �����Servlet��</p>
 * <p>Description:BASE_USER_PARAMETER</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2007-02-09 16:14</p>
 * @author Zerrion
 * @version 1.0
 * <servlet><servlet-name>UserParameterAction</servlet-name><servlet-class>com.dhccity.base.servlet.UserParameterAction</servlet-class></servlet>
   <servlet-mapping><servlet-name>UserParameterAction</servlet-name><url-pattern>/baseUserParameterAction</url-pattern></servlet-mapping>
 */

public class UserParameterAction extends ServletAction
{
	private final String SYSTEM_NAME = "ϵͳά����ϵͳ";
	private final String MODULE_NAME = "�û���������";
	private final int WINDOW_TYPE = 1; //0��ʾ��Ч��1��ʾ��ת��2��ʾ�ر�

	/**
	 * ����ֵ����
	 */
	public void setupValue(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		BaseUserParameter baseUserParameter = null;

		String pageSize = request.getString("pageSize");
		baseUserParameter = new BaseUserParameter().findByUserId(user.getId(), "PAGE_SIZE");
		if (baseUserParameter != null)
		{
			baseUserParameter.setValue(pageSize);
			baseUserParameter.update();
		}
		else
		{
			baseUserParameter = new BaseUserParameter();
			baseUserParameter.setUserId(user.getId());
			baseUserParameter.setCode("PAGE_SIZE");
			baseUserParameter.setValue(pageSize);
			baseUserParameter.add();
		}

		user.addLog(SYSTEM_NAME, MODULE_NAME, "��������");
		doReturn(response, WINDOW_TYPE, "userParameter_setup.jsp");
	}

}
