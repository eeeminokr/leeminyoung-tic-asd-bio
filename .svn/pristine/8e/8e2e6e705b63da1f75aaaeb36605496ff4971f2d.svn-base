<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="eco" uri="www.ecoinsight.co.kr/tag" %>
<%@ include file="/include/common.inc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${incTitle}</title>
<jsp:include page='<%=incInclude %>' flush="false"></jsp:include>
<script type="text/javascript" src="${contextPath}/js/medical/target/targetList.js"></script>
<style>
	/* 해당 페이지만 폰트 사이즈 업 */
	.content_head .tit, .content_head .btns .btnsStyle, .x-grid-cell-inner {font-size:13px;}
	.x-column-header-text-inner, .x-grid-cell input[type="text"] {font-size:12px;}
	.x-grid-cell {padding-top:3px;padding-bottom:3px;}
</style>
</head>
<body>	
	<div id="BodyDiv" style> 
		<div class="content_head">
            <h2 class="tit">대상자 정보 관리</h2>
            <div class="btns">
            	<eco:authorize menuId="A001" authName = "deleteYn">
                <button type="button" id="delBtn" onclick="selectDelete();" class="btnsStyle"><img src="${contextPath}/images/img/ico_del.png" alt="" /><span>삭제</span></button>
                </eco:authorize>
                <eco:authorize menuId="A001" authName = "uploadYn">
                <button type="button" onclick="excelUpload();" class="btnsStyle"><img src="${contextPath}/images/img/ico_upload.png" alt="" /><span>업로드</span></button>
               	</eco:authorize>	
               	<eco:authorize menuId="A001" authName = "downYn">
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
	                        <span class="label">방문상태</span>
	                        <div class="con check_right">
	                        	<%-- <eco:codeCombo name="status" id="status"  classCd="STS01"/> --%> 
	                        	<label><input type="checkbox" name="status" value="0001"><span>대기</span></label>
	                        	<label><input type="checkbox" name="status" value="0002"><span>예정</span></label>
	                        	<label><input type="checkbox" name="status" value="0003"><span>완료</span></label>
	                        	<label><input type="checkbox" name="status" value="0004"><span>DROP</span></label>
	                        </div>
	                    </li>
	                    <li>
	                        <span class="label">공존진단</span>
	                        <div class="cont check_right">
		                        <label><input type="checkbox" name="cxtDiag" value="1-1"/><span>ADHD Inattentive Type</span></label>
		                        <label><input type="checkbox" name="cxtDiag" value="1-2"/><span>ADHD Hyperactive Type</span></label>
		                        <label><input type="checkbox" name="cxtDiag" value="1-3"/><span>ADHD Combined Type</span></label>
		                        <label><input type="checkbox" name="cxtDiag" value="1-4"/><span style="margin-right: 8px;">ADHD NOS</span></label>
		                        <label><input type="checkbox" name="cxtDiag" value="2-1"/><span style="margin-right: 8px;">Tourette Syndrome</span></label>
		                        <label><input type="checkbox" name="cxtDiag" value="2-2"/><span>Chronic Motor or Vocal Tic Disorder</span></label>
		                        <label><input type="checkbox" name="cxtDiag" value="2-3"/><span style="margin-right: 3px;">Transient Tic Disorder</span></label>
	                            <label><input type="checkbox" name="cxtDiag" value="3"/><span style="margin-right: 3px;">Oppositional defiant disorder</span></label>
	                            <label><input type="checkbox" name="cxtDiag" value="4"/><span>Conduct disorder</span></label>
		                        <label><input type="checkbox" name="cxtDiag" value="5"/><span>정동장애</span></label>
	                            <label><input type="checkbox" name="cxtDiag" value="6"/><span>불안장애</span></label>
	                            <label><input type="checkbox" name="cxtDiag" value="7"/><span>기타</span></label>
	                        </div>
	                    </li>
	                    <li>
	                        <div class="check_right">
	                            <label><input type="checkbox" name="researchInterview" /><span>연구면담</span></label>
	                            <label><input type="checkbox" name="psychology" /><span>심리</span></label>
	                            <label><input type="checkbox" name="urine" /><span>소변</span></label>
	                            <label><input type="checkbox" name="remainsAgree" /><span>동의서</span></label>
	                            <label><input type="checkbox" name="surveyDistrib" /><span>설문지배부</span></label>
	                            <label><input type="checkbox" name="sendResult" /><span>결과지발송</span></label>
	                            <label><input type="checkbox" name="interviewDate" /><span>면담결과</span></label>
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
        
        <!-- paging -->
        <!-- <div class="paging">
            <a class="nav_prev" href=""><i><em class="txt_hide">prev</em></i></a><a href="">1</a><a href="">2</a><span class="on">3</span><a href="">4</a><a href="">5</a><a href="">6</a><a href="">7</a><a href="">8</a><a class="nav_next" href=""><i><em class="txt_hide">next</em></i></a>
        </div> -->
	</div>
	<jsp:include page='<%=incFooter %>' flush="false"></jsp:include>
</body>
</html>