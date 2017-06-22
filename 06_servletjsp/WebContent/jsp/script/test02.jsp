<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	선언문 연습
	<%! 
		// 선언문 사용시 _jspService 밖에 적용됨...
		String msg = "멤버변수로 적용";
		public void call() {
			System.out.println(msg);
		}
	%>
</body>
</html>












