var pageSize = parameter['pageSize'];
var dataIntegrationListGrid;
var activePage = parameter['activePage'];
var sm = new Ext.selection.CheckboxModel({
	headerWidth : 40
});
var dataIntegrationListStore;
var searchParams = {};

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
							id : 'dataIntegrationAsdList-grid',
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
								locked : true,
								sortable : false,
								menuDisabled : true,
								hidden : true
							}, {
								dataIndex : 'performCntMax',
								header : '최종차수',
								width : 80,
								align : 'center',
								locked : true,
								sortable : false,
								menuDisabled : true,
								hidden : true
							}, {
								dataIndex : 'performNm',
								header : '차수명',
								width : 80,
								align : 'center',
								locked : true,
								sortable : false,
								menuDisabled : true,
								hidden : true
							},{ 	
								dataIndex : 'disClassDtl',
								header : '질병군',
								tooltip : '질병군',
								width : 100,
								align : 'center',
								locked : true,
								sortable : false,
								menuDisabled : true
							}
//							,{ 	
//								dataIndex : 'docClassDtl',
//								header : 'docClassDtl',
//								tooltip : 'docClassDtl',
//								width : 100,
//								align : 'center',
//								locked : true,
//								sortable : false,
//								menuDisabled : true
//							}
							,{ 	
								text : '연구번호',
								tooltip : '연구번호',
								locked : true,
								menuDisabled : true,
								sortable : false,
								columns : [{
								dataIndex : 'targetId',
								tooltip: '뇌원천<br/>연구번호',
								header : '뇌원천<br/>연구번호',
								width : 80,
								align : 'center',
								locked : true,
								sortable : false,
								menuDisabled : true
							},{
								dataIndex : 'targetDisId',
								tooltip: '뇌질환<br/>연구번호',
								header : '뇌질환<br/>연구번호',
								width : 80,
								align : 'center',
								locked : true,
								sortable : false,
								menuDisabled : true
							}]
							},{
								dataIndex : 'sex',
								tooltip: '성별',
								header : '성별',
								width : 60,
								align : 'center',
								locked : true,
								sortable : false,
								menuDisabled : true
							}
