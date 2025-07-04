Ext.ns('Ext.ux.grid');

/**
 * String 클래스에 replaceAll 함수 추가
 * @param search
 * @param replace
 * @returns
 */
String.prototype.replaceAll = function(search, replace)
{
    if(!replace) 
        return this;

    return this.split(search).join(replace);
};

Ext.apply(Ext, {
	/**
	 * 배열 안에 찾는 것이 있는지 판별하는 펑션 추가
	 * @param o
	 * @param val
	 * @returns {Boolean}
	 */
	inArray : function(o, val) {
		if (!Ext.isArray(o)) {
			return false;
		}
		
		for (var i = 0 ; i < o.length ; i++) {
			if (o[i] == val) {
				return true;
			}
		}
		
		return false;
	}
});

Ext.apply(Ext.util.Format, {
	/**
	 * 툴팁
	 * @param v
	 * @param metaData
	 * @returns
	 */
	tooltip : function(v, metaData) {
		metaData.attr = 'ext:qtip="' + Ext.util.Format.htmlEncode(v) + '"';
		
		return v; 
	},
	/**
	 * 링크
	 * @param v 화면에 나오는 값
	 * @param url 링크 url
	 * @param params 파라미터 (json object)
	 * @returns
	 */
	link : function(v, url, params) {
		return String.format('<a href="{0}" class="link">{1}</a>', makeUrl(url, params), Ext.util.Format.htmlEncode(v));
	}
});

/**
 * 폼에 있는 값들을 json 객체로 반환
 * @param formId
 * @returns {___anonymous1247_1248}
 */
function getFormValues(formId) {
	if (!formId) {
		formId = 'searchForm';
	}
	
	var form = $('#' + formId);
	var data = {};
	
	
	form.find('input[type=text]').each(function(i, o) {
		var name = $(o).attr('name') || $(o).attr('id');
		var value = $(o).val();
		
		if (name && value) {
			data[name] = value;
		}
	});
	
	form.find('select').each(function(i, o) {
		var name = $(o).attr('name') || $(o).attr('id');
		var value = $(o).find('option:selected').val();
		
		if (name && value) {
			data[name] = value;
		}
	});
	
	form.find(':checkbox:checked').each(function(i, o) {
		var name = $(o).attr('name') || $(o).attr('id');
		var value = $(o).val();
		
		if (name && value) {
			data[name] = value;
		}
	});
	
	return data;
};

/**
 * datefield 에 'Ymd', 'Ym', 'Y' 3가지 입력이 가능하도록 한다.
 */
Ext.override(Ext.form.DateField, {
	beforeBlur: function (){
		var d = null;
        var raw = this.getRawValue();

        // format 값으로 검사
        d = Date.parseDate(raw, this.format);
        if (d) {
        	raw = d.format(this.format);
        } else {
        	// multiFormat 값으로 검사
        	if (Ext.isArray(this.multiFormat)) {
            	Ext.each(this.multiFormat, function(format) {
                	d = Date.parseDate(raw, format);
                	if (d) {
                		raw = d.format(format);
                		return false;
                	}
                });
            }
        }
        if (!d) {
        	// 빈값일 경우 error 방지
        	if (this.originalValue != '') {
            	raw = this.originalValue.format(this.format);
        	}
        	// 모두 만족하는 값이 아니면 기본값으로 변경
        }
	},
	//Datefield 에서 fmt형식으로 return value
	getYmdValue : function(fmt) {
		var val = this.parseDate(Ext.form.DateField.superclass.getValue.call(this)) || "";
		//fmt 형식을 입력하지 않을 경우 Datefield에 적용된 format 적용
		fmt = typeof(fmt) == 'undefined' || fmt == '' ? this.format : fmt;
		
		return Ext.util.Format.date(val, fmt);
	},
	onFocus : function() {
		if (this.format == 'Y-m-d') {
    		var raw = this.getRawValue();
    		this.setRawValue(raw.replace(/-/gi,''));
		}
	},
	onBlur : function() {
		//Y-m-d Datefield에 Ymd형식으로 입력할 경우 Dash추가 조건
        var raw = this.getRawValue().replace(/-/gi,'');
        if (this.format == 'Y-m-d' && raw.length == 8) {
            var year = raw.substr(0,4);
            var month = raw.substr(4,2);
            var day = raw.substr(6,2);
            raw = year + '-' + month + '-' + day;
        }
        this.setRawValue(raw);
	}
});

/**
 * URL 을 만들어준다.
 * @param url
 * @param params 파라미터 객체 또는 파라미터 문자열
 * @returns {String}
 */
function makeUrl(url, params) {
	if (!url) {
		return '';
	}
	
	if (url.indexOf(GLOBAL_CONTEXT_PATH) == 0) {
		var l = GLOBAL_CONTEXT_PATH.length;
		
		url = url.substring(l, url.length);
	}
	
	if (url.indexOf('/') != 0) {
		url = '/' + url;
	}
	
	return GLOBAL_CONTEXT_PATH + url + (Ext.isEmpty(encodeParams(params), false) == false ? '?' + encodeParams(params) : '');
}

/**
 * 파라미터를 인코딩해서 파라미터 문자열 반환
 * @param obj 객체 또는 파라미터 문자열
 * @returns
 */
function encodeParams(obj) {
	if(!obj) {
		return '';
	}
	
	if (typeof obj === 'string') {
		if(obj.indexOf('?') == 0) {
			obj = obj.substring(1, obj.length);
		}
		obj = Ext.urlDecode(obj);
	}
	
	var p = {};
	
	for (var key in obj) {
		
		if (!key) continue;
		
		var v = obj[key];

		switch (typeof v) {
		case 'undefined':
			continue;
			break;
		case 'string':
			if (!v) continue;
			break;
		}
		
		p[key] = v;
	}
	
	return Ext.urlEncode(p);
}

/**
 * 모달팝업을 띄운다.
 *
 * @param     : htmlUrl(모달팝업주소), paramValue(인수), popupWidth(넓이), popupHeight(높이)
 * @return    : 모달팝업 호출
 *
*/
function ShowPopup(htmlUrl, paramValue, popupWidth, popupHeight){
	var feat = "dialogHeight:" + popupHeight + "px;dialogWidth:" + popupWidth + "px;center:yes;edge:raised;help:no;resizable:no;scroll:no;status:no;";

	return window.showModalDialog(htmlUrl, paramValue, feat);
}

function formatDate(value){
    return value ? value.dateFormat('Y-m') : '';
}

Ext.ux.grid.CheckColumn = function(config){
    Ext.apply(this, config);
    if(!this.id){
        this.id = Ext.id();
    }
    this.renderer = this.renderer.createDelegate(this);
};

Ext.ux.grid.CheckColumn.prototype ={
    init : function(grid){
        this.grid = grid;
        this.grid.on('render', function(){
            var view = this.grid.getView();
            view.mainBody.on('mousedown', this.onMouseDown, this);
        }, this);
    },

    onMouseDown : function(e, t){
        if(t.className && t.className.indexOf('x-grid3-cc-'+this.id) != -1){
            e.stopEvent();
            var index = this.grid.getView().findRowIndex(t);
            var record = this.grid.store.getAt(index);
            record.set(this.dataIndex, !record.data[this.dataIndex]);
        }
    },

    renderer : function(v, p, record){
        p.css += ' x-grid3-check-col-td'; 
        return '<div class="x-grid3-check-col'+(v?'-on':'')+' x-grid3-cc-'+this.id+'">&#160;</div>';
    }
};

// register ptype
//Ext.preg('checkcolumn', Ext.ux.grid.CheckColumn);

// backwards compat
Ext.grid.CheckColumn = Ext.ux.grid.CheckColumn;

