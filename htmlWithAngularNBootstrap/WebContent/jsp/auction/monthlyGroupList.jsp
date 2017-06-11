<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:import url="/jsp/common/header.jsp"></c:import>
<c:import url="/jsp/common/nav.jsp"></c:import>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-8">
		<c:choose>
		<c:when test="${fn:length(list.list) > 0}">
			<table class="table">
			<tbody>
				<tr>
					<td class="text-left">
					<h5>${list.HIGH_PROD_CATE_NM}</h5>
					<h6><kbd>이달의  경매</kbd></h6>
					</td>
					<td colspan="2" class="text-right">
						<c:if test="${list.totalPage != 0}">
						<nav aria-label="Page navigation">
							<ul class="pagination pagination-sm">
								<c:if test="${list.startIndicator eq 1}">
								<li><a 
									  data-href="<c:url value="${pathList['27'].PATH}${pathList['27'].PATH_NM}" />"
									  data-param="HIGH_PROD_CATE_NM=${list.HIGH_PROD_CATE_NM}&PROD_CATE_NUM=${list.GROUP_CATE_NUM}&page=${list.start - 1}&viewCount=30" 
									  aria-label="Previous" ><span
										aria-hidden="true">&laquo;</span>
								</a></li>
								</c:if>
								<c:forEach begin="${list.start}" var="index" end="${list.end}" step="1">
									<c:choose>
									<c:when test="${list.currentPage eq index}" >
										<li class="active"><a class="bg-primary">${index}</a></li>
									</c:when>
									<c:otherwise>
										<li ><a data-href="<c:url value="${pathList['27'].PATH}${pathList['27'].PATH_NM}" />"
												data-param="HIGH_PROD_CATE_NUM=${list.HIGH_PROD_CATE_NM}&PROD_CATE_NUM=${list.GROUP_CATE_NUM}&page=${index}&start=${(index - 1) * list.viewCount + 1}&end=${(index - 1)* list.viewCount + list.viewCount}">${index}</a></li>
									</c:otherwise>
									</c:choose>
								</c:forEach>
								<c:if test="${list.endIndicator eq 1}">
								<li><a data-href="<c:url value="${pathList['27'].PATH}${pathList['27'].PATH_NM}" />" 
									   data-param="HIGH_PROD_CATE_NUM=${list.HIGH_PROD_CATE_NM}&PROD_CATE_NUM=${list.GROUP_CATE_NUM}&page=${list.end + 1}&viewCount=30" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
								</a></li>
								</c:if>
							</ul>
						</nav>
						</c:if>
					</td>
				</tr>
				<c:forEach items="${list.list}"  begin="0" step="1" varStatus="status" var="regAuc" >
					<c:if test="${(status.count - 1)% 3 == 0}">
					<tr>
					</c:if>
						<td class="text-right col-md-4">
							<div class="thumbnail">
								<c:choose>
								<c:when test="${empty regAuc.files}">
									<img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTVjNjlkMGM1ZDIgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNWM2OWQwYzVkMiI+PHJlY3Qgd2lkdGg9IjI0MiIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI4OS44NTAwMDAzODE0Njk3MyIgeT0iMTA1LjciPjI0MngyMDA8L3RleHQ+PC9nPjwvZz48L3N2Zz4=" alt="...">
								</c:when>
								<c:otherwise>
									<img src='<c:url value="/product/image/${regAuc.files[0].ATTAC_FILE_NUM}" />'>
								</c:otherwise>
								</c:choose>
								<div class="caption">
									<h5><kbd>${regAuc.AUC_PROD_NM}</kbd></h5>
									<p>시작일 : <fmt:formatDate value="${regAuc.START_DTIME}" pattern="yyyy-MM-dd"/></p>
									<p>종료일 : <fmt:formatDate value="${regAuc.END_DTIME}" pattern="yyyy-MM-dd"/></p>
									<p>시작가 : ${regAuc.START_PRICE}</p>
									<p>수량 : ${regAuc.QTY}</p>
									<p>
										<a href="${contextPath}${pathList['19'].PATH}${pathList['19'].PATH_NM}?no=${regAuc.AUC_REG_NUM}" class="btn btn-primary" role="button">상세보기</a>
									</p>
								</div>
							</div>
						</td>
					<c:if test="${status.count % 3 == 0}">
					</tr>
					</c:if>
				</c:forEach>
			</tbody>
			</table>
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
	</div>
	<div class="col-md-1"></div>
</div>

<script>
</script>
<c:import url="/jsp/common/footer.jsp"></c:import>
