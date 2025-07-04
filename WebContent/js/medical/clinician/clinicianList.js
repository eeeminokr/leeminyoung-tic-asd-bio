var pageSize =  parameter['pageSize'];
var clinicianListGrid;
var activePage = parameter['activePage'];
var sm = new Ext.selection.CheckboxModel({headerWidth:40});
var clinicianStore;
var performCntStore;
var clinicianTitle = "Total";
var chgColumn =[];
//var clinicianTitle = "";
var searchParams={};
var searchPageParams={};
var pageParams ={};
var chgTabNm = pageLoad.getParameter('chgTabNm');
var chgTargetId = pageLoad.getParameter('targetId');
var chgPerformCnt = pageLoad.getParameter('performCnt');


var columListGrid = [];

clinicianListGrid = function() {

			Ext.create("Ext.panel.Panel", {
				// 'resizable-panel',
				height : '760px',
				region : 'center',
				layout : 'border',
				renderTo : 'ContentsDiv',
				border : false,
				items : [ {
					xtype : 'grid',
					id : 'clinicianList-grid',
					region : 'center',
					enableLocking: true,
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
			        })
					,listeners: {//row click 이벤트
						celldblclick : function(view, cell, cellIndex, record,row, rowIndex, e) {
							var clickedDataIndex = view.panel.headerCt.getHeaderAtIndex(cellIndex).dataIndex;
							var clickedColumnName = view.panel.headerCt.getHeaderAtIndex(cellIndex).text;
							var clickedCellValue = record.get(clickedDataIndex);
							var tabName =['K-SADS','SRS01','CYBO1','YBOCS'];
							
							//연구번호 클릭 시 데이터 통합 분석 상세로 이동
							if(clickedDataIndex == "targetId"){
								var targetId = clickedCellValue;
								var url = GLOBAL_CONTEXT_PATH + '/medical/dataIntegration/dataIntegrationDtl.view';
								location.href = url+"?targetId="+targetId;
							}
							if(clickedCellValue=="o"){
								var targetId = record.get('targetId');
								var performCnt = record.get('performCnt');
								var tabDocId = clickedDataIndex=='cbcl1'?'kcbcl':clickedDataIndex;
								//클릭한 열의 탭으로 이동
								searchPageParams.targetId = targetId;
								searchPageParams.performCnt = performCnt;
								searchPageParams.schKeyWord="schTargetId";
								searchPageParams.rndId=loginRndId;
								searchPageParams.disClassDtl = menuDisClassDtl;
								searchPageParams.limit=clinicianStore.getPageSize();
								searchPageParams.docNm = clickedColumnName;
								searchPageParams.docId = tabDocId
								moveTabPage(clickedColumnName);
								moveTabPage(tabDocId.toUpperCase());
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
	console.log("clinician~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	Ext.QuickTips.init();	
		
	
	//왼쪽메뉴 선택
	parent.leftMenuChgByUrl(window.location.href);
	
	clinicianStore =  Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : false,
		pageSize : pageSize,
		proxy : {
			type : 'ajax',
			async : false,
			extraParams : { docClassDtl : 'DC004', disClassDtl : menuDisClassDtl},
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
// extraParams : { docId : 'ARS01'},
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
	
	
	//메뉴 생성
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
				console.log("탭여기까지왔다아아아ㅏ아");	
					for(var i=0; i<clinicianMenuStore.getTotalCount(); i++){
						var docNm=clinicianMenuStore.data.items[i].data.docNm;
						var docId=clinicianMenuStore.data.items[i].data.docId;
						console.log(docNm + "docNm뮤슨이름이냐?");
						$(".submenu").append('<button type="button" class="menuBtn" onClick=gridChg(\''+docId+'\');>'+docNm+'</button>');
						
					}
			}
		}
	});		
	new clinicianListGrid();
	
	
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
    	
    	// 왼쪽메뉴 변경
      	parent.leftMenuChg('AO06','AO04');
    	//해당탭으로 이동
    	searchPageParams.targetId = chgTargetId;
    	searchPageParams.performCnt = chgPerformCnt;
		searchPageParams.schKeyWord="schTargetId";
		searchPageParams.rndId=loginRndId;
		searchPageParams.limit=clinicianStore.getPageSize();
		searchPageParams.disClassDtl = menuDisClassDtl;
		searchPageParams.docId = chgTabNm;
		//searchPageParams.docId = chgTabNm2;
		console.log(chgTabNm2+"임상가평가chgTabNm2");
	//	moveTabPage(chgTabNm);

	   console.log(chgTabNm2+"chgTabNm2222222");
  		moveTabPage(chgTabNm.toUpperCase());
    }else{
    	//total화면으로 이동
    	//gridChg('Total');
    	var clinicianParams = {
    				docId : 'Total',
    				disClassDtl : menuDisClassDtl
    	}
    	
    	clinicianStore.proxy.extraParams = clinicianParams;
    	clinicianStore.load();
 
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
//	var targetId = document.getElementById('targetId').value;
//	var male = '';
//	var female = '';
//	var sex = '';
//	var checkPro="";
//	var startAge = document.getElementById('startAge').value;
//	var endAge = document.getElementById('endAge').value;
//	var performCnt = document.getElementById('performCnt').value;
	
	//var cv = '';
	//var pSelf = '';
	//var cSelf = '';
	//var pSelf2 = '';
	//var iv4 = '';
	console
	
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
	var s1 = document.getElementsByName("s1")[0].checked;
	var srs01 = document.getElementsByName("srs01")[0].checked;
	var cybo1 = document.getElementsByName("cybo1")[0].checked;
	var ybocs = document.getElementsByName("ybocs")[0].checked;

	searchParams = {
			rndId : loginRndId,
			targetId : document.getElementById("targetId").value,
			startAge : document.getElementById("startAge").value,
			endAge : document.getElementById("endAge").value,
			sex : checkSex,
			protocol : checkPro,
			performCnt : document.getElementById("performCnt").value,
			cvCgis : cvCgis?'Y':'N',
			cvCgii : cvCgii?'Y':'N',
			cvCgas : cvCgas?'Y':'N',
			s1 : s1?'Y':'N',
			srs01 : srs01?'Y':'N',
		    cybo1 : cyb01?'Y':'N',
			ybocs : ybocs?'Y':'N',
			tmt : tmt?'Y':'N',
			disClassDtl : menuDisClassDtl
			}
	 	clinicianStore.proxy.extraPrams = searchParams;
	pageParams = {
			start : 0,
			limit : pageSize
			
		};
	
	
	clinician.load({
		params : pageParams
	});
	
	//gridChg(clinicianTitle);
}

function gridChg(title,pageNum,rNum){
	
	var perfromNm = 'V';
	//if(title =='SRS01' || title == 'K-SADS' || title == 'CYBO1' || title =='YBOCS' ) performNm = 'W';
	searchParams.disClassDtl = menuDisClassDtl;
	if( title == 'Total'){ 
		
		//----------------------------
		
		
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
	
	
	//---------------------
		
		if(title =='S1001'){
		Ext.MessageBox.show({
		       msg: '<p style="text-align:center"><br/>조회 중입니다..</p>',
		       progressText: '잠시만 기다려주세요..',
		       width:300,
		       wait:true,
		       waitConfig: {interval:200},
		   });
		clinicianTitle = "S1001";
		chgColumn = columnS1;
		searchParams.docId = 'S1001';
		searchParams.rndId = loginRndId;
		clinicianStore.proxy.url = GLOBAL_CONTEXT_PATH + '/medical/clinician/selectClinicianList.do';
		clinicianStore.proxy.extraParams = searchParams;
		if(pageNum != "" && pageNum != undefined){
			//targetId 위치로 이동
			clinicianStore.currentPage = pageNum;
			clinicianStore.load(function(){
				
				sm.select(rNum,true);
				//스크롤 이동
				var x= Ext.getCmp('clinicianList-grid').getView().ownerGrid.getScrollX();
				
				Ext.getCmp('clinicianList-grid').getView().ownerGrid.scrollTo(x,rNum*26);
			});
		}else{
			clinicianStore.load({
				params : pageParams
			});
		}
		setTimeout(function(){
			Ext.getCmp("clcinicianList-grid").reconfigure(clinicianStore, chgColumn);
			 $('h3.tit').addClass('on').html(title);
			 $('.total_search').hide();
			Ext.MessageBox.hide();
		}, 1000);
		return false;
	}else if(title == "SRS01"){ 
		clinicianTitle = "SRS01";
		chgColumn = columnSrs1;
		searchParams.docId = 'SRS01';
	}else if(title == "CYBO1"){ // 임상가평가 미존재
		surveyTitle = "CYBO1";
		chgColumn = columnCyBocs1;
		searchParams.docId = 'CYBO1';
	}else if(title == "YBOCS"){
		surveyTitle = "YBOCS";
		chgColumn = columnYBocs;
		searchParams.docId = 'YBOCS';
	}
	
	searchParams.rndId = loginRndId;
	clinicianStore.proxy.url = GLOBAL_CONTEXT_PATH + '/medical/clinician/selectClinicianList.do';
	clinicianStore.proxy.extraParams = searchParams;
	
	if(pageNum != "" && pageNum != undefined){
		clinicianStore.currentPage = pageNum;
		clinicianStore.load(function(){
			
			sm.select(rNum,true);
			//스크롤 이동
			var x= Ext.getCmp('clinicianList-grid').getView().ownerGrid.getScrollX();
			Ext.getCmp('clinicianList-grid').getView().ownerGrid.scrollTo(x,rNum*26);
			Ext.MessageBox.hide();
		});
	}else{
		clinicianStore.load({
			params : pageParams
		});
	}

	
	Ext.getCmp("clinicianList-grid").reconfigure(clinicianStore, chgColumn);
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
function createElement(name, value){
	var field = document.createElement("input");
	field.setAttribute("type", "hidden");
	field.setAttribute("name", name);
	field.setAttribute("value", value);
	return field;
}

function excelDownload(){
	if(clinicianStore.getCount() == 0) {
        Ext.Msg.alert('Warning', '결과자료가 없습니다.');
        return false;
    }
	var s = sm.getSelection();

	if (s.length > 0) {
		//선택 다운로드
		 var form = document.createElement("form");
		    form.setAttribute("charset", "UTF-8");
		    form.setAttribute("method", "Post");  //Post 방식
		    form.setAttribute("action", GLOBAL_CONTEXT_PATH+'/medical/clinician/clinicianSelectExcelDownload.do'); //요청 보낼 주소
		    
		    form.appendChild(createElement("rndId",loginRndId));
		    form.appendChild(createElement("docNm",clinicianTitle));
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
		searchParams.docNm = clinicianTitle;
		searchParams.rndId = loginRndId;
		searchParams.limit=60000;
		document.location.href = makeUrl('/medical/clinician/clinicianExcelDownload.do', searchParams);
	}
	
}

function uploadExcelDownload() {
	
	location.href = GLOBAL_CONTEXT_PATH + '/downFile.view?dir=file.sample.dir&fileName=clinicianUpload.xlsx';
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
		title: '심리검사 데이터 업로드',
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
		            		 var  url = GLOBAL_CONTEXT_PATH + '/medical/clinician/clinicianFileUpload.do';
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
			 docNm : clinicianTitle
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
	        	 		url : makeUrl('/medical/clinician/deleteclinician.do'),
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


//Total column 설문지(전체)
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
					dataIndex : 'execDate',
					header : '실시일',
					tooltip: '실시일',
					width: 100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
						dataIndex : 'cvCgis',
						header : 'CGI-S',
						tooltip: 'CGI-S',
						width: 100,
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
						dataIndex : 's1',
						header : 'K-SADS',
						tooltip: 'K-SADS',
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
						width: 80,
						menuDisabled : true,
						sortable: false,
						renderer : function(value, metaData, record, rowIndex){			    	
							var cursorChk = value;
							if(value == 'o')cursorChk = '<span class="btn">' + value + '</span>';
					        return cursorChk;
					    }
					}];
				

// Total column END













//S1 column
var columnS1 =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip : '연구번호',
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
					tooltip : '성별',
					width: 80,
					locked : true,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip : '프로토콜',
					width: 100,
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
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 's1ExecDate',
					header : 'K-SADS<br />실시일',
					tooltip : 'K-SADS<br />실시일',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'ticSubtype',
					header : 'Tic<br />subtype',
					tooltip : 'Tic<br />subtype',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 's1ExecDate',
					header : '지능검사<br />실시날짜',
					tooltip : '지능검사<br />실시날짜',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'fsiq',
					header : 'FSIQ',
					tooltip : 'FSIQ',
					width: 80,
					align : 'center',
					menuDisabled : true,
					sortable: false
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
				   },{
					    text: 'K-SADS',
					    tooltip: 'K-SADS',
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
				text: '틱장애부록',
				tooltip: '틱장애부록',
				sortable: false	,
				menuDisabled : true,
				columns : [{
				text: '단순운동틱',
				tooltip: '단순운동틱',
				menuDisabled : true,
				columns : [{
					dataIndex : 'sactTic1Ce',
					header : '1.요약CE',
					tooltip : '1.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic1Msp',
					header : '1.요약MSP',
					tooltip : '1.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic2Ce',
					header : '2.요약CE',
					tooltip : '2.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic2Msp',
					header : '2.요약MSP',
					tooltip : '2.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic3Ce',
					header : '3.요약CE',
					tooltip : '3.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic3Msp',
					header : '3.요약MSP',
					tooltip : '3.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic4Ce',
					header : '4.요약CE',
					tooltip : '4.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic4Msp',
					header : '4.요약MSP',
					tooltip : '4.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic5Ce',
					header : '5.요약CE',
					tooltip : '5.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic5Msp',
					header : '5.요약MSP',
					tooltip : '5.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic6Ce',
					header : '6.요약CE',
					tooltip : '6.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic6Msp',
					header : '6.요약MSP',
					tooltip : '6.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic7Ce',
					header : '7.요약CE',
					tooltip : '7.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic7Msp',
					header : '7.요약MSP',
					tooltip : '7.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic8Ce',
					header : '8.요약CE',
					tooltip : '8.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'sactTic8Msp',
					header : '8.요약MSP',
					tooltip : '8.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
				},{
				text: '복합운동틱',
				tooltip: '복합운동틱',
				sortable: false,
				menuDisabled : true,
				columns : [{
					dataIndex : 'cactTic1Ce',
					header : '1.요약CE',
					tooltip : '1.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cactTic1Msp',
					header : '1.요약MSP',
					tooltip : '1.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cactTic2Ce',
					header : '2.요약CE',
					tooltip : '2.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cactTic2Msp',
					header : '2.요약MSP',
					tooltip : '2.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cactTic3Ce',
					header : '3.요약CE',
					tooltip : '3.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cactTic3Msp',
					header : '3.요약MSP',
					tooltip : '3.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cactTic4Ce',
					header : '4.요약CE',
					tooltip : '4.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cactTic4Msp',
					header : '4.요약MSP',
					tooltip : '4.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cactTic5Ce',
					header : '5.요약CE',
					tooltip : '5.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cactTic5Msp',
					header : '5.요약MSP',
					tooltip : '5.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
				},{
				text: '단순음성틱',
				tooltip: '단순음성틱',
				sortable: false,
				menuDisabled : true,
				columns : [{
					dataIndex : 'svoiceTic1Ce',
					header : '1.요약CE',
					tooltip : '1.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'svoiceTic1Msp',
					header : '1.요약MSP',
					tooltip : '1.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'svoiceTic2Ce',
					header : '2.요약CE',
					tooltip : '2.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'svoiceTic2Msp',
					header : '2.요약MSP',
					tooltip : '2.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false			
				},{
					dataIndex : 'svoiceTic3Ce',
					header : '3.요약CE',
					tooltip : '3.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'svoiceTic3Msp',
					header : '3.요약MSP',
					tooltip : '3.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
				},{
				text: '복합음성틱',
				tooltip: '복합음성틱',
				sortable: false,
				menuDisabled : true,
				columns : [{
					dataIndex : 'cvoiceTic1Ce',
					header : '1.요약CE',
					tooltip : '1.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic1Msp',
					header : '1.요약MSP',
					tooltip : '1.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic2Ce',
					header : '2.요약CE',
					tooltip : '2.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic2Msp',
					header : '2.요약MSP',
					tooltip : '2.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic3Ce',
					header : '3.요약CE',
					tooltip : '3.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic3Msp',
					header : '3.요약MSP',
					tooltip : '3.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic4Ce',
					header : '4.요약CE',
					tooltip : '4.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic4Msp',
					header : '4.요약MSP',
					tooltip : '4.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic5Ce',
					header : '5.요약CE',
					tooltip : '5.요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic5Msp',
					header : '5.요약MSP',
					tooltip : '5.요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic6aCe',
					header : '6.a요약CE',
					tooltip : '6.a요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic6aMsp',
					header : '6.a요약MSP',
					tooltip : '6.a요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic6bCe',
					header : '6.b요약CE',
					tooltip : '6.b요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic6bMsp',
					header : '6.b요약MSP',
					tooltip : '6.b요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic6cCe',
					header : '6.c요약CE',
					tooltip : '6.c요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'cvoiceTic6cMsp',
					header : '6.c요약MSP',
					tooltip : '6.c요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
				},{
				text: '뚜렛장애의 진단기준',
				tooltip: '뚜렛장애의 진단기준',
				sortable: false,
				menuDisabled : true,
				columns : [{
					dataIndex : 'tourette7aCe',
					header : '7.a요약CE',
					tooltip : '7.a요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'tourette7aMsp',
					header : '7.a요약MSP',
					tooltip : '7.a요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'tourette7bCe',
					header : '7.b요약CE',
					tooltip : '7.b요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'tourette7bMsp',
					header : '7.b요약MSP',
					tooltip : '7.b요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
				},{
				text: '만성틱의 진단기준',
				tooltip: '만성틱의 진단기준',
				sortable: false,
				menuDisabled : true,
				columns : [{
					dataIndex : 'chronicTic8aCe',
					header : '8.a요약CE',
					tooltip : '8.a요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'chronicTic8aMsp',
					header : '8.a요약MSP',
					tooltip : '8.a요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'chronicTic8bCe',
					header : '8.b요약CE',
					tooltip : '8.b요약CE',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				},{
					dataIndex : 'chronicTic8bMsp',
					tooltip : '8.b요약MSP',
					header : '8.b요약MSP',
					width : 80,
					//width : 180,
					align : 'center',
					menuDisabled : true,
					sortable: false					
				}]
				},{
					text: '일과성틱의 진단기준',
					tooltip: '일과성틱의 진단기준',
					sortable: false,
					menuDisabled : true,
					columns : [{
						dataIndex : 'dailyTic9aCe',
						header : '9.a요약CE',
						tooltip : '9.a요약CE',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false					
					},{
						dataIndex : 'dailyTic9aMsp',
						header : '9.a요약MSP',
						tooltip : '9.a요약MSP',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false					
					},{
						dataIndex : 'dailyTic9bCe',
						header : '9.b요약CE',
						tooltip : '9.b요약CE',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false					
					},{
						dataIndex : 'dailyTic9bMsp',
						header : '9.b요약MSP',
						tooltip : '9.b요약MSP',
						width : 80,
						//width : 180,
						align : 'center',
						menuDisabled : true,
						sortable: false					
						}]
					}]
				}];

			
//S1 column END


//SRS1 column 설문지 검사 임상가평가(SRS)
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


//Y-BOCS column 설문지 (Y-BOCS) 부모 임상가평가
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



//Total column
/*
var columnTotal =	[{ 	
					dataIndex : 'targetId',
					header : '연구번호',
					tooltip : '연구번호',
					flex : 7/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false,
					renderer : function(value,metadata,record,rowIndex,colIndex,view ){
						metadata.tdCls = 'btn';
						return value;
					}
				},{
					dataIndex : 'sex',
					header : '성별',
					tooltip : '성별',
					flex : 4/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'protocol',
					header : '프로토콜',
					tooltip : '프로토콜',
					flex : 8/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'performCntNm',
					header : '차수',
					tooltip : '차수',
					flex : 4/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'age',
					header : '나이',
					tooltip : '나이',
					flex : 4/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'execDate',
					header : '실시일',
					tooltip : '실시일',
					flex : 8/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false 
				},{
					dataIndex : 'ata',
					header : 'ATA',
					tooltip : 'ATA',
					flex : 8/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'stroop',
					header : 'STROOP',
					tooltip : 'STROOP',
					flex : 8/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'cctt',
					header : 'CCTT',
					tooltip : 'CCTT',
					flex : 8/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'wsct',
					header : 'WCST',
					tooltip : 'WCST',
					flex : 8/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'cat',
					header : 'CAT',
					tooltip : 'CAT',
					flex : 8/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'exitii',
					header : 'EXIT-II',
					tooltip : 'EXIT-II',
					flex : 8/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'cpt3',
					header : 'CPT-3',
					tooltip : 'CPT-3',
					flex : 8/100,
					align : 'center',
					style: 'padding:10px;',
					menuDisabled : true,
					sortable: false
				},{
					dataIndex : 'tmt',
					header : 'TMT',
					tooltip : 'TMT',
					flex : 8/100,
					align : 'center',
					menuDisabled : true,
					sortable: false
				}];
*/
//Total column END