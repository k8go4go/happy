<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="myPath" value="${pageContext.request.contextPath}" />



<c:import url="/jsp/common/header.jsp" />
<c:import url="/jsp/common/gnb.jsp" />
<c:import url="/jsp/common/lnb.jsp" />

<script type="text/javascript">
	function login() {
		var form = document.getElementById('login_form');
		var email = form.EMAIL;
		var passwd = form.PASSWD;
		var usr_cd = form.USR_CD;

		if(!required(form)) {
			alert("이메일 주소 또는 패스워드를 입력해주시기 바랍니다.");
			return;
		}
		
		if (!validationID(email.value)) {
			EMAIL.focus();
			alert("이메일 주소를 다시 입력해주시기 바랍니다.");
			return;
		}

		form.method = 'post';
		form.action = '${myPath}/service/member/login.do';
		form.submit();

		console.log(form);
	}

	function required(form) {
		var arrs = form.getElementsByTagName('input');

		for (var i = 0; i < arrs.length; i++) {
			if (arrs[i].value.length == 0) {
				return false;
			}
		}

		return true;
	}
	
	function validationID(email) {
		if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
			return true;
		}
		return false;
	}

	function cancel() {
		var elements = document.getElementsByClassName('bitTxt');
		
		for(var i=0;  i < elements.length; i++) {
			 elements[i].value = '';
		}
	}
</script>

<style type="text/css">
#left, #center, #right {
	display: inline-block;
	zoom: 1;
	padding: 5px;
	vertical-align: middle;
}

#left {
	width: 132px;
}

#center {
	width: 432px;
}

#right {
	width: 132px;
}

table {
	width: 400px
}

th, td:nth-child(odd) {
	width: 35%;
	font: bold;
	text-align: right;
	margin: 10px;
	padding: 10px;
	text-shadow: 1px 1px 0px #BEE2F9;
}

#ZIPNO1, #ZIPNO2 {
	text-align: center;
}

</style>
<div id="contentwrap">
	<div id="content">
		<div id="left" class="over_container"></div>
		<div id="center" class="over_container">
			<form id="login_form" name="login_form">
				<h1 style="font-size: 16px; text-align: center;">로그인</h1>
				<hr>
				<table>
					<tr>
						<th>회원구분</th>
						<td>개인<input class="bitRadio" type="radio" name="USR_CD"
							id="USR_CD" value="1" checked="checked" style="width: 20px;"
							onclick="usercd();" /> 회사<input class="bitRadio" type="radio"
							name="USR_CD" id="USR_CD" value="2" style="width: 20px;"
							onclick="usercd();" /></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><input class="bitTxt" type="email" name="EMAIL"
							id="EMAIL" placeholder="이메일을 입력하세요" required maxlength="50" /></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input class="bitTxt" type="password" name="PASSWD"
							id="PASSWD" placeholder="비밀번호를 입력하세요" required maxlength="10" /></td>
					</tr>
				</table>
			</form>
			<table>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						class="bitBtn" type="button" id="JOINBTN" value="로그인"
						onclick="login();" /> <input class="bitBtn" type="button"
						id="CANCELBTN" value="취소" onclick="cancel();" /></td>
				</tr>
			</table>
		</div>
		<div id="right" class="over_container"></div>
	</div>
</div>
<c:import url="/jsp/common/footer.jsp" />