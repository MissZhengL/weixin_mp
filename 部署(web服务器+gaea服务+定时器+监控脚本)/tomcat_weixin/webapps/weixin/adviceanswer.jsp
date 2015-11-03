<%@page import="cn.hofan.dal.impl.SupplierDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no"/>
	<title>感谢</title>
	</head>
	<body>
	<%
	request.setCharacterEncoding("UTF-8");
	String advice = request.getParameter("desc");
	SupplierDaoImpl dao = new SupplierDaoImpl();
	dao.saveAdvice(advice);
	%>
		<div class="wrap" align="center" style="background:url(bg.jpg) no-repeat ; background-size: cover; -moz-background-size: cover; " >
		<br><br><br><br><br>
		<div align="center"><b>感谢反馈！</b></div>
		<br><br><br><br><br>
	</div>
	</body>
</html>