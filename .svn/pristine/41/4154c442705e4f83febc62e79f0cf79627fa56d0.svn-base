var pageSize = parameter['pageSize'];
var dataIntegrationListGrid;
var activePage = parameter['activePage'];
var sm = new Ext.selection.CheckboxModel({
	headerWidth : 40
});
var dataIntegrationListStore;
var searchParams = {};
var wk12 = 0; //컬럼길이 12wk

dataIntegrationListGrid = function() {

		Ext.create(
					"Ext.panel.Panel",
					{
						// 'resizable-panel',
						height : '760px',
						region : 'center',
						layout : 'border',
						renderTo : 'ContentsDiv',
						border : false,
						items : [ {
							xtype : 'grid',
							id : 'dataIntegrationList-grid',
							region : 'center',
							autoExpandColumn : 'subject',
							store : dataIntegrationListStore,
							rowNumberer : true,
							trackMouseOver : true,
							autoScroll : true,
							columnLines : true,
							stripeRows : true,
							loadMask : true,
							border : true,
							singleSelect : true,
							selModel : sm,
							columns : [ {
								dataIndex : 'performCnt',
								header : '차수',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								hidden : true
							}, {
								dataIndex : 'performCntMax',
								header : '최종차수',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								hidden : true
							}, {
								dataIndex : 'performNm',
								header : '차수명',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								hidden : true
							}, 
							{
								dataIndex : 'targetId',
								tooltip: '연구번호',
								header : '연구번호',
								width : 80,
								align : 'center',
								locked : true,
								sortable : false,
								menuDisabled : true
							}, {
								dataIndex : 'sex',
								tooltip: '성별',
								header : '성별',
								width : 60,
								align : 'center',
								locked : true,
								sortable : false,
								menuDisabled : true
							}, {
								dataIndex : 'protocol',
								tooltip: '프로토콜',
								header : '프로토콜',
								width : 100,
								align : 'center',
								locked : true,
								sortable : false,
								menuDisabled : true
							}, {
								dataIndex : 'performCntMaxNm',
								tooltip: '최종차수',
								header : '최종차수',
								width : 60,
								align : 'center',
								locked : true,
								sortable : false,
								menuDisabled : true
							}, {
								dataIndex : 'cxtDiag',
								tooltip: '공존진단',
								header : '공존진단',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								renderer : dataSplit,
								style : 'text-align:center',
								align : 'left'
							}, {
								dataIndex : 'mriDate',
								tooltip: '영상',
								header : '영상',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								renderer : dataSplit,
								style : 'text-align:center',
								align : 'left'
							}, {
								text : '심리검사',
								tooltip: '심리검사',
								menuDisabled : true,
								columns : [ {

									dataIndex : 'ata',
									tooltip: 'ATA',
									header : 'ATA',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								}, {
									dataIndex : 'stroop',
									tooltip: 'STROOP',
									header : 'STROOP',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								}, {
									dataIndex : 'cctt',
									tooltip: 'CCTT',
									header : 'CCTT',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								}, {
									dataIndex : 'wsct',
									tooltip: 'WCST',
									header : 'WCST',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								}, {
									dataIndex : 'cat',
									tooltip: 'CAT',
									header : 'CAT',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								}, {
									dataIndex : 'exitii',
									tooltip: 'EXIT-II',
									header : 'EXIT-II',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								}, {
									dataIndex : 'cpt3',
									tooltip: 'CTP-3',
									header : 'CPT-3',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								}, {
									dataIndex : 'tmt',
									tooltip: 'TMT',
									header : 'TMT',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								} ]
							}, {
								text : '설문지',
								tooltip: '설문지',
								menuDisabled : true,
								columns : [ {
									text : '부모자녀평가',
									tooltip: '부모자녀평가',
									menuDisabled : true,
									columns : [ {
										dataIndex : 'ars',
										tooltip: 'ARS',
										header : 'ARS',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'kcbcl',
										tooltip: 'KCBCL',
										header : 'K-CBCL',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'cbcl',
										tooltip: 'CBCL',
										header : 'CBCL',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'dbds',
										tooltip: 'DBDS',
										header : 'DBDS',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'cmrsp',
										tooltip: 'CMRS-P',
										header : 'CMRS-P',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'trauma',
										tooltip: '트라우마',
										header : '트라우마',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									} ]
								}, {
									text : '아동자가평가',
									tooltip: '아동자가평가',
									menuDisabled : true,
									columns : [ {
										dataIndex : 'cdic',
										tooltip: 'CDI 아동용',
										header : 'CDI 아동용',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'iat',
										tooltip: 'IAT',
										header : 'IAT',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'kscale',
										tooltip: 'K-척도',
										header : 'K-척도',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'rcmas',
										tooltip: 'RCMAS',
										header : 'RCMAS',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'staitc',
										tooltip: 'STAI-T<br />(아동)',
										header : 'STAI-T<br />(아동)',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'staisc',
										tooltip: 'STAI-S<br />(아동)',
										header : 'STAI-S<br />(아동)',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'staity',
										tooltip: 'STAI-T<br />(청소년)',
										header : 'STAI-T<br />(청소년)',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'staisy',
										tooltip: 'STAI-S<br />(청소년)',
										header : 'STAI-S<br />(청소년)',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'loicv',
										tooltip: 'LOI-CV',
										header : 'LOI-CV',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'kbis11r',
										tooltip: 'K-BIS-11-R',
										header : 'K-BIS-11-R',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									} ]
								}, {
									text : '부모자가평가',
									tooltip: '부모자가평가',
									menuDisabled : true,
									columns : [ {
										dataIndex : 'bdi',
										tooltip: 'BDI',
										header : 'BDI',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'staitp',
										tooltip: 'STAI-T<br />(부모)',
										header : 'STAI-T<br />(부모)',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'staisp',
										tooltip: 'STAI-S<br />(부모)',
										header : 'STAI-S<br />(부모)',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'mbri',
										tooltip: 'MBRI',
										header : 'MBRI',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'kaadhdsAdult',
										tooltip: 'K-AADHDS<br />(성인용)',
										header : 'K-AADHDS<br />(성인용)',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'kpsi',
										tooltip: 'K-PSI',
										header : 'K-PSI',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									} ]
								} ]
							}, {
								dataIndex : 'clinicalValuation',
								tooltip: '임상가평가',
								header : '임상가평가',
								width : 130,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								renderer : dataSplit,
								style : 'text-align:center',
								align : 'left'
							}, {
								dataIndex : 'interval4Interview',
								tooltip: '4주 간격 면담지',
								header : '4주 간격 면담지',
								width : 130,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								renderer : dataSplit,
								style : 'text-align:center',
								align : 'left'
							} ],
							listeners : {
								celldblclick : function(view, cell, cellIndex, record,row, rowIndex, e) {
									if(cellIndex <= 7){
										//최종차수까지는 상세화면으로 이동
										var url = GLOBAL_CONTEXT_PATH
												+ '/medical/dataIntegration/dataIntegrationDtl.view';
										url += '?targetId=' +record.get('targetId');
										url += '&disClassDtl=' + record.get('disClassDtl');
										url += '&sex=' + record.get('sex');
										url += '&birthYm=' + record.get('birthYm');
										url += '&protocol=' + record.get('protocol');
										url += '&performCntMaxNm=' + record.get('performCntMaxNm');
										location.href = url;
									}
								}
							},
							fbar : new Ext.PagingToolbar(
									{
										id : 'dataIntegrationList-grid-page',
										pageSize : pageSize,
										store : dataIntegrationListStore,
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
						} ]

					});

}

Ext.onReady(function() {
	Ext.QuickTips.init();
	
	
	//왼쪽메뉴 선택
	parent.leftMenuChgByUrl(window.location.href);
	

	dataIntegrationListStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		pageSize : pageSize,
		proxy : {
			type : 'ajax',
			extraParams : {
				disClassDtl : menuDisClassDtl
			},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/dataIntegration/selectDataIntegrationList.do',
			reader : {
				type : 'json',
				root : 'result'
			}

		},
		listeners : {
			load : function(store) {
				var grid = Ext.getCmp('dataIntegrationList-grid');
				if(store.data.items[0] != null){
					if (store.data.items[0].data.maxSeq == 1){ //데이터 없을때
						for (i = 7; i < 40; i++) {// 공존진단부터 끝컬럼까지
							grid.columns[i].setWidth(70);
						}
					}else{
						var maxNum = store.data.items[0].data.maxSeq; //최대차수개수
						for (i = 7; i < 39; i++) {// 공존진단부터 K-PSI(임상가평가 전)까지
							grid.columns[i].setWidth((32 * maxNum) + (maxNum) + (48 * wk12));
							
						}
							grid.columns[39].setWidth((32 * maxNum)); //임상가평가
					}		
					//4주간격면담지 column width
					var maxSeq4wk = store.data.items[0].data.maxSeq4wk; //최대차수개수
					grid.columns[40].setWidth((48 * maxSeq4wk));
				}
				Ext.getCmp('dataIntegrationList-grid').getView().refresh();
			}
		}
	});

	new dataIntegrationListGrid();
});

