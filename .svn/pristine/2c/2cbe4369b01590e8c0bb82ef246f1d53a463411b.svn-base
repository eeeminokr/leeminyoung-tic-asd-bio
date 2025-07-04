var pageSize = parameter['pageSize'];
var targetListGrid;
var activePage = parameter['activePage'];
var targetListStore;
var sm = new Ext.selection.CheckboxModel({
	headerWidth : 30
});
var searchParams = {};
var searchPageParams = {};
var chgTabNm = pageLoad.getParameter('chgTabNm');
var chgTargetId = pageLoad.getParameter('targetId');
var chgPerformCnt = pageLoad.getParameter('performCnt');
var statusStore;


targetListGrid = function() {

 Ext.create("Ext.panel.Panel", {
		// 'resizable-panel',
		height : '760px',
		region : 'center',
		layout : 'border',
		renderTo : 'ContentsDiv',
		border : false,
		items : [ {
			xtype : 'grid',
			id : 'targetList-grid',
			region : 'center',
			autoExpandColumn : 'subject',
			enableLocking: true,
			store : targetListStore,
			rowNumberer : true,
			trackMouseOver : true,
			autoScroll : true,
			columnLines : true,
			stripeRows : true,
			loadMask : true,
			border : true,
			singleSelect : true,
			plugins:  [Ext.create('Ext.grid.plugin.CellEditing',{
							listeners: {'beforeedit': beforeedit}
					})],
			selModel : sm,
			viewConfig: {
	        	enableTextSelection: true,
	        	markDirty: false,
	        },
			columns : [ {
				dataIndex : 'targetId',
				header : '연구번호',
				tooltip: '연구번호',
				width : 80,
				align : 'center',
				sortable : false,
				locked : true,
				menuDisabled : true,
				renderer : function(value,metadata,record,rowIndex,colIndex,view ){
					metadata.tdCls = 'btn';
					return value;
				}
			}, {
				dataIndex : 'disClassDtl',
				header : '질병군',
				tooltip : '질병군',
				width : 80,
				align : 'center',
				locked : true,
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'sex',
				header : '성별',
				tooltip : '성별',
				width : 80,
				align : 'center',
				locked : true,
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'birthYm',
				header : '생년월일',
				tooltip : '생년월일',
				width : 80,
				align : 'center',
				locked : true,
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'protocol',
				header : '프로토콜',
				tooltip : '프로토콜',
				width : 100,
				align : 'center',
				locked : true,
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'drugKind',
				header : '약물',
				tooltip : '약물',
				width : 80,
				align : 'center',
				locked : true,
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'performCntNm',
				header : '차수',
				tooltip : '차수',
				width : 80,
				align : 'center',
				locked : true,
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'cxtDiag',
				header : '공존진단',
				tooltip : '공존진단',
				width : 80,
				style: 'text-align:center',
				align : 'left',
				sortable : false,
				menuDisabled : true,
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
					metaData.style = 'cursor:Default';
					metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(record.data.cxtDetail) + '"';
					if(value == "") return value;
					var returnStr="";
					var cxtDiagArr = value.split(',');
					for(i in cxtDiagArr){
						returnStr += '<span class="icon_num">'+cxtDiagArr[i]+'</span>'
					}
					return returnStr;
					
				}
			}, {
				dataIndex : 'cxtDetail',
				header : '공존진단',
				tooltip : '공존진단',
				width : 80,
				align : 'center',
				sortable : false,
				hidden : true,
				menuDisabled : true
			}, {
				dataIndex : 'age',
				header : '나이',
				tooltip : '나이',
				width : 80,
				align : 'center',
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'visitDate',
				header : '방문일자',
				tooltip : '방문일자',
				width : 80,
				align : 'center',
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'nextVisitDate',
				header : '다음 방문일자',
				tooltip : '다음 방문일자',
				xtype: 'widgetcolumn',
				width : 110,
				align : 'center',
				sortable : false,
				menuDisabled : true,
				items : [{
					xtype : 'button',
					text : '저장',
					scale : 'small',
					handler : function(){
						selectNextVisitDate();
					}
				}],
				widget: {
	                  xtype: 'datefield',
	                  editable: true,
	                  format : 'Ymd',
	          	      submitFormat : 'Ymd',
	          	      displayField: 'nextVisitDate',
	                  listeners: {
	                        	select: function(me){
		                		  var record = me.getWidgetRecord();
		                		  property = me.getWidgetColumn().dataIndex;
		                		  record.set(property, me.getSubmitValue());
		                		  var row = me.up('gridview').indexOf(me.el.up('table'));
	                              sm.select(row,true);
		                		  targetListStore.commitChanges();
	                        	},
	                        	change:function(me){
	                        		
	                        		 var record = me.getWidgetRecord();
	                        		 var chgn = me.lastValue;
	                        		 record.data.nextVisitDate=chgn;
	                        	},
	                  }
	              }
			}, {
				  dataIndex : 'status',
				  header : '방문상태',
				  tooltip : '방문상태',
	              xtype: 'widgetcolumn',
	              width : 120,
	              align : 'center',
	              sortable : false,
				  menuDisabled : true,
	              items : [{
						id : 'visitStatus',
						xtype : 'button',
						text : '저장',
						scale : 'small',
						handler: function(){
							selectVisitStatus();
						}
					}],
	              widget: {
	                  xtype: 'combo',
	                  store: statusStore ,
	                  editable: false,
	                  displayField: 'classCdDtlNm',
	                  valueField: 'classCdDtlNm',
	                  queryMode: 'local',
	                  listeners: {
	                     change: function (combo) {
	                              if (combo.hasFocus) {
	                                  var record = combo.getWidgetRecord(),
	                                      property = combo.getWidgetColumn().dataIndex;
	                                  var row = combo.up('gridview').indexOf(combo.el.up('table'));
		                              sm.select(row,true);
	                                  record.set(property, combo.getValue());
	                              }
	                              targetListStore.commitChanges();
	                          }	
	                  }
	              },
	              editor:{}
			}, {
				dataIndex : 'researchInterview',
				header : '연구면담',
				tooltip : '연구면담',
				width : 80,
				align : 'center',
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'psychology',
				header : '심리',
				tooltip : '심리',
				width : 100,
				align : 'center',
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'urine',
				header : '소변',
				tooltip : '소변',
				width : 80,
				align : 'center',
				sortable : false,
				menuDisabled : true
			}, {
				text : '동의서',
				tooltip : '동의서',
				menuDisabled : true,
				columns : [ {
					dataIndex : 'agreeGuardian',
					header : '보호자',
					tooltip : '보호자',
					width : 80,
					// width : 180,
					align : 'center',
					resizable : false,
					menuDisabled : true,
					sortable : false,

				}, {
					dataIndex : 'agreeTarget',
					header : '대상자',
					tooltip : '대상자',
					width : 80,
					align : 'center',
					resizable : false,
					menuDisabled : true,
					sortable : false,
				} ]
			}, {
				dataIndex : 'surveyDistrib',
				header : '설문지 배부',
				tooltip : '설문지 배부',
				width : 100,
				align : 'center',
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'surveyReclam',
				header : '설문지회수',
				tooltip : '설문지회수',
				width : 100,
				align : 'center',
				sortable : false,
				menuDisabled : true
			}, {
				dataIndex : 'sendResult',
				header : '결과지발송',
				tooltip : '결과지발송',
				width : 100,
				align : 'center',
				sortable : false,
				menuDisabled : true
			}, {
				text : '면담결과',
				tooltip : '면담결과',
				menuDisabled : true,
				columns : [ {
					dataIndex : 'interviewDate',
					header : '면담일자',
					tooltip : '면담일자',
					width : 80,
					// width : 180,
					align : 'center',
					resizable : false,
					menuDisabled : true,
					sortable : false,

				}, {
					dataIndex : 'interviewer',
					header : '면담자',
					tooltip : '면담자',
					width : 80,
					align : 'center',
					resizable : false,
					menuDisabled : true,
					sortable : false,
				}, {
					dataIndex : 'interviewMethod',
					header : '면담방법',
					tooltip : '면담방법',
					width : 100,
					align : 'center',
					sortable : false,
					menuDisabled : true
				} ]
			}, {
				dataIndex : 'targetRemarks',
				header : '비고',
				tooltip : '비고',
				width : 380,
				style: 'text-align:center',
				align : 'left',
				sortable : false,
				renderer : Ext.util.Format.tooltip,
				menuDisabled : true,
				editor: {
                    allowBlank: true,
				},
				items : [{
					xtype : 'button',
					text : '저장',
					scale : 'small',
					handler: function(){
						selectTargetRemarks();
					}
				}],
				//그리드 툴팁
				renderer: function(value, metaData, record, rowIdx, colIdx, store) {
				        value = Ext.String.htmlEncode(value);
				        metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
				        return value;
				}
			} ],
			fbar : new Ext.PagingToolbar({
				id : 'targetList-grid-page',
				pageSize : pageSize,
				store : targetListStore,
				displayInfo : true,
				items : [ '->' ],
				prependButtons : true,
				plugins : [ new Ext.ux.plugin.PagingToolbarResizer() ],
				listeners : {
					change : function(p, pageData) {
						if (pageData.total == 0) {
							return;
						}
						activePage = pageData.activePage;
					},
					changevalue : function(p, value) {
						pageSize = value;
					}
				}
			})
	        ,listeners: {//row click 이벤트
				celldblclick : function(view, cell, cellIndex, record,row, rowIndex, e) {
					var clickedDataIndex = view.panel.headerCt.getHeaderAtIndex(cellIndex).dataIndex;
					var clickedCellValue = record.get(clickedDataIndex);
					
					//연구번호 클릭 시 데이터 통합 분석 상세로 이동
					if(clickedDataIndex == "targetId"){
						var targetId = clickedCellValue;
						var url = GLOBAL_CONTEXT_PATH + '/medical/dataIntegration/dataIntegrationDtl.view';
						location.href = url+"?targetId="+targetId;
					}
				}
			}
		} ]

	});
}

