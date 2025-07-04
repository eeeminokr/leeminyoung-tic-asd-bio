var userMgtGrid;
var userMgtPageSize  = 21;
var modifyUser = false;
var validUserGrid = true;
var sm =new Ext.selection.CheckboxModel({headerWidth:40});


Ext.onReady(function() {
	userListStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		pageSize : userMgtPageSize,
		proxy : {
			type : 'ajax',
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/basicinfo/selectMemberList.do',
			reader : {
				type : 'json',
				root : 'result',
				totalProperty: 'total'
			}

		},
		listeners : {
			load : function() {

			}
		}
	});
	
});

userMgtGrid = function() {

	Ext.create("Ext.panel.Panel", {
		// 'resizable-panel',
		height : '250px',
		region : 'center',
		layout : 'border',
		id : 'userMgtGrid-panel',
		renderTo : 'user_list',
		border : false,
		items : [ {
			xtype : 'grid',
			id : 'userMgtList-grid',
			region : 'center',
			autoExpandColumn : 'subject',
			store : userListStore,
			rowNumberer : true,
			trackMouseOver : true,
			autoScroll : true,
			columnLines : true,
			stripeRows : true,
			loadMask : true,
			border : true,
			singleSelect: true,
			selModel: sm,
			columns : [{
				header: 'IDX',
	        	dataIndex: 'idx',
	        	flex: 10/100,
//	        	width: 100,
	        	align: 'center',
				menuDisabled : true,
				hidden: true
			},{
				header: '사용자 ID',
	        	dataIndex: 'userId',
	        	flex: 10/100,
//	        	width: 100,
	        	align: 'center',
				menuDisabled : true
			},{
				header: '사용자명',
				dataIndex: 'userNm',
				flex: 10/100,
//	        	width: 100,
				align: 'center',
				menuDisabled : true
			},{
				header: '비밀번호',
				dataIndex: 'userPwd',
				flex: 10/100,
//	        	width: 100,
				align: 'center',
				menuDisabled : true,
				hidden: true
			},{
				header: '권한',
				dataIndex: 'userAuthNm',
	        	flex: 10/100,
//	        	width: 100,
				align: 'center',
				menuDisabled : true
			},{
				header: '권한코드',
				dataIndex: 'userAuth',
				flex: 10/100,
//	        	width: 100,
				align: 'center',
				menuDisabled : true,
				hidden: true
			},{
				header: '소속기관',
				dataIndex: 'userInstCdNm',
	        	flex: 10/100,
//	        	width: 100,
				align: 'center',
			},{
				header: '소속기관코드',
				dataIndex: 'userInstCd',
				flex: 10/100,
//	        	width: 100,
				align: 'center',
				hidden: true
			},{
				header: '부서',
				dataIndex: 'deptNm',
				flex: 10/100,
//	        	width: 100,
				align: 'center',
				menuDisabled : true
			},{
				header: '연락처',
				dataIndex: 'phoneNum',
	        	flex: 10/100,
//	        	width: 100,
				align: 'center',
				menuDisabled : true
			},{
				header: '이메일',
				dataIndex: 'email',
	        	flex: 16/100,
//	        	width: 100,
				align: 'center',
				menuDisabled : true
			},{
				header: '생성일자',
				dataIndex: 'createDate',
	        	flex: 12/100,
//	        	width: 100,
				align: 'center',
				menuDisabled : true
			},{
				header: '수정일자',
				dataIndex: 'updateDate',
	        	flex: 12/100,
//	        	width: 100,
				align: 'center',
				menuDisabled : true
			}],
            listeners: {
		    	//row click 이벤트
            	rowdblclick: function(grid, record, item, index, e, eOpts) {
		        	var rec = grid.getStore().getAt(index);
		        	document.getElementById('idx').value = record.get('idx');
            		document.getElementById('userId').value = record.get('userId');
            		document.getElementById('userNm').value = record.get('userNm');
            		document.getElementById('userAuth').value = record.get('userAuth');
            		document.getElementById('userInstCd').value = record.get('userInstCd');
            		document.getElementById('deptNm').value = record.get('deptNm');
            		document.getElementById('phoneNum').value = record.get('phoneNum');
            		document.getElementById('email').value = record.get('email');
            		document.getElementById('userId').readOnly = true;
            		modifyUser = true;
            		var button = Ext.get('regButton');
            		button.setText('수정');
				}
            },
            dockedItems : [{
		        xtype: 'pagingtoolbar',
		        store: userListStore,  
		        dock: 'bottom',
		        displayInfo: true,
		        items: ['->'],
		        prependButtons: true
		    }],
			viewConfig : {
				forceFit : true
			}
		} ]
		
	});
}

