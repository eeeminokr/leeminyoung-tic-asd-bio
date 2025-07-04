<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="eco" uri="www.ecoinsight.co.kr/tag"%>
<%@ include file="/include/common.inc"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${incTitle}</title>
<jsp:include page='<%=incInclude %>' flush="false"></jsp:include>
<script src="https://cdn.amcharts.com/lib/5/index.js"></script>
<script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
<script type="text/javascript"
	src="${contextPath}/js/dashboardBarChart.js"></script>
<script type="text/javascript"
	src="${contextPath}/js/dashboardLineChart.js"></script>
<script type="text/javascript" src="${contextPath}/js/dashboardList.js"></script>
<style>
.chart--container {
	/* 	  height: 400px;
	  position: relative;
  		width: 50%; */
	display: flex;
	width: 100%;
}

.zc-ref {
	display: none;
}

.grid-row-span {
	flex: 1;
}

.grid-row-span .x-grid-row {
	border-bottom: 0;
	min-height: 36px;
	max-height: 50px;
	height: 40px;
}

.grid-row-span .x-grid-item {
	border-style: none;
}

.grid-row-span .x-grid-td {
	border-bottom: 1px solid #ededed;
}

.grid-row-span .row-span {
	border-bottom: 1px solid #fff;
}

.grid-row-span .row-span-first {
	position: relative;
	padding: 0 0 20px 1px;
	position: static;
}

.grid-row-span .row-span-first .x-grid-cell-inner {
	position: absolute;
	white-space: normal;
	overflow: visible;
	display: table;
	z-index: 9999;
	left: 15px;
	text-align: center;
	width: 100px !important;
}

.grid-row-span .row-span-first .x-grid-cell-inner {
	display: table-cell;
	vertical-align: middle;
}

.grid-row-span .row-span-last {
	border-bottom: 1px solid #ededed;
}

/* 항목  */
.title-header>div:nth-of-type(1) {
	height: 50px;
	display: table-cell;
	padding-left: 10px;
	vertical-align: middle;
}

/* TIC군 총합 */
.total {
	width: 185px !important;
}

.totalMerge {
	width: 0px !important;
}

.total .x-grid-cell-inner {
	left: 50px !important;
}

body {
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto,
		Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji",
		"Segoe UI Symbol";
	font-size: 9pt;
}

body, html {
	height: 100%;
	margin: 0;
	overflow: hidden; /* to remove the default margin and scrollbar */
}

.chart--container {
	height: 50%;
	display: flex;
	width: 100%;
}

#chartdiv, #chartdiv2 {
	flex: 1;
}

#chartdiv2 {
	margin-left: 10px;
}

#chartList {
	height: 50%;
	width: 100%;
	overflow: auto;
	overflow: scroll;
	padding-bottom: 100px;
}

#chartList::-webkit-scrollbar {
	display: none;
	overflow: scroll;

	/*   height: 400px; */
}

/* Other styles remain unchanged */
</style>
</head>

<!-- 대시보드일때 body에 dashboard 클래스 추가 : 
     스크롤이 생기는 문제로 #bodycontainer 높이를 임의로 설정해 두었기 때문에 이부분을 없애기 위해 필요함. -->
<body class="dashboard">
	<br />
	<div class="chart--container">
		<div id="chartdiv"></div>
		<div id="chartdivChild"></div>
		<div id="chartdiv2"></div>
	</div>
	<!--     <div class="chart--container">
        <div id="barChart"></div>
        <div id="lineChart"></div>
    </div> -->
	<div style="width: 100%; padding-top: 100px;">
		<div class="content_head">
			<h2 class="tit">수집현황</h2>
			<div class="btns">
				<button class="btnsStyle" onclick="excelDownload();">
					<img src="${contextPath}/images/img/ico_dwload.png" alt="" /> <span>다운로드</span>
				</button>
			</div>
		</div>

		<div id="dashboardList"></div>
	</div>
</body>
<script>



</script>

</html>
