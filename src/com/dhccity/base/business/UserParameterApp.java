package com.dhccity.base.business;

import org.light.*;
import com.dhccity.base.entity.*;

public class UserParameterApp
{
	public int pageSize = 15; //ÿҳ��ʾ����
	public boolean isShow = false;

    public UserParameterApp()
    {
    }


	public UserParameterApp(long userId)
	{
		String pageSizeValue=getValue(userId,"PAGE_SIZE");
    	if (!pageSizeValue.equals("")) pageSize=Convert.toInt(pageSizeValue);
	}


    /**
     * ��ȡ����ȡ
     * @param userId long	�û�ID
     * @param code String	����
     * @return String
     */
    public String getValue(long userId,String code)
    {
		String value="";
        BaseUserParameter baseUserParameter=new BaseUserParameter().findByUserId(userId,code);
        if (baseUserParameter!=null) value=baseUserParameter.getValue();
        else
        {
            value=ParameterApp.getString(code);
        }
        return value;
    }

}
