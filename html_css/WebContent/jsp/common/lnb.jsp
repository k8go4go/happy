<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="lnbPath" value="${pageContext.request.contextPath}" />
    
<div id="leftcolumnwrap">
	<div id="leftcolumn">
		<div id="lnb">
			<ul>
				<c:if test="${not empty sessionScope.user}">
					<li><a href="${lnbPath}/jsp/product/addProduct.jsp">경매등록</a></li>
					<li><a href="${lnbPath}/jsp/product/bidding.jsp">경매입찰</a></li>
					<li><hr></li>
				</c:if>
				<li><a href="${lnbPath}/jsp/foruser/faq.jsp" >F.A.Q</a></li>
				<li><a href="${lnbPath}/service/foruser/qna.do">Q.N.A</a></li>
				<li><a href="${lnbPath}/jsp/foruser/contactUs.jsp">Contact Us</a></li>
			</ul>
		</div>
	</div>
</div>