Ext.onReady(function() {
	Ext.QuickTips.init();

	//왼쪽메뉴 선택
	parent.leftMenuChgByUrl(window.location.href);
	
	
	targetListStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		pageSize : pageSize,
		proxy : {
			type : 'ajax',
			extraParams : {'disClassDtl' : menuDisClassDtl},
			url : GLOBAL_CONTEXT_PATH + '/medical/target/selectTargetList.do',
			reader : {
				type : 'json',
				root : 'result',
				totalProperty : 'total'
			}

		},
		listeners : {
			load : function() {
			}
		}
	});
	
	statusStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
  		autoLoad : true,
		pageSize : pageSize,
		fields: ['nextVisitDate', 'nextVisitDate'],
		async: false,
		proxy : {
		    type : 'ajax',
			extraParams : {'classCd' : 'STS01'},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/commoninfo/code/selectCodeDetailSearchCondition.do',
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
	
	new targetListGrid();
	
	//데이터 통합 정보에서 이동
	if(chgTabNm != ''){
    	
		
    	//해당탭으로 이동
    	searchPageParams.targetId = chgTargetId;
    	searchPageParams.performCnt = chgPerformCnt;
		searchPageParams.schKeyWord="schTargetId";
		searchPageParams.rndId=loginRndId;
		searchPageParams.limit=targetListStore.getPageSize();
		searchPageParams.disClassDtl = menuDisClassDtl;
		moveTargetPage();
    }
});

