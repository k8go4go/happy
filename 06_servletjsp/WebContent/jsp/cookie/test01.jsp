<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>설정된 쿠키 정보</h2>
	<%
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			String name = c.getName();
			String value = 
					URLDecoder.decode(
						c.getValue(), "utf-8"
					);
	%>
			<%= name %>, <%= value %><br>
	<%		
		}
	%>

	<h2>쿠키 설정</h2>
	<form action="Test01">
		이름 : <input type="text" name="name" /><br>
		값 : <input type="text" name="value" /><br>
		<input type="submit" value="쿠키 설정" />
	</form>	
</body>
</html>











