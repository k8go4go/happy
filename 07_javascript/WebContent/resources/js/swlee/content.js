var issueKeyWrap = {
	cover : "<div class=\"issueKeyWrap\"><ul></ul></div>",
	paragraph :"<li></li>",
	period : "<div class=\"period\"><i class=\"xi-calendar\"></i><i class=\"xi-angle-right\"></i></div>",
	issueKeyList :"<ol class=\"issueKeyList\"></ol>"
};

var weeklyWrap = {
	cover : "<div class=\"weeklyWrap\"><div class=\"dateTit\"><a href=\"#\" class=\"xi-angle-left\"><span>prev</span></a><strong></strong><a href=\"#\" class=\"xi-angle-right\"><span>next</span></a></div></div>",
	weeklyDate : "<ul class=\"weeklyDate\"></ul>",
	weeklyDateCount : "<li><span></span><a href=\"#\"></a></li>",
	selectDate :  "<p class=\"sTit\"></p>",
	scrollWrapper : "<div class=\"scrollbar-inner\"></div>",
	weeklyNewsList : "<ul class=\"weeklyNewsList\"></ul>",
	weeklyNews : "<li><a href=\"#\"></a></li>",
	scrollX : "<div class=\"scroll-element scroll-x scroll-scrolly_visible\"><div class=\"scroll-element_outer\"><div class=\"scroll-element_size\"></div><div class=\"scroll-element_track\"></div><div class=\"scroll-bar\" style=\"width: 88px;\"></div></div></div>",
	scrollY : "<div class=\"scroll-element scroll-y scroll-scrolly_visible\"><div class=\"scroll-element_outer\"><div class=\"scroll-element_size\"></div><div class=\"scroll-element_track\"></div><div class=\"scroll-bar\" style=\"height: 82px; top: 31px;\"></div></div></div>",
};

var weeklyData = {
	currentWeek : "2017년 8월 2주차  ~ 2017년 8월 1주차",
	prevWeek : "2017년 8월 1주차",
	nextWeek : "2017년 8월 3주차",
	
	currentDate : {
		title : "8월 4일",
		news : [
			{ from : "네이버뉴스", tle: "11법무부, 공수처 방안 발표…\"정치 중립 지켜 성역없는 수사\"", url : "http://www.naver.com" },
			{ from : "한겨례", tle: "22법무부, 공수처 방안 발표…\"정치 중립 지켜 성역없는 수사\"", url : "http://www.naver.com" },
			{ from : "네이버뉴스", tle: "333333333333, 공수처 방안 발표…\"정치 중립 지켜 성역없는 수사\"333333333333, 공수처 방안 발표…\"정치 중립 지켜 성역없는 수사\"", url : "http://www.naver.com" },
			{ from : "네이버뉴스", tle: "44법무부, 공수처 방안 발표…\"정치 중립 지켜 성역없는 수사\"", url : "http://www.naver.com" },
			{ from : "네이버뉴스", tle: "44법무부, 공수처 방안 발표…\"정치 중립 지켜 성역없는 수사\"", url : "http://www.naver.com" },
			{ from : "네이버뉴스", tle: "44법무부, 공수처 방안 발표…\"정치 중립 지켜 성역없는 수사\"", url : "http://www.naver.com" },
			{ from : "네이버뉴스", tle: "44법무부, 공수처 방안 발표…\"정치 중립 지켜 성역없는 수사\"", url : "#" },
			{ from : "네이버뉴스", tle: "44법무부, 공수처 방안 발표…\"정치 중립 지켜 성역없는 수사\"", url : "#" },
			{ from : "네이버뉴스", tle: "44법무부, 공수처 방안 발표…\"정치 중립 지켜 성역없는 수사\"", url : "#" },
		]
	},
	
	weeklyDate : [
		{date : "08.01", cnt : "3" , active:"active"},
		{date : "08.03", cnt : "12" },
		{date : "08.04", cnt : "0" },
		{date : "08.05", cnt : "1" },
		{date : "08.06", cnt : "3" },
		{date : "08.07", cnt : "3" },
	]
}


var arr = new Array();
arr[0] = new Array(new Array(21), new Array(21), new Array(21), new Array(21));
arr[0][0] = [ 
	{period: "2017.04.02~2017.04.08"},
	{num : "1", txt : "탈당A", score : "2,452,354"},
	{num : "2", txt : "키워드A1", score : "2,452,354"}, 
	{num : "3", txt : "광명", score : "2,452,354"}, 
	{num : "4", txt : "문재인", score : "2,452,354"}, 
	{num : "5", txt : "지역구", score : "2,452,354"}, 
	{num : "6", txt : "민주당", score : "2,452,354"}, 
	{num : "7", txt : "키워드B", score : "2,452,354"}, 
	{num : "8", txt : "지역구", score : "2,452,354"}, 
	{num : "9", txt : "시의원", score : "2,452,354"}, 
	{num : "10", txt : "출신", score : "2,452,354"}, 
	{num : "11", txt : "보좌관", score : "2,452,354"},
	{num : "12", txt : "대선", score : "2,452,354"}, 
	{num : "13", txt : "갑누", score : "2,452,354"}, 
	{num : "14", txt : "전원", score : "2,452,354"}, 
	{num : "15", txt : "생각", score : "2,452,354"}, 
	{num : "16", txt : "대표", score : "2,452,354"}, 
	{num : "17", txt : "우상호", score : "2,452,354"}, 
	{num : "18", txt : "충격", score : "2,452,354"}, 
	{num : "19", txt : "원내대표", score : "2,452,354"}, 
	{num : "20", txt : "더불어민주당", score : "2,452,354"},
];

