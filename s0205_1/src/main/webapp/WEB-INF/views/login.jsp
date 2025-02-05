<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 페이지</title>
	</head>
	<body>
		<h2>로그인페이지</h2>
		<form action="doLogin" method="post">
			<label>아이디</label>
			<input type="text" name="id">
			<label>패스워드</label>
			<input type="text" name="pw">
			<input type="submit" value="로그인">
		</form>
		<h4><a href="/">메인페이지 이동</a></h4>
	</body>
</html>