<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<div class="modal fade" id="regAuctionFormModal" tabindex="-1" role="dialog"
	aria-labelledby="joinFormModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-info">
				<h4 class="modal-title glyphicon glyphicon-thumbs-up"
					id="joinFormModalLabel">경매등록</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
			<div class="table-responsive">
				<form id="regAuctionForm" name="regAuctionForm" method="post" action="${contextPath}${pathList['13'].PATH}${pathList['13'].PATH_NM}" 
					enctype="multipart/form-data">
					<table class="table">
					<tbody>
						<tr>
							<td class="text-right col-sm-2"><h6>메인사진</h6></td>
							<td class="text-left col-sm-10">
								<input style="display:inline;" class="input-sm" type="file"
								id="M_UPLOAD" name="M_UPLOAD" onchange="readURL(this, 'mainPreview');"
								required/>
							</td>
						</tr>
						<tr>
							<td class="text-right col-sm-2"><h6>썸네일사진</h6></td>
							<td class="text-left col-sm-10">
								<input style="display:inline;" class="input-sm" type="file"
								id="T_UPLOAD" name="T_UPLOAD" onchange="readURL(this, 'secPreview');" 
								required/>
							</td>
						</tr>
						<tr>
							<td class="text-right col-sm-2" rowspan="3"><h6>사진업로드</h6></td>
							<td class="text-left col-sm-10" rowspan="3">
								<img id="mainPreview" width='150px;' height='200px;' src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTVjNjlkMGM1ZDIgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNWM2OWQwYzVkMiI+PHJlY3Qgd2lkdGg9IjI0MiIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI4OS44NTAwMDAzODE0Njk3MyIgeT0iMTA1LjciPjI0MngyMDA8L3RleHQ+PC9nPjwvZz48L3N2Zz4=" alt="...">
								<img id="secPreview" width='150px;' height='200px;' src="data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTVjNjlkMGM1ZDIgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNWM2OWQwYzVkMiI+PHJlY3Qgd2lkdGg9IjI0MiIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI4OS44NTAwMDAzODE0Njk3MyIgeT0iMTA1LjciPjI0MngyMDA8L3RleHQ+PC9nPjwvZz48L3N2Zz4=" alt="...">
							</td>
						</tr>
						<tr></tr><tr></tr>
						<tr>
								<td class="text-right col-sm-2"><h6>메인분류 선택</h6></td>
								<td class="text-center col-sm-6">
								<select id="PROD_CATE_NUM_ROOT">
								</select>								
								</td>
							</tr>
							<tr>
								<td class="text-right col-sm-2"><h6>중분류 선택</h6></td>
								<td class="text-center col-sm-6">
								<select id="PROD_CATE_NUM_SECOND">
								</select>
								</td>
							</tr>
							<tr>
								<td class="text-right col-sm-2"><h6>선 택</h6></td>
								<td class="text-center col-sm-6">
								<select id="PROD_CATE_NUM">
								</select>
								</td>
							</tr>
							<tr>
								<td class="text-right col-sm-2"><h6>경매유형</h6></td>
								<td class="text-center col-sm-6">
								<select id="AUC_TYPE_NUM">
								</select>
								</td>
							</tr>
					</tbody>
					</table>
					<input type="hidden" name="PROD_CATE_NUM" id="PROD_CATE" />
					<input type="hidden" name="AUC_TYPE_NUM" id="AUC_TYPE" />
					
					<table class="table" id='productTable'>
						<tbody>							
							<tr>
								<td class="text-right col-sm-2"><h6>상품명</h6></td>
								<td class="text-center col-sm-8"><input type="text"
									class="input-sm col-sm-6" name="AUC_PROD_NM" id="AUC_PROD_NM" 
									required />
							</tr>
							<tr>
								<td class="text-right col-sm-2"><h6>상품설명</h6></td>
								<td class="text-center col-sm-6"><textarea 
									class="input-sm col-sm-6" id="SHORT_CONT" name="SHORT_CONT" required ></textarea>
								</td>
							</tr>
							<tr>
								<td class="text-right col-sm-2"><h6>시작시간</h6></td>
								<td class="text-center col-sm-6">
			                      	<div class="input-group date form_datetime1 col-md-10" data-date="2017-06-05T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
					                    <input class="input-sm col-sm-6" size="16" type="text" id="START_DTIME" name="START_DTIME" value="" readonly>
					                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
										<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
					                </div>
								</td>	
							</tr>
							<tr>
								<td class="text-right"><h6>종료시간</h6></td>
								<td class="text-center">
								<div class="input-group date form_datetime2 col-md-10" data-date="2017-06-05T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
					                    <input class="input-sm col-sm-6" size="16" type="text" id="END_DTIME" name="END_DTIME" value="" readonly>
					                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
										<span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
					                </div>
								</td>
							</tr>
							<tr>
								<td class="text-right col-sm-2"><h6>시작가격</h6></td>
								<td class="text-center col-sm-6"><input type="text"
									class="input-sm col-sm-6" id="START_PRICE" name="START_PRICE"  required>
								</td>
							</tr>
							<tr>
								<td class="text-right col-sm-2"><h6>수량</h6></td>
								<td class="text-center col-sm-6"><input type="text"
									class="input-sm col-sm-6" id="QTY" name="QTY" required />
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			</div>
			
			<div class="modal-footer bg-info">
				<button id='checkBtn' type="button" class="btn btn-primary" form="regAuctionForm">경매등록</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
			</div>
		</div>
	</div>
