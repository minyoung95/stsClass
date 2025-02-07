<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>메인페이지</title>
	</head>
	<body>
		<h2>메인페이지</h2>
			<div>session_id : 세션 아이디가 없습니다.</div>
			<div>
				<a href="login">로그인</a>
			</div>
			<div>
				<a href="member">회원가입</a>
			</div>
			<div>session_id : ${session_id}</div>
			<div>
				<a href="logout">로그아웃</a>
			</div>
			<div>
				<a href="board">게시판</a>
			</div>
			<div>
				<a href="member">회원정보</a>
			</div>	
			<div>
				<a href="stuInput">학생성적입력</a>
			</div>	
			<div>
				<a href="data?bno=1">데이터</a>
				<a href="data2/10">데이터2</a>
			</div>	
			<div>
				<a href="data3/1,2,3">데이터3</a>
				<a href="data4">데이터4</a>
			</div>	
	</body>
</html>