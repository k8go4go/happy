<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
	
<table class="table">
<tbody>
	<tr>
		<td class="text-left">
		<h5>${mainAuction[0].HIGH_PROD_CATE_NM}</h5>
		<h6><kbd>이달의 최고  경매</kbd></h6>
		</td>
		<td colspan="2" class="text-right">
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
	<tr>
		<c:forEach items="${mainAuction}" var="list">
		<td class="text-right col-md-4">
			<div class="thumbnail">
				<c:choose>
				<c:when test="${empty list.files}">
					<img src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTVjNjlkMGM1ZDIgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNWM2OWQwYzVkMiI+PHJlY3Qgd2lkdGg9IjI0MiIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI4OS44NTAwMDAzODE0Njk3MyIgeT0iMTA1LjciPjI0MngyMDA8L3RleHQ+PC9nPjwvZz48L3N2Zz4=" alt="...">
				</c:when>
				<c:otherwise>
					<img src='<c:url value="/product/image/${list.files[0].ATTAC_FILE_NUM}" />'>
				</c:otherwise>
				</c:choose>
				<div class="caption">
					<h5><kbd>${list.AUC_PROD_NM}</kbd></h5>
					<p>시작일 : <fmt:formatDate value="${list.START_DTIME}" pattern="yyyy-MM-dd"/></p>
					<p>종료일 : <fmt:formatDate value="${list.END_DTIME}" pattern="yyyy-MM-dd"/></p>
					<p>시작가 : ${list.START_PRICE}</p>
					<p>수량 : ${list.QTY}</p>
					<p>
						<a href="${contextPath}${pathList['19'].PATH}${pathList['19'].PATH_NM}?no=${regAuc.AUC_REG_NUM}" class="btn btn-primary" role="button">상세보기</a>
					</p>
				</div>
			</div>
		</td>
		</c:forEach>
	</tr>
</tbody>
</table>