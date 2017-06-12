<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="modal fade" id="newbiddingModal" tabindex="-1" role="dialog" aria-labelledby="newbiddingModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-danger">
				<h4 class="modal-title glyphicon glyphicon-thumbs-up"
					id="biddingHistoryModalLabel">입찰 내역</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
			<div class="table-responsive">				
				<form id="newbiddingModalForm" name="newbiddingModalForm" class="tab-pane" role="tabpane3">
					<table class="table" id='newbiddingModalTable' >
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
							<tr>
								<td class="text-right col-sm-2"><h6>최종가격</h6></td>
								<td class="text-center col-sm-6">
									<c:choose>
									<c:when test="${fn:length(aucVO.biddingList) > 0}">
									<input type="text"
									class="input-sm col-sm-6" value="<fmt:formatNumber value="${aucVO.biddingList['0'].BID_PRICE}" pattern="###,###,###"/>" 
									readonly="readonly" />
									</c:when>
									<c:otherwise>
									<input type="text"
									class="input-sm col-sm-6" value="입찰된 금액이 없습니다." 
									readonly="readonly" />
									</c:otherwise>
									</c:choose>
									</td>
							</tr>
							<tr>
								<td class="text-right col-sm-2"><h6>가격</h6></td>
								<td class="text-center col-sm-6"><input type="text"
									class="input-sm col-sm-6" id="BID_PRICE" name="BID_PRICE" /></td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="2" class="text-center col-sm-8">
									<button id="reGoBtn" type="button" class="btn btn-primary">입찰등록</button>
									<button id="cancelBtn" type="button" class="btn btn-info">취소</button>
								</td>
							</tr>
						</tfoot>
					</table>
					<input type="hidden" id="MEMB_ID" name="MEMB_ID" value="${sessionScope.user.MEMB_ID}" />
				</form>
			</div>
			</div>
		</div>
	</div>
</div>

<script>
$('#cancelBtn').on('click', function(e) {
	$("#newbiddingModal").modal("hide");
	$('#BID_PRICE').val('');
});

$('#reGoBtn').on('click', function(e) {
	var bid_price = $('#BID_PRICE');
	
	if(!bid_price) {
		swal('입찰오류', '입찰가를 등록해주시기 바랍니다.', 'error');
		return ;
	}
	
	if(bid_price.val() == 0 || bid_price.val() < 0) {
		swal('입찰오류', '입찰가는 0원이하를 등록할수 없습니다.', 'error');
		return;
	}
	
	var datas = new FormData();
	datas.append('BID_PRICE', $('#BID_PRICE').val());
	datas.append('AUC_REG_NUM', $('#AUC_REG_NUM').val());
	console.log(datas.get('BID_PRICE'));
	console.log(datas.get('AUC_REG_NUM'));
	$.ajax(
		{
			url : '${contextPath}${pathList['29'].PATH}${pathList['29'].PATH_NM}',
			data :
				'BID_PRICE=' + $('#BID_PRICE').val() + '&AUC_REG_NUM='+ $('#AUC_REG_NUM').val(), 
			type: 'get',
			success : function (result) {
				console.log(result);
				console.log(result.result);
				console.log(result.msg);
				if(result.result == -1) {
					swal('오류', result.msg, 'error');
				}
			},
			error : function (result) {
				swal('오류', '알수 없는 오류가 발생했습니다.' + result, 'error');
			}
		}
	);
});

</script>