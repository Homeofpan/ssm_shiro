<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>登录页面</h3>
<font color="red">${param.msg}</font>
<form method="post" action="/login">
用户名:<input type="text" name="name"/><br>
用户名:<input type="password" name="password"/><br>
<input type="checkbox" name="isRememberMe"/>记住我<span></span><br>
<input type="submit" value="登录">
</form>
</body>
</html>