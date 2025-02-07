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
		<c:if test="${session_id == null }">
			<div>session_id : 세션 아이디가 없습니다.</div>
			<div>
				<a href="login">로그인</a>
			</div>
			<div>
				<a href="member">회원가입</a>
			</div>
		</c:if>
		<c:if test="${session_id != null }">
			<div>session_id : ${session_id}</div>
			<div>
				<a href="logout">로그아웃</a>
			</div>
			<div>
				<a href="board">게시판</a>
			</div>
			<div>
				<a href="memInfo">회원정보</a>
			</div>	
		</c:if>
	</body>
</html>