<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-3.2.1.js"
  integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
  crossorigin="anonymous"></script>

</head>
<body>
<div>
	<div>
		<c:import url="/view/include/topMenu.jsp" />
	</div>	
	<div>
		<table>		
		<tr>		
		  <td>번호<td>
			<td><c:out value="${board.no}" /><td>
		</tr>		
		<tr>		
		  <td>제목<td>
			<td><c:out value="${board.title}" /><td>
		</tr>		
		<tr>		
		  <td>글쓴이<td>
			<td><c:out value="${board.writer}" /><td>
		</tr>		
		<tr>		
		  <td>내용<td>
			<td><c:out value="${board.content}" /><td>
		</tr>		
		<tr>		
		  <td>등록일<td>
		  <td>
		  	  <fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd HH:mm:ss" />
		  </td>	  
		</tr>		
		<tr>		
		  <td>첨부파일<td>
		  <td>
		  	  <a href="${pageContext.request.contextPath}/download?path=${file.filePath}&sName=${file.systemName}&dName=${file.oriName}">${file.oriName}</a>(${file.fileSize} byte)
		  </td>	  
		</tr>		
		</table>		
		<a href='updateForm.do?no=<c:out value="${board.no}" />'>수정</a>
		<a href='delete.do?no=<c:out value="${board.no}" />'>삭제</a>
		<a href='list.do'>목록</a>
		
		
		<div id="comment">
			<form id="rForm" method="post" action="commentRegist.do">
				<table width="70%">
				<tr>
					<td><input type="text" name="userId" value="${user.id}" /></td>
					<td><textarea name="content" rows="2" cols="60"></textarea></td>
					<td><input type="submit" value="등록" /></td>
				</tr>	
				</table>
			</form>
		</div>
		<div id="commentList"></div>
		
		<%--
		<form action="commentUpdate.do" method="post">
			<input type="hidden" name="no" value="${board.no}" />
			<input type="hidden" name="commentNo" value="${commentNo}" />
		
		<div id="commentList">
		  <table width='80%' border='1'>
		  <tr>
			<c:forEach var="comment" items="${commentList}">
			<c:choose>
		  		<c:when test="${commentNo eq comment.commentNo}">	
					<tr>
					  <td><c:out value="${comment.userId}" /></td>
					  <td>
					  	<textarea name="content" rows="2" cols="60"><c:out value="${comment.content}" /></textarea>
					  </td>
					  <td colspan="2">
					  	  <input type="submit" value="수정" />	
					  </td>
					 </tr>
			 	</c:when>
			 	<c:otherwise>
					<tr>
					  <td><c:out value="${comment.userId}" /></td>
					  <td>
					  		<c:out value="${comment.content}" /></td>
					  <td><fmt:formatDate var="regDate" value="${comment.regDate}" 
					                      pattern="yyyy-MM-dd HH:mm:ss" />
					      <c:out value="${regDate}" />
					  </td>
					  <td>
					  	  <a href="commentDelete.do?commentNo=${comment.commentNo}&no=${comment.no}">삭제</a>	
					  	  <a href="detail.do?commentNo=${comment.commentNo}&no=${comment.no}">수정</a>	
					  </td>
					 </tr>
			 	</c:otherwise>
			 </c:choose>	
			 </c:forEach>
			 <c:if test="${empty commentList}">
			 <tr>
			    <td colspan='4'>댓글이 존재하지 않습니다.</td>
			 </tr>
		 	</c:if>
		 </table>
		</div>
		</form>				
		 --%>
	</div>	
	<div>
		<c:import url="/view/include/footer.jsp" />
	</div>
</div>

