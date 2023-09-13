<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품등록페이지</title>
<link href="../css/product.css"  rel="stylesheet">

</head>
<body>
<div class="webcontainer">
<%@include file="../header.jsp" %>
	<h3>제품 등록 페이지</h3>
	<form class="registerForm">
		카테고리 : <select name="cno">
					<option value="1">노트북</option>
					<option value="2">태블릿</option>
					<option value="3">냉장고</option>
				</select> <br/>
		제품명 : <input name="pname" type="text"><br/>
		제품설명 : <textarea name="pconent" ></textarea><br/>
		제품가격 : <input name="pprice" type="number"><br/>
		<!-- 첨부파일 1개일때 -->
		제품사진 : <input name="pimg" type="file" multiple="multiple"/><br/>
		<button onclick="onRegister()" type="button">등록</button>
	</form>
	
</div>

<script src="../js/product/register.js"></script>
</body>
</html>

	
	<!-- 
	
	<div class="webcontainer">
	
		<h3> 제품 등록 페이지 [ form 태그 없는경우 1 ] </h3>
		<div>
			제품명 : <input class="pname1" type="text">   <br> 
			제품설명 : <textarea class="pcontent1" ></textarea> <br>
			<button onclick="register1()" type="button"> 등록1 </button>
		</div>
		
		<h3> 제품 등록 페이지 [ form 태그 이용하는 경우 2 ] </h3>
		<form class="registerForm1">
			제품명 : <input name="pname2" type="text">   <br> 
			제품설명 : <textarea name="pcontent2" ></textarea> <br>
			<button onclick="register2()" type="button"> 등록2 </button>
		</form>
		
		
	</div>
	
	
	
	 -->