<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

Ext.ns('CommonJs'); 


var pageLoad; //page 간 이동 & Parameter 전달 역활

CommonJs.PageLoad = function() {
	var sendUIParam;
	var sendParams;
	var sendStoreParams;
	var STORE_PARAMETER_NAME = '__storeParams';
	

	this.setParams = function(sendParams){
		this.sendParams = sendParams;
	}
	
	/*
	 * List Page로 이동 (list에넘어온 Store Parameter 정보를 다시 넘긴다.
	 * Param1 uiJs : js 명
	 * Param2 additionalData : 추가 Parameter 정보
	 * Param3 addStoreParam : list에서 넘어온 Store Parameter를 넘길지 여부
	 */
	this.gotoList = function(uiJs,additionalData) {
		if(typeof(additionalData) == 'undefined' || additionalData == ''){
			additionalData =  this.getSendStorParams();
		}else{
			additionalData +="&"+this.getSendStorParams();
		}
		this.gotoPage(uiJs,additionalData);
	}

	/*
	 * Page 이동
	 * Param1 uiJs : js 명
	 * Param2 additionalData : 추가 Parameter 정보
	 * Param3 sendParamstore : 이전 페이지 Store에서 넘어온 Parameter
	 */
	this.gotoPage = function(uiJs,additionalData,sendParamstore) {
		this.sendUIParam = "uiJs=" + uiJs;
		
		if(typeof(additionalData) != "undefined" && additionalData != ""){
			this.sendParams = additionalData;
		}
		
		if(typeof(sendParamstore) != "undefined" && sendParamstore != ""){

            var options = sendParamstore.lastOptions;
			options.params = options.params || {};

			for(var name in options.params){
				
				if(typeof(this.sendStoreParams) != "undefined" && this.sendStoreParams != ""){
					this.sendStoreParams +="&"+name+"="+options.params[name];
				}else{
					this.sendStoreParams =name+"="+options.params[name];
				}				
			} //end of for(...)
			
			if(typeof(this.sendStoreParams) != "undefined" && this.sendStoreParams != ""){
				//alert(this.sendStoreParams);
				if(typeof(this.sendParams) != "undefined" && this.sendParams != ""){
					this.sendParams +="&"+STORE_PARAMETER_NAME+"="+encodeURIComponent(this.sendStoreParams);
				}else{
					this.sendParams ="&"+STORE_PARAMETER_NAME+"="+encodeURIComponent(this.sendStoreParams);
				}			
			}
		}

		this.reloadTab();
	}

	/*
	 * 다음페이지에 넘길 Parameter 정보를 조회
	 * return Parmeter 정보(ex. ui=12&com=34)
	 */	
	this.getSendParams = function(){
		return (typeof(this.sendParams) != "undefined" && 
				this.sendParams != null)?this.sendParams : "";
		
	}

	/*
	 * 다음페이지에 넘길 Full Url정보를 조회(Parameter 포함)
	 * return Parmeter 정보(ex. uiJs=aaaa.js&ui=12&com=34)
	 */		
	this.getSendFullParams = function(){
		return this.sendUIParam+(this.getSendParams() != ""? "&"+this.getSendParams():"");
	}

	/*
	 * 이전페이지에서 넘어온 Store Parameter정보를 조회
	 * return Parmeter 정보(ex. ui=12&com=34)
	 */			
	this.getSendStorParams = function(){
		return decodeURIComponent(this.getParameter(STORE_PARAMETER_NAME));
	}
	

	/*
	 * 이전페이지에서 넘어온  Parameter정보를 조회
	 * return Parmeter 정보(ex. ui=12&com=34)
	 */		
	this.getParameter = function(param) {
		if(typeof(param) == "undefined" ||
		   param == null || param == "") return "";
		
	     var reqParams = Ext.urlDecode(window.location.search.substring(1));
		
		if(typeof(reqParams) != "undefined" && 
		   typeof(reqParams[param]) != "undefined"){
		   return reqParams[param];
		}else{
			return "";
		}		
	 };	
	 	
	/*
	 * 이전페이지에서 넘어온  Parameter 정보를 Setting 한다. (Component & Store BaseParams)
	 * return store baseParam을 Setting할 Store
	 * return componentId 값을 Setting 할 component ID 
	 */		
	this.setParamValue = function(store,componentId) {		
		if(typeof(Ext.getCmp(componentId)) == 'undefined') return;
		
		
		var cmpName = Ext.getCmp(componentId).name;
		var vName = this.getParameter(cmpName);

		if(vName == null) vName ="";
		Ext.getCmp(componentId).setValue(vName)

		if(typeof(store) == 'undefined') return;
		store.baseParams[cmpName] = vName;
	};		 


	/*
	 * Tab 정보를 Reload 한다.
	 */		 
	this.reloadTab = function(){
		var activeTab = parent.contentPanel.getActiveTab();
		activeTab.setSrc(GLOBAL_UI_VIEW+"?"+this.getSendFullParams());
		activeTab.on('documentloaded', function(frame){ alert('Document is loaded');});		

		
	}
	
	/*
	 * 조회조건 parameter 를 GET 방식으로 Setting 한다. 
	 */
	this.reqParams = function(keys) {
		var param = '';
		for(var i = 0; i < keys.length; i ++) {
			var obj = document.getElementById(keys[i]);
			if(obj != null) {
				param += '&' + keys[i] + '=' + obj.value;
			}
		}
		return param;
	}
	
	this.resParams = function(keys) {
		var param = '';
		for(var i = 0; i < keys.length; i ++) {
			var value = this.getParameter(keys[i]);
			if(value != '') {
				param += '&' + keys[i] + '=' + value;
			}
		}
		return param;
	}
	
	this.searchLoad = function(keys) {
		for(var i = 0; i < keys.length; i ++) {
			var obj = document.getElementById(keys[i]);
			if(this.getParameter(keys[i]) != '') {
				obj.value = this.getParameter(keys[i]);
			}
		}
	}
	
	this.isDirty = function(key) {
		if(this.getParameter(key) != document.getElementById(key).value)
			return true;
		return false;
	}
	
	this.load = function(store) {
		
	}
};

pageLoad = new CommonJs.PageLoad();



