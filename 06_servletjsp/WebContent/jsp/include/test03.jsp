<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>one.jsp 페이지 포함하기</h1>
	<hr>
	<c:import url="one.jsp" />
	<hr>
	
	<c:import url="one.jsp">
		<c:param name="msg" value="test" />
	</c:import>
	<hr>	
	
	<c:import url="http://www.bitjobedu.co.kr" />
</body>
</html>





