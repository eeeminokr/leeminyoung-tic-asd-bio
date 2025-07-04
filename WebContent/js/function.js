/**
 * 폼 초기화 -> 검색
 */
function doReset() {
	try {
		$('form#searchForm').each(function(i, f) {
			$(f)[0].reset();
		});
	} catch (e) {
		if (console) {
			console.log(e);
		}
	}
	
	try {
		activePage = 1;
		pageSize = 50;
	} catch (e) {
		if (console) {
			console.log(e);
		}
	}
	try {
		doSearch();
	} catch (e) {
		if (console) {
			console.log(e);
		}
	}
	
}

/**
 * 쿠키 파라미터로 폼의 값 세팅
 * @param id
 */
function applyCookieSearchValue(id) {
	var id="searchForm";
	var form = $('form' + (id ? '#' + id : ''));
	for(key in parameter) {
		var texts = form.find(':text#' + key + ',select#' + key);
		$.each(texts, function(i, o) {
			$(o).val(parameter[key]);
		});
		
		var checkboxs = form.find(':checkbox');
		$.each(checkboxs, function(i, o) {
			if ($(o).val() == parameter[key]) {
				$(o).prop('checked', true);
			}
		});
	}
}

/**
 * 현재 화면의 값들을(폼데이터 포함)
 * @param addParams
 */
function saveCookieSearchValue(addParams) {
	if (!addParams) {
		addParams = {};
	}
	var pathname =  encodeURIComponent(document.location.pathname);
	var params = makeFormToParams('searchForm');
	Ext.apply(params, addParams);
	if (activePage) {
		params['activePage'] = activePage;
	}
	if (pageSize) {
		params['pageSize'] = pageSize;
	}

	$.cookie.raw = true;
	$.cookie(pathname, Ext.urlEncode(params));
}	

/**
 * 현재 화면(url)의 쿠키 값을 지운다.
 */
function removeCookieSearchValue() {
	var pathname = encodeURIComponent(document.location.pathname);
	$.removeCookie(pathname);
	parameter = {};
}

/**
 * 폼에 있는 값을을 객체로 만든다.
 * @param id
 * @returns object
 */
function makeFormToParams(id) {
	var params = {};
	var form = $('form' + (id ? '#' + id : ''));
	var texts = form.find(':text,select');
	$.each(texts, function(i, o) {
		params[$(o).attr('id') || $(o).attr('name')] = $(o).val();
	});
	
	var checkboxs = form.find(':checkbox');
	$.each(checkboxs, function(i, o) {
		params[$(o).attr('id') || $(o).attr('name')] = $(o).prop('checked') ? $(o).val() : '';
	});
	
	return params;
}

/**
 * 파일 다운로드 팝업
 * @param url
 * @param params
 * @param version
 */
function popupDownload(url, params, version) {
	if (!version) {
		version = 2007;
	}
	
	if (!params) {
		params = {};
	}
	
	
	params['excelVersion'] = version;
	
	var p = {
		url : makeUrl(url, params)
	};
	
	window.open(makeUrl('/medical/downloading.view', p), 'download',
			'width=500,height=200,scrollbars=no,resizeable=no,status=no,menubar=no,location=no');
}
/**
 * 지수를 변환
 */
Ext.apply(Ext.util.Format, {
	exponentialToNumber : function(v) {
		// 지수인지 확인
		var s = v.toString();
		if(s.indexOf('e+') != -1 || s.indexOf('e-') != -1) {
			v = v.toFixed(20);
			v = v.replace(/0+$/, '');
			v = v.replace(/\.$/, '');
		}
		
		return v;
	}
});

/* ----------------------------------------------------------------------------
 * 오늘날짜 반환
 * 
 * pDelimiter : pYyyymmdd 값에 사용된 구분자를 설정 (없으면 "" 입력)
 * 
 --------------------------------------------------------------------------- */
Date.prototype.toYYYYMMDD = function(delim) {
	if (delim == undefined) delim = "";
	var year = this.getFullYear().toString();
	var month = this.getMonth() + 1;
	var day = this.getDate();
	month = (month < 10 ? "0" : "") + month;
	day = (day < 10 ? "0" : "") + day;
	return year + delim + month + delim + day;
};

