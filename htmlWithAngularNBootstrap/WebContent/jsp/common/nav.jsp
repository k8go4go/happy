<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.dropdown-submenu {
    position: relative;
}

.dropdown-submenu>.dropdown-menu {
    top: 0;
    left: 100%;
    margin-top: -6px;
    margin-left: -1px;
    -webkit-border-radius: 0 6px 6px 6px;
    -moz-border-radius: 0 6px 6px;
    border-radius: 0 6px 6px 6px;
}

.dropdown-submenu:hover>.dropdown-menu {
    display: block;
}

.dropdown-submenu>a:after {
    display: block;
    content: " ";
    float: right;
    width: 0;
    height: 0;
    border-color: transparent;
    border-style: solid;
    border-width: 5px 0 5px 5px;
    border-left-color: #ccc;
    margin-top: 5px;
    margin-right: -10px;
}

.dropdown-submenu:hover>a:after {
    border-left-color: #fff;
}

.dropdown-submenu.pull-left {
    float: none;
}

.dropdown-submenu.pull-left>.dropdown-menu {
    left: -100%;
    margin-left: 10px;
    -webkit-border-radius: 6px 0 6px 6px;
    -moz-border-radius: 6px 0 6px 6px;
    border-radius: 6px 0 6px 6px;
}
</style>
<nav class="navbar navbar-default navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img style="width:40px;" alt="Brand" src="${contextPath}/resources/imgs/brand.png"></a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 진행중인 경매 <span class="caret"></span></a>
          <ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
          	  <c:forEach var="menu" items="${menuList}">
	              <li class="dropdown-submenu">
	                <a tabindex="-1" href="">${menu.PROD_CATE_NM}</a>
	                <ul class="dropdown-menu">
	          	  <c:forEach var="menuItem" items="${menu.lowerCateVO}">
	                  <li><a href="${contextPath}/${menu.PROD_CATE_NUM}/${menuItem.PROD_CATE_NUM}/menu.do">${menuItem.PROD_CATE_NM}</a></li>
	              </c:forEach>
	                </ul>
	              <li class="divider"></li>
	              </li>
              </c:forEach>
            </ul>
        </li>
      </ul>
      
      <ul class="nav navbar-nav">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 이달의 경매 <span class="caret"></span></a>
          <ul class="dropdown-menu multi-level" role="menu" aria-labelledby="dropdownMenu">
          	  <c:forEach var="menu" items="${menuList}">
	              <li class="dropdown-submenu">
	                <a tabindex="-1" href="#">${menu.PROD_CATE_NM}</a>
	                <ul class="dropdown-menu">
	          	  <c:forEach var="menuItem" items="${menu.lowerCateVO}">
	                  <li><a href="#">${menuItem.PROD_CATE_NM}</a></li>
	              </c:forEach>
	                </ul>
	              <li class="divider"></li>
	              </li>
              </c:forEach>
            </ul>
        </li>
        <li><a href="#">My Auction</a></li>
      </ul>
      
      
      <ul class="nav navbar-nav navbar-right">
        <li><button type="button" class="btn btn-danger">로그인</button></li>
        <li><button type="button" class="btn btn-danger">로그아웃</button></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">고객센터<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">QNA</a></li>
            <li><a href="#">FAQ</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">About US</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav> 