function doSearch() {
	var checkSex = "", checkPro = "", checkCxtDiag = "", checkStatus = "";
	if ($("input:checkbox[name=check_sex]:checked").length == 1)
		checkSex = $("input:checkbox[name=check_sex]:checked").val();
	$("input:checkbox[name=check_pro]:checked").each(function() {
		if (checkPro != "")
			checkPro += ",";
		var val = this.value;
		val = val.replace(/ /gi, "");
//		console.log("val------ : "+val);
		checkPro += "'" + val + "'";
	})

	$("input:checkbox[name=cxtDiag]:checked").each(function() {
		if (checkCxtDiag != "")
			checkCxtDiag += " OR ";
		checkCxtDiag += "INSTR(CXT_DIAG, '" + this.value + "')";
		
	})
	
	$("input:checkbox[name=status]:checked").each(function() {
		if (checkStatus != "")
			checkStatus += ",";
		var val = this.value;
//		val = val.replace(/ /gi, "");
		checkStatus += "'" + val + "'";
	})
	
	var researchInterview = document.getElementsByName("researchInterview")[0].checked;
	var psychology = document.getElementsByName("psychology")[0].checked;
	var urine = document.getElementsByName("urine")[0].checked;
	var surveyDistrib = document.getElementsByName("surveyDistrib")[0].checked;
	var sendResult = document.getElementsByName("sendResult")[0].checked;
	var interviewDate = document.getElementsByName("interviewDate")[0].checked;
	var remainsAgree = document.getElementsByName("remainsAgree")[0].checked;
	searchParams = {
		targetId : document.getElementById("targetId").value,
		startAge : document.getElementById("startAge").value,
		endAge : document.getElementById("endAge").value,
		sex : checkSex,
		protocol : checkPro,
		status : checkStatus,
		performCnt : document.getElementById("performCnt").value,
		cxtDiag : checkCxtDiag,
		researchInterview : researchInterview ? 'Y' : 'N',
		psychology : psychology ? 'Y' : 'N',
		urine : urine ? 'Y' : 'N',
		remainsAgree : remainsAgree ? 'Y' : 'N',
		surveyDistrib : surveyDistrib ? 'Y' : 'N',
		sendResult : sendResult ? 'Y' : 'N',
		interviewDate : interviewDate ? 'Y' : 'N',
		disClassDtl : menuDisClassDtl

	}

	targetListStore.proxy.extraParams = searchParams;
	var pageParams = {
		start : 0,
		limit : pageSize
	};

	targetListStore.load({
		params : pageParams
	});
}

