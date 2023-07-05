<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/frontEndProject/css/kiosk.css" rel="styleSheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="kiosk_wrap">
		<div><!-- 헤더 : 상단 이미지 + 카테고리 -->
			<!-- 광고이미지 -->
			<img class="himg" src="../img/kiosk/top_img01.png" />
			
			<!-- 카테고리 -->
			<ul class="categorymenu">
				<!-- categoryPrint함수가 메뉴를 넣어줄 영역 -->
			</ul>
		</div>
		<div><!-- 본문: 제품출력/카트풀력 -->
			<div class="product_box"> <!-- 제품출력 -->
				<!-- 제품1 -->
				<!-- function productPrint(categoryNo) 출력되는 영역
				<div class="product">
					<img src="../img/kiosk/menu5.png"/>
					<div class="product_info">
						<div class="pname">헬로 릴리트 와퍼</div>
						<div class="pprice">15,000원</div>
					</div>
				</div>
				-->
				
			</div>
			<div class="cart_box"> <!-- 카트구역 -->
				<div class="cart_content"> <!-- 제품가격 /총가격-->
					<div class="cart_top">
						<div class="ccount_box">카트 <span class="ccount">0</span></div>
						<div class="ctotalbox">총주문금액 : <span class="ctotal">0 원</span></div>
					</div>
					<div class="cart_bottom">
						<!-- 카트내 제품 1개 : 제품명 / 가격 / 취소버튼-->
						<!--  <div class="citem">
							<div class="iname">더블비프불고기버거</div>
							<div class="iprice">12,000원</div>
							<span class="icancel">X</span>						
						</div> -->
						
					
					</div>
				</div>
				<div class="cart_btn">
					<button onclick="wholeCancel()" class="btn_cancel">취소하기</button>
					<button onclick="productOrder()"class="btn_order">주문하기</button>
				</div>
			</div>
		</div>
		
	
	
	</div>




	<%@include file="../footer.jsp" %>
	<script src="/frontEndProject/js/kiosk.js"></script>
</body>
</html>