function getToday(pDelimiter){
	var today = new Date();
	var yyyy;
	var mm;
	var dd;
	
	yyyy = today.getFullYear();
	mm = today.getMonth()+1;
	dd = today.getDate();
	
	mm = mm < 10 ? "0" + mm : mm;
	dd = dd < 10 ? "0" + dd : dd;
	
	return yyyy + pDelimiter + mm + pDelimiter + dd;
}

/* ----------------------------------------------------------------------------
 * 특정 날짜에 대해 지정한 값만큼 가감(+-)한 날짜를 반환
 * 
 * 입력 파라미터 -----
 * pInterval : "yyyy" 는 연도 가감, "m" 은 월 가감, "d" 는 일 가감
 * pAddVal  : 가감 하고자 하는 값 (정수형)
 * pYyyymmdd : 가감의 기준이 되는 날짜
 * pDelimiter : pYyyymmdd 값에 사용된 구분자를 설정 (없으면 "" 입력)
 * 
 * 반환값 ----
 * yyyymmdd 또는 함수 입력시 지정된 구분자를 가지는 yyyy?mm?dd 값
 *
 * 사용예 ---
 * 2008-01-01 에 3 일 더하기 ==> addDate("d", 3, "2008-08-01", "-");
 * 20080301 에 8 개월 더하기 ==> addDate("m", 8, "20080301", "");
 --------------------------------------------------------------------------- */
function addDate(pInterval, pAddVal, pYyyymmdd, pDelimiter) {
	var yyyy;
	var mm;
	var dd;
	var cDate;
	var oDate;
	var cYear, cMonth, cDay;

	if (pDelimiter != "") {
		pYyyymmdd = pYyyymmdd.replace(eval("/\\" + pDelimiter + "/g"), "");
	}

	yyyy = pYyyymmdd.substr(0, 4);
	mm = pYyyymmdd.substr(4, 2);
	dd = pYyyymmdd.substr(6, 2);

	if (pInterval == "yyyy") {
		yyyy = (yyyy * 1) + (pAddVal * 1);
	} else if (pInterval == "m") {
		mm = (mm * 1) + (pAddVal * 1);

	} else if (pInterval == "d") {
		dd = (dd * 1) + (pAddVal * 1);
	}

	cDate = new Date(yyyy, mm - 1, dd); // 12월, 31일을 초과하는 입력값에 대해 자동으로 계산된 날짜가 만들어짐.
	cYear = cDate.getFullYear();
	cMonth = cDate.getMonth() + 1;
	cDay = cDate.getDate();

	cMonth = cMonth < 10 ? "0" + cMonth : cMonth;
	cDay = cDay < 10 ? "0" + cDay : cDay;
	var rtnVal;
	if (pDelimiter != "") {
		rtnValue= cYear.toString() + pDelimiter.toString() + cMonth.toString() + pDelimiter.toString() + cDay.toString();
	} else {
		rtnVal = cYear.toString() + cMonth.toString() + cDay.toString();
	}
	return rtnValue;
}
 
 
//----------------------------------------------//
//쿠키 핸들링 관련 함수들
//----------------------------------------------//
function setCookie (name,value,path,domain,secure) {
	var expires = new Date();
	expires.setMonth(expires.getMonth() + 1);

	document.cookie = name + "=" + escape (value) +
	  ((expires) ? "; expires=" + expires.toGMTString() : "") +
	  ((path) ? "; path=" + path : "") +
	  ((domain) ? "; domain=" + domain : "") +
	  ((secure) ? "; secure" : "");
}

function getCookie (name) {
	var arg = name + "=";
	var alen = arg.length;
	var clen = document.cookie.length;

	var i = 0;
	while (i < clen) {
	   var j = i + alen;
	   if (document.cookie.substring(i, j) == arg)
	     return getCookieVal (j);
	   i = document.cookie.indexOf(" ", i) + 1;
	   if (i == 0) break;
	}
	return null;
}

function getCookieVal (offset) {
	var endstr = document.cookie.indexOf (";", offset);
	if (endstr == -1)
	  endstr = document.cookie.length;
	return unescape(document.cookie.substring(offset, endstr));
}


function glOpenRDViewerPop(reportId,userParams,options){
	//var winOptions = 'width=800,height=700,menubar=no,toolbar=no,scrollbars=yes,resizable=yes';
	var windownName = "new";
	if(reportId.indexOf(".") > 0){
		windownName = reportId.substring(0,reportId.indexOf("."));
		//alert(windownName);
	}
	
	if(typeof(options) == "undefined"){
		options = 'width=800,height=700,menubar=no,toolbar=no,scrollbars=yes,resizable=yes';
	}
	
    window.open(GLOBAL_CONTEXT_PATH+"/viewer/RDViewerPop.jsp?report_id="+reportId+"&userParams="+userParams
 		   ,windownName
 		   ,options);
}