function excelUpload() {
	var excelDataUploadPanel = new ExcelDataUploadPanel();
	excelDataUploadPanel.show();
}

/* 데이터업로드(엑셀) */
ExcelDataUploadPanel = function() {
	ExcelDataUploadPanel.superclass.constructor
			.call(
					this,
					{
						id : 'ExcelDataFile-upload',
						closeAction : 'destroy',
						title : '대상자정보 데이터 업로드',
						titleAlign : 'center',
						plain : false,
						width : 400,
						height : 170,
						maximizable : false,
						modal : true,
						border : false,
						resizable : false,
						layout : 'fit',
						items : [ Ext
								.create(
										'Ext.form.Panel',
										{
											fileUpload : true,
											frame : true,
											autoHeight : true,
											labelWidth : 150,
											style : "padding-top: 10px;",
											items : [{
													msgTarget : 'side',
													id : 'excelUploadFile',
													name : 'excelUploadFile',
													fieldLabel : '원본 파일',
													anchor : '95%',
													style : "padding-left: 20px;",
													required : true,
													autoShow : true,
													xtype : 'filefield',
													width : 350,
													listeners : {
														change : function(obj, value,eOpts) {
															obj.setRawValue(value.replace(/C:\\fakepath\\/g,''));
														}
													}
												},{
														msgTarget : 'side',
														id : 'uploadZipFile',
														name : 'uploadZipFile',
														fieldLabel : '관리 파일 ',
														anchor : '95%',
														style : "padding-left: 20px;",
														required : true,
														autoShow : true,
														xtype : 'filefield',
														width : 350,
														listeners : {
															change : function(obj, value,eOpts) {
																obj.setRawValue(value.replace(/C:\\fakepath\\/g,''));
															}
														}
													}],
											buttonAlign : 'center',
											buttons : [
													{
														text : '업로드',
														cls : 'btn_color',
														handler : function(btn) {
															var win = btn
																	.up('window');
															var formF = win
																	.down('form');
															ufp = formF
																	.getForm();
															var file1 = Ext
																	.getCmp(
																			'uploadZipFile')
																	.getValue();
															var file2 = Ext
																	.getCmp(
																			'excelUploadFile')
																	.getValue();
															if (file1 == ""
																	&& file2 == "") {
																Ext.Msg
																		.alert(
																				'알림',
																				'<b>업로드 파일을 확인해 주세요.</b>');
															} else {
																if (file1 != ""
																		&& !file1
																				.match(/(.zip|.tar|.gz)$/)) {
																	Ext.Msg
																			.alert(
																					'알림',
																					'zip, tar, gz 확장자를 가진 파일만 진행 가능합니다.');
																	return false;
																}
																if (file2 != ""
																		&& !file2
																				.match(/(.xls|.xlsx)$/)) {
																	Ext.Msg
																			.alert(
																					'알림',
																					'xls, xlsx 확장자를 가진 파일만 진행 가능합니다.');
																	return false;
																}
																Ext.MessageBox
																		.show({
																			msg : '데이터 업로드 중..',
																			progressText : '잠시만 기다려주세요..',
																			width : 300,
																			wait : true,
																			waitConfig : {
																				interval : 200
																			},
																			icon : 'ext-mb-download',
																			animEl : 'buttonID'
																		});
																var url = GLOBAL_CONTEXT_PATH
																		+ '/medical/target/targetFileUpload.do';
																ufp
																		.submit({
																			url : url,
																			params : {
																				rndId : loginRndId,
																				disClassDtl : menuDisClassDtl,
																				fileClassDtl : 'FIL01'
																			},
																			success : function(
																					response,
																					opts) {
																				Ext.MessageBox
																						.hide();
																				var obj = Ext
																						.decode(response.responseText);
																				var json = Ext.util.JSON
																						.decode(opts.response.responseText);
																				Ext.Msg
																						.show({
																							title : '알림',
																							msg : '파일 업로드를 성공하였습니다.',
																							buttons : Ext.Msg.OK,
																							fn : function(
																									btn,
																									text) {
																								if (btn == 'ok') {
																									doSearch();
																									Ext.getCmp('ExcelDataFile-upload').close();
																									parent.followUplistRefresh();
																								}
																							}
																						});
																			},
																			failure : function(
																					response,
																					opts) {
																				Ext.MessageBox
																						.hide();
																				var json = Ext.util.JSON
																						.decode(opts.response.responseText);
																				Ext.Msg
																						.alert(
																								'알림',
																								'<b>'
																										+ json.message
																										+ '</b>');
																			}
																		});
															}
														}
													},
													{
														text : '취소',
														handler : function() {
															Ext
																	.getCmp(
																			'ExcelDataFile-upload')
																	.close();
														}
													} ]
										}) ]
					});
};

