<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="type" value="S" />
	<c:set var="type" value="U" />
	<c:set var="type" value="T" />
	<%--
		화면에 type의 값에 따라 다음과 같이 출력
		
		S 라면 "관리자 계정입니다"
		U 라면 "일반 사용자 계정입니다"
		S 또는 U가 아니라면 "잘못된 접근입니다"
	 --%>	
	<c:if test="${type == 'S'}">
		<h1>관리자 계정입니다</h1>
	</c:if>
	<c:if test="${type == 'U'}">
		<h1>일반 사용자 계정입니다</h1>
	</c:if>
	<c:if test="${type != 'S' and type != 'U'}">
		<h1>잘못된 접근입니다</h1>
	</c:if>
</body>
</html>











