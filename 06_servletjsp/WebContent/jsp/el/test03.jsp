<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// pageContext : 현재 페이지 에서만 사용
	// 객체 찾을때 찾는 순서
	// pageContext -> request -> session -> application
 	pageContext.setAttribute("msg", "page 공유");
	request.setAttribute("msg", "request 공유");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	msg : ${msg}<br>
	request msg : ${requestScope.msg}<br>
</body>
</html>






