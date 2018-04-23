<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter,java.util.ResourceBundle"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	ResourceBundle res = ResourceBundle.getBundle("system"); 
    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	
	String rootPath = application.getRealPath("/");
	String myrootPath = res.getString("upload.imagePath");
	out.write( new ActionEnter( request,rootPath, myrootPath).exec() );
	
%>