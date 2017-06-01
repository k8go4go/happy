<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/jsp/common/header.jsp"></c:import>
<c:import url="/jsp/common/nav.jsp"></c:import>


<c:import url="/jsp/foruser/explainModal.jsp"></c:import>
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-8">
	  <h2>질문과 답변</h2>
	  <p>The .table-striped class adds zebra-stripes to a table:</p>            
	
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th class="col-md-1 text-center">글번호</th>
	        <th class="col-md-5 text-center">제목</th>
	        <th class="col-md-1 text-center">작성자</th>
	        <th class="col-md-2 text-center">작성일</th>
	        <th class="col-md-1 text-center">상태</th>
	      </tr>
	    </thead>
	    <c:choose>
		<c:when test="${not empty requestScope.list}">
		<tbody>
		<c:forEach items="${requestScope.list}" var="recod" begin="0" step="1">
	      <tr>
	        <td class="text-center"><kbd>${recod.BOARD_NUM}</kbd></td>
	        <td class="text-center">
	        <a href="javascript:showModal('${recod.TITLE}', '${recod.BOARD_NUM}', '${recod.CATE_NM}', '${recod.WRITER_NM}', '<fmt:formatDate value="${recod.WRITE_DATE}" pattern="yyyy-mm-dd"/>', '${recod.CONT}', '${recod.REVIEW_CNT}');">
	        ${recod.TITLE}</a></td>
	        <td class="text-center"><small>${recod.WRITER_NM}</small></td>
	        <td class="text-center"><small><fmt:formatDate value="${recod.WRITE_DATE}" pattern="yyyy-mm-dd"/></small></td>
	        <td class="text-center"><kbd><small>${recod.CATE_NM}</small></kbd></td>
	      </tr>
		      <c:if test="${not empty recod.replys}">
				<c:forEach items="${recod.replys}" var="replayRec" begin="0" step="1">
			<tr>
				<td class="text-center"><kbd>${replayRec.BOARD_NUM}</kbd></td>
		        <td class="text-center">
		        <a href="javascript:showModal('${replayRec.TITLE}', '${replayRec.BOARD_NUM}', '${replayRec.CATE_NM}', '${replayRec.WRITER_NM}', '<fmt:formatDate value="${replayRec.WRITE_DATE}" pattern="yyyy-mm-dd"/>', '${replayRec.CONT}', '${replayRec.REVIEW_CNT}');">
		        ${replayRec.TITLE}</a></td>
		        <td class="text-center"><small>${replayRec.WRITER_NM}</small></td>
		        <td class="text-center"><small><fmt:formatDate value="${replayRec.WRITE_DATE}" pattern="yyyy-mm-dd"/></small></td>
	        	<td class="text-center"><kbd><small>${replayRec.CATE_NM}</small></kbd></td>
		    </tr>
			    </c:forEach>
			    </c:if>
	    </c:forEach>
	    </tbody>
		</c:when>
		<c:otherwise>
		 <tbody>
	      <tr>
	        <td colspan="5">데이터가 없습니다.</td>
	      </tr>
	    </tbody>
		</c:otherwise>
		</c:choose>
	  </table>
		
	<!-- 페이지 버튼 -->
		<c:if test="${requestScope.totalPage != 0}">
		<div class="text-center">
		<nav aria-label="Page navigation">
			<ul class="pagination">
				<c:if test="${requestScope.startIndicator != 0}">
				<li><a href="#" aria-label="Previous"> <span
						aria-hidden="true">&laquo;</span>
				</a></li>
				</c:if>
				<c:forEach begin="${requestScope.start}" var="index" end="${requestScope.end}" step="1">
				<li><a href="#">${index}</a></li>
				</c:forEach>
				<c:if test="${requestScope.endIndicator != 0}">
				<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
				</c:if>
			</ul>
		</nav>
		</div>
		</c:if>
	</div>
	<div class="col-md-1"></div>
</div>

<script>
	var showModal = function (TITLE, BOARD_NUM, CATE_NM, WRITER_NM, WRITE_DATE, CONT, REVIEW_CNT) {
		$('#TITLE').val(TITLE);
		$('#BOARD_NUM').val(BOARD_NUM);
		$('#CATE_NM').val(CATE_NM);
		$('#WRITER_NM').val(WRITER_NM);
		$('#WRITE_DATE').val(WRITE_DATE);
		$('#CONT').val(CONT);
		$('#REVIEW_CNT').html(REVIEW_CNT);
		
		$('#anaFormModal').modal('show');
	}
	
	var changeDisable =  function() {
		$('#TITLE').attr('disabled',false);
		$('#WRITER_NM').attr('disabled',false);
		$('#WRITE_DATE').attr('disabled',false);
		$('#CONT').attr('disabled',false);
		
		$('#btnModify').hide();
		$('#btnClose').hide();
		
		$('#btnComplete').show();
		$('#btnCancel').show();
	}

	var cancelModify = function () {
		$('#TITLE').attr('disabled',true);
		$('#WRITER_NM').attr('disabled',true);
		$('#WRITE_DATE').attr('disabled',true);
		$('#CONT').attr('disabled',true);
		
		$('#btnModify').show();
		$('#btnClose').show();
		
		$('#btnComplete').hide();
		$('#btnCancel').hide();
	}
	
	var completeModify = function () {
		cancelModify();
		var frm = $("#boardModalForm")[0];
		frm.action = '${contextPath}${pathList['3'].PATH}${pathList['3'].PATH_NM}';
		frm.submit();
	}
</script>

<c:import url="/jsp/common/footer.jsp"></c:import>