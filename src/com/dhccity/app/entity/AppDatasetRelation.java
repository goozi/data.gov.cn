package com.dhccity.app.entity;

import java.util.*;
import org.light.*;

/**
 * <p>Title: APP_DATASET_RELATION表对应实体类</p>
 * <p>Description:应用数据集关系</p>
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-18 16:44:33</p>
 * @author Zerrion
 * @version 1.0
 */
public class AppDatasetRelation extends Ado
{
	private long id;				//ID
	private long appId;				//应用ID
	private long datasetId;			//数据集ID
	private Date createTime;		//创建时间

	{defaultOrder = "o.id desc";} //默认的排序方式

	public AppDatasetRelation()
	{
	}

	public AppDatasetRelation(long id)
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
	 * 对应字段：[应用ID]  类型：[NUMBER]  长度：[22]
	 */
	public void setAppId(long appId)
	{
		this.appId = appId;
	}

	/**
	 * 对应字段：[应用ID]  类型：[NUMBER]  长度：[22]
	 */
	public long getAppId()
	{
		return this.appId;
	}

	/**
	 * 对应字段：[数据集ID]  类型：[NUMBER]  长度：[22]
	 */
	public void setDatasetId(long datasetId)
	{
		this.datasetId = datasetId;
	}

	/**
	 * 对应字段：[数据集ID]  类型：[NUMBER]  长度：[22]
	 */
	public long getDatasetId()
	{
		return this.datasetId;
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

	//===============================以下为自编辑代码===================================

	/**
	 * 通过应用 ID 查找数据
	 * @param appId
	 * @return
	 */
	public AppDatasetRelation findByAppId(long appId){
		String hql = "from AppDatasetRelation o where o.appId="+appId;
		return (AppDatasetRelation)this.findObject(hql);
	}

	/**
	 * 通过数据集 ID 查找列表
	 * @param datasetId
	 * @return
	 */
	public  List<AppDatasetRelation> findByDatasetId(long datasetId){
		String hql = "from AppDatasetRelation o where o.datasetId="+datasetId;
		return this.findAll(hql);
	}
}