Ext.ux.grid.RowEditor = Ext.extend(Ext.Panel, {
    floating: true,
    shadow: false,
    layout: 'hbox',
    cls: 'x-small-editor',
    buttonAlign: 'center',
    baseCls: 'x-row-editor',
    elements: 'header,footer,body',
    frameWidth: 5,
    buttonPad: 3,
    clicksToEdit: 'auto',
    monitorValid: true,
    focusDelay: 250,
    errorSummary: true,

    saveText: 'Save',
    cancelText: 'Cancel',
    commitChangesText: 'You need to commit or cancel your changes',
    errorText: 'Errors',
    blChkText: '필수값을 입력하세요',

    defaults: {
        normalWidth: true
    },

    initComponent: function(){
        Ext.ux.grid.RowEditor.superclass.initComponent.call(this);
        this.addEvents(
            /**
             * @event beforeedit
             * Fired before the row editor is activated.
             * If the listener returns <tt>false</tt> the editor will not be activated.
             * @param {Ext.ux.grid.RowEditor} roweditor This object
             * @param {Number} rowIndex The rowIndex of the row just edited
             */
            'beforeedit',
            /**
             * @event canceledit
             * Fired when the editor is cancelled.
             * @param {Ext.ux.grid.RowEditor} roweditor This object
             * @param {Boolean} forced True if the cancel button is pressed, false is the editor was invalid.
             */
            'canceledit',
            /**
             * @event validateedit
             * Fired after a row is edited and passes validation.
             * If the listener returns <tt>false</tt> changes to the record will not be set.
             * @param {Ext.ux.grid.RowEditor} roweditor This object
             * @param {Object} changes Object with changes made to the record.
             * @param {Ext.data.Record} r The Record that was edited.
             * @param {Number} rowIndex The rowIndex of the row just edited
             */
            'validateedit',
            /**
             * @event afteredit
             * Fired after a row is edited and passes validation.  This event is fired
             * after the store's update event is fired with this edit.
             * @param {Ext.ux.grid.RowEditor} roweditor This object
             * @param {Object} changes Object with changes made to the record.
             * @param {Ext.data.Record} r The Record that was edited.
             * @param {Number} rowIndex The rowIndex of the row just edited
             */
            'afteredit'
        );
    },

    init: function(grid){
        this.grid = grid;
        this.ownerCt = grid;
        if(this.clicksToEdit === 2){
            grid.on('rowdblclick', this.onRowDblClick, this);
        }else{
            grid.on('rowclick', this.onRowClick, this);
            if(Ext.isIE){
                grid.on('rowdblclick', this.onRowDblClick, this);
            }
        }

        // stopEditing without saving when a record is removed from Store.
        grid.getStore().on('remove', function() {
            this.stopEditing(false);
        },this);

        grid.on({
            scope: this,
            keydown: this.onGridKey,
            columnresize: this.verifyLayout,
            columnmove: this.refreshFields,
            reconfigure: this.refreshFields,
            beforedestroy : this.beforedestroy,
            destroy : this.destroy,
            bodyscroll: {
                buffer: 250,
                fn: this.positionButtons
            }
        });
        grid.getColumnModel().on('hiddenchange', this.verifyLayout, this, {delay:1});
        grid.getView().on('refresh', this.stopEditing.createDelegate(this, []));
    },

    beforedestroy: function() {
        this.stopMonitoring();
        this.grid.getStore().un('remove', this.onStoreRemove, this);
        this.stopEditing(false);
        Ext.destroy(this.btns, this.tooltip);
    },

    refreshFields: function(){
        this.initFields();
        this.verifyLayout();
    },

    isDirty: function(){
        var dirty;
        this.items.each(function(f){
            if(String(this.values[f.id]) !== String(f.getValue())){
                dirty = true;
                return false;
            }
        }, this);
        return dirty;
    },
    
    isEditing: function(){
        if(this.editing){
        	return true;
        }
    },
    
    startEditing: function(rowIndex, doFocus){
        if(this.editing && this.isDirty()){
            this.showTooltip(this.commitChangesText);
            return;
        }
        if(Ext.isObject(rowIndex)){
            rowIndex = this.grid.getStore().indexOf(rowIndex);
        }
        if(this.fireEvent('beforeedit', this, rowIndex) !== false){
            this.editing = true;
            var g = this.grid, view = g.getView(),
                row = view.getRow(rowIndex),
                record = g.store.getAt(rowIndex);

            this.record = record;
            this.rowIndex = rowIndex;
            this.values = {};
            if(!this.rendered){
                this.render(view.getEditorParent());
            }
            var w = Ext.fly(row).getWidth();
            this.setSize(w);
            if(!this.initialized){
                this.initFields();
            }
            var cm = g.getColumnModel(), fields = this.items.items, f, val;
            for(var i = 0, len = cm.getColumnCount(); i < len; i++){
                val = this.preEditValue(record, cm.getDataIndex(i));
                f = fields[i];
                f.setValue(val);               
              /* 특정 아이디가 아닌부분은 disabled하는 로직 제외
                if(f.id=="editCost" || f.id=="id_comboDeterminBasis" || f.id=="id_comboMeetYn" || f.id=="id_comboOrigin" || f.id=="id_rvcrate")
                {
                }
                else
               	{
                    f.setDisabled(cm.isCellEditable(i, row));
               	}
              */
              // id에 _disable이 포함되어있을경우 disable
                if(f.column.id.indexOf("_disable") >= 1){
                	f.setDisabled(cm.isCellEditable(i, row));   
                }
                
                this.values[f.id] = Ext.isEmpty(val) ? '' : val;
            }
            this.verifyLayout(true);
            if(!this.isVisible()){
                this.setPagePosition(Ext.fly(row).getXY());
            } else{
                this.el.setXY(Ext.fly(row).getXY(), {duration:0.15});
            }
            if(!this.isVisible()){
                this.show().doLayout();
            }
            if(doFocus !== false){
                this.doFocus.defer(this.focusDelay, this);
            }
        }
    },
   startInserting: function(rowIndex, doFocus){
        if(this.editing && this.isDirty()){
            this.showTooltip(this.commitChangesText);
            return;
        }
        if(Ext.isObject(rowIndex)){
            rowIndex = this.grid.getStore().indexOf(rowIndex);
        }
        if(this.fireEvent('beforeedit', this, rowIndex) !== false){
            this.editing = true;
            var g = this.grid, view = g.getView(),
                row = view.getRow(rowIndex),
                record = g.store.getAt(rowIndex);

            this.record = record;
            this.rowIndex = rowIndex;
            this.values = {};
            if(!this.rendered){
                this.render(view.getEditorParent());
            }
            var w = Ext.fly(row).getWidth();
            this.setSize(w);
            if(!this.initialized){
                this.initFields();
            }
            var cm = g.getColumnModel(), fields = this.items.items, f, val;
            for(var i = 0, len = cm.getColumnCount(); i < len; i++){
                val = this.preEditValue(record, cm.getDataIndex(i));
                f = fields[i];
                f.setValue(val);
                f.setDisabled(!cm.isCellEditable(i, row));
                this.values[f.id] = Ext.isEmpty(val) ? '' : val;
            }
            this.verifyLayout(true);
            if(!this.isVisible()){
                this.setPagePosition(Ext.fly(row).getXY());
            } else{
                this.el.setXY(Ext.fly(row).getXY(), {duration:0.15});
            }
            if(!this.isVisible()){
                this.show().doLayout();
            }
            if(doFocus !== false){
                this.doFocus.defer(this.focusDelay, this);
            }
        }
    },
    stopEditing : function(saveChanges){   	
        this.editing = false;
        if(!this.isVisible()){
            return;
        }
        if(saveChanges === false || !this.isValid()){
            this.hide();
            this.fireEvent('canceledit', this, saveChanges === false);
            return;
        }
        var changes = {},
            r = this.record,
            hasChange = false,
            cm = this.grid.colModel,
            fields = this.items.items;
        for(var i = 0, len = cm.getColumnCount(); i < len; i++){
            if(!cm.isHidden(i)){
                var dindex = cm.getDataIndex(i);
                if(!Ext.isEmpty(dindex)){
                    var oldValue = r.data[dindex],
                        value = this.postEditValue(fields[i].getValue(), oldValue, r, dindex);
                    
                    f = fields[i];
                    // id에 _blChk이 포함되어있을경우 빈칸값 확인
                    if(f.column.id.indexOf("_blChk") >= 1 && String(value) == ''){
                    	this.showTooltip(this.blChkText);
                    	return;
                    }
                    
                    if(String(oldValue) !== String(value)){
                        changes[dindex] = value;
                        hasChange = true;
                    }
                    
                }
                changes['editCheck'] ='Y';
            }
        }
        if(hasChange && this.fireEvent('validateedit', this, changes, r, this.rowIndex) !== false){
            r.beginEdit();
            Ext.iterate(changes, function(name, value){
                r.set(name, value);
            });
            r.endEdit();
            this.fireEvent('afteredit', this, changes, r, this.rowIndex);
        }
        this.hide();
    },

    verifyLayout: function(force){
        if(this.el && (this.isVisible() || force === true)){
            var row = this.grid.getView().getRow(this.rowIndex);
            this.setSize(Ext.fly(row).getWidth(), Ext.isIE ? Ext.fly(row).getHeight() + 10 : Ext.fly(row).getHeight());
            var cm = this.grid.colModel, fields = this.items.items;
            for(var i = 0, len = cm.getColumnCount(); i < len; i++){
                if(!cm.isHidden(i)){
                    var adjust = 0;
                    if(i === (len - 1)){
                        adjust += 3; // outer padding
                    } else{
                        adjust += 1;
                    }
                    fields[i].show();
                    fields[i].setWidth(cm.getColumnWidth(i) - adjust);
                } else{
                    fields[i].hide();
                }
            }
            this.doLayout();
            this.positionButtons();
        }
    },

    slideHide : function(){
        this.hide();
    },

    initFields: function(){
        var cm = this.grid.getColumnModel(), pm = Ext.layout.ContainerLayout.prototype.parseMargins;
        this.removeAll(false);
        for(var i = 0, len = cm.getColumnCount(); i < len; i++){
            var c = cm.getColumnAt(i),
                ed = c.getEditor();
            if(!ed){
                ed = c.displayEditor || new Ext.form.DisplayField();
            }
            if(i == 0){
                ed.margins = pm('0 1 2 1');
            } else if(i == len - 1){
                ed.margins = pm('0 0 2 1');
            } else{
                ed.margins = pm('0 1 2');
            }
            ed.setWidth(cm.getColumnWidth(i));
            ed.column = c;
            if(ed.ownerCt !== this){
                ed.on('focus', this.ensureVisible, this);
                ed.on('specialkey', this.onKey, this);
            }
            this.insert(i, ed);
        }
        this.initialized = true;
    },

    onKey: function(f, e){
        if(e.getKey() === e.ENTER){
            this.stopEditing(true);
            e.stopPropagation();
        }
    },

    onGridKey: function(e){
        if(e.getKey() === e.ENTER && !this.isVisible()){
            var r = this.grid.getSelectionModel().getSelected();
            if(r){
                var index = this.grid.store.indexOf(r);
                this.startEditing(index);
                e.stopPropagation();
            }
        }
    },

    ensureVisible: function(editor){
        if(this.isVisible()){
             this.grid.getView().ensureVisible(this.rowIndex, this.grid.colModel.getIndexById(editor.column.id), true);
        }
    },

    onRowClick: function(g, rowIndex, e){
        if(this.clicksToEdit == 'auto'){
            var li = this.lastClickIndex;
            this.lastClickIndex = rowIndex;
            if(li != rowIndex && !this.isVisible()){
                return;
            }
        }
        this.startEditing(rowIndex, false);
        this.doFocus.defer(this.focusDelay, this, [e.getPoint()]);
    },

    onRowDblClick: function(g, rowIndex, e){
        this.startEditing(rowIndex, false);
        this.doFocus.defer(this.focusDelay, this, [e.getPoint()]);
    },

    onRender: function(){
        Ext.ux.grid.RowEditor.superclass.onRender.apply(this, arguments);
        this.el.swallowEvent(['keydown', 'keyup', 'keypress']);
        this.btns = new Ext.Panel({
            baseCls: 'x-plain',
            cls: 'x-btns',
            elements:'body',
            layout: 'table',
            width: (this.minButtonWidth * 2) + (this.frameWidth * 2) + (this.buttonPad * 4), // width must be specified for IE
            items: [{
                ref: 'saveBtn',
                itemId: 'saveBtn',
                xtype: 'button',
                text: this.saveText,
                width: this.minButtonWidth,
                handler: this.stopEditing.createDelegate(this, [true])
            },{
                xtype: 'button',
                text: this.cancelText,
                width: this.minButtonWidth,
                handler: this.stopEditing.createDelegate(this, [false])
            }]
        });
        this.btns.render(this.bwrap);
    },

    afterRender: function(){
        Ext.ux.grid.RowEditor.superclass.afterRender.apply(this, arguments);
        this.positionButtons();
        if(this.monitorValid){
            this.startMonitoring();
        }
    },

    onShow: function(){
        if(this.monitorValid){
            this.startMonitoring();
        }
        Ext.ux.grid.RowEditor.superclass.onShow.apply(this, arguments);
    },

    onHide: function(){
        Ext.ux.grid.RowEditor.superclass.onHide.apply(this, arguments);
        this.stopMonitoring();
        this.grid.getView().focusRow(this.rowIndex);
    },

    positionButtons: function(){
        if(this.btns){
            var g = this.grid,
                h = this.el.dom.clientHeight,
                view = g.getView(),
                scroll = view.scroller.dom.scrollLeft,
                bw = this.btns.getWidth(),
                width = Math.min(g.getWidth(), g.getColumnModel().getTotalWidth());

            this.btns.el.shift({left: (width/2)-(bw/2)+scroll, top: h + 12, stopFx: true, duration:0.2});
        }
    },

    // private
    preEditValue : function(r, field){
        var value = r.data[field];
        return this.autoEncode && typeof value === 'string' ? Ext.util.Format.htmlDecode(value) : value;
    },

    // private
    postEditValue : function(value, originalValue, r, field){
        return this.autoEncode && typeof value == 'string' ? Ext.util.Format.htmlEncode(value) : value;
    },

    doFocus: function(pt){
        if(this.isVisible()){
            var index = 0,
                cm = this.grid.getColumnModel(),
                c;
            if(pt){
                index = this.getTargetColumnIndex(pt);
            }
            for(var i = index||0, len = cm.getColumnCount(); i < len; i++){
                c = cm.getColumnAt(i);
                if(!c.hidden && c.getEditor()){
                    c.getEditor().focus();
                    break;
                }
            }
        }
    },

    getTargetColumnIndex: function(pt){
        var grid = this.grid,
            v = grid.view,
            x = pt.left,
            cms = grid.colModel.config,
            i = 0,
            match = false;
        for(var len = cms.length, c; c = cms[i]; i++){
            if(!c.hidden){
                if(Ext.fly(v.getHeaderCell(i)).getRegion().right >= x){
                    match = i;
                    break;
                }
            }
        }
        return match;
    },

    startMonitoring : function(){
        if(!this.bound && this.monitorValid){
            this.bound = true;
            Ext.TaskMgr.start({
                run : this.bindHandler,
                interval : this.monitorPoll || 200,
                scope: this
            });
        }
    },

    stopMonitoring : function(){
        this.bound = false;
        if(this.tooltip){
            this.tooltip.hide();
        }
    },

    isValid: function(){
        var valid = true;
        this.items.each(function(f){
            if(!f.isValid(true)){
                valid = false;
                return false;
            }
        });
        return valid;
    },

    // private
    bindHandler : function(){
        if(!this.bound){
            return false; // stops binding
        }
        var valid = this.isValid();
        if(!valid && this.errorSummary){
            this.showTooltip(this.getErrorText().join(''));
        }
        this.btns.saveBtn.setDisabled(!valid);
        this.fireEvent('validation', this, valid);
    },

    showTooltip: function(msg){
        var t = this.tooltip;
        if(!t){
            t = this.tooltip = new Ext.ToolTip({
                maxWidth: 600,
                cls: 'errorTip',
                width: 300,
                title: this.errorText,
                autoHide: false,
                anchor: 'left',
                anchorToTarget: true,
                mouseOffset: [40,0]
            });
        }
        var v = this.grid.getView(),
            top = parseInt(this.el.dom.style.top, 10),
            scroll = v.scroller.dom.scrollTop,
            h = this.el.getHeight();

        if(top + h >= scroll){
//            t.initTarget(this.items.last().getEl());
            t.initTarget(this.btns.getEl());
            if(!t.rendered){
                t.show();
                t.hide();
            }
            t.body.update(msg);
            t.doAutoWidth(20);
            t.show();
        }else if(t.rendered){
            t.hide();
        }
    },

    getErrorText: function(){
        var data = ['<ul>'];
        this.items.each(function(f){
            if(!f.isValid(true)){
                data.push('<li>', f.getActiveError(), '</li>');
            }
        });
        data.push('</ul>');
        return data;
    }
});
//Ext.preg('roweditor', Ext.ux.grid.RowEditor);

