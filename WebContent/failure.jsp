<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//承接從Servlet傳遞過來的參數
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
	%>
	<!-- 驗證使用者失敗頁面 -->
	<h1>Login Failure</h1>

	<!-- 使用< %= % > 將想要顯示在網頁上的java內容直接印出-->
	user =
	<%=user%><br>
	pass =
	<%=pass%>
</body>
</html>