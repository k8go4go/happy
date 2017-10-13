/**
 * 
 *//**
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

var isDegbug = true;

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

function debug(text) {
	if(isDegbug)
		if(Array.isArray(text)) {
			$.each(text, function(index, node) {
				console.log("[debug]" + "["+index+"] = " +  node);
			});
		} else {
			console.dir("[debug]" + text);
		}
}

/**
 * options : 위젯 최초 설정을 위한 options을 정의한다. 
 * props :         
 */
var $w = function (options, props, template) {
	// default 
	var _ele = {
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
		gridstack : {}
	};
	
	// system copy
	if(options) {
//		_ele.options = $.extend(true, {}, options);
		_ele.opts = extend(_ele.opts, options);
	} 
	// system copy
	if(props) {
//		_ele.props = $.extend(true, {}, props);
		_ele.props = extend(_ele.props, props);
	} 
	
	_ele.gridstack = $('.grid-stack').gridstack(_ele.opts);
	
	debug(_ele.gridstack);
	
	var _griddata = _ele.gridstack.data('gridstack');
	_griddata.movable('.grid-stack-item', false);
	_griddata.resizable('.grid-stack-item', false);
	
	_ele.widgetEle = _griddata.addWidget(template, 
			_ele.opts.x, _ele.opts.y, 
			_ele.opts.width, _ele.opts.height, 
			_ele.opts.autoPosition, _ele.opts.minWidth,
			_ele.opts.maxWidth, _ele.opts.minHeight,
			_ele.opts.maxHeight, _ele.opts.id);
	
	debug([template, 
		_ele.opts.x, _ele.opts.y, 
		_ele.opts.width, _ele.opts.height, 
		_ele.opts.autoPosition, _ele.opts.minWidth,
		_ele.opts.maxWidth, _ele.opts.minHeight,
		_ele.opts.maxHeight, _ele.opts.id]);
	
	_ele.init = function() {
		if(_ele.props.hasOwnProperty("title")) {
			debug("hasProperty title");
			_ele.widgetEle.find("strong").text(_ele.props.title);
		}
		
		if(_ele.props.hasOwnProperty("id")) {
			debug("hasProperty id");
			_ele.widgetEle.find("#chartid").attr("id", _ele.props.id);
		}
		
		_ele.setHeadSubArea();		
		debug("widget is initialize completed");
	}
	
	_ele.setHeadSubArea = function() {
		if(!_ele.props.hasOwnProperty("hasChannels")) 
			_ele.props.hasChannels = false;
		
		if(_ele.props.hasChannels) {			
			var _channelEle = _ele.widgetEle.find('.sub').append("<div class=\"channelClass\"></div>");
			_ele.widgetEle.find('.channelClass').css("display", "inline");
			
			if(!Array.isArray(_ele.props.channels)) throw Error("need array object");
			
			_ele.props.channels.forEach(function(x) {
				_ele.widgetEle.find('.channelClass').append("<button id="+x.name+">"+x.name+"</button>");
				_ele.widgetEle.find("#"+x.name).on("click", function() {
					alert(_ele.widgetEle.find("#"+x.name).text());
				});
			});
		}
		
		if(_ele.props.download) {			
			var _dwEle = _ele.widgetEle.find('.sub').append("<div class=\"dwClass\"></div>");
			_ele.widgetEle.find('.dwClass').css("display", "inline");
			_ele.widgetEle.find('.dwClass').append("<button id=download >다운로드</button>");
			
		}
	};
	
	_ele.getOrder = function () {
		return _ele.opts.order; 
	};
	
	_ele.setContent = function(type, vals) {
		switch(type) {
			case 'c' :
				debug("thecontent is a chart type");
				break;
			case 't' :
				debug("thecontent is a table type");
				break;
			default :
				_ele.type = type;
				break;
		}		
				
		if(vals) _ele.content.vals = $.extend(true, {}, vals);
		
		debug("setContent is complete");
	};
	
	// chart 또는 기타에 의해 Content가 바낄때 마다 호출해줘야 한다.
	_ele.updateContent = function(vals) {
		
	}
	
	
	_ele.init();

	return _ele;
}