Ext.ns('Ext.ux.form');

//controll 할 xtype 들..
var GL_FIELD_CONTR_TYPE_ARR =["textfield","checkbox","radiogroup","checkboxgroup","datefield","button","compositefield"];

//readonly css
var GL_READONLY_CSS = 'txt-readOnly';

var GL_DEFAULT_LIMIT = 15;

Ext.ux.form.SearchField = Ext.extend(Ext.form.TwinTriggerField, {
    initComponent : function(){
        Ext.ux.form.SearchField.superclass.initComponent.call(this);
        this.on('specialkey', function(f, e){
            if(e.getKey() == e.ENTER){
                this.onTrigger2Click();
            }
        }, this);
    },

    validationEvent: false,
    validateOnBlur: false,
    trigger1Class: 'x-form-clear-trigger',
    trigger2Class: 'x-form-search-trigger',
    hideTrigger1: true,
    width:180,
    hasSearch: false,
    paramName: 'schKeyWord',
    paramName2: 'schKeyField',
    
	onTrigger1Click : function(){
	    if(this.hasSearch){
	    	//loader
	    	if(typeof(this.loader) != "undefined" && 
	    		this.loader != "") {
			    this.loader.baseParams[this.paramName] = '';
		    	this.loader.baseParams[this.paramName2] = '';
			    this.loader.loadContents();
    		}
		    //store
	    	if(typeof(this.store) != "undefined" && 
	    		this.store != "") {
		        this.store.baseParams[this.paramName] = '';
			    			        
				//tbar의 다른 항목을 검색조건에 추가 하고자 할경우.
				if(typeof(this.addTbarPrams) != "undefined" && this.addTbarPrams){
					for(var i=0; i<this.ownerCt.items.items.length; i++){
						var xtype = this.ownerCt.items.items[i].getXType();
						if(xtype == "combo" || xtype == "hidden"){
							this.store.baseParams[this.ownerCt.items.items[i].name] = this.ownerCt.items.items[i].getValue();
						}
					}
				}		        
				var limit = GL_DEFAULT_LIMIT;
				if(typeof(this.limit) != "undefined" && this.limit > 0){
					limit = this.limit;
				}					    
			    var o = {start: 0,limit : limit};
			    //this.store.reload({params:o});
			    this.store.load({params:o});
    		}
	    	//common
			this.el.dom.value = '';
	        this.triggers[0].hide();
	        this.hasSearch = false;
			this.focus();
	    }
	},
	
	onTrigger2Click : function(){
	    var v = this.getRawValue();
	    
		if(typeof(this.allowBlankSearch) != "undefined" && this.allowBlankSearch == true){
			this.hasSearch = true;
		}
	    /*if(v.length < 1){
	        this.onTrigger1Click();
	        return;
	    }
		if(!this.allowBlankSearch && v.length < 2){
			Ext.Msg.alert('Invalid Search', 'You must enter a minimum of 2 characters to search the API');
			return;
		}*/
	    //loader
    	if(typeof(this.loader) != "undefined" && 
    		this.loader != "") {
		    this.loader.baseParams[this.paramName] = v;
		    this.loader.baseParams[this.paramName2] = this.loader.baseParams.schKeyField;
		    this.loader.loadContents();
    	}
	    //store
    	if(typeof(this.store) != "undefined" && 
    		this.store != "") {
			this.store.baseParams[this.paramName] = v;
			
			//tbar의 다른 항목을 검색조건에 추가 하고자 할경우.
			if(typeof(this.addTbarPrams) != "undefined" && this.addTbarPrams){
				for(var i=0; i<this.ownerCt.items.items.length; i++){
					var xtype = this.ownerCt.items.items[i].getXType();
					if(xtype == "combo" || xtype == "hidden"){
						this.store.baseParams[this.ownerCt.items.items[i].name] = this.ownerCt.items.items[i].getValue();
					}
				}
			}
			
//			if(typeof(this.limit)== "undefined"){
//				alert("TwinTriggerField 에 limit option이 누락되었습니다.\nex)limit: 10");
//				return;
//			}
			var limit = GL_DEFAULT_LIMIT;
			if(typeof(this.limit) != "undefined" && this.limit > 0){
				limit = this.limit;
			}			
		    var o = {start: 0, limit : limit};
		    //this.store.reload({params:o});
		    this.store.load({params:o});
    	}
	    //common
	    this.hasSearch = true;
	    this.triggers[0].show();
		this.focus();
	}
});
//Ext.reg('searchfield', Ext.ux.form.SearchField);

