var widgetHandler = (function(){
		var widgets = [];
		var currentW = {};
		var template =
			 "<div class=\"grid-stack-item\" data-gs-x=\"0\" data-gs-y=\"0\" data-gs-width=\"8\" data-gs-height=\"2\" data-gs-no-resize=\"true\" data-gs-no-move=\"true\">"
			+"		<div class=\"grid-stack-item-content\">                                                                                                               "
			+"			<div class=\"tit\">                                                                                                                               "
			+"				<strong>이슈 미디어이슈 미디어</strong>                                                                               "
			+"				<div class=\"sortArea\"><div class=\"item\">\"</div></div>"
			+"			</div>                                                                                                                                            "
			+"			<div class=\"cont\">                                                                                                                              "
			+"			</div>                                                                                                                                            "
			+"		</div>                                                                                                                                                "
			+"</div>                                                                                                                                                      ";
		
		return {	
			init : function() {
				var datas = widgetHandler.config(widgetHandler.datas());
				var widget1 = $w(datas[0], datas[1], template);
				widget1.init();
				widgets.push(widget1);	
				
				var widget2 = $w(datas[2], datas[3], template);
				widget2.init();
				widgets.push(widget2);
//				
//				var widget3 = $w(datas[4], datas[5], template);
//				widget3.init();
//				widgets.push(widget3);
//				
//				var widget4 = $w(datas[6], datas[7], template);
//				widget4.init();
//				widgets.push(widget4);
//				
//				var widget5 = $w(datas[8], datas[9], template);
//				widget5.init();
//				widgets.push(widget5);
			},
			
			config : function(datas) {
				return [
					{
						x:0, 
						y:0, 
						maxWidth:8,
						maxHeight:2,
						width:8, 
						height:2 
					}, 
					{
						title:"이슈키워드", 
						id : "103",
						type : 't', // t : table , c : chart,   tc : composite
						settings : ['media', 'duration'],
						requestUrl : "" 
					}, 
					
					{
						x:0, 
						y:0, 
						maxWidth:4,
						maxHeight:1,
						width:4, 
						height:1 
					}, 
					{
						title:"위클리뉴스", 
						id : "111",
						type : 't', 						
						requestUrl : "" 
					},
					
					{
						x:0, 
						y:0, 
						maxWidth:8,
						maxHeight:2,
						width:8, 
						height:2 
					}, 
					{
						title:"이슈뉴스", 
						id : "112",
						type : 't', // t : table , c : chart,   tc : composite
						settings : ['direction'],
						requestUrl : "" 
					},
					
					{
						x:0, 
						y:0, 
						maxWidth:4,
						maxHeight:1,
						width:4, 
						height:1 
					}, 
					{
						title:"이슈미디어", 
						id : "113",
						type : 't', // t : table , c : chart,   tc : composite
						settings : ['categories', 'setOnly'],
						requestUrl : "",
						industryType : [
							{"1001":"유통"},
							{"1002":"은행"},
							{"1003":"증권"},
							{"1004":"카드"},
							{"1005":"보험"},
							{"1006":"외식"},
							{"1007":"화장품"},
							{"1008":"패션"},
							{"1009":"통신"},
							{"1010":"자동차"},
							{"1011":"IT"},
							{"1012":"방송,연예"},
							{"1013":"공공정책"},
							{"1014":"여행"},
							{"1015":"스포츠"},
						]
					},
					
					{
						x:0, 
						y:0, 
						maxWidth:4,
						maxHeight:2,
						width:4, 
						height:2 
					}, 
					{
						title:"경쟁사 랭킹", 
						id : "102",
						type : 't', // t : table , c : chart,   tc : composite
						settings : ['media', 'setWith'],
						requestUrl : "" 
					},
				]
			},
			
			cleanup : function() {
				
			},
			
			datas : function() {
				
			}	
		};
	})();