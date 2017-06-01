<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="loginFormModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm" >
    <div class="modal-content">
      <div class="modal-header bg-danger">
        <h4 class="modal-title glyphicon glyphicon-thumbs-up" id="loginFormModalLabel">로그인</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="MEMB_ID" class="form-control-label">아이디:</label>
            <input type="text" class="form-control" id="MEMB_ID">
          </div>
          <div class="form-group">
            <label for="SEC_NUM" class="form-control-label">패스워드:</label>
            <input type="password" class="form-control" id="SEC_NUM">
          </div>
        </form>
      </div>
      <div class="modal-footer bg-danger">
        <button type="button" class="btn btn-primary" onclick="login();">로그인</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>