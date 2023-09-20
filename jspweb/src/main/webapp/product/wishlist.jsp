<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품등록페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

<link href="../css/wishlist.css"  rel="stylesheet">

<style>
	
</style>
</head>
<body>
<%@include file="../header.jsp" %>
	<div  class="container">
	<table class="table">
		<tr class="table-light">
			<th width="5%"><input class="checkbox"type="checkbox"></th>
			<th width="5%"> 이미지 </th>
			<th width="60%"> 제품 정보 </th>
			<th width="20%"> 가격 </th>
			<th width="10%"> 비교 </th>
		</tr>
		<tbody class="wishlist table-group-divider">
			<tr>
				<td><input type="checkbox" class="checkbox" ></td>
				<td> <img src = "/jspweb/product/img/1 (2).jpg" width="100%" ></td>
				<td> 노트북 팝니다. </td>
				<td> 373,555원</td>
				<td> <button> X </button> </td>
			</tr>
			<tr>
				<td><input type="checkbox" class="checkbox"></td>
				<td> <img src = "/jspweb/product/img/1 (2).jpg" ></td>
				<td> 노트북 팝니다. </td>
				<td> 373,555원</td>
				<td> <button> X </button> </td>
			</tr>
			<tr>
				<td><input type="checkbox" class="checkbox"></td>
				<td> <img src = "/jspweb/product/img/1 (2).jpg" ></td>
				<td> 노트북 팝니다. </td>
				<td> 373,555원</td>
				<td> <button > X </button> </td>
			</tr>
			<tr>
				<td><input type="checkbox" class="checkbox"></td>
				<td> <img src = "/jspweb/product/img/1 (2).jpg" ></td>
				<td> 노트북 팝니다. </td>
				<td> 373,555원</td>
				<td> <button> X </button> </td>
			</tr>
		
		
		</tbody>
		
	
	</table>
	<div class="delbtnBox">
		<button type="button" class="btn btn-success"> 선택삭제</button>
		<button type="button" class="btn btn-success"> 전체삭제</button>
	</div>
	
	<div class="buybtnBox">
		<button type="button" class="btn btn-success"> 선택구매</button>
		<button type="button" class="btn btn-success"> 전체구매</button>
	</div>
	</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<script src="../js/product/wishlist.js"></script>
</body>
</html>

	 