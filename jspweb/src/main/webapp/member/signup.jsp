<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/member.css"  rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>
<!-- 회원가입 전체구역 -->
	<div class="swrap">

	<ul>
		<li>아이디:<input onkeyup="idcheck()" class="mid" type="text">
			<span class="idcheckbox"></span>
		</li>

		<li >비밀번호:<input onkeyup="pwcheck()" class="mpwd" type="text"></li>
		<li >비밀번호확인:<input onkeyup="pwcheck()" class="mpwdconfirm" type="text">
		<span class="pwcheckbox"></span>
        </li>
		<li>이메일: <input onkeyup="emailcheck()" class="memail" type="text">
		 <!-- 이메일 인증요청 버튼  >> 유효성 검사 통과시 사용가능 -->
		<button disabled class="authReqBtn" onclick="authReq()" type="button">인증요청</button>
		</li>

		<li class="authbox">
		  <!-- 인증요청 버튼 클릭시 보이는 구역 -->

		     이메일 인증코드	: <input class="emailconfirm" type="text">
		      <span class="emailcheckbox"></span>
		</li>


		<li>프로필	: <input class="mfile" type="file"></li>
		<li><button onclick ="signup()">저장</button></li>


	</ul>

	</div>
<script src="../js/signup.js"></script>
</body>
</html>