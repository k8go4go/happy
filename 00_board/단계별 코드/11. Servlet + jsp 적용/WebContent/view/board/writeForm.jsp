<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='write' method='post'>
	  제목 : <input type='text' name='title' /><br>
	  글쓴이 : <input type='text' name='writer' /><br>
	  내용 : <br>
	  <textarea name='content' rows='5' cols='70'></textarea><br>
	  <input type='submit' value='등록' />
	</form>
	<a href='list'>목록</a>
</body>
</html>