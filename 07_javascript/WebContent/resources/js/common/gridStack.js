/**
 * Create: 2017.09.26
 * Author: 송원진
 * Purpose: 위젯 생성 관련 부분 gridstack.js
 */

var GridStackWidget = new function(){
	this.movable = true; 
	this.resizable = true; 
	
	
	// 위젯 생성 컨테이너 
	var options = {
		cellHeight: 420,
		cellWidth: 265,
	    verticalMargin: 30,
	    itemClass : "grid-stack-items",
	    float: true,
	    acceptWidgets : true
	};
	// 위젯 생성하기 -- 설정에서 최초로 위젯을 생성할때
	// grid : 생성할 gridstack 요소, htmlStr : 생성할 템플릿 , locx : 가로위치 , locy : 세로우치 , width : 가로 길이 , height : 세로길이
	// 최소 최대값을 위젯에 지정할때
	this.addMaxWidget = function(grid, htmlStr , locx , locy , width , height, minWidth, maxWidth, minHeight, maxHeight , id){
	
		var griddata = grid.data('gridstack');

		griddata.addWidget(htmlStr, locx, locy, width, height, true , minWidth , maxWidth , minHeight, maxHeight , id);
		
	};
	// 최소 최대값을 위젯에 지정안함
	this.addBasicWidget = function(grid, htmlStr , locx , locy , width , height, id){
		var griddata = grid.data('gridstack');
		griddata.movable('.grid-stack-item', GridStackWidget.movable);
		griddata.resizable('.grid-stack-item', GridStackWidget.resizable);
		var element = griddata.addWidget(htmlStr,locx, locy, width, height,true , null , null , null, null ,id);

		return element;
	};
	
	// 위젯을 만들어넣는다
	// htmlStr <div id="makeid" data-gs-id="gsi-1" data-gs-x="0" data-gs-y="0" data-gs-width="3" data-gs-height="2" data-gs-auto-position="yes">위젯 컨텐츠영역</div>
	this.makeWidget = function(htmlStr){
		$('.grid-stack').gridstack();
		 htmlStr = '<div id="makeid" data-gs-id="gsi-1" data-gs-x="0" data-gs-y="0" data-gs-width="3" data-gs-height="2" data-gs-auto-position="yes">위젯 컨텐츠영역</div>';
		$('.grid-stack').append(htmlStr);
		var grid = $('.grid-stack').data('gridstack');
		grid.makeWidget('makeid');	

	};
	// 화면내 위젯의 좌표 가로 세로 길이를 가져온다.
	this.infoGridWidget = function(){
		var returndate = _.map($('.grid-stack > .grid-stack-item:visible'), function (el) {
            el = $(el);
            var node = el.data('_gridstack_node');
            return {
                x: node.x,
                y: node.y,
                width: node.width,
                height: node.height,
                id : node.id
            };
        });
		return returndate;
	};
}