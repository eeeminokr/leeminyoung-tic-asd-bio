var pageSize =  parameter['pageSize'];
var surveyListGrid;
var activePage = parameter['activePage'];
var sm = new Ext.selection.CheckboxModel({headerWidth:40});
var surveyStore;
var performCntStore;
var surveyTitle = "Total";
var chgColumn =[];
var searchParams={};
var searchPageParams={};
var chgTabNm = pageLoad.getParameter('chgTabNm');
var chgTargetId = pageLoad.getParameter('targetId');
var chgPerformCnt = pageLoad.getParameter('performCnt');

var columnPrdv1 =[];

surveyListGrid = function() {

			Ext.create("Ext.panel.Panel", {
				// 'resizable-panel',
				height : '760px',
				region : 'center',
				layout : 'border',
				id : 'surveyList-panel',
				renderTo : 'ContentsDiv',
				border : false,
				items : [ {
					xtype : 'grid',
					id : 'surveyList-grid',
					region : 'center',
					autoExpandColumn : 'subject',
					store : surveyStore,
					rowNumberer : true,
					trackMouseOver : true,
					autoScroll : true,
					columnLines : true,
					stripeRows : true,
					loadMask : true,
					border : true,
					singleSelect: true,
					selModel: sm,
					columns : columnTotal,
					fbar: new Ext.PagingToolbar({
			        	id: 'surveyList-grid-page',
			            pageSize: pageSize,
			            store: surveyStore,
						displayInfo: true,
						items: ['->'],
			            prependButtons: true,
			            plugins : [new Ext.ux.plugin.PagingToolbarResizer()],
						listeners : {
							change : function(p, pageData) {
								if (pageData.total == 0) {
									return;
								}
								activePage = pageData.activePage;
							},
							changevalue : function (p, value) {
								pageSize = value;
							}
						}
			        }),
			        listeners: {// row click 이벤트
			        	
						celldblclick : function(view, cell, cellIndex, record,row, rowIndex, e) {
							var clickedDataIndex = view.panel.headerCt.getHeaderAtIndex(cellIndex).dataIndex;
							var clickedColumnName = view.panel.headerCt.getHeaderAtIndex(cellIndex).text;
							var clickedCellValue = record.get(clickedDataIndex);
							var tabName =['PRDV1', 'SRS01', 'SRS02', 'YGTS1', 'YGTS2', 'CYBO2', 'YBOCS', 'YBOCA', 'ARS01', 'KCBCL', 'DBDS1'
								, 'CMRSP', 'TRAUM', 'CDI01', 'IAT01', 'KSCAL', 'RCMAS', 'STITC', 'STISC', 'STITY', 'STISY', 'STITP', 'STISP'
								, 'LOICV', 'KBIS1', 'BDI01', 'MBRI1', 'KADHD', 'KPSI1', 'CYBO3'];
							
							// 연구번호 클릭 시 데이터 통합 분석 상세로 이동
							if(clickedDataIndex == "targetId"){
								var targetId = clickedCellValue;
								var url = GLOBAL_CONTEXT_PATH + '/medical/dataIntegration/dataIntegrationDtl.view';
								location.href = url+"?targetId="+targetId;
							}
							
							if(clickedCellValue=="o"){
								var targetId = record.get('targetId');
								var performCnt = record.get('performCnt');
								var tabDocId = clickedDataIndex=='cbcl1'?'kcbcl':clickedDataIndex;
								// 클릭한 열의 탭으로 이동
								searchPageParams.targetId = targetId;
								searchPageParams.performCnt = performCnt;
								searchPageParams.schKeyWord="schTargetId";
								searchPageParams.rndId=loginRndId;
								searchPageParams.disClassDtl = menuDisClassDtl;
								searchPageParams.limit=surveyStore.getPageSize();
								searchPageParams.docId = tabDocId
								moveTabPage(tabDocId.toUpperCase());
								/*
								 * for(var i in tabName){
								 * if(tabName[i]==clickedColumnName){ //클릭한 열의
								 * 탭으로 이동 gridChg(tabName[clickedColumnName]);
								 * break; } }
								 */
							}
						}
				
					}
				} ]
				
			});
	
	
}

Ext.onReady(function() {
	Ext.QuickTips.init();	
	
	surveyStore =  Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : false,
		pageSize : pageSize,
		proxy : {
			type : 'ajax',
			async : false,
			timeout : 100000000,
			extraParams : { 'disClassDtl' : menuDisClassDtl},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/survey/selectSurveyList.do',
			reader : {
				type : 'json',
				root : 'result'
			}

		},
		listeners : {
			load : function() {	
			}
		}
	});
	
	
	
	performCntStore =  Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		pageSize : pageSize,
		proxy : {
			type : 'ajax',
			async : false,
// extraParams : { docId : 'ARS01'},
			url : GLOBAL_CONTEXT_PATH
			+ '/medical/survey/selectPerformCntList.do',
			reader : {
				type : 'json',
				root : 'result'
			}
	
		},
		listeners : {
			load : function() {
				Ext.each(performCntStore.getRange(), function(record) {
					var elOptNew = document.createElement('option');
					  elOptNew.text = record.get('performNm');
					  elOptNew.value = record.get('performCnt');
					  var elSel = document.getElementById('performCnt');
					  try {
					   elSel.add(elOptNew, null); // standards compliant;
													// doesn't work in IE
					  }catch(ex) {
					   elSel.add(elOptNew); // IE only
					  }

		    	});		
			}
		}
	});
	// 메뉴 생성
	var tabList=[];
	var surveyMenuStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		proxy : {
			type : 'ajax',
			async : false,
			extraParams : { docClassDtl : 'DC002', disClassDtl : menuDisClassDtl},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/survey/selectSurveyMenuList.do',
			reader : {
				type : 'json',
				root : 'result'
			}

		},
		listeners : {
			load : function() {
					for(var i=0; i<surveyMenuStore.getTotalCount(); i++){
						var docNm=surveyMenuStore.data.items[i].data.docNm;
						var docId=surveyMenuStore.data.items[i].data.docId;
// if(i==0) $("#menuDiv").append('<button class="menuBtn"
// onClick=gridChg(\'Total\');>Total</button>');
						$(".submenu").append('<button type="button" class="menuBtn" onClick=gridChg(\''+docId+'\');>'+docNm+'</button>');
						
					}
			}
		}
	});	
	new surveyListGrid();
	// 타이틀에 마우스 오버시 2뎁스 노출
	$('.submenu').hide();
	$('h2.tit').css('cursor','pointer').addClass('has_submenu');
	$('h2.tit').click(function(){
		if( $(this).hasClass('active') ){
			$(this).removeClass('active');
			$('.submenu').hide();
		} else {
			$(this).addClass('active');
			$('.submenu').show();
		}
	});
    // 버튼 클릭시 2뎁스 타이틀
    $('.submenu').find('.menuBtn').on('click', function(){
    	var btnText = $(this).text();
        $('h3.tit').addClass('on').html(btnText);
    });
    
    // 메뉴이름 클릭 시 total로 이동
    $('h2.tit').on('click', function(){
    	$('h3.tit').removeClass('on');
    	gridChg('Total');
    });
    // 데이터 통합 분석에서 이동한 경우
      if(chgTabNm != ''){
      	
      	// 왼쪽메뉴 변경
      	parent.leftMenuChg('E001','D001');
      	
  		
      	// 해당탭으로 이동
      	searchPageParams.targetId = chgTargetId;
      	searchPageParams.performCnt = chgPerformCnt;
  		searchPageParams.schKeyWord="schTargetId";
  		searchPageParams.rndId=loginRndId;
  		searchPageParams.limit=surveyStore.getPageSize();
  		searchPageParams.disClassDtl = menuDisClassDtl;
  		searchPageParams.docId = chgTabNm;
  		moveTabPage(chgTabNm.toUpperCase());
  		
      }else{
    	  var surveyParams = {
    				docId : 'Total',
    				disClassDtl : menuDisClassDtl
    		}
    		
    		surveyStore.proxy.extraParams = surveyParams;
    		surveyStore.load();
      }

});

// 검색 팝업 열기
function openSearchPop(){
    $('.searchbox').show();
}
// 팝업 닫기
function closeSearchPop(){
    $('.searchbox').hide();
}

function excelDownload(){
    if(surveyStore.getCount() == 0) {
 Ext.Msg.alert('Warning', '결과자료가 없습니다.');
 return false;
}
    var s = sm.getSelection();
    var targetIds = '';
    var performCnts = '';
    
    Ext.each(s, function(rec) {
              if(targetIds== ''){
                         targetIds = rec.get('targetId');
   }else{
             targetIds += '|' + rec.get('targetId');
   }
              
              if(performCnts== ''){
                         performCnts = rec.get('performCnt');
   }else{
             performCnts += '|' + rec.get('performCnt');
   }
    });                   
    
    searchParams.docId = surveyTitle;
    searchParams.targetIds = targetIds;
    searchParams.performCnts = performCnts;
    document.location.href = makeUrl('/medical/survey/surveyExcelList.do', searchParams);
    
}

function excelUpload(){
	var excelDataUploadPanel = new ExcelDataUploadPanel();
	excelDataUploadPanel.show();
}

function uploadExcelDownload() {
	var fileClassDtl = 'FIL03';
	var params = {
			rndId : loginRndId,
			disClassDtl : menuDisClassDtl,
			fileClassDtl : fileClassDtl
	}
	
	location.href = GLOBAL_CONTEXT_PATH + '/downFile.view?dir=file.sample.dir&fileName=SurveyUpload.xlsx';
}


function selectDeleteSurvey(){
	Ext.Msg.confirm('알림', '선택한 데이터를 삭제하시겠습니까?', function(btn) {
	    if (btn == 'yes') {
			var list = [];
			var params = {};
			var s = sm.getSelection();
			if(s < 1){
				Ext.Msg.alert('알림', '삭제할 데이터를 선택해주세요.');
				return false;
			}
			Ext.each(s, function(rec) {
				surveyVO = {
						targetId : rec.get('targetId'),
						performCnt : rec.get('performCnt'),
						docId : surveyTitle=='Total'?surveyTitle:rec.get('docId')
				};
				list.push(surveyVO);
			});
			Ext.Ajax.request({
			    url : makeUrl('/medical/survey/deleteSurveyAnswer.do'),
			    headers : {
		            'Content-Type' : 'application/json'
		        },
		        method : 'post',
		        jsonData : {surveyList : list},
		        timeout : 100000000,
		        success : function(response, opts) {
		            var obj = Ext.decode(response.responseText);
		            if (obj.success) {
		            		Ext.Msg.alert('알림', '설문지가 삭제되었습니다. ');
		            		Ext.Msg.show({
						    	title: '알림',
						    	msg: '설문지가 삭제되었습니다..', 
						    	buttons: Ext.Msg.OK,
						    	fn: function(btn, text) {
						    		if (btn == 'ok') {
						    			surveyStore.load();
						    		}
						    	}
						    });
		            } else {
		            	Ext.MessageBox.hide();
		                Ext.Msg.alert('알림', '설문지 삭제에 실패했습니다.<br/><b>'+ obj.errors.reason+'</b>');
		            }
		        },
		        callback : function() {
		        	
		        }
			});
	    }
	});
}

