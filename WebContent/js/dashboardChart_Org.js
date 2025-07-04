var lineChartPanel;
var lineChartListStore;
var barChartPanel;
var barChartListStore;
var barLineTotalStore;
var dashboardListGrid;
var dashboardListStore;
var dashboardListVStore;
var maxCntStore;
var chartLimits=[];

var searchParams = {};

var maxCnt;

var yyyyArr = [];
var tmp = [];
var ptc03Arr = [];
var ptc01Arr = [];
var ptc02Arr = [];
var totalArr = [];

var yyyyArrLine = [];
var ptc03ArrLine = [];
var ptc01ArrLine = [];
var ptc02ArrLine = [];

var v1;
var v2;
var v3;
var v4;

function excelDownload() {
	if (dashboardListStore.getCount() == 0) {
		Ext.Msg.alert('Warning', '결과자료가 없습니다.');
		return false;
	}else {
		document.location.href = makeUrl(
				'/medical/main/dashboardListExcelDownload.do', searchParams);
	}

}

function barLineChart(){
//CHART CONFIG //막대그래프
//-----------------------------
barChartPanel = {
		type: 'mixed',
		title : {
			text : 'Tic 임상연구 대상자 Enroll 현황',
			fontSize : '16px',
			textAlign : 'left',
			x : '22px',
			fontColor : '#00384A'
		},
		globals: {
		 fontFamily: 'Arial'
		},
		backgroundColor: '#FFFFFF',
		width: '100%',
		legend: {
		margin: 'auto 47 auto auto',
		 backgroundColor: 'none',
		 borderWidth: '0px',
		 item: {
		   fontColor: '#7E7E7E',
		   fontSize : '12px'
		 },
		 
		 layout: 'float',
		 marker: {
		   type: 'circle',
		   size: 5
		 },
		 shadow: false,
		 toggleAction: 'remove',
		 y: '30px'
		},
		plot: {
		 barSpace: '10px',
		},
		scaleX: {
		values : yyyyArr,
		 guide: {
		   visible: false
		 },
		 item: {
		   color: '#8B8B8B',
		   fontSize : '13px'
		 },
		 lineColor: '#D9D7D5',
		 lineWidth: '1px',
		 tick: {
		   visible: true,
		   lineColor: '#d2dae2',
	          lineWidth: '1px'
		 },
		 zooming: true,
	     zoomTo: [
	       0,
	       5
	     ]
		},
		scaleY: {
			values : '0:'+v1+':'+v2,
	        guide: {
	          lineStyle: 'solid',
	        },
	        item: {
	          fontColor: '#8B8B8B',
	          fontFamily: 'Arial',
	          fontSize : '13px'
	        },
	        lineColor: '#D9D7D5',
	        tick: {
		 		   visible: true,
		 		   lineColor: '#d2dae2',
		 	       lineWidth: '1px'
		 		 },
	      },
		
		
		scrollX: {
		    bar: {
		      alpha: 0.1,
		      backgroundColor: '#a6a6a6',
		      borderRadius: '1px'
		    },
		    handle: {
		      backgroundColor: 'white',
		      borderRadius: '5px',
		      borderTop: '0.5px solid #a6a6a6',
		      borderRight: '0.5px solid #a6a6a6',
		      borderBottom: '0.5px solid #a6a6a6',
		      borderLeft: '0.5px solid #a6a6a6'
		    },
		    
		  },
		series: [
			{
			   type: 'bar',
			   text: '비약물군',
			   values: ptc03Arr,
			   backgroundColor: '#F29E4A',
			   barWidth: '10px',
			   hoverState: {
			     visible: false
			   },
			   
			 },
			 {
			   type: 'bar',
			   text: '약물(단기)',
			   values: ptc01Arr,
			   backgroundColor: '#7BBADE',
			   barWidth: '10px',
			   hoverState: {
			     visible: false
			   }
			 },
			 {
			   type: 'bar',
			   text: '약물(장기)',
			   values: ptc02Arr,
			   backgroundColor: '#93DE7F',
			   barWidth: '10px',
			   hoverState: {
			     visible: false
			   }
		 },
		 {
		   type: 'line',
		   text: 'TOTAL',
		   values: totalArr,		   
		   aspect: 'Straight',
		   highlight: false,
		   lineColor: '#8B8B8B',
		   lineWidth: '2px',
		   marker: {
		     backgroundColor: '#FFFFFF',
		     borderColor: '#8B8B8B',
		     borderWidth: '2px',
		     shadow: false
		   }
		 }
		 ]
};
}

