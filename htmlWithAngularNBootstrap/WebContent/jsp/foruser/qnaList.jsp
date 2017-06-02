<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/jsp/common/header.jsp"></c:import>
<c:import url="/jsp/common/nav.jsp"></c:import>


<c:import url="/jsp/foruser/writeModal.jsp"></c:import>
<c:import url="/jsp/foruser/explainModal.jsp"></c:import>
<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-8">
	  <h2>질문과 답변</h2>
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
	        <c:if test="${not empty recod.attacFileVO}">
	        <h5 class="modal-title glyphicon glyphicon-download-alt text-right"></h5>
	        </c:if>
	        <a href="javascript:showModal('${recod.TITLE}', '${recod.BOARD_NUM}', '${recod.CATE_NM}', '${recod.WRITER_NM}', '<fmt:formatDate value="${recod.WRITE_DATE}" pattern="yyyy-mm-dd"/>', '${recod.CONT}', '${recod.REVIEW_CNT}');">
	        ${recod.shortTITLE}</a></td>
	        <td class="text-center"><small>${recod.WRITER_NM}</small></td>
	        <td class="text-center"><small><fmt:formatDate value="${recod.WRITE_DATE}" pattern="yyyy-mm-dd"/></small></td>
	        <td class="text-center"><small>${recod.CATE_NM}</small></td>
	      </tr>
		      <c:if test="${not empty recod.replys}">
				<c:forEach items="${recod.replys}" var="replayRec" begin="0" step="1">
				<tr>
					<td class="text-center"></td>
			        <td class="text-center">
			        <c:if test="${not empty replayRec.attacFileVO}">
			        <h5 class="modal-title glyphicon glyphicon-download-alt text-right"></h5>
			        </c:if>
			        <a href="javascript:showModal('${replayRec.TITLE}', '${replayRec.BOARD_NUM}', '${replayRec.CATE_NM}', '${replayRec.WRITER_NM}', '<fmt:formatDate value="${replayRec.WRITE_DATE}" pattern="yyyy-mm-dd"/>', '${replayRec.CONT}', '${replayRec.REVIEW_CNT}');">
			        ${replayRec.shortTITLE}</a></td>
			        <td class="text-center"><small>${replayRec.WRITER_NM}</small></td>
			        <td class="text-center"><small><fmt:formatDate value="${replayRec.WRITE_DATE}" pattern="yyyy-mm-dd"/></small></td>
		        	<td class="text-center"><kbd><small><kbd>답변</kbd></small></kbd></td>
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
	   <table class="table">
	    <tbody>
	      <tr>
	        <td colspan="4" class="col-md-7 text-center">
		        <c:if test="${requestScope.totalPage != 0}">
			        <nav aria-label="Page navigation">
						<ul class="pagination">
							<c:if test="${requestScope.startIndicator eq 1}">
							<li><a href="<c:url value="${pathList['2'].PATH}${pathList['2'].PATH_NM}" />?page=${start-1}&viewCount=10" 
								aria-label="Previous"> <span
									aria-hidden="true">&laquo;</span>
							</a></li>
							</c:if>
							<c:forEach begin="${requestScope.start}" var="index" end="${requestScope.end}" step="1">
							<c:choose>
							<c:when test="${currentPage eq index}" >
								<li><a class="bg-primary">${index}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="<c:url value="${pathList['2'].PATH}${pathList['2'].PATH_NM}" />?page=${index}&start=${(index - 1)*viewCount + 1}&end=${(index - 1)*viewCount + viewCount}">${index}</a></li>
							</c:otherwise>
							</c:choose>
							</c:forEach>
							<c:if test="${requestScope.endIndicator eq 1}">
							<li><a href="<c:url value="${pathList['2'].PATH}${pathList['2'].PATH_NM}" />?page=${end+1}&viewCount=10" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
							</c:if>
						</ul>
					</nav>
				</c:if>
	        </td>
	        <td class="col-md-1 text-center">
	        	<button id="btnWrite" type="button" class="btn btn-secondary" onclick="writeQna();" >글쓰기</button>
	        </td>
	      </tr>
	    </tbody>
	   </table>
	</div>
	<div class="col-md-1"></div>
</div>

<script>
	$( document ).ready(function() {
	    var result = '${requestScope.result}';
	    var msg = '${requestScope.msg}';
	    console.log(result);
	    console.log(msg);
	    if(result.length > 0) {
	    	if(result > 0)
	    		swal("처리결과", msg, "success");
	    	else
	    		swal("처리결과", msg, "error");
	    }
	});
	
	var writeQna = function () {
		$('#writeFormModal').modal('show');
	}
	
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
		$('#TITLE').attr('readonly',false);
		$('#WRITER_NM').attr('readonly',false);
		$('#CONT').attr('readonly',false);
		
		$('#btnModify').hide();
		$('#btnClose').hide();
		$('#btnDelete').hide();
		
		$('#btnComplete').show();
		$('#btnCancel').show();
	}

	var cancelModify = function () {
		$('#TITLE').attr('readonly',true);
		$('#WRITER_NM').attr('readonly',true);
		$('#CONT').attr('readonly',true);
		
		$('#btnModify').show();
		$('#btnClose').show();
		$('#btnDelete').show();
		
		$('#btnComplete').hide();
		$('#btnCancel').hide();
	}
	
	var completeWrite = function () {
		// 테스트용 
		$('#writeWMEMB_NUM').val('87');
		writeFormModal
		var frm = document.boardWriteModalForm;
		frm.action = '${contextPath}${pathList['5'].PATH}${pathList['5'].PATH_NM}';
		frm.submit();
	}
	
	var completeModify = function () {
		cancelModify();
		var frm = document.boardModalForm;
		frm.action = '${contextPath}${pathList['3'].PATH}${pathList['3'].PATH_NM}';
		frm.submit();
	}
	
	var deleteBoard = function () {
		cancelModify();
		var frm = document.boardModalForm;
		frm.action = '${contextPath}${pathList['4'].PATH}${pathList['4'].PATH_NM}';
		frm.submit();
	}
</script>

<c:import url="/jsp/common/footer.jsp"></c:import>