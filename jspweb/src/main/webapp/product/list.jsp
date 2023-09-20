<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품등록페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<link href="../css/product.css"  rel="stylesheet">

<style>
	
</style>
</head>
<body>
<%@include file="../header.jsp" %>
	<div class="mapcontent"> <!-- 지도와 사이드바 포함된 구역 -->
			
			<!-- 지도를 표시할 div 입니다 -->
			<div id="map"></div>
			
			<!-- 사이드바 구역 -->
			<div class="sidebar">
			
			</div>
			
	</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f944d875d569375b6c6bc259f5f497b&libraries=clusterer"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<script src="../js/product/list.js"></script>
</body>
</html>

	 