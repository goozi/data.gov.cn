package com.dhccity.base.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import java.util.Random;

import org.light.*;
import com.dhccity.base.business.*;
import com.dhccity.base.entity.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005</p>
 * @author Zerrion
 * @version 1.0
 */

public class LoginAction extends ServletAction
{

	/**
	 * 用户登录
	 */
	public void check(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String browserType = request.getHeader("User-Agent");
		String loginName = request.getString("loginName");
		String password = request.getString("password");
		String returnPage = "";
		try
		{
			//if (browserType.indexOf("MSIE") == -1 || loginName.equals("") || password.equals(""))
				if (loginName.equals("") || password.equals(""))
			{
				returnPage = response.encodeRedirectURL("login.jsps");
				response.sendRedirect(returnPage);
				return;
			}

			BaseUser baseUser = BaseUser.findByLoginName(loginName, password);
			if (baseUser != null) //密码验证通过
			{
				User currUser = new UserApp(baseUser);
				currUser.setIp(request.getRemoteAddr());
				currUser.setLoginTime(new Date());
				HttpSession session = request.getSession(true);
				session.removeAttribute("user");
				session.setAttribute("user", currUser);
				response.sendRedirect("main.jsp");
			}
			else
			{
				returnPage = response.encodeRedirectURL("login.jsps?state=ERROR&loginName=" + loginName);

				response.sendRedirect(returnPage);
			}
		}
		catch (Exception e)
		{
			returnPage = response.encodeRedirectURL("login.jsps?state=ERROR&loginName=" + loginName);
			response.sendRedirect(returnPage);
		}

	}

	/**
	 * 用户退出
	 */
	public void logout(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		request.getSession(false).removeAttribute("user");
		String returnPage = response.encodeRedirectURL("login.jsps");
		response.sendRedirect(returnPage);
	}


	/**
	 * 生成验证码
	 */
	public void captcha(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		Integer captcha = new Random().nextInt(5);
		request.getSession(false).setAttribute("captcha",captcha.toString());
		PrintWriter out = response.getWriter();
		out.print(captcha.toString());
	}

	/**
	 * 用户前端登录
	 */
	public void login(HttpRequest request, HttpServletResponse response, User user) throws ServletException, IOException
	{
		String loginName = request.getString("loginName");
		String password = request.getString("password");
		PrintWriter out = response.getWriter();
		BaseUser baseUser = BaseUser.findByLoginName(loginName, password);
		if (baseUser != null) //密码验证通过
		{
			User currUser = new UserApp(baseUser);
			currUser.setIp(request.getRemoteAddr());
			currUser.setLoginTime(new Date());
			HttpSession session = request.getSession(true);
			session.removeAttribute("user");
			session.setAttribute("user", currUser);
			out.print("success");
		}
		else
		{
			out.print("false");
		}
	}
}
