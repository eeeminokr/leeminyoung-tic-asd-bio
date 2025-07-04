var DataIntegration = {};
var tabStore;
var ajxTabStore;
var docDtlStore;
var docDtlListGrid;
var tabList ='';
var searchParams = {};
var ticDtlPanel;
var multiChoiceValid = {};
var docColumn = {};
var dataIntegrationDtlStore;
var dataIntegrationSurveyStore;
var dataIntegrationClinicianStore;
var targetId = pageLoad.getParameter('targetId');
var docClassDtl = pageLoad.getParameter('docClassDtl');
var docId = pageLoad.getParameter('docId');
console.log(docClassDtl+" :docClassDtl파라미터값으로 가져와지냐??????????????")
console.log(docId+" :docId파라미터값으로 가져와지냐??????????????")
var sPerformCnt = 'V0';
var sDocClassDtl = 'DC004';
var performYel;
var performYelList = [];



DataIntegration.DataIntegrationDtlListPanel  = function() {
	DataIntegration.DataIntegrationDtlListPanel.superclass.constructor.call(this, {
			xtype : 'grid',
			id : 'ticDocDtl-grid',
			region : 'center',
			store : docDtlStore,
			height : '800px',
			renderTo : 'ticDocDtl',
			rowNumberer : true,
			trackMouseOver : true,
			autoScroll : true,
			columnLines : true,
			stripeRows : true,
			loadMask : true,
			border : true,
			singleSelect: true,
			cls: 'dataintegration-grid',
			viewConfig: {
	            enableTextSelection: true,
	            markDirty: false,
	            listeners : {
	                refresh : function (dataview) {
		                Ext.each(dataview.panel.columns, function (column) {
			                if (column.autoSizeColumn === true) column.autoSize();
		               	})
	               	}
	            }
	        },
			columns : [{
				text : '번호',
			    dataIndex: 'inqNo',
			    sortable : false,
				align : 'center',
//				flex : 5/100,
				width : 50,
			    // other config you need..
			    renderer : function(value, metaData, record, rowIndex){
			    	rowNum = rowIndex+1;
			    	record.set('inqNo', rowNum);
			    	// 번호 수정
					var rec = docDtlStore.getAt(0);
						if(rec.get("docId") == 'KASDS'){//K-ASDS
							if(rowNum > 9 && rowNum < 23){
								rowNum = rowNum-9;
							}else if(rowNum > 22 && rowNum < 34){
								rowNum = rowNum-22;
							}else if(rowNum > 33 && rowNum < 44){
								rowNum = rowNum-33;
							}else if(rowNum > 43){
								rowNum = rowNum-43;
							}
						}else if(rec.get("docId") == 'BPI01'){//부모자녀평가 AQ/EQ/SQ
							if(rowNum > 15 && rowNum < 41 ){
								rowNum = rowNum-15;
							}else if(rowNum > 40 && rowNum < 53 ){
								rowNum = rowNum-40;
							}	
		
						}else if(rec.get("docId") == 'PC3Q1'){//부모자녀평가 AQ/EQ/SQ
							if(rowNum > 50){
								rowNum = rowNum-50;
							}
						}else if(rec.get("docId") == 'SCQ01'){//SCQ
							if(rowNum > 40){
								rowNum = rowNum-40;
							}
						}else if(rec.get("docId") == 'PP3Q1'){ //부모자가평가 AQ/EQ/SQ
							if(rowNum > 60 && rowNum < 136){rowNum = rowIndex-59};
							if(rowNum > 135 && rowNum <= 185){rowNum = rowIndex-134}
						}else if(rec.get("docId") == 'CC3QA'){ //아동자가평가 AQ/EQ/SQ 성인용
							
							if(rowNum > 60 && rowNum < 136){rowNum = rowIndex-59};
							
							if(rowNum > 135 && rowNum <= 185){rowNum = rowIndex-134};
							
						}else if(rec.get("docId") == 'CC3QC'){ //아동자가평가 AQ/EQ/SQ 아동용
							if(rowNum > 50 && rowNum <= 105){rowNum = rowIndex-49};
						}else if(rec.get("docId") == 'SIB01'){//SIB
							if(rowNum >= 6 && rowNum <= 10){
								rowNum = rowNum-5;
							}else if(rowNum >= 11 && rowNum <= 15){
								rowNum = rowNum-10;
							}else if(rowNum >= 16 && rowNum <= 20){
								rowNum = rowNum-15;
							}else if(rowNum >= 21 && rowNum <= 25){
								rowNum = rowNum-20;
							}else if(rowNum >= 26 && rowNum <= 30){
								rowNum = rowNum-25;
							}else if(rowNum >= 31 && rowNum <= 35){
								rowNum = rowNum-30;
							}else if(rowNum >= 36 && rowNum <= 40){
								rowNum = rowNum-35;
							}
						}else if(rec.get("docId") == 'LSD01'){//LSD
							if(rowNum == 9){
								rowNum = 9+"-"+1;
							}else if(rowNum == 10){
								rowNum = 9+"-"+2;
							}else if(rowNum == 11){
								rowNum = 9+"-"+3;
							}else if(rowNum == 12){
								rowNum = 9+"-"+4;
							}else if(rowNum == 13){
								rowNum = 9+"-"+5;
							}else if(rowNum >= 14){
								rowNum = rowNum-13;
							}
						}else if(rec.get("docId") == 'OCBCL' || rec.get("docId") == 'OCB15'){//K-CBCL(구버전) & 구CBCL 1.6-8
							if(rowNum == 56){
								rowNum = "56a";
							}else if(rowNum == 57){
								rowNum = "56b";
							}else if(rowNum == 58){
								rowNum = "56c";
							}else if(rowNum == 59){
								rowNum = "56d";
							}else if(rowNum == 60){
								rowNum = "56e";
							}else if(rowNum == 61){
								rowNum = "56f";
							}else if(rowNum == 62){
								rowNum = "56g";
							}else if(rowNum == 63){
								rowNum = "56h";
							}else if(rowNum >= 64 && rowNum <= 120){
								rowNum = rowNum-7;
							}else if(rowNum == 121){
								rowNum = "113-1";
							}else if(rowNum == 122){
								rowNum = "113-2";
							}else if(rowNum == 123){
								rowNum = "113-3";
							}
						}else if(rec.get("docId") == 'OCB15'){//CBCL1.5-5 
							if(rowNum == 101){
								rowNum = "100-1";
							}else if(rowNum == 102){
								rowNum = "100-2";
							}else if(rowNum == 103){
								rowNum = "100-3";
							}
						}
			    	
			        return '<ul class="survey_list"><li><div class="list_q"><span class="num">' + rowNum + '</span></div></li></ul>';
			    },
			    hidden : false
			},{
				text : '문항',
				dataIndex : 'inqContent',
				flex : 40 / 100,
				align : 'left',
				menuDisabled : true,
				renderer : function(value, metaData, record, rowIndex){
			        return '<div class="list_q"><span class="inqContent">' + value + '</span></div>';
			    }
			},{
				text : '',
				dataIndex : 'multiChoice1',
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice1 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
//					console.log(rowIndex + ', inqu?: ' + record.get('inqTypeCd'));
					if(value != '' || record.get('inqTypeCd') == 'INQU2'){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-1-Y" name="' + rowIndex + '-1Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){							
							return '<div class="list_q"><span class="inqContent"></span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-1Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-1-Y" name="' + rowIndex + '-1Y" disabled style="margin-left: 15px;">';
						}else if(record.get('inqTypeCd') == 'INQU4'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-1-Y" name="' + rowIndex + '-1Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}	
				}
			},{
				text : '',
				dataIndex : 'multiChoice2',
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice2 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-2-Y" name="' + rowIndex + '-2Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-2Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-2-Y" name="' + rowIndex + '-2Y" disabled style="margin-left: 15px;">';
						}else if(record.get('inqTypeCd') == 'INQU4'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-2-Y" name="' + rowIndex + '-2Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}	
				}
			},{
				text : '',
				dataIndex : 'multiChoice3',
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice3 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-3-Y" name="' + rowIndex + '-3Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-3Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-3-Y" name="' + rowIndex + '-3Y" disabled style="margin-left: 15px;">';
						}else if(record.get('inqTypeCd') == 'INQU4'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="' + rowIndex + '-3-Y" name="' + rowIndex + '-3Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}
					}else{
						return ''
					}	
				}
			},{
				text : '',
				dataIndex : 'multiChoice4',
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice4 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-4-Y" name="' + rowIndex + '-4Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-4Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-4-Y" name="' + rowIndex + '-4Y" disabled style="margin-left: 15px;">';
						}else if(record.get('inqTypeCd') == 'INQU4'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="' + rowIndex + '-4-Y" name="' + rowIndex + '-4Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice5',
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice5 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-5-Y" name="' + rowIndex + '-5Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-5Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-5-Y" name="' + rowIndex + '-5Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice6',
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice6 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-6-Y" name="' + rowIndex + '-6Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-6Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-6-Y" name="' + rowIndex + '-6Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice7',
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice7 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-7-Y" name="' + rowIndex + '-7Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-7Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-7-Y" name="' + rowIndex + '-7Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice8',
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice8 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-8-Y" name="' + rowIndex + '-8Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-8Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-8-Y" name="' + rowIndex + '-8Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice9',
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice9 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-9-Y" name="' + rowIndex + '-9Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-9Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-9-Y" name="' + rowIndex + '-9Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice10',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice10 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-10-Y" name="' + rowIndex + '-10Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-10Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-10-Y" name="' + rowIndex + '-10Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice11',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice11 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-11-Y" name="' + rowIndex + '-11Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-11Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-11-Y" name="' + rowIndex + '-11Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice12',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice12 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-12-Y" name="' + rowIndex + '-12Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-12Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-12-Y" name="' + rowIndex + '-12Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice13',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice13 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-13-Y" name="' + rowIndex + '-13Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-13Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-13-Y" name="' + rowIndex + '-13Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice14',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice14 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-14-Y" name="' + rowIndex + '-14Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-14Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-14-Y" name="' + rowIndex + '-14Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice15',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice15 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-15-Y" name="' + rowIndex + '-15Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-15Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-15-Y" name="' + rowIndex + '-15Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice16',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice16 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-16-Y" name="' + rowIndex + '-16Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-16Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-16-Y" name="' + rowIndex + '-16Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice17',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice17 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-17-Y" name="' + rowIndex + '-17Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-17Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-17-Y" name="' + rowIndex + '-17Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice18',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice18 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-18-Y" name="' + rowIndex + '-18Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-18Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-18-Y" name="' + rowIndex + '-18Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice19',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice19 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-19-Y" name="' + rowIndex + '-19Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-19Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-19-Y" name="' + rowIndex + '-19Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice20',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice20 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-20-Y" name="' + rowIndex + '-20Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-20Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-20-Y" name="' + rowIndex + '-20Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice21',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice21 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-21-Y" name="' + rowIndex + '-21Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-21Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-21-Y" name="' + rowIndex + '-21Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice22',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice22 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-22-Y" name="' + rowIndex + '-22Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-22Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-22-Y" name="' + rowIndex + '-22Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice23',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice23 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-23-Y" name="' + rowIndex + '-23Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-23Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-23-Y" name="' + rowIndex + '-23Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice24',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice24 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-24-Y" name="' + rowIndex + '-24Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-24Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-24-Y" name="' + rowIndex + '-24Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice25',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice25 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-25-Y" name="' + rowIndex + '-25Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-25Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-25-Y" name="' + rowIndex + '-25Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice26',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice26 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-26-Y" name="' + rowIndex + '-26Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-26Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-26-Y" name="' + rowIndex + '-26Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice27',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice27 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-27-Y" name="' + rowIndex + '-27Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-27Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-27-Y" name="' + rowIndex + '-27Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}
			},{
				text : '',
				dataIndex : 'multiChoice28',
//				flex : 10/100,
//				autoSizeColumn : true,
				flex : 15 / 100,
				align : 'center',
				menuDisabled : true,
				hidden : multiChoiceValid.multiChoice28 == ''?true:false,
				renderer : function(value, metaData, record, rowIndex){
//			    	record.set('inqNo', rowIndex + 1);
					if(value != ''){
						if(record.get('inqTypeCd') == 'INQU1'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><label><input type="radio" id="' + rowIndex + '-28-Y" name="' + rowIndex + '-28Y" disabled style="margin-left: 15px;"><span></span></label>';
						}else if(record.get('inqTypeCd') == 'INQU2'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><textarea id="subjectAnswer" name="' + rowIndex + '-28Y" cols="12" rows="4" disabled>입력값 없음</textarea>'
						}else if(record.get('inqTypeCd') == 'INQU3'){
							return '<div class="list_q"><span class="inqContent">' + value + '</span></div>' + '<br><input type="checkbox" id="' + rowIndex + '-28-Y" name="' + rowIndex + '-28Y" disabled style="margin-left: 15px;">';
						}
					}else{
						return ''
					}					
				}

			}]
	});
};