/* 데이터업로드(엑셀) */
ExcelDataUploadPanel = function(){
	ExcelDataUploadPanel.superclass.constructor.call(this, {
		id: 'ExcelDataFile-upload',
		closeAction: 'destroy',
		title: '설문지 데이터 업로드',
		plain: false,
		width: 400,
		height : 170,
		maximizable: false,
		modal: true,
		border : false,
		resizable : false,
		layout : 'fit',
		items: [
			 Ext.create('Ext.form.Panel',{
				fileUpload: true,
		        frame: true,
		        autoHeight: true,
				labelWidth: 150,
				style : "padding-top: 20px;",
		        items: [{
		        	msgTarget: 'side',
		        	// allowBlank: false,
      				// inputType: 'file',
					id: 'excelUploadFile',
					name: 'excelUploadFile',
					fieldLabel: '원본 파일',
					// blankText: '원본 파일',
					anchor: '95%',
					style : "padding-left: 20px;",
					required: true,
					autoShow: true,
					xtype: 'filefield',
					width : 350,
					listeners:{
						change : function( obj, value, eOpts ){
							obj.setRawValue(value.replace(/C:\\fakepath\\/g, ''));
						}
					}
		        },{
		        	msgTarget: 'side',
		        	// allowBlank: false,
      				// inputType: 'file',
					id: 'uploadZipFile',
					name: 'uploadZipFile',
					fieldLabel: '관리 파일 ',
					// blankText: '관리 파일',
					anchor: '95%',
					style : "padding-left: 20px;",
					required: true,
					autoShow: true,
					xtype: 'filefield',
					width : 350,
					listeners:{
						change : function( obj, value, eOpts ){
							obj.setRawValue(value.replace(/C:\\fakepath\\/g, ''));
						}
					}
		        }],
		        buttonAlign: 'center',
		        buttons: [{
		            text: '업로드',
		            handler: function(btn){
		            	var win = btn.up('window');
		                var formF = win.down('form');
		            	ufp =formF.getForm();
		            	var file1 = Ext.getCmp('uploadZipFile').getValue();
		            	var file2 = Ext.getCmp('excelUploadFile').getValue();
		            	if(file1=="" && file2==""){
		            		Ext.Msg.alert('알림', '<b>업로드 파일을 확인해 주세요.</b>');
		            		return false;
		            	}else{
		            		if(file1 != "" && !file1.match(/(.zip|.tar|.gz)$/)){
		            			Ext.Msg.alert('알림', 'zip, tar, gz 확장자를 가진 파일만 진행 가능합니다.');
			            	    return false;
		            		}
		            		if(file2 != "" && !file2.match(/(.xls|.xlsx)$/)){
		            			Ext.Msg.alert('알림', 'xls, xlsx 확장자를 가진 파일만 진행 가능합니다.');
			            	    return false;
		            		}
			            	var taskId = ((1 + Math.random()) * 0x10000 | 0).toString(16).substring(1) + new Date().getMilliseconds();
			            	var params = {
	    			    			taskIdentity : taskId,
	        					};
			            	// a boolean flag to decide when to stop checking
							// progress
	    			    	var getProgressBoo=true;
	    			    	Ext.MessageBox.show({
	    				           title: 'Please wait',
	    				           msg: '<Label id="proTitle">설문지 엑셀 업로드 중입니다.</Label>',
	    				           progressText: 'Initializing...',
	    				           width:300,
	    				           progress:true,
	    				           closable:false
	    				       });
	    			    	var f = function(proCnt,totCnt){
	    			            return function(){
	    			            	if(proCnt == totCnt){
	    			            	}else{
	    			            		var avg = isNaN(proCnt/totCnt)==true?0:proCnt/totCnt;
	    			            		Ext.MessageBox.updateProgress(avg, Math.round(100*avg)+'% completed');
	    			            	}
	    			           };
	    			        };
	    			        var task = {
	 			    			   run: function(){
	 				    			      if(getProgressBoo){
	 				    			         // make another Ajax request to
												// get the latest status
	 				    			         Ext.Ajax.request({
	 				    			            url : GLOBAL_CONTEXT_PATH + '/ProgressMonitor',
	 				    			            timeout: 100000000,
	 				    			            method: 'POST',
	 				    			            params :{
	 				    			               taskIdentity: taskId   // use
																			// the
																			// same
																			// taskId
																			// which
																			// was
																			// used
																			// while
																			// submitting
																			// task
	 				    			            },
	 				    			            success: function (response, options) {
	 				    			               var obj = Ext.decode(response.responseText);
	 				    			               // get the number of total
													// items and total
													// processed..
	 				    			               // for a task with 5 steps,
													// totalItems would be 5 and
													// totalProcessed will
	 				    			               // vary from 0 to 5..
	 				    			               var totalItems = obj.total;
	 				    			               var totalProcessed = obj.totalProcessed;
	 				    			               var taskName  = '설문지 엑셀 업로드';
	 				    			               var statusName = '';
	 				    			               var taskNum = obj.taskNum;
	 				    			               taskName  = '설문지 엑셀 업로드 중입니다.';
	// if(taskNum == 2) taskName = '승인요청 등록중입니다.';
	// if(taskNum == 3) taskName = '확인서에 저장중입니다.';
	// if(taskNum == 4) taskName = '최종 승인요청 업로드 중입니다.';
	 				    			               
	 				    			               if (obj.statusNum != 0){
	 				    			            	   document.getElementById("proTitle").innerHTML = statusName;
	 				    			               }else{
	 				    			            	   if(totalProcessed == 0 && totalItems==0){
	 				    			            		   document.getElementById("proTitle").innerHTML = statusName;
	 				    			            	   }else{
	 				    			            		   document.getElementById("proTitle").innerHTML = taskName
	 					    			            	   +"( "
	 					    			            	   +totalProcessed
	 					    			            	   +" / "
	 					    			            	   +totalItems
	 					    			            	   +" )";
	 				    			            	   }						        				    			               }
	 				    			               setTimeout(f(totalProcessed, totalItems), 10);
	 				    			            }
	 				    			         });
	 				    			      }else{
	 				    			         // stop the TaskRunner when the
												// 'getProgressBoo' is false
	 				    			         runner.stop(task);
	 				    			      }
	 				    			   },
	 				    			   interval: 500 // monitor the progress
														// every 200
														// milliseconds
	 				    			};
		    			        var runner = new Ext.util.TaskRunner();
		    					runner.start(task);
			            		var  url = GLOBAL_CONTEXT_PATH + '/medical/survey/surveyExcelUpload.do';
			            		ufp.submit({
				                	url: url,
				                	params: {
	    								'taskId' : taskId,
	    								rndId: loginRndId,
				                		disClassDtl: menuDisClassDtl,
				                		fileClassDtl: 'FIL03'
	    						    },
		                            success: function(response, opts){
		                            	  Ext.MessageBox.hide();
		                            	  getProgressBoo=false;
									      var obj = Ext.decode(response.responseText);
									      var json = Ext.util.JSON.decode(opts.response.responseText);
		                                  Ext.Msg.show({
		                                      title: '알림',
		                                      msg: '파일 업로드를 성공하였습니다.', 
		                                      buttons: Ext.Msg.OK,
		                                      fn: function(btn, text) {
		                                          if (btn == 'ok') {
		                                        	  doSearch();
		                                        	  Ext.getCmp('ExcelDataFile-upload').close();
		                                          }
		                                      }
		                                  });
		                              },
		                              failure : function(response, opts) {
		                            	  Ext.MessageBox.hide();
		                            	  getProgressBoo=false;
		                              	  var json = Ext.util.JSON.decode(opts.response.responseText);
		                                  Ext.Msg.alert('알림', '<b>' + json.message + '</b>');
		                              }
				                });
		            	}
		            }
		        },{
					text: '취소',
					handler: function(){
						Ext.getCmp('ExcelDataFile-upload').close();
					}
				}]
			})
		]
	});
};

Ext.extend(ExcelDataUploadPanel, Ext.Window, {
});

function doSearch() {
	var targetId = document.getElementById('targetId').value;
	var male = '';
	var female = '';
	var sex = '';
	var checkPro="";
	var startAge = document.getElementById('startAge').value;
	var endAge = document.getElementById('endAge').value;
	var performCnt = document.getElementById('performCnt').value;
	var cv = '';
	var pSelf = '';
	var cSelf = '';
	var pSelf2 = '';
	var iv4 = '';
	
	$("input:checkbox[name=check_pro]:checked").each(function(){
		if(checkPro != "")checkPro += ",";
		var val = this.value;
		val = val.replace(/ /gi, ""); 
		checkPro += "'"+ val+ "'";
	});
	
	if($('#male').prop('checked') == true) {
		male = 'Y';		
	}else{
		male = 'N';
	}
	
	if($('#female').prop('checked') == true) {
		female = 'Y';		
	}else{
		female = 'N';
	}
	
	if($('#pro_1').prop('checked') == true) {
		ptY = 'Y';		
	}else{
		ptY = 'N';
	}
	
	if($('#pro_2').prop('checked') == true) {
		ptN = 'Y';		
	}else{
		ptN = 'N';
	}
	if(male == 'Y' && female == 'N'){
		sex = 'M'
	}else if(male == 'N' && female == 'Y'){
		sex = 'F'
	}else{
		sex = '';
	}
	if(ptY == 'Y' && ptN == 'N'){
		ptYn = 'Y'
	}else if(ptY == 'N' && ptN == 'Y'){
		ptYn = 'N'
	}else{
		ptYn = '';
	}
	if($('#cv').prop('checked') == true) {
		cv = 'Y';		
	}else{
		cv = 'N';
	}
	if($('#pSelf').prop('checked') == true) {
		pSelf = 'Y';		
	}else{
		pSelf = 'N';
	}
	if($('#cSelf').prop('checked') == true) {
		cSelf = 'Y';		
	}else{
		cSelf = 'N';
	}
	if($('#pSelf2').prop('checked') == true) {
		pSelf2 = 'Y';		
	}else{
		pSelf2 = 'N';
	}
	if($('#iv4').prop('checked') == true) {
		iv4 = 'Y';		
	}else{
		iv4 = 'N';
	}
	searchParams = {
			docId : surveyTitle,
			targetId : targetId,
			sex : sex,
			protocol : checkPro,
			startAge : startAge,
			endAge : endAge,
			performCnt : performCnt,
			cv : cv,
			pSelf : pSelf,
			cSelf : cSelf,
			pSelf2 : pSelf2,
			iv4 : iv4
	}
	surveyStore.proxy.extraParams = searchParams;
		
	var pageParams = {
			start : 0,
			limit : pageSize
		};
	
	surveyStore.load({
		params : pageParams
	});
}

function gridChg(title,pageNum,rNum){
	// 검색조건에 임상가평가, 4주간 평가 콤보 조건
	var performNm = 'V';
	if(title == 'SRS02' || title == 'YGTS2' || title == 'CYBO2' || title == 'CYBO3') performNm = 'W';
	if(title == 'Total'){// 전체탭일 경우 추가검색조건 표시
		performNm = '';
		document.getElementById('check_right').style.display = "block";
	}else{
		document.getElementById('check_right').style.display = "none";
	}
	var performParams = {
			performNm : performNm
	}
	performCntStore.proxy.extraParams = performParams;
	performCntStore.load();
	performCntStore.on('load', function(store, records, successful){
		var elSel = document.getElementById('performCnt');
		var i;
		for (i = elSel.length - 1; i>=1; i--) {
			elSel.remove(i);
		}
		/**
		 * 선택된 option의 이전에 새로운 option 을 추가한다.
		 */
		var elSel = '';
		Ext.each(performCntStore.getRange(), function(record) {
			var elOptNew = document.createElement('option');
			  elOptNew.text = record.get('performNm');
			  elOptNew.value = record.get('performCnt');
			  var elSel = document.getElementById('performCnt');
			  try {
			   elSel.add(elOptNew, null); // standards compliant; doesn't work
											// in IE
			  }catch(ex) {
			   elSel.add(elOptNew); // IE only
			  }

    	});		
	});
	Ext.Ajax.request({
 		url : GLOBAL_CONTEXT_PATH + '/medical/survey/selectDocNmByDocId.do',
 	    method : 'POST',
 	    params :{
           docId: title,
           disClassDtl : menuDisClassDtl  
        },
 	    timeout : 100000000,
        success : function(response, opts) {
        	var obj = Ext.decode(response.responseText);
            if (obj.success) {
            	if(obj.docNm != null)	$('h3.tit').addClass('on').html(obj.docNm);
            }
        },
        failure : function(){
        },
        callback : function() {
        }
 	});

	searchParams.disClassDtl = menuDisClassDtl;
	if(title == "PRDV1"){
		surveyTitle = "PRDV1";
		chgColumn = columnPrdv1;
		searchParams.docId = 'PRDV1';
		
		//주산기 발달력 컬럼 동적 구현 addPrdv1~addPrdv4
		var left;
		var prdvCount = 1;
		$(".x-grid-scrollbar").scroll(function(){
			left = $(this).scrollLeft();
			var width1 = $(this)[0].scrollWidth;
			var width2 = $(this)[0].clientWidth;
			var val = width1 - width2;
			if(left == val && prdvCount < 5 && surveyTitle == "PRDV1"){
				Ext.MessageBox.show({
				       msg: '<p style="text-align:center"><br/>항목을 불러오는 중입니다.</p>',
				       progressText: '잠시만 기다려주세요..',
				       width:300,
				       wait:true,
				       waitConfig: {interval:150},
				   });
				
				setTimeout(function(){
					Ext.suspendLayouts();
					surveyStore.suspendEvents();
					eval("addPrdv"+prdvCount+"(left)");
					Ext.getCmp("surveyList-grid").reconfigure(chgColumn);
					Ext.resumeLayouts(true);
					surveyStore.resumeEvents();
					surveyStore.commitChanges();
					prdvCount++;
					Ext.MessageBox.hide();
				}, 1000);
				}
		});
		
	}else if(title == "SRS01"){
		surveyTitle = "SRS01";
		chgColumn = columnSrs1;
		searchParams.docId = 'SRS01';
	}else if(title == "SRS02"){
		surveyTitle = "SRS02";
		chgColumn = columnSrs2;
		searchParams.docId = 'SRS02';
	}else if(title == "YGTS1"){
		surveyTitle = "YGTS1";
		chgColumn = columnYgtss1;
		searchParams.docId = 'YGTS1';
	}else if(title == "YGTS2"){
		surveyTitle = "YGTS2";
		chgColumn = columnYgtss2;
		searchParams.docId = 'YGTS2';
	}else if(title == "CYBO2"){ // 임상가평가 미존재
		surveyTitle = "CYBO2";
		chgColumn = columnCyBocs2;
		searchParams.docId = 'CYBO2';
	}else if(title == "CYBO3"){ 
		surveyTitle = "CYBO3";
		chgColumn = columnCybo3;
		searchParams.docId = 'CYBO3';
	}else if(title == "YBOCS"){
		surveyTitle = "YBOCS";
		chgColumn = columnYBocs;
		searchParams.docId = 'YBOCS';
	}else if(title == "YBOCA"){
		surveyTitle = "YBOCA";
		chgColumn = columnYBoca;
		searchParams.docId = 'YBOCA';
	}else if(title == "ARS01"){
		surveyTitle = "ARS01"
		chgColumn = columnArs;
		searchParams.docId = 'ARS01';
	}else if(title == "KCBCL"){
		surveyTitle = "KCBCL"
		chgColumn = columnKCbcl;
		searchParams.docId = 'KCBCL';
	}else if(title == "DBDS1"){ 
		surveyTitle = "DBDS1"
		chgColumn = columnDbds;
		searchParams.docId = 'DBDS1';
	}else if(title == "CMRSP"){ 
		surveyTitle = "CMRSP"
		chgColumn = columnCmrsP;
		searchParams.docId = 'CMRSP';
	}else if(title == "TRAUM"){
		surveyTitle = "TRAUM" 
		chgColumn = columnTrauma;
		searchParams.docId = 'TRAUM';
	}else if(title == "CDI01"){ 
		surveyTitle = "CDI01"
		chgColumn = columnCdi;
		searchParams.docId = 'CDI01';
	}else if(title == "IAT01"){ 
		surveyTitle = "IAT01"
		chgColumn = columnIat;
		searchParams.docId = 'IAT01';
	}else if(title == "KSCAL"){ 
		surveyTitle = "KSCAL"
		chgColumn = columnKScale;
		searchParams.docId = 'KSCAL';
	}else if(title == "RCMAS"){ 
		surveyTitle = "RCMAS"
		chgColumn = columnRcmas;
		searchParams.docId = 'RCMAS';
	}else if(title == "STITC"){
		surveyTitle = "STITC" 
		chgColumn = columnStaiTC;
		searchParams.docId = 'STITC';
	}else if(title == "STISC"){
		surveyTitle = "STISC" 
		chgColumn = columnStaiSC;
		searchParams.docId = 'STISC';
	}else if(title == "STITY"){
		surveyTitle = "STITY" 
		chgColumn = columnStaiTY;
		searchParams.docId = 'STITY';
	}else if(title == "STISY"){
		surveyTitle = "STISY" 
		chgColumn = columnStaiSY;
		searchParams.docId = 'STISY';
	}else if(title == "STITP"){ 
		surveyTitle = "STITP"
		chgColumn = columnStaiTP;
		searchParams.docId = 'STITP';
	}else if(title == "STISP"){ 
		surveyTitle = "STISP"
		chgColumn = columnStaiSP;
		searchParams.docId = 'STISP';
	}else if(title == "LOICV"){ 
		surveyTitle = "LOICV"
		chgColumn = columnLoiCv;
		searchParams.docId = 'LOICV';
	}else if(title == "KBIS1"){ 
		surveyTitle = "KBIS1"
		chgColumn = columnKBis11;
		searchParams.docId = 'KBIS1';
	}else if(title == "BDI01"){ 
		surveyTitle = "BDI01"
		chgColumn = columnBdi;
		searchParams.docId = 'BDI01';
	}else if(title == "MBRI1"){ 
		surveyTitle = "MBRI1"
		chgColumn = columnMbri;
		searchParams.docId = 'MBRI1';
	}else if(title == "KADHD"){ 
		surveyTitle = "KADHD"
		chgColumn = columnkAadhds;
		searchParams.docId = 'KADHD';
	}else if(title == "KPSI1"){ 
		surveyTitle = "KPSI1"
		chgColumn = columnPsi;
		searchParams.docId = 'KPSI1';
	}else if(title == "Total"){ 
		surveyTitle = "Total";
		chgColumn = columnTotal;
		searchParams.docId = 'Total';
	}
// var selCol = Ext.getCmp("surveyList-grid").getColumns()[0];
// if(title == "Total"){
// selCol.hide();
// }else{
// selCol.show();
// }
	surveyStore.proxy.url = GLOBAL_CONTEXT_PATH + '/medical/survey/selectSurveyList.do';
	surveyStore.proxy.extraParams = searchParams;
	if(pageNum != "" && pageNum != undefined){
		surveyStore.currentPage = pageNum;
		surveyStore.load(function(){
			
			sm.select(rNum,true);
			// 스크롤 이동
			var x= Ext.getCmp('surveyList-grid').getView().ownerGrid.getX();
			Ext.getCmp('surveyList-grid').getView().ownerGrid.scrollTo(x,rNum*26);
			Ext.MessageBox.hide();
		});
	}else{
		surveyStore.load(function(){
		});
	}
	Ext.suspendLayouts();
	surveyStore.suspendEvents();
	Ext.getCmp("surveyList-grid").reconfigure(surveyStore, chgColumn);
	Ext.resumeLayouts(true);
	surveyStore.resumeEvents();
}
// Grid column

