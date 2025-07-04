<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="eco" uri="www.ecoinsight.co.kr/tag" %>
<%@ include file="/include/common.inc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${incTitle}</title>
<jsp:include page='<%=incInclude %>' flush="false"></jsp:include>
<script type="text/javascript" src="${contextPath}/js/medical/dataIntegration/dataIntegrationDtlAo.js"></script>
<script type="text/javascript" src="${contextPath}/js/slick.min.js"></script>
</head>
<style>
	.list_q .inqContent {position:relative;min-height:28px;padding:3px 0 8px 4px;line-height:1.5em;white-space:normal;}
    .slick-slide {float:left;}
    #remarksButton{
    border: 1px solid #2477bf;
    background-color: #3892d4; 
    color: white; padding : 3px; 
    padding-left : 10px; padding-right : 10px;
    font-size: 12px; 
    font-weight : bold;
    margin-top: 4px; 
    margin-left: 10px;
    border-radius : 3px;
    }
    #remarksButton:hover{background-color: #157fcc;}
    .selected{
    background-color : yellow;
    }
    .innerDivC{
        width: 100%;
	    padding: 10px;
	    font-weight: bold;
	    color: #555;
	    border-top: 1px solid #e7e7e7;
    }
    .innerNum{
        width: 49px;
	    padding: 10px;
	    /* font-weight: bold; */
	    color: #555;
	    border-top: 1px solid #e7e7e7;
    }
    .innerContent{
        width: 600px;
	    padding: 10px;
	    /* font-weight: bold; */
	    color: #555;
	    border-top: 1px solid #e7e7e7;
    }
