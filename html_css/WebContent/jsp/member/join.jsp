<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<c:set var="myPath" value="${pageContext.request.contextPath}" />

<c:import url="/jsp/common/header.jsp" />
<c:import url="/jsp/common/gnb.jsp" />
<c:import url="/jsp/common/lnb.jsp" />

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	function join() {
		var form = document.getElementById('join_member');
		var social_no = form.SOCIAL_NO;
		var nm = form.NM;
		var email = form.EMAIL;
		var passwd = form.PASSWD;
		var cpasswd = form.CPASSWD;
		var telno = form.TELNO;
		var zipno1 = form.ZIPNO1;
		var zipno2 = form.ZIPNO2;
		var address1 = form.ADDRESS1;
		var address2 = form.ADDRESS2;
		var usr_cd = form.USR_CD;

		if(!required(form)) {
			alert("필수사항을 입력해주시기 바랍니다.");
			return;
		}

		if (!validationID(email.value)) {
			EMAIL.focus();
			alert("이메일 주소를 다시 입력해주시기 바랍니다.");
			return;
		}

		if (!validationSocial_no(social_no.value)) {
			social_no.focus();
			alert("주민등록 번호를 다시 입력해주시기 바랍니다.");
			return;
		}

		if (!validationPasswd(passwd.value, cpasswd.value)) {
			cpasswd.focus();
			return;
		}

		if (ADDRESS1.value == "") {
			alert("상세주소를 입력해주세요.");
			return;
		}

		if (ADDRESS2.value == "") {
			alert("상세주소를 입력해주세요.");
			return;
		}

		form.method = 'post';
		form.action = '${myPath}/service/member/join.do';
		form.submit();
	}

	function validationID(email) {
		if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
			return true;
		}
		return false;
	}

	function validationSocial_no(social_no) {
		if (/^[0-9]{6}\-?[0-9]{7}$/.test(social_no)) {
			return true;
		}
		return false;
	}

	function validationPasswd(p1, p2) {
		if (/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/.test(p1)
				&& /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/.test(p2)) {
			if (p1 == p2) {
				return true;
			} else {
				alert("비밀번호  다릅니다. 다시 입력해주세요")
			}
		} else {
			alert("비밀번호 길이 또는 영문,특수문자, 숫자를 혼용하지 않았습니다. 다시 입력해주세요")
		}

		return false;
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

	function usercd() {
		var form = document.getElementById('join_member');
		var usr_cd = form.MEMB_CD;

		var div_pr = document.getElementById('pr_member');
		var div_com = document.getElementById('com_member');

		if (usr_cd.value == '1') {
			div_pr.style = 'display:blcok';
			div_com.style = 'display:none';
		} else {
			div_pr.style = 'display:none';
			div_com.style = 'display:blcok';
		}
	}

	function cancelJoin() {
		var elements = document.getElementsByClassName('bitTxt');
		
		for(var i=0;  i < elements.length; i++) {
			 elements[i].value = '';
		}
	}
	
	function zipSearch() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            console.log(data);
	        	var form = document.getElementById('join_member');
	    		var zipno1 = form.ZIPNO1;
	    		var zipno2 = form.ZIPNO2;
	    		var address1 = form.ADDRESS1;
	    		
	    		zipno1.value = data.postcode1;
	    		zipno2.value = data.postcode2;
	    		address1.value = data.address;
	    		
	        }
	    }).open();
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
			<form id="join_member" name="join_member">
				<h1 style="font-size: 16px; text-align: center;">회원가입</h1>
				<hr>
				<table>
					<tr>
						<th>회원구분</th>
						<td>개인<input class="bitRadio" type="radio" name="MEMB_CD"
							id="MEMB_CD" value="1" checked="checked" style="width: 20px;"
							onclick="usercd();" /> 회사<input class="bitRadio" type="radio"
							name="MEMB_CD" id="MEMB_CD" value="2" style="width: 20px;"
							onclick="usercd();" /></td>
					</tr>
					<tr>
						<th>프로필 사진등록</th>
						<td><input type="file" name="UPLOADFILE" id="UPLOADFILE" 
							required /></td>
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
					<tr>
						<th>비밀번호확인</th>
						<td><input class="bitTxt" type="password" name="CPASSWD"
							id="CPASSWD" placeholder="동일한 비밀번호를 입력하세요" required
							maxlength="10" /></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td><input class="bitTxt" type="text" name="ZIPNO1"
							id="ADDRESS" disabled="disabled" style="width: 40px;" /> - <input
							class="bitTxt" type="text" name="ZIPNO2" id="ZIPNO2"
							disabled="disabled" style="width: 40px;" /> <input
							class="bitBtn" type="button" id="FIND_ZIP" value="우편번호찾기" onclick="zipSearch();"/></td>
					</tr>
					<tr>
						<th>집주소</th>
						<td><input class="bitTxt" type="text" name="ADDRESS"
							id="ADDRESS" disabled="disabled"></td>
					</tr>
					<tr>
						<th>상제집주소</th>
						<td><input class="bitTxt" type="text" name="DETA_ADDRESS"
							id="DETA_ADDRESS" placeholder="상세주소를 입력하세요" required></td>
					</tr>
				</table>
				<div id="pr_member" style="display: block;">
					<table>
						<tr>
							<th>이름</th>
							<td><input class="bitTxt" type="text" name="NM" id="NM"
								placeholder="이름을 입력하세요" required maxlength="5" /></td>
						</tr>
						<tr>
							<th>주민등록번호</th>
							<td><input class="bitTxt" type="text" name="SOCIAL_NO"
								id="SOCIAL_NO" placeholder="주민등록번호을 입력하세요" required
								maxlength="14" /></td>
						</tr>
					</table>
				</div>
				<div id="com_member" style="display: none;">
					<table>
						<tr>
							<th>회사명</th>
							<td><input class="bitTxt" type="text" name="COM_NM"
								id="COM_NM" placeholder="회사명을 입력하세요" required maxlength="20" /></td>
						</tr>
						<tr>
							<th>사업자등록번호</th>
							<td><input class="bitTxt" type="text" name="BUS_NO"
								id="BUS_NO" placeholder="사업자등록번호를 입력하세요" required
								maxlength="10" /></td>
						</tr>
						<tr>
							<th>대표자명</th>
							<td><input class="bitTxt" type="text" name="CEO_NM"
								id="CEO_NM" placeholder="대표자명을 입력하세요" required maxlength="5" /></td>
						</tr>
						<tr>
							<th>담당자명</th>
							<td><input class="bitTxt" type="text" name="CHG_NM"
								id="CHG_NM" placeholder="담당자명을 입력하세요" required maxlength="5" /></td>
						</tr>
					</table>
				</div>
			</form>
			<table>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						class="bitBtn" type="button" id="JOINBTN" value="회원가입"
						onclick="join();" /> <input class="bitBtn" type="button"
						id="CANCELBTN" value="취소" onclick="cancelJoin();" /></td>
				</tr>
			</table>
		</div>
		<div id="right" class="over_container"></div>
	</div>
</div>
<c:import url="/jsp/common/footer.jsp" />