function doUserUpdate(){
	Ext.Msg.show({
        title: '알림',
        msg: '사용자정보를 저장하시겠습니까?', 
        buttons: Ext.Msg.OKCANCEL,
        fn: function(btn, text) {
            if (btn == 'ok') {
            	var userId = document.getElementById('mUserId').value;
            	var deptNm = document.getElementById('mDeptNm').value;
            	var userAuth = document.getElementById('mUserAuth').value;
            	var userInstCd = document.getElementById('mUserInstCd').value;
            	var phoneNum = document.getElementById('mPhoneNum').value;
            	var email = document.getElementById('mEmail').value;
            	Ext.Ajax.request({
            		url : makeUrl('/medical/basicinfo/updateUser.do'),
            		params : {
            			idx : idx,
            			userId : userId,
            			userAuth : userAuth,
            			userInstCd : userInstCd,
            			deptNm : deptNm,
            			phoneNum : phoneNum,
            			email : email,
            		},
            		success : function(resp) {
            			var obj = Ext.decode(resp.responseText);
            			if (obj.success) {	   
                        	Ext.Msg.show({
                                title: '알림',
                                msg: '저장되었습니다.', 
                                buttons: Ext.Msg.OK,
                                fn: function(btn, text) {
                                	close_user_input();
                                }
                            });                    
            			} else {
            				Ext.Msg.alert('알림', '사용자정보 저장에 실패했습니다.<br/><b>'+ obj.errMsg + '</b>');
            			}
            		},
            		callback : function() {
            		}
            	});
            }else if( btn =='cancel'){
            	return false;
            }
        }
    });
}

function doUserPwUpdate(){
	var originPwd = document.getElementById('originPwd').value;
	if(originPwd != loginUserPwd){
		Ext.Msg.alert('알림', '현재 비밀번호가 일치 하지않습니다!');
		return false;
	}
	Ext.Msg.show({
        title: '알림',
        msg: '변경한 비밀번호를 저장하시겠습니까?', 
        buttons: Ext.Msg.OKCANCEL,
        fn: function(btn, text) {
            if (btn == 'ok') {
            	var newPwd1 = document.getElementById('newPwd1').value;
            	var newPwd2 = document.getElementById('newPwd2').value;
            	
            	if(newPwd1 != newPwd2){
            		Ext.Msg.alert('알림', '입력하신 새 비밀번호가 일치 하지않습니다!');
            		return false;
            	}else if(newPwd1 == ''){
            		Ext.Msg.alert('알림', '새 비밀번호를 입력해주세요!');
            		return false;
            	}else if(newPwd1 == ''){
            		Ext.Msg.alert('알림', '새 비밀번호 확인을 입력해주세요!');
            		return false;
            	}
            	
            	Ext.Ajax.request({
            		url : makeUrl('/medical/basicinfo/updatePwd.do'),
            		params : {
            			idx : idx,
            			userId : userId,
            			userPwd : newPwd1
            		},
            		success : function(resp) {
            			var obj = Ext.decode(resp.responseText);
            			if (obj.success) {	   
                        	Ext.Msg.show({
                                title: '알림',
                                msg: '저장되었습니다.', 
                                buttons: Ext.Msg.OK,
                                fn: function(btn, text) {
                                	close_user_pw();
                                }
                            });                    
            			} else {
            				Ext.Msg.alert('알림', '비밀번호 저장에 실패했습니다.<br/><b>'+ obj.errMsg + '</b>');
            			}
            		},
            		callback : function() {
            		}
            	});
            	loginUserPwd = document.getElementById('newPwd1').value;
            }else if( btn =='cancel'){
            	return false;
            }
        }
    });
}

