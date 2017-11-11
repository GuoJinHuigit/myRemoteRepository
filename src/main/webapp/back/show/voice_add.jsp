<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/upload.css">
<style>
.tr {
	margin: 10px;
}
</style>
<form id="voice_form"
	method='post' enctype="multipart/form-data" runat="server">
		
		<div class="tr">
		<input type="text" class="easyui-textbox" value="${param.specialId }" required="required" name="speId"><br>
		</div>
		
		<div class="tr">
		<font class="font">音频名称</font>
		<input type="text" class="easyui-textbox" required="required" name="audioName"><br>
		</div>
		
		<div class="tr">
		<font class="font">音频上传</font>
		<p class="_box">
		<input type="file" name="file" multiple />选择音频文件
		</p>
		<span>音频文件的大小不要超过1G,目前只能上传mp3格式音频文件</span>
		</div>
		
</form>

