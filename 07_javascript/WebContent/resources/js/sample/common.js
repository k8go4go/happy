/**
 * 여러 페이지에서 사용 할 JAVASCRIPT 함수 
 */
	/**
	 * GET방식 파라미터 획득
	 *
	 * return : getParam("paramKeyName") 형태로 GET방식 파라미터 리턴 by 김정현
	 */
	var getParam = function(key){
	    var _parammap = {};
	    document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
	        function decode(s) {
	            return decodeURIComponent(s.split("+").join(" "));
	        }
	
	        _parammap[decode(arguments[1])] = decode(arguments[2]);
	    });
	
	    return _parammap[key];
	};
	
	/**
	 * 북카트 카운트를 Header.jsp 에 삽입 @서윤형
	 *
	 * return : 북카트의 개수를 (카운트) 형태로 return
	 */
	function getBookCartCount(){
		$.ajax({
			url : "/cart/getCartCountAjax",
			dataType : "json",
			cache : false,
			success : function(responseData){
				$("#cartCount").html("("+ responseData.cartCount +")")
			},
			error:function(request, status, error){
				alert("서버 오류입니다. 관리자에게 문의바랍니다.");
			}
		});
	}
	
	/** 
	 * 관심도서 추가 @서윤형
	 * 
	 * @param goodsNo : goodsDetailNo
	 */
	function setFavorite(goodsNo){
		$.ajax({
			type : "post",
			cache : false,
			url : "/mypage/setFavoriteAjax",
			data : "&goodsDetailNo="+goodsNo,
			dataType : "json",
			success : function(responseData){
				if(responseData.errorCode == 0){
					if(responseData.resultCount == 0){
						$("#f"+goodsNo).removeClass("btn_wish");
						$("#f"+goodsNo).removeClass("btn_wish_on");
						$("#f"+goodsNo).addClass("btn_wish");
					}else{
						$("#f"+goodsNo).removeClass("btn_wish");
						$("#f"+goodsNo).removeClass("btn_wish_on");
						$("#f"+goodsNo).addClass("btn_wish_on");
					}
				}else{
					alert("로그인 후 이용가능합니다.");
					return;
				}
			},
			error:function(request, status, error){
				alert("서버 오류입니다. 관리자에게 문의바랍니다.");
			}
		});
	}

	/**
	 * 날짜 더하기 빼기 @서윤형
	 * 
	 * @param calDate : 더 하거나 뺄 일 수 
	 * return : 날짜에서 calDate만큼 더하거나 뺀 후 yyyy-mm-dd 형태로 return
	 */
	function calculateDate(calDate){
		var tempDate = new Date();
		tempDate.setDate(tempDate.getDate()+calDate);
		
		var year = tempDate.getFullYear();
		var month = tempDate.getMonth() + 1;
		var date = tempDate.getDate();
		
		return year + "-" + (month < 10 ? "0"+month : month) +"-"+ (date < 10 ? "0"+date : date); 	
	}
	
	/**
	 * 상품 판매 유형에 따라 detail 페이지 선정하여 이동
	 * 
	 * @param goodsType : 상품 판매 유형(L : 단품, P : 패키지, S : 시리즈, Y : 연재)
	 * @param goodsDetailNo : 상품판매번호
	 */
	function getBookDetail(goodsType, goodsDetailNo, cateDepth1, cateDepth2, cateDepth3, cateDepth4){
		var url;
		url = "/product/detail?cateDepth1="+cateDepth1+"&cateDepth2="+cateDepth2+"&cateDepth3="+cateDepth3+"&cateDepth4="+cateDepth4+"&goodsDetailNo="+goodsDetailNo+"&goodsType="+goodsType;
		location.href = url;
	}
	
	/**
	 * 원화단위로 콤마찍기(1000단위)
	 * 
	 * @param price 금액 숫자
	 * return : 원화단위로 콤마 찍은 텍스트 리턴
	 */ 
	function getPriceNumber(price){
		n =price;
		if(isNaN(n)){return 0;}
		var reg = /(^[+-]?\d+)(\d{3})/;
		n+='';
		while(reg.test(n))
		n = n.replace(reg, '$1' + ',' + '$2');
		price = n;
		return price;
	}
	
	
	/**
	 * div.pop_layer > wrap_pop 형식의 레이어 팝업을 사용하기 쉽게 변경한 함수
	 * class 가 pop_layer 인 div 에 사용할 id 값을 준 후
	 * javascript 상에서 
	 * 
	 * $("#사용할id").layerShow(); 를 할 경우 layer open,
	 * $("#사용할id").layerhide(); 를 할 경우 layer close  
	 */
	$.fn.layerShow = function () {
		var layerId = $(this).attr("id");
		
		var temp = $(".wrap_pop");
		var bg = temp.prev().hasClass('bg');	//dimmed 레이어를 감지하기 위한 boolean 변수

		if(bg){
			$("#"+layerId).fadeIn();	//'bg' 클래스가 존재하면 레이어가 나타나고 배경은 dimmed 된다. 
		}else{
			temp.fadeIn();
		}

		// 화면의 중앙에 레이어를 띄운다.
		if (temp.outerHeight() < $(document).height() ) temp.css('margin-top', '-'+temp.outerHeight()/2+'px');
		else temp.css('top', '0px');
		if (temp.outerWidth() < $(document).width() ) temp.css('margin-left', '-'+temp.outerWidth()/2+'px');
		else temp.css('left', '0px');
		
		temp.find('a.close').click(function(e){
			if(bg){
				$("#"+layerId).fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다. 
			}else{
				temp.fadeOut();
			}
			e.preventDefault();
		});
	}

	$.fn.layerHide = function() {
		var layerId = $(this).attr("id");
		var temp = $(".wrap_pop");
		var bg = temp.prev().hasClass('bg');	//dimmed 레이어를 감지하기 위한 boolean 변수
		
		if(bg){
			$("#"+layerId).fadeOut(); //'bg' 클래스가 존재하면 레이어를 사라지게 한다. 
		}else{
			temp.fadeOut();
		}
	}
	
	
	/**
	 * 모바일 체크 
	 * 
	 * return : 모바일일 경우 true, 아닐 경우 false  
	 */
	function isMobile(){
		var UserAgent = navigator.userAgent;
		if (UserAgent.match(/iPhone|iPod|Android|Windows CE|BlackBerry|Symbian|Windows Phone|webOS|Opera Mini|Opera Mobi|POLARIS|IEMobile|lgtelecom|nokia|SonyEricsson/i) != null || UserAgent.match(/LG|SAMSUNG|Samsung/) != null){
			return true;
		}else{
			return false;
		}
	}