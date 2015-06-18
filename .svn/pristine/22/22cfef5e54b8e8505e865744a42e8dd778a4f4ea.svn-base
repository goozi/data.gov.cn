<%@ page import="java.util.*" %>
<%@ page import="org.light.*" %>
<%@ page import="com.dhccity.base.business.*" %>
<%
	response.setHeader("Pragma","No-cache");
	response.setHeader("Cache-Control","no-cache");
	response.setDateHeader("Expires",0);

	HttpRequest req = HttpRequestFactory.createRequest(request);	
	User user=Server.getCurrUser(request);
	UserParameterApp parameter=(UserParameterApp) user.getParameterObject();	
	String path = Config.Path;
	//System.out.println(path);
%>