// Total column 설문지(전체)
var columnTotal =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'visitDate',
					header : '방문일자',
					tooltip: '방문일자',
					width: 100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: '임상가평가',
					menuDisabled : true,
					columns : [{
						dataIndex : 'cvCgis',
						header : 'CGI-S',
						tooltip: 'CGI-S',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'cvCgii',
						header :'CGI-I',
						tooltip: 'CGI-I',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'cvCgas',
						header : 'C-GAS',
						tooltip: 'C-GAS',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'srs01',
						header : 'SRS',
						tooltip: 'SRS',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'ygts1',
						header : 'YGTSS',
						tooltip: 'YGTSS',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
						
					},{
						dataIndex : 'yboca',
						header : 'YBOCS<br/>(임상가평가)',
						tooltip: 'YBOCS(임상가평가)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'ybocs',
						header : 'YBOCS-부모<br/>(임상가평가)',
						tooltip: 'YBOCS-부모(임상가평가)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					}]
				},{
					text: '부모자녀평가',
					menuDisabled : true,
					columns : [{
						dataIndex : 'ars01',
						header : 'ARS',
						tooltip: 'ARS',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
						
					},{
						dataIndex : 'kcbcl',
						header :'K-CBCL',
						tooltip: 'K-CBCL',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'cbcl1',
						header : 'CBCL',
						tooltip: 'CBCL',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'dbds1',
						header : 'DBDS',
						tooltip: 'DBDS',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'cmrsp',
						header : 'CMRS-P',
						tooltip: 'CMRS-P',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'traum',
						header : '트라우마',
						tooltip: '트라우마',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
						
					}]
				},{
					text: '아동자가평가',
					menuDisabled : true,
					columns : [{
						dataIndex : 'cdi01',
						header : 'CDI',
						tooltip: 'CDI',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }						
					},{
						dataIndex : 'iat01',
						header :'IAT',
						tooltip: 'IAT',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'kscal',
						header : 'K-척도',
						tooltip: 'K-척도',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'rcmas',
						header : 'RCMAS',
						tooltip: 'RCMAS',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'stitc',
						header : 'STAI-T<br/>(아동)',
						tooltip: 'STAI-T(아동)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'stisc',
						header : 'STAI-S<br/>(아동)',
						tooltip: 'STAI-S(아동)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }						
					},{
						dataIndex : 'stity',
						header : 'STAI-T<br/>(청소년)',
						tooltip: 'STAI-T(청소년)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }						
					},{
						dataIndex : 'stisy',
						header : 'STAI-S<br/>(청소년)',
						tooltip: 'STAI-S(청소년)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }						
					},{
						dataIndex : 'loicv',
						header : 'LOI-CV',
						tooltip: 'LOI-CV',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'kbis1',
						header : 'K-BIS-11-R',
						tooltip: 'K-BIS-11-R',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					}]
				},{
					text: '부모자가평가',
					menuDisabled : true,
					columns : [{
						dataIndex : 'bdi01',
						header : 'BDI',
						tooltip: 'BDI',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'stitp',
						header : 'STAI-T<br/>(부모)',
						tooltip: 'STAI-T(부모)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'stisp',
						header : 'STAI-S<br/>(부모)',
						tooltip: 'STAI-S(부모)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'mbri1',
						header : 'MBRI',
						tooltip: 'MBRI',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'kadhd',
						header : 'K-AADHDS<br/>(성인용)',
						tooltip: 'K-AADHDS(성인용)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'kpsi1',
						header : 'K-PSI',
						tooltip: 'K-PSI',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					}]
				},{
					text: '4주 간격 면담지',
					menuDisabled : true,
					columns : [{
						dataIndex : 'iv4Cgis',
						header : 'CGI-S',
						tooltip: 'CGI-S',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'iv4Cgii',
						header : 'CGI-I',
						tooltip: 'CGI-I',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'iv4Cgas',
						header : 'C-GAS',
						tooltip: 'C-GAS',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'srs02',
						header : 'SRS',
						tooltip: 'SRS',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'ygts2',
						header : 'YGTSS',
						tooltip: 'YGTSS',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'cybo2',
						header : 'YBOCS<br />(4주간격면담지)',
						tooltip: 'YBOCS(4주간격면담지)',
						align : 'center',
						width: 100,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'cybo3',
						header : 'YBOCS-부모<br />(4주간격면담지)',
						tooltip: 'YBOCS-부모(4주간격면담지)',
						align : 'center',
						width: 100,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					},{
						dataIndex : 'pillCount',
						header : 'Pill Count',
						tooltip: 'Pill Count',
						align : 'center',
						renderer : Ext.util.Format.tooltip,
						width: 130,
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					}
					}]
				}];

// Total column END

// PRDV column 주산기 발달력 설문지 검사 임상가평가(SRS)
columnPrdv1.push({ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					hidden: true
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					hidden: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'prdvExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: '부모 및 가족 가정환경',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '조부',
						tooltip: '조부',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'조모',
						tooltip: '조모',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '외조부',
						tooltip: '외조부',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '외조모',
						tooltip: '외조모',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '부',
						tooltip: '부',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '모',
						tooltip: '모',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '그외',
						tooltip: '그외',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '부학력',
						tooltip: '부학력',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '모학력',
						tooltip: '모학력',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '부종교',
						tooltip: '부종교',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '모종교',
						tooltip: '모종교',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '경제수준',
						tooltip: '경제수준',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '모손잡이',
						tooltip: '모손잡이',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '부손잡이',
						tooltip: '부손잡이',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '부출생연도',
						tooltip: '부출생연도',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '부현재키',
						tooltip: '부현재키',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '모출생연도',
						tooltip: '모출생연도',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '모현재키',
						tooltip: '모현재키',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '부직업',
						tooltip: '부직업',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '모직업',
						tooltip: '모직업',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: '가족의 건강',
					menuDisabled : true,
					columns : [{
						dataIndex : 'b1',
						header : 'ADHD',
						tooltip: 'ADHD',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b2',
						header : '학습장애',
						tooltip: '학습장애',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b3',
						header : '언어',
						tooltip: '언어',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b4',
						header : '정신지체',
						tooltip: '정신지체',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b5',
						header : 'OCD',
						tooltip: 'OCD',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b6',
						header : '지나친 걱정',
						tooltip: '지나친 걱정',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b7',
						header : '틱',
						tooltip: '틱',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b8',
						header : '정신병',
						tooltip: '정신병',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b9',
						header : '우울증',
						tooltip: '우울증',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b10',
						header : '불안증',
						tooltip: '불안증',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b11',
						header : '공황장애',
						tooltip: '공황장애',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b12',
						header : '자살',
						tooltip: '자살',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b13',
						header : '알콜중독',
						tooltip: '알콜중독',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b14',
						header : '야노증',
						tooltip: '야노증',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b15',
						header : '자폐증',
						tooltip: '자폐증',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b16',
						header : '행동장애',
						tooltip: '행동장애',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b17',
						header : '도둑질 등',
						tooltip: '도둑질 등',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b18',
						header : '법적문제',
						tooltip: '법적문제',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b19',
						header : '감옥',
						tooltip: '감옥',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b20',
						header : '조울증',
						tooltip: '조울증',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b21',
						header : '기타',
						tooltip: '기타',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b22',
						header : '누가(1)',
						tooltip: '누가(1)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b23',
						header : '자세히(1)',
						tooltip: '자세히(1)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b24',
						header : '누가(2)',
						tooltip: '누가(2)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b25',
						header : '자세히(2)',
						tooltip: '자세히(2)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b26',
						header : '누가(3)',
						tooltip: '누가(3)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b27',
						header : '자세히(3)',
						tooltip: '자세히(3)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b28',
						header : '누가(4)',
						tooltip: '누가(4)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b29',
						header : '자세히(4)',
						tooltip: '자세히(4)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b30',
						header : '(부)복용약물명',
						tooltip: '(부)복용약물명',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b31',
						header : '복용량',
						tooltip: '복용량',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b32',
						header : '복용기간',
						tooltip: '복용기간',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b33',
						header : '(모)복용약물명',
						tooltip: '(모)복용약물명',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b34',
						header : '복용량',
						tooltip: '복용량',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b35',
						header : '복용기간',
						tooltip: '복용기간',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b36',
						header : '(부)흡연여부',
						tooltip: '(부)흡연여부',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b37',
						header : '시작연도',
						tooltip: '시작연도',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b38',
						header : '끊은연도',
						tooltip: '끊은연도',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b39',
						header : '흡연량',
						tooltip: '흡연량',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b40',
						header : '(모)흡연여부',
						tooltip: '(모)흡연여부',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b41',
						header : '시작연도',
						tooltip: '시작연도',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b42',
						header : '끊은연도',
						tooltip: '끊은연도',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b43',
						header : '흡연량',
						tooltip: '흡연량',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b44',
						header : '(부)음주여부',
						tooltip: '(부)음주여부',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b45',
						header : '시작연도',
						tooltip: '시작연도',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b46',
						header : '끊은연도',
						tooltip: '끊은연도',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b47',
						header : '마시는 횟수',
						tooltip: '마시는 횟수',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b48',
						header : '주종',
						tooltip: '주종',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b49',
						header : '양',
						tooltip: '양',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b50',
						header : '(모)음주여부',
						tooltip: '(모)음주여부',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b51',
						header : '시작연도',
						tooltip: '시작연도',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b52',
						header : '끊은연도',
						tooltip: '끊은연도',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'b53',
						header : '마시는 횟수',
						tooltip: '마시는 횟수',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b54',
						header : '주종',
						tooltip: '주종',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'b55',
						header : '양',
						tooltip: '양',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					}]
				}
				);

