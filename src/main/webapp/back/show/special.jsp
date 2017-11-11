<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<div class="easyui-panel" title="数据展示"
	style="background:#fafafa;height:99%;width:99%"
	data-options="iconCls:'icon-save',maximizable:true">
	<table id="zhuanji_dg" fit="true"></table>
</div>
<div id="tb">
<a href="javascript:;" onclick="addSpecial()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加新专辑</a>
<a href="javascript:;" onclick="addVoice()" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加新音频</a>
</div>

<div id ="special_dialog"></div>
<div id ="voice_dialog"></div>
 
<script type="text/javascript">
function reload_special(){
	$('#zhuanji_dg').treegrid("reload");
}

//编辑音频
function editRow(id,type){
	if(type=="special"){
	console.log(type);
		select=$("#zhuanji_dg").treegrid("getSelected");
		$('a.edit').dialog({    
			    title: '编辑专辑',
			    id:'spe',    
			    width: 500,    
			    height: 400,    
			    closed: false,    
			    cache: false,
			    href: '${pageContext.request.contextPath}/back/show/special_edit.jsp',    
			    modal: true,
			    buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						$("#ff").form("submit",{
							url:'${pageContext.request.contextPath}/special/update',
							onSubmit:function(){
								var res=$("#ff").form("validate");
								return res;
							},
							success:function(param){
								var json=$.parseJSON(param);
								if(json=='specialEditOk'){
									$("#zhuanji_dg").treegrid("reload");
									$.messager.show({
										title:'更新专辑状态',
										msg:'专辑更新成功~~',
										timeout:5000
									});
								}else{
									$.messager.show({
										title:'更新专辑状态',
										msg:'专辑更新失败！！',
										timeout:5000
									});
								}
							}
						
						});
						$("#spe").dialog("close");
					}
				}, {
					text : '取消',
					iconCls : 'icon-cancel',
					handler : function() {
						//关闭dialog，messager.show提示
						$("#spe").dialog("close");
						$.messager.show({
								title:'更新状况',
								msg:'你取消了本次更新',
								timeout:3000
						});
					}
				}]
	
		});
	}else if($("#zhuanji_dg").treegrid("getSelected").type=="audio"){
		$('a.edit').dialog({    
			    title: '编辑音频', 
			    id:'aud',  
			    width: 500,    
			    height: 400,    
			    closed: false,    
			    cache: false,
			    href: '${pageContext.request.contextPath}/back/show/audio_edit.jsp',    
			    modal: true,
			    buttons : [ {
					text : '确定',
					iconCls : 'icon-ok',
					handler : function() {
						$("#audio_ff").form("submit",{
							url:'${pageContext.request.contextPath}/audio/updateAudio',
							onSubmit:function(){
								var res=$("#audio_ff").form("validate");
								return res;
							},
							success:function(pa){
								var json=$.parseJSON(pa);
								if(json=='audioEditOk'){
									$("#zhuanji_dg").treegrid("reload");
									$.messager.show({
										title:'更新音频状态',
										msg:'专辑音频成功~~',
										timeout:5000
									});
								}else{
									$.messager.show({
										title:'更新音频状态',
										msg:'专辑音频失败！！',
										timeout:5000
									});
								}
							}
						
						});
						$("#aud").dialog("close");
					}
				}, {
					text : '取消',
					iconCls : 'icon-cancel',
					handler : function() {
						//关闭dialog，messager.show提示
						$("#a.edit").dialog("close");
						$.messager.show({
								title:'更新状况',
								msg:'你取消了本次更新',
								timeout:3000
						});
					}
				}]
	
		});
	}
		
}	

// 删除 
function delRow(id,type){
	if(type=="special"){
	var sel=$("#zhuanji_dg").treegrid("getSelected");
		var s=window.confirm("你确定要删除这个专辑");
		if(s){
			if(sel.children.length==0){//表示专辑中没有音频，直接删除专辑
				var status=sel.specialStatus;
				if(status=='待展示'){
					$.ajax({
						type:'post',
						url:'${pageContext.request.contextPath}/special/removeSpecial',
						data:'id='+id,
						dataType:'json',
						success:function(data){
							if(data=='removeOk'){
								$("#zhuanji_dg").treegrid("reload");
								$.messager.show({
									title:'专辑删除消息',
									msg:'删除成功',
									timeout:5000
								});
							}else{
								$.messager.show({
									title:'专辑删除消息',
									msg:'删除失败',
									timeout:5000
								});
							}
						}
					});
				}
			}else{//表明专辑中有音频，先删除专辑再删除音频
				var sel=$("#zhuanji_dg").treegrid("getSelected").specialStatus;
				var ss=sel.children;
				console.log(sel);
				$.ajax({
						type:'post',
						url:'${pageContext.request.contextPath}/special/removeSpecialAndAudio',
						data:'spId='+id,
						dataType:'json',
						success:function(da){
							if(da=='deleteOk'){
								$("#zhuanji_dg").treegrid("reload");
								$.messager.show({
									title:'删除音频及专辑',
									msg:'删除成功',
									timeout:5000
							});
						}
					}
				});
			}
		} 
	}

	if(type=="audio"){
		//直接操作音频表删除音频
		console.log(id);
		var sele=$("#zhuanji_dg").treegrid("getSelected").audioStatus;
		console.log(sele);
		var flag=window.confirm("确定删除这个音频");
		if(flag){
			if(sele=="待展示"){
				$.ajax({
					type:'post',
					url:'${pageContext.request.contextPath}/audio/removeAudio',
					data:'id='+id,
					dataType:'json',
					success:function(audio){
						if(audio=="removeOk"){
							$("#zhuanji_dg").treegrid("reload");
							$.messager.show({
								title:'删除音频状态',
								msg:'删除成功',
								timeout:5000
							});
						}
					}
				});
			}
		}
	}
}