<script>
	// ajax를 이용해서 댓글 목록을 조회
	/*
	   1. ajax를 이용해서 서버에 데이터를 요청
	   2. 응답처리된 데이터를 
	      <div id="commentList"></div>
	         엘리먼트에 보이도록 결과 처리 
	 */
	function commentList() {
		$.ajax({
			url: "commentList.do",
			data: {no: "${board.no}"},
			dataType: "json"
		})
		.done(makeCommentList);		
	}
	
	// 댓글 등록, 수정, 삭제, 목록
	// 목록 데이터를 받아서 commentList에 
	// 화면 출력
	function makeCommentList(result) {
		var html = "";
		html += "<table width='80%' border='1'>";

		for (var i = 0; i < result.length; i++) {
			var comment = result[i];
			html += "<tr id='row" + comment.commentNo + "'>";
			html += "<td>" + comment.userId + "</td>";
			html += "<td>" + comment.content + "</td>";
			
			var date = new Date(comment.regDate);
			var time = date.getFullYear() + "-"
			         + (date.getMonth() + 1) + "-"
			         + date.getDate() + " "
			         + date.getHours() + ":"
			         + date.getMinutes() + ":"
			         + date.getSeconds();
			html += "<td>" + time + "</td>";
			html += "<td>";
			html += "  <a href='javascript:commentDelete(" + comment.commentNo + ");'>삭제</a>";	
			html += "  <a href='javascript:commentUpdateForm(" + comment.commentNo + ");'>수정</a>";	
			html += "</td>";
			html += "</tr>";
			
		}
		if (result.length == 0) {
			html += "<tr>";
			html += "  <td colspan='4'>댓글이 존재하지 않습니다.</td>";
			html += "</tr>";
		}
		html += "</table>";
		
		$("#commentList").html(html);
	}         
	      
	function commentDelete(commentNo) {
		$.ajax({
			url: "commentDelete.do",
			data: {
				no: "${board.no}",
				commentNo: commentNo 
			},
			dataType: "json"
		})
		.done(makeCommentList);
	}
	
	// 댓글 등록 처리
	$("#rForm").submit(function () {
		$.ajax({
			url: "commentRegist.do",
			type: "POST", 
			data: {
				no: "${board.no}",
				content: $("#rForm textarea[name='content']").val(),
				userId: $("#rForm input[name='userId']").val()
			}
		})
		.done(function (result) {
			// 입력폼 초기화 작업 
			// 로그인 안한 상태인 경우
			if(!'${user.id}') {
				$("#rForm input[name='userId']").val("");
			}
			$("#rForm textarea[name='content']").val("");
			
			makeCommentList(result);
		});
		return false;
	});
	
	function commentUpdateForm(commentNo) {
		// id가 row로 시작하는 모든 엘리먼트 ...
		$("#commentList tr[id ^= 'row']").show();
		$("#commentList tr[id ^= 'mod']").hide();
		
		var modId = $("#row" + commentNo + " > td:eq(0)").text();
		var modContent = $("#row" + commentNo + " > td:eq(1)").text();

		var html = "";
		html += "<tr id='modRow" + commentNo + "'>";
		html += "  <td>" + modId + "</td>";
		html += "  <td><textarea name='content'>" + modContent + "</textarea></td>";
		html += "  <td colspan='2'>";
		html += "    <a href='javascript:commentUpdate(" + commentNo + ");'>수정</a>";	
		html += "    <a href='javascript:commentCancel(" + commentNo + ");'>취소</a>";	
		html += "  </td>";
		html += "</tr>";
		
		
		// 해당 tr를 화면에서 숨긴다.
		$("#row" + commentNo).after(html);
		$("#row" + commentNo).hide();
	}
	
	function commentCancel(commentNo) {
		$("#row" + commentNo).show();
		$("#modRow" + commentNo).remove();
	}
	
	function commentUpdate(commentNo) {
		$.ajax({
			url: "commentUpdate.do",
			type: "POST",
			data: {
				no: "${board.no}", 
				content: $("#modRow" + commentNo + " textarea[name=content]").val(), 
				commentNo: commentNo
			},
			dataType: "json"
		})
		.done(makeCommentList);
	}
	
	// 페이지가 로딩되면...
	commentList();
</script>	

</body>
</html>