</div>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
	$('#checkBtn').on('click', function(e) {
		var f = $('#regAuctionForm');
		
		if(f.START_DTIME == '' || f.END_DTIME == '') {
			swal('경매등록오류', '시작/종료시간은 필수사항입니다.', 'error');
			return;
		}
		
		if(f.M_UPLOAD == '' || f.T_UPLOAD == '') {
			swal('경매등록오류', '사진은 필수사항입니다.', 'error');
			return;
		}
		
		if(f.PROD_CATE_NUM == '') {
			swal('경매등록오류', '상품카테고리를 선택해주세요', 'error');
			return;
		}
		
		if(f.AUC_TYPE_NUM == '') {
			swal('경매등록오류', '경매유형을 선택해주세요', 'error');
			return;
		}
		
		if(f.AUC_PROD_NM == '') {
			swal('경매등록오류', '등록 상품명을 입력해주세요', 'error');
			return;
		}
		
		if(f.SHORT_CONT == '') {
			swal('경매등록오류', '등록 상품 설명을 입력해주세요', 'error');
			return;
		}
		
		if(f.START_PRICE == '') {
			swal('경매등록오류', '시작가를 천원단위로 입력해주세요', 'error');
			return;
		}
		
		if(f.QTY == '') {
			swal('경매등록오류', '등록 상품 수량을 입력해주세요', 'error');
			return;
		}
		
		var sDate = Date.parse(f.START_DTIME);
		var eDate = Date.parse(f.END_DTIME);
		
		var currentTimt = new Date();
		currentTimt.setDate(7);
		if(sDate > currentTimt) {
			swal('경매등록오류', '시작시간은 1주일 이후로 등록가능합니다.', 'error');
			return;
		}
		
		if(sDate >= eDate) {
			swal('경매등록오류', '시작시간은 종료일 보다 클수 없습니다.', 'error');
			return;
		}
		
		f.submit();
	});
	
	$('.form_datetime1').datetimepicker({
		format: 'yyyy-mm-dd hh:ii',
	    language:  'ko',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
	    showMeridian: 1
	});
	$('.form_datetime2').datetimepicker({
		format: 'yyyy-mm-dd hh:ii',			
	    language:  'ko',
	    weekStart: 1,
	    todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		forceParse: 0,
	    showMeridian: 1
	});	
	
	function getCategoryThird(categoryNum) {
		$.ajax(
			 {
		 		type: 'get',
		 		data: 'PROD_CATE_NUM='+categoryNum.value,
				url: '${contextPath}${pathList['12'].PATH}${pathList['12'].PATH_NM}',
		 		success: function(result) {
		 			var cate = $("#PROD_CATE_NUM");
		 			cate.find('option').remove();
		 			$.each(result.lowerCateVO, function(index) {
		 				$("#PROD_CATE_NUM").append($("<option>",{
	                  		value: result.lowerCateVO[index].PROD_CATE_NUM,
	                  		text: result.lowerCateVO[index].PROD_CATE_NM
	            		}));
		 			});
		 			
		 			$('#PROD_CATE_NUM').on('change', function (e) {
		 				$('#PROD_CATE').val(this.selected.val);
		 			});
	    		}
			}
		);
	}
	
	function getCategorySecond(categoryNum) {
		$.ajax(
			 {
		 		type: 'get',
				url: '${contextPath}${pathList['12'].PATH}${pathList['12'].PATH_NM}',
				data: 'PROD_CATE_NUM='+categoryNum.value,
		 		success: function(result) {
	 				var cate = $("#PROD_CATE_NUM_SECOND");
	 				cate.find('option').remove();
		 			$.each(result.lowerCateVO, function(index) {
		 				$("#PROD_CATE_NUM_SECOND").append($("<option>",{
	                  		value: result.lowerCateVO[index].PROD_CATE_NUM,
	                  		text: result.lowerCateVO[index].PROD_CATE_NM
	            		}));
		 			});
		 			
		 			$("#PROD_CATE_NUM_SECOND").on("change", function(event) { 
		 				getCategoryThird(this);
		 			});
	 			}
			}
		);
	}
	
	function getCategory() {
	   // 경매 상품 카테고리 Select 표시 ajax로 가져온다.
	   var optionCount = $("#PROD_CATE_NUM_ROOT option").size();
	   if(optionCount < 1) {
	   		$.ajax(
				 {
			 		type: 'get',
					url: '${contextPath}${pathList['12'].PATH}${pathList['12'].PATH_NM}',
			 		success: function(result) {
		 				var cate = $("#PROD_CATE_NUM_ROOT");
			 			$.each(result.lowerCateVO, function(index) {
			 				$("#PROD_CATE_NUM_ROOT").append($("<option>",{
		                  		value: result.lowerCateVO[index].PROD_CATE_NUM,
		                  		text: result.lowerCateVO[index].PROD_CATE_NM
		            		}));
			 			});
			 			
			 			$("#PROD_CATE_NUM_ROOT").on("change", function(event) { 
			 				getCategorySecond(this);
			 			});
		 			}
				}
			);
	    }
   	    // 경매 유형 Select 표시 ajax로 가져온다.
   	    var optionCount = $("#AUC_TYPE_NUM option").size();
		   if(optionCount < 1) {
	   		$.ajax(
				 {
			 		type: 'get',
			 		url: '${contextPath}${pathList['11'].PATH}${pathList['11'].PATH_NM}',
			 		success: function(result) {
			 			var cate = $("#AUC_TYPE_NUM");
			 			var optionCount = $("#AUC_TYPE_NUM option").size();
			 			$.each(result.LIST, function(index) {
			 				$("#AUC_TYPE_NUM").append($("<option>",{
		                  		value: result.LIST[index].CD,
		                  		text: result.LIST[index].CATE_NM
		            		}));
			 			});
			 			$('#AUC_TYPE_NUM').on(
			 				{
			 					'change': function () {
			 						$('#AUC_TYPE').val(this.selected.val);
			 					}
			 				}
			 			);
		    		}
				}
			);
	   }
	}
</script>