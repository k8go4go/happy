<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="modal fade" id="enterRegbiddingModal" tabindex="-1" role="dialog" aria-labelledby="enterRegbiddingModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-danger">
				<h4 class="modal-title glyphicon glyphicon-thumbs-up"
					id="enterRegbiddingModalLabel">입찰자 입장</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
			<div class="table-responsive">				
				<form id="enterRegBidForm" name="enterRegBidForm" class="tab-pane" role="tabpane3">
					<table class="table" id='enterRegbiddingModalTable' >
						<tbody>
							<tr>
								<td class="text-right col-sm-2"><h6>경매유형</h6></td>
								<td class="text-center col-sm-8"><input type="text" class="input-sm col-sm-6"
									value="${aucVO.AUC_TYPE_NM}" readonly="readonly"/></td>
							</tr>
							<tr>
								<td class="text-right col-sm-2"><h6>상품명</h6></td>
								<td class="text-center col-sm-8"><input type="text"
									class="input-sm col-sm-6" name="AUC_PROD_NM" id="AUC_PROD_NM"
									value="${aucVO.AUC_PROD_NM}"  readonly="readonly"/>
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
			                      	<div class="input-group date form_datetime1 col-md-10" data-date="2017-06-05T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
					                    <input class="input-sm col-sm-6" size="16" type="text" id="START_DTIME" name="START_DTIME" 
					                    value='<fmt:formatDate value="${aucVO.START_DTIME}" pattern="yyyy-MM-dd hh:mm" />' 
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
					                     readonly="readonly" />
					                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
										<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
					                </div>
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
						</tbody>
						<tfoot>
							<tr>
								<td colspan="2" class="text-center col-sm-8">
								<c:if test="${not empty sessionScope.user}">
									<jsp:useBean id="now" class="java.util.Date" />
									<fmt:formatDate var="sDate" value='${aucVO.END_DTIME}' pattern='yyyy-MM-dd hh:mm'/>
									<fmt:formatDate var="eDate" value='${aucVO.START_DTIME}' pattern='yyyy-MM-dd hh:mm'/>
									<fmt:formatDate var="today" value="${now}" pattern="yyyy-MM-dd hh:mm"/>
									
									<c:if test="${sDate > today}">
										<button id="enterReGoBtn" type="button" class="btn btn-primary">입장</button>
									</c:if>
								</c:if>
										<button id="enterCancelBtn" type="button" class="btn btn-info">취소</button>
								</td>
							</tr>
						</tfoot>
					</table>
				</form>
			</div>
			</div>
		</div>
	</div>
</div>
<script>
$('#enterCancelBtn').on('click', function(e) {
	$("#enterRegbiddingModal").modal("hide");
});

$('#enterReGoBtn').on('click', function(e) {
	$.ajax(
		{
			url : '${contextPath}${pathList['31'].PATH}${pathList['31'].PATH_NM}',
			data : 'BID_QTY=' + '${aucVO.QTY}' + '&AUC_REG_NUM='+ $('#AUC_REG_NUM').val(), 
			type: 'get',
			success : function (result) {
				var parseJon = JSON.parse(result);
				if(parseJon.result == 1) {
					swal('입찰자 입장 성공', parseJon.msg, 'success');
					setTimeout(function() {
						location.reload();						
					}, 1000);
					return;
				}
				swal('입찰자 입장 실패', parseJon.msg, 'error');
				return;
			},
			error : function (result) {
				swal('오류', '알수 없는 오류가 발생했습니다.' + result, 'error');
			}
		}
	);
});
</script>