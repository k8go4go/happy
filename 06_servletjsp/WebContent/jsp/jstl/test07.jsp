<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	SimpleDateFormat sdf = new SimpleDateFormat(
	    "yyyy-MM-dd"
	);	
	// 날짜 -> 문자
	String sDate = sdf.format(new Date());
	
	// 문자 -> 날짜
	Date d = sdf.parse("2017-03-22");
	 --%>
	<fmt:parseDate var="d" value="2017-03-22" 
	               pattern="yyyy-MM-dd"/>
	년도 : <c:out value="${d.year + 1900}" />
	<br>
	날짜 객체에서 문자열 추출
	<br>
	<fmt:formatDate value="${d}" pattern="yyyy-MM-dd"/>                
</body>
</html>