/*
 * panelName -- panel id
 * args - button 구분명 (등록버튼-> REG [regHandler], 
 * 						수정버튼->MODIFY [modifyHandler], 
 * 						삭제버튼 --> DELETE [deleteHandler], 
 * 						목록버튼 --> LIST [listHandler], 
 * 						저장버튼 --> SAVE [saveHandler], 
 * 						EXCEL 버튼 --> EXCEL [excelHandler], 
 * 						PRINT 버튼 --> PRINT [printHandler])
 * 						닫기 버튼 --> CLOSE [closeHandler])
 * 						새로고침 버튼 --> REFRESH 
 * 				기타	    '-' Separator --> '-' 
 * 				 	    ' ' Spacer --> ' ' 
 *       ex)args = ["REG","MODIFY","DELETE","LIST"];
 * fillYn - tbar fill을 추가 할건지 여부 (버튼이 왼쪽 정렬됨) --> default true
 * removeAllYn - 기존 버튼을 모두 지울지 여부 --> default false
 * 
 */
var glTbarButtonsArr=["REG","MODIFY","DELETE","LIST","SAVE","EXCEL","PRINT","CLOSE","UPLOAD","STOP","PLAY"];

Ext.ux.form.TbarButton = function(panelName,args,fillYn,removeAllYn) {
	
	var panel = Ext.getCmp(panelName);
	var tb = panel.getTopToolbar();
	
	var isNewTbar = false;
	
	if(typeof(tb)== 'undefined'){	
		tb = new Ext.Toolbar();
		//panel.add(tb);
		isNewTbar = true;
	}
	
	//default true
	if(typeof(removeAllYn)!= 'undefined' && removeAllYn==true){
		tb.removeAll(true);
	}else{
		
		var isDelete = false;
		//tbfill 이후 모든 component를 삭제한다.
		for(var i=0; i<tb.items.items.length; i++){	
			
			var type = tb.items.items[i].getXType();
			if(isDelete && 
			   (type == 'button' ||
			    type == 'tbspace'||
			    type == 'tbseparator')){
				tb.remove(tb.items.items[i].id,true);
				i--;
			}			
			if(type == "tbfill"){
				isDelete = true;
				continue;
			}
		}				
		/*
		for(var i=0; i<glTbarButtonsArr.length; i++){
			tb.remove(panelName+glTbarButtonsArr[i]+"Button",true);
		}*/
		
	}
	
	//default true
	if(typeof(fillYn)== 'undefined' || fillYn!=false){
		tb.addFill();
	}

	for(var i=0; i<args.length; i++){
		//등록버튼
		if(args[i] == "REG"){
		    tb.addButton( {
					text: BTN_REGISTER,
					id : panelName+glTbarButtonsArr[i]+"Button",
					iconCls:'btn_reg',
					scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
					mode: args[i],
					handler: panel.regHandler
				});			
		
		//수정버튼
		}else if(args[i] == "MODIFY"){
			tb.addButton( {
					text:BTN_MODIFY,
					id : panelName+glTbarButtonsArr[i]+"Button",
				    iconCls:'btn_modify',		
				    scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
  					mode: args[i],
					handler: panel.modifyHandler
				});		
			
		//수정버튼 - 이름은저장
		}else if(args[i] == "SMODIFY"){
			tb.addButton( {
					text:BTN_SAVE,
					id : panelName+glTbarButtonsArr[i]+"Button",
				    iconCls:'btn_save',		
				    scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
  					mode: args[i],
					handler: panel.modifyHandler
				});	
				
		//삭제버튼
		}else if(args[i] == "DELETE"){
			tb.addButton( {
					text:BTN_DELETE,
					id : panelName+glTbarButtonsArr[i]+"Button",
				    iconCls:'btn_delete',		
				    scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
					mode: args[i],
				    handler: panel.deleteHandler
				});			
					
										
		//목록버튼
		}else if(args[i] == "LIST"){
	    	tb.addButton( {
					text:BTN_LIST,
					id : panelName+glTbarButtonsArr[i]+"Button",
				    iconCls:'btn_list',		
				    scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
					mode: args[i],
					handler: panel.listHandler
				});			
				
										
		//저장버튼
		}else if(args[i] == "SAVE"){
		    tb.addButton( {
					text:BTN_SAVE,
					id : panelName+glTbarButtonsArr[i]+"Button",
				    iconCls:'btn_save',		
				    scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
					mode: args[i],
					handler: panel.saveHandler
				});			
										
		//EXCEL 버튼
		}else if(args[i] == "EXCEL"){
		    tb.addButton( {
					text:BTN_EXCEL,
					id : panelName+glTbarButtonsArr[i]+"Button",
				    iconCls:'btn_excel',
				    scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
					mode: args[i],
					handler: panel.exportHandler
				});			
			
		//PRINT 버튼
		}else if(args[i] == "PRINT"){
		    tb.addButton( {
					text:BTN_PRINT,
					id : panelName+glTbarButtonsArr[i]+"Button",
				    iconCls:'btn_print',		
				    scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
					mode: args[i],
					handler: panel.printHandler
				});							
		//CLOSE 버튼
		}else if(args[i] == "CLOSE"){
		    tb.addButton( {
					text:BTN_CLOSE,
					id : panelName+glTbarButtonsArr[i]+"Button",
				    iconCls:'btn_close',		
				    scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
					mode: args[i],
					handler: panel.closeHandler
				});									
		//UPLOAD 버튼
		}else if(args[i] == "UPLOAD"){
		    tb.addButton( {
					text:BTN_UPLOAD,
					id : panelName+glTbarButtonsArr[i]+"Button",
				    iconCls:'btn_excel',		
				    scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
					mode: args[i],
					handler: panel.uploadHandler
				});	
				
		//STOP 버튼
		}else if(args[i] == "STOP"){
		    tb.addButton( {
					text:BTN_STOP,
					id : panelName+glTbarButtonsArr[i]+"Button",
				    iconCls:'btn_stop',		
				    scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
					mode: args[i],
					handler: panel.stopHandler
				});									
		//PLAY 버튼
		}else if(args[i] == "PLAY"){
		    tb.addButton( {
					text:BTN_PLAY,
					id : panelName+glTbarButtonsArr[i]+"Button",
				    iconCls:'btn_play',		
				    scale: 'small',
					height: '20',
					style: 'background:none; border:none;',
					mode: args[i],
					handler: panel.playHandler
				});									

		//Separator
		}else if(args[i] == "-"){
		   tb.addSeparator();
		   
		//Separator
		}else if(args[i] == " "){
		   tb.addSpacer(); 
		}
		
		tb.doLayout();
		
		if(isNewTbar){
			panel.add(tb);
		}
	}
	
	
	this.add = function(id,text,event,css){
	    tb.addButton( {
			text:text,
			id : panelName+id,
		    iconCls:css,		
		    scale: 'small',
			height: '20',
			style: 'background:none; border:none;',
			mode: id,
			handler: eval('panel.'+event)
		});				
		tb.doLayout();
		
	};
	this.addSeparator = function(){
		   tb.addSeparator();
	};	
	this.addSpacer = function(){
		   tb.addSpacer();
	};		
};
/*
 * form submit 처리를 위한 Class
 * args - formId : FormPanel id
 *        url : form submit url
 *        svcId : transaction 구분값 ex) 'REG','MODIFY'....
 *               - callback 함수에서 구분에 따른 후처리수행시 필요
 *        params : 입력항목외 추가적으로 넘어가야 하는 Parameter
 *              ex){nameKor :loginInputForm.getForm().findField("userId").getValue()};
 *       successMsg : 저정후 메세지 (서버의 메세지가 우선 적용됨)
 * 
 */
