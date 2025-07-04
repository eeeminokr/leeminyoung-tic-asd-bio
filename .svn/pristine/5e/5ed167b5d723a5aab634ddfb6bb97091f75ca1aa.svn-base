<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="eco" uri="www.ecoinsight.co.kr/tag" %>
<%@ include file="/include/common.inc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${incTitle}</title>
<jsp:include page='<%=incInclude %>' flush="false"></jsp:include>
<script type="text/javascript" src="${contextPath}/js/dashboardChartAsd.js"></script>

<script type="text/javascript" src="${contextPath}/js/ZingChart/zingchart.min.js"></script> 
<style>

	.chart--container {
	  height: 400px;
	  position: relative;
  		width: 50%;
	}

	.zc-ref {
	  display: none;
	}
     .grid-row-span .x-grid-row {
	    border-bottom: 0;
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
	    left : 15px;
	    text-align: center;
	    width : 100px !important;
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
	
	/* ASD군 총합 */
	.total{
	width : 185px !important;
	}
	.totalMerge{
	width : 0px !important;
	}
	.total .x-grid-cell-inner{
	left : 50px !important;
	}
	
	#ext-element-29 > td.x-grid-cell.x-grid-td.x-grid-cell-gridcolumn-1019.row-span.row-span-first.row-span-last.x-grid-cell-first{
	width : 185px !important;
	}
	
	#ext-element-29 > td.x-grid-cell.x-grid-td.x-grid-cell-gridcolumn-1019.row-span.row-span-first.row-span-last.x-grid-cell-first > div{
	left : 50px !important;
	}
	
	
	
</style>
</head>

<!-- 대시보드일때 body에 dashboard 클래스 추가 : 
     스크롤이 생기는 문제로 #bodycontainer 높이를 임의로 설정해 두었기 때문에 이부분을 없애기 위해 필요함. -->
<body class="dashboard">
	<%-- <table width="100%" border="0" cellpadding="0" cellspacing="0">
	  	<tr>
	    	<td align="center" valign="middle" height="600"><h2>DASHBOARD</h2><BR><img src="${contextPath}/images/coming_soon.jpg" alt="준비중입니다." width="767" height="260" /></td>
	  	</tr> 
	  	
	</table> --%>
	<!-- <div style="width: 1700px; padding-top: 30px;"> -->
	<br/>
	<div id="barChart" style="float : left;" class="chart--container"></div>
	<div id="lineChart" style="float : none;" class="chart--container"></div>
	<!-- </div> -->
	
	<div class="content_head">
	<h2 class="tit">수집현황</h2>  <!-- style="margin-right: 50px" -->
	<div class="btns">
		<button class="btnsStyle" onclick="excelDownload();"><img src="${contextPath}/images/img/ico_dwload.png" alt="" /><span>다운로드</span></button>
	</div>
	</div>
	<div id="dashboardList"></div>

</body>
</html>
