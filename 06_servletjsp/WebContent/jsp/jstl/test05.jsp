<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	for (int i = 1; i <= 10; i++) {
		System.out.println(i);
	}
	 --%>	
	 
    <c:forEach var="i" begin="1" end="10">
    	<c:out value="${i}" /><br>
    </c:forEach>
    
      생년월일 : 
    <select>
	    <c:forEach var="i" begin="1960" end="2000">
	    	<option value="${i}">${i}</option>
	    </c:forEach>
    </select>	 
    <br>
    <%--
    	for (String s : list) {
    		System.out.println(s);
    	}
     --%>
    <%
    	List<String> list = new ArrayList<>();
    	list.add("one");
    	list.add("two");
    	list.add("three");
    	
    	pageContext.setAttribute("list", list);
    %> 
    <c:forEach var="s" items="${list}">
    	<c:out value="${s}" /><br>
    </c:forEach> 
    
    <%-- 
    	출력이 아래와 같이 되도록 코드 작성
    	one,two,three
    --%>
    <c:set var="cnt" value="1" />	
    <c:forEach var="s" items="${list}">
    	<c:if test="${cnt != 1}">,</c:if>
    	<c:out value="${s}" />
	    <c:set var="cnt" value="${cnt + 1}" />	
    </c:forEach> 
    <br>
    
    <c:forEach var="s" items="${list}" varStatus="loop">
    	${loop.first}:::${loop.last}:::${loop.count}:::${loop.index}<br>
    </c:forEach>

    <c:forEach var="s" items="${list}" varStatus="loop">
    	<c:if test="${not loop.first}">,</c:if>
    	<c:out value="${s}" />
    </c:forEach>
</body>
</html>













