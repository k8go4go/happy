<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="anaFormModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header bg-danger">
        <h4 class="modal-title glyphicon glyphicon-thumbs-up" id="qnaTitle"></h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          <div class="form-group">
            <label for="BOARD_NUM" class="form-control-label">글번호</label>
            <div id="BOARD_NUM"></div><kbd><div id="CATE_NM"></div></kbd>
          </div>
          <div class="form-group">
            <label for="WRITER_NM" class="form-control-label">작성자</label>
            <div id="WRITER_NM"></div>
          </div>
          <div class="form-group">
            <label for="WRITE_DATE" class="form-control-label">작성일</label>
            <div id="WRITE_DATE"></div>
          </div>
          <div class="form-group">
            <label for="CONT" class="form-control-label">내용</label>
            <div id="CONT"></div>
          </div>
          <div class="form-group">
            <label for="REVIEW_CNT" class="form-control-label">조회수</label>
            <kbd><div id="REVIEW_CNT"></div></kbd>
          </div>
      </div>
      <div class="modal-footer bg-danger">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>