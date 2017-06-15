<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/jsp/admin/common/adminHeader.jsp"></c:import>
<c:import url="/jsp/admin/common/adminNav.jsp"></c:import>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-8">
		<table class="table" id='myBidTable' >
			<thead>
				<tr>
					<th class="text-center"><small>아이디</small></th>
					<th class="text-center"><small>이메일</small></th>
					<th class="text-center"><small>전화번호</small></th>
					<th class="text-center"><small>핸드폰번호</small></th>
					<th class="text-center"><small>가입일</small></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach begin="0" step="1" items="${list}" var="userVO">
				<tr>
					<td class="text-center col-sm-1"><small>${userVO.MEMB_ID}</small></td>
					<td class="text-center col-sm-3"><small>${userVO.EMAIL}</small></td>
					<td class="text-center col-sm-2"><small>${userVO.TEL_NUM}</small></td>
					<td class="text-center col-sm-2"><small>${userVO.MOBIL_NUM}</small></td>
					<td class="text-center col-sm-1"><small><fmt:formatDate value="${userVO.REG_DTIME}" pattern="yyyy-MM-dd hh:mm"/></small></td>
				</tr>
			</c:forEach>
			</tbody>
			<tfoot>
			</tfoot>
		</table>
	</div>
	<div class="col-md-1"></div>
</div>

<script>
</script>
<c:import url="/jsp/admin/common/adminFooter.jsp"></c:import>