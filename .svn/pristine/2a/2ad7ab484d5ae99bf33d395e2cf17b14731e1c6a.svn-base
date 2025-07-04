var pageSize =  parameter['pageSize'];
var clinicianListGrid;
var activePage = parameter['activePage'];
var sm = new Ext.selection.CheckboxModel({headerWidth:40});
var clinicianStore;
var performCntStore;
var clinicianTitle = "Total";
var chgColumn =[];
var searchParams={};
var searchPageParams={};
var pageParams ={};
var chgTabNm = pageLoad.getParameter('chgTabNm');
var chgTargetId = pageLoad.getParameter('targetId');
var chgPerformCnt = pageLoad.getParameter('performCnt');

var columnPrdv1 =[];

clinicianListGrid = function() {
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
					id : 'clinicianList-grid',
					region : 'center',
					autoExpandColumn : 'subject',
					store : clinicianStore,
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
			        	id: 'clinicianList-grid-page',
			            pageSize: pageSize,
			            store: clinicianStore,
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
							var tabName =['K-SADS-PL','SRS','CY-BOCS','YBOCS'];
							
							// 연구번호 클릭 시 데이터 통합 분석 상세로 이동
							if(clickedDataIndex == "targetId"){
								var targetId = clickedCellValue;
								var url = GLOBAL_CONTEXT_PATH + '/medical/dataIntegration/dataIntegrationDtlAo.view';
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
								searchPageParams.limit=clinicianStore.getPageSize();
								searchPageParams.docId = tabDocId
								moveTabPage(tabDocId.toUpperCase());
							}
						}
				
					}
				} ]
				
			});
	
	
}