//							, {
//								dataIndex : 'protocol',
//								tooltip: '프로토콜',
//								header : '프로토콜',
//								width : 100,
//								align : 'center',
//								locked : true,
//								sortable : false,
//								menuDisabled : true
//							}
							, {
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
								style : 'text-align:center;,display: inline-table;',
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
								style : 'text-align:center;, display: inline-table;',
								align : 'left'
							},{
								text : '임상가평가',
								tooltip: '임상가평가',
								menuDisabled : true,
								columns : [{
									dataIndex : 'exts1',
									tooltip: 'K-SADS-PL',
									header : 'K-SADS-PL',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								},{
									dataIndex : 'srs01',
									header : 'SRS',
									tooltip: 'SRS',
									align : 'center',
									width: 120,
									menuDisabled : true,
									sortable: false,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								},{
									dataIndex : 'cybocs',
									header : 'CY-BOCS',
									tooltip: 'CY-BOCS',
									align : 'center',
									width: 80,
									menuDisabled : true,
									sortable: false,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								},{
									dataIndex : 'ybocs',
									header : 'Y-BOCS',
									tooltip: 'Y-BOCS',
									align : 'center',
									width: 120,
									menuDisabled : true,
									sortable: false,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								}
							]}	
							
							
							,{
								text : '심리/발달검사',
								tooltip: '심리/발달검사',
								menuDisabled : true,
								columns : [{
								dataIndex : 's1',
								tooltip: '지능검사',
								header : '지능검사',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								renderer : dataSplit,
								style : 'text-align:center',
								align : 'left'
							},{
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
							},{
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
							}, {
								dataIndex : 'ados1',
								tooltip: 'ADOS',
								header : 'ADOS',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								renderer : dataSplit,
								style : 'text-align:center',
								align : 'left'
							}, {
								dataIndex : 'ados2',
								tooltip: 'ADOS-2',
								header : 'ADOS-2',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								renderer : dataSplit,
								style : 'text-align:center',
								align : 'left'
							}, {
								dataIndex : 'pep',
								tooltip: 'PEP-R',
								header : 'PEP-R',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								renderer : dataSplit,
								style : 'text-align:center',
								align : 'left'
							}, {
								dataIndex : 'sms',
								tooltip: 'SMS',
								header : 'SMS',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								renderer : dataSplit,
								style : 'text-align:center',
								align : 'left'
							}, {
								dataIndex : 'cars',
								tooltip: 'CARS',
								header : 'CARS',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								renderer : dataSplit,
								style : 'text-align:center',
								align : 'left'
							}
							
							]}
								, {
								text : '설문지',
								tooltip: '설문지',
								menuDisabled : true,
								columns : [{
									text: '부모자녀평가',
									menuDisabled : true,
									columns : [{
										dataIndex : 'prdv1',
										header : '주산기 발달력',
										tooltip: '주산기 발달력',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'kmchat',
										header : 'KMCHAT',
										tooltip: 'KMCHAT',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'ars',
										header : 'ARS',
										tooltip: 'ARS',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'abc',
										header : 'ABC',
										tooltip: 'ABC',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'sib',
										header : 'SIB',
										tooltip: 'SIB',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'bpi',
										header : 'BPI',
										tooltip: 'BPI',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'srs',
										header : 'SRS',
										tooltip: 'SRS',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'scq',
										header : 'SCQ',
										tooltip: 'SCQ',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'pc3q',
										header : '부모 자녀<br/>AQ/EQ/SQ',
										tooltip: '부모 자녀<br/>AQ/EQ/SQ',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'kAsds',
										header : 'K-ASDS',
										tooltip: 'K-ASDS',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'ssis',
										header : 'SSIS',
										tooltip: 'SSIS',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
										
									},{
										dataIndex : 'trauma',
										header : '트라우마',
										tooltip: '트라우마',
										align : 'center',
										width: 80,
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
										
									},{
										dataIndex : 'cmrsp',
										header : 'CMRS-P',
										tooltip: 'CMRS-P',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
										
									},{ //NEW CPCL 항목 추가
										dataIndex : 'oldCbcl',
										header :'CPCL',
										tooltip: 'CPCL',
										align : 'center',
										width: 80,
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{ //구 OCBCL => K-CBCL(구버전)
										dataIndex : 'oldCbcl15',
										header :'K-CBCL(구버전)',
										tooltip: 'K-CBCL(구버전)',
										align : 'center',
										width: 80,
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}	,{
										dataIndex : 'cbcl15',
										header : 'CBCL<br/>1.5-5',
										tooltip: 'CBCL<br/>1.5-5',
										align : 'center',
										width: 80,
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{  //구OBCL => CBCL 6-18
										dataIndex : 'oldCbcl15',
										header : 'CBCL<br/>6-18',
										tooltip: 'CBCL<br/>6-18',
										align : 'center',
										width: 80,
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'lsd',
										header : 'LSD',
										tooltip: 'LSD',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'qpgsR3',
										header : 'QPGS-RⅢ',
										tooltip: 'QPGS-RⅢ',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'gsrs',
										header : 'GSRS',
										tooltip: 'GSRS',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									   
									},{
										dataIndex : 'kCshq',
										header : 'K-CSHQ',
										tooltip: 'K-CSHQ',
										width: 80,
										align : 'center',
										menuDisabled : true,
										sortable: false,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									 
									}]
								},{
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
										dataIndex : 'bdia',
										tooltip: 'BDI 성인용',
										header : 'BDI 성인용',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'staitc',
										tooltip: 'STAI-T',
										header : 'STAI-T',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}, {
										dataIndex : 'staisc',
										tooltip: 'STAI-S',
										header : 'STAI-S',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'cc3qc',
										tooltip: '아동 자가<br/>AQ/EQ/SQ 아동용',
										header : '아동 자가<br/>AQ/EQ/SQ 아동용',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'cc3qa',
										tooltip: '아동 자가<br/>AQ/EQ/SQ 성인용',
										header : '아동 자가<br/>AQ/EQ/SQ 성인용',
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
									},{
										dataIndex : 'kscalea',
										tooltip: 'K-척도 성인용',
										header : 'K-척도 성인용',
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
									},{
										dataIndex : 'traumaa',
										tooltip: '트라우마 성인용',
										header : '트라우마 성인용',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									}]
								},
								 {
									text : '부모자가평가',
									tooltip: '부모자가평가',
									menuDisabled : true,
									columns : [ {
										dataIndex : 'bdi',
										tooltip: 'BDI(부모용)',
										header : 'BDI(부모용)',
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
									},{
										dataIndex : 'pp3q',
										tooltip: '부모 자가<br/>AQ/EQ/SQ',
										header : '부모 자가<br/>AQ/EQ/SQ',
										width : 80,
										align : 'center',
										sortable : false,
										menuDisabled : true,
										renderer : dataSplit,
										style : 'text-align:center',
										align : 'left'
									},{
										dataIndex : 'kPsi',
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
								}
									
								]}, {
								text : '환경물질 분석',
								tooltip: '환경물질 분석',
								menuDisabled : true,
								columns : [{
									dataIndex : 'analEnvMatt',
									tooltip: 'PHTs 3종 및 COT(소변)',
									header : 'PHTs 3종 및 COT(소변)',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								},{
									dataIndex : 'analEnvMattBl',
									tooltip: '중금속(혈액)',
									header : '중금속(혈액)',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								}]
							},{
								text : '유전정보',
								tooltip: '유전정보',
								menuDisabled : true,
								columns : [{
									dataIndex : 'wgs',
									tooltip: 'WGS',
									header : 'WGS',
									width : 80,
									align : 'center',
									sortable : false,
									menuDisabled : true,
									renderer : dataSplit,
									style : 'text-align:center',
									align : 'left'
								}]
							}
							/*
							,{
								dataIndex : 'clinicalValuation',
								tooltip: '임상가평가',
								header : '임상가평가',
								width : 80,
								align : 'center',
								sortable : false,
								menuDisabled : true,
								renderer : dataSplit,
								style : 'text-align:center',
								align : 'left'
							}
							*/
							],
							listeners : {
								celldblclick : function(view, cell, cellIndex, record,row, rowIndex, e, colIndex) {
									var cl = view.panel.headerCt.getHeaderAtIndex(cellIndex).dataIndex;
									if(cl == "targetId" || cl == "targetDisId" || cl == "sex" || cl == "protocol" || cl == "performCntMaxNm"){
							
									var docId = record.get('docId');
									console.log(docId+"docId값이 나왔나???????????");
										
										var  docClassDtl = record.get('docClassDtl');
										console.log("docClassDtlN=========> :"+docClassDtl);
										
										//최종차수까지는 상세화면으로 이동
										var url = GLOBAL_CONTEXT_PATH
												+ '/medical/dataIntegration/dataIntegrationDtlAo.view';
										url += '?targetId=' +record.get('targetId');
										url += '&disClassDtl=' + record.get('disClassDtl');
										url += '&docClassDtl=' + record.get('docClassDtl');
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
										id : 'dataIntegrationAsdList-grid-page',
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
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/dataIntegrationAsd/selectDataIntegrationListAo.do',
			reader : {
				type : 'json',
				root : 'result'
			},
			extraParams : {
				disClassDtl : menuDisClassDtl,
				docClassDtl : docClassDtl,
			//	docId : docId
			}
		},
		listeners : {
			load : function(store) {
				var grid = Ext.getCmp('dataIntegrationAsdList-grid');
				if(store.data.items[0] != null){
					if (store.data.items[0].data.maxSeq == 1){ //데이터 없을때
						for (i = 8; i < 65; i++) {// 공존진단부터 끝컬럼까지
							grid.columns[i].setWidth(70);
						}
					}else{
						var maxNum = store.data.items[0].data.maxSeq; //최대차수개수
						for (i = 8; i < 65; i++) {// 공존진단부터 끝까지
							if(i == 61 || i == 62 || i == 63) grid.columns[i].setWidth(70);
							else grid.columns[i].setWidth((32 * maxNum) + maxNum);
						}
					}
				}
				Ext.getCmp('dataIntegrationAsdList-grid').getView().refresh();
			}
		}
	});

	new dataIntegrationListGrid();
});

