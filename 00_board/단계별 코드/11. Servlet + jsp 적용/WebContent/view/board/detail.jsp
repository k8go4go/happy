<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	BoardVO board = (BoardVO)request.getAttribute("board");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>		
	<tr>		
	  <td>번호<td>
		<td><%= board.getNo() %><td>
	</tr>		
	<tr>		
	  <td>제목<td>
		<td><%= board.getTitle() %><td>
	</tr>		
	<tr>		
	  <td>글쓴이<td>
		<td><%= board.getWriter() %><td>
	</tr>		
	<tr>		
	  <td>내용<td>
		<td><%= board.getContent() %><td>
	</tr>		
	<tr>		
	  <td>등록일<td>
		<td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(board.getRegDate()) %><td>
	</tr>		
	</table>		
	<a href='updateForm?no=<%= board.getNo() %>'>수정</a>
	<a href='delete?no=<%= board.getNo() %>'>삭제</a>
	<a href='list'>목록</a>
</body>
</html>