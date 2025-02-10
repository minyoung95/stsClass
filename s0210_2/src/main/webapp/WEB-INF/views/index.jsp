<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
		<script>
		if("${param.logout}" == "1"){
			alert("로그아웃이 되었습니다.");
			location.href="/";
		}
		</script>
	</head>
	<body>
		<h2>메인페이지</h2>
		<div>세션아이디 : ${session_id}</div>
		<div>${session_name}님 환영합니다.</div>
		<ul>
			<c:if test="${session_id == null}">
				<li><a href="/member/login">로그인</a></li>
				<hr>
				<li><a href="/member/member">회원가입</a></li>
				<li><a href="/member/memInfo">회원정보</a></li>
				<li><a href="/board/blist">게시판</a></li>
				<li><a href="/board/bwrite">글쓰기</a></li>
			</c:if>
			<c:if test="${session_id != null}">
				<li><a href="/member/logout">로그아웃</a></li>
				<hr>
				<li><a href="/member/memInsert">회원가입</a></li>
				<li><a href="/member/memInfo">회원정보</a></li>
				<li><a href="/board/blist">게시판</a></li>
				<li><a href="/board/bwrite">글쓰기</a></li>
			</c:if>
		</ul>
	</body>
</html>