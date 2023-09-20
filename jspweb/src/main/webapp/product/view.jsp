<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품등록페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<link href="../css/product_view.css"  rel="stylesheet">

<style>
	
</style>
</head>
<body>
<%@include file="../header.jsp" %>
	<div class="productBox">
		<!-- 부트스트랩 캐러셀 -->
		<div id="carouselExample" class="carousel slide">
		  <div class="imgbox carousel-inner">
		    
		    
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
		<div class=pInfo>
			<div class="mid">판매자 : 김호동</div>
			<div class="categoryDate">
				<div class="pcname"> 카테고리: <span>노트북</span></div>
				 <div class="pdate"> 등록일 : <span> 203309-19 11:47</span></div>
			</div>
			<div class="pname">내용입니다. 어쩌구 어쩌구노트북을 팝니다.</div>
			<div class="pprice">657,000</div>
			<div class="pcomment">어쩌구노트북을 팝니다어쩌구노트북을 팝니다어쩌구노트북을 팝니다어쩌구노트북을 팝니다어쩌구노트북을 팝니다</div>
			<div class="pbtnBox">
				<button onclick="setWish()" type="button">찜하기 <span class="wish">♡</span></button>
				<button type="button">바로구매</button>
			</div>	
			
			<!-- Nav tabs -->
			<ul class="mt-5 nav  nav-pills nav-tabs" id="myTab" role="tablist">
			  <li class="nav-item" role="presentation">
			    <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#navtab1" type="button" role="tab" aria-controls="home" aria-selected="true">
			    제품위치
			    </button>
			  </li>
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#navtab2" type="button" role="tab" aria-controls="profile" aria-selected="false">
			    제품후기
			    </button>
			  </li>
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="messages-tab" data-bs-toggle="tab" data-bs-target="#navtab3" type="button" role="tab" aria-controls="messages" aria-selected="false">
			    Q&A</button>
			  </li>
			  <li class="nav-item" role="presentation">
			    <button class="nav-link" id="settings-tab" data-bs-toggle="tab" data-bs-target="#navtab4" type="button" role="tab" aria-controls="settings" aria-selected="false">
			    구매유의사항
			    </button>
			  </li>
			</ul>
			
			<!-- Tab panes -->
			<div class="tab-content">
			  <div class="tab-pane active" id="navtab1" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
			  ...
			  </div>
			  <div class="tab-pane" id="navtab2" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
			  ...
			  </div>
			  <div class="tab-pane" id="navtab3" role="tabpanel" aria-labelledby="messages-tab" tabindex="0">
			  ...
			  </div>
			  <div class="tab-pane" id="navtab4" role="tabpanel" aria-labelledby="settings-tab" tabindex="0">
			  </div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f944d875d569375b6c6bc259f5f497b&libraries=clusterer"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<script src="../js/product/view.js"></script>
</body>
</html>

	 