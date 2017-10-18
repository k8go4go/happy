// 기본적인 파라미터를 처리한다.
var ParamLoder = {	
	media : '', // 미디어
	publisher : '', // 퍼블러셔
	search : '', // 검색어
	exclude : '', // 제외식
	filter : '', // 필터식
	select : '', // 조건식
	hashtag : '', // 해시태그식
	category : '', // 카테고리
	relatedword : '', // 1차 연관어
	relatedword2 : '', // 2차 연관어
	rt : '', // rt 유무
	from : '', // 검색 시작일
	to : '', // 검색 종료일
	size : 10,
	offset : 2,
		
	// 기본적인 검색에서 요청할 파라미터집합
	getBasicRequestParam : function(){
		this.media = this.getMediaValue();
		this.publisher = this.getPublisherValue();
		this.search = $(".searchArea .searchBox input").text();
		this.exclude = ""; // 제외식
		this.filter = ""; // 필터식
		this.select = ""; // 조건식
		this.hashtag = ""; // 해시태그식
		this.category = ""; // 카테고리
		this.relatedword = ""; // 1차 연관어
		this.relatedword2 = ""; // 2차 연관어
		this.rt = ""; // rt 유무
		this.from =$(".searchArea span.fromArea").text().replace(/\/|\.|-/g , '') ; // 검색 시작일
		this.to = $(".searchArea span.toArea").text().replace(/\/|\.|-/g , '') ;// 검색 종료일
		return {
			media:this.media,
			publisher:this.publisher,
			search:this.search,
			exclude : this.exclude,
			filter : this.filter,
			select : this.select,
			hashtag : this.hashtag,
			category : this.category,
			relatedword : this.relatedword, // 1차 선택 연관어
			relatedword2 : this.relatedword2, // 2차 선택 연관어
			from : this.from,
			to:this.to,
			size : this.size,
			offset : this.offset,
			rt : this.rt
		}	
	},
	
	// 상단 미디어 선택 값을 가져온다.
	getMediaValue : function(){
		returnMedia = "";
		$(".searchArea .media input").each(function(){
			var tempId = "";
			if($(this).prop("checked") ){
				tempId = $(this).prop("id");
				if('mediaAll' == tempId){
					returnMedia = "ct_all_2";
					return false;
				}else if('mediaMass' == tempId){  // 메스미디어
					returnMedia += "ct_mm "; // 구분자역활의 공백이다.
				}else if('mediaTwitter' == tempId){  // 트위터
					returnMedia += "ct_tt "; // 구분자역활의 공백이다.
				}else if('mediaFace' == tempId){// 페이스북
					returnMedia += "ct_fb "; // 구분자역활의 공백이다.
				}else if('mediaInsta' == tempId){ // 인스타그램
					returnMedia += "ct_in "; // 구분자역활의 공백이다.
				}else if('mediaBlog' == tempId){ // 블로그
					returnMedia += "ct_bg "; // 구분자역활의 공백이다.
				}else if('mediaComm' == tempId){ // 커뮤니티
					returnMedia += "ct_cm "; // 구분자역활의 공백이다.
				}		
			} 
		});	
		return returnMedia;
	},
	
	// 분석채널 선택부분
	getPublisherValue : function(){
		var publisher =$(".searchArea .media .channel a span").text();
		if(publisher.indexOf('기업') != -1 ) publisher = 'E';
		else if(publisher.indexOf('소비자') != -1) publisher = 'C';
		else if(publisher.indexOf('Third')!= -1 ) publisher = 'T';
		else publisher = 'A';
		return publisher;
	},

	
};
// 유저, 세션, 로그인, 메뉴 관련된 사항
var UserUtil = {
	// 상단 대시보드 유저별로 가져오기
	// menuId : 메뉴아이디
	getDashBoardMenu : function(menuId){
		$.ajax({
			url : "/user/getDashboard",
			dataType : "json",
			data : {menuId:menuId},
			cache : false,
			success : function(data){
				$.each(data, function(){
					alert(this.dashboardNm);
					
				});
			
			},
			error:function(request, status, error){
				alert("서버 오류입니다. 관리자에게 문의바랍니다.");
			}
		});
	}
};
// 메뉴 이동관련 
var menuUtil = {
	surl : location.href.split("?")[0],
	// 대시보드를 선택한이벤트 dashBoardId : 대시보드id
	goDashBoard : function(dashBoardId){
		location.href=this.surl+"?dashBoardId="+dashBoardId;
	},
	
	// 상단 좌측 대메뉴를 선택한 경우 urlName : 이동주소 menuId : 대메뉴Id
	goRootMenu : function(urlName,menuId){
		location.href=urlName+"?&menuId="+menuId;		
	} 


};


var ComUtil = {
	//콤마로 3자리마다 구분자를 넣는 숫자 포맷
	formatNumber : function(number){
	  var reg = /(^[+-]?\d+)(\d{3})/;   // 정규식
	  number += '';                     // 숫자를 문자열로 변환
	  while (reg.test(number))
	  number = number.replace(reg, '$1' + ',' + '$2');
	  return number;
	},
	// 콤마제거 delimiter : 구분자
	removeComma : function(number , delimiter){  // 콤마제거
		if(delimiter ==undefined){
			delimiter = ",";
		}
	    if ( number == undefined || number == null || number == "" ) {
	        return "";
	    }
	    var txtNumber = '' + number;
		
	    return txtNumber.replace(/(,)/g, "");
	},
	// 배열 중복제거
	dupArr : function(arr){
		for(var i=0; i<arr.length; i++) {
	        var checkDobl = 0;
	        for(var j=0; j<arr.length; j++) {
	            if(arr[i] != arr[j]) {
	                continue;
	            } else {
	                checkDobl++;
	                if(checkDobl>1){
	                    spliced = arr.splice(j,1);
	                }
	            }
	        }
	    }
	    return arr;
	},
	// 잠시멈춤
	sleep : function sleep(num){	//[1/1000초]
		var now = new Date();
		var stop = now.getTime() + num;
	    while(true){
		   now = new Date();
		   if(now.getTime() > stop)return;
		}
	},
	// 숫자인지 판단
	isNumber : function(str) {
	  str += ''; // 문자열로 변환
	  str = str.replace(/^\s*|\s*$/g, ''); // 좌우 공백 제거
	  if (str == '' || isNaN(str)) return false;
	  return true;
	},
	// 숫자만 추출
	getNumberOnly : function(str){
		var val = str.value;
	    val = new String(val);
	    var regex = /[^0-9]/g;
	    val = val.replace(regex, '');
	    return val;
	},
	
	// 엑셀 다운로드 table 태그 존재하는 경우만
	// 테이블영역 존재하는 div 태그 id
	// 엑셀저장 파일 이름
	exportExcelTable : function(id){
		var ee = excelExport(id).parseToCSV().parseToXLS("excelexport sheet");
		location.href = ee.getXLSDataURI();
	}
	
}
