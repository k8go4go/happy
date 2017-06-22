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
		<h2>로그인</h2>
		<hr>
		<p>${error}</p>
		<form action="Login" method="post">
			<input type="text" name="id" /><br>
			<input type="text" name="pass" /><br>
			<button>로그인</button>
		</form>
	</div>	
	<div>
		<c:import url="/view/include/footer.jsp" />
	</div>	
</div>	
</body>
</html>











