<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 부트 스트랩 CSS적용 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- 써머노트 CSS 적용 -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.css" rel="stylesheet">

</head>
<body>
	<%@include file="../header.jsp" %>
	<div class="container">	
		<input class="form-control my-3 title" type="text" placeholder="제목">
		<textarea id="summernote" class="form-control my-3" rows="10" cols=""></textarea>
		<input class="form-control my-3" type="file"/>
		<div class="row justify-content-md-center my-3">
			<div class="col-2"><input onclick="onWrite()" class="form-control btn btn-dark" type="button" value="등록"></div>  
			<div class="col-2"><input class="form-control btn btn-secondary" type="button" value="다시쓰기"></div>
			<div class="col-2"><input class="form-control btn btn-secondary" type="button" value="목록보기"></div>
		</div>
		
	</div>
	<%@include file="../footer.jsp" %>
<!-- jquery : js라이브러리 -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>

<!-- 부트 스트랩 JS적용 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<!-- 썸머노트 js적용 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/summernote-lite.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.20/lang/summernote-ko-KR.min.js"></script>
<script src="../js/write.js" type="text/javascript"></script>
</body>
</html>