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
  <table>
    <tr>
	 <th>번호</th>
	 <th>제목</th>
	 <th>글쓴이</th>
	 <th>등록일자</th>
 	</tr>
	<c:forEach var="board" items="${list}">
	<tr>
		<td><c:out value="${board.no}" /></td>
		<td>
			<a href='detail?no=<c:out value="${board.no}" />'>
				<c:out value="${board.title}" />
			</a>
		</td>
		<td><c:out value="${board.writer}" /></td>
		<td>
			<fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd" />
		</td>
	</tr>
	</c:forEach>
	<c:if test="${empty list}">
	<tr>
	  <td colspan='4'>게시물이 존재하지 않습니다.</td>
	</tr>
	</c:if>
	</table>		
	<a href='writeForm'>글쓰기</a>
</body>
</html>












