<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>메인 페이지</h1>
	<%--
		만약 로그인 되어 있는 상태라면 
		로그아웃 링크가 보이도록 한다.
		로그인이 되어 있지 않다면 로그인 링크가 보인다.
	 --%>
	 <c:choose>
	 	<c:when test="${empty user}">
		  <h2><a href="LoginForm">로그인</a></h2>
		</c:when> 			
		<c:otherwise>
		  <h2><a href="Logout">로그아웃</a></h2>			
		</c:otherwise>
	 </c:choose>
</body>
</html>


















