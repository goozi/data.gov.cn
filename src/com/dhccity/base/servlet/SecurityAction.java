package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.business.*;
import com.dhccity.base.entity.*;

/**
 * <p>Title: BASE_SECURITY ������Servlet��</p>
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
	private final String SYSTEM_NAME = "ϵͳά����ϵͳ";
	private final String MODULE_NAME = "Ȩ�޹���";
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
		int type = request.getInt("type");
		String explain = request.getString("explain");
		String meno = request.getString("meno");
		int securityLevel = request.getInt("securityLevel");

		//�½�һ������
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
		baseSecurity.add(); //���Ӽ�¼

		//���������ַ����
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
				baseSecurityUrl.add(); //���Ӽ�¼
			}
		}

		user.addLog(SYSTEM_NAME, MODULE_NAME, "���Ӽ�¼[" + name + "]");
		doReturn(response, WINDOW_TYPE, "security_list.jsp?searchField=id&searchValue=" + baseSecurity.getId() + "&search=����");
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
		int type = request.getInt("type");
		String explain = request.getString("explain");
		String meno = request.getString("meno");
		int securityLevel = request.getInt("securityLevel");

		//�½�һ������
		BaseSecurity baseSecurity = (BaseSecurity)new BaseSecurity().findById(id);
		baseSecurity.setName(name);
		baseSecurity.setSequ(sequ);
		baseSecurity.setParentId(parentId);
		baseSecurity.setValue(value);
		baseSecurity.setType(type);
		baseSecurity.setDescription(explain);
		baseSecurity.setMeno(meno);
		baseSecurity.setSecurityLevel(securityLevel);
		baseSecurity.update(); //�޸ļ�¼

		//�޸������ַ����
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
				baseSecurityUrl.update(); //�޸ļ�¼
			}
			if (!urls[i].equals("") && ids[i] == 0)
			{
				BaseSecurityUrl baseSecurityUrl = new BaseSecurityUrl();
				baseSecurityUrl.setSecurityId(baseSecurity.getId());
				baseSecurityUrl.setUrl(urls[i]);
				baseSecurityUrl.setQuery(query[i]);
				baseSecurityUrl.add(); //���Ӽ�¼
			}
		}

		user.addLog(SYSTEM_NAME, MODULE_NAME, "�޸ļ�¼[" + name + "]");
		doReturn(response, WINDOW_TYPE, "security_list.jsp?searchField=id&searchValue=" + baseSecurity.getId() + "&search=����");
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
				BaseSecurity baseSecurity = (BaseSecurity)new BaseSecurity().findById(idArray[i]);
				baseSecurity.setState(state);
				baseSecurity.update();
				log += baseSecurity.getName() + ";";
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
	 * ������ѡ��XML
	 */
	public void createRadioTreeXml(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.print(SecurityApp.createRadioTreeXml());
	}

	/**
	 * ��������XML
	 */
	public void createTreeXml(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.print(TreeApp.createTreeXml("Security"));
	}

	/**
	 * �������Ƿ����
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