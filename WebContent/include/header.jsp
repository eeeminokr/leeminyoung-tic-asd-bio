<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="eco" uri="www.ecoinsight.co.kr/tag" %>
<!-- <link type="text/css" href="${contextPath}/css/main.css" media="screen" rel="stylesheet" /> -->
<!-- jQuery -->
<style type="text/css">
body {
  min-width:1200px;
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.style4 {color: #f3f5f7}
.style5 {
	font-size: 11px;
	font-weight: bold;
	color: #666666;
}
#menualDownload{
    display: block;
    width: 30px;
    height: 29px;
    position: absolute;
    top: 3px;
    right: 113px;
    z-index: 1000;
    cursor: pointer;
    background:url(${contextPath}/images/header/uti_ico1.png) no-repeat 50% 50%;
   }
#menualDownload a{
  color: #fff;
}
/* #userInfo{
    display: block;
    width: 100px;
    height: 29px;
    position: absolute;
    top: 10px;
    right: 6px;
    z-index: 1000;
    cursor: pointer;
   }
#userInfo a{
  color: #fff;
} */
#logout{
    display: block;
    width: 25px;
    height: 29px;
    position: absolute;
    top: 20px;
    right: 25px;
    z-index: 1000;
    cursor: pointer;
    background:url(${contextPath}/images/header/uti_ico3.png) no-repeat 50% 50%;
   }
#logout a{
  color: #fff;
}
#top_tabs {
  padding: 8px 10px 0;
  min-height: 41px;
  background: #eff1f2;
  border-bottom: 1px solid #96a0a9;
  box-sizing: border-box;
}
.top_tabs_item {
    overflow: hidden;
    position: relative;
    border: 1px solid #96a0a9;
    border-bottom: 0;
    border-radius: 3px 3px 0 0;
    background-color: #eff1f2;
    display: inline-block;
    height: 32px;
    line-height: 32px;
    padding-left: 14px;
    padding-right: 6px;
    cursor: pointer;
    font-size: 15px;
    font-weight: normal;
    vertical-align: bottom;
    box-sizing: border-box;
}
.top_tabs_item a {
  color: #000;
}
.tabs_selected {
    background-color: #009dba;
    border: 0;
}
.tabs_selected a, .tabs_selected .tab_x {
  color: #fff;
}
span.tab_x {
  display: inline-block;
  margin-top: -5px;
  font-size: 16px;
  font-family: verdana, sans-serif;
  vertical-align: top;
}



/* .menuA{
	cursor: pointer;
}
.menuA img {
	width:30px;
} */
/* .all_menu{
	display:none;
	position: fixed;
    z-index: 9999;
    width: 300px;
    top: 50px;
    background-color: white;
} */

