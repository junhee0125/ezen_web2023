<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/chatting.css"  rel="stylesheet">

</head>
<body>
<%@include file="../header.jsp" %>
<div class="webcontainer">
	
	<!-- 채팅 전체구역 -->
	<div  class="chatBox">
	
	
		<!-- 채팅내용목록 -->
		<div class="chatcont">
			<!-- 보냈을때  오른쪽정렬 -->
			
			<!-- 알림 메세지 -->
			<!-- <div class="alram"> 강호동님이 입장햇습니다.</div>-->
			<!-- 받을때  왼쪽정렬 -->
			
		</div>
		<!-- 채팅입력창, 전송버튼 -->
		<div class="chatbottom">
			<textarea class="msg"> </textarea>
			
			<button onclick="onSend()" type="button">전송</button>
		</div>
	</div>
</div>

<script src="../js/chatting.js"></script>
</body>
</html>
<!-- 
	
	<div  class="chatBox">
	
	
		
		<div class="chatcont">
			
			<div class="rcont">
				<div class="subcont">
					<div class="date">오전10:11</div>
					<div class="content">안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요
					안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요
					안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요</div>
				
				</div>
			
			</div>
			<div class="alram"> 강호동님이 입장햇습니다.</div>
		
			<div class="lcont">
				<img src="/jspweb/member/img/default.webp">
				<div class="tocont">
					<div> 강호동</div>
					<div class="subcont"> 
						<div class="content">안녕하세요안녕하세요안녕하세요안녕하세요
						안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요
						안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요안녕하세요
						안녕하세요안녕하세요안녕하세요안녕하세요</div>
						<div class="date">오전10:11</div>
					
					</div>
					
					
				
				</div>
		
			</div>
		</div>
		<div class="chatbottom">
			<textarea class="msg"> </textarea>
			
			<button onclick="onSend()" type="button">전송</button>
		</div>
	</div>




 -->