function dataSplit(value, metadata, record, rowIndex, colIndex, view) {
	var grid = Ext.getCmp('dataIntegrationList-grid').ownerGrid;
	var colName = grid.normalGrid.columns[colIndex].text;
	var dataIndex = grid.normalGrid.columns[colIndex].dataIndex;
	var cnt = record.data.performCnt;
	var cntNm = record.data.performNm;
	var targetId = record.data.targetId;
	var valArr = [];
	var cntNmArr = [];
	var cntArr = [];
	var resultStr = "";
	if (cnt.indexOf(', ') != -1) {
		valArr = value.split(', ');
		cntNmArr = cntNm.split(', ');
		cntArr = cnt.split(', ');
	} else {
		valArr.push(value);
		cntNmArr.push(cntNm);
		cntArr.push(cnt);
	}
	var btnCls = "btn";
	if(colName == "임상가평가" || colName == "4주 간격 면담지") btnCls = "";
	for (var j = 0; j < valArr.length; j++) {
		if(cntNmArr[j].indexOf("12WK") != -1) {wk12 = 1};
		if(dataIndex == "interval4Interview"){
			if(cntNmArr[j].indexOf("4WK") == -1 && cntNmArr[j].indexOf("8WK") == -1 && cntNmArr[j].indexOf("12WK") == -1) continue;  
		}else{
			if(cntNmArr[j].indexOf("4WK") != -1 || cntNmArr[j].indexOf("8WK") != -1) continue;
		}
		if(dataIndex == "clinicalValuation"){
			if(cntNmArr[j].indexOf("4WK") != -1 || cntNmArr[j].indexOf("8WK") != -1 || cntNmArr[j].indexOf("12WK") != -1) continue; 
		}
		
		if (valArr[j] == "o") {
			resultStr += "<span class='border_color1 "+btnCls+"' onclick=\"gotoMenu('"+colName+"','"+targetId+"','"+cntArr[j]+"')\" >" + cntNmArr[j]
					+ "</span>";
		} else if (valArr[j] == "x") {
			resultStr += "<span class='border_color2' >" + cntNmArr[j]
					+ "</span>";
		} else if (valArr[j] == "z"){
			resultStr += "<span class='border_color3 "+btnCls+"' onclick=\"gotoMenu('"+colName+"','"+targetId+"','"+cntArr[j]+"')\">" + cntNmArr[j]
			+ "</span>";
		}
	}
	return resultStr;

}

