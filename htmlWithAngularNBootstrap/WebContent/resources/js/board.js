/**
 * 보드의 모달 및 이벤트를 제어하기 위한 JS 구성
 */

// 모달 처리 작업

var qnaModal =  {
	// bootstrap의 div의 id를 보내준다.	
	showModal : function(divId) {
		$('#' + divId).modal('show');
	}, 
	
	disablechangeArray : [],
	
	setModifyQnaList : function(divId) {
		$('#'+divId).find("input");	
		console.log($('#'+divId).find("input"));
	}
}

