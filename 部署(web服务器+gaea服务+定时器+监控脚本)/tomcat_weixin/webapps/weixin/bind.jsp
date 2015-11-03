<%@page import="cn.hofan.dal.impl.SupplierDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
 
<!-- 公共HEAD设置 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>账号绑定</title>
<meta name="description" content="浩方 供应商 门户 账号绑定" />
<meta name="keywords" content="浩方 供应商 门户 账号绑定" />
<meta name="robots" content="INDEX,FOLLOW" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="">
<meta name="format-detection" content="telephone=no">
<!-- <meta id="viewport" name="viewport" content="width=640px,minimum-scale=0.2,maximum-scale=0.2" /> --> 
<!-- <meta id="viewport" name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />-->
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>


<!--[if lte IE 9]>
<script type="text/javascript" src="http://www.100what.com/media/js/eff9c204dba7cd1c4ae36bc4db1a7848.1442479459.js"></script>
<![endif]-->

<!-- 苹果设备ViewPort兼容 -->
<!-- <script type="text/javascript">
	if (/(iPhone|iPad|iPod|iOS)/i.test(navigator.userAgent)) {
		//alert(navigator.userAgent); 
		//add a new meta node of viewport in head node
		head = document.getElementsByTagName('head');
		viewport = document.createElement('meta');
		viewport.name = 'viewport';
		viewport.content = 'target-densitydpi=device-dpi, width=' + 640 + 'px, user-scalable=no';
		head.length > 0 && head[head.length - 1].appendChild(viewport);    
		   
	}
</script> -->

<!-- 微信JS API -->
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script>
  	wx.config({
	    debug: false,
	    appId: 'wxbe3a2665ec44da5e',
	    timestamp: 1442912946,
	    nonceStr: 'MUv9cDZOW4F5txMN',
	    signature: 'f53e6a4df3ee6dd70cd9ee88aceb665408389cc8',
	    jsApiList: [
	        'checkJsApi',
	        'onMenuShareTimeline',
	        'onMenuShareAppMessage',
	        'showMenuItems',
	        'hideMenuItems',
// 	        'chooseWXPay',
		]
  	});
</script>
<script src="http://www.100what.com/skin/frontend/aw_mobile/iphone/js/wxjsapi.js"></script>
<script type="text/javascript">
	function OnInput(event){
		document.getElementById("butt").disabled=false;
	}
</script>
</head>
<body  class="weixin-home-index">
<%
request.setCharacterEncoding("UTF-8");
String openid = request.getParameter("openid");
//out.print("openid="+openid);
SupplierDaoImpl dao = new SupplierDaoImpl();
if(!dao.openIdIsChecked(openid)){
	if(dao.openIdCheckedExpire(openid)){
%>
	<div class="wrap" align="center"  style="background:url(bg.jpg) no-repeat ; background-size: cover; -moz-background-size: cover; " > 
		<form action="http://weixin.hofan.cn/weixin/bind2.jsp?openid=<%=openid%>" method="post">
		<br><br>
		<div>验证超时,请重新输入供应商编号</div><br><br>
			<input style="border-radius:5px;width:300px;height:35px" type="text" name="erpcode" oninput="OnInput(event)" placeholder="请重新输入您的供应商编号"/><br><br><br>
			<input style="border-radius:5px;width:300px;height:50px;background:green;color: white;font-size: 20px" id="butt" type="submit" name="secondname"  disabled="disabled"  value="发送验证码"/><br><br><br>
		</form>
	</div>
 	
	
<%
	}else if(!dao.openIdIsNotChecked(openid)){
		%>
		<div class="wrap" align="center"  style="background:url(bg.jpg) no-repeat ; background-size: cover; -moz-background-size: cover; " > 
		<form action="http://weixin.hofan.cn/weixin/bind2.jsp?openid=<%=openid%>" method="post">
		<div><br><br><b>供应商编号</b><br><br></div>
				<input style="border-radius:5px;width:300px;height:35px" type="text" oninput="OnInput(event)" name="erpcode" placeholder="请输入您的供应商编号"/><br><br>
				<input style="border-radius:5px;width:300px;height:50px;background:green;color: white;font-size: 20px" id="butt" disabled="disabled" type="submit" name="secondname"  value="发送验证码"/><br><br><br><br>
		</form>
		</div>
		<%
	}else{
		String erpcode = dao.getCode(openid);
		%>
		<div class="wrap" align="center" style="background:url(bg.jpg) no-repeat ; background-size: cover; -moz-background-size: cover; ">
		<form
			action="http://weixin.hofan.cn/weixin/bindanswer.jsp?openid=<%=openid%>"
			method="post">
			<br>
			<br>
			<div>请您前往浩方门户绑定的邮箱收发验证码</div>
			<br>
			<br> <input
				style="border-radius: 5px; width: 300px; height: 35px" type="text"
				name="firstname" oninput="OnInput(event)" placeholder="请输入验证码" /><br>
			<br>
			<br> <input
				style="border-radius: 5px; width: 300px; height: 50px; background: green; color: white; font-size: 20px"
				id="butt" disabled="disabled" type="submit" name="secondname"
				value="提交" /> <input type="hidden" name="erpcode"
				value="<%=erpcode%>" /><br>
			<br>
			<br>
		</form>
		</div>
		<%
	}
	
}else{
	%>
	<div class="wrap" align="center" style="background:url(bg.jpg) no-repeat ; background-size: cover; -moz-background-size: cover; ">
		<br><br><br><br><div><b>账号已绑定！</b></div><br><br><br><br>
	</div>
	<%
}
%>
	
</body>
</html>