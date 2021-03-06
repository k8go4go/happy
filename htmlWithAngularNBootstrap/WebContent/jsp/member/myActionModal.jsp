<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="modal fade" id="myAuctionFormModal" tabindex="-1" role="dialog" 
				aria-labelledby="myAuctionFormModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-danger">
				<h4 class="modal-title glyphicon glyphicon-thumbs-up"
					id="myAuctionFormModalLabel">My Auction</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
			<div class="table-responsive">
				<ul class="nav nav-tabs" role="tablist">				
				  <li class="nav-item">
				    <a class="nav-link active" data-toggle="tab" href="#myinfo" role="tab">회원정보</a>
				  </li>
				  <li class="nav-item">
				    <a id='myBiddingHistory' class="nav-link" data-toggle="tab" href="#myBiddingHistoryForm" role="tab">입찰정보</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" data-toggle="tab" href="#mySBidForm" role="tab">낙찰정보</a>
				  </li>				  
				</ul>
				<div class="tab-content">
				<form id="myinfo" name="myinfo" class="tab-pane active" role="tabpanel" enctype="multipart/form-data">
					<table class="table" id='memberInfoHeaderTable'>
					<tbody>
						<tr>
							<td class="text-right col-sm-2"><h6>경매등록정보</h6></td>
							<td class="text-left col-sm-10">
								<button id='doRegAuc' type="button" class="btn btn-primary">경매등록정보</button>
							</td>
						</tr>
						<tr>
							<td class="text-right col-sm-2"><h6>회원구분</h6></td>
							<td class="text-left col-sm-10">
								<c:choose>
								<c:when test="${user.MEMB_CD eq '2001' }">
									<h6 style="display:inline;" >개인</h6>
									<input type="radio" id="MEMB_CD" class="input-sm" name="MEMB_CD" checked="checked" value="${user.MEMB_CD}"/>
								</c:when>
								<c:otherwise>
									<h6 style="display:inline;">기업</h6>
									<input type="radio" id="MEMB_CD" class="input-sm" name="MEMB_CD" checked="checked" value="${user.MEMB_CD}"/>
								</c:otherwise>
								</c:choose>
								<h6 style="display:inline;">사진업로드</h6>
								<input style="display:inline;" id="UPLOADFILE" name="UPLOADFILE" class="input-sm" type="file" onchange="readURL(this, 'previewProfile');" required/>
							</td>
						</tr>
						<tr>
							<td class="text-right col-sm-2" rowspan="3"><h6>프로필</h6></td>
							<td class="text-left col-sm-10" rowspan="3">
								<c:choose>
								<c:when test="${not empty user.USR_FILE}">
									<img id="previewProfile" width='150px;' height='200px;' src='<c:url value="/profile/image/${user.USR_FILE.REAL_NM}" />' />
								</c:when>
								<c:otherwise>
									<img id="previewProfile"  width='150px;' height='200px;' src='data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9InllcyI/PjxzdmcgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB3aWR0aD0iMjQyIiBoZWlnaHQ9IjIwMCIgdmlld0JveD0iMCAwIDI0MiAyMDAiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPjwhLS0KU291cmNlIFVSTDogaG9sZGVyLmpzLzEwMCV4MjAwCkNyZWF0ZWQgd2l0aCBIb2xkZXIuanMgMi42LjAuCkxlYXJuIG1vcmUgYXQgaHR0cDovL2hvbGRlcmpzLmNvbQooYykgMjAxMi0yMDE1IEl2YW4gTWFsb3BpbnNreSAtIGh0dHA6Ly9pbXNreS5jbwotLT48ZGVmcz48c3R5bGUgdHlwZT0idGV4dC9jc3MiPjwhW0NEQVRBWyNob2xkZXJfMTVjNjlkMGM1ZDIgdGV4dCB7IGZpbGw6I0FBQUFBQTtmb250LXdlaWdodDpib2xkO2ZvbnQtZmFtaWx5OkFyaWFsLCBIZWx2ZXRpY2EsIE9wZW4gU2Fucywgc2Fucy1zZXJpZiwgbW9ub3NwYWNlO2ZvbnQtc2l6ZToxMnB0IH0gXV0+PC9zdHlsZT48L2RlZnM+PGcgaWQ9ImhvbGRlcl8xNWM2OWQwYzVkMiI+PHJlY3Qgd2lkdGg9IjI0MiIgaGVpZ2h0PSIyMDAiIGZpbGw9IiNFRUVFRUUiLz48Zz48dGV4dCB4PSI4OS44NTAwMDAzODE0Njk3MyIgeT0iMTA1LjciPjI0MngyMDA8L3RleHQ+PC9nPjwvZz48L3N2Zz4=' />
								</c:otherwise>
								</c:choose>
							</td>
						</tr>
						<tr></tr><tr></tr>
					</tbody>
					</table>
					<c:choose>
					<c:when test="${user.MEMB_CD eq '2001' }">
					<table class="table" id='memberInfoPriHeaderTable' >
						<tbody>
						<tr>
							<td class="text-right col-sm-2"><h6>이름</h6></td>
							<td class="text-right col-sm-4">
								<input type="text"
									class="input-sm col-sm-10" name="NM" id="NM" value="<c:out value="${user.NM}"/>" />
							</td>
							<td class="text-right col-sm-2"><h6>주민등록번호</h6></td>
							<td class="text-right col-sm-4">
								<input type="text"
									class="input-sm col-sm-10" name="SOC_REG_NUM" id="SOC_REG_NUM" value="<c:out value="${user.SOC_REG_NUM}"/>" />
							</td>
						</tr>
						</tbody>
					</table>
					</c:when>
					<c:otherwise>
					<table class="table" id='memberInfoComHeaderTable'>
						<tbody>
						<tr>
							<td class="text-right col-sm-2"><h6>회사명</h6></td>
							<td class="text-right col-sm-4"><input class="input-sm col-sm-10" type="text" name="CORP_NM"
								id="CORP_NM"  value="<c:out value="${user.CORP_NM}"/>" /></td>
							<td class="text-right col-sm-2"><h6>사업자등록번호</h6></td>
							<td class="text-right col-sm-4"><input class="input-sm col-sm-10" type="text" name="BUS_NUM"
								id="BUS_NUM"  value="<c:out value="${user.BUS_NUM}"/>" /></td>
						</tr>
						<tr>
							<td class="text-right col-sm-2"><h6>대표자명</h6></td>
							<td class="text-right col-sm-4"><input class="input-sm col-sm-10" type="text" name="CEO_NM"
								id="CEO_NM"  value="<c:out value="${user.CEO_NM}"/>" /></td>
							<td class="text-right col-sm-2"><h6>담당자명</h6></td>
							<td class="text-right col-sm-4"><input class="input-sm col-sm-10" type="text" name="CHGR_NM"
								id="CHGR_NM" value="<c:out value="${user.CHGR_NM}" />" /></td>
						</tr>
						</tbody>
					</table>
					</c:otherwise>
					</c:choose>
					<table class="table" id='memberInfoCommonHeaderTable'>
						<tbody>							
							<tr>
								<td class="text-right"><h6>아이디</h6></td>
								<td class="text-center"><input type="text"
									class="input-sm col-sm-6" name="MEMB_ID" id="MEMB_ID" value="<c:out value="${user.MEMB_ID}" />"
									 />
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>비밀번호</h6></td>
								<td class="text-center"><input type="password"
									class="input-sm col-sm-6" id="SEC_NUM" name="SEC_NUM" value="<c:out value="${user.SEC_NUM}" />"
									 />
									<button type="button" class="btn btn-primary"
										onclick="changePassword();">비밀번호변경</button>
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>이메일</h6></td>
								<td class="text-center">
									<input type="text"
									class="input-sm col-sm-2" id="EMAIL" required value="testtest" name="EMAIL" value="<c:out value="${user.EMAIL}"/>" />
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>전화번호</h6></td>
								<td class="text-center"><input type="email"
									class="input-sm col-sm-6" id="TEL_NUM" name="TEL_NUM"  required value="<c:out value="${user.TEL_NUM}"/>" />
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>핸드폰번호</h6></td>
								<td class="text-center"><input type="email"
									class="input-sm col-sm-6" id="MOBIL_NUM" name="MOBIL_NUM" required value="<c:out value="${user.MOBIL_NUM}"/>" />
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>우편번호</h6></td>
								<td class="text-center"><input type="text"
									class=" input-sm col-sm-4" id="ZIP_NUM" name="ZIP_NUM" 
									 value="<c:out value="${user.ZIP_NUM}"/>" />
									<button type="button" class="btn btn-primary" onclick="zipSearch();">우편번호변경</button>
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>주소</h6></td>
								<td class="text-center"><input type="email" name="ADDRESS" 
									class="input-sm col-sm-8" id="ADDRESS"  value="<c:out value="${user.ADDRESS}"/>" />
								</td>
							</tr>
							<tr>
								<td class="text-right"><h6>상세주소</h6></td>
								<td class="text-center"><input type="email" name="DETA_ADDRESS" 
									class="input-sm col-sm-8" id="DETA_ADDRESS"  value="<c:out value="${user.DETA_ADDRESS}"/>" />
								</td>
							</tr>
						</tbody>
					</table>
					<div class="modal-footer bg-danger">
						<button id='modifyUser' type="button" class="btn btn-primary">수정하기</button>						
					</div>
				</form>
				<form id="myBiddingHistoryForm" name="myBiddingHistoryForm" class="tab-pane" role="tabpane3">
					<table class="table" id='biddingHistoryTable' >
						<thead>
							<tr>
								<th class="text-right col-sm-1"><small>번호</small></th>
								<th class="text-right col-sm-3"><small>경매상품명</small></th>
								<th class="text-right col-sm-2"><small>시작일자</small></th>
								<th class="text-right col-sm-2"><small>종료일자</small></th>
								<th class="text-right col-sm-2"><small>입찰가</small></th>
								<th class="text-right col-sm-2"><small>입찰일자</small></th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</form>
				<form id="mySBidForm" name="mySBidForm" class="tab-pane" role="tabpane3">
					<table class="table" id='mySBidTable' >
						<tbody>
						<tr>
							<td class="text-right col-sm-2"><h6>낙찰번호</h6></td>
							<td class="text-right col-sm-4"></td>
							<td class="text-right col-sm-2"><h6>낙찰금액</h6></td>
							<td class="text-right col-sm-4"></td>
						</tr>
						</tbody>
					</table>
				</form>
			</div>
			</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	function dateFormat(date){
	  //2016/12/28
	  //string
	  //return에 '/' 부분을 마음대로 바꿀 수 있음
	  var year = date.getFullYear();
	  var month = (1 + date.getMonth()); // month는 0부터시작함.
	  month = month >= 10 ? month : '0' + month; // 두자리수 맞춰줌
	  var day = date.getDate();
	  day = day >= 10 ? day : '0' + day; // 두자리 수 맞춰줌

	  return  year + '/' + month + '/' + day;
	}
	
	$('#myBiddingHistory').on('click', function(){
		console.log('check');			
		$.ajax(
			 {
		 		type: 'get',
				url: '${contextPath}${pathList['32'].PATH}${pathList['32'].PATH_NM}',
		 		success: function(result) {
		 			if(result.result) {
		 				swal("입찰내역 정보", "입찰내역 정보가 없습니다.", "error");
		 				$('#biddingHistoryTable > tbody > tr').remove();
		 				var emptyTr = "<tr><td class='text-right'>입찰내역 정보가 없습니다.</td></tr>" 
		 				$('#biddingHistoryTable > tbody').html(emptyTr);
		 			} else {
		 				if(result.length > 0) {
		 					$('#biddingHistoryTable > tbody > tr').remove();
		 					var tag;
							for(var i=0; i < result.length; i++) {
								tag += '<tr>';
								tag += '<td class="text-right"><small>'+result[i].BID_PRICE_REG_NUM+'</small></td>';
								tag += '<td class="text-right"><small>'+result[i].AUC_PROD_NM+'</small></td>';
								tag += '<td class="text-right"><small>'+dateFormat(new Date(result[i].START_DTIME))+'</small></td>';
								tag += '<td class="text-right"><small>'+dateFormat(new Date(result[i].END_DTIME))+'</small></td>';
								tag += '<td class="text-right"><small>'+result[i].BID_PRICE+'</small></td>';
								tag += '<td class="text-right"><small>'+dateFormat(new Date(result[i].BID_DTIME))+'</small></td>';
								tag += '</tr>';
							}
		 					$('#biddingHistoryTable > tbody').html(tag);
		 				}
		 			}
	    		},
	    		error: function(result) {
	    			swal("사용자정보변경", "서버 오류입니다.", "error");
	    		}
			}
		);
	});

	$('#doRegAuc').on('click', function () {
		location.href = '${contextPath}${pathList['16'].PATH}${pathList['16'].PATH_NM}'; 
	});
	
	$('#modifyUser').on('click', function() {
		var myinfo = $('#myinfo')[0];
		var datas = new FormData(myinfo);
		 $.ajax(
			 {
		 		type: 'post',
		 		enctype: 'multipart/form-data',
				url: '${contextPath}${pathList['15'].PATH}${pathList['15'].PATH_NM}',
				data: datas ,
				processData: false,
				contentType: false,
		 		success: function(result) {
		 			swal("사용자정보변경", result.msg, "success");
	    		},
	    		error: function(result) {
	    			swal("사용자정보변경", "서버 오류입니다.", "error");
	    		}
			}
		);
	});
	
	$('#logout').on('click', function(e) {
		location.href = '${contextPath}${pathList['14'].PATH}${pathList['14'].PATH_NM}';
	}) 
</script>