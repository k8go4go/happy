<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='update' method='post'>
	  <input type='hidden' name='no' value='<c:out value="${board.no}" />'>
	  <table>
	    <tr>
	      <td>제목</td>
	      <td><input type='text' name='title' value='<c:out value="${board.title}" />' /></td>
	    </tr>
	    <tr>
	      <td>글쓴이</td>
	      <td><input type='text' name='writer' readonly value='<c:out value="${board.writer}" />' /></td>
	    </tr>
	    <tr>
	      <td>내용</td>
	      <td><textarea name='content' rows='5' cols='70'><c:out value="${board.content}" /></textarea></td>
	    </tr>
	  </table>
	  <input type='submit' value='수정' />
	</form>
	<a href='list'>목록</a>
</body>
</html>