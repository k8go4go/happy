<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/jsp/common/header.jsp"></c:import>
<c:import url="/jsp/common/nav.jsp"></c:import>

<div class="row">
	<div class="col-md-1"></div>
	<div class="col-md-8">
		<!-- 게시판 반복 부분 -->
		<c:choose>
		<c:when test="${not empty requestScope.list}">
		<div class="panel-group" id="acc">
		<c:forEach items="${requestScope.list}" var="recod" begin="0" step="1">
				<div class="panel panel-default">
					<div class="panel-heading" style="height:35px;">
						<div class="col-sm-1 text-left">
							<kbd>${recod.BOARD_NUM}</kbd>
						</div>
						<div class="col-sm-8 text-center">
							<a data-toggle="collapse" data-parent="#acc" href="#c${recod.BOARD_NUM}">
							${recod.TITLE}
							</a>
						</div>
						<div class="col-sm-3 text-right">
							<span>${recod.WRITER_NM}</span>
							<kbd>${recod.REVIEW_CNT}</kbd>
							<span><fmt:formatDate value="${recod.WRITE_DATE}" pattern="yyyy-mm-dd"/></span>
						</div>
					</div>
					<div id="c${recod.BOARD_NUM}" class="panel-collapse collapse">
						<div class="panel-body bg-success">
							${recod.CONT}
							<c:if test="${not empty recod.replys}">
							<ul class="list-group" >
							<c:forEach items="${recod.replys}" var="replayRec" begin="0" step="1">
						        <li class="list-group-item" style="height:35px;">
							        <div class="col-sm-1 text-left" >
							        	<kbd>${replayRec.BOARD_NUM}</kbd>
							        </div>
							        <div class="col-sm-8 text-center">
							        	${replayRec.TITLE}
									</div>
									<div class="col-sm-3 text-right" >
										<span>${replayRec.WRITER_NM}</span>
										<kbd><fmt:formatDate value="${replayRec.WRITE_DATE}" pattern="yyyy-mm-dd"/></kbd>
									</div>
						        </li>
						        <li class="list-group-item bg-primary" style="height:35px;">${replayRec.CONT}</li>
						    </c:forEach>
						    </ul>
						    </c:if>
						</div>
					</div>
				</div>
		</c:forEach>
		</div>
		</c:when>
		<c:otherwise>
		<div class="panel-group" id="acc">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						데이터가 없습니다.
					</h4>
				</div>				
			</div>
		</div>
		</c:otherwise>
		</c:choose>
		
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
<c:import url="/jsp/common/footer.jsp"></c:import>