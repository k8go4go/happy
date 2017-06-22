<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		실행문 : 실행할 자바코드 작성
		표현식 : 출력할 부분을 명시(out.println 대체)
	 --%>
	<%
		String msg = "안녕하세요";
		out.println(msg);
	%>
	<%= msg %>
</body>
</html>










