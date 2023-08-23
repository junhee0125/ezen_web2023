<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css import -->
<link href="visitlog.css" rel="stylesheet"/>
</head>
<body>
	<!-- CRUD (restful Api)기반의 비회원 게시판 방문록 구현 -->
	<div class="wrap">
	
		<div class ="vwrite"><!-- 쓰기구역 -->
		<ul>
			<li>
				<input class="vwriter" type= "text" placeholder="작성자"> <br/>
				<input class="vpwd" type="text" placeholder="비밀번호">
			</li>
		
			<li>
				<textarea class="vcontent" rows="5" cols="46" placeholder="내용을 입력하세요"></textarea>
			</li>
			<li>
				<button onclick="vwrite()" type="button">등록</button>
			</li>
		</ul>	
		</div>
		
		
		<div class="viewList"><!-- 출력구역 -->
		<!-- 	
			<div class="items">
				<div class="header">
					<div> 유재석 </div>
					<div>2222-11-11 11:55:11</div>
				</div>
				<div class="conts"> 안녕하세요</div>
				<div class="btn">
					<button type="button">수정</button> <br/>
					<button type="button">삭제</button>
				</div>
			
			</div>
			-->
		</div>
	</div>
<!-- 최신 JQuery 불러오려고 왜? ajax쓸라고  왜?  외부로부터 통신하려고-->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<!-- js import -->
<script src= "visitlog.js" type="text/javascript"></script>
</body>
</html>