Ext.extend(ExcelDataUploadPanel, Ext.Window, {});

function createElement(name, value){
	var field = document.createElement("input");
	field.setAttribute("type", "hidden");
	field.setAttribute("name", name);
	field.setAttribute("value", value);
	return field;
}

function excelDownload() {
	if (targetListStore.getCount() == 0) {
		Ext.Msg.alert('Warning', '결과자료가 없습니다.');
		return false;
	}
	
	var s = sm.getSelection();

	if (s.length > 0) {
		//선택 다운로드
		
		var form = document.createElement("form");
	    form.setAttribute("charset", "UTF-8");
	    form.setAttribute("method", "Post");  //Post 방식
	    form.setAttribute("action", GLOBAL_CONTEXT_PATH+'/medical/target/targetSelectExcelDownload.do'); //요청 보낼 주소
	    
	    form.appendChild(createElement("rndId",loginRndId));
	    form.appendChild(createElement("disClassDtl",menuDisClassDtl));
		Ext.each(s, function(rec) {
			 //form에 전달할 데이터 셋팅
				
			    form.appendChild(createElement("targetId",rec.get('targetId')));
			    form.appendChild(createElement("performCnt",rec.get('performCnt')));
			 });
		
		
	    document.body.appendChild(form);
	    form.target = '_self';
	    form.submit();

	}else{
		//전체 다운로드
		searchParams.limit = 60000;
		searchParams.disClassDtl = menuDisClassDtl;
		document.location.href = makeUrl('/medical/target/targetExcelDownload.do',searchParams);
	}
	
	

}

function uploadExcelDownload() {
	
	location.href = GLOBAL_CONTEXT_PATH + '/downFile.view?dir=file.sample.dir&fileName=TargetUpload.xlsx';
	
}

