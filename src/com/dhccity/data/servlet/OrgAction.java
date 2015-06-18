package com.dhccity.data.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dhccity.base.util.BaseConstant;
import org.light.*;
import com.dhccity.data.entity.Org;
/**
 * <p>Title: Org�������Servlet��</p>
 * <p>Description:</p>:);
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-18 16:52:59</p>
 * @author Zerrion
 * @version 1.0
 */
public class OrgAction extends ServletAction implements BaseConstant
{
	private final String SYSTEM_NAME = "����";
	private final String MODULE_NAME = "��������";
	private final int WINDOW_TYPE = 1; //0��ʾ��Ч��1��ʾ��ת��2��ʾ�ر�

	/**
	 * ����һ������
	 */
	public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String name = request.getString("name");
		String title = request.getString("title");
		String description = request.getString("description");
		//int state = request.getInt("state");
		String logo = request.getString("logo");
		long creator = request.getLong("creator");
		Date createTime = request.getDate("createTime");
		int approvalStatus = request.getInt("approvalStatus");

		Date now = new Date();

		//�½�һ������
		Org org = new Org();
		org.setName(name);
		org.setTitle(title);
		org.setDescription(description);
		org.setState(STATE_NORMAL);
		org.setLogo(logo);
		org.setCreator(user.getId());
		org.setCreateTime(now);
		org.setApprovalStatus(APPROVAL_STATUS_NORMAL);
		org.setType("custom");
		org.add(); //���Ӽ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "���Ӽ�¼["+title+"]");
		doReturn(response, WINDOW_TYPE, "org_list.jsp");
	}

	/**
	 * �޸�ָ������
	 */
	public void updateData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long id = request.getLong("id");
		String name = request.getString("name");
		String title = request.getString("title");
		String description = request.getString("description");
		//int state = request.getInt("state");
		String logo = request.getString("logo");
		//long creator = request.getLong("creator");
		//Date createTime = request.getDate("createTime");
		//int approvalStatus = request.getInt("approvalStatus");

		//�½�һ������
		Org org = (Org) new Org().findById(id);
		org.setId(id);
		org.setName(name);
		org.setTitle(title);
		org.setDescription(description);
		//org.setState(STATE_NORMAL);
		org.setLogo(logo);
		//org.setCreator(creator);
		//org.setCreateTime(createTime);
		//org.setApprovalStatus(approvalStatus);
		org.update(); //�޸ļ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "�޸ļ�¼["+title+"]");
		doReturn(response, WINDOW_TYPE, "org_list.jsp");
	}

	/**
	 * ɾ������
	 */
	public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long[] idArray = request.getLongArray("idArray");
		String log = "";

		//�½�һ������
		Org org = new Org();
		if (idArray != null)
		{
			for (int i = 0; i < idArray.length; i++)
			{
				org.delete(idArray[i]); //ɾ����¼
				log += idArray[i] + ";";
			}
		}

		user.addLog(SYSTEM_NAME, MODULE_NAME, "ɾ����¼[" + log + "]");
	}

	/**
	 * ���
	 */
	public void approvalData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long id = request.getLong("id");
		String type = request.getString("type");

		//�½�һ������
		Org org = (Org) new Org().findById(id);
		if(type.equals("refuse")){
			org.setApprovalStatus(APPROVAL_STATUS_REFUSE);
		}else if(type.equals("pass")){
			org.setApprovalStatus(APPROVAL_STATUS_PASS);
		}
		org.update(); //�޸ļ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "��˼�¼["+ id+"]");
		PrintWriter out = response.getWriter();
		out.print("success");
	}
	/**
	 * ������װ������
	 */
	public void loadJsonData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String json = new Org().getJsonByUser(user.getId());

		user.addLog(SYSTEM_NAME, MODULE_NAME, "������װ������["+ user.getId()+"]");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
