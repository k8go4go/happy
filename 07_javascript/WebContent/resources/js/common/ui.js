var tu = {};
var tgArr = [];
(function(window, $) {

	var CommonUI = (function($, undefined) {
		var _CommonUI = function() {
			// property----------------
		}
		_CommonUI.extend = function(a, b) {
			var spp = a.prototype;
			for ( var property in b) {
				spp[property] = b[property];
			}
			return a;
		};
		_CommonUI.prototype._applyOptions = function(op, applyO) {
			var margeO = {};
			for ( var attrname in op) {
				margeO[attrname] = op[attrname];
			}
			for ( var attrname in applyO) {
				margeO[attrname] = applyO[attrname];
			}
			return margeO

		};

		return _CommonUI;
	})(!!jQuery ? jQuery : false);


	// TAB UI
	/*
	 * var tab = new rs.ui.Toggle(); tab.show({selector : {menu : $("a"), content :
	 * $("b")} , start : 0 , tabClass : "on", contClass:"off" });
	 */
	CommonUI.Toggle = function() {
		CommonUI.call(this, arguments);
		this._options = {
			
			tglArea : null,
			tglBtn : ".drop-bt",
			tglCont : ".drop-ct",
			innerBtn : "li",

			start : 0,
			tabClass : "on",
			closeCallback : null,
			subMenuCallback : null,
			setIndex: false,
			hashEvent: false
		}
		
		this.tglObj = null;
		this.tglArea = null;
		this.tglBtn = null;
		this.tglCont = null;
		this.innerBtn = null;
		this.cIdx = 0;
		this.tg = null;
		this.setIndex = false;
		
	}
	CommonUI.Toggle.prototype = new CommonUI();
	CommonUI.extend(CommonUI.Toggle, {
		show : function(opt) {
			if (opt) {
				this._options = this._applyOptions(this._options, opt);
			}
			this._init();
		},

		_init : function() {
			var opt = this._options;
			this.tglArea = opt.tglArea;
			this.tglObj = this.tglArea;
			
			this.tglBtn = this.tglObj.find("" + opt.tglBtn).eq(0);
			this.tglCont = this.tglObj.find("" + opt.tglCont).eq(0);
			this.innerBtn = this.tglCont.find("" + opt.innerBtn);
			this.closeCallback = opt.closeCallback;
			this.subMenuCallback = opt.subMenuCallback;
			
			this._hashHandler();
			
			
			this._pushToogle();
			
		},
		_hashHandler : function(){
			var that = this;
			var scName = "" + that.tglObj.selector + " "+that._options.tglBtn;
			var scInnerName = "" + that.tglObj.selector + " "+that._options.tglCont + " "+that._options.innerBtn;
			//console.log(scInnerName)
			//$(document).on("click",scName,function(e){
			that.tglBtn.off("click").on("click",function(e){
				e.preventDefault();
	
				if(!$(this).closest(".drop-ar").hasClass("dragged")){
					//alert($(this).hasClass("open"))
					if($(this).hasClass("open")){
						that.hideCont();
					}else {
						
						if(that.closeCallback != null)that.closeCallback();
						that.tglCont.show();
						$(this).addClass("open");
					}
				}
				
			})

			//$(document).on("click",scInnerName,function(e){
			that.innerBtn.off("click").on("click",function(e){

				if(that.subMenuCallback != null)that.subMenuCallback(e,$(this),that.tglObj);
				if(!that.tglObj.hasClass("non-ch")){
					
					that.tglCont.hide();
					that.tglBtn.removeClass("open");
				}
			})

		},
		hideCont : function(){
			var that = this;
			if(that.tglBtn.hasClass("open")){
				that.tglCont.hide();
				that.tglBtn.removeClass("open");
			}
		
		}
		,
		
		getArea : function(){
			var that = this;
			return that.tglObj
		},

		_pushToogle : function(){
			tgArr.push(this);
		}

	})
	


	// 슬라이드 UI
	/*
	 * var slide = new rs.ui.Slide({item : $("a"), next : $("b"), prev :$("c")}); slide.show({dir : 'vertical'});
	 */
	CommonUI.Slide = function() {
		CommonUI.call(this, arguments);	
		this._options = {
			dir : "vertical"
		};
		
		this.content = arguments[0] || null;
		this.cIdx = 0;
		this.pIdx = 0;
		this.totalNum = 0;
		this.timerID = null;
	}
	CommonUI.Slide.prototype = new CommonUI();
	CommonUI.extend(CommonUI.Slide, {
		show : function(opt) {
			if (opt) {
				this._options = this._applyOptions(this._options, opt);
			}
			this._init();
			
		},
		_init : function() {
			var opt = this._options;
			var arg = this.content;
			this.item = arg.item;
			this.next = arg.next;
			this.prev = arg.prev;
			this.dir = opt.dir;
			this.itemH = this.item.outerHeight(true);
			this.totalNum = this.item.size();
			
			this._setNode();
			
			if(this.item.size() >= 1){
				this._setEvent();
			}
			this._timer();
			
		},
		_setNode : function(){
			var node = this.item;
			var taht = this;
			node.css("position","absolute");
			
			node.each(function(i){
				var tg = $(this);
				tg.css("top",taht.itemH * i);
			})
			
		},
		_setEvent : function() {
			var that = this;
			this.next.off("click").on("click", {
				me : this
			}, function(e) {
				e.preventDefault();
				var me = e.data.me;
				me._next();
				
			})
			this.prev.off("click").on("click",{
				me : this
			}, function(e) {
				e.preventDefault();
				var me = e.data.me;
				me._prev();
			})
			
			
			$(".rollingNotice").on({
				"mouseenter" : function(){
					clearInterval(that.timerID);
				},
				"mouseleave" : function(){
					that._timer();
				},
				
			})
		},
		_timer :function(){
			var that = this;
			that.timerID = setInterval(function(){that._next()},4000);
		},
		_next : function(){
			this.pIdx = this.cIdx;
			this.cIdx++;
			if(this.cIdx >= this.totalNum ){
				this.cIdx = 0;
			}
			this._moveNode("next");
		},
		_prev : function(){
			this.pIdx = this.cIdx;
			this.cIdx--;
			if(this.cIdx < 0){
				this.cIdx = this.totalNum -1;
			}
			this._moveNode("prev");
		},
		_getCurrent : function(){
			return this.item.eq(this.cIdx);
		},
		_moveNode : function(dir){
			var node = this.item;
			var cInitPos = 0;
			var pEndPos = 0;
			if(dir == "next"){
				cInitPos = this.itemH;
				pEndPos  =  -1*(this.itemH);
			}else{
				cInitPos = -1*(this.itemH);
				pEndPos =  this.itemH;
			}
			
			//node.eq(this.pIdx).velocity("stop");
			node.eq(this.pIdx).stop().css("top",0).animate({ top: pEndPos }, 400 );//.velocity({top:[ pEndPos , 0 ]},{duration: 400}) 
			
			//node.eq(this.cIdx).velocity("stop");
			node.eq(this.cIdx).stop().css("top",cInitPos).animate({ top: 0 }, 400 );//.velocity({top:[ 0 , cInitPos ]},{duration: 400}) 
			
		}

	})
	tu.ui = CommonUI

})(window, jQuery);




