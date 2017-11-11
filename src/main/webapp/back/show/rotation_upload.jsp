<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/css/upload.css" style="align:center">
	<center><form id="form1" runat="server" action="${pageContext.request.contextPath}/rotate/add" method="post" enctype="multipart/form-data">
		<p class="_box">
		<input type="file" name="file" id="_f">选择图片
		</p>
		<span>图片大小不要超过2M,可以使用jpg、png等后缀</span>
	</form></center>