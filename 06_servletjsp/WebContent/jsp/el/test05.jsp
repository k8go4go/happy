<%@page import="board.BoardVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	BoardVO board = new BoardVO();
	board.setNo(100);
	board.setTitle("el 접근");
	
	pageContext.setAttribute("board", board);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	board : ${board}<br>
	<%--
		board가 Map 이 아닌 일반 클래스일 경우
		get 메서드를 호출하는데 "."뒤에 이름에 해당하는 
		get 메서들를 호출
		board.getNo();
		board.getContent();
	 --%>
	no : ${board.no}<br>
	title : ${board.title}<br>
	title : ${board["title"]}<br>
	
<%-- 	content : ${board.content}<br> --%>


</body>
</html>














