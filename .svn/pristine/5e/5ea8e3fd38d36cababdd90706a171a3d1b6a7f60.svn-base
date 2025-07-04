<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="eco" uri="www.ecoinsight.co.kr/tag" %>
<%@ include file="/include/common.inc"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page='<%=incInclude %>' flush="false"></jsp:include>
<script type="text/javascript" src="${contextPath}/js/medical/imaging/imagingList.js"></script>
<script type="text/javascript" src="${contextPath}/js/progress.js"></script>
</head>
<body>
	<div id="BodyDiv">
		<div class ="content_head">
		<h2 class ="tit">영상</h2>
		<div class="btns">
			<div class="right">
				<eco:authorize menuId="B001" authName = "deleteYn">
				<button type="button" onclick="selectDelete();" class="btnsStyle"><img src="${contextPath}/images/img/ico_del.png" alt="" />삭제</button>
				</eco:authorize>
				<eco:authorize menuId="B001" authName = "uploadYn">
				<button type="button" onclick="fileUpload();" class="btnsStyle"><img src="${contextPath}/images/img/ico_upload.png" alt="" />업로드</button>
				</eco:authorize>
				<eco:authorize menuId="B001" authName = "downYn">
				<div class = "dropdown">
	               	<button type="button" id="dropdown" class="btnsStyle"><img src="${contextPath}/images/img/ico_dwload.png" alt="" /><span>다운로드</span></button>
					<div class ="dropdown_cont">
               		<input type="button" id="chkDown1" class="btn" value="화면 다운로드" onclick="excelDownload();"/>
					<input type="button" id="chkDown2" class="btn" value="업로드 양식 다운로드" onclick= "uploadExcelDownload()"/>
					</div>               	
               	</div>
               	</eco:authorize>
				<button type="button" onclick="openSearchPop();" class="btnsStyle"><img src="${contextPath}/images/img/ico_search.png" alt="" />검색</button>
			</div>
			<div class="both"></div>
		</div>
		   <!-- 검색 팝업창 -->
            <div class="searchbox pop_wrap">
            	<form id="searchForm">
	                <button class="btnstyle btn_close" type="button" onclick="closeSearchPop()"><em class="txt_hide">창닫기</em></button>
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
	                        <span class="label">나이</span>
	                        <div class="cont">
	                            <input type="text" id="startAge" style="width:35px;" /> ~ <input type="text" id="endAge" style="width:35px;" />
	                        </div>
	                    </li>
	                    <li>
	                        <span class="label">차수</span>
	                        <div class="cont">
	                        	<eco:codeCombo name="performCnt" id="performCnt" performCntYN="Y" classCd="N"/>
	                        </div>
	                    </li>
	                    <li>
	                        <span class="label">포크랄</span> 
	                        <div class="cont check_right">
	                            <label><input type="checkbox" name="pocral" value="Oppositional defiant disorder"/><span></span></label>
	                        </div>
	                    </li>
	                    <li>
	                        <span class="label">영상종류</span>
	                        <div class="cont check_right">
	                            <label><input type="checkbox" name="asl" /><span>ASL</span></label>
	                            <label><input type="checkbox" name="dti" /><span>DTI</span></label>
	                            <label><input type="checkbox" name="fmri" /><span>fMRI</span></label>
	                            <label><input type="checkbox" name="t1" /><span>T1</span></label>
	                            <label><input type="checkbox" name="t2" /><span>T2</span></label>
	                        </div>
	                    </li>
	                </ul>
	                <div class="btm">
	                    <button type="button" class="btn bg_skyblue" onclick="doSearch();"><img src="${contextPath}/images/img/ico_search_w.png" alt="" /> <span>검색</span></button>
	                    <button type="button" class="btn bg_gray" onclick="doReset();"><img src="${contextPath}/images/img/ico_re.png" alt="" /> <span>초기화</span></button>
	                </div>
	             </form>
            </div> <!-- 검색 팝업창 end --> 
          </div>
		<div id="ContentsDiv" style="margin : 5px;">
		</div>
		 <!-- paging -->
	</div>
	<jsp:include page='<%=incFooter %>' flush="false"></jsp:include>
</body>
</html>