arr[0][1] = [ 
	{period: "2017년 4월"},
	{num : "1",  txt : "탈당",     score : "2,452,354"},
	{num : "2",  txt : "키워드A1",   score : "2,452,354"}, 
	{num : "3",  txt : "광명",     score : "2,452,354"}, 
	{num : "4",  txt : "문재인",    score : "2,452,354"}, 
	{num : "5",  txt : "지역구",    score : "2,452,354"}, 
	{num : "6",  txt : "민주당",    score : "2,452,354"}, 
	{num : "7",  txt : "키워드B",   score : "2,452,354"}, 
	{num : "8",  txt : "지역구",    score : "2,452,354"}, 
	{num : "9",  txt : "우상호",      score : "2,452,354"}, 
	{num : "10", txt : "충격",       score : "2,452,354"}, 
	{num : "11", txt : "원내대표",     score : "2,452,354"},
	{num : "12", txt : "더불어민주당",   score : "2,452,354"}, 
	{num : "13", txt : "시의원",       score : "2,452,354"}, 
	{num : "14", txt : "출신",        score : "2,452,354"}, 
	{num : "15", txt : "보좌관",       score : "2,452,354"}, 
	{num : "16", txt : "대선",        score : "2,452,354"}, 
	{num : "17", txt : "갑누",        score : "2,452,354"}, 
	{num : "18", txt : "전원",        score : "2,452,354"}, 
	{num : "19", txt : "생각",        score : "2,452,354"}, 
	{num : "20", txt : "대표",       score : "2,452,354"},
];

arr[0][2] = [ 
	{period: "2017년 3분기"},
	{num : "1",  txt :"전원",         score : "2,452,354"},
	{num : "2",  txt :"생각",         score : "2,452,354"}, 
	{num : "3",  txt :"대표",         score : "2,452,354"}, 
	{num : "4",  txt :"우상호",        score : "2,452,354"}, 
	{num : "5",  txt :"충격",         score : "2,452,354"}, 
	{num : "6",  txt :"원내대표",      score : "2,452,354"}, 
	{num : "7",  txt :"더불어민주당",    score : "2,452,354"}, 
	{num : "8",  txt :"탈당",        score : "2,452,354"}, 
	{num : "9",  txt :"키워드A",      score : "2,452,354"}, 
	{num : "10", txt :   "시의원",   score : "2,452,354"}, 
	{num : "11", txt :   "출신",    score : "2,452,354"},
	{num : "12", txt :   "보좌관",   score : "2,452,354"}, 
	{num : "13", txt :   "대선",   score : "2,452,354"}, 
	{num : "14", txt :   "갑누",   score : "2,452,354"}, 
	{num : "15", txt : "광명",      score : "2,452,354"}, 
	{num : "16", txt : "문재인",     score : "2,452,354"}, 
	{num : "17", txt : "지역구",     score : "2,452,354"}, 
	{num : "18", txt : "민주당",     score : "2,452,354"}, 
	{num : "19", txt : "키워드B",    score : "2,452,354"}, 
	{num : "20", txt : "지역구",    score : "2,452,354"},
];

arr[0][3] = [ 
	{period: "2017년 4월 3주"},
	{num : "1",  txt : "시의원",      score : "2,452,354"},
	{num : "2",  txt : "출신",       score : "2,452,354"}, 
	{num : "3",  txt : "보좌관",      score : "2,452,354"}, 
	{num : "4",  txt : "대선",       score : "2,452,354"}, 
	{num : "5",  txt : "갑누",       score : "2,452,354"}, 
	{num : "6",  txt : "전원",       score : "2,452,354"}, 
	{num : "7",  txt : "생각",       score : "2,452,354"}, 
	{num : "8",  txt : "대표",       score : "2,452,354"}, 
	{num : "9",  txt : "우상호",      score : "2,452,354"}, 
	{num : "10", txt : "충격",       score : "2,452,354"}, 
	{num : "11", txt : "원내대표",     score : "2,452,354"},
	{num : "12", txt : "더불어민주당",   score : "2,452,354"}, 
	{num : "13", txt : "탈당",      score : "2,452,354"}, 
	{num : "14", txt : "키워드A",    score : "2,452,354"}, 
	{num : "15", txt : "광명",      score : "2,452,354"}, 
	{num : "16", txt : "문재인",     score : "2,452,354"}, 
	{num : "17", txt : "지역구",     score : "2,452,354"}, 
	{num : "18", txt : "민주당",     score : "2,452,354"}, 
	{num : "19", txt : "키워드B",    score : "2,452,354"}, 
	{num : "20", txt : "지역구",    score : "2,452,354"},
];