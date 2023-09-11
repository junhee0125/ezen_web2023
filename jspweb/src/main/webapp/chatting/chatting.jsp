<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/chatting/chattin.css"  rel="stylesheet">

</head>
<body>
<%@include file="../header.jsp" %>
<div class="webcontainer">
	
	<h2>채팅</h2>
	<div>
		<div class="contentBox">
			
		
		</div>
		<input class="inputContent" type="text">
		<button class= "sendbtn" onclick="mesgsend()" type="button" >전송</button>
	</div>
</div>

<script src="../js/chatting.js"></script>
</body>
</html>