package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_DEPARTMENT �����Servlet��</p>
 * <p>Description:BASE_DEPARTMENT</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2006-04-11 12:38</p>
 * @author Zerrion
 * @version 1.0
 * <servlet><servlet-name>DepartmentAction</servlet-name><servlet-class>com.dhccity.base.servlet.DepartmentAction</servlet-class></servlet>
   <servlet-mapping><servlet-name>DepartmentAction</servlet-name><url-pattern>/baseDepartmentAction</url-pattern></servlet-mapping>
 */

public class DepartmentAction extends ServletAction
{
	private final String SYSTEM_NAME = "ϵͳά����ϵͳ";
	private final String MODULE_NAME = "���Ź���";
	private final int WINDOW_TYPE = 1; //0��ʾ��Ч��1��ʾ��ת��2��ʾ�ر�

	/**
	 * �������
	 */
	public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String name = request.getString("name");
		int sequ = request.getInt("sequ");
		long parentId = request.getLong("parentId");
		long leaderId = request.getLong("leaderId");
		String code = request.getString("code");
		String fullName = request.getString("fullName");
		long mainLevel = request.getLong("mainLevel");
		long subLevel = request.getLong("subLevel");
		long property = request.getLong("property");
		String address = request.getString("address");
		String postCode = request.getString("postCode");
		String canton = request.getString("canton");
		String tel = request.getString("tel");
		String fax = request.getString("fax");
		String explain = request.getString("explain");
		String meno = request.getString("meno");

		//�½�һ������
		BaseDepartment baseDepartment = new BaseDepartment();
		baseDepartment.setName(name);
		baseDepartment.setState(1);
		baseDepartment.setSequ(sequ);
		baseDepartment.setParentId(parentId);
		baseDepartment.setLeaderId(leaderId);
		baseDepartment.setCode(code);
		baseDepartment.setFullName(fullName);
		baseDepartment.setMainLevel(mainLevel);
		baseDepartment.setSubLevel(subLevel);
		baseDepartment.setProperty(property);
		baseDepartment.setAddress(address);
		baseDepartment.setPostCode(postCode);
		baseDepartment.setCanton(canton);
		baseDepartment.setTel(tel);
		baseDepartment.setFax(fax);
		baseDepartment.setExplain(explain);
		baseDepartment.setMeno(meno);
		baseDepartment.add(); //���Ӽ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "���Ӽ�¼[" + name + "]");
		doReturn(response, WINDOW_TYPE, "department_list.jsp?searchField=id&searchValue=" + baseDepartment.getId() + "&search=����");
	}

	/**
	 * �޸����
	 */
	public void updateData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long id = request.getLong("id");
		String name = request.getString("name");
		int sequ = request.getInt("sequ");
		long parentId = request.getLong("parentId");
		long leaderId = request.getLong("leaderId");
		String code = request.getString("code");
		String fullName = request.getString("fullName");
		long mainLevel = request.getLong("mainLevel");
		long subLevel = request.getLong("subLevel");
		long property = request.getLong("property");
		String address = request.getString("address");
		String postCode = request.getString("postCode");
		String canton = request.getString("canton");
		String tel = request.getString("tel");
		String fax = request.getString("fax");
		String explain = request.getString("explain");
		String meno = request.getString("meno");

		//�½�һ������
		BaseDepartment baseDepartment = (BaseDepartment)new BaseDepartment().findById(id);
		baseDepartment.setName(name);
		baseDepartment.setSequ(sequ);
		baseDepartment.setParentId(parentId);
		baseDepartment.setLeaderId(leaderId);
		baseDepartment.setCode(code);
		baseDepartment.setFullName(fullName);
		baseDepartment.setMainLevel(mainLevel);
		baseDepartment.setSubLevel(subLevel);
		baseDepartment.setProperty(property);
		baseDepartment.setAddress(address);
		baseDepartment.setPostCode(postCode);
		baseDepartment.setCanton(canton);
		baseDepartment.setTel(tel);
		baseDepartment.setFax(fax);
		baseDepartment.setExplain(explain);
		baseDepartment.setMeno(meno);
		baseDepartment.update(); //�޸ļ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "�޸ļ�¼[" + name + "]");
		doReturn(response, WINDOW_TYPE, "department_list.jsp?searchField=id&searchValue=" + baseDepartment.getId() + "&search=����");
	}

	/**
	 * �ı䲿��״̬
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
				BaseDepartment baseDepartment = (BaseDepartment)new BaseDepartment().findById(idArray[i]);
				baseDepartment.setState(state);
				baseDepartment.update();
				log += baseDepartment.getName() + ";";
			}
		}
		if (state == 0)
		{
			user.addLog(SYSTEM_NAME, MODULE_NAME, "ɾ���¼[" + log + "]");
		}
		else
		{
			user.addLog(SYSTEM_NAME, MODULE_NAME, "�ָ���¼[" + log + "]");
		}
	}

}
