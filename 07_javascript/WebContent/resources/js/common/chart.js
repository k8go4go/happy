/**
 * Create: 2017.09.21
 * Author: 송원진
 * Purpose: 차트 관련 부분 정의
 */

	/*차트 관련 정보 객체*/
	var ChartInfoConfig = {
		// 배경색상	
		backgroundColor : ["#3F8096","#2DA8B6","#ef6d69","#825acb","#F1862E","#f1ce2b","#eb6232","#92da4c","#b19bdb","#69a08a","#f282c7","#829ff2","#c0a154","#43d9c2"],
		// 미디어별색상
		mediaColor : {
			M:"#6D55CD", // 메스미디어
			T:"#568BCC",  // 트위터
			F:"#37579D",  // 페이스북
			B:"#64C15D",  // 블로그
			C:"#CA6555",  // 커뮤니티
			I:"#7A8D92"  // 인스타그램 
		},
		// 감성
		sentimentColor : {
			P:"#acd806", // 긍정
			N:"#8677f5",  // 부정
			E:"#009DD0" // 중립
		}, 
	
		//긍정색상
		posColor : ["#00b7aa","#0074e0","#00be70 ","#0073df ","#00b5f4","#5896b7"], 
		//부정색상
		negColor : ["#873450","#e83900 ","#3fb678","#0073df","#5896b7","#00be70"],
		//라인차트색상
		lineColor : ["#2a5fd5","#922ffb", "#cb9aff" ,"#e84b30", "#5b3dff","#ff7a00","#d7283e" ,"#ff486e" ,"#614f3e" ,"#5c5958"],
		//bar차트 색상
		barColor : ["#00b9a2","#ff7978", "#705efe" ,"#79f3ff", "#ffd36c","#fab5e0","#ffaa45" ,"#c4e833" ,"#bbc6ff" ,"#ffec7b"],
	}

	// 제목 관련 세부 설정부분
	var ChartTitleConfilg = {
		text:"여기에 타이틀이 와야 합니다.", // 일반적으로 제목만
		textAlign : "center", //"left" | "center" | "right"
		adjustLayout : 1, // 차트영역과 겹쳐지지 않게 하기 1 , 0 , true, false
		alpha : 1.0, // 투명도
		backgroundColor : "#FFFFFF",
		width:"100%", // 10 | "20px" | 0.3 | "30%" |
		height:0,
		bold : 0,
		borderColor : "none",
		borderRadius : 0,
		color:"none",
		fontColor : "none",
		fontStyle : "none", // "none" | "italic" | "oblique"
		fontWeight : "normal", //| "bold"
		margin : 0, //10 | "5px" | "10 20" | "5px 10px 15px 20px" 
		padding : 0,
		offsetX : 0, // 위치강제로 적용할때
		offsetY : 0,
		shadow : 0,
		wrapText : 0, // 폭에 따른 줄바꿈여부
		zIndex : 0
	}
	
	// 서브 타이틀부분
	var ChartSubtitleConfig = {
		  text:"여기에 서브타이틀이 와야 합니다.", // 일반적으로 제목만
		  textAlign : "center", //"left" | "center" | "right"
		  adjustLayout : 1, // 차트영역과 겹쳐지지 않게 하기 1 , 0 , true, false
		  alpha : 1.0, // 투명도
		  backgroundColor : "#FFFFFF",
		  width:"100%", // 10 | "20px" | 0.3 | "30%" |
		  height:0,
		  bold : 0,
		  borderColor : "none",
		  borderRadius : 0,
		  color:"none",
		  fontColor : "none",
		  fontStyle : "none", // "none" | "italic" | "oblique"
		  fontWeight : "normal", //| "bold"
		  margin : 0, //10 | "5px" | "10 20" | "5px 10px 15px 20px" 
		  padding : 0,
		  offsetX : 0, // 위치강제로 적용할때
		  offsetY : 0,
		//  x : 0, // 위치강제로 적용할때
		//  y : 30,
		  shadow : 0,
		  wrapText : 0, // 폭에 따른 줄바꿈여부
		  zIndex : 0
	}

	// 레전드관련환경설정
	var ChartLegendConfig = {
			adjustLayout : 1, // 차트영역과 겹쳐지지 않게 하기 1 , 0 , true, false
			layout:"h", //"horizontal" | "h" | "vertical" | "v" | "row x col" | "x col" | "row x" | "float"
			margin:"0", //10 | "5px" | "10 20" | "5px 10px 15px 20px" 
			align : "center", //"left" | "center" | "right"
			backgroundColor : "",
			borderColor : "#333",
			borderWidth:"1",
			//header:{text:""},
			// footer:{text:""}, // 하단에 컨트롤 안되는 부분이 생기므로 자제
			callout : true, // 화살표나타난다.
			calloutPosition : "top", // 화살표방향
			dragHandler : "header" , //"header" | "icon"
			draggable : 1 , // true | false | 1 | 0
			verticalAlign : "bottom",
			offsetX : 0, // 위치강제로 적용할때
			offsetY : -10,
			//  x : 0, // 위치강제로 적용할때
			//  y : 0,
			maxItems : 5, // 한화면에 표시될 최대 갯수
			overflow : "page",//"none" | "hidden" | "page" | "scroll" 최대갯수 이후 표시방식(페이징,스크롤)
			shadow:false,
			
			toggleAction: "hide"//"hide" | "remove" | "disabled"
	}

	var ChartScaleXConfig = {
			values : "", // 값의 범위를 지정해줘야 목차가 제대로 나온다.
			//decimals : 3, // 가로목차가 숫자일때사용
            //decimalsSeparator : "," // 가로 목차 숫자일때 1,000  표시
			//exponent : 0, // 큰숫자를 자동으로 형식변환할지 규정
			//exponentDecimals : 2, // 자동변화시 소수점정리
			thousandsSeparator: ",", // 월별표시일때는 흠???????? 그려보고 판단해야함
			format : "%v%" , // '$%v' | '%v%' | '%v seconds' | ... // 표시형식
			lineColor:"#666", // 라인색을 지정할때 사용한다. 만약 빈값으로 세팅하면 사라지므로 요소자체를 지정하면 안된다.
			itemsOverlap:0, // 내용겹치게 할지 
		    lineStyle:"solid", //'solid' | 'dotted' | 'dashed' | 'dashdot'
		    lineWidth:1,
		    maxItems : 10, // 화면영역에 최 대로 표시될 갯수 요소차체를 삭제하면 화면에 모두 표시
		    offset : 0, // 화면 좌우 공백 시작공백 offsetStart  끝부분 공백 offsetEnd
		    visible : 1, // 보이게 할지 안보이게 할지
		    zooming : 1, // 일부영역을 확대할지 안할지
		    minValue:0,
		    maxValue:100

	}
	
	var ChartScaleYConfig = {
			values : "", // 값의 범위를 지정해줘야 목차가 제대로 나온다.
			//decimals : 3, // 가로목차가 숫자일때사용
            //decimalsSeparator : "," // 가로 목차 숫자일때 1,000  표시
			//exponent : 0, // 큰숫자를 자동으로 형식변환할지 규정
			//exponentDecimals : 2, // 자동변화시 소수점정리
			thousandsSeparator: ",",
			format : "%v%" , // '$%v' | '%v%' | '%v seconds' | ... // 표시형식
			lineColor:"#666", // 라인색을 지정할때 사용한다. 만약 빈값으로 세팅하면 사라지므로 요소자체를 지정하면 안된다.
			itemsOverlap:0, // 내용겹치게 할지 
		    lineStyle:"solid", //'solid' | 'dotted' | 'dashed' | 'dashdot'
		    lineWidth:1,
		    maxItems : 10, // 화면영역에 최 대로 표시될 갯수 요소차체를 삭제하면 화면에 모두 표시
		    offset : 0, // 화면 좌우 공백 시작공백 offsetStart  끝부분 공백 offsetEnd
		    visible : 1, // 보이게 할지 안보이게 할지
		    zooming : 1, // 일부영역을 확대할지 안할지
		    minValue: 0,
		    maxValue:100

	};
	// 파이차트형태
	var ChartScaleRConfig = {
			// 파이차트 사용영역
			aperture : 180 , // 보여질 각도 일단은 절반
			refAngle : 180 , //회전시킬각도
			// Gauge  차트만 사용한다.
			labels : [], // ['Cold', 'Just Right', 'Hot'],
			item : {}, // font , padding 등요소값
			markers : {},
			ring : {} , // 가장자리요소들
			values : "" //'0:100:10' scarex 

	};
	
	// 튤팁
	var CharTooltipConfig = {
			text: "%t<br>값은: %v<br>비율은 %npv%",
			textAlign: "left",
			shadow: 5,
			borderRadius: 5,
			borderWidth: 1,
			borderColor: "#fff",
			// 하단은 파이차트 센터용
			/*anchor:'c',
			 x:'50%',
		 	    y:'50%',*/

	
	};
	
	// 차트 Plot object 차트 전체적으로 영향을 줄 스타일만 정의해야함
	var ChartPlotConfig = {
			// Line 차트용
			aspect : "spline", // 라인그래프 라인 스타일 /* "spline" | "stepped" */
			// Bar 차트
			stacked : 1, // 1, 0  // 한개의 바에 값을 모두 그릴지 유무
			stackType : "normal",
			borderWidth:1, 
			//lineStyle:"dotted",
			valueBox : {
				text:'%t',
			      fontSize:15,
			      fontWeight:"bold", // "normal" | "bold"
			      placement:"out", // 위치
			      //fontColor:"transparent",
			      lineStyle:"dotted",
			      visible : 1, 
			}
			// 파이차트를 위해서는 2개 만들어야 한다.
			/*valueBox:[
				{
					  text:'%t',
				      fontSize:15,
				      fontWeight:"bold", // "normal" | "bold"
				      placement:"out", // 위치
				      //fontColor:"transparent",
				      lineStyle:"dotted",
				      visible : 1, 
				    },
				    {
				    	 text: '%v', //  '%npv%'
					      fontSize:15,
					      fontWeight:"bold", // "normal" | "bold"
					      placement:"in", // 위치
					      //fontColor:"transparent",
					      lineStyle:"dotted",
					      visible : 1, 
					    },
			]*/

/*			tooltip: {
				backgroundColor: '#FFF8E1',
				borderColor: '#FFC107',
				borderRadius: 3,
				fontColor: '#FFC107',
				fontFamily: 'Georgia'
				},*/

			/*valueBox:{ // pie 차트에 유효
				 // 값의 위치 Bar Chart top-out(=top) | top-in | middle | bottom-in | bottom-out(=bottom) | over  
				 // Heat Map top | bottom | left | right | over  
				 // Line Chart auto | top | bottom | left | right | over  
				 // Pie Chart out | in | center 
				placement:"out",
				fontColor:"gray",
				fontSize:12,
				fontWeight:"normal"
			},
			hoverState: {
				lineColor: "white",
				alpha: 1,
				backgroundColor: "pink",
				alphaArea: 0.5
				},
			hoverMarker: {
				type: "star5",
				size: 10,
				backgroundColor: "#FFCCFF"
			}*/

	}
	
	// 차트 실제 값을나타내는 부분
	// 1개의 영역당 series 1개를 선언해야한다. 영역은 1개 라인 , 1개의 파이slice , 1개의 Column (scarex) 영역 이 해당함
	// 예) 라인차트 1개 라인당 1개 values 에 라인에서 표시될 값을 입력[510,520,530]
	// 예) 파이차트 1개 영역당 1개 선언및 values 1개만 [510] 선언 내부에서 영역이 분리되는 파이(nestedpie)인경우 values [510,520,530] 선언
	var ChartSeriesConfig = {
			//차트별로 values 는 형태가 다르므로 확인 하고 추가해주어야 한다.
			values: [], // [510,520,530,510,520,550,500,500,500,500,500,500,500,500,500] // 여기는 사용하고자 하는 차트별로 다르므로 확인해서 작업해야함
			backgroundColor : "",
			backgroundImage : "",
			text : "", 
			value : 0,
			// 라인그래프일때
			lineColor:"",
			lineStyle:"solid"  ,// "solid" | "dotted" | "dashed"
			aspect : "line", // 라인그래프 라인 스타일 /* "spline" | "stepped" */
			decimals: 0, // 소수점자리수
			exponent : 0,
			thousandsSeparator: ",",
			lineWidth : 1,
			marker:{},
			children:[]
	}
	
	// 마커 스타일정의
	var ChartMarkerConfig = {
		backgroundColor : "",
		backgroundImage : "",
		backgroundRepeat:"no-repeat",
		//backgroundFit:"xy",
		borderColor : "",
		borderWidth : 1,
		alpha : 1.0, // 투명도 0.0~1.0
		text : "",
		lineColor : "",
		lineStyle : "", //"solid" | "dotted" | "dashed"
		type : "circle" , //inherit , star5 , match ,  circle , diamond ,rpoly5
		plot : {},
		//showLine : 1, // 0 1 레전드에 줄긋기
		visible : 1 , // 0 1 
		size : 1 // 크기
	};
	
	// 미리보기 관련
	var CharPreviewConfig = {
		active  : {alpha:1.0, backgroundColor: "none"} ,	
		handle : {},
		alpha : 1.0,
		backgroundColor : "none",
		height : 10,
		position:"0% 100%",
        margin:"10,50,10,50",
        height:50,
		x:0,
		y:"90%"
	};
	
	// 가장 기본 차트
	var ChartBasicConfig = {
		backgroundColor : ChartInfoConfig.backgroundColor[0],
		type : "pie",
		title : {},
		subtitle : "",
		height : "100%",
		width : "100%",
		x:"0%",
		y:"0%",
/*		preview : {} ,*/
		series : [],
		scaleX : {},//{ "values":"1998:2012:1","max-items":8 }
		scaleY : {},//{ "values":"1998:2012:1","max-items":8 }
		scaleY2 : {},//{ "values":"1998:2012:1","max-items":8 }
		scaleX2 : {},//{ "values":"1998:2012:1","max-items":8 }
		tooltip :{"visible":"true"} // "text":"%t: %v outbreaks in %k"
	};
	

	
	// options 정의
	var ChartOptionsConfig = {
		text : '', // 한문장으로 
		minLength: 3, // 문장에서 나누어지는 단어의 문자수
		ignore : [], // 단어를 배열로 입력한다.
		maxItems: 100, // 최대표현갯수
		aspect : 'spiral' , // flow-center , flow-top , spiral
		stepAngle : 5,
		stepRadius : 5,
		token : 'word'  , //"word" (default) | "character"
		style: {
		    alpha: 1.0,
		    backgroundColor: 'white',
		    borderRadius: 5,
		    fontFamily: 'Cabin Sketch', // 요건 디자인 퍼블오면 바로 바꾼다.
		    padding: '2px 5px',
		    textAlpha: 1
		  },
		words:[{text:'' , count:0}], // {text:'omg' , count:1000}
		rotate: false , // 글자를 회전시킬지유무
		
	};
	
	// 멀티차트 -- 워드클라우드용
	var ChartGrahsetConfig = {
		graphset:[]
	};
	
	// 기본차트그리기
	// id 화면내 그려질 구역이름
	function renderChart(chartData, id){
	
		//zingchart.THEME="classic"; // 만약 테마를 사용한다면
	
		zingchart.render({ // Render Method[3]
			id: id,
			data: chartData,
			height: 500,
			width: '100%'
		});
	};
	
