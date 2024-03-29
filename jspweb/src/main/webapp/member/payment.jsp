<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<link href="../css/product.css"  rel="stylesheet">

</head>
<body>
<%@include file="../header.jsp" %>
<div class="webcontatiner">
	<div>
		<button onclick="onAmount(1000)" type="button">1000포인트</button>
		<button onclick="onAmount(5000)" type="button">5000포인트</button>
		<button onclick="onAmount(10000)" type="button">10000포인트</button>
		<button onclick="onAmount(50000)" type="button">50000포인트</button>
		<button onclick="onAmount(100000)" type="button">100000포인트</button>
		
	
	</div>
	
	<div>
		<button onclick="onPayMethod('card')" type="button">신용카드</button>
		<button onclick="onPayMethod('trans')" type="button">실시간계좌이체</button>
		<button onclick="onPayMethod('vbank')" type="button">가상계좌</button>
		<button onclick="onPayMethod('phone')" type="button">휴대폰소액결제</button>
	
	</div>
	<button onclick="requestPay()" type="결제하기">결제하기</button>			
			
			
	</div>
<!-- 포트원 라이브러리 추가 -->	
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>	
<script src="../js/payment.js"></script>

</body>
</html>