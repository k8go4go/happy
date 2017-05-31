<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath"  value="${pageContext.request.contextPath}" scope="request"/>
<c:set var="menuList"  value="${applicationScope['menu']}" scope="request"/>
<c:set var="pathList"  value="${applicationScope['path']}" scope="request"/>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="description" content="비트캠프 옥선 미니 프로젝트">
<meta name="author" content="이상욱">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/bootstrap-theme.css">
<link href="${contextPath}/resources/css/sweetalert.css" rel="stylesheet">
<title>Bit Used Auction</title>
</head>
<body role='document'>