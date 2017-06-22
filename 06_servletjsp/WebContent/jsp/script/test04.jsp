<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%-- 
	지시문 
	1. page    : 작성한 페이지에 대한 필요한 정보를 알려준다.
	   - contentType : response.setContentType( 값 );
	   - 서블릿으로 변환될때 브라우져에게 보낼 문서의 타입 설정
	   - import : import java.util.ArrayList;
	            : 페이지에서 사용하는 클래스에 대한 import 처리 
	   
	2. include : 다른 페이지의 코드를 내 페이지에 가져오기
	3. taglib  : 개발자가 정의한 태그의 정보를 알려준다.

--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
		String sDate = sdf.format(new Date());
		out.println(sDate);		
	%>
</body>
</html>













