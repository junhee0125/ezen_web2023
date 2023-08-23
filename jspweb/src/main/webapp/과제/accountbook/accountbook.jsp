<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="accountbook.css" rel="stylesheet"/>

</head>
<body>
	<div class="wrap">
		<div class="inputArea"> <!-- 입력구역 -->
			<span>항 목 : </span><input class="atext" type="text"/>
			<span>금 액 : </span><input class="anumber" type="text"/><span>원</span>
			<button onclick="aWrite()" type="button"> 등 록 </button>
		</div>
		
			<div class="rHeader">
				<div class="rDate hbg"> 날 짜 </div>
				<div class="rCont hbg"> 가계부 내용</div>
				<div class="rNum hbg"> 금  액</div>				
				<div class="rEdit hbg"> 수정 / 삭제</div>
			
			</div>
		<div class="outputArea"> <!-- 출력구역 -->	
			<!-- 리스트 반복 출력구역 s -->
			<div class="rItems">
				<div class="rDate"> 날 짜 </div>
				<div class="rCont">떡볶이</div>
				<div class="rNum">2000</div>
				<div class="rEdit">
					<button type="button">수정</button>
					<button type="button">삭제</button>
				</div>
			</div>
			<!-- 리스트 반복 출력구역 e -->
		</div>
	</div>
<!-- 최신 JQuery 불러오려고 왜? ajax쓸라고  왜?  외부로부터 통신하려고-->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- js import -->
<script src= "accountbook.js" type="text/javascript"></script>
</body>
</html>