Ext.extend(DataIntegration.DataIntegrationDtlListPanel, Ext.grid.GridPanel, {
});

Ext.onReady(function(){	
	Ext.QuickTips.init();
	
	document.getElementById('targetId').innerHTML = targetId;

	//왼쪽메뉴 변경
	parent.leftMenuChg('','AO08');

	console.log(menuDisClassDtl);
	ajxTabStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		fields: ['docId', 'docNm','docClassDtl'],
		proxy : {
			type : 'ajax',
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/dataIntegrationAsd/selectTicDocDtlList.do',
			reader : {
				type : 'json',
				root : 'result'
			},
			extraParams : {
				
				docId : docId,
				disClassDtl : menuDisClassDtl,
				docClassDtl : docClassDtl
			}
//			params:{
//				targetId : targetId
//				, disClassDtl : menuDisClassDtl
//				, sex : sex
//				, birthYm  : birthYm
//				, protocol : protocol
//				, performCntMaxNm : performCntMaxNm
//			}
		},
		listeners : {
			load : function() {	
				var tabGrid;
				tabList = '[';
				Ext.each(ajxTabStore.getRange(), function(record) {
					//설문지 탭 생성
					tabList += '{title: "'+ record.get('docNm') + '"},';
				});
				tabList += ']';
				var activeTabRec = ajxTabStore.getAt(0);
//				console.log(activeTabRec.get('docNm'));
				// 초기 세팅
				searchParams = {
    	    			//docId : activeTabRec.get('docId'),
						docId : 'SRS01',
    	    			disClassDtl : menuDisClassDtl,
    	    			docClassDtl : docClassDtl
    	    	}
    	    	docDtlStore.proxy.extraParams = searchParams;	
    	    	docDtlStore.load();
    	    	docDtlStore.removeAll();
    	    	//docDtlStore.load();
    	    	docDtlStore.on('load', function(store, records, successful){ //불러온 설문지 항목 갯수에 맞게 컬럼 숨김/보이기
        	    	docTabLoad();
        	    	dataIntegrationSurveyLoad('SRS01', sPerformCnt ,'DC004');
    	    	});				    	 
    	    	console.log("docClassDtl 탭부분: "+docClassDtl)
				//new docDtlListGrid();
//    	    	dataIntegrationSurveyLoad('ARS01', sPerformCnt);
    	    	document.getElementById('SRS01').style.fontWeight = '700';
    	    	document.getElementById('SRS01').style.backgroundColor = 'yellow';
    	    	$('#clinical').parent().children().eq(1).children('td').css('background-color','yellow');
			},
			callback : function() {
			}
		}
	});

	
	docDtlStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : false,
		proxy : {
			type : 'ajax',
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/dataIntegrationAsd/selectTicDocDtl.do',
			reader : {
				type : 'json',
				root : 'result'
			}
		},
		listeners : {
			load : function() {
			},
			callback : function() {
			}
		}
	});

