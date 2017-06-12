<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="modal fade" id="biddingHistoryModal" tabindex="-1" role="dialog" aria-labelledby="biddingHistoryModalLabel" aria-hidden="true">
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
				<form id="mySBidForm" name="biddingHistoryForm" class="tab-pane" role="tabpane3">
					<c:choose>
					<c:when test="${not empty aucVO.biddingList }">
					<table class="table" id='biddingHistoryTable' >
						<thead>
							<tr>
								<th class="text-right col-sm-2">번호</th>
								<th class="text-right col-sm-4">가격</th>
								<th class="text-right col-sm-2">입찰일자</th>
								<th class="text-right col-sm-4">입찰자ID</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${aucVO.biddingList}" var="list" >
						<tr>
							<td class="text-right col-sm-2"><h6>${list.BID_PRICE_REG_NUM}</h6></td>
							<td class="text-right col-sm-4"><KBD>
							<fmt:formatNumber value="${list.BID_PRICE}" pattern="###,###,###"/>
							</KBD></td>
							<td class="text-right col-sm-3">
							<h6>
							<fmt:formatDate value="${list.BID_DTIME}" pattern="yyyy-MM-dd hh:mm"/>
							</h6></td>
							<td class="text-right col-sm-3">${list.MEMB_ID}</td>
						</tr>
						</c:forEach>
						</tbody>
					</table>
					</c:when>
					<c:otherwise>
					<table class="table" id='biddingHistoryTable' >
						<tbody>
						<tr>
							<td class="text-right col-sm-12"><h6>입찰내역이 없습니다.</h6></td>
						</tr>
						</tbody>
					</table>
					</c:otherwise>	
					</c:choose>
				</form>
			</div>
			</div>
		</div>
	</div>
</div>