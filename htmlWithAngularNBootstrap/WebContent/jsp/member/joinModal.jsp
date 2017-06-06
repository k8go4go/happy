<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="joinFormModal" tabindex="-1" role="dialog"
	aria-labelledby="joinFormModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-danger">
				<h4 class="modal-title glyphicon glyphicon-thumbs-up"
					id="joinFormModalLabel">회원가입</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
			<div class="table-responsive">
				<form id="memberJoinForm" name="memberJoinForm" enctype="multipart/form-data">
					<table class="table">
					<tbody>
						<tr>
							<td class="text-right col-sm-2"><h6>회원구분</h6></td>
							<td class="text-left col-sm-10">
								<h6 style="display:inline;" >개인</h6>
								<input type="radio" id="MEMB_CD" class="input-sm" name="MEMB_CD" checked="checked" value="2001" onclick="memb_cd();"/>
								<h6 style="display:inline;">기업</h6>
								<input type="radio" id="MEMB_CD" class="input-sm" name="MEMB_CD" value="2002" onclick="memb_cd();" />
								
								<h6 style="display:inline;">사진업로드</h6>
								<input style="display:inline;" class="input-sm" type="file" id="UPLOADFILE" name="UPLOADFILE" onchange="readURL(this, 'preview');" required/>
							</td>
						</tr>
						<tr>
							<td class="text-right col-sm-2" rowspan="3"><h6>프로필</h6></td>
							<td class="text-left col-sm-10" rowspan="3">
								<img id="preview" name="FILE_NAME" width='150px;' height='200px;' src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTVjNjlkMGM1ZDIgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNWM2OWQwYzVkMiI+PHJlY3Qgd2lkdGg9IjI0MiIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI4OS44NTAwMDAzODE0Njk3MyIgeT0iMTA1LjciPjI0MngyMDA8L3RleHQ+PC9nPjwvZz48L3N2Zz4=">
							</td>
						</tr>
						<tr></tr><tr></tr>
					</tbody>
					</table>
					<table class="table" id='joinPriTable' style="display: block;">
						<tbody>
						<tr>
							<td class="text-right col-sm-2"><h6>이름</h6></td>
							<td class="text-right col-sm-4">
								<input type="text"
									class="input-sm col-sm-10" name="NM" id="NM" value="이상욱">
							</td>
							<td class="text-right col-sm-2"><h6>주민등록번호</h6></td>
							<td class="text-right col-sm-4">
								<input type="text"
									class="input-sm col-sm-10" name="SOC_REG_NUM" id="SOC_REG_NUM" value="7605281111111">
							</td>
						</tr>
						</tbody>
					</table>
					<table class="table" id='joinComTable' style="display: none;">
						<tbody>
						<tr>
							<td class="text-right col-sm-2"><h6>회사명</h6></td>
							<td class="text-right col-sm-4"><input class="input-sm col-sm-10" type="text" name="CORP_NM"
								id="CORP_NM"  required  value="비트"/></td>
							<td class="text-right col-sm-2"><h6>사업자등록번호</h6></td>
							<td class="text-right col-sm-4"><input class="input-sm col-sm-10" type="text" name="BUS_NUM"
								id="BUS_NUM"  required  value="1111111111"/></td>
						</tr>
						<tr>
							<td class="text-right col-sm-2"><h6>대표자명</h6></td>
							<td class="text-right col-sm-4"><input class="input-sm col-sm-10" type="text" name="CEO_NM"
								id="CEO_NM"  required value="김용재"/></td>
							<td class="text-right col-sm-2"><h6>담당자명</h6></td>
							<td class="text-right col-sm-4"><input class="input-sm col-sm-10" type="text" name="CHGR_NM"
								id="CHGR_NM"  required  value="정의홍"/></td>
						</tr>
						</tbody>
					</table>
					<table class="table" id='joinMainTable'>
						<tbody>							
							<tr>
								<td class="text-right"><h6>아이디</h6></td>
								<td class="text-center"><input type="text"
									class="input-sm col-sm-6" name="MEMB_ID" id="MEMB_ID" value="test1234"
									required>
									<button type="button" class="btn btn-primary"
										onclick="checkDuplicate();">중복확인</button></td>
							</tr>
							<tr>
								<td class="text-right"><h6>비밀번호</h6></td>
								<td class="text-center"><input type="password"
									class="input-sm col-sm-6" id="SEC_NUM" name="SEC_NUM" required value="testtest!1">
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>비밀번호확인</h6></td>
								<td class="text-center"><input type="password"
									class="input-sm col-sm-6" id="CONFIRM_SEC_NUM" name="CONFIRM_SEC_NUM"
									required value="testtest!1"></td>
							</tr>
							<tr>
								<td class="text-right"><h6>이메일</h6></td>
								<td class="text-center">
									<input type="hidden" class="input-sm col-sm-2" id="EMAIL" name="EMAIL">
									<input type="text"
									class="input-sm col-sm-2" id="EMAIL1" required value="testtest" name="EMAIL1">
									<span class="col-sm-1">@</span>
									<input type="text" class="input-sm col-sm-2" id="EMAIL2" name="EMAIL2"
										readonly="readonly" value="test.com"
									required>
									  <select  id="MAIL_CD" name="MAIL_CD" onchange="emailChange();">
								        <option value="1901">daum.net</option>
								        <option value="1902">naver.com</option>
								        <option value="1903">gmail.com</option>
								        <option value="1904">empas.com</option>
								        <option value="1905" selected>직접입력</option>
								      </select>									
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>전화번호</h6></td>
								<td class="text-center"><input type="email"
									class="input-sm col-sm-6" id="TEL_NUM" name="TEL_NUM"  required value="011-1234-1234">
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>핸드폰번호</h6></td>
								<td class="text-center"><input type="email"
									class="input-sm col-sm-6" id="MOBIL_NUM" name="MOBIL_NUM" required value="011-1234-1234">
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>우편번호</h6></td>
								<td class="text-center"><input type="text"
									class=" input-sm col-sm-4" id="ZIP_NUM" name="ZIP_NUM" 
									required readonly="readonly">
									<button type="button" class="btn btn-primary" onclick="zipSearch();">우편번호찾기</button>
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>주소</h6></td>
								<td class="text-center"><input type="email" name="ADDRESS" 
									class="input-sm col-sm-8" id="ADDRESS" required readonly="readonly">
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>상세주소</h6></td>
								<td class="text-center"><input type="email" name="DETA_ADDRESS" 
									class="input-sm col-sm-8" id="DETA_ADDRESS" required value="011-1234-1234">
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			</div>
			
			<div class="modal-footer bg-danger">
				<button type="button" class="btn btn-primary" onclick="join();">회원가입</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	function readURL(input, tag) { 
		if (input.files && input.files[0]) { 
			var reader = new FileReader(); 
			reader.onload = function (e) { 
				$('#' + tag).attr('src', e.target.result); 
			} 
			reader.readAsDataURL(input.files[0]); 
		} 
	}

	
	var emailChange = function() {
		var x = document.getElementById("MAIL_CD").value;
		if(x == '1905') {
			$('#EMAIL2').val('');
			$('#EMAIL2').attr('readonly',false);
		} else {
			$('#EMAIL2').attr('readonly',true);
	        switch(x) {
	        case '1901' : $('#EMAIL2').val('daum.net');  
	        	break;
	        case '1902' : $('#EMAIL2').val('naver.com'); 
	        	break;
	        case '1903' : $('#EMAIL2').val('gmail.com'); 
	        	break;
	        case '1904' : $('#EMAIL2').val('empas.com'); 
	        	break;
	        }
		}
	}
	
	var checkDuplicate = function() {
		console.log("id" + document.getElementById('memberJoinForm').MEMB_ID.value);
		 $.ajax(
			 {
		 		type: 'get',
				url: '${contextPath}${pathList['10'].PATH}${pathList['10'].PATH_NM}',
				data: 'id=' + document.getElementById('memberJoinForm').MEMB_ID.value ,
		 		success: function(result) {
		 			if(result == '0')
		 				swal("아이디중복확인", "사용하실수 있는 ID 입니다.", "success");
		 			else
		 				swal("아이디중복확인", "사용하실수 없는ID 입니다.", "error");
	    		},
	    		error: function(result) {
	    			swal("가입오류", "서버 오류입니다.", "error");
	    		}
			}
		);
	}
	
	var memb_cd = function() {
		var form = document.getElementById('memberJoinForm');
		var usr_cd = form.MEMB_CD;

		var div_pr = document.getElementById('joinPriTable');
		var div_com = document.getElementById('joinComTable');

		if (usr_cd.value == '2001') {
			div_pr.style = 'display:blcok';
			div_com.style = 'display:none';
		} else {
			div_pr.style = 'display:none';
			div_com.style = 'display:blcok';
		}
	}
	
	var join = function() {
		var form = document.memberJoinForm;
		var memb_id = form.MEMB_ID;
		var mail_cd = form.MAIL_CD;
		var email = form.EMAIL;
			email.value = form.EMAIL1.value + '@' + form.EMAIL2.value;
		var usr_cd = form.MEMB_CD;
		var social_no = form.SOC_REG_NUM;
		var nm = form.NM;
		var passwd = form.SEC_NUM;
		var cpasswd = form.CONFIRM_SEC_NUM;
		var telno = form.TEL_NUM;
		var mobil_num = form.MOBIL_NUM;
		var zip_num = form.ZIP_NUM;
		var address = form.ADDRESS;
		var deta_address = form.DETA_ADDRESS;
		
		var mainTable = document.getElementById('joinMainTable');
		var joinPriTable = document.getElementById('joinPriTable');
		var joinComTable = document.getElementById('joinComTable');
		
		if(!required(mainTable)) {
			swal("가입오류", "필수사항을 입력해주시기 바랍니다.", "error");
			return;
		}
		
		if(usr_cd == '2001') {
			if(!required(joinPriTable)) {
				swal("가입오류", "필수사항을 입력해주시기 바랍니다.", "error");
				return;
			} 
		} else {
			if(!required(joinComTable)) {
				swal("가입오류", "필수사항을 입력해주시기 바랍니다.", "error");
				return;
			}
		}
		
		if (!validationID(memb_id.value, '1905')) {
			swal("가입오류", "아이디 오류입니다.", "error");
			return;
		}
		
		if (!validationID(email.value, mail_cd.value)) {
			swal("가입오류", "이메일 오류입니다.", "error");
			return;
		}

		if (!validationPasswd(passwd.value, cpasswd.value)) {
			swal("가입오류", "패스워드가 다릅니다", "error");
			return;
		}

		if (address.value == "") {
			swal("가입오류", "우편번호 찾기를 눌러 우편번호를 찾아주세요", "error");
			return;
		}

		if (deta_address.value == "") {
			swal("가입오류", "상세 주소 기입 하셔야 합니다.", "error");
			return;
		}
		
		form.method = 'post';
		form.action = '${contextPath}${pathList['9'].PATH}${pathList['9'].PATH_NM}';
		form.submit();
	}

	var validationID  = function(email, option) {
		if(option == '1905') {
			if (/^\w+([\.-]?\w+)*/.test(email)) {
				return true;
			}
			return false;
		} else {
			if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
				return true;
			}
			return false;
		}
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



	function cancelJoin() {
		var elements = document.memberJoinForm.getElementsByTagName('input');
		
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
	        	var form = document.getElementById('memberJoinForm');
	    		var zipno = form.ZIP_NUM;
	    		var address = form.ADDRESS;
	    		
	    		zipno.value = data.postcode1 + data.postcode2;
	    		address.value = data.address;
	    		
	        }
	    }).open();
	}
</script>