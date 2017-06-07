<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/jsp/common/header.jsp"></c:import>
<c:import url="/jsp/common/nav.jsp"></c:import>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-8">
		<table class="table" id='myBidTable' >
			<thead>
				<tr>
					<th class="text-center"><small>상품유형</small></th>
					<th class="text-center"><small>경매유형</small></th>
					<th class="text-center"><small>상품명</small></th>
					<th class="text-center"><small>시작시간</small></th>
					<th class="text-center"><small>종료시간</small></th>
					<th class="text-center"><small>시작가</small></th>
					<th class="text-center"><small>수량</small></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach begin="0" step="1" items="${list}" var="regAuc">
				<tr>
					<td class="text-center col-sm-2"><a href="${contextPath}${pathList['17'].PATH}${pathList['17'].PATH_NM}?no=${regAuc.AUC_REG_NUM}" ><small>${regAuc.PROD_CATE_NM}</small></a></td>
					<td class="text-center col-sm-1"><a href="${contextPath}${pathList['17'].PATH}${pathList['17'].PATH_NM}?no=${regAuc.AUC_REG_NUM}" ><small>${regAuc.AUC_TYPE_NM}</small></a></td>
					<td class="text-center col-sm-3"><a href="${contextPath}${pathList['17'].PATH}${pathList['17'].PATH_NM}?no=${regAuc.AUC_REG_NUM}" ><small>${regAuc.AUC_PROD_NM}</small></a></td>
					<td class="text-center col-sm-2"><a href="${contextPath}${pathList['17'].PATH}${pathList['17'].PATH_NM}?no=${regAuc.AUC_REG_NUM}" ><small>
					<fmt:formatDate value="${regAuc.START_DTIME}" pattern="yyyy-mm-dd"/>
					</small></a></td>
					<td class="text-center col-sm-2"><a href="${contextPath}${pathList['17'].PATH}${pathList['17'].PATH_NM}?no=${regAuc.AUC_REG_NUM}" ><small>
					<fmt:formatDate value="${regAuc.START_DTIME}" pattern="yyyy-mm-dd"/>
					</small></a></td>
					<td class="text-center col-sm-2"><a href="${contextPath}${pathList['17'].PATH}${pathList['17'].PATH_NM}?no=${regAuc.AUC_REG_NUM}" ><small>${regAuc.START_PRICE}</small></a></td>
					<td class="text-center col-sm-1"><a href="${contextPath}${pathList['17'].PATH}${pathList['17'].PATH_NM}?no=${regAuc.AUC_REG_NUM}" ><small>${regAuc.QTY}</small></a></td>
				</tr>
			</c:forEach>
			</tbody>
			<tfoot>
			<tr>
				<td colspan="7" class="text-center">
					<nav aria-label="Page navigation">
						<ul class="pagination pagination-sm">
							<li><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span></a></li>
							<li><a href="#" class="bg-primary">1</a></li>
							<li><a href="#" class="bg-primary">2</a></li>
							<li><a href="#" class="bg-primary">3</a></li>
							<li><a href="#" class="bg-primary">4</a></li>
							<li><a href="#" class="bg-primary">5</a></li>
							<li><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</td>
			</tr>
			</tfoot>
		</table>
	</div>
	<div class="col-md-1"></div>
</div>

<script>
</script>
<c:import url="/jsp/common/footer.jsp"></c:import>