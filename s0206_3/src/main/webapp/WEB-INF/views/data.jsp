<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판</title>
		<style>
			h2{text-align: center;}
			table, th, td{border:1px solid black; border-collapse: collapse;}
			table{width: 800px; text-align: center;}
			th, td{height: 40px;}
		</style>
	</head>
	<body>
		<h2>게시판</h2>
		<table>
			<colgroup>
				<col width="50%">
				<col width="50%">
			</colgroup>
			<tr>
				<th>번호</th>
				<th>제목</th>
			</tr>
			<tr>
				<td>${bno}</td>
				<td>${btitle}</td>
			</tr>
		</table>
		<div>
			<a href="/">메인페이지 이동</a>
		</div>
	</body>
</html>