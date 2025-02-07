<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>학생성적정보</title>
		<style>
			h2{text-align: center;}
			table, th, td{border:1px solid black; border-collapse: collapse;}
			table{width: 800px; text-align: center;}
			th, td{height: 40px;}
		</style>
	</head>
	<body>
		<h2>학생성적정보</h2>
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
				<th>학번</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>합계</th>
				<th>평균</th>
			</tr>
			<tr>
				<td>${Score.stuno}</td>
				<td>${Score.name}</td>
				<td>${Score.kor}</td>
				<td>${Score.eng}</td>
				<td>${Score.math}</td>
				<td>${total}</td>
				<td>${avg}</td>
			</tr>
		</table>
		<div>
			<a href="/">메인페이지 이동</a>
		</div>
	</body>
</html>