function lineChart(){
//라인그래프
lineChartPanel = {
		  backgroundColor: '#ecf2f6',
		  graphset: [
		    {
		      type: 'line',
		      backgroundColor: '#fff',
		      borderColor: '#dae5ec',
		      width: '100%',
		      height: '100%',
		      plot: {
		        animation: {
		          delay: 500,
		          effect: 'ANIMATION_SLIDE_LEFT'
		        }
		      },
		      scaleY: {
		        values : '0:'+v3+':'+v4,
		        guide: {
		          lineStyle: 'solid',
		        },
		        item: {
		          fontColor: '#8B8B8B',
		          fontFamily: 'Arial',
		          fontSize : '13px'
		        },
		        lineColor: '#D9D7D5',
		        tick: {
			 		   visible: true,
			 		   lineColor: '#d2dae2',
			 	       lineWidth: '1px'
			 		 },
		      }, 
		      legend: {
			        margin: 'auto 55 auto auto',
			        backgroundColor: 'none',
			        borderWidth: '0px',
			        item: {
			          margin: '0px',
			          padding: '0px',
			          fontColor: '#7E7E7E',
			          fontSize : '12px'
			        },
			        layout: 'float',
			        marker: {
			          type: 'match',
			          lineWidth: '2px',
			          showLine: 'true',
			          size: 5
			        },
			        y : '30px',
			        shadow: false
			      },
			      scaleLabel: {
				        padding: '5px 10px',
				        backgroundColor: '#707d94',
				        borderRadius: '5px',
				        fontColor: '#ffffff',
				        fontFamily: 'Arial',
				        fontSize: '10px'
				      },
				      crosshairX: {
				        lineColor: '#707d94',
				        lineWidth: '1px',
				        plotLabel: {
				          padding: '5px 10px',
				          alpha: 1,
				          borderRadius: '5px',
				          fontColor: '#000',
				          fontFamily: 'Arial',
				          fontSize: '10px',
				          shadow: false
				        }
				      },
				      tooltip: {
				        visible: false
				      },
		      scaleX: {
		        values: yyyyArrLine,
		        guide: {
		          visible: false
		        },
		        item: {
		          paddingTop: '5px',
		          fontColor: '#8391a5',
		          fontFamily: 'Arial',
		          fontSize: '13px'
		        },
		        lineColor: '#d2dae2',
		        lineWidth: '2px',
		        tick: {
		          lineColor: '#d2dae2',
		          lineWidth: '1px'
		        },
		        zooming: true,
			     zoomTo: [
			       0,
			       5
			     ]
		      },
		      scrollX: {
				    bar: {
				      alpha: 0.1,
				      backgroundColor: '#a6a6a6',
				      borderRadius: '1px'
				    },
				    handle: {
				      backgroundColor: 'white',
				      borderRadius: '5px',
				      borderTop: '0.5px solid #a6a6a6',
				      borderRight: '0.5px solid #a6a6a6',
				      borderBottom: '0.5px solid #a6a6a6',
				      borderLeft: '0.5px solid #a6a6a6'
				    },
				    
				  },
		      
		      series: [
		        {
		          text: '비약물군',
		          values: ptc03ArrLine,
		          lineColor: '#F29E4A',
		          lineWidth: '2.5px',
		          marker: {
		            backgroundColor: '#fff',
		            borderColor: '#F29E4A',
		            borderWidth: '2px',
		            shadow: false,
		          },
		          palette: 0,
		          shadow: false
		        },
		        {
		          text: '단기약물군치료',
		          values: ptc01ArrLine,
		          lineColor: '#7BBADE',
		          lineWidth: '2.5px',
		          marker: {
		            backgroundColor: '#fff',
		            borderColor: '#7BBADE',
		            borderWidth: '2px',
		            shadow: false,
		          },
		          palette: 1,
		          shadow: false,
		          visible: true
		        },
		        {
		          text: '장기약물노출군',
		          values: ptc02ArrLine,
		          lineColor: '#93DE7F',
		          lineWidth: '2.5px',
		          marker: {
		            backgroundColor: '#fff',
		            borderColor: '#93DE7F',
		            borderWidth: '2px',
		            shadow: false,
		          },
		          palette: 2,
		          shadow: false,
		          visible: true
		        }
		      ]
		    }
		  ]
		};
}

//수집현황 표
dashboardListGrid = function() {

	Ext.create( "Ext.panel.Panel",{
					// 'resizable-panel',
					height : '373px',
					region : 'center',
					layout : 'border',
					renderTo : 'dashboardList',
					scrollbars: true,
					border : false,
					items : [ {
						xtype : 'grid',
						id : 'dashboardList-grid',
						region : 'center',
		                cls: 'grid-row-span',
						store : dashboardListStore,
						enableLocking: true,
						//autoScroll : true,
						columnLines : true,
						stripeRows : true,
						loadMask : true,
						border : true,
						singleSelect : true,
						viewConfig:{
							enableTextSelection: true,
		    				markDirty: false,
		    				stripeRows: false,
						},
					} ]

				});

}



