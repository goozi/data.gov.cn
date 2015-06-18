package com.dhccity.data.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dhccity.base.util.BaseConstant;
import org.light.*;
import com.dhccity.data.entity.Org;
/**
 * <p>Title: Org对象管理Servlet类</p>
 * <p>Description:</p>:);
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-18 16:52:59</p>
 * @author Zerrion
 * @version 1.0
 */
public class OrgAction extends ServletAction implements BaseConstant
{
	private final String SYSTEM_NAME = "数据";
	private final String MODULE_NAME = "发布机构";
	private final int WINDOW_TYPE = 1; //0表示无效、1表示调转、2表示关闭

	/**
	 * 增加一条数据
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

		//新建一个对象
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
		org.add(); //增加记录

		user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录["+title+"]");
		doReturn(response, WINDOW_TYPE, "org_list.jsp");
	}

	/**
	 * 修改指定数据
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

		//新建一个对象
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
		org.update(); //修改记录

		user.addLog(SYSTEM_NAME, MODULE_NAME, "修改记录["+title+"]");
		doReturn(response, WINDOW_TYPE, "org_list.jsp");
	}

	/**
	 * 删除数据
	 */
	public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long[] idArray = request.getLongArray("idArray");
		String log = "";

		//新建一个对象
		Org org = new Org();
		if (idArray != null)
		{
			for (int i = 0; i < idArray.length; i++)
			{
				org.delete(idArray[i]); //删除记录
				log += idArray[i] + ";";
			}
		}

		user.addLog(SYSTEM_NAME, MODULE_NAME, "删除记录[" + log + "]");
	}

	/**
	 * 审核
	 */
	public void approvalData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long id = request.getLong("id");
		String type = request.getString("type");

		//新建一个对象
		Org org = (Org) new Org().findById(id);
		if(type.equals("refuse")){
			org.setApprovalStatus(APPROVAL_STATUS_REFUSE);
		}else if(type.equals("pass")){
			org.setApprovalStatus(APPROVAL_STATUS_PASS);
		}
		org.update(); //修改记录

		user.addLog(SYSTEM_NAME, MODULE_NAME, "审核记录["+ id+"]");
		PrintWriter out = response.getWriter();
		out.print("success");
	}
	/**
	 * 下拉框装载数据
	 */
	public void loadJsonData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String json = new Org().getJsonByUser(user.getId());

		user.addLog(SYSTEM_NAME, MODULE_NAME, "下拉框装载数据["+ user.getId()+"]");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