function selectDelete() {

	var s = sm.getSelection();
	if (s < 1) {
		Ext.Msg.alert('알림', '데이터를 선택해주세요.');
		return false;
	}

	Ext.MessageBox.show({
		title : '알림',
		msg : '정말 삭제하시겠습니까?',
		buttons : Ext.MessageBox.OKCANCEL,
		fn : function(btn) {
			if (btn == 'ok') {
				var list = [];
				Ext.each(s, function(rec) {
					targetVO = {
						targetId : rec.get('targetId'),
						performCnt : rec.get('performCnt'),
						performCntNm : rec.get('performCntNm')
					}

					list.push(targetVO)
				});

				Ext.Ajax.request({
					url : makeUrl('/medical/target/deleteTargetId.do'),
					headers : {
						'Content-Type' : 'application/json'
					},
					method : 'post',
					jsonData : {
						targetList : list
					},
					success : function(resp) {
						var obj = Ext.decode(resp.responseText);
						if (obj.success) {
							Ext.Msg.alert('알림', '데이터가 삭제되었습니다.');
							parent.followUplistRefresh();
						} else {
							Ext.Msg.alert('알림', '데이터 삭제에 실패했습니다.<br/><b>'
									+ obj.errors.reason + '</b>');
						}
					},
					callback : function() {
						doSearch();
					}
				});
				/*
				 * Ext.Ajax.request({ url :
				 * makeUrl('/medical/target/deleteTargetId.do'), headers : {
				 * 'Content-Type' : 'application/json' }, params : {targetListVO :
				 * list}, timeout : 100000000, success : function(response,
				 * opts) { var obj = Ext.decode(response.responseText); if
				 * (obj.success) { Ext.Msg.alert("알림","삭제되었습니다."); doSearch(); } }
				 * });
				 */
			}
		}
	});
}

// 검색 팝업 열기
function openSearchPop() {
	$('.searchbox').show();
}
// 팝업 닫기
function closeSearchPop() {
	$('.searchbox').hide();
}

function moveTargetPage(){
	//검색조건 초기화
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
 		url : makeUrl('/medical/target/selectTargetPage.do'),
 		params : searchPageParams,
 	    method : 'POST',
 	    timeout : 100000000,
        success : function(response, opts) {
        	var obj = Ext.decode(response.responseText);
            if (obj.success) {
            	
            	var pageNum = obj.pageNum;
            	var rNum = (obj.rNum-1);
            	if(rNum == -1){
            		targetListStore.currentPage = 1;
            		targetListStore.load();
            		Ext.MessageBox.hide();
            	}else{
	            	targetListStore.currentPage = pageNum;
	            	targetListStore.load(function(){
	        			
		        		sm.select(rNum,true);
		        		//스크롤 이동
		        		var x= Ext.getCmp('targetList-grid').getView().ownerGrid.getScrollX();
		        		Ext.getCmp('targetList-grid').getView().ownerGrid.scrollTo(x,rNum*26);
		        		Ext.MessageBox.hide();
	        		});
            	}
            }
        }
 	});
	
}

//방문상태 선택 수정
function selectVisitStatus(){
	var s = sm.getSelection();
	var targetIdList = [];
	var performCntList = [];
	var statusList = [];
	
	if (s < 1) {
		Ext.Msg.alert('알림', '데이터를 선택해주세요.');
		return false;
	}
	
	Ext.each(s, function(rec){
		
		targetIdList.push(rec.get('targetId'));
		performCntList.push(rec.get('performCnt'));
		statusList.push(rec.get('status'));
		
	});
	
	var params = {
			targetIdList : targetIdList,
			performCntList : performCntList,
			statusList : statusList
	};
	
	Ext.MessageBox.show({
		title : '알림',
		msg : '저장하시겠습니까?',
		buttons : Ext.MessageBox.OKCANCEL,
		fn : function(btn) {
			if (btn == 'ok') {
			Ext.Ajax.request({
				url : makeUrl('/medical/target/updateTargetList.do'),
	            params : params,
				method : 'POST',
				timeout : 100000000,
				success : function(response, opts) {
					Ext.Msg.alert('알림', '데이터가 저장되었습니다.');
					doSearch();
					parent.followUplistRefresh();
				},
				failure : function(result, request){
   	         	},
   	         	callback : function() {
   	         	}
			});
		  }
		}
	});
	
}

