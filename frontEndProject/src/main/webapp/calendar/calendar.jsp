<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다리꼬지마</title>
<link href="../css/calendar.css" rel="stylesheet">


</head>
<body>
	<%@include file="../header.jsp" %>
	<!--  -->
	<div class="wrap"> <!-- 전체구역 -->
		<div class="caltop">
			<!-- 이전 달 버튼 -->
			<button onclick="onNext(0)" type="button"> < </button>
			<!-- 현재 월 표시구역 -->
			<h3 class="caldate">2023년 07월</h3>
			<!-- 다음달 표시구역 -->
			<button onclick="onNext(1)" type="button"> > </button>
		</div>
		<div class="calendar"> <!-- 날짜 표시 구역 -->
			<!--  상단의 요일 표기  -->
			
			<!-- 일day 표기 -->
			<div > 1
				<span class="todo"> 밥먹기밥먹기밥먹기밥 먹기밥먹기밤밥먹 기밥먹 기밥먹기밥먹기 밥먹기밤밥먹기밥먹기밥먹기밥먹기밥먹기밤밥먹기밥먹기밥먹기밥먹기밥먹기밤 </span>
				<span class="todo"> 잠자기 </span>
				<span class="todo"> 잠자기 </span>				
			</div>
			
		</div>
	</div>
	
	<!-- 모달 전체 영역 -->
	<div class="modal_wrap">
		<div class="modal">
			<h4> 일정추가 </h4>
			
			<input class="color" type="color">
			<div class="date">2023-07-10</div>
			<textarea class="content" rows="5" cols="55"></textarea>
			<div class="modal_btn"> 
				<button onclick="onWrite()">일정등록</button>
				<button onclick="closeModal()">닫기</button>
			</div>
		</div>
	</div>
	
	
	
	<%@include file="../footer.jsp" %>
<script src="../js/calendar.js" type="text/javascript"></script>
</body>
</html>