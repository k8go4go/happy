<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="anaFormModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
   <form id="boardModalForm" method="get" enctype="text/html">
    <div class="modal-content">
      <div class="modal-header bg-danger">
        <input type="text" class="modal-title" style="border: none;" id="TITLE" name="TITLE" disabled="disabled"/>
        <h5 class="modal-title glyphicon glyphicon-thumbs-up text-right" id="REVIEW_CNT"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
		<table class="table table-striped">
			<tbody>
				<tr>
				<td class="text-center"><small>글번호</small></td>
	        	<td class="text-center"><input type="text" style="border: none;" id="BOARD_NUM" name="BOARD_NUM" disabled="disabled"/></td>
				<td class="text-center"><small>답변상태</small></td>
	        	<td class="text-center"><input type="text" style="border: none;" id="CATE_NM" name="CATE_NM" disabled="disabled"/></td>
				</tr>
				<tr>
				<td class="text-center"><small>작성자</small></td>
	        	<td class="text-center"><input type="text" style="border: none;" id="WRITER_NM" name="WRITER_NM" disabled="disabled"/></td>
				<td class="text-center"><small>작성일</small></td>
	        	<td class="text-center"><input type="text" style="border: none;" id="WRITE_DATE" name="WRITE_DATE" disabled="disabled"/></td>
				</tr>
				<tr>
				<td class="text-center"><small>내용</small></td>
	        	<td colspan="3" class="text-center"><textarea style="resize: none; border: none;" id="CONT" name="CONT" rows="5" cols="60" disabled="disabled"></textarea></td>
				</tr>
			</tbody>
		</table>
      </div>
      <div class="modal-footer bg-danger">
        <button id="btnComplete" type="submit" class="btn btn-secondary" style="display: none;" data-dismiss="modal" onclick="completeModify();" >수정완료</button>
        <button id="btnCancel" type="button" class="btn btn-secondary" style="display: none;" onclick="cancelModify();">취소</button>
        
        <button id="btnModify" type="button" class="btn btn-secondary" style="display: inline-block;" onclick="changeDisable();">수정하기</button>
        <button id="btnClose" type="button" class="btn btn-secondary" style="display: inline-block;" data-dismiss="modal">닫기</button>
      </div>
    </div>
    </form>
  </div>
</div>