function addPrdv1(){
	columnPrdv1.push({
			text: '임신 관련 정보',
			menuDisabled : true,
			columns : [{
				dataIndex : 'c1',
				header : '기분',
				tooltip: '기분',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
	},{
		dataIndex : 'c2',
		header : '의학적도움 여부',
		tooltip: '의학적도움 여부',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c3',
		header : '사전임신',
		tooltip: '사전임신',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c4',
		header : '사전출산',
		tooltip: '사전출산',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c5',
		header : '사전유산',
		tooltip: '사전유산',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c6',
		header : '유산개월',
		tooltip: '유산개월',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c7',
		header : '사전 낙태',
		tooltip: '사전 낙태',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c8',
		header : '사전 사산',
		tooltip: '사전 사산',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c9',
		header : '피임방법',
		tooltip: '피임방법',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c10',
		header : '계획임신',
		tooltip: '계획임신',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c11',
		header : '원하던임신',
		tooltip: '원하던임신',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c12',
		header : '(모)나이',
		tooltip: '(모)나이',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c13',
		header : '(부)나이',
		tooltip: '(부)나이',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c14',
		header : '산전검진',
		tooltip: '산전검진',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c15',
		header : '간격',
		tooltip: '간격',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false,
		renderer: function(value, metaData, record, rowIdx, colIdx, store) {
	        value = Ext.String.htmlEncode(value);
	        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
	        return value;
	},
	},{
		dataIndex : 'c16',
		header : '입덧',
		tooltip: '입덧',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c17',
		header : '시기',
		tooltip: '시기',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c18',
		header : '오심',
		tooltip: '오심',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c19',
		header : '구토',
		tooltip: '구토',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c20',
		header : '체중감소',
		tooltip: '체중감소',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c21',
		header : '기타',
		tooltip: '기타',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c22',
		header : '스트레스 여부',
		tooltip: '스트레스 여부',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c23',
		header : '이유',
		tooltip: '이유',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false,
		renderer: function(value, metaData, record, rowIdx, colIdx, store) {
	        value = Ext.String.htmlEncode(value);
	        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
	        return value;
	},
	},{
		dataIndex : 'c24',
		header : '술',
		tooltip: '술',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c25',
		header : '담배',
		tooltip: '담배',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c26',
		header : '커피',
		tooltip: '커피',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c27',
		header : '한약',
		tooltip: '한약',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c28',
		header : '다른약물',
		tooltip: '다른약물',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c29',
		header : '기타',
		tooltip: '기타',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c30',
		header : '언제(1)',
		tooltip: '언제(1)',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c31',
		header : '기간(1)',
		tooltip: '기간(1)',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c32',
		header : '양(1)',
		tooltip: '양(1)',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c33',
		header : '언제(2)',
		tooltip: '언제(2)',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c34',
		header : '기간(2)',
		tooltip: '기간(2)',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c35',
		header : '양(2)',
		tooltip: '양(2)',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c36',
		header : '질환명',
		tooltip: '질환명',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false,
		renderer: function(value, metaData, record, rowIdx, colIdx, store) {
	        value = Ext.String.htmlEncode(value);
	        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
	        return value;
	},
	},{
		dataIndex : 'c37',
		header : '약물이름',
		tooltip: '약물이름',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false,
		renderer: function(value, metaData, record, rowIdx, colIdx, store) {
	        value = Ext.String.htmlEncode(value);
	        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
	        return value;
	},
	},{
		dataIndex : 'c38',
		header : '용량',
		tooltip: '용량',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false,
		renderer: function(value, metaData, record, rowIdx, colIdx, store) {
	        value = Ext.String.htmlEncode(value);
	        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
	        return value;
	},
	},{
		dataIndex : 'c39',
		header : '복용기간',
		tooltip: '복용기간',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false,
		renderer: function(value, metaData, record, rowIdx, colIdx, store) {
	        value = Ext.String.htmlEncode(value);
	        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
	        return value;
	},
	},{
		dataIndex : 'c40',
		header : '입덧',
		tooltip: '입덧',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c41',
		header : '통증',
		tooltip: '통증',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c42',
		header : '고혈압',
		tooltip: '고혈압',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c43',
		header : '유산방지',
		tooltip: '유산방지',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c44',
		header : '체중증가',
		tooltip: '체중증가',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c45',
		header : '건강위해',
		tooltip: '건강위해',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c46',
		header : '산전비타민',
		tooltip: '산전비타민',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c47',
		header : '기타',
		tooltip: '기타',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false,
		renderer: function(value, metaData, record, rowIdx, colIdx, store) {
	        value = Ext.String.htmlEncode(value);
	        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
	        return value;
	},
	},{
		dataIndex : 'c48',
		header : '태아위치',
		tooltip: '태아위치',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c49',
		header : '양수터짐',
		tooltip: '양수터짐',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c50',
		header : '하혈',
		tooltip: '하혈',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c51',
		header : '피비침',
		tooltip: '피비침',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c52',
		header : '풍진',
		tooltip: '풍진',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c53',
		header : '임신중독증',
		tooltip: '임신중독증',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c54',
		header : '경련',
		tooltip: '경련',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c55',
		header : '정신적문제',
		tooltip: '정신적문제',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c56',
		header : '가정문제',
		tooltip: '가정문제',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c57',
		header : '사고부상',
		tooltip: '사고부상',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c58',
		header : '변비 등',
		tooltip: '변비 등',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c59',
		header : '심리적 스트레스',
		tooltip: '심리적 스트레스',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	},{
		dataIndex : 'c60',
		header : '스트레스 정도',
		tooltip: '스트레스 정도',
		width: 80,
		align : 'center',
		menuDisabled : true,
		sortable: false
	}]
});
};

function addPrdv2(){
	columnPrdv1.push({
			text: '출산',
			menuDisabled : true,
			columns : [{
				dataIndex : 'd1',
				header : '출산 달',
				tooltip: '출산 달',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
			        value = Ext.String.htmlEncode(value);
			        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
			        return value;
			},
			},{
				dataIndex : 'd2',
				header : '주수',
				tooltip: '주수',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd3',
				header : '진통후 분만 시간',
				tooltip: '진통후 분만 시간',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd4',
				header : '양수터진 후 출산시간',
				tooltip: '양수터진 후 출산시간',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd5',
				header : '출산방식',
				tooltip: '출산방식',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd6',
				header : '관장여부',
				tooltip: '관장여부',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd7',
				header : '쌍둥이여부',
				tooltip: '쌍둥이여부',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd8',
				header : '마취여부',
				tooltip: '마취여부',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd9',
				header : '전신/부분',
				tooltip: '전신/부분',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd10',
				header : '제왕절개 계획여부',
				tooltip: '제왕절개 계획여부',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd11',
				header : '이유',
				tooltip: '이유',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
			        value = Ext.String.htmlEncode(value);
			        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
			        return value;
			},
			},{
				dataIndex : 'd12',
				header : '난산',
				tooltip: '난산',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd13',
				header : '심폐이상',
				tooltip: '심폐이상',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd14',
				header : '탯줄감김',
				tooltip: '탯줄감김',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd15',
				header : '호흡곤란',
				tooltip: '호흡곤란',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd16',
				header : '태반문제',
				tooltip: '태반문제',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd17',
				header : '탯줄문제',
				tooltip: '탯줄문제',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd18',
				header : '기타건강',
				tooltip: '기타건강',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd19',
				header : '체중',
				tooltip: '체중',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},
			{
				dataIndex : 'd20',
				header : '머리둘레',
				tooltip: '머리둘레',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd21',
				header : '인큐베이터 여부',
				tooltip: '인큐베이터 여부',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd22',
				header : '이유',
				tooltip: '이유',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
			        value = Ext.String.htmlEncode(value);
			        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
			        return value;
			},
			},{
				dataIndex : 'd23',
				header : '신체적문제 여부',
				tooltip: '신체적문제 여부',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd24',
				header : '이유',
				tooltip: '이유',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
			        value = Ext.String.htmlEncode(value);
			        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
			        return value;
			},
			},{
				dataIndex : 'd25',
				header : '모의 우울기분',
				tooltip: '모의 우울기분',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd26',
				header : '정도',
				tooltip: '정도',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd27',
				header : '출산 후 입원여부',
				tooltip: '출산 후 입원여부',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'd28',
				header : '이유',
				tooltip: '이유',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
			        value = Ext.String.htmlEncode(value);
			        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
			        return value;
			},
			}]
		}
		,{
			text: '육아관련',
			menuDisabled : true,
			columns : [{
				dataIndex : 'e1',
				header : 'ㄱ-1',
				tooltip: 'ㄱ-1',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e2',
				header : 'ㄱ-2',
				tooltip: 'ㄱ-2',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e3',
				header : 'ㄱ-3',
				tooltip: 'ㄱ-3',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e4',
				header : 'ㄱ-4',
				tooltip: 'ㄱ-4',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e5',
				header : 'ㄱ-5',
				tooltip: 'ㄱ-5',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e6',
				header : 'ㄱ-6',
				tooltip: 'ㄱ-6',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e7',
				header : 'ㄱ합계',
				tooltip: 'ㄱ합계',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e8',
				header : 'ㄴ-1',
				tooltip: 'ㄴ-1',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e9',
				header : 'ㄴ-2',
				tooltip: 'ㄴ-2',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e10',
				header : 'ㄴ-3',
				tooltip: 'ㄴ-3',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e11',
				header : 'ㄴ-4',
				tooltip: 'ㄴ-4',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e12',
				header : 'ㄴ합계',
				tooltip: 'ㄴ합계',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e13',
				header : 'ㄷ-1',
				tooltip: 'ㄷ-1',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e14',
				header : 'ㄷ-2',
				tooltip: 'ㄷ-2',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e15',
				header : 'ㄷ-3',
				tooltip: 'ㄷ-3',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e16',
				header : 'ㄷ합계',
				tooltip: 'ㄷ합계',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e17',
				header : 'ㄹ-1',
				tooltip: 'ㄹ-1',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e18',
				header : 'ㄹ-2',
				tooltip: 'ㄹ-2',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e19',
				header : 'ㄹ-3',
				tooltip: 'ㄹ-3',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e20',
				header : 'ㄹ합계',
				tooltip: 'ㄹ합계',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e21',
				header : 'ㅁ-1',
				tooltip: 'ㅁ-1',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e22',
				header : 'ㅁ-2',
				tooltip: 'ㅁ-2',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e23',
				header : 'ㅁ-3',
				tooltip: 'ㅁ-3',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e24',
				header : 'ㅁ-4',
				tooltip: 'ㅁ-4',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e25',
				header : 'ㅁ-5',
				tooltip: 'ㅁ-5',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e26',
				header : 'ㅁ합계',
				tooltip: 'ㅁ합계',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e27',
				header : 'ㅂ-1',
				tooltip: 'ㅂ-1',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e28',
				header : 'ㅂ-2',
				tooltip: 'ㅂ-2',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e29',
				header : 'ㅂ-3',
				tooltip: 'ㅂ-3',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e30',
				header : 'ㅂ-4',
				tooltip: 'ㅂ-4',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e31',
				header : 'ㅂ-5',
				tooltip: 'ㅂ-5',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e32',
				header : 'ㅂ합계',
				tooltip: 'ㅂ합계',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e33',
				header : 'ㅅ-1',
				tooltip: 'ㅅ-1',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e34',
				header : 'ㅅ-2',
				tooltip: 'ㅅ-2',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e35',
				header : 'ㅅ-3',
				tooltip: 'ㅅ-3',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e36',
				header : 'ㅅ-4',
				tooltip: 'ㅅ-4',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e37',
				header : 'ㅅ-5',
				tooltip: 'ㅅ-5',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'e38',
				header : 'ㅅ합계',
				tooltip: 'ㅅ합계',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			}]
		})
//	Ext.getCmp("surveyList-grid").reconfigure(columnPrdv1);
//	surveyStore.commitChanges();
}

function addPrdv3(){
	columnPrdv1.push({
			text: '발달력',
			menuDisabled : true,
			columns : [{
				dataIndex : 'f1',
				header : '손잡이',
				tooltip: '손잡이',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f2',
				header : '주양육자',
				tooltip: '주양육자',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f3',
				header : '이유',
				tooltip: '이유',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
			        value = Ext.String.htmlEncode(value);
			        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
			        return value;
			},
			},{
				dataIndex : 'f4',
				header : '양육자변화',
				tooltip: '양육자변화',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f5',
				header : '횟수',
				tooltip: '횟수',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
			        value = Ext.String.htmlEncode(value);
			        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
			        return value;
			},
			},{
				dataIndex : 'f6',
				header : '이유',
				tooltip: '이유',
				renderer : Ext.util.Format.tooltip,
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
			        value = Ext.String.htmlEncode(value);
			        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
			        return value;
			},
			},{
				dataIndex : 'f7',
				header : '유년기 사는 장소',
				tooltip: '유년기 사는 장소',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f8',
				header : '1',
				tooltip: '1',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f9',
				header : '2',
				tooltip: '2',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f10',
				header : '3',
				tooltip: '3',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f11',
				header : '4',
				tooltip: '4',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f12',
				header : '5',
				tooltip: '5',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f13',
				header : '6',
				tooltip: '6',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f14',
				header : '7',
				tooltip: '7',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f15',
				header : '8',
				tooltip: '8',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f16',
				header : '9',
				tooltip: '9',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f17',
				header : '10',
				tooltip: '10',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f18',
				header : '11',
				tooltip: '11',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f19',
				header : '12',
				tooltip: '12',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f20',
				header : '13',
				tooltip: '13',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f21',
				header : '14',
				tooltip: '14',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f22',
				header : '낮가림',
				tooltip: '낮가림',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f23',
				header : '목가누기 등',
				tooltip: '목가누기 등',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f24',
				header : '옹알이',
				tooltip: '옹알이',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f25',
				header : '문장 말하기',
				tooltip: '문장 말하기',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
			        value = Ext.String.htmlEncode(value);
			        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
			        return value;
			},
			},{
				dataIndex : 'f26',
				header : '대소변 가리기',
				tooltip: '대소변 가리기',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
			        value = Ext.String.htmlEncode(value);
			        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
			        return value;
			},
			},{
				dataIndex : 'f27',
				header : '야뇨증',
				tooltip: '야뇨증',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f28',
				header : '(야뇨증)나이',
				tooltip: '(야뇨증)나이',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f29',
				header : '분리불안',
				tooltip: '분리불안',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f30',
				header : '또래관계',
				tooltip: '또래관게',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f31',
				header : '(예)라면시기',
				tooltip: '(예)라면시기',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
			        value = Ext.String.htmlEncode(value);
			        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
			        return value;
			},
			},{
				dataIndex : 'f32',
				header : '학업성취',
				tooltip: '학업성취',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f33',
				header : '학교적응정도',
				tooltip: '학교적응정도',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f34',
				header : '상담받은적',
				tooltip: '상담받은적',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f35',
				header : '1',
				tooltip: '1',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f36',
				header : '2',
				tooltip: '2',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f37',
				header : '3',
				tooltip: '3',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f38',
				header : '4',
				tooltip: '4',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f39',
				header : '5',
				tooltip: '5',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f40',
				header : '6',
				tooltip: '6',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f41',
				header : '7',
				tooltip: '7',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f42',
				header : '8',
				tooltip: '8',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f43',
				header : '9',
				tooltip: '9',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f44',
				header : '10',
				tooltip: '10',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f45',
				header : '11',
				tooltip: '11',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f46',
				header : '12',
				tooltip: '12',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f47',
				header : '1',
				tooltip: '1',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f48',
				header : '2',
				tooltip: '2',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f49',
				header : '3',
				tooltip: '3',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f50',
				header : '4',
				tooltip: '4',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f51',
				header : '5',
				tooltip: '5',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f52',
				header : '6',
				tooltip: '6',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f53',
				header : '7',
				tooltip: '7',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f54',
				header : '8',
				tooltip: '8',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f55',
				header : '9',
				tooltip: '9',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f56',
				header : '10',
				tooltip: '10',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f57',
				header : '11',
				tooltip: '11',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			},{
				dataIndex : 'f58',
				header : '12',
				tooltip: '12',
				width: 80,
				align : 'center',
				menuDisabled : true,
				sortable: false
			}]
		})		
}

