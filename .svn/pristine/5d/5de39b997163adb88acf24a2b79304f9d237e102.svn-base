
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="medical.commoninfo.member.service.MemberVO"%>
<%@ page import="medical.framework.util.StringUtil"%>
<%@ page import="java.util.*"%>
<script type="text/javascript">
//Init the singleton.  Any tag-based quick tips will start working.
Ext.QuickTips.init();
var menuListStore; 
var disClassDtl = "DS001"
	Ext.onReady(function() {
		var menuList =[];
		
		menuListStore = Ext.create('Ext.data.Store', {
			storeId : 'Staging',
			autoLoad : true,
			proxy : {
				type : 'ajax',
				async : false,
				extraParams : { disClassDtl : disClassDtl},
				url : GLOBAL_CONTEXT_PATH
						+ '/medical/main/selectMenuList.do',
				reader : {
					type : 'json',
					root : 'result'
				},			 		
				

			},
			listeners : {
				load : function() {
					menuList=[];
					for(var i=0; i<menuListStore.getTotalCount(); i++){
						menuList.push({
				            xtype: 'container',
				            layout: 'hbox',
				            defaultType: 'textfield',
				            margin: '0',
				            items: [{
				            	xtype:'button',
			                    //text: menuListStore.data.items[i].data.menuNm,
			                    id : menuListStore.data.items[i].data.menuId,
			                    linkUrl: menuListStore.data.items[i].data.linkUrl,
			                    style : 'height:50px', 
			                    html : '<img src="'+GLOBAL_CONTEXT_PATH+menuListStore.data.items[i].data.imageUrl+'">'+menuListStore.data.items[i].data.menuNm,
			                    listeners: {
			                        click: function(btn) {
			                        		for(var i=0; i<menuListStore.getTotalCount(); i++){
			                        			var btnT = Ext.getCmp(menuListStore.data.items[i].data.menuId);
			                        			btnT.removeCls("current");
			                        		}
				                        	$("#bodycontainer_frame").attr('src',GLOBAL_CONTEXT_PATH+'/'+btn.linkUrl+'?menuId='+btn.id);
				                        	var id = Ext.getCmp(btn.id);
				                        	id.addCls("current");
				                        }
					                }				                
				            }]
				        })
						
					}
					Ext.create('Ext.form.Panel',{
						id : 'resizable-menu',
						autoWidth : true,
						fileUpload: true,
						frame: true,
						autoHeight: true,
						renderTo : 'BDSPleft-menu',
						labelWidth: 80,
						// style : "padding-top: 20px;",
						items: menuList		        
					});

					
				}
			}
		});		
		
		
	});

function leftMenuReload(chgcode){
	
	if(disClassDtl!=chgcode){
		//대메뉴 current 클래스 추가
		$('.'+disClassDtl+'_li').removeClass("current");
		$('.'+chgcode+'_li').addClass("current");
		
		Ext.getCmp("resizable-menu").destroy();
		$('.all_menu').hide();
		disClassDtl = chgcode; 
		menuListStore.proxy.extraParams = { disClassDtl : disClassDtl};
		menuListStore.load();
		if(chgcode == "DS003" || chgcode == "DS004"){
			$("#bodycontainer_frame").attr('src',GLOBAL_CONTEXT_PATH+'/dashboardAsd.view');	
		}else{
			$("#bodycontainer_frame").attr('src',GLOBAL_CONTEXT_PATH+'/dashboard.view');	
		}
	}
}

function leftMenuChg(bMenuId,aMenuId){
	
	//왼쪽 메뉴 변경
	if(bMenuId == ""){
		for(var i=0; i<menuListStore.getTotalCount(); i++){
			var btnT = Ext.getCmp(menuListStore.data.items[i].data.menuId);
			btnT.removeCls("current");
		}
	}else{
		Ext.getCmp(bMenuId).removeCls("current");
	}
	Ext.getCmp(aMenuId).addCls("current");
}

function leftMenuChgByUrl(url){
	var linkUrl, menuId;
	for(var i=0; i<menuListStore.getTotalCount(); i++){
		
		linkUrl = menuListStore.data.items[i].data.linkUrl;
		menuId = menuListStore.data.items[i].data.menuId;
		if(url.indexOf(linkUrl) == -1 && Ext.getCmp(menuId).hasCls("current")){
			Ext.getCmp(menuId).removeCls("current");
		}
		if(url.indexOf(linkUrl) != -1){ 
			Ext.getCmp(menuId).addCls("current");
		}
		
	}
}
</script>
<style>
</style>

<div id="BDSPleft">
    <div id="BDSPleft-menu"></div>
</div>