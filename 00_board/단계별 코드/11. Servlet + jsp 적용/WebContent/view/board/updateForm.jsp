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
	<form action='update' method='post'>
	  <input type='hidden' name='no' value='<%= board.getNo() %>'>
	  <table>
	    <tr>
	      <td>제목</td>
	      <td><input type='text' name='title' value='<%= board.getTitle() %>' /></td>
	    </tr>
	    <tr>
	      <td>글쓴이</td>
	      <td><input type='text' name='writer' readonly value='<%= board.getWriter() %>' /></td>
	    </tr>
	    <tr>
	      <td>내용</td>
	      <td><textarea name='content' rows='5' cols='70'><%= board.getContent() %></textarea></td>
	    </tr>
	  </table>
	  <input type='submit' value='수정' />
	</form>
	<a href='list'>목록</a>
</body>
</html>