</style>
<body>
	<div id="BodyDiv">

		<!-- .content_head : 페이지 타이틀, 2뎁스, 상단버튼-->
		<div class="content_head">
			<h2 class="tit">데이터 통합 분석</h2>

			<!-- 검색 팝업창 -->
			<%-- <div class="searchbox pop_wrap">
				<button class="btnstyle btn_close" onclick="closeSearchPop()"><em class="txt_hide">창닫기</em></button>
				<ul>
					<li>
						<span class="label">뇌원천 연구번호</span>
						<div class="cont">
							<input type="text" style="width:123px;" />
						</div>
					</li>
					<li>
						<span class="label">뇌질환 연구번호</span>
						<div class="cont">
							<input type="text" style="width:123px;" />
						</div>
					</li>
					<li>
						<span class="label">성별</span>
						<div class="cont check_btns">
							<input type="checkbox" name="check_sex" id="sex_m" class="first" /><label for="sex_m">남자</label><input type="checkbox" name="check_sex" id="sex_f" /><label for="sex_f">여자</label>
						</div>
					</li>
					<li>
						<span class="label">프로토콜</span>
						<div class="cont check_btns check_w90">
							<input type="checkbox" name="check_pro" id="pro_1" class="first" /><label for="pro_1">약물군</label><input type="checkbox" name="check_pro" id="pro_2" /><label for="pro_2">비 약물군</label>
						</div>
					</li>
					<li>
						<span class="label">나이</span>
						<div class="cont">
							<input type="text" style="width:35px;" /> ~ <input type="text" style="width:35px;" />
						</div>
					</li>
					<li>
						<span class="label">차수</span>
						<div class="cont">
							<select name="" id="">
								<option value="">V0</option>
							</select>
						</div>
					</li>
				</ul>
				<div class="btm">
					<button type="button" class="btn bg_skyblue"><img src="${contextPath}/images/img/ico_search_w.png" alt="" /> <span>검색</span></button>
					<button type="button" class="btn bg_gray"><img src="${contextPath}/images/img/ico_re.png" alt="" /> <span>초기화</span></button>
				</div>
			</div> --%>
			<!-- //검색 팝업창 -->
		</div>
		<!-- //.content_head -->

		<div id="ContentsDiv" style="">

			<div class="float_left" style="min-width:185px;width:18%;">
				<!-- 기본정보 -->
				<div class="box_style">
					<div class="box_head">
						기본정보
					</div>
					<div class="box_body" id="BasicInfo">
						<table>
							<colgroup>
								<col width="45%" />
								<col width="25%" />
								<col width="30%" />
							</colgroup>
							<tbody>
								<tr>
									<th>뇌원천 연구번호</th>
									<td colspan="2"><span id="targetId"></span></td>
								</tr>
								<tr>
									<th>뇌질환 연구번호</th>
									<td colspan="2"><span id="targetDisId"></span></td>
								</tr>
								<tr>
									<th>질병군</th>
									<td colspan="2"><span id="disClassDtl"></span></td>
								</tr>
								 
								<tr>
									<th>탭분류</th>
									<td colspan="2"><span id="docClassDtl"></span></td>
								</tr>
							
								<tr>
									<th>성별</th>
									<td colspan="2"><span id="sex"></span></td>
								</tr>
								<tr>
									<th>생년월일</th>
									<td colspan="2"><span id="birthYm"></span></td>
								</tr>
								<tr>
									<th>프로토콜</th>
									<td colspan="2"><span id="protocol"></span></td>
								</tr>
								<tr>
									<th>최종차수</th>
									<td colspan="2"><span id="performCntMaxNm" ></span></td>
								</tr>
								<tr>
									<th rowspan="3">인체유래물<br>동의서</th>
									<td>부</td>
									<td><span id="humanDerivedMaterialsF"></span></td>
								</tr>
								<tr>
									<td>모</td>
									<td><span id="humanDerivedMaterialsM"></span></td>
								</tr>
								<tr>
									<td>아동</td>
									<td><span id="humanDerivedMaterialsC"></span></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- 기본검사 -->
				<div class="box_style">
					<div class="box_head bg_type1">
						기본검사
					</div>
					<div class="box_body">
						<table>
							<colgroup>
								<col width="45%" />
								<col width="25%" />
								<col width="30%" />
							</colgroup>
							<tbody>
								<tr>
									<th rowspan="3">채혈</th>
									<td>부</td>
									<td><span id="bloodFather"></span></td>
								</tr>
								<tr>
									<td>모</td>
									<td><span id="bloodMother"></span></td>
								</tr>
								<tr>
									<td>아동</td>
									<td><span id="bloodChild"></span></td>
								</tr>
								<tr>
									<th>K-SADS 결과보고서</th>
									<td colspan="2"><span id="ksads"></span></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- 소변 -->
				<div class="box_style">
					<div class="box_head">
						소변
					</div>
					<div class="box_body box_scroll" style="height:59px;">
						<table>
							<colgroup>
								<col width="20%">
								<col width="80%">
							</colgroup>
							<tbody>
								<tr class="urine_tr">
									<th>V0</th>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- 공존진단 -->
				<div class="box_style">
					<div class="box_head">
						공존진단
					</div>
					<div class="box_body box_scroll" style="height:89px;">
						<table>
							<colgroup>
								<col width="20%">
								<col width="80%">
							</colgroup>
							<tbody>
								<tr class="bg">
									<th>차수</th>
									<th>공존진단명</th>
								</tr>
								<tr class="cxt_diag_tr">
									<td>V0</td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- 참여연구 동의서 -->
				<div class="box_style">
					<div class="box_head">
						참여연구 동의서
					</div>
					<div class="box_body box_scroll" style="height:59px;">
						<table>
							<colgroup>
								<col width="20%">
								<col width="20%">
								<col width="60%">
							</colgroup>
							<tbody>
								<tr class="consent_tr">
									<th rowspan="2">V0</th>
									<td>보호자</td>
									<td></td>
								</tr>
								<tr class="consent_tr">
									<td>아동</td>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!-- //.float_left -->

			<div class="float_left" style="min-width:300px;width:30%;">

				<!-- 영상 -->
				<div class="box_style">
					<div class="box_head">
						영상
					</div>
					<div class="box_body box_scroll" style="height:147px;">
						<table>
							<colgroup>
								<col width="30%">
								<col width="20%">
								<col width="30%">
								<col width="20%">
							</colgroup>
							<tbody>
								<tr class="bg imaging_tr">
									<th>항목</th>
									<th>차수</th>
									<th>실시일</th>
									<th>결과</th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>

				<!-- 심리검사 -->
				<div class="box_style box_shadow">
					<div class="box_head center">
						심리검사
					</div>
					<div class="box_body box_scroll" style="height:89px;">
						<table>
							<colgroup>
								<col width="30%">
								<col width="20%">
								<col width="30%">
								<col width="20%">
							</colgroup>
							<tbody>
								<tr class="bg psych_testing_tr">
									<th>항목</th>
									<th>차수</th>
									<th>실시일</th>
									<th>결과</th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				
				<!-- 임상가 평가 -->
				<div class="box_style box_shadow">
					<div class="box_head center">
						임상가 평가
					</div>
					<div class="box_body box_scroll" style="height:89px;">
						<table>
							<colgroup>
								<col width="30%">
								<col width="20%">
								<col width="30%">
								<col width="20%">
							</colgroup>
							<tbody>
								<tr class="bg clinical_evaluation_tr" id="clinical">
									<th>항목</th>
									<th>차수</th>
									<th>실시일</th>
									<th>결과</th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				
				<!-- 설문지 -->
				<div class="box_style">
					<div class="box_head center">
						설문지
					</div>
					<div class="box_body box_scroll" style="height:118px;">
						<table>
							<colgroup>
								<col width="30%">
								<col width="20%">
								<col width="30%">
								<col width="20%">
							</colgroup>
							<tbody>
								<tr class="bg questionnaire_tr" id="survey">
									<th>항목</th>
									<th>차수</th>
									<th>실시일</th>
									<th>결과</th>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<br />
				<div class="box_style">
					<div class="box_head center">
						메모<button type="button" id="remarksButton" onclick="saveRemarks()" >저장</button>
					</div>
					<div>
						<textarea id="remarks" style="width: 515px; height: 100px; resize: none;"></textarea>
					</div>
				</div>
			</div><!-- //.float_left -->
			
			<div class="float_left" style="min-width:525px;width:52%;">
				<div class="survey_tabs">
					<input type="hidden" class="currentIndex">
					<div class="slide_nav">
					</div>
					<div class="slide_wrap">
                        <div id="slider" class="slide_inner">
                        	<div class="survey_btns">
								<h3>임상가 평가</h3>
								<button type="button" class="survey_btn" id="SRS01" onclick="docDtlLoad('SRS01','DC004')">SRS(약)</button>
								<button type="button" class="survey_btn" id="CYBO1" onclick="docDtlLoad('CYBO1','DC004')">CY-BOCS</button>
								<button type="button" class="survey_btn" id="YBOCS" onclick="docDtlLoad('YBOCS','DC004')">YBOCS(부모)</button>
							</div>
							<div class="survey_btns">
								<h3>부모자녀 평가</h3>
								<button type="button" class="survey_btn" id="KMCHT" onclick="docDtlLoad('KMCHT','DC002')">KMCHAT</button>
								<button type="button" class="survey_btn" id="ARS01" onclick="docDtlLoad('ARS01','DC002')">ARS</button>
								<button type="button" class="survey_btn" id="ABC01" onclick="docDtlLoad('ABC01','DC002')">ABC</button>
								<button type="button" class="survey_btn" id="SIB01" onclick="docDtlLoad('SIB01','DC002')">SIB</button>
								<button type="button" class="survey_btn" id="BPI01" onclick="docDtlLoad('BPI01','DC002')">BPI</button>
								<button type="button" class="survey_btn" id="SRS03" onclick="docDtlLoad('SRS03','DC002')">SRS</button>
								<button type="button" class="survey_btn" id="SCQ01" onclick="docDtlLoad('SCQ01','DC002')">SCQ</button>
								<button type="button" class="survey_btn" id="PC3Q1" onclick="docDtlLoad('PC3Q1','DC002')">부모 자녀 AQ/EQ/SQ</button>
								<button type="button" class="survey_btn" id="KASDS" onclick="docDtlLoad('KASDS','DC002')">K-ASDS</button>
								<button type="button" class="survey_btn" id="SSIS1" onclick="docDtlLoad('SSIS1','DC002')">SSIS</button>
								<button type="button" class="survey_btn" id="TRAUM" onclick="docDtlLoad('TRAUM','DC002')">트라우마</button>
								<button type="button" class="survey_btn" id="CMRSP" onclick="docDtlLoad('CMRSP','DC002')">CMRS-P</button>
							    <button type="button" class="survey_btn" id="CPCL" onclick="docDtlLoad('CPCL','DC002')">CPCL</button>
								
								<button type="button" class="survey_btn" id="OCBCL" onclick="docDtlLoad('OCBCL','DC002')">K-CBCL(구버전)</button>
								<button type="button" class="survey_btn" id="CBC15" onclick="docDtlLoad('CBC15','DC002')">CBCL 1.5-5</button>
								<button type="button" class="survey_btn" id="OCB15" onclick="docDtlLoad('OCB15','DC002')">CBCL 6-18</button>
								<button type="button" class="survey_btn" id="LSD01" onclick="docDtlLoad('LSD01','DC002')">LSD</button>
								<button type="button" class="survey_btn" id="QPGSR" onclick="docDtlLoad('QPGSR','DC002')">QPGS-RⅢ</button>
								<button type="button" class="survey_btn" id="GSRS1" onclick="docDtlLoad('GSRS1','DC002')">GSRS</button>
								<button type="button" class="survey_btn" id="KCSHQ" onclick="docDtlLoad('KCSHQ','DC002')">K-CSHQ</button>	
								
							</div>
							<div class="survey_btns">
								<h3>아동자가 평가</h3>
								<button type="button" class="survey_btn" id="CDI01" onclick="docDtlLoad('CDI01')">CDI(아동)</button>
								<button type="button" class="survey_btn" id="BDI02" onclick="docDtlLoad('BDI02')">BDI 성인용</button>
								<button type="button" class="survey_btn" id="STITC" onclick="docDtlLoad('STITC')">STAI-T</button>
								<button type="button" class="survey_btn" id="STISC" onclick="docDtlLoad('STISC')">STAI-S</button>
								<button type="button" class="survey_btn" id="CC3QC" onclick="docDtlLoad('CC3QC')">아동자가 AQ/EQ/SQ 아동용</button>
								<button type="button" class="survey_btn" id="CC3QA" onclick="docDtlLoad('CC3QA')">아동자가 AQ/EQ/SQ 성인용</button>
								<button type="button" class="survey_btn" id="IAT01" onclick="docDtlLoad('IAT01')">IAT</button>
								<button type="button" class="survey_btn" id="KSCAL" onclick="docDtlLoad('KSCAL')">K-척도</button>
								<button type="button" class="survey_btn" id="KSCAA" onclick="docDtlLoad('KSCAA')">K-척도 성인용</button>
								<button type="button" class="survey_btn" id="RCMAS" onclick="docDtlLoad('RCMAS')">RCMAS</button>
								<button type="button" class="survey_btn" id="TRAUA" onclick="docDtlLoad('TRAUA')">트라우마 성인용</button>
							</div>
							<div class="survey_btns">
								<h3>부모자가 평가</h3>
								<button type="button" class="survey_btn" id="BDI01" onclick="docDtlLoad('BDI01')">BDI 부모용</button>
								<button type="button" class="survey_btn" id="STITP" onclick="docDtlLoad('STITP')">STAI-T 부모용</button>
								<button type="button" class="survey_btn" id="STISP" onclick="docDtlLoad('STISP')">STAI-S 부모용</button>
								<button type="button" class="survey_btn" id="MBRI1" onclick="docDtlLoad('MBRI1')">MBRI</button>
								<button type="button" class="survey_btn" id="PP3Q1" onclick="docDtlLoad('PP3Q1')">부모자가 AQ/EQ/SQ</button>
								<button type="button" class="survey_btn" id="KPSI1" onclick="docDtlLoad('KPSI1')">K-PSI</button>
							</div>
						</div>
					</div>
				</div>
				
				<div class="survey_cont" id="ticDocDtl">
					
				</div>
			</div>
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

//버튼 슬라이더
$('#slider').slick({
    dots: false,
    infinite: true,
    variableWidth: true,
    appendArrows: $('.slide_nav'),
    prevArrow: '<span class="btn btn_prev"><em class="txt_hide">이전</em></span>',
    nextArrow: '<span class="btn btn_next"><em class="txt_hide">다음</em></span>',
})
.on('afterChange', function( e, slick, currentSlide ) {
	$('.currentIndex').val(currentSlide);
});
</script>

</body>
</html>