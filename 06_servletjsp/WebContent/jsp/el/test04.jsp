<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	Map<String, String> map = new HashMap<>();
	map.put("id", "hong");
	map.put("name", "gil");
	
	pageContext.setAttribute("map", map);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		Map 타입이라면 "." 방식으로 값을 접근
		map.id  -> map.get("id");
	 --%>
	${map}<br>
	id : ${map.id}<br>
	name : ${map.name}<br>
	email : ${map.email}<br>
</body>
</html>




















