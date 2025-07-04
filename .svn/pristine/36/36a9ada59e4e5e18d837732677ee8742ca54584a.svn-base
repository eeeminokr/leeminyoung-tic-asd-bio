var pageSize =  parameter['pageSize'];
var geneListGrid;
var activePage = parameter['activePage'];
var sm = new Ext.selection.CheckboxModel({headerWidth:40});
var geneStore;
var chgColumn =[];
var geneTitle = "";
var searchParams={};
var searchPageParams={};
var pageParams ={};
var chgTabNm = pageLoad.getParameter('chgTabNm');
var chgTargetId = pageLoad.getParameter('targetId');
var chgPerformCnt = pageLoad.getParameter('performCnt');


geneListGrid = function() {

			Ext.create("Ext.panel.Panel", {
				// 'resizable-panel',
				height : '760px',
				region : 'center',
				layout : 'border',
				renderTo : 'ContentsDiv',
				border : false,
				items : [ {
					xtype : 'grid',
					id : 'geneList-grid',
					region : 'center',
					enableLocking: true,
					autoExpandColumn : 'subject',
					store : geneStore,
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
			        	id: 'geneList-grid-page',
			            pageSize: pageSize,
			            store: geneStore,
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
								searchPageParams.limit=geneStore.getPageSize();
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
	
	geneStore =  Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : false,
		pageSize : pageSize,
		proxy : {
			type : 'ajax',
			async : false,
			extraParams : { docClassDtl : 'DC005', disClassDtl : menuDisClassDtl},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/gene/selectGeneList.do',
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
	var geneMenuStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		proxy : {
			type : 'ajax',
			async : false,
			extraParams : { docClassDtl : 'DC005', disClassDtl : menuDisClassDtl},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/gene/selectGeneMenuList.do',
			reader : {
				type : 'json',
				root : 'result'
			}

		},
		listeners : {
			load : function() {
					for(var i=0; i<geneMenuStore.getTotalCount(); i++){
						var docNm=geneMenuStore.data.items[i].data.docNm;
						console.log("docNm-------->:"+docNm)
						var docId=geneMenuStore.data.items[i].data.docId;
						$(".submenu").append('<button type="button" class="menuBtn" onClick=gridChg(\''+docNm+'\');>'+docNm+'</button>');
						
					}
			}
		}
	});		
	new geneListGrid();
	
	
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
		searchPageParams.limit=geneStore.getPageSize();
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
	

	var gen = document.getElementsByName("analGen")[0].checked;

	
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
	gridChg(geneTitle);
}

function gridChg(title,pageNum,rNum){
	
	searchParams.disClassDtl = menuDisClassDtl;
	if(title == "Total"){
		geneTitle = "Total";
		chgColumn = columnTotal;
		searchParams.docNm = 'Total';
	}else if(title == "WGS"){
		geneTitle = "WGS";
		chgColumn = columnGen;
		searchParams.docNm = 'WGS';
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
	geneStore.proxy.url = GLOBAL_CONTEXT_PATH + '/medical/gene/selectGeneList.do';
	geneStore.proxy.extraParams = searchParams;
	
	if(pageNum != "" && pageNum != undefined){
		geneStore.currentPage = pageNum;
		geneStore.load(function(){
			
			sm.select(rNum,true);
			//스크롤 이동
			var x= Ext.getCmp('geneList-grid').getView().ownerGrid.getScrollX();
			Ext.getCmp('geneList-grid').getView().ownerGrid.scrollTo(x,rNum*26);
			Ext.MessageBox.hide();
		});
	}else{
		geneStore.load({
			params : pageParams
		});
	}
	
	Ext.getCmp("geneList-grid").reconfigure(geneStore, chgColumn);
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
 		url : makeUrl('/medical/gene/selectGenePage.do'),
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
	if(geneStore.getCount() == 0) {
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
    
    searchParams.docId = geneTitle;
    searchParams.targetIds = targetIds;
    searchParams.performCnts = performCnts;
    searchParams.disClassDtl = menuDisClassDtl;
    searchParams.rndId = loginRndId;
    document.location.href = makeUrl('/medical/gene/geneExcelList.do', searchParams);
    
}

function uploadExcelDownload() {
	
	location.href = GLOBAL_CONTEXT_PATH + '/downFile.view?dir=file.sample.dir&fileName=AsdgeneUpload.xlsx';
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
		            		 var  url = GLOBAL_CONTEXT_PATH + '/medical/gene/geneFileUpload.do';
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


function selectDeleteGene(){
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
			 docNm : geneTitle
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
	        	 		url : makeUrl('/medical/gene/deleteGene.do'),
	        	 		params : params,
	        	 	    method : 'POST',
	        	 	    timeout : 100000000,
	        	        success : function(response, opts) {
	        	        	var obj = Ext.decode(response.responseText);
	        	            if (obj.success) {
	        	            	Ext.MessageBox.hide();
	        	            	Ext.Msg.alert("알림","삭제되었습니다.");
	        	            	geneStore.load();
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
	dataIndex : 'wgs',
	header : 'WGS',
	tooltip : 'WGS',
	flex : 19/100,
	align : 'center',
	style: 'padding:10px;',
	menuDisabled : true,
	sortable: false 
}];

//Total column END


//유전자 정보
var columnGen = [{ 	
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
	align : 'center',
	menuDisabled : true,
	sortable: false
},{
	dataIndex : 'analDate',
	header : '분석일',
	tooltip: '분석일',
	width: 100,
	align : 'center',
	menuDisabled : true,
	sortable: false
}]
// 유전자정보End

