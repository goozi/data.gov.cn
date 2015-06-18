package com.dhccity.data.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dhccity.base.util.BaseConstant;
import org.light.*;
import com.dhccity.data.entity.DataGroup;
/**
 * <p>Title: DataGroup对象管理Servlet类</p>
 * <p>Description:</p>:);
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-18 16:50:55</p>
 * @author Zerrion
 * @version 1.0
 */
public class DataGroupAction extends ServletAction implements BaseConstant
{
	private final String SYSTEM_NAME = "数据";
	private final String MODULE_NAME = "数据专题";
	private final int WINDOW_TYPE = 1; //0表示无效、1表示调转、2表示关闭

	/**
	 * 增加一条数据
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

		//新建一个对象
		DataGroup dataGroup = new DataGroup();
		dataGroup.setName(name);
		dataGroup.setTitle(title);
		dataGroup.setDescription(description);
		dataGroup.setCreateTime(now);
		dataGroup.setState(STATE_NORMAL);
		dataGroup.setCreator(user.getId());
		dataGroup.setApprovalStatus(APPROVAL_STATUS_NORMAL);
		dataGroup.setLogo(logo);
		dataGroup.setType("custom");//标识该专题为用户自定义
		dataGroup.add(); //增加记录

		user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录["+title+"]");
		doReturn(response, WINDOW_TYPE, "dataGroup_list.jsp");
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
		//Date createTime = request.getDate("createTime");
		//int state = request.getInt("state");
		//long creator = request.getLong("creator");
		//int approvalStatus = request.getInt("approvalStatus");
		String logo = request.getString("logo");

		//新建一个对象
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
		dataGroup.update(); //修改记录

		user.addLog(SYSTEM_NAME, MODULE_NAME, "修改记录[]");
		doReturn(response, WINDOW_TYPE, "dataGroup_list.jsp");
	}

	/**
	 * 删除数据
	 */
	public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long[] idArray = request.getLongArray("idArray");
		String log = "";

		//新建一个对象
		DataGroup dataGroup = new DataGroup();
		if (idArray != null)
		{
			for (int i = 0; i < idArray.length; i++)
			{
				dataGroup.delete(idArray[i]); //删除记录
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
		DataGroup dataGroup = (DataGroup) new DataGroup().findById(id);
		if(type.equals("refuse")){
			dataGroup.setApprovalStatus(APPROVAL_STATUS_REFUSE);
		}else if(type.equals("pass")){
			dataGroup.setApprovalStatus(APPROVAL_STATUS_PASS);
		}
		dataGroup.update(); //修改记录

		user.addLog(SYSTEM_NAME, MODULE_NAME, "审核记录["+ id+"]");
		PrintWriter out = response.getWriter();
		out.print("success");
	}
	/**
	 * 下拉框装载数据
	 */
	public void loadJsonData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String json = new DataGroup().getJsonByUser(user.getId());

		user.addLog(SYSTEM_NAME, MODULE_NAME, "下拉框装载数据["+ user.getId()+"]");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
}
