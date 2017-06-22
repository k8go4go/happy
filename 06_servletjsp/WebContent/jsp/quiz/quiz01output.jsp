<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int dan = Integer.parseInt(
					request.getParameter("dan"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for (int i = 1; i < 10; i++) {
			String msg = String.format(
				"%d * %d = %d<br>", dan, i, dan * i
			);	
	%>
		<%= msg %>
	<%
		}
	%>
	<a href="quiz01input.jsp">다시입력</a>
</body>
</html>