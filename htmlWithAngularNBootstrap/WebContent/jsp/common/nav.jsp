<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});
</script>
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

<div class="container">
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-8">
			<nav class="navbar sticky-top navbar-inverse">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<a class="navbar-brand" data-toggle="tooltip" title="홈으로.." href="<c:url value="${pathList['1'].PATH}${pathList['1'].PATH_NM}" />"> <img width="30" height="30"
							class="d-inline-block align-middle"
							src="${contextPath}/resources/imgs/brand.png">
						</a>
					</div>

					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false"> 진행중인 경매 <span class="caret"></span></a>
								<ul class="dropdown-menu multi-level" role="menu"
									aria-labelledby="dropdownMenu">
									<c:forEach var="menu" items="${menuList}">
										<li class="dropdown-submenu"><a tabindex="-1" href="">${menu.PROD_CATE_NM}</a>
											<ul class="dropdown-menu">
												<c:forEach var="menuItem" items="${menu.lowerCateVO}">
													<li><a
														href="${contextPath}/${menu.PROD_CATE_NUM}/${menuItem.PROD_CATE_NUM}/menu.do">${menuItem.PROD_CATE_NM}</a></li>
												</c:forEach>
											</ul>
										<li class="divider"></li></li>
							</c:forEach>
						</ul>
						</li>
						</ul>

						<ul class="nav navbar-nav">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false"> 이달의 경매 <span class="caret"></span></a>
								<ul class="dropdown-menu multi-level" role="menu"
									aria-labelledby="dropdownMenu">
									<c:forEach var="menu" items="${menuList}">
										<li class="dropdown-submenu"><a tabindex="-1" href="#">${menu.PROD_CATE_NM}</a>
											<ul class="dropdown-menu">
												<c:forEach var="menuItem" items="${menu.lowerCateVO}">
													<li><a href="#">${menuItem.PROD_CATE_NM}</a></li>
												</c:forEach>
											</ul>
										<li class="divider"></li></li>
							</c:forEach>
						</ul>
						</li>
						</ul>

						<form class="navbar-form navbar-right">
							<c:choose>
							<c:when test="${not empty sessionScope.user}">
								<button type="button" class="btn btn-info glyphicon glyphicon-eye-open" >로그아웃</button>
								<button type="button" class="btn btn-info glyphicon glyphicon-eye-open" >My Auction</button>
							</c:when>
							<c:otherwise>
								<button type="button" class="btn btn-info glyphicon glyphicon-eye-open" data-toggle="modal" data-target="#loginFormModal" >로그인</button>
								<button type="button" class="btn btn-info glyphicon glyphicon-eye-open" data-toggle="modal" data-target="#joinFormModal" >회원가입</button>
							</c:otherwise>
							</c:choose>
						</form>

<c:import url="/jsp/member/loginModal.jsp"></c:import>
<c:import url="/jsp/member/joinModal.jsp"></c:import>						
						
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">고객센터<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="<c:url value="${pathList['2'].PATH}${pathList['2'].PATH_NM}" />">QNA</a></li>
									<li><a href="<c:url value="${pathList['6'].PATH}${pathList['6'].PATH_NM}" />">FAQ</a></li>
									<li role="separator" class="divider"></li>
									<li><a href="#">About US</a></li>
								</ul></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</div>
		<div class="col-md-1"></div>
	</div>