/**
 * iText Open시 이용.
 * @param reportId
 * @param userParams
 * @param options
 */
function glOpenITextViewerPop(reportId,params,options){
	//var winOptions = 'width=800,height=700,menubar=no,toolbar=no,scrollbars=yes,resizable=yes';
	var windownName = "iTextView";
	
	if(typeof(options) == "undefined"){
		options = 'width=800,height=650px,menubar=no,toolbar=no,scrollbars=no,resizable=no';
	}
	
	//alert(GLOBAL_CONTEXT_PATH + reportId + "?" + params);
	
	window.open(GLOBAL_CONTEXT_PATH + reportId + (params != '' ? "?" + params : '')  ,windownName ,options);
}


function glMergeGridCell(args){
	var addArgs = arguments;

	return function(value, meta, record, rowIndex, colIndex, store) {
		var debug = "";
		if(addArgs.length == 0 ) {
			addArgs = new Array();
			addArgs[0] = this.dataIndex;
		}
			
		var first = !rowIndex ? true : false;
		var last = rowIndex >= store.getCount() - 1 ? true:false;
		
		
		//첫번째 row가 아닐경우 loop돌면서 비교
		if(!first){
			for(var i=0; i<addArgs.length; i++){
				//debug +="["+value+"]/["+store.getAt(rowIndex - 1).get(addArgs[i])+"]";
				if(store.getAt(rowIndex).get(addArgs[i]) != store.getAt(rowIndex - 1).get(addArgs[i])){
					first = true;
					break;
				}
			}
		}
		
		//마지막 row가 아닐경우 loop돌면서 비교
		if(!last){
			for(var i=0; i<addArgs.length; i++){
				if(store.getAt(rowIndex).get(addArgs[i]) !== store.getAt(rowIndex + 1).get(addArgs[i])){
					last = true;
					break;
				}
			}
		}						
		
		meta.css += 'row-span' + (first ? ' row-span-first' : '') +  (last ? ' row-span-last' : '');
		if (first) {
		var i = rowIndex + 1;
		while (i < store.getCount() && value == store.getAt(i).get(args)) {
		i++;
		}
		//var rowHeight = 0, padding = 6,
		//height = (rowHeight * (i - rowIndex) - padding) + 'px';
		//meta.attr = 'style="height:' + height + ';line-height:' + height + ';"';
		}
		return first ? value : '';	          
	};
 }




//glDoAjax call back function SuccessMessage
 //{"success":true,"messages":{"message":"요청하신 작업이 성공적으로 처리되었습니다."}}
 //{"success":false,"messages":{"message":"잠시 후 다시 시도하세요."}} --> 업무 오류 메세지 처리
 //{"success":false,"errors":{"reason":"잠시 후 다시 시도하세요."}} --> 시스템 Exception
function glAjaxDefaultMessage(jsonData) {
	if(typeof(jsonData) == 'undefined' || typeof(jsonData.success) == 'undefined') return;
 		
	//controller message 처리
	if(typeof(jsonData.messages) != 'undefined' && 
        typeof(jsonData.messages.message) != 'undefined'){
		Ext.MessageBox.alert(jsonData.success?'Success':'Failed', jsonData.messages.message);
	
	//Exception 처리
	}else if(typeof(jsonData.errors) != 'undefined' && 
        typeof(jsonData.errors.reason) != 'undefined'){
		Ext.MessageBox.alert('Failed', jsonData.errors.reason);
    }
}

function glDoAjax(url,params,method,serviceId,callback) {
	
	if(typeof(method) == 'undefined' || method == ''){
		method = 'GET';
	}
	
    //XHR request를 위한 메소드 호출
	Ext.Ajax.request({
		url : url, 
		params : params, //{ action : 'getDate' },
		method: method,//'GET',
        
		//성공 시에 수행될 콜백 함수
		success: function ( result, request) { 
			if(typeof(callback) != 'undefined' && callback != ''){
				try {
					eval(callback)(Ext.util.JSON.decode(result.responseText));
				}catch (err) {
					Ext.MessageBox.alert('ERROR', 'Could not decode ' + result.responseText);
				}
			}							
		},
        
		//실패 시에 수행될 콜백 함수
		failure: function ( result, request) { 
			Ext.MessageBox.alert('Failed', result.responseText); 
		} 
	});
}

