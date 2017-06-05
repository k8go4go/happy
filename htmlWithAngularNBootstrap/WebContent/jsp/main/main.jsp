<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:import url="/jsp/common/header.jsp"></c:import>
<c:import url="/jsp/common/nav.jsp"></c:import>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-8">
		<!-- 진행중인 경매 -->
		<c:import url="/jsp/auction/ingAuction.jsp"></c:import>		
		<!-- 이달의 최고 경매 -->
		<c:import url="/jsp/auction/monthlyAuction.jsp"></c:import>		
	</div>
	<div class="col-md-1"></div>
</div>

<script>
</script>
<c:import url="/jsp/common/footer.jsp"></c:import>