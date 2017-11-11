<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<form id="ff" method="post">
   	<table cellpadding="5">
   		<tr>
   			<td>ID:</td>
   			<td><input class="easyui-textbox"  type="text" name="id" data-options="required:true,readonly:true"></input></td>
   		</tr>
   		<tr>
   			<td>专辑名称:</td>
   			<td><input class="easyui-textbox"  type="text" name="name" data-options="required:true"></input></td>
   		</tr>
   		<tr>
   			<td>作者:</td>
   			<td><input class="easyui-textbox"  type="text" name="author" data-options="required:true"></input></td>
   		</tr>
   		<tr>
   			<td>播音:</td>
   			<td><input class="easyui-textbox"  name="broadCast" data-options="required:true" ></input></td>
   		</tr>
   		<tr>
   			<td>专辑类型:</td>
   			<td><input class="easyui-textbox"  name="type" data-options="required:true" ></input></td>
   		</tr>
   		<tr>
   			<td>专辑图片名称:</td>
   			<td><input class="easyui-textbox"  name="oriName" data-options="required:true" ></input></td>
   		</tr>
   		<tr>
   			<td>专辑状态:</td>
   			<td><input class="easyui-textbox"  name="specialStatus" data-options="required:true" ></input></td>
   		</tr>
   	</table>
   </form>
<script type="text/javascript">
	$("#ff").form("load",{
		id:$("#zhuanji_dg").treegrid("getSelected").id,
		name:$("#zhuanji_dg").treegrid("getSelected").name,
		author:$("#zhuanji_dg").treegrid("getSelected").author,
		broadCast:$("#zhuanji_dg").treegrid("getSelected").broadCast,
		type:$("#zhuanji_dg").treegrid("getSelected").type,
		oriName:$("#zhuanji_dg").treegrid("getSelected").oriName,
		specialStatus:$("#zhuanji_dg").treegrid("getSelected").specialStatus
	});
</script>