Ext.ux.form.Transaction = function() {
	var formId;
	var params;
	var svcId;
	var url;
	var successMsg = '작업 중.... 잠시만 기다려 주세요.';
	
	this.set = function(formId,url,svcId,params,successMsg){
		this.formId = formId;
		this.url = url;
		this.svcId = svcId;
		this.params = params;
		if(typeof(successMsg) != "undefined"){
			this.successMsg = successMsg;
		}
	};
	
	this.setSuccessMsg = function(successMsg){
		this.successMsg = successMsg;
	};
	
	this.setParams = function(params){
		this.params = params;
	};
	
	this.submit = function(){
		if(!this.formId.getForm().isValid()) return false;
		
		this.formId.getForm().setValues(this.params);

		var callbackForm = this.formId;
		var msg = this.successMsg;
		var param = this.params;
		var serviceId = this.svcId;
		
		if(typeof(param) == "undefined" ||
		  param == ""){
		  	param = {createBy:member.userId,updateBy:member.userId};
		  }else{ 
			param.createBy = member.userId;
			param.updateBy = member.userId;
		  }
				  
		if(typeof(serviceId) == "undefined"){
			serviceId = '';
		}
		
		var fields = this.formId.findByType("combo");
		var disableArr = Array();
		var j = 0;
		for(var i=0; i<fields.length; i++){
			if(fields[i].disabled){
				fields[i].enable(true);
				disableArr[j++]=fields[i];
			}
		}
		
		this.formId.getForm().submit({
             url: this.url,
			 method: 'POST',
			 params:param,
			 waitMsg: 'Saving Information...',
			 failure: function(form, action) {
					if(disableArr !== null && disableArr.length > 0){
						for(var i=0; i<disableArr.length; i++){
							fields[i].disable(true);
						}
					}
					var errorMsg = "";
			        switch (action.failureType) {
			            case Ext.form.Action.CLIENT_INVALID:
                            //errorMsg = "Form fields may not be submitted with invalid values";
                            errorMsg = "입력값을 확인하세요.";
			            break;
			            case Ext.form.Action.CONNECT_FAILURE:
                            //errorMsg = action.response.responseText;
                            errorMsg = "시스템 담당자에게 물어보세요.";
			            break;
			            case Ext.form.Action.SERVER_INVALID:
							errorMsg = Ext.util.JSON.decode(action.response.responseText).errors.reason;
			            	// errorMsg = "오류가 발생하였습니다.<br>F5를 누르시고 다시 시도해 주세요.";
			            break;
			        }
			        
			        var myMask  =  new Ext.LoadMask(Ext.getBody(), {msg: '잠시만 기다려주세요...'});
			        myMask.hide();
			        
					Ext.Msg.alert('Fail'
								 ,errorMsg
								 ,function(btn, text){
									    callbackForm.callback(serviceId,action.failureType);
								  });
				},
				success: function(form, action){
					if(disableArr !== null && disableArr.length > 0){
						for(var i=0; i<disableArr.length; i++){
							fields[i].disable(true);
						}
					}
					
					//서버 Message 우선
					if(typeof(action.result.messages) != "undefined" &&
					   typeof(action.result.messages.message) != "undefined" && 
					   action.result.messages.message != ""){
					   msg = action.result.messages.message;
					 }

			        var myMask  =  new Ext.LoadMask(Ext.getBody(), {msg: '잠시만 기다려주세요...'});
			        myMask.hide();
			        
					if(typeof(msg) != "undefined" && msg != ""){
						Ext.Msg.alert('Success'
									 ,msg
									 ,function(btn, text){
										 	try {
										 		callbackForm.callback(serviceId,action.failureType);
										 	} catch (e) {
										 		if(console) {
										 			console.error(e);
										 		}
										 	}
									  });											
					 }else{
					 	callbackForm.callback(serviceId,'');
					 }
				}
			}); 
		};
};



/*
 * Form Element 제어를 위한 Class
 * 
 * 사용 예시)
 * 	var cont = new Ext.ux.form.FieldControl(Ext.getCmp('Main.MemberModifyForm'));
 *
 *	cont.enableAll(); //입력항목 전부를 enable 시킨다.
 *	cont.enable('E'); //userData가 E인 항목만 Enable 시킨다.
 *	cont.enableNDisable('E'); //userData가 E인 항목만 Enable 시키고 나머지 항목은 Disable 시킨다.
 *	cont.enableNDisable('E','D'); //userData가 E인 항목만 Enable 시키고 'D'인 항목은  Disable 시킨다.
 *	cont.disableNEnable('E'); //userData가 E인 항목만 Disable 시키고 나머지 항목은 Enable 시킨다.
 *	cont.disableNEnable('E','D'); //userData가 E인 항목만 Disable 시키고 'D'인 항목은  Enable 시킨다.
 *	cont.disableAll(); //입력항목전부를 disable 시킨다.
 *	cont.disable('D'); //userData가 D인 항목만 Disable 시킨다.
 * 
 */
