/**
 * Create: 2017.08.17
 * Author: 송원진
 * Purpose: 로그인처리관련기능정의
 */

$(document).ready(function(){

	/*var mediaColor = {
			M:"#6D55CD",
			T:"#568BCC",
			F:"#37579D",
			B:"#64C15D",
			R:"#64C15D",
			C:"#CA6555",
			A:"#7A8D92"
		};
	zingchart.THEME="classic";
	var myConfig = {
	    "background-color":mediaColor.T,
	    "type":"line",
	    "title":{
	        "text":"Yearly Outbreaks by Genus",
	        "color":"#333",
	        "background-color":"white",
	        "width":"60%",
	        "text-align":"left",
	    },
	    "subtitle":{
	        "text":"Toggle a legend item to remove the series and adjust the scale.",
	        "text-align":"left",
	        "width":"60%"
	    },
		"legend":{
	        "layout":"x1",
	        "margin-top":"5%",
	        "border-width":"0",
	        "shadow":false,
	        "marker":{
	            "cursor":"hand",
	            "border-width":"0"
	        },
	        "background-color":"white",
	        "item":{
	            "cursor":"hand"
	        },
	        "toggle-action":"remove"
	    },
		"scaleX":{
	        "values":"1998:2012:1",
	        "max-items":8
		},
		"scaleY":{
	        "line-color":"#333"
		},
	    "tooltip":{
	        "text":"%t: %v outbreaks in %k"
	    },
		"plot":{
	        "line-width":3,
	        "marker":{
	            "size":2
	        },
	        "selection-mode":"multiple",
	        "background-mode":"graph",
	        "selected-state":{
	            "line-width":4
	        },
	        "background-state":{
	            "line-color":"#eee",
	            "marker":{
	                "background-color":"none"
	            }
	        }
		},
	    "plotarea":{
	        "margin":"15% 25% 10% 7%"
	    },
		"series":[
	        {
	            "values":[783,672,621,466,427,315,382,299,363,363,350,213,261,287,243],
	            "text":"Undeclared",
	            "line-color":"#a6cee3",
	            "marker":{
	                "background-color":"#a6cee3",
	                "border-color":"#a6cee3"
	            }
	        },
	        {
	            "values":[148,137,149,134,132,136,141,115,120,146,117,118,132,114,116],
	            "text":"Salmonella",
	            "line-color":"#1f78b4",
	            "marker":{
	                "background-color":"#1f78b4",
	                "border-color":"#1f78b4"
	            }
	        },
	        {
	            "values":[73,199,276,305,367,285,496,283,503,321,358,198,303,224,288],
	            "text":"Norovirus",
	            "line-color":"#b2df8a",
	            "marker":{
	                "background-color":"#b2df8a",
	                "border-color":"#b2df8a"
	            }
	        },
	        {
	            "values":[19,12,6,6,8,9,9,6,8,1,2,2,6,8,12],
	            "text":"Vibrio",
	            "line-color":"#33a02c",
	            "marker":{
	                "background-color":"#33a02c",
	                "border-color":"#33a02c"
	            }
	        },
	        {
	            "values":[32,31,35,24,33,26,21,23,30,44,36,36,30,28,30],
	            "text":"E.coli",
	            "line-color":"#fb9a99",
	            "marker":{
	                "background-color":"#fb9a99",
	                "border-color":"#fb9a99"
	            }
	        },
	        {
	            "values":[12,12,12,6,7,6,2,6,5,4,1,2,3,1,0],
	            "text":"Hepatitis",
	            "line-color":"#e31a1c",
	            "marker":{
	                "background-color":"#e31a1c",
	                "border-color":"#e31a1c"
	            }
	        },
	        {
	            "values":[39,58,63,59,64,50,39,34,29,21,14,13,10,12,8],
	            "text":"Staphylococcus",
	            "line-color":"#fdbf6f",
	            "marker":{
	                "background-color":"#fdbf6f",
	                "border-color":"#fdbf6f"
	            }
	        },
	        {
	            "values":[56,53,60,61,65,52,58,42,39,50,44,30,34,23,32],
	            "text":"Clostridium",
	            "line-color":"#ff7f00",
	            "marker":{
	                "background-color":"#ff7f00",
	                "border-color":"#ff7f00"
	            }
	        },
	        {
	            "values":[15,6,15,20,22,22,15,25,27,30,26,16,28,33,38],
	            "text":"Campylobacter",
	            "line-color":"#cab2d6",
	            "marker":{
	                "background-color":"#cab2d6",
	                "border-color":"#cab2d6"
	            }
	        },
	        {
	            "values":[19,15,13,16,12,14,11,8,10,11,6,4,5,4,2],
	            "text":"Shigella",
	            "line-color":"#ffff99",
	            "marker":{
	                "background-color":"#ffff99",
	                "border-color":"#ffff99"
	            }
	        },
	        {
	            "values":[33,30,35,26,27,38,29,25,30,18,9,5,10,10,15],
	            "text":"Scombroid",
	            "line-color":"#6a3d9a",
	            "marker":{
	                "background-color":"#6a3d9a",
	                "border-color":"#6a3d9a"
	            }
	        },
	        {
	            "values":[1,1,0,3,3,1,2,0,0,0,0,0,0,1,2],
	            "text":"Yersinia",
	            "line-color":"#b15928",
	            "marker":{
	                "background-color":"#b15928",
	                "border-color":"#b15928"
	            }
	        },
	        {
	            "values":[32,32,56,62,82,65,57,40,33,41,26,12,15,10,3],
	            "text":"Bacillus"
	        },
	        {
	            "values":[2,5,2,2,1,2,0,4,4,1,3,2,5,5,5],
	            "text":"Listeria"
	        },
	        {
	            "values":[1,0,1,0,0,0,0,0,0,0,0,1,1,0,0],
	            "text":"Pesticides"
	        },
	        {
	            "values":[1,2,2,2,3,0,3,5,3,0,3,1,0,2,0],
	            "text":"Cyclospora"
	        },
	        {
	            "values":[18,15,19,26,23,18,10,10,10,14,15,10,5,15,8],
	            "text":"Ciguatoxin"
	        },
	        {
	            "values":[1,0,1,0,2,2,1,0,4,4,2,0,0,4,0],
	            "text":"Cryptosporidium"
	        },
	        {
	            "values":[1,0,0,0,0,0,0,0,0,0,0,0,0,0,1],
	            "text":"Streptococcus"
	        },
	        {
	            "values":[27,53,28,11,32,38,35,33,33,13,6,4,2,17,13],
	            "text":"Other"
	        }
		]
	};
	 
	zingchart.render({ 
		id : 'myChart', 
		data : myConfig, 
		height: 500, 
		width: '100%' 
	});*/
});


