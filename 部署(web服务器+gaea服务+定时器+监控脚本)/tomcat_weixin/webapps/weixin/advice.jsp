<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
	<title>提点建议</title>
	<script type="text/javascript">
	function OnInput(event){
		document.getElementById("butt").disabled=false;
	}
	function checkLength(obj,maxlength){
	    if(obj.value.length > maxlength){
	        obj.value = obj.value.substring(0,maxlength);
	    }
	}
	</script>
	</head>
	<body>
	 <div class="wrap" align="center" style="background:url(bgg.jpg) no-repeat ; background-size: cover; -moz-background-size: cover; " > 
		<form action="http://weixin.hofan.cn/weixin/adviceanswer.jsp" method="POST" >
			<table style="margin-top: 20px" align="center" cellpadding="10px" cellspacing="0px" >
				<tr>
					<td>
						<textarea id="desc" rows="5" cols="45" name="desc"  onpropertychange="checkLength(this,50);" oninput="checkLength(this,50);OnInput(event)" ></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input style="border-radius:5px;width:100%;height:50px;background:green;color: white;font-size: 15px" type="submit" id="butt" disabled="disabled" value="提交"/>
						<br><br>
					<!-- 	<input style="border-radius:5px;width:150px;height:50px;background:green;color: white;font-size: 15px" type="reset" value="重置"/> -->
					</td>
				</tr>
			</table>
		</form>
	</div>
	</body>
</html>