function createElement(name, value) {
	var field = document.createElement("input");
	field.setAttribute("type", "hidden");
	field.setAttribute("name", name);
	field.setAttribute("value", value);
	return field;
}

function excelDownload() {

	if (dataIntegrationListStore.getCount() == 0) {
		Ext.Msg.alert('Warning', '결과자료가 없습니다.');
		return false;
	}

	var s = sm.getSelection();

	if (s.length > 0) {
		// 선택 다운로드

		var form = document.createElement("form");
		form.setAttribute("charset", "UTF-8");
		form.setAttribute("method", "Post"); // Post 방식
		form
				.setAttribute(
						"action",
						GLOBAL_CONTEXT_PATH
								+ '/medical/dataIntegration/dataIntgrationListSelectExcelDownload.do'); // 요청
		
		Ext.each(s, function(rec) {
			// form에 전달할 데이터 셋팅
			form.appendChild(createElement("targetId", rec.get('targetId')));
			form.appendChild(createElement("disClassDtl",menuDisClassDtl));
		});

		document.body.appendChild(form);
		form.submit();

	} else {
		// 전체 다운로드
		searchParams.limit = 60000;
		searchParams.disClassDtl = menuDisClassDtl;
		document.location.href = makeUrl(
				'/medical/dataIntegration/dataIntgrationListExcelDownload.do',
				searchParams);
	}
}

