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
		<li>비밀번호:<input class="mpwd" type="text"></li>
		<li>비밀번호확인:<input class="mpwdconfirm" type="text"></li>
		<li>이메일: <input class="memail" type="text"></li>
		<li>이메일 인증코드	: <input class="emailconfirm" type="text"></li>
		<li>프로필	: <input class="mfile" type="file"></li>
		<li><button onclick ="signup()">저장</button></li>
	
	
	</ul>
		
	</div>
<script src="../js/signup.js"></script>
</body>
</html>