var pageSize =  parameter['pageSize'];
var analysisListGrid;
var activePage = parameter['activePage'];
var sm = new Ext.selection.CheckboxModel({headerWidth:40});
var analysisStore;
var chgColumn =[];
var analysisTitle = "";
var searchParams={};
var searchPageParams={};
var pageParams ={};
var chgTabNm = pageLoad.getParameter('chgTabNm');
var chgTargetId = pageLoad.getParameter('targetId');
var chgPerformCnt = pageLoad.getParameter('performCnt');


analysisListGrid = function() {

			Ext.create("Ext.panel.Panel", {
				// 'resizable-panel',
				height : '760px',
				region : 'center',
				layout : 'border',
				renderTo : 'ContentsDiv',
				border : false,
				items : [ {
					xtype : 'grid',
					id : 'analysisList-grid',
					region : 'center',
					enableLocking: true,
					autoExpandColumn : 'subject',
					store : analysisStore,
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
			        	id: 'analysisList-grid-page',
			            pageSize: pageSize,
			            store: analysisStore,
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
						celldblclick : function(view, cell, cellIndex, record,row, rowIndex, e) {
							var clickedDataIndex = view.panel.headerCt.getHeaderAtIndex(cellIndex).dataIndex;
							var clickedColumnName = view.panel.headerCt.getHeaderAtIndex(cellIndex).text;
							var clickedCellValue = record.get(clickedDataIndex);
							var tabName =['K-SADS','ATA','STROOP','CCTT','WCST','CAT','EXIT-II','CPT-3','TMT'];
							
							//연구번호 클릭 시 데이터 통합 분석 상세로 이동
							/*if(clickedDataIndex == "targetId"){
								var targetId = clickedCellValue;
								var url = GLOBAL_CONTEXT_PATH + '/medical/dataIntegration/dataIntegrationDtl.view';
								location.href = url+"?targetId="+targetId;
							}*/
							if(clickedCellValue=="o"){
								var targetId = record.get('targetId');
								var performCnt = record.get('performCnt');
								
								//클릭한 열의 탭으로 이동
								searchPageParams.targetId = targetId;
								searchPageParams.performCnt = performCnt;
								searchPageParams.schKeyWord="schTargetId";
								searchPageParams.rndId=loginRndId;
								searchPageParams.disClassDtl = menuDisClassDtl;
								searchPageParams.limit=analysisStore.getPageSize();
								searchPageParams.docNm = clickedColumnName;
								moveTabPage(clickedColumnName);
								/*for(var i in tabName){
									if(tabName[i]==clickedColumnName){
										//클릭한 열의 탭으로 이동
										gridChg(tabName[clickedColumnName]);
										break;
									}
								}*/
							}								
						}
					}
				}]
				
			});
	
	
}