Ext.onReady(function() {
	Ext.QuickTips.init();
	
	//막대그래프
	barChartListStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		proxy : {
			type : 'ajax',
			extraParams : {
				classCdDtl : 'DS001'
			},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/main/selectDashboardBarData.do',
			reader : {
				type : 'json',
				root : 'result'
			}

		},
		listeners : {
			load :  function(store) {
				
				if(store.getTotalCount == 0){
					yyyyArr = ['2020'];
					ptc03Arr = [0];
					ptc01Arr = [0];
					ptc02Arr = [0];

				}else{
				for(var i=0; i<store.getTotalCount(); i++){
					var rec = store.getAt(i);
					
					//년도 중복제거
					tmp.push(rec.get("yyyy"));
					$.each(tmp, function(i, el){
					    if($.inArray(el, yyyyArr) === -1) yyyyArr.push(el);
					});
					
					//각 프로토콜 값
					if(rec.get("classCdDtl").indexOf('비약물군') != -1){
						ptc03Arr.push(parseInt(rec.get("pcount")));
					}else if(rec.get("classCdDtl").indexOf('단기') != -1){
						ptc01Arr.push(parseInt(rec.get("pcount")));
					}else if(rec.get("classCdDtl").indexOf('장기') != -1){
						ptc02Arr.push(parseInt(rec.get("pcount")));
					}
					
					}
				}
				
				barLineTotalStore.load();

			}
		}
	});
	
	//막대 라인 total 값
	barLineTotalStore= Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : false,
		proxy : {
			type : 'ajax',
			extraParams : {
				classCdDtl : 'DS001'
			},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/main/selectDashboardBarDataTotal.do',
			reader : {
				type : 'json',
				root : 'result'
			}
		},
		listeners : {
			load :  function(store) {
				var rec2 = store.getAt(0);
				
				if(rec2 == null){
					totalArr = [0];
					v1 = '50';
					v2 = '10';
				}else{
				
				for(var i=0; i<store.getTotalCount(); i++){
					var rec = store.getAt(i);
					totalArr.push(parseInt(rec.get("yyyyTotal")));
				}
				
				v1 = rec2.get("yValue1");
				v2 = rec2.get("yValue2");
				}
				
				barLineChart();
				
				zingchart.render({
					id: 'barChart',
					data: barChartPanel,
					height : '100%',
					width: '100%'
					});
			}
		}
	});

	
	//라인그래프
	lineChartListStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		proxy : {
			type : 'ajax',
			extraParams : {
				classCdDtl : 'DS001'
			},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/main/selectDashboardData.do',
			reader : {
				type : 'json',
				root : 'result',
				totalProperty: 'total'
			}

		},
		listeners : {
			load :  function(store) {
				
			
				if(store.getTotalCount() == 0){
					yyyyArrLine = ['2020'];
					ptc03ArrLine = [0];
					ptc01ArrLine = [0];
					ptc02ArrLine = [0];
					v3 = '50';
					v4 = '10';
				}else{
				
				for( var i=0; i<store.getTotalCount();i++){
					var rec = store.getAt(i);
					console.log(rec)
					yyyyArrLine.push(rec.get("yyyy"));
					ptc03ArrLine.push(parseInt(rec.get("ptc03")));
					ptc01ArrLine.push(parseInt(rec.get("ptc01")));
					ptc02ArrLine.push(parseInt(rec.get("ptc02")));
				}
				
	
				var rec2 = store.getAt(0);
				v3 = rec2.get("yValue3");
				v4 = rec2.get("yValue4");
				
				console.log(ptc01ArrLine)
				}
				
				lineChart();
				
				zingchart.render({
					  id: 'lineChart',
					  data: lineChartPanel,
					  height: '100%',
					  width: '100%',
					});
			}
		}
	});
	

	
	//차수 최대값
	maxCntStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		proxy : {
			extraParams : {
				classCdDtl : "DS001"
			},
			type : 'ajax',
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/main/selectMaxPerformCnt.do',
			reader : {
				type : 'json',
				root : 'result'
			}
		},
		listeners : {
			load :  function(store) {
				maxCnt = store.getAt(0).get('performCnt');
				searchParams = {
						performCnt : maxCnt,
						classCdDtl : 'DS001'
				}
				dashboardListVStore.proxy.extraParams = searchParams;
				dashboardListVStore.load();
			}
		}
});
	
	//V1부터 생성할 컬럼데이터
	dashboardListVStore= Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : false,
		proxy : {
			type : 'ajax',
			async : true,
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/main/selectDashboardListVcnt.do',
			reader : {
				type : 'json',
				root : 'result'
			}
		},
		listeners : {
			load :  function() {
				dashboardListStore.load();
			},
			callback : function() {
			}
		}
	});
	
	//수집현황 표
	dashboardListStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : false,
		proxy : {
			type : 'ajax',
			extraParams : {
				classCdDtl : 'DS001'
			},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/main/selectDashboardList.do',
			reader : {
				type : 'json',
				root : 'result',
			}
		},
		listeners : {
			load :  function(store) {
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
								text : '항목',
								menuDisabled : true,
								sortable: false	,
								locked : true,
								cls : 'title-header',
								defaults: {
							      style: { 
							    	  display: 'none !important' //헤더 merge
							      } 
							    },
								columns : [{
									dataIndex : 'classCdDtlNm',
									width : 125,
									align : 'center',
									text : '',
									locked : true,
									menuDisabled : true,
									sortable: false	,
									renderer: function (value, meta, record, rowIndex, colIndex, store) {	  
					                    	var first = !rowIndex || value !== store.getAt(rowIndex - 1).get('classCdDtlNm'),
						                        last = rowIndex >= store.getCount() - 1 || value !== store.getAt(rowIndex + 1).get('classCdDtlNm');
						                    meta.tdCls = 'row-span' + (first ? ' row-span-first' : '') +  (last ? ' row-span-last' : '');
						                    
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
						                    if(value == 'TIC군 총합'){
						                    	meta.css = 'total';
						                    }
					                    	return first ? value : '';
				                	},
									
								},{
									dataIndex : 'sex',
									width : 60,
									align : 'center',
									text : '',
									locked : true,
									menuDisabled : true,
									sortable: false	,
									renderer: function (value, meta, record, rowIndex, colIndex, store) {	  
					                    if(value == '셀삭제'){
					                    	meta.css = 'totalMerge';
					                    }
				                    	return value;
			                	}	
								}]
							},{
								text : 'V0(baseline)',
								menuDisabled : true,
								sortable: false	,
								lockable : false,
								columns : [{
									dataIndex : 's3pc1',
									header : '완료',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								},{
									dataIndex : 's2pc1',
									header : '예정',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true,
								}]
							},{
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
							});
				
				//차수별 리스트 row
				var vCnt = dashboardListVStore.getCount()/10;
				//차수 시작 카운트
				var pCnt = 5;
				//차수명
				var vNm = maxCntStore.getAt(0).get('performNm');
				if (vNm.indexOf(',') != -1){
					vNmArr = vNm.split(',');
				}else{
					vNmArr.push(vNm);
				}
				
				var vTen = 0;
				
					//5 이후 차수만큼 10줄씩
					for(var j = 0; j < vCnt; j++){
						vNmSplit = vNmArr[j];
						title = vNmSplit+' ('+(j+1)+'년 f/u)';
						
						//dataIndex
						cntNm4 = 's4pc'+pCnt;
						cntNm3 = 's3pc'+pCnt;
						cntNm2 = 's2pc'+pCnt;
						cntNm1 = 's1pc'+pCnt;
						
						for(var k = 0; k < dashboardListStore.getCount(); k++){
							if(j == 0){
							rec2 = dashboardListStore.getAt(k);
							rec3 = dashboardListVStore.getAt(k);
							
							}else{
							rec2 = dashboardListStore.getAt(k);
							rec3 = dashboardListVStore.getAt(k+vTen);	
							}
							
							s4pc = rec3.get('s4pc5');
							s3pc = rec3.get('s3pc5');
							s2pc = rec3.get('s2pc5');
							s1pc = rec3.get('s1pc5');
							
							rec2.set(cntNm4,s4pc);
							rec2.set(cntNm3,s3pc);
							rec2.set(cntNm2,s2pc);
							rec2.set(cntNm1,s1pc);
						}
						
						
							addColumns.push({
								text : title,
								menuDisabled : true,
								sortable: false	,
								flex : 14/100,
								scrollbars: true,
								columns : [{
									dataIndex : cntNm4,
									header : 'DROP',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								},{
									dataIndex : cntNm3,
									header : '완료',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								},{
									dataIndex : cntNm2,
									header : '예정',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								},{
									dataIndex : cntNm1,
									header : '대기',
									width : 58,
									align : 'center',
									sortable : false,
									menuDisabled : true
								}]
							});
						
						pCnt++;
						vTen += 10;
					}
				
				Ext.getCmp("dashboardList-grid").reconfigure(dashboardListStore, addColumns);
				dashboardListStore.commitChanges();
				
			}
		}//load 끝
		
		
	});
	
	
	new dashboardListGrid();
	
	
});



