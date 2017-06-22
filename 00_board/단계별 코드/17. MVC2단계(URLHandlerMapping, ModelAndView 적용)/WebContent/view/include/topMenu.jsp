<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
	<c:choose>
	 	<c:when test="${empty user}">
			<li><a href="${pageContext.request.contextPath}/login/LoginForm.do">로그인</a></li>
		</c:when> 			
		<c:otherwise>
			<li><a href="${pageContext.request.contextPath}/login/Logout.do">로그아웃</a></li>
		</c:otherwise>
	 </c:choose>
	<li><a href="${pageContext.request.contextPath}/board/list.do">이야기</a></li>
</ul>