function addPrdv4(){
	columnPrdv1.push({
					text: '아이의 건강',
					menuDisabled : true,
					columns : [{
						dataIndex : 'g1',
						header : '입원, 수술여부',
						tooltip: '입원, 수술여부',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g2',
						header : '이유',
						tooltip: '이유',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g3',
						header : '시기',
						tooltip: '시기',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g4',
						header : '현재건강',
						tooltip: '현재건강',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g5',
						header : '외상여부',
						tooltip: '외상여부',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g6',
						header : '시기',
						tooltip: '시기',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g7',
						header : '이유',
						tooltip: '이유',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g8',
						header : '돌 이전 설사',
						tooltip: '돌 이전 설사',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g9',
						header : '시기',
						tooltip: '시기',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g10',
						header : '이유',
						tooltip: '이유',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g11',
						header : '돌 이전 고열 횟수',
						tooltip: '돌 이전 고열 횟수',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g12',
						header : '시기',
						tooltip: '시기',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g13',
						header : '돌 이전 항생제 치료',
						tooltip: '돌 이전 항생제 치료',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g14',
						header : '돌 이전 두드러기',
						tooltip: '돌 이전 두드러기',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g15',
						header : '시기',
						tooltip: '시기',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g16',
						header : '이유',
						tooltip: '이유',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g17',
						header : '돌 이전 전신마취',
						tooltip: '돌 이전 전신마취',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g18',
						header : '시기',
						tooltip: '시기',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g19',
						header : '이유',
						tooltip: '이유',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g20',
						header : '머리 다친적',
						tooltip: '머리 다친적',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g21',
						header : '시기',
						tooltip: '시기',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g22',
						header : '이유',
						tooltip: '이유',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g23',
						header : '뇌성마비',
						tooltip: '뇌성마비',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g24',
						header : '자폐증',
						tooltip: '자폐증',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g25',
						header : '언어장애',
						tooltip: '언어장애',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g26',
						header : '정신지체',
						tooltip: '정신지체',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g27',
						header : '학습장애',
						tooltip: '학습장애',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g28',
						header : 'ADHD',
						tooltip: 'ADHD',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g29',
						header : '불안증',
						tooltip: '불안증',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g30',
						header : '우울증',
						tooltip: '우울증',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g31',
						header : '천식',
						tooltip: '천식',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g32',
						header : '아토피',
						tooltip: '아토피',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g33',
						header : '알레르기 비염',
						tooltip: '알레르기 비염',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g34',
						header : '외상성 뇌손상',
						tooltip: '외상성 뇌손상',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g35',
						header : '기타 뇌신경질환',
						tooltip: '기타 뇌신경질환',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g36',
						header : '기타 신체질환',
						tooltip: '기타 신체질환',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g37',
						header : '나이',
						tooltip: '나이',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g38',
						header : '내용',
						tooltip: '내용',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g39',
						header : '나이(2)',
						tooltip: '나이(2)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g40',
						header : '내용(2)',
						tooltip: '내용(2)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g41',
						header : '나이(3)',
						tooltip: '나이(3)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g42',
						header : '내용(3)',
						tooltip: '내용(3)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g43',
						header : '나이(4)',
						tooltip: '나이(4)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g44',
						header : '내용(4)',
						tooltip: '내용(4)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g45',
						header : '나이(5)',
						tooltip: '나이(5)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g46',
						header : '내용(5)',
						tooltip: '내용(5)',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g47',
						header : '예방접종',
						tooltip: '예방접종',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g48',
						header : '정서행동문제로 상담소 방문',
						tooltip: '정서행동문제로 상담소 방문',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g49',
						header : '시기',
						tooltip: '시기',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g50',
						header : '이유',
						tooltip: '이유',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g51',
						header : 'motor틱',
						tooltip: 'motor틱',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g52',
						header : '시기',
						tooltip: '시기',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g53',
						header : '이유',
						tooltip: '이유',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g54',
						header : '음성틱',
						tooltip: '음성틱',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'g55',
						header : '시기',
						tooltip: '시기',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'g56',
						header : '이유',
						tooltip: '이유',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					}]
				},{
					text: '학습 및 사회성',
					menuDisabled : true,
					columns : [{
						dataIndex : 'h1',
						header : '놀이방/유치원 시작연령',
						tooltip: '놀이방/유치원 시작연령',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h2',
						header : '분리불안',
						tooltip: '분리불안',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h3',
						header : '또래사귐',
						tooltip: '또래사귐',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h4',
						header : '평가',
						tooltip: '평가',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'h5',
						header : '학습문제',
						tooltip: '학습문제',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h6',
						header : '발달지연',
						tooltip: '발달지연',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h7',
						header : '특수교육수업',
						tooltip: '특수교육수업',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h8',
						header : '언어치료',
						tooltip: '언어치료',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h9',
						header : '정서행동문제',
						tooltip: '정서행동문제',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h10',
						header : '결석일',
						tooltip: '결석일',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h11',
						header : '(평일)컴퓨터게임시간',
						tooltip: '(평일)컴퓨터게임시간',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h12',
						header : '(평일)집밖에서노는시간',
						tooltip: '(평일)집밖에서노는시간',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h13',
						header : '(주말)밖에서노는시간',
						tooltip: '(주말)밖에서노는시간',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h14',
						header : '식사속도',
						tooltip: '식사속도',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h15',
						header : '움직이는 놀이 횟수',
						tooltip: '움직이는 놀이 횟수',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'h16',
						header : '매회 놀이시간',
						tooltip: '매회 놀이시간',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					}]
				},{
					text: '사춘기여부',
					menuDisabled : true,
					columns : [{
						dataIndex : 'i1',
						header : '사춘기여부',
						tooltip: '사춘기여부',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'i2',
						header : '음모여부',
						tooltip: '음모여부',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'i3',
						header : '(남아)변성',
						tooltip: '(남아)변성',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},
					{
						dataIndex : 'i4',
						header : '(남아)수염',
						tooltip: '(남아)수염',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},
					{
						dataIndex : 'i5',
						header : '(여아)젖몽우리',
						tooltip: '(여아)젖몽우리',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'i6',
						header : '시작나이',
						tooltip: '시작나이',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'i7',
						header : '(여아)초경',
						tooltip: '(여아)초경',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					}
					]
				})
}
// PRDV1 column END

