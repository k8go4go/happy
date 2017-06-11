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
					<c:if test="${list.value.totalPage != 0}">
					<nav aria-label="Page navigation">
						<ul id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_ul" class="pagination pagination-sm">
							<c:if test="${list.value.startIndicator eq 1}">
							<li><a id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_sindi" 
								  data-href="<c:url value="${pathList['27'].PATH}${pathList['27'].PATH_NM}" />"
								  data-param="POS=t_${list.value.list[0].HIGH_PROD_CATE_NUM}&PROD_CATE_NUM=${list.value.GROUP_CATE_NUM}&page=${list.value.start - 1}&viewCount=3" 
								  aria-label="Previous" ><span
									aria-hidden="true">&laquo;</span>
							</a></li>
							</c:if>
							<c:forEach begin="${list.value.start}" var="index" end="${list.value.end}" step="1">
								<c:choose>
								<c:when test="${list.value.currentPage eq index}" >
									<li class="active"><a id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_a${index}" class="bg-primary">${index}</a></li>
								</c:when>
								<c:otherwise>
									<li ><a id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_a${index}"  data-href="<c:url value="${pathList['27'].PATH}${pathList['27'].PATH_NM}" />"
											data-param="POS=t_${list.value.list[0].HIGH_PROD_CATE_NUM}&PROD_CATE_NUM=${list.value.GROUP_CATE_NUM}&page=${index}&start=${(index - 1) * list.value.viewCount + 1}&end=${(index - 1)* list.value.viewCount + list.value.viewCount}">${index}</a></li>
								</c:otherwise>
								</c:choose>
							</c:forEach>
							<c:if test="${list.value.endIndicator eq 1}">
							<li><a id="t_${list.value.list[0].HIGH_PROD_CATE_NUM}_eindi" data-href="<c:url value="${pathList['27'].PATH}${pathList['27'].PATH_NM}" />" 
								   data-param="POS=t_${list.value.list[0].HIGH_PROD_CATE_NUM}&PROD_CATE_NUM=${list.value.GROUP_CATE_NUM}&page=${list.value.end + 1}&viewCount=3" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
							</c:if>
						</ul>
					</nav>
					</c:if>
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
<script>
$('a').on('click', function(e) {
	var href = this.dataset.href;
	var param = this.dataset.param;
	if(href == '')
		return;
	
	$.ajax(
		{
			type: 'get',
			url: href,
			data: param,
			success : function(result) {
				var t_id = result.TABLE_TR_ID;
				var gNum = result.GROUP_CATE_NUM; 
				var start = parseInt(result.start); 
				var end = parseInt(result.end);
				var currentPage = parseInt(result.currentPage);
				var startIndicator = parseInt(result.startIndicator);
				var endIndicator = parseInt(result.endIndicator);
				var total = parseInt(result.total);
				var viewCount = parseInt(result.viewCount);
				var totalPage = parseInt(result.totalPage);
				var contenxtPath = '${contextPath}';
				var href = '${pathList['27'].PATH}${pathList['27'].PATH_NM}';
				var detailPage = '${contextPath}' + '${pathList['19'].PATH}' + '${pathList['19'].PATH_NM}' + '?no=' + '${regAuc.AUC_REG_NUM}';
				
				$('#' + t_id + '_ul').children().remove();
				
				if(startIndicator != 0) {
					var param = 'POS=' + t_id + '&PROD_CATE_NUM= ' + gNum + '&page=' + (start - 1) + '&viewCount=3';
					if($('#' + t_id + '_sindi').length == 0) {
						$('#' + t_id + '_ul').prepend($("<li><a data-href='"+href+"' data-param='"+param+"' id='"+ "#" + t_id + "_sindi' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>"));
					}
				} else {
					var startIndi = $('#' + t_id + '_sindi');
					if(startIndi.length != 0) {
						$('#' + t_id + '_ul li:first-child').remove();
					}
				}
				
				for(var i=start; i <= end ; i++) {
					if(i == currentPage) {
						$('#' + t_id + '_ul').append($("<li class='active'><a id='"+ t_id + "_a" + i + "'>"+i+"</a></li>"));
					} else {
						var param = "POS=" + t_id + "&PROD_CATE_NUM=" + gNum + "&page=" + i + "&start=" + ((i - 1) * viewCount + 1) + "&end=" + ((i - 1) * viewCount + viewCount);
						$('#' + t_id + '_ul').append($("<li><a id='"+ t_id + "_a" + i + "' data-href='"+href+"' data-param='" +param+"' >"+i+"</a></li>"));
					}
				}
				
				if(endIndicator != 0 ) {
					var param = 'POS=' + t_id + '&PROD_CATE_NUM= ' + gNum + '&page=' + (end + 1) + '&viewCount=3';
					if($('#' + t_id + '_eindi').length == 0) {
						$('#' + t_id + '_ul').append($("<li><a data-href='"+href+"' data-param='"+param+"' id='"+ "#" + t_id + "_eindi' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>"));
					}
				} else {
					var endIndi = $('#' + t_id + '_eindi');
					if(endIndi.length != 0) {
						$('#' + t_id + '_ul li:last-child').remove();
					}
				}
				
				for(var i=0 ; i < result.list.length ; i++) {
					var i1 = $('#' + t_id + '_i' + (i+1));
					var k1 = $('#' + t_id + '_k' + (i+1));
					var p1 = $('#' + t_id + '_p1_' + (i+1));
					var p2 = $('#' + t_id + '_p2_' + (i+1));
					var p3 = $('#' + t_id + '_p3_' + (i+1));
					var p4 = $('#' + t_id + '_p4_' + (i+1));
					
					if(result.list[i].files.length != 0 && contenxtPath != '')
						i1.attr('src', "/" + contenxtPath + '/product/image/' + result.list[i].files[0].ATTAC_FILE_NUM);
					
					k1.text(result.list[i].AUC_PROD_NM);
					p1.text("시작일 : " + result.list[i].START_DTIME);
					p2.text("종료일 : " + result.list[i].END_DTIME);
					p3.text("시작가: " + result.list[i].START_PRICE);
					p4.text("수량 : " + result.list[i].QTY);
				}
			}
		}
	);
});	
</script>