Ext.onReady(function() {
	Ext.QuickTips.init();	
		
	
	//왼쪽메뉴 선택
	parent.leftMenuChgByUrl(window.location.href);
	
	analysisStore =  Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : false,
		pageSize : pageSize,
		proxy : {
			type : 'ajax',
			async : false,
			extraParams : { docClassDtl : 'DC003', disClassDtl : menuDisClassDtl},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/analysis/selectAnalysisList.do',
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
	
	var tabList=[];
	var analysisMenuStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		proxy : {
			type : 'ajax',
			async : false,
			extraParams : { docClassDtl : 'DC003', disClassDtl : menuDisClassDtl},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/analysis/selectAnalysisMenuList.do',
			reader : {
				type : 'json',
				root : 'result'
			}

		},
		listeners : {
			load : function() {
					for(var i=0; i<analysisMenuStore.getTotalCount(); i++){
						var docNm=analysisMenuStore.data.items[i].data.docNm;
						var docId=analysisMenuStore.data.items[i].data.docId;
						$(".submenu").append('<button type="button" class="menuBtn" onClick="gridChg(\''+docNm+'\');">'+docNm+'</button>');
						
					}
			}
		}
	});		
	new analysisListGrid();
	
	
	//타이틀에 마우스 오버시 2뎁스 노출
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

    //버튼 클릭시 2뎁스 타이틀
    $('.submenu').find('.menuBtn').on('click', function(){
        var btnText = $(this).text();
        $('h3.tit').addClass('on').html(btnText);
    });
    
    //메뉴이름 클릭 시 total로 이동
    $('h2.tit').on('click', function(){
    	$('h3.tit').removeClass('on');
    	gridChg('Total');
    });
    
    //데이터 통합 분석에서 이동한 경우
    if(chgTabNm != ''){
    	
    	//해당탭으로 이동
    	searchPageParams.targetId = chgTargetId;
    	searchPageParams.performCnt = chgPerformCnt;
		searchPageParams.schKeyWord="schTargetId";
		searchPageParams.rndId=loginRndId;
		searchPageParams.limit=analysisStore.getPageSize();
		searchPageParams.disClassDtl = menuDisClassDtl;
		searchPageParams.docNm = chgTabNm;
		moveTabPage(chgTabNm);
		
    }else{
    	//total화면으로 이동
    	gridChg('Total');
    }
    
});


//검색 팝업 열기
function openSearchPop(){
    $('.searchbox').show();
}
//팝업 닫기
function closeSearchPop(){
    $('.searchbox').hide();
}

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
	
	var envMatt = document.getElementsByName("analEnvMatt")[0].checked;
	var gen = document.getElementsByName("analGen")[0].checked;
	var snp = document.getElementsByName("analSnp")[0].checked;
	
	searchParams = {
			rndId : loginRndId,
			targetId : document.getElementById("targetId").value,
			startAge : document.getElementById("startAge").value,
			endAge : document.getElementById("endAge").value,
			sex : checkSex,
			protocol : checkPro,
			//performCnt : document.getElementById("performCnt").value,
			analEnvMatt : envMatt?'Y':'N',
			analGen : gen?'Y':'N',
			analSnp : snp?'Y':'N',
			disClassDtl : menuDisClassDtl
			}
	pageParams = {
			start : 0,
			limit : pageSize
		};
	gridChg(analysisTitle);
}