function targetSelect(chgTargetId, chgPerformCnt){
	
	//해당탭으로 이동
	searchPageParams.targetId = chgTargetId;
	searchPageParams.performCnt = chgPerformCnt;
	searchPageParams.schKeyWord="schTargetId";
	searchPageParams.rndId=loginRndId;
	searchPageParams.limit=targetListStore.getPageSize();
	searchPageParams.disClassDtl = menuDisClassDtl;
	moveTargetPage();
	
}
// 다음 방문일자 선택
function selectNextVisitDate(){
	
	var s = sm.getSelection();
	var targetIdList = [];
	var performCntList = [];
	var nextVisitDateList = [];
	var dateChk = true;
	
	if (s < 1) {
		Ext.Msg.alert('알림', '데이터를 선택해주세요.');
		return false;
	}
	Ext.getCmp('targetList-grid').getView().refresh();
	
	Ext.each(s, function(rec){
		targetIdList.push(rec.get('targetId'));
		performCntList.push(rec.get('performCnt'));
		nextVisitDateList.push(rec.get('nextVisitDate'));
		var numVisitDate = parseInt(rec.get('visitDate').substr(0,4)+rec.get('visitDate').substr(5,2)+rec.get('visitDate').substr(8,2));
		var numNextVisitDate = parseInt(rec.get('nextVisitDate'));
		if(rec.get('nextVisitDate') == null || rec.get('nextVisitDate') == '') {
			Ext.Msg.alert('알림', '연구번호 : ' + rec.get('targetId') + ' 차수 : ' + rec.get('performCntNm') + 
					'의 다음 방문일자가 날짜 형식에 맞지 않습니다. 재입력 바랍니다.');
			dateChk = false;
			return dateChk;
		}else{
			if(numNextVisitDate < numVisitDate ){
				Ext.Msg.alert('알림', '연구번호 : ' + rec.get('targetId') + ' 차수 : ' + rec.get('performCntNm') + 
					'의 다음 방문일자가 방문일자보다 과거입니다. 재입력 바랍니다.');
					dateChk = false;
					return false;
				}
				return true;
			}
		});
		
	var params = {
			targetIdList : targetIdList,
			performCntList : performCntList,
			nextVisitDateList : nextVisitDateList
	};
	
	if(dateChk==true){	
		
			Ext.MessageBox.show({
				title : '알림',
				msg : '저장하시겠습니까?',
				buttons : Ext.MessageBox.OKCANCEL,
				fn : function(btn) {
					if (btn == 'ok') {
							Ext.Ajax.request({
								url : makeUrl('/medical/target/updateNextVisitDate.do'),
					            params : params,
								method : 'POST',
								timeout : 100000000,
								success : function(response, opts) {
									Ext.Msg.alert('알림', '데이터가 저장되었습니다.');
									doSearch();
									parent.followUplistRefresh();
								},
								failure : function(result, request){
				   	         	},
				   	         	callback : function() {
				   	         	}
							});
						}	
					}
				});
		}
}
function selectTargetRemarks(){
	var s = sm.getSelection();
	var targetIdList = [];
	var performCntList = [];
	var targetRemarksList = [];
	
	if (s < 1) {
		Ext.Msg.alert('알림', '데이터를 선택해주세요.');
		return false;
	}
	
	Ext.getCmp('targetList-grid').getView().refresh();
	
	Ext.each(s, function(rec){
		targetIdList.push(rec.get('targetId'));
		performCntList.push(rec.get('performCnt'));
		targetRemarksList.push(rec.get('targetRemarks'));
	});
	
	var params = {
			targetIdList : targetIdList,
			performCntList : performCntList,
			targetRemarksList : targetRemarksList
	};
	
	Ext.MessageBox.show({
		title : '알림',
		msg : '저장하시겠습니까?',
		buttons : Ext.MessageBox.OKCANCEL,
		fn : function(btn) {
			if (btn == 'ok') {
					Ext.Ajax.request({
						url : makeUrl('/medical/target/updateTargetRemarks.do'),
			            params : params,
						method : 'POST',
						timeout : 100000000,
						success : function(response, opts) {
							Ext.Msg.alert('알림', '데이터가 저장되었습니다.');
							doSearch();
							parent.followUplistRefresh();
						},
						failure : function(result, request){
		   	         	},
		   	         	callback : function() {
		   	         	}
					});
				}	
			}
		});
}

function beforeedit(editor, obj){
	if(obj.field == 'status'){
		return false;
	}
}

