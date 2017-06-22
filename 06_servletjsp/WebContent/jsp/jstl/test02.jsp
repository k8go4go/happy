<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="msg" value="test" />
	<c:set var="msg" value="<h1>test</h1>" />
	
	el msg : ${msg}<br>
	out msg : <c:out value="${msg}" /><br>
	
	msg2 : <c:out value="${msg2}" default="정보 없음" />
	
</body>
</html>