function draw(){
	var myConfig1 = {

		    "type":"line",
		    "subtitle" : "서브 타이틀부분",
		    marginBottom:"100px",
			"legend":{
		        "layout":"h",
		        "callout" : true,
		        "margin":"0",
		        "border-width":"1",
		        "shadow":false,
		        height : 20,
		        width : 100,
		      //  toggleAction: "hide",
		       // offsetX : 0,
		      //  x : 510,
		        "verticalAlign" : "bottom",
		        "overflow" : "page",
		        //"max-items" : 5,

		        "background-color":"",
		        "item":{
		            "cursor":"hand"
		        },
		        "header":{
		              "text":""
		            },
		           
		      //  "toggle-action":"remove"
		    },
		"scaleX":{
			zooming:true,
			thousandsSeparator: ",",
		        "max-items":3
			},
			"scaleY":{
				zooming:true,
				thousandsSeparator: ",",
		        "line-color":"#333"
			},
		    "tooltip":{
		        "visible":"true"
		    },
			"plot":{
		        "line-width":3,
		        "marker":{
		            "size":2
		        },
		        "selection-mode":"multiple",
		        "background-mode":"graph",
		        "selected-state":{
		            "line-width":4
		        },
		        "background-state":{
		            "line-color":"#eee",
		            "marker":{
		                "background-color":"none"
		            }
		        }
			},
		    "plotarea":{
		        "margin":"15% 25% 10% 7%"
		    },
			"series":[
		      
			]
		};
/*	ChartTitleConfilg.text = "who!";
	var  myConfig = $.extend(true, {}, ChartBasicConfig);
	myConfig.scaleX.minValue = "1990"; // 가로목차 값범위는 지정해줘야 한다.
	myConfig.scaleX.offset ="0"; // 가로목차 값범위는 지정해줘야 한다.
	myConfig.scaleX.step ="year"; // 가로목차 값범위는 지정해줘야 한다.
*/	//myConfig.scaleX.transform ="{type: 'date', all: '%M %d'}"; // 가로목차 값범위는 지정해줘야 한다.
	//myConfig.scaleX.zoomSnap ="1"; // 가로목차 값범위는 지정해줘야 한다.
//	myConfig.scaleX.zoomTo =[1995,2000]; // 가로목차 값범위는 지정해줘야 한다.
/*	myConfig.title = ChartTitleConfilg;
	myConfig.subtitle = ChartSubtitleConfig;
	myConfig.legend= ChartLegendConfig;
	myConfig.plot = ChartPlotConfig;
	var ChartSeriesConfigcopy1 =$.extend(true, {}, ChartSeriesConfig);
	//ChartSeriesConfigcopy1.values = [1710,520,730,510,720,550,700,500,600,5100,1500,1500,500,500,500];
	//var values = {values:300};
	
	ChartSeriesConfigcopy1.values.push(200);
	//ChartSeriesConfigcopy1.values.push(100);
	ChartSeriesConfigcopy1.text = "멀까!";
	ChartSeriesConfigcopy1.lineColor = "gold";
	
	var ChartSeriesConfigcopy2 =$.extend(true, {}, ChartSeriesConfig);
	//ChartSeriesConfigcopy2.values = [1110,1220,330,210,320,450,500,100,200,300,1510,1520,1530,1540,900];
	ChartSeriesConfigcopy2.values.push(100);
	ChartSeriesConfigcopy2.text = "멀까2!";
	ChartSeriesConfigcopy2.lineColor = "blue";
	var ChartSeriesConfigcopy3 =$.extend(true, {}, ChartSeriesConfig);
	ChartSeriesConfigcopy3.values.push(120);
	var ChartMarkerConfigcopy1 =$.extend(true, {}, ChartSeriesConfig);
	ChartMarkerConfigcopy1.size = 20;
	ChartSeriesConfigcopy1.marker = ChartMarkerConfigcopy1;
	myConfig.series.push(ChartSeriesConfigcopy1);
	myConfig.series.push(ChartSeriesConfigcopy2);
	myConfig.series.push(ChartSeriesConfigcopy3);*/
	// 라인차트일경우나 bar 스택아닌경우
	// 1 . 기본 차트 설정부분을 선언한다. 값들의 상호 영향을 미칠수 있으니 꼭 복사한다.
	var  myConfig = $.extend(true, {}, ChartBasicConfig);
	myConfig.type = "bar"; // 차트의 종류를 선언하낟.
	// 2. 제목 서브 제목을 설정한다.
	myConfig.title.text= "차트 한번 그려본다."; // 제목을 지정한다.  -- 필요없을시 선언안하거나 공백
	//myConfig.title = ChartTitleConfilg;
	//myConfig.subtitle = "서브제목 여기한번 써본다.";
	// 자세한 제목설정은 ChartTitleConfilg , ChartSubtitleConfig 을 이용한다.
	// 3. 라인 바차트형식 가로축을 설정한다. 표시될 최소값,최고 값,한화면에 나타날 갯수지정한다.
	myConfig.scaleX.values = "1998:2010:1";
	myConfig.scaleX.transform ="{type: 'date', all: '%M %d'}";
	//myConfig.scaleX.maxItems = 5;
	myConfig.scaleX.	zooming =1;
	// 4. 세로축에 관련된 설정을 한다. - 가로축의 경우 값설정이 없다면 1부터 시작하지만 세로축은 series 의 값에 따라 기본저으로 표현이된다.
	//myConfig.scaleX.values = "";
	// scale 에 관련된 세부 설정은 ChartScaleXConfig , ChartScaleYConfig 
	myConfig.scaleY.thousandsSeparator = ",";
	myConfig.scaleY.maxValue = 100;

	// 5. legend 를 설정한다. 차트 하단이나 측면에 목차형식표현
	myConfig.legend = ChartLegendConfig;
	// 5.1 legend 세부 설정을 한다.
	myConfig.legend.draggable = 0;
	myConfig.legend.maxItems = 3;
	myConfig.legend.overflow = "scroll";
	
	// 6. 전체에 적용될 스타일을 지정한다.
	// 이곳에서 스타일을 적용하면 전체에 스타일이 지정되므로 각 영역단위로 스타일을 지정하는 편이 좋다.
	var ChartPlotConfigCopy1 =$.extend(true, {}, ChartPlotConfig);
	ChartPlotConfigCopy1.stackType = "100%";
	//ChartPlotConfigCopy1.stacked =0;
	myConfig.plot = ChartPlotConfigCopy1;
	
	// 7. 차트에 표현될 값과 값들이 표현된 라인이나 파이 바등의 스타일을 지정한다.
	// 7-1 표현된 값의 영역수 만큼 지정해야 한다.
	var ChartSeriesConfigcopy1 =$.extend(true, {}, ChartSeriesConfig);
	ChartSeriesConfigcopy1.values = [310,1320,1430,1410,1420,1450,1400,1480,1360,1400,1500,1501,1510,1503,1507]; // 이값을 파악해서 scare 부분을 조정해줘야 가로 축이 보기 좋게 표현된다.
	ChartSeriesConfigcopy1.lineColor = "blue"; // 라인차트인경우 색지정
	ChartSeriesConfigcopy1.backgroundColor = "blue"; // 라인차트인경우 색지정
	ChartSeriesConfigcopy1.text = "값1!"; // 목차등에 표시될 값의 이름
	// 8. 차트에 표시될 마커
	var ChartMarkerConfigCopy1 =$.extend(true, {}, ChartMarkerConfig);
	ChartMarkerConfigCopy1.backgroundColor = "blue";
	ChartMarkerConfigCopy1.borderColor = "gray";
	ChartMarkerConfigCopy1.borderWidth = 1;
	ChartMarkerConfigCopy1.size = 3;
	
	ChartSeriesConfigcopy1.marker = ChartMarkerConfigCopy1;
	myConfig.series.push(ChartSeriesConfigcopy1);
	
	
	var ChartSeriesConfigcopy2 =$.extend(true, {}, ChartSeriesConfig);
	ChartSeriesConfigcopy2.values = [2400,2420,2422,2415,1420,2020,2110,1480,1760,1980,2000,2101,1787,1456,1211]; // 이값을 파악해서 scare 부분을 조정해줘야 가로 축이 보기 좋게 표현된다.
	ChartSeriesConfigcopy2.lineColor = "green"; // 라인차트인경우 색지정
	ChartSeriesConfigcopy2.backgroundColor = "green"; // 라인차트인경우 색지정
	ChartSeriesConfigcopy2.text = "값2!"; // 목차등에 표시될 값의 이름
	var ChartMarkerConfigCopy2 =$.extend(true, {}, ChartMarkerConfig);
	ChartMarkerConfigCopy2.backgroundColor = "yellow";
	ChartMarkerConfigCopy2.borderColor = "gray";
	ChartMarkerConfigCopy2.borderWidth = 1;
	ChartMarkerConfigCopy2.size = 3;
	ChartSeriesConfigcopy2.marker = ChartMarkerConfigCopy2;
	myConfig.series.push(ChartSeriesConfigcopy2);
	
	var ChartSeriesConfigcopy3 =$.extend(true, {}, ChartSeriesConfig);
	ChartSeriesConfigcopy3.values = [2000,1420,2400,2115,1020,2090,2210,1780,1960,2080,2000,3101,1987,1746,211]; // 이값을 파악해서 scare 부분을 조정해줘야 가로 축이 보기 좋게 표현된다.
	ChartSeriesConfigcopy3.lineColor = "#00afa4"; // 라인차트인경우 색지정
	ChartSeriesConfigcopy3.backgroundColor = "#00afa4"; // 라인차트인경우 색지정
	ChartSeriesConfigcopy3.text = "값3!"; // 목차등에 표시될 값의 이름

	myConfig.series.push(ChartSeriesConfigcopy3);

	renderChart(myConfig , 'myChart');
	
	// 2개이상의 차트를 그린다. 
	// 양쪽으로 벌어지는 긍부정차트
	var  myMultConfig = $.extend(true, {}, ChartGrahsetConfig);
	
	var  myConfigM1 = $.extend(true, {}, ChartBasicConfig);
	myConfigM1.type = "hbar"; // 차트의 종류를 선언하낟.
	myConfigM1.width = "40%";
	myConfigM1.height = "90%";
	myConfigM1.x = "0%";
	myConfigM1.y = "0";
	var ChartSeriesConfigcopym1 =$.extend(true, {}, ChartSeriesConfig);
	ChartSeriesConfigcopym1.values = [-310,-1320,-1430,-1410,-1420,-1450,-1400,-1480,-1360,-1400,-1500,-1501,-1510,-1503,-1507]; // 이값을 파악해서 scare 부분을 조정해줘야 가로 축이 보기 좋게 표현된다.
	ChartSeriesConfigcopym1.text = "값1!"; // 목차등에 표시될 값의 이름
	myConfigM1.series.push(ChartSeriesConfigcopym1);
	myConfigM1.scaleX.values=['','','','','','','','','','','','','','',];
	myConfigM1.scaleX.lineWidth=0;
	myConfigM1.scaleX.tick={visible:0};
	//myConfigM1.scaleX.tick.visible=0;
	

	myConfigM1.scaleX2.values="27:33:1";
	myConfigM1.scaleX2.values=['웃다','감사하다','잘하다','좋은','지지하다','시작하다','기쁨','사람','했빛','긍정','플러스','이익','이자','소득',];
	myMultConfig.graphset.push(myConfigM1);
	
	
	var  myConfigM2 = $.extend(true, {}, ChartBasicConfig);
	myConfigM2.type = "hbar"; // 차트의 종류를 선언하낟.
	myConfigM2.width = "40%";
	myConfigM2.height = "90%";
	myConfigM2.x = "50%";
	myConfigM2.y = "0";
	myConfigM2.scaleX.values=['슬픔','감사하다','잘하다','좋은','지지하다','낭비하다','기쁨','사람','했빛','긍정','플러스','이익','이자','지출',];
	var ChartSeriesConfigcopym2 =$.extend(true, {}, ChartSeriesConfig);
	ChartSeriesConfigcopym2.values = [310,1320,1430,1410,1420,1450,1400,1480,1360,1400,1500,1501,1510,1503,1507]; // 이값을 파악해서 scare 부분을 조정해줘야 가로 축이 보기 좋게 표현된다.
	ChartSeriesConfigcopym2.text = "값2!"; // 목차등에 표시될 값의 이름
	ChartSeriesConfigcopym2.backgroundColor = "red"; // 목차등에 표시될 값의 이름
	myConfigM2.series.push(ChartSeriesConfigcopym2);

	myMultConfig.graphset.push(myConfigM2);
	
	renderChart(myMultConfig , 'myChart2');
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 파이
	var  myConfigP1 = $.extend(true, {}, ChartBasicConfig);
	myConfigP1.type = "pie";  // 파이는 pie , 도넛형태는 ring
	myConfigP1.title.text= "파이차트를 그려봅시다.";
	myConfigP1.width = "100%";
	myConfigP1.scaleR = ChartScaleRConfig;
	//myConfigP1.scaleR.aperture = 270;
	var ChartSeriesConfigcopyP1 =$.extend(true, {}, ChartSeriesConfig);
	var ChartSeriesConfigcopyP2 =$.extend(true, {}, ChartSeriesConfig);
	var ChartSeriesConfigcopyP3 =$.extend(true, {}, ChartSeriesConfig);
	ChartSeriesConfigcopyP1.values=[20];
	ChartSeriesConfigcopyP2.values=[10];
	ChartSeriesConfigcopyP3.values=[50];
	myConfigP1.series.push(ChartSeriesConfigcopyP1);
	myConfigP1.series.push(ChartSeriesConfigcopyP2);
	myConfigP1.series.push(ChartSeriesConfigcopyP3);
	
	renderChart(myConfigP1 , 'myChartp1');
	
	// 파이
	var  myConfigP2 = $.extend(true, {}, ChartBasicConfig);
	myConfigP2.type = "ring";  // 파이는 pie , 도넛형태는 ring
	myConfigP2.title.text= "링차트를 그려봅시다.";
	myConfigP2.width = "100%";
	myConfigP2.scaleR = ChartScaleRConfig;
	//myConfigP1.scaleR.aperture = 270;
	var ChartPlotConfigCopyp1 =$.extend(true, {}, ChartPlotConfig);
	
	var ChartSeriesConfigcopyP12 =$.extend(true, {}, ChartSeriesConfig);
	var ChartSeriesConfigcopyP22 =$.extend(true, {}, ChartSeriesConfig);
	var ChartSeriesConfigcopyP32 =$.extend(true, {}, ChartSeriesConfig);
	ChartSeriesConfigcopyP12.values=[200];
	ChartSeriesConfigcopyP12.text="하나";
	ChartSeriesConfigcopyP12.lineColor="red";
	ChartSeriesConfigcopyP22.values=[110];
	ChartSeriesConfigcopyP22.text="둘";
	ChartSeriesConfigcopyP22.lineColor="red";
	ChartSeriesConfigcopyP32.values=[510];
	ChartSeriesConfigcopyP32.text="셋";
	ChartSeriesConfigcopyP32.lineColor="red";
	myConfigP2.plot = ChartPlotConfigCopyp1;
	myConfigP2.tooltip = CharTooltipConfig;
	myConfigP2.series.push(ChartSeriesConfigcopyP12);
	myConfigP2.series.push(ChartSeriesConfigcopyP22);
	myConfigP2.series.push(ChartSeriesConfigcopyP32);
	
	renderChart(myConfigP2 , 'myChartp2');
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// 라인차트그려보자
	// 1 . 기본 차트 설정부분을 선언한다. 값들의 상호 영향을 미칠수 있으니 꼭 복사한다.
	var  myConfigL1 = $.extend(true, {}, ChartBasicConfig);
	myConfigL1.type = "line"; // 차트의 종류를 선언하낟.
	// 2. 제목 서브 제목을 설정한다.
	myConfigL1.title.text= "라인차트를 그려봅시다."; // 제목을 지정한다.  -- 필요없을시 선언안하거나 공백

	// 3. 라인 바차트형식 가로축을 설정한다. 표시될 최소값,최고 값,한화면에 나타날 갯수지정한다.
	myConfigL1.scaleX.values = "1998:2010:1";
	myConfigL1.scaleX.step = "year";



	myConfigL1.scaleX.zooming =1;
	// 4. 세로축에 관련된 설정을 한다. - 가로축의 경우 값설정이 없다면 1부터 시작하지만 세로축은 series 의 값에 따라 기본저으로 표현이된다.
	//myConfig.scaleX.values = "";
	// scale 에 관련된 세부 설정은 ChartScaleXConfig , ChartScaleYConfig 
	myConfigL1.scaleY.thousandsSeparator = ",";

	// 5. legend 를 설정한다. 차트 하단이나 측면에 목차형식표현
	myConfigL1.legend = ChartLegendConfig;
	// 5.1 legend 세부 설정을 한다.
	myConfigL1.legend.draggable = 1;
	myConfigL1.legend.maxItems = 2;
	myConfigL1.legend.overflow = "page";
	myConfigL1.legend.margin = "5px 0px 15px 20px";
	myConfigL1.legend.padding = "0";

	// 6 . 줌차트를 위한 미리보기 기능구현 
	//myConfigL1.myConfigL1.live = 1; // 미리보기
	myConfigL1.preview = CharPreviewConfig;
	// 7. 차트에 표현될 값과 값들이 표현된 라인이나 파이 바등의 스타일을 지정한다.
	// 7-1 표현된 값의 영역수 만큼 지정해야 한다.
	var ChartSeriesConfigcopyL1 =$.extend(true, {}, ChartSeriesConfig);
	ChartSeriesConfigcopyL1.values = [310,1320,1430,1410,1420,1450,1400,1480,1360,1400,1500,1501,1510,1503,1507]; // 이값을 파악해서 scare 부분을 조정해줘야 가로 축이 보기 좋게 표현된다.
	ChartSeriesConfigcopyL1.lineColor = "blue"; // 라인차트인경우 색지정
	ChartSeriesConfigcopyL1.backgroundColor = "blue"; // 라인차트인경우 색지정
	ChartSeriesConfigcopyL1.text = "값1!"; // 목차등에 표시될 값의 이름
	// 8. 차트에 표시될 마커
	var ChartMarkerConfigCopyL1 =$.extend(true, {}, ChartMarkerConfig);
	ChartMarkerConfigCopyL1.backgroundColor = "blue";
	ChartMarkerConfigCopyL1.borderColor = "gray";
	ChartMarkerConfigCopyL1.borderWidth = 1;
	ChartMarkerConfigCopyL1.size = 3;
	
	ChartSeriesConfigcopyL1.marker = ChartMarkerConfigCopyL1;
	myConfigL1.series.push(ChartSeriesConfigcopyL1);
	
	
	var ChartSeriesConfigcopyL2 =$.extend(true, {}, ChartSeriesConfig);
	ChartSeriesConfigcopyL2.values = [2400,2420,2422,2415,1420,2020,2110,1480,1760,1980,2000,2101,1787,1456,1211]; // 이값을 파악해서 scare 부분을 조정해줘야 가로 축이 보기 좋게 표현된다.
	ChartSeriesConfigcopyL2.lineColor = "green"; // 라인차트인경우 색지정
	ChartSeriesConfigcopyL2.backgroundColor = "green"; // 라인차트인경우 색지정
	ChartSeriesConfigcopyL2.text = "라인2!"; // 목차등에 표시될 값의 이름

	myConfigL1.series.push(ChartSeriesConfigcopyL2);
	
	var ChartSeriesConfigcopyL3 =$.extend(true, {}, ChartSeriesConfig);
	ChartSeriesConfigcopyL3.values = [2000,1420,2400,2115,1020,2090,2210,1780,1960,2080,2000,3101,1987,1746,211]; // 이값을 파악해서 scare 부분을 조정해줘야 가로 축이 보기 좋게 표현된다.
	ChartSeriesConfigcopyL3.lineColor = "#00afa4"; // 라인차트인경우 색지정
	ChartSeriesConfigcopyL3.backgroundColor = "#00afa4"; // 라인차트인경우 색지정
	ChartSeriesConfigcopyL3.text = "라인3!"; // 목차등에 표시될 값의 이름

	myConfigL1.series.push(ChartSeriesConfigcopyL3);

	renderChart(myConfigL1 , 'myChartL1');
	
	
	
	
}

