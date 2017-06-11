<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:choose>
<c:when test="${fn:length(mainAuction) > 0}">
	<c:forEach items="${mainAuction}" var="list">	
		<table class="table" id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}">
		<tbody>
			<tr class="tr1">
				<td class="text-left">
				<h5>${list.value.list[0].HIGH_PROD_CATE_NM}</h5>
				<h6><kbd>이달의  경매</kbd></h6>
				</td>
				<td colspan="2" class="text-right">
					<nav aria-label="Page navigation">
						<ul id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_ul" class="pagination pagination-sm">
							<li ><a href="<c:url value="${pathList['28'].PATH}${pathList['28'].PATH_NM}" />">전체보기</a></li>
						</ul>
					</nav>
				</td>
			</tr>
			<tr>
				<c:forEach items="${list.value.list}"  begin="0" step="1" varStatus="status" var="regAuc" >
				<td class="text-right col-md-4">
					<div class="thumbnail">
						<c:choose>
						<c:when test="${empty regAuc.files}">
							<img id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_i${status.count}" src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTVjNjlkMGM1ZDIgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNWM2OWQwYzVkMiI+PHJlY3Qgd2lkdGg9IjI0MiIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI4OS44NTAwMDAzODE0Njk3MyIgeT0iMTA1LjciPjI0MngyMDA8L3RleHQ+PC9nPjwvZz48L3N2Zz4=" alt="...">
						</c:when>
						<c:otherwise>
							<img id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_i${status.count}" src='<c:url value="/product/image/${regAuc.files[0].ATTAC_FILE_NUM}" />'>
						</c:otherwise>
						</c:choose>
						<div class="caption">
							<h5><kbd id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_k${status.count}">${regAuc.AUC_PROD_NM}</kbd></h5>
							<p id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_p1_${status.count}">시작일 : <fmt:formatDate value="${regAuc.START_DTIME}" pattern="yyyy-MM-dd"/></p>
							<p id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_p2_${status.count}">종료일 : <fmt:formatDate value="${regAuc.END_DTIME}" pattern="yyyy-MM-dd"/></p>
							<p id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_p3_${status.count}">시작가 : ${regAuc.START_PRICE}</p>
							<p id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_p4_${status.count}">수량 : ${regAuc.QTY}</p>
							<p>
								<a id="t_${status.count}_${list.value.list[0].HIGH_PROD_CATE_NUM}_a1${status.count}" href="${contextPath}${pathList['19'].PATH}${pathList['19'].PATH_NM}?no=${regAuc.AUC_REG_NUM}" class="btn btn-primary" role="button">상세보기</a>
							</p>
						</div>
					</div>
				</td>
				</c:forEach>
			</tr>
		</tbody>
		</table>
	</c:forEach>
</c:when>
<c:otherwise>
	<table class="table">
		<tbody>
			<tr>
				<td colspan="3" class="text-left">
				<h6><kbd>이달의  경매</kbd></h6>
				</td>
			</tr>
			<tr>
				<td colspan="3" class="text-cetner col">
					<div class="panel panel-danger text-cetner">
					    <div class="panel-body"><h5>이달의 경매 물품이 없습니다.</h5></div>
					</div>
				</td>
			</tr>
		</tbody>
	</table>
</c:otherwise>
</c:choose>
