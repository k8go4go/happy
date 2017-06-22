<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="kr.co.mlec.board.mapper.BoardMapper"%>
<%@page import="common.db.MyAppSqlConfig"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	SqlSession sqlSession = 
				MyAppSqlConfig.getSqlSessionInstance();;
	BoardMapper mapper = 
				sqlSession.getMapper(BoardMapper.class);

	BoardVO boardVO = new BoardVO();
	boardVO.setTitle(request.getParameter("title"));
	boardVO.setWriter(request.getParameter("writer"));
	boardVO.setContent(request.getParameter("content"));
	mapper.insertBoard(boardVO);
	sqlSession.commit();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 등록이 완료되었습니다.</h2>
	<a href='list.jsp'>목록</a>
</body>
</html>