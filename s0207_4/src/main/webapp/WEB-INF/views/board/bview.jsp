<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>게시판리스트</title>
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
				<col width="10%">
				<col width="*">
				<col width="15%">
				<col width="15%">
				<col width="10%">
			</colgroup>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<!-- 
			<tr>
				<td>${bdto.bno}</td>
				<td>${bdto.btitle}</td>
				<td>${bdto.id}</td>
				<td>${bdto.bdate}</td>
				<td>${bdto.bhit}</td>
			</tr>
			 -->
		</table>
		<div>
			<a href="/">메인페이지 이동</a>
		</div>
	</body>
</html>