function doSearch() {
	var targetId = document.getElementById('targetId').value;
	var male = '';
	var female = '';
	var sex = '';
	var performCnt = document.getElementById('performCnt').value;
	var checkPro="";
	
	$("input:checkbox[name=check_pro]:checked").each(function(){
		if(checkPro != "")checkPro += ",";
		var val = this.value;
		val = val.replace(/ /gi, ""); 
		checkPro += "'"+ val+ "'";
	});

	if ($('#sex_m').prop('checked') == true) {
		male = 'Y';
	} else {
		male = 'N';
	}

	if ($('#sex_f').prop('checked') == true) {
		female = 'Y';
	} else {
		female = 'N';
	}
	if (male == 'Y' && female == 'N') {
		sex = 'M'
	} else if (male == 'N' && female == 'Y') {
		sex = 'F'
	} else {
		sex = '';
	}
	searchParams = {
		targetId : targetId,
		sex : sex,
		protocol : checkPro,
		performCnt : performCnt,
		disClassDtl : menuDisClassDtl
	}
	dataIntegrationListStore.proxy.extraParams = searchParams;

	var pageParams = {
		start : 0,
		limit : pageSize
	};

	dataIntegrationListStore.load({
		params : pageParams
	});
}

function searchCheck(obj) {
	var check = $.trim(obj);
	if (check == undefined || check == "" || check == "선택") {
		return false;
	}
	return true;
}

function gotoMenu(tabName, targetId, performCnt){
	//해당 메뉴로 이동
	if(tabName == "ATA" || tabName == "STROOP" || tabName == "CCTT" || tabName == "WCST" || tabName == "CAT"
		 || tabName == "EXIT-II" || tabName == "CPT-3" || tabName == "TMT"){
		var url = GLOBAL_CONTEXT_PATH + '/medical/neuropsy/neuropsyList.view';
		location.href = url+"?chgTabNm="+tabName+"&targetId="+targetId+"&performCnt="+performCnt;
	}else if(tabName == "공존진단"){
		var url = GLOBAL_CONTEXT_PATH + '/medical/target/targetList.view';
		location.href = url+"?chgTabNm="+tabName+"&targetId="+targetId+"&performCnt="+performCnt;
	}else if(tabName == "영상"){
		var url = GLOBAL_CONTEXT_PATH + '/medical/imaging/imagingList.view';
		location.href = url+"?chgTabNm="+tabName+"&targetId="+targetId+"&performCnt="+performCnt;
	}else{
		var surveyArr = ['ARS','K-CBCL','CBCL','DBDS','CMRS-P','트라우마','CDI 아동용','K-척도','RCMAS','STAI-T<br />(아동)'
			,'STAI-S<br />(아동)','STAI-T<br />(청소년)','STAI-S<br />(청소년)','LOI-CV','K-BIS-11-R','BDI','STAI-T<br />(부모)','STAI-S<br />(부모)','IAT','MBRI','K-AADHDS<br />(성인용)','K-PSI'];
		var surveyCdArr = ['ars01','kcbcl','kcbcl','dbds1','cmrsp','traum','cdi01','kscal','rcmas','stitc','stisc','stity','stisy'
							,'loicv','kbis1','bdi01','stitp','stisp','iat01','mbri1','kadhd','kpsi1'];
		
		for(i in surveyArr){
			if(surveyArr[i] == tabName){
				var url = GLOBAL_CONTEXT_PATH + '/medical/survey/surveyList.view';
				location.href = url+"?chgTabNm="+surveyCdArr[i]+"&targetId="+targetId+"&performCnt="+performCnt;
			}
		}
	}
	
}