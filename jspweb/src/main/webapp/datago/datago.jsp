<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/datago.css"  rel="stylesheet">

</head>
<body>
<%@include file="../header.jsp" %>
<div class="webcontainer">

	<h3>카카오 지도</h3>
	<div class="detailBox"></div>
	<div id="map" style="width:100%;height:500px;"></div>


	<h3>공공데이터</h3>
	<h6> 안산시 착한가격업소 현황</h6>
	<table class="apiTable1">
		
	
	
	
	</table>


</div>




<!-- 카카오JS -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f944d875d569375b6c6bc259f5f497b&libraries=clusterer"></script>
<script src="../js/datago.js"></script>

</body>
</html>