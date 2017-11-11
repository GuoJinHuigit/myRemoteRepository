<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<script type="text/javascript">
	var editRow;
	var tools=[
		{
			iconCls:'icon-add',
			handler:function(){
				$("#up").dialog("open");
			}
		
		},{
			iconCls:'icon-cut',
			handler:function(){
				console.log("remove");
				var select=$("#tg").datagrid("getSelected");
				if(select==null){
					alert("请选择删除哪行数据");
				}else{
					//获得选中行的id
					var id=select.id;
					console.log(id);
					$.ajax({
						type:'post',
						url:'${pageContext.request.contextPath}/rotate/delete',
						data:'id='+id,
						dataType:'json',
						success:function(del){
							console.log(del);
							$("#tg").datagrid("reload");
							if(del=='delOk'){
								$.messager.show({
									title:'删除状况',
									msg:'恭喜你~~,删除成功',
									timeout:3000
								});
							}else{
								$.messager.show({
									title:'删除状态',
									msg:'删除失败',
									timeout:3000
								});
							}
						}
					});
				}
			}
		},{
			iconCls:'icon-edit',
			handler:function(){
				console.log("edit");
				//获得选中行
				editRow=$("#tg").datagrid("getSelected");
				if(editRow==null){
					alert("请选择要修改的行");
				}else{
					//打开dialog
					$("#edit").dialog("open");
					//强制刷新dialog中的数据
					$("#edit").dialog("refresh");
				}
			}
		},{
			iconCls:'icon-save',
			handler:function(){
				console.log("save");
		}	
	}
];
	var btn=[
		{
			text:'确定',
			iconCls:'icon-ok',
			handler:function(){
				//验证数据，提交表单，关闭dialog，messager.show提示
				$("#form1").form("submit",{
					url:"${pageContext.request.contextPath}/rotate/add",
					onSubmit:function(){
						var res=$("#form1").form("validate");
						console.log(res);
						return res;
					},
					success:function(data){
						var da=$.parseJSON(data);
						console.log(da);
						if(da=='addOk'){
							$("#tg").datagrid("reload");
							$.messager.show({
								title:'上传状况',
								msg:'恭喜你~~,图片上传成功',
								timeout:3000
							});
						}else{
							$.messager.show({
								title:'上传状况',
								msg:'图片上传失败,请重新上传',
								timeout:3000
							});
						}
					}
				});
				$("#up").dialog("close");
			}
		},{
			text:'取消',
			iconCls:'icon-cancel',
			handler:function(){
				//关闭dialog，messager.show提示
				$("#up").dialog("close");
				$.messager.show({
					title:'上传状况', 
					msg:'你取消了本次上传',
					timeout:3000
				});
			}
		}
	];
	
	var updates=[
		{
			text:'确定',
			iconCls:'icon-ok',
			handler:function(){
				//验证数据，提交表单，关闭dialog，messager.show提示
				$("#ff").form("submit",{
					url:"${pageContext.request.contextPath}/rotate/update",
					onSubmit:function(){//表单提交的回调函数
						var resu=$("#ff").form("validate");
						console.log(resu);
						return resu;
					},
					success:function(up){//表单响应时的回调函数
						console.log(up);
						var update=$.parseJSON(up);
						if(update=='updateOk'){
							//关闭dialog,messager.show提示,刷新datagrid中的数据
							$("#tg").datagrid("reload");
							messager.show({
								title:'更新状态',
								msg:'恭喜你~~,更新成功',
								timeout:3000
							});
						}else{
							messager.show({
								title:'更新状态',
								msg:'更新失败,请重试',
								timeout:3000
							});
						}
					}
				
				});
				$("#edit").dialog("close");
			}	
		},{
			text:'取消',
			iconCls:'icon-cancel',
			handler:function(){
				//关闭dialog,message.show提示
				$("#edit").dialog("close");
				messager.show({
					title:'更新状态',
					msg:'你取消了本次更新',
					timeout:5000
				});
			}
		}
	];
</script>
<table class="easyui-datagrid" id="tg" style="width:600px;"
			data-options="title:'轮播图数据展示表', 
						iconCls:'icon-save',
						fitColumns:true,
						singleSelect:true,
	   					striped:true,
	   					toolbar:tools,
	   					url:'${pageContext.request.contextPath}/rotate/findPage',
	   					pageNumber:1,
	   					pagination:true,
	   					pageSize:3,
	   					pageList:[3,6,9,12,15]
	   					">
	<thead>
  		<tr>
    		<th data-options="field:'originalName',align:'center',width:100">图片预览图</th>
    		<th data-options="field:'showStatus',align:'center',width:100">状态</th>
    		<th data-options="field:'discript',align:'center',width:100">描述</th>
    		<th data-options="field:'uploadTime',align:'center',width:100">上传时间</th>
  		</tr>
	</thead>
</table>

	<div class="easyui-dialog" style="width:200px;height:200px;" id="up" 
								data-options="title:'上传图片',
								maximizable:true,
								minimizable:true,
								closed:true,
								resizable:true,
								modal:true,
								href:'${pageContext.request.contextPath}/back/show/rotation_upload.jsp',
								buttons:btn"></div>
	<div class="easyui-dialog" style="width:300px;height:300px;" id="edit" 
								data-options="title:'修改图片状态',
								maximizable:true,
								minimizable:true,
								closed:true,
								resizable:true,
								modal:true,
								href:'${pageContext.request.contextPath}/back/show/rotation_update.jsp',
								buttons:updates"></div>
								

