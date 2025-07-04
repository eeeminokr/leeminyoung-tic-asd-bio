<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="eco" uri="www.ecoinsight.co.kr/tag" %>
<meta http-equiv="X-UA-Compatible" content="IE=edge" /> 

<%-- <script type="text/javascript" src="${contextPath}/js/jquery/jquery-3.3.1.min.js" ></script> --%>
<%-- <script type="text/javascript" src="${contextPath}/js/jquery/jquery-1.3.2.min.js"></script> --%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" src="${contextPath}/js/ExtJS62/ext-all.js"></script>
<script type="text/javascript" src="${contextPath}/js/ExtJS62/theme-crisp.js"></script>
<script type="text/javascript" src="${contextPath}/js/ExtJS62/locale/ext-locale-ko.js"></script>
<script type="text/javascript" src="${contextPath}/js/ExtJS62/charts.js"></script> 

<script type="text/javascript" src="${contextPath}/js/function.js"></script>
<script type="text/javascript" src="${contextPath}/js/component.js"></script>
<script type="text/javascript" src="${contextPath}/include/common.jsp"></script>

<script type="text/javascript" src="${contextPath}/js/ExtJS62/MonthPickerPlugin.js"></script>
<script type="text/javascript" src="${contextPath}/js/ExtJS62/PagingToolbarResizer.js"></script>
<script type="text/javascript" src="${contextPath}/js/jquery/jquery.cookie.js"></script>
<!-- stylesheet -->
<!-- <link rel="stylesheet" type="text/css" href="css/common.css" /> -->
<link rel="stylesheet" type="text/css" href="${contextPath}/css/ExtJS62/font-ext-all.css" />
<!-- <link rel="stylesheet" type="text/css" href="${contextPath}/css/style3.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/left.css" /> -->
<link rel="stylesheet" type="text/css" href="${contextPath}/css/extjs/theme-crisp/theme-crisp-all.css"/>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/ExtJS62/charts-all.css"/>
<%-- <link rel="stylesheet" type="text/css" href="${contextPath}/css/extjs/theme-gray/resources/theme-gray-all.css"/> --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css" />
<eco:javascriptParameter />
<script language='javascript'>
var GLOBAL_CONTEXT_PATH ='${contextPath}';  
var loginId = '${member.userId}';
var userGrade = '${member.userAuth}';
var loginRndId = '${member.rndId}';
var menuDisClassDtl = '${disClassDtl}';
var docClassDtl ='${docClassDtl}';
/* begin antop */
Ext.Ajax.timeout = 180000;

if (!Ext.grid.GridPanel.prototype.emptyText) {
	Ext.grid.GridPanel.prototype.emptyText = '표시할 데이터가 없습니다.';
	}
$(function(){
	document.onkeydown = noRefresh ;
});
function noRefresh()
{
	 /* F5 번키 막음. */
    if(event.keyCode == 116)
    {
        event.keyCode = 0;
        parent.iframeReload();
        return false;
    }
}
</script>