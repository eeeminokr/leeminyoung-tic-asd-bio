var pageSize =  parameter['pageSize'];
var imagingListGrid;
var activePage = parameter['activePage'];
var imagingListStore;
var sm = new Ext.selection.CheckboxModel({headerWidth:40});
var ImagingUpload = {};
var searchParams = {};
var searchPageParams = {};
var chgTabNm = pageLoad.getParameter('chgTabNm');
var chgTargetId = pageLoad.getParameter('targetId');
var chgPerformCnt = pageLoad.getParameter('performCnt');


imagingListGrid = function() {
	Ext.create("Ext.panel.Panel", {
		height : '760px',
		region : 'center',
		layout : 'border',
		renderTo : 'ContentsDiv',
		border : false,
		cls : 'mousepointer',
		items : [ {
			xtype : 'grid',
			id : 'imagingList-grid',
			region : 'center',
			autoExpandColumn : 'subject',
			store : imagingListStore,
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
				tooltip : '성별',
				flex: 5 / 100,
				align : 'center',
				sortable: false,
				menuDisabled : true
			},{
				dataIndex : 'birthYm',
				header : '생년월일',
				tooltip : '생년월일',
				flex: 8 / 100,
				align : 'center',
				sortable: false,
				menuDisabled : true
			},{
				dataIndex : 'performCnt',
				header : '차수',
				tooltip : '차수',
				flex: 4 / 100,
				align : 'center',
				sortable: false,
				menuDisabled : true
			},{
				dataIndex : 'age',
				header : '나이',
				tooltip : '나이',
				flex:4 / 100,
				align : 'center',
				sortable: false,
				menuDisabled : true
			},{
				dataIndex : 'execDate',
				header : '실시일',
				tooltip : '실시일',
				flex: 8 / 100,
				align : 'center',
				sortable: false,
				menuDisabled : true
			},{
				dataIndex : 'pocral',
				header : '포크랄',
				tooltip : '포크랄',
				flex: 10 / 100,
				align : 'center',
				sortable: false,
				menuDisabled : true
			},{
				text: '영상종류',
				tooltip: '영상종류',
				flex: 43 / 100,
				menuDisabled : true,
				columns : [{
					dataIndex : 'asl',
					header : 'ASL',
					tooltip : 'ASL',
					flex: 12 / 100,
					align : 'center',
					resizable : false,
					menuDisabled : true,
					sortable: false,
					
				},{
					dataIndex : 'dti',
					header : 'DTI',
					tooltip : 'DTI',
					flex: 12 / 100,
					align : 'center',
					resizable : false,
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'fmri',
					header : 'fMRI',
					tooltip : 'fMRI',
					flex: 12 / 100,
					align : 'center',
					resizable : false,
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 't1',
					header : 'T1',
					tooltip : 'T1',
					flex: 12 / 100,
					align : 'center',
					resizable : false,
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 't2',
					header : 'T2',
					tooltip : 'T2',
					flex: 12 / 100,
					align : 'center',
					resizable : false,
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'swi',
					header : 'SWI',
					tooltip : 'SWI',
					flex: 12 / 100,
					align : 'center',
					resizable : false,
					menuDisabled : true,
					sortable: false,
				}]
			},{
				header : '업로드이력관리',
				tooltip : '업로드이력관리',
				dataIndex : 'updateDate',
				flex: 10 / 100,
				align : 'center',
				sortable: false,
				menuDisabled : true,
				renderer : function(value, metaData, record, rowIndex)
			    {
					value = Ext.String.htmlEncode(value) +" "+ record.get('updateBy');
					metaData.tdAttr = 'data-qtip="' + Ext.String.htmlEncode(value) + '"';
					 
			        return value;
			    },
			}],
			fbar: new Ext.PagingToolbar({
	        	id: 'imagingList-grid-page',
	            pageSize: pageSize,
	            store: imagingListStore,
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
	        })
			,listeners: {//row click 이벤트
//				celldblclick : function(view, cell, cellIndex, record,row, rowIndex, e) {
//					var clickedDataIndex = view.panel.headerCt.getHeaderAtIndex(cellIndex).dataIndex;
//					var clickedCellValue = record.get(clickedDataIndex);
//					
//					//연구번호 클릭 시 데이터 통합 분석 상세로 이동
//					if(clickedDataIndex == "targetId"){
//						var targetId = clickedCellValue;
//						var url = GLOBAL_CONTEXT_PATH + '/medical/dataIntegration/dataIntegrationDtl.view';
//						location.href = url+"?targetId="+targetId;
//					}
//				}
			}
		} ]
		
	});
}

