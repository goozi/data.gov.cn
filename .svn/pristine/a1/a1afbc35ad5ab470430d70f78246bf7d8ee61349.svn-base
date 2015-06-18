package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.business.*;

public class TreeAction extends ServletAction
{

	/**
	 * 增加数据
	 */
	public void createXml(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		out.print(MenuApp.createXml(user));
	}

}
