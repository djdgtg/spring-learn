var oTable = null;
var dictype = null;
var faIcon = {
		valid: 'fa fa-check-circle fa-lg text-success',
		invalid: 'fa fa-times-circle fa-lg',
		validating: 'fa fa-refresh'
	}

$(window).on('load', function() {
    //加载字典类型数据
    loadDicType();
    
    //字典类型切换
    $('#dicTypeSelect').on('change',function(){
    	oTable.bootstrapTable("refresh");
    });
    
    validDicTypeForm();
    validDicForm();

});


//获取字典类型
function loadDicType(){
    $("#dicTypeSelect").children().remove();
	 $.ajax({  
         url: "dics/list",  
         dataType: "json",  
         data: {"isdictype":1},
         success: function (data) {  
         	if(data.data != null){
                 $.each(data.data, function (index, dic) {  
                     $("#dicTypeSelect").append("<option value='" + dic.dictype + "'>" + dic.dictypename + "</option>");  
                 });  
                 $("#dicTypeSelect").selectpicker("refresh");
                 $("#dicTypeSelect").selectpicker("show");
                 dictype = data.data[0].dictype;
                 $("#dicTypeSelect").selectpicker("val",dictype);
                 $("#dictypename").val(dictype);
                 loadDic();
         	}
         },  
          
         error: function (XMLHttpRequest, textStatus, errorThrown) {  
        	 bootbox.alert('加载失败，请稍后重试'); 
         }  
     });
}


//加载字典数据
function loadDic(){
	oTable = $("#dicTb").bootstrapTable({
    	method: "post",  //使用get请求到服务器获取数据  
    	contentType : "application/x-www-form-urlencoded",
        url: "dics/list", //获取数据的Servlet地址   
        queryParams: function(){
        	return {'isdictype':0,'dictype':$('#dicTypeSelect').val()};
        },
        striped: true,  //表格显示条纹  
        pagination: true, //启动分页  
        pageSize: 10,  //每页显示的记录数  
        pageNumber:1, //当前第几页  
        pageList: [5, 10, 15, 20, 25],  //记录数可选列表  
        search: false,  //是否启用查询  
        sortable: false,                     //是否启用排序
        showColumns: false,  //显示下拉框勾选要显示的列  
        showRefresh: false,  //显示刷新按钮  
        sidePagination: "client", //表示服务端请求  
		locale:'zh-CN',
        clickToSelect: true,    //是否启用点击选中行
        columns: [{
        	checkbox: true
        }, {
        	field:'dicid',
        	visible: false,
        }, {
        	field: 'dicname',
        	title: '字典名称',
        	align: 'center',
        	valign: 'middle',
        }, {
        	field: 'isdictype',
        	visible: false,
        },  {
            field: 'dicvalue',
            title: '字典值',
        },  {
            field: 'dictype',
            title: '字典类型',
        }],
        toolbar:"#dicToolbar",
    });
}

/**
 * 字典类型modal
 */
function dicTypeModal(){
	clearFormData("#addDicTypeForm");
	$("#dicTypeIsDicType").val(1);
	$("#addDicTypeModal").modal('show');
}

/**
 * 字典modal
 */
function dicModal(optype){
	clearFormData("#addDicForm");
	$("#dicIsDicType").val(0);
	$("#dictypename").val($('#dicTypeSelect').val());
	$("#optype").val(optype);

	if(optype == 1){
		$("#modalTitle")[0].innerText = "修改字典";
		var selDics = $("#dicTb").bootstrapTable('getSelections');
		if(selDics.length == 1){
			var dicId = selDics[0].dicid;
			var dicValue = selDics[0].dicvalue;
			var dicName = selDics[0].dicname;
			var dicType = selDics[0].dictype;
			
			$("#dicName").val(dicName);
			$("#dicValue").val(dicValue);
			$("#dicId").val(dicId);

		}else{
			bootbox.alert('请选择1条字典信息', function(){
	            return;
	        });
			return;
		}
	}else{
		$("#modalTitle")[0].innerText = "新增字典";
	}
	$("#addDicModal").modal('show');
}


function validDicTypeForm(){
    //字典类型form验证
    $('#addDicTypeForm').bootstrapValidator({
		excluded: [':disabled'],
		feedbackIcons: faIcon,
		fields: {
		'baseDics.dictype': {
			validators: {
				notEmpty: {
					message: '字典类型不能为空'
				},
				stringLength: {
					min: 1,
					max: 20,
					message: '字段类型长度必须在1~20位之间'
				},
			}
		},
		'baseDics.dictypename': {
			validators: {
				notEmpty: {
					message: '字典类型中文名不能为空'
				},
				stringLength: {
					min: 1,
					max: 20,
					message: '字段类型中文名长度必须在1~50位之间'
				},
			}
		},
		}
	}).on('success.field.bv', function(e, data) {
    	var $parent = data.element.parents('.form-group');
    	$parent.removeClass('has-success');
    }).on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');

        // Use Ajax to submit form data
		addDics("#addDicTypeForm","#addDicTypeModal");
    });
}

