<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/jsp/admin/common/adminHeader.jsp"></c:import>
<c:import url="/jsp/admin/common/adminNav.jsp"></c:import>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-8">
		<h4 class="glyphicon glyphicon-thumbs-up" >경매정보보기</h4>
		<c:if test="${not empty fileListVO}">
		<table class="table">
			<tbody>
				<tr>
					<td class="text-right col-sm-2" rowspan="3"><h6>상품사진</h6></td>
					<td class="text-left col-sm-10" rowspan="3"><img
						id="mainUpdatePreview" width='150px;' height='200px;'
						src='<c:url value="/product/image/${fileListVO[0].ATTAC_FILE_NUM}" />'>
						<img id="secUpdatePreview" width='150px;' height='200px;'
						src='<c:url value="/product/image/${fileListVO[1].ATTAC_FILE_NUM}" />'>
					</td>
				</tr>
				<tr></tr>
				<tr></tr>
			</tbody>
		</table>
		</c:if>
		
		<form id="apprCDForm" name="apprCDForm" method="post"
			action="${contextPath}${pathList['23'].PATH}${pathList['23'].PATH_NM}">		
			<c:if test="${aucVO.APPR_CD != '1500' }">
				<div class="text-center col-sm-10">
					<h4>승인처리</h4>
					<h5><kbd>${aucVO.APPR_NM}</kbd></h5>
				</div>
			</c:if>	
			<table class="table" id='productTable'>
				<tbody>
					<tr>
						<td class="text-right col-sm-2"><h6>선 택</h6></td>
						<td class="text-center col-sm-8"><input type="text" class="input-sm col-sm-6"
							value="${aucVO.PROD_CATE_NM}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>경매유형</h6></td>
						<td class="text-center col-sm-8"><input type="text" class="input-sm col-sm-6"
							value="${aucVO.AUC_TYPE_NM}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>상품명</h6></td>
						<td class="text-center col-sm-8"><input type="text"
							class="input-sm col-sm-6" name="AUC_PROD_NM" id="AUC_PROD_NM"
							value="${aucVO.AUC_PROD_NM}" readonly="readonly" />
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>상품설명</h6></td>
						<td class="text-left col-sm-6"><textarea
								class="text-left input-sm col-sm-6" id="SHORT_CONT" name="SHORT_CONT"
								readonly="readonly">${aucVO.SHORT_CONT}</textarea></td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>시작시간</h6></td>
						<td class="text-center col-sm-6">
		                    <input class="input-sm col-sm-6" size="16" type="text" id="START_DTIME" name="START_DTIME" 
		                    value='<fmt:formatDate value="${aucVO.START_DTIME}" />' 
		                    readonly="readonly" />
						</td>	
					</tr>
					<tr>
						<td class="text-right"><h6>종료시간</h6></td>
						<td class="text-center">
		                    <input class="input-sm col-sm-6" size="16" type="text" id="END_DTIME" name="END_DTIME" 
		                    value="<fmt:formatDate value="${aucVO.END_DTIME}" />" readonly="readonly"/>
						</td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>시작가격</h6></td>
						<td class="text-center col-sm-6"><input type="text"
							class="input-sm col-sm-6" id="START_PRICE" name="START_PRICE"
							value="${aucVO.START_PRICE}" readonly="readonly"></td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>수량</h6></td>
						<td class="text-center col-sm-6"><input type="text"
							class="input-sm col-sm-6" id="QTY" name="QTY"
							value="${aucVO.QTY}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>거부사유</h6></td>
						<td class="text-left col-sm-6"><textarea
								class="text-left input-sm col-sm-6" id="REJ_REAS" name="REJ_REAS"
								required>${regRejVO.REG_REJ_REAS}</textarea></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" class="text-center col-sm-8">
							<c:if test="${aucVO.APPR_CD == '1500' }">
								<button id="apprCDChangeBtn" type="button" class="btn btn-primary">승인</button>
								<button id="apprCDCancelBtn" type="button" class="btn btn-primary">거부</button>
							</c:if>
							<button id="backBtn" type="button" class="btn btn-info">돌아가기</button>
						</td>
					</tr>
				</tfoot>
			</table>
			<input type="hidden" class="input-sm col-sm-6" id="AUC_REG_NUM" name="AUC_REG_NUM" value="${aucVO.AUC_REG_NUM}" readonly="readonly" />
		</form>
		<form id="apprRejForm" name="apprRejForm" method="post"
			action="${contextPath}${pathList['24'].PATH}${pathList['24'].PATH_NM}">
			<input type="hidden" class="input-sm col-sm-6" id="AUC_REG_NUM" name="AUC_REG_NUM" value="${aucVO.AUC_REG_NUM}" />		
			<input type="hidden" class="input-sm col-sm-6" id="REJ_REAS" name="REJ_REAS" />		
		</form>
	</div>
	<div class="col-md-1"></div>
</div>

<script>
	$('#backBtn').on('click', function(e) {
		history.back(-1);
	});
	
	$('#apprCDChangeBtn').on('click', function(e) {
		var f = $('#apprCDForm');
		f.submit();
	});
	
	$('#apprCDCancelBtn').on('click', function(e) {
		var reason = $('#REJ_REAS');
		
		if(reason.val() == '') {
			swal('승인거부오류', '거부시 거부사유를 기입하셔야 합니다.','error');
			return false;
		}
		$("input[name='REJ_REAS']").val($('#REJ_REAS').val());
		
		console.log($("input[name='REJ_REAS']").val());
		
		var f = $('#apprRejForm');
		f.submit();
	});
</script>
<c:import url="/jsp/admin/common/adminFooter.jsp"></c:import>