</style>
<script type="text/javascript" src="${contextPath}/js/header.js"></script>
<script type="text/javascript" src="${contextPath}/js/medical/basicinfo/userMgt.js"></script>
<script type="text/javascript">
//세션에서 로그인정보를 가져온다.
var loginUserId = '<c:out value="${member.userId}"/>';
var loginUserPwd = '<c:out value="${member.userPwd}"/>';
var loginUserAuth = '<c:out value="${member.userAuth}"/>';
//var loginUserInstCd = '<c:out value="${member.userInstCd}"/>';
//var loginUserInstCdNm = '<c:out value="${member.userInstCdNm}"/>';
//var loginInstTargetCd = '<c:out value="${member.instTargetCd}"/>';



    
</script>
<div id="header">
    <div class ="all_menu pop_wrap">
      <div class="pop_inner">
        <div class="tit">질병군</div>
        <ul id="diseList" class="list">
        </ul>
      </div>
    </div>
    <div class="logo_wrap">
      <a class="menuA" onclick="MenuOpen()"><img src="${contextPath}/images/img/menu_img.png" alt="MENU" /></a>
      <a href="<%=request.getContextPath()+"/main.view" %>">
        <img src="${contextPath}/images/header/logo.png" alt="BDSP" />              
      </a>
    </div>
      
      <div class="utility">
          <span class="btn btn_noti" onclick="notiPopup()"><img src="${contextPath}/images/header/ico_noti.png" alt="대상자 Follow up" /></span>
          <span id ="userInfo" onclick="user_pop()">${member.userNm}님</span>
      </div>

      <!-- 아이콘 팝업 -->
      <div class="noti_pop pop_wrap">
        <div class="pop_inner">
            <div class="tit">대상자 Follow up</div>
            <!-- 스크롤 : 필요한 높이 설정하세요 -->
            <div class="scroll_wrap" style="height:285px;">
              <table class="table_style1">
                <colgroup>
                    <col width="" />
                    <col width="" />
                    <col width="" />
                </colgroup>
                <thead>
                    <tr>
                        <th>연구번호</th>
                        <th>방문 예정일</th>
                        <th>관리일자</th>
                    </tr>
                </thead>
                <tbody id="targetFTbody">
                </tbody>
              </table>
            </div>
        </div>
    </div>

    <!-- 계정정보 팝업 -->
    <div class="user_pop pop_wrap">
      <div class="pop_inner">
        <div class="tit"><strong class="on">계정정보</strong><span>아이디</span></div>
        <ul class="list">
            <li><a onclick="doLogOut()">로그아웃</a></li>
            <li><a onclick="user_input_pop()">계정정보 수정</a></li>
            <li id="userMgt" name="userMgt" ><a onclick="user_mgt_pop()" >사용자 관리</a></li>
            <li id="userAuthMgt" id="userAuthMgt" ><a onclick="user_auth_pop()">권한관리</a></li>
            <li><a onclick="manualDownload()">시스템 메뉴얼</a></li>
        </ul>
      </div>
    </div>

    <!-- 계정정보 입력 팝업 -->
    <div class="user_input_pop pop_wrap">
      <button class="btnstyle btn_close" onclick="close_user_input()"><em class="txt_hide">창닫기</em></button>
      <div class="pop_inner">
        <div class="tit"><strong class="on">계정정보</strong></div>
        <ul class="list_input">
          <li>
            <label for="">사용자ID<span class="req"><em class="txt_hide">필수</em></span></label>
            <input type="text" id="mUserId" name="mUserId" readOnly/>
          </li>
          <li>
            <label for="">사용자명<span class="req"><em class="txt_hide">필수</em></span></label>
            <input type="text" id='mUserNm' name="mUserNm"/>
          </li>
          <li>
            <label for="">권한<span class="req"><em class="txt_hide">필수</em></span></label>
            <input type="text" id="mUserAuthNm" name="mUserAuthNm" readOnly/>
            <input type="hidden" id="mUserAuth" name="mUserAuth"/>
          </li>
          <li>
            <label for="">소속기관<span class="req"><em class="txt_hide">필수</em></span></label>
            <eco:codeCombo name="mUserInstCd" id="mUserInstCd"  classCd="IS001" allowBlank="false"/>
          </li>
          <li>
            <label for="">부서</label>
            <input type="text" id="mDeptNm" name="mDeptNm"/>
          </li>
          <li>
            <label for="">연락처</label>
            <input type="text" id="mPhoneNum" name="mPhoneNum"/>
          </li>
          <li>
            <label for="">이메일</label>
            <input type="text" id="mEmail" name="mEmail"/>
          </li>
        </ul>
        <div class="btm">
            <button class="btn bg_blue" onclick="doUserUpdate()">저장</button><button class="btn bg_dgray"  onclick="user_pw_pop()">비밀번호 변경</button>
        </div>
      </div>
    </div>

    <!-- 비밀번호 변경 팝업 -->
    <div class="user_pw_pop pop_wrap">
      <button class="btnstyle btn_close" onclick="close_user_pw()"><em class="txt_hide">창닫기</em></button>
      <div class="pop_inner">
        <div class="tit"><strong class="on">비밀번호 변경</strong></div>
        <ul class="list_input">
          <li><label for="">현재 비밀번호</label><input type="password" id="originPwd" name="originPwd"/></li>
          <li><label for="">새 비밀번호</label><input type="password" id="newPwd1" name="newPwd1"/></li>
          <li><label for="">새 비밀번호 확인</label><input type="password" id="newPwd2" name="newPwd2"/></li>
        </ul>
        <div class="txt_info">
            <p>비밀번호 복잡도 조건<br />
              * 8자리 이상 20자리 이하<br />
              * 영문자, 숫자, 특수문자 조합<br />
              * aaa, bbb 같은 반복적인 문자 4자 이상 사용금지<br />
              * 123 같은 순차적인 문자 4자 이상 사용금지</p>
          </ul>
        </div>
        <div class="btm">
          <button class="btn bg_blue" onclick="doUserPwUpdate()">저장</button>
        </div>
      </div>
    </div>

    <!-- 사용자 관리 팝업 -->
    <div class="user_mgt_pop pop_wrap">
      <button class="btnstyle btn_close" onclick="close_user_mgt()"><em class="txt_hide">창닫기</em></button>
      <div class="pop_inner">
        <div class="tit"><strong class="on">사용자 관리</strong></div>
        <ul class="list_input">
          <li>
            <label for="">사용자ID</label>
            <input type="text" id="userId" name="userId" />
          </li>
          <li>
            <label for="">사용자명</label>
            <input type="text" id="userNm" name="userNm" />
            <input type="hidden" id="idx" name="idx" />
            <input type="hidden" id="userPwd" name="userPwd" />
          </li>
          <li>
            <label for="">권한</label>
            <%-- <eco:codeCombo name="userAuth" id="userAuth"  classCd="AU001" allowBlankText="선택"/> --%>
            <eco:grpAuthCombo name="userAuth" id="userAuth" allowBlankText="선택"/>
            <!-- <span id="userGrpAuth" class="userGrpAuth" name="userGrpAuth"></span> -->
          </li>
          <li>
            <label for="">소속기관</label>
            <eco:codeCombo name="userInstCd" id="userInstCd"  classCd="IS001" allowBlankText="선택"/>
          </li>
          <li>
            <label for="">부서</label>
            <input type="text" id="deptNm" name="deptNm" />
          </li>
          <li>
            <label for="">연락처</label>
            <input type="text" id="phoneNum" name="phoneNum" />
          </li>
          <li>
            <label for="">이메일</label>
            <input type="text" id="email" name="email" />
          </li>.
          <li class="btm">
            <button class="btn bg_blue" id="regButton" name="regButton" onclick="doSave()">등록</button><button class="btn bg_blue" onclick="deleteUser()">삭제</button><button class="btn bg_dgray" onclick="doUserMgtReset()">초기화</button>
          </li>
        </ul>
        <div class="user_list" id="user_list" name="user_list">
        	<div class="userMgtList" id="userMgtList"></div>
        </div>
      </div>
    </div>
</div>
