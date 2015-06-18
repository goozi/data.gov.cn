package com.dhccity.app.entity;

import java.util.*;
import org.light.*;

/**
 * <p>Title: APP_DATASET_RELATION���Ӧʵ����</p>
 * <p>Description:Ӧ�����ݼ���ϵ</p>
 * <p>Company: Kingtop</p>
 * <p>CreateDate: 2015-05-18 16:44:33</p>
 * @author Zerrion
 * @version 1.0
 */
public class AppDatasetRelation extends Ado
{
	private long id;				//ID
	private long appId;				//Ӧ��ID
	private long datasetId;			//���ݼ�ID
	private Date createTime;		//����ʱ��

	{defaultOrder = "o.id desc";} //Ĭ�ϵ�����ʽ

	public AppDatasetRelation()
	{
	}

	public AppDatasetRelation(long id)
	{
		this.id = id;
	}

	/**
	 * ��Ӧ�ֶΣ�[ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * ��Ӧ�ֶΣ�[ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public long getId()
	{
		return this.id;
	}

	/**
	 * ��Ӧ�ֶΣ�[Ӧ��ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public void setAppId(long appId)
	{
		this.appId = appId;
	}

	/**
	 * ��Ӧ�ֶΣ�[Ӧ��ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public long getAppId()
	{
		return this.appId;
	}

	/**
	 * ��Ӧ�ֶΣ�[���ݼ�ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public void setDatasetId(long datasetId)
	{
		this.datasetId = datasetId;
	}

	/**
	 * ��Ӧ�ֶΣ�[���ݼ�ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public long getDatasetId()
	{
		return this.datasetId;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ʱ��]  ���ͣ�[DATE]  ���ȣ�[7]
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ʱ��]  ���ͣ�[DATE]  ���ȣ�[7]
	 */
	public Date getCreateTime()
	{
		return this.createTime;
	}

	//===============================����Ϊ�Ա༭����===================================

	/**
	 * ͨ��Ӧ�� ID ��������
	 * @param appId
	 * @return
	 */
	public AppDatasetRelation findByAppId(long appId){
		String hql = "from AppDatasetRelation o where o.appId="+appId;
		return (AppDatasetRelation)this.findObject(hql);
	}

	/**
	 * ͨ�����ݼ� ID �����б�
	 * @param datasetId
	 * @return
	 */
	public  List<AppDatasetRelation> findByDatasetId(long datasetId){
		String hql = "from AppDatasetRelation o where o.datasetId="+datasetId;
		return this.findAll(hql);
	}
}
