<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="myContextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${myContextPath}/resource/css/main.css" />
<title>bit used auction</title>

<style type="text/css">
#left, #center, #right{
    display:inline-block; 
    zoom:1;
    padding:5px; 
    vertical-align:middle;
}

#left{
    width:232px; 
}

#center{
	width:232px; 
}

#right{
	width:232px; 
}

.over_container {
    position: relative;
    width: 50%;
}

.over_image {
  opacity: 1;
  display: block;
  width: 100%;
  height: auto;
  transition: .5s ease;
  backface-visibility: hidden;
}

.middle {
  transition: .5s ease;
  opacity: 0;
  position: absolute;
  top: 35%;
  left: 50%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%)
}

.over_container:hover .over_image {
  opacity: 0.3;
}

.over_container:hover .middle {
  opacity: 1;
}

.text {
  background-color: #4CAF50;
  color: white;
  font-size: 16px;
  padding: 16px 32px;
}

</style>
</head>
<body>
<div id="wrapper">