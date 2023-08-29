<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 헤더 -->
<h3> 헤더</h3>
	<div>

		<ul>
			<li><a href="/jspweb/index.jsp">홈으로</a></li>
			<li><a href="/jspweb/member/signup.jsp">회원가입</a></li>
			<li><a href="/jspweb/visitlog/visitlog.jsp">방문록</a></li>
			<li><a href="/jspweb/visitlog/accountbook.jsp">과제1:가계부</a></li>
			<li><a href="/jspweb/library/library.jsp">과제2:도서관열람실</a></li>

		</ul>
	</div>
<!-- 최신 JQuery 불러오려고 왜? ajax쓸라고  왜?  외부로부터 통신하려고-->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</body>
</html>
<!--
	헤더에 넣어두면 좋을
	- 헤더는 많은 페이지에서 참조하는 페이지므로 공통적인 코드를 넣어두며좋음



 -->