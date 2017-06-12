<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="modal fade" id="regbiddingListModal" tabindex="-1" role="dialog" aria-labelledby="regbiddingListModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-danger">
				<h4 class="modal-title glyphicon glyphicon-thumbs-up"
					id="regbiddingListModalLabel">입찰자 입장 내역</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
			<div class="table-responsive">				
				<form id="regBidForm" name="regBidForm" class="tab-pane" role="tabpane3">
					<c:choose>
					<c:when test="${not empty aucVO.biddingRegList }">
					<table class="table" id='regBidTable' >
						<thead>
							<tr>
								<th class="text-right col-sm-1">번호</th>
								<th class="text-right col-sm-3">입장일자</th>
								<th class="text-right col-sm-3">입잘자이메일</th>
								<th class="text-right col-sm-3">입찰자ID</th>
								<th class="text-right col-sm-2">등급</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${aucVO.biddingRegList}" var="list" >
						<tr>
							<td class="text-right col-sm-1"><h6>${list.BID_NUM}</h6></td>
							<td class="text-right col-sm-3">
							<h6>
							<fmt:formatDate value="${list.REG_DTIME}" pattern="yyyy-MM-dd hh:mm"/>
							</h6></td>
							<td class="text-right col-sm-3"><h6>${list.EMAIL}</h6></td>
							<td class="text-right col-sm-3"><h6><KBD>${list.MEMB_ID}</KBD></h6></td>
							<td class="text-right col-sm-2"><h6>${list.CATE_NM}</h6></td>
						</tr>
						</c:forEach>
						</tbody>
					</table>
					</c:when>
					<c:otherwise>
					<table class="table" id='regBidTable' >
						<tbody>
						<tr>
							<td class="text-right col-sm-12"><h6>입찰자 입장 목록이 없습니다.</h6></td>
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