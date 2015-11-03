<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>绑定结果</title>
</head>
<body>
<%
     String id=request.getParameter("email");
     out.print("你好:  "+id);
%>
<br>
恭喜您,账号绑定成功,您现在可以实时收发订单消息与查询入库信息等其他服务.
</body>
</html>