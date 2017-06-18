<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/jsp/admin/common/adminHeader.jsp"></c:import>
<c:import url="/jsp/admin/common/adminNav.jsp"></c:import>    

<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/highcharts-3d.js"></script>
	<div id="regAucStat" style="height: 600px;"></div>
    <div id="regBiddingStat" style="height: 600px;"></div>
    <div id="biddingStat" style="height: 600px;"></div>
<script>
$(function () {
	var json = JSON.parse('${datas1}');
	var categoriesData = ['1월', '2월', '3월', '4월', '5월', '6월',
        '7월', '8월', '9월', '10월', '11월', '12월']; 
    var seriesData = json; 
     
    var json2 = JSON.parse('${datas2}');
    var seriesData2 = json2; 
    
    var json3 = JSON.parse('${datas3}');
    var seriesData3 = json3;
    
    Highcharts.chart('regAucStat', {
        title: {
            text: '경매 등록 월별 통계[회원별]',
            x: -20 //center
        },
        subtitle: {
            text: '비트 중고 경매 2017년',
            x: -20
        },
        xAxis: {
            categories: categoriesData
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
        series: seriesData
    });
    
    
    Highcharts.chart('regBiddingStat', {
    	chart: {
    		type: 'column',
            margin: 75,
            options3d: {
				enabled: true,
                alpha: 15,
                beta: 15,
                depth: 110
            }
        },
        
        plotOptions: {
            column: {
                depth: 40,
                stacking: true,
                grouping: false,
                groupZPadding: 10
            }
        },
        title: {
            text: '경매 입장 월별 통계[경매별]',
            x: -20 //center
        },
        subtitle: {
            text: '비트 중고 경매 2017년',
            x: -20
        },
        xAxis: {
            categories: categoriesData
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
        series: seriesData2
    });
    
    Highcharts.chart('biddingStat', {
    	chart: {
            type: 'column',
            margin: 75,
            options3d: {
				enabled: true,
                alpha: 15,
                beta: 15,
                depth: 50
            }
        },
        title: {
            text: '경매 입찰 월별 통계[경매별]',
            x: -20 //center
        },
        subtitle: {
            text: '비트 중고 경매 2017년',
            x: -20
        },
        plotOptions: {
            column: {
                depth: 25
            }
        },
        xAxis: {
            categories: categoriesData
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
        series: seriesData3
    });
});
</script>
<c:import url="/jsp/admin/common/adminFooter.jsp"></c:import>