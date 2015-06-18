package com.dhccity.data.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dhccity.base.util.BaseConstant;
import org.light.*;
import com.dhccity.data.entity.DataGroup;
/**
 * <p>Title: DataGroup�������Servlet��</p>
 * <p>Description:</p>:);
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-18 16:50:55</p>
 * @author Zerrion
 * @version 1.0
 */
public class DataGroupAction extends ServletAction implements BaseConstant
{
	private final String SYSTEM_NAME = "����";
	private final String MODULE_NAME = "����ר��";
	private final int WINDOW_TYPE = 1; //0��ʾ��Ч��1��ʾ��ת��2��ʾ�ر�

	/**
	 * ����һ������
	 */
	public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String name = request.getString("name");
		String title = request.getString("title");
		String description = request.getString("description");
		//Date createTime = request.getDate("createTime");
		//int state = request.getInt("state");
		//long creator = request.getLong("creator");
		//int approvalStatus = request.getInt("approvalStatus");
		String logo = request.getString("logo");

		Date now = new Date();

		//�½�һ������
		DataGroup dataGroup = new DataGroup();
		dataGroup.setName(name);
		dataGroup.setTitle(title);
		dataGroup.setDescription(description);
		dataGroup.setCreateTime(now);
		dataGroup.setState(STATE_NORMAL);
		dataGroup.setCreator(user.getId());
		dataGroup.setApprovalStatus(APPROVAL_STATUS_NORMAL);
		dataGroup.setLogo(logo);
		dataGroup.setType("custom");//��ʶ��ר��Ϊ�û��Զ���
		dataGroup.add(); //���Ӽ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "���Ӽ�¼["+title+"]");
		doReturn(response, WINDOW_TYPE, "dataGroup_list.jsp");
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
		//Date createTime = request.getDate("createTime");
		//int state = request.getInt("state");
		//long creator = request.getLong("creator");
		//int approvalStatus = request.getInt("approvalStatus");
		String logo = request.getString("logo");

		//�½�һ������
		DataGroup dataGroup = (DataGroup) new DataGroup().findById(id);
		dataGroup.setId(id);
		dataGroup.setName(name);
		dataGroup.setTitle(title);
		dataGroup.setDescription(description);
		//dataGroup.setCreateTime(createTime);
		//dataGroup.setState(state);
		//dataGroup.setCreator(creator);
		//dataGroup.setApprovalStatus(approvalStatus);
		dataGroup.setLogo(logo);
		dataGroup.update(); //�޸ļ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "�޸ļ�¼[]");
		doReturn(response, WINDOW_TYPE, "dataGroup_list.jsp");
	}

	/**
	 * ɾ������
	 */
	public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long[] idArray = request.getLongArray("idArray");
		String log = "";

		//�½�һ������
		DataGroup dataGroup = new DataGroup();
		if (idArray != null)
		{
			for (int i = 0; i < idArray.length; i++)
			{
				dataGroup.delete(idArray[i]); //ɾ����¼
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
		DataGroup dataGroup = (DataGroup) new DataGroup().findById(id);
		if(type.equals("refuse")){
			dataGroup.setApprovalStatus(APPROVAL_STATUS_REFUSE);
		}else if(type.equals("pass")){
			dataGroup.setApprovalStatus(APPROVAL_STATUS_PASS);
		}
		dataGroup.update(); //�޸ļ�¼

		user.addLog(SYSTEM_NAME, MODULE_NAME, "��˼�¼["+ id+"]");
		PrintWriter out = response.getWriter();
		out.print("success");
	}
	/**
	 * ������װ������
	 */
	public void loadJsonData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String json = new DataGroup().getJsonByUser(user.getId());

		user.addLog(SYSTEM_NAME, MODULE_NAME, "������װ������["+ user.getId()+"]");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