Ext.onReady(function() {
	Ext.QuickTips.init();	
	
	//왼쪽메뉴 선택
	parent.leftMenuChgByUrl(window.location.href);
	
	imagingListStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		pageSize : pageSize,
		proxy : {
			type : 'ajax',
			extraParams : {'disClassDtl' : menuDisClassDtl},
			url : GLOBAL_CONTEXT_PATH + '/medical/imagingInfo/selectImageList.do',
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
	
	
	new imagingListGrid();
	
	
	//데이터 통합 정보에서 이동
	if(chgTabNm != ''){
    	//해당탭으로 이동
    	searchPageParams.targetId = chgTargetId;
    	searchPageParams.performCnt = chgPerformCnt;
		searchPageParams.schKeyWord="schTargetId";
		searchPageParams.rndId=loginRndId;
		searchPageParams.limit=imagingListStore.getPageSize();
		searchPageParams.disClassDtl = menuDisClassDtl;
		moveImagingPage();
    }
	
});


function moveImagingPage(){
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
 		url : makeUrl('/medical/imagingInfo/selectImagingPage.do'),
 		params : searchPageParams,
 	    method : 'POST',
 	    timeout : 100000000,
        success : function(response, opts) {
        	var obj = Ext.decode(response.responseText);
            if (obj.success) {
            	
            	var pageNum = obj.pageNum;
            	var rNum = (obj.rNum-1);

            	imagingListStore.currentPage = pageNum;
            	imagingListStore.load(function(){
        			
	        		sm.select(rNum,true);
	        		//스크롤 이동
	        		var x= Ext.getCmp('imagingList-grid').getView().getScrollX();
	        		Ext.getCmp('imagingList-grid').getView().scrollTo(x,rNum*26);
	        		Ext.MessageBox.hide();
        		});
            }
        }
 	});
	
}

