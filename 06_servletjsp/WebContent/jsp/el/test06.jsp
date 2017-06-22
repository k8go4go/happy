<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
	객체[] : 맵, 자바빈즈, 배열, 리스트
 --%>
<%
	List<String> list = new ArrayList<>();
	list.add("일");	
	list.add("이");	
	list.add("삼");
	
	pageContext.setAttribute("list", list);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${list[0]}<br>
	${list[1]}<br>
	${list[2]}<br>
</body>
</html>

