Ext.ux.form.FieldControl = function(form) {
	var formId = form;
	var isEnable = false;
	var isDisable = false;
	var enableFlag;
	var disableFlag;
	

	this.enableAll = function(){
		this.isEnable = true;
		this.isDisable = false;
		this.enableFlag = "ALL";
		this.disableFlag = "";
		
		this.doEnable();
	};
	
	this.enable = function(flag){
		this.isEnable = true;
		this.isDisable = false;
		this.enableFlag = flag;
		this.disableFlag = "";
		
		this.doEnable();
	};	
	this.enableNDisable = function(enableFlag,disableFalg){
		this.isEnable = true;
		this.isDisable = true;
		this.enableFlag = enableFlag;
		if(typeof(disableFalg) != "undefined" && disableFalg != ""){
			this.disableFlag = disableFalg;
		}else{
			this.disableFlag = "ALL";
		}
		
		this.doEnable();
	};	
	
	this.disableNEnable = function(disableFlag,enableFlag){
		this.isEnable = true;
		this.isDisable = true;
		this.disableFlag = disableFlag;
		if(typeof(enableFlag) != "undefined" && enableFlag != ""){
			this.enableFlag = enableFlag;
		}else{
			this.enableFlag = "DISABLE";
		}
		
		this.doEnable();
	};
		
	
	this.disable = function(flag){
		this.isEnable = false;
		this.isDisable = true;
		this.enableFlag = "";
		this.disableFlag = flag;
		
		this.doEnable();
	};
		
	this.disableAll = function(){
		this.isEnable = false;
		this.isDisable = true;
		this.enableFlag = "";
		this.disableFlag = "ALL";
		
		this.doEnable();		
	};
	
	this.uxDisplayOnly = function(field,displayOnly, cls) {
		var displayOnly = (displayOnly === false) ? false : true;
		var cls = (cls) ? cls : GL_READONLY_CSS;

		if (displayOnly) {
			field.el.addClass(cls);
		} else {
			field.el.removeClass(cls);
		}
		var xType = field.getXType();

		field.el.dom.readOnly = displayOnly;

		if (xType == 'checkbox') {
			field.readOnly = displayOnly; 
			
		}else if (xType == 'radiogroup' || xType == 'checkboxgroup' || xType =='compositefield') {
			field.el.removeClass(cls);

			var items = field.items.items;
			for (var i = 0; i < items.length; i++) {
							
				if(items[i].getXType() == 'displayfield')
					continue;
					
				if(items[i].getXType() == 'datefield'){
					items[i].setHideTrigger(displayOnly);
				}
				
				if (displayOnly) {
					items[i].el.addClass(cls);
				} else {
					items[i].el.removeClass(cls);
				}				
				items[i].el.readOnly = displayOnly;
				//items[i].readOnly = displayOnly;
			};
			
		}else if(xType == 'button') {
			//field.setDisabled(displayOnly);
			field.setVisible(!displayOnly);
		}

		if (field.trigger){
			//field.trigger.setDisplayed(!displayOnly);
		}
		
 		// Remove click event handlers
        if (field instanceof Ext.form.TriggerField) {
          	if (displayOnly)
            	field.trigger.un('click', field.onTriggerClick, field);
          	else
            	field.trigger.on('click', field.onTriggerClick, field, {preventDefault:true});

			field.setDisabled(displayOnly);
            /*
            if (displayOnly){
	          field.un('click', field.onViewClick, field);
	        }else{
	          field.on('click', field.onViewClick, field);
	        }
		   */
        }		
	};
	
	this.doEnable = function(){
		for(var i=0; i<GL_FIELD_CONTR_TYPE_ARR.length; i++){
			var fields = formId.findByType(GL_FIELD_CONTR_TYPE_ARR[i]);

			for(var j=0; j<fields.length; j++){				
				
				//활성화 할 대상일경우.
				var userData = "";
				if(typeof(fields[j].userData) != "undefined"){
					userData = fields[j].userData;
				}
				if(this.isEnable && (this.enableFlag == "ALL" || this.enableFlag == userData ||
				                    (this.enableFlag == "DISABLE" && this.isDisable && this.disableFlag != userData))){
				    this.uxDisplayOnly(fields[j],false,GL_READONLY_CSS);            	

				}else if(this.isDisable && (this.disableFlag == "ALL" || this.disableFlag == userData ||
			                               (this.isEnable && this.enableFlag == userData))){
				    this.uxDisplayOnly(fields[j],true,GL_READONLY_CSS);            	
				}				
			}			
		}
	};	
};

Ext.ux.FileTreeMenu = function(config) {
	config = config || {};

	Ext.apply(config, {
		items:[{
			 text:'&#160'
			,cls:'ux-ftm-nodename'
			,disabledClass:''
			,disabled:true
			,cmd:'nodename'
		},
		new Ext.menu.Separator({cmd:'sep-collapse'})
		,{	
			 text:this.newdirText
			,iconCls:this.newdirIconCls
			,cmd:BTN_REGISTER
		},{
			 text:this.renameText
			,iconCls:this.renameIconCls
			,cmd:BTN_MODIFY
		},{	
			 text:this.deleteText
			,iconCls:this.deleteIconCls
			,cmd:BTN_DELETE
		}	
		,new Ext.menu.Separator({cmd:'sep-open'})
		,{
			 text:this.reloadText
			,iconCls:this.reloadIconCls
			,cmd:'reload'
		},{
			 text:this.expandText
			,iconCls:this.expandIconCls
			,cmd:'expand'
		},{
			 text:this.collapseText
			,iconCls:this.collapseIconCls
			,cmd:'collapse'
		}

		]
	});
	
	Ext.ux.FileTreeMenu.superclass.constructor.call(this, config);

}; // eo constructor

Ext.extend(Ext.ux.FileTreeMenu, Ext.menu.Menu, {
	 collapseIconCls:'icon-collapse-all'
	,collapseText: 'Collapse all'
	,deleteIconCls:'icon-cross'
	,deleteKeyName:'Delete Key'
//	,deleteText:BTN_DELETE
	,expandIconCls:'icon-expand-all'
	,expandText: 'Expand all'
	,newdirIconCls:'icon-folder-add'
//	,newdirText:BTN_REGISTER
	,openBlankIconCls:'icon-open-blank'
	,openBlankText:'Open in new window'
	,openDwnldIconCls:'icon-open-download'
	,openDwnldText:'Download'
	,openIconCls:'icon-open'
	,openPopupIconCls:'icon-open-popup'
	,openPopupText:'Open in popup'
	,openSelfIconCls:'icon-open-self'
	,openSelfText:'Open in this window'
	,openText:'Open'
	,reloadIconCls:'icon-refresh'
	,reloadText:'R<span style="text-decoration:underline">e</span>load'
	,renameIconCls:'icon-pencil'
//	,renameText:BTN_MODIFY
	,width:190
	,getItemByCmd:function(cmd) {
		var open;
		var item = this.items.find(function(i) {
			return cmd === i.cmd;
		});
		if(!item) {
			open = this.items.find(function(i) {
				return 'open' === i.cmd;
			});
			if(!open) {
				return null;
			}
			item = open.menu.items.find(function(i) {
				return cmd === i.cmd;
			});
		}
		return item;
	} 
	,setItemDisabled:function(cmd, disabled) {
		var item = this.getItemByCmd(cmd);
		if(item) {
			item.setDisabled(disabled);
		}
	} 
	,beforeDestroy:function() {
	} 
}); 

//Ext.reg('filetreemenu', Ext.ux.FileTreeMenu);

Ext.ux.form.ScriptTagStore= function(config) {
	// ************************************************************
	// @FIXED 2011/05/21
	var url;
	var remoteSort = false;
	if(typeof(config) == 'string') {
		url = config;
	} else if(typeof(config) != 'undefined') {
		url = config.url;
		remoteSort = typeof(config.remoteSort) == 'undefined'?false:config.remoteSort;
	} else {
		return;
	}
	//
	// ************************************************************
	
	var proxy = new Ext.data.ScriptTagProxy({
        url:url,
        method: 'POST'
	});
	var reader = new Ext.ux.form.DynamicJsonReader({
		root: 'results',
        totalProperty: 'total',
        remoteSort: remoteSort
	});

	Ext.ux.form.ScriptTagStore.superclass.constructor.call(this, {
		remoteSort: remoteSort,
		proxy: proxy,
		reader: reader,
        listeners: {
            exception : function(proxy, type, action, options, res, arg) {
                if(typeof(Ext.util.JSON.decode(res.responseText).success) != undefined &&
                Ext.util.JSON.decode(res.responseText).success == false){
                    var reason = Ext.util.JSON.decode(res.responseText).errors.reason;
                    Ext.Msg.alert('Failed!', reason);
                }
            }
         }		
	});
    // ************************************************************
    // @FIXED 2011/05/21
	reader.store = this;
    // ************************************************************

};

Ext.extend(Ext.ux.form.ScriptTagStore, Ext.data.Store, {});


/*
 * 개인정보 수정 popup Store
 */
Ext.ux.form.DynamicStore= function(config) {
	// ************************************************************
	// @FIXED 2011/05/21
	var url;
	var remoteSort = false;
	if(typeof(config) == 'string') {
		url = config;
	} else if(typeof(config) != 'undefined') {
		url = config.url;
		remoteSort = typeof(config.remoteSort) == 'undefined'?false:config.remoteSort;
	} else {
		return;
	}
	//
	// ************************************************************
	
	var proxy = new Ext.data.HttpProxy({
        url:url,
        method: 'POST',
        timeout:600000
	});
	var reader = new Ext.ux.form.DynamicJsonReader({
			root: 'results',
            totalProperty: 'total',
	        remoteSort: remoteSort
		});

	Ext.ux.form.DynamicStore.superclass.constructor.call(this, {
		remoteSort: remoteSort,
		proxy: proxy,
		reader: reader,
        listeners: {
            exception : function(proxy, type, action, options, res, arg) {
                if(typeof(Ext.util.JSON.decode(res.responseText).success) != undefined &&
                Ext.util.JSON.decode(res.responseText).success == false){
                    var reason = Ext.util.JSON.decode(res.responseText).errors.reason;
                    Ext.Msg.alert('Failed!', reason);
                }
            }
         }		
	});
    // ************************************************************
    // @FIXED 2011/05/21
	reader.store = this;
    // ************************************************************

};

Ext.extend(Ext.ux.form.DynamicStore, Ext.data.Store, {
	/*
	loadData: function(param) {
		this.load({params: param,
		     callback: function(records,options,success) {
			 }});		
	} */
});

