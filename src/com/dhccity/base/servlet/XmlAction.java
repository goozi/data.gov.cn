package com.dhccity.base.servlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.light.*;
import com.dhccity.base.entity.*;

public class XmlAction extends ServletAction
{

	/**
	 * 部门用户XML
	 */
	public void createDepartmentAndUser(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String strXml = "<?xml version='1.0' encoding='GB2312'?>";
		strXml += "<tree>";

		strXml += "<item text='┌全部' value='0'>";
		Iterator itUser = new BaseUser().findAllUser().iterator();
		while (itUser.hasNext())
		{
			BaseUser baseUser = (BaseUser) itUser.next();
			strXml += "<item text='" + baseUser.getName() + "' value='" + baseUser.getId() + "' />";
		}
		strXml += "</item>";

		Iterator it = new BaseDepartment().findAllNode(1).iterator();

		while (it.hasNext())
		{
			BaseDepartment baseDepartment = (BaseDepartment) it.next();
			strXml += "<item text='" + baseDepartment.getLevelString() + baseDepartment.getName() + "' value='"+baseDepartment.getId()+"'>";
			Iterator itUserTemp = new BaseUser().findByDepartmentId(baseDepartment.getId()).iterator();
			while (itUserTemp.hasNext())
			{
				BaseUser baseUser = (BaseUser) itUserTemp.next();
				strXml += "<item text='" + baseUser.getName() + "' value='" + baseUser.getId() + "' />";
			}
			strXml += "</item>";
		}
		strXml += "</tree>";
		out.print(strXml);
	}

	/**
	 * 部门用户XML
	 */
	public void createDepartmentAndUser2(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		String strXml = "<?xml version='1.0' encoding='GB2312'?>";
		strXml += "<tree>";

		strXml += "<item text='' value='0'>";
		Iterator itUser = new BaseUser().findAllUser().iterator();
		strXml += "<item text='' value='0' />";
		while (itUser.hasNext())
		{
			BaseUser baseUser = (BaseUser) itUser.next();
			strXml += "<item text='" + baseUser.getName() + "' value='" + baseUser.getId() + "' />";
		}
		strXml += "</item>";

		Iterator it = new BaseDepartment().findAllNode(1).iterator();

		while (it.hasNext())
		{
			BaseDepartment baseDepartment = (BaseDepartment) it.next();
			strXml += "<item text='" + baseDepartment.getLevelString() + baseDepartment.getName() + "' value='" + baseDepartment.getId() + "' >";
			Iterator itUserTemp = new BaseUser().findByDepartmentId(baseDepartment.getId()).iterator();
			strXml += "<item text='' value='0' />";
			while (itUserTemp.hasNext())
			{
				BaseUser baseUser = (BaseUser) itUserTemp.next();
				strXml += "<item text='" + baseUser.getName() + "' value='" + baseUser.getId() + "' />";
			}
			strXml += "</item>";
		}
		strXml += "</tree>";
		out.print(strXml);
	}

}
