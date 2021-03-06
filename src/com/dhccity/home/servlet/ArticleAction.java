package com.dhccity.home.servlet;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.light.*;

import com.dhccity.base.business.DocumentApp;
import com.dhccity.base.util.BaseConstant;
import com.dhccity.home.entity.Article;
/**
 * <p>Title: Article对象管理Servlet类</p>
 * <p>Description:</p>:);
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-12 15:06:08</p>
 * @author Zerrion
 * @version 1.0
 */
public class ArticleAction extends ServletAction implements BaseConstant
{
	private final String SYSTEM_NAME = "通用";
	private final String MODULE_NAME = "文章";
	private final int WINDOW_TYPE = 1; //0表示无效、1表示调转、2表示关闭

	/**
	 * 增加一条数据
	 */
	public void addData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String title = request.getString("title");
		String content = request.getString("content");
		//long type = request.getLong("type");
		//long creator = request.getLong("creator");
		//int state = request.getInt("state");
		String isPublic = request.getString("isPublic");
		Date today = new Date();
		//Date createTime = request.getDate("createTime");
		//long modifyUser = request.getLong("modifyUser");
		//Date modifyTime = request.getDate("modifyTime");
		//long readNum = request.getLong("readNum");
		//String ip = request.getString("ip");

		//新建一个对象
		Article article = new Article();
		article.setTitle(title);
		article.setContent(content);
		article.setType(ARTICLE_TYPE_CAROUSEL);
		article.setCreator(user.getId());
		article.setState(STATE_NORMAL);
		article.setIsPublic(isPublic);
		article.setCreateTime(today);
		//article.setModifyUser(modifyUser);
		//article.setModifyTime(modifyTime);
		//article.setReadNum(readNum);
		//article.setIp(request.getRemoteAddr());
		article.add(); //增加记录
		
		DocumentApp.addDocuments(request, article.getId(), user);

		user.addLog(SYSTEM_NAME, MODULE_NAME, "增加记录["+article.getId()+"]");
		doReturn(response, WINDOW_TYPE, "carousel_list.jsp");
	}

	/**
	 * 修改指定数据
	 */
	public void updateData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long id = request.getLong("id");
		String title = request.getString("title");
		String content = request.getString("content");
		String type = request.getString("type");
		long creator = request.getLong("creator");
		String state = request.getString("state");
		String isPublic = request.getString("isPublic");
		Date createTime = request.getDate("createTime");
		long modifyUser = request.getLong("modifyUser");
		Date modifyTime = request.getDate("modifyTime");
		long readNum = request.getLong("readNum");
		String ip = request.getString("ip");

		//新建一个对象
		Article article = (Article) new Article().findById(id);
		article.setId(id);
		article.setTitle(title);
		article.setContent(content);
		article.setType(type);
		article.setCreator(creator);
		article.setState(state);
		article.setIsPublic(isPublic);
		article.setCreateTime(createTime);
		article.setModifyUser(modifyUser);
		article.setModifyTime(modifyTime);
		article.setReadNum(readNum);
		article.setIp(ip);
		article.update(); //修改记录

		user.addLog(SYSTEM_NAME, MODULE_NAME, "修改记录[]");
		doReturn(response, WINDOW_TYPE, "carousel_list.jsp");
	}

	/**
	 * 删除数据
	 */
	public void deleteData(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		long[] idArray = request.getLongArray("idArray");
		String log = "";

		//新建一个对象
		Article article = new Article();
		if (idArray != null)
		{
			for (int i = 0; i < idArray.length; i++)
			{
				article.delete(idArray[i]); //删除记录
				log += idArray[i] + ";";
			}
		}

		user.addLog(SYSTEM_NAME, MODULE_NAME, "删除记录[" + log + "]");
	}
}
