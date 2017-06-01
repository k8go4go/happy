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
	        <th class="col-md-6 text-center">제목</th>
	        <th class="col-md-1 text-center">작성자</th>
	        <th class="col-md-1 text-center">작성일</th>
	        <th class="col-md-1 text-center">상태</th>
	      </tr>
	    </thead>
	    <c:choose>
		<c:when test="${not empty requestScope.list}">
		<tbody>
		<c:forEach items="${requestScope.list}" var="recod" begin="0" step="1">
	      <tr>
	        <td class="text-center"><kbd>${recod.BOARD_NUM}</kbd></td>
	        <td class="text-center"><a href="javascript:showModal('${recod}');">${recod.TITLE}</a><kbd>${recod.REVIEW_CNT}</kbd></td>
	        <td class="text-center"><span>${recod.WRITER_NM}</span></td>
	        <td class="text-center"><fmt:formatDate value="${recod.WRITE_DATE}" pattern="yyyy-mm-dd"/></td>
	        <td class="text-center"><kbd>${recod.CATE_NM}</kbd></td>
	      </tr>
		      <c:if test="${not empty recod.replys}">
				<c:forEach items="${recod.replys}" var="replayRec" begin="0" step="1">
			<tr>
				<td class="text-center"><kbd>${replayRec.BOARD_NUM}</kbd></td>
		        <td class="text-center"><a href="javascript:showModal('${replayRec}');">${replayRec.TITLE}</a><kbd>${replayRec.REVIEW_CNT}</kbd></td>
		        <td class="text-center"><span>${replayRec.WRITER_NM}</span></td>
		        <td class="text-center"><fmt:formatDate value="${replayRec.WRITE_DATE}" pattern="yyyy-mm-dd"/></td>
	        	<td class="text-center"><kbd>${replayRec.CATE_NM}</kbd></td>
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
		</c:if>
	</div>
	<div class="col-md-1"></div>
</div>

<script>
	function showModal(record) {
		$('#qnaTitle').html(record.TITLE);
		$('#BOARD_NUM').html(record);
		$('#CATE_NM').html(record);
		$('#WRITER_NM').html(record);
		$('#WRITE_DATE').html(record);
		$('#CONT').html(record);
		$('#REVIEW_CNT').html(record);
		
// 		$('#qnaTitle').html('${record.TITLE}');
// 		$('#BOARD_NUM').html('${record.BOARD_NUM}');
// 		$('#CATE_NM').html('${record.CATE_NM}');
// 		$('#WRITER_NM').html('${record.WRITER_NM}');
// 		$('#WRITE_DATE').html('${record.WRITE_DATE}');
// 		$('#CONT').html('${record.CONT}');
// 		$('#REVIEW_CNT').html('${record.REVIEW_CNT}');
		
		$('#anaFormModal').modal('show');
	}
	

</script>

<c:import url="/jsp/common/footer.jsp"></c:import>