//	var rec1 = dataIntegrationSurveyStore.getAt(0);
//	var rec2 = docDtlStore.getAt(j);

	
	console.log(docId+"DOCid==================================")
	dataIntegrationSurveyStore = Ext.create('Ext.data.Store', {

		storeId : 'Staging',
		autoLoad : false,
		
		proxy : {
			
			type : 'ajax',
			
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/surveyAsd/selectSurveyListAo.do',
					
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

	dataIntegrationClinicianStore = Ext.create('Ext.data.Store', {

		storeId : 'Staging',
		autoLoad : false,
		
		proxy : {
			
			type : 'ajax',
			
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
	
	
	
	docDtlListGrid = function() {
		   Ext.create('Ext.tab.Panel', {
			   id: 'testTabPanel',
	           renderTo: 'ticDocTabs',
//	           plugins: ['viewport'],
	           // Reconfigure tab bar for multiple rows by setting
	           // layout to 'column' and disabling overflow handler
	           listeners: {
	        	    tabchange: function(tabPanel, newTab, oldTab, eOpts)  {

	        	    	searchParams = {
	        	    			docNm : newTab.title
	        	    	}
	        	    	docDtlStore.proxy.extraParams = searchParams;	
	        	    	docDtlStore.load();
	        	    	docDtlStore.removeAll();
	        	    	docDtlStore.on('load', function(store, records, successful){
		        	    	docTabLoad();
	        	    	});
	        	    }
	           },
	       })
		
	}
	new DataIntegration.DataIntegrationDtlListPanel();
	
	dataIntegrationDtlStore = Ext.create('Ext.data.Store', {
		storeId : 'Staging',
		autoLoad : true,
		proxy : {
			type : 'ajax',
			async : false,
			extraParams : { targetId : targetId,
							rndId : loginRndId,
							disClassDtl : menuDisClassDtl,
							docClassDtl : docClassDtl},
			url : GLOBAL_CONTEXT_PATH
					+ '/medical/dataIntegrationAsd/selectDataIntegrationDtlListAo.do',
			reader : {
				type : 'json',
				root : 'result'
			
			}

		},
		listeners : {
			load : function(store, meta) {
					var data;
					var inStr;
					var tNum;
					var downStr;
					var birth = store.data.items[0].data.birthYm;
					calcAge(birth); //만나이 계산 함수
					document.getElementById('targetDisId').innerHTML = store.data.items[0].data.targetDisId;
					document.getElementById('disClassDtl').innerHTML = store.data.items[0].data.disClassDtl;
					
					var docClassDtls = store.data.items[0].data.docClassDtl;
				
					//document.getElenentById('docClassDtl').innerHTML = store.data.items[0].data.docClassDtl;
					document.getElementById('sex').innerHTML = store.data.items[0].data.sex;
					document.getElementById('birthYm').innerHTML = store.data.items[0].data.birthYm + ' (만' + birthYmAge + '세)';
					document.getElementById('protocol').innerHTML = store.data.items[0].data.protocol;
					document.getElementById('performCntMaxNm').innerHTML = store.data.items[0].data.performCntMaxNm;
					document.getElementById('remarks').innerHTML = store.data.items[0].data.remarks;
					
					
					console.log('dddddddddddddddddddddddddddddddddd: '+docClassDtls)
					
					for(var i=0; i<store.getTotalCount(); i++){
						data = store.data.items[i].data;
						tNum = (i*2);
						
						//td yellow 초기화 갯수
						performYel = data.performNm;
						performYelList.push(performYel);
						
						if(i==0){
							//인체유래물 동의서
							if(data.humanDerivedMaterialsF != ""){
								inStr="<a onclick=\"downFile('"+data.humanDerivedMaterialsF+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
								$("#humanDerivedMaterialsF").html(inStr);
							} 
							if(data.humanDerivedMaterialsM != ""){
								inStr="<a onclick=\"downFile('"+data.humanDerivedMaterialsM+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
								$("#humanDerivedMaterialsM").html(inStr);
							} 
							if(data.humanDerivedMaterialsC != ""){
								inStr="<a onclick=\"downFile('"+data.humanDerivedMaterialsC+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
								$("#humanDerivedMaterialsC").html(inStr);
							} 
							//채혈
							if(data.bloodFather != ""){
								inStr="<a onclick=\"downFile('"+data.bloodFather+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
								$("#bloodFather").html(inStr);
							}
							if(data.bloodMother != ""){
								inStr="<a onclick=\"downFile('"+data.bloodMother+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
								$("#bloodMother").html(inStr);
							}
							if(data.bloodChild != ""){
								inStr="<a onclick=\"downFile('"+data.bloodChild+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
								$("#bloodChild").html(inStr);
							}
							//K-SADS 결과보고서
							if(data.ksads != ""){
								inStr="<a onclick=\"downFile('"+data.ksads+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
								$("#ksads").html(inStr);
							}
						}else{
							//요소 추가
							var urine = $(".urine_tr").eq(0).clone();
							$(".urine_tr").parent().append(urine);
							
							var cxtDiagC = $(".cxt_diag_tr").eq(0).clone();
							$(".cxt_diag_tr").parent().append(cxtDiagC);
							
							var consentC = $(".consent_tr").eq(0).clone();
							$(".consent_tr").parent().append(consentC);
							consentC = $(".consent_tr").eq(1).clone();
							$(".consent_tr").parent().append(consentC);
						}
						
						//소변
						$(".urine_tr").eq(i).find("th").html(data.performNm);
						if(data.urine != "" && data.urine !=undefined){
							inStr="<a style='cursor:pointer;' onclick=\"downFile('"+data.urine+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
						}else inStr ="";
						$(".urine_tr").eq(i).find("td").html(inStr);
						
						//공존진단
						var cxtDiagArr = data.cxtDiag.split(',');
						var cxtDiagStr="";
						if(cxtDiagArr !="" ){
							for(j in cxtDiagArr){
								cxtDiagStr += '<span class="icon_num">'+cxtDiagArr[j]+'</span>'
							}
						}
						
						$(".cxt_diag_tr").eq(i).find("td").eq(0).html(data.performNm);
						$(".cxt_diag_tr").eq(i).find("td").eq(1).html(cxtDiagStr);
						$(".cxt_diag_tr").eq(i).find("td").eq(1).attr("data-qtip",data.cxtDetail);
						//참여연구 동의서
						$(".consent_tr").eq(tNum).find("th").html(data.performNm);
						
						
						if(data.consentP != "" && data.consentP !=undefined){
							inStr="<a style='cursor:pointer;' onclick=\"downFile('"+data.consentP+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
							
						}else inStr ="";
						
						$(".consent_tr").eq(tNum).find("td").eq(1).html(inStr) //보호자
						if(data.consentC != "" && data.consentC !=undefined){
							inStr="<a style='cursor:pointer;' onclick=\"downFile('"+data.consentC+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
						}else inStr ="";
						$(".consent_tr").eq(tNum+1).find("td").eq(1).html(inStr) //아동;
						
						//영상
						var iTr;
						
						
						if(data.asl != "" && data.asl !=undefined){
							iTr = makeTr("ASL",data.performNm,data.execDate,"<a onclick=\"downFile('"+data.tarFilePath+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>");
							$(".imaging_tr").parent().append(iTr);
						}
						if(data.dti != "" && data.dti !=undefined){
							iTr = makeTr("DTI",data.performNm,data.execDate,"<a onclick=\"downFile('"+data.tarFilePath+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>");
							$(".imaging_tr").parent().append(iTr);
						}
						if(data.fmri != "" && data.fmri !=undefined){
							iTr = makeTr("fMRI",data.performNm,data.execDate,"<a onclick=\"downFile('"+data.tarFilePath+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>");
							$(".imaging_tr").parent().append(iTr);
						}
						if(data.t1 != "" && data.t1 !=undefined){
							iTr = makeTr("T1",data.performNm,data.execDate,"<a onclick=\"downFile('"+data.tarFilePath+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>");
							$(".imaging_tr").parent().append(iTr);
						}
						if(data.t2 != "" && data.t2 !=undefined){
							iTr = makeTr("T2",data.performNm,data.execDate,"<a onclick=\"downFile('"+data.tarFilePath+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>");
							$(".imaging_tr").parent().append(iTr);
						}
						if(data.swi != "" && data.swi !=undefined){
							iTr = makeTr("SWI",data.performNm,data.execDate,"<a onclick=\"downFile('"+data.tarFilePath+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>");
							$(".imaging_tr").parent().append(iTr);
						}
						
						//심리검사
						if(data.performNm != "4WK" && data.performNm != "8WK"){
						if(data.psychTesting != "" && data.psychTesting !=undefined) downStr = "<a onclick=\"downFile('"+data.psychTesting+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
						else downStr = "";
						iTr = makeTr("심리검사",data.performNm,data.execDate, downStr);
						$(".psych_testing_tr").parent().append(iTr);
						}
						//임상가 평가
						if(data.performNm != "4WK" && data.performNm != "8WK" && data.performNm != "12WK"){
						if(data.clinicalEvaluation != "" && data.clinicalEvaluation !=undefined) downStr = "<a onclick=\"downFile('"+data.clinicalEvaluation+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
						else downStr = "";
						iTr = makeTr("임상가평가",data.performNm,data.execDate,downStr,"Y");
						$(".clinical_evaluation_tr").parent().append(iTr);
						}
						//설문지
						if(data.performNm != "4WK" && data.performNm != "8WK"){
						if(data.questionnaire != "" && data.questionnaire !=undefined) downStr = "<a onclick=\"downFile('"+data.questionnaire+"')\"><img src="+ GLOBAL_CONTEXT_PATH +"/images/img/attach.png /></a>";
						else downStr = "";
						iTr = makeTr("부모자녀 평가",data.performNm,data.execDate,downStr,"Y");
						$(".questionnaire_tr").parent().append(iTr);
						iTr = makeTr("아동자가 평가",data.performNm,data.execDate,downStr,"Y");
						$(".questionnaire_tr").parent().append(iTr);
						iTr = makeTr("부모자가 평가",data.performNm,data.execDate,downStr,"Y");
						$(".questionnaire_tr").parent().append(iTr);
						}
					}
					
					//영상정보 없을 때 기본 셋팅
					if($(".imaging_tr").parent().children().size() == 1){
						iTr = makeTr("ASL","V0","","");
						$(".imaging_tr").parent().append(iTr);
						iTr = makeTr("DTI","V0","","");
						$(".imaging_tr").parent().append(iTr);
						iTr = makeTr("fMRI","V0","","");
						$(".imaging_tr").parent().append(iTr);
						iTr = makeTr("T1","V0","","");
						$(".imaging_tr").parent().append(iTr);
						iTr = makeTr("T2","V0","","");
						$(".imaging_tr").parent().append(iTr);
						iTr = makeTr("SWI","V0","","");
						$(".imaging_tr").parent().append(iTr);
					}
					
					
					//tab 이동
					$('.tabslide_tb').click(function(){
						var value = $(this).html();
						console.log("탭밸류 이름값---->: "+value)
						var tIndex;
						var cIndex = $('.currentIndex').val();
						if(cIndex == "") cIndex = 0;
						else cIndex = parseInt(cIndex);
						var nPage = 4;
						if(value=='임상가평가'){
							 tIndex = 0;
							 if(cIndex < tIndex) nPage = 0;
							 $('#slider').slick('slickGoTo', nPage);
							 setTimeout(function(){docDtlLoad('SRS01','DC004')},700);
						}else if(value=='부모자녀 평가'){
							 tIndex = 1;
							 if(cIndex < tIndex) nPage = 0;
							 $('#slider').slick('slickGoTo', nPage+1);
							 docDtlLoad('KMCHT','DC002');
						}else if(value=='아동자가 평가'){
							 tIndex = 2;
							 if(cIndex < tIndex) nPage = 0;
							 $('#slider').slick('slickGoTo', nPage+2);
							 docDtlLoad('CDI01')
						}else if(value=='부모자가 평가'){
							 tIndex = 3;
							 if(cIndex < tIndex) nPage = 0;
							 $('#slider').slick('slickGoTo', nPage+3);
							 setTimeout(function(){docDtlLoad('BDI01')},700);
						}
						
					});
			}
		}
	});		
});


function docTabLoad(){
	//답변컬럼 확인용 변수 초기화
	for(var i=1;i<29;i++){
		eval('multiChoiceValid.multiChoice' + i + ' = ""');
	}
	Ext.each(docDtlStore.getRange(), function(record) {
		for(var i=1;i<29;i++){
			eval('multiChoiceValid.multiChoice' + i + ' += record.get("multiChoice' + i + '");');
	//		console.log("record"+i+"값:"+record.get('docId'))
		}
	});			
	var grid = Ext.getCmp('ticDocDtl-grid'); 

	for(var i=1;i<29;i++){
		eval('Ext.String.trim(multiChoiceValid.multiChoice' + i + ');');
		eval('docColumn.column' + i + '  = grid.getColumns()[' + (i + 1) + '];');
		if(eval('multiChoiceValid.multiChoice' + i) == ''){
			eval('docColumn.column' + i + '.hide();');
		}else{
			eval('docColumn.column' + i + '.show();');
		}

	
	}
	
	//grid.reconfigure(grid.store, grid.initialConfig.columns);
	//Ext.getCmp('ticDocDtl-grid').getView().refresh();
}

var testdocC;
var testdocId;
function docDtlLoad(docId,docClassDtl){
	var docClassDtls;
	console.log("docId(docId function에 들어옴)======> :"+ docId)
	console.log("disClassDtl(disDtlLoad function에 들어옴)======> :"+ menuDisClassDtl);
	console.log("docClassDtl(docDtlLoad function에 들어옴)======> :"+ docClassDtl);
	testdocC = docClassDtl;
	testdocId = docId;
	console.log(testdocId +"docId뿌려진다-------------------------")
	
//	if(docId =='SRS01'){
//		docClassDtls = 'DC004'
//	}else if(docId = 'KMCHT') {
//		docClassDtls = 'DC002'
//	}
//	
	searchParams = {
			docId : docId,
			disClassDtl : menuDisClassDtl,
			docClassDtl : docClassDtl
	}
	docDtlStore.proxy.extraParams = searchParams;	
	docDtlStore.removeAll();
	docDtlStore.load(function(){
		docTabLoad();
	
    	dataIntegrationSurveyLoad(docId, sPerformCnt ,docClassDtls);
	});
	
	//차수에 따른 항목 yellow 표시 jh.lee
	var pc = 0; //V0~ 차수
	var pc4Iv; //4주간격 차수
	var pcNumList = []; //4주간격차수 split
	var pcNum; //split WK
	var pcNum4 = 0; //4주간격 차수 갯수
	var nextTr = ".next('tr')";
	var tr = "";
	
	//부모자녀평가
	var parentChild = (docId == 'KMCHT' || docId == 'OCBCL' || docId == 'CPCL' || docId == 'OCB15' || docId == 'CBC15'  
				|| docId == 'LSD01' || docId == 'LSD01' || docId == 'QPGSR' || docId == 'GSRS1' || docId == 'KCSHQ'
				|| docId == 'ARS01' || docId == 'ABC01' || docId == 'SIB01' || docId == 'BPI01' || docId == 'SRS03'
				|| docId == 'SCQ01' || docId == 'PC3Q1' || docId == 'KASDS' || docId == 'SSIS1' || docId == 'TRAUM');
	//아동자가평가
	var childSelf = (docId == 'CDI01' || docId == 'BDI02' || docId == 'STITC' || docId == 'STISC' || docId == 'CC3QC' || docId == 'CC3QA' 
				|| docId == 'IAT01' || docId == 'KSCAL' || docId == 'RCMAS' || docId == 'TRAUA');
	//부모자가평가
	var parentSelf = (docId == 'BDI01' || docId == 'STITP' || docId == 'STISP' || docId == 'MBRI1' || docId == 'PP3Q1' || docId == 'KPSI1');
	
	//탭 이동시 yellow 초기화 : 임상가
	for(var i = 0; i < performYelList.length; i++){
		tr = tr+nextTr;
		eval('$(".clinical_evaluation_tr").closest("tr")'+tr+'.children().css("backgroundColor", "white");');
	}
	tr = "";
	
	//탭 이동시 yellow 초기화 : 설문지
	for(var i = 0; i < (performYelList.length)*3; i++){
		tr = tr+nextTr;
		eval('$(".questionnaire_tr").closest("tr")'+tr+'.children().css("backgroundColor", "white");');
	}
	tr = "";
	
	//V 차수
	if(sPerformCnt != '4WK' || sPerformCnt != '8WK'){
		if(sPerformCnt != '12WK'){
			pc = parseInt(sPerformCnt.substr(1, sPerformCnt.length-1));
			
			//임상가 평가
			if(docId == 'SRS01' || docId == 'CYBO1' || docId == 'YBOCS' || docId == 'S1001'){
				for(var i = 0; i < pc+1; i++){tr = tr+nextTr;}
				eval('$(".clinical_evaluation_tr").closest("tr")' + tr + '.children().css("backgroundColor", "yellow");');
				tr = "";
			}
		}
	}
	
	//설문지 //4WK, 8WK 제외, 12WK 여부에 따라 다르게 계산
	if(sPerformCnt != '4WK' || sPerformCnt != '8WK'){
		if(sPerformCnt == 'V0'){
			if(parentChild){
				for(var i = 0; i < pc+1; i++){tr = tr+nextTr;}
			}else if(childSelf){
				for(var i = 0; i < pc+2; i++){tr = tr+nextTr;}
			}else if(parentSelf){
				for(var i = 0; i < pc+3; i++){tr = tr+nextTr;}
			}
		}else if(sPerformCnt != 'V0' && (performYelList.indexOf('12WK') != -1)){
				if(sPerformCnt == '12WK'){
					if(parentChild){
						for(var i = 0; i < 4; i++){tr = tr+nextTr;}
					}else if(childSelf){
						for(var i = 0; i < 5; i++){tr = tr+nextTr;}
					}else if(parentSelf){
						for(var i = 0; i < 6; i++){tr = tr+nextTr;}
					}
				}else { //12WK가 있는 경우 V1부터
					if(parentChild){
						for(var i = 0; i < (pc*3)+4; i++){tr = tr+nextTr;}
					}else if(childSelf){
						for(var i = 0; i < (pc*3)+5; i++){tr = tr+nextTr;}
					}else if(parentSelf){
						for(var i = 0; i < (pc*3)+6; i++){tr = tr+nextTr;}
					}
				}
			}else{//12WK가 없는 경우 V1부터
				if(parentChild){
					for(var i = 0; i < (pc*3)+1; i++){tr = tr+nextTr;}
				}else if(childSelf){
					for(var i = 0; i < (pc*3)+2; i++){tr = tr+nextTr;}
				}else if(parentSelf){
					for(var i = 0; i < (pc*3)+3; i++){tr = tr+nextTr;}
				}
			}
		eval('$(".questionnaire_tr").closest("tr")' + tr + '.children().css("backgroundColor", "yellow");');
		tr = "";
	}
	
	var all = document.getElementsByClassName('survey_btn');
	for (var i = 0; i < all.length; i++) {
	  all[i].style.fontWeight = '400'; 
	  all[i].style.backgroundColor = 'white'; 
	}

	document.getElementById(docId).style.fontWeight = '700';
	document.getElementById(docId).style.backgroundColor = 'yellow';
	
}

function dataIntegrationSurveyLoad(docId, sPerformCnt, sDocClassDtl){
	console.log(sDocClassDtl+"sDocClassDtl::::::::::")
	searchParams = {
			docId : docId
			, targetId : targetId
			, performNm : sPerformCnt
			, sDocClassDtl : sDocClassDtl
	}
	
	dataIntegrationSurveyStore.proxy.extraParams = searchParams;	
	dataIntegrationSurveyStore.removeAll();
	
	
	console.log(docId+"docID가져와지는건가?????????????????????????????????????")	
	
	dataIntegrationSurveyStore.load(function(){
		console.log("dataintegration들어왔당")
		if(dataIntegrationSurveyStore.getAt(0) != null){
		var inqCnt = 0; //체크 name
		var inqCnt1 = 1; //vo변수 숫자
		
		for(var j = 0; j < docDtlStore.getCount();j++){ //행
			
			var rec1 = dataIntegrationSurveyStore.getAt(0);
			console.log(rec1.get('a14')+"::::::a14뭔값인가?")
			console.log(rec1.get('a15')+"::::::a15뭔값인가?")
			var rec2 = docDtlStore.getAt(j);
			console.log(rec2.get("docId")+"???????무슨값일까?")
			for(var i=1; i<29;i++){ //열
    			var a = '';
    			//BDI
    			a += 'if(rec2.get("docId") == "BDI01" && '+inqCnt1+'== 20){';
    			a += 'if(rec2.get("allotScore'+i+'") ==  rec1.get("weightControl")){';
		 		a += '$("input:checkbox[name= 19-'+i+'Y]").prop("checked", true);}}'; //INQ3
		 		
		 		//SRS - a1, a2 (약물 종류 - 용량)
		 		a += 'else if((rec2.get("docId") == "SRS01" || rec2.get("docId") == "SRS02") && '+inqCnt1+'== 1 && '+inqCnt+' ==0){';
		 		a += 'var pillA1 = rec1.get("a1"); var pillA2 = rec1.get("a2");';
		 		a += 'if(pillA1 == "" && pillA2 ==""){$("textarea[name=0-1Y]").text("입력값 없음");'
		 		a += '}else{$("textarea[name=0-1Y]").text(pillA1 +" - "+ pillA2);}';
		 		a += 'inqCnt1++;';
		 		a += '}';
		 		
		 		
		 		//일반 변수 : a로 시작
		 		a += 'else{';
		 		
		 		a += 'if(rec2.get("inqTypeCd") == "INQU2"){'; 				//주관식
		 		a += '$("textarea[name='+inqCnt+'-'+i+'Y]").text(rec1.get("a'+inqCnt1+'"));}';
		 		
    			a += 'if(rec2.get("allotScore' + i + '") ==  rec1.get("a'+inqCnt1+'")){'; //allotscore 와 a로 시작하는 각 변수 점수 비교
//    			a += 'console.log("진입확인 : '+inqCnt1+'");';
    			a += 'if(rec2.get("inqTypeCd") == "INQU1"){'; 						//객관식 라디오버튼
    			//a += 'console.log("진입확인: '+inqCnt+'");';
    			a += '$("input:radio[name='+inqCnt+'-'+i+'Y]").prop("checked", true);';
    			a += '}else if(rec2.get("inqTypeCd") == "INQU3"){'; 				//복수선택 체크박스
		 		a += '$("input:checkbox[name='+inqCnt+'-'+i+'Y]").prop("checked", true);';
		 		a += '}else if(rec2.get("inqTypeCd") == "INQU4"){'; 				//복합(LOICE : 객관+주관)
		 		a += '$("input:checkbox[name='+inqCnt+'-'+i+'Y]").prop("checked", true);}}';
		 		a += '}';
		 		
		 	//	a += 'else if(rec2.get("inqTypeCd") == "INQU1" && rec1.get("docId")){';
		 	//	a +=  'if(rec1.get("a'+inqCnt+'") == '+inqCnt1+'
		 		
		 		
		 		//확인콘솔
		 		console.log(j + "행  a(inqCnt1): "+inqCnt1);
		 		console.log(j + "행  a(inqCnt): " +inqCnt);
		 		console.log(inqCnt+'-'+i+'Y') //체크박스 name 확인
		 		eval('console.log(rec1.get("a'+inqCnt1+'"))'); //변수에 따른 값
    			eval('console.log(rec2.get("allotScore' + i+'"))');
		 		eval('console.log(rec2.get("allotScore' + i + '") ==  rec1.get("a'+inqCnt1+'"))'); //비교문 확인출력
		 		console.log("타입 : "+rec2.get('inqTypeCd')); //타입확인
		 		
		 		eval(a); //출력
    		}
			
    		inqCnt++;
    		inqCnt1++;
		}
		}
		
		if(docId == "CDI01"){// CDI 항목 remove
			var tableId;
			for(var i = 0; i < 27; i++){
				tableId = $('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(i).attr('id');
				$('#'+tableId).children('tbody').children('tr').children('td').eq(1).remove();
				$('#'+tableId).css('width','100%');
				$('#'+tableId).children('tbody').children('tr').children('td').eq(0).css('width','26px');
			}
			$('#gridcolumn-1011').remove();
			$('#gridcolumn-1012').remove();
			$('#gridcolumn-1013').remove();
			$('#gridcolumn-1014').remove();
			$('#ticDocDtl-grid-bodyWrap').children().eq(0).children('div').css('background-color','#8995a5');
		}else if(docId == "KASDS"){// K-ASDS 항목 제목 추가
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(0).attr('id')).before("<div class='innerDivC'>Ⅰ. 언어</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(10).attr('id')).before("<div class='innerDivC'>Ⅱ. 사회성</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(24).attr('id')).before("<div class='innerDivC'>Ⅲ. 부적응 행동</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(36).attr('id')).before("<div class='innerDivC'>Ⅳ. 인지</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(47).attr('id')).before("<div class='innerDivC'>Ⅴ. 감각 운동</div>");
		}else if(docId == "SSIS1"){// SSIS 항목 제목 추가
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(0).attr('id')).before("<div class='innerDivC'>사회적 기술</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(47).attr('id')).before("<div class='innerDivC'>문제 행동</div>");
		}else if(docId == "SIB01"){//  항목 제목 추가
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(0).attr('id')).before("<div class='innerDivC'>1. 자신을 해치는 행동</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(6).attr('id')).before("<div class='innerDivC'>2. 타인을 해치는 행동</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(12).attr('id')).before("<div class='innerDivC'>3. 물건을 파괴하는 행동</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(18).attr('id')).before("<div class='innerDivC'>4. 방해하는 행동</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(24).attr('id')).before("<div class='innerDivC'>5. 특이한 반복적인 습관</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(30).attr('id')).before("<div class='innerDivC'>6. 사회적으로 공격적인 행동</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(36).attr('id')).before("<div class='innerDivC'>7. 위축된 행동이나 부주의한 행동</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(42).attr('id')).before("<div class='innerDivC'>8. 비협조적인 행동</div>");
		}else if(docId == "LSD01"){// LSD 항목 제목 추가
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(7).attr('id')).before("<div class='innerDivC'>*7번에 ‘예’라고 하신 경우, 8번과 다음 문항을 완성해 주십시오.</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(9).attr('id')).before("<div class='innerDivC'>(8번에 ‘예’라고 응답한 경우)<br>아이가 쓰는 가장 길고 좋은 문장을 적고, 문장에 쓰인 단어의 수를 표시하여 주십시오.<br>조사는 세지 않습니다. (24~35개월에만 해당하는 문항입니다.)<br>예시) 내일은 아빠랑 같이 놀이터에 가자 - 5단어</div>");
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(15).attr('id')).before("<div class='innerDivC'>(18~15개월) 아이가 자발적으로 말하는 단어에는 Ⓞ에 표시, <br>그렇지 않은 단어에는 ⓧ에 표시 또는 공란으로 비워 두십시오(따라하거나 단순히 이해하는 단어 제외).<br>만약 아이가 같은 의미의 외국 단어를 말하거나 발음이 덜 명확하거나<br>아이들만의 방식으로 발음을 하더라도 알고 표현하면 Ⓞ에 표시하십시오<br>(예: 애플-사과, 벼원-병원).</div>");
		}else if(docId == "OCBCL" || docId == "CBCL2"){
			$("#"+$('#ticDocDtl-grid-body').children().eq(0).children().eq(1).children().eq(55).attr('id')).before("<div class='innerDivC'>56. 의학적으로 밝혀진 원인 없이 나타나는 신체적 문제가 있다.</div>");
		}
		
	});
	
	
	
	//dataIntegrationClinicianStore
	if(docId == 'SRS01' || docId == 'CYBO1' || docId == 'YBOCS'){
		
		dataIntegrationClinicianStore.proxy.extraParams = searchParams;
		dataIntegrationClinicianStore.removeAll();		
		
		dataIntegrationClinicianStore.load(function(){
			if(dataIntegrationClinicianStore.getAt(0) != null){
			var inqCnt = 0; //체크 name
			var inqCnt1 = 1; //vo변수 숫자
			
			for(var j = 0; j < docDtlStore.getCount();j++){ //행
				
				var rec1 = dataIntegrationClinicianStore.getAt(0);
				var rec2 = docDtlStore.getAt(j);
				console.log(rec2.get("docId")+"???????무슨값일까?")
				for(var i=1; i<29;i++){ //열
	    			var a = '';
	    		
			 		
			 		//SRS - a1, a2 (약물 종류 - 용량)
			 		a += 'if((rec2.get("docId") == "SRS01" || rec2.get("docId") == "SRS02") && '+inqCnt1+'== 1 && '+inqCnt+' ==0){';
			 		a += 'var pillA1 = rec1.get("a1"); var pillA2 = rec1.get("a2");';
			 		a += 'if(pillA1 == "" && pillA2 ==""){$("textarea[name=0-1Y]").text("입력값 없음");'
			 		a += '}else{$("textarea[name=0-1Y]").text(pillA1 +" - "+ pillA2);}';
			 		a += 'inqCnt1++;';
			 		a += '}';
			 		
			 		
			 		//일반 변수 : a로 시작
			 		a += 'else{';
			 		
			 		a += 'if(rec2.get("inqTypeCd") == "INQU2"){'; 				//주관식
			 		a += '$("textarea[name='+inqCnt+'-'+i+'Y]").text(rec1.get("a'+inqCnt1+'"));}';
			 		
	    			a += 'if(rec2.get("allotScore' + i + '") ==  rec1.get("a'+inqCnt1+'")){'; //allotscore 와 a로 시작하는 각 변수 점수 비교
//	    			a += 'console.log("진입확인 : '+inqCnt1+'");';
	    			a += 'if(rec2.get("inqTypeCd") == "INQU1"){'; 						//객관식 라디오버튼
	    			a += '$("input:radio[name='+inqCnt+'-'+i+'Y]").prop("checked", true);';
	    			a += '}else if(rec2.get("inqTypeCd") == "INQU3"){'; 				//복수선택 체크박스
			 		a += '$("input:checkbox[name='+inqCnt+'-'+i+'Y]").prop("checked", true);';
			 		a += '}else if(rec2.get("inqTypeCd") == "INQU4"){'; 				//복합(LOICE : 객관+주관)
			 		a += '$("input:checkbox[name='+inqCnt+'-'+i+'Y]").prop("checked", true);}}';
			 		a += '}';
			 		
			 		//확인콘솔
//			 		console.log(j + "행  a"+inqCnt1);
//			 		console.log(inqCnt+'-'+i+'Y') //체크박스 name 확인
//			 		eval('console.log(rec1.get("a'+inqCnt1+'"))'); //변수에 따른 값
//	    			eval('console.log(rec2.get("allotScore' + i+'"))');
//			 		eval('console.log(rec2.get("allotScore' + i + '") ==  rec1.get("a'+inqCnt1+'"))'); //비교문 확인출력
//			 		console.log("타입 : "+rec2.get('inqTypeCd')); //타입확인
			 		
			 		eval(a); //출력
	    		}
				
	    		inqCnt++;
	    		inqCnt1++;
			}
			}
			

			
		});
		}

	
	
}

function makeTr(d1,d2,d3,d4,btnYn){
	var trStr;
	trStr = "<tr>";
	if(btnYn=="Y") trStr += "<td class=\"btn tabslide_tb\" onclick=setPerformCnt('"+d2+"')>";
	else trStr += "<td>";
	trStr += d1+"</td>";
	trStr += "<td>"+d2+"</td>";
	trStr += "<td>"+d3+"</td>";
	if(d4 !="") trStr += "<td class=\"btn tabslide_tb\">";
	else trStr += "<td>";
	trStr += d4+"</td>";
	trStr += "</tr>";
	return trStr;
}

function setPerformCnt(d2){ //탭 이동시 performNm 가져옴
	sPerformCnt = d2
}

function downFile(downFile){
	location.href=GLOBAL_CONTEXT_PATH+"/medical/dataIntegration/dataIntegrationDtlPDFDownload.do?downFile="+downFile;
}

function saveRemarks(){
	
	var remarks = document.getElementById("remarks").value
	
	var params = {
		remarks : remarks
		, targetId : targetId
		, rndId : loginRndId
		, disClassDtl : menuDisClassDtl
	}
	var ch_char = check_key(remarks); //특수기호 function에서 chkNo 3 수정
	if(nonSpecialChar(ch_char)){
	Ext.MessageBox.show({
		title : '알림',
		msg : '저장하시겠습니까?',
		buttons : Ext.MessageBox.OKCANCEL,
		fn : function(btn) {
			if (btn == 'ok') {
					Ext.Ajax.request({
						url : makeUrl('/medical/target/updateRemarksDataDtl.do'),
			            params : params,
						method : 'POST',
						timeout : 100000000,
						success : function(resp) {
							var obj = Ext.decode(resp.responseText);
							if (obj.success) {
//								Ext.Msg.alert('알림', '데이터가 저장되었습니다.');
								Ext.Msg.show({
		                            title: '알림',
		                            msg: '데이터가 저장되었습니다.', 
		                            buttons: Ext.Msg.OK,
//		                            fn: function(btn, text) {
//		                                if (btn == 'ok') {
//		                              	  location.reload();
//		                                }
//		                            }
		                        });
							} else {
								Ext.Msg.alert('알림', '데이터 저장에 실패했습니다.<br/><b>'
										+ obj.errMsg + '</b>');
							}
						},
		   	         	callback : function() {
		   	         	}
					});
				}	
			}
		});
	}else if (nonSpecialChar(ch_char) == false){
		return;
	}
	
};