function gridChg(title,pageNum,rNum){
	
	searchParams.disClassDtl = menuDisClassDtl;
	if(title == "Total"){
		analysisTitle = "Total";
		chgColumn = columnTotal;
		searchParams.docNm = 'Total';
	}else if(title == "PHTs 3종 및 COT(소변)"){ 
		analysisTitle = "PHTs 3종 및 COT(소변)";
		chgColumn = columnEnvMatt;
		searchParams.docNm = `PHTs 3종 및 COT(소변)`;
	}else if(title == "중금속(혈액)"){ 
		analysisTitle = '중금속(혈액)';
		chgColumn = columnEnvMattBl;
		searchParams.docNm = '중금속(혈액)';
	}
	
	if(title != "Total"){ 
	     $('h3.tit').addClass('on').html(title);
	     
	    //Total 검색조건 hide
		$('.total_search').hide();
		
	}else{
		//Total 검색조건 show
		$('.total_search').show();
		
	}
	
	searchParams.rndId = loginRndId;
	analysisStore.proxy.url = GLOBAL_CONTEXT_PATH + '/medical/analysis/selectAnalysisList.do';
	analysisStore.proxy.extraParams = searchParams;
	
	if(pageNum != "" && pageNum != undefined){
		analysisStore.currentPage = pageNum;
		analysisStore.load(function(){
			
			sm.select(rNum,true);
			//스크롤 이동
			var x= Ext.getCmp('analysisList-grid').getView().ownerGrid.getScrollX();
			Ext.getCmp('analysisList-grid').getView().ownerGrid.scrollTo(x,rNum*26);
			Ext.MessageBox.hide();
		});
	}else{
		analysisStore.load({
			params : pageParams
		});
	}
	
	Ext.getCmp("analysisList-grid").reconfigure(analysisStore, chgColumn);
}
function moveTabPage(title){
	//검색조건 초기화
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
 		url : makeUrl('/medical/analysis/selectAnalysisPage.do'),
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
function createElement(name, value){
	var field = document.createElement("input");
	field.setAttribute("type", "hidden");
	field.setAttribute("name", name);
	field.setAttribute("value", value);
	return field;
}

function excelDownload(){
	if(analysisStore.getCount() == 0) {
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
    
    searchParams.docId = analysisTitle;
    searchParams.targetIds = targetIds;
    searchParams.performCnts = performCnts;
    searchParams.disClassDtl = menuDisClassDtl;
    searchParams.rndId = loginRndId;
    document.location.href = makeUrl('/medical/analysis/analysisExcelList.do', searchParams);
    
}

function uploadExcelDownload() {
	
	location.href = GLOBAL_CONTEXT_PATH + '/downFile.view?dir=file.sample.dir&fileName=AsdEvanalysisUpload.xlsx';
}

function excelUpload(){
	var excelDataUploadPanel = new ExcelDataUploadPanel();
	excelDataUploadPanel.show();
}

/*데이터업로드(엑셀)*/
ExcelDataUploadPanel = function(){
	ExcelDataUploadPanel.superclass.constructor.call(this, {
		id: 'ExcelDataFile-upload',
		closeAction: 'destroy',
		title: '분석 데이터 업로드',
		titleAlign: 'center',
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
		        	//allowBlank: false,
      				//inputType: 'file',
					id: 'excelUploadFile',
					name: 'excelUploadFile',
					fieldLabel: '원본 파일',
					//blankText: '원본 파일',
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
		        	//allowBlank: false,
      				//inputType: 'file',
					id: 'uploadZipFile',
					name: 'uploadZipFile',
					fieldLabel: '관리 파일 ',
					//blankText: '관리 파일',
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
		            		 Ext.MessageBox.show({
		            		       msg: '데이터 업로드 중..',
		            		       progressText: '잠시만 기다려주세요..',
		            		       width:300,
		            		       wait:true,
		            		       waitConfig: {interval:200},
		            		       icon:'ext-mb-download', 
		            		       animEl: 'buttonID'
		            		   });
		            		 var  url = GLOBAL_CONTEXT_PATH + '/medical/analysis/analysisFileUpload.do';
		            		ufp.submit({
			                	url: url,
			                	params :{
			                		rndId: loginRndId,
			                		disClassDtl: menuDisClassDtl,
			                		fileClassDtl: 'FIL02'
			                	},
	                            success: function(response, opts){
	                            	  Ext.MessageBox.hide();
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


function selectDeleteAnalysis(){
	var targetIdList = [];
	var performCntList = [];
	var performNmList = [];
	var s = sm.getSelection();
	 if (s < 1) {
		Ext.Msg.alert('알림', '데이터를 선택해주세요.');
		return false;
		}
	 Ext.each(s, function(rec) {
		 targetIdList.push(rec.get('targetId'));
		 performCntList.push(rec.get('performCnt'));
		 performNmList.push(rec.get('performCntNm'));
	 });
	 
	 var params = {
			 targetIdList : targetIdList,
			 performCntList : performCntList,
			 performNmList : performNmList,
			 docNm : analysisTitle
			 };
	 Ext.MessageBox.show({
        title:'알림',
        msg: '정말 삭제하시겠습니까?',
        buttons: Ext.MessageBox.OKCANCEL,
        fn: function(btn){
	        	if(btn == 'ok'){
	        		Ext.MessageBox.show({
	     		       msg: '<p style="text-align:center"><br/>삭제 중입니다..</p>',
	     		       progressText: '잠시만 기다려주세요..',
	     		       width:300,
	     		       wait:true,
	     		       waitConfig: {interval:200},
	     		   });
	        		Ext.Ajax.request({
	        	 		url : makeUrl('/medical/analysis/deleteAnalysis.do'),
	        	 		params : params,
	        	 	    method : 'POST',
	        	 	    timeout : 100000000,
	        	        success : function(response, opts) {
	        	        	var obj = Ext.decode(response.responseText);
	        	            if (obj.success) {
	        	            	Ext.MessageBox.hide();
	        	            	Ext.Msg.alert("알림","삭제되었습니다.");
	        	            	analysisStore.load();
	        	            	//doSearch();
	        	            }
	        	        }
	        	 	});
	        	}
        }
    });
}


//Grid column 

var columnTotal =[{ 	
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
						columns : [{ 	
					dataIndex : 'targetId',
					header : '뇌원천 연구번호',
					tooltip : '뇌원천 연구번호',
					flex : 8/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
					},{ 	
					dataIndex : 'targetDisId',
					header : '뇌질환 연구번호',
					tooltip : '뇌질환 연구번호',
					flex : 8/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false,
					
					}]
					},{
					dataIndex : 'sex',
					header : '성별',
					tooltip : '성별',
					width: 80,
					//flex : 4/100,
					locked : true,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
					},{
					dataIndex : 'performCntNm',
					header : '차수',
					tooltip : '차수',
					width: 80,
					//flex : 4/100,
					locked : true,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
					},{
					dataIndex : 'age',
					header : '나이',
					tooltip : '나이',
					width: 80,
					//flex : 4/100,
					locked : true,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
					},{
					dataIndex : 'execDate',
					header : '실시일',
					tooltip : '실시일',
					width: 100,
					//flex : 8/100,
					locked : true,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false 
					},{
	dataIndex : 'analEnvMatt',
	header : 'PHTs 3종 및 COT(소변)',
	tooltip : 'PHTs 3종 및 COT(소변)',
	flex : 19/100,
	align : 'center',
	style: 'padding:10px;',
	menuDisabled : true,
	sortable: false 
},{
	dataIndex : 'analEnvMattBl',
	header : '중금속(혈액)',
	tooltip : '중금속(혈액)',
	flex : 19/100,
	align : 'center',
	style: 'padding:10px;',
	menuDisabled : true,
	sortable: false 
}];

//Total column END

//환경물질분석  PHTs 3종 및 COT(소변)
var columnEnvMatt = [{ 	
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
	columns : [{ 	
			dataIndex : 'targetId',
			header : '뇌원천 연구번호',
			tooltip : '뇌원천 연구번호',
			flex : 8/100,
			align : 'center',
			style: 'padding:10px;',
			menuDisabled : true,
			sortable: false,
			renderer : function(value,metadata,record,rowIndex,colIndex,view ){
				metadata.tdCls = 'btn';
				return value;
			}
			},{ 	
			dataIndex : 'targetDisId',
			header : '뇌질환 연구번호',
			tooltip : '뇌질환 연구번호',
			flex : 8/100,
			align : 'center',
			style: 'padding:10px;',
			menuDisabled : true,
			sortable: false,
			
			}]
			},{
			dataIndex : 'sex',
			header : '성별',
			tooltip : '성별',
			width: 80,
			//flex : 4/100,
			locked : true,
			align : 'center',
			style: 'padding:10px;',
			menuDisabled : true,
			sortable: false
			},{
			dataIndex : 'performCntNm',
			header : '차수',
			tooltip : '차수',
			width: 80,
			//flex : 4/100,
			locked : true,
			align : 'center',
			style: 'padding:10px;',
			menuDisabled : true,
			sortable: false
			},{
			dataIndex : 'age',
			header : '나이',
			tooltip : '나이',
			width: 80,
			//flex : 4/100,
			locked : true,
			align : 'center',
			style: 'padding:10px;',
			menuDisabled : true,
			sortable: false
			},{
				dataIndex : 'collectDate',
				header : '채취일',
				tooltip: '채취일',
				width: 100,
			//flex : 8/100,
			locked : true,
			align : 'center',
			style: 'padding:10px;',
			menuDisabled : true,
			sortable: false 
			},{
				dataIndex : 'analDate',
				header : '결과보고일',
				tooltip: '결과보고일',
				locked : true,
				align : 'center',
				style: 'padding:10px;',
				menuDisabled : true,
				sortable: false 
			},{
				text : "PHTs 3종 및 COT(소변)",
				tooltip : "PHTs 3종 및 COT(소변)",
				menuDisabled : true,
				columns : [{
					text: 'Creatinine </br></br>',
					tooltip: 'Creatinine',
					menuDisabled : true,
					columns : [{
						dataIndex: 'creatinine',
						header : '분석값 </br> (g/L)',
						tooltip : '분석값 </br> (g/L)',
						width : 120,
		
						align : 'center',
						menuDisabled : true,
						sortable : false,
					}]
		
	},{
		text : 'COT </br> (MDL : 0.149 ug/L)',
		tooltip : 'COT </br> (MDL : 0.149 ug/L)',
		menuDisabled : true,
		columns : [{
			dataIndex: 'cot',
			header : '분석값 </br> (ug/L)',
			tooltip : '분석값 </br> (ug/L)',
			width : 60,
			align : 'center',
			menuDisabled : true,
			sortable : false,
		},{
			dataIndex: 'cotCreatinine',
			header : '분석값 </br> (ug/g creatinine)',
			tooltip : '분석값 </br> (ug/g creatinine)',
			width : 60,
			align : 'center',
			menuDisabled : true,
			sortable : false,
		}]
	},{
		text : 'MEHHP </br> (MDL : 0.009 ug/L)',
		tooltip: 'MEHHP </br> (MDL : 0.009 ug/L)',
		menuDisabled : true,
		columns : [{
			dataIndex: 'mehhp',
			header : '분석값 </br> (ug/L)',
			tooltip : '분석값 </br> (ug/L)',
			width : 60,
			align : 'center',
			menuDisabled : true,
			sortable : false,
		},{
			dataIndex: 'mehhpCreatinine',
			header : '분석값 </br> (ug/g creatinine)',
			tooltip : '분석값 </br> (ug/g creatinine)',
			width : 60,
			align : 'center',
			menuDisabled : true,
			sortable : false,
		}]
		
	},{
		text : 'MEOHP </br> (MDL : 0.008 ug/L)',
		tooltip: 'MEOHP </br> (MDL : 0.008 ug/L)',
		menuDisabled : true,
		columns : [{
			dataIndex: 'meohp',
			header : '분석값 </br> (ug/L)',
			tooltip : '분석값 </br> (ug/L)',
			width : 60,
			align : 'center',
			menuDisabled : true,
			sortable : false,
		},{
			dataIndex: 'meohpCreatinine',
			header : '분석값 </br> (ug/g creatinine)',
			tooltip : '분석값 </br> (ug/g creatinine)',
			width : 60,
			align : 'center',
			menuDisabled : true,
			sortable : false,
		}]
	},{
		text : 'MnBP </br> (MDL : 0.146 ug/L)',
		tooltip: 'MnBP </br> (MDL : 0.146 ug/L)',
		menuDisabled : true,
		columns : [{
			dataIndex: 'mnbp',
			header : '분석값 </br> (ug/L)',
			tooltip : '분석값 </br> (ug/L)',
			width : 60,
			align : 'center',
			menuDisabled : true,
			sortable : false,
		},{
			dataIndex: 'mnbpCreatinine',
			header : '분석값 </br> (ug/g creatinine)',
			tooltip : '분석값 </br> (ug/g creatinine)',
			width : 60,
			align : 'center',
			menuDisabled : true,
			sortable : false,
		}]
	},{
		text : '3-PBA </br> (MDL : 0.013 ug/L)',
		tooltip: '3-PBA </br> (MDL : 0.013 ug/L)',
		menuDisabled : true,
		columns : [{
			dataIndex: 'threePba',
			header : '분석값 </br> (ug/L)',
			tooltip : '분석값 </br> (ug/L)',
			width : 60,
			align : 'center',
			menuDisabled : true,
			sortable : false,
		},{
			dataIndex: 'threePbaCreatinine',
			header : '분석값 </br> (ug/g creatinine)',
			tooltip : '분석값 </br> (ug/g creatinine)',
			width : 60,
			align : 'center',
			menuDisabled : true,
			sortable : false,
		}]
	}]
}];
//환경물질분석 End





//환경물질분석  PHTs 3종 및 COT(소변)
var columnEnvMattBl = [{ 	
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
				columns : [{ 	
			dataIndex : 'targetId',
			header : '뇌원천 연구번호',
			tooltip : '뇌원천 연구번호',
			flex : 8/100,
			align : 'center',
			style: 'padding:10px;',
			menuDisabled : true,
			sortable: false,
			renderer : function(value,metadata,record,rowIndex,colIndex,view ){
				metadata.tdCls = 'btn';
				return value;
			}
			},{ 	
			dataIndex : 'targetDisId',
			header : '뇌질환 연구번호',
			tooltip : '뇌질환 연구번호',
			flex : 8/100,
			align : 'center',
			style: 'padding:10px;',
			menuDisabled : true,
			sortable: false,
			
			}]
			},{
			dataIndex : 'sex',
			header : '성별',
			tooltip : '성별',
			width: 80,
			//flex : 4/100,
			locked : true,
			align : 'center',
			style: 'padding:10px;',
			menuDisabled : true,
			sortable: false
			},{
			dataIndex : 'performCntNm',
			header : '차수',
			tooltip : '차수',
			width: 80,
			//flex : 4/100,
			locked : true,
			align : 'center',
			style: 'padding:10px;',
			menuDisabled : true,
			sortable: false
			},{
			dataIndex : 'age',
			header : '나이',
			tooltip : '나이',
			width: 80,
			//flex : 4/100,
			locked : true,
			align : 'center',
			style: 'padding:10px;',
			menuDisabled : true,
			sortable: false
			},{
				text : '중금속(혈액)',
				tooltip : '중금속(혈액)',
				menuDisabled : true,
				columns : [{
						dataIndex: 'bloodCollectDate',
						header : '채취일',
						tooltip : '채취일',
						width : 100,
						align : 'center',
						menuDisabled : true,
						sortable : false,
					},{
						dataIndex: 'tube',
						header : '튜브',
						tooltip : '튜브',
						width : 100,
						align : 'center',
						menuDisabled : true,
						sortable : false,
					},{
						dataIndex: 'metalAnalDate',
						header : '결과보고일',
						tooltip : '결과보고일',
						width :100,
						align : 'center',
						menuDisabled : true,
						sortable : false,
					},{
					text : 'B_Mn </br> (MDL 0.07ug/L)',
					columns : [{
						dataIndex: 'BMn',
						header : '분석값 </br> (ug/L)',
						tooltip : '분석값 </br> (ug/L)',
						width : 60,
						align : 'center',
						menuDisabled : true,
						sortable : false,
					}]
				},{
					text : 'B_Cd </br> (MDL 0.10ug/L)',
					columns : [{
						dataIndex: 'BCd',
						header : '분석값 </br> (ug/L)',
						tooltip : '분석값 </br> (ug/L)',
						width : 60,
						align : 'center',
						menuDisabled : true,
						sortable : false,
					}]
				},{
					text : 'B_Pb </br> (MDL 0.18ug/L)',
					columns : [{
						dataIndex: 'BPb',
						header : '분석값 </br> (ug/L)',
						tooltip : '분석값 </br> (ug/L)',
						width : 60,
						align : 'center',
						menuDisabled : true,
						sortable : false,
					}]
				}]
			}];







//columnSnp = [{
//	dataIndex : 'targetId',
//	header : '뇌원천<br/>연구번호',
//	tooltip: '뇌원천<br/>연구번호',
//	width: 80,
//	align : 'center',
//	locked : true,
//	menuDisabled : true,
//	sortable: false,
//	renderer : function(value,metadata,record,rowIndex,colIndex,view ){
//		metadata.tdCls = 'btn';
//		return value;
//	}
//},{ 	
//	dataIndex : 'targetDisId',
//	header : '뇌질환<br/>연구번호',
//	tooltip: '뇌질환<br/>연구번호',
//	width: 80,
//	align : 'center',
//	locked : true,
//	menuDisabled : true,
//	sortable: false,
//	renderer : function(value,metadata,record,rowIndex,colIndex,view ){
//		metadata.tdCls = 'btn';
//		return value;
//	}
//},{
//	dataIndex : 'sex',
//	header : '성별',
//	tooltip: '성별',
//	width: 80,
//	align : 'center',
//	locked : true,
//	menuDisabled : true,
//	sortable: false
//},{
//	dataIndex : 'protocol',
//	header : '프로토콜',
//	tooltip: '프로토콜',
//	width: 100,
//	align : 'center',
//	locked : true,
//	menuDisabled : true,
//	sortable: false
//},{
//	dataIndex : 'age',
//	header : '나이',
//	tooltip: '나이',
//	width: 80,
//	locked : true,
//	align : 'center',
//	menuDisabled : true,
//	sortable: false
//},{
//	dataIndex : 'collectDate',
//	header : '채취일',
//	tooltip: '채취일',
//	width: 100,
//	align : 'center',
//	menuDisabled : true,
//	sortable: false
//},{
//	dataIndex : 'analDate',
//	header : '분석일',
//	tooltip: '분석일',
//	width: 100,
//	align : 'center',
//	menuDisabled : true,
//	sortable: false
//},{
//	text : "OXTR(SNP분석)",
//	menuDisabled : true,
//	tooltip : "OXTR(SNP분석)",
//	columns : [{
//		dataIndex : 'rs2254298',
//		header : 'rs2254298 </br> G>A',
//		tooltip: 'rs2254298 </br> G>A',
//		width: 80,
//		align : 'center',
//		menuDisabled : true,
//		sortable: false
//	},{
//		dataIndex : 'rs53576',
//		header : 'rs53576 </br> A>G/A',
//		tooltip: 'rs53576 </br> A>G/A',
//		width: 80,
//		align : 'center',
//		menuDisabled : true,
//		sortable: false
//	}]
//	
//},{
//	text : "CNTNAP2(SNP 분석)",
//	menuDisabled : true,
//	tooltip : "CNTNAP2(SNP 분석)",
//	columns : [{
//		dataIndex : 'rs7794745',
//		header : 'rs7794745 </br> A>T',
//		tooltip: 'rs7794745 </br> A>T',
//		width: 80,
//		align : 'center',
//		menuDisabled : true,
//		sortable: false
//	},{
//		dataIndex : 'rs2710126',
//		header : 'rs2710126 </br> C>T',
//		tooltip: 'rs2710126 </br> C>T',
//		width: 80,
//		align : 'center',
//		menuDisabled : true,
//		sortable: false
//	}]
//},{
//	text : "NRXN1(SNP 분석)",
//	menuDisabled : true,
//	tooltip : "NRXN1(SNP 분석)",
//	columns : [{
//		dataIndex : 'rs1045881',
//		header : 'rs1045881 </br> C>T',
//		tooltip: 'rs1045881 </br> C>T',
//		width: 80,
//		align : 'center',
//		menuDisabled : true,
//		sortable: false
//	},{
//		dataIndex : 'rs858932',
//		header : 'rs858932 </br> C>A, C>G',
//		tooltip: 'rs858932 </br> C>A, C>G',
//		width: 80,
//		align : 'center',
//		menuDisabled : true,
//		sortable: false
//	}]
//}]