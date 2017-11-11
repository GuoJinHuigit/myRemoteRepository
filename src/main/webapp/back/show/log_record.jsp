<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
	
</script>

<input class="easyui-searchbox" style="width:300px" data-options="menu:'#mm'" style="padding-top:10px"/>
<div id="mm" style="width:150px">
	<div data-options="name:'item1'">Search Item1</div>
	<div data-options="name:'item2',selected:true">Search Item2</div>
	<div data-options="name:'item3'">Search Item3</div>
</div>
<table class="easyui-datagrid" id="log" data-options="
			title:'日志记录表',
			fitColumns:true,
			singleSelect:true,
    		striped:true,
    		url:'${pageContext.request.contextPath}/log/findLogPage',
    		pagination:true,
    		pageNumber:1,
    		pageSize:15,
	   		pageList:[5,10,15,20,25]
	   		">
	<thead>
		<tr>
			<th data-options="field:'id',align:'center',width:200">ID</th>
			<th data-options="field:'username',align:'center',width:200" >操作用户</th>
			<th data-options="field:'time',align:'center',width:200">操作时间</th>
			<th data-options="field:'methodType',align:'center',width:200">操作类型</th>
			<th data-options="field:'detail',align:'center',width:200">详细信息</th>
		</tr>
	</thead>
</table>