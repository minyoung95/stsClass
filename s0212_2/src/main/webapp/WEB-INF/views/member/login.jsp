<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp" %>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="/">HOME</a></li>
				<li><a href="#">MEMBERSHIP</a></li>
				<li class="last">로그인</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">MEMBERSHIP<span>멤버쉽</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">로그인</a></li>
					<li><a href="#" id="leftNavi2">회원가입</a></li>
					<li><a href="#" id="leftNavi3">아이디/<span>비밀번호 찾기</span></a></li>
					<li><a href="#" id="leftNavi4">회원약관</a></li>
					<li><a href="#" id="leftNavi5">개인정보<span>취급방침</span></a></li>
					<li class="last"><a href="#" id="leftNavi6">이메일무단<span>수집거부</span></a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(1,0);</script>

			<script>
					
				// 쿠키 읽기
				$(function(){
					const cookies = document.cookie.split(";");
					for(let cookie of cookies){
						let [k,v] = cookie.split("=");
						if(k == "cook_id"){
							console.log(v);
							$("#id").focus();
							$("#id").val(v);
							$("#idsave").attr("checked",true);
						}
					}
				})
				
				// 자바스크립트 쿠키저장
				$(function(){
					$("#idsave").change(() => {
						if($("#idsave").is(":checked")){
							let id = $("#id").val();
						    let date = new Date();
						    date.setTime(date.getTime()+(1000*60*60*24)); //1일
						    //쿠키저장
						    document.cookie = `cook_id=`+id+`; expires=`+date.toUTCString()+`; path=/`;
						}else{
							// 쿠키 삭제 : 시간 0으로 셋팅(지난 시간 입력시 사라짐)
							document.cookie = `cook_id=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/`;
							$("#id").val("");
						}
					});
				});
			</script>
			
			<!-- contents -->
			<div id="contents">
				<div id="member">
					<h2><strong>로그인</strong><span>로그인 후 주문하시면 다양한 혜택을 받으실 수 있습니다.</span></h2>
					<h3>회원 로그인</h3>
					<div class="informbox">
						<div class="inform">
							<ul>
							<form action="/member/login" name="loginFrm" method="post">
								<li><input type="text" name="id" id="id" class="loginType" onfocus="this.className='mfocus'" onblur="if (this.value.length==0) {this.className='loginType'}else {this.className='mfocusnot'}" style="ime-mode:inactive;" /></li>
								<li><input type="password" name="pw" class="passType" onfocus="this.className='mfocus'" onblur="if (this.value.length==0) {this.className='passType'}else {this.className='mfocusnot'}" style="ime-mode:inactive;" /></li>
							</ul>

								<div class="btn"><a class="sbtn">로그인</a></div>
								<div class="chk"><input type="checkbox" id="idsave"/><label for="idsave">아이디 저장</label></div>							
							</form>

							<div class="point">
								<p>아이디와 비밀번호를 잊으셨나요?</p>
								<a href="#" class="nbtn">아이디/비밀번호 찾기</a>
							</div>
						</div>
					</div>



					<h3>비회원 주문 조회</h3>
					<div class="informbox">
						<div class="inform">
							<ul>
								<li><input type="text" class="ordererType" onfocus="this.className='mfocus'" onblur="if (this.value.length==0) {this.className='ordererType'}else {this.className='mfocusnot'}" /></li>
								<li><input type="text" class="ordernumType" onfocus="this.className='mfocus'" onblur="if (this.value.length==0) {this.className='ordernumType'}else {this.className='mfocusnot'}" /></li>
							</ul>

							<div class="btn"><a href="#" class="gbtn">조회하기</a></div>
							<div class="point">
								<p>아직 JARDIN 회원이 아니신가요? <span>회원가입하시고 다양한 혜택을 받으세요.</span></p>
								<a href="#" class="nbtn">회원가입</a>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- //contents -->


		</div>
	</div>
	<!-- //container -->
<%@ include file="../footer.jsp"%>