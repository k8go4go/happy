var template = 
 "<div class=\"grid-stack-item\" data-gs-x=\"0\" data-gs-y=\"0\" data-gs-width=\"4\" data-gs-height=\"1\" data-gs-no-resize=\"true\" data-gs-no-move=\"true\">"
+"		<div class=\"grid-stack-item-content\">                                                                                                               "
+"			<div class=\"tit\">                                                                                                                               "
+"				<i class=\"xi-drag-vertical\"></i><strong>이슈 미디어이슈 미디어</strong>                                                                               "
+"			</div>                                                                                                                                            "
+"			<div class=\"sub\">                                                                                                                               "
+"			</div>                                                                                                                                            "
+"			<div class=\"cont\">                                                                                                                              "
+"				<div id=\"tableid\">                                                                                                                          "
+"			</div>                                                                                                                                            "
+"		</div>                                                                                                                                                "
+"</div>                                                                                                                                                      "
	;                                                                                                                                                         

var widget1 = $w(
	{
		x:0, 
		y:0, 
		maxWidth:5,
		width:5, 
		height:5 
	}, 
	{
		title:"test1", 
		id : "w1",
		download : true,
		hasChannels : false
	}, 
template);

var widget2 = $w(
	{
		x:0, 
		y:0, 
		maxWidth:5,
		width:5, 
		height:5, 
	}, 
	{
		title:"test2", 
		id : "w2",			
		download : true,
		hasChannels : true,
		channels : [
			{name : 'a' , url:''},
			{name : 'tw', url:''},
			{name : 'fb', url:''},
			{name : 'b' , url:''},
			{name : 'nv', url:''},
		]
	}, 
template);


console.log(widget1);
console.log(widget2);
