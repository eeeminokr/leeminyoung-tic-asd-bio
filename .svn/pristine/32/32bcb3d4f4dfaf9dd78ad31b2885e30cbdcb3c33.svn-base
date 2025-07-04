<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="eco" uri="www.ecoinsight.co.kr/tag" %>
<%@ include file="/include/common.inc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${incTitle}</title>
<jsp:include page='<%=incInclude %>' flush="false"></jsp:include>
<script type="text/javascript" src="${contextPath}/js/medical/analysis/analListAo.js"></script>


</head>
<body>	
	<div id="BodyDiv"> 

		<!-- .content_head : 페이지 타이틀, 2뎁스, 상단버튼-->
		<div class="content_head">
		
			<h2 class="tit">환경물질 분석</h2>
			<h3 class="tit"></h3>
            <div class="submenu">
            </div>
			<div class="btns">
			<eco:authorize menuId="AO06" authName = "deleteYn">
			<button type="button" onclick="selectDeleteAnalysis();" class="btnsStyle"><img src="${contextPath}/images/img/ico_del.png" alt="" /><span>삭제</span></button>
			</eco:authorize>
			<eco:authorize menuId="AO06" authName = "uploadYn"> 
			<button type="button" onclick="excelUpload();" class="btnsStyle"><img src="${contextPath}/images/img/ico_upload.png" alt="" /><span>업로드</span></button>
			</eco:authorize>
			<eco:authorize menuId="AO06" authName = "downYn">
				<div class = "dropdown">
	               	<button type="button" id="dropdown" class="btnsStyle"><img src="${contextPath}/images/img/ico_dwload.png" alt="" /><span>다운로드</span></button>
					<div class ="dropdown_cont">
               		<input type="button" id="chkDown1" class="btn" value="화면 다운로드" onclick="excelDownload();"/>
					<input type="button" id="chkDown2" class="btn" value="업로드 양식 다운로드" onclick= "uploadExcelDownload()"/>
					</div>               	
               	</div>
            </eco:authorize>
				<button class="btnsStyle" onclick="openSearchPop()"><img src="${contextPath}/images/img/ico_search.png" alt="" /><span>검색</span></button>
			</div>

			<!-- 검색 팝업창 -->
			<div class="searchbox pop_wrap">
			<form id="searchForm" name="searchForm" onsubmit="doSearch(); return false;">
				<button class="btnstyle btn_close" onclick="closeSearchPop()"><em class="txt_hide">창닫기</em></button>
				<ul>
					<li>
						<span class="label">뇌원천 연구번호</span>
						<div class="cont">
							<input type="text" id="targetId" name="targetId"  style="width:123px;" />
						</div>
					</li>
					<li>
						<span class="label">뇌질환 연구번호</span>
						<div class="cont">
							<input type="text" id="targetDisId" name="targetDisId"  style="width:123px;" />
						</div>
					</li>
					<li>
						<span class="label">성별</span>
                        <div class="cont check_btns">
	                            <input type="checkbox" name="check_sex" id="sex_m" class="first" value="M"/><label for="sex_m">남자</label><input type="checkbox" name="check_sex" id="sex_f" value="F"/><label for="sex_f">여자</label>
                        </div>
					</li>
	
					<li>
                       	<span class="label">나이</span>
                        <div class="cont">
                            <input type="text" id="startAge" style="width:35px;" /> ~ <input type="text" id="endAge" style="width:35px;" />
                        </div>
                    </li>
            
                    <li class="total_search">
                        <div class="check_right">
                            <label><input type="checkbox" name="analEnvMatt" /><span>PHTs 3종 및 COT(소변)</span></label>
                            <label><input type="checkbox" name="analEnvMattBl" /><span>중금속(혈액)</span></label>
                           
                        </div>
                    </li>
				</ul>
				<div class="btm">
					<button type="button" onclick="doSearch();" class="btn bg_skyblue"><img src="${contextPath}/images/img/ico_search_w.png" alt="" /> <span>검색</span></button>
					<button type="button" onclick="doReset();" class="btn bg_gray"><img src="${contextPath}/images/img/ico_re.png" alt="" /> <span>초기화</span></button>
				</div>
				</form>
			</div>
			<!-- //검색 팝업창 -->
		</div>
		<!-- //.content_head -->

		<div id="ContentsDiv" style="">
		</div>
	</div>
	<jsp:include page='<%=incFooter %>' flush="false"></jsp:include>

<script>
//검색 팝업 열기
function openSearchPop(){
	$('.searchbox').show();
}
//팝업 닫기
function closeSearchPop(){
	$('.searchbox').hide();
}
</script>
</body>
</html>