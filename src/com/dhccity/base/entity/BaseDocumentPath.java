package com.dhccity.base.entity;

import org.light.*;

/**
 * <p>Title: BASE_DOCUMENT_PATH 表对应类</p>
 * <p>Description:BASE_DOCUMENT_PATH</p>
 * <p>Company: dhccity</p>
 * <p>CreateDate: 2005-05-20 17:26</p>
 * @author Zerrion
 * @version 1.0
 */

public class BaseDocumentPath extends Ado
{
	private long id;		//ID
	private String sourceCode;	//来源代号
	private String path;		//路径
	private String explain;		//说明

	public BaseDocumentPath()
	{
	}

	public BaseDocumentPath(long id)
	{
		this.id = id;
	}

	/**
	 * 对应字段：[ID]  类型：NUMBER(22)
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * 对应字段：[ID]  类型：NUMBER(22)
	 */
	public long getId()
	{
		return this.id;
	}

	/**
	 * 对应字段：[来源代号]  类型：VARCHAR2(50)
	 */
	public void setSourceCode(String sourceCode)
	{
		this.sourceCode = sourceCode;
	}

	/**
	 * 对应字段：[来源代号]  类型：VARCHAR2(50)
	 */
	public String getSourceCode()
	{
		return this.sourceCode == null ? "" : this.sourceCode;
	}

	/**
	 * 对应字段：[存放路径]  类型：VARCHAR2(300)
	 */
	public void setPath(String path)
	{
		this.path = path;
	}

	/**
	 * 对应字段：[存放路径]  类型：VARCHAR2(300)
	 */
	public String getPath()
	{
		return this.path == null ? "" : this.path;
	}

	/**
	 * 对应字段：[说明]  类型：VARCHAR2(1000)
	 */
	public void setExplain(String explain)
	{
		this.explain = explain;
	}

	/**
	 * 对应字段：[说明]  类型：VARCHAR2(1000)
	 */
	public String getExplain()
	{
		return this.explain == null ? "" : this.explain;
	}

	//===============================以下为自编辑代码===================================

	/**
	 * 通过来源代号，获得类型的路径
	 * @param sourceCode String   来源代号
	 * @return String
	 */
	public String getDocumentPath(String sourceCode)
	{
		String hql = "from BaseDocumentPath o where o.sourceCode='" + sourceCode + "'";
		BaseDocumentPath baseDocumentPath = (BaseDocumentPath)this.findObject(hql);
		return baseDocumentPath.getPath();
	}

}
