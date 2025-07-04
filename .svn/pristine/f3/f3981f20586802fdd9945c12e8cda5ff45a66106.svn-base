	
$(function(){
	document.onkeydown = noRefresh ;
	document.onkeydown = noRefresh2 ;
	
}); 

function noRefresh()
{
	 /* F5 번키 막음. */
    if(event.keyCode == 116)
    {
        event.keyCode = 0;
        return false;
    }
}

function noRefresh2() //iframe을 parents로 인식하는 현상 방지를 위함
{
	console.log();
}

function doLogOut(){
	var url = GLOBAL_CONTEXT_PATH + '/medical/main/logout.do';
	location.href = url;
}

function manualDownload() {
	Ext.Msg.alert('알림', '준비 중입니다.');
	//location.href = GLOBAL_CONTEXT_PATH + '/downFile.view?dir=file.sample.dir&fileName=bdsp_manual.pdf';
}

var targetFollowUpListStore;

Ext.onReady(function() {
	//header menu 가져오기
	
	var diseMenuListStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		proxy : {
			type : 'ajax',
			async : false,
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/main/selectDiseMenuList.do',
			reader : {
				type : 'json',
				root : 'result'
			},
			extraParams : { classCd : 'DISE1'},
		},
		listeners : {
			load : function() {
				var menuli = $("#diseList");
				for(var i=0; i<diseMenuListStore.getTotalCount(); i++){
					
					var nm = diseMenuListStore.data.items[i].data.classCdDtlNm;
					var cd = diseMenuListStore.data.items[i].data.classCdDtl;
					menuli.append("<li class=\""+cd+"_li\"><a onClick=\"leftMenuReload('"+cd+"')\">"+nm+"</a></li>")
					
				}
				//처음 DS001에 class 추가
				$('#diseList').find('.DS001_li').addClass("current");
				

			}
		}
	});		
	
	
	//대상자 Follow up 팝업
	targetFollowUpListStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		id : 'targetFollowUpListStore',
		proxy : {
			type : 'ajax',
			async : false,
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/target/selectTargetFollowUpList.do',
			reader : {
				type : 'json',
				root : 'result'
			}
		},
		listeners : {
			load : function() {
				
				var targetFTbody = $("#targetFTbody");
				var appendStr;
				var targetId;
				var nextVisitDate;
				var remainVisitDate;
				var performCnt;
				var redCnt = 0;
				targetFTbody.empty();
				for(var i=0; i<targetFollowUpListStore.getTotalCount(); i++){
					targetId = targetFollowUpListStore.data.items[i].data.targetId;
					nextVisitDate = targetFollowUpListStore.data.items[i].data.nextVisitDate;
					remainVisitDate = targetFollowUpListStore.data.items[i].data.remainVisitDate;
					performCnt = targetFollowUpListStore.data.items[i].data.performCnt;
					appendStr = "";
					
					appendStr += "<tr>";
					appendStr += "	<td class=\"btn\" onclick=\"gotoTargetMenu('"+targetId+"','"+performCnt+"')\">"+targetId+"</td>";
					appendStr += "	<td>"+nextVisitDate+"</td>";
					appendStr += "	<td>";
					if(remainVisitDate <= 15){
						appendStr += " <strong class=\"color_red\">"+remainVisitDate+"</strong>";
						redCnt++;
					}else{
						appendStr += " <strong class=\"color_blue\">"+remainVisitDate+"</strong>";
						redCnt++;
					}
					appendStr += "	</td>";
					appendStr += "</tr>";
					targetFTbody.append(appendStr);
					
				}
				if(redCnt>0){
					$(".btn.btn_noti img").attr("src",GLOBAL_CONTEXT_PATH+"/images/header/ico_noti_red.png");
				}else{
					$(".btn.btn_noti img").attr("src",GLOBAL_CONTEXT_PATH+"/images/header/ico_noti.png");
				}
			}
		}
	});		
	
});

function followUplistRefresh(){
	//팝업창 refresh
	targetFollowUpListStore.load();
	if($('.noti_pop').css("display")!="none"){
		$('.noti_pop').show();
	}
}
function MenuOpen(){
	if($('.all_menu').css("display")=="none"){
		$('.all_menu').show();
	}else{
		$('.all_menu').hide();
	}
}

// header 오른쪽 Follow up 아이콘 팝업
function notiPopup(){
	if($('.noti_pop').css("display")=="none"){
		targetFollowUpListStore.load();
		$('.noti_pop').show();
	}else{
		$('.noti_pop').hide();
	}
}

// 임시 : 계정정보 팝업 스크립트
function user_pop(){
	if($('.user_pop').css("display")=="none"){
		$('.user_pop').show();
		if(loginUserAuth != 'G001'){
//			$('.userMgt').hide();
//			$('.userAuthMgt').hide();
			document.getElementById('userMgt').style.display = "none";
			document.getElementById('userAuthMgt').style.display = "none";
		}
	}else{
		$('.user_pop').hide();
	}
}
function user_input_pop(){
	$('.user_input_pop').show();
	Ext.Ajax.request({
 		url : GLOBAL_CONTEXT_PATH + '/medical/basicinfo/selectUser.do',
 	    method : 'POST',
 	   params :{
           userId: loginUserId   // use the same taskId which was used while submitting task
        },
 	    timeout : 100000000,
        success : function(response, opts) {
        	var obj = Ext.decode(response.responseText);
            if (obj.success) {
            	idx = obj.result.idx;
            	loginUserPwd = obj.result.userPwd;
            	userId = obj.result.userId;
            	document.getElementById('mUserId').value = obj.result.userId;
            	document.getElementById('mUserNm').value = obj.result.userNm;
            	document.getElementById('mUserAuth').value = obj.result.userAuth;
            	document.getElementById('mUserAuthNm').value = obj.result.userAuthNm;
            	document.getElementById('mUserInstCd').value = obj.result.userInstCd;
            	document.getElementById('mDeptNm').value = obj.result.deptNm;
            	document.getElementById('mPhoneNum').value = obj.result.phoneNum;
            	document.getElementById('mEmail').value = obj.result.email;
            }
        },
        failure : function(){
        },
        callback : function() {
        }
 	});
}

function user_mgt_pop(){
	$('.user_mgt_pop').show();
	if(validUserGrid){
		new userMgtGrid();
		validUserGrid = false;
	}else{
		doUserMgtReset();
	}
}

function user_pw_pop(){
	$('.user_pw_pop').show();
}
function close_user_input(){
	$('.user_input_pop').hide();
}
function close_user_pw(){
	$('.user_pw_pop').hide();
}
function close_user_mgt(){	
	$('.user_mgt_pop').hide();
}
function user_auth_pop(){
	Ext.Msg.alert('알림', '준비 중입니다.');
}

function gotoTargetMenu(targetId, performCnt){
	var iframe = $('#bodycontainer_frame');
	var pUrl = iframe.attr('src');
	if(pUrl.indexOf("targetList.view") != -1){
		//대상자 정보 화면에서 바로 이동
		iframe[0].contentWindow.targetSelect(targetId, performCnt);
	}else{
		var url = GLOBAL_CONTEXT_PATH + "/medical/target/targetList.view"
								+"?chgTabNm=chgTab&targetId="+targetId+"&performCnt="+performCnt;
	
		$("#bodycontainer_frame").attr('src','/BDSP_S/'+url);
	}
}
