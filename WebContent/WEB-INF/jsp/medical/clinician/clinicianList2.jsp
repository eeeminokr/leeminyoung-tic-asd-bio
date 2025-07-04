<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="eco" uri="www.ecoinsight.co.kr/tag" %>
<%@ include file="/include/common.inc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${incTitle}</title>
<jsp:include page='<%=incInclude %>' flush="false"></jsp:include>
<script type="text/javascript" src="${contextPath}/js/medical/clinician/clinicianList.js"></script>
</head>
<body>	
	<div id="BodyDiv">
		<div class="content_head">
			<h2 class="tit">임상가평가검사</h2>
            <h3 class="tit"></h3>
            <div class="submenu">
            </div>
			<!-- <div id="menuDiv" class="submenu"></div> -->
			<div class="btns">
				<eco:authorize menuId="C001" authName = "deleteYn">
				<button type="button" onclick="selectDelete();" class="btnsStyle"><img src="${contextPath}/images/img/ico_del.png" alt="" /><span>삭제</span></button>
				</eco:authorize>
				<eco:authorize menuId="C001" authName = "uploadYn">
				<button type="button" onclick="excelUpload();" class="btnsStyle"><img src="${contextPath}/images/img/ico_upload.png" alt="" /><span>업로드</span></button>
				</eco:authorize>
				<eco:authorize menuId="C001" authName = "downYn">
				<div class = "dropdown">
	               	<button type="button" id="dropdown" class="btnsStyle"><img src="${contextPath}/images/img/ico_dwload.png" alt="" /><span>다운로드</span></button>
					<div class ="dropdown_cont">
               		<input type="button" id="chkDown1" class="btn" value="화면 다운로드" onclick="excelDownload();"/>
					<input type="button" id="chkDown2" class="btn" value="업로드 양식 다운로드" onclick= "uploadExcelDownload()"/>
					</div>               	
               	</div>
               	</eco:authorize>
               	
				<button type="button" onclick="openSearchPop();" class="btnsStyle"><img src="${contextPath}/images/img/ico_search.png" alt="" /><span>검색</span></button>
			</div>
			<!-- 검색 팝업창 -->
            <div class="searchbox pop_wrap">
            	<form id="searchForm">
	                <button class="btnstyle btn_close" type="button"  onclick="closeSearchPop()"><em class="txt_hide">창닫기</em></button>
	                <ul>
	                    <li>
	                        <span class="label">연구번호</span>
	                        <div class="cont">
	                            <input type="text" id="targetId" style="width:123px;" />
	                        </div>
	                    </li>
	                    <li>
	                        <span class="label">성별</span>
	                        <div class="cont check_btns">
	                            <input type="checkbox" name="check_sex" id="sex_m" class="first" value="M"/><label for="sex_m">남자</label><input type="checkbox" name="check_sex" id="sex_f" value="F"/><label for="sex_f">여자</label>
	                        </div>
	                    </li>
	                    <li>
	                        <span class="label">프로토콜</span>
	                        <div class="cont check_btns check_w90">
	                             <input type="checkbox" name="check_pro" id="pro_1" class="first" value="단기약물치료군" /><label for="pro_1">단기약물치료군</label><!-- 
	                             --><input type="checkbox" name="check_pro" id="pro_2" value="장기약물노출군" /><label for="pro_2">장기약물노출군</label><!-- 
		                         --><input type="checkbox" name="check_pro" id="pro_3" value="비 약물군"/><label for="pro_3">비 약물군</label>
	                        </div>
	                    </li>
	                    <li>
	                        <span class="label">차수</span>
	                        <div class="cont">
	                            <eco:codeCombo name="performCnt" id="performCnt" performCntYN="Y" classCd="N"/>
	                        </div>
	                    </li>
	                    <li>
	                        <span class="label">나이</span>
	                        <div class="cont">
	                            <input type="text" id="startAge" style="width:35px;" /> ~ <input type="text" id="endAge" style="width:35px;" />
	                        </div>
	                    </li>
	                     <li>
	                        <span class="label">실시일</span>
	                        <div class="cont">
	                            <input type="text" id="startAge" style="width:35px;" /> ~ <input type="text" id="endAge" style="width:35px;" />
	                        </div>
	                    </li>
	                    <li class="total_search">
	                        <div class="check_right" id="check_right">
	                            <label><input type="checkbox" name="cvCgis" /><span>CGI-S</span></label>
	                            <label><input type="checkbox" name="cvCgii" /><span>CGI-I</span></label>
	                            <label><input type="checkbox" name="cvCgas" /><span>C-GAS</span></label>
	                            <label><input type="checkbox" name="s1" /><span>K-SADS-PL</span></label>
	                            <label><input type="checkbox" name="srs01" /><span>SRS</span></label>
	                            <label><input type="checkbox" name="cybo1" /><span>CY-BOCS</span></label>
								<label><input type="checkbox" name="ybocs" /><span>Y-BOCS</span></label>
	                        </div>
	                    </li>
	                </ul>
	                <div class="btm">
	                    <button type="button" class="btn bg_skyblue" onclick="doSearch();"><img src="${contextPath}/images/img/ico_search_w.png" alt="" /> <span>검색</span></button>
	                    <button type="button" class="btn bg_gray" onclick="doReset();"><img src="${contextPath}/images/img/ico_re.png" alt="" /> <span>초기화</span></button>
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
</body>
</html>