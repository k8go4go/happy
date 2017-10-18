/**
 *  위젯이 필요한 기능
 *  1. 속성
 *   - Size
 *     - W : 265
 *     - H : 420
 *     - G : 30
 *     - 기본 Template : Unique한 ID 구분값
 *     - 기본 GridStack의 Options
 *  2. Looks 
 *   - Header
 *     - title
 *     - Curation 
 *   - Sub_header
 *     - Channel (전체, TW, FB, ...) 
 *     - SelectBox (기간, 산업군,  
 *     - Download (이미지, Excel) 
 *     - 기간 버튼
 *   - Section
 *     - 간편 요약 섹션
 *     - 상세보기 섹션
 *     - Chart 영역
 *     -      
 *  3. Functions
 */

function extend (o, p) {
	for (prop in p) { // For all props in p.
		o[prop] = p[prop]; // Add the property to o.
	}
	return o;
}

function merge  (o, p) {
	for (prop in p) { 
		if (o.hasOwnProperty[prop]) continue; 
		o[prop] = p[prop]; // Add the property to o.
	}
	return o;
}

/**
 * options : 위젯 최초 설정을 위한 options을 정의한다. 
 * props :         
 */
var $w = function (options, props, template) {
	var mediaStr =     ["mediaType", "media01", "media02", "media03", "media04", "media05", "media06", "media07"];
	var setOnlyStr =   ["btnSetting"];
	var setWithStr =   ["btnSetting", "xi-file-text-o", "xi-file-image-o"];
	var setWithImageStr =   ["btnSetting", "xi-file-image-o"];
	var setWithTextStr =   ["btnSetting", "xi-file-text-o"];
	var periodStr =    ["periodType", "periodRadio01", "periodRadio02", "periodRadio03", "periodRadio04"];
	var directionStr = ["xi-angle-left", "xi-angle-right"];
	
	// default 
	var el = {
		opts : {
			autoPosition:true, 
			minWidth:1, 
			maxWidth:1, 
			minHeight:1, 
			maxHeight:1,
			cellHeight: 420,
			cellWidth: 265,
		    verticalMargin: 30,
		    float: true,
		    acceptWidgets : true,
			order : 1
		},
		props : {},
		gridstack : {},
	};
	
	el.init = function() {
		if(options) el.opts = extend(el.opts, options);
		if(props) el.props = extend(el.props, props);
		
		el.gridstack = $('.grid-stack').gridstack(el.opts);
		var _griddata = el.gridstack.data('gridstack');
		
		_griddata.movable('.grid-stack-item', false);
		_griddata.resizable('.grid-stack-item', false);
		
		el.widgetEle = _griddata.addWidget(template, 
				el.opts.x, el.opts.y, 
				el.opts.width, el.opts.height, 
				el.opts.autoPosition, el.opts.minWidth,
				el.opts.maxWidth, el.opts.minHeight,
				el.opts.maxHeight, el.opts.id);
		
		if(el.props.hasOwnProperty("title")) {
			el.widgetEle.find("strong").text(el.props.title);
		}
		
		if(el.props.hasOwnProperty("id")) {
			el.widgetEle.find("#tableid").attr("id", el.props.id);
		}
		
		el.settings();		
	}
	
	/**
	 * Title Area setting을 하기 위한 function
	 * : channels, categories, setting/images/download, durations, directions
	 */
	el.settings = function() {
		if(el.props.settings) {
			el.props.settings.forEach(function(node) {
				if(!node.includes('direction')) {
					// 화살표를 제외한 것들은 .item의 자식으로
					el.widgetEle.find('.item').append(tags[node]);
				} else {
					// 양방향 화살표는 tit의 형제로 
					el.widgetEle.find('.tit').after(tags[node]);
				}
				el.changeEleId(node, el.widgetEle);
				el.bindEvent(node);			
			});
		}
		// 전체 위젯 공통으로 사용할 Event를 등록한다. 
		el.bindEvent();
	}
	
	el.changeEleId = function (type, $tag) {
		switch(type) {
		case 'media' : 
			mediaStr.forEach(function(node) {
				if(node.includes("Type"))
					$tag.find("." + node).attr("id", node +"_" + el.props.id);
				else {
					$tag.find("#" + node).attr("id", node +"_" + el.props.id);
					$tag.find("#" + node + "_"+el.props.id).next().attr("for", node + "_" + el.props.id);
				}
			});
			break;
		case 'setOnly' : 
			setOnlyStr.forEach(function(node) {
				$tag.find("." + node).attr("id", node +"_" + el.props.id);
			});
			break;
		case 'setWith' : 
			setWithStr.forEach(function(node) {
				$tag.find("." + node).attr("id", node +"_" + el.props.id);
			});
			break;
		case 'setWithImage' :
			setWithImageStr.forEach(function(node) {
				$tag.find("." + node).attr("id", node +"_" + el.props.id);
			});
			break;
		case 'setWithFile' :
			setWithTextStr.forEach(function(node) {
				$tag.find("." + node).attr("id", node +"_" + el.props.id);
			});
			break;	
		case 'categories' : 
			$tag.find(".dropdown2").append("<li class=\"all\"><a href=\"#\" id=\"cateBtnType"+el.props.id+"\">전체 <em>카테고리<span>&nbsp;("+el.props.industryType.length+")</span></em></a></li>");
			el.props.industryType.forEach(function(node) {
				for (var prop in node) {
					// Active setting
					// <li><a href=\"#\" id=\"cateBtn\" class=\"active\">증권</a></li>
					$tag.find(".dropdown2").append("<li><a href=\"#\" id=\"cate"+el.props.id+"_"+prop+"\">"+node[prop]+"</a></li>");
				}
			});
			break;
		case 'duration' :
			periodStr.forEach(function(node) {
				if(node.includes("Type"))
					$tag.find("." + node).attr("id", node +"_" + el.props.id);
				else {
					$tag.find("#" + node).attr("id", node +"_" + el.props.id);
					$tag.find("#" + node + "_"+el.props.id).next().attr("for", node + "_" + el.props.id);
				}
			});
			break;
		case 'direction' :
			directionStr.forEach(function(node) {
				$tag.find("." + node).attr("id", node +"_" + el.props.id);
			});				
			break;
		}
	};
	
	el.createEle = function(tag, options) {
		
	} 
	
	el.bindEvent = function(tag) {
		// Example
		// 이벤트 등록(Curation이면서 하위에 Event를 적용해야 할 것들은 이것을 등록한다.) : events.on("REFRESH", this.doList);
		// DOM에 바인딩 : $(document.body).on('click', '#boardUpdate', this.doModify);
		// 이벤트 Fire : events.emit("REFRESH", {limit:100, start:0});
		switch(tag) {
			case 'media' : 
				mediaStr.forEach(function(node) {
					$(document.body).on('click', "#"+node+"_" + el.props.id, function() {
						alert("#"+node+"_" + el.props.id);
					});
				});
				break;
			case 'setOnly' : 
				setOnlyStr.forEach(function(node) {
					$(document.body).on('click', "#"+node+"_" + el.props.id, function() {
						alert("#"+node+"_" + el.props.id);
					});
				});
				break;
			case 'setWith' : 
				setWithStr.forEach(function(node) {
					$(document.body).on('click', "#"+node+"_" + el.props.id, function() {
						alert("#"+node+"_" + el.props.id);
					});
				});
				break;
			case 'setWithImage' : 
				setWithImageStr.forEach(function(node) {
					$(document.body).on('click', "#"+node+"_" + el.props.id, function() {
						alert("#"+node+"_" + el.props.id);
					});
				});
				break;	
			case 'setWithText' : 
				setWithTextStr.forEach(function(node) {
					$(document.body).on('click', "#"+node+"_" + el.props.id, function() {
						alert("#"+node+"_" + el.props.id);
					});
				});
				break;
			case 'categories' :
				// All
				$(document.body).on('click', "#cateBtnType"+el.props.id, function(){
					alert("#cateBtnType"+el.props.id);
				});
				// 하위
				el.props.industryType.forEach(function(node) {
					for (var prop in node) {
						$(document.body).on('click', "#cate"+el.props.id+"_"+prop, function(){
							alert("#cate"+el.props.id+"_"+prop);
						});
					}
				});
				break;
			case 'duration' :
				periodStr.forEach(function(node) {
					$(document.body).on('click', "#"+node+"_" + el.props.id, function(){
						alert("#"+node+"_" + el.props.id);
					});
				})
				break;
			case 'direction' :
				directionStr.forEach(function(node) {
					$(document.body).on('click', "#"+node+"_" + el.props.id, function(){
						alert("#"+node+"_" + el.props.id);
					});
				});				
				break;
		}
	}
	
	el.getOrder = function () {
		return el.opts.order; 
	};
	
	el.request = function(sendData) {
		$.get(el.props.requestUrl, sendData).
		done(function(recieveData) {
			var result = JSON.parse(recieveData);
			el.setContent(result);
		}).fail(function(recieveData) {
			// alert을 띠워준다.
		});
	}
	
	el.setContent = function(vals) {
		switch(el.props.id) {
			case '100' :
				el.$100(vals);
				break;   // 기간
			case '101' : break;   // 산업별키워드랭킹
			case '102' : break;   // 경쟁사순위변화
			case '103' :
				el.$103(vals);
				break;   // 이슈키워드순위
			case '104' : break;   // 브랜드인덱스
			case '105' : break;   // 매체별버즈차트
			case '106' : break;   // 버즈차트
			case '107' : break;   // 긍,부정차트
			case '108' : break;   // 매체별비율차트
			case '109' : break;   // 연관어차트
			case '110' : break;   // 감성어차트
			case '111' : break;   // 위클리뉴스
			case '112' : break;   // 이슈뉴스
			case '113' : break;   // 이슈미디어
			case '114' : break;   // 산업맞춤보고서
			case '115' : break;   // 포스트
		}
	};
	
	el.$100 = function(vals) {
			
	};
	/**
	 * 이슈키워드
	 */
	el.$103 = function(vals) {
		// 전체 미디어, 위젯 설정
	};
	
	return el;
}
