<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/board/list.css"  rel="stylesheet">

</head>
<body>
<%@include file="../header.jsp" %>
<div class="webcontainer">
    <h2  class="boardCategory">공지사항</h2>
    <div class="btnBox">
       <button onclick="onWrite()" type="button">글쓰기</button>
    </div>
    <div class="boardBox">
        <ul class="listHead">
            <li class="bno">번호</li>
            <li class="bcname">구분</li>
            <li class="btitle">제목</li>
            <li class="bwriter">작성자</li>
            <li class="bview">조회수</li>
            <li class="bdate">작성일</li>
        </ul>
        <div class="listBox">
        
	       <!-- 리스트 출력부분 -->
        
        </div>
       
    </div>

   

</div>
<script src="../js/board/list.js"></script>

</body>
</html>