$(document).ready(function() {
	
		
		
	// 기타 토글 버튼 UI
	$(".drop-ar").each(function(){
		var dropToggle = new tu.ui.Toggle();
		dropToggle.show({tglArea : $(this) , innerBtn : "a",closeCallback : otherClose });
	})


	
	//닫기 컨트롤
	function otherClose(){
		for(var i = 0; i<tgArr.length; i++ ){
			if(!tgArr[i].getArea().is(".non-ch"))tgArr[i].hideCont();
		}
	}



	//좌측 상단 커버스토리 토글
	var coverToggle = new tu.ui.Toggle();
	coverToggle.show({tglArea : $(".cover-ar") , innerBtn : "a",closeCallback : otherClose, subMenuCallback : coverMenuControl });

	
	//좌측 상단 커버스토리 메뉴 클릭 콜백
	function coverMenuControl(e,el){
		var $menu = el;
		$(".cover-ar .drop-bt span").html($menu.html());
		
	}

	



	//대시보드 토글
	
	$(".dash1-ar").each(function(){
		var dashToggle1 = new tu.ui.Toggle();
		dashToggle1.show({tglArea : $(this) , innerBtn : "a",closeCallback : otherClose, subMenuCallback : dashMenuControl });
	})
	
	function dashMenuControl(e,el,parent){
		var $menu = el;
		if(el.text() == "삭제"){
			parent.remove();
		};
		
	}


	// 대시보드 추가
	$(".addSuc").on("click",function(e){
		e.preventDefault();

		var wrapper = $("<li>",{class : 'dash1-ar'});
		var data = '<a href="#">DASHBOARD 3</a><a href="" class="xi-ellipsis-h drop-bt"><span>설정</span></a><ul class="boardMenu_setting drop-ct"><li><a href="#">이름변경</a></li><li><a href="#">삭제</a></li></ul>'

		var dash = wrapper.append(data) ;
		$(".menu").append(dash);

		var dashToggle1 = new tu.ui.Toggle();
		dashToggle1.show({tglArea : dash , innerBtn : "a",closeCallback : otherClose, subMenuCallback : dashMenuControl });
		
	})
	
	

	



	//채널 토글
	var channelToggle1 = new tu.ui.Toggle();
	channelToggle1.show({tglArea : $(".channel-ar") , innerBtn : "a",closeCallback : otherClose, subMenuCallback : channelMenuControl });

	
	function channelMenuControl(e,el,parent){
		var $menu = el;
		parent.find(".drop-bt span").html($menu.html());
		
	}
	

	

	//위젯 카테고리 토글
	$(".category-ar").each(function(){
		var wgCateToogle = new tu.ui.Toggle();
		wgCateToogle.show({tglArea : $(this) , innerBtn : "a",closeCallback : otherClose, subMenuCallback : wgCateMenuControl });
	})
	
	
	function wgCateMenuControl(e,el,parent){
		var $menu = el;
		parent.find(".drop-bt span").html($menu.html());
		
	}


	//위젯 인기순 토글
	$(".rank-ar").each(function(){
		var wgRankToogle = new tu.ui.Toggle();
		wgRankToogle.show({tglArea : $(this) , innerBtn : "a",closeCallback : otherClose, subMenuCallback : wgRankMenuControl });
	});
	
	function wgRankMenuControl(e,el,parent){
		var $menu = el;
		parent.find(".drop-bt span").html($menu.html());
		
	}



	
	//검색영역
	var searchArea = $(".search"),
		searchBox = searchArea.find(".searchBox"),
		searchSetting = searchArea.find(".searchSetting");

	searchSetting.find("li a").on("click",function(e){
		e.preventDefault();
		var searchTxt = $(this).text();
		searchBox.find("input").val(searchTxt);
		searchSetting.hide();
	})





	//위젯 dragable
	$( ".widgetAddLayer" ).draggable({ 
		containment: ".container",
		scroll: false,
		cursor: 'move',
		handle: "> .drop-bt",
		start: function() {
			
			$(this).addClass('dragged')
		},
		stop: function(e) {
			var that = $(this);
			setTimeout(function(){ that.removeClass('dragged') }, 200);
		}
	});




	// datePicker 
	var datepickerSetting = function(){

		var dFormat = "yy.mm.dd";
		var from = $( "#from" );
		
		from.datepicker({
			defaultDate: "-2w",
			dateFormat : dFormat,
			prevText: '이전 달',
			nextText: '다음 달',
			monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			dayNames: ['일', '월', '화', '수', '목', '금', '토'],
			dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
			dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
			showMonthAfterYear: true,
			yearSuffix: '년'
		});
		from.on( "change", function() {
			var fdv = $(this).datepicker().val();
			var tdv = to.datepicker().val();
			to.datepicker( "option", "minDate", getDate( fdv ) );

			changePeiodArea(fdv,tdv)
		});

		var to = $( "#to" );
		to.datepicker({
			defaultDate: new Date ,
			dateFormat : dFormat,
			prevText: '이전 달',
			nextText: '다음 달',
			monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
			dayNames: ['일', '월', '화', '수', '목', '금', '토'],
			dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
			dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
			showMonthAfterYear: true,
			yearSuffix: '년'
		});
		to.on( "change", function() {
			var fdv = from.datepicker().val();
			var tdv = $(this).datepicker().val();
			from.datepicker( "option", "maxDate", getDate( tdv ) );

			changePeiodArea(fdv,tdv)
		});

		function getDate( dateValeu ) {
			var date;
			try {
				date = $.datepicker.parseDate( dFormat, dateValeu );
			} catch( error ) {
				date = null;
			}

			return date;
		}

		from.trigger("change");
		to.trigger("change");
		
		$("input[name=periodCheck]").on("change",function(){
			var pv = $(this).val();
			var fromDate = to.datepicker("getDate");
			
			switch(pv){
			
				case "1w" : 
						fromDate.setDate(fromDate.getDate() - 7)
					break
				case "2w" : 
						fromDate.setDate(fromDate.getDate() - 14)
					break
				case "3w" : 
						fromDate.setDate(fromDate.getDate() - 21)
					break
				case "1m" : 
						fromDate.setMonth(fromDate.getMonth() - 1)
					break
				case "6m" : 
						fromDate.setMonth(fromDate.getMonth() - 6)
					break
				case "1y" : 
						fromDate.setFullYear(fromDate.getFullYear() - 1)
					break
				case "2y" : 
						fromDate.setFullYear(fromDate.getFullYear() - 2)
					break
			
			}
			changeFromPeriod(fromDate)
		})
		function changeFromPeriod(fromDate){
			from.datepicker( "setDate", fromDate );
			var dv = from.datepicker().val();
			$(".period .fromArea").text(dv);
		}
		
		function changePeiodArea(fromDateValue,toDateValue){
			
			$(".period .fromArea").text(fromDateValue);
			$(".period .toArea").text(toDateValue);
		}
	}
	datepickerSetting();
	
	
	// 해더 스크롤 UI
	var scFlag = false;
	$(window).on("scroll",function(){
		var $search = $(".searchArea"),
			headerH = $(".header").outerHeight(true),
			searchH = $search.outerHeight(true),
			totalH = headerH + searchH + 30,
			st = $(this).scrollTop(),
			unH = -1 * searchH;

		if(st >= totalH){
			if(!$search.hasClass("sticky")){
				$search.addClass("sticky");
			if(!scFlag){
					$search.stop().css("top", unH).animate({ top: 0 }, 600 );
					scFlag = true;
				}
			}
		}else{
			if($search.hasClass("sticky")){
				$search.removeClass("sticky");
				scFlag = false;
			}
		}
	})
	$(window).trigger("scroll");


	//footer 공지사항 슬라이드
	var slide = new tu.ui.Slide({item : $(".rollingNotice li"), next : $(".rollingNotice .up"), prev :$(".rollingNotice .down")}); 
	slide.show();

});

$(document).ready(function(){
	
	$('.grid-stack').gridstack({
		width: 12
	});
	//scrollbar jqeury
	$('.scrollbar-inner').scrollbar();
});