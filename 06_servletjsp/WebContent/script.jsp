<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	var msg = [
		<c:forEach var="i" begin="1" end="10" varStatus="loop">
			<c:if test="${not loop.first}">, </c:if>
			<c:out value="${i}" />
		</c:forEach>
	];
	alert(msg[0]);
</script>
</body>
</html>