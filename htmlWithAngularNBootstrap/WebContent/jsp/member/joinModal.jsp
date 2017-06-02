<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="joinFormModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header bg-danger">
        <h4 class="modal-title glyphicon glyphicon-thumbs-up" id="loginFormModalLabel">회원가입</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="memberJoinForm">
          <table class="table">
			<tbody>
				<tr>
					<td class="text-right"><h6>회원구분</h6></td>
		        	<td class="text-center">
		        		<div class="input-group" >
						  <h6 style="display:inline;">개인</h6>
						  <input type="radio" id="MEMB_CD" />
						  <h6 style="display:inline;">기업</h6>
						  <input type="radio" id="MEMB_CD"/>
		          		</div>
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>아이디</h6></td>
		        	<td class="text-center">
						<input type="text" class="input-sm col-sm-6" id="MEMB_ID" onchange="" required="required">
						<button type="button" class="btn btn-primary" onclick="checkDuplicate();">중복확인</button>
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>비밀번호</h6></td>
		        	<td class="text-center">
						<input type="password" class="input-sm col-sm-6" id="SEC_NUM" required="required">
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>비밀번호확인</h6></td>
		        	<td class="text-center">
						<input type="password" class="input-sm col-sm-6" id="CONFIRM_SEC_NUM" required="required">
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>프로필 사진</h6></td>
		        	<td class="text-center">
						<input class="input-sm col-sm-6" type="file"/>
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>이메일</h6></td>
		        	<td class="text-center">
						<input type="email" class="input-sm col-sm-6" id="EMAIL" required="required">
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>전화번호</h6></td>
		        	<td class="text-center">
						<input type="email" class="input-sm col-sm-6" id="TEL_NUM" required="required">
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>핸드폰번호</h6></td>
		        	<td class="text-center">
						<input type="email" class="input-sm col-sm-6" id="MOBIL_NUM" required="required">
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>우편번호</h6></td>
		        	<td class="text-center">
		        		<input type="text" class=" input-sm col-sm-4" id="ZIP_NUM" onchange="" required="required">
						<button type="button" class="btn btn-primary" onclick="">우편번호찾기</button>
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>주소</h6></td>
		        	<td class="text-center">
						<input type="email" class="input-sm col-sm-8" id="ADDRESS" required="required">
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>상세주소</h6></td>
		        	<td class="text-center">
						<input type="email" class="input-sm col-sm-8" id="DETA_ADDRESS" required="required">
		        	</td>
				</tr>
			</tbody>
		</table>
        </form>
      </div>
      
      <div class="modal-footer bg-danger">
        <button type="button" class="btn btn-primary" onclick="join();">회원가입</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>