function doSearch() {
	 
	var checkSex = "", checkPro = "";
	var pocral = document.getElementsByName("pocral")[0].checked;
	var dti = document.getElementsByName("dti")[0].checked;
	var asl = document.getElementsByName("asl")[0].checked;
	var fmri = document.getElementsByName("fmri")[0].checked;
	var t1 = document.getElementsByName("t1")[0].checked;
	var t2 = document.getElementsByName("t2")[0].checked;
	var swi = document.getElementsByName("swi")[0].checked;
	
	if ($("input:checkbox[name=check_sex]:checked").length == 1)
		checkSex = $("input:checkbox[name=check_sex]:checked").val();

	$("input:checkbox[name=check_pro]:checked").each(function() {
		if (checkPro != "")
			checkPro += ",";
		var val = this.value;
		val = val.replace(/ /gi, "");
		checkPro += "'" + val + "'";
	})
	
	searchParams = {
		targetId : document.getElementById("targetId").value, //뇌원천 연구번호
		targetDisId : document.getElementById("targetDisId").value, //뇌질환 연구번호
		sex : checkSex,										// 성별
		startAge : document.getElementById("startAge").value, //시작나이
		endAge : document.getElementById("endAge").value,	// 끝나이
		performCnt : document.getElementById("performCnt").value, // 차수
		protocol : checkPro, 
		pocral : pocral ? 'Y' : 'N',
		dti	 : dti ? 'Y' : 'N',
		asl : asl ? 'Y' : 'N',
		fmri : fmri ? 'Y' : 'N',
		t1 : t1 ? 'Y' : 'N',
		t2 : t2 ? 'Y' : 'N',
		swi : swi ? 'Y' : 'N',		
		disClassDtl : menuDisClassDtl
	}
	imagingListStore.proxy.extraParams = searchParams;
	var pageParams = {
		start : 0,
		limit : pageSize
	};

	imagingListStore.load({
		params : pageParams
	});
	imagingListStore.load();
	
}
ImagingUpload.PopUpWin = function(){
	var file1 = "";
	var file2 = "";
	ImagingUpload.PopUpWin.superclass.constructor.call(this, {
		id: 'ImagingUpload',
		closeAction: 'destroy',
		title: '파일 업로드',
		plain: false,
		width: 400,
		height : 220,
		autoHeight: true,
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
				labelWidth: 90,
				style : "margin:0 auto;padding-top:10px;",
		        items: [{
				        xtype: 'radiogroup',
				        fieldLabel: '업로드 구분',
				        id: 'uploadType',
				        columns: 2,
						vertical: false,
						style: 'margin:0;padding:6px 20px 6px 10px;border-bottom: 1px solid #d5d8dd;',
				        defaults: {
				            width: 'auto',
				            margin : 5
				        },
				        items: [{
				            boxLabel: '파일',
				            name: 'rb',
				            inputValue: '1',
				            checked: true
				        }, {
				            boxLabel: '폴더',
			            	name: 'rb',
				            inputValue: '2'
				        }],
				        listeners: {
				        	renderer: function(val){
//				        		console.log('comboValue ===> ' + val);
				        	},
				            change : function(obj, value){
//				            	console.log('comboValue ===> ' + value.rb);
				            	if(value.rb != 1){
				            		document.getElementById("excelUploadFile-button-fileInputEl").title = '업로드 구분을 파일로 선택한 후 진행해 주시기 바랍니다.';
				            	}else{
				            		document.getElementById("excelUploadFile-button-fileInputEl").title = '선택된 파일 없음';
				            	}
				               }
				           }
				    },
				    { 
		        	xtype: 'filefield',
		        	id: 'excelUploadFile',
					name: 'excelUploadFile',
		        	msgTarget: 'side',
					fieldLabel: '원본파일',
					blankText: '파일을 선택하세요',
					anchor: '95%',
//					required: true,
					autoShow: true,
					buttonText : 'Select',
					fileInputAttributes: {
			            accept: '.xls, .xlsx'
			        }, 
					flex : 3,
					style: 'margin:0;padding:6px 20px 6px 10px;border-bottom: 1px solid #d5d8dd;',
					width : 350,
					listeners:{
						click: {
				            element: 'el', //bind to the underlying el property on the panel
				            fn: function(){
								document.getElementById("excelUploadFile-button-fileInputEl").removeAttribute("webkitdirectory");
								document.getElementById("excelUploadFile-button-fileInputEl").removeAttribute("mozdirectory");
								document.getElementById("excelUploadFile-button-fileInputEl").removeAttribute("multiple");
				            }
				        },
						change : function( obj, value, eOpts ){
							if (typeof Ext.getCmp('uploadType').getValue().rb === 'undefined'){
								Ext.Msg.alert('알림','업로드 구분을 선택해 주세요.');
								return false;
							}
							obj.setRawValue(value.replace(/C:\\fakepath\\/g, ''));
						}
					}
                },
                {
			    	xtype: 'filefield',
			    	id: 'dataFile',
					name: 'dataFile',
		        	msgTarget: 'side',
					fieldLabel: '영상파일',
					blankText: '폴더 또는 파일을 선택하세요',
					anchor: '95%',
//					required: true,
					autoShow: true,
					buttonText : 'Select',
/*						fileInputAttributes: {
			            accept: '.zip, .tar, .bz'
			        }, */
					flex : 3,
					style: 'margin:0;padding:6px 20px 6px 10px;border-bottom: 1px solid #d5d8dd;',
					width : 350,
					listeners:{
						click: {
				            element: 'el', //bind to the underlying el property on the panel
				            fn: function(){
//				            	console.log(Ext.getCmp('dataFile').getValue());
				            	if(Ext.getCmp('uploadType').getValue().rb == '1'){
									document.getElementById("dataFile-button-fileInputEl").removeAttribute("webkitdirectory");
									document.getElementById("dataFile-button-fileInputEl").removeAttribute("mozdirectory");
									document.getElementById("dataFile-button-fileInputEl").removeAttribute("multiple");
								}else{
									//폴더선택으로 할 수 있도록 변경
									Ext.getCmp('dataFile').fileInputEl.set({ webkitdirectory :'' ,mozdirectory :'',multiple:true});
								}
				            	}
				        },
						change : function( obj, value, eOpts ){
							if (typeof Ext.getCmp('uploadType').getValue().rb === 'undefined'){
								Ext.Msg.alert('알림','업로드 구분을 선택해 주세요.');
								return false;
							}
							obj.setRawValue(value.replace(/C:\\fakepath\\/g, ''));
						}
					}
                }],
		        buttonAlign: 'center',
		        buttons: [{
		            text: '업로드',
		            handler: function(btn){
		            	file1 = Ext.getCmp('dataFile').getValue();
		            	file2 = Ext.getCmp('excelUploadFile').getValue();
		            	if(file1=="" && file2==""){
		            		Ext.Msg.alert('알림', '<b>업로드 파일을 확인해 주세요.</b>');
		            		return false;
		            	}
		            	
		            	if(Ext.getCmp('uploadType').getValue().rb == '1'){
			            	if(file1 != "" && !file1.match(/(.zip|.tar|.gz)$/)){
		            			Ext.Msg.alert('알림', 'zip, tar, gz 확장자를 가진 파일만 진행 가능합니다.');
			            	    return false;
		            		}
			            	if(file1 != ""){
				            	var file1Addr = file1.split('_');
				            	if(file1Addr.length != 3){
				            		Ext.Msg.alert('알림', '규격화된 파일명 형식이 아닙니다. 확인해 보시기 바랍니다.<br> ex :  연구번호_차수_파일구분명.zip');
				            	    return false;
				            	}
			            	}
		            	}else{
		            		if(file1 == "" && file2 != ""){
		            			Ext.Msg.alert('알림', '원본파일은 업로드 구분을 파일로 선택한 후 진행해 주시기 바랍니다.');
		            			Ext.getCmp('excelUploadFile').setRawValue('');
			            	    return false;
		            		} 
		            	}
		            	if(file2 != "" && !file2.match(/(.xls|.xlsx)$/)){
	            			Ext.Msg.alert('알림', 'xls, xlsx 확장자를 가진 파일만 진행 가능합니다.');
		            	    return false;
	            		}
		            	var win = btn.up('window');
		                var formF = win.down('form');
		            	var ufp =formF.getForm();
		            	if(ufp.isValid()&&file1 != ""){
		            		var fileSize = document.getElementById('dataFile-button-fileInputEl').files[0].size;
		            		if(fileSize > 2147483648){
	            		    	Ext.Msg.alert('알림', '2GB 이하의 파일을 업로드해주세요.<br/><br/><b>현재 파일사이즈: '+ (fileSize / 1024 / 1024 / 1024).toFixed(2) +'GB</b>');
	            		    	return false;
	            		    }
		            	}
	            		/* progress info */
	            		var taskId = ((1 + Math.random()) * 0x10000 | 0).toString(16).substring(1) + new Date().getMilliseconds();
	            		var getProgressBoo=true;	// a boolean flag to decide when to stop checking progress
	            		 Ext.MessageBox.show({
	            		        title: 'Please wait',
	            		        msg: '<Label id="proTitle">서버로 업로드 중입니다.</Label>',
	            		        progressText: 'Initializing...',
	            		        width:320,
	            		        progress:true,
	            		        closable:false
	            		    });
	            		var calculation = function(proCnt, totCnt, zipTotal, zipTotalProcessed, taskNum){
	            		   return function(){
	            		   	if(proCnt == totCnt){
	            		   	}else{
	            		   		var avg = isNaN(proCnt/totCnt)==true?0:proCnt/totCnt;
	            		   		if(taskNum == 3)Ext.MessageBox.updateProgress(avg, 
	            		   				proCnt+' / '+totCnt+' compressed (Creating ZIP : ' + zipTotalProcessed + ' / ' + zipTotal + ')');
	            		   		else Ext.MessageBox.updateProgress(avg, proCnt+' / '+totCnt+' completed');
	            		   	}
	            		  };
	            		};
	            		var task = {
	            				   run: function(){
	            				      if(getProgressBoo){
	            				         // make another Ajax request to get the latest status
	            				         Ext.Ajax.request({
	            				            url : GLOBAL_CONTEXT_PATH + '/ProgressMonitor',
	            				            timeout: 100000000,
	            				            method: 'POST',
	            				            params :{
	            				               taskIdentity: taskId   // use the same taskId which was used while submitting task
	            				            },
	            				            success: function (response, options) {
	            				               var obj = Ext.decode(response.responseText);
	            				               // get the number of total items and total processed..
	            				               // for a task with 5 steps, totalItems would be 5 and totalProcessed will
	            				               // vary from 0 to 5..
	            				               var dProcess = "( 원본파일 : " + obj.zTotalProcessed + " / " + obj.zTotal + " )";
	            				               var totalSize = obj.total;
	            				               var totalProcessed = obj.totalProcessed;
	            				               var zipTotal = obj.mTotal;
	            				               var zipTotalProcessed = obj.mTotalProcessed;
	            				               var taskNum = obj.taskNum;
	            				               var taskName;
	            				               if(taskNum == 1)taskName = '압축 해제  중입니다.';
	            				               else if(taskNum == 2)taskName = '파일 분류 중입니다.';
	            				               else if(taskNum == 3){
	            				            	   taskName = '종류별 파일 압축 중입니다.';
	            				               }
	            				               else if(taskNum == 4)taskName = 'TAR 압축 중입니다.';
	            				               else if(taskNum == 5)taskName = 'Excel파일 업로드 중입니다.';
	            				               else taskName = "";
	            				               if(file1!=""){
	            				            	   if(totalProcessed == 0 && totalSize==0)document.getElementById("proTitle").innerHTML = "영상 파일 업로드 중입니다" + dProcess;
	            				            	   else document.getElementById("proTitle").innerHTML = taskName + dProcess;
	            				               }else if(file1=="" && file2!="")document.getElementById("proTitle").innerHTML = "Excel 파일 업로드 중입니다";
	            				               setTimeout(calculation(totalProcessed, totalSize, zipTotal, zipTotalProcessed, taskNum), 10);
	            				            }
	            				         });
	            				      }else{
	            				         // stop the TaskRunner when the 'getProgressBoo' is false
	            				         runner.stop(task);
	            				      }
	            				 },
	            				 interval: 100 // monitor the progress every 200 milliseconds
	            		};
	            		 // start the TaskRunner
            			var runner = new Ext.util.TaskRunner();
            			runner.start(task);
	            		ufp.submit({
		                	url: GLOBAL_CONTEXT_PATH + '/medical/imagingInfo/imagingFileUpload.do',
		                	params :{
					               taskIdentity: taskId,   // use the same taskId which was used while submitting task
					               rndId: loginRndId,
			                		disClassDtl: menuDisClassDtl,
			                		fileClassDtl: 'FIL04'
					            },
				            timeout : 100000000,
		                	progress: function(action, progress, event) {
		                    	var p = event.loaded / event.total;
		                    	var loaded = Math.round(event.loaded / 1024 / 1024);
		                    	var total = Math.round(event.total / 1024 / 1024);
		                    	if(p == 1){
		                    		Ext.Msg.updateProgress(p, Math.round(100 * p) + '% (' + loaded + '/' + total + 'MB) 잠시만 기다려주세요...');
		                    	}else{
		                    		Ext.Msg.updateProgress(p, Math.round(100 * p) + '% (' + loaded + '/' + total + 'MB) 복사중...');
		                    	}
		                    },
                            success: function(response, opts){
                            	Ext.MessageBox.hide();   // hide the progress bar
                    			getProgressBoo=false;  // no need to check progress now
							    var obj = Ext.decode(response.responseText);
							    Ext.Msg.show({
							    	title: '알림',
							    	msg: '파일 업로드를 성공하였습니다.', 
							    	buttons: Ext.Msg.OK,
							    	fn: function(btn, text) {
							    		if (btn == 'ok') {
							    			Ext.getCmp('ImagingUpload').close();
							    			location.reload();
							    		}
							    	}
							    });
                              },
                              failure : function(response, opts) {
                            	  Ext.MessageBox.hide();
                            	  getProgressBoo=false;
                              	var json = Ext.util.JSON.decode(opts.response.responseText);
                                  Ext.Msg.alert('알림', '<b>' + json.message + '</b>');
                              },
                              callback : function() {
                              }
		                });
		            } //handler end
		        },{
					text: '취소',
					handler: function(){
						Ext.getCmp('ImagingUpload').close();
					}
				}]
			})
		]
	});
};
Ext.extend(ImagingUpload.PopUpWin, Ext.Window, {
});
function fileUpload(){
	var imagingPopup = new ImagingUpload.PopUpWin();
	imagingPopup.show(this);
}
function openSearchPop() {
	$('.searchbox').show();
}
//팝업 닫기
function closeSearchPop() {
	$('.searchbox').hide();
}

