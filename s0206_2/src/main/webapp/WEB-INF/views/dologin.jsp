<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>가입회원정보</title>
		<style>
			h2{text-align: center;}
			table, th, td{border:1px solid black; border-collapse: collapse;}
			table{width: 800px; text-align: center;}
			th, td{height: 40px;}
		</style>
	</head>
	<body>
		<h2>로그인정보</h2>
		<table>
			<colgroup>
				<col width="*%">
				<col width="16%">
				<col width="16%">
				<col width="16%">
				<col width="16%">
				<col width="16%">
				<col width="16%">
			</colgroup>
			<tr>
				<th>아이디</th>
				<th>패스워드</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>합계</th>
				<th>평균</th>
			</tr>
			<tr>
				<td>${id}</td>
				<td>${pw}</td>
				<td>${kor}</td>
				<td>${eng}</td>
				<td>${math}</td>
				<td>${total}</td>
				<td>${avg}</td>
			</tr>
		</table>
		<div>
			<a href="/">메인페이지 이동</a>
		</div>
	</body>
</html>