<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/hrm.css"  rel="stylesheet">
</head>
<body>
<%@include file="../header.jsp" %>
<!-- 직원등록 전체구역 -->
    <div class="webcontainer">
    <form class="hrmForm">
        <h2> 이젠 개발자 커뮤니티 </h2>
            <p> 환영합니다. 다양한 커뮤니티 플랫폼 제공합니다. </p>

            <div class="intitle">이름</div>
            <input maxlength="20" name="hname" class="hname"  type="text" />


            <div class="intitle">직급</div>
            <select class="hrank" required>
                <option value="" alt="Clerk">선택</option>
                <option value="C" alt="Clerk">사원</option>
                <option value="S" alt="SeniorClerk">주임</option>
                <option value="A" alt="AssistantManager">대리</option>
                <option value="M" alt="Manager">팀장</option>
                <option value="G" alt="GeneralManager">부장</option>
                <option value="P" alt="President" >사장</option>
            </select>

            <div class="intitle">전화번호</div>
            <input maxlength="13" class="hphone" name="hphone" type="tel"  pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" required  placeholder="010-1234-1234"/>


            <div class="intitle">프로필</div>
            <input onchange="preimg( this )" name="hphoto" class="hphoto" type="file" accept="image/*" />
            <img class="preimg" alt="" src="img/default.webp">

            <button class="saveBtn" onclick="save()" type="button">등록</button>

    </form>
    </div>
<script src="../js/hrm.js"></script>
</body>
</html>