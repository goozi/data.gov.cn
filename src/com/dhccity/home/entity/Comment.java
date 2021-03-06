package com.dhccity.home.entity;

import java.util.*;
import org.light.*;

/**
 * <p>Title: comment表对应实体类</p>
 * <p>Description:评论</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2015-05-12 12:48:07</p>
 * @author Zerrion
 * @version 1.0
 */
public class Comment extends Ado
{
	private long id;				//ID
	private long articleId;			//文章ID
	private String content;			//内容
	private int state;				//状态
	private String ip;				//来源IP
	private long creator;			//创建人
	private Date createTime;		//创建时间
	private long modifyUser;		//修改人
	private Date modifyTime;		//修改时间

	{defaultOrder = "o.id desc";} //默认的排序方式

	public Comment()
	{
	}

	public Comment(long id)
	{
		this.id = id;
	}

	/**
	 * 对应字段：[ID]  类型：[NUMBER]  长度：[22]
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * 对应字段：[ID]  类型：[NUMBER]  长度：[22]
	 */
	public long getId()
	{
		return this.id;
	}

	/**
	 * 对应字段：[文章ID]  类型：[NUMBER]  长度：[22]
	 */
	public void setArticleId(long articleId)
	{
		this.articleId = articleId;
	}

	/**
	 * 对应字段：[文章ID]  类型：[NUMBER]  长度：[22]
	 */
	public long getArticleId()
	{
		return this.articleId;
	}

	/**
	 * 对应字段：[内容]  类型：[CLOB]  长度：[4000]
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	/**
	 * 对应字段：[内容]  类型：[CLOB]  长度：[4000]
	 */
	public String getContent()
	{
		return this.content== null ? "" : this.content;
	}

	/**
	 * 对应字段：[状态]  类型：[NUMBER]  长度：[1]
	 */
	public void setState(int state)
	{
		this.state = state;
	}

	/**
	 * 对应字段：[状态]  类型：[NUMBER]  长度：[1]
	 */
	public int getState()
	{
		return this.state;
	}

	/**
	 * 对应字段：[来源IP]  类型：[VARCHAR2]  长度：[15]
	 */
	public void setIp(String ip)
	{
		this.ip = ip;
	}

	/**
	 * 对应字段：[来源IP]  类型：[VARCHAR2]  长度：[15]
	 */
	public String getIp()
	{
		return this.ip== null ? "" : this.ip;
	}

	/**
	 * 对应字段：[创建人]  类型：[NUMBER]  长度：[22]
	 */
	public void setCreator(long creator)
	{
		this.creator = creator;
	}

	/**
	 * 对应字段：[创建人]  类型：[NUMBER]  长度：[22]
	 */
	public long getCreator()
	{
		return this.creator;
	}

	/**
	 * 对应字段：[创建时间]  类型：[DATE]  长度：[7]
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * 对应字段：[创建时间]  类型：[DATE]  长度：[7]
	 */
	public Date getCreateTime()
	{
		return this.createTime;
	}

	/**
	 * 对应字段：[修改人]  类型：[NUMBER]  长度：[22]
	 */
	public void setModifyUser(long modifyUser)
	{
		this.modifyUser = modifyUser;
	}

	/**
	 * 对应字段：[修改人]  类型：[NUMBER]  长度：[22]
	 */
	public long getModifyUser()
	{
		return this.modifyUser;
	}

	/**
	 * 对应字段：[修改时间]  类型：[DATE]  长度：[7]
	 */
	public void setModifyTime(Date modifyTime)
	{
		this.modifyTime = modifyTime;
	}

	/**
	 * 对应字段：[修改时间]  类型：[DATE]  长度：[7]
	 */
	public Date getModifyTime()
	{
		return this.modifyTime;
	}

	//===============================以下为自编辑代码===================================

	public List<Comment> findByArticleId(long articleId){
		String hql = "from Comment o where o.articleId="+articleId+" and o.state=1";
		return this.findAll(hql);
	}
}
