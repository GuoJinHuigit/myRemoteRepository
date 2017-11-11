<%--<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>--%>
<%@page  pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
   <link rel="stylesheet" type="text/css" 
	href="${pageContext.request.contextPath}/back/themes/gray/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/back/easyUi/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

	function selectTabs(menuName,menuIcon,href){
		console.log(menuName);
		console.log(menuIcon);
		console.log(href);
		//判断标题所对应的Tab是否存在  如果存在则选中  不存在则添加
		var istabs=$("#tt").tabs("exists",menuName);
		if(istabs){
			$("#tt").tabs("select",menuName);
		}else{
			$("#tt").tabs("add",{
				title:menuName,
				iconCls:menuIcon,
				selected:true,
				closable:true,
				href:"${pageContext.request.contextPath}/back/show/"+href
			});
		}
	}
	$(function(){
		//发送Ajax 请求  json数据
		$.post(
			"${pageContext.request.contextPath}/menu/findMenuByRole",//url
		  	//function 执行成功后回调函数 
			function(data){
				//遍历集合  第1个参数要遍历集合的名   index 元素的下表  obj 循环变量
				console.log(data);
				$.each(data,function(index,obj){
					var content="";
					//遍历子菜单
					$.each(obj.children,function(i,o){
						console.log(o);
						content+="<a class='easyui-linkbutton' onClick='selectTabs(\""+o.menuName+"\",\""+o.menuIcon+"\",\""+o.href+"\")' style='width:100%' data-options='iconCls:\""+o.menuIcon+"\"'>"+o.menuName+"</a>";
					});
					
					$("#aa").accordion("add",{
						title:obj.menuName,
						iconCls:obj.menuIcon,
						//content 子菜单的内容
						content:content,
						selected:false
					});
				});
			},"JSON"
		);
	});
</script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" ><shiro:hasRole name="superAdmin">持名法州后台管理系统</shiro:hasRole></div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 350px;float:right;padding-top:15px">欢迎您:<shiro:principal/> &nbsp;<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/logout" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'" style="overflow:hidden; ">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">   
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(../back/img/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>   
</body> 
</html>