<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.mlec.board.mapper.BoardMapper"%>
<%@page import="common.db.MyAppSqlConfig"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	SqlSession sqlSession = 
			MyAppSqlConfig.getSqlSessionInstance();;
	BoardMapper mapper = 
			sqlSession.getMapper(BoardMapper.class);
	List<BoardVO> list = mapper.selectBoard();
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
	 <th>번호</th>
	 <th>제목</th>
	 <th>글쓴이</th>
	 <th>등록일자</th>
 	</tr>
<%
	SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy-MM-dd"
	);
	for (BoardVO b : list) {
%> 	
	<tr>
		<td><%= b.getNo() %></td>
		<td>
			<a href='detail.jsp?no=<%= b.getNo() %>'>
				<%= b.getTitle() %>
			</a>
		</td>
		<td><%= b.getWriter() %></td>
		<td><%= sdf.format(b.getRegDate()) %></td>
	</tr>
<%
	}
	if (list.size() == 0) {
%>	
	<tr>
	  <td colspan='4'>게시물이 존재하지 않습니다.</td>
	</tr>
<%
	}
%>	
	</table>		
	<a href='writeForm.jsp'>글쓰기</a>
</body>
</html>