function selectDelete() {
	var s = sm.getSelection();
	var targetIdList = [];
	var performCntList = [];
	if (s < 1) {
		Ext.Msg.alert('알림', '데이터를 선택해주세요.');
		return false;
	}
	Ext.each(s, function(rec) {
		 targetIdList.push(rec.get('targetId'));
		 performCntList.push(rec.get('performCnt'));
	});

	var params = {
			 targetIdList : targetIdList,
			 performCntList : performCntList,
			 loginRndId : loginRndId
			 };
	Ext.MessageBox.show({
		title : '알림',
		msg : '정말 삭제하시겠습니까?',
		buttons : Ext.MessageBox.OKCANCEL,
		fn : function(btn) {
			if (btn == 'ok') {
				/*Ext.MessageBox.show({
	     		       msg: '<p style="text-align:center"><br/>삭제 중입니다..</p>',
	     		       progressText: '잠시만 기다려주세요..',
	     		       width:300,
	     		       wait:true,
	     		       waitConfig: {interval:200},
	     		   });*/

				Ext.Ajax.request({
					url : makeUrl('/medical/imagingInfo/deleteImaging.do'),
					params : params,
					method : 'POST',
					timeout : 100000000,
					success : function(resp, opts) {
						var obj = Ext.decode(resp.responseText);
						if (obj.success) {
	        	            Ext.MessageBox.hide();
	        	            Ext.Msg.alert("알림","삭제되었습니다.");
	        	            doSearch();
	        	        }
					}
				});
			}
		}
	});
	
}
function createElement(name, value){
	var field = document.createElement("input");
	field.setAttribute("type", "hidden");
	field.setAttribute("name", name);
	field.setAttribute("value", value);
	return field;
}

function excelDownload() {
	
	
	if (imagingListStore.getCount() == 0) {
	Ext.Msg.alert('Warning', '결과자료가 없습니다.');
	return false;
	}
	
	var s = sm.getSelection();
	
	//선택 다운로드
	if (s.length > 0) {
		var form = document.createElement("form");
		form.setAttribute("charset", "UTF-8");
	    form.setAttribute("method", "Post");  //Post 방식
	    form.setAttribute("action", GLOBAL_CONTEXT_PATH+'/medical/imagingInfo/imagingSelectExcelDownload.do'); //요청 보낼 주소
	    form.appendChild(createElement("rndId",loginRndId));
	    form.appendChild(createElement("disClassDtl",menuDisClassDtl));

	    //form에 전달할 데이터 셋팅
	    Ext.each(s, function(rec) {
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
		document.location.href = makeUrl('/medical/imagingInfo/imagingExcelDownload.do',searchParams);
		
	}
	  
}

function uploadExcelDownload() {

	location.href = GLOBAL_CONTEXT_PATH + '/downFile.view?dir=file.sample.dir&fileName=AsdImagingInfoUpload.xlsx';
}



