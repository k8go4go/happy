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
	BoardVO board = mapper.selectBoardByNo(no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='update.jsp' method='post'>
	  <input type='hidden' name='no' value='<%= no %>'>
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
	<a href='list.jsp'>목록</a>
</body>
</html>