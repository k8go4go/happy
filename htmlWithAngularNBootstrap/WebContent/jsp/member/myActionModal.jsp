<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="myAuctionFormModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" >
    <div class="modal-content">
      <div class="modal-header bg-danger">
        <h4 class="modal-title glyphicon glyphicon-thumbs-up" id="loginFormModalLabel">My Auction</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
			<div class="btn-group" role="group" aria-label="...">
				<button type="button" class="btn btn-default">나의경매이력</button>
				<button type="button" class="btn btn-default">Middle</button>
				<button type="button" class="btn btn-default">Right</button>
			</div>
		  </div>
          
          <div class="form-group">
	          <label class="glyphicon glyphicon-user">아이디</label>
	          <div class="input-group" >
	          	  <span class="input-group-addon" id="addon2"></span>
	              <input type="text" class="form-control" id="MEMB_ID" aria-describedby="addon2" required="required">
	          	  <span class="input-group-addon" id="addon2"></span>
	          
	          	  <input class="form-control" type="file"/>
	          </div>
          </div>
          
          <div class="form-group">
	          <label class="glyphicon glyphicon-qrcode">비밀번호</label>
	          <div class="input-group" >
	            <span class="input-group-addon" id="addon3"></span>
	            <input type="password" class="form-control" id="SEC_NUM" aria-describedby="addon3" required="required">
	            <span class="input-group-addon" id="addon3"></span>
	          </div>
	      </div>
	      
	       <div class="form-group">
	          <label class="glyphicon glyphicon-barcode">비밀번호 확인</label>    
	          <div class="input-group" >
	            <span class="input-group-addon" id="addon4"></span>
	            <input type="password" class="form-control" id="SEC_NUM_CONFIRM" aria-describedby="addon4" required="required">
	            <span class="input-group-addon" id="addon4"></span>
	          </div>
	      </div>
	      
	      <div class="form-group">
	          <label class="glyphicon glyphicon-envelope">이메일</label>      
	          <div class="input-group" >
	            <span class="input-group-addon" id="addon5"></span>
	            <input type="email" class="form-control" id="EMAIL" aria-describedby="addon5" required="required">
	            <span class="input-group-addon" id="addon5"></span>
	          </div>
	      </div>
	      
          <div class="form-group">
	          <label class="glyphicon glyphicon-phone-alt">전화번호</label>
	          <div class="input-group" >
	            <span class="input-group-addon" id="addon6"></span>
	            <input type="text" class="form-control" id="TEL_NUM" aria-describedby="addon6" required="required">
	            <span class="input-group-addon" id="addon6"></span>
	          </div>
	      </div>
	      
	      <div class="form-group">
	          <label class="glyphicon glyphicon-phone">핸드폰번호</label>    
	          <div class="input-group" >
	            <span class="input-group-addon" id="addon7"></span>
	            <input type="text" class="form-control" id="MOBIL_NUM" aria-describedby="addon7" required="required">
	            <span class="input-group-addon" id="addon7"></span>
	          </div>
	      </div>
	      
	      <div class="form-group">
	          <label class="glyphicon glyphicon-bookmark">우편번호</label>    
	          <div class="input-group" >
	            <span class="input-group-addon" id="addon8"></span>
	            <input type="text" class="form-control" id="ZIP_NUM" aria-describedby="addon8" required="required">
	            <span class="input-group-addon" id="addon8"></span>
	            <span class="input-group-btn">
	        		<button class="btn btn-default" type="button">우편번호</button>
	      		</span>
	          </div>
          </div>
          
          <div class="form-group">
	          <label class="glyphicon glyphicon-home">주소</label> 
	          <div class="input-group" >
	            <span class="input-group-addon" id="addon9"></span>
	            <input type="text" class="form-control" id="ADDRESS" aria-describedby="addon9">
	            <span class="input-group-addon" id="addon9"></span>
	          </div>
          </div>
          
          <div class="form-group">
	          <label class="glyphicon glyphicon-home">상세주소</label> 
	          <div class="input-group" >
	            <span class="input-group-addon" id="addon10"></span>
	            <input type="text" class="form-control" id="DETA_ADDRESS" aria-describedby="addon10" required="required">
	            <span class="input-group-addon" id="addon10"></span>
	          </div>
	      </div>    
        </form>
      </div>
      
      <div class="modal-footer bg-danger">
        <button type="button" class="btn btn-primary">로그인</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
      </div>
    </div>
  </div>
</div>