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
        <h2>마이페이지 </h2>
            <div class="intitle">프로필 변경</div>
            <input onchange="preimg( this )" name="mfile" class="mfile" type="file" accept="image/*" />
            <img class="preimg" alt="" src="img/default.webp">

            <div class="intitle">아이디</div>
            <div class="mid">aaa111</div>
            <div class="idcheckbox"></div>

            <div class="intitle"> 기존 비밀번호</div>
            <input maxlength="20"  onkeyup="pwcheck()" name="mpwd" class="mpwd" type="password" />

            <div class="intitle">새로운 비밀번호 </div>
            <input maxlength="20" onkeyup="pwcheck()" name="newmpwd"class="mpwdconfirm" type="password" />
            <div class="pwcheckbox"></div>

            <div class="intitle">이메일</div>
            <div class="memail">aaa111@aaa.com</div>


            <button class="signupbtn" onclick="mupdate()" type="button">회원정보수정</button>
             <button class="signupbtn" onclick="mdelete()" type="button">회원탈퇴</button>

    </form>
	</div>
<script src="../js/signup.js"></script>
<script src="../js/info.js"></script>
</body>
</html>