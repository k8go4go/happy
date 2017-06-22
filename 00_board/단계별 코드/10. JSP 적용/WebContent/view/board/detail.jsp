<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="kr.co.mlec.board.mapper.BoardMapper"%>
<%@page import="common.db.MyAppSqlConfig"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	SqlSession sqlSession = 
			MyAppSqlConfig.getSqlSessionInstance();;
	BoardMapper mapper = 
			sqlSession.getMapper(BoardMapper.class);
	int no = Integer.parseInt(request.getParameter("no"));
	BoardVO boardVO = mapper.selectBoardByNo(no);
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
		<td><%= no %><td>
	</tr>		
	<tr>		
	  <td>제목<td>
		<td><%= boardVO.getTitle() %><td>
	</tr>		
	<tr>		
	  <td>글쓴이<td>
		<td><%= boardVO.getWriter() %><td>
	</tr>		
	<tr>		
	  <td>내용<td>
		<td><%= boardVO.getContent() %><td>
	</tr>		
	<tr>		
	  <td>등록일<td>
		<td><%= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(boardVO.getRegDate()) %><td>
	</tr>		
	</table>		
	<a href='updateForm.jsp?no=<%= no %>'>수정</a>
	<a href='delete.jsp?no=<%= no %>'>삭제</a>
	<a href='list.jsp'>목록</a>
</body>
</html>