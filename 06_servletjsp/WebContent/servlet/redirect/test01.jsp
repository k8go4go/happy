<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
	Date d = (Date)request.getAttribute("d");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>리다이렉트된 페이지...</h1>
	<%= msg %><br>
	<%= d %>
</body>
</html>