//字典信息验证
function validDicForm(){
	$('#addDicForm').bootstrapValidator({
		feedbackIcons: faIcon,
		fields: {
		"baseDics.dicname": {
			validators: {
				notEmpty: {
					message: '字典名不能为空.'
				},
				stringLength: {
					min: 1,
					max: 20,
					message: '字典名长度必须在1~20位之间'
				},
			}
		},
		"baseDics.dicvalue": {
			validators: {
				notEmpty: {
					message: '字典值不能为空.'
				},
				stringLength: {
					min: 1,
					max: 20,
					message: '字典值中文名长度必须在1~20位之间'
				},
			}
		}
		}
	}).on('success.field.bv', function(e, data) {
    	var $parent = data.element.parents('.form-group');
    	$parent.removeClass('has-success');
    }).on('success.form.bv', function(e) {
        // Prevent form submission
        e.preventDefault();

        // Get the form instance
        var $form = $(e.target);

        // Get the BootstrapValidator instance
        var bv = $form.data('bootstrapValidator');

        // Use Ajax to submit form data

		var opType = $("#optype").val();
		if(opType == 1){
			updateDicMsg();
		}else{
			addDics("#addDicForm","#addDicModal");
		}
    });
}


//添加字典及字典类型
function addDics(formId,modalId){
	$.ajax({
		type: "POST",
		url: "dics/add",
		data: $(formId).serialize(),
	    success: function(data) {
	    	if (data.status == 200) {
	    		bootbox.alert(data.msg, function(){//清空表单数据
		    		clearFormData(formId);

		    		$(modalId).modal('hide');

		    		if(modalId == "#addDicTypeModal"){
		    			loadDicType();
			    		$('#dicTypeSelect').selectpicker('val',$("#dicType").val());
		    		}else{
		    			$("#dicTb").bootstrapTable("refresh");
		    		}
	            });
	    		
	    	}else{
	    		bootbox.alert(data.msg);
	    	}
		}
	});
}


function updateDicMsg(){
	$.ajax({
		type: "POST",
		url: "dics/update",
		data: $("#addDicForm").serialize(),
	    success: function(data) {
	    	if (data.status == 200) {
	    		bootbox.alert(data.msg, function(){
		    		//关闭对话框
		    		$('#addDicModal').modal('hide');
		    		$("#opType").val(0);
		    		//清空表单数据
		    		clearFormData("#addDicForm");
		    		//重新加载表格数据
		    		$("#dicTb").bootstrapTable("refresh");
	            });
	    	} else {
	    		bootbox.alert(data.msg);
	    	}
		}
	});
}


//删除字典类型
function delDicTypeBtn(){
	//var dicType = $("#dicType").val();
	var dicType = $("#dicTypeSelect").val();
	$.ajax({
		type: "POST",
		url: "dics/del",
		data: "dictype=" + dicType + "&isdictype=1",
	    success: function(data) {
	    	if (data.status == 200) {
	    		bootbox.alert(data.msg, function(){
	                $("#dicTypeSelect").selectpicker("render");
	                $("#dicTypeSelect").selectpicker("refresh");
	                //重新加载表格数据
		    		$("#dicTb").bootstrapTable("refresh");
	            });
	    	} else {
	    		bootbox.alert(data.msg);
	    	}
	    	
		}
	});
}



//删除
function delDics() {
	var selDics = $("#dicTb").bootstrapTable('getSelections');
	if(selDics.length == 0){
		bootbox.alert('至少选择一个字典！', function(){
            return;
        });
		return;
	}else{
		var dicIds = "";  
	  
		for (var i = 0; i < selDics.length; i++) {  
			dicIds += selDics[i].dicid + ","; 
		} 
		dicIds += 0;
		bootbox.confirm("确定删除?", function(result) {
	        if (result) {
	        	$.ajax({
	        		type: "POST",
	        		url: "dics/delBatch",
	        		data: "dicIds=" + dicIds,
	        	    success: function(data) {
	        	    	if (data.status == 200) {
	        	    		bootbox.alert(data.msg, function(){
		        	    		//重新加载表格数据
		        	    		$("#dicTb").bootstrapTable("refresh");
	        	            });
	        	    	} else {
	        	    		bootbox.alert(data.msg);
	        	    	}
	        	    	
	        		}
	        	});
	        }

	    });
	}
}
