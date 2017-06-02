<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="writeFormModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
   <form name="boardWriteModalForm" method="post" >
   	<input type="hidden"  id="writeWMEMB_NUM" name="MEMB_NUM" />
    <div class="modal-content">
      <div class="modal-header bg-danger">
      	<h4 class="modal-title glyphicon glyphicon-thumbs-up text-right" >글쓰기</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>            
      </div>
      <div class="modal-body">
		<table class="table ">
			<tbody>
				<tr>
				<td class="text-center"><small>작성자</small></td>
	        	<td class="text-center"><input type="text"  id="writeWRITER_NM" name="WRITER_NM" /></td>
				<td class="text-center"><small>제목</small></td>
	        	<td class="text-center"><input type="text"  id="writeTITLE" name="TITLE" /></td>
				</tr>
				<tr>
				<td class="text-center"><small>내용</small></td>
	        	<td colspan="3" class="text-center"><textarea style="resize: none;" id="writeCONT" name="CONT" rows="5" cols="60" ></textarea></td>
				</tr>
			</tbody>
		</table>
      </div>
      <div class="modal-footer bg-danger">
        <button id="btnWrite" type="button" class="btn btn-secondary" style="display: inline-block;" onclick="completeWrite();">완료</button>
        <button id="btnWriteClose" type="button" class="btn btn-secondary" style="display: inline-block;" data-dismiss="modal">닫기</button>
      </div>
    </div>
    </form>
  </div>
</div>