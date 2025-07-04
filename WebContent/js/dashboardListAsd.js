var dashboardListGrid;
var dashboardListStore;
var dashboardListVStore;
var maxCntStore;
var searchParams = {};
var maxCnt;

function excelDownload() {
	if (dashboardListStore.getCount() == 0) {
		Ext.Msg.alert('Warning', '결과자료가 없습니다.');
		return false;
	} else {
		document.location.href = makeUrl(
			'/medical/main/dashboardListExcelDownload.do', searchParams);
	}

}

//수집현황 표
dashboardListGrid = function() {

	Ext.create("Ext.panel.Panel", {
		// 'resizable-panel',
		height: '373px',
		width: '100%',
		region: 'center',
		layout: 'border',
		renderTo: 'dashboardList',
		border: false,
		items: [{
			xtype: 'grid',
			id: 'dashboardList-grid',
			region: 'center',
			cls: 'grid-row-span',
			store: dashboardListStore,
			enableLocking: true,
			autoScroll: true,
			columnLines: true,
			stripeRows: true,
			loadMask: true,
			border: true,
			singleSelect: true,
			viewConfig: {
				enableTextSelection: true,
				markDirty: false,
				stripeRows: false,
			},
		}]

	});

}



Ext.onReady(function() {
	Ext.QuickTips.init();

	//차수 최대값
	maxCntStore = Ext.create('Ext.data.Store', {
		storeId: 'Staging',
		autoLoad: true,
		proxy: {
			type: 'ajax',
			extraParams: {
				classCdDtl: "DS003"
			},
			url: GLOBAL_CONTEXT_PATH
				+ '/medical/main/selectMaxPerformCnt.do',
			reader: {
				type: 'json',
				root: 'result'
			}
		},
		listeners: {
			load: function(store) {
				maxCnt = store.getAt(0).get('performCnt');
				searchParams = {
					performCnt: maxCnt,
					classCdDtl: "DS003"
				}
				dashboardListVStore.proxy.extraParams = searchParams;
				dashboardListVStore.load();
			}
		}
	});

	//V1부터 생성할 컬럼데이터
	dashboardListVStore = Ext.create('Ext.data.Store', {
		storeId: 'Staging',
		autoLoad: false,
		proxy: {
			type: 'ajax',
			async: true,
			url: GLOBAL_CONTEXT_PATH
				+ '/medical/main/selectDashboardListVcnt.do',
			reader: {
				type: 'json',
				root: 'result'
			}
		},
		listeners: {
			load: function() {
				dashboardListStore.load();
			},
			callback: function() {
			}
		}
	});

	//수집현황 표
	dashboardListStore = Ext.create('Ext.data.Store', {
		storeId: 'Staging',
		autoLoad: false,
		proxy: {
			type: 'ajax',
			extraParams: {
				classCdDtl: 'DS003'
			},
			url: GLOBAL_CONTEXT_PATH
				+ '/medical/main/selectDashboardList.do',
			reader: {
				type: 'json',
				root: 'result',
			}
		},
		listeners: {
			load: function(store) {
				var addColumns = [];
				var rec2;
				var rec3;
				var s4pc5;
				var s3pc5;
				var s2pc5;
				var s1pc5;
				var s1pc = [];
				var s4pc = [];
				var s3pc = [];
				var s2pc = [];

				var vNmArr = [];
				var title;
				var vNmSplit;
				var cntNm4;
				var cntNm3;
				var cntNm2;
				var cntNm1;


				addColumns.push({
					text: '항목',
					menuDisabled: true,
					sortable: false,
					locked: true,
					cls: 'title-header',
					defaults: {
						style: {
							display: 'none !important' //헤더 merge
						}
					},
					columns: [{
						dataIndex: 'classCdDtlNm',
						width: 125,
						align: 'center',
						text: '',
						locked: true,
						menuDisabled: true,
						sortable: false,
						renderer: function(value, meta, record, rowIndex, colIndex, store) {
							var first = !rowIndex || value !== store.getAt(rowIndex - 1).get('classCdDtlNm'),
								last = rowIndex >= store.getCount() - 1 || value !== store.getAt(rowIndex + 1).get('classCdDtlNm');
							meta.tdCls = 'row-span' + (first ? ' row-span-first' : '') + (last ? ' row-span-last' : '');

							if (first) {
								var i = rowIndex + 1;
								while (i < store.getCount() && value === store.getAt(i).get('classCdDtlNm')) {
									i++;
								}
								i = i - 1;
								var rowHeight = 45, padding = 6,
									height = (rowHeight * (i - rowIndex) - padding) + 'px';
								meta.style = 'height:' + height + ';line-height:' + height + ';width:100%;';
							}
							if (value == 'TIC군 총합') {
								meta.css = 'total';
							}
							return first ? value : '';
						},

					}, {
						dataIndex: 'sex',
						width: 60,
						align: 'center',
						text: '',
						locked: true,
						menuDisabled: true,
						sortable: false,
						renderer: function(value, meta, record, rowIndex, colIndex, store) {
							if (value == '셀삭제') {
								meta.css = 'totalMerge';
							}
							return value;
						}
					}]
				}, {
					text: 'V0(baseline)',
					menuDisabled: true,
					sortable: false,
					lockable: false,
					columns: [{
						dataIndex: 's3pc1',
						header: '완료',
						width: 100,
						//width : 58,
						align: 'center',
						sortable: false,
						menuDisabled: true
					}, {
						dataIndex: 's2pc1',
						header: '예정',
						width: 100,
						//width : 58,
						align: 'center',
						sortable: false,
						menuDisabled: true,
					}]
				}/*{
								text : '4wk 약물면담',
								menuDisabled : true,
								sortable: false	,
								columns : [{
									dataIndex : 's4pc2',
									header : 'DROP',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								},{
									dataIndex : 's3pc2',
									header : '완료',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								},{
									dataIndex : 's2pc2',
									header : '예정',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								}]
							},{
								text : '8wk 약물면담',
								menuDisabled : true,
								sortable: false	,
								columns : [{
									dataIndex : 's4pc3',
									header : 'DROP',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								},{
									dataIndex : 's3pc3',
									header : '완료',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								},{
									dataIndex : 's2pc3',
									header : '예정',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								}]
							},{
								text : '12wk 약물면담',
								menuDisabled : true,
								sortable: false	,
								columns : [{
									dataIndex : 's4pc4',
									header : 'DROP',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								},{
									dataIndex : 's3pc4',
									header : '완료',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								},{
									dataIndex : 's2pc4',
									header : '예정',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								}]
							}*/);

				//차수별 리스트 row
				var vCnt = dashboardListVStore.getCount() / 10;
				//차수 시작 카운트
				var pCnt = 5;
				//차수명
				var vNm = maxCntStore.getAt(0).get('performNm');
				if (vNm.indexOf(',') != -1) {
					vNmArr = vNm.split(',');
				} else {
					vNmArr.push(vNm);
				}

				var vTen = 0;

				//5 이후 차수만큼 10줄씩
				for (var j = 0; j < vCnt; j++) {
					vNmSplit = vNmArr[j];
					title = vNmSplit + ' (' + (j + 1) + '년 f/u)';

					//dataIndex
					cntNm4 = 's4pc' + pCnt;
					cntNm3 = 's3pc' + pCnt;
					cntNm2 = 's2pc' + pCnt;
					cntNm1 = 's1pc' + pCnt;

					for (var k = 0; k < dashboardListStore.getCount(); k++) {
						if (j == 0) {
							rec2 = dashboardListStore.getAt(k);
							rec3 = dashboardListVStore.getAt(k);

						} else {
							rec2 = dashboardListStore.getAt(k);
							rec3 = dashboardListVStore.getAt(k + vTen);
						}

						s4pc = rec3.get('s4pc5');
						s3pc = rec3.get('s3pc5');
						s2pc = rec3.get('s2pc5');
						s1pc = rec3.get('s1pc5');

						rec2.set(cntNm4, s4pc);
						rec2.set(cntNm3, s3pc);
						rec2.set(cntNm2, s2pc);
						rec2.set(cntNm1, s1pc);
					}

					addColumns.push({
						text: title,
						menuDisabled: true,
						sortable: false,
						flex: 14 / 100,
						columns: [{
							dataIndex: cntNm4,
							header: 'DROP',
							flex: 1,
							minWidth: 58,
							align: 'center',
							sortable: false,
							menuDisabled: true
						}, {
							dataIndex: cntNm3,
							header: '완료',
							flex: 1,
							minWidth: 58,
							align: 'center',
							sortable: false,
							menuDisabled: true
						}, {
							dataIndex: cntNm2,
							header: '예정',
							flex: 1,
							minWidth: 58,
							align: 'center',
							sortable: false,
							menuDisabled: true
						}, {
							dataIndex: cntNm1,
							header: '대기',
							flex: 1,
							minWidth: 58,
							align: 'center',
							sortable: false,
							menuDisabled: true
						}]
					});


					pCnt++;
					vTen += 10;
				}

				Ext.getCmp("dashboardList-grid").reconfigure(dashboardListStore, addColumns);
				dashboardListStore.commitChanges();

			}
		}


	});


	new dashboardListGrid();


});



