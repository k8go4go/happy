<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="loginFormModal" tabindex="-1" role="dialog" aria-labelledby="loginFormModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm" >
    <div class="modal-content">
      <div class="modal-header bg-danger">
        <h4 class="modal-title glyphicon glyphicon-thumbs-up" id="loginFormModalLabel">로그인</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form name="loginForm" method="post">
           <table class="table">
			<tbody>
				<tr>
					<td class="text-right"><h6>회원구분</h6></td>
		        	<td class="text-center">
		        		<div class="btn-group" role="group" >
						  <h6 style="display:inline;" >개인</h6>
						  <input type="radio" id="MEMB_CD" name="MEMB_CD" checked="checked" value="2001" onclick="memb_cd();"/>
						  <h6 style="display:inline;">기업</h6>
						  <input type="radio" id="MEMB_CD" name="MEMB_CD" value="2002" onclick="memb_cd();"/>
		          		</div>
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>아이디</h6></td>
		        	<td class="text-center">
						<input type="text" class="input-sm col-sm-10" id="MEMB_ID" name="MEMB_ID"  value="test1234" required>
		        	</td>
				</tr>
				<tr>
					<td class="text-right"><h6>비밀번호</h6></td>
		        	<td class="text-center">
						<input type="password" class="input-sm col-sm-10" id="SEC_NUM" name="SEC_NUM" value="testtest!1" required>
		        	</td>
				</tr>
			  </tbody>
			</table>
        </form>
      </div>
      <div class="modal-footer bg-danger">
        <button type="button" class="btn btn-primary" onclick="login();">로그인</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>
<script>
	var login = function (index) {
		var frm = document.loginForm;
		frm.action = '${contextPath}${pathList['8'].PATH}${pathList['8'].PATH_NM}';
		frm.submit();
	}
</script>