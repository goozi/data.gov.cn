package com.dhccity.base.business;

import java.text.*;
import java.util.*;

import com.dhccity.base.entity.*;

/**
 * �����ȡҵ����
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: �����о�ͼ��Ϣ�������޹�˾</p>
 * @author Zerrion
 * @version 1.0
 */

public class ParameterApp
{

	/**
	 * ͨ�����code����ַ��Ͳ���ֵ
	 * @param code String �������
	 * @return String
	 */
	public static String getString(String code)
	{
		BaseParameter baseParameter = new BaseParameter().findByCode(code);
		return baseParameter == null ? "" : baseParameter.getValue();
	}

	/**
	 * ͨ�����code��������Ͳ���ֵ
	 * @param code String �������
	 * @return int
	 */
	public static int getInt(String code)
	{
		try
		{
			BaseParameter baseParameter = new BaseParameter().findByCode(code);
			return Integer.parseInt(baseParameter.getValue());
		}
		catch (Exception ex)
		{
			return 0;
		}
	}

	/**
	 * ͨ�����code��ø����Ͳ���ֵ
	 * @param code String   �������
	 * @return float
	 */
	public static float getFloat(String code)
	{
		try
		{
			BaseParameter baseParameter = new BaseParameter().findByCode(code);
			return Float.parseFloat(baseParameter.getValue());
		}
		catch (Exception ex)
		{
			return 0;
		}
	}

	/**
	 * ͨ�����code��������Ͳ���ֵ
	 * @param code String  �������
	 * @return float
	 */
	public static Date getDate(String code)
	{
		BaseParameter baseParameter = new BaseParameter().findByCode(code);
		Date date = null;
		SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			date = dataFormat.parse(baseParameter.getValue());
		}
		catch (Exception ex)
		{
			;
		}
		return date;
	}
}