Ext.ux.form.DynamicJsonReader = function(config){
	Ext.ux.form.DynamicJsonReader.superclass.constructor.call(this, config, []);
};
Ext.extend(Ext.ux.form.DynamicJsonReader, Ext.data.JsonReader, {
    getRecordType : function(data) {
	        var i = 0,
	        arr = [];
	        for (var name in data[0]){
	            arr[i++] = name;
	            } // is there a built-in to do this?
	        this.recordType = Ext.data.Record.create(arr);
	        
	        // ************************************************************
	        // @FIXED 2011/05/21
	        try {
		        this.store.recordType = this.recordType;
		        this.store.fields = this.recordType.prototype.fields;
		        this.store.fireEvent('metachange',this,this.meta);
		    } catch(e) {
		    }
		    // ************************************************************
	        return this.recordType;
        },
    readRecords : function(o){ // this is just the same as base class, with call to getRecordType injected
        this.jsonData = o;	
        var s = this.meta;
        var sid = s.id;
        var totalRecords = 0;
        if(s.totalProperty){
            var v = parseInt(eval("o." + s.totalProperty), 10);
            if(!isNaN(v)){
                totalRecords = v;
            }
        }
        var root = s.root ? eval("o." + s.root) : o;
        var recordType = this.getRecordType(root);
        var fields = recordType.prototype.fields;
        var records = [];
        for(var i = 0; i < root.length; i++){
            var n = root[i];
            var values = {};
            var id = (n[sid] !== undefined && n[sid] !== "" ? n[sid] : null);
            for(var j = 0, jlen = fields.length; j < jlen; j++){
                var f = fields.items[j];
                var map = f.mapping || f.name;
                var v = n[map] !== undefined ? n[map] : f.defaultValue;
                v = f.convert(v);
                values[f.name] = v;
            }
            var record = new recordType(values, id);
            record.json = n;
            records[records.length] = record;
        }
        return {
        	success : true,
            records : records,
            totalRecords : totalRecords || records.length
            };
    }
});


Ext.ux.form.DynamicGridPanel = Ext.extend(Ext.grid.GridPanel, {
	initComponent : function() {
		var config = {
			viewConfig : {
				forceFit : true
			},
			enableColLock : this.enableColLock,
			loadMask : this.loadMask,
			border : this.border,
			stripeRows : this.stripeRows,
			ds : this.store,
			columns : []
		};
		Ext.apply(this, config);
		Ext.apply(this.initialConfig, config);
		Ext.ux.form.DynamicGridPanel.superclass.initComponent.apply(
				this, arguments);
	},
	onRender : function(ct, position) {
		this.colModel.defaultSortable = true;
		Ext.ux.form.DynamicGridPanel.superclass.onRender.call(this, ct, position);

		this.el.mask('Loading...');
		this.store.on('load',
			function(store, record, opts) {
				try{							
					if (typeof (this.store.reader.jsonData.columns) === 'object') {
						var columns = [];
						if (this.rowNumberer) {
							columns.push(new Ext.grid.RowNumberer());
						}
						if (this.checkboxSelModel) {
							columns.push(new Ext.grid.CheckboxSelectionModel());
						}
						Ext.each(
								this.store.reader.jsonData.columns,
								function(column) {
										columns.push(column);
								});

						this.getColumnModel().setConfig(columns);
					}
					this.el.unmask();
				}catch(e){
					this.el.unmask();
				}
			}, this);
		this.store.load({params:this.store.addParams});
	}
});

/**
  * Ext.ux.form.Spinner Class
	*
	* @author  Steven Chim
	* @version Spinner.js 2008-08-27 v0.35
  *
  * @class Ext.ux.form.Spinner
  * @extends Ext.form.TriggerField
  */

Ext.namespace("Ext.ux.form");

Ext.ux.form.Spinner = function(config){
	Ext.ux.form.Spinner.superclass.constructor.call(this, config);
	this.addEvents({
		'spin' : true,
		'spinup' : true,
		'spindown' : true
	});
};

Ext.extend(Ext.ux.form.Spinner, Ext.form.TriggerField, {
	triggerClass : 'x-form-spinner-trigger',
	splitterClass : 'x-form-spinner-splitter',

//	alternateKey : Ext.EventObject.shiftKey,
	strategy : undefined,

	//private
	onRender : function(ct, position){
		Ext.ux.form.Spinner.superclass.onRender.call(this, ct, position);

		this.splitter = this.wrap.createChild({tag:'div', cls:this.splitterClass, style:'width:13px; height:2px;'});
		this.splitter.show().setRight( (Ext.isIE) ? 1 : 2 );
		this.splitter.show().setTop(10);

		this.proxy = this.trigger.createProxy('', this.splitter, true);
		this.proxy.addClass("x-form-spinner-proxy");
		this.proxy.setStyle('left','0px');  
		this.proxy.setSize(14, 1);
		this.proxy.hide();
		this.dd = new Ext.dd.DDProxy(this.splitter.dom.id, "SpinnerDrag", {dragElId: this.proxy.id});

		this.initSpinner();
	},

	//private
	initTrigger : function(){
		this.trigger.addClassOnOver('x-form-trigger-over');
		this.trigger.addClassOnClick('x-form-trigger-click');
	},

	//private
	initSpinner : function(){
		this.keyNav = new Ext.KeyNav(this.el, {
			"up" : function(e){
				e.preventDefault();
				this.onSpinUp();
			},

			"down" : function(e){
				e.preventDefault();
				this.onSpinDown();
			},

			"pageUp" : function(e){
				e.preventDefault();
				this.onSpinUpAlternate();
			},

			"pageDown" : function(e){
				e.preventDefault();
				this.onSpinDownAlternate();
			},

			scope : this
		});

		this.repeater = new Ext.util.ClickRepeater(this.trigger);
		this.repeater.on("click", this.onTriggerClick, this, {preventDefault:true});
		this.trigger.on("mouseover", this.onMouseOver, this, {preventDefault:true});
		this.trigger.on("mouseout",  this.onMouseOut,  this, {preventDefault:true});
		this.trigger.on("mousemove", this.onMouseMove, this, {preventDefault:true});
		this.trigger.on("mousedown", this.onMouseDown, this, {preventDefault:true});
		this.trigger.on("mouseup",   this.onMouseUp,   this, {preventDefault:true});
		this.wrap.on("mousewheel",   this.handleMouseWheel, this);

		this.dd.setXConstraint(0, 0, 10);
		this.dd.setYConstraint(1500, 1500, 10);
		this.dd.endDrag = this.endDrag.createDelegate(this);
		this.dd.startDrag = this.startDrag.createDelegate(this);
		this.dd.onDrag = this.onDrag.createDelegate(this);

        /*
        jsakalos suggestion
        http://extjs.com/forum/showthread.php?p=121850#post121850 */
        if('object' == typeof this.strategy && this.strategy.xtype) {
            switch(this.strategy.xtype) {
                case 'number':
                    this.strategy = new Ext.ux.form.Spinner.NumberStrategy(this.strategy);
	                break;

                case 'date':
                    this.strategy = new Ext.ux.form.Spinner.DateStrategy(this.strategy);
	                break;

                case 'time':
                    this.strategy = new Ext.ux.form.Spinner.TimeStrategy(this.strategy);
                	break;

                default:
                    delete(this.strategy);
                	break;
            }
            delete(this.strategy.xtype);
        }

		if(this.strategy == undefined){
			this.strategy = new Ext.ux.form.Spinner.NumberStrategy();
		}
	},

	//private
	onMouseOver : function(){
		if(this.disabled){
			return;
		}
		var middle = this.getMiddle();
		this.__tmphcls = (Ext.EventObject.getPageY() < middle) ? 'x-form-spinner-overup' : 'x-form-spinner-overdown';
		this.trigger.addClass(this.__tmphcls);
	},

	//private
	onMouseOut : function(){
		this.trigger.removeClass(this.__tmphcls);
	},

	//private
	onMouseMove : function(){
		if(this.disabled){
			return;
		}
		var middle = this.getMiddle();
		if( ((Ext.EventObject.getPageY() > middle) && this.__tmphcls == "x-form-spinner-overup") ||
			((Ext.EventObject.getPageY() < middle) && this.__tmphcls == "x-form-spinner-overdown")){
		}
	},

	//private
	onMouseDown : function(){
		if(this.disabled){
			return;
		}
		var middle = this.getMiddle();
		this.__tmpccls = (Ext.EventObject.getPageY() < middle) ? 'x-form-spinner-clickup' : 'x-form-spinner-clickdown';
		this.trigger.addClass(this.__tmpccls);
	},

	//private
	onMouseUp : function(){
		this.trigger.removeClass(this.__tmpccls);
	},

	//private
	onTriggerClick : function(){
		if(this.disabled || this.getEl().dom.readOnly){
			return;
		}
		var middle = this.getMiddle();
		var ud = (Ext.EventObject.getPageY() < middle) ? 'Up' : 'Down';
		this['onSpin'+ud]();
	},

	//private
	getMiddle : function(){
		var t = this.trigger.getTop();
		var h = this.trigger.getHeight();
		var middle = t + (h/2);
		return middle;
	},
	
	//private
	//checks if control is allowed to spin
	isSpinnable : function(){
		if(this.disabled || this.getEl().dom.readOnly){
			Ext.EventObject.preventDefault();	//prevent scrolling when disabled/readonly
			return false;
		}
		return true;
	},

	handleMouseWheel : function(e){
		//disable scrolling when not focused
		if(this.wrap.hasClass('x-trigger-wrap-focus') == false){
			return;
		}

		var delta = e.getWheelDelta();
		if(delta > 0){
			this.onSpinUp();
			e.stopEvent();
		} else if(delta < 0){
			this.onSpinDown();
			e.stopEvent();
		}
	},

	//private
	startDrag : function(){
		this.proxy.show();
		this._previousY = Ext.fly(this.dd.getDragEl()).getTop();
	},

	//private
	endDrag : function(){
		this.proxy.hide();
	},

	//private
	onDrag : function(){
		if(this.disabled){
			return;
		}
		var y = Ext.fly(this.dd.getDragEl()).getTop();
		var ud = '';

		if(this._previousY > y){ud = 'Up';}         //up
		if(this._previousY < y){ud = 'Down';}       //down

		if(ud != ''){
			this['onSpin'+ud]();
		}

		this._previousY = y;
	},

	//private
	onSpinUp : function(){
		if(this.isSpinnable() == false) {
			return;
		}
		if(Ext.EventObject.shiftKey == true){
			this.onSpinUpAlternate();
			return;
		}else{
			this.strategy.onSpinUp(this);
		}
		this.fireEvent("spin", this);
		this.fireEvent("spinup", this);
	},

	//private
	onSpinDown : function(){
		if(this.isSpinnable() == false) {
			return;
		}
		if(Ext.EventObject.shiftKey == true){
			this.onSpinDownAlternate();
			return;
		}else{
			this.strategy.onSpinDown(this);
		}
		this.fireEvent("spin", this);
		this.fireEvent("spindown", this);
	},

	//private
	onSpinUpAlternate : function(){
		if(this.isSpinnable() == false) {
			return;
		}
		this.strategy.onSpinUpAlternate(this);
		this.fireEvent("spin", this);
		this.fireEvent("spinup", this);
	},

	//private
	onSpinDownAlternate : function(){
		if(this.isSpinnable() == false) {
			return;
		}
		this.strategy.onSpinDownAlternate(this);
		this.fireEvent("spin", this);
		this.fireEvent("spindown", this);
	}

});

