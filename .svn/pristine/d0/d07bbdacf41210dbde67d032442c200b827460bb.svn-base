package com.dhccity.base.entity;

import org.light.*;
import java.util.*;

/**
 * <p>Title: BASE_USER_PARAMETER ���Ӧ��</p>
 * <p>Description:BASE_USER_PARAMETER</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2007-02-09 16:14</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseUserParameter  extends Ado
{
	private long id; //ID
	private long userId; //�û�ID
	private String code; //����
	private String value; //ֵ

	//{defaultOrder = "o.id";} //Ĭ�ϵ�����ʽ

	public BaseUserParameter()
	{
	}

	public BaseUserParameter(long id)
	{
		this.id=id;
	}

	/**
	 * ��Ӧ�ֶΣ�[ID]  ���ͣ�NUMBER(22)
	 */
	public void setId(long id)
	{
		this.id=id;
	}

	/**
	 * ��Ӧ�ֶΣ�[ID]  ���ͣ�NUMBER(22)
	 */
	public long getId()
	{
		return this.id;
	}

	/**
	 * ��Ӧ�ֶΣ�[�û�ID]  ���ͣ�NUMBER(12)
	 */
	public void setUserId(long userId)
	{
		this.userId=userId;
	}

	/**
	 * ��Ӧ�ֶΣ�[�û�ID]  ���ͣ�NUMBER(12)
	 */
	public long getUserId()
	{
		return this.userId;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(100)
	 */
	public void setCode(String code)
	{
		this.code=code;
	}

	/**
	 * ��Ӧ�ֶΣ�[����]  ���ͣ�VARCHAR2(100)
	 */
	public String getCode()
	{
		return this.code==null?"":this.code;
	}

	/**
	 * ��Ӧ�ֶΣ�[ֵ]  ���ͣ�VARCHAR2(4000)
	 */
	public void setValue(String value)
	{
		this.value=value;
	}

	/**
	 * ��Ӧ�ֶΣ�[ֵ]  ���ͣ�VARCHAR2(4000)
	 */
	public String getValue()
	{
		return this.value==null?"":this.value;
	}


	//===============================����Ϊ�Ա༭����===================================

    /**
    * ͨ���û�ID���������û��������
    * @param userId long		�û�ID
    * @param code String		����
    * @return BaseUserParameter
    */
   public BaseUserParameter  findByUserId(long userId, String  code)
   {
       String hql = "from BaseUserParameter o where o.userId=" + userId + " and o.code='" + code + "'";
       return (BaseUserParameter) this.findObject(hql);
   }


}
