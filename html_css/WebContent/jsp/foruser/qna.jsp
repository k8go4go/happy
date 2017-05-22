<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="user" value="${sessionScope.user}"/>

<c:set var="myPath" value="${pageContext.request.contextPath}" />
<c:set var="boardList" value="${requestScope.list}" />
<c:set var="viewCount" value="${viewCount}" />


<c:import url="/jsp/common/header.jsp" />
<c:import url="/jsp/common/gnb.jsp" />
<c:import url="/jsp/common/lnb.jsp" />

<style type="text/css">
#left, #center, #right {
	display: inline-block;
	zoom: 1;
	padding: 5px;
	vertical-align: middle;
}

#left {
	width: 0px;
}

#center {
	width: 696px;
}

#right {
	width: 0px;
}

td {
	font-size: 12px;
	padding: 5px;
	margin:5px 5px;	
} 

tr:NTH-CHILD(odd) {
	font-size: 12px;
	padding: 0px;
	margin:0px;
	border-radius: 5px;
	border-left: 10px solid #1c64d1;
	border-right: 10px solid #5ba3e0;
/* 	background-color: #2586d7; */
} 

tr:NTH-CHILD(even) {
	font-size: 12px;
	padding: 0px;
	margin:0px;
	border-radius: 5px;
	border-left: 10px solid #ffffff;
	border-right: 10px solid #ffffff;
/* 	background-color: #2586d7; */
} 

img {
    border: 1px solid #ddd;
    border-radius: 2px;
    padding: 2px;
}

img:hover {
    box-shadow: 0 0 1px 1px rgba(0, 140, 186, 0.5);
}

</style>
<script type="text/javascript">
function view(index) {
	var ind = index % 10;
	var els = document.getElementsByClassName("answer");
	for(var i=0; i < els.length ; i++) {
		if(i == ind - 1)
			els[i].style = 'display:;';
		else
			els[i].style = 'display:none';
	}	
}	

function changeViewCount() {
	var vc = document.getElementById('id_viewCount');
	window.location = ("${myPath}/service/foruser/qna.do?viewCount=" + vc.value);
}

function initViewCount() {
	var vc = document.getElementById('id_viewCount').options;
	var fromServer = ${viewCount};
	for(var i=0; i < vc.length; i++)
    {
		if(vc[i].value == fromServer) {
			vc[i].selected = true;
			return;
		}
    }
}

</script>
<div id="contentwrap">
	<div id="content">
		<div id="left" class="over_container"></div>
		<div id="center" class="over_container" align="center">
			<h1 style="font-size: 16px;">Q.N.A</h1>
			<hr style="display:inline-block;width:600px;">
			<span>보기</span>
			<select id="id_viewCount" onchange="changeViewCount();">
					<option value="10">10개</option>
					<option value="20">20개</option>
					<option value="30">30개</option>
			</select>
		</div>
		<div id="right" class="over_container">
		</div>
	</div>
	<div id="content">
		<div id="left" class="over_container"></div>

		<div id="center" class="over_container">
			<table id="table_board" class="list">
				<colgroup>
					<!-- 번호 , 사진, 제목, 작성자, 조회수, 작성일 -->
					<col width="30px">
					<col width="52px">
					<col width="462px">
					<col width="55px">
					<col width="55px">
					<col width="60px">
				</colgroup>
				<thead><tr>
					<th>NO</th>
					<th>사진</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr></thead>
				<tbody>
					<c:choose>
					<c:when test="${not empty boardList}" >
					<c:forEach var="board" items="${boardList}" >
						<tr onmouseover="view(${board.BOARD_NUM});">
							<td><c:out value="${board.BOARD_NUM}"/></td>
							<td>
								<img style="width:20px;vertical-align: middle;" src="${myPath}/${board.attacFileVO.REAL_PATH}/${board.attacFileVO.REAL_NM}" />
							</td>
							<td>
							<c:forEach var="i" begin="1" end="${board.INDENT}" step="1" >
								<img style="vertical-align: middle;" src="${myPath}/resource/img/common/indent.jpg">
							</c:forEach>
							<c:out value="${board.TITLE}"/>
							</td>
							<td><c:out value="${board.MEMB_NUM}"/></td>
							<td><c:out value="${board.REVIEW_CNT}"/></td>
							<td><fmt:formatDate value="${board.WRITE_DATE}" pattern="yyyy-MM-dd"/></td>
						</tr>
						<tr style="display:none" class="answer">
							<td colspan="6" style="font-size:14px; letter-spacing: 3px;">	
								<div align="right">
									<a href="${myPath}/jsp/foruser/write.qna_write.jsp">
									<img  alt="삭제하기" src="${myPath}/resource/img/common/delete.jpg"/></a>
									<a href="${myPath}/jsp/foruser/write.qna_write.jsp"> 
									<img alt="댓글달기" src="${myPath}/resource/img/common/reply.jpg"/></a>
									<a href="${myPath}/jsp/foruser/write.qna_write.jsp"> 
									<img alt="수정하기" src="${myPath}/resource/img/common/modify.jpg"/></a>
								</div> 
								<span style="margin:20px;">${board.CONT}</span>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5" align="center">
							<c:if test="${startIndicator eq 1 }">
								<span style="color: yellow"><a href="${myPath}/service/foruser/qna.do?page=${start-1}&viewCount=${viewCount}">◁ </a></span>
							</c:if>
							<c:forEach var="i" begin="${start}" end="${end}" step="1">
							<c:choose>
								<c:when test="${currentPage eq i}" >
									<span style="color: red">${i}</span>
								</c:when>
								<c:otherwise>
									<span style="color: yellow"><a href="${myPath}/service/foruser/qna.do?page=${i}&viewCount=${viewCount}">${i}</a></span>
								</c:otherwise>
							</c:choose>
							</c:forEach>
							<c:if test="${endIndicator eq 1 }">
								<span style="color: yellow"><a href="${myPath}/service/foruser/qna.do?page=${end+1}&viewCount=${viewCount}">▶</a></span>
							</c:if>
						</td>
						<td align="right">
							<span><a href="${myPath}/jsp/foruser/write.qna_write.jsp">
							<img src="${myPath}/resource/img/common/add.jpg"/>
							</a></span>
						</td>
					</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="6" align="center">작성된 글목록이 없습니다.</td>
						</tr>
					</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<div id="right" class="over_container"></div>
	</div>
</div>
<script type="text/javascript">
	window.onload = initViewCount();
</script>
<c:import url="/jsp/common/footer.jsp" />