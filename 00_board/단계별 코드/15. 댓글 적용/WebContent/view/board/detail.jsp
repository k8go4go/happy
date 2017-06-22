<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<a href='updateForm?no=<c:out value="${board.no}" />'>수정</a>
		<a href='delete?no=<c:out value="${board.no}" />'>삭제</a>
		<a href='list'>목록</a>
		
		
		<div id="comment">
			<form method="post" action="commentRegist">
				<input type="hidden" name="no" value="${board.no}" />	
				<table width="70%">
				<tr>
					<td><input type="text" name="userId" value="${user.id}" /></td>
					<td><textarea name="content" rows="2" cols="60"></textarea></td>
					<td><input type="submit" value="등록" /></td>
				</tr>	
				</table>
			</form>
		</div>
		
		<form action="commentUpdate" method="post">
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
					  	  <a href="commentDelete?commentNo=${comment.commentNo}&no=${comment.no}">삭제</a>	
					  	  <a href="detail?commentNo=${comment.commentNo}&no=${comment.no}">수정</a>	
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
		
	</div>	
	<div>
		<c:import url="/view/include/footer.jsp" />
	</div>	
</div>
</body>
</html>