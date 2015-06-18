package com.dhccity.home.entity;

import java.util.*;
import org.light.*;

/**
 * <p>Title: comment����Ӧʵ����</p>
 * <p>Description:����</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2015-05-12 12:48:07</p>
 * @author Zerrion
 * @version 1.0
 */
public class Comment extends Ado
{
	private long id;				//ID
	private long articleId;			//����ID
	private String content;			//����
	private int state;				//״̬
	private String ip;				//��ԴIP
	private long creator;			//������
	private Date createTime;		//����ʱ��
	private long modifyUser;		//�޸���
	private Date modifyTime;		//�޸�ʱ��

	{defaultOrder = "o.id desc";} //Ĭ�ϵ�����ʽ

	public Comment()
	{
	}

	public Comment(long id)
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
	 * ��Ӧ�ֶΣ�[����ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public void setArticleId(long articleId)
	{
		this.articleId = articleId;
	}

	/**
	 * ��Ӧ�ֶΣ�[����ID]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public long getArticleId()
	{
		return this.articleId;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�[CLOB]  ���ȣ�[4000]
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�[CLOB]  ���ȣ�[4000]
	 */
	public String getContent()
	{
		return this.content== null ? "" : this.content;
	}

	/**
	 * ��Ӧ�ֶΣ�[״̬]  ���ͣ�[NUMBER]  ���ȣ�[1]
	 */
	public void setState(int state)
	{
		this.state = state;
	}

	/**
	 * ��Ӧ�ֶΣ�[״̬]  ���ͣ�[NUMBER]  ���ȣ�[1]
	 */
	public int getState()
	{
		return this.state;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ԴIP]  ���ͣ�[VARCHAR2]  ���ȣ�[15]
	 */
	public void setIp(String ip)
	{
		this.ip = ip;
	}

	/**
	 * ��Ӧ�ֶΣ�[��ԴIP]  ���ͣ�[VARCHAR2]  ���ȣ�[15]
	 */
	public String getIp()
	{
		return this.ip== null ? "" : this.ip;
	}

	/**
	 * ��Ӧ�ֶΣ�[������]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public void setCreator(long creator)
	{
		this.creator = creator;
	}

	/**
	 * ��Ӧ�ֶΣ�[������]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public long getCreator()
	{
		return this.creator;
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

	/**
	 * ��Ӧ�ֶΣ�[�޸���]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public void setModifyUser(long modifyUser)
	{
		this.modifyUser = modifyUser;
	}

	/**
	 * ��Ӧ�ֶΣ�[�޸���]  ���ͣ�[NUMBER]  ���ȣ�[22]
	 */
	public long getModifyUser()
	{
		return this.modifyUser;
	}

	/**
	 * ��Ӧ�ֶΣ�[�޸�ʱ��]  ���ͣ�[DATE]  ���ȣ�[7]
	 */
	public void setModifyTime(Date modifyTime)
	{
		this.modifyTime = modifyTime;
	}

	/**
	 * ��Ӧ�ֶΣ�[�޸�ʱ��]  ���ͣ�[DATE]  ���ȣ�[7]
	 */
	public Date getModifyTime()
	{
		return this.modifyTime;
	}

	//===============================����Ϊ�Ա༭����===================================

	public List<Comment> findByArticleId(long articleId){
		String hql = "from Comment o where o.articleId="+articleId+" and o.state=1";
		return this.findAll(hql);
	}
}