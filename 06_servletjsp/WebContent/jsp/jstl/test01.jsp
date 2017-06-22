<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	page 영역에 cnt 변수이름으로 1을 설정한다.<br>
	<%--
		pageContext.setAttribute("cnt", "1");
	 --%>
	<c:set var="cnt" value="1" scope="page" />
	
	page 영역에 설정된 cnt 변수의 값 : ${cnt}<br>

	request 영역에 cnt 변수이름으로 100을 설정한다.<br>
	<c:set var="cnt" value="100" scope="request" />

	request 영역에 설정된 cnt 변수의 값 : ${requestScope.cnt}<br>
	
	page 영역의 cnt 변수의 값을 기존의 값에서 1을 증가시킨다.<br>

	<c:set var="cnt" value="${cnt + 1}" scope="page" />
	page 영역에 설정된 cnt 변수의 값 : ${cnt}<br>

</body>
</html>











