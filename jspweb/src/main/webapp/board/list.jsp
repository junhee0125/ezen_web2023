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
	<!-- 상단 : (페이지 제목과 설명) -->
	<div class="boardHeader">
		 <h2  class="boardCategory">게시판</h2>
		 <p> 다양한 사람들과 정보를 공유해요</p>
	</div>
	
	<!-- 2. 상단 부가 버튼 -->
   	<div class="lposition btnBox ">
       	
       	<div>
       		<span class="boardcount"> 게시물 수 : 6 </span>
       		<select onchange="onListSize()" class="listSize" > <!-- 한페이지에 표시할 최대 게시물수 -->
       			<option>10</option>
       			<option>15</option>
       			<option>20</option>
       		</select>
       	</div>
       	<button onclick="onWrite()" type="button">글쓰기</button>
    </div>
       
   <!-- 카테고리 구역 -->
	<div class="  lposition">
   		<button onclick="onCategory(0)" class="btn" type="button">전체보기</button>
   		<button onclick="onCategory(1)" class="btn" type="button">공지사항</button>
   		<button onclick="onCategory(2)" class="btn" type="button">자유게시판</button>
   		<button onclick="onCategory(3)" class="btn" type="button">노하우</button>
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
    <div class="boradBottom">
    	<div class="searchBox">
			<select class="searchType">
			<!-- * 검색할 필드명 -->
				<option value="b.btitle">제목</option>
				<option value="b.content">내용</option>
				<option value="m.mid">작성자</option>
			</select>
			<input class="keyword" type="text">
			<button onclick="onSearch()" class="searchBtn" type="button">검색</button>
		</div>
		<!-- 페이징 구역 -->
		<div class="pageBox">
			<!-- getList() 페이지 네이션 출력 -->
		</div>
		<!--  검색구역 -->
		
		
   </div>

</div>
<script src="../js/board/list.js"></script>

</body>
</html>