function doLink(url) {
	window.location.href = url;
}

String.prototype.trim = function() {   
	return this.replace(/^\s+|\s+$/g,"");   
};

String.prototype.ltrim = function() {   
	return this.replace(/^\s+/,"");      
};   

String.prototype.rtrim = function() {   
	return this.replace(/\s+$/,"");      
}; 

function goPrintViewByPath(flag, doc, path, key, ftaType, pYyyymm) {
    var yyyymm = typeof pYyyymm == "undefined" || pYyyymm.trim() == "" ? "000000" : pYyyymm;
	var url = GLOBAL_CONTEXT_PATH+"/viewer?flag="+flag+"&path="+path+"&doc="+doc+"&key="+key+"&ftaType="+ftaType+"&yyyymm="+yyyymm;
	var win = window.open(url,"printView",",menubar=0,resizable=1,width=1000,height=700");
	win.focus();
}

function getContextPath() {
     var offset=location.href.indexOf(location.host)+location.host.length;
     var ctxPath=location.href.substring(offset,location.href.indexOf('/',offset+1));
     return ctxPath;
}

function getResourceId() {
	var rscId;
	if(getContextPath().indexOf('BDSP') == -1)rscId = document.location.pathname;
	else rscId = document.location.pathname.replace(getContextPath(), '');
	return rscId;
}

function getConfigUI(compId) {
	var conf = configUI[getResourceId()+"/"+compId];
	return typeof(conf) == 'undefined' || conf == '' ? 'N' : conf ;
}
function checkGrade(compGrade,grade){
	if(compGrade == 'G3'){
		if(grade=='G1' || grade=='G2' || grade=='G3') return true;
		else return false;
	}else if(compGrade == 'G2'){
		if(grade=='G1' || grade=='G2') return true;
		else return false;
	}else if(compGrade == 'G1'){
		if(grade=='G1') return true;
		else return false;
	}
	return false;
}
function getUuid(){
	function s4() {
	      return ((1 + Math.random()) * 0x10000 | 0).toString(16).substring(1);
	    }
	    return s4() + s4() + s4() + s4() + s4() + s4() + s4() + s4();
}
function getCenterPosition(popupW,popupH){
	var left = Math.ceil((window.screen.width - popupW)/2);
	var top = Math.ceil((window.screen.height - popupH)/2);
	var rtnValue = [];
	rtnValue[0] = left;
	rtnValue[1] = top;
	return rtnValue;
}

//20200825 jh.lee
function check_key(char_ASCII){
	var chkNo = "";
	
	for (var i=0; i < char_ASCII.length; i++) {
		ch_char = char_ASCII.charAt(i);
	    ch = ch_char.charCodeAt();
		//숫자
		if (ch >= 48 && ch <= 57 )
			chkNo += 1;
		//영어
		else if ((ch>=65 && ch<=90) || (ch>=97 && ch<=122))
			chkNo += 2;
		//특수기호 35# 36$ 37% 47/ 64@ 92\ 94^ 124| 
		else if (ch==35 || ch ==36 || ch==37 || ch==47 || ch==64 || ch==92 || ch==94 || ch==124)
			chkNo += 3;
		//한글 (자음,모음)
		else if ((ch >= 12592) && (ch <= 12687))
			chkNo += 4;
		//한글 (완성형)
		else if ((ch >= 44032) && (ch <= 55203))
			chkNo += 5;
	}
	return chkNo;
}

//특수문자 방지
function nonSpecialChar(check_key) {
	if(check_key.indexOf("3") != -1){
		Ext.Msg.alert("알림", "특수문자를 입력 할 수 없습니다.");
		return false;
	}
	return true;
}

//만나이 계산
function calcAge(birth) {
	
       var date = new Date();
       var year = date.getFullYear();
       var month = (date.getMonth() + 1);
       var day = date.getDate();
       if (month < 10) month = '0' + month;
       if (day < 10) day = '0' + day;
       var monthDay = month + day;
       birth = birth.replace('-', '').replace('-', '');
       var birthdayy = birth.substr(0, 4);
       var birthdaymd = birth.substr(4, 4);
       birthYmAge = monthDay < birthdaymd ? year - birthdayy - 1 : year - birthdayy;
       return birthYmAge;
} 
