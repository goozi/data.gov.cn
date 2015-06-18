package com.dhccity.base.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import org.light.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: �����о�ͼ��Ϣ�������޹�˾</p>
 * @author Zerrion
 * @version 1.0
 */

public class SystemAction extends ServletAction
{
	/**
	 * ������������
	 */
	public void restart(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		try
		{
			Runtime.getRuntime().exec("cmd.exe /c start " + Server.getCurrPath() + "restart.bat");
		}
		catch (IOException ex)
		{
		}
	}

}
