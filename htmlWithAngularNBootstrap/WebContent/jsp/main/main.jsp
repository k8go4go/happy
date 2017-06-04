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
$( document ).ready(function() {
    var result = '${requestScope.result}';
    var msg = '${requestScope.msg}';
    console.log(result);
    console.log(msg);
    if(result.length > 0) {
    	if(result > 0)
    		swal("처리결과", msg, "success");
    	else
    		swal("처리결과", msg, "error");
    }
});
</script>
<c:import url="/jsp/common/footer.jsp"></c:import>