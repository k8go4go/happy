<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/jsp/admin/common/adminHeader.jsp"></c:import>
<c:import url="/jsp/admin/common/adminNav.jsp"></c:import>    

<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/highcharts-3d.js"></script>
	<div id="regAucStat" style="height: 500px"></div>
    <div id="regBiddingStat"></div>
    <div id="biddingStat"></div>
<script>
$(function () {
	var json = JSON.parse('${datas}');
	console.dir(json[1].name);
	console.dir(json[1].data);
	
    Highcharts.chart('regAucStat', {
        title: {
            text: '경매 등록 월별 통계',
            x: -20 //center
        },
        subtitle: {
            text: '비트 중고 경매 2017년',
            x: -20
        },
        xAxis: {
            categories: ['1월', '2월', '3월', '4월', '5월', '6월',
                '7월', '8월', '9월', '10월', '11월', '12월']
        },
        yAxis: {
            title: {
                text: '등록수'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '등록수'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [
        	{ 
        		name: json[0].name , data:json[0].data
        	}, { 
        		name: json[1].name , data:json[1].data
        	}, { 
        		name: json[2].name , data:json[2].data
        	}, { 
        		name: json[3].name , data:json[3].data
        	}, { 
        		name: json[4].name , data:json[4].data
        	}, { 
        		name: json[5].name , data:json[5].data
        	}, { 
        		name: json[6].name , data:json[6].data
        	}, { 
        		name: json[7].name , data:json[7].data
        	}, { 
        		name: json[8].name , data:json[8].data
        	},  { 
        		name: json[9].name , data:json[9].data
        	},{ 
        		name: json[10].name , data:json[10].data
        	}, {                                  
        		name: json[11].name , data:json[11].data
        	}, {                                  
        		name: json[12].name , data:json[12].data
        	}, {                                  
        		name: json[13].name , data:json[13].data
        	}, {                                  
        		name: json[14].name , data:json[14].data
        	}, {                                  
        		name: json[15].name , data:json[15].data
        	}, {                                  
        		name: json[16].name , data:json[16].data
        	}, {                                  
        		name: json[17].name , data:json[17].data
        	}, {                                  
        		name: json[18].name , data:json[18].data
        	},  {                                 
        		name: json[19].name , data:json[19].data
        	},{                                   
        		name: json[20].name , data:json[20].data
        	}, {                                  
        		name: json[21].name , data:json[21].data
        	}, {                                  
        		name: json[22].name , data:json[22].data
        	}, {                                  
        		name: json[23].name , data:json[23].data
        	}, {                                  
        		name: json[24].name , data:json[24].data
        	}, {                                  
        		name: json[25].name , data:json[25].data
        	}, {                                  
        		name: json[26].name , data:json[26].data
        	},                                    
        ]
    });
});
</script>
<c:import url="/jsp/admin/common/adminFooter.jsp"></c:import>