package com.dhccity.base.business;

import org.light.*;
import com.dhccity.base.entity.*;

public class UserParameterApp
{
	public int pageSize = 15; //每页显示行数
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
     * 获取属性取
     * @param userId long	用户ID
     * @param code String	代码
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
