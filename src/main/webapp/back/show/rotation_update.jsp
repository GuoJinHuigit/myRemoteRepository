<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<form id="ff" method="post">
   	<table cellpadding="5">
   		<tr>
   			<td>ID:</td>
   			<td><input class="easyui-textbox" id="id" type="text" name="id" data-options="required:true,readonly:true"></input></td>
   		</tr>
   		<tr>
   			<td>图片名称:</td>
   			<td><input class="easyui-textbox" id="originalName" type="text" name="originalName" data-options="required:true"></input></td>
   		</tr>
   		<tr>
   			<td>图片状态:</td>
   			<td><input class="easyui-textbox" id="showStatus" type="text" name="showStatus" data-options="required:true"></input></td>
   		</tr>
   		<tr>
   			<td>图片描述信息:</td>
   			<td><input class="easyui-textbox" id="discript" name="discript" ></input></td>
   		</tr>
   		<tr>
   			<td>上传时间:</td>
   			<td><input class="easyui-textbox" id="uploadTime" name="uploadTime" data-options="required:true" ></input></td>
   		</tr>
   	</table>
   </form>
<script type="text/javascript">
	$("#ff").form("load",{
		id:editRow.id,
		originalName:editRow.originalName,
		showStatus:editRow.showStatus,
		discript:editRow.discript,
		uploadTime:editRow.uploadTime
	});
</script>