Ext.onReady(function() {
	Ext.QuickTips.init();	
	
	clinicianStore =  Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : false,
		pageSize : pageSize,
		proxy : {
			type : 'ajax',
			async : false,
			timeout : 100000000,
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/clinician/selectClinicianList.do',
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
//			extraParams : { docId : 'ARS01'},
			url : GLOBAL_CONTEXT_PATH
			+ '/medical/clinician/selectPerformCntList.do',
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
	var clinicianMenuStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		proxy : {
			type : 'ajax',
			async : false,
			extraParams : { docClassDtl : 'DC004', disClassDtl : menuDisClassDtl},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/clinician/selectClinicianMenuList.do',
			reader : {
				type : 'json',
				root : 'result'
			}

		},
		listeners : {
			load : function() {
					for(var i=0; i<clinicianMenuStore.getTotalCount(); i++){
						var disclassdtl = clinicianMenuStore.data.items[i].data.disClassDtl;
						var docNm=clinicianMenuStore.data.items[i].data.docNm;
						var docId=clinicianMenuStore.data.items[i].data.docId;
// if(i==0) $("#menuDiv").append('<button class="menuBtn"
// onClick=gridChg(\'Total\');>Total</button>');
						if(disclassdtl == "DS005" && docId == "S1001") {
							$(".submenu").append('<button type="button" class="menuBtn" onClick=gridChg(\''+docNm+'\');>'+docNm+'</button>');
						}else{
						$(".submenu").append('<button type="button" class="menuBtn" onClick=gridChg(\''+docId+'\');>'+docNm+'</button>');
						}
					}
			}
		}
	});	
	new clinicianListGrid();
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
      	parent.leftMenuChg('AO08','ADHD03');
      	
  		
      	// 해당탭으로 이동
      	searchPageParams.targetId = chgTargetId;
      	searchPageParams.performCnt = chgPerformCnt;
  		searchPageParams.schKeyWord="schTargetId";
  		searchPageParams.rndId=loginRndId;
  		searchPageParams.limit=clinicianStore.getPageSize();
  		searchPageParams.disClassDtl = menuDisClassDtl;
  		searchPageParams.docId = chgTabNm;
  		moveTabPage(chgTabNm.toUpperCase());
  		
      }else{
    	  var clinicianParams = {
    				docId : 'Total',
    				disClassDtl : menuDisClassDtl
    		}
    		
    		clinicianStore.proxy.extraParams = clinicianParams;
    		clinicianStore.load();
    
    	 
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
	console.log("다운로드 입성")
    if(clinicianStore.getCount() == 0) {
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
    
    searchParams.docId = clinicianTitle;
    searchParams.targetIds = targetIds;
    console.log(targetIds+"targetIDS")
    searchParams.performCnts = performCnts;
    console.log(performCnts+"PERFROMCNT")
    searchParams.disClassDtl = menuDisClassDtl;
    document.location.href = makeUrl('/medical/clinician/clinicianExcelDownload.do', searchParams);
    
}

function excelUpload(){
	var excelDataUploadPanel = new ExcelDataUploadPanel();
	excelDataUploadPanel.show();
}

function uploadExcelDownload() {
	var fileClassDtl = 'FIL05';
	var params = {
			rndId : loginRndId,
			disClassDtl : menuDisClassDtl,
			fileClassDtl : fileClassDtl
	}
	
	location.href = GLOBAL_CONTEXT_PATH + '/downFile.view?dir=file.sample.dir&fileName=ClinicianUpload2.xlsx';
}


function selectDeleteClinician(){
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
				clinicianVO = {
						targetId : rec.get('targetId'),
						performCnt : rec.get('performCnt'),
						performCntNm : rec.get('performCntNm'),
						docId : clinicianTitle
				};
				list.push(clinicianVO);
				console.log(list);
			});
			Ext.Ajax.request({
			    url : makeUrl('/medical/clinician/deleteClinicianAnswer.do'),
			    headers : {
		            'Content-Type' : 'application/json'
		        },
		        method : 'post',
		        jsonData : {clinicianList : list},
		        timeout : 100000000,
		        success : function(response, opts) {
		            var obj = Ext.decode(response.responseText);
		            if (obj.success) {
		            		Ext.Msg.alert('알림', '임상가평가가 삭제되었습니다. ');
		            		Ext.Msg.show({
						    	title: '알림',
						    	msg: '삭제되었습니다..', 
						    	buttons: Ext.Msg.OK,
						    	fn: function(btn, text) {
						    		if (btn == 'ok') {
						    			clinicianStore.load();
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
			            	console.log(taskId +": taskid");
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
			            		var  url = GLOBAL_CONTEXT_PATH + '/medical/clinician/clinicianAsdExcelUpload.do';
			            		ufp.submit({
				                	url: url,
				                	params: {
	    								'taskId' : taskId,
	    								rndId: loginRndId,
				                		disClassDtl: menuDisClassDtl,
				                		fileClassDtl: 'FIL05'
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
	
	var checkSex = "", checkPro="", checkKind="";
	if($("input:checkbox[name=check_sex]:checked").length==1) checkSex =  $("input:checkbox[name=check_sex]:checked").val();
	$("input:checkbox[name=check_pro]:checked").each(function(){
		if(checkPro != "")checkPro += ",";
		var val = this.value;
		val = val.replace(/ /gi, ""); 
		checkPro += "'"+ val+ "'";
	});
	$("input:checkbox[name=check_Kind]:checked").each(function(){
		if(checkKind != "")checkKind += ",";
		var val = this.value;
		val = val.replace(/ /gi, ""); 
		checkKind += "'"+ val+ "'";
	})
	
	var cvCgis = document.getElementsByName("cvCgis")[0].checked;
	var cvCgii = document.getElementsByName("cvCgii")[0].checked;
	var cvCgas = document.getElementsByName("cvCgas")[0].checked;
	var exts1 = document.getElementsByName("exts1")[0].checked;
	var srs01 = document.getElementsByName("srs01")[0].checked;
	var cybo1 = document.getElementsByName("cybo1")[0].checked;
	var ybocs = document.getElementsByName("ybocs")[0].checked;


	searchParams = {
			rndId : loginRndId,
			targetId : document.getElementById("targetId").value,
			startAge : document.getElementById("startAge").value,
			endAge : document.getElementById("endAge").value,
			sex : checkSex,
			performCnt : document.getElementById("performCnt").value,
			cvCgis : cvCgis?'Y':'N',
			cvCgii : cvCgii?'Y':'N',
			cvCgas : cvCgas?'Y':'N',
			exts1 : exts1?'Y':'N',
			srs01 : srs01?'Y':'N',
			cybo1 : cybo1?'Y':'N',
			ybocs : ybocs?'Y':'N',
			disClassDtl : menuDisClassDtl
			}
	 	clinicianStore.proxy.extraPrams = searchParams;
	pageParams = {
			start : 0,
			limit : pageSize
			
		};
	gridChg(clinicianTitle);
}


function gridChg(title,pageNum,rNum){
	// 검색조건에 임상가평가, 4주간 평가 콤보 조건
	var performNm = 'V';
	//if(title == 'SRS02' || title == 'YGTS2' || title == 'CYBO2' || title == 'CYBO3') performNm = 'W';
	if( title == 'Total'){// 전체탭일 경우 추가검색조건 표시
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
	 console.log(title+"titledocid들어갈곳")
	Ext.Ajax.request({
 		url : GLOBAL_CONTEXT_PATH + '/medical/clinician/selectDocNmByDocId.do',
 	    method : 'POST',
 	    params :{
           docId: title,
           disClassDtl : menuDisClassDtl,
           docClassDtl : 'DC004'
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
	

	docClassDtl = 'DC004'
	console.log(menuDisClassDtl+": menuDisClassDtl")
	if(title == "K-SADS-PL"){
		Ext.MessageBox.show({
		       msg: '<p style="text-align:center"><br/>조회 중입니다..</p>',
		       progressText: '잠시만 기다려주세요..',
		       width:300,
		       wait:true,
		       waitConfig: {interval:200},
		   });
		clinicianTitle = "S1001";
		s1title = "K-SADS-PL"
		chgColumn = columnS1;
		searchParams.rndId = loginRndId;
		searchParams.docId = 'S1001';
		searchParams.docNm = 'K-SADS-PL';
		clinicianStore.proxy.url = GLOBAL_CONTEXT_PATH + '/medical/clinician/selectClinicianList.do';
		clinicianStore.proxy.extraParams = searchParams;
		
		if(pageNum != "" && pageNum != undefined){
			clinicianStore.currentPage = pageNum;
			clinicianStore.load(function(){
				
				sm.select(rNum,true);
				// 스크롤 이동
				var x= Ext.getCmp('clinicianList-grid').getView().ownerGrid.getX();
				Ext.getCmp('clinicianList-grid').getView().ownerGrid.scrollTo(x,rNum*26);
			//	Ext.MessageBox.hide();
			});
		}else{
			clinicianStore.load({
				params : pageParams
		
			});
		}
			setTimeout(function(){
				Ext.getCmp("clinicianList-grid").reconfigure(clinicianStore, chgColumn);
				 $('h3.tit').addClass('on').html(s1title);
				 $('.total_search').hide();
				Ext.MessageBox.hide();
			}, 1000);
			return false;



		
	}else if(title == "SRS01"){
		clinicianTitle = "SRS01";
		chgColumn = columnSrs1;
		searchParams.docId = 'SRS01';
		srs1Title = "SRS";
	     $('h3.tit').addClass('on').html(srs1Title);
	     $('.total_search').hide();
	}else if(title == "YBOCS"){
		clinicianTitle = "YBOCS";
		chgColumn = columnYBocs;
		searchParams.docId = 'YBOCS';
		ybocstitle = "YBOCS";
		 $('h3.tit').addClass('on').html(ybocstitle);
		 $('.total_search').hide();
	}else if(title == "Total"){ 
		clinicianTitle = "Total";
		chgColumn = columnTotal;
		searchParams.docId = 'Total';
		$('.total_search').show();
	}else if(title == "CYBO1"){ 
		clinicianTitle = "CYBO1";
		chgColumn = columnCybocs;
		searchParams.docId = 'CYBO1';
		Cybo1title = "CY-BOCS"
	 $('h3.tit').addClass('on').html(Cybo1title);
		 $('.total_search').hide();
	}

	searchParams.rndId = loginRndId;
	clinicianStore.proxy.url = GLOBAL_CONTEXT_PATH + '/medical/clinician/selectClinicianList.do';
	clinicianStore.proxy.extraParams = searchParams;
	
	if(pageNum != "" && pageNum != undefined){
		clinicianStore.currentPage = pageNum;
		clinicianStore.load(function(){
			
			sm.select(rNum,true);
			// 스크롤 이동
			var x= Ext.getCmp('clinicianList-grid').getView().ownerGrid.getX();
			Ext.getCmp('clinicianList-grid').getView().ownerGrid.scrollTo(x,rNum*26);
			Ext.MessageBox.hide();
		});
	}else{
		clinicianStore.load(function(){
			params : pageParams
		});
	}
	
	Ext.suspendLayouts();
	clinicianStore.suspendEvents();
	
	Ext.getCmp("clinicianList-grid").reconfigure(clinicianStore, chgColumn);
	Ext.resumeLayouts(true);
	clinicianStore.resumeEvents();
}
// Grid column

// Total column 설문지(전체)
var columnTotal =	[
	{
		dataIndex : 'disClassDtl',
		header : '질병군',
		tooltip : '질병군',
		width : 130,
		align : 'center',
		locked : true,
		sortable : false,
		menuDisabled : true
	},{ 	
	text : '연구번호',
	tooltip : '연구번호',
	locked : true,
	menuDisabled : true,
	sortable : false,
	columns : [{
		dataIndex : 'targetId',
		header : '뇌원천',
		tooltip: '뇌원천',
		width: 130,
		align : 'center',
		locked : true,
		menuDisabled : true,
		sortable: false,
		renderer : function(value,metadata,record,rowIndex,colIndex,view ){
			metadata.tdCls = 'btn';
			return value;
		}
	},{
		dataIndex : 'targetDisId',
		header : '뇌질환',
		tooltip: '뇌질환',
		width: 130,
		align : 'center',
		locked : true,
		menuDisabled : true,
		sortable: false,
		renderer : function(value,metadata,record,rowIndex,colIndex,view ){
			metadata.tdCls = 'btn';
			return value;	
		}
		}]
},{
	dataIndex : 'sex',
	header : '성별',
	tooltip: '성별',
	width: 120,
	locked : true,
	align : 'center',
	menuDisabled : true,
	sortable: false
},{
	dataIndex : 'performNm',
	header : '차수',
	tooltip: '차수',
	width: 120,
	locked : true,
	align : 'center',
	menuDisabled : true,
	sortable: false
},{
	dataIndex : 'age',
	header : '나이',
	tooltip: '나이',
	width: 120,
	locked : true,
	align : 'center',
	menuDisabled : true,
	sortable: false
},{
	dataIndex : 'execDate',
	header : '실시일',
	tooltip: '실시일',
	width: 120,
	locked : true,
	align : 'center',
	menuDisabled : true,
	sortable: false
},{
		dataIndex : 'cvCgis',
		header : 'CGI-S',
		tooltip: 'CGI-S',
		width: 120,
		locked : false,
		align : 'center',
		menuDisabled : true,
		sortable: false,
		
	},{
		dataIndex : 'cvCgii',
		header :'CGI-I',
		tooltip: 'CGI-I',
		align : 'center',
		width: 120,
		menuDisabled : true,
		sortable: false,
	},{
		dataIndex : 'cvCgas',
		header : 'C-GAS',
		tooltip: 'C-GAS',
		align : 'center',
		width: 120,
		menuDisabled : true,
		sortable: false,
	},{
		dataIndex : 'exts1',
		header : 'K-SADS-PL',
		tooltip: 'K-SADS-PL',
		align : 'center',
		width: 120,
		menuDisabled : true,
		sortable: false,
		renderer : function(value, metaData, record, rowIndex){			    	
			var cursorChk = value;
			if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
	        return cursorChk;
	    }
		
	},{
		dataIndex : 'srs01',
		header : 'SRS',
		tooltip: 'SRS',
		align : 'center',
		width: 120,
		menuDisabled : true,
		sortable: false,
		renderer : function(value, metaData, record, rowIndex){			    	
			var cursorChk = value;
			if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
	        return cursorChk;
	    }
	},{
		dataIndex : 'cybo1',
		header : 'CY-BOCS',
		tooltip: 'CY-BOCS',
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
		header : 'YBOCS',
		tooltip: 'YBOCS',
		align : 'center',
		width: 120,
		menuDisabled : true,
		sortable: false,
		renderer : function(value, metaData, record, rowIndex){			    	
			var cursorChk = value;
			if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
	        return cursorChk;
	    }
	}];


// Total column END


// SRS1 column 설문지 검사 임상가평가(SRS)
var columnSrs1 =	[{
					dataIndex : 'disClassDtl',
					header : '질병군',
					tooltip : '질병군',
					width : 80,
					align : 'center',
					locked : true,
					sortable : false,
					menuDisabled : true
				},{
					text : '연구번호',
					tooltip : '연구번호',
					locked : true,
					menuDisabled : true,
					sortable : false,
					columns : [{
					dataIndex : 'targetId',
					header : '뇌원천',
					tooltip: '뇌원천',
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
					dataIndex : 'targetDisId',
					header : '뇌질환',
					tooltip: '뇌질환',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				}]
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
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'srs01ExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					text: 'SRS',
					menuDisabled : true,
					locked : false,
					columns : [{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 80,
						menuDisabled : true,
						sortable: false,
					},{
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
					}},{
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
					}},{
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
					}]
				}];

// SRS1 column END

// Y-BOCS column 설문지 (Y-BOCS) 부모 임상가평가
var columnYBocs =	[{
					dataIndex : 'disClassDtl',
					header : '질병군',
					tooltip : '질병군',
					width : 80,
					align : 'center',
					locked : true,
					sortable : false,
					menuDisabled : true
					},{ 	
					dataIndex : 'targetId',
					header : '뇌원천',
					tooltip: '뇌원천',
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
					dataIndex : 'targetDisId',
					header : '뇌질환',
					tooltip: '뇌질환',
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
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					width: 80,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'ybocsExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 100,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'YBOCS-부모(임상가평가)',
					menuDisabled : true,
					locked: false,
//					flex : 65/100,
					columns : [{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 120,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'compulsion',
						header : '강박사고 총점',
						tooltip: '강박사고 총점',
						align : 'center',
						width: 120,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a10',
						header : '10',
						tooltip: '10',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'compulsiveBehavior',
						header : '강박행동 총점',
						tooltip: '강박행동 총점',
						align : 'center',
						width: 120,
						menuDisabled : true,
						sortable: false,
					}]
				}];

// Y-BOCS column END



//CY-BOCS column 설문지 임상가평가
var columnCybocs =	[{
						dataIndex : 'disClassDtl',
						header : '질병군',
						tooltip : '질병군',
						width : 80,
						align : 'center',
						locked : true,
						sortable : false,
						menuDisabled : true
				   },{ 	
						text : '연구번호',
						tooltip : '연구번호',
						locked : true,
						menuDisabled : true,
						sortable : false,
						columns : [{ 	
					dataIndex : 'targetId',
					header : '뇌원천<br/>연구번호',
					tooltip: '뇌원천<br/>연구번호',
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
					dataIndex : 'targetDisId',
					header : '뇌질환<br/>연구번호',
					tooltip: '뇌질환<br/>연구번호',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}	
					}]
				
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip: '성별',
					width: 80,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performNm',
					header : '차수',
					tooltip: '차수',
					locked : true,
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip: '나이',
					width: 80,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'cybocsExecDate',
					header : '실시일',
					tooltip: '실시일',
					width: 100,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: '임상가 평가 (CY-BOCS)',
					menuDisabled : true,
					locked : false,
					//flex : 65/100,
					columns : [{
						dataIndex : 'totalScore',
						header : '총점',
						tooltip: '총점',
						align : 'center',
						width: 120,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a1',
						header : '1',
						tooltip: '1',
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a2',
						header :'2',
						tooltip: '2',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3',
						header : '3',
						tooltip: '3',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a4',
						header : '4',
						tooltip: '4',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a5',
						header : '5',
						tooltip: '5',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'compulsion',
						header : '강박사고 총점',
						tooltip: '강박사고 총점',
						align : 'center',
						width: 120,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a6',
						header : '6',
						tooltip: '6',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a7',
						header : '7',
						tooltip: '7',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a8',
						header : '8',
						tooltip: '8',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a9',
						header : '9',
						tooltip: '9',
						align : 'center',
						width: 90,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'compulsiveBehavior',
						header : '강박행동 총점',
						tooltip: '강박행동 총점',
						align : 'center',
						width: 120,
						menuDisabled : true,
						sortable: false,
					}]
				}];

//CY-BOCS column END

//S1 column
var columnS1 =	[
	{
		dataIndex : 'disClassDtl',
		header : '질병군',
		tooltip : '질병군',
		width : 100,
		align : 'center',
		locked : true,
		sortable : false,
		menuDisabled : true
	},{ 	
		text : '연구번호',
		tooltip : '연구번호',
		locked : true,
		menuDisabled : true,
		sortable : false,
		columns :[{ 	
					dataIndex : 'targetId',
					header : '뇌원천',
					tooltip : '뇌원천',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{ 	
					dataIndex : 'targetDisId',
					header : '뇌질환 ',
					tooltip : '뇌질환',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
			  }]
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip : '성별',
					width: 80,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performCntNm',
					header : '차수',
					tooltip : '차수',
					width: 80,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip : '나이',
					width: 80,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 's1ExecDate',
					header : 'K-SADS<br />실시일',
					tooltip : 'K-SADS<br />실시일',
					width: 80,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'enrollAge',
					header : '나이<br/>(Enroll 기준)',
					tooltip : '나이<br/>(Enroll 기준)',
					width: 80,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
				    text: 'K-SADS-PL',
				    tooltip: 'K-SADS-PL',
				    locked : false,
					sortable: false	,
					menuDisabled : true,
					columns : [{
						text: '선별-우울',
						tooltip: '선별-우울',
						sortable: false	,
						menuDisabled : true,
						columns : [{
							dataIndex : 'ksadsBlues',
							header : '우울한기분',
							tooltip : '우울한기분',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'ksadsAnger',
							header : '과민성 및 <br />분노',
							tooltip : '과민성 및 <br />분노',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'ksadsLossm',
							header : '동기저하',
							tooltip : '동기저하',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'ksadsDeath',
							header : '죽음에 대한<br />사고',
							tooltip : '죽음에 대한<br />사고',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'ksadsSuicide',
							header : '자살사고',
							tooltip : '자살사고',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'ksadsSuiSeverity',
							header : '자살행위-<br />심각도',
							tooltip : '자살행위-<br />심각도',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'ksadsSuiCriticality',
							header : '자살행위-<br />치명도',
							tooltip : '자살행위-<br />치명도',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'ksadsSelfharm',
							header : '자해',
							tooltip : '자해',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
				},{
					text: '선별-조증',
					tooltip: '선별-조증',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'ksadsUplift',
						header : '고양감',
						tooltip : '고양감',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'ksadsDecSleep',
						header : '수면욕구<br />감소',
						tooltip : '수면욕구<br />감소',
						width :80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'ksadsGoalActivity',
						header : '목표지향활동',
						tooltip : '목표지향활동',
						width :80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'ksadsGallop',
						header : '질주사고',
						tooltip : '질주사고',
						width :80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
			},{
				text: '선별-정신증',
				tooltip: '선별-정신증',
				sortable: false	,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsHallucination',
					header : '환각',
					tooltip : '환각',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false,
					
				},{
					dataIndex : 'ksadsDelusion',
					header : '망상',
					tooltip : '망상',
					width :80,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				}]
			},{
				text: '선별-공황장애',
				tooltip: '선별-공황장애',
				sortable: false	,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsPanic',
					header : '공황발작',
					tooltip : '공황발작',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false,
					
					}]
			},{
				text: '선별-분리불안장애',
				tooltip: '선별-분리불안장애',
				sortable: false	,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsSeparationFear',
					header : '분리사건<br/>두려움',
					tooltip : '분리사건<br/>두려움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsAttachFear',
					header : '애착대상<br/>두려움',
					tooltip : '애착대상<br/>두려움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsRejectSchool',
					header : '학교거부',
					tooltip : '학교거부',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsSleepFear',
					header : '혼자자기<br/>두려움',
					tooltip : '혼자자기<br/>두려움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsAloneFear',
					header : '집에혼자<br/>두려움',
					tooltip : '집에혼자<br/>두려움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				text: '선별-회피성장애',
				tooltip: '선별-회피성장애',
				sortable: false	,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsAtrophy',
					header : '위축',
					tooltip : '위축',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsSituationFear',
					header : '사회적상황<br/>두려움',
					tooltip : '사회적상황<br/>두려움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				text: '선별-광장공포',
				tooltip: '선별-광장공포',
				sortable: false	,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsPain',
					header : '고통',
					tooltip : '고통',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsAvoid',
					header : '회피',
					tooltip : '회피',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				text: '선별-과불안',
				tooltip: '선별-과불안',
				sortable: false	,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsFutureWorry',
					header : '미래에 대한<br />걱정',
					tooltip : '미래에 대한<br />걱정',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsBodyComplain',
					header : '신체 불평',
					tooltip : '신체 불평',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{				 
					dataIndex : 'ksadsSelfConsious',
					header : '현저한<br />자의식',
					tooltip : '현저한<br />자의식',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsTension',
					header : '현저한긴장감',
					tooltip : '현저한긴장감',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				text: '선별-강박증',
				tooltip: '선별-강박증',
				sortable: false	,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsComplusiveAct',
					header : '강박행동',
					tooltip : '강박행동',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsComplusiveThink',
					header : '강박사고',
					tooltip : '강박사고',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				text: '선별-유뇨증, 유분증',
				tooltip: '선별-유뇨증, 유분증',
				sortable: false	,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsPeeNight',
					header : '소변 저녁',
					tooltip : '소변 저녁',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsPeeDay',
					header : '소변 낮',
					tooltip : '소변 낮',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsPeeTotal',
					header : '소변 합계',
					tooltip : '소변 합계',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsShitNight',
					header : '대변 저녁',
					tooltip : '대변 저녁',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsShitDay',
					header : '대변 낮',
					tooltip : '대변 낮',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsShitTotal',
					header : '대변 합계',
					tooltip : '대변 합계',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				dataIndex : 'ksadsFatFear',
				header : '살찌는거 <br />두려움',
				tooltip : '살찌는거 <br />두려움',
				width : 80,
				//width : 180,
				align : 'center',
				menuDisabled : true,
				sortable: false					
			},{
				dataIndex : 'ksadsLowWeight',
				header : '저체중',
				tooltip : '저체중',
				width : 80,
				//width : 180,
				align : 'center',
				menuDisabled : true,
				sortable: false					
			},{
				dataIndex : 'ksadsWeightLoss',
				header : '체중감량',
				tooltip : '체중감량',
				width : 80,
				//width : 180,
				align : 'center',
				menuDisabled : true,
				sortable: false					
			},{
				dataIndex : 'ksadsVoracity',
				header : '폭식',
				tooltip : '폭식',
				width : 80,
				//width : 180,
				align : 'center',
				menuDisabled : true,
				sortable: false					
			},{
				text: '선별-ADHD',
				tooltip: '선별-ADHD',
				sortable: false	,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsAdhdCf',
					header : '지속어려움',
					tooltip : '지속어려움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsAdhdEd',
					header : '쉽게 산만',
					tooltip : '쉽게 산만',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsAdhdSf',
					header : '앉아있기<br />어려움',
					tooltip : '앉아있기<br />어려움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsAdhdImpulsivity',
					header : '충동성',
					tooltip : '충동성',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				text: '선별-ODD',
				tooltip: '선별-ODD',
				sortable: false,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsOddAngry',
					header : '욱하고 화내기',
					tooltip : '욱하고 화내기',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsOddAa',
					header : '어른과 말다툼',
					tooltip : '어른과 말다툼',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsOddNotrules',
					header : '규칙따르지않음',
					tooltip : '규칙따르지않음',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				text: '선별-CD',
				tooltip: '선별-CD',
				sortable: false,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsCdLie',
					header : '거짓말',
					tooltip : '거짓말',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsCdTruancy',
					header : '무단결석',
					tooltip : '무단결석',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsCdFight',
					header : '신체적싸움',
					tooltip : '신체적싸움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsCdTorment',
					header : '괴롭힘',
					tooltip : '괴롭힘',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'ksadsCdThievery',
					header : '도둑질',
					tooltip : '도둑질',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				text: '선별-틱',
				tooltip: '선별-틱',
				sortable: false,
				menuDisabled : true,
				columns : [{
					dataIndex : 'ksadsExerciseTic',
					header : '운동틱',
					tooltip : '운동틱',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{				 
					dataIndex : 'ksadsExerciseVoice',
					header : '음성틱',
					tooltip : '음성틱',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				dataIndex : 'gas',
				header : 'GAS',
				tooltip : 'GAS',
				width : 80,
				//width : 180,
				align : 'center',
				menuDisabled : true,
				sortable: false					
			},{
				text: 'ADHD 요건',
				tooltip: 'ADHD 요건',
				menuDisabled : true,
				columns : [{
					dataIndex : 'adhdrq1Mistake',
					header : '1.부주의한 실수',
					tooltip : '1.부주의한 실수',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq2Notlisten',
					header : '2.경청X',
					tooltip : '2.경청X',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq3FollowDiff',
					header : '3.지시따르기 어려움',
					tooltip : '3.지시따르기 어려움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq4ArrangeDiff',
					header : '4.과제 정리어려움',
					tooltip : '4.과제 정리어려움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq5AssignAvoid',
					header : '5.주의력요하는 과제회피',
					tooltip : '5.주의력요하는 과제회피',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq6LostItem',
					header : '6.물건을 분실',
					tooltip : '6.물건을 분실',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq7Forgetfulness',
					header : '7.일상활동 건망증',
					tooltip : '7.일상활동 건망증',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq8Unrest',
					header : '8.안절부절못함',
					tooltip : '8.안절부절못함',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq9Overrun',
					header : '9.지나치게 뛰거나 기어오름',
					tooltip : '9.지나치게 뛰거나 기어오름',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq10EndlessAct',
					header : '10.끊임없이 활동',
					tooltip : '10.끊임없이 활동',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq11SilentDiff',
					header : '11.조용하게 노느데 어려움',
					tooltip : '11.조용하게 노느데 어려움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq12SuddenAns',
					header : '12.불쑥 대답',
					tooltip : '12.불쑥 대답',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq13WaitDiff',
					header : '13.순서 기다리는데 어려움',
					tooltip : '13.순서 기다리는데 어려움',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq14Interrupt',
					header : '14.방해, 끼어들기',
					tooltip : '14.방해, 끼어들기',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq15Fickle',
					header : '15.활동 이것저것바꿈',
					tooltip : '15.활동 이것저것바꿈',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq16Chatter',
					header : '16.지나치게 많이 말함',
					tooltip : '16.지나치게 많이 말함',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'adhdrq17DangerAct',
					header : '17. 신체적으로 위험한 활동',
					tooltip : '17. 신체적으로 위험한 활동',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				sortable: false	,
				menuDisabled : true,
					columns : [{
					dataIndex : 'diagnosis',
					header : '진단',
					tooltip : '진단',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
			},{
				sortable: false	,
				menuDisabled : true,
					columns : [{
					dataIndex : 'diagnosisEtc',
					header : '기타진단',
					tooltip : '기타진단',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false
				}]
			}]
			
			},{
				text: '지능-K-Leiter',
				tooltip: '지능-K-Letier',
				sortable: false	,
				menuDisabled : true,
				columns : [{
					text: '환산점수의 합계',
					tooltip: '환산점수의 합계',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'exctAllIntell',
						header : '전체지능',
						tooltip : '전체지능',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exctShortIntell',
						header : '단축지능',
						tooltip : '단축지능',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exctFluidInfer',
						header : '유동적 추론',
						tooltip : '유동적 추론',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exctBasicVisual',
						header : '기본적<br/>시각화',
						tooltip : '기본적 시각화',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: '지능지수/복합지수',
					tooltip: '지능지수/복합지수',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'icidAllIntell',
						header : '전체지능',
						tooltip : '전체지능',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'icidShortIntell',
						header : '단축지능',
						tooltip : '단축지능',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'icidFluidInfer',
						header : '유동적 추론',
						tooltip : '유동적 추론',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'icidBasicVisual',
						header : '기본적<br/>시각화',
						tooltip : '기본적 시각화',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: '시각화 및 추론 원점수',
					tooltip: '시각화 및 추론 원점수',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'vifsForeBack',
						header : '전경배경',
						tooltip : '전경배경',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'vifsShapeComp',
						header : '형태완성',
						tooltip : '형태완성',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'vifsMatch',
						header : '짝짓기',
						tooltip : '짝짓기',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'vifsOrderInfer',
						header : '계기적<br/>순서추론',
						tooltip : '계기적 순서추론',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'vifsPattFind',
						header : '반복패턴찾기',
						tooltip : '반복패턴찾기',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'vifsDrawInfer',
						header : '그림맥락추론',
						tooltip : '그림맥락추론',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'vifsCategoriz',
						header : '범주화',
						tooltip : '범주화',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: '시각화 및 추론 환산점수',
					tooltip: '시각화 및 추론 원점수',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'viexcForeBack',
						header : '전경배경',
						tooltip : '전경배경',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'viexcShapeComp',
						header : '형태완성',
						tooltip : '형태완성',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'viexcMatch',
						header : '짝짓기',
						tooltip : '짝짓기',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'viexcOrderInfer',
						header : '계기적<br/>순서추론',
						tooltip : '계기적 순서추론',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'viexcPattFind',
						header : '반복패턴찾기',
						tooltip : '반복패턴찾기',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'viexcDrawInfer',
						header : '그림맥락추론',
						tooltip : '그림맥락추론',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'viexcCategoriz',
						header : '범주화',
						tooltip : '범주화',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: '주의환산합계',
					tooltip: '주의환산합계',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'cexcMemorySelect',
						header : '기억선별',
						tooltip : '기억선별',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'cexcRecogMemory',
						header : '재인기억',
						tooltip : '재인기억',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: '주의복합지수',
					tooltip: '주의복합지수',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'ccompMemorySelect',
						header : '기억선별',
						tooltip : '기억선별',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'ccompRecogMemory',
						header : '재인기억',
						tooltip : '재인기억',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: '원점수',
					tooltip: '원점수',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'scPairAsso',
						header : '쌍대연합',
						tooltip : '쌍대연합',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'scImmedRecog',
						header : '즉각재인',
						tooltip : '즉각재인',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'scImmedRemember',
						header : '바로 따라<br/>기억하기',
						tooltip : '바로 따라<br/>기억하기',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'scSustainAtt',
						header : '지속적주의력',
						tooltip : '지속적주의력',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'scDelayRecog',
						header : '지연재인',
						tooltip : '지연재인',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: '환산점수',
					tooltip: '환산점수',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'excPairAsso',
						header : '쌍대연합',
						tooltip : '쌍대연합',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'excImmedRecog',
						header : '즉각재인',
						tooltip : '즉각재인',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'excImmedRemember',
						header : '바로 따라<br/>기억하기',
						tooltip : '바로 따라<br/>기억하기',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'excSustainAtt',
						header : '지속적주의력',
						tooltip : '지속적주의력',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'excDelayRecog',
						header : '지연재인',
						tooltip : '지연재인',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: '부모용',
					tooltip: '부모용',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'pRsCompsc',
						header : '인지/사회<br/>복합점수',
						tooltip : '인지/사회<br/>복합점수',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'pEcCompsc',
						header : '정서/조절<br/>복합점수',
						tooltip : '정서/조절<br/>복합점수',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: '원점수',
					tooltip: '원점수',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'scAttention',
						header : '주의력',
						tooltip : '주의력',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'scActivLevel',
						header : '활동수준',
						tooltip : '활동수준',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'scImpuls',
						header : '충동성',
						tooltip : '충동성',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'scAdaptability',
						header : '적응능력',
						tooltip : '적응능력',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'scMoodConfid',
						header : '기분과자신감',
						tooltip : '기분과자신감',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'scFeelEmo',
						header : '활력감정',
						tooltip : '활력감정',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'scSociability',
						header : '사회성',
						tooltip : '사회성',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'scControl',
						header : '조절',
						tooltip : '조절',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: '환산점수',
					tooltip: '환산점수',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						dataIndex : 'excAttention',
						header : '주의력',
						tooltip : '주의력',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'excActivLevel',
						header : '활동수준',
						tooltip : '활동수준',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'excImpuls',
						header : '충동성',
						tooltip : '충동성',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'excAdaptability',
						header : '적응능력',
						tooltip : '적응능력',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'excMoodConfid',
						header : '기분과자신감',
						tooltip : '기분과자신감',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'excFeelEmo',
						header : '활력감정',
						tooltip : '활력감정',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'excSociability',
						header : '사회성',
						tooltip : '사회성',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'excControl',
						header : '조절',
						tooltip : '조절',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				}]
			},{
					text: 'KEDI-WISC',
					tooltip: 'KEDI-WISC',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						text: '원점수',
						tooltip: '원점수',
						sortable: false	,
						menuDisabled : true,
						columns : [{
							dataIndex : 'kediwaisVocaOs',
							header : '어휘',
							tooltip : '어휘',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'kediwaisArithOs',
							header : '산수',
							tooltip : '산수',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kediwaisOrderOs',
							header : '차례',
							tooltip : '차례',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kediwaisPieceOs',
							header : '토막',
							tooltip : '토막',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '환산점수',
						tooltip: '환산점수',
						sortable: false	,
						menuDisabled : true,
						columns : [{
							dataIndex : 'kediwaisVocaEs',
							header : '어휘',
							tooltip : '어휘',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'kediwaisArithEs',
							header : '산수',
							tooltip : '산수',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kediwaisOrderEs',
							header : '차례',
							tooltip : '차례',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kediwaisPieceEs',
							header : '토막',
							tooltip : '토막',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					}]
				},{
					text: 'K-WISC-IV',
					tooltip: 'K-WISC-IV',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						text: '원점수',
						tooltip: '원점수',
						sortable: false	,
						menuDisabled : true,
						columns : [{
							dataIndex : 'kwiscivCos',
							header : '공통성',
							tooltip : '공통성',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'kwiscivVos',
							header : '어휘',
							tooltip : '어휘',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivUos',
							header : '이해',
							tooltip : '이해',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivPos',
							header : '토막',
							tooltip : '토막',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivCpos',
							header : '공통그림',
							tooltip : '공통그림',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivMos',
							header : '행렬',
							tooltip : '행렬',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivNos',
							header : '숫자',
							tooltip : '숫자',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivScos',
							header : '순차연결',
							tooltip : '순차연결',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivSos',
							header : '기호',
							tooltip : '기호',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivStos',
							header : '동형',
							tooltip : '동형',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '환산점수',
						tooltip: '환산점수',
						sortable: false	,
						menuDisabled : true,
						columns : [{
							dataIndex : 'kwiscivCes',
							header : '공통성',
							tooltip : '공통성',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'kwiscivVes',
							header : '어휘',
							tooltip : '어휘',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivUes',
							header : '이해',
							tooltip : '이해',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivPes',
							header : '토막',
							tooltip : '토막',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivCpes',
							header : '공통그림',
							tooltip : '공통그림',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivMes',
							header : '행렬',
							tooltip : '행렬',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivNes',
							header : '숫자',
							tooltip : '숫자',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivSces',
							header : '순차연결',
							tooltip : '순차연결',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivSes',
							header : '기호',
							tooltip : '기호',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivStes',
							header : '동형',
							tooltip : '동형',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					}]
				},{
					text: 'K-WAIS-IV',
					tooltip: 'K-WAIS-IV',
					sortable: false	,
					menuDisabled : true,
					columns : [{
						text: '원점수',
						tooltip: '원점수',
						sortable: false	,
						menuDisabled : true,
						columns : [{
							dataIndex : 'kwiscivSios',
							header : '공통성<br />SI',
							tooltip : '공통성<br />SI',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'kwiscivVcos',
							header : '어휘<br />VC',
							tooltip : '어휘<br />VC',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivInos',
							header : '상식<br />IN',
							tooltip : '상식<br />IN',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivBdos',
							header : '토막짜기<br />BD',
							tooltip : '토막짜기<br />BD',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivMros',
							header : '행렬추론<br />MR',
							tooltip : '행렬추론<br />MR',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivVpos',
							header : '퍼즐<br />VP',
							tooltip : '퍼즐<br />VP',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivDsos',
							header : '숫자<br />DS',
							tooltip : '숫자<br />DS',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivAros',
							header : '산수<br />AR',
							tooltip : '산수<br />AR',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivSsos',
							header : '동형찾기<br />SS',
							tooltip : '동형찾기<br />SS',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivCdos',
							header : '기호쓰기<br />CD',
							tooltip : '기호쓰기<br />CD',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '환산점수',
						tooltip: '환산점수',
						sortable: false	,
						menuDisabled : true,
						columns : [{
								dataIndex : 'kwiscivSies',
								header : '공통성<br />SI',
								tooltip : '공통성<br />SI',
								width : 80,
								//width : 180,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'kwiscivVces',
								header : '어휘<br />VC',
								tooltip : '어휘<br />VC',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwiscivInes',
								header : '상식<br />IN',
								tooltip : '상식<br />IN',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwiscivBdes',
								header : '토막짜기<br />BD',
								tooltip : '토막짜기<br />BD',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwiscivMres',
								header : '행렬추론<br />MR',
								tooltip : '행렬추론<br />MR',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwiscivVpes',
								header : '퍼즐<br />VP',
								tooltip : '퍼즐<br />VP',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwiscivDses',
								header : '숫자<br />DS',
								tooltip : '숫자<br />DS',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwiscivAres',
								header : '산수<br />AR',
								tooltip : '산수<br />AR',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwiscivSses',
								header : '동형찾기<br />SS',
								tooltip : '동형찾기<br />SS',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwiscivCdes',
								header : '기호쓰기<br />CD',
								tooltip : '기호쓰기<br />CD',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							}]
						}]
				   }];

			
//S1 column END




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
 		url : makeUrl('/medical/clinician/selectClinicianPage.do'),
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