// SRS1 column 설문지 검사 임상가평가(SRS)
var columnSrs1 =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'srsExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'SRS',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '약물종류',
						tooltip: '약물종류',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
						
					},{
						dataIndex : 'a2',
						header :'용량',
						tooltip: '용량',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'a3',
						header : '불면',
						tooltip: '불면',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '악몽',
						tooltip: '악몽',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '멍함',
						tooltip: '멍함',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '말수줌',
						tooltip: '말수줌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '관심저하',
						tooltip: '관심저하',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '식욕저하',
						tooltip: '식욕저하',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '짜증',
						tooltip: '짜증',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '복통',
						tooltip: '복통',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '두통',
						tooltip: '두통',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '졸림',
						tooltip: '졸림',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '슬픔',
						tooltip: '슬픔',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '울먹임',
						tooltip: '울먹임',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '불안함',
						tooltip: '불안함',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '손톱깨묾',
						tooltip: '손톱깨묾',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '들뜸',
						tooltip: '들뜸',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '현기증',
						tooltip: '현기증',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '틱',
						tooltip: '틱',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// SRS1 column END

// SRS2 column 설문지 검사 4주 간격 면담지(SRS)
var columnSrs2 =	[{ 	
						dataIndex : 'targetId',
						header : '연구번호',
						tooltip: '연구번호',
						width: 80,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
						renderer : function(value,metadata,record,rowIndex,colIndex,view ){
							metadata.tdCls = 'btn';
							return value;
						}
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip: '성별',
						width: 80,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'protocol',
						header : '프로토콜',
						tooltip: '프로토콜',
						width: 100,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'performNm',
						header : '차수',
						tooltip: '차수',
						width: 80,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'age',
						header : '나이',
						tooltip: '나이',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'srsExecDate',
						header : '실시일',
						tooltip: '실시일',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						text: 'SRS',
						menuDisabled : true,
						columns : [{
							dataIndex : 'a1',
							header : '약물종류',
							tooltip: '약물종류',
							width: 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							renderer: function(value, metaData, record, rowIdx, colIdx, store) {
						        value = Ext.String.htmlEncode(value);
						        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
						        return value;
						},
							
						},{
							dataIndex : 'a2',
							header :'용량',
							tooltip: '용량',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
							renderer: function(value, metaData, record, rowIdx, colIdx, store) {
						        value = Ext.String.htmlEncode(value);
						        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
						        return value;
						},
						},{
							dataIndex : 'a3',
							header : '불면',
							tooltip: '불면',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a4',
							header : '악몽',
							tooltip: '악몽',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a5',
							header : '멍함',
							tooltip: '멍함',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a6',
							header : '말수줌',
							tooltip: '말수줌',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a7',
							header : '관심저하',
							tooltip: '관심저하',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a8',
							header : '식욕저하',
							tooltip: '식욕저하',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a9',
							header : '짜증',
							tooltip: '짜증',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a10',
							header : '복통',
							tooltip: '복통',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a11',
							header : '두통',
							tooltip: '두통',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a12',
							header : '졸림',
							tooltip: '졸림',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a13',
							header : '슬픔',
							tooltip: '슬픔',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a14',
							header : '울먹임',
							tooltip: '울먹임',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a15',
							header : '불안함',
							tooltip: '불안함',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a16',
							header : '손톱깨묾',
							tooltip: '손톱깨묾',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a17',
							header : '들뜸',
							tooltip: '들뜸',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a18',
							header : '현기증',
							tooltip: '현기증',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a19',
							header : '틱',
							tooltip: '틱',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'totalScore',
							header : '총점',
							tooltip: '총점',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						}]
					}];

// SRS column END

// YGTSS1 column 설문지 검사 임상가평가(YGTSS)
var columnYgtss1 =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					flex : 5/100,
					align : 'center',
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					flex : 5/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					flex : 7/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					flex : 5/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					flex : 5/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'ygtssExecDate',
					header : '실시일',
					tooltip: '실시일',
					flex : 7/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'YGTSS',
					flex : 60/100,
					menuDisabled : true,
					columns : [{
						dataIndex : 'm1',
						header : '1 근육',
						tooltip: '1 근육',
						flex : 4/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'v1',
						header : '1 음성',
						tooltip: '1 음성',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'm2',
						header : '2 근육',
						tooltip: '2 근육',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'v2',
						header : '2 음성',
						tooltip: '2 음성',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'm3',
						header : '3 근육',
						tooltip: '3 근육',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'v3',
						header : '3 음성',
						tooltip: '3 음성',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'm4',
						header : '4 근육',
						tooltip: '4 근육',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'v4',
						header : '4 음성',
						tooltip: '4 음성',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'm5',
						header : '5 근육',
						tooltip: '5 근육',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'v5',
						header : '5 음성',
						tooltip: '5 음성',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'disabilityDegree',
						header : '장애도',
						tooltip: '장애도',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'mScore',
						header : '근육점수',
						tooltip: '근육점수',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'vScore',
						header : '음성점수',
						tooltip: '음성점수',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalTic',
						header : '전체틱',
						tooltip: '전체틱',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalYgtss',
						header : '전체<br/>YGTSS',
						tooltip: '전체 YGTSS',
						align : 'center',
						flex : 4/100,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// YGTSS1 column END

// YGTSS2 column 설문지 검사 4주 간격 면담지(YGTSS)
var columnYgtss2 =	[{ 	
						dataIndex : 'targetId',
						header : '연구번호',
						tooltip: '연구번호',
						flex : 5/100,
						align : 'center',
// locked : true,
						menuDisabled : true,
						sortable: false,
						renderer : function(value,metadata,record,rowIndex,colIndex,view ){
							metadata.tdCls = 'btn';
							return value;
						}
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip: '성별',
						flex : 5/100,
						align : 'center',
// locked : true,
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'protocol',
						header : '프로토콜',
						tooltip: '프로토콜',
						flex : 10/100,
						align : 'center',
// locked : true,
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'performNm',
						header : '차수',
						tooltip: '차수',
						flex : 5/100,
						align : 'center',
// locked : true,
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'age',
						header : '나이',
						tooltip: '나이',
						flex : 5/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'ygtssExecDate',
						header : '실시일',
						tooltip: '실시일',
						flex : 7/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
					text: 'YGTSS',
					menuDisabled : true,
					flex : 60/100,
					columns : [{
							dataIndex : 'm1',
							header : '1 근육',
							tooltip: '1 근육',
							flex : 4/100,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'v1',
							header : '1 음성',
							tooltip: '1 음성',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'm2',
							header : '2 근육',
							tooltip: '2 근육',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'v2',
							header : '2 음성',
							tooltip: '2 음성',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'm3',
							header : '3 근육',
							tooltip: '3 근육',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'v3',
							header : '3 음성',
							tooltip: '3 음성',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'm4',
							header : '4 근육',
							tooltip: '4 근육',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'v4',
							header : '4 음성',
							tooltip: '4 음성',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'm5',
							header : '5 근육',
							tooltip: '5 근육',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'v5',
							header : '5 음성',
							tooltip: '5 음성',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'disabilityDegree',
							header : '장애도',
							tooltip: '장애도',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'mScore',
							header : '근육점수',
							tooltip: '근육점수',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'vScore',
							header : '음성점수',
							tooltip: '음성점수',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'totalTic',
							header : '전체틱',
							tooltip: '전체틱',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'totalYgtss',
							header : '전체<br/>YGTSS',
							tooltip: '전체 YGTSS',
							align : 'center',
							flex : 4/100,
							menuDisabled : true,
							sortable: false,
						}]
					}];

// YGTSS column END

// CYBOCS2 column 설문지 4주 간격 면담지(YBOCS-부모) 4주간격면담지
var columnCyBocs2 =	[{ 	
						dataIndex : 'targetId',
						header : '연구번호',
						tooltip: '연구번호',
						flex : 5/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer : function(value,metadata,record,rowIndex,colIndex,view ){
							metadata.tdCls = 'btn';
							return value;
						}
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip: '성별',
						flex : 4/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'protocol',
						header : '프로토콜',
						tooltip: '프로토콜',
						flex : 7/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'performNm',
						header : '차수',
						tooltip: '차수',
						flex : 4/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'age',
						header : '나이',
						tooltip: '나이',
						flex : 4/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
// dataIndex : 'cybocsExecDate',
						dataIndex : 'ybocaExecDate',
						header : '실시일',
						tooltip: '실시일',
						flex : 7/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						text: 'YBOCS(4주간격면담지)',
						menuDisabled : true,
						flex : 65/100,
						columns : [{
								dataIndex : 'a1',
								header : '1',
								tooltip: '1',
								flex : 5/100,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							
						},{
							dataIndex : 'a2',
							header :'2',
							tooltip: '2',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a3',
							header : '3',
							tooltip: '3',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a4',
							header : '4',
							tooltip: '4',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a5',
							header : '5',
							tooltip: '5',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a6',
							header : '6',
							tooltip: '6',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a7',
							header : '7',
							tooltip: '7',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a8',
							header : '8',
							tooltip: '8',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a9',
							header : '9',
							tooltip: '9',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a10',
							header : '10',
							tooltip: '10',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'compulsion',
							header : '강박사고',
							tooltip: '강박사고',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'compulsiveBehavior',
							header : '강박행동',
							tooltip: '강박행동',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'totalScore',
							header : '총점',
							tooltip: '총점',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						}]
					}];

// CY-BOCS column END


// Y-BOCS column 설문지 (Y-BOCS) 부모 임상가평가
var columnYBocs =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					flex : 5/100,
					align : 'center',
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					flex : 7/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'ybocsExecDate',
					header : '실시일',
					tooltip: '실시일',
					flex : 7/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'YBOCS-부모(임상가평가)',
					menuDisabled : true,
					flex : 65/100,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						flex : 5/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'compulsion',
						header : '강박사고',
						tooltip: '강박사고',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'compulsiveBehavior',
						header : '강박행동',
						tooltip: '강박행동',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// Y-BOCS column END

// YBOCS-부모 column 설문지 (CYBO3) 부모 4주간격면담지
var columnCybo3 =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					flex : 5/100,
					align : 'center',
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					flex : 7/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'ybocsExecDate',
					header : '실시일',
					tooltip: '실시일',
					flex : 7/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'YBOCS-부모(4주간격면담지)',
					menuDisabled : true,
					flex : 65/100,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						flex : 5/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'compulsion',
						header : '강박사고',
						tooltip: '강박사고',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'compulsiveBehavior',
						header : '강박행동',
						tooltip: '강박행동',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						flex : 5/100,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// CYBO3 column END

// Y-BOCS column 설문지 (Y-BOCS) 임상가평가
var columnYBoca =	[{ 	
						dataIndex : 'targetId',
						header : '연구번호',
						tooltip: '연구번호',
						flex : 5/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer : function(value,metadata,record,rowIndex,colIndex,view ){
							metadata.tdCls = 'btn';
							return value;
						}
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip: '성별',
						flex : 4/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'protocol',
						header : '프로토콜',
						tooltip: '프로토콜',
						flex : 7/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'performNm',
						header : '차수',
						tooltip: '차수',
						flex : 4/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'age',
						header : '나이',
						tooltip: '나이',
						flex : 4/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
// dataIndex : 'cybocsExecDate',
						dataIndex : 'ybocaExecDate',
						header : '실시일',
						tooltip: '실시일',
						flex : 7/100,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						text: 'YBOCS(임상가평가)',
						menuDisabled : true,
						flex : 65/100,
						columns : [{
							dataIndex : 'a1',
							header : '1',
							tooltip: '1',
							flex : 5/100,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a2',
							header :'2',
							tooltip: '2',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a3',
							header : '3',
							tooltip: '3',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a4',
							header : '4',
							tooltip: '4',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a5',
							header : '5',
							tooltip: '5',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a6',
							header : '6',
							tooltip: '6',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a7',
							header : '7',
							tooltip: '7',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a8',
							header : '8',
							tooltip: '8',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a9',
							header : '9',
							tooltip: '9',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a10',
							header : '10',
							tooltip: '10',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'compulsion',
							header : '강박사고',
							tooltip: '강박사고',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'compulsiveBehavior',
							header : '강박행동',
							tooltip: '강박행동',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'totalScore',
							header : '총점',
							tooltip: '총점',
							align : 'center',
							flex : 5/100,
							menuDisabled : true,
							sortable: false,
						}]
					}];

// Y-BOCS column END

// ARS column 설문지 (ARS)
var columnArs =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'arsExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'ARS',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'carelessness',
						header : '부주의<br/>(주의력결핍)',
						tooltip: '부주의(주의력결핍)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'hyperactivity',
						header : '충동성<br/>(과잉행동 충동성)',
						tooltip: '충동성(과잉행동 충동성)',
						align : 'center',
						width: 120,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// ARS column END


// K-CBCL column 설문지 (K-CBCL)
var columnKCbcl =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'kcbclExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'CBCL',
					menuDisabled : true,
					columns : [{
						dataIndex : 'c1',
						header : '위축 T',
						tooltip: '위축 T',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'c2',
						header : '신체증상',
						tooltip: '신체증상',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'c3',
						header : '우울/불안',
						tooltip: '우울/불안',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'c4',
						header : '사회적미성숙',
						tooltip: '사회적미성숙',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'c5',
						header : '사고의문제',
						tooltip: '사고의문제',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'c6',
						header : '주의집중문제',
						tooltip: '주의집중문제',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'c7',
						header : '비행',
						tooltip: '비행',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'c8',
						header : '공격성',
						tooltip: '공격성',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'c9',
						header : '내재화',
						tooltip: '내재화',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'c10',
						header : '외현화',
						tooltip: '외현화',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'c11',
						header : '총',
						tooltip: '총',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'c12',
						header : '성문제',
						tooltip: '성문제',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'c13',
						header : '정서적불안정',
						tooltip: '정서적불안정',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: 'K-CBCL',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22',
						header : '22',
						tooltip: '22',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23',
						header : '23',
						tooltip: '23',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24',
						header : '24',
						tooltip: '24',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25',
						header : '25',
						tooltip: '25',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26',
						header : '26',
						tooltip: '26',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27',
						header : '27',
						tooltip: '27',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a28',
						header : '28',
						tooltip: '28',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29',
						header : '29',
						tooltip: '29',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a30',
						header : '30',
						tooltip: '30',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a31',
						header : '31',
						tooltip: '31',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a32',
						header : '32',
						tooltip: '32',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a33',
						header : '33',
						tooltip: '33',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a34',
						header : '34',
						tooltip: '34',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a35',
						header : '35',
						tooltip: '35',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a36',
						header : '36',
						tooltip: '36',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a37',
						header : '37',
						tooltip: '37',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a38',
						header : '38',
						tooltip: '38',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a39',
						header : '39',
						tooltip: '39',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a40',
						header : '40',
						tooltip: '40',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a41',
						header : '41',
						tooltip: '41',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a42',
						header : '42',
						tooltip: '42',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a43',
						header : '43',
						tooltip: '43',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a44',
						header : '44',
						tooltip: '44',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a45',
						header : '45',
						tooltip: '45',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a46',
						header : '46',
						tooltip: '46',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a47',
						header : '47',
						tooltip: '47',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a48',
						header : '48',
						tooltip: '48',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a49',
						header : '49',
						tooltip: '49',						
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a50',
						header : '50',
						tooltip: '50',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a51',
						header : '51',
						tooltip: '51',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a52',
						header : '52',
						tooltip: '52',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a53',
						header : '53',
						tooltip: '53',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a54',
						header : '54',
						tooltip: '54',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a55',
						header : '55',
						tooltip: '55',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a56a',
						header : '56a',
						tooltip: '56a',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a56b',
						header : '56b',
						tooltip: '56b',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a56c',
						header : '56c',
						tooltip: '56c',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a56d',
						header : '56d',
						tooltip: '56d',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a56e',
						header : '56e',
						tooltip: '56e',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a56f',
						header : '56f',
						tooltip: '56f',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a56g',
						header : '56g',
						tooltip: '56g',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a56h',
						header : '56h',
						tooltip: '56h',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a57',
						header : '57',
						tooltip: '57',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a58',
						header : '58',
						tooltip: '58',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a59',
						header : '59',
						tooltip: '59',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a60',
						header : '60',
						tooltip: '60',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a61',
						header : '61',
						tooltip: '61',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a62',
						header : '62',
						tooltip: '62',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a63',
						header : '63',
						tooltip: '63',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a64',
						header : '64',
						tooltip: '64',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a65',
						header : '65',
						tooltip: '65',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a66',
						header : '66',
						tooltip: '66',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a67',
						header : '67',
						tooltip: '67',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a68',
						header : '68',
						tooltip: '68',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a69',
						header : '69',
						tooltip: '69',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a70',
						header : '70',
						tooltip: '70',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a71',
						header : '71',
						tooltip: '71',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a72',
						header : '72',
						tooltip: '72',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a73',
						header : '73',
						tooltip: '73',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a74',
						header : '74',
						tooltip: '74',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a75',
						header : '75',
						tooltip: '75',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a76',
						header : '76',
						tooltip: '76',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a77',
						header : '77',
						tooltip: '77',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a78',
						header : '78',
						tooltip: '78',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a79',
						header : '79',
						tooltip: '79',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a80',
						header : '80',
						tooltip: '80',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a81',
						header : '81',
						tooltip: '81',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a82',
						header : '82',
						tooltip: '82',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a83',
						header : '83',
						tooltip: '83',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a84',
						header : '84',
						tooltip: '84',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a85',
						header : '85',
						tooltip: '85',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a86',
						header : '86',
						tooltip: '86',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a87',
						header : '87',
						tooltip: '87',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a88',
						header : '88',
						tooltip: '88',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a89',
						header : '89',
						tooltip: '89',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a90',
						header : '90',
						tooltip: '90',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a91',
						header : '91',
						tooltip: '91',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a92',
						header : '92',
						tooltip: '92',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a93',
						header : '93',
						tooltip: '93',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a94',
						header : '94',
						tooltip: '94',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a95',
						header : '95',
						tooltip: '95',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a96',
						header : '96',
						tooltip: '96',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a97',
						header : '97',
						tooltip: '97',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a98',
						header : '98',
						tooltip: '98',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a99',
						header : '99',
						tooltip: '99',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a100',
						header : '100',
						tooltip: '100',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a101',
						header : '101',
						tooltip: '101',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a102',
						header : '102',
						tooltip: '102',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a103',
						header : '103',
						tooltip: '103',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a104',
						header : '104',
						tooltip: '104',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a105',
						header : '105',
						tooltip: '105',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a106',
						header : '106',
						tooltip: '106',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a107',
						header : '107',
						tooltip: '107',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a108',
						header : '108',
						tooltip: '108',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a109',
						header : '109',
						tooltip: '109',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a110',
						header : '110',
						tooltip: '110',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a111',
						header : '111',
						tooltip: '111',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a112',
						header : '112',
						tooltip: '112',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a113',
						header : '113-1',
						tooltip: '113-1',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'a114',
						header : '113-2',
						tooltip: '113-2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a115',
						header : '113-3',
						tooltip: '113-3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// K-CBCL column END


// DBDS column 설문지 (DBDS)
var columnDbds =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'dbdsExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'DBDS',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22',
						header : '22',
						tooltip: '22',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23',
						header : '23',
						tooltip: '23',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24',
						header : '24',
						tooltip: '24',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25',
						header : '25',
						tooltip: '25',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26',
						header : '26',
						tooltip: '26',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27',
						header : '27',
						tooltip: '27',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a28',
						header : '28',
						tooltip: '28',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29',
						header : '29',
						tooltip: '29',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a30',
						header : '30',
						tooltip: '30',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a31',
						header : '31',
						tooltip: '31',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a32',
						header : '32',
						tooltip: '32',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a33',
						header : '33',
						tooltip: '33',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a34',
						header : '34',
						tooltip: '34',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a35',
						header : '35',
						tooltip: '35',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a36',
						header : '36',
						tooltip: '36',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a37',
						header : '37',
						tooltip: '37',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a38',
						header : '38',
						tooltip: '38',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a39',
						header : '39',
						tooltip: '39',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a40',
						header : '40',
						tooltip: '40',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a41',
						header : '41',
						tooltip: '41',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'adhd',
						header : 'ADHD',
						tooltip: 'ADHD',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'odd',
						header : 'ODD',
						tooltip: 'ODD',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'cd',
						header : 'CD',
						tooltip: 'CD',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'odd2',
						header : 'ODD<br/>(2점)',
						tooltip: 'ODD(2점)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'odd3',
						header : 'ODD<br/>(3점)',
						tooltip: 'ODD(3점)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// DBDScolumn END

// CMRS-P column 설문지 (CMRS-P)
var columnCmrsP =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'cmrspExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'CMRS-P',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// CMRS-Pcolumn END


// 트라우마 column 설문지 (트라우마)
var columnTrauma =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'traumaExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: '트라우마',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22',
						header : '22',
						tooltip: '22',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23',
						header : '23',
						tooltip: '23',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24',
						header : '24',
						tooltip: '24',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25',
						header : '25',
						tooltip: '25',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26',
						header : '26',
						tooltip: '26',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27',
						header : '27',
						tooltip: '27',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a28',
						header : '28<br/>가장 큰 영향준항목',
						tooltip: '28 가장 큰 영향준항목',
						align : 'center',
						width: 150,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29',
						header : '29<br/>공포/무력감',
						tooltip: '29 공포/무력감',
						align : 'center',
						width: 150,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a30',
						header : '30<br/>꿈을꾸는 느낌',
						tooltip: '30 꿈을꾸는 느낌',
						align : 'center',
						width: 150,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// DBDScolumn END


// CDI 아동용 column 설문지 (CDI 아동용)
var columnCdi =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'cdiChildExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'CDI (아동용)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22',
						header : '22',
						tooltip: '22',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23',
						header : '23',
						tooltip: '23',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24',
						header : '24',
						tooltip: '24',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25',
						header : '25',
						tooltip: '25',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26',
						header : '26',
						tooltip: '26',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27',
						header : '27',
						tooltip: '27',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// CDI 아동용 column



// IAT column 설문지 (IAT)
var columnIat =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'iatExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'IAT',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// IAT column


// K-척도 column 설문지 (K-척도)
var columnKScale =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'kcriterionExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'K-척도',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuㅋDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22',
						header : '22',
						tooltip: '22',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23',
						header : '23',
						tooltip: '23',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24',
						header : '24',
						tooltip: '24',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25',
						header : '25',
						tooltip: '25',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26',
						header : '26',
						tooltip: '26',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27',
						header : '27',
						tooltip: '27',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a28',
						header : '28',
						tooltip: '28',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29',
						header : '29',
						tooltip: '29',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a30',
						header : '30',
						tooltip: '30',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a31',
						header : '31',
						tooltip: '31',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a32',
						header : '32',
						tooltip: '32',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a33',
						header : '33',
						tooltip: '33',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a34',
						header : '34',
						tooltip: '34',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a35',
						header : '35',
						tooltip: '35',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a36',
						header : '36',
						tooltip: '36',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a37',
						header : '37',
						tooltip: '37',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a38',
						header : '38',
						tooltip: '38',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a39',
						header : '39',
						tooltip: '39',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a40',
						header : '40',
						tooltip: '40',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// K-척도 column END



// RCMAS column 설문지 (RCMAS)
var columnRcmas =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'rcmasExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'RCMAS',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header : '2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuㅋDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22',
						header : '22',
						tooltip: '22',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23',
						header : '23',
						tooltip: '23',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24',
						header : '24',
						tooltip: '24',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25',
						header : '25',
						tooltip: '25',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26',
						header : '26',
						tooltip: '26',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27',
						header : '27',
						tooltip: '27',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a28',
						header : '28',
						tooltip: '28',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29',
						header : '29',
						tooltip: '29',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a30',
						header : '30',
						tooltip: '30',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a31',
						header : '31',
						tooltip: '31',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a32',
						header : '32',
						tooltip: '32',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a33',
						header : '33',
						tooltip: '33',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a34',
						header : '34',
						tooltip: '34',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a35',
						header : '35',
						tooltip: '35',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a36',
						header : '36',
						tooltip: '36',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a37',
						header : '37',
						tooltip: '37',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// RCMAS column END

// STAI-T column 설문지 (STAI-T) 아동용
var columnStaiTC =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수 ',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'staitChildExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'STAI-T 아동용',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuㅋDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// STAI-T column END


// STAI-T column 설문지 (STAI-S) 아동용
var columnStaiSC =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'staisChildExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'STAI-S 아동용',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header : '2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuㅋDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// STAI-S column END

var columnStaiTY =	[{ 	
						dataIndex : 'targetId',
						header : '연구번호',
						tooltip: '연구번호',
						width: 80,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
						renderer : function(value,metadata,record,rowIndex,colIndex,view ){
							metadata.tdCls = 'btn';
							return value;
						}
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip: '성별',
						width: 80,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'protocol',
						header : '프로토콜',
						tooltip: '프로토콜',
						width: 100,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'performNm',
						header : '차수',
						tooltip: '차수',
						width: 80,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'age',
						header : '나이',
						tooltip: '나이',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'staitYouthExecDate',
						header : '실시일',
						tooltip: '실시일',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						text: 'STAI-T 청소년용',
						menuDisabled : true,
						columns : [{
							dataIndex : 'a1',
							header : '1',
							tooltip: '1',
							width: 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a1Rc',
							header : '1_역',
							tooltip: '1_역',
							width: 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a2',
							header :'2',
							tooltip: '2',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a3',
							header : '3',
							tooltip: '3',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a4',
							header : '4',
							tooltip: '4',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a5',
							header : '5',
							tooltip: '5',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a6',
							header : '6',
							tooltip: '6',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a6Rc',
							header : '6_역',
							tooltip: '6_역',
							width: 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a7',
							header : '7',
							tooltip: '7',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a7Rc',
							header : '7_역',
							tooltip: '7_역',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a8',
							header : '8',
							tooltip: '8',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a9',
							header : '9',
							tooltip: '9',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a10',
							header : '10',
							tooltip: '10',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a10Rc',
							header : '10_역',
							tooltip: '10_역',
							width: 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a11',
							header : '11',
							tooltip: '11',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a12',
							header : '12',
							tooltip: '12',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a13',
							header : '13',
							tooltip: '13',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a13Rc',
							header : '13_역',
							tooltip: '13_역',
							width: 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a14',
							header : '14',
							tooltip: '14',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a15',
							header : '15',
							tooltip: '15',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a16',
							header : '16',
							tooltip: '16',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a16Rc',
							header : '16_역',
							tooltip: '16_역',
							width: 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a17',
							header : '17',
							tooltip: '17',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a18',
							header : '18',
							tooltip: '18',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a19',
							header : '19',
							tooltip: '19',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'a19Rc',
							header : '19_역',
							tooltip: '19_역',
							width: 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'a20',
							header : '20',
							tooltip: '20',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'totalScore',
							header : '총점',
							tooltip: '총점',
							align : 'center',
							width: 80,
							menuDisabled : true,
							sortable: false,
						}]
					}];

// STAI-T 청소년용 column END


var columnStaiSY =	[{ 	
							dataIndex : 'targetId',
							header : '연구번호',
							tooltip: '연구번호',
							width: 80,
							align : 'center',
							locked : true,
							menuDisabled : true,
							sortable: false,
							renderer : function(value,metadata,record,rowIndex,colIndex,view ){
								metadata.tdCls = 'btn';
								return value;
							}
						},{
							dataIndex : 'sex',
							header : '성별',
							tooltip: '성별',
							width: 80,
							align : 'center',
							locked : true,
							menuDisabled : true,
							sortable: false
						},{
							dataIndex : 'protocol',
							header : '프로토콜',
							tooltip: '프로토콜',
							width: 100,
							align : 'center',
							locked : true,
							menuDisabled : true,
							sortable: false
						},{
							dataIndex : 'performNm',
							header : '차수',
							tooltip: '차수',
							width: 80,
							align : 'center',
							locked : true,
							menuDisabled : true,
							sortable: false
						},{
							dataIndex : 'age',
							header : '나이',
							tooltip: '나이',
							width: 80,
							align : 'center',
							menuDisabled : true,
							sortable: false
						},{
							dataIndex : 'staisYouthExecDate',
							header : '실시일',
							tooltip: '실시일',
							width: 80,
							align : 'center',
							menuDisabled : true,
							sortable: false
						},{
							text: 'STAI-S 청소년용',
							menuDisabled : true,
							columns : [{
								dataIndex : 'a1',
								header : '1',
								tooltip: '1',
								width: 80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a1Rc',
								header : '1_역',
								tooltip: '1_역',
								width: 80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a2',
								header :'2',
								tooltip: '2',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a2Rc',
								header : '2_역',
								tooltip: '2_역',
								width: 80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a3',
								header : '3',
								tooltip: '3',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a4',
								header : '4',
								tooltip: '4',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a5',
								header : '5',
								tooltip: '5',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a5Rc',
								header : '5_역',
								tooltip: '5_역',
								width: 80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a6',
								header : '6',
								tooltip: '6',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a7',
								header : '7',
								tooltip: '7',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a8',
								header : '8',
								tooltip: '8',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a8Rc',
								header : '8_역',
								tooltip: '8_역',
								width: 80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a9',
								header : '9',
								tooltip: '9',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a10',
								header : '10',
								tooltip: '10',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a10Rc',
								header : '10_역',
								tooltip: '10_역',
								width: 80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a11',
								header : '11',
								tooltip: '11',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a11Rc',
								header : '11_역',
								tooltip: '11_역',
								width: 80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a12',
								header : '12',
								tooltip: '12',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a13',
								header : '13',
								tooltip: '13',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a14',
								header : '14',
								tooltip: '14',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a15',
								header : '15',
								tooltip: '15',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a15Rc',
								header : '15_역',
								tooltip: '15_역',
								width: 80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a16',
								header : '16',
								tooltip: '16',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a16Rc',
								header : '16_역',
								tooltip: '16_역',
								width: 80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a17',
								header : '17',
								tooltip: '17',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a18',
								header : '18',
								tooltip: '18',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a19',
								header : '19',
								tooltip: '19',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a19Rc',
								header : '19_역',
								tooltip: '19_역',
								width: 80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'a20',
								header : '20',
								tooltip: '20',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'a20Rc',
								header : '20_역',
								tooltip: '20_역',
								width: 80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'totalScore',
								header : '총점',
								tooltip: '총점',
								align : 'center',
								width: 80,
								menuDisabled : true,
								sortable: false,
							}]
						}];

// STAI-S 청소년용 column END


// LOI-CV column 설문지 ( LOI-CV)
var columnLoiCv =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'loicvExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'LOI-CV',
					menuDisabled : true,
					columns : [{
						dataIndex : 'currentTime',
						header : '현재시간',
						tooltip: '현재시간',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					        value = Ext.String.htmlEncode(value);
					        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					        return value;
					},
					},{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false						
					},{
						dataIndex : 'a1Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a1Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a2Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a2Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a5Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a6Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a7Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a7Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22',
						header : '22',
						tooltip: '22',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23',
						header : '23',
						tooltip: '23',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24',
						header : '24',
						tooltip: '24',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25',
						header : '25',
						tooltip: '25',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26',
						header : '26',
						tooltip: '26',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27',
						header : '27',
						tooltip: '27',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a28',
						header : '28',
						tooltip: '28',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a28Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a28Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29',
						header : '29',
						tooltip: '29',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a30',
						header : '30',
						tooltip: '30',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a30Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a30Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a31',
						header : '31',
						tooltip: '31',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a31Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a31Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a32',
						header : '32',
						tooltip: '32',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a32Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a32Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a33',
						header : '33',
						tooltip: '33',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a33Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a33Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a34',
						header : '34',
						tooltip: '34',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a34Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a34Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a35',
						header : '35',
						tooltip: '35',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a35Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a35Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a36',
						header : '36',
						tooltip: '36',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a36Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a36Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a37',
						header : '37',
						tooltip: '37',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a37Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a37Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a38',
						header : '38',
						tooltip: '38',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a38Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a38Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a39',
						header : '39',
						tooltip: '39',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a39Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a39Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a40',
						header : '40',
						tooltip: '40',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a40Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a40Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a41',
						header : '41',
						tooltip: '41',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a41Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a41Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a42',
						header : '42',
						tooltip: '42',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a42Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a42Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a43',
						header : '43',
						tooltip: '43',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a43Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a43Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a44',
						header : '44',
						tooltip: '44',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a44Feeling',
						header :'느낌',
						tooltip: '느낌',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a44Encumbrance',
						header :'지장',
						tooltip: '지장',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalYnScore',
						header : '총점<br/>(예/아니오)',
						tooltip: '총점(예/아니오)',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalFeelingScore',
						header : '총점<br/>(느낌)',
						tooltip: '총점(느낌)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalEncumbranceScore',
						header : '총점<br/>(지장)',
						tooltip: '총점(지장)',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// LOI-CV column END

 

// K-Bis-11-R column 설문지 (K-Bis-11-R)
var columnKBis11 =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'kbis11rExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'K-Bis-11-R',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a1Rc',
						header : '1_역',
						tooltip: '1_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header : '2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a7Rc',
						header : '7_역',
						tooltip: '7_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8Rc',
						header : '8_역',
						tooltip: '8_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9Rc',
						header : '9_역',
						tooltip: '9_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10Rc',
						header : '10_역',
						tooltip: '10_역',
						width: 85,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12Rc',
						header : '12_역',
						tooltip: '12_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13Rc',
						header : '13_역',
						tooltip: '13_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15Rc',
						header : '15_역',
						tooltip: '15_역',
						width: 85,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20Rc',
						header : '20_역',
						tooltip: '20_역',
						width: 85,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22',
						header : '22',
						tooltip: '22',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23',
						header : '23',
						tooltip: '23',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24',
						header : '24',
						tooltip: '24',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25',
						header : '25',
						tooltip: '25',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26',
						header : '26',
						tooltip: '26',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27',
						header : '27',
						tooltip: '27',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a28',
						header : '28',
						tooltip: '28',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29',
						header : '29',
						tooltip: '29',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29Rc',
						header : '29_역',
						tooltip: '29_역',
						width: 85,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a30',
						header : '30',
						tooltip: '30',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a30Rc',
						header : '30_역',
						tooltip: '30_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					}]
				}];

// K-Bis-11-Rcolumn END



// BDI 부모용 column 설문지 (BDI 부모용)
var columnBdi =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'bdiParentsExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'BDI (부모용)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'weightControl',
						header : '체중조절',
						tooltip: '체중조절',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// BDI 부모용 column END


// STAI-T 부모용 column 설문지 (STAI-T 부모용)
var columnStaiTP =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'staitParentsExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'STAI-T 부모용',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a1Rc',
						header : '1_역',
						tooltip: '1_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6Rc',
						header : '6_역',
						tooltip: '6_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a7Rc',
						header : '7_역',
						tooltip: '7_역',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10Rc',
						header : '10_역',
						tooltip: '10_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13Rc',
						header : '13_역',
						tooltip: '13_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16Rc',
						header : '16_역',
						tooltip: '16_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19Rc',
						header : '19_역',
						tooltip: '19_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// STAI-T 부모용 column END


// STAI-S 부모용 column 설문지 (STAI-S 부모용)
var columnStaiSP =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'staisParentsExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'STAI-S 부모용',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a1Rc',
						header : '1_역',
						tooltip: '1_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a2Rc',
						header : '2_역',
						tooltip: '2_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a5Rc',
						header : '5_역',
						tooltip: '5_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8Rc',
						header : '8_역',
						tooltip: '8_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10Rc',
						header : '10_역',
						tooltip: '10_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11Rc',
						header : '11_역',
						tooltip: '11_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15Rc',
						header : '15_역',
						tooltip: '15_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16Rc',
						header : '16_역',
						tooltip: '16_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19Rc',
						header : '19_역',
						tooltip: '19_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20Rc',
						header : '20_역',
						tooltip: '20_역',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// STAI-S 부모용 column END

// MBRI column 설문지 (MBRI)
var columnMbri =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'mbriExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'MBRI',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22',
						header : '22',
						tooltip: '22',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23',
						header : '23',
						tooltip: '23',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24',
						header : '24',
						tooltip: '24',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25',
						header : '25',
						tooltip: '25',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26',
						header : '26',
						tooltip: '26',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27',
						header : '27',
						tooltip: '27',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a28',
						header : '28',
						tooltip: '28',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29',
						header : '29',
						tooltip: '29',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a30',
						header : '30',
						tooltip: '30',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a31',
						header : '31',
						tooltip: '31',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a32',
						header : '32',
						tooltip: '32',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a33',
						header : '33',
						tooltip: '33',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a34',
						header : '34',
						tooltip: '34',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a35',
						header : '35',
						tooltip: '35',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a36',
						header : '36',
						tooltip: '36',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a37',
						header : '37',
						tooltip: '37',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a38',
						header : '38',
						tooltip: '38',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a39',
						header : '39',
						tooltip: '39',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a40',
						header : '40',
						tooltip: '40',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a41',
						header : '41',
						tooltip: '41',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a42',
						header : '42',
						tooltip: '42',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a43',
						header : '43',
						tooltip: '43',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a44',
						header : '44',
						tooltip: '44',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a45',
						header : '45',
						tooltip: '45',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a46',
						header : '46',
						tooltip: '46',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a47',
						header : '47',
						tooltip: '47',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a48',
						header : '48',
						tooltip: '48',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'affectionateAttitude',
						header : '애정적<br/>태도',
						tooltip: '애정적 태도',						
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'denyAttitude',
						header : '거부적<br/>태도',
						tooltip: '거부적 태도',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'autonomousAttitude',
						header : '자율적<br/>태도',
						tooltip: '자율적 태도',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'controlledAttitude',
						header : '통제적<br/>태도',
						tooltip: '통제적 태도',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총합',
						tooltip: '총합',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// MBRI column END


// K-AADHDS column 설문지 (K-AADHDS)
var columnkAadhds =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'kaadhdsExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'K-AADHDS',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '2',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuㅋDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'carelessness',
						header : '부주의',
						tooltip: '부주의',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'hyperactivity',
						header : '과잉행동',
						tooltip: '과잉행동',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// K-AADHDS column END

	

// PSI column 설문지 (PSI)
var columnPsi =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip: '연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip: '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'kpsiExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'PSI',
					menuDisabled : true,
					columns : [{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a11',
						header : '11',
						tooltip: '11',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a12',
						header : '12',
						tooltip: '12',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a13',
						header : '13',
						tooltip: '13',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a14',
						header : '14',
						tooltip: '14',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a15',
						header : '15',
						tooltip: '15',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a16',
						header : '16',
						tooltip: '16',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a17',
						header : '17',
						tooltip: '17',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a18',
						header : '18',
						tooltip: '18',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a19',
						header : '19',
						tooltip: '19',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a20',
						header : '20',
						tooltip: '20',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a21',
						header : '21',
						tooltip: '21',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a22',
						header : '22',
						tooltip: '22',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a23',
						header : '23',
						tooltip: '23',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a24',
						header : '24',
						tooltip: '24',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a25',
						header : '25',
						tooltip: '25',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a26',
						header : '26',
						tooltip: '26',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a27',
						header : '27',
						tooltip: '27',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a28',
						header : '28',
						tooltip: '28',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a29',
						header : '29',
						tooltip: '29',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a30',
						header : '30',
						tooltip: '30',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a31',
						header : '31',
						tooltip: '31',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a32',
						header : '32',
						tooltip: '32',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a33',
						header : '33',
						tooltip: '33',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a34',
						header : '34',
						tooltip: '34',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a35',
						header : '35',
						tooltip: '35',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a36',
						header : '36',
						tooltip: '36',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a37',
						header : '37',
						tooltip: '37',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a38',
						header : '38',
						tooltip: '38',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a39',
						header : '39',
						tooltip: '39',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a40',
						header : '40',
						tooltip: '40',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a41',
						header : '41',
						tooltip: '41',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a42',
						header : '42',
						tooltip: '42',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a43',
						header : '43',
						tooltip: '43',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a44',
						header : '44',
						tooltip: '44',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a45',
						header : '45',
						tooltip: '45',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a46',
						header : '46',
						tooltip: '46',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a47',
						header : '47',
						tooltip: '47',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a48',
						header : '48',
						tooltip: '48',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a49',
						header : '49',
						tooltip: '49',						
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a50',
						header : '50',
						tooltip: '50',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a51',
						header : '51',
						tooltip: '51',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a52',
						header : '52',
						tooltip: '52',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a53',
						header : '53',
						tooltip: '53',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a54',
						header : '54',
						tooltip: '54',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a55',
						header : '55',
						tooltip: '55',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a56',
						header : '56',
						tooltip: '56',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a57',
						header : '57',
						tooltip: '57',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a58',
						header : '58',
						tooltip: '58',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a59',
						header : '59',
						tooltip: '59',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a60',
						header : '60',
						tooltip: '60',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a61',
						header : '61',
						tooltip: '61',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a62',
						header : '62',
						tooltip: '62',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a63',
						header : '63',
						tooltip: '63',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a64',
						header : '64',
						tooltip: '64',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a65',
						header : '65',
						tooltip: '65',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a66',
						header : '66',
						tooltip: '66',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a67',
						header : '67',
						tooltip: '67',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a68',
						header : '68',
						tooltip: '68',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a69',
						header : '69',
						tooltip: '69',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a70',
						header : '70',
						tooltip: '70',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a71',
						header : '71',
						tooltip: '71',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a72',
						header : '72',
						tooltip: '72',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a73',
						header : '73',
						tooltip: '73',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a74',
						header : '74',
						tooltip: '74',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a75',
						header : '75',
						tooltip: '75',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a76',
						header : '76',
						tooltip: '76',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a77',
						header : '77',
						tooltip: '77',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a78',
						header : '78',
						tooltip: '78',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a79',
						header : '79',
						tooltip: '79',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a80',
						header : '80',
						tooltip: '80',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a81',
						header : '81',
						tooltip: '81',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a82',
						header : '82',
						tooltip: '82',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a83',
						header : '83',
						tooltip: '83',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a84',
						header : '84',
						tooltip: '84',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a85',
						header : '85',
						tooltip: '85',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a86',
						header : '86',
						tooltip: '86',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a87',
						header : '87',
						tooltip: '87',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a88',
						header : '88',
						tooltip: '88',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a89',
						header : '89',
						tooltip: '89',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a90',
						header : '90',
						tooltip: '90',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a91',
						header : '91',
						tooltip: '91',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a92',
						header : '92',
						tooltip: '92',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a93',
						header : '93',
						tooltip: '93',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a94',
						header : '94',
						tooltip: '94',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a95',
						header : '95',
						tooltip: '95',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a96',
						header : '96',
						tooltip: '96',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a97',
						header : '97',
						tooltip: '97',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a98',
						header : '98',
						tooltip: '98',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a99',
						header : '99',
						tooltip: '99',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a100',
						header : '100',
						tooltip: '100',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a101',
						header : '101',
						tooltip: '101',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a102',
						header : '102',
						tooltip: '102',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a103',
						header : '103',
						tooltip: '103',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a104',
						header : '104',
						tooltip: '104',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a105',
						header : '105',
						tooltip: '105',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a106',
						header : '106',
						tooltip: '106',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a107',
						header : '107',
						tooltip: '107',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a108',
						header : '108',
						tooltip: '108',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a109',
						header : '109',
						tooltip: '109',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a110',
						header : '110',
						tooltip: '110',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a111',
						header : '111',
						tooltip: '111',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a112',
						header : '112',
						tooltip: '112',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a113',
						header : '<span style="color:red">113</span>',
						tooltip: '113',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a114',
						header : '114',
						tooltip: '114',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a115',
						header : '115',
						tooltip: '115',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a116',
						header : '116',
						tooltip: '116',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a117',
						header : '117',
						tooltip: '117',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a118',
						header : '118',
						tooltip: '118',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a119',
						header : '119',
						tooltip: '119',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a120',
						header : '120',
						tooltip: '120',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a121',
						header : '주의산만/과잉행동',
						tooltip: '주의산만/과잉행동',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a122',
						header : '적응',
						tooltip: '적응',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a123',
						header : '보상',
						tooltip: '보상',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a124',
						header : '요구',
						tooltip: '요구',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a125',
						header : '기분',
						tooltip: '기분',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a126',
						header : '수용',
						tooltip: '수용',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a127',
						header : '아동 영역',
						tooltip: '아동 영역',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a128',
						header : '유능감',
						tooltip: '유능감',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a129',
						header : '고립',
						tooltip: '고립',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a130',
						header : '애착',
						tooltip: '애착',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a131',
						header : '건강',
						tooltip: '건강',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a132',
						header : '역할제한',
						tooltip: '역할제한',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a133',
						header : '우울',
						tooltip: '우울',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a134',
						header : '배우자',
						tooltip: '배우자',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a135',
						header : '부모영역',
						tooltip: '부모영역',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a136',
						header : '총스트레스',
						tooltip: '총스트레스',
						align : 'center',
						width: 95,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a137',
						header : '일상스트레스',
						tooltip: '일상스트레스',
						align : 'center',
						width: 100,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// PSI column END

function moveTabPage(title){
	// 검색조건 초기화
	searchParams = {};
	$('form#searchForm').each(function(i, f) {
		$(f)[0].reset();
	});
	Ext.MessageBox.show({
	       msg: '메뉴 이동중..',
	       progressText: '잠시만 기다려주세요..',
	       width:300,
	       wait:true,
	       waitConfig: {interval:200},
	       icon:'ext-mb-download', 
	       animEl: 'buttonID'
	   });
	Ext.Ajax.request({
 		url : makeUrl('/medical/survey/selectSurveyPage.do'),
 		params : searchPageParams,
 	    method : 'POST',
 	    timeout : 100000000,
        success : function(response, opts) {
        	var obj = Ext.decode(response.responseText);
            if (obj.success) {
            	var pageNum = obj.pageNum;
            	var rNum = (obj.rNum-1);
            	gridChg(title,pageNum,rNum);
            	
            }
        }
 	});
	
}

function searchCheck(obj){
	var check = $.trim(obj);
	if(check == undefined || check == "" || check == "선택"){
		return false;
	}
	return true;
}

