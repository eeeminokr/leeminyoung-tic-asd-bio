var Login = {};
var noticeStore = {};
var loginInputForm;
var loginStore;


// login

var idField, pwdField;

function onLoginSubmit() {
	idField = $('#id').val();
	pwdField = $('#pw').val();
	authField = $('#userAuth').val();
	if( idField=="" || pwdField =="" ) {
	/*	Ext.MessageBox.show({
			title: '확인',
			msg: "아이디와 비밀번호를 입력하시기 바랍니다",
			buttons: Ext.Msg.OK
		});*/
		alert("아이디와 비밀번호를 입력하시기 바랍니다");
	}
	
	if(idField !=="" && pwdField !=="") {
		Ext.MessageBox.show({
	         msg: '<br>로그인 중입니다...',
	         progressText: 'Saving...',
	         width: 300,
	         heigth : 30,
	         wait: {
	             interval: 200
	         },
	     });
		var svcId = "login";
		var url = GLOBAL_CONTEXT_PATH + '/medical/main/login.do';
		//mask.show();
		
		
		Ext.Ajax.request({
			url : url,
			method : 'POST',
			params : {
				userId: idField,
				userPwd: pwdField,
				userAuth: authField				
			},
			success : function(resp) {
				//mask.hide();

				var json = Ext.decode(resp.responseText);
				
				if(json.success == true) {
					Ext.MessageBox.hide();
					document.location.href = GLOBAL_CONTEXT_PATH + '/main.view';
					
					
					
				} else {
					Ext.MessageBox.hide();
					Ext.Msg.alert('인증 오류', json.errors.reason);
				}
			}
		});
	}
	
	return false;
}






Ext.onReady(function() {
	 
	/*var myMask = new Ext.LoadMask({
		renterTo : Ext.getBody(), 
		message : {msg:"Please wait..."}
		
	)}*/
    //myMask.show();
});



