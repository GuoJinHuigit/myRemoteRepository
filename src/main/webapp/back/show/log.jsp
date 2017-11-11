<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<center>
	<input id="ss"></input> 
	<div id="mm"> 
		<div>按姓名搜索</div> 
		<div>按时间搜索</div> 
		<div>按类型搜索</div> 
	</div> 
</center>
<table id="tal"></table>
<div id="daa">
	<table id="tab"></table>
</div>
<div id="dbb" style="text-align: center"><h2 id="tbb" style="margin-top:40px"></h2></div>
<script type="text/javascript">
	$("#tal").datagrid({
		url:'${pageContext.request.contextPath}/log/findLogPage',
		fitColumns:true,
	 	striped:true,
	 	pageList : [ 15, 30 ],
		pageSize : 15,
	 	rownumbers: true,
	    singleSelect:true,
	    iconCls:'icon-edit',
		striped:true,
		pagination:true,
		pagePosition:top,
		fit:true,
		columns:[[
			{field:'id',title:'日志ID',width:200,align:'center'},
			{field:'username',title:'操作用户',width:100,align:'center'},
			{field:'time',title:'操作时间',width:100,align:'center'},
			{field:'dataType',title:'日志详情',width:200,align:'center'},
			{field:'detail',title:'操作类型',width:50,align:'center'}
		]]
	});
	$('#ss').searchbox({ 
		searcher:function(value,name){ 
			if(name=="按姓名搜索" && value !=""){
				$("#daa").dialog("open");
				$.ajax({
					type:"post",
					data:"username="+value,
					dataType:"json",
					url:"${pageContext.request.contextPath}/log/part",
					success:function(a){
						$("#tab").datagrid("loadData",a);
					}
				});
			};
			if(name=="按时间搜索" && value !=""){
				$("#daa").dialog("open");
				$.ajax({
					type:"post",
					data:"date="+value,
					dataType:"json",
					url:"${pageContext.request.contextPath}/log/part",
					success:function(a){
						mydata=a;
						$("#tab").datagrid("loadData",mydata);
					}
				});
			};
			if(name=="按类型搜索" && value !=""){
				$("#daa").dialog("open");
				$.ajax({
					type:"post",
					data:"type="+value,
					dataType:"json",
					url:"${pageContext.request.contextPath}/log/part",
					success:function(a){
						mydata=a;
						$("#tab").datagrid("loadData",mydata);
					}
				});
			};
			if(value ==""){
				$("#dbb").dialog("open");
				$("#tbb").html("请输入要查询的内容！");
				setTimeout(function(){
					$("#dbb").dialog("close");
				},2000);
			}
		}, 
		width:300,
		height:30,
		menu:'#mm', 
		prompt:'请输入值' 
	});
	$("#daa").dialog({
		width:1000,
	 	height:600,
	 	iconCls:'icon-add',
		title:'按姓名查询结果',
	    modal:true,
		closed:true,
	}); 
	$("#dbb").dialog({
		width:400,
	 	height:150,
	 	iconCls:'icon-add',
		title:'操作成功？',
	    modal:true,
		closed:true,
	});
	$("#tab").datagrid({
		/* url:'${pageContext.request.contextPath}/log/part', */
		fitColumns:true,
	 	striped:true,
	 	rownumbers: true,
	    singleSelect:true,
	    iconCls:'icon-edit',
		striped:true,
		fit:true,
		columns:[[
			{field:'id',title:'日志ID',width:200,align:'center'},
			{field:'username',title:'操作用户',width:60,align:'center'},
			{field:'time',title:'操作时间',width:100,align:'center'},
			{field:'methodType',title:'日志详情',width:260,align:'center'},
			{field:'detail',title:'操作类型',width:50,align:'center'}
		]]
	});
</script>