function pwValiCheck(chekPwd){
	var checkPwd1;
	var checkPwd2;
	
	var regexPw = /^.*(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	
	switch(chekPwd){
		case 1:
			checkPwd1 = document.getElementById('newPwd1').value;
			if(checkPwd1.length!=0 && (!checkPwd1.match(regexPw)|| checkPwd1.length < 8))
			{
				Ext.Msg.show({
				    title:'유효성 검사 에러',
				    msg:"비밀번호가 문자/숫자/특수문자포함 8자리 이상이여야 합니다.",
				    icon: Ext.MessageBox.ERROR,
				    buttons: Ext.Msg.OK,
				    fn: function(buttonId) {
				        if (buttonId === "ok") {
				        	document.getElementById('newPwd1').focus();
				        }
				    }
				});
				Ext.MessageBox.getDialog().getEl().setStyle('z-index','80000');
				
				return;
			}
			break;
		case 2:
			checkPwd2 = document.getElementById('newPwd2').value;
			if(checkPwd2.length!=0 && (!checkPwd2.match(regexPw)|| checkPwd2.length < 8))
			{
				Ext.Msg.show({
				    title:'유효성 검사 에러',
				    msg:"비밀번호가 문자/숫자/특수문자포함 8자리 이상이여야 합니다.",
				    icon: Ext.MessageBox.ERROR,
				    buttons: Ext.Msg.OK,
				    fn: function(buttonId) {
				        if (buttonId === "ok") {
				        	document.getElementById('newPwd2').focus();
				        }
				    }
				});
				Ext.MessageBox.getDialog().getEl().setStyle('z-index','80000');
				
				return;
			}
			break;
	}
	
}

function doUserMgtReset(){
	document.getElementById('idx').value = '';
	document.getElementById('userId').value = '';
	document.getElementById('userNm').value = '';
	document.getElementById('userAuth').value = '';
	document.getElementById('userInstCd').value = '';
	document.getElementById('deptNm').value = '';
	document.getElementById('phoneNum').value = '';
	document.getElementById('email').value = '';
	var button = Ext.get('regButton');
	button.setText('등록');
	document.getElementById('userId').readOnly = false;
	modifyUser = false
	userListStore.load();
	Ext.getCmp('userMgtList-grid').getView().refresh();
}

function doSave(){
	if(modifyUser){
		doUpdateUser();
	}else{
		idCheck();
	}
}

function doSaveUser(){
	var userId = document.getElementById('userId').value;
	var userNm = document.getElementById('userNm').value;
	var userAuth = document.getElementById('userAuth').value;
	var userInstCd= document.getElementById('userInstCd').value;
	var deptNm = document.getElementById('deptNm').value;
	var phoneNum = document.getElementById('phoneNum').value;
	var email = document.getElementById('email').value;
	
	Ext.Msg.confirm('알림', '사용자를 저장하시겠습니까?', function(btn) {
	    if (btn == 'yes') {
	    	if (!validCheck(userId)) {
	    		Ext.Msg.alert('알림', '사용자ID를 입력해주세요.');
	    		return;
	    	}	
	    	if (!validCheck(userNm)) {
	    		Ext.Msg.alert('알림', '사용자명을 입력해주세요.');
	    		return;
	    	}	
	    	if(!validCheck(userInstCd)){
	    		Ext.Msg.alert('알림', '소속기관을 선택해주세요.');
	    		return;
	    	}
	    	if(!validCheck(userAuth)){
	    		Ext.Msg.alert('알림', '권한을 선택해주세요.');
	    		return;
	    	}
	    	
	    	Ext.Ajax.request({
	    		url: GLOBAL_CONTEXT_PATH + '/medical/basicinfo/insertUser.do',
	    		params: {
                	userId : userId,
                	userNm : userNm,
                	userPwd : 'seoul1234',
                	userAuth : userAuth,
                	userInstCd : userInstCd,
                	deptNm : deptNm,
                	useYn : 'Y',
                	phoneNum : phoneNum,
                	email : email
    			},
                success : function(resp) {
                    var obj = Ext.decode(resp.responseText);
                    if (obj.success) {	    
	                    Ext.Msg.show({
	    	    		    title:'알림',
	    	    		    msg:"저장 되었습니다.",
	    	    		    icon: Ext.MessageBox.OK,
	    	    		    buttons: Ext.Msg.OK,
	    	    		    fn: function(buttonId) {
	    	    		        if (buttonId === "ok") {
	    	    		        	doUserMgtReset();
            	            		userListStore.load();
            	            		Ext.getCmp('userMgtList-grid').getView().refresh();
	    	    		        }
	    	    		    }
	    	    		});           
                    } else {
                          Ext.Msg.alert('알림', '사용자 등록에 실패했습니다.<br/><b>'+ obj.errMsg + '</b>');
                    }
                },
                callback : function() {
                }
	    	});
	    }
	});
	
	function validCheck(obj){
		var check = $.trim(obj);
		if(check == undefined || check == "" || check == "선택"){
			return false;
		}
		return true;
	}
}

function doUpdateUser(){
	var idx = document.getElementById('idx').value;
	var userId = document.getElementById('userId').value;
	var userNm = document.getElementById('userNm').value;
	var userAuth = document.getElementById('userAuth').value;
	var userInstCd= document.getElementById('userInstCd').value;
	var deptNm = document.getElementById('deptNm').value;
	var phoneNum = document.getElementById('phoneNum').value;
	var email = document.getElementById('email').value;
	
	Ext.Msg.confirm('알림', '사용자를 수정하시겠습니까?', function(btn) {
		if (btn == 'yes') {
			if (!validCheck(userNm)) {
				Ext.Msg.alert('알림', '사용자명을 입력해주세요.');
				return;
			}	
			if(!validCheck(userInstCd)){
				Ext.Msg.alert('알림', '소속기관을 선택해주세요.');
				return;
			}
			if(!validCheck(userAuth)){
				Ext.Msg.alert('알림', '권한을 선택해주세요.');
				return;
			}
			
			Ext.Ajax.request({
				url: GLOBAL_CONTEXT_PATH + '/medical/basicinfo/updateUser.do',
				params: {
					idx : idx,
					userId : userId,
					userNm : userNm,
					userAuth : userAuth,
					userInstCd : userInstCd,
					deptNm : deptNm,
					useYn : 'Y',
					phoneNum : phoneNum,
					email : email
				},
				success : function(resp) {
					var obj = Ext.decode(resp.responseText);
					if (obj.success) {	    
						Ext.Msg.show({
							title:'알림',
							msg:"수정 되었습니다.",
							icon: Ext.MessageBox.OK,
							buttons: Ext.Msg.OK,
							fn: function(buttonId) {
								if (buttonId === "ok") {
									doUserMgtReset();
									userListStore.load();
									Ext.getCmp('userMgtList-grid').getView().refresh();
								}
							}
						});           
					} else {
						Ext.Msg.alert('알림', '사용자 수정에 실패했습니다.<br/><b>'+ obj.errMsg + '</b>');
					}
				},
				callback : function() {
				}
			});
		}
	});
}

function idCheck(){
	var userId = document.getElementById('userId').value;
	
	Ext.Ajax.request({
		url: GLOBAL_CONTEXT_PATH + '/medical/basicinfo/checkUserId.do',
		params: {
			userId: userId,
		},
		success: function(response, options) {
			var obj = Ext.decode(response.responseText);
			if(obj.results.success==true){
				doSaveUser();
			}else{
				Ext.Msg.show({
				    title:'알림',
				    msg:"이미사용중인 ID 입니다.",
				    icon: Ext.MessageBox.ERROR,
				    buttons: Ext.Msg.OK,
				    fn: function(buttonId) {
				        if (buttonId === "ok") {
							isUserId = 'N';
							document.getElementById('userId').focus();
				        }
				    }
				});
			}
		},
		failure: function(form, action) {
			Ext.Msg.show({
			    title:'알림',
			    msg:"이미사용중인 ID 입니다.",
			    icon: Ext.MessageBox.ERROR,
			    buttons: Ext.Msg.OK,
			    fn: function(buttonId) {
			        if (buttonId === "ok") {
						isUserId = 'N';
						document.getElementById('userId').focus();
			        }
			    }
			});
		}
	});
}

function validCheck(obj){
	var check = $.trim(obj);
	if(check == undefined || check == "" || check == "선택"){
		return false;
	}
	return true;
}

function deleteUser() {
	var userId = document.getElementById('userId').value;
	var list = [];
	var s = sm.getSelection();
	if (s < 1 && (userId == '')) {
		Ext.Msg.alert('알림', '사용자를 선택해주세요.');
		return;
	}
	Ext.Msg.confirm('알림', '선택한 사용자를 삭제하시겠습니까?', function(btn) {
	    if (btn == 'yes') {	    	
	    	if(s < 1 && (userId != '')){
	    		memberVO = {
    					userId : userId
    			};
	    		list.push(memberVO);
	    	}else {
	    		Ext.each(s, function(rec) {
	    			memberVO = {
	    					userId : rec.get('userId'),
	    			};
	    			list.push(memberVO);
	    		});	    		
	    	}
	    	Ext.Ajax.request({
	    	    url : makeUrl('/medical/basicinfo/deleteUser.do'),
	    	    headers : {
                    'Content-Type' : 'application/json'
                },
                method : 'post',
                jsonData : {memberList : list},
                success : function(resp) {
                    var obj = Ext.decode(resp.responseText);
                    if (obj.success) {
                    	Ext.Msg.show({
							title:'알림',
							msg:"사용자가 삭제되었습니다.",
							icon: Ext.MessageBox.OK,
							buttons: Ext.Msg.OK,
							fn: function(buttonId) {
								if (buttonId === "ok") {
				                	doUserMgtReset();
									userListStore.load();
									document.getElementById('userMgtList-grid').getView().refresh();
								}
							}
						});       
                    } else {
                          Ext.Msg.alert('알림', '사용자 삭제에 실패했습니다.<br/><b>'+ obj.errors.reason+'</b>');
                    }
                },
                callback : function() {
                }
	    	});
	    }
	});
}