function dataSplit(value, metadata, record, rowIndex, colIndex, view) {
	var grid = Ext.getCmp('dataIntegrationAsdList-grid').ownerGrid;
	var colName = grid.normalGrid.columns[colIndex].text;
	var dataIndex = grid.normalGrid.columns[colIndex].dataIndex;
	var cnt = record.data.performCnt;
	var cntNm = record.data.performNm;
	var targetId = record.data.targetId;
	var docClassDtl = record.data.docClassDtl;
	var docId = record.data.docId;
	
//	console.log(cntNm+": <------------cntNm 들어왔다.")
//	console.log(docClassDtl+": <------------docClassDTL 들어왔다.")
//	console.log(docId+": <------------docId 들어왔다.")
	var valArr = [];
	var cntNmArr = [];
	var cntArr = [];
	var docDtlArr = [];
	var resultStr = "";
	if (cnt.indexOf(', ') != -1) {
		valArr = value.split(', ');
		cntNmArr = cntNm.split(', ');
		cntArr = cnt.split(', ');
		docDtlArr = docClassDtl.split(', ');
		docIdArr = docId.split(', ');
	} else {
		valArr.push(value);
		cntNmArr.push(cntNm);
		cntArr.push(cnt);
		docDtlArr(docClassDtl);
		docIdArr(docId);
	}
	var btnCls = "btn";
	if(colName == "임상가평가") btnCls = "";

	for (var j = 0; j < valArr.length; j++) {
		if (valArr[j] == "o") {
			resultStr += "<span class='border_color1 "+btnCls+"' onclick=\"gotoMenu('"+colName+"','"+targetId+"','"+cntArr[j]+"','"+docIdArr[j]+"','"+docDtlArr[j]+"')\" >" + cntNmArr[j]
					+ "</span>";
		} else if (valArr[j] == "x") {
			resultStr += "<span class='border_color2' >" + cntNmArr[j]
					+ "</span>";
		} else if (valArr[j] == "z"){
			resultStr += "<span class='border_color3 "+btnCls+"' onclick=\"gotoMenu('"+colName+"','"+targetId+"','"+cntArr[j]+"','"+docIdArr[j]+"','"+docDtlArr[j]+"')\">" + cntNmArr[j]
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
								+ '/medical/dataIntegrationAsd/dataIntgrationListSelectExcelDownload.do'); // 요청
		
		Ext.each(s, function(rec) {
			// form에 전달할 데이터 셋팅
			form.appendChild(createElement("targetId", rec.get('targetId')));
			form.appendChild(createElement("disClassDtl",menuDisClassDtl));
			form.appendChild(creatElement("docClassDtl",rec.get('docClassDtl')));
		});

		document.body.appendChild(form);
		form.submit();

	} else {
		// 전체 다운로드
		searchParams.limit = 60000;
		searchParams.disClassDtl = menuDisClassDtl;
		document.location.href = makeUrl(
				'/medical/dataIntegrationAsd/dataIntgrationListExcelDownload.do',
				searchParams);
	}
}

