<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="modal fade" id="regAuctionFormModal" tabindex="-1" role="dialog"
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
				<form id="regAuctionForm" name="regAuctionForm" enctype="multipart/form-data">
					<table class="table">
					<tbody>
						<tr>
							<td class="text-right col-sm-2"><h6>회원구분</h6></td>
							<td class="text-left col-sm-10">
								<h6 style="display:inline;">메인사진업로드</h6>
								<input style="display:inline;" class="input-sm" type="file" required/>
								
								<h6 style="display:inline;">썸네일사진업로드</h6>
								<input style="display:inline;" class="input-sm" type="file" required/>
							</td>
						</tr>
						<tr>
							<td class="text-right col-sm-2" rowspan="3"><h6>사진업로드</h6></td>
							<td class="text-left col-sm-10" rowspan="3">
								<img width='150px;' height='200px;' src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTVjNjlkMGM1ZDIgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNWM2OWQwYzVkMiI+PHJlY3Qgd2lkdGg9IjI0MiIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI4OS44NTAwMDAzODE0Njk3MyIgeT0iMTA1LjciPjI0MngyMDA8L3RleHQ+PC9nPjwvZz48L3N2Zz4=" alt="...">
								<img width='150px;' height='200px;' src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTVjNjlkMGM1ZDIgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNWM2OWQwYzVkMiI+PHJlY3Qgd2lkdGg9IjI0MiIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI4OS44NTAwMDAzODE0Njk3MyIgeT0iMTA1LjciPjI0MngyMDA8L3RleHQ+PC9nPjwvZz48L3N2Zz4=" alt="...">
							</td>
						</tr>
						<tr></tr><tr></tr>
					</tbody>
					</table>
					
					<table class="table" id='productTable'>
						<tbody>							
							<tr>
								<td class="text-right"><h6>상품명</h6></td>
								<td class="text-center"><input type="text"
									class="input-sm col-sm-6" name="AUC_PROD_NM" id="AUC_PROD_NM" 
									required />
							</tr>
							<tr>
								<td class="text-right"><h6>상품설명</h6></td>
								<td class="text-center"><textarea 
									class="input-sm col-sm-6" id="SHORT_CONT" name="SHORT_CONT" required ></textarea>
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>시작시간</h6></td>
								<td class="text-center">
								<input type="password" class="input-sm col-sm-6" id="START_DTIME" name="START_DTIME"
									required/></td>
							</tr>
							<tr>
								<td class="text-right"><h6>종료시간</h6></td>
								<td class="text-center"><input type="text"
									class="input-sm col-sm-6" id="END_DTIME" name="END_DTIME"
									required/></td>
							</tr>
							
							<tr>
								<td class="text-right"><h6>시작가</h6></td>
								<td class="text-center"><input type="text"
									class="input-sm col-sm-6" id="START_PRICE" name="START_PRICE"  required value="011-1234-1234">
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>수량</h6></td>
								<td class="text-center"><input type="text"
									class="input-sm col-sm-6" id="QTY" name="QTY" required />
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>상품카테고리 선택</h6></td>
								<td class="text-center"><input type="email" name="PROD_CATE_NUM" 
									class="input-sm col-sm-8" id="PROD_CATE_NUM" required>
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>경매유형</h6></td>
								<td class="text-center"><input type="email" name="AUC_TYPE_NUM" 
									class="input-sm col-sm-8" id="AUC_TYPE_NUM" required>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			</div>
			
			<div class="modal-footer bg-danger">
				<button type="button" class="btn btn-primary" onclick="regAuction();">경매등록</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	$( document ).ready(function() {
	   // 경매 상품 카테고리 Select 표시 ajax로 가져온다.
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
	   // 경매 유형 Select 표시 ajax로 가져온다.
	});
</script>