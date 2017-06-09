<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/jsp/admin/common/adminHeader.jsp"></c:import>
<c:import url="/jsp/admin/common/adminNav.jsp"></c:import>


<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-8">
	<table class="table">
	<tbody>
		<tr>
			<td class="text-left">
			<c:choose>
			<c:when test="${not empty sessionScope.mgr}">
				<kbd>${sessionScope.mgr.EMAIL}@${sessionScope.mgr.MAIL_CD_NM}</kbd>
				<kbd>${sessionScope.mgr.MEMB_CD_NM}</kbd>
				<kbd>${sessionScope.mgr.REG_DTIME}</kbd>
				<h5>${sessionScope.mgr.MGR_NM}님이 로그인하셨습니다.</h5>
			</c:when>
			<c:otherwise>
				<kbd>비로그인</kbd>
				<h5>관리자님 로그인이 필요 합니다</h5>
			</c:otherwise>
			</c:choose>
			</td>
		</tr>
	  </tbody>
	</table>
	<c:if test="${not empty sessionScope.mgr}">
	<div class="table-responsive">
		<div class="panel panel-danger">
		    <div class="panel-body">미승인 목록</div>
		</div>
		<table class="table" id="needApprCDTable">
		<thead>
			<tr>
				<th class="text-center"><small>상품유형</small></th>
				<th class="text-center"><small>경매유형</small></th>
				<th class="text-center"><small>상품명</small></th>
				<th class="text-center"><small>시작시간</small></th>
				<th class="text-center"><small>종료시간</small></th>
				<th class="text-center"><small>시작가</small></th>
				<th class="text-center"><small>승인</small></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach begin="0" step="1" items="${needApprCD}" var="regAuc">
			<tr>
				<td class="text-center col-sm-2"><small>${regAuc.PROD_CATE_NM}</small></td>
				<td class="text-center col-sm-1"><small>${regAuc.AUC_TYPE_NM}</small></td>
				<td class="text-center col-sm-3"><small>${regAuc.AUC_PROD_NM}</small></td>
				<td class="text-center col-sm-2"><small>
				<fmt:formatDate value="${regAuc.START_DTIME}" pattern="yyyy-MM-dd"/>
				</small></td>
				<td class="text-center col-sm-2"><small>
				<fmt:formatDate value="${regAuc.START_DTIME}" pattern="yyyy-MM-dd"/>
				</small></td>
				<td class="text-center col-sm-2"><small>${regAuc.START_PRICE}</small></td>
				<td class="text-center col-sm-1"><button name='doApprCD' type="button" class="btn btn-primary" data-AUC_REG_NUM="${regAuc.AUC_REG_NUM}">승인여부</button></td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		</tfoot>
		</table>
		
		<div class="panel panel-success">
		    <div class="panel-body">승인처리 목록</div>
		</div>
		<table class="table" id='doneApprCDTable'>
		<thead>
			<tr>
				<th class="text-center"><small>상품유형</small></th>
				<th class="text-center"><small>경매유형</small></th>
				<th class="text-center"><small>상품명</small></th>
				<th class="text-center"><small>시작시간</small></th>
				<th class="text-center"><small>종료시간</small></th>
				<th class="text-center"><small>시작가</small></th>
				<th class="text-center"><small>승인</small></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach begin="0" step="1" items="${doneApprCD}" var="regAuc">
			<tr>
				<td class="text-center col-sm-2"><small>${regAuc.PROD_CATE_NM}</small></td>
				<td class="text-center col-sm-1"><small>${regAuc.AUC_TYPE_NM}</small></td>
				<td class="text-center col-sm-3"><small>${regAuc.AUC_PROD_NM}</small></td>
				<td class="text-center col-sm-2"><small>
				<fmt:formatDate value="${regAuc.START_DTIME}" pattern="yyyy-MM-dd"/>
				</small></td>
				<td class="text-center col-sm-2"><small>
				<fmt:formatDate value="${regAuc.START_DTIME}" pattern="yyyy-MM-dd"/>
				</small></td>
				<td class="text-center col-sm-2"><small>${regAuc.START_PRICE}</small></td>
				<td class="text-center col-sm-1"><button name='doApprCD' type="button" class="btn btn-primary" data-AUC_REG_NUM="${regAuc.AUC_REG_NUM}">${regAuc.APPR_NM}</button></td>
			</tr>
		</c:forEach>
		</tbody>
		<tfoot>
		</tfoot>
		</table>
	</div>
	</c:if>
	</div>
	<div class="col-md-1"></div>
	<form id="appcCallForm" method="POST" action="${contextPath}${pathList['22'].PATH}${pathList['22'].PATH_NM}"> 
		<input type="hidden" id="AUC_REG_NUM" name="AUC_REG_NUM" />
	</form>
</div>
<script>
	$("button[name='doApprCD']").on('click', function(e) {
		var auc_reg_num = this.dataset.auc_reg_num;
		$('#AUC_REG_NUM').val(auc_reg_num);
		$('#appcCallForm').submit();
	});
</script>
<c:import url="/jsp/admin/common/adminFooter.jsp"></c:import>