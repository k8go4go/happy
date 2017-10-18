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
		if(options) el.opts = el._extend(el.opts, options);
		if(props) el.props = el._extend(el.props, props);
		
		el.gridstack = $('.grid-stack').gridstack(el.opts);
		var _griddata = el.gridstack.data('gridstack');
		
		_griddata.movable('.grid-stack-item', false);
		_griddata.resizable('.grid-stack-item', false);
		
		el.wdom = _griddata.addWidget(template, 
				el.opts.x, el.opts.y, 
				el.opts.width, el.opts.height, 
				el.opts.autoPosition, el.opts.minWidth,
				el.opts.maxWidth, el.opts.minHeight,
				el.opts.maxHeight, el.opts.id);

		el.wdom.find(".cont").attr("id", "cont_" + el.props.id);
		
		if(el.props.hasOwnProperty("title")) {
			el.wdom.find("strong").text(el.props.title);
		}
		
		if(el.props.hasOwnProperty("id")) {
			el.wdom.find("#tableid").attr("id", el.props.id);
		}
		
		el.settings();		
		el.render();
	};
	
	/**
	 * Title Area setting을 하기 위한 function
	 * : channels, categories, setting/images/download, durations, directions
	 */
	el.settings = function() {
		if(el.props.settings) {
			$.each(el.props.settings, function(key, val) {
				if(!val.includes('direction')) el.wdom.find('.item').append(tags[val]); // 화살표를 제외한 것들은 .item의 자식으로
				else el.wdom.find('.tit').after(tags[val]); // 양방향 화살표는 tit의 형제로
				
				el.changeAttrId(val, el.wdom);
				el.bindEvent(val);
			});
		}
	};
	
	el.changeAttrId = function (type, $tag) {
		switch(type) {
		case 'media' : 
			$.each(mediaStr, function(key, val) {
				var id = el._uniqueStr([val, el.props.id]);
				
				if(val.includes("Type")) {
					$tag.find("." + val).attr("id", id); 
				} else {
					$tag.find("#" + val).attr("id", id);
					$tag.find("#" + id).next().attr("for", id);
				}
			});
			break;
		case 'setOnly' : 
			$.each(mediaStr, function(key, val) {
				var id = el._uniqueStr([val, el.props.id]);
				$tag.find("." + val).attr("id", id);
			});
			
			break;
		case 'setWith' : 
			$.each(setWithStr, function(key, val) {
				var id = el._uniqueStr([val, el.props.id]);
				$tag.find("." + val).attr("id", id);
			});
			break;
		case 'setWithImage' :
			$.each(setWithImageStr, function(key, val) {
				var id = el._uniqueStr([val, el.props.id]);
				$tag.find("." + val).attr("id", id);
			});

			break;
		case 'setWithFile' :
			$.each(setWithTextStr, function(key, val) {
				var id = el._uniqueStr([val, el.props.id]);
				$tag.find("." + val).attr("id", id);
			});
			break;	
		case 'categories' : 
			$tag.find(".dropdown2").append("<li class=\"all\"><a href=\"#\" id=\"cateBtnType_"+el.props.id+"\">전체 <em>카테고리<span>&nbsp;("+el.props.industryType.length+")</span></em></a></li>");
			el.props.industryType.forEach(function(node) {
				for (var prop in node) {
					// Active setting
					// <li><a href=\"#\" id=\"cateBtn\" class=\"active\">증권</a></li>
					$tag.find(".dropdown2").append("<li><a href=\"#\" id=\"cate_"+el.props.id+"_"+prop+"\">"+node[prop]+"</a></li>");
				}
			});
			break;
		case 'duration' :
			$.each(periodStr, function(key, val) {
				var id = el._uniqueStr([val, el.props.id]);
				if(val.includes("Type")) {
					$tag.find("." + val).attr("id", id); 
				} else {
					$tag.find("#" + val).attr("id", id);
					$tag.find("#" + id).next().attr("for", id);
				}
			});
			
			break;
		case 'direction' :
			$.each(directionStr, function(key, val) {
				var id = el._uniqueStr([val, el.props.id]);
				$tag.find("." + val).attr("id", id);
			});
			break;
		}
	};
	
	el.bindEvent = function(type) {
		// Example
		// 이벤트 등록(Curation이면서 하위에 Event를 적용해야 할 것들은 이것을 등록한다.) : events.on("REFRESH", this.doList);
		// DOM에 바인딩 : $(document.body).on('click', '#boardUpdate', this.doModify);
		// 이벤트 Fire : events.emit("REFRESH", {limit:100, start:0});
		switch(type) {
			case 'media' : 
				$.each(mediaStr, function(key, val) {
					var id = el._uniqueStr([val, el.props.id]);
					$(document.body).on('click', "#"+id, function(event) {
						el.render();
					});
				});
				
				break;
			case 'setOnly' : 
				$.each(setOnlyStr, function(key, val) {
					var id = el._uniqueStr([val, el.props.id]);
					$(document.body).on('click', "#"+id, function(event) {
						alert("#"+id);
					});
				});
				break;
			case 'setWith' : 
				$.each(setWithStr, function(key, val) {
					var id = el._uniqueStr([val, el.props.id]);
					$(document.body).on('click', "#"+id, function(event) {
						alert("#"+id);
					});
				});
				break;
			case 'setWithImage' : 
				$.each(setWithImageStr, function(key, val) {
					var id = el._uniqueStr([val, el.props.id]);
					$(document.body).on('click', "#"+id, function(event) {
						alert("#"+id);
					});
				});
				break;	
			case 'setWithText' : 
				$.each(setWithTextStr, function(key, val) {
					var id = el._uniqueStr([val, el.props.id]);
					$(document.body).on('click', "#" + id, function(event) {
						alert("#"+id);
					});
				});
				break;
			case 'categories' :
				// All
				var id = el._uniqueStr(["cateBtnType", el.props.id]);
				$(document.body).on('click', "#" + id, function(){
					alert("#cateBtnType"+el.props.id);
				});
				// 하위
				$.each(el.props.industryType, function(key, val) {
					for (var prop in val) {
						id = el._uniqueStr(["cate", el.props.id, prop]);
						$(document.body).on('click', "#"+id, function(){
							alert("#"+id);
						});
					}
				});
				break;
			case 'duration' :
				$.each(periodStr, function(key, val) {
					var id = val+"_" + el.props.id;
					$(document.body).on('click', "#" + id, function(event) {
						alert("#"+id);
					});
				});
				break;
			case 'direction' :
				$.each(directionStr, function(key, val) {
					var id = val+"_" + el.props.id;
					$(document.body).on('click', "#" + id, function(event) {
						alert("#"+id);
					});
				});
				break;
		}
	}
	
	el._uniqueStr = function (obj, delimiter) {
		delimiter = delimiter || "_";
		var retVal = "";
		if(Array.isArray(obj)) { // Array 인지 검사
			$.each(obj, function(key, val) {
				if(key != obj.length - 1) retVal += val + delimiter;
				else retVal += val;
			});
			
			return retVal;
		} else {
			throw new Error("obj는 배열만");
		}
	}
	
	el._extend = function(o, p) {
		for (prop in p) { // For all props in p.
			o[prop] = p[prop]; // Add the property to o.
		}
		return o;
	}
	
	el._merge = function(o, p) {
		for (prop in p) { 
			if (o.hasOwnProperty[prop]) continue; 
			o[prop] = p[prop]; // Add the property to o.
		}
		return o;
	}
	
	el.getOrder = function () {
		return el.opts.order; 
	};
	
	el.request = function(sendData) {
		$.get(el.props.requestUrl, sendData).
		done(function(recieveData) {
			var result = JSON.parse(recieveData);
			el.render(result);
		}).fail(function(recieveData) {
			// alert을 띠워준다.
		});
	}
	
	el.render = function(vals) {
		switch(el.props.id) {
			case '100' :
				el.$100(vals);
				break;   // 기간
			case '101' : break;   // 산업별키워드랭킹
			case '102' : break;   // 경쟁사순위변화
			case '103' :
				el.$103(el.wdom, arr[0]);  // content.js에 있음
				break;   // 이슈키워드순위
			case '104' : break;   // 브랜드인덱스
			case '105' : break;   // 매체별버즈차트
			case '106' : break;   // 버즈차트
			case '107' : break;   // 긍,부정차트
			case '108' : break;   // 매체별비율차트
			case '109' : break;   // 연관어차트
			case '110' : break;   // 감성어차트
			case '111' :
				el.$111(el.wdom, weeklyData); 
				break;   // 위클리뉴스
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
	el.$103 = function($tag, vals) {
		$(".issueKeyWrap").remove();
		$tag.find("#cont_" + el.props.id).append(issueKeyWrap.cover); // <div class="issueKeyWrap"><ul> 
		
		$.each(vals, function(key, val) {
			var period = val.splice(0, 1); // 배열에서 기간정보를 배열에서 제외 시킨다.
			
			$tag.find(".issueKeyWrap > ul").append(issueKeyWrap.paragraph); // <li>  
			$tag.find(".issueKeyWrap > ul > li:eq("+key+")").append(issueKeyWrap.period); // <div class="period"><i class="xi-calendar"></i> 2017.04.02~2017.04.08 <i class="xi-angle-right"></i></div>
			$tag.find(".period:eq("+key+")").html("<i class=\"xi-calendar\"></i>"+period[0].period+"<i class=\"xi-angle-right\"></i></div>");
			$tag.find(".issueKeyWrap > ul > li:eq("+key+")").append(issueKeyWrap.issueKeyList); // <ol class="issueKeyList">
			
			el.$103.registerEvent(key);
			
			if(Array.isArray(val)) {
				$.each(val, function(k, v) {
					$tag.find(".issueKeyList:eq("+key+")").append(el._createEl("li"));
					$tag.find(".issueKeyList:eq("+key+") > li:eq("+k+")").append(el._createEl("a", {attr : { 'href':'#'}}));
					$tag.find(".issueKeyList:eq("+key+") > li:eq("+k+") > a").append(el._createEl("em" , {cls : "num", text : v.num}));
					$tag.find(".issueKeyList:eq("+key+") > li:eq("+k+") > a").append(el._createEl("span" , {cls : "txt", text : v.txt}));
					$tag.find(".issueKeyList:eq("+key+") > li:eq("+k+")").append(el._createEl("span" , {cls : "score", text : v.score}));
				});
			} 
		});
	};
	
	el.$103.registerEvent = function(key) {
		$(document.body).on("click", ".issueKeyList:eq("+key+") a" ,function(event){
			el.$103.toggleEvent(key, event);
		});
	}
	
	el.$103.toggleEvent = function(key, event) {
		var clr = "pick " + (el.$103.data.count < 10 ? "clr0" + el.$103.data.count : "clr" + el.$103.data.count);
		var selectStr = $(event.currentTarget.children[1]).text();
		var searchText = $(".issueKeyList > li:contains('"+selectStr+"')");
		
		if(searchText && searchText.length > 1) {
			$.each($(".issueKeyList > li span:contains('"+selectStr+"')"), function(key, val){
			     if($(val).text() == selectStr) {
			    	 $(val).parent().parent().toggleClass(clr);
			     }
			});
			
			++el.$103.data.count;
			if(el.$103.data.count > 20)
				el.$103.data.count = 1;
		}
	}
	
	el.$103.data = {
		count : 1
	};
	
	el.$111 = function($tag, vals) {
		$(".weeklyWrap").remove();
		$tag.find("#cont_" + el.props.id).append(weeklyWrap.cover); // <div class="weeklyWrap"><div class="dateTit">
		$tag.find(".dateTit strong").text();
		el.$111.title($tag, vals.currentWeek);  // big title
		
		$tag.find(".dateTit").after(weeklyWrap.weeklyDate); // <ul class="weeklyDate">		
		
		$.each(weeklyData.weeklyDate, function(key, val) {
			if(!val.active)
				$tag.find(".weeklyDate").append(weeklyWrap.weeklyDateCount);
			else {
				$tag.find(".weeklyDate").append(weeklyWrap.weeklyDateCount);
				$tag.find(".weeklyDate li:eq("+key+")").addClass("active");
			}
			
			$tag.find(".weeklyDate li:eq("+key+") > span").text(val.date);
			$tag.find(".weeklyDate li:eq("+key+") > a").text(val.cnt);
		});
		
		$tag.find(".weeklyDate").after(weeklyWrap.selectDate);
		$tag.find(".sTit").html("<strong>" + weeklyData.currentDate.title + "</strong>의 관심 뉴스");
		
		console.log($tag.find(".weeklyWrap"));
		console.log(weeklyWrap.scrollWrapper);
		$tag.find(".weeklyWrap").append(weeklyWrap.scrollWrapper); 
		$tag.find(".weeklyWrap .scrollbar-inner").append(weeklyWrap.weeklyNewsList);
		
		$.each(weeklyData.currentDate.news, function(key, val) {
			$tag.find(".weeklyNewsList").append(weeklyWrap.weeklyNews);
			$tag.find(".weeklyNewsList li:eq("+key+") > a").attr("href", val.url);
			$tag.find(".weeklyNewsList li:eq("+key+") > a").html(val.tle + "<span>"+val.from+"</span>");
		});
		
		$tag.find(".weeklyWrap .scroll-wrapper").append(weeklyWrap.scrollX);
		$tag.find(".weeklyWrap .scroll-wrapper").append(weeklyWrap.scrollY);
		el.$111.registerEvent();
	}
	
	el.$111.registerEvent = function() {
		$(document.body).on("click", ".dateTit a" ,function(event){
			el.$111.weeklyEvent("xi-angle-left", event);
		});
		
		$(document.body).on("click", ".weeklyDate a" ,function(event){
			el.$111.dailyEvent(".weeklyDate li", event);
		});
	}
	
	el.$111.weeklyEvent = function(conditionClass, event) {
		if($(event.currentTarget).hasClass(conditionClass)) {
			alert("전주 Ajax 이벤트");
			// ajax 요청 처리 한다.
		} else {
			alert("다음주 Ajax 이벤트");
			// ajax 요청 처리 한다.
		}
		
		el.render(); // 재 render
	}
	
	el.$111.dailyEvent = function(conditionClass, event) {
		if($(conditionClass).hasClass("active")) $(conditionClass).removeClass("active"); 
		$(event.currentTarget.parentElement).addClass("active");
		
		// ajax 요청 처리 한다.
	}
	
	el.$111.title = function($tag, $tle) {
		if($tle) {
			$(".dateTit strong").text($tle);
		} else {
			
		}
		return $(".dateTit strong").text();
	}
	
	el._createEl = function(tag, options) {
	    if (!tag) return $('<div />');
	    var $elem = $('<' + tag + '/>');
	    if (options){
	        if (options.id)
	            $elem.attr('id', options.id);
	        if (options.cls) {
	            if (typeof options.cls == 'null' || typeof options.cls == 'undefined') {
	                // do nothing
	            } else if (typeof options.cls == 'string') {
	                $elem.addClass(options.cls);
	            } else if (typeof options.cls == 'object') {
	                for ( var i in options.cls) {
	                    $elem.addClass(options.cls[i]);
	                }
	            }
	        }
	        if (options.text)
	            $elem.text(options.text);
	        
	        if(options.html)
	        	$elem.html(options.html);
	        
	        if (typeof options.attr != 'null' && typeof options.attr == 'object') {
	            for (var i in options.attr) {
	                $elem.attr(i, options.attr[i]);
	            }
	        }
	        if (typeof options.css != 'null' && typeof options.css == 'object') {
	            for (var i in options.css) {
	                $elem.css(i, options.css[i]);
	            }
	        }
	    }
	    return $elem;
	}
	
	return el;
}
