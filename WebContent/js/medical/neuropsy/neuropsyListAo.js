var pageSize =  parameter['pageSize'];
var developmentalListGrid;
var activePage = parameter['activePage'];
var sm = new Ext.selection.CheckboxModel({headerWidth:40});
var neuropsyStore;
var chgColumn =[];
var neuropsyTitle = "";
var searchParams={};
var searchPageParams={};
var pageParams ={};
var chgTabNm = pageLoad.getParameter('chgTabNm');
var chgTargetId = pageLoad.getParameter('targetId');
var chgPerformCnt = pageLoad.getParameter('performCnt');


developmentalListGrid = function() {

			Ext.create("Ext.panel.Panel", {
				// 'resizable-panel',
				height : '760px',
				region : 'center',
				layout : 'border',
				renderTo : 'ContentsDiv',
				border : false,
				items : [ {
					xtype : 'grid',
					id : 'neuropsyList-grid',
					region : 'center',
					enableLocking: true,
					autoExpandColumn : 'subject',
					store : neuropsyStore,
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
			        	id: 'neuropsyList-grid-page',
			            pageSize: pageSize,
			            store: neuropsyStore,
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
							var tabName =['K-SADS','ATA','STROOP','CCTT','WCST','CAT','EXIT-II','CPT-3','TMT',
								'ADOS1','ADOS2','SMS','PEP','CARS'];
							
							//연구번호 클릭 시 데이터 통합 분석 상세로 이동
							if(clickedDataIndex == "targetId"){
								var targetId = clickedCellValue;
								var url = GLOBAL_CONTEXT_PATH + '/medical/dataIntegration/dataIntegrationDtlAo.view';
								location.href = url+"?targetId="+targetId;
							}
							if(clickedCellValue=="o"){
								var targetId = record.get('targetId');
								var performCnt = record.get('performCnt');

								//클릭한 열의 탭으로 이동
								searchPageParams.targetId = targetId;
								searchPageParams.performCnt = performCnt;
								searchPageParams.schKeyWord="schTargetId";
								searchPageParams.rndId=loginRndId;
								searchPageParams.disClassDtl = menuDisClassDtl;
								searchPageParams.limit=neuropsyStore.getPageSize();
								searchPageParams.docNm = clickedColumnName;
								searchPageParams.docId = tabDocId;
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
	
	neuropsyStore =  Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : false,
		pageSize : pageSize,
		proxy : {
			type : 'ajax',
			async : false,
			extraParams : { docClassDtl : 'DC001', disClassDtl : menuDisClassDtl},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/neuropsy/selectNeuropsyList.do',
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
	var neuropsyMenuStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		proxy : {
			type : 'ajax',
			async : false,
			extraParams : { docClassDtl : 'DC001', disClassDtl : menuDisClassDtl},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/neuropsy/selectNeuropsyMenuList.do',
			reader : {
				type : 'json',
				root : 'result'
			}

		},
		listeners : {
			load : function() {
				
					for(var i=0; i<neuropsyMenuStore.getTotalCount(); i++){
						var disclassdtl = neuropsyMenuStore.data.items[i].data.disClassDtl;
						var docNm=neuropsyMenuStore.data.items[i].data.docNm;
						var docId=neuropsyMenuStore.data.items[i].data.docId;
						if(disclassdtl == "DS003" && docId == "S1001") {
							docNm ="지능검사"
						}
						$(".submenu").append('<button type="button" class="menuBtn" onClick=gridChg(\''+docNm+'\');>'+docNm+'</button>');
						
					}
			}
		}
	});		
	new developmentalListGrid();
	
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
    	console.log(btnText);
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
		searchPageParams.limit=neuropsyStore.getPageSize();
		searchPageParams.disClassDtl = menuDisClassDtl;
		searchPageParams.docNm = chgTabNm;
	//	searchPageParams.docId = chgTabNm2; 
	//	console.log(chgTabNm2+"chgTabNm2");
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
	var s1 = document.getElementsByName("s1")[0].checked;
	var ata = document.getElementsByName("ata")[0].checked;
	var stroop = document.getElementsByName("stroop")[0].checked;
	var cctt = document.getElementsByName("cctt")[0].checked;
	var wsct = document.getElementsByName("wsct")[0].checked;
	var cat = document.getElementsByName("cat")[0].checked;
	var exitii = document.getElementsByName("exitii")[0].checked;
	var cpt3 = document.getElementsByName("cpt3")[0].checked;
	var tmt = document.getElementsByName("tmt")[0].checked;
	var ados1 = document.getElementsByName("ados1")[0].checked;
	var ados2 = document.getElementsByName("ados2")[0].checked;
	var pep = document.getElementsByName("pep")[0].checked;
	var sms = document.getElementsByName("sms")[0].checked;
	var cars = document.getElementsByName("cars")[0].checked;
	
	searchParams = {
			rndId : loginRndId,
			targetId : document.getElementById("targetId").value,
			targetDisId : document.getElementById("targetDisId").value, //뇌질환 id
			startAge : document.getElementById("startAge").value,
			endAge : document.getElementById("endAge").value,
			sex : checkSex,
			protocol : checkPro,
			performCnt : document.getElementById("performCnt").value,
			ata : ata?'Y':'N',
			stroop : stroop?'Y':'N',
			cctt : cctt?'Y':'N',
			wsct : wsct?'Y':'N',
			cat : cat?'Y':'N',
			exitii : exitii?'Y':'N',
			cpt3 : cpt3?'Y':'N',
			tmt : tmt?'Y':'N',
			ados1 : ados1?'Y':'N',		
			ados2 : ados2?'Y':'N',		
			pep : pep?'Y':'N',		
			sms : sms?'Y':'N',
			cars : cars?'Y':'N',
					
			disClassDtl : menuDisClassDtl
			}
	pageParams = {
			start : 0,
			limit : pageSize
		};
	gridChg(neuropsyTitle);
}

function gridChg(title,pageNum,rNum){
	searchParams.disClassDtl = menuDisClassDtl;
	console.log(menuDisClassDtl+": menuDisClassDtl")
	console.log(title+": title")
	if(title == "지능검사"){ 
		Ext.MessageBox.show({
		       msg: '<p style="text-align:center"><br/>조회 중입니다..</p>',
		       progressText: '잠시만 기다려주세요..',
		       width:300,
		       wait:true,
		       waitConfig: {interval:200},
		   });
			
			neuropsyTitle = "K-SADS";
		if(title == "지능검사" && menuDisClassDtl == "DS003")  {
			  s1title ="지능검사";
			
		}else{
			  s1title ="K-SADS";
		}	
		 
		chgColumn = columnS1;
		searchParams.docNm = 'K-SADS';
		searchParams.rndId = loginRndId;
		console.log("!!!!!!!!!!!!!!!!!!")
		neuropsyStore.proxy.url = GLOBAL_CONTEXT_PATH + '/medical/neuropsy/selectNeuropsyList.do';
		neuropsyStore.proxy.extraParams = searchParams;
		if(pageNum != "" && pageNum != undefined){
			//targetId 위치로 이동
			neuropsyStore.currentPage = pageNum;
			neuropsyStore.load(function(){
				
				sm.select(rNum,true);
				//스크롤 이동
				var x= Ext.getCmp('neuropsyList-grid').getView().ownerGrid.getScrollX();
				
				Ext.getCmp('neuropsyList-grid').getView().ownerGrid.scrollTo(x,rNum*26);
			});
		}else{
			neuropsyStore.load({
				params : pageParams
			});
		}
		setTimeout(function(){
			Ext.getCmp("neuropsyList-grid").reconfigure(neuropsyStore, chgColumn);
			 $('h3.tit').addClass('on').html(s1title);
			 $('.total_search').hide();
			Ext.MessageBox.hide();
		}, 1000);
		return false;
	}else if(title == "ATA"){ 
		neuropsyTitle = "ATA";
		chgColumn = columnAta;
		searchParams.docNm = 'ATA';
	}else if(title == "STROOP"){
		neuropsyTitle = "STROOP";
		chgColumn = columnStroop;
		searchParams.docNm = 'STROOP';
	}else if(title == "CCTT"){
		neuropsyTitle = "CCTT";
		chgColumn = columnCctt;
		searchParams.docNm = 'CCTT';
	}else if(title == "WCST"){
		chgColumn = columnWcst;
		neuropsyTitle = "WCST";
		searchParams.docNm = 'WCST';
	}else if(title == "CAT"){
		chgColumn = columnCat;
		neuropsyTitle = "CAT";
		searchParams.docNm = 'CAT';
	}else if(title =="EXIT-II"){
		chgColumn = columnExit;
		neuropsyTitle = "EXIT-II";
		searchParams.docNm = 'EXIT-II';
	}else if(title == "CPT-3"){
		chgColumn = columnCpt;
		neuropsyTitle  = "CPT-3";
		searchParams.docNm = 'CPT-3';
	}else if(title == "TMT"){
		neuropsyTitle = "TMT";
		chgColumn = columnTmt;
		searchParams.docNm = 'TMT';
	}else if(title == "Total"){ 
		neuropsyTitle = "Total";
		chgColumn = columnTotal;
		searchParams.docNm = 'Total';
	}else if(title == "PEP-R"){ 
		neuropsyTitle = "PEP-R";
		chgColumn = columnPep;
		searchParams.docNm = 'PEP-R';
	}else if(title == "ADOS"){ 
		
		
	
		
		neuropsyTitle = "ADOS";
		chgColumn = columnAdos1;
		searchParams.docNm = 'ADOS';
	}else if(title == "ADOS-2"){ 
		
		neuropsyTitle = "ADOS-2";
		chgColumn = columnAdos2;
		searchParams.docNm = 'ADOS-2';
//	}else if(title == "ADOS3"){ 
//		neuropsyTitle = "ADOS3";
//		chgColumn = columnAdos3;
//		searchParams.docNm = 'ADOS3';
	}else if(title == "SMS"){ 
		neuropsyTitle = "SMS";
		chgColumn = columnSms;
		searchParams.docNm = 'SMS';
	}else if(title == "CARS"){ 
		neuropsyTitle = "CARS";
		chgColumn = columnCars;
		searchParams.docNm = 'CARS';
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
	neuropsyStore.proxy.url = GLOBAL_CONTEXT_PATH + '/medical/neuropsy/selectNeuropsyList.do';
	neuropsyStore.proxy.extraParams = searchParams;
	
	if(pageNum != "" && pageNum != undefined){
		neuropsyStore.currentPage = pageNum;
		neuropsyStore.load(function(){
			
			sm.select(rNum,true);
			//스크롤 이동
			var x= Ext.getCmp('neuropsyList-grid').getView().ownerGrid.getScrollX();
			Ext.getCmp('neuropsyList-grid').getView().ownerGrid.scrollTo(x,rNum*26);
			Ext.MessageBox.hide();
		});
	}else{
		neuropsyStore.load({
			params : pageParams
		});
	}
	
	
	Ext.getCmp("neuropsyList-grid").reconfigure(neuropsyStore, chgColumn);
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
 		url : makeUrl('/medical/neuropsy/selectNeuropsyPage.do'),
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
	if(neuropsyStore.getCount() == 0) {
        Ext.Msg.alert('Warning', '결과자료가 없습니다.');
        return false;
    }
	var s = sm.getSelection();

	if (s.length > 0) {
		//선택 다운로드
		 var form = document.createElement("form");
		    form.setAttribute("charset", "UTF-8");
		    form.setAttribute("method", "Post");  //Post 방식
		    form.setAttribute("action", GLOBAL_CONTEXT_PATH+'/medical/neuropsy/neuropsySelectExcelDownload.do'); //요청 보낼 주소
		    
		    form.appendChild(createElement("rndId",loginRndId));
		    form.appendChild(createElement("docNm",neuropsyTitle));
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
		searchParams.docNm = neuropsyTitle;
		searchParams.rndId = loginRndId;
		searchParams.limit=60000;
		document.location.href = makeUrl('/medical/neuropsy/neuropsyExcelDownload.do', searchParams);
	}
	
}

function uploadExcelDownload() {
	location.href = GLOBAL_CONTEXT_PATH + '/downFile.view?dir=file.sample.dir&fileName=AsdNeuropsyDevelopmentUpload.xlsx';
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
		title: '심리/발달검사 데이터 업로드',
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
		            		 var  url = GLOBAL_CONTEXT_PATH + '/medical/neuropsy/neuropsyFileUpload.do';
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


function selectDelete(){
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
			 docNm : neuropsyTitle
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
	        	 		url : makeUrl('/medical/neuropsy/deleteNeuropsy.do'),
	        	 		params : params,
	        	 	    method : 'POST',
	        	 	    timeout : 100000000,
	        	        success : function(response, opts) {
	        	        	var obj = Ext.decode(response.responseText);
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







//------------------------------------------------------------------------------------------------심리검사 컬럼 생성

//Grid column 
//S1 column
var columnS1 =	[{
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
					header : '뇌원천',
					tooltip : '뇌원천 ',
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
					locked : true,
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
					header : '실시일',
					tooltip : '실시일',
					width: 80,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'fsiq',
					header : 'FSIQ',
					tooltip : 'FSIQ',
					locked : true,
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
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
					},{
						text: '환산점수 합',
						tooltip: '환산점수 합',
						sortable: false	,
						menuDisabled : true,
						columns : [{
							dataIndex : 'kwiscivEsadlu',
							header : '언어이해',
							tooltip : '언어이해',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'kwiscivEsadpr',
							header : '지각추론',
							tooltip : '지각추론',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivEsadwr',
							header : '작업기억',
							tooltip : '작업기억',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivEsadps',
							header : '처리속도',
							tooltip : '처리속도',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivEsadalliq',
							header : '전체IQ',
							tooltip : '전체IQ',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '지표점수',
						tooltip: '지표점수',
						sortable: false	,
						menuDisabled : true,
						columns : [{
							dataIndex : 'kwiscivIdxslu',
							header : '언어이해',
							tooltip : '언어이해',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'kwiscivIdxspr',
							header : '지각추론',
							tooltip : '지각추론',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivIdxswr',
							header : '작업기억',
							tooltip : '작업기억',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivIdxsps',
							header : '처리속도',
							tooltip : '처리속도',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivIdxsalliq',
							header : '전체IQ',
							tooltip : '전체IQ',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '백분위',
						tooltip: '백분위',
						sortable: false	,
						menuDisabled : true,
						columns : [{
							dataIndex : 'kwiscivPercntlu',
							header : '언어이해',
							tooltip : '언어이해',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'kwiscivPercntpr',
							header : '지각추론',
							tooltip : '지각추론',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivPercntwr',
							header : '작업기억',
							tooltip : '작업기억',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivPercntps',
							header : '처리속도',
							tooltip : '처리속도',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivPercntalliq',
							header : '전체IQ',
							tooltip : '전체IQ',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '95%신뢰구간',
						tooltip: '95%신뢰구간',
						sortable: false	,
						menuDisabled : true,
						columns : [{
							dataIndex : 'kwiscivConfitvllu',
							header : '언어이해',
							tooltip : '언어이해',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'kwiscivConfitvlpr',
							header : '지각추론',
							tooltip : '지각추론',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivConfitvlwr',
							header : '작업기억',
							tooltip : '작업기억',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivConfitvlps',
							header : '처리속도',
							tooltip : '처리속도',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivConfitvlalliq',
							header : '전체IQ',
							tooltip : '전체IQ',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '질적분류(수준)',
						tooltip: '질적분류(수준)',
						sortable: false	,
						menuDisabled : true,
						columns : [{
							dataIndex : 'kwiscivQdlu',
							header : '언어이해',
							tooltip : '언어이해',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'kwiscivQdpr',
							header : '지각추론',
							tooltip : '지각추론',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivQdwr',
							header : '작업기억',
							tooltip : '작업기억',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivQdps',
							header : '처리속도',
							tooltip : '처리속도',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'kwiscivQdalliq',
							header : '전체IQ',
							tooltip : '전체IQ',
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
						},{
							text: '환산점수 합',
							tooltip: '환산점수 합',
							sortable: false	,
							menuDisabled : true,
							columns : [{
								dataIndex : 'kwisciv2Esadlu',
								header : '언어이해',
								tooltip : '언어이해',
								width : 80,
								//width : 180,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'kwisciv2Esadpr',
								header : '지각추론',
								tooltip : '지각추론',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Esadwr',
								header : '작업기억',
								tooltip : '작업기억',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Esadps',
								header : '처리속도',
								tooltip : '처리속도',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Esadalliq',
								header : '전체IQ',
								tooltip : '전체IQ',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							}]
						},{
							text: '지표점수',
							tooltip: '지표점수',
							sortable: false	,
							menuDisabled : true,
							columns : [{
								dataIndex : 'kwisciv2Idxslu',
								header : '언어이해',
								tooltip : '언어이해',
								width : 80,
								//width : 180,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'kwisciv2Idxspr',
								header : '지각추론',
								tooltip : '지각추론',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Idxswr',
								header : '작업기억',
								tooltip : '작업기억',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Idxsps',
								header : '처리속도',
								tooltip : '처리속도',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Idxsalliq',
								header : '전체IQ',
								tooltip : '전체IQ',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							}]
						},{
							text: '백분위',
							tooltip: '백분위',
							sortable: false	,
							menuDisabled : true,
							columns : [{
								dataIndex : 'kwisciv2Percntlu',
								header : '언어이해',
								tooltip : '언어이해',
								width : 80,
								//width : 180,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'kwisciv2Percntpr',
								header : '지각추론',
								tooltip : '지각추론',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Percntwr',
								header : '작업기억',
								tooltip : '작업기억',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Percntps',
								header : '처리속도',
								tooltip : '처리속도',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Percntalliq',
								header : '전체IQ',
								tooltip : '전체IQ',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							}]
						},{
							text: '95%신뢰구간',
							tooltip: '95%신뢰구간',
							sortable: false	,
							menuDisabled : true,
							columns : [{
								dataIndex : 'kwisciv2Confitvllu',
								header : '언어이해',
								tooltip : '언어이해',
								width : 80,
								//width : 180,
								align : 'center',
								menuDisabled : true,
								sortable: false,
								
							},{
								dataIndex : 'kwisciv2Confitvlpr',
								header : '지각추론',
								tooltip : '지각추론',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Confitvlwr',
								header : '작업기억',
								tooltip : '작업기억',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Confitvlps',
								header : '처리속도',
								tooltip : '처리속도',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							},{
								dataIndex : 'kwisciv2Confitvlalliq',
								header : '전체IQ',
								tooltip : '전체IQ',
								width :80,
								align : 'center',
								menuDisabled : true,
								sortable: false,
							}]
						}]
				   }];

			
//S1 column END

//ATA column
var columnAta =	[{
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
						header : '뇌원천',
						tooltip : '뇌원천 ',
						width: 90,
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
						width: 90,
						locked : true,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
						}]
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip : '성별',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'performCntNm',
						header : '차수',
						tooltip : '차수',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'age',
						header : '나이',
						tooltip : '나이',
						width: 90,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'ataExecDate',
						header : '실시일',
						tooltip : '실시일',
						width: 100,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
					text: 'ATA(시각)',
					tooltip: 'ATA(시각)',
					//enableColumnResize: true,
					//autoSizeColumn: true,
					menuDisabled : true,
					sortable: false,
					columns : [{
						dataIndex : 'atavMissz',
						header : '누락Z',
						tooltip : '누락Z',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'atavFalarmz',
						header : '오경보Z',
						tooltip : '오경보Z',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'atavReactzAvg',
						header : '반응시간<br />평균Z',
						tooltip : '반응시간<br />평균Z',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'atavReactzDev',
						header : '반응시간<br />표준편차Z',
						tooltip : '반응시간<br />표준편차Z',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'atavMisst',
						header : '누락T',
						tooltip : '누락T',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'atavFalarmt',
						header : '오경보T',
						tooltip : '오경보T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'atavReacttAvg',
						header : '반응시간<br />평균T',
						tooltip : '반응시간<br />평균T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'atavReacttDev',
						header : '반응시간<br />표준편차T',
						tooltip : '반응시간<br />표준편차T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: 'ATA(청각)',
					tooltip: 'ATA(청각)',
					columns : [{
						dataIndex : 'atahMissz',
						header : '누락Z',
						tooltip : '누락Z',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'atahFalarmz',
						header : '오경보Z',
						tooltip : '오경보Z',
						width :80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'atahReactzAvg',
						header : '반응시간<br />평균Z',
						tooltip : '반응시간<br />평균Z',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'atahReactzDev',
						header : '반응시간<br />표준편차Z',
						tooltip : '반응시간<br />표준편차Z',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'atahMisst',
						header : '누락T',
						tooltip : '누락T',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'atahFalarmt',
						header : '오경보T',
						tooltip : '오경보T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'atahReacttAvg',
						header : '반응시간<br />평균T',
						tooltip : '반응시간<br />평균T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'atahReacttDev',
						header : '반응시간<br />표준편차T',
						tooltip : '반응시간<br />표준편차T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				}];
//ATA column END				
//STROOP column 
var columnStroop	=	[{
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
						header : '뇌원천',
						tooltip : '뇌원천 ',
						width: 90,
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
						width: 90,
						locked : true,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
						}]
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip : '성별',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'performCntNm',
						header : '차수',
						tooltip : '차수',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'age',
						header : '나이',
						tooltip : '나이',
						width: 90,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'stroopExecDate',
						header : '실시일',
						tooltip : '실시일',
						width: 100,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
					text: 'STROOP',
					tooltip: 'STROOP',
					menuDisabled : true,
					sortable: false,
					flex : 64/100,
					columns : [{
						dataIndex : 'wordR',
						header : '단어R',
						tooltip : '단어R',
						flex : 8/100,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'colorR',
						header : '색상R',
						tooltip : '색상R',
						flex : 8/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'colorwordR',
						header : '색상-단어R',
						tooltip : '색상-단어R',
						flex : 8/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'interferR',
						header : '간섭R',
						tooltip : '간섭R',
						flex : 8/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'wordT',
						header : '단어T',
						tooltip : '단어T',
						flex : 8/100,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'colorT',
						header : '색상T',
						tooltip : '색상T',
						flex : 8/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'colorwordT',
						header : '색상-단어T',
						tooltip : '색상-단어T',
						flex : 8/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'interferT',
						header : '간섭T',
						tooltip : '간섭T',
						flex : 8/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				}];
//STROOP column END				
//CCTT column 	
var columnCctt=   [{
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
					header : '뇌원천',
					tooltip : '뇌원천 ',
					width: 90,
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
					width: 90,
					locked : true,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					}]
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip : '성별',
					locked : true,
					width: 90,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'performCntNm',
					header : '차수',
					tooltip : '차수',
					locked : true,
					width: 90,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip : '나이',
					width: 90,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'ccttExecDate',
					header : '실시일',
					tooltip : '실시일',
					width: 100,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
				    text: 'CCTT-1',
				    tooltip: 'CCTT-1',
				    menuDisabled : true,
				    sortable: false,
				    columns : [{
				       dataIndex : 'cctt1CompleteTime',
				       header : '완성시간',
				       tooltip : '완성시간',
				       width : 80,
				       //width : 180,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				       
				    },{
				       dataIndex : 'cctt1Tpoint',
				       header :'T점',
				       tooltip :'T점',
				       width : 80,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    },{
				       dataIndex : 'cctt1Ile',
				       header : '%ile',
				       tooltip : '%ile',
				       width : 80,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    },{
				       dataIndex : 'cctt1DigseqErr',
				       header : '숫자순서<br />오류',
				       tooltip : '숫자순서<br />오류',
				       width : 80,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    },{
				       dataIndex : 'cctt1ApproxErr',
				       header : '근사오류',
				       tooltip : '근사오류',
				       width : 80,
				       //width : 180,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				       
				    },{
				       dataIndex : 'cctt1Catalist',
				       header : '촉진',
				       tooltip : '촉진',
				       width : 80,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    }]
				 },{
				    text: 'CCTT-2',
				    tooltip: 'CCTT-2',
				    menuDisabled : true,
				    columns : [{
				       dataIndex : 'cctt2CompleteTime',
				       header : '완성시간',
				       tooltip : '완성시간',
				       width : 80,
				       //width : 180,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				       
				    },{
				       dataIndex : 'cctt2Tpoint',
				       header : 'T점',
				       tooltip : 'T점',
				       width :80,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    },{
				       dataIndex : 'cctt2Ile',
				       header : '%ile',
				       tooltip : '%ile',
				       width : 80,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    },{
				       dataIndex : 'cctt2ColseqErr',
				       header : '색순서오류',
				       tooltip : '색순서오류',
				       width : 90,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    },{
				       dataIndex : 'cctt2DigseqErr',
				       header : '숫자순서<br/>오류',
				       tooltip : '숫자순서<br/>오류',
				       width : 80,
				       //width : 180,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				       
				    },{
				       dataIndex : 'cctt2ApproxErr',
				       header : '근사오류',
				       tooltip : '근사오류',
				       width : 80,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    },{
				       dataIndex : 'cctt2Catalist',
				       header : '촉진',
				       tooltip : '촉진',
				       width : 80,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    }]
				 },{
				    text: 'Interference A',
				    tooltip: 'Interference A',
				    menuDisabled : true,
				    columns : [{
				       dataIndex : 'interferARiir',
				       header : '비율간섭<br />지표R',
				       tooltip : '비율간섭<br />지표R',
				       width : 80,
				       //width : 180,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				       
				    },{
				       dataIndex : 'interferAIle',
				       header : '%ile',
				       tooltip : '%ile',
				       width :80,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    }]
				 },{
				    text: 'Interference B',
				    tooltip: 'Interference B',
				    menuDisabled : true,
				    columns : [{
				       dataIndex : 'interferBRiir',
				       header : '차이간섭지표R',
				       tooltip : '차이간섭지표R',
				       width : 110,
				       //width : 180,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				       
				    },{
				       dataIndex : 'interferBTpoint',
				       header : 'T점',
				       tooltip : 'T점',
				       width :80,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    },{
				       dataIndex : 'interferBIle',
				       header : '%ile',
				       tooltip : '%ile',
				       width :80,
				       align : 'center',
				       menuDisabled : true,
				       sortable: false,
				    }]
				 }];
//CCTT column END
//WCST column
var columnWcst =	[{
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
						header : '뇌원천',
						tooltip : '뇌원천 ',
						width: 90,
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
						width: 90,
						locked : true,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
						}]
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip : '성별',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'performCntNm',
						header : '차수',
						tooltip : '차수',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'age',
						header : '나이',
						tooltip : '나이',
						width: 90,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'wsctExecDate',
						header : '실시일',
						tooltip : '실시일',
						width: 100,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						text: 'WCST',
						tooltip: 'WCST',
						menuDisabled : true,
						sortable: false,
						columns : [{
							dataIndex : 'totalErrorsR',
							header : 'Total Errors R',
							tooltip : 'Total Errors R',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'totalErrorsS',
							header :'Total Errors S',
							tooltip :'Total Errors S',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'totalErrorsT',
							header : 'Total Errors T',
							tooltip : 'Total Errors T',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'totalErrorsIle',
							header : 'Total Errors<br />%ile',
							tooltip : 'Total Errors<br />%ile',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'perseverResponT',
							header : 'Perseverative<br />Respon T',
							tooltip : 'Perseverative<br />Respon T',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'perseverErrorT',
							header : 'Perseverative<br />Error T',
							tooltip : 'Perseverative<br />Error T',
							width : 80,
							align : 'center',
							menuDisabled : true,
						},{
							dataIndex : 'nonperseverErrorT',
							header : 'Nonperseverative<br />Error T',
							tooltip : 'Nonperseverative<br />Error T',
							//tooltip: 'Nonperseverative<br />Error T',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'concepResponT',
							header : 'Conceprual<br />level Respon T',
							tooltip : 'Conceprual<br />level Respon T',
							width :80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'categoryCompleteR',
							header : 'Categories<br />Completed R',
							tooltip : 'Categories<br />Completed R',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'trialCompleteR',
							header : 'Trials to<br />complete R',
							tooltip : 'Trials to<br />complete R',
							width : 90,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'failureR',
							header : 'Failure R',
							tooltip : 'Failure R',
							width : 80,
							//width : 180,
							align : 'center',
							menuDisabled : true,
							sortable: false,
							
						},{
							dataIndex : 'ingtoLearn',
							header : 'Learning to<br />Learn',
							tooltip : 'Learning to<br />Learn',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'categoryCompleteIle',
							header : 'Categories<br />Completed<br />%ile',
							tooltip : 'Categories<br />Completed<br />%ile',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'trialCompleteIle',
							header : 'Trials to<br />complete<br />%ile',
							tooltip : 'Trials to<br />complete<br />%ile',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'failureIle',
							header : 'Failure %ile',
							tooltip : 'Failure %ile',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'ingtoLearnIle',
							header : 'Learning to<br />Learn %ile',
							tooltip : 'Learning to<br />Learn %ile',
							width : 80,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					}];
//WCST column END
//CAT column
var columnCat =	[{ 	
					dataIndex : 'targetId',
					header : '뇌원천 연구번호',
					tooltip : '뇌원천 연구번호',
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
					header : '뇌질환 연구번호',
					tooltip : '뇌질환 연구번호',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip : '성별',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip : '프로토콜',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performCntNm',
					header : '차수',
					tooltip : '차수',
					width: 80,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip : '나이',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'catExecDate',
					header : '실시일',
					tooltip : '실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					text: 'CAT(단순선택-시각)',
					tooltip: 'CAT(단순선택-시각)',
					menuDisabled : true,
					sortable: false,
					columns : [{
						dataIndex : 'catvMissr',
						header : '누락 R',
						tooltip : '누락 R',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catvFalarmr',
						header :'오경보 R',
						tooltip :'오경보 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catvReactrAvg',
						header : '정반응 평균 R',
						tooltip : '정반응 평균 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catvReactrDev',
						header : '정반응 표준편차 R',
						tooltip : '정반응 표준편차 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catvMissaq',
						header : '누락 AQ',
						tooltip : '누락 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catvFalarmaq',
						header : '오경보 AQ',
						tooltip : '오경보 AQ',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'catvReactaqAvg',
						header : '정반응 평균 AQ',
						tooltip : '정반응 평균 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catvReactaqDev',
						header : '정반응 표준편차 AQ',
						tooltip : '정반응 표준편차 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					}]
				},{
					text: 'CAT(단순선택-청각)',
					tooltip: 'CAT(단순선택-청각)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'cathMissr',
						header : '누락 R',
						tooltip : '누락 R',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'cathFalarmr',
						header :'오경보 R',
						tooltip :'오경보 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'cathReactrAvg',
						header : '정반응 평균 R',
						tooltip : '정반응 평균 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'cathReactrDev',
						header : '정반응 표중편차 R',
						tooltip : '정반응 표중편차 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'cathMissaq',
						header : '누락 AQ',
						tooltip : '누락 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'cathFalarmaq',
						header : '오경보 AQ',
						tooltip : '오경보 AQ',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'cathReactaqAvg',
						header : '정반응 평균 AQ',
						tooltip : '정반응 평균 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'cathReactaqDev',
						header : '정반응 표준편차 AQ',
						tooltip : '정반응 표준편차 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					}]
				},{
					text: 'CAT(억제지속)',
					tooltip: 'CAT(억제지속)',
					menuDisabled : true,
					sortable: false,
					columns : [{
						dataIndex : 'catcMissr',
						header : '누락 R',
						tooltip : '누락 R',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catcFalarmr',
						header :'오경보 R',
						tooltip :'오경보 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catcReactrAvg',
						header : '정반응 평균 R',
						tooltip : '정반응 평균 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catcReactrDev',
						header : '정반응 표중편차 R',
						tooltip : '정반응 표중편차 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catcMissaq',
						header : '누락 AQ',
						tooltip : '누락 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catcFalarmaq',
						header : '오경보 AQ',
						tooltip : '오경보 AQ',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'catcReactaqAvg',
						header : '정반응 평균 AQ',
						tooltip : '정반응 평균 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catcReactaqDev',
						header : '정반응 표준편차 AQ',
						tooltip : '정반응 표준편차 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					}]
				},{
					text: 'CAT(간섭선택)',
					tooltip: 'CAT(간섭선택)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'catiMissr',
						header : '누락 R',
						tooltip : '누락 R',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catiFalarmr',
						header :'오경보 R',
						tooltip :'오경보 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catiReactrAvg',
						header : '정반응 평균 R',
						tooltip : '정반응 평균 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catiReactrDev',
						header : '정반응 표중편차 R',
						tooltip : '정반응 표중편차 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catiMissaq',
						header : '누락 AQ',
						tooltip : '누락 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catiFalarmaq',
						header : '오경보 AQ',
						tooltip : '오경보 AQ',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'catiReactaqAvg',
						header : '정반응 평균 AQ',
						tooltip : '정반응 평균 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catiReactaqDev',
						header : '정반응 표준편차 AQ',
						tooltip : '정반응 표준편차 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					}]
				},{
					text: 'CAT(분할)',
					tooltip: 'CAT(분할)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'catdMissr',
						header : '누락 R',
						tooltip : '누락 R',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catdFalarmr',
						header :'오경보 R',
						tooltip :'오경보 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catdReactrAvg',
						header : '정반응 평균 R',
						tooltip : '정반응 평균 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catdReactrDev',
						header : '정반응 표중편차 R',
						tooltip : '정반응 표중편차 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catdMissaq',
						header : '누락 AQ',
						tooltip : '누락 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catdFalarmaq',
						header : '오경보 AQ',
						tooltip : '오경보 AQ',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'catdReactaqAvg',
						header : '정반응 평균 AQ',
						tooltip : '정반응 평균 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catdReactaqDev',
						header : '정반응 표준편차 AQ',
						tooltip : '정반응 표준편차 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					}]
				},{
					text: 'CAT(작업기억)',
					tooltip: 'CAT(작업기억)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'catmdReactr',
						header : '순방향<br />정반응 R',
						tooltip : '순방향<br />정반응 R',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catmrReactr',
						header :'역방향<br />정반응 R',
						tooltip :'역방향<br />정반응 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catmdSpacer',
						header : '순방향<br />공간폭 R',
						tooltip : '순방향<br />공간폭 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catmrSpacer',
						header : '역방향<br />공간폭 R',
						tooltip : '역방향<br />공간폭 R',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'catmdReactaq',
						header : '순방향<br />정반응 AQ',
						tooltip : '순방향<br />정반응 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catmrReactaq',
						header : '역방향<br />정반응 AQ',
						tooltip : '역방향<br />정반응 AQ',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'catmdSpaceaq',
						header : '순방향<br />공간폭 AQ',
						tooltip : '순방향<br />공간폭 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'catmrSpaceaq',
						header : '역방향<br />공간폭 AQ',
						tooltip : '역방향<br />공간폭 AQ',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					}]
				}];

//CAT column END

//EXIT-II column
var columnExit =[{
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
						header : '뇌원천',
						tooltip : '뇌원천 ',
						width: 90,
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
						width: 90,
						locked : true,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
						}]
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip : '성별',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'performCntNm',
						header : '차수',
						tooltip : '차수',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'age',
						header : '나이',
						tooltip : '나이',
						width: 90,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiExecDate',
						header : '실시일',
						tooltip : '실시일',
						width: 100,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
					text: 'EXIT-II (스트룹 검사)',
					tooltip: 'EXIT-II (스트룹 검사)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'exitiiStroopStos',
						header : '단순시간<br />원점수',
						tooltip : '단순시간<br />원점수',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'exitiiStroopStt',
						header :'단순시간 T',
						tooltip :'단순시간 T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiStroopSeos',
						header : '단순오류 원점수',
						tooltip : '단순오류 원점수',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiStroopSet',
						header : '단순오류T',
						tooltip : '단순오류T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiStroopItos',
						header : '간섭시간 원점수',
						tooltip : '간섭시간 원점수',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'exitiiStroopItt',
						header : '간섭시간T',
						tooltip : '간섭시간T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					},{
						dataIndex : 'exitiiStroopIeos',
						header : '간섭오류 원점수',
						tooltip : '간섭오류 원점수',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'exitiiStroopIet',
						header : '간섭오류T',
						tooltip : '간섭오류T',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					}]
				},{
					text: 'EXIT-II (단어유창성)',
					tooltip: 'EXIT-II (단어유창성)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'exitiiWordfqRaos',
						header : '정반응 원점수',
						tooltip : '정반응 원점수',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'exitiiWordfqRat',
						header :'정반응T',
						tooltip :'정반응T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiWordfqBaos',
						header : '비어반응 원점수',
						tooltip : '비어반응 원점수',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiWordfqBat',
						header :'비어반응T',
						tooltip :'비어반응T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiWordfqLaos',
						header : '반복반응 원점수',
						tooltip : '반복반응 원점수',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'exitiiWordfqLat',
						header : '반복반응T',
						tooltip : '반복반응T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false
					}]
				},{
					text: 'EXIT-II (도안유창성)',
					tooltip: 'EXIT-II (도안유창성)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'exitiiDesignRaos',
						header : '정반응 원점수',
						tooltip : '정반응 원점수',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'exitiiDesignRat',
						header :'정반응T',
						tooltip :'정반응T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiDesignLaos',
						header : '반복반응 원점수',
						tooltip : '반복반응 원점수',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiDesignLat',
						header : '반복반응T',
						tooltip : '반복반응T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: 'EXIT-II (AVLT)',
					tooltip: 'EXIT-II (AVLT)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'exitiiAvltDmos',
						header : '지연회상 원점수',
						tooltip : '지연회상 원점수',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'exitiiAvltDmt',
						header :'지연회상T',
						tooltip :'지연회상T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiAvltDjos',
						header : '지연재인 원점수',
						tooltip : '지연재인 원점수',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiAvltDjt',
						header : '지연재인T',
						tooltip : '지연재인T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: 'EXIT-II (CFT)',
					tooltip: 'EXIT-II (CFT)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'exitiiCftPos',
						header : '계획성 원점수',
						tooltip : '계획성 원점수',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'exitiiCftPt',
						header :'계획성T',
						tooltip :'계획성T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiCftDos',
						header : '보고그리기 원점수',
						tooltip : '보고그리기 원점수',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiCftDt',
						header : '보고그리기T',
						tooltip : '보고그리기T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: 'EXIT-II (EFQ)',
					tooltip: 'EXIT-II (EFQ)',
					menuDisabled : true,
					columns : [{
						dataIndex : 'exitiiEfqEss',
						header : '환산점수 합',
						tooltip : '환산점수 합',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'exitiiEfqNis',
						header :'지수점수',
						tooltip :'지수점수',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiEfqPercentile',
						header : '백분위',
						tooltip : '백분위',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'exitiiEfqEval',
						header : '평가',
						tooltip : '평가',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				}];

//EXIT-II column END

//CPT-3 column
var columnCpt =	[{
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
						header : '뇌원천',
						tooltip : '뇌원천 ',
						width: 90,
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
						width: 90,
						locked : true,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
						}]
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip : '성별',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'performCntNm',
						header : '차수',
						tooltip : '차수',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'age',
						header : '나이',
						tooltip : '나이',
						width: 90,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'cpt3ExecDate',
						header : '실시일',
						tooltip : '실시일',
						width: 100,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
					text: 'CPT-3',
					tooltip: 'CPT-3',
					sortable: true,
					menuDisabled : true,
					columns : [{
						dataIndex : 'detectT',
						header : 'Detectability T',
						tooltip : 'Detectability T',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'detectGl',
						header :'Detectabilirt<br/>Guideline',
						tooltip :'Detectabilirt<br/>Guideline',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'omissionT',
						header : 'Omissions T',
						tooltip : 'Omissions T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'omissionGl',
						header : 'Omissions Guideline',
						tooltip : 'Omissions Guideline',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'comissionT',
						header : 'Comissions T',
						tooltip : 'Comissions T',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'comissionGl',
						header : 'Comissions<br />Guideline',
						tooltip : 'Comissions<br />Guideline',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'preservT',
						header : 'Perserverations T',
						tooltip : 'Perserverations T',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'preservGl',
						header : ' Perserverations<br />Guideline',
						tooltip : ' Perserverations<br />Guideline',
						width :80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'hrtT',
						header : 'HRT T',
						tooltip : 'HRT T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'hrtGl',
						header : ' HRT Guideline',
						tooltip : ' HRT Guideline',
						width : 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'hrtSdT',
						header : 'HRT SD T',
						tooltip : 'HRT SD T',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'hrtSdGl',
						header : 'HRT SD<br />Guideline',
						tooltip : 'HRT SD<br />Guideline',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'variaT',
						header : 'variability T',
						tooltip : 'variability T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'variaGl',
						header : 'variability<br />Guideline',
						tooltip : 'variability<br />Guideline',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'hrtBct',
						header : 'HRT Block<br />Change T',
						tooltip : 'HRT Block<br />Change T',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'hrtBcg',
						header : 'HRT Block<br />Change<br />Guideline',
						tooltip : 'HRT Block<br />Change<br />Guideline',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'hrtIct',
						header : 'HRT ISI Change T ',
						tooltip : 'HRT ISI Change T ',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'hrtIcg',
						header : 'HRT ISI Change Guideline',
						tooltip : 'HRT ISI Change Guideline',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'responStyle',
						header : 'response style',
						tooltip : 'response style',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				}];

//CPT-3 column END


//TMT column
var columnTmt =	[{
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
						header : '뇌원천',
						tooltip : '뇌원천 ',
						width: 90,
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
						width: 90,
						locked : true,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
						}]
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip : '성별',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'performCntNm',
						header : '차수',
						tooltip : '차수',
						locked : true,
						width: 90,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'age',
						header : '나이',
						tooltip : '나이',
						width: 90,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'tmtExecDate',
						header : '실시일',
						tooltip : '실시일',
						width: 100,
						locked : true,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
					text: 'TMT',
					tooltip: 'TMT',
					menuDisabled : true,
					flex : 65/100,
					columns : [{
						dataIndex : 'tmtArt',
						header : 'TMT-A(RT)',
						tooltip : 'TMT-A(RT)',
						//width : 180,
						flex : 13/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'tmtAError',
						header :'error',
						tooltip :'error',
						align : 'center',
						flex : 13/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'tmtBrt',
						header : 'TMT-B(RT)',
						tooltip : 'TMT-B(RT)',
						align : 'center',
						flex : 13/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'tmtBError',
						header : 'error',
						tooltip : 'error',
						//width : 180,
						align : 'center',
						flex : 13/100,
						menuDisabled : true,
						sortable: false,
						
					}]
				}];

//TMT column END

//Total column
var columnTotal =	[{
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
					dataIndex : 's1',
					header : '지능검사',
					tooltip : '지능검사',
					width: 80,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'ata',
					header : 'ATA',
					tooltip : 'ATA',
					flex : 4/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'stroop',
					header : 'STROOP',
					tooltip : 'STROOP',
					width: 80,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'cctt',
					header : 'CCTT',
					tooltip : 'CCTT',
					flex : 4/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'wsct',
					header : 'WCST',
					tooltip : 'WCST',
					flex : 4/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'cat',
					header : 'CAT',
					tooltip : 'CAT',
					flex : 4/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'exitii',
					header : 'EXIT-II',
					tooltip : 'EXIT-II',
					flex : 4/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'cpt3',
					header : 'CPT-3',
					tooltip : 'CPT-3',
					flex : 4/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'tmt',
					header : 'TMT',
					tooltip : 'TMT',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'ados1',
					header : 'ADOS',
					tooltip : 'ADOS',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'ados2',
					header : 'ADOS-2',
					tooltip : 'ADOS-2',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
					
//				},{
//					dataIndex : 'ados3',
//					header : 'ADOS3',
//					tooltip : 'ADOS3',
//					flex : 4/100,
//					align : 'center',
//					menuDisabled : true,
//					sortable: false
//				},{
				},{
					dataIndex : 'pep',
					header : 'PEP-R',
					tooltip : 'PEP-R',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'sms',
					header : 'SMS',
					tooltip : 'SMS',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'cars',
					header : 'CARS',
					tooltip : 'CARS',
					flex : 4/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				}];

//Total column END

//ADOS1 column
var columnAdos1 =[{
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
					header : '뇌원천',
					tooltip : '뇌원천 ',
					width: 90,
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
					width: 90,
					locked : true,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
					}]
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip : '성별',
					locked : true,
					width: 90,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'performCntNm',
					header : '차수',
					tooltip : '차수',
					locked : true,
					width: 90,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip : '나이',
					width: 90,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'ados1ExecDate',
					header : '실시일',
					tooltip : '실시일',
					width: 100,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'ados1Module',
					header : '모듈',
					tooltip : '모듈',
					width: 100,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					text: 'ADOS',
					tooltip: 'ADOS',
					locked : false,
					menuDisabled : true,
					flex : 50/100,
					columns : [{
						dataIndex : 'ados1Commu',
						header : '언어',
						tooltip : '언어',
						flex : 10/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'socialInteraction',
						header :'사회적 상호작용',
						tooltip :'사회적 상호작용',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'lanSocialInter',
						header : '언어+사회적<br/>상호작용',
						tooltip : '언어+사회적 상호작용',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'ados1Play',
						header : '놀이',
						tooltip : '놀이',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'a1StereoInterest',
						header : '상동행동,<br/>제한된 관심사',
						tooltip : '상동행동,<br/>제한된 관심사',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'ados1Total',
						header : '총점',
						tooltip : '총점',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
						
					}]
				}];
//ADOS1 column END

//ADOS-2 column
var columnAdos2 =[{
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
						header : '뇌원천',
						tooltip : '뇌원천 ',
						width: 90,
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
						width: 90,
						locked : true,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
						}]
					},{
						dataIndex : 'sex',
						header : '성별',
						tooltip : '성별',
						locked : true,
						width: 60,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
					dataIndex : 'performCntNm',
					header : '차수',
					tooltip : '차수',
					locked : true,
					width: 60,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip : '나이',
					locked : true,
					width: 60,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'ados2ExecDate',
					header : '실시일',
					tooltip : '실시일',
					locked : true,
					width: 100,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'ados2Module',
					header : '모듈',
					tooltip : '모듈',
					locked : true,
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'ados2Line',
					header : '구분',
					tooltip : '구분',
					locked : true,
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					text: 'ADOS-2',
					tooltip: 'ADOS-2',
					menuDisabled : true,
					flex : 70/100,
					columns : [{
						dataIndex : 'ados2Commu',
						header : '의사소통',
						tooltip : '의사소통',
						align : 'center',
						flex : 15/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'givtakeSocialInter',
						header : '주고받는<br/> 사회적 상호작용',
						tooltip : '주고받는<br/> 사회적 상호작용',
						align : 'center',
						flex : 20/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'socialAffTotal',
						header : '사회적 정동 총합',
						tooltip : '사회적 정동 총합',
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'restRepetTotal',
						header :'제한적이고<br/>반복적인 행동 총합',
						tooltip :'제한적이고<br/>반복적인 행동 총합',
						align : 'center',
						flex : 20/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'ados2Total',
						header : '전체 총합<br/>(진단점수)',
						tooltip : '전체 총합<br/>(진단점수)',
						align : 'center',
						flex : 20/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'ados2Diagnosis',
						header : '진단',
						tooltip : '진단',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'ados2SymptomLev',
						header : '증상수준',
						tooltip : '증상수준',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'compareScore',
						header : '비교점수',
						tooltip : '비교점수',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
						
					}]
				}];

//ADOS2 column END

//ADOS3 column
/*
var columnAdos3 =[{ 	
					dataIndex : 'targetId',
					header : '뇌원천 연구번호',
					tooltip : '뇌원천 연구번호',
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
					header : '뇌질환 연구번호',
					tooltip : '뇌질환 연구번호',
					width: 100,
					align : 'center',
					locked : true,
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip : '성별',
					flex : 8/100,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip : '프로토콜',
					flex : 10/100,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'performCntNm',
					header : '차수',
					tooltip : '차수',
					flex : 7/100,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip : '나이',
					flex : 7/100,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'ados3ExecDate',
					header : '실시일',
					tooltip : '실시일',
					flex : 8/100,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					text: 'ADOS3',
					tooltip: 'ADOS3',
					menuDisabled : true,
					flex : 50/100,
					columns : [{
						dataIndex : 'communication',
						header : 'Communication',
						tooltip : 'Communication',
						flex : 10/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'recSocialInter',
						header :'Reciprocal<br/>Social Interaction',
						tooltip :'Reciprocal<br/>Social Interaction',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'commuSocialInter',
						header : 'Communication+<br/>Social interaction',
						tooltip : 'Communication+<br/>Social interaction',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'a3StereoInterest',
						header : 'Stereotyped Behaviours and<br/>Restricted Interests',
						tooltip : 'Stereotyped Behaviours and<br/>Restricted Interests',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'ados3Total',
						header : '총점',
						tooltip : '총점',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
						
					}]
				}];

//ADOS3 column END
*/

//PEP column
var columnPep =[{
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
						header : '뇌원천',
						tooltip : '뇌원천 ',
						width: 90,
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
						width: 90,
						locked : true,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
					}]
				},{
						dataIndex : 'sex',
						header : '성별',
						tooltip : '성별',
						locked : true,
						width: 60,
						align : 'center',
						menuDisabled : true,
						sortable: false,
				},{
					dataIndex : 'performCntNm',
					header : '차수',
					tooltip : '차수',
					locked : true,
					width: 60,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip : '나이',
					locked : true,
					width: 60,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'pepExecDate',
					header : '실시일',
					tooltip : '실시일',
					locked : true,
					width: 100,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					text: '행동척도',
					tooltip: '행동척도',
					menuDisabled : true,
					columns : [{
						text: '관계',
						tooltip: '관계',
						menuDisabled : true,
						columns : [{
							dataIndex : 'behavRelN',
							header : '정상',
							tooltip : '정상',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'behavRelM',
							header : '경증',
							tooltip : '경증',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'behavRelS',
							header : '중증',
							tooltip : '중증',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '재료',
						tooltip: '재료',
						menuDisabled : true,
						columns : [{
							dataIndex : 'behavMateN',
							header : '정상',
							tooltip : '정상',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'behavMateM',
							header : '경증',
							tooltip : '경증',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'behavMateS',
							header : '중증',
							tooltip : '중증',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '감각',
						tooltip: '감각',
						menuDisabled : true,
						columns : [{
							dataIndex : 'behavSenseN',
							header : '정상',
							tooltip : '정상',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'behavSenseM',
							header : '경증',
							tooltip : '경증',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'behavSenseS',
							header : '중증',
							tooltip : '중증',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '언어',
						tooltip: '언어',
						menuDisabled : true,
						columns : [{
							dataIndex : 'behavLanN',
							header : '정상',
							tooltip : '정상',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'behavLanM',
							header : '경증',
							tooltip : '경증',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'behavLanS',
							header : '중증',
							tooltip : '중증',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					}]
				},{
					text: '발달척도',
					tooltip: '발달척도',
					menuDisabled : true,
					columns : [{
						text: '모방',
						tooltip: '모방',
						menuDisabled : true,
						columns : [{
							dataIndex : 'devCopyP',
							header : '합격',
							tooltip : '합격',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devCopyB',
							header : '싹트기',
							tooltip : '싹트기',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devCopyF',
							header : '실패',
							tooltip : '실패',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '지각',
						tooltip: '지각',
						menuDisabled : true,
						columns : [{
							dataIndex : 'devPerceptP',
							header : '합격',
							tooltip : '합격',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devPerceptB',
							header : '싹트기',
							tooltip : '싹트기',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devPerceptF',
							header : '실패',
							tooltip : '실패',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '소근육',
						tooltip: '소근육',
						menuDisabled : true,
						columns : [{
							dataIndex : 'devMusclesP',
							header : '합격',
							tooltip : '합격',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devMusclesB',
							header : '싹트기',
							tooltip : '싹트기',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devMusclesF',
							header : '실패',
							tooltip : '실패',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '대근육',
						tooltip: '대근육',
						menuDisabled : true,
						columns : [{
							dataIndex : 'devMusclebP',
							header : '합격',
							tooltip : '합격',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devMusclebB',
							header : '싹트기',
							tooltip : '싹트기',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devMusclebF',
							header : '실패',
							tooltip : '실패',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '눈-손협응',
						tooltip: '눈-손협응',
						menuDisabled : true,
						columns : [{
							dataIndex : 'devEyehandP',
							header : '합격',
							tooltip : '합격',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devEyehandB',
							header : '싹트기',
							tooltip : '싹트기',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devEyehandF',
							header : '실패',
							tooltip : '실패',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '동작성',
						tooltip: '동작성',
						menuDisabled : true,
						columns : [{
							dataIndex : 'devActP',
							header : '합격',
							tooltip : '합격',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devActB',
							header : '싹트기',
							tooltip : '싹트기',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devActF',
							header : '실패',
							tooltip : '실패',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						text: '언어성',
						tooltip: '언어성',
						menuDisabled : true,
						columns : [{
							dataIndex : 'devLanP',
							header : '합격',
							tooltip : '합격',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devLanB',
							header : '싹트기',
							tooltip : '싹트기',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'devLanF',
							header : '실패',
							tooltip : '실패',
							width : 50,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]
					},{
						dataIndex : 'devScore',
						header : '발달점수',
						tooltip : '발달점수',
						width : 70,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				},{
					text: 'PEP',
					tooltip: 'PEP',
					menuDisabled : true,
					columns : [{
						dataIndex : 'pepCa',
						header : 'CA',
						tooltip : 'CA',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'pepDa',
						header : 'DA',
						tooltip : 'DA',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'pepDq',
						header : 'DA',
						tooltip : 'DA',
						width : 80,
						align : 'center',
						menuDisabled : true,
						sortable: false,
					}]
				}];

//EXIT-II column END

//SMS column
var columnSms =[
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
						columns : [{ 	
						dataIndex : 'targetId',
						header : '뇌원천',
						tooltip : '뇌원천 ',
						width: 90,
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
						width: 90,
						locked : true,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
						}]
					},{
					dataIndex : 'sex',
					header : '성별',
					tooltip : '성별',
					width: 60,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'performCntNm',
					header : '차수',
					tooltip : '차수',
					width: 60,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip : '나이',
					width: 60,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'smsExecDate',
					header : '실시일',
					tooltip : '실시일',
					width: 100,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					text: 'Subscale',
					tooltip: 'Subscale',
					locked : false,
					menuDisabled : true,
					flex : 70/100,
					columns : [{
						dataIndex : 'subMovecap',
						header : '이동능력',
						tooltip : '이동능력',
						flex : 15/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subCommucap',
						header :'의사소통 능력',
						tooltip :'의사소통 능력',
						align : 'center',
						flex : 15/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'subSocialcap',
						header :'사회화 능력',
						tooltip :'사회화 능력',
						align : 'center',
						flex : 15/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'subWorkcap',
						header :'작업 능력',
						tooltip :'작업 능력',
						align : 'center',
						flex : 15/100,
						menuDisabled : true,
						sortable: false,
					},{
						dataIndex : 'subSelfmanagecap',
						header :'자기관리 능력',
						tooltip :'자기관리 능력',
						align : 'center',
						flex : 15/100,
						menuDisabled : true,
						sortable: false,
					},{
						text: '기본적인 자조 능력',
					   	tooltip: '기본적인 자조 능력',
					   	menuDisabled : true,
					   	flex : 30/100,
					   	columns : [{
							dataIndex : 'subBasicapGeneral',
							header : 'General',
							tooltip : 'General',
							flex : 10/100,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'subBasicapDressing',
							header : 'Dressing',
							tooltip : 'Dressing',
							flex : 10/100,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						},{
							dataIndex : 'subBasicapEating',
							header : 'Eating',
							tooltip : 'Eating',
							flex : 10/100,
							align : 'center',
							menuDisabled : true,
							sortable: false,
						}]}
					]}
					,{
					text: 'SMS',
					tooltip: 'SMS',
					menuDisabled : true,
					flex : 20/100,
					columns : [{
						dataIndex : 'smsSa',
						header : 'SA',
						tooltip : 'SA',
						flex : 10/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'smsSq',
						header :'SQ',
						tooltip :'SQ',
						align : 'center',
						flex : 10/100,
						menuDisabled : true,
						sortable: false,
					}]
				}];

//SMS column END

//CARS column
var columnCars =[{
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
						header : '뇌원천',
						tooltip : '뇌원천 ',
						width: 90,
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
						width: 90,
						locked : true,
						align : 'center',
						locked : true,
						menuDisabled : true,
						sortable: false,
						}]
					},{
					dataIndex : 'sex',
					header : '성별',
					tooltip : '성별',
//					flex : 10/100,
					width: 60,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'performCntNm',
					header : '차수',
					tooltip : '차수',
//					flex : 11/100,
					width: 60,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'age',
					header : '나이',
//					tooltip : '나이',
					width: 60,
					flex : 9/100,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					dataIndex : 'carsExecDate',
					header : '실시일',
					tooltip : '실시일',
//					flex : 10/100,
					width: 90,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false,
				},{
					text: 'Subscale',
					tooltip: 'Subscale',
					menuDisabled : true,
					locked:false,
					flex : 95/100,
					columns : [{
						dataIndex : 'subPsRelation',
						header : '사람과의<br/>관계',
						tooltip : '사람과의<br/>관계',
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subImitation',
						header : '모방',
						tooltip : '모방',
						flex : 10/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subEmoRact',
						header : '정서반응',
						tooltip : '정서반응',
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subBodyuse',
						header : '신체사용',
						tooltip : '신체사용',
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subObjuse',
						header : '물체사용',
						tooltip : '물체사용',
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subChgAdapt',
						header : '변화에 대한<br/>적응',
						tooltip : '변화에 대한<br/>적응',
						flex : 25/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subVisualRact',
						header : '시각반응',
						tooltip : '시각반응',
//						width: 100,
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subAuditoryRact',
						header : '청각반응',
						tooltip : '청각반응',
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subEtcRactUse',
						header : '미각,후각,촉각<br/>반응 및 사용',
						tooltip : '미각,후각,촉각<br/>반응 및 사용',
						flex : 30/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subFearNervous',
						header : '두려움<br/>또는 <br/>신경과민',
						tooltip : '두려움<br/>또는 <br/>신경과민',
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subVerbCommu',
						header : '언어적<br/>의사소통',
						tooltip : '언어적<br/>의사소통',
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subNonverbCommu',
						header : '비언어적<br/>의사소통',
						tooltip : '비언어적<br/>의사소통',
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subActlev',
						header : '활동수준',
						tooltip : '활동수준',
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subIntellevCstc',
						header : '지적반응의 <br/>수준과 항상성',
						tooltip : '지적반응의 수준과 <br/>항상성',
						flex : 30/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					},{
						dataIndex : 'subGeneralEft',
						header : '일반적<br/>인상',
						tooltip : '일반적<br/>인상',
						flex : 20/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					}]
				},{
					text: 'CARS',
					tooltip: 'CARS',
					menuDisabled : true,
					locked:false,
					flex : 5/100,
					columns : [{
						dataIndex : 'carsTotal',
						header : '총점',
						tooltip : '총점',
						flex : 5/100,
						align : 'center',
						menuDisabled : true,
						sortable: false,
						
					}]
				}];

//SMS column END