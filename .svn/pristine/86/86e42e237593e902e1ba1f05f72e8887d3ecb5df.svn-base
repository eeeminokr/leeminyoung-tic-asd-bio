<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="eco" uri="www.ecoinsight.co.kr/tag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Login</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<%@ include file="/include/common.inc"%>
<head>
<jsp:include page='<%=incInclude%>' flush="false"></jsp:include>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/login.css"/>
<!-- <link rel="stylesheet" type="text/css" href="/BDSP/css/mainStyle.css"/> -->
<script type="text/javascript" src="${contextPath}/js/medical/login.js"></script>
<style>
	input:focus::-webkit-input-placeholder{
	 color:transparent;
	 }
    ::-webkit-input-placeholder { /* 크롬  */
    color: #212f3f;
}
/* input box color */ 
     input:-webkit-autofill,
input:-webkit-autofill:hover,
input:-webkit-autofill:focus,
input:-webkit-autofill:active {
    -webkit-animation: autofill 0s forwards;
    animation: autofill 0s forwards;
    -webkit-text-fill-color : #e9e9e9;
}

@keyframes autofill {
    100% {
        background: transparent;
        color: inherit;
    }
}

@-webkit-keyframes autofill {
    100% {
        background: transparent;
        color: inherit;
    }
}
</style>
</head>
<body style="margin:0; padding:0;" >
	<table width="100%" height="100%" border="0" background="${contextPath}/images/login/bg_login.jpg" class="backbg2">
  <tr>
    <td style="vertical-align:top;">
    	<form name="login"  method="post" onSubmit="return onLoginSubmit();">
        
        <div class="login_box">
            <div class="logo_wrap">
                <img src="${contextPath}/images/login/login_logo.png" alt="BDSP" />
                <p>Biomedical Data Science Platform</p>
            </div>
            <ul>
                <!-- 로그인 첫번째 박스 (아이디)  -->
                <li class="li_id">
                    <input type="text" id="id" name="user_id" maxlength="20" placeholder="ID" tabindex="1"/><!--공백없앰
                 --><%-- <eco:codeCombo name="userAuth" id="userAuth"  classCd="AU001" allowBlank="false" value="관리자"/> --%>
                </li>
                <!-- 로그인 첫번째 박스 (패스워드)  -->
                <li class="li_pw">
                    <input type="password" id="pw" name="user_id" maxlength="20" placeholder="Password" tabindex="2"/>
                </li>
                <li>
                    <button type="submit"><img src="${contextPath}/images/login/txt_login.png"></button>
                </li>
            </ul>
        </div>

       </form>
   </td>
  </tr>
</table>
</body>

</html>