<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/jsp/common/header.jsp"></c:import>
<c:import url="/jsp/common/nav.jsp"></c:import>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-8">
		<h4 class="glyphicon glyphicon-thumbs-up" id="joinFormModalLabel">경매등록</h4>
		<form id="regAuctionForm" name="regAuctionForm" method="post"
			action="${contextPath}${pathList['13'].PATH}${pathList['13'].PATH_NM}"
			enctype="multipart/form-data">
			<c:if test="${not empty fileListVO }">
			<table class="table">
				<tbody>
					<tr>
						<td class="text-right col-sm-2" rowspan="3"><h6>상품사진</h6></td>
						<td class="text-left col-sm-10" rowspan="3"><img
							id="mainPreview" width='150px;' height='200px;'
							src='<c:url value="/product/image/${fileListVO[0].ATTAC_FILE_NUM}" />'>
							<img id="secPreview" width='150px;' height='200px;'
							src='<c:url value="/product/image/${fileListVO[1].ATTAC_FILE_NUM}" />'>
						</td>
					</tr>
					<tr></tr>
					<tr></tr>
				</tbody>
			</table>
			</c:if>

			<table class="table" id='productTable'>
				<tbody>
					<tr>
						<td class="text-right col-sm-2"><h6>선 택</h6></td>
						<td class="text-center col-sm-8"><input type="text" class="input-sm col-sm-6"
							value="${aucVO.PROD_CATE_NM}" /></td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>경매유형</h6></td>
						<td class="text-center col-sm-8"><input type="text" class="input-sm col-sm-6"
							value="${aucVO.AUC_TYPE_NM}" /></td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>상품명</h6></td>
						<td class="text-center col-sm-8"><input type="text"
							class="input-sm col-sm-6" name="AUC_PROD_NM" id="AUC_PROD_NM"
							value="${aucVO.AUC_PROD_NM}" required />
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>상품설명</h6></td>
						<td class="text-left col-sm-6"><textarea
								class="text-left input-sm col-sm-6" id="SHORT_CONT" name="SHORT_CONT"
								required>
					${aucVO.SHORT_CONT}
					</textarea></td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>시작시간</h6></td>
						<td class="text-center col-sm-6"><input
							class="input-sm col-sm-6" size="16" type="text" id="START_DTIME"
							name="START_DTIME" value='<fmt:formatDate value="${aucVO.START_DTIME}" pattern="yyyy-MM-dd hh:mm"/>' readonly>
						</td>
					</tr>
					<tr>
						<td class="text-right"><h6>종료시간</h6></td>
						<td class="text-center"><input class="input-sm col-sm-6"
							size="16" type="text" id="END_DTIME" name="END_DTIME"
							value="<fmt:formatDate value="${aucVO.END_DTIME}" pattern="yyyy-MM-dd hh:mm"/>" readonly></td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>시작가격</h6></td>
						<td class="text-center col-sm-6"><input type="text"
							class="input-sm col-sm-6" id="START_PRICE" name="START_PRICE"
							value="${aucVO.START_PRICE}" required></td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>수량</h6></td>
						<td class="text-center col-sm-6"><input type="text"
							class="input-sm col-sm-6" id="QTY" name="QTY"
							value="${aucVO.QTY}" required /></td>
					</tr>
				</tbody>
			</table>
		</form>

	</div>
	<div class="col-md-1"></div>
</div>

<script>
	
</script>
<c:import url="/jsp/common/footer.jsp"></c:import>