function doSearch() {
	console.log("docClassDtl-------------->: "+docClassDtl);
	//var docClassDtlt = document.getElementById('docClassDtl').value;
	//console.log("docClassDtlt============> : "+docClassDtlt);
	var targetId = document.getElementById('targetId').value;
	var targetDisId = document.getElementById('targetDisId').value;
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
		disClassDtl : menuDisClassDtl,
		docClassDtl : docClassDtl,
		targetDisId : targetDisId
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

function gotoMenu(tabName, targetId, performCnt,docId,docClassDtl){
	var tf = true;
	
	//해당 메뉴로 이동  tabNme == 'K-SADS-PL'||  tabNme == 'SRS' || tabNme == 'CY-BOCS' || tabNme == 'YBOCS' 
	if(tabName == "공존진단"){
		var url = GLOBAL_CONTEXT_PATH + '/medical/target/targetListAo.view';
		location.href = url+"?chgTabNm="+tabName+"&targetId="+targetId+"&performCnt="+performCnt;
	}else if(tabName == "영상"){
		var url = GLOBAL_CONTEXT_PATH + '/medical/imaging/imagingListAo.view';
		location.href = url+"?chgTabNm="+tabName+"&targetId="+targetId+"&performCnt="+performCnt;
	}else if(tabName == 'K-SADS-PL'||  tabName == 'SRS' || tabName == 'CY-BOCS' || tabName == 'YBOCS'){
		
//		var url = GLOBAL_CONTEXT_PATH + '/medical/clinician/clinicianListAo.view';
//		location.href = url+"?chgTabNm="+tabName+"&targetId="+targetId+"&performCnt="+performCnt;
		
		var clinicianArr = ['K-SADS-PL', 'SRS','CY-BOCS','YBOCS']; 
		
		var clinicianCdArr = ['K-SADS-PL', 'srs01','cybo1','ybocs'];
		//var clinicianCdArr = ['K-SADS-PL', 'SRS','CYBO1','YBOCS'];
		
		for(c in clinicianArr){
			if(clinicianArr[c] == tabName){
				var url = GLOBAL_CONTEXT_PATH + '/medical/clinician/clinicianListAo.view';
				location.href = url+"?chgTabNm="+clinicianCdArr[c]+"&targetId="+targetId+"&performCnt="+performCnt;
			}
		}
	}
	else if(tabName == 'PHTs 3종 및 COT(소변)' || tabName == '중금속(혈액)'){
		if(tabName=='PHTs 3종 및 COT(소변)')tabName='PHTs 3종 및 COT(소변)';
		var url = GLOBAL_CONTEXT_PATH + '/medical/analysis/analListAo.view';
		location.href = url+"?chgTabNm="+tabName+"&targetId="+targetId+"&performCnt="+performCnt;
	}else if(tabName == "유전자정보"){
		if(tabName=='유전자정보')tabName='유전자정보';
		var url = GLOBAL_CONTEXT_PATH + '/medical/gene/geneList.view';
		location.href = url+"?chgTabNm="+tabName+"&targetId="+targetId+"&performCnt="+performCnt;
	}else{
		var neuropsyArr = ['지능검사', 'ATA','STROOP','CCTT','WCST','CAT','EXIT-II','CPT-3','TMT','ADOS','ADOS-2','PEP-R','SMS','CARS']
		
		var neuropsyCdArr = ['지능검사','ATA','STROOP','CCTT','WCST','CAT','EXIT-II','CPT-3','TMT','ADOS','ADOS-2','PEP-R','SMS','CARS'];
		
		for(j in neuropsyArr){
			if(neuropsyArr[j] == tabName){
				tf = false;
				var url = GLOBAL_CONTEXT_PATH + '/medical/neuropsy/neuropsyListAo.view';
				location.href = url+"?chgTabNm="+neuropsyCdArr[j]+"&targetId="+targetId+"&performCnt="+performCnt;
			}
		}
		
		if(tf){
			var surveyArr = ['주산기 발달력','KMCHAT','ARS','ABC','SIB','BPI','SCQ','부모 자녀<br/>AQ/EQ/SQ','K-ASDS','SSIS','트라우마','CMRS-P','CPCL','K-CBCL(구버전)',
							'CBCL 1.5-5','CBCL 6-18','LSD','QPGS-RⅢ','GSRS','KCSHQ','CDI','BDI 성인용','STAI-T','STAI-S','아동 자가<br/>AQ/EQ/SQ 아동용','아동 자가<br/>AQ/EQ/SQ 성인용',
							'IAT','K-척도','K-척도 성인용','RCMAS','트라우마 성인용','BDI(부모용)','STAI-T<br />(부모)','STAI-S<br />(부모)',
							'MBRI','AQ/EQ/SQ(부모용)','K-PSI'];
			var surveyCdArr = ['prdv1','kmcht','ars01','abc01','sib01','bpi01','scq01','pc3q1','kasds','ssis1','traum','cmrsp','cpcl','ocbcl','cbc15','ocb15','lsd01',
								'qpgsr','gsrs1','kcshq','cdi01','bdi02','stitc','stisc','cc3qc','cc3qa',
								'iat01','kscal','kscaa','rcmas','traua','bdi01','stitp','stisp','mbri1','pp3q1','kpsi1'];
			
			for(i in surveyArr){
				if(surveyArr[i] == tabName){
					var url = GLOBAL_CONTEXT_PATH + '/medical/survey/surveyListAo.view';
					location.href = url+"?chgTabNm="+surveyCdArr[i]+"&targetId="+targetId+"&performCnt="+performCnt;
				}
			}
		}
	}
}