/*	// 이미 그려진 차트에 다시 차트 그리기
	function setDataChart(chartData, id , type){
		zingchart.exec('id', 'setdata', {
			data : {type :  type , series:[values:[]] }
		}
	}*/
	
	
	// 차트별 기본정의
	
	
	// treemap 정의
	var ChartTreemapConfig = {
		type : "treemap",
		plotarea:{
               "margin":"10"
           },
		series : [{text:"test",value:0}],
		options:{
			    splitType: "alternate", // "alternate" //balanced (default), horizontal, vertical, alternate
			    aspectType: "palette", // palette(palette 이용) transition(colorStart, colorEnd)
			    alphaAspect: false,
			    thousandsSeparator: ",",
			    decimalsSeparator: ".",
			    decimals: "0",
			    palette: [], // "#c98411","#281300","#991e00","#470000","#ff921f","#feb950","#704700","#8a773c"
			    minAlpha: .4,
			    colorStart: "", // #336699
			    colorEnd: "", // #99ccff
			    box: {bordercolor:""},
			    tooltipBox: {},
			    hoverState: {
			    	alpha:1,
			        backgroundColor:""
			   }
		}
	};

	var ChartRankFlowConfig = {
		type : "rankflow",
		plotarea:{
			margin:10
	    },
	    options : {
	    	colorType : "palette",
	    	palette : [], //"red","orange","green","blue","purple"
	    	style : {
	    		tooltip : {}
	    	}
	    },
	    scaleX:{
	        labels:[], // 상단에 목차처럼 표시  "2017.01.01" , "2017.01.02" , "2017.01.03" , ""
	        values:[] // 마우스 오버 이벤트시 나타나는 표시값 "2017년1월1일" , "2017년1월2일" , "2017년1월3일" , ""
	    },
		series : [] // {text:"test",ranks:[1,1,1],rank:1}
		};
	
	var ChartHeatMapConfig = {
		type : "heatmap",
		plot : {
			valueBox: {}, // 표현되는 값의 스타일
			backgroundColor : "",
			borderWidth : "",
			borderColor : "",
			lineStyle : "",
			borderRadius : "1px",
			rules : [], // { "rule": "%v >= 60", "background-color": "orange", "border-width": 1,"line-style": "solid", "border-radius": "1px", "tooltip-text": "%v Oranges"
		},
		scaleX : {
			labels:[] , // "Sun","Mon","Tue","Wed","Thu","Fri","Sat"
			lineColor: "none",
			guide : {visible : 0},
			tick : {visible : 0},
			placement:"opposite"
		},
		scaleY : {
			labels:[] , // "Sun","Mon","Tue","Wed","Thu","Fri","Sat"
			lineColor: "none",
			guide : {visible : 0},
			tick : {visible : 0},
		},
		series : [] // {values: [59,15,5,30,60,99,28]}
	}
	
	// 차트 표형 양식 부분

/*	>>> aspect <<<
    Area : segmented | spline | stepped 
	Bar/Column : bar | cone | histogram | cylinder (3-D only) | pyramid (3-D only) 
	Bullet : bar | cone | histogram 
	Heat Map : brightness | size | vertical | horizontal | none 
	Line : segmented | spline | stepped | jumped 
	Radar : line | area | rose (or column or bar) | scatter | mixed 
	Range : segmented | spline 
	Stock : candlestick | whisker 
	
	>>> placement <<<
	Area auto | top | bottom | left | right | over 
	Bar top-out(=top) | top-in | middle | bottom-in | bottom-out(=bottom) | over 
	Bubble top | bottom | left | right | over 
	Gauge center | tip | edge 
	Heat Map top | bottom | left | right | over 
	Line auto | top | bottom | left | right | over 
	Pie out | in | center 
	Scatter top | bottom | left | right | over 

	*/