//Ext.reg('uxspinner', Ext.ux.form.Spinner);

/***
 * Abstract Strategy
 */
Ext.ux.form.Spinner.Strategy = function(config){
	Ext.apply(this, config);
};

Ext.extend(Ext.ux.form.Spinner.Strategy, Ext.util.Observable, {
	defaultValue : 0,
	minValue : undefined,
	maxValue : undefined,
	incrementValue : 1,
	alternateIncrementValue : 5,
	validationTask : new Ext.util.DelayedTask(),
	
	onSpinUp : function(field){
		this.spin(field, false, false);
	},

	onSpinDown : function(field){
		this.spin(field, true, false);
	},

	onSpinUpAlternate : function(field){
		this.spin(field, false, true);
	},

	onSpinDownAlternate : function(field){
		this.spin(field, true, true);
	},

	spin : function(field, down, alternate){
		this.validationTask.delay(500, function(){
			field.validate();
		});
		//extend
	},

	fixBoundries : function(value){
		return value;
		//overwrite
	}
	
});

/***
 * Concrete Strategy: Numbers
 */
Ext.ux.form.Spinner.NumberStrategy = function(config){
	Ext.ux.form.Spinner.NumberStrategy.superclass.constructor.call(this, config);
};

Ext.extend(Ext.ux.form.Spinner.NumberStrategy, Ext.ux.form.Spinner.Strategy, {

    allowDecimals : true,
    decimalPrecision : 2,
    
	spin : function(field, down, alternate){
		Ext.ux.form.Spinner.NumberStrategy.superclass.spin.call(this, field, down, alternate);

		var v = parseFloat(field.getValue());
		var incr = (alternate == true) ? this.alternateIncrementValue : this.incrementValue;

		(down == true) ? v -= incr : v += incr ;
		v = (isNaN(v)) ? this.defaultValue : v;
		v = this.fixBoundries(v);
		field.setRawValue(v);
	},

	fixBoundries : function(value){
		var v = value;

		if(this.minValue != undefined && v < this.minValue){
			v = this.minValue;
		}
		if(this.maxValue != undefined && v > this.maxValue){
			v = this.maxValue;
		}

		return this.fixPrecision(v);
	},
	
    // private
    fixPrecision : function(value){
        var nan = isNaN(value);
        if(!this.allowDecimals || this.decimalPrecision == -1 || nan || !value){
            return nan ? '' : value;
        }
        return parseFloat(parseFloat(value).toFixed(this.decimalPrecision));
    }
});


/***
 * Concrete Strategy: Date
 */
Ext.ux.form.Spinner.DateStrategy = function(config){
	Ext.ux.form.Spinner.DateStrategy.superclass.constructor.call(this, config);
};

Ext.extend(Ext.ux.form.Spinner.DateStrategy, Ext.ux.form.Spinner.Strategy, {
	defaultValue : new Date(),
	format : "Y-m-d",
	incrementValue : 1,
	incrementConstant : Date.DAY,
	alternateIncrementValue : 1,
	alternateIncrementConstant : Date.MONTH,

	spin : function(field, down, alternate){
		Ext.ux.form.Spinner.DateStrategy.superclass.spin.call(this);

		var v = field.getRawValue();
		
		v = Date.parseDate(v, this.format);
		var dir = (down == true) ? -1 : 1 ;
		var incr = (alternate == true) ? this.alternateIncrementValue : this.incrementValue;
		var dtconst = (alternate == true) ? this.alternateIncrementConstant : this.incrementConstant;

		if(typeof this.defaultValue == 'string'){
			this.defaultValue = Date.parseDate(this.defaultValue, this.format);
		}

		v = (v) ? v.add(dtconst, dir*incr) : this.defaultValue;

		v = this.fixBoundries(v);
		field.setRawValue(Ext.util.Format.date(v,this.format));
	},
	
	//private
	fixBoundries : function(date){
		var dt = date;
		var min = (typeof this.minValue == 'string') ? Date.parseDate(this.minValue, this.format) : this.minValue ;
		var max = (typeof this.maxValue == 'string') ? Date.parseDate(this.maxValue, this.format) : this.maxValue ;

		if(this.minValue != undefined && dt < min){
			dt = min;
		}
		if(this.maxValue != undefined && dt > max){
			dt = max;
		}

		return dt;
	}

});


/***
 * Concrete Strategy: Time
 */
Ext.ux.form.Spinner.TimeStrategy = function(config){
	Ext.ux.form.Spinner.TimeStrategy.superclass.constructor.call(this, config);
};

Ext.extend(Ext.ux.form.Spinner.TimeStrategy, Ext.ux.form.Spinner.DateStrategy, {
	format : "H:i",
	incrementValue : 1,
	incrementConstant : Date.MINUTE,
	alternateIncrementValue : 1,
	alternateIncrementConstant : Date.HOUR
});

/***
 * CheckColumn
 */
Ext.grid.CheckColumn = function(config){
    Ext.apply(this, config);
    if(!this.id){
        this.id = Ext.id();
    }
    this.renderer = this.renderer.createDelegate(this);
};

Ext.grid.CheckColumn.prototype ={
    init : function(grid){
        this.grid = grid;
        this.grid.on('render', function(){
            var view = this.grid.getView();
            view.mainBody.on('mousedown', this.onMouseDown, this);
        }, this);
    },

    onMouseDown : function(e, t){
        if(t.className && t.className.indexOf('x-grid3-cc-'+this.id) != -1){
            e.stopEvent();
            var index = this.grid.getView().findRowIndex(t);
            var record = this.grid.store.getAt(index);
            record.set(this.dataIndex, !record.data[this.dataIndex]);
        }
    },

    renderer : function(v, p, record){
        p.css += ' x-grid3-check-col-td'; 
        return '<div class="x-grid3-check-col'+(v?'-on':'')+' x-grid3-cc-'+this.id+'"> </div>';
    }
};  
