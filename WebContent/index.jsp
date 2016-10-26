<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
form   表單，負責劃出傳遞資料用的區域
action 這裡為連接指定的 servlet 路徑，另一個使用方法為 /Example/ExampleLogin 
	        通用功能為傳遞給下一個網址
method 指定傳送給post功能，另一個method是get功能，這是網頁通用語法。
input  第一個傳遞類型為text(文字)，name(參數名稱)為user， placeholder為預設在輸入欄位寫入提示文字
input  第二個傳遞類型為password(密碼)，name(參數名稱)為pass
button 傳遞類型為submit，主要做將form表單內包裹的資料傳送給action指定的位置
-->

	<form action="ExampleLogin" method="post">
		<input type="text" name="user" placeholder="請輸入帳號" /> <br> <input
			type="password" name="pass" /> <br>
		<button type="submit">送出</button>
	</form>

</body>
</html>