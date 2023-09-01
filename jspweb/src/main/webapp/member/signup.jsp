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
	<div class="webcontainer">
    <form class="signupForm"><!-- 폼전송시 각input에 name -->
        <h2> 이젠 개발자 커뮤니티 </h2>
            <p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다. </p>

            <div class="intitle">아이디</div>
            <input maxlength="30" onkeyup="idcheck() " name="mid" class="mid"  type="text" />
            <div class="idcheckbox"></div>

            <div class="intitle">비밀번호</div>
            <input maxlength="20"  onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password" />

            <div class="intitle">비밀번호 확인</div>
            <input maxlength="20" onkeyup="pwcheck()"  class="mpwdconfirm" type="password" />
            <div class="pwcheckbox"></div>

            <div class="intitle">이메일</div>
             <!-- 이메일 인증요청 버튼  >> 유효성 검사 통과시 사용가능 -->
            <div class="emailbox">
                <input onkeyup="emailcheck()" name="memail" class="memail" type="text" />
                <button disabled class="authReqBtn" onclick="authReq()"  type="button">인증요청</button>
            </div>
            <div class="authbox"> </div>
            <div class="emailcheckbox"></div>

            <div class="intitle">프로필</div>
            <input onchange="preimg( this )" name="mfile" class="mfile" type="file" accept="image/*" />
            <img class="preimg" alt="" src="img/default.webp">

            <button class="signupbtn" onclick="signup()" type="button">회원가입</button>

    </form>
	</div>
<script src="../js/signup.js"></script>
</body>
</html>