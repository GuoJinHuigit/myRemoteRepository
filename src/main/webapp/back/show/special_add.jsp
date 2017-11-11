<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/upload.css">
<style>
.tr {
	margin: 10px;
}
</style>
<form id="banner_upload"
	method='post' enctype="multipart/form-data" runat="server">

		<div class="tr">
		<font class="font">专辑名称</font>
		<input type="text" class="easyui-textbox" required="required" name="specialName"><br>
		</div>
		
		<div class="tr">
		<font class="font">作&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;者</font>
		<input type="text" class="easyui-textbox" required="required" name="author"><br>
		</div>
		
		<div class="tr">
		<font class="font">播&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;音</font>
		<input type="text" class="easyui-textbox" name="broadCast"><br>
		</div>
		
		<div class="tr">
		<font class="font">专辑封面上传</font>
		<p class="_box">
		<input type="file" name="file" accept="image/*" >选择图片
		</p>
		<span>图片大小不要超过2M,可以使用jpg、png等后缀</span>
		</div>
		
		<div class="tr">
		<font class="font">专辑介绍</font><br>
		<textarea name="details" style="width:400px;height:200px"></textarea>
		</div>
</form>

