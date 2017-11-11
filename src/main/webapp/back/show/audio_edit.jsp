<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<form id="audio_ff" method="post">
   	<table cellpadding="5">
   		<tr>
   			<td>音频ID:</td>
   			<td><input class="easyui-textbox"  type="text" name="id" data-options="required:true,readonly:true"></input></td>
   		</tr>
   		<tr>
   			<td>音频名称:</td>
   			<td><input class="easyui-textbox"  type="text" name="name" data-options="required:true"></input></td>
   		</tr>
   		<tr>
   			<td>音频状态:</td>
   			<td><input class="easyui-textbox"  type="text" name="audioStatus" data-options="required:true"></input></td>
   		</tr>
   		<tr>
   			<td>音频上传日期:</td>
   			<td><input class="easyui-textbox"  name="audioDate" data-options="required:true" ></input></td>
   		</tr>
   		<tr>
   			<td>音频类型:</td>
   			<td><input class="easyui-textbox"  name="type" data-options="required:true" ></input></td>
   		</tr>
   		<tr>
   			<td>音频文件名称:</td>
   			<td><input class="easyui-textbox"  name="audioOriName" data-options="required:true" ></input></td>
   		</tr>
   	</table>
   </form>
<script type="text/javascript">
	$("#audio_ff").form("load",{
		id:$("#zhuanji_dg").treegrid("getSelected").id,
		name:$("#zhuanji_dg").treegrid("getSelected").name,
		audioStatus:$("#zhuanji_dg").treegrid("getSelected").audioStatus,
		audioDate:$("#zhuanji_dg").treegrid("getSelected").audioDate,
		type:$("#zhuanji_dg").treegrid("getSelected").type,
		audioOriName:$("#zhuanji_dg").treegrid("getSelected").audioOriName,
	});
</script>
