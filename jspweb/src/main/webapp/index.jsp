<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<style> 
.carousel-item img{
	height:600px;
	object-fit:cover;
}
.productBox{
display: flex;
justify-content: space-between;}

</style>
</head>
<body>
<%@include file="header.jsp" %>
	<h3> 본문</h3>


<!-- 캐러셀(bs) -->
	<div id="carouselExample" class="carousel slide">
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="/jspweb/img/product01.jpg" class="d-block w-100" alt="잔티 하프론 루즈핏 기모 맨투맨">
	    </div>
	    <div class="carousel-item">
	      <img src="/jspweb/img/product02.jpg" class="d-block w-100" alt="잔티 하프론 루즈핏 기모 맨투맨">
	    </div>
	    <div class="carousel-item">
	      <img src="/jspweb/img/product03.jpg" class="d-block w-100" alt="잔티 하프론 루즈핏 기모 맨투맨">
	    </div>
	  </div>
	  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Previous</span>
	  </button>
	  <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="visually-hidden">Next</span>
	  </button>
</div>



	<!-- 카드(bs) : 다양한 컨텐츠를 표시하는 컨테이너[구역]  -->
	<div class="container"> <!-- container(bs) : 컨테이너 구역  --> 
		<h1 class="text-center my-5" style="color: #312a55;font-weight: bold;"> NEW ITEM</h1>
		<!-- JS에서 HTML 넣어주는 위치 -->
		<div class="productBox my-5 row row-cols-1 row-cols-md-4 g-4"> </div>
	</div>







	
<%@include file="footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<script src="/jspweb/js/index.js"></script>

</body>
</html>
<!-- 
ip: 네트워크(인터넷) 사용하는 컴퓨터의 식별번호
	ip : localhost / 192.168.17.148
port: 컴퓨터내 프로그램 식별하는 번호
	mysql : 3306[권장]
	톰캣[서버] : 8080[권장]
	http: 80권장


	cmd > netstat -ano
		포트 강제 종류 [서버 안꺼지는 경우] : taskkill/f/pid [프로그램아이디번호]




 -->