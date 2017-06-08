<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/jsp/common/header.jsp"></c:import>
<c:import url="/jsp/common/nav.jsp"></c:import>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-8">
		<h4 class="glyphicon glyphicon-thumbs-up" id="joinFormModalLabel">경매정보보기</h4>
		<form id="regAucModifyForm" name="regAucModifyForm" method="post"
			action="${contextPath}${pathList['18'].PATH}${pathList['18'].PATH_NM}"
			enctype="multipart/form-data">
			<c:if test="${not empty fileListVO }">
			<table class="table">
				<tbody>
					<tr>
						<td class="text-right col-sm-2"><h6>메인사진</h6></td>
						<td class="text-left col-sm-10">
							<input style="display:inline;" class="input-sm" type="file"
							id="M_UPLOAD" name="M_UPLOAD" onchange="readURL(this, 'mainUpdatePreview');"
							required/>
						</td>
					</tr>
					<tr>
						<td class="text-right col-sm-2"><h6>썸네일사진</h6></td>
						<td class="text-left col-sm-10">
							<input style="display:inline;" class="input-sm" type="file"
							id="T_UPLOAD" name="T_UPLOAD" onchange="readURL(this, 'secUpdatePreview');" 
							required/>
						</td>
					</tr>
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
			
			<input type="hidden" name="ATTAC_FILE_NUM1" value="${fileListVO[0].ATTAC_FILE_NUM}" />
			<input type="hidden" name="ATTAC_FILE_NUM2" value="${fileListVO[1].ATTAC_FILE_NUM}" />
			<input type="hidden" name="PROD_CATE_NUM" value="${aucVO.PROD_CATE_NUM}" />
			<input type="hidden" name="AUC_TYPE_NUM" value="${aucVO.AUC_TYPE_NUM}" />
			<input type="hidden" name="AUC_REG_NUM" value="${aucVO.AUC_REG_NUM}" />
			
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
						<td class="text-center col-sm-6">
	                      	<div class="input-group date form_datetime1 col-md-10" data-date="2017-06-05T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
			                    <input class="input-sm col-sm-6" size="16" type="text" id="START_DTIME" name="START_DTIME" 
			                    value='<fmt:formatDate value="${aucVO.START_DTIME}" pattern="yyyy-MM-dd hh:mm"/>' 
			                    />
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
			                </div>
						</td>	
					</tr>
					<tr>
						<td class="text-right"><h6>종료시간</h6></td>
						<td class="text-center">
						<div class="input-group date form_datetime2 col-md-10" data-date="2017-06-05T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
			                    <input class="input-sm col-sm-6" size="16" type="text" id="END_DTIME" name="END_DTIME" 
			                    value="<fmt:formatDate value="${aucVO.END_DTIME}" pattern="yyyy-MM-dd hh:mm"/>" 
			                    />
			                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
								<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
			                </div>
						</td>
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
				<tfoot>
					<tr>
						<td colspan="2" class="text-center col-sm-8">
							<button id="biddingBtn" type="button" class="btn btn-primary">입찰하기</button>
							<button id="backBtn" type="button" class="btn btn-info">돌아가기</button>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<div class="col-md-1"></div>
</div>

<script>
	$('#backBtn').on('click', function(e) {
		history.back(-1);
	});
</script>
<c:import url="/jsp/common/footer.jsp"></c:import>