//给删除和修改添加easyui-linkbutton
function addCss(){
	$("a.edit").linkbutton({
		plain:true,
		iconCls:'icon-edit',
		height:18,
	});
	$("a.remove").linkbutton({
		plain:true,
		iconCls:'icon-remove',
		height:18, 
	});
}
 
 
	function addSpecial() {
		$('#special_dialog').dialog({    
		    title: '添加新专辑',    
		    width: 500,    
		    height: 400,    
		    closed: false,    
		    cache: false,
		    href: '${pageContext.request.contextPath}/back/show/special_add.jsp',    
		    modal: true,
		    buttons : [ {
				text : '重置',
				iconCls : 'icon-undo',
				handler : function() {
					
				}
			}, {
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {
					//发送表单请求
					//表单
				$('#banner_upload').form("submit",{
					url : "${pageContext.request.contextPath}/special/addSpecial",
					onSubmit : function() {
						// do some check    
						// return false to prevent submit;
						var result=$("#banner_upload").form("validate"); 
						console.log(result);
						return result;   
					},
					success : function(data) {
						var spe=$.parseJSON(data);
						if(spe=='addSpeOk'){
							$("#zhuanji_dg").treegrid("reload");
							$.messager.show({
								title:'添加新专辑',
								msg:'恭喜你~~,专辑添加成功',
								timeout:5000
							
							});
						}else{
							$.messager.show({
								title:'添加新专辑',
								msg:'添加失败,请重试',
								timeout:5000
							
							});
						}
					}
				});
					//关闭对话框
				$('#special_dialog').dialog("close");

				//刷新数据表格
				reload_special();
				}
			} ]
		});    
		$('#special_dialog').dialog("open");
	}

	
	function addVoice() {
		//获得选中行
		var selectRow = $('#zhuanji_dg').treegrid("getSelected");
		if(selectRow == null){
			console.log("ss");
			alert("请先选择所属专辑");
		}else{
			//添加音频
			$('#voice_dialog').dialog({    
		    title: '添加音频文件',    
		    width: 400,    
		    height: 300,    
		    closed: false,    
		    cache: false,
		    href: '${pageContext.request.contextPath}/back/show/voice_add.jsp?specialId='+selectRow.id,    
		    modal: false,
		    buttons : [ {
				text : '重置',
				iconCls : 'icon-undo',
				handler : function() {

				}
			}, {
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {
					//发送表单请求
					//表单
				$('#voice_form').form("submit",{
					url : "${pageContext.request.contextPath}/audio/addAudio",
					onSubmit : function() {
						// do some check    
						// return false to prevent submit;
						var audi=$("#voice_form").form("validate");  
						console.log(audi);
						return audi;  
					},
					success : function(da) {
						var aud=$.parseJSON(da);
						if(aud=='addAudioOk'){
							$("#zhuanji_dg").treegrid("reload");
							$("##voice_dialog").dialog("close");
							$.messager.show({
								title:'添加新音频',
								msg:'恭喜你~~,音频添加成功',
								timeout:5000
							});
						}else{
							$.messager.show({
								title:'添加新音频',
								msg:'音频添加失败',
								timeout:5000
							});
						}
					}
				});
					//关闭对话框
				$('#voice_dialog').dialog("close");
				//刷新数据表格
				reload_special();
				}
			}]
		});    
		$('#voice_dialog').dialog("open");
		}
	}

	$(function() {
		$('#zhuanji_dg').treegrid({
			url:'${pageContext.request.contextPath}/special/specialPage',
			//自动列宽
			fitColumns : true,
			
			pageList : [ 4, 8, 12 ],
			pageSize : 4,
			pagination : true,
			//显示行号
			rownumbers: true,
			
			onLoadSuccess:addCss,
			
			//treegrid 
			idField : 'id',  //节点（父子）的唯一标示   父子节点之间id也不能重复  
			treeField : 'name', //节点的文本内容   name: 代表文本的值来源的字段
			toolbar:"#tb",

			columns : [ [ {
				field : 'name',
				title : '专辑名称',
				width : 100
			},{
				field : 'specialPath',
				title : '路径',
				width : 200,
				formatter : function(val, row, index) {
					if(row.type == "special"){
						return "<img width='56' height='56' src = "+row.specialPath+">";
					}else if(row.type=="audio"){
						return "<audio src="+row.audioPath+" controls></audio>";
					}else{
						return null;
					}
				}
			},{
				field : 'relaseDate',
				title : '上传日期',
				width : 100
				},{
				field : 'audioStatus',
				title : '音频状态',
				width : 100
				},{
				field : 'audioOriName',
				title : '音频名称',
				width : 100
				},{title:'操作',field:'aaa',width:150,align:'center',
				formatter:function(value,row,index){
					console.log(row);
					console.log(row.id);
					return "<a href='javascript:;' onClick='editRow(\""+row.id+"\",\""+row.type+"\")' class='edit'>编辑</a>&nbsp;<a href='javascript:;' class='remove' onClick='delRow(\""+row.id+"\",\""+row.type+"\")'>删除</a>";
				}
			}, ] ]
		});

	});
</script>

