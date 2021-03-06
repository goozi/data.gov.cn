package com.dhccity.home.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dhccity.base.util.BaseConstant;
import com.dhccity.base.util.SystemUtil;
import org.light.*;
import com.dhccity.home.entity.Comment;
/**
 * <p>Title: Comment对象管理Servlet类</p>
 * <p>Description:</p>:);
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-18 16:55:51</p>
 * @author Zerrion
 * @version 1.0
 */
public class CommentAction extends ServletAction implements BaseConstant
{
	private final String SYSTEM_NAME = "通用";
	private final String MODULE_NAME = "评论";
	private final int WINDOW_TYPE = 1; //0表示无效、1表示调转、2表示关闭

	/**
	 * 增加一条数据
	 */
	public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long articleId = request.getLong("articleId");
		String content = request.getString("content");

		Date now = new Date();

		//新建一个对象
		Comment comment = new Comment();
		comment.setArticleId(articleId);
		comment.setContent(content);
		comment.setState(1);
		comment.setIp(user.getIp());
		comment.setCreator(user.getId());
		comment.setCreateTime(now);
		comment.setModifyUser(user.getId());
		comment.setModifyTime(now);
		comment.add(); //增加记录

		user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录["+comment.getId()+"]");
//		doReturn(response, WINDOW_TYPE, "comment_list.jsp");
		response.getWriter().print("success");
	}

	/**
	 * 修改指定数据
	 */
	public void updateData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long id = request.getLong("id");
		long articleId = request.getLong("articleId");
		String content = request.getString("content");

		Date now = new Date();

		//新建一个对象
		Comment comment = (Comment) new Comment().findById(id);
		comment.setId(id);
		comment.setArticleId(articleId);
		comment.setContent(content);
		comment.setModifyUser(user.getId());
		comment.setModifyTime(now);
		comment.update(); //修改记录

		user.addLog(SYSTEM_NAME, MODULE_NAME, "修改记录["+id+"]");
		doReturn(response, WINDOW_TYPE, "comment_list.jsp");
	}

	/**
	 * 删除数据
	 */
	public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long[] idArray = request.getLongArray("idArray");
		String log = "";

		//新建一个对象
		Comment comment = new Comment();
		if (idArray != null)
		{
			for (int i = 0; i < idArray.length; i++)
			{
				comment.delete(idArray[i]); //删除记录
				log += idArray[i] + ";";
			}
		}

		user.addLog(SYSTEM_NAME, MODULE_NAME, "删除记录[" + log + "]");
	}
}
