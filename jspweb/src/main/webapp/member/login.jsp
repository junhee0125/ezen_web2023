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
            <input maxlength="30"  name="mid" class="mid"  type="text" />


            <div class="intitle">비밀번호</div>
            <input maxlength="20"   name="mpwd" class="mpwd" type="password" />

            <!-- -로그인 유효성검사구역 -->
            <div class="logincheckbox">    </div>

            <!-- 아이디/비밀번호찾기 -->
            <div class="findbtnbox">
                <a href="#">아이디 찾기</a>
                <a href="#">비밀번호찾기</a>
            </div>

            <button class="signupbtn" onclick="login()" type="button">회원가입</button>

    </form>
	</div>
<script src="../js/login.js"></script>
</body>
</html>