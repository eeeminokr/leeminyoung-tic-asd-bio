<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="eco" uri="www.ecoinsight.co.kr/tag" %>
<%@ include file="/include/common.inc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${incTitle}</title>
<jsp:include page='<%=incInclude %>' flush="false"></jsp:include>
</head>

<script>
	$(document).ready(function(){
		$("#bodycontainer").append("<iframe style='display: inline;height: 950px; width:1700px;' id='bodycontainer_frame' class='bodyframe' frameborder='0' src='/BDSP_S/dashboard.view?frame=true' style='display:none;'></iframe>"); //iframe 추가
	});
</script>
<body>
	<jsp:include page='<%=incHeader %>' flush="false"></jsp:include>
	<jsp:include page='<%=incLeft %>' flush="true"></jsp:include>
	<div id="bodycontainer" style="height:950px"></div>
	
</body>
</html>
