<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<div>
		<c:import url="/view/include/topMenu.jsp" />
	</div>	
	<div>
		<form action='write' method='post' enctype="multipart/form-data">
		  제목 : <input type='text' name='title' /><br>
		  글쓴이 : <input type='text' name='writer' /><br>
		  내용 : <br>
		  <textarea name='content' rows='5' cols='70'></textarea><br>
		  첨부파일 : <input type="file" name="attachFile" /><br>
		  <input type='submit' value='등록' />
		</form>
		<a href='list'>목록</a>
	</div>	
	<div>
		<c:import url="/view/include/footer.jsp" />
	</div>	
</div>

</body>
</html>