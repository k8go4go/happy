<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="user" value="${sessionScope.user}"/>
<c:set var="gnbContextPath" value="${pageContext.request.contextPath}"/>

<div id="navigationwrap">
	<div id="navigation">
		<div>
			<nav class="top_nav">
				<ul id="menu-bar">
					<li class="active"><a href="main.html">비트중고경매</a></li>
					<li><a href="progressAuction.html?product_cd=0">진행중인 경매</a>
						<ul>
							<li><a href="${gnbContextPath}/jsp/product/progressAuction.html?product_cd=1">전자제품</a></li>
							<li><a href="${gnbContextPath}/jsp/product/progressAuction.html?product_cd=2">의류</a></li>
							<li><a href="${gnbContextPath}/jsp/product/progressAuction.html?product_cd=3">식품</a></li>
							<li><a href="${gnbContextPath}/jsp/product/progressAuction.html?product_cd=4">기타</a></li>
						</ul></li>
					<li><a href="#">이달의 최고 경매</a>
						<ul>
							<li><a href="${gnbContextPath}/jsp/product/doneAuction.html">전자제품</a></li>
							<li><a href="${gnbContextPath}/jsp/product/doneAuction.html">의류</a></li>
							<li><a href="${gnbContextPath}/jsp/product/doneAuction.html">식품</a></li>
							<li><a href="${gnbContextPath}/jsp/product/doneAuction.html">기타</a></li>
						</ul></li>
					<c:choose>	
					<c:when test="${empty user}">
						<li><a href="${gnbContextPath}/jsp/member/join.jsp">회원가입</a></li>
						<li><a href="${gnbContextPath}/jsp/member/login.jsp">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${gnbContextPath}/jsp/member/memberinfo.jsp">회원정보</a></li>
						<li><a href="${gnbContextPath}/jsp/member/logout.jsp">로그아웃</a></li>
						
						<li><a href="${gnbContextPath}/jsp/member/logout.jsp">My Auction</a></li>
					</c:otherwise>
					</c:choose>
				</ul>
			</nav>
		</div>
	</div>
</div>
