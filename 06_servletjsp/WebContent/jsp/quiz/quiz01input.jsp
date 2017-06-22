<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="quiz01output.jsp">
		<select name="dan">
		<%
			for (int i = 2; i < 10; i++) {
		%>
			<option value="<%= i %>"><%= i %></option>
		<%	
			}
		%>
		</select>
		<button>출력</button>
	</form>
</body>
</html>