<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<nav class="navbar sticky-top navbar">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<a class="navbar-brand" data-toggle="tooltip" title="홈으로.." href="<c:url value="/admin/adminMain.do" />"> <img width="30" height="30"
							class="d-inline-block align-middle"
							src="${contextPath}/resources/imgs/brand.png">
						</a>
					</div>

				<form class="navbar-form navbar-left">
					<c:choose>
					<c:when test="${not empty sessionScope.mgr}">
						<button type="button" id="adminLogout" class="btn btn-info" >로그아웃</button>
						<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myAuctionFormModal">Auction List</button>
					</c:when>
					<c:otherwise>
						<button type="button" class="btn btn-info" data-toggle="modal" data-target="#amdinloginFormModal" >로그인</button>
					</c:otherwise>
					</c:choose>
				</form>

<c:import url="/jsp/admin/mgr/loginModal.jsp"></c:import>
						
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">통계정보<span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li><a href="#">통계현황</a></li>
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
<script>
	$('#adminLogout').on('click', function (e) {
		location.href = '${contextPath}${pathList['25'].PATH}${pathList['25'].PATH_NM}';
	})
</script>	