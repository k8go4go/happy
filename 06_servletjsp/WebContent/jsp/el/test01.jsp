<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연산자</title>
</head>
<body>
	5 + 5 = <%= 5 + 5 %><br>
	5 + 5 = ${ 5 + 5 }<br>
	5 % 2 = ${ 5 % 2 }<br>
	5 mod 2 = ${5 mod 2}<br>
	5 == 5 = ${5 == 5}<br>
	5 eq 5 = ${5 eq 5}<br>
	empty "a" = ${empty "a"}<br>
	empty "" = ${empty ""}<br>
	!empty "" = ${!empty ""}<br>
	not empty "" = ${not empty ""}<br>
	